package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    private ForumData jSl;
    private final boolean nve;

    public o(ForumData forumData, boolean z) {
        this.jSl = forumData;
        this.nve = z;
    }

    public ForumData bCk() {
        return this.jSl;
    }

    public boolean dMH() {
        return this.nve;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return null;
    }
}
