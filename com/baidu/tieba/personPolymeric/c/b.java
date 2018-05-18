package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fLo = BdUniqueId.gen();
    public String avatar;
    public String ctF;
    public String ctG;
    public boolean ctM;
    public String fLp;
    public int fLq;
    public long forumId;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fLo;
    }
}
