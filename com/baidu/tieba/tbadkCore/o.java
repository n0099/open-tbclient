package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.q {
    private ForumData jpk;
    private final boolean mVD;

    public o(ForumData forumData, boolean z) {
        this.jpk = forumData;
        this.mVD = z;
    }

    public ForumData bAz() {
        return this.jpk;
    }

    public boolean dJn() {
        return this.mVD;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return null;
    }
}
