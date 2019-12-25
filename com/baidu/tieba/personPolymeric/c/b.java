package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes8.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jkd = BdUniqueId.gen();
    public String avatar;
    public String fIa;
    public String fIb;
    public boolean fIh;
    public long forumId;
    public boolean isAttention;
    public boolean isHost;
    public String jke;
    public int jkf;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jkd;
    }
}
