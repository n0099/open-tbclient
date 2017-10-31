package com.baidu.tieba.video.localvideo;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.provider.MediaStore;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    public static final String gGN = Environment.getExternalStorageDirectory().toString() + "/.video_pics";

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4, 124=4] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0163  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<d> bZ(Context context) {
        Cursor cursor;
        Cursor cursor2;
        String videoPath;
        File file;
        String string;
        Cursor cursor3 = null;
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = context.getContentResolver();
        try {
            cursor = contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "duration", "mime_type", "date_modified"}, null, null, VrPlayerActivityConfig.TITLE);
            try {
                String[] strArr = {"video_id", "_data"};
                cursor.moveToFirst();
                int count = cursor.getCount();
                for (int i = 0; i < count; i++) {
                    d dVar = new d();
                    String string2 = cursor.getString(cursor.getColumnIndex("_id"));
                    dVar.tr(string2);
                    String string3 = cursor.getString(cursor.getColumnIndex("_data"));
                    if (string3 != null) {
                        dVar.setVideoPath(string3.replace("/storage/emulated/0", "/sdcard"));
                    }
                    dVar.setDuration(com.baidu.adp.lib.g.b.g(cursor.getString(cursor.getColumnIndex("duration")), 0));
                    dVar.setMimeType(cursor.getString(cursor.getColumnIndex("mime_type")));
                    dVar.cM(Long.parseLong(cursor.getString(cursor.getColumnIndex("date_modified"))));
                    try {
                        cursor2 = contentResolver.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, strArr, "video_id=" + string2, null, null);
                        if (cursor2 != null) {
                            try {
                                try {
                                    if (cursor2.moveToFirst() && (string = cursor2.getString(cursor2.getColumnIndex("_data"))) != null) {
                                        dVar.ts(string.replace("/storage/emulated/0", "/sdcard"));
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
                    if (dVar.getVideoPath() != null && dVar.getDuration() != 0 && tx(dVar.getMimeType()) && dVar.getDuration() >= 1000) {
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static int tt(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
                try {
                    return parseInt;
                } catch (Exception e) {
                    return parseInt;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                return 0;
            }
        } finally {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public static d tu(String str) {
        File file = new File(str);
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        d dVar = new d();
        dVar.setVideoPath(str);
        dVar.cM(file.lastModified());
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:0x0114 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x0121 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x005e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.ByteArrayOutputStream] */
    public static d tv(String str) {
        Bitmap bitmap;
        FileOutputStream fileOutputStream;
        Exception e;
        File file = new File(str);
        if (file != null && file.exists() && file.isFile()) {
            d dVar = new d();
            dVar.setVideoPath(str);
            dVar.cM(file.lastModified());
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            File file2 = new File(gGN);
            if (!file2.exists()) {
                file2.mkdir();
            }
            ?? r3 = ".png";
            StringBuilder append = new StringBuilder().append(gGN).append(File.separator).append(tw(str)).append(".png");
            String sb = append.toString();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    bitmap = mediaMetadataRetriever.getFrameAtTime(0L, 1);
                    try {
                        r3 = new ByteArrayOutputStream();
                        try {
                            bitmap.compress(Bitmap.CompressFormat.PNG, 50, r3);
                            fileOutputStream = new FileOutputStream(sb);
                            try {
                                fileOutputStream.write(r3.toByteArray());
                                dVar.ts(sb);
                                dVar.setDuration(Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)));
                                dVar.setMimeType(mediaMetadataRetriever.extractMetadata(12));
                                dVar.setVideoWidth(Integer.parseInt(mediaMetadataRetriever.extractMetadata(18)));
                                dVar.setVideoHeight(Integer.parseInt(mediaMetadataRetriever.extractMetadata(19)));
                                if (r3 != 0) {
                                    try {
                                        r3.close();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                        append = fileOutputStream;
                                        r3 = r3;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (bitmap != 0) {
                                    bitmap.recycle();
                                }
                                mediaMetadataRetriever.release();
                                append = fileOutputStream;
                                r3 = r3;
                            } catch (Exception e3) {
                                e = e3;
                                e.printStackTrace();
                                if (r3 != 0) {
                                    try {
                                        r3.close();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                        append = fileOutputStream;
                                        r3 = r3;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (bitmap != null) {
                                    bitmap.recycle();
                                }
                                mediaMetadataRetriever.release();
                                append = fileOutputStream;
                                r3 = r3;
                                return dVar;
                            }
                        } catch (Exception e5) {
                            fileOutputStream = null;
                            e = e5;
                        } catch (Throwable th) {
                            th = th;
                            append = 0;
                            if (r3 != 0) {
                                try {
                                    r3.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                    throw th;
                                }
                            }
                            if (append != 0) {
                                append.close();
                            }
                            if (bitmap != null) {
                                bitmap.recycle();
                            }
                            mediaMetadataRetriever.release();
                            throw th;
                        }
                    } catch (Exception e7) {
                        r3 = 0;
                        e = e7;
                        fileOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        append = 0;
                        r3 = 0;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e8) {
                r3 = 0;
                bitmap = null;
                fileOutputStream = null;
                e = e8;
            } catch (Throwable th4) {
                th = th4;
                append = 0;
                r3 = 0;
                bitmap = null;
            }
            return dVar;
        }
        return null;
    }

    public static String tw(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                if ((b & 255) < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b & 255));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void d(String str, List<d> list, boolean z) {
        File[] listFiles;
        d tu;
        if (list != null && !StringUtils.isNull(str) && (listFiles = new File(str).listFiles()) != null && listFiles.length != 0) {
            for (File file : listFiles) {
                if (file != null && !StringUtils.isNull(file.getPath())) {
                    String path = file.getPath();
                    if (file.isFile()) {
                        if (path.contains("_tiebaconverting.mp4")) {
                            if (file.exists()) {
                                file.delete();
                            }
                        } else if (path.contains(".mp4") && ".mp4".equals(path.substring(path.lastIndexOf(".mp4"))) && (tu = tu(file.getPath())) != null && file.length() > 102400 && tu.getDuration() >= 1000 && tx(tu.getMimeType())) {
                            list.add(tu);
                        }
                    } else if (file.isDirectory() && !path.contains("/.") && z) {
                        d(path, list, z);
                    }
                }
            }
        }
    }

    public static void dE(List<d> list) {
        Collections.sort(list, new a());
    }

    /* loaded from: classes2.dex */
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

    public static boolean tx(String str) {
        return "video/mp4".equals(str) || "video/ext-mp4".equals(str);
    }
}
