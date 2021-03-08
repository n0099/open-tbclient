package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    private ForumData jUi;
    private final boolean nxI;

    public o(ForumData forumData, boolean z) {
        this.jUi = forumData;
        this.nxI = z;
    }

    public ForumData bCn() {
        return this.jUi;
    }

    public boolean dMX() {
        return this.nxI;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return null;
    }
}
