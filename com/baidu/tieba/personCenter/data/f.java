package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static BdUniqueId ghX = BdUniqueId.gen();
    public UserData fDO;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return ghX;
    }
}
