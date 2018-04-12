package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fKl = BdUniqueId.gen();
    public String avatar;
    public boolean csF;
    public String csy;
    public String csz;
    public String fKm;
    public int fKn;
    public long forumId;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fKl;
    }
}
