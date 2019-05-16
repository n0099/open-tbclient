package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long hzf;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void dZ(long j) {
        this.hzf = j;
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

    public BdUniqueId bPs() {
        return this.mPageId;
    }

    public int getSource() {
        return this.source;
    }

    public long bPt() {
        return this.hzf;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
