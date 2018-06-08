package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fWA = BdUniqueId.gen();
    public String avatar;
    public String cCj;
    public String cCk;
    public boolean cCq;
    public String fWB;
    public int fWC;
    public long forumId;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fWA;
    }
}
