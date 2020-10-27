package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes24.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId lXm = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String hWh;
    public String hWi;
    public boolean hWo;
    public boolean isAttention;
    public boolean isHost;
    public String jrg;
    public int lXn;
    public int postNum;
    public int sex;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lXm;
    }
}
