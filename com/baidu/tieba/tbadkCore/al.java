package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bn;
/* loaded from: classes.dex */
public class al extends bg {
    public static final BdUniqueId frw = BdUniqueId.gen();
    private bk frx;
    private bn fry;
    private boolean frz = false;

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return frw;
    }

    public boolean bit() {
        return this.frz;
    }

    public void kJ(boolean z) {
        this.frz = z;
    }

    public bk biu() {
        return this.frx;
    }

    public void a(bk bkVar) {
        this.frx = bkVar;
    }

    public bn biv() {
        return this.fry;
    }

    public void a(bn bnVar) {
        this.fry = bnVar;
    }
}
