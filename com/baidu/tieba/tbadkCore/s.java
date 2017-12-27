package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.be;
/* loaded from: classes.dex */
public class s extends be {
    public static final BdUniqueId hhz = BdUniqueId.gen();
    private String fortune_desc;
    private boolean hhA;
    private m hhB;

    public boolean bBz() {
        return this.hhA;
    }

    public String bBA() {
        return this.fortune_desc;
    }

    public m bBB() {
        return this.hhB;
    }

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return hhz;
    }
}
