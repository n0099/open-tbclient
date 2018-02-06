package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
public class s extends bd {
    public static final BdUniqueId gZN = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gZO;
    private m gZP;

    public boolean bwo() {
        return this.gZO;
    }

    public String bwp() {
        return this.fortune_desc;
    }

    public m bwq() {
        return this.gZP;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gZN;
    }
}
