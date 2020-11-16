package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes23.dex */
public class f extends BaseCardInfo {
    public static final BdUniqueId mdJ = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String forumName;
    public int mdK;
    public int sex;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mdJ;
    }
}
