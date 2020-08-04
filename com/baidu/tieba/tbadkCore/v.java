package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bv;
/* loaded from: classes.dex */
public class v extends bv {
    public static final BdUniqueId lLY = BdUniqueId.gen();
    private String fortune_desc;
    private boolean lLZ;
    private p lMa;

    public boolean dkE() {
        return this.lLZ;
    }

    public void vh(boolean z) {
        this.lLZ = z;
    }

    public String dkF() {
        return this.fortune_desc;
    }

    public void NF(String str) {
        this.fortune_desc = str;
    }

    public p dkG() {
        return this.lMa;
    }

    public void a(p pVar) {
        this.lMa = pVar;
    }

    @Override // com.baidu.tbadk.core.data.bv, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lLY;
    }
}
