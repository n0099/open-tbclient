package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class as {
    private static volatile as bXn;
    private boolean amk = false;

    public static as agM() {
        if (bXn == null) {
            synchronized (as.class) {
                if (bXn == null) {
                    bXn = new as();
                }
            }
        }
        return bXn;
    }

    public void eA(boolean z) {
        this.amk = z;
        TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", z);
    }

    public boolean agN() {
        return this.amk;
    }
}
