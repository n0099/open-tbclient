package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.q {
    private ForumData jjm;
    private final boolean mPA;

    public o(ForumData forumData, boolean z) {
        this.jjm = forumData;
        this.mPA = z;
    }

    public ForumData bya() {
        return this.jjm;
    }

    public boolean dGL() {
        return this.mPA;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return null;
    }
}
