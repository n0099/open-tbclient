package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class e {
    private long forumId;
    private long iud;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void em(long j) {
        this.iud = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void r(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void yk(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId chq() {
        return this.mPageId;
    }

    public int chr() {
        return this.source;
    }

    public long chs() {
        return this.iud;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
