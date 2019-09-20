package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId itS = BdUniqueId.gen();
    public String avatar;
    public String eIr;
    public String eIs;
    public boolean eIy;
    public long forumId;
    public boolean isAttention;
    public boolean isHost;
    public String itT;
    public int itU;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return itS;
    }
}
