package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
public class s extends bd {
    public static final BdUniqueId gXu = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gXv;
    private m gXw;

    public boolean buX() {
        return this.gXv;
    }

    public String buY() {
        return this.fortune_desc;
    }

    public m buZ() {
        return this.gXw;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gXu;
    }
}
