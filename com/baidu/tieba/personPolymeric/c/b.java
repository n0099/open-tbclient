package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes8.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId mwY = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String iAn;
    public String iAo;
    public boolean iAu;
    public boolean isAttention;
    public boolean isHost;
    public String jYM;
    public int mwZ;
    public int postNum;
    public int sex;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mwY;
    }
}
