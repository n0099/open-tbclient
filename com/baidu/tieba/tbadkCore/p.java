package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class p extends bl {
    public static final BdUniqueId gfv = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gfw;
    private j gfx;

    public boolean brF() {
        return this.gfw;
    }

    public String brG() {
        return this.fortune_desc;
    }

    public j brH() {
        return this.gfx;
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gfv;
    }
}
