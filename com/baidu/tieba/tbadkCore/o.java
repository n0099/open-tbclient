package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.q {
    private ForumData iWP;
    private final boolean mCR;

    public o(ForumData forumData, boolean z) {
        this.iWP = forumData;
        this.mCR = z;
    }

    public ForumData bwh() {
        return this.iWP;
    }

    public boolean dDD() {
        return this.mCR;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return null;
    }
}
