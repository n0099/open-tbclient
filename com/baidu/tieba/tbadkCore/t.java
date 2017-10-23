package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class t extends bh {
    public static final BdUniqueId gfB = BdUniqueId.gen();
    private bi gfC;
    private bl gfD;
    private boolean gfE = false;

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gfB;
    }

    public boolean bqG() {
        return this.gfE;
    }

    public bi bqH() {
        return this.gfC;
    }

    public bl bqI() {
        return this.gfD;
    }
}
