package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    private ForumData jPU;
    private final boolean nqc;

    public o(ForumData forumData, boolean z) {
        this.jPU = forumData;
        this.nqc = z;
    }

    public ForumData bFL() {
        return this.jPU;
    }

    public boolean dOo() {
        return this.nqc;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return null;
    }
}
