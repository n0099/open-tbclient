package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId Xv = BdUniqueId.gen();
    public String Vz;
    public String Wl;
    public String postId;
    public String title;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Xv;
    }
}
