package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eMm = BdUniqueId.gen();
    public String avatar;
    public String bDU;
    public boolean bEb;
    public boolean bld;
    public String cDr;
    public String eMn;
    public int eMo;
    public long forumId;
    public boolean isAttention;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eMm;
    }
}
