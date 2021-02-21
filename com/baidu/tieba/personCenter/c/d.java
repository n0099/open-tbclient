package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class d extends BaseCardInfo {
    public static BdUniqueId mtT = BdUniqueId.gen();
    public int mtP;
    public int mtQ;
    public int mtR;
    public boolean mtS;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mtT;
    }
}
