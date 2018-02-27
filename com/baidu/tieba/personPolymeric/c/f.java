package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gpA = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String forumName;
    public int gpB;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gpA;
    }
}
