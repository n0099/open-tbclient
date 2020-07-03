package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class i extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kNT = BdUniqueId.gen();
    public boolean isHost;
    public int sex;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kNT;
    }
}
