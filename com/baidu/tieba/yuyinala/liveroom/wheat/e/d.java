package com.baidu.tieba.yuyinala.liveroom.wheat.e;
/* loaded from: classes11.dex */
public class d {
    private static c oES;
    public static boolean oyv = false;

    public static void bj(String str, boolean z) {
        if (oyv) {
            if (oES == null) {
                oES = new c();
            }
            oES.report(str);
        }
    }
}
