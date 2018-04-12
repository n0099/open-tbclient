package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fDT = BdUniqueId.gen();
    public int fDP;
    public int fDQ;
    public int fDR;
    public boolean fDS;
    public UserData fbV;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fDT;
    }
}
