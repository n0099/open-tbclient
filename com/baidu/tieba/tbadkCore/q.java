package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public class q extends bh {
    public static final BdUniqueId gpg = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gph;
    private k gpi;

    public boolean btV() {
        return this.gph;
    }

    public String btW() {
        return this.fortune_desc;
    }

    public k btX() {
        return this.gpi;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gpg;
    }
}
