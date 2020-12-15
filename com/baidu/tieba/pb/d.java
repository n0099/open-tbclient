package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long lyM;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void hr(long j) {
        this.lyM = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void t(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void GL(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId dmF() {
        return this.mPageId;
    }

    public int dmG() {
        return this.source;
    }

    public long dmH() {
        return this.lyM;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
