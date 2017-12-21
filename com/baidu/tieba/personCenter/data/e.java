package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fte = BdUniqueId.gen();
    public UserData ePx;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fte;
    }
}
