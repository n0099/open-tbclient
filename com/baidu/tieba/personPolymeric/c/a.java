package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eFo = BdUniqueId.gen();
    public String avatar;
    public boolean bho;
    public String bvI;
    public boolean bvP;
    public String eFp;
    public String eFq;
    public int eFr;
    public long forumId;
    public boolean isAttention;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eFo;
    }
}
