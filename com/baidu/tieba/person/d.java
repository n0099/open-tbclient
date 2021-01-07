package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes.dex */
public class d implements n {
    public static final BdUniqueId mny = BdUniqueId.gen();
    public int backgroundId;
    public int mkD;
    public int mkE;

    public d() {
    }

    public d(int i, int i2) {
        this.mkD = i;
        this.mkE = i2;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mny;
    }
}
