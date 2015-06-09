package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class aj extends com.baidu.tbadk.core.data.w {
    public static final BdUniqueId cpQ = BdUniqueId.gen();
    private boolean cpR;
    private x cpS;
    private String fortune_desc;

    public boolean amR() {
        return this.cpR;
    }

    public void fe(boolean z) {
        this.cpR = z;
    }

    public String amS() {
        return this.fortune_desc;
    }

    public void jw(String str) {
        this.fortune_desc = str;
    }

    public x amT() {
        return this.cpS;
    }

    public void b(x xVar) {
        this.cpS = xVar;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return cpQ;
    }
}
