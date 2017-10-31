package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class u extends bh {
    public static final BdUniqueId gor = BdUniqueId.gen();
    private bi gos;
    private bl got;
    private boolean gou = false;

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gor;
    }

    public boolean btM() {
        return this.gou;
    }

    public bi btN() {
        return this.gos;
    }

    public bl btO() {
        return this.got;
    }
}
