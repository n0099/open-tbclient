package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.cd;
import com.baidu.tbadk.core.data.cg;
/* loaded from: classes.dex */
public class ad extends cb {
    public static final BdUniqueId nwb = BdUniqueId.gen();
    private boolean gGZ = false;
    private cd nwc;
    private cg nwd;

    @Override // com.baidu.tbadk.core.data.cb, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nwb;
    }

    public boolean dNb() {
        return this.gGZ;
    }

    public void yo(boolean z) {
        this.gGZ = z;
    }

    public cd dNc() {
        return this.nwc;
    }

    public void a(cd cdVar) {
        this.nwc = cdVar;
    }

    public cg dNd() {
        return this.nwd;
    }

    public void a(cg cgVar) {
        this.nwd = cgVar;
    }
}
