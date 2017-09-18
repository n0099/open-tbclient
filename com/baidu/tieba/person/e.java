package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class e extends bj {
    public static final BdUniqueId bIV = BdUniqueId.gen();
    public static final BdUniqueId feT = BdUniqueId.gen();
    public long feR;
    public boolean feU;

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.feU ? feT : bIV;
    }
}
