package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId jfH = BdUniqueId.gen();
    public int backgroundId;
    public int jcN;
    public int jcO;

    public d() {
    }

    public d(int i, int i2) {
        this.jcN = i;
        this.jcO = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jfH;
    }
}
