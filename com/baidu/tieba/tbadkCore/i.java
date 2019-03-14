package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iEn = BdUniqueId.gen();
    private List<FeedForumData> fjF;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iEn;
    }

    public List<FeedForumData> cdB() {
        return this.fjF;
    }

    public void dU(List<FeedForumData> list) {
        this.fjF = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
