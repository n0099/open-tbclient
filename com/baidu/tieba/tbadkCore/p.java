package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import tbclient.ForumRuleStatus;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.q {
    private ForumData jDq;
    private ForumRuleStatus nku;

    public p(ForumData forumData, ForumRuleStatus forumRuleStatus) {
        this.jDq = forumData;
        this.nku = forumRuleStatus;
    }

    public ForumRuleStatus dOv() {
        return this.nku;
    }

    public void b(ForumRuleStatus forumRuleStatus) {
        this.nku = forumRuleStatus;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return null;
    }
}
