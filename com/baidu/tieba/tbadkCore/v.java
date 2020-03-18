package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class v extends bj {
    public static final BdUniqueId khf = BdUniqueId.gen();
    private String fortune_desc;
    private boolean khg;
    private p khh;

    public boolean cKS() {
        return this.khg;
    }

    public void sO(boolean z) {
        this.khg = z;
    }

    public String cKT() {
        return this.fortune_desc;
    }

    public void IV(String str) {
        this.fortune_desc = str;
    }

    public p cKU() {
        return this.khh;
    }

    public void a(p pVar) {
        this.khh = pVar;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return khf;
    }
}
