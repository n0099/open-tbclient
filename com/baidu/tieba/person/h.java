package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId fcH = BdUniqueId.gen();
    public int eZr;
    public int eZs;
    public int fcI;

    public h() {
    }

    public h(int i, int i2) {
        this.eZr = i;
        this.eZs = i2;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fcH;
    }
}
