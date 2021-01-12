package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import tbclient.ForumRuleStatus;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    private ForumData jLo;
    private ForumRuleStatus nlw;

    public p(ForumData forumData, ForumRuleStatus forumRuleStatus) {
        this.jLo = forumData;
        this.nlw = forumRuleStatus;
    }

    public ForumRuleStatus dKx() {
        return this.nlw;
    }

    public void b(ForumRuleStatus forumRuleStatus) {
        this.nlw = forumRuleStatus;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return null;
    }
}
