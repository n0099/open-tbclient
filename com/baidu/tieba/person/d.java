package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes.dex */
public class d implements h {
    public static final BdUniqueId fOM = BdUniqueId.gen();
    public int aQS;
    public int fLf;
    public int fLg;

    public d() {
    }

    public d(int i, int i2) {
        this.fLf = i;
        this.fLg = i2;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fOM;
    }
}
