package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes.dex */
public class s extends bb {
    public static final BdUniqueId hkh = BdUniqueId.gen();
    private String fortune_desc;
    private boolean hki;
    private m hkj;

    public boolean bCK() {
        return this.hki;
    }

    public String bCL() {
        return this.fortune_desc;
    }

    public m bCM() {
        return this.hkj;
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return hkh;
    }
}
