package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long lkU;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void gJ(long j) {
        this.lkU = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void t(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void Fy(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId dhV() {
        return this.mPageId;
    }

    public int dhW() {
        return this.source;
    }

    public long dhX() {
        return this.lkU;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
