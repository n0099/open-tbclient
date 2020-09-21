package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes.dex */
public class w extends bw {
    public static final BdUniqueId mnw = BdUniqueId.gen();
    private String fortune_desc;
    private boolean mnx;
    private q mny;

    public boolean dzZ() {
        return this.mnx;
    }

    public void wh(boolean z) {
        this.mnx = z;
    }

    public String dAa() {
        return this.fortune_desc;
    }

    public void Rf(String str) {
        this.fortune_desc = str;
    }

    public q dAb() {
        return this.mny;
    }

    public void a(q qVar) {
        this.mny = qVar;
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mnw;
    }
}
