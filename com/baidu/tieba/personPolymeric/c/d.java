package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eHz = BdUniqueId.gen();
    public String des;
    public String eHu;
    public String iconUrl;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eHz;
    }
}
