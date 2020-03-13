package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long izQ;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void er(long j) {
        this.izQ = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void r(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void yw(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId ckf() {
        return this.mPageId;
    }

    public int ckg() {
        return this.source;
    }

    public long ckh() {
        return this.izQ;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
