package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class p extends bj {
    public static final BdUniqueId gha = BdUniqueId.gen();
    private String fortune_desc;
    private boolean ghb;
    private j ghc;

    public boolean brC() {
        return this.ghb;
    }

    public String brD() {
        return this.fortune_desc;
    }

    public j brE() {
        return this.ghc;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gha;
    }
}
