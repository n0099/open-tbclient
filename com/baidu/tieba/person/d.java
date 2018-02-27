package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes.dex */
public class d implements i {
    public static final BdUniqueId ghD = BdUniqueId.gen();
    public int bxP;
    public int geb;
    public int gec;

    public d() {
    }

    public d(int i, int i2) {
        this.geb = i;
        this.gec = i2;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return ghD;
    }
}
