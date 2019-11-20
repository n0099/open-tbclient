package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId irB = BdUniqueId.gen();
    public String avatar;
    public String eQf;
    public String eQg;
    public boolean eQm;
    public long forumId;
    public String irC;
    public int irD;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return irB;
    }
}
