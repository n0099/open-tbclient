package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kaK = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String gtq;
    public String gtr;
    public boolean gtx;
    public boolean isAttention;
    public boolean isHost;
    public String kaL;
    public int kaM;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kaK;
    }
}
