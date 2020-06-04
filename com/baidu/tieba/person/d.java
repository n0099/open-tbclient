package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
/* loaded from: classes.dex */
public class d implements o {
    public static final BdUniqueId kkD = BdUniqueId.gen();
    public int backgroundId;
    public int khF;
    public int khG;

    public d() {
    }

    public d(int i, int i2) {
        this.khF = i;
        this.khG = i2;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return kkD;
    }
}
