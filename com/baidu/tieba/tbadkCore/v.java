package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class v extends bd {
    public static final BdUniqueId gym = BdUniqueId.gen();
    private bf gyn;
    private bi gyo;
    private boolean gyp = false;

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gym;
    }

    public boolean bvG() {
        return this.gyp;
    }

    public bf bvH() {
        return this.gyn;
    }

    public bi bvI() {
        return this.gyo;
    }
}
