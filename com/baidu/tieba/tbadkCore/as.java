package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class as {
    private static volatile as bXm;
    private boolean amh = false;

    public static as agH() {
        if (bXm == null) {
            synchronized (as.class) {
                if (bXm == null) {
                    bXm = new as();
                }
            }
        }
        return bXm;
    }

    public void eA(boolean z) {
        this.amh = z;
        TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", z);
    }

    public boolean agI() {
        return this.amh;
    }
}
