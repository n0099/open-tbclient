package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class e extends bl {
    public static final BdUniqueId bEA = BdUniqueId.gen();
    public static final BdUniqueId fdO = BdUniqueId.gen();
    public long fdM;
    public boolean fdP;

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.fdP ? fdO : bEA;
    }
}
