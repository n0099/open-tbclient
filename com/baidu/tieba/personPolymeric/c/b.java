package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hRG = BdUniqueId.gen();
    public String avatar;
    public String elQ;
    public String elR;
    public boolean elX;
    public long forumId;
    public String hRH;
    public int hRI;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hRG;
    }
}
