package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId grj = BdUniqueId.gen();
    public String avatar;
    public String cRV;
    public String cRW;
    public boolean cSc;
    public long forumId;
    public String grk;
    public int grl;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return grj;
    }
}
