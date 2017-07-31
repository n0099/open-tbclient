package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fkw = BdUniqueId.gen();
    public boolean buk;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fkw;
    }
}
