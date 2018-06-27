package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes2.dex */
public class c implements h {
    public static final BdUniqueId fTn = BdUniqueId.gen();
    private int fTo = 0;

    public int bji() {
        return this.fTo;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fTn;
    }
}
