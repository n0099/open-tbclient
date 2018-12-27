package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes.dex */
public class s extends bb {
    public static final BdUniqueId hns = BdUniqueId.gen();
    private String fortune_desc;
    private boolean hnt;
    private m hnu;

    public boolean bDB() {
        return this.hnt;
    }

    public String bDC() {
        return this.fortune_desc;
    }

    public m bDD() {
        return this.hnu;
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return hns;
    }
}
