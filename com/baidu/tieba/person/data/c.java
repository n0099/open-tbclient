package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes5.dex */
public class c implements h {
    public static final BdUniqueId gqx = BdUniqueId.gen();
    private int gqy = 0;

    public int bow() {
        return this.gqy;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gqx;
    }
}
