package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long jBX;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void fd(long j) {
        this.jBX = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void t(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void zP(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId cBS() {
        return this.mPageId;
    }

    public int cBT() {
        return this.source;
    }

    public long cBU() {
        return this.jBX;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
