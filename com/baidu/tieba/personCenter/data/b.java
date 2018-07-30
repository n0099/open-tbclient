package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fUE = BdUniqueId.gen();
    public int fUA;
    public int fUB;
    public int fUC;
    public boolean fUD;
    public UserData fsA;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fUE;
    }
}
