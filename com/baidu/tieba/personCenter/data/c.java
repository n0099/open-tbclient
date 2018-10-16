package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes5.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static BdUniqueId gjp = BdUniqueId.gen();
    public UserData fHF;
    public int gjl;
    public int gjm;
    public int gjn;
    public boolean gjo;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gjp;
    }
}
