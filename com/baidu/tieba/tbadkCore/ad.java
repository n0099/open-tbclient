package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.data.bs;
/* loaded from: classes.dex */
public class ad extends bm {
    public static final BdUniqueId fLm = BdUniqueId.gen();
    private bp fLn;
    private bs fLo;
    private boolean fLp = false;

    @Override // com.baidu.tbadk.core.data.bm, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fLm;
    }

    public boolean blL() {
        return this.fLp;
    }

    public bp blM() {
        return this.fLn;
    }

    public bs blN() {
        return this.fLo;
    }
}
