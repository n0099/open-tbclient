package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes2.dex */
public class c implements h {
    public static final BdUniqueId fDR = BdUniqueId.gen();
    private int fDS = 0;

    public int bdC() {
        return this.fDS;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fDR;
    }
}
