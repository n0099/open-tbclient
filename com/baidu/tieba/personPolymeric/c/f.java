package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes7.dex */
public class f extends BaseCardInfo {
    public static final BdUniqueId msA = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String forumName;
    public int msB;
    public int sex;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return msA;
    }
}
