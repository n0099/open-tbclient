package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static BdUniqueId ghn = BdUniqueId.gen();
    public UserData fDt;
    public int ghj;
    public int ghk;
    public int ghl;
    public boolean ghm;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return ghn;
    }
}
