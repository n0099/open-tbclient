package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public class v extends bc {
    public static final BdUniqueId gMd = BdUniqueId.gen();
    private boolean bxm = false;
    private be gMe;
    private bh gMf;

    @Override // com.baidu.tbadk.core.data.bc, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gMd;
    }

    public boolean bwW() {
        return this.bxm;
    }

    public be bwX() {
        return this.gMe;
    }

    public bh bwY() {
        return this.gMf;
    }
}
