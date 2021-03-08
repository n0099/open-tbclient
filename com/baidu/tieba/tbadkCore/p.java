package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import tbclient.ForumRuleStatus;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    private ForumData jUi;
    private ForumRuleStatus nxJ;

    public p(ForumData forumData, ForumRuleStatus forumRuleStatus) {
        this.jUi = forumData;
        this.nxJ = forumRuleStatus;
    }

    public ForumRuleStatus dMY() {
        return this.nxJ;
    }

    public void b(ForumRuleStatus forumRuleStatus) {
        this.nxJ = forumRuleStatus;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return null;
    }
}
