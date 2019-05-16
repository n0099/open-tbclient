package com.baidu.tieba.tbadkCore.util;
/* loaded from: classes.dex */
public class e {
    private static boolean jbs = false;

    public static void cnr() {
        jbs = true;
    }

    public static void cns() {
        jbs = false;
    }

    public static boolean cnt() {
        return jbs;
    }
}
