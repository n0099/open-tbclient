package com.baidu.tieba.yuyinala.liveroom.wheat.e;
/* loaded from: classes11.dex */
public class d {
    public static boolean oEa = false;
    private static c oKw;

    public static void bj(String str, boolean z) {
        if (oEa) {
            if (oKw == null) {
                oKw = new c();
            }
            oKw.report(str);
        }
    }
}
