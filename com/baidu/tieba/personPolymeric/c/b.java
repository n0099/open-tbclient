package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes24.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId lKQ = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String hJK;
    public String hJL;
    public boolean hJR;
    public boolean isAttention;
    public boolean isHost;
    public String jeI;
    public int lKR;
    public int postNum;
    public int sex;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lKQ;
    }
}
