package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes5.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static BdUniqueId gjq = BdUniqueId.gen();
    public UserData fHG;
    public int gjm;
    public int gjn;
    public int gjo;
    public boolean gjp;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gjq;
    }
}
