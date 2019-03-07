package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iEu = BdUniqueId.gen();
    private List<FeedForumData> fjG;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iEu;
    }

    public List<FeedForumData> cdy() {
        return this.fjG;
    }

    public void dU(List<FeedForumData> list) {
        this.fjG = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
