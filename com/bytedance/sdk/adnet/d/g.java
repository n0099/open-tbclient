package com.bytedance.sdk.adnet.d;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static String f6354a = null;

    public static boolean a(Context context) {
        String c = c(context);
        return c != null && (c.endsWith(":push") || c.endsWith(":pushservice"));
    }

    public static boolean b(Context context) {
        String c = c(context);
        return (c == null || !c.contains(":")) && c != null && c.equals(context.getPackageName());
    }

    public static String c(Context context) {
        String str = f6354a;
        if (TextUtils.isEmpty(str)) {
            try {
                int myPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        f6354a = runningAppProcessInfo.processName;
                        return f6354a;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            f6354a = a();
            return f6354a;
        }
        return str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [80=4] */
    private static java.lang.String a() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L66
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L66
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L66
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66
            r4.<init>()     // Catch: java.lang.Throwable -> L66
            java.lang.String r5 = "/proc/"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L66
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L66
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L66
            java.lang.String r5 = "/cmdline"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L66
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L66
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L66
            java.lang.String r4 = "iso-8859-1"
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L66
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L66
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42
            r2.<init>()     // Catch: java.lang.Throwable -> L42
        L37:
            int r3 = r1.read()     // Catch: java.lang.Throwable -> L42
            if (r3 <= 0) goto L49
            char r3 = (char) r3     // Catch: java.lang.Throwable -> L42
            r2.append(r3)     // Catch: java.lang.Throwable -> L42
            goto L37
        L42:
            r2 = move-exception
        L43:
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.lang.Exception -> L5e
        L48:
            return r0
        L49:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.lang.Exception -> L53
            goto L48
        L53:
            r1 = move-exception
            goto L48
        L55:
            r1 = move-exception
            r2 = r1
            r3 = r0
        L58:
            if (r3 == 0) goto L5d
            r3.close()     // Catch: java.lang.Exception -> L60
        L5d:
            throw r2
        L5e:
            r1 = move-exception
            goto L48
        L60:
            r0 = move-exception
            goto L5d
        L62:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L58
        L66:
            r1 = move-exception
            r1 = r0
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.d.g.a():java.lang.String");
    }
}
