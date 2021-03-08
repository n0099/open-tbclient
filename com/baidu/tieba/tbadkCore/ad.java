package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.cd;
import com.baidu.tbadk.core.data.cg;
/* loaded from: classes.dex */
public class ad extends cb {
    public static final BdUniqueId nyf = BdUniqueId.gen();
    private boolean gII = false;
    private cd nyg;
    private cg nyh;

    @Override // com.baidu.tbadk.core.data.cb, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nyf;
    }

    public boolean dNj() {
        return this.gII;
    }

    public void yo(boolean z) {
        this.gII = z;
    }

    public cd dNk() {
        return this.nyg;
    }

    public void a(cd cdVar) {
        this.nyg = cdVar;
    }

    public cg dNl() {
        return this.nyh;
    }

    public void a(cg cgVar) {
        this.nyh = cgVar;
    }
}
