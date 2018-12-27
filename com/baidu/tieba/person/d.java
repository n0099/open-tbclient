package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes.dex */
public class d implements h {
    public static final BdUniqueId gsO = BdUniqueId.gen();
    public int bdO;
    public int gpf;
    public int gpg;

    public d() {
    }

    public d(int i, int i2) {
        this.gpf = i;
        this.gpg = i2;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gsO;
    }
}
