package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
public class s extends bd {
    public static final BdUniqueId gHR = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gHS;
    private m gHT;

    public boolean bws() {
        return this.gHS;
    }

    public String bwt() {
        return this.fortune_desc;
    }

    public m bwu() {
        return this.gHT;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gHR;
    }
}
