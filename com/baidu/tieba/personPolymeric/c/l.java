package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes24.dex */
public class l extends BaseCardInfo {
    public static final BdUniqueId eJq = BdUniqueId.gen();
    public String postId;
    public String thumbnailUrl;
    public String tid;
    public String title;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eJq;
    }
}
