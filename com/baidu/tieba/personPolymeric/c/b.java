package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gxZ = BdUniqueId.gen();
    public String avatar;
    public String cYC;
    public String cYD;
    public boolean cYJ;
    public long forumId;
    public String gya;
    public int gyb;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gxZ;
    }
}
