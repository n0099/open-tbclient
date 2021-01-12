package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes7.dex */
public class e extends BaseCardInfo {
    public static final BdUniqueId msz = BdUniqueId.gen();
    public String des;
    public String iconUrl;
    public String jUh;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return msz;
    }
}
