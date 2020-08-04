package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes18.dex */
public class i extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kWS = BdUniqueId.gen();
    public boolean isHost;
    public int sex;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kWS;
    }
}
