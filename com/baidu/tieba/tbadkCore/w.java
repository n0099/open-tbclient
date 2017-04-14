package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class w extends bi {
    public static final BdUniqueId fuI = BdUniqueId.gen();
    private String fortune_desc;
    private boolean fuJ;
    private o fuK;

    public boolean bhz() {
        return this.fuJ;
    }

    public void lg(boolean z) {
        this.fuJ = z;
    }

    public String bhA() {
        return this.fortune_desc;
    }

    public void pY(String str) {
        this.fortune_desc = str;
    }

    public o bhB() {
        return this.fuK;
    }

    public void b(o oVar) {
        this.fuK = oVar;
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fuI;
    }
}
