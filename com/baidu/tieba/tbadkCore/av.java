package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class av {
    private static volatile av cnx;
    private boolean cnw = false;

    public static av amt() {
        if (cnx == null) {
            synchronized (av.class) {
                if (cnx == null) {
                    cnx = new av();
                }
            }
        }
        return cnx;
    }

    public void eM(boolean z) {
        this.cnw = z;
        TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", z);
    }

    public boolean amu() {
        return this.cnw;
    }
}
