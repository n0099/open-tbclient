package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static BdUniqueId lPC = BdUniqueId.gen();
    public int lPA;
    public boolean lPB;
    public int lPy;
    public int lPz;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lPC;
    }
}
