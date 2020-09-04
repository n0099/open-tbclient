package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes18.dex */
public class m extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId lmX = BdUniqueId.gen();
    public List<com.baidu.adp.widget.ListView.q> lmY;
    public long uid;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lmX;
    }
}
