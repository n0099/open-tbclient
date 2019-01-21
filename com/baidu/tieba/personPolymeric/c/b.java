package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gBV = BdUniqueId.gen();
    public String avatar;
    public String dch;
    public String dci;
    public boolean dco;
    public long forumId;
    public String gBW;
    public int gBX;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gBV;
    }
}
