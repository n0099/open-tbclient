package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class f implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId gfi = BdUniqueId.gen();
    private List<FeedForumData> cqz;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gfi;
    }

    public List<FeedForumData> bqw() {
        return this.cqz;
    }

    public void dg(List<FeedForumData> list) {
        this.cqz = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
