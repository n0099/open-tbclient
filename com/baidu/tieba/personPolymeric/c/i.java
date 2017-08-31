package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fkM = BdUniqueId.gen();
    public boolean bvm;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fkM;
    }
}
