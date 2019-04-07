package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class l extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId bBg = BdUniqueId.gen();
    public String postId;
    public String thumbnailUrl;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bBg;
    }
}
