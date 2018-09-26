package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes.dex */
public class s extends bb {
    public static final BdUniqueId gUu = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gUv;
    private m gUw;

    public boolean bye() {
        return this.gUv;
    }

    public String byf() {
        return this.fortune_desc;
    }

    public m byg() {
        return this.gUw;
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gUu;
    }
}
