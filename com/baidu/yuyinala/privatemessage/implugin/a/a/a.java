package com.baidu.yuyinala.privatemessage.implugin.a.a;
/* loaded from: classes4.dex */
public class a {
    public static int c(float f, int i) {
        if (i >= 0 && i < 10) {
            return (int) ((1.0f + (i / 10.0f)) * f);
        }
        if (i >= 10 && i < 20) {
            return (int) (2.0f * f);
        }
        if (i >= 20 && i < 30) {
            return (int) (f * 2.5d);
        }
        if (i >= 30 && i < 40) {
            return (int) (3.0f * f);
        }
        if (i >= 40 && i < 50) {
            return (int) (f * 3.5d);
        }
        if (i >= 10 && i <= 60) {
            return (int) (f * 4.0f);
        }
        return (int) (f * 4.0f);
    }
}
