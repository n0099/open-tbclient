package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId iss = BdUniqueId.gen();
    public String avatar;
    public String eQW;
    public String eQX;
    public boolean eRd;
    public long forumId;
    public boolean isAttention;
    public boolean isHost;
    public String ist;
    public int isu;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iss;
    }
}
