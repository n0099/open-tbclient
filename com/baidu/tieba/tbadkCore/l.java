package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes15.dex */
public class l implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId mdp = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> ihc;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mdp;
    }

    public List<FeedForumData> dvW() {
        return this.ihc;
    }

    public void fd(List<FeedForumData> list) {
        this.ihc = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
