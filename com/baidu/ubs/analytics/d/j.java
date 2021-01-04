package com.baidu.ubs.analytics.d;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes6.dex */
public final class j {
    private static int oOV = 1000;
    private static boolean oOW = true;

    public static void c(boolean z) {
        oOW = z;
    }

    public static void I(String str) {
        if (oOW) {
            a(5, "BaiDuAbSDK", str, null);
        }
    }

    public static void b(Throwable th) {
        if (oOW) {
            a(4, "BaiDuAbSDK", "", th);
        }
    }

    public static void G(String str) {
        if (oOW) {
            a(2, "BaiDuAbSDK", str, null);
        }
    }

    public static void a(Throwable th) {
        if (oOW) {
            a(2, "BaiDuAbSDK", "", th);
        }
    }

    private static void a(int i, String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.length() >= oOV) {
                switch (i) {
                    case 1:
                        Log.v(str, str2.substring(0, oOV));
                        break;
                    case 2:
                        Log.d(str, str2.substring(0, oOV));
                        break;
                    case 3:
                        Log.i(str, str2.substring(0, oOV));
                        break;
                    case 4:
                        Log.w(str, str2.substring(0, oOV));
                        break;
                    case 5:
                        Log.e(str, str2.substring(0, oOV));
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
            String j = j(th);
            if (!TextUtils.isEmpty(j)) {
                switch (i) {
                    case 1:
                        Log.v(str, j);
                        return;
                    case 2:
                        Log.d(str, j);
                        return;
                    case 3:
                        Log.i(str, j);
                        return;
                    case 4:
                        Log.w(str, j);
                        return;
                    case 5:
                        Log.e(str, j);
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
    private static java.lang.String j(java.lang.Throwable r5) {
        /*
            r3 = 0
            java.lang.String r0 = ""
            java.io.StringWriter r4 = new java.io.StringWriter     // Catch: java.lang.Throwable -> L27
            r4.<init>()     // Catch: java.lang.Throwable -> L27
            java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch: java.lang.Throwable -> L55
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L55
            r5.printStackTrace(r2)     // Catch: java.lang.Throwable -> L58
            r2.flush()     // Catch: java.lang.Throwable -> L58
            r4.flush()     // Catch: java.lang.Throwable -> L58
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L58
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
            r4 = r3
        L2a:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L53
            if (r4 == 0) goto L32
            r4.close()     // Catch: java.lang.Throwable -> L38
        L32:
            if (r2 == 0) goto L21
            r2.close()
            goto L21
        L38:
            r1 = move-exception
            r1.printStackTrace()
            goto L32
        L3d:
            r0 = move-exception
            r2 = r3
            r4 = r3
        L40:
            if (r4 == 0) goto L45
            r4.close()     // Catch: java.lang.Throwable -> L4b
        L45:
            if (r2 == 0) goto L4a
            r2.close()
        L4a:
            throw r0
        L4b:
            r1 = move-exception
            r1.printStackTrace()
            goto L45
        L50:
            r0 = move-exception
            r2 = r3
            goto L40
        L53:
            r0 = move-exception
            goto L40
        L55:
            r1 = move-exception
            r2 = r3
            goto L2a
        L58:
            r1 = move-exception
            goto L2a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ubs.analytics.d.j.j(java.lang.Throwable):java.lang.String");
    }
}
