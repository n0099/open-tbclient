package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iDY = BdUniqueId.gen();
    private List<FeedForumData> fjr;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iDY;
    }

    public List<FeedForumData> cdx() {
        return this.fjr;
    }

    public void dR(List<FeedForumData> list) {
        this.fjr = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
