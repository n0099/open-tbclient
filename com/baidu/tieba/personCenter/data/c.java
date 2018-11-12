package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes5.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static BdUniqueId gkP = BdUniqueId.gen();
    public UserData fJe;
    public int gkL;
    public int gkM;
    public int gkN;
    public boolean gkO;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gkP;
    }
}
