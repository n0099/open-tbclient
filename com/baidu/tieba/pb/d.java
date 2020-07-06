package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long jWN;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void fg(long j) {
        this.jWN = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void t(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void AT(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId cGz() {
        return this.mPageId;
    }

    public int cGA() {
        return this.source;
    }

    public long cGB() {
        return this.jWN;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
