package com.baidu.tieba.lego.card.c;

import android.graphics.Color;
/* loaded from: classes.dex */
public class b {
    public static int rM(String str) {
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

    public static boolean DT(int i) {
        if (i == Integer.MAX_VALUE) {
            return true;
        }
        return false;
    }
}
