package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes8.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId keU = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> gzE;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return keU;
    }

    public List<FeedForumData> cKo() {
        return this.gzE;
    }

    public void ed(List<FeedForumData> list) {
        this.gzE = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
