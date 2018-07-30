package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes.dex */
public class s extends bb {
    public static final BdUniqueId gMP = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gMQ;
    private m gMR;

    public boolean bvx() {
        return this.gMQ;
    }

    public String bvy() {
        return this.fortune_desc;
    }

    public m bvz() {
        return this.gMR;
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gMP;
    }
}
