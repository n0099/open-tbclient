package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class aa extends com.baidu.tbadk.core.data.z {
    public static final BdUniqueId dFI = BdUniqueId.gen();
    private boolean dFJ;
    private q dFK;
    private String fortune_desc;

    public boolean aEz() {
        return this.dFJ;
    }

    public void hs(boolean z) {
        this.dFJ = z;
    }

    public String aEA() {
        return this.fortune_desc;
    }

    public void mp(String str) {
        this.fortune_desc = str;
    }

    public q aEB() {
        return this.dFK;
    }

    public void b(q qVar) {
        this.dFK = qVar;
    }

    @Override // com.baidu.tbadk.core.data.z, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dFI;
    }
}
