package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId joS = BdUniqueId.gen();
    public String avatar;
    public String fNV;
    public String fNW;
    public boolean fOc;
    public long forumId;
    public boolean isAttention;
    public boolean isHost;
    public String joT;
    public int joU;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return joS;
    }
}
