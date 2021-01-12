package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes.dex */
public class d implements n {
    public static final BdUniqueId miU = BdUniqueId.gen();
    public int backgroundId;
    public int mfX;
    public int mfY;

    public d() {
    }

    public d(int i, int i2) {
        this.mfX = i;
        this.mfY = i2;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return miU;
    }
}
