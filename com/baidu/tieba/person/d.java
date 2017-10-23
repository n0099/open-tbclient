package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eYJ = BdUniqueId.gen();
    public int aGl;
    public int eVF;
    public int eVG;

    public d() {
    }

    public d(int i, int i2) {
        this.eVF = i;
        this.eVG = i2;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eYJ;
    }
}
