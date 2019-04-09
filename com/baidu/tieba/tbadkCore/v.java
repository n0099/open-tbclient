package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class v extends bg {
    public static final BdUniqueId iET = BdUniqueId.gen();
    private boolean dgW = false;
    private bi iEU;
    private bl iEV;

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iET;
    }

    public boolean blF() {
        return this.dgW;
    }

    public void pT(boolean z) {
        this.dgW = z;
    }

    public bi cdK() {
        return this.iEU;
    }

    public void a(bi biVar) {
        this.iEU = biVar;
    }

    public bl cdL() {
        return this.iEV;
    }

    public void a(bl blVar) {
        this.iEV = blVar;
    }
}
