package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
/* loaded from: classes.dex */
public class x extends bz {
    public static final BdUniqueId nlF = BdUniqueId.gen();
    private String fortune_desc;
    private boolean nlG;
    private r nlH;

    public boolean dKF() {
        return this.nlG;
    }

    public void xU(boolean z) {
        this.nlG = z;
    }

    public String dKG() {
        return this.fortune_desc;
    }

    public void RY(String str) {
        this.fortune_desc = str;
    }

    public r dKH() {
        return this.nlH;
    }

    public void a(r rVar) {
        this.nlH = rVar;
    }

    @Override // com.baidu.tbadk.core.data.bz, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nlF;
    }
}
