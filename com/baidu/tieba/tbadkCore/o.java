package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.q {
    private ForumData jpQ;
    private final boolean mWv;

    public o(ForumData forumData, boolean z) {
        this.jpQ = forumData;
        this.mWv = z;
    }

    public ForumData bzP() {
        return this.jpQ;
    }

    public boolean dJe() {
        return this.mWv;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return null;
    }
}
