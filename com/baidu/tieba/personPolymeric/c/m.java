package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes23.dex */
public class m extends BaseCardInfo {
    public static final BdUniqueId mdT = BdUniqueId.gen();
    public List<com.baidu.adp.widget.ListView.q> mdU;
    public long uid;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mdT;
    }
}
