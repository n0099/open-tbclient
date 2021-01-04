package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import tbclient.ForumRuleStatus;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    private ForumData jPU;
    private ForumRuleStatus nqe;

    public p(ForumData forumData, ForumRuleStatus forumRuleStatus) {
        this.jPU = forumData;
        this.nqe = forumRuleStatus;
    }

    public ForumRuleStatus dOo() {
        return this.nqe;
    }

    public void b(ForumRuleStatus forumRuleStatus) {
        this.nqe = forumRuleStatus;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return null;
    }
}
