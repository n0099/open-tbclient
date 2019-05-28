package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long hzi;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void dZ(long j) {
        this.hzi = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void p(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void setSource(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId bPv() {
        return this.mPageId;
    }

    public int getSource() {
        return this.source;
    }

    public long bPw() {
        return this.hzi;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
