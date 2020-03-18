package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes8.dex */
public class l implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId kgw = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> gAC;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kgw;
    }

    public List<FeedForumData> cKI() {
        return this.gAC;
    }

    public void ed(List<FeedForumData> list) {
        this.gAC = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
