package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bp;
/* loaded from: classes.dex */
public class t extends bl {
    public static final BdUniqueId ggU = BdUniqueId.gen();
    private bm ggV;
    private bp ggW;
    private boolean ggX = false;

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return ggU;
    }

    public boolean brP() {
        return this.ggX;
    }

    public bm brQ() {
        return this.ggV;
    }

    public bp brR() {
        return this.ggW;
    }
}
