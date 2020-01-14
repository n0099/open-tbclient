package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes7.dex */
public class e extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static BdUniqueId jgs = BdUniqueId.gen();

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgs;
    }
}
