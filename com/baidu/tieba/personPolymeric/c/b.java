package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fmb = BdUniqueId.gen();
    public String avatar;
    public String bKR;
    public boolean bKY;
    public boolean buA;
    public String cXk;
    public String fmc;
    public int fmd;
    public long forumId;
    public boolean isAttention;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fmb;
    }
}
