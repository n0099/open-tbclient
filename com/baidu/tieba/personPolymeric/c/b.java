package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId iqP = BdUniqueId.gen();
    public String avatar;
    public String eGB;
    public String eGC;
    public boolean eGI;
    public long forumId;
    public String iqQ;
    public int iqR;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iqP;
    }
}
