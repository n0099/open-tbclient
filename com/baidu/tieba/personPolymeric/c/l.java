package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId Zd = BdUniqueId.gen();
    public String WY;
    public String XS;
    public String postId;
    public String title;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Zd;
    }
}
