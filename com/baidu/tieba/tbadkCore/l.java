package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes21.dex */
public class l implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId mCq = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> iCX;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mCq;
    }

    public List<FeedForumData> dDA() {
        return this.iCX;
    }

    public void fp(List<FeedForumData> list) {
        this.iCX = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
