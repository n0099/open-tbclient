package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hRU = BdUniqueId.gen();
    public String avatar;
    public String eme;
    public String emf;
    public boolean eml;
    public long forumId;
    public String hRV;
    public int hRW;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hRU;
    }
}
