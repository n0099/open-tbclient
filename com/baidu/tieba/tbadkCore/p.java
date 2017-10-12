package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public class p extends bh {
    public static final BdUniqueId gfB = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gfC;
    private j gfD;

    public boolean bqK() {
        return this.gfC;
    }

    public String bqL() {
        return this.fortune_desc;
    }

    public j bqM() {
        return this.gfD;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gfB;
    }
}
