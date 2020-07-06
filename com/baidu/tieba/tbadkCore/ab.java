package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bz;
/* loaded from: classes.dex */
public class ab extends bu {
    public static final BdUniqueId lET = BdUniqueId.gen();
    private boolean ftM = false;
    private bw lEU;
    private bz lEV;

    @Override // com.baidu.tbadk.core.data.bu, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lET;
    }

    public boolean dhy() {
        return this.ftM;
    }

    public void uE(boolean z) {
        this.ftM = z;
    }

    public bw dhz() {
        return this.lEU;
    }

    public void a(bw bwVar) {
        this.lEU = bwVar;
    }

    public bz dhA() {
        return this.lEV;
    }

    public void a(bz bzVar) {
        this.lEV = bzVar;
    }
}
