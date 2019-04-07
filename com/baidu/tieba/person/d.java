package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId hJP = BdUniqueId.gen();
    public int cog;
    public int hGh;
    public int hGi;

    public d() {
    }

    public d(int i, int i2) {
        this.hGh = i;
        this.hGi = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hJP;
    }
}
