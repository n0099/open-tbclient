package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes24.dex */
public class f extends BaseCardInfo {
    public static final BdUniqueId mrP = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String forumName;
    public int mrQ;
    public int sex;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mrP;
    }
}
