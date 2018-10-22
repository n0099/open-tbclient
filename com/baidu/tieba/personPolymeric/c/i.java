package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gpY = BdUniqueId.gen();
    public boolean isHost;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gpY;
    }
}
