package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class e extends bj {
    public static final BdUniqueId bIe = BdUniqueId.gen();
    public static final BdUniqueId fea = BdUniqueId.gen();
    public long fdY;
    public boolean feb;

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.feb ? fea : bIe;
    }
}
