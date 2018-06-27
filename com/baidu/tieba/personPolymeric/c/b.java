package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gaA = BdUniqueId.gen();
    public String avatar;
    public String cAd;
    public String cAe;
    public boolean cAk;
    public long forumId;
    public String gaB;
    public int gaC;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gaA;
    }
}
