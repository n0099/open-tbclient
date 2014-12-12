package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ag extends com.baidu.tbadk.core.data.w {
    public static final BdUniqueId bTc = BdUniqueId.gen();
    private boolean bRR;
    private u bRS;
    private String fortune_desc;

    public boolean aeC() {
        return this.bRR;
    }

    public void eq(boolean z) {
        this.bRR = z;
    }

    public String aeD() {
        return this.fortune_desc;
    }

    public void hZ(String str) {
        this.fortune_desc = str;
    }

    public u aeE() {
        return this.bRS;
    }

    public void a(u uVar) {
        this.bRS = uVar;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.am
    public BdUniqueId jr() {
        return bTc;
    }
}
