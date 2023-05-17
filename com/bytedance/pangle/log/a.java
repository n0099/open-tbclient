package com.bytedance.pangle.log;
/* loaded from: classes8.dex */
public class a {
    public static volatile a a;

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                a = new a();
            }
        }
        return a;
    }

    public static void b() {
        ZeusLogger.d("Zeus/DefaultReporterImpl", "skip default report");
    }
}
