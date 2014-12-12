package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class as {
    private static volatile as bVv;
    private boolean alq = false;

    public static as agh() {
        if (bVv == null) {
            synchronized (as.class) {
                if (bVv == null) {
                    bVv = new as();
                }
            }
        }
        return bVv;
    }

    public void et(boolean z) {
        this.alq = z;
        TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", z);
    }

    public boolean agi() {
        return this.alq;
    }
}
