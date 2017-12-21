package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
public class r extends bd {
    public static final BdUniqueId gAN = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gAO;
    private l gAP;

    public boolean bwk() {
        return this.gAO;
    }

    public String bwl() {
        return this.fortune_desc;
    }

    public l bwm() {
        return this.gAP;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gAN;
    }
}
