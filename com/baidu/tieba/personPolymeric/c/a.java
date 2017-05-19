package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eCZ = BdUniqueId.gen();
    public String avatar;
    public boolean bjW;
    public String bxY;
    public boolean byg;
    public String cxa;
    public String eDa;
    public int eDb;
    public long forumId;
    public boolean isAttention;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eCZ;
    }
}
