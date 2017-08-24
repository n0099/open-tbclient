package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class p extends bl {
    public static final BdUniqueId giz = BdUniqueId.gen();
    private String fortune_desc;
    private boolean giA;
    private j giB;

    public boolean bsn() {
        return this.giA;
    }

    public String bso() {
        return this.fortune_desc;
    }

    public j bsp() {
        return this.giB;
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return giz;
    }
}
