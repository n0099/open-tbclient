package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes21.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static BdUniqueId lnO = BdUniqueId.gen();
    public int lnK;
    public int lnL;
    public int lnM;
    public boolean lnN;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lnO;
    }
}
