package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bm;
/* loaded from: classes.dex */
public class e extends bm {
    public static final BdUniqueId bzk = BdUniqueId.gen();
    public static final BdUniqueId eQb = BdUniqueId.gen();
    public long ePZ;
    public boolean eQc;

    @Override // com.baidu.tbadk.core.data.bm, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return this.eQc ? eQb : bzk;
    }
}
