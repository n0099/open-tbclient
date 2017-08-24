package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fms = BdUniqueId.gen();
    public boolean fmt = true;
    public boolean fmu = true;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fms;
    }
}
