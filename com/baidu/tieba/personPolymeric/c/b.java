package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes24.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId mdl = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String ice;
    public String icf;
    public boolean icl;
    public boolean isAttention;
    public boolean isHost;
    public String jxd;
    public int mdm;
    public int postNum;
    public int sex;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mdl;
    }
}
