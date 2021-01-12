package com.baidu.tieba.yuyinala.liveroom.wheat.e;
/* loaded from: classes10.dex */
public class d {
    private static c oAm;
    public static boolean otO = false;

    public static void bj(String str, boolean z) {
        if (otO) {
            if (oAm == null) {
                oAm = new c();
            }
            oAm.report(str);
        }
    }
}
