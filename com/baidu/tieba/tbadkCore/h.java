package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId fzx = BdUniqueId.gen();
    private List<FeedForumData> cbh;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fzx;
    }

    public List<FeedForumData> bgh() {
        return this.cbh;
    }

    public void cw(List<FeedForumData> list) {
        this.cbh = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
