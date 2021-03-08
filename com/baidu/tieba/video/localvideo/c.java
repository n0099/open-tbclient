package com.baidu.tieba.video.localvideo;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.provider.MediaStore;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.down.statistic.ConfigSpeedStat;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [89=4, 116=4] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0163  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<b> ha(Context context) {
        Cursor cursor;
        Cursor cursor2;
        String videoPath;
        File file;
        String string;
        Cursor cursor3 = null;
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = context.getContentResolver();
        try {
            cursor = contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{IMConstants.MSG_ROW_ID, "_data", "duration", "mime_type", "date_modified"}, null, null, "title");
            try {
                String[] strArr = {"video_id", "_data"};
                cursor.moveToFirst();
                int count = cursor.getCount();
                for (int i = 0; i < count; i++) {
                    b bVar = new b();
                    String string2 = cursor.getString(cursor.getColumnIndex(IMConstants.MSG_ROW_ID));
                    bVar.setVideoId(string2);
                    String string3 = cursor.getString(cursor.getColumnIndex("_data"));
                    if (string3 != null) {
                        bVar.setVideoPath(string3.replace("/storage/emulated/0", "/sdcard"));
                    }
                    bVar.setDuration(com.baidu.adp.lib.f.b.toInt(cursor.getString(cursor.getColumnIndex("duration")), 0));
                    bVar.setMimeType(cursor.getString(cursor.getColumnIndex("mime_type")));
                    bVar.cv(Long.parseLong(cursor.getString(cursor.getColumnIndex("date_modified"))));
                    try {
                        cursor2 = contentResolver.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, strArr, "video_id=" + string2, null, null);
                        if (cursor2 != null) {
                            try {
                                try {
                                    if (cursor2.moveToFirst() && (string = cursor2.getString(cursor2.getColumnIndex("_data"))) != null) {
                                        bVar.UK(string.replace("/storage/emulated/0", "/sdcard"));
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                cursor.moveToNext();
                                if (bVar.getVideoPath() != null) {
                                    videoPath = bVar.getVideoPath();
                                    String substring = videoPath.substring(0, videoPath.lastIndexOf("/"));
                                    if (!videoPath.contains("/DCIM/")) {
                                        arrayList.add(bVar);
                                    }
                                }
                            }
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = null;
                    }
                    cursor.moveToNext();
                    if (bVar.getVideoPath() != null && bVar.getDuration() != 0 && UM(bVar.getMimeType()) && bVar.getDuration() >= 1000) {
                        videoPath = bVar.getVideoPath();
                        String substring2 = videoPath.substring(0, videoPath.lastIndexOf("/"));
                        if (!videoPath.contains("/DCIM/") && ((substring2 == null || !substring2.equals("/sdcard")) && (file = new File(videoPath)) != null && file.exists())) {
                            arrayList.add(bVar);
                        }
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e3) {
                e = e3;
                cursor3 = cursor;
                try {
                    e.printStackTrace();
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
                    cursor = cursor3;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
        } catch (Throwable th5) {
            th = th5;
            cursor = null;
        }
        return arrayList;
    }

    public static b UL(String str) {
        File file = new File(str);
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        b bVar = new b();
        bVar.setVideoPath(str);
        bVar.cv(file.lastModified());
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                if (extractMetadata != null) {
                    bVar.setDuration(Integer.parseInt(extractMetadata));
                }
                bVar.setMimeType(mediaMetadataRetriever.extractMetadata(12));
                try {
                    mediaMetadataRetriever.release();
                    return bVar;
                } catch (Exception e) {
                    e.printStackTrace();
                    return bVar;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    mediaMetadataRetriever.release();
                    return bVar;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return bVar;
                }
            }
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    public static void f(String str, List<b> list, boolean z) {
        File[] listFiles;
        b UL;
        if (list != null && !StringUtils.isNull(str) && (listFiles = new File(str).listFiles()) != null && listFiles.length != 0) {
            for (File file : listFiles) {
                if (file != null && !StringUtils.isNull(file.getPath())) {
                    String path = file.getPath();
                    if (file.isFile()) {
                        if (path.contains("_tiebaconverting.mp4")) {
                            if (file.exists()) {
                                file.delete();
                            }
                        } else if (path.contains(".mp4") && ".mp4".equals(path.substring(path.lastIndexOf(".mp4"))) && (UL = UL(file.getPath())) != null && file.length() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT && UL.getDuration() >= 1000 && UM(UL.getMimeType())) {
                            list.add(UL);
                        }
                    } else if (file.isDirectory() && !path.contains("/.") && z) {
                        f(path, list, z);
                    }
                }
            }
        }
    }

    public static void ga(List<b> list) {
        Collections.sort(list, new a());
    }

    /* loaded from: classes7.dex */
    public static final class a implements Comparator<b> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            int i = 0;
            if (bVar.getLastModified() < bVar2.getLastModified()) {
                i = 1;
            }
            if (bVar.getLastModified() > bVar2.getLastModified()) {
                return -1;
            }
            return i;
        }
    }

    public static boolean UM(String str) {
        return "video/mp4".equals(str) || "video/ext-mp4".equals(str);
    }
}
