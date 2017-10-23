package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId XZ = BdUniqueId.gen();
    public String WT;
    public String Wm;
    public String postId;
    public String title;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return XZ;
    }
}
