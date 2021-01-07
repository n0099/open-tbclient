package com.baidu.tieba.yuyinala.liveroom.wheat.e;
/* loaded from: classes11.dex */
public class d {
    private static c oER;
    public static boolean oyu = false;

    public static void bj(String str, boolean z) {
        if (oyu) {
            if (oER == null) {
                oER = new c();
            }
            oER.report(str);
        }
    }
}
