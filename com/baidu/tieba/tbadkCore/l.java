package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes8.dex */
public class l implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId kQF = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> hke;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kQF;
    }

    public List<FeedForumData> cVB() {
        return this.hke;
    }

    public void es(List<FeedForumData> list) {
        this.hke = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
