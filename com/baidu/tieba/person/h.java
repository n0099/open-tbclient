package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId fef = BdUniqueId.gen();
    public int aHa;
    public int faP;
    public int faQ;

    public h() {
    }

    public h(int i, int i2) {
        this.faP = i;
        this.faQ = i2;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fef;
    }
}
