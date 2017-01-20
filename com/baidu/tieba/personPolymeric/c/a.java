package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eDQ = BdUniqueId.gen();
    public String avatar;
    public boolean baK;
    public String boU;
    public boolean bpb;
    public String eDR;
    public String eDS;
    public int eDT;
    public long forumId;
    public boolean isAttention;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eDQ;
    }
}
