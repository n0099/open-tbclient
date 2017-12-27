package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class w extends be {
    public static final BdUniqueId hhM = BdUniqueId.gen();
    private bg hhN;
    private bj hhO;
    private boolean hhP = false;

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return hhM;
    }

    public boolean bBC() {
        return this.hhP;
    }

    public bg bBD() {
        return this.hhN;
    }

    public bj bBE() {
        return this.hhO;
    }
}
