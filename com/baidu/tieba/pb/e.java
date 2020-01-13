package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class e {
    private long forumId;
    private long ixH;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void er(long j) {
        this.ixH = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void r(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void yp(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId ciy() {
        return this.mPageId;
    }

    public int ciz() {
        return this.source;
    }

    public long ciA() {
        return this.ixH;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
