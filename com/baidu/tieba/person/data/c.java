package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes2.dex */
public class c implements h {
    public static final BdUniqueId fTA = BdUniqueId.gen();
    private int fTB = 0;

    public int bhB() {
        return this.fTB;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fTA;
    }
}
