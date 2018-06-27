package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fUG = BdUniqueId.gen();
    public UserData fso;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fUG;
    }
}
