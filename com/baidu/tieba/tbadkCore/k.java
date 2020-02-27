package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes8.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId keG = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> gzq;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return keG;
    }

    public List<FeedForumData> cKl() {
        return this.gzq;
    }

    public void ed(List<FeedForumData> list) {
        this.gzq = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
