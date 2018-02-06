package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.data.b implements i {
    public static BdUniqueId gjt = BdUniqueId.gen();

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gjt;
    }
}
