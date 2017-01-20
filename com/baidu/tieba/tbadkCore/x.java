package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public class x extends bh {
    public static final BdUniqueId foC = BdUniqueId.gen();
    private boolean foD;
    private o foE;
    private String fortune_desc;

    public boolean bhb() {
        return this.foD;
    }

    public void lf(boolean z) {
        this.foD = z;
    }

    public String bhc() {
        return this.fortune_desc;
    }

    public void qz(String str) {
        this.fortune_desc = str;
    }

    public o bhd() {
        return this.foE;
    }

    public void b(o oVar) {
        this.foE = oVar;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return foC;
    }
}
