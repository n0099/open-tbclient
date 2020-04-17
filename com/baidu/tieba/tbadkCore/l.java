package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes8.dex */
public class l implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId kQB = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> hjY;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kQB;
    }

    public List<FeedForumData> cVE() {
        return this.hjY;
    }

    public void es(List<FeedForumData> list) {
        this.hjY = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
