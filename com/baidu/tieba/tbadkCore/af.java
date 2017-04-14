package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
/* loaded from: classes.dex */
public class af extends bi {
    public static final BdUniqueId fuW = BdUniqueId.gen();
    private bl fuX;
    private bo fuY;
    private boolean fuZ = false;

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fuW;
    }

    public boolean bhC() {
        return this.fuZ;
    }

    public void lh(boolean z) {
        this.fuZ = z;
    }

    public bl bhD() {
        return this.fuX;
    }

    public void a(bl blVar) {
        this.fuX = blVar;
    }

    public bo bhE() {
        return this.fuY;
    }

    public void a(bo boVar) {
        this.fuY = boVar;
    }
}
