package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.cd;
import com.baidu.tbadk.core.data.cg;
/* loaded from: classes.dex */
public class ad extends cb {
    public static final BdUniqueId nvB = BdUniqueId.gen();
    private boolean gGL = false;
    private cd nvC;
    private cg nvD;

    @Override // com.baidu.tbadk.core.data.cb, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nvB;
    }

    public boolean dMT() {
        return this.gGL;
    }

    public void yo(boolean z) {
        this.gGL = z;
    }

    public cd dMU() {
        return this.nvC;
    }

    public void a(cd cdVar) {
        this.nvC = cdVar;
    }

    public cg dMV() {
        return this.nvD;
    }

    public void a(cg cgVar) {
        this.nvD = cgVar;
    }
}
