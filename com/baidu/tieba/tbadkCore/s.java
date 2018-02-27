package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
public class s extends bd {
    public static final BdUniqueId gZy = BdUniqueId.gen();
    private String fortune_desc;
    private m gZA;
    private boolean gZz;

    public boolean bwn() {
        return this.gZz;
    }

    public String bwo() {
        return this.fortune_desc;
    }

    public m bwp() {
        return this.gZA;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gZy;
    }
}
