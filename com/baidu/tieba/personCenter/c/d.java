package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static BdUniqueId jTi = BdUniqueId.gen();
    public int jTe;
    public int jTf;
    public int jTg;
    public boolean jTh;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jTi;
    }
}
