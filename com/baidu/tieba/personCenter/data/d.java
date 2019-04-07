package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b implements m {
    public static BdUniqueId hLz = BdUniqueId.gen();

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hLz;
    }
}
