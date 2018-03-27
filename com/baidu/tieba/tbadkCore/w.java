package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class w extends bd {
    public static final BdUniqueId hag = BdUniqueId.gen();
    private boolean cdw = false;
    private bf hah;
    private bi hai;

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return hag;
    }

    public boolean bwv() {
        return this.cdw;
    }

    public bf bww() {
        return this.hah;
    }

    public bi bwx() {
        return this.hai;
    }
}
