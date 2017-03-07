package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId frB = BdUniqueId.gen();
    private List<FeedForumData> bVd;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return frB;
    }

    public List<FeedForumData> bfv() {
        return this.bVd;
    }

    public void cD(List<FeedForumData> list) {
        this.bVd = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
