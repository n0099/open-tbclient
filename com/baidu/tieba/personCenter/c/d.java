package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static BdUniqueId leP = BdUniqueId.gen();
    public int leL;
    public int leM;
    public int leN;
    public boolean leO;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return leP;
    }
}
