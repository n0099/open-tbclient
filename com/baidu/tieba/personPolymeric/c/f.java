package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fWH = BdUniqueId.gen();
    public String avatar;
    public int fWI;
    public long forumId;
    public String forumName;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fWH;
    }
}
