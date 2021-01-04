package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long lDS;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void hm(long j) {
        this.lDS = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void t(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void GD(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId dmp() {
        return this.mPageId;
    }

    public int dmq() {
        return this.source;
    }

    public long dmr() {
        return this.lDS;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
