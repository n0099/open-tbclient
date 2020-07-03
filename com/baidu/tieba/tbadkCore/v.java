package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bu;
/* loaded from: classes.dex */
public class v extends bu {
    public static final BdUniqueId lEH = BdUniqueId.gen();
    private String fortune_desc;
    private boolean lEI;
    private p lEJ;

    public boolean dhu() {
        return this.lEI;
    }

    public void uD(boolean z) {
        this.lEI = z;
    }

    public String dhv() {
        return this.fortune_desc;
    }

    public void MX(String str) {
        this.fortune_desc = str;
    }

    public p dhw() {
        return this.lEJ;
    }

    public void a(p pVar) {
        this.lEJ = pVar;
    }

    @Override // com.baidu.tbadk.core.data.bu, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lEH;
    }
}
