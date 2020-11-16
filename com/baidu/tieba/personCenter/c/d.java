package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class d extends BaseCardInfo {
    public static BdUniqueId lVQ = BdUniqueId.gen();
    public int lVM;
    public int lVN;
    public int lVO;
    public boolean lVP;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lVQ;
    }
}
