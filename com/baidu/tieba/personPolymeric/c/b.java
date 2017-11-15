package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fpx = BdUniqueId.gen();
    public String avatar;
    public String bVN;
    public boolean bVU;
    public long forumId;
    public int fpA;
    public String fpy;
    public String fpz;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fpx;
    }
}
