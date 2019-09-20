package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long hIk;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void em(long j) {
        this.hIk = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void p(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void xE(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId bTi() {
        return this.mPageId;
    }

    public int getSource() {
        return this.source;
    }

    public long bTj() {
        return this.hIk;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
