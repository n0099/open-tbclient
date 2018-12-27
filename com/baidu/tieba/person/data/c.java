package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes5.dex */
public class c implements h {
    public static final BdUniqueId gto = BdUniqueId.gen();
    private int gtp = 0;

    public int bph() {
        return this.gtp;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gto;
    }
}
