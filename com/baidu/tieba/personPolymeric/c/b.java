package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kNF = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String gVm;
    public String gVn;
    public boolean gVt;
    public boolean isAttention;
    public boolean isHost;
    public String kNG;
    public int kNH;
    public int postNum;
    public int sex;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kNF;
    }
}
