package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class ah {
    private static volatile ah cQx;
    private boolean cQw = false;

    public static ah atM() {
        if (cQx == null) {
            synchronized (ah.class) {
                if (cQx == null) {
                    cQx = new ah();
                }
            }
        }
        return cQx;
    }

    public void gi(boolean z) {
        this.cQw = z;
        TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", z);
    }

    public boolean atN() {
        return this.cQw;
    }
}
