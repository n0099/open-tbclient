package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
public class s extends bd {
    public static final BdUniqueId gvo = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gvp;
    private m gvq;

    public boolean brs() {
        return this.gvp;
    }

    public String brt() {
        return this.fortune_desc;
    }

    public m bru() {
        return this.gvq;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gvo;
    }
}
