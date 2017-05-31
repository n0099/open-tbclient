package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eMG = BdUniqueId.gen();
    public long eMH;
    public String picUrl;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eMG;
    }
}
