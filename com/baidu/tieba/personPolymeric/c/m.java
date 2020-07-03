package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes11.dex */
public class m extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kNW = BdUniqueId.gen();
    public List<q> kNX;
    public long uid;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kNW;
    }
}
