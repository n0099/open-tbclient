package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public class p extends bh {
    public static final BdUniqueId gfC = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gfD;
    private j gfE;

    public boolean bqL() {
        return this.gfD;
    }

    public String bqM() {
        return this.fortune_desc;
    }

    public j bqN() {
        return this.gfE;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gfC;
    }
}
