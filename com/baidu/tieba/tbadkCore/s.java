package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes.dex */
public class s extends bb {
    public static final BdUniqueId hbQ = BdUniqueId.gen();
    private String fortune_desc;
    private boolean hbR;
    private m hbS;

    public boolean bBt() {
        return this.hbR;
    }

    public String bBu() {
        return this.fortune_desc;
    }

    public m bBv() {
        return this.hbS;
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return hbQ;
    }
}
