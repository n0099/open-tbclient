package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ikt = BdUniqueId.gen();
    public String avatar;
    public String eBE;
    public String eBF;
    public boolean eBL;
    public long forumId;
    public String iku;
    public int ikv;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ikt;
    }
}
