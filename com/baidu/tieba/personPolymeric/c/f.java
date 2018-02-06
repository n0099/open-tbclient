package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gpL = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String forumName;
    public int gpM;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gpL;
    }
}
