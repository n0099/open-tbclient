package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes21.dex */
public class l implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId mVd = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> iVq;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mVd;
    }

    public List<FeedForumData> dJk() {
        return this.iVq;
    }

    public void fG(List<FeedForumData> list) {
        this.iVq = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
