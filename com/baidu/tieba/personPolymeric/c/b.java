package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ikx = BdUniqueId.gen();
    public String avatar;
    public String eBF;
    public String eBG;
    public boolean eBM;
    public long forumId;
    public String iky;
    public int ikz;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ikx;
    }
}
