package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes.dex */
public class s extends bb {
    public static final BdUniqueId gMR = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gMS;
    private m gMT;

    public boolean bvy() {
        return this.gMS;
    }

    public String bvz() {
        return this.fortune_desc;
    }

    public m bvA() {
        return this.gMT;
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gMR;
    }
}
