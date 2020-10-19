package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static BdUniqueId lDf = BdUniqueId.gen();
    public int lDb;
    public int lDc;
    public int lDd;
    public boolean lDe;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lDf;
    }
}
