package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long hFZ;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void dG(long j) {
        this.hFZ = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void wj(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId bQf() {
        return this.mPageId;
    }

    public int bQg() {
        return this.source;
    }

    public long bQh() {
        return this.hFZ;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
