package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jnK = BdUniqueId.gen();
    public String avatar;
    public String fLk;
    public String fLl;
    public boolean fLr;
    public long forumId;
    public boolean isAttention;
    public boolean isHost;
    public String jnL;
    public int jnM;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jnK;
    }
}
