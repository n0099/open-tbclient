package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fgP = BdUniqueId.gen();
    public String avatar;
    public String bOh;
    public boolean bOo;
    public String fgQ;
    public String fgR;
    public int fgS;
    public long forumId;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fgP;
    }
}
