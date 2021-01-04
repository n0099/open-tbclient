package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    private ForumData jPU;
    private final boolean nqd;

    public o(ForumData forumData, boolean z) {
        this.jPU = forumData;
        this.nqd = z;
    }

    public ForumData bFK() {
        return this.jPU;
    }

    public boolean dOn() {
        return this.nqd;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return null;
    }
}
