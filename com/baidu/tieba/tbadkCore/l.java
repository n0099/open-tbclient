package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes15.dex */
public class l implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId mda = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> igW;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mda;
    }

    public List<FeedForumData> dvR() {
        return this.igW;
    }

    public void fd(List<FeedForumData> list) {
        this.igW = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
