package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fUx = BdUniqueId.gen();
    public int fUt;
    public int fUu;
    public int fUv;
    public boolean fUw;
    public UserData fst;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fUx;
    }
}
