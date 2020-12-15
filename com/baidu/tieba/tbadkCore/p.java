package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import tbclient.ForumRuleStatus;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.q {
    private ForumData jDs;
    private ForumRuleStatus nkw;

    public p(ForumData forumData, ForumRuleStatus forumRuleStatus) {
        this.jDs = forumData;
        this.nkw = forumRuleStatus;
    }

    public ForumRuleStatus dOw() {
        return this.nkw;
    }

    public void b(ForumRuleStatus forumRuleStatus) {
        this.nkw = forumRuleStatus;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return null;
    }
}
