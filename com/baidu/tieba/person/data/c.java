package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes9.dex */
public class c implements m {
    public static final BdUniqueId jgc = BdUniqueId.gen();
    private int jgd = 0;

    public int cuZ() {
        return this.jgd;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgc;
    }
}
