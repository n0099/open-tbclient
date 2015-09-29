package com.baidu.tieba.write.c;
/* loaded from: classes.dex */
public class a {
    private static long lastClickTime = 0;

    public static long f(CharSequence charSequence) {
        double d = 0.0d;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (charAt > ' ') {
                if (charAt > 0 && charAt < 127) {
                    d += 0.5d;
                } else {
                    d += 1.0d;
                }
            }
        }
        return Math.round(d);
    }

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - lastClickTime;
        if (0 < j && j < 1000) {
            return true;
        }
        lastClickTime = currentTimeMillis;
        return false;
    }
}
