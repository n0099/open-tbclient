package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class e extends bl {
    public static final BdUniqueId bDq = BdUniqueId.gen();
    public static final BdUniqueId fcC = BdUniqueId.gen();
    public long fcA;
    public boolean fcD;

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.fcD ? fcC : bDq;
    }
}
