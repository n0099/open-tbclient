package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class l extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId atL = BdUniqueId.gen();
    public String postId;
    public String thumbnailUrl;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return atL;
    }
}
