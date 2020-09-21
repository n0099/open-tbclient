package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes23.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId lvE = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String huP;
    public String huQ;
    public boolean huW;
    public String iPO;
    public boolean isAttention;
    public boolean isHost;
    public int lvF;
    public int postNum;
    public int sex;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lvE;
    }
}
