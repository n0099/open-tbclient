package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static BdUniqueId hLR = BdUniqueId.gen();
    public int hLN;
    public int hLO;
    public int hLP;
    public boolean hLQ;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hLR;
    }
}
