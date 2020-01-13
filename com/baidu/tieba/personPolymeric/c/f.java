package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jnM = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String forumName;
    public int jnN;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jnM;
    }
}
