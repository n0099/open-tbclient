package com.baidu.tieba.pb;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d {
    private long forumId;
    private long hFw;
    private BdUniqueId mPageId;
    private int source;
    private long threadId;

    public void ej(long j) {
        this.hFw = j;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void p(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void xz(int i) {
        this.source = i;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public BdUniqueId bSh() {
        return this.mPageId;
    }

    public int getSource() {
        return this.source;
    }

    public long bSi() {
        return this.hFw;
    }

    public long getForumId() {
        return this.forumId;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
