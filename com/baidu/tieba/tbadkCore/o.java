package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.q {
    private ForumData jDq;
    private final boolean nkt;

    public o(ForumData forumData, boolean z) {
        this.jDq = forumData;
        this.nkt = z;
    }

    public ForumData bDp() {
        return this.jDq;
    }

    public boolean dOu() {
        return this.nkt;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return null;
    }
}
