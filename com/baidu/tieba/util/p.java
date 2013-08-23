package com.baidu.tieba.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public static final File f1806a = Environment.getExternalStorageDirectory();

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
                    return file.mkdir();
                } catch (Exception e) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean c() {
        return a(f1806a + "/tieba/");
    }

    public static boolean b(String str) {
        if (a()) {
            try {
                return new File(new StringBuilder().append(f1806a).append("/").append("tieba").append("/").append(str).toString()).exists();
            } catch (Exception e) {
                aq.b("FileHelper", "CheckFile", "error = " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static long a(String str, String str2) {
        if (a()) {
            try {
                if (new File(f1806a + "/tieba/" + str + "/" + str2).exists()) {
                    return com.baidu.tieba.data.g.f();
                }
                return -1L;
            } catch (Exception e) {
                aq.b("FileHelper", "CheckFile", "error = " + e.getMessage());
                return -1L;
            }
        }
        return -1L;
    }

    public static File c(String str) {
        if (c()) {
            File file = new File(f1806a + "/tieba/" + str);
            try {
                if (file.exists()) {
                    return file;
                }
                return null;
            } catch (SecurityException e) {
                aq.b("FileHelper", "GetFile", "error = " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File d(String str) {
        if (!c()) {
            return null;
        }
        return new File(f1806a + "/tieba/" + str);
    }

    public static File e(String str) {
        if (c()) {
            File file = new File(f1806a + "/tieba/" + str);
            try {
                if (!file.exists() || file.delete()) {
                    if (file.createNewFile()) {
                        return file;
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                aq.b("FileHelper", "CreateFile", "error = " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File f(String str) {
        if (c()) {
            File file = new File(f1806a + "/tieba/" + str);
            try {
                if (file.exists()) {
                    return file;
                }
                if (file.createNewFile()) {
                    return file;
                }
                return null;
            } catch (Exception e) {
                aq.b("FileHelper", "CreateFile", "error = " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [338=4, 339=4, 341=4, 342=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00bd */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        ?? sb = new StringBuilder(String.valueOf(str != null ? f1806a + "/tieba/" + str + "/" : f1806a + "/tieba/"));
        try {
            try {
                fileInputStream = new FileInputStream(new File(sb.append(str2).toString()));
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
                                    e4.printStackTrace();
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
                                    e6.printStackTrace();
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
            str3 = f1806a + "/tieba/" + str + "/";
        } else {
            str3 = f1806a + "/tieba/";
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
            aq.b("FileHelper", "SaveFile", e.getMessage());
            return null;
        }
    }

    public static Bitmap c(String str, String str2) {
        String str3;
        if (str != null) {
            str3 = f1806a + "/tieba/" + str + "/";
        } else {
            str3 = f1806a + "/tieba/";
        }
        try {
            return BitmapFactory.decodeFile(String.valueOf(str3) + str2);
        } catch (OutOfMemoryError e) {
            System.gc();
            try {
                return BitmapFactory.decodeFile(String.valueOf(str3) + str2);
            } catch (OutOfMemoryError e2) {
                return null;
            }
        }
    }

    public static String a(String str, byte[] bArr) {
        return a(null, str, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [450=4, 451=4, 453=4, 454=4] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2, byte[] bArr) {
        String str3;
        FileOutputStream fileOutputStream;
        if (!a(str != null ? f1806a + "/tieba/" + str + "/" : f1806a + "/tieba/") || bArr == null || str2 == null) {
            return null;
        }
        File file = new File(String.valueOf(str3) + str2);
        FileOutputStream fileOutputStream2 = null;
        try {
            if ((file.exists() && !file.delete()) || !file.createNewFile()) {
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th) {
                        aq.b("FileHelper", "SaveFile", "error = " + th.getMessage());
                    }
                }
                return null;
            }
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
                        } catch (Throwable th2) {
                            aq.b("FileHelper", "SaveFile", "error = " + th2.getMessage());
                            return path;
                        }
                    }
                    return path;
                } catch (IOException e) {
                    e = e;
                    aq.b("FileHelper", "SaveFile", "error = " + e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            aq.b("FileHelper", "SaveFile", "error = " + th3.getMessage());
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
                        aq.b("FileHelper", "SaveFile", "error = " + th5.getMessage());
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

    public static byte[] d(String str, String str2) {
        String str3;
        if (!c() || str2 == null) {
            return null;
        }
        if (str != null) {
            str3 = f1806a + "/tieba/" + str + "/";
        } else {
            str3 = f1806a + "/tieba/";
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
            aq.b("FileHelper", "GetFileData", "error = " + e.getMessage());
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [517=4, 518=4, 520=4, 521=4, 524=4, 525=4, 527=4, 528=4] */
    public static boolean e(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = 0
            r2 = 0
            r0 = 0
            r1 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.io.File r4 = com.baidu.tieba.util.p.f1806a
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = "/"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = "tieba"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = "/"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.io.File r5 = com.baidu.tieba.util.p.f1806a
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = "/"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = "tieba"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = "/"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r9)
            java.lang.String r4 = r4.toString()
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L12b
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L12b
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L12b
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L12b
            boolean r3 = r5.exists()     // Catch: java.lang.Throwable -> L12b
            if (r3 != 0) goto L83
            if (r2 == 0) goto L63
            r0.close()     // Catch: java.lang.Throwable -> L69
        L63:
            if (r2 == 0) goto L68
            r1.close()     // Catch: java.lang.Throwable -> L76
        L68:
            return r7
        L69:
            r0 = move-exception
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r0 = r0.toString()
            com.baidu.tieba.util.aq.b(r3, r4, r0)
            goto L63
        L76:
            r0 = move-exception
            java.lang.String r1 = "FileHelper"
            java.lang.String r2 = "CopyFile"
            java.lang.String r0 = r0.toString()
            com.baidu.tieba.util.aq.b(r1, r2, r0)
            goto L68
        L83:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L12b
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L12b
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L12e
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L12e
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> Lbc
        L91:
            int r4 = r3.read(r0)     // Catch: java.lang.Throwable -> Lbc
            if (r4 > 0) goto Lb7
            r3.close()     // Catch: java.lang.Throwable -> Lbc
            r0 = 0
            r1.close()     // Catch: java.lang.Throwable -> L132
            r1 = 0
            if (r2 == 0) goto La4
            r0.close()     // Catch: java.lang.Throwable -> L115
        La4:
            if (r2 == 0) goto L68
            r1.close()     // Catch: java.lang.Throwable -> Laa
            goto L68
        Laa:
            r0 = move-exception
            java.lang.String r1 = "FileHelper"
            java.lang.String r2 = "CopyFile"
            java.lang.String r0 = r0.toString()
            com.baidu.tieba.util.aq.b(r1, r2, r0)
            goto L68
        Lb7:
            r5 = 0
            r1.write(r0, r5, r4)     // Catch: java.lang.Throwable -> Lbc
            goto L91
        Lbc:
            r0 = move-exception
            r2 = r3
        Lbe:
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L129
            com.baidu.tieba.util.aq.b(r3, r4, r0)     // Catch: java.lang.Throwable -> L129
            if (r2 == 0) goto Lce
            r2.close()     // Catch: java.lang.Throwable -> Le1
        Lce:
            if (r1 == 0) goto L68
            r1.close()     // Catch: java.lang.Throwable -> Ld4
            goto L68
        Ld4:
            r0 = move-exception
            java.lang.String r1 = "FileHelper"
            java.lang.String r2 = "CopyFile"
            java.lang.String r0 = r0.toString()
            com.baidu.tieba.util.aq.b(r1, r2, r0)
            goto L68
        Le1:
            r0 = move-exception
            java.lang.String r2 = "FileHelper"
            java.lang.String r3 = "CopyFile"
            java.lang.String r0 = r0.toString()
            com.baidu.tieba.util.aq.b(r2, r3, r0)
            goto Lce
        Lee:
            r0 = move-exception
            r1 = r2
        Lf0:
            if (r2 == 0) goto Lf5
            r2.close()     // Catch: java.lang.Throwable -> Lfb
        Lf5:
            if (r1 == 0) goto Lfa
            r1.close()     // Catch: java.lang.Throwable -> L108
        Lfa:
            throw r0
        Lfb:
            r2 = move-exception
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r2 = r2.toString()
            com.baidu.tieba.util.aq.b(r3, r4, r2)
            goto Lf5
        L108:
            r1 = move-exception
            java.lang.String r2 = "FileHelper"
            java.lang.String r3 = "CopyFile"
            java.lang.String r1 = r1.toString()
            com.baidu.tieba.util.aq.b(r2, r3, r1)
            goto Lfa
        L115:
            r0 = move-exception
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r0 = r0.toString()
            com.baidu.tieba.util.aq.b(r3, r4, r0)
            goto La4
        L122:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto Lf0
        L126:
            r0 = move-exception
            r2 = r3
            goto Lf0
        L129:
            r0 = move-exception
            goto Lf0
        L12b:
            r0 = move-exception
            r1 = r2
            goto Lbe
        L12e:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto Lbe
        L132:
            r0 = move-exception
            goto Lbe
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.util.p.e(java.lang.String, java.lang.String):boolean");
    }

    public static InputStream g(String str) {
        return a(c(str));
    }

    public static InputStream a(File file) {
        if (file != null) {
            try {
                return new FileInputStream(file);
            } catch (Throwable th) {
                aq.b("FileHelper", "GetStreamFromFile", "error = " + th.getMessage());
                return null;
            }
        }
        return null;
    }

    public static boolean h(String str) {
        if (c()) {
            File file = new File(f1806a + "/tieba/" + str);
            try {
                if (file.exists()) {
                    return file.delete();
                }
                return false;
            } catch (Throwable th) {
                aq.b("FileHelper", "DelFile", "error = " + th.getMessage());
                return false;
            }
        }
        return false;
    }
}
