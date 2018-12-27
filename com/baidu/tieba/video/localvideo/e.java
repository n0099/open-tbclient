package com.baidu.tieba.video.localvideo;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.provider.MediaStore;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.video.VideoConvertUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes5.dex */
public class e {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [89=4, 116=4] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0163  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<d> de(Context context) {
        Cursor cursor;
        Cursor cursor2;
        String videoPath;
        File file;
        String string;
        Cursor cursor3 = null;
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = context.getContentResolver();
        try {
            cursor = contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "duration", "mime_type", "date_modified"}, null, null, "title");
            try {
                String[] strArr = {"video_id", "_data"};
                cursor.moveToFirst();
                int count = cursor.getCount();
                for (int i = 0; i < count; i++) {
                    d dVar = new d();
                    String string2 = cursor.getString(cursor.getColumnIndex("_id"));
                    dVar.setVideoId(string2);
                    String string3 = cursor.getString(cursor.getColumnIndex("_data"));
                    if (string3 != null) {
                        dVar.setVideoPath(string3.replace("/storage/emulated/0", "/sdcard"));
                    }
                    dVar.setDuration(com.baidu.adp.lib.g.b.l(cursor.getString(cursor.getColumnIndex("duration")), 0));
                    dVar.setMimeType(cursor.getString(cursor.getColumnIndex("mime_type")));
                    dVar.dq(Long.parseLong(cursor.getString(cursor.getColumnIndex("date_modified"))));
                    try {
                        cursor2 = contentResolver.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, strArr, "video_id=" + string2, null, null);
                        if (cursor2 != null) {
                            try {
                                try {
                                    if (cursor2.moveToFirst() && (string = cursor2.getString(cursor2.getColumnIndex("_data"))) != null) {
                                        dVar.wS(string.replace("/storage/emulated/0", "/sdcard"));
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
                                if (dVar.getVideoPath() != null) {
                                    videoPath = dVar.getVideoPath();
                                    String substring = videoPath.substring(0, videoPath.lastIndexOf("/"));
                                    if (!videoPath.contains("/DCIM/")) {
                                        arrayList.add(dVar);
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
                    if (dVar.getVideoPath() != null && dVar.getDuration() != 0 && wV(dVar.getMimeType()) && dVar.getDuration() >= 1000) {
                        videoPath = dVar.getVideoPath();
                        String substring2 = videoPath.substring(0, videoPath.lastIndexOf("/"));
                        if (!videoPath.contains("/DCIM/") && ((substring2 == null || !substring2.equals("/sdcard")) && (file = new File(videoPath)) != null && file.exists())) {
                            arrayList.add(dVar);
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

    public static int wB(String str) {
        return VideoConvertUtil.wB(str);
    }

    public static d wT(String str) {
        File file = new File(str);
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        d dVar = new d();
        dVar.setVideoPath(str);
        dVar.dq(file.lastModified());
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                if (extractMetadata != null) {
                    dVar.setDuration(Integer.parseInt(extractMetadata));
                }
                dVar.setMimeType(mediaMetadataRetriever.extractMetadata(12));
                try {
                    mediaMetadataRetriever.release();
                    return dVar;
                } catch (Exception e) {
                    e.printStackTrace();
                    return dVar;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    mediaMetadataRetriever.release();
                    return dVar;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return dVar;
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static d wU(String str) {
        File file = new File(str);
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        d dVar = new d();
        dVar.setVideoPath(str);
        dVar.dq(file.lastModified());
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                dVar.setDuration(Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)));
                dVar.setMimeType(mediaMetadataRetriever.extractMetadata(12));
                dVar.setVideoWidth(Integer.parseInt(mediaMetadataRetriever.extractMetadata(18)));
                dVar.setVideoHeight(Integer.parseInt(mediaMetadataRetriever.extractMetadata(19)));
            } finally {
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return dVar;
    }

    public static String wA(String str) {
        return VideoConvertUtil.wA(str);
    }

    public static void c(String str, List<d> list, boolean z) {
        File[] listFiles;
        d wT;
        if (list != null && !StringUtils.isNull(str) && (listFiles = new File(str).listFiles()) != null && listFiles.length != 0) {
            for (File file : listFiles) {
                if (file != null && !StringUtils.isNull(file.getPath())) {
                    String path = file.getPath();
                    if (file.isFile()) {
                        if (path.contains("_tiebaconverting.mp4")) {
                            if (file.exists()) {
                                file.delete();
                            }
                        } else if (path.contains(".mp4") && ".mp4".equals(path.substring(path.lastIndexOf(".mp4"))) && (wT = wT(file.getPath())) != null && file.length() > 102400 && wT.getDuration() >= 1000 && wV(wT.getMimeType())) {
                            list.add(wT);
                        }
                    } else if (file.isDirectory() && !path.contains("/.") && z) {
                        c(path, list, z);
                    }
                }
            }
        }
    }

    public static void ec(List<d> list) {
        Collections.sort(list, new a());
    }

    /* loaded from: classes5.dex */
    public static final class a implements Comparator<d> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            int i = 0;
            if (dVar.getLastModified() < dVar2.getLastModified()) {
                i = 1;
            }
            if (dVar.getLastModified() > dVar2.getLastModified()) {
                return -1;
            }
            return i;
        }
    }

    public static boolean wV(String str) {
        return "video/mp4".equals(str) || "video/ext-mp4".equals(str);
    }
}
