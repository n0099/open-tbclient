package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eJZ = BdUniqueId.gen();
    public boolean akC;
    public String avatar;
    public String bcL;
    public boolean bcS;
    public boolean bcU;
    public String eKa;
    public String eKb;
    public int eKc;
    public long forumId;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eJZ;
    }
}
