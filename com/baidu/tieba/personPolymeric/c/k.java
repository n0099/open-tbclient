package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId XM = BdUniqueId.gen();
    public String VP;
    public String WD;
    public String postId;
    public String title;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return XM;
    }
}
