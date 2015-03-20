package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class av {
    private static volatile av cnh;
    private boolean cng = false;

    public static av ame() {
        if (cnh == null) {
            synchronized (av.class) {
                if (cnh == null) {
                    cnh = new av();
                }
            }
        }
        return cnh;
    }

    public void eO(boolean z) {
        this.cng = z;
        TbadkSettings.getInst().saveBoolean("has_show_mutiimage_tip", z);
    }

    public boolean amf() {
        return this.cng;
    }
}
