package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class v extends bg {
    public static final BdUniqueId iES = BdUniqueId.gen();
    private boolean dgV = false;
    private bi iET;
    private bl iEU;

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iES;
    }

    public boolean blF() {
        return this.dgV;
    }

    public void pT(boolean z) {
        this.dgV = z;
    }

    public bi cdK() {
        return this.iET;
    }

    public void a(bi biVar) {
        this.iET = biVar;
    }

    public bl cdL() {
        return this.iEU;
    }

    public void a(bl blVar) {
        this.iEU = blVar;
    }
}
