package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes.dex */
public class d implements i {
    public static final BdUniqueId ghT = BdUniqueId.gen();
    public int bxS;
    public int ges;
    public int get;

    public d() {
    }

    public d(int i, int i2) {
        this.ges = i;
        this.get = i2;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return ghT;
    }
}
