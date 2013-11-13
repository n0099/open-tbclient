package com.baidu.tieba.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.switchs.SwitchKey;
import com.slidingmenu.lib.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    public static final File f2480a = Environment.getExternalStorageDirectory();
    private static final File b = TiebaApplication.g().getCacheDir();

    public static boolean a() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static String b() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals(Environment.MEDIA_REMOVED)) {
            return TiebaApplication.g().getString(R.string.error_no_sdcard);
        }
        if (externalStorageState.equals(Environment.MEDIA_UNMOUNTED) || externalStorageState.equals(Environment.MEDIA_UNMOUNTABLE)) {
            return TiebaApplication.g().getString(R.string.error_sd_unmount);
        }
        if (externalStorageState.equals(Environment.MEDIA_SHARED)) {
            return TiebaApplication.g().getString(R.string.error_sd_shared);
        }
        return TiebaApplication.g().getString(R.string.error_sd_error);
    }

    public static boolean a(String str) {
        if (a()) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    return file.mkdirs();
                } catch (Exception e) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean c() {
        return a(f2480a + "/tieba/");
    }

    public static boolean b(String str) {
        if (a()) {
            try {
                return new File(new StringBuilder().append(f2480a).append("/").append("tieba").append("/").append(str).toString()).exists();
            } catch (Exception e) {
                bg.b("FileHelper", "CheckFile", "error = " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static long a(String str, String str2) {
        if (a()) {
            try {
                if (new File(f2480a + "/tieba/" + str + "/" + str2).exists()) {
                    return com.baidu.tieba.data.h.f();
                }
                return -1L;
            } catch (Exception e) {
                bg.b("FileHelper", "CheckFile", "error = " + e.getMessage());
                return -1L;
            }
        }
        return -1L;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        return f2480a + "/tieba/" + str;
    }

    public static File d(String str) {
        if (c()) {
            File file = new File(f2480a + "/tieba/" + str);
            try {
                if (file.exists()) {
                    return file;
                }
                return null;
            } catch (SecurityException e) {
                bg.b("FileHelper", "GetFile", "error = " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File e(String str) {
        if (!c()) {
            return null;
        }
        return new File(f2480a + "/tieba/" + str);
    }

    public static File f(String str) {
        if (c()) {
            File file = new File(f2480a + "/tieba/" + str);
            try {
                if (!file.exists() || file.delete()) {
                    if (file.createNewFile()) {
                        return file;
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                bg.b("FileHelper", "CreateFile", "error = " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File g(String str) {
        if (c()) {
            File file = new File(f2480a + "/tieba/" + str);
            try {
                if (file.exists()) {
                    return file;
                }
                if (file.createNewFile()) {
                    return file;
                }
                return null;
            } catch (Exception e) {
                bg.b("FileHelper", "CreateFile", "error = " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [391=4, 392=4, 394=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00b7 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(String str, String str2) {
        FileInputStream fileInputStream;
        IOException e;
        boolean z;
        FileNotFoundException e2;
        FileInputStream fileInputStream2 = null;
        String str3 = str != null ? f2480a + "/tieba/" + str + "/" : f2480a + "/tieba/";
        ?? sb = new StringBuilder();
        try {
            try {
                fileInputStream = new FileInputStream(new File(sb.append(str3).append(str2).toString()));
                try {
                    byte[] bArr = new byte[7];
                    z = fileInputStream.read(bArr, 0, 6) == 6 ? UtilHelper.a(bArr) : false;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (FileNotFoundException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                    e = e4;
                                    e.printStackTrace();
                                    return z;
                                }
                            }
                            return z;
                        } catch (IOException e5) {
                            e = e5;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e6) {
                                    e = e6;
                                    e.printStackTrace();
                                    return z;
                                }
                            }
                            return z;
                        }
                    } else {
                        fileInputStream2 = fileInputStream;
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e7) {
                            e = e7;
                            e.printStackTrace();
                            return z;
                        }
                    }
                } catch (FileNotFoundException e8) {
                    e2 = e8;
                    z = false;
                } catch (IOException e9) {
                    e = e9;
                    z = false;
                }
            } catch (Throwable th) {
                th = th;
                if (sb != 0) {
                    try {
                        sb.close();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e11) {
            fileInputStream = null;
            e2 = e11;
            z = false;
        } catch (IOException e12) {
            fileInputStream = null;
            e = e12;
            z = false;
        } catch (Throwable th2) {
            th = th2;
            sb = 0;
            if (sb != 0) {
            }
            throw th;
        }
        return z;
    }

    public static String a(String str, String str2, Bitmap bitmap, int i) {
        String str3;
        if (bitmap == null) {
            return null;
        }
        if (str != null) {
            str3 = f2480a + "/tieba/" + str + "/";
        } else {
            str3 = f2480a + "/tieba/";
        }
        if (!a(str3) || bitmap == null) {
            return null;
        }
        File file = new File(str3 + str2);
        try {
            if ((!file.exists() || file.delete()) && file.createNewFile()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getPath();
            }
            return null;
        } catch (Exception e) {
            bg.b("FileHelper", "SaveFile", e.getMessage());
            return null;
        }
    }

    public static String a(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        if (str != null) {
            str5 = f2480a + "/tieba/" + str + "/";
        } else {
            str5 = f2480a + "/tieba/";
        }
        if (str3 != null) {
            str6 = f2480a + "/tieba/" + str3 + "/";
        } else {
            str6 = f2480a + "/tieba/";
        }
        if (a(str5) && a(str6)) {
            File file = new File(str5 + str2);
            File file2 = new File(str6 + str4);
            if (file.renameTo(file2)) {
                return file2.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    public static Bitmap c(String str, String str2) {
        String str3;
        if (str != null) {
            str3 = f2480a + "/tieba/" + str + "/";
        } else {
            str3 = f2480a + "/tieba/";
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = com.baidu.tieba.data.h.n;
            return BitmapFactory.decodeFile(str3 + str2, options);
        } catch (OutOfMemoryError e) {
            System.gc();
            try {
                return BitmapFactory.decodeFile(str3 + str2);
            } catch (OutOfMemoryError e2) {
                return null;
            }
        }
    }

    public static String a(String str, byte[] bArr) {
        return a((String) null, str, bArr);
    }

    public static String a(String str, byte[] bArr, int i) {
        return a() ? a((String) null, a(str, i, false), bArr) : a(i, str, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [563=5, 564=5, 566=5, 567=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:0x019a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:61:0x019d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x008b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0114 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v25, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2, byte[] bArr) {
        FileOutputStream fileOutputStream;
        String str3;
        String str4 = str != null ? f2480a + "/tieba/" + str + "/" : f2480a + "/tieba/";
        if (!a(str4) || bArr == null || str2 == null) {
            return null;
        }
        File file = new File(str4 + str2);
        String parent = file.getParent();
        boolean a2 = com.baidu.adp.lib.h.h.a(parent);
        FileOutputStream fileOutputStream2 = a2;
        if (!a2) {
            ?? file2 = new File(parent);
            boolean exists = file2.exists();
            fileOutputStream2 = file2;
            if (!exists) {
                file2.mkdirs();
                fileOutputStream2 = file2;
            }
        }
        FileOutputStream fileOutputStream3 = null;
        try {
            try {
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream2 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th2) {
                        bg.b("FileHelper", "SaveFile", "error = " + th2.getMessage());
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = 0;
            if (fileOutputStream2 != 0) {
            }
            throw th;
        }
        if (file.exists() && !file.delete()) {
            if (0 != 0) {
                try {
                    fileOutputStream3.close();
                } catch (Throwable th4) {
                    bg.b("FileHelper", "SaveFile", "error = " + th4.getMessage());
                }
            }
            return null;
        } else if (!file.createNewFile()) {
            if (0 != 0) {
                try {
                    fileOutputStream3.close();
                } catch (Throwable th5) {
                    bg.b("FileHelper", "SaveFile", "error = " + th5.getMessage());
                }
            }
            return null;
        } else {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                fileOutputStream.flush();
                fileOutputStream.close();
                fileOutputStream2 = 0;
                fileOutputStream2 = 0;
                str3 = file.getPath();
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th6) {
                        bg.b("FileHelper", "SaveFile", "error = " + th6.getMessage());
                        fileOutputStream2 = "FileHelper";
                    }
                }
            } catch (IOException e2) {
                e = e2;
                bg.b("FileHelper", "SaveFile", "error = " + e.getMessage());
                FileOutputStream fileOutputStream4 = fileOutputStream;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        fileOutputStream4 = fileOutputStream;
                    } catch (Throwable th7) {
                        bg.b("FileHelper", "SaveFile", "error = " + th7.getMessage());
                        fileOutputStream4 = "FileHelper";
                    }
                }
                str3 = null;
                fileOutputStream2 = fileOutputStream4;
                return str3;
            }
            return str3;
        }
    }

    public static byte[] d(String str, String str2) {
        String str3;
        if (!c() || str2 == null) {
            return null;
        }
        if (str != null) {
            str3 = f2480a + "/tieba/" + str + "/";
        } else {
            str3 = f2480a + "/tieba/";
        }
        File file = new File(str3 + str2);
        try {
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return byteArrayOutputStream.toByteArray();
            }
            return null;
        } catch (IOException e) {
            bg.b("FileHelper", "GetFileData", "error = " + e.getMessage());
            return null;
        }
    }

    private static String b(String str, boolean z) {
        return (z && str.startsWith(f2480a.toString())) ? str : f2480a + "/tieba/" + str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [652=4, 653=4, 655=4, 656=4, 659=4, 660=4, 662=4, 663=4] */
    public static boolean a(java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            r7 = 0
            r2 = 0
            r0 = 0
            r1 = 0
            java.lang.String r3 = b(r8, r10)
            java.lang.String r4 = b(r9, r10)
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> Le4
            r5.<init>(r3)     // Catch: java.lang.Throwable -> Le4
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> Le4
            r6.<init>(r4)     // Catch: java.lang.Throwable -> Le4
            boolean r3 = r5.exists()     // Catch: java.lang.Throwable -> Le4
            if (r3 != 0) goto L27
            if (r2 == 0) goto L21
            r0.close()     // Catch: java.lang.Throwable -> Lb6
        L21:
            if (r2 == 0) goto L26
            r1.close()     // Catch: java.lang.Throwable -> Lc4
        L26:
            return r7
        L27:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Le4
            r3.<init>(r5)     // Catch: java.lang.Throwable -> Le4
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Le8
            r1.<init>(r6)     // Catch: java.lang.Throwable -> Le8
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L40
        L35:
            int r4 = r3.read(r0)     // Catch: java.lang.Throwable -> L40
            if (r4 <= 0) goto L65
            r5 = 0
            r1.write(r0, r5, r4)     // Catch: java.lang.Throwable -> L40
            goto L35
        L40:
            r0 = move-exception
            r2 = r3
        L42:
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Le2
            com.baidu.tieba.util.bg.b(r3, r4, r0)     // Catch: java.lang.Throwable -> Le2
            if (r2 == 0) goto L52
            r2.close()     // Catch: java.lang.Throwable -> La9
        L52:
            if (r1 == 0) goto L26
            r1.close()     // Catch: java.lang.Throwable -> L58
            goto L26
        L58:
            r0 = move-exception
            java.lang.String r1 = "FileHelper"
            java.lang.String r2 = "CopyFile"
            java.lang.String r0 = r0.toString()
        L61:
            com.baidu.tieba.util.bg.b(r1, r2, r0)
            goto L26
        L65:
            r3.close()     // Catch: java.lang.Throwable -> L40
            r0 = 0
            r1.close()     // Catch: java.lang.Throwable -> Led
            r1 = 0
            if (r2 == 0) goto L72
            r0.close()     // Catch: java.lang.Throwable -> Lce
        L72:
            if (r2 == 0) goto L26
            r1.close()     // Catch: java.lang.Throwable -> L78
            goto L26
        L78:
            r0 = move-exception
            java.lang.String r1 = "FileHelper"
            java.lang.String r2 = "CopyFile"
            java.lang.String r0 = r0.toString()
            goto L61
        L82:
            r0 = move-exception
            r1 = r2
        L84:
            if (r2 == 0) goto L89
            r2.close()     // Catch: java.lang.Throwable -> L8f
        L89:
            if (r1 == 0) goto L8e
            r1.close()     // Catch: java.lang.Throwable -> L9c
        L8e:
            throw r0
        L8f:
            r2 = move-exception
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r2 = r2.toString()
            com.baidu.tieba.util.bg.b(r3, r4, r2)
            goto L89
        L9c:
            r1 = move-exception
            java.lang.String r2 = "FileHelper"
            java.lang.String r3 = "CopyFile"
            java.lang.String r1 = r1.toString()
            com.baidu.tieba.util.bg.b(r2, r3, r1)
            goto L8e
        La9:
            r0 = move-exception
            java.lang.String r2 = "FileHelper"
            java.lang.String r3 = "CopyFile"
            java.lang.String r0 = r0.toString()
            com.baidu.tieba.util.bg.b(r2, r3, r0)
            goto L52
        Lb6:
            r0 = move-exception
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r0 = r0.toString()
            com.baidu.tieba.util.bg.b(r3, r4, r0)
            goto L21
        Lc4:
            r0 = move-exception
            java.lang.String r1 = "FileHelper"
            java.lang.String r2 = "CopyFile"
            java.lang.String r0 = r0.toString()
            goto L61
        Lce:
            r0 = move-exception
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r0 = r0.toString()
            com.baidu.tieba.util.bg.b(r3, r4, r0)
            goto L72
        Ldb:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L84
        Ldf:
            r0 = move-exception
            r2 = r3
            goto L84
        Le2:
            r0 = move-exception
            goto L84
        Le4:
            r0 = move-exception
            r1 = r2
            goto L42
        Le8:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L42
        Led:
            r0 = move-exception
            goto L42
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.util.af.a(java.lang.String, java.lang.String, boolean):boolean");
    }

    public static boolean e(String str, String str2) {
        return a(str, str2, false);
    }

    public static InputStream h(String str) {
        return a(d(str));
    }

    public static InputStream i(String str) {
        File file = new File(str);
        try {
            try {
                return a(file.exists() ? file : null);
            } catch (SecurityException e) {
                bg.b("FileHelper", "GetFile", "error = " + e.getMessage());
                return a((File) null);
            }
        } catch (Throwable th) {
            return a(file);
        }
    }

    public static InputStream a(File file) {
        if (file != null) {
            try {
                return new FileInputStream(file);
            } catch (Throwable th) {
                bg.b("FileHelper", "GetStreamFromFile", "error = " + th.getMessage());
                return null;
            }
        }
        return null;
    }

    public static boolean j(String str) {
        if (c()) {
            File file = new File(f2480a + "/tieba/" + str);
            try {
                if (file.exists()) {
                    return file.delete();
                }
                return false;
            } catch (Throwable th) {
                bg.b("FileHelper", "DelFile", "error = " + th.getMessage());
                return false;
            }
        }
        return false;
    }

    public static String d() {
        return f2480a + "/tieba/";
    }

    public static boolean f(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        String parent = file2.getParent();
        if (!com.baidu.adp.lib.h.h.a(parent)) {
            File file3 = new File(parent);
            if (!file3.exists()) {
                file3.mkdirs();
            }
        }
        if (file.exists()) {
            return file.renameTo(file2);
        }
        return false;
    }

    public static long e() {
        String absolutePath;
        if (a()) {
            absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            absolutePath = Environment.getRootDirectory().getAbsolutePath();
        }
        if (absolutePath == null) {
            return 0L;
        }
        StatFs statFs = new StatFs(absolutePath);
        return statFs.getBlockSize() * statFs.getAvailableBlocks();
    }

    public static String a(int i, String str) {
        return a(i, str, false);
    }

    private static String a(int i, String str, boolean z) {
        if (b == null) {
            return null;
        }
        File[] listFiles = b.listFiles();
        String a2 = a(i);
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (listFiles[i2] != null && listFiles[i2].getName().startsWith(a2)) {
                if (listFiles[i2].getName().endsWith(str)) {
                    return listFiles[i2].getAbsolutePath();
                }
                if (z) {
                    listFiles[i2].delete();
                }
            }
        }
        return null;
    }

    private static String a(int i) {
        switch (i) {
            case 1:
                return SwitchKey.VOICE;
            default:
                return "";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [884=4, 885=4, 887=4, 888=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x00f0 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x00f2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0016 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(int i, String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        String str2;
        File createTempFile;
        if (str == null || bArr == null || bArr.length == 0) {
            return null;
        }
        String a2 = a(i, str, true);
        if (a2 == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    createTempFile = File.createTempFile(a(i), str, b);
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th2) {
                            bg.b("FileHelper", "SaveFile", "error = " + th2.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (IOException e) {
                e = e;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = null;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
            if (createTempFile == null) {
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th4) {
                        bg.b("FileHelper", "SaveFile", "error = " + th4.getMessage());
                    }
                }
                return null;
            }
            fileOutputStream = new FileOutputStream(createTempFile);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                fileOutputStream.flush();
                fileOutputStream.close();
                fileOutputStream2 = null;
                fileOutputStream2 = null;
                str2 = createTempFile.getPath();
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th5) {
                        bg.b("FileHelper", "SaveFile", "error = " + th5.getMessage());
                        fileOutputStream2 = "FileHelper";
                    }
                }
            } catch (IOException e2) {
                e = e2;
                bg.b("FileHelper", "SaveFile", "error = " + e.getMessage());
                FileOutputStream fileOutputStream3 = fileOutputStream;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        fileOutputStream3 = fileOutputStream;
                    } catch (Throwable th6) {
                        bg.b("FileHelper", "SaveFile", "error = " + th6.getMessage());
                        fileOutputStream3 = "FileHelper";
                    }
                }
                str2 = null;
                fileOutputStream2 = fileOutputStream3;
                return str2;
            }
            return str2;
        }
        return a2;
    }

    public static String a(String str, int i) {
        if (str == null) {
            return null;
        }
        if (a()) {
            if (b(a(str, i, false))) {
                return a(str, i, true);
            }
            return null;
        }
        return a(1, str);
    }

    public static String a(String str, int i, boolean z) {
        if (!a()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append(d());
        }
        sb.append(a(i));
        sb.append(File.separator);
        sb.append(str);
        return sb.toString();
    }

    public static long b(File file) {
        try {
            if (file.exists()) {
                return new FileInputStream(file).available();
            }
            return 0L;
        } catch (Exception e) {
            return 0L;
        }
    }

    public static boolean c(File file) {
        try {
            return file.delete();
        } catch (Exception e) {
            return false;
        }
    }

    public static long a(String str, boolean z) {
        return a(new File(str), z);
    }

    public static long a(File file, boolean z) {
        long length;
        long j = 0;
        File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isDirectory() && !z) {
                length = a(listFiles[i], false);
            } else {
                length = listFiles[i].length();
            }
            j += length;
        }
        return j;
    }

    public static void k(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
        }
    }
}
