package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long hGQ;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void dH(long j) {
        this.hGQ = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void wk(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId bQh() {
        return this.mPageId;
    }

    public int bQi() {
        return this.source;
    }

    public long bQj() {
        return this.hGQ;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
