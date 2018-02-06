package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static BdUniqueId gjH = BdUniqueId.gen();
    public UserData fHl;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gjH;
    }
}
