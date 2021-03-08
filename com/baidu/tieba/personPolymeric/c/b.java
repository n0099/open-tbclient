package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes7.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId mDP = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String iDn;
    public String iDo;
    public boolean iDu;
    public boolean isAttention;
    public boolean isHost;
    public String kdY;
    public int mDQ;
    public int postNum;
    public int sex;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mDP;
    }
}
