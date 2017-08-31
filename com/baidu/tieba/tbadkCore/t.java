package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bn;
/* loaded from: classes.dex */
public class t extends bj {
    public static final BdUniqueId gho = BdUniqueId.gen();
    private bk ghp;
    private bn ghq;
    private boolean ghr = false;

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gho;
    }

    public boolean brF() {
        return this.ghr;
    }

    public bk brG() {
        return this.ghp;
    }

    public bn brH() {
        return this.ghq;
    }
}
