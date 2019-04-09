package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hRH = BdUniqueId.gen();
    public String avatar;
    public String elR;
    public String elS;
    public boolean elY;
    public long forumId;
    public String hRI;
    public int hRJ;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hRH;
    }
}
