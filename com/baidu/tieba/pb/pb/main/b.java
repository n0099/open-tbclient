package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
public class b {
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastClickTime < 500) {
            return true;
        }
        lastClickTime = currentTimeMillis;
        return false;
    }
}
