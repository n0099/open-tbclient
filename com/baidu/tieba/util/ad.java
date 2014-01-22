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
import java.io.OutputStream;
/* loaded from: classes.dex */
public class ad {
    public static final File a = Environment.getExternalStorageDirectory();
    private static final File b = TiebaApplication.h().getCacheDir();

    public static boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String b() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals("removed")) {
            return TiebaApplication.h().getString(R.string.error_no_sdcard);
        }
        if (externalStorageState.equals("unmounted") || externalStorageState.equals("unmountable")) {
            return TiebaApplication.h().getString(R.string.error_sd_unmount);
        }
        if (externalStorageState.equals("shared")) {
            return TiebaApplication.h().getString(R.string.error_sd_shared);
        }
        return TiebaApplication.h().getString(R.string.error_sd_error);
    }

    public static boolean a(String str) {
        if (a()) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    return file.mkdirs();
                } catch (Exception e) {
                    by.a(e, "FileHelper.CheckTempDir " + str);
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean c() {
        return a(a + "/tieba/");
    }

    public static boolean b(String str) {
        if (a()) {
            try {
                return new File(new StringBuilder().append(a).append("/").append("tieba").append("/").append(str).toString()).exists();
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b("FileHelper", "CheckFile", "error = " + e.getMessage());
                by.a(e, "FileHelper.CheckFile " + str);
                return false;
            }
        }
        return false;
    }

    public static long a(String str, String str2) {
        if (a()) {
            try {
                if (new File(a + "/tieba/" + str + "/" + str2).exists()) {
                    return com.baidu.tieba.data.h.f();
                }
                return -1L;
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b("FileHelper", "CheckFile", "error = " + e.getMessage());
                by.a(e, "FileHelper.checkImageFileSize " + str + "/" + str2);
                return -1L;
            }
        }
        return -1L;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        return a + "/tieba/" + str;
    }

    public static File d(String str) {
        if (c()) {
            File file = new File(a + "/tieba/" + str);
            try {
                if (file.exists()) {
                    return file;
                }
                return null;
            } catch (SecurityException e) {
                com.baidu.adp.lib.g.e.b("FileHelper", "GetFile", "error = " + e.getMessage());
                by.a(e, "FileHelper.GetFile" + str);
                return null;
            }
        }
        return null;
    }

    public static File e(String str) {
        if (!c()) {
            return null;
        }
        return new File(a + "/tieba/" + str);
    }

    public static File f(String str) {
        if (c()) {
            File file = new File(a + "/tieba/" + str);
            try {
                if (!file.exists() || file.delete()) {
                    if (file.createNewFile()) {
                        return file;
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b("FileHelper", "CreateFile", "error = " + e.getMessage());
                by.a(e, "FileHelper.CreateFile " + str);
                return null;
            }
        }
        return null;
    }

    public static File g(String str) {
        if (c()) {
            File file = new File(a + "/tieba/" + str);
            try {
                if (file.exists()) {
                    return file;
                }
                if (file.createNewFile()) {
                    return file;
                }
                return null;
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b("FileHelper", "CreateFileIfNotFound", "error = " + e.getMessage());
                by.a(e, "FileHelper.CreateFileIfNotFound " + str);
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [409=4, 410=4, 412=4, 413=4, 414=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0179 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        String str3;
        FileInputStream fileInputStream2 = null;
        String str4 = str != null ? a + "/tieba/" + str + "/" : a + "/tieba/";
        ?? sb = new StringBuilder();
        try {
            try {
                fileInputStream = new FileInputStream(new File(sb.append(str4).append(str2).toString()));
                try {
                    byte[] bArr = new byte[7];
                    z = fileInputStream.read(bArr, 0, 6) == 6 ? com.baidu.adp.lib.g.g.a(bArr) : false;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (FileNotFoundException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            by.a(e2, "FileHelper.isGif " + str + "/" + str2);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                    e = e4;
                                    e.printStackTrace();
                                    str3 = "FileHelper.isGif " + str + "/" + str2;
                                    by.a(e, str3);
                                    return z;
                                }
                            }
                            return z;
                        } catch (IOException e5) {
                            e = e5;
                            e.printStackTrace();
                            by.a(e, "FileHelper.isGif " + str + "/" + str2);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e6) {
                                    e = e6;
                                    e.printStackTrace();
                                    str3 = "FileHelper.isGif " + str + "/" + str2;
                                    by.a(e, str3);
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
                            str3 = "FileHelper.isGif " + str + "/" + str2;
                            by.a(e, str3);
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
                        by.a(e10, "FileHelper.isGif " + str + "/" + str2);
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
            str3 = a + "/tieba/" + str + "/";
        } else {
            str3 = a + "/tieba/";
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
            com.baidu.adp.lib.g.e.b("FileHelper", "SaveFile", e.getMessage());
            by.a(e, "FileHelper.SaveFile1 " + str + "/" + str2);
            return null;
        }
    }

    public static String a(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        if (str != null) {
            str5 = a + "/tieba/" + str + "/";
        } else {
            str5 = a + "/tieba/";
        }
        if (str3 != null) {
            str6 = a + "/tieba/" + str3 + "/";
        } else {
            str6 = a + "/tieba/";
        }
        if (a(str5) && a(str6)) {
            File file = new File(str5 + str2);
            File file2 = new File(str6 + str4);
            if (!file.renameTo(file2)) {
                by.a("renameTo err", "FileHelper.renameTo");
                return null;
            }
            return file2.getAbsolutePath();
        }
        return null;
    }

    public static Bitmap c(String str, String str2) {
        String str3;
        if (str != null) {
            str3 = a + "/tieba/" + str + "/";
        } else {
            str3 = a + "/tieba/";
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = com.baidu.tieba.data.h.m;
            return BitmapFactory.decodeFile(str3 + str2, options);
        } catch (OutOfMemoryError e) {
            by.a(e.getMessage(), "FileHelper.getImage " + str + "/" + str2);
            System.gc();
            try {
                return BitmapFactory.decodeFile(str3 + str2);
            } catch (OutOfMemoryError e2) {
                by.a(e.getMessage(), "FileHelper.getImage " + str + "/" + str2);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [586=5, 587=5, 589=5, 590=5, 592=5] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0158 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2, byte[] bArr) {
        FileOutputStream fileOutputStream;
        String str3 = str != null ? a + "/tieba/" + str + "/" : a + "/tieba/";
        if (!a(str3) || bArr == null || str2 == null) {
            return null;
        }
        File file = new File(str3 + str2);
        String parent = file.getParent();
        if (!com.baidu.adp.lib.g.m.a(parent)) {
            File file2 = new File(parent);
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            if (file.exists() && !file.delete()) {
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th) {
                        com.baidu.adp.lib.g.e.b("FileHelper", "SaveFile", "error = " + th.getMessage());
                        by.a(th.getMessage(), "FileHelper.SaveFile2 " + str + "/" + str2);
                    }
                }
                return null;
            } else if (!file.createNewFile()) {
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th2) {
                        com.baidu.adp.lib.g.e.b("FileHelper", "SaveFile", "error = " + th2.getMessage());
                        by.a(th2.getMessage(), "FileHelper.SaveFile2 " + str + "/" + str2);
                    }
                }
                return null;
            } else {
                fileOutputStream = new FileOutputStream(file);
                try {
                    try {
                        fileOutputStream.write(bArr, 0, bArr.length);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        FileOutputStream fileOutputStream3 = null;
                        String path = file.getPath();
                        if (0 != 0) {
                            try {
                                fileOutputStream3.close();
                                return path;
                            } catch (Throwable th3) {
                                com.baidu.adp.lib.g.e.b("FileHelper", "SaveFile", "error = " + th3.getMessage());
                                by.a(th3.getMessage(), "FileHelper.SaveFile2 " + str + "/" + str2);
                                return path;
                            }
                        }
                        return path;
                    } catch (IOException e) {
                        e = e;
                        com.baidu.adp.lib.g.e.b("FileHelper", "SaveFile", "error = " + e.getMessage());
                        by.a(e, "FileHelper.SaveFile2 " + str + "/" + str2);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th4) {
                                com.baidu.adp.lib.g.e.b("FileHelper", "SaveFile", "error = " + th4.getMessage());
                                by.a(th4.getMessage(), "FileHelper.SaveFile2 " + str + "/" + str2);
                            }
                        }
                        return null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th6) {
                            com.baidu.adp.lib.g.e.b("FileHelper", "SaveFile", "error = " + th6.getMessage());
                            by.a(th6.getMessage(), "FileHelper.SaveFile2 " + str + "/" + str2);
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [646=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0112 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public static String a(String str, String str2, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        String str3 = str != null ? a + "/tieba/" + str + "/" : a + "/tieba/";
        if (!a(str3) || inputStream == null || str2 == null) {
            return null;
        }
        File file = new File(str3 + str2);
        String parent = file.getParent();
        boolean a2 = com.baidu.adp.lib.g.m.a(parent);
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
                    p.a((OutputStream) null);
                    return null;
                } else if (!file.createNewFile()) {
                    p.a((OutputStream) null);
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
                                p.a((OutputStream) fileOutputStream);
                                return path;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } catch (IOException e) {
                        e = e;
                        com.baidu.adp.lib.g.e.b("FileHelper", "SaveFile", "error = " + e.getMessage());
                        by.a(e, "FileHelper.saveFile " + str + "/" + str2);
                        p.a((OutputStream) fileOutputStream);
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                p.a((OutputStream) r2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r2 = 0;
            p.a((OutputStream) r2);
            throw th;
        }
    }

    public static byte[] d(String str, String str2) {
        String str3;
        if (!c() || str2 == null) {
            return null;
        }
        if (str != null) {
            str3 = a + "/tieba/" + str + "/";
        } else {
            str3 = a + "/tieba/";
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
            com.baidu.adp.lib.g.e.b("FileHelper", "GetFileData", "error = " + e.getMessage());
            by.a(e, "FileHelper.GetFileData " + str + "/" + str2);
            return null;
        }
    }

    private static String b(String str, boolean z) {
        return (z && str.startsWith(a.toString())) ? str : a + "/tieba/" + str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [732=4, 733=4, 735=4, 736=4, 737=4, 740=4, 741=4, 743=4, 744=4, 745=4] */
    public static boolean a(java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            r7 = 0
            r2 = 0
            r0 = 0
            r1 = 0
            java.lang.String r3 = b(r8, r10)
            java.lang.String r4 = b(r9, r10)
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L230
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L230
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L230
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L230
            boolean r3 = r5.exists()     // Catch: java.lang.Throwable -> L230
            if (r3 != 0) goto L27
            if (r2 == 0) goto L21
            r0.close()     // Catch: java.lang.Throwable -> L191
        L21:
            if (r2 == 0) goto L26
            r1.close()     // Catch: java.lang.Throwable -> L1c3
        L26:
            return r7
        L27:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L230
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L230
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L234
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L234
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L40
        L35:
            int r4 = r3.read(r0)     // Catch: java.lang.Throwable -> L40
            if (r4 <= 0) goto Lae
            r5 = 0
            r1.write(r0, r5, r4)     // Catch: java.lang.Throwable -> L40
            goto L35
        L40:
            r0 = move-exception
            r2 = r3
        L42:
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Throwable -> L22d
            com.baidu.adp.lib.g.e.b(r3, r4, r5)     // Catch: java.lang.Throwable -> L22d
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L22d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L22d
            r3.<init>()     // Catch: java.lang.Throwable -> L22d
            java.lang.String r4 = "FileHelper.CopyFile "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L22d
            java.lang.StringBuilder r3 = r3.append(r8)     // Catch: java.lang.Throwable -> L22d
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L22d
            java.lang.StringBuilder r3 = r3.append(r9)     // Catch: java.lang.Throwable -> L22d
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L22d
            com.baidu.tieba.util.by.a(r0, r3)     // Catch: java.lang.Throwable -> L22d
            if (r2 == 0) goto L76
            r2.close()     // Catch: java.lang.Throwable -> L15f
        L76:
            if (r1 == 0) goto L26
            r1.close()     // Catch: java.lang.Throwable -> L7c
            goto L26
        L7c:
            r0 = move-exception
            java.lang.String r1 = "FileHelper"
            java.lang.String r2 = "CopyFile"
            java.lang.String r3 = r0.toString()
            com.baidu.adp.lib.g.e.b(r1, r2, r3)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "FileHelper.CopyFile "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r2 = " to "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r1 = r1.toString()
        La9:
            com.baidu.tieba.util.by.a(r0, r1)
            goto L26
        Lae:
            r3.close()     // Catch: java.lang.Throwable -> L40
            r0 = 0
            r1.close()     // Catch: java.lang.Throwable -> L239
            r1 = 0
            if (r2 == 0) goto Lbb
            r0.close()     // Catch: java.lang.Throwable -> L1f2
        Lbb:
            if (r2 == 0) goto L26
            r1.close()     // Catch: java.lang.Throwable -> Lc2
            goto L26
        Lc2:
            r0 = move-exception
            java.lang.String r1 = "FileHelper"
            java.lang.String r2 = "CopyFile"
            java.lang.String r3 = r0.toString()
            com.baidu.adp.lib.g.e.b(r1, r2, r3)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "FileHelper.CopyFile "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r2 = " to "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r1 = r1.toString()
            goto La9
        Lf0:
            r0 = move-exception
            r1 = r2
        Lf2:
            if (r2 == 0) goto Lf7
            r2.close()     // Catch: java.lang.Throwable -> Lfd
        Lf7:
            if (r1 == 0) goto Lfc
            r1.close()     // Catch: java.lang.Throwable -> L12e
        Lfc:
            throw r0
        Lfd:
            r2 = move-exception
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r5 = r2.toString()
            com.baidu.adp.lib.g.e.b(r3, r4, r5)
            java.lang.String r2 = r2.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "FileHelper.CopyFile "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.baidu.tieba.util.by.a(r2, r3)
            goto Lf7
        L12e:
            r1 = move-exception
            java.lang.String r2 = "FileHelper"
            java.lang.String r3 = "CopyFile"
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.g.e.b(r2, r3, r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.CopyFile "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.tieba.util.by.a(r1, r2)
            goto Lfc
        L15f:
            r0 = move-exception
            java.lang.String r2 = "FileHelper"
            java.lang.String r3 = "CopyFile"
            java.lang.String r4 = r0.toString()
            com.baidu.adp.lib.g.e.b(r2, r3, r4)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.CopyFile "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.tieba.util.by.a(r0, r2)
            goto L76
        L191:
            r0 = move-exception
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r5 = r0.toString()
            com.baidu.adp.lib.g.e.b(r3, r4, r5)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "FileHelper.CopyFile "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.baidu.tieba.util.by.a(r0, r3)
            goto L21
        L1c3:
            r0 = move-exception
            java.lang.String r1 = "FileHelper"
            java.lang.String r2 = "CopyFile"
            java.lang.String r3 = r0.toString()
            com.baidu.adp.lib.g.e.b(r1, r2, r3)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "FileHelper.CopyFile "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r2 = " to "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r1 = r1.toString()
            goto La9
        L1f2:
            r0 = move-exception
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r5 = r0.toString()
            com.baidu.adp.lib.g.e.b(r3, r4, r5)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "FileHelper.CopyFile "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.baidu.tieba.util.by.a(r0, r3)
            goto Lbb
        L224:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto Lf2
        L229:
            r0 = move-exception
            r2 = r3
            goto Lf2
        L22d:
            r0 = move-exception
            goto Lf2
        L230:
            r0 = move-exception
            r1 = r2
            goto L42
        L234:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L42
        L239:
            r0 = move-exception
            goto L42
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.util.ad.a(java.lang.String, java.lang.String, boolean):boolean");
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
                com.baidu.adp.lib.g.e.b("FileHelper", "GetFile", "error = " + e.getMessage());
                by.a(e, "FileHelper.GetStreamFromTmpFile " + str);
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
                com.baidu.adp.lib.g.e.b("FileHelper", "GetStreamFromFile", "error = " + th.getMessage());
                by.a(th.getMessage(), "FileHelper.GetStreamFromFile");
                return null;
            }
        }
        return null;
    }

    public static boolean j(String str) {
        if (c()) {
            File file = new File(a + "/tieba/" + str);
            try {
                if (file.exists()) {
                    return file.delete();
                }
                return false;
            } catch (Throwable th) {
                com.baidu.adp.lib.g.e.b("FileHelper", "DelFile", "error = " + th.getMessage());
                by.a(th.getMessage(), "FileHelper.DelFile " + str);
                return false;
            }
        }
        return false;
    }

    public static String d() {
        return a + "/tieba/";
    }

    public static boolean f(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        String parent = file2.getParent();
        if (!com.baidu.adp.lib.g.m.a(parent)) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [972=4, 973=4, 975=4, 976=4, 978=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x011a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x011d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:55:0x0016 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
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
                            com.baidu.adp.lib.g.e.b("FileHelper", "SaveFile", "error = " + th2.getMessage());
                            by.a(th2.getMessage(), "FileHelper.SaveFile ");
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
                        com.baidu.adp.lib.g.e.b("FileHelper", "SaveFile", "error = " + th4.getMessage());
                        by.a(th4.getMessage(), "FileHelper.SaveFile ");
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
                        com.baidu.adp.lib.g.e.b("FileHelper", "SaveFile", "error = " + th5.getMessage());
                        by.a(th5.getMessage(), "FileHelper.SaveFile ");
                        fileOutputStream2 = "FileHelper.SaveFile ";
                    }
                }
            } catch (IOException e2) {
                e = e2;
                com.baidu.adp.lib.g.e.b("FileHelper", "SaveFile", "error = " + e.getMessage());
                by.a(e, "FileHelper.SaveFile ");
                FileOutputStream fileOutputStream3 = fileOutputStream;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        fileOutputStream3 = fileOutputStream;
                    } catch (Throwable th6) {
                        com.baidu.adp.lib.g.e.b("FileHelper", "SaveFile", "error = " + th6.getMessage());
                        by.a(th6.getMessage(), "FileHelper.SaveFile ");
                        fileOutputStream3 = "FileHelper.SaveFile ";
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

    /* JADX WARN: Removed duplicated region for block: B:39:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long b(File file) {
        FileInputStream fileInputStream;
        String str;
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
                        by.a(e, "FileHelper.getFileSize");
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                                e = e2;
                                str = "FileHelper.getFileSize";
                                by.a(e, str);
                                return j;
                            }
                        }
                        return j;
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                        e = e3;
                        str = "FileHelper.getFileSize";
                        by.a(e, str);
                        return j;
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                        by.a(e4, "FileHelper.getFileSize");
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
            by.a(e, "FileHelper.deleteFile");
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
            by.a(e, "FileHelper.makeRootDirectory " + str);
        }
    }

    public static long g(String str, String str2) {
        if (a()) {
            try {
                File file = new File(a + "/tieba/" + str + "/" + str2);
                if (file.exists()) {
                    return file.length();
                }
                return -1L;
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b("FileHelper", "CheckFile", "error = " + e.getMessage());
                by.a(e, "FileHelper.checkFileSize " + str + "/" + str2);
                return -1L;
            }
        }
        return -1L;
    }
}
