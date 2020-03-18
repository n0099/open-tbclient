package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jqr = BdUniqueId.gen();
    public String avatar;
    public String fOD;
    public String fOE;
    public boolean fOK;
    public long forumId;
    public boolean isAttention;
    public boolean isHost;
    public String jqs;
    public int jqt;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jqr;
    }
}
