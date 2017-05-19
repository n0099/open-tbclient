package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId frH = BdUniqueId.gen();
    private List<FeedForumData> bVg;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return frH;
    }

    public List<FeedForumData> beN() {
        return this.bVg;
    }

    public void ct(List<FeedForumData> list) {
        this.bVg = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
