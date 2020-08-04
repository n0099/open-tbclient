package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes15.dex */
public class l implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId lLq = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> hSO;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lLq;
    }

    public List<FeedForumData> dku() {
        return this.hSO;
    }

    public void eV(List<FeedForumData> list) {
        this.hSO = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
