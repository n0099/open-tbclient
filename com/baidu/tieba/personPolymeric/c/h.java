package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eDm = BdUniqueId.gen();
    public boolean bjW;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eDm;
    }
}
