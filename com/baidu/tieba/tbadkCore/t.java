package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
public class t extends bd {
    public static final BdUniqueId gZV = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gZW;
    private n gZX;

    public boolean bws() {
        return this.gZW;
    }

    public String bwt() {
        return this.fortune_desc;
    }

    public n bwu() {
        return this.gZX;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gZV;
    }
}
