package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes2.dex */
public class w extends bw {
    public static final BdUniqueId mdI = BdUniqueId.gen();
    private String fortune_desc;
    private boolean mdJ;
    private q mdK;

    public boolean dwb() {
        return this.mdJ;
    }

    public void vW(boolean z) {
        this.mdJ = z;
    }

    public String dwc() {
        return this.fortune_desc;
    }

    public void QF(String str) {
        this.fortune_desc = str;
    }

    public q dwd() {
        return this.mdK;
    }

    public void a(q qVar) {
        this.mdK = qVar;
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mdI;
    }
}
