package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fpp = BdUniqueId.gen();
    public boolean fpq = true;
    public boolean fpr = true;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fpp;
    }
}
