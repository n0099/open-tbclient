package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ksC = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String gIb;
    public String gIc;
    public boolean gIi;
    public boolean isAttention;
    public boolean isHost;
    public String ksD;
    public int ksE;
    public int postNum;
    public int sex;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return ksC;
    }
}
