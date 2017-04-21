package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class w extends bi {
    public static final BdUniqueId fwY = BdUniqueId.gen();
    private String fortune_desc;
    private boolean fwZ;
    private o fxa;

    public boolean biA() {
        return this.fwZ;
    }

    public void lq(boolean z) {
        this.fwZ = z;
    }

    public String biB() {
        return this.fortune_desc;
    }

    public void pZ(String str) {
        this.fortune_desc = str;
    }

    public o biC() {
        return this.fxa;
    }

    public void b(o oVar) {
        this.fxa = oVar;
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fwY;
    }
}
