package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bc;
/* loaded from: classes.dex */
public class s extends bc {
    public static final BdUniqueId gLR = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gLS;
    private m gLT;

    public boolean bwT() {
        return this.gLS;
    }

    public String bwU() {
        return this.fortune_desc;
    }

    public m bwV() {
        return this.gLT;
    }

    @Override // com.baidu.tbadk.core.data.bc, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gLR;
    }
}
