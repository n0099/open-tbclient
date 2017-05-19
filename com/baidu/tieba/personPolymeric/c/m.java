package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eDt = BdUniqueId.gen();
    public long eDu;
    public String picUrl;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eDt;
    }
}
