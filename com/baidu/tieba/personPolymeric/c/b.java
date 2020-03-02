package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId joG = BdUniqueId.gen();
    public String avatar;
    public String fNI;
    public String fNJ;
    public boolean fNP;
    public long forumId;
    public boolean isAttention;
    public boolean isHost;
    public String joH;
    public int joI;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return joG;
    }
}
