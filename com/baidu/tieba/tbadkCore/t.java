package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class t extends bh {
    public static final BdUniqueId gfP = BdUniqueId.gen();
    private bi gfQ;
    private bl gfR;
    private boolean gfS = false;

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gfP;
    }

    public boolean bqN() {
        return this.gfS;
    }

    public bi bqO() {
        return this.gfQ;
    }

    public bl bqP() {
        return this.gfR;
    }
}
