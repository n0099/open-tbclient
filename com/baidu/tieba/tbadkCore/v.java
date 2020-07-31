package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bv;
/* loaded from: classes.dex */
public class v extends bv {
    public static final BdUniqueId lLW = BdUniqueId.gen();
    private String fortune_desc;
    private boolean lLX;
    private p lLY;

    public boolean dkD() {
        return this.lLX;
    }

    public void vh(boolean z) {
        this.lLX = z;
    }

    public String dkE() {
        return this.fortune_desc;
    }

    public void NF(String str) {
        this.fortune_desc = str;
    }

    public p dkF() {
        return this.lLY;
    }

    public void a(p pVar) {
        this.lLY = pVar;
    }

    @Override // com.baidu.tbadk.core.data.bv, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lLW;
    }
}
