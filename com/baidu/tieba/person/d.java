package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes.dex */
public class d implements h {
    public static final BdUniqueId gjh = BdUniqueId.gen();
    public int ban;
    public int gfx;
    public int gfy;

    public d() {
    }

    public d(int i, int i2) {
        this.gfx = i;
        this.gfy = i2;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gjh;
    }
}
