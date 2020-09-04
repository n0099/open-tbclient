package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes.dex */
public class w extends bw {
    public static final BdUniqueId mdX = BdUniqueId.gen();
    private String fortune_desc;
    private boolean mdY;
    private q mdZ;

    public boolean dwg() {
        return this.mdY;
    }

    public void vY(boolean z) {
        this.mdY = z;
    }

    public String dwh() {
        return this.fortune_desc;
    }

    public void QF(String str) {
        this.fortune_desc = str;
    }

    public q dwi() {
        return this.mdZ;
    }

    public void a(q qVar) {
        this.mdZ = qVar;
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mdX;
    }
}
