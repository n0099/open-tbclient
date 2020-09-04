package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes18.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId lmH = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String hnL;
    public String hnM;
    public boolean hnS;
    public boolean isAttention;
    public boolean isHost;
    public String jib;
    public int lmI;
    public int postNum;
    public int sex;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lmH;
    }
}
