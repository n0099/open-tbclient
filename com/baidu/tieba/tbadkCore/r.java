package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
public class r extends bd {
    public static final BdUniqueId gxZ = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gya;
    private l gyb;

    public boolean bvD() {
        return this.gya;
    }

    public String bvE() {
        return this.fortune_desc;
    }

    public l bvF() {
        return this.gyb;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gxZ;
    }
}
