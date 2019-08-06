package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId irT = BdUniqueId.gen();
    public String avatar;
    public String eGI;
    public String eGJ;
    public boolean eGP;
    public long forumId;
    public String irU;
    public int irV;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return irT;
    }
}
