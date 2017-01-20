package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bn;
/* loaded from: classes.dex */
public class ag extends bh {
    public static final BdUniqueId foQ = BdUniqueId.gen();
    private bk foR;
    private bn foS;
    private boolean foT = false;

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return foQ;
    }

    public boolean bhe() {
        return this.foT;
    }

    public void lg(boolean z) {
        this.foT = z;
    }

    public bk bhf() {
        return this.foR;
    }

    public void a(bk bkVar) {
        this.foR = bkVar;
    }

    public bn bhg() {
        return this.foS;
    }

    public void a(bn bnVar) {
        this.foS = bnVar;
    }
}
