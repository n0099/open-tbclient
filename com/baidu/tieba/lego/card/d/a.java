package com.baidu.tieba.lego.card.d;

import android.graphics.Color;
/* loaded from: classes.dex */
public class a {
    public static int bR(String str) {
        if (str == null || str.length() == 0) {
            return Integer.MAX_VALUE;
        }
        try {
            if (!str.startsWith("#")) {
                str = "#" + str;
            }
            return Color.parseColor(str);
        } catch (Exception e) {
            return Integer.MAX_VALUE;
        }
    }

    public static boolean ve(int i) {
        if (i == Integer.MAX_VALUE) {
            return true;
        }
        return false;
    }
}
