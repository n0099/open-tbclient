package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gBU = BdUniqueId.gen();
    public String avatar;
    public String dcg;
    public String dch;
    public boolean dcn;
    public long forumId;
    public String gBV;
    public int gBW;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gBU;
    }
}
