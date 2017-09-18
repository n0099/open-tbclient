package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class p extends bj {
    public static final BdUniqueId ghU = BdUniqueId.gen();
    private String fortune_desc;
    private boolean ghV;
    private j ghW;

    public boolean brN() {
        return this.ghV;
    }

    public String brO() {
        return this.fortune_desc;
    }

    public j brP() {
        return this.ghW;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return ghU;
    }
}
