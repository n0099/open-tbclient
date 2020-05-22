package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
/* loaded from: classes.dex */
public class v extends bk {
    public static final BdUniqueId ljE = BdUniqueId.gen();
    private String fortune_desc;
    private boolean ljF;
    private p ljG;

    public boolean dcQ() {
        return this.ljF;
    }

    public void uo(boolean z) {
        this.ljF = z;
    }

    public String dcR() {
        return this.fortune_desc;
    }

    public void Mu(String str) {
        this.fortune_desc = str;
    }

    public p dcS() {
        return this.ljG;
    }

    public void a(p pVar) {
        this.ljG = pVar;
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return ljE;
    }
}
