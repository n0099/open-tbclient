package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class c implements m {
    public static final BdUniqueId hKJ = BdUniqueId.gen();
    private int hKK = 0;

    public int bQm() {
        return this.hKK;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hKJ;
    }
}
