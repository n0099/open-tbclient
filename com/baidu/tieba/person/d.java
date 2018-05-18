package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes.dex */
public class d implements h {
    public static final BdUniqueId fDs = BdUniqueId.gen();
    public int aIq;
    public int fzK;
    public int fzL;

    public d() {
    }

    public d(int i, int i2) {
        this.fzK = i;
        this.fzL = i2;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fDs;
    }
}
