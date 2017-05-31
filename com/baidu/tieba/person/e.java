package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class e extends bl {
    public static final BdUniqueId bwx = BdUniqueId.gen();
    public static final BdUniqueId eGt = BdUniqueId.gen();
    public long eGr;
    public boolean eGu;

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return this.eGu ? eGt : bwx;
    }
}
