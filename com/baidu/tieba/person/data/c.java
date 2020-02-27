package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes9.dex */
public class c implements m {
    public static final BdUniqueId jga = BdUniqueId.gen();
    private int jgb = 0;

    public int cuX() {
        return this.jgb;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jga;
    }
}
