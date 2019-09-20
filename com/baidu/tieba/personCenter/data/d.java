package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static BdUniqueId imX = BdUniqueId.gen();
    public int imT;
    public int imU;
    public int imV;
    public boolean imW;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return imX;
    }
}
