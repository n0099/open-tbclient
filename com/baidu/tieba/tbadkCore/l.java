package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes21.dex */
public class l implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId njT = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> jjB;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return njT;
    }

    public List<FeedForumData> dOr() {
        return this.jjB;
    }

    public void fU(List<FeedForumData> list) {
        this.jjB = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
