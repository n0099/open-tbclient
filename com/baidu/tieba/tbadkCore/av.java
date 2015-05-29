package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class av {
    private static volatile av crv;
    private boolean cru = false;

    public static av aof() {
        if (crv == null) {
            synchronized (av.class) {
                if (crv == null) {
                    crv = new av();
                }
            }
        }
        return crv;
    }

    public void ff(boolean z) {
        this.cru = z;
        TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", z);
    }

    public boolean aog() {
        return this.cru;
    }
}
