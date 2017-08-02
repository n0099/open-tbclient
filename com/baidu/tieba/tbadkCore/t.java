package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bp;
/* loaded from: classes.dex */
public class t extends bl {
    public static final BdUniqueId gfJ = BdUniqueId.gen();
    private bm gfK;
    private bp gfL;
    private boolean gfM = false;

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gfJ;
    }

    public boolean brI() {
        return this.gfM;
    }

    public bm brJ() {
        return this.gfK;
    }

    public bp brK() {
        return this.gfL;
    }
}
