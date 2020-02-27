package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId joE = BdUniqueId.gen();
    public String avatar;
    public String fNG;
    public String fNH;
    public boolean fNN;
    public long forumId;
    public boolean isAttention;
    public boolean isHost;
    public String joF;
    public int joG;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return joE;
    }
}
