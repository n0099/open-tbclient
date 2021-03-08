package com.baidu.tieba.yuyinala.liveroom.wheat.e;
/* loaded from: classes10.dex */
public class d {
    public static boolean oGf = false;
    private static c oMB;

    public static void bj(String str, boolean z) {
        if (oGf) {
            if (oMB == null) {
                oMB = new c();
            }
            oMB.report(str);
        }
    }
}
