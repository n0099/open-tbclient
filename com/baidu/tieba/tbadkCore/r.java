package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
public class r extends bd {
    public static final BdUniqueId gAI = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gAJ;
    private l gAK;

    public boolean bwj() {
        return this.gAJ;
    }

    public String bwk() {
        return this.fortune_desc;
    }

    public l bwl() {
        return this.gAK;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gAI;
    }
}
