package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class aj extends com.baidu.tbadk.core.data.w {
    public static final BdUniqueId clA = BdUniqueId.gen();
    private boolean clB;
    private x clC;
    private String fortune_desc;

    public boolean akQ() {
        return this.clB;
    }

    public void eM(boolean z) {
        this.clB = z;
    }

    public String akR() {
        return this.fortune_desc;
    }

    public void iA(String str) {
        this.fortune_desc = str;
    }

    public x akS() {
        return this.clC;
    }

    public void b(x xVar) {
        this.clC = xVar;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return clA;
    }
}
