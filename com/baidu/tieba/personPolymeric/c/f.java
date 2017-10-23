package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fgJ = BdUniqueId.gen();
    public String avatar;
    public int fgK;
    public long forumId;
    public String forumName;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fgJ;
    }
}
