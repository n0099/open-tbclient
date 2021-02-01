package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long lHZ;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void hr(long j) {
        this.lHZ = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void u(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void Fq(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId dkK() {
        return this.mPageId;
    }

    public int dkL() {
        return this.source;
    }

    public long dkM() {
        return this.lHZ;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
