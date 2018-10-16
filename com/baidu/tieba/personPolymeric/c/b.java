package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gpJ = BdUniqueId.gen();
    public String avatar;
    public String cQP;
    public String cQQ;
    public boolean cQW;
    public long forumId;
    public String gpK;
    public int gpL;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gpJ;
    }
}
