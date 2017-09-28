package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class t extends bh {
    public static final BdUniqueId gfQ = BdUniqueId.gen();
    private bi gfR;
    private bl gfS;
    private boolean gfT = false;

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gfQ;
    }

    public boolean bqO() {
        return this.gfT;
    }

    public bi bqP() {
        return this.gfR;
    }

    public bl bqQ() {
        return this.gfS;
    }
}
