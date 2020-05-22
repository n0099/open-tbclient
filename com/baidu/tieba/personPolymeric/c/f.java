package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ksJ = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String forumName;
    public int ksK;
    public int sex;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return ksJ;
    }
}
