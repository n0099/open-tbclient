package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bn;
/* loaded from: classes.dex */
public class t extends bj {
    public static final BdUniqueId gij = BdUniqueId.gen();
    private bk gik;
    private bn gil;
    private boolean gim = false;

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gij;
    }

    public boolean brQ() {
        return this.gim;
    }

    public bk brR() {
        return this.gik;
    }

    public bn brS() {
        return this.gil;
    }
}
