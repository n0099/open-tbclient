package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static BdUniqueId idF = BdUniqueId.gen();
    public int idB;
    public int idC;
    public int idD;
    public boolean idE;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return idF;
    }
}
