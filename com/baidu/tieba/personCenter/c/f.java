package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static BdUniqueId faH = BdUniqueId.gen();
    public UserData eyy;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return faH;
    }
}
