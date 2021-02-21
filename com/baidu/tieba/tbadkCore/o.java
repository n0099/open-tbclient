package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    private ForumData jSz;
    private final boolean nvE;

    public o(ForumData forumData, boolean z) {
        this.jSz = forumData;
        this.nvE = z;
    }

    public ForumData bCk() {
        return this.jSz;
    }

    public boolean dMP() {
        return this.nvE;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return null;
    }
}
