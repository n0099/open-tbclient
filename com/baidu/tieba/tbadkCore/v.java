package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class v extends bg {
    public static final BdUniqueId iFq = BdUniqueId.gen();
    private boolean dgW = false;
    private bi iFr;
    private bl iFs;

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iFq;
    }

    public boolean blJ() {
        return this.dgW;
    }

    public void pT(boolean z) {
        this.dgW = z;
    }

    public bi cdM() {
        return this.iFr;
    }

    public void a(bi biVar) {
        this.iFr = biVar;
    }

    public bl cdN() {
        return this.iFs;
    }

    public void a(bl blVar) {
        this.iFs = blVar;
    }
}
