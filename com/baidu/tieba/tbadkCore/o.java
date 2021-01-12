package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    private ForumData jLo;
    private final boolean nlv;

    public o(ForumData forumData, boolean z) {
        this.jLo = forumData;
        this.nlv = z;
    }

    public ForumData bBS() {
        return this.jLo;
    }

    public boolean dKw() {
        return this.nlv;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return null;
    }
}
