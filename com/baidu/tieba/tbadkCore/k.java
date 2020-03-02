package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes8.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId keI = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> gzs;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return keI;
    }

    public List<FeedForumData> cKn() {
        return this.gzs;
    }

    public void ed(List<FeedForumData> list) {
        this.gzs = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
