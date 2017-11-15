package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class u extends bh {
    public static final BdUniqueId gpu = BdUniqueId.gen();
    private bi gpv;
    private bl gpw;
    private boolean gpx = false;

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gpu;
    }

    public boolean btY() {
        return this.gpx;
    }

    public bi btZ() {
        return this.gpv;
    }

    public bl bua() {
        return this.gpw;
    }
}
