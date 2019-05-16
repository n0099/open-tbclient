package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iWM = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> fzM;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iWM;
    }

    public List<FeedForumData> clC() {
        return this.fzM;
    }

    public void eb(List<FeedForumData> list) {
        this.fzM = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
