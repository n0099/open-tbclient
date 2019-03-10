package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static BdUniqueId hLS = BdUniqueId.gen();
    public int hLO;
    public int hLP;
    public int hLQ;
    public boolean hLR;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hLS;
    }
}
