package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
/* loaded from: classes.dex */
public class v extends bk {
    public static final BdUniqueId lkN = BdUniqueId.gen();
    private String fortune_desc;
    private boolean lkO;
    private p lkP;

    public boolean ddf() {
        return this.lkO;
    }

    public void uo(boolean z) {
        this.lkO = z;
    }

    public String ddg() {
        return this.fortune_desc;
    }

    public void Mv(String str) {
        this.fortune_desc = str;
    }

    public p ddh() {
        return this.lkP;
    }

    public void a(p pVar) {
        this.lkP = pVar;
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return lkN;
    }
}
