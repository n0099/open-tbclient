package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ktO = BdUniqueId.gen();
    public String des;
    public String iconUrl;
    public String ktJ;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return ktO;
    }
}
