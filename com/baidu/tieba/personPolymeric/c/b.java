package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gAQ = BdUniqueId.gen();
    public String avatar;
    public boolean dbB;
    public String dbu;
    public String dbv;
    public long forumId;
    public String gAR;
    public int gAS;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gAQ;
    }
}
