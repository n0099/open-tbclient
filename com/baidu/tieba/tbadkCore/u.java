package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
/* loaded from: classes.dex */
public class u extends bk {
    public static final BdUniqueId ftd = BdUniqueId.gen();
    private String fortune_desc;
    private boolean fte;
    private o ftf;

    public boolean bfX() {
        return this.fte;
    }

    public String bfY() {
        return this.fortune_desc;
    }

    public o bfZ() {
        return this.ftf;
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ftd;
    }
}
