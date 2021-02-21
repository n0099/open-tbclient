package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import tbclient.ForumRuleStatus;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    private ForumData jSz;
    private ForumRuleStatus nvF;

    public p(ForumData forumData, ForumRuleStatus forumRuleStatus) {
        this.jSz = forumData;
        this.nvF = forumRuleStatus;
    }

    public ForumRuleStatus dMQ() {
        return this.nvF;
    }

    public void b(ForumRuleStatus forumRuleStatus) {
        this.nvF = forumRuleStatus;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return null;
    }
}
