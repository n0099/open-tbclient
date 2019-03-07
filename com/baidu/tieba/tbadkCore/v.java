package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class v extends bg {
    public static final BdUniqueId iFp = BdUniqueId.gen();
    private boolean dgW = false;
    private bi iFq;
    private bl iFr;

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iFp;
    }

    public boolean blI() {
        return this.dgW;
    }

    public void pT(boolean z) {
        this.dgW = z;
    }

    public bi cdL() {
        return this.iFq;
    }

    public void a(bi biVar) {
        this.iFq = biVar;
    }

    public bl cdM() {
        return this.iFr;
    }

    public void a(bl blVar) {
        this.iFr = blVar;
    }
}
