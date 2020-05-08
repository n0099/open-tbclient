package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long jlA;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void fc(long j) {
        this.jlA = j;
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

    public BdUniqueId cvb() {
        return this.mPageId;
    }

    public int cvc() {
        return this.source;
    }

    public long cvd() {
        return this.jlA;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
