package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class v extends bg {
    public static final BdUniqueId iFi = BdUniqueId.gen();
    private boolean dgS = false;
    private bi iFj;
    private bl iFk;

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iFi;
    }

    public boolean blI() {
        return this.dgS;
    }

    public void pT(boolean z) {
        this.dgS = z;
    }

    public bi cdO() {
        return this.iFj;
    }

    public void a(bi biVar) {
        this.iFj = biVar;
    }

    public bl cdP() {
        return this.iFk;
    }

    public void a(bl blVar) {
        this.iFk = blVar;
    }
}
