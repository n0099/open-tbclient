package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.q {
    private ForumData jDs;
    private final boolean nkv;

    public o(ForumData forumData, boolean z) {
        this.jDs = forumData;
        this.nkv = z;
    }

    public ForumData bDp() {
        return this.jDs;
    }

    public boolean dOv() {
        return this.nkv;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return null;
    }
}
