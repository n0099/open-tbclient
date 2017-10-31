package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId foZ = BdUniqueId.gen();
    public String avatar;
    public String bVA;
    public boolean bVH;
    public long forumId;
    public String fpa;
    public String fpb;
    public int fpc;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return foZ;
    }
}
