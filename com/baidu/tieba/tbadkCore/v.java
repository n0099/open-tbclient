package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class v extends bb {
    public static final BdUniqueId hoJ = BdUniqueId.gen();
    private boolean bRD = false;
    private bd hoK;
    private bg hoL;

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return hoJ;
    }

    public boolean aLG() {
        return this.bRD;
    }

    public bd bEn() {
        return this.hoK;
    }

    public bg bEo() {
        return this.hoL;
    }
}
