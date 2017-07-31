package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class p extends bl {
    public static final BdUniqueId ggG = BdUniqueId.gen();
    private String fortune_desc;
    private boolean ggH;
    private j ggI;

    public boolean brM() {
        return this.ggH;
    }

    public String brN() {
        return this.fortune_desc;
    }

    public j brO() {
        return this.ggI;
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return ggG;
    }
}
