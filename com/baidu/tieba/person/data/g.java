package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class g extends a {
    public static final BdUniqueId dbN = BdUniqueId.gen();

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dbN;
    }
}
