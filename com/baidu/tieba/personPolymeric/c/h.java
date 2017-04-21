package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eHS = BdUniqueId.gen();
    public boolean bjz;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eHS;
    }
}
