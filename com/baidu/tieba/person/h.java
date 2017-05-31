package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class h implements v {
    public static final BdUniqueId eGy = BdUniqueId.gen();
    public int eDi;
    public int eDj;
    public int eGz;

    public h() {
    }

    public h(int i, int i2) {
        this.eDi = i;
        this.eDj = i2;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eGy;
    }
}
