package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public class q extends bh {
    public static final BdUniqueId goc = BdUniqueId.gen();
    private String fortune_desc;
    private boolean goe;
    private k gof;

    public boolean btJ() {
        return this.goe;
    }

    public String btK() {
        return this.fortune_desc;
    }

    public k btL() {
        return this.gof;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return goc;
    }
}
