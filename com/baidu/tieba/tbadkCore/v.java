package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class v extends bb {
    public static final BdUniqueId hnE = BdUniqueId.gen();
    private boolean bQS = false;
    private bd hnF;
    private bg hnG;

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return hnE;
    }

    public boolean aLi() {
        return this.bQS;
    }

    public bd bDE() {
        return this.hnF;
    }

    public bg bDF() {
        return this.hnG;
    }
}
