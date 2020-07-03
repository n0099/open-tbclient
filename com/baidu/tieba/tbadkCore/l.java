package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes8.dex */
public class l implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId lDZ = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> hMN;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lDZ;
    }

    public List<FeedForumData> dhk() {
        return this.hMN;
    }

    public void eP(List<FeedForumData> list) {
        this.hMN = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
