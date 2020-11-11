package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes24.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId mdr = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String forumName;
    public int mds;
    public int sex;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mdr;
    }
}
