package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class w extends bj {
    public static final BdUniqueId fsY = BdUniqueId.gen();
    private String fortune_desc;
    private boolean fsZ;
    private o fta;

    public boolean bgO() {
        return this.fsZ;
    }

    public void ld(boolean z) {
        this.fsZ = z;
    }

    public String bgP() {
        return this.fortune_desc;
    }

    public void pH(String str) {
        this.fortune_desc = str;
    }

    public o bgQ() {
        return this.fta;
    }

    public void b(o oVar) {
        this.fta = oVar;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fsY;
    }
}
