package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public class p extends bh {
    public static final BdUniqueId gfn = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gfo;
    private j gfp;

    public boolean bqD() {
        return this.gfo;
    }

    public String bqE() {
        return this.fortune_desc;
    }

    public j bqF() {
        return this.gfp;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gfn;
    }
}
