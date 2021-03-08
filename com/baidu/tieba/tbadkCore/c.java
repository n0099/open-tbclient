package com.baidu.tieba.tbadkCore;

import android.graphics.Color;
/* loaded from: classes.dex */
public class c {
    public static int l(int i, float f) {
        return (((int) ((i >>> 24) * f)) << 24) | (16777215 & i);
    }

    public static int Jx(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        if ((fArr[0] >= 0.0f && fArr[0] < 60.0f) || ((fArr[0] >= 120.0f && fArr[0] < 180.0f) || fArr[0] >= 240.0f || fArr[0] < 300.0f)) {
            fArr[0] = fArr[0] - 15.0f;
        } else {
            fArr[0] = fArr[0] + 15.0f;
        }
        return Color.HSVToColor(fArr);
    }

    public static int rT(String str) {
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
}
