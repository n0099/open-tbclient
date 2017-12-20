package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class v extends bd {
    public static final BdUniqueId gAV = BdUniqueId.gen();
    private bf gAW;
    private bi gAX;
    private boolean gAY = false;

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gAV;
    }

    public boolean bwm() {
        return this.gAY;
    }

    public bf bwn() {
        return this.gAW;
    }

    public bi bwo() {
        return this.gAX;
    }
}
