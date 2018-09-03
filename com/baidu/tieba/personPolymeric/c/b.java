package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gaR = BdUniqueId.gen();
    public String avatar;
    public String cCF;
    public String cCG;
    public boolean cCM;
    public long forumId;
    public String gaS;
    public int gaT;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gaR;
    }
}
