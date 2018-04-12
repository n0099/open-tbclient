package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
public class s extends bd {
    public static final BdUniqueId gvr = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gvs;
    private m gvt;

    public boolean brs() {
        return this.gvs;
    }

    public String brt() {
        return this.fortune_desc;
    }

    public m bru() {
        return this.gvt;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gvr;
    }
}
