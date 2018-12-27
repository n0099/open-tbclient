package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes5.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static BdUniqueId guM = BdUniqueId.gen();
    public UserData fSM;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return guM;
    }
}
