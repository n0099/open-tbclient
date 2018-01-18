package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
public class s extends bd {
    public static final BdUniqueId gXa = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gXb;
    private m gXc;

    public boolean buV() {
        return this.gXb;
    }

    public String buW() {
        return this.fortune_desc;
    }

    public m buX() {
        return this.gXc;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gXa;
    }
}
