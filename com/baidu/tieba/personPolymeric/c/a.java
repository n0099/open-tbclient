package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eHE = BdUniqueId.gen();
    public String avatar;
    public boolean bjz;
    public String bxZ;
    public boolean byg;
    public String eHF;
    public String eHG;
    public int eHH;
    public long forumId;
    public boolean isAttention;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eHE;
    }
}
