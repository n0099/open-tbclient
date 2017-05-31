package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class u extends bl {
    public static final BdUniqueId fAU = BdUniqueId.gen();
    private boolean fAV;
    private o fAW;
    private String fortune_desc;

    public boolean bhu() {
        return this.fAV;
    }

    public String bhv() {
        return this.fortune_desc;
    }

    public o bhw() {
        return this.fAW;
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fAU;
    }
}
