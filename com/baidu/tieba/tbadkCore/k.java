package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes5.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId jZY = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> guf;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jZY;
    }

    public List<FeedForumData> cHB() {
        return this.guf;
    }

    public void eh(List<FeedForumData> list) {
        this.guf = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
