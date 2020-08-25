package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes18.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId lmw = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String hnH;
    public String hnI;
    public boolean hnO;
    public boolean isAttention;
    public boolean isHost;
    public String jhV;
    public int lmx;
    public int postNum;
    public int sex;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lmw;
    }
}
