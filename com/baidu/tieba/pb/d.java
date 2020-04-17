package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long jlw;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void fc(long j) {
        this.jlw = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void r(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void zf(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId cve() {
        return this.mPageId;
    }

    public int cvf() {
        return this.source;
    }

    public long cvg() {
        return this.jlw;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
