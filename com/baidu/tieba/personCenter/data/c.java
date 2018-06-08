package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b implements h {
    public static BdUniqueId fQq = BdUniqueId.gen();

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fQq;
    }
}
