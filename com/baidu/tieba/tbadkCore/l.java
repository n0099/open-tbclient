package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes20.dex */
public class l implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId mVV = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> iWc;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mVV;
    }

    public List<FeedForumData> dJb() {
        return this.iWc;
    }

    public void fG(List<FeedForumData> list) {
        this.iWc = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
