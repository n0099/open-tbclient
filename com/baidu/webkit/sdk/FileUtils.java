package com.baidu.webkit.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FilenameFilter;
/* loaded from: classes11.dex */
class FileUtils {
    static final String TAG = "FileUtils";
    private static String sFileRwErrorDetail;

    static {
        try {
            System.loadLibrary("zeuslzma");
        } catch (Throwable th) {
            Log.e(TAG, "failed to load lzma library: " + th);
        }
        sFileRwErrorDetail = "none";
    }

    FileUtils() {
    }

    public static String checkTimestamp(Context context, String str, String str2) {
        if (str == null) {
            return str2;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo != null ? checkTimestamp(str, str2, packageInfo.versionCode + Constants.ACCEPT_TIME_SEPARATOR_SERVER + packageInfo.lastUpdateTime) : str2;
        } catch (PackageManager.NameNotFoundException e) {
            return str2;
        } catch (Exception e2) {
            return str2;
        }
    }

    public static String checkTimestamp(String str, final String str2, String str3) {
        String str4 = str2 + str3;
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list(new FilenameFilter() { // from class: com.baidu.webkit.sdk.FileUtils.1
                @Override // java.io.FilenameFilter
                public final boolean accept(File file2, String str5) {
                    return str5.startsWith(str2);
                }
            });
            if (list == null) {
                return str4;
            }
            for (int i = 0; i < list.length; i++) {
                if (str4.equals(list[i])) {
                    return null;
                }
                new File(file, list[i]).delete();
            }
            return str4;
        }
        return str4;
    }

    public static void clearTimestamp(Context context, String str, final String str2) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            for (String str3 : file.list(new FilenameFilter() { // from class: com.baidu.webkit.sdk.FileUtils.2
                @Override // java.io.FilenameFilter
                public final boolean accept(File file2, String str4) {
                    return str4.startsWith(str2);
                }
            })) {
                new File(file, str3).delete();
            }
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
    public static boolean copyFile(java.lang.String r7, java.lang.String r8) {
        /*
            r2 = 0
            r1 = 0
            r0 = 1
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r3]
            if (r7 == 0) goto Lb
            if (r8 != 0) goto L2a
        Lb:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "copy file fail, from = "
            r0.<init>(r2)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r2 = ", to = "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r0 = r0.toString()
            setFileRwErrorDetail(r0)
        L29:
            return r1
        L2a:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L7c
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L7c
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L7c
            r4.<init>(r8)     // Catch: java.lang.Throwable -> L7c
            boolean r6 = r3.exists()     // Catch: java.lang.Throwable -> L7c
            if (r6 == 0) goto L46
            boolean r6 = r3.isDirectory()     // Catch: java.lang.Throwable -> L7c
            if (r6 != 0) goto L46
            boolean r6 = r4.isDirectory()     // Catch: java.lang.Throwable -> L7c
            if (r6 == 0) goto L92
        L46:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            java.lang.String r5 = "copy file fail, fileFrom.exists = "
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L7c
            boolean r5 = r3.exists()     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r5 = ", fileFrom.isDirectory = "
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch: java.lang.Throwable -> L7c
            boolean r3 = r3.isDirectory()     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r3 = ", fileTo.isDirectory = "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L7c
            boolean r3 = r4.isDirectory()     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L7c
            setFileRwErrorDetail(r0)     // Catch: java.lang.Throwable -> L7c
            goto L29
        L7c:
            r0 = move-exception
            r3 = r2
        L7e:
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L102
            setFileRwErrorDetail(r0)     // Catch: java.lang.Throwable -> L102
            if (r3 == 0) goto L8a
            r3.close()     // Catch: java.lang.Throwable -> Lf7
        L8a:
            if (r2 == 0) goto L109
            r2.close()     // Catch: java.lang.Throwable -> Lf2
            r0 = r1
        L90:
            r1 = r0
            goto L29
        L92:
            boolean r3 = r4.exists()     // Catch: java.lang.Throwable -> L7c
            if (r3 != 0) goto Ld0
            java.io.File r3 = r4.getParentFile()     // Catch: java.lang.Throwable -> L7c
            if (r3 == 0) goto Ld0
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> L7c
            if (r4 != 0) goto Ld0
            boolean r4 = r3.mkdirs()     // Catch: java.lang.Throwable -> L7c
            if (r4 != 0) goto Ld0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            java.lang.String r4 = "cannot mkdirs, path = "
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L7c
            setFileRwErrorDetail(r0)     // Catch: java.lang.Throwable -> L7c
            goto L29
        Lc3:
            r0 = move-exception
            r4 = r2
        Lc5:
            if (r4 == 0) goto Lca
            r4.close()     // Catch: java.lang.Throwable -> Lf9
        Lca:
            if (r2 == 0) goto Lcf
            r2.close()     // Catch: java.lang.Throwable -> Lfb
        Lcf:
            throw r0
        Ld0:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L7c
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L7c
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L105
            r3.<init>(r8)     // Catch: java.lang.Throwable -> L105
        Lda:
            int r2 = r4.read(r5)     // Catch: java.lang.Throwable -> Le5
            if (r2 <= 0) goto Le9
            r6 = 0
            r3.write(r5, r6, r2)     // Catch: java.lang.Throwable -> Le5
            goto Lda
        Le5:
            r0 = move-exception
            r2 = r3
            r3 = r4
            goto L7e
        Le9:
            r4.close()     // Catch: java.lang.Throwable -> Lf5
        Lec:
            r3.close()     // Catch: java.lang.Throwable -> Lf0
            goto L90
        Lf0:
            r1 = move-exception
            goto L90
        Lf2:
            r0 = move-exception
            r0 = r1
            goto L90
        Lf5:
            r1 = move-exception
            goto Lec
        Lf7:
            r0 = move-exception
            goto L8a
        Lf9:
            r1 = move-exception
            goto Lca
        Lfb:
            r1 = move-exception
            goto Lcf
        Lfd:
            r0 = move-exception
            goto Lc5
        Lff:
            r0 = move-exception
            r2 = r3
            goto Lc5
        L102:
            r0 = move-exception
            r4 = r3
            goto Lc5
        L105:
            r0 = move-exception
            r3 = r4
            goto L7e
        L109:
            r0 = r1
            goto L90
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.webkit.sdk.FileUtils.copyFile(java.lang.String, java.lang.String):boolean");
    }

    public static boolean deleteDir(File file, File file2) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!deleteDir(new File(file, str), file2)) {
                    return false;
                }
            }
        }
        if (file != file2) {
            return file.delete();
        }
        return true;
    }

    public static String getFileRwErrorDetailAndReset() {
        String str = sFileRwErrorDetail;
        sFileRwErrorDetail = "none";
        return str == null ? "none" : str;
    }

    public static boolean link(String str, String str2) {
        File file = new File(str2);
        if (file.isDirectory() || str2 == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        return (parentFile == null || parentFile.exists() || parentFile.mkdirs()) && nativeSymlink(str, str2) == 0;
    }

    private static native int nativeSymlink(String str, String str2);

    private static void setFileRwErrorDetail(String str) {
        sFileRwErrorDetail = str;
    }
}
