package com.baidu.tieba.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import java.io.OutputStream;
/* loaded from: classes.dex */
public class af {
    public static final File a = Environment.getExternalStorageDirectory();
    private static final File b = TiebaApplication.g().b().getCacheDir();

    public static boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String b() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals("removed")) {
            return TiebaApplication.g().b().getString(R.string.error_no_sdcard);
        }
        if (externalStorageState.equals("unmounted") || externalStorageState.equals("unmountable")) {
            return TiebaApplication.g().b().getString(R.string.error_sd_unmount);
        }
        if (externalStorageState.equals("shared")) {
            return TiebaApplication.g().b().getString(R.string.error_sd_shared);
        }
        return TiebaApplication.g().b().getString(R.string.error_sd_error);
    }

    public static boolean a(String str) {
        if (a()) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    return file.mkdirs();
                } catch (Exception e) {
                    cb.a(e, "FileHelper.CheckTempDir " + str);
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean c() {
        return a(a + "/" + com.baidu.tieba.data.i.k() + "/");
    }

    public static boolean b(String str) {
        if (a()) {
            try {
                return new File(new StringBuilder().append(a).append("/").append(com.baidu.tieba.data.i.k()).append("/").append(str).toString()).exists();
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("FileHelper", "CheckFile", "error = " + e.getMessage());
                cb.a(e, "FileHelper.CheckFile " + str);
                return false;
            }
        }
        return false;
    }

    public static long a(String str, String str2) {
        if (a()) {
            try {
                if (new File(a + "/" + com.baidu.tieba.data.i.k() + "/" + str + "/" + str2).exists()) {
                    return com.baidu.tieba.data.i.q();
                }
                return -1L;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("FileHelper", "CheckFile", "error = " + e.getMessage());
                cb.a(e, "FileHelper.checkImageFileSize " + str + "/" + str2);
                return -1L;
            }
        }
        return -1L;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        return a + "/" + com.baidu.tieba.data.i.k() + "/" + str;
    }

    public static File d(String str) {
        if (c()) {
            File file = new File(a + "/" + com.baidu.tieba.data.i.k() + "/" + str);
            try {
                if (file.exists()) {
                    return file;
                }
                return null;
            } catch (SecurityException e) {
                com.baidu.adp.lib.util.f.b("FileHelper", "GetFile", "error = " + e.getMessage());
                cb.a(e, "FileHelper.GetFile" + str);
                return null;
            }
        }
        return null;
    }

    public static File e(String str) {
        if (!c()) {
            return null;
        }
        return new File(a + "/" + com.baidu.tieba.data.i.k() + "/" + str);
    }

    public static File f(String str) {
        if (c()) {
            File file = new File(a + "/" + com.baidu.tieba.data.i.k() + "/" + str);
            try {
                if (!file.exists() || file.delete()) {
                    if (file.createNewFile()) {
                        return file;
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("FileHelper", "CreateFile", "error = " + e.getMessage());
                cb.a(e, "FileHelper.CreateFile " + str);
                return null;
            }
        }
        return null;
    }

    public static File g(String str) {
        if (c()) {
            File file = new File(a + "/" + com.baidu.tieba.data.i.k() + "/" + str);
            try {
                if (file.exists()) {
                    return file;
                }
                if (file.createNewFile()) {
                    return file;
                }
                return null;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("FileHelper", "CreateFileIfNotFound", "error = " + e.getMessage());
                cb.a(e, "FileHelper.CreateFileIfNotFound " + str);
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [409=4, 410=4, 412=4, 413=4, 414=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x016c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        ?? sb = new StringBuilder(String.valueOf(str != null ? a + "/" + com.baidu.tieba.data.i.k() + "/" + str + "/" : a + "/" + com.baidu.tieba.data.i.k() + "/"));
        try {
            try {
                fileInputStream = new FileInputStream(new File(sb.append(str2).toString()));
                try {
                    byte[] bArr = new byte[7];
                    z = fileInputStream.read(bArr, 0, 6) == 6 ? BdUtilHelper.a(bArr) : false;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (FileNotFoundException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            cb.a(e2, "FileHelper.isGif " + str + "/" + str2);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                    cb.a(e4, "FileHelper.isGif " + str + "/" + str2);
                                }
                            }
                            return z;
                        } catch (IOException e5) {
                            e = e5;
                            e.printStackTrace();
                            cb.a(e, "FileHelper.isGif " + str + "/" + str2);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                    cb.a(e6, "FileHelper.isGif " + str + "/" + str2);
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
                            e7.printStackTrace();
                            cb.a(e7, "FileHelper.isGif " + str + "/" + str2);
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
                        cb.a(e10, "FileHelper.isGif " + str + "/" + str2);
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
            str3 = a + "/" + com.baidu.tieba.data.i.k() + "/" + str + "/";
        } else {
            str3 = a + "/" + com.baidu.tieba.data.i.k() + "/";
        }
        if (!a(str3) || bitmap == null) {
            return null;
        }
        File file = new File(String.valueOf(str3) + str2);
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
            com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", e.getMessage());
            cb.a(e, "FileHelper.SaveFile1 " + str + "/" + str2);
            return null;
        }
    }

    public static String a(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        if (str != null) {
            str5 = a + "/" + com.baidu.tieba.data.i.k() + "/" + str + "/";
        } else {
            str5 = a + "/" + com.baidu.tieba.data.i.k() + "/";
        }
        if (str3 != null) {
            str6 = a + "/" + com.baidu.tieba.data.i.k() + "/" + str3 + "/";
        } else {
            str6 = a + "/" + com.baidu.tieba.data.i.k() + "/";
        }
        if (a(str5) && a(str6)) {
            File file = new File(String.valueOf(str5) + str2);
            File file2 = new File(String.valueOf(str6) + str4);
            if (!file.renameTo(file2)) {
                cb.a("renameTo err", "FileHelper.renameTo");
                return null;
            }
            return file2.getAbsolutePath();
        }
        return null;
    }

    public static Bitmap c(String str, String str2) {
        String str3;
        if (str != null) {
            str3 = a + "/" + com.baidu.tieba.data.i.k() + "/" + str + "/";
        } else {
            str3 = a + "/" + com.baidu.tieba.data.i.k() + "/";
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = com.baidu.tieba.data.i.m;
            return BitmapFactory.decodeFile(String.valueOf(str3) + str2, options);
        } catch (OutOfMemoryError e) {
            cb.a(e.getMessage(), "FileHelper.getImage " + str + "/" + str2);
            System.gc();
            try {
                return BitmapFactory.decodeFile(String.valueOf(str3) + str2);
            } catch (OutOfMemoryError e2) {
                cb.a(e.getMessage(), "FileHelper.getImage " + str + "/" + str2);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [586=5, 587=5, 589=5, 590=10, 591=5, 592=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:0x0241 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:61:0x0243 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x008f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0201 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v30, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v50, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2, byte[] bArr) {
        String str3;
        FileOutputStream fileOutputStream;
        String str4;
        if (!a(str != null ? a + "/" + com.baidu.tieba.data.i.k() + "/" + str + "/" : a + "/" + com.baidu.tieba.data.i.k() + "/") || bArr == null || str2 == null) {
            return null;
        }
        File file = new File(String.valueOf(str3) + str2);
        String parent = file.getParent();
        boolean a2 = com.baidu.adp.lib.util.m.a(parent);
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
                        com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + th2.getMessage());
                        cb.a(th2.getMessage(), "FileHelper.SaveFile2 " + str + "/" + str2);
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
                    com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + th4.getMessage());
                    cb.a(th4.getMessage(), "FileHelper.SaveFile2 " + str + "/" + str2);
                }
            }
            return null;
        } else if (!file.createNewFile()) {
            if (0 != 0) {
                try {
                    fileOutputStream3.close();
                } catch (Throwable th5) {
                    com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + th5.getMessage());
                    cb.a(th5.getMessage(), "FileHelper.SaveFile2 " + str + "/" + str2);
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
                str4 = file.getPath();
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th6) {
                        com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + th6.getMessage());
                        String str5 = "FileHelper.SaveFile2 " + str + "/" + str2;
                        cb.a(th6.getMessage(), str5);
                        fileOutputStream2 = str5;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + e.getMessage());
                cb.a(e, "FileHelper.SaveFile2 " + str + "/" + str2);
                String str6 = fileOutputStream;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        str6 = fileOutputStream;
                    } catch (Throwable th7) {
                        com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + th7.getMessage());
                        String str7 = "FileHelper.SaveFile2 " + str + "/" + str2;
                        cb.a(th7.getMessage(), str7);
                        str6 = str7;
                    }
                }
                str4 = null;
                fileOutputStream2 = str6;
                return str4;
            }
            return str4;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [646=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x010e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public static String a(String str, String str2, InputStream inputStream) {
        String str3;
        FileOutputStream fileOutputStream;
        if (!a(str != null ? a + "/" + com.baidu.tieba.data.i.k() + "/" + str + "/" : a + "/" + com.baidu.tieba.data.i.k() + "/") || inputStream == null || str2 == null) {
            return null;
        }
        File file = new File(String.valueOf(str3) + str2);
        String parent = file.getParent();
        boolean a2 = com.baidu.adp.lib.util.m.a(parent);
        ?? r2 = a2;
        if (!a2) {
            File file2 = new File(parent);
            boolean exists = file2.exists();
            r2 = file2;
            if (!exists) {
                file2.mkdirs();
                r2 = file2;
            }
        }
        try {
            try {
                if (file.exists() && !file.delete()) {
                    r.a((OutputStream) null);
                    return null;
                } else if (!file.createNewFile()) {
                    r.a((OutputStream) null);
                    return null;
                } else {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                fileOutputStream.flush();
                                String path = file.getPath();
                                r.a((OutputStream) fileOutputStream);
                                return path;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } catch (IOException e) {
                        e = e;
                        com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + e.getMessage());
                        cb.a(e, "FileHelper.saveFile " + str + "/" + str2);
                        r.a((OutputStream) fileOutputStream);
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                r.a((OutputStream) r2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r2 = 0;
            r.a((OutputStream) r2);
            throw th;
        }
    }

    public static byte[] d(String str, String str2) {
        String str3;
        if (!c() || str2 == null) {
            return null;
        }
        if (str != null) {
            str3 = a + "/" + com.baidu.tieba.data.i.k() + "/" + str + "/";
        } else {
            str3 = a + "/" + com.baidu.tieba.data.i.k() + "/";
        }
        File file = new File(String.valueOf(str3) + str2);
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
            com.baidu.adp.lib.util.f.b("FileHelper", "GetFileData", "error = " + e.getMessage());
            cb.a(e, "FileHelper.GetFileData " + str + "/" + str2);
            return null;
        }
    }

    private static String b(String str, boolean z) {
        return (z && str.startsWith(a.toString())) ? str : a + "/" + com.baidu.tieba.data.i.k() + "/" + str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [733=4, 734=4, 736=4, 737=4, 738=4, 741=4, 742=4, 744=4, 745=4, 746=4] */
    public static boolean a(java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            r0 = 0
            r3 = 0
            r1 = 0
            r2 = 0
            java.lang.String r4 = b(r8, r10)
            java.lang.String r5 = b(r9, r10)
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L212
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L212
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L212
            r7.<init>(r5)     // Catch: java.lang.Throwable -> L212
            boolean r4 = r6.exists()     // Catch: java.lang.Throwable -> L212
            if (r4 != 0) goto L81
            if (r3 == 0) goto L21
            r1.close()     // Catch: java.lang.Throwable -> L27
        L21:
            if (r3 == 0) goto L26
            r2.close()     // Catch: java.lang.Throwable -> L54
        L26:
            return r0
        L27:
            r1 = move-exception
            java.lang.String r4 = "FileHelper"
            java.lang.String r5 = "CopyFile"
            java.lang.String r6 = r1.toString()
            com.baidu.adp.lib.util.f.b(r4, r5, r6)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "FileHelper.CopyFile "
            r4.<init>(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r9)
            java.lang.String r4 = r4.toString()
            com.baidu.tieba.util.cb.a(r1, r4)
            goto L21
        L54:
            r1 = move-exception
            java.lang.String r2 = "FileHelper"
            java.lang.String r3 = "CopyFile"
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.util.f.b(r2, r3, r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "FileHelper.CopyFile "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.tieba.util.cb.a(r1, r2)
            goto L26
        L81:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L212
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L212
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L216
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L216
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> Ldd
        L8f:
            int r5 = r4.read(r1)     // Catch: java.lang.Throwable -> Ldd
            if (r5 > 0) goto Ld8
            r4.close()     // Catch: java.lang.Throwable -> Ldd
            r1 = 0
            r2.close()     // Catch: java.lang.Throwable -> L21b
            r2 = 0
            r0 = 1
            if (r3 == 0) goto La3
            r1.close()     // Catch: java.lang.Throwable -> L1d8
        La3:
            if (r3 == 0) goto L26
            r2.close()     // Catch: java.lang.Throwable -> Laa
            goto L26
        Laa:
            r1 = move-exception
            java.lang.String r2 = "FileHelper"
            java.lang.String r3 = "CopyFile"
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.util.f.b(r2, r3, r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "FileHelper.CopyFile "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.tieba.util.cb.a(r1, r2)
            goto L26
        Ld8:
            r6 = 0
            r2.write(r1, r6, r5)     // Catch: java.lang.Throwable -> Ldd
            goto L8f
        Ldd:
            r1 = move-exception
            r3 = r4
        Ldf:
            java.lang.String r4 = "FileHelper"
            java.lang.String r5 = "CopyFile"
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> L20f
            com.baidu.adp.lib.util.f.b(r4, r5, r6)     // Catch: java.lang.Throwable -> L20f
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L20f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L20f
            java.lang.String r5 = "FileHelper.CopyFile "
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L20f
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch: java.lang.Throwable -> L20f
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L20f
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch: java.lang.Throwable -> L20f
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L20f
            com.baidu.tieba.util.cb.a(r1, r4)     // Catch: java.lang.Throwable -> L20f
            if (r3 == 0) goto L10f
            r3.close()     // Catch: java.lang.Throwable -> L144
        L10f:
            if (r2 == 0) goto L26
            r2.close()     // Catch: java.lang.Throwable -> L116
            goto L26
        L116:
            r1 = move-exception
            java.lang.String r2 = "FileHelper"
            java.lang.String r3 = "CopyFile"
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.util.f.b(r2, r3, r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "FileHelper.CopyFile "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.tieba.util.cb.a(r1, r2)
            goto L26
        L144:
            r1 = move-exception
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r5 = r1.toString()
            com.baidu.adp.lib.util.f.b(r3, r4, r5)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "FileHelper.CopyFile "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.baidu.tieba.util.cb.a(r1, r3)
            goto L10f
        L171:
            r0 = move-exception
            r2 = r3
        L173:
            if (r3 == 0) goto L178
            r3.close()     // Catch: java.lang.Throwable -> L17e
        L178:
            if (r2 == 0) goto L17d
            r2.close()     // Catch: java.lang.Throwable -> L1ab
        L17d:
            throw r0
        L17e:
            r1 = move-exception
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r5 = r1.toString()
            com.baidu.adp.lib.util.f.b(r3, r4, r5)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "FileHelper.CopyFile "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.baidu.tieba.util.cb.a(r1, r3)
            goto L178
        L1ab:
            r1 = move-exception
            java.lang.String r2 = "FileHelper"
            java.lang.String r3 = "CopyFile"
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.util.f.b(r2, r3, r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "FileHelper.CopyFile "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.tieba.util.cb.a(r1, r2)
            goto L17d
        L1d8:
            r1 = move-exception
            java.lang.String r4 = "FileHelper"
            java.lang.String r5 = "CopyFile"
            java.lang.String r6 = r1.toString()
            com.baidu.adp.lib.util.f.b(r4, r5, r6)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "FileHelper.CopyFile "
            r4.<init>(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r9)
            java.lang.String r4 = r4.toString()
            com.baidu.tieba.util.cb.a(r1, r4)
            goto La3
        L206:
            r0 = move-exception
            r2 = r3
            r3 = r4
            goto L173
        L20b:
            r0 = move-exception
            r3 = r4
            goto L173
        L20f:
            r0 = move-exception
            goto L173
        L212:
            r1 = move-exception
            r2 = r3
            goto Ldf
        L216:
            r1 = move-exception
            r2 = r3
            r3 = r4
            goto Ldf
        L21b:
            r1 = move-exception
            goto Ldf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.util.af.a(java.lang.String, java.lang.String, boolean):boolean");
    }

    public static boolean e(String str, String str2) {
        return a(str, str2, false);
    }

    public static InputStream h(String str) {
        return a(d(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
        if (r1.exists() == false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InputStream i(String str) {
        File file = null;
        File file2 = new File(str);
        try {
            try {
            } catch (SecurityException e) {
                com.baidu.adp.lib.util.f.b("FileHelper", "GetFile", "error = " + e.getMessage());
                cb.a(e, "FileHelper.GetStreamFromTmpFile " + str);
                return a(file);
            }
        } catch (Throwable th) {
        }
        file = file2;
        return a(file);
    }

    public static InputStream a(File file) {
        if (file != null) {
            try {
                return new FileInputStream(file);
            } catch (Throwable th) {
                com.baidu.adp.lib.util.f.b("FileHelper", "GetStreamFromFile", "error = " + th.getMessage());
                cb.a(th.getMessage(), "FileHelper.GetStreamFromFile");
                return null;
            }
        }
        return null;
    }

    public static boolean j(String str) {
        if (c()) {
            File file = new File(a + "/" + com.baidu.tieba.data.i.k() + "/" + str);
            try {
                if (file.exists()) {
                    return file.delete();
                }
                return false;
            } catch (Throwable th) {
                com.baidu.adp.lib.util.f.b("FileHelper", "DelFile", "error = " + th.getMessage());
                cb.a(th.getMessage(), "FileHelper.DelFile " + str);
                return false;
            }
        }
        return false;
    }

    public static String d() {
        return a + "/" + com.baidu.tieba.data.i.k() + "/";
    }

    public static boolean f(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        String parent = file2.getParent();
        if (!com.baidu.adp.lib.util.m.a(parent)) {
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

    public static String a(int i) {
        switch (i) {
            case 1:
                return SwitchKey.VOICE;
            case 2:
                return "emotion";
            default:
                return "";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [973=4, 974=4, 976=4, 977=8, 978=4, 979=4] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(int i, String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (str == null || bArr == null || bArr.length == 0) {
            return null;
        }
        String a2 = a(i, str, true);
        if (a2 != null) {
            return a2;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            File createTempFile = File.createTempFile(a(i), str, b);
            if (createTempFile == null) {
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th) {
                        com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + th.getMessage());
                        cb.a(th.getMessage(), "FileHelper.SaveFile ");
                    }
                }
                return null;
            }
            fileOutputStream = new FileOutputStream(createTempFile);
            try {
                try {
                    fileOutputStream.write(bArr, 0, bArr.length);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    FileOutputStream fileOutputStream3 = null;
                    String path = createTempFile.getPath();
                    if (0 != 0) {
                        try {
                            fileOutputStream3.close();
                            return path;
                        } catch (Throwable th2) {
                            com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + th2.getMessage());
                            cb.a(th2.getMessage(), "FileHelper.SaveFile ");
                            return path;
                        }
                    }
                    return path;
                } catch (IOException e) {
                    e = e;
                    com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + e.getMessage());
                    cb.a(e, "FileHelper.SaveFile ");
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + th3.getMessage());
                            cb.a(th3.getMessage(), "FileHelper.SaveFile ");
                        }
                    }
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th5) {
                        com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + th5.getMessage());
                        cb.a(th5.getMessage(), "FileHelper.SaveFile ");
                    }
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
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

    public static long k(String str) {
        return b(new File(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long b(File file) {
        FileInputStream fileInputStream;
        long j = 0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                if (!file.exists()) {
                    fileInputStream = null;
                } else {
                    fileInputStream = new FileInputStream(file);
                    try {
                        j = fileInputStream.available();
                    } catch (Exception e) {
                        e = e;
                        cb.a(e, "FileHelper.getFileSize");
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                                cb.a(e2, "FileHelper.getFileSize");
                            }
                        }
                        return j;
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                        cb.a(e3, "FileHelper.getFileSize");
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                        cb.a(e4, "FileHelper.getFileSize");
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        return j;
    }

    public static boolean c(File file) {
        try {
            return file.delete();
        } catch (Exception e) {
            cb.a(e, "FileHelper.deleteFile");
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
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory() && !z) {
                    length = a(listFiles[i], false);
                } else {
                    length = listFiles[i].length();
                }
                j += length;
            }
        }
        return j;
    }

    public static void l(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            cb.a(e, "FileHelper.makeRootDirectory " + str);
        }
    }

    public static long g(String str, String str2) {
        if (a()) {
            try {
                File file = new File(a + "/" + com.baidu.tieba.data.i.k() + "/" + str + "/" + str2);
                if (file.exists()) {
                    return file.length();
                }
                return -1L;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("FileHelper", "CheckFile", "error = " + e.getMessage());
                cb.a(e, "FileHelper.checkFileSize " + str + "/" + str2);
                return -1L;
            }
        }
        return -1L;
    }
}
