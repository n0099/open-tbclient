package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long lKp;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void hr(long j) {
        this.lKp = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void v(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void Ft(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId dla() {
        return this.mPageId;
    }

    public int dlb() {
        return this.source;
    }

    public long dlc() {
        return this.lKp;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
