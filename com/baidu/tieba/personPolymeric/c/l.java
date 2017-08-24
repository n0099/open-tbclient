package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId Zg = BdUniqueId.gen();
    public String XV;
    public String Xb;
    public String postId;
    public String title;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Zg;
    }
}
