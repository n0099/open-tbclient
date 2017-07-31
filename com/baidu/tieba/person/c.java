package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fdL = BdUniqueId.gen();
    public long fdM;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fdL;
    }
}
