package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class v extends bb {
    public static final BdUniqueId hoK = BdUniqueId.gen();
    private boolean bRE = false;
    private bd hoL;
    private bg hoM;

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return hoK;
    }

    public boolean aLG() {
        return this.bRE;
    }

    public bd bEn() {
        return this.hoL;
    }

    public bg bEo() {
        return this.hoM;
    }
}
