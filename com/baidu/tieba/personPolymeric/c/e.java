package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes23.dex */
public class e extends BaseCardInfo {
    public static final BdUniqueId mdI = BdUniqueId.gen();
    public String des;
    public String iconUrl;
    public String jxU;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mdI;
    }
}
