package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fgR = BdUniqueId.gen();
    public boolean fgS = true;
    public boolean fgT = true;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fgR;
    }
}
