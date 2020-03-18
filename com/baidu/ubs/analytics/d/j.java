package com.baidu.ubs.analytics.d;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes8.dex */
public final class j {
    private static int bn = 1000;
    private static boolean kYE = true;

    public static void c(boolean z) {
        kYE = z;
    }

    public static void Ls(String str) {
        if (kYE) {
            a(5, "BaiDuAbSDK", str, null);
        }
    }

    public static void b(Throwable th) {
        if (kYE) {
            a(4, "BaiDuAbSDK", "", th);
        }
    }

    public static void Lz(String str) {
        if (kYE) {
            a(2, "BaiDuAbSDK", str, null);
        }
    }

    public static void a(Throwable th) {
        if (kYE) {
            a(2, "BaiDuAbSDK", "", th);
        }
    }

    private static void a(int i, String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.length() >= bn) {
                switch (i) {
                    case 1:
                        Log.v(str, str2.substring(0, bn));
                        break;
                    case 2:
                        Log.d(str, str2.substring(0, bn));
                        break;
                    case 3:
                        Log.i(str, str2.substring(0, bn));
                        break;
                    case 4:
                        Log.w(str, str2.substring(0, bn));
                        break;
                    case 5:
                        Log.e(str, str2.substring(0, bn));
                        break;
                }
            } else {
                switch (i) {
                    case 1:
                        Log.v(str, str2);
                        break;
                    case 2:
                        Log.d(str, str2);
                        break;
                    case 3:
                        Log.i(str, str2);
                        break;
                    case 4:
                        Log.w(str, str2);
                        break;
                    case 5:
                        Log.e(str, str2);
                        break;
                    default:
                        Log.d(str, str2);
                        break;
                }
            }
        }
        if (th != null) {
            String r = r(th);
            if (!TextUtils.isEmpty(r)) {
                switch (i) {
                    case 1:
                        Log.v(str, r);
                        return;
                    case 2:
                        Log.d(str, r);
                        return;
                    case 3:
                        Log.i(str, r);
                        return;
                    case 4:
                        Log.w(str, r);
                        return;
                    case 5:
                        Log.e(str, r);
                        return;
                    default:
                        Log.d(str, str2);
                        return;
                }
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
    private static java.lang.String r(java.lang.Throwable r5) {
        /*
            r3 = 0
            java.lang.String r0 = ""
            java.io.StringWriter r4 = new java.io.StringWriter     // Catch: java.lang.Throwable -> L27
            r4.<init>()     // Catch: java.lang.Throwable -> L27
            java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch: java.lang.Throwable -> L57
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L57
            r5.printStackTrace(r2)     // Catch: java.lang.Throwable -> L5b
            r2.flush()     // Catch: java.lang.Throwable -> L5b
            r4.flush()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L5b
            r4.close()     // Catch: java.lang.Throwable -> L22
        L1e:
            r2.close()
        L21:
            return r0
        L22:
            r1 = move-exception
            r1.printStackTrace()
            goto L1e
        L27:
            r1 = move-exception
            r2 = r3
        L29:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L54
            if (r3 == 0) goto L31
            r3.close()     // Catch: java.lang.Throwable -> L37
        L31:
            if (r2 == 0) goto L21
            r2.close()
            goto L21
        L37:
            r1 = move-exception
            r1.printStackTrace()
            goto L31
        L3c:
            r0 = move-exception
            r2 = r3
            r4 = r3
        L3f:
            if (r4 == 0) goto L44
            r4.close()     // Catch: java.lang.Throwable -> L4a
        L44:
            if (r2 == 0) goto L49
            r2.close()
        L49:
            throw r0
        L4a:
            r1 = move-exception
            r1.printStackTrace()
            goto L44
        L4f:
            r0 = move-exception
            r2 = r3
            goto L3f
        L52:
            r0 = move-exception
            goto L3f
        L54:
            r0 = move-exception
            r4 = r3
            goto L3f
        L57:
            r1 = move-exception
            r2 = r3
            r3 = r4
            goto L29
        L5b:
            r1 = move-exception
            r3 = r4
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ubs.analytics.d.j.r(java.lang.Throwable):java.lang.String");
    }
}
