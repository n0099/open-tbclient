package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long kuP;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void fG(long j) {
        this.kuP = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void u(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void DL(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId cUX() {
        return this.mPageId;
    }

    public int cUY() {
        return this.source;
    }

    public long cUZ() {
        return this.kuP;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
