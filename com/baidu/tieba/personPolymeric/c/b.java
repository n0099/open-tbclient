package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fgB = BdUniqueId.gen();
    public String avatar;
    public String bNV;
    public boolean bOc;
    public String fgC;
    public String fgD;
    public int fgE;
    public long forumId;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fgB;
    }
}
