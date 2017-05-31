package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.br;
/* loaded from: classes.dex */
public class ad extends bl {
    public static final BdUniqueId fBi = BdUniqueId.gen();
    private bo fBj;
    private br fBk;
    private boolean fBl = false;

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fBi;
    }

    public boolean bhx() {
        return this.fBl;
    }

    public bo bhy() {
        return this.fBj;
    }

    public br bhz() {
        return this.fBk;
    }
}
