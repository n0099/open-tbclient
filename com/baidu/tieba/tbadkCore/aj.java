package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class aj extends com.baidu.tbadk.core.data.w {
    public static final BdUniqueId cpP = BdUniqueId.gen();
    private boolean cpQ;
    private x cpR;
    private String fortune_desc;

    public boolean amQ() {
        return this.cpQ;
    }

    public void fe(boolean z) {
        this.cpQ = z;
    }

    public String amR() {
        return this.fortune_desc;
    }

    public void jw(String str) {
        this.fortune_desc = str;
    }

    public x amS() {
        return this.cpR;
    }

    public void b(x xVar) {
        this.cpR = xVar;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return cpP;
    }
}
