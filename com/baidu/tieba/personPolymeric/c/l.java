package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class l extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dLH = BdUniqueId.gen();
    public String postId;
    public String thumbnailUrl;
    public String tid;
    public String title;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dLH;
    }
}
