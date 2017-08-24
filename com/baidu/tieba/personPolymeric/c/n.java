package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fmy = BdUniqueId.gen();
    public long fmz;
    public String picUrl;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fmy;
    }
}
