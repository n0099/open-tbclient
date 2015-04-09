package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class aj extends com.baidu.tbadk.core.data.w {
    public static final BdUniqueId clQ = BdUniqueId.gen();
    private boolean clR;
    private x clS;
    private String fortune_desc;

    public boolean alf() {
        return this.clR;
    }

    public void eK(boolean z) {
        this.clR = z;
    }

    public String alg() {
        return this.fortune_desc;
    }

    public void iD(String str) {
        this.fortune_desc = str;
    }

    public x alh() {
        return this.clS;
    }

    public void b(x xVar) {
        this.clS = xVar;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return clQ;
    }
}
