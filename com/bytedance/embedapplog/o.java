package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.util.Locale;
/* loaded from: classes6.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static final CharSequence f5835a = "sony";

    /* renamed from: b  reason: collision with root package name */
    private static final CharSequence f5836b = "amigo";
    private static final CharSequence c = "funtouch";

    public static boolean a() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean b() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains(RomUtils.MANUFACTURER_OPPO);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [237=4] */
    private static java.lang.String a(java.lang.String r6) {
        /*
            java.lang.String r0 = ""
            r2 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3d
            r3.<init>()     // Catch: java.lang.Throwable -> L3d
            java.lang.String r4 = "getprop "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L3d
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch: java.lang.Throwable -> L3d
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L3d
            java.lang.Process r3 = r1.exec(r3)     // Catch: java.lang.Throwable -> L3d
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3d
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3d
            java.io.InputStream r5 = r3.getInputStream()     // Catch: java.lang.Throwable -> L3d
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L3d
            r5 = 1024(0x400, float:1.435E-42)
            r1.<init>(r4, r5)     // Catch: java.lang.Throwable -> L3d
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L55
            r3.destroy()     // Catch: java.lang.Throwable -> L55
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.io.IOException -> L4e
        L3c:
            return r0
        L3d:
            r1 = move-exception
            r1 = r2
        L3f:
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.io.IOException -> L45
            goto L3c
        L45:
            r1 = move-exception
            goto L3c
        L47:
            r0 = move-exception
        L48:
            if (r2 == 0) goto L4d
            r2.close()     // Catch: java.io.IOException -> L50
        L4d:
            throw r0
        L4e:
            r1 = move-exception
            goto L3c
        L50:
            r1 = move-exception
            goto L4d
        L52:
            r0 = move-exception
            r2 = r1
            goto L48
        L55:
            r2 = move-exception
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.o.a(java.lang.String):java.lang.String");
    }

    public static boolean c() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains(RomUtils.MANUFACTURER_MEIZU);
    }

    public static boolean d() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean e() {
        return "samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER);
    }

    private static String i() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static boolean f() {
        String str = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("VIBEUI_V2");
        }
        String a2 = a(RomUtils.PROP_RO_BUILD_VERSION_INCREMENTAL);
        return !TextUtils.isEmpty(a2) && a2.contains("VIBEUI_V2");
    }

    public static boolean g() {
        return i().toUpperCase().contains(RomUtils.ROM_NUBIA);
    }

    public static boolean h() {
        return i().toUpperCase().contains("ASUS");
    }

    public static boolean a(Context context) {
        return i().toUpperCase().contains("HUAWEI");
    }
}
