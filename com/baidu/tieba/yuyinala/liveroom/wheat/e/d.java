package com.baidu.tieba.yuyinala.liveroom.wheat.e;
/* loaded from: classes11.dex */
public class d {
    public static boolean oDA = false;
    private static c oJW;

    public static void bj(String str, boolean z) {
        if (oDA) {
            if (oJW == null) {
                oJW = new c();
            }
            oJW.report(str);
        }
    }
}
