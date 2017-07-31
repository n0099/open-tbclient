package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fki = BdUniqueId.gen();
    public String avatar;
    public String bKi;
    public boolean bKp;
    public boolean buk;
    public String cVl;
    public String fkj;
    public int fkk;
    public long forumId;
    public boolean isAttention;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fki;
    }
}
