package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import tbclient.ForumRuleStatus;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    private ForumData jSl;
    private ForumRuleStatus nvf;

    public p(ForumData forumData, ForumRuleStatus forumRuleStatus) {
        this.jSl = forumData;
        this.nvf = forumRuleStatus;
    }

    public ForumRuleStatus dMI() {
        return this.nvf;
    }

    public void b(ForumRuleStatus forumRuleStatus) {
        this.nvf = forumRuleStatus;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return null;
    }
}
