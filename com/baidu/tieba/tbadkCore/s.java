package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes.dex */
public class s extends bb {
    public static final BdUniqueId hbP = BdUniqueId.gen();
    private String fortune_desc;
    private boolean hbQ;
    private m hbR;

    public boolean bBt() {
        return this.hbQ;
    }

    public String bBu() {
        return this.fortune_desc;
    }

    public m bBv() {
        return this.hbR;
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return hbP;
    }
}
