package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes.dex */
public class s extends bb {
    public static final BdUniqueId hdn = BdUniqueId.gen();
    private String fortune_desc;
    private boolean hdo;
    private m hdp;

    public boolean bAP() {
        return this.hdo;
    }

    public String bAQ() {
        return this.fortune_desc;
    }

    public m bAR() {
        return this.hdp;
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return hdn;
    }
}
