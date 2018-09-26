package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class v extends bb {
    public static final BdUniqueId gUG = BdUniqueId.gen();
    private boolean bDI = false;
    private bd gUH;
    private bg gUI;

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gUG;
    }

    public boolean aFM() {
        return this.bDI;
    }

    public bd byh() {
        return this.gUH;
    }

    public bg byi() {
        return this.gUI;
    }
}
