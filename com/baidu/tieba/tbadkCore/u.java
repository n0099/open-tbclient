package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bm;
/* loaded from: classes.dex */
public class u extends bm {
    public static final BdUniqueId fKY = BdUniqueId.gen();
    private boolean fKZ;
    private o fLa;
    private String fortune_desc;

    public boolean blI() {
        return this.fKZ;
    }

    public String blJ() {
        return this.fortune_desc;
    }

    public o blK() {
        return this.fLa;
    }

    @Override // com.baidu.tbadk.core.data.bm, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fKY;
    }
}
