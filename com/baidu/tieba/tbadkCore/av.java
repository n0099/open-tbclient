package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class av {
    private static volatile av crw;
    private boolean crv = false;

    public static av aog() {
        if (crw == null) {
            synchronized (av.class) {
                if (crw == null) {
                    crw = new av();
                }
            }
        }
        return crw;
    }

    public void ff(boolean z) {
        this.crv = z;
        TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", z);
    }

    public boolean aoh() {
        return this.crv;
    }
}
