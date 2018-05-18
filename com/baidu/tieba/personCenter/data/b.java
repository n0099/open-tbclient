package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fEW = BdUniqueId.gen();
    public int fES;
    public int fET;
    public int fEU;
    public boolean fEV;
    public UserData fcZ;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fEW;
    }
}
