package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long kfn;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void fu(long j) {
        this.kfn = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void u(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void Bs(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId cKi() {
        return this.mPageId;
    }

    public int cKj() {
        return this.source;
    }

    public long cKk() {
        return this.kfn;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
