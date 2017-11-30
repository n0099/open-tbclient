package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class g implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId gwv = BdUniqueId.gen();
    private List<FeedForumData> cQB;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gwv;
    }

    public List<FeedForumData> buh() {
        return this.cQB;
    }

    public void ds(List<FeedForumData> list) {
        this.cQB = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
