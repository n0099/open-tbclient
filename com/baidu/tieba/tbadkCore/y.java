package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.core.data.v {
    public static final BdUniqueId cHK = BdUniqueId.gen();
    private boolean cHL;
    private o cHM;
    private String fortune_desc;

    public boolean apr() {
        return this.cHL;
    }

    public void fw(boolean z) {
        this.cHL = z;
    }

    public String aps() {
        return this.fortune_desc;
    }

    public void ks(String str) {
        this.fortune_desc = str;
    }

    public o apt() {
        return this.cHM;
    }

    public void b(o oVar) {
        this.cHM = oVar;
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cHK;
    }
}
