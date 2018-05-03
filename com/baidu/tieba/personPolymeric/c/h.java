package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fKv = BdUniqueId.gen();
    public int width = 0;
    public int height = 0;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fKv;
    }
}
