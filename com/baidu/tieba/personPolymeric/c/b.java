package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fmd = BdUniqueId.gen();
    public String avatar;
    public String bKS;
    public boolean bKZ;
    public boolean buB;
    public String cXk;
    public String fme;
    public int fmf;
    public long forumId;
    public boolean isAttention;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fmd;
    }
}
