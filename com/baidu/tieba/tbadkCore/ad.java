package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.bq;
/* loaded from: classes.dex */
public class ad extends bk {
    public static final BdUniqueId ftr = BdUniqueId.gen();
    private bn fts;
    private bq ftt;
    private boolean ftu = false;

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ftr;
    }

    public boolean bga() {
        return this.ftu;
    }

    public bn bgb() {
        return this.fts;
    }

    public bq bgc() {
        return this.ftt;
    }
}
