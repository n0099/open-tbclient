package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class ag {
    private static volatile ag cHX;
    private boolean cHW = false;

    public static ag apz() {
        if (cHX == null) {
            synchronized (ag.class) {
                if (cHX == null) {
                    cHX = new ag();
                }
            }
        }
        return cHX;
    }

    public void fx(boolean z) {
        this.cHW = z;
        TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", z);
    }

    public boolean apA() {
        return this.cHW;
    }
}
