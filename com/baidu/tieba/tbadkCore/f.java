package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class f implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId gfC = BdUniqueId.gen();
    private List<FeedForumData> cxL;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gfC;
    }

    public List<FeedForumData> bqm() {
        return this.cxL;
    }

    public void dg(List<FeedForumData> list) {
        this.cxL = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
