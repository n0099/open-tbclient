package com.baidu.tieba.yuyinala.liveroom.wheat.e;
/* loaded from: classes10.dex */
public class d {
    private static c oAn;
    public static boolean otP = false;

    public static void bj(String str, boolean z) {
        if (otP) {
            if (oAn == null) {
                oAn = new c();
            }
            oAn.report(str);
        }
    }
}
