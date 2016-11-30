package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId fzH = BdUniqueId.gen();
    private List<FeedForumData> cca;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fzH;
    }

    public List<FeedForumData> bkf() {
        return this.cca;
    }

    public void db(List<FeedForumData> list) {
        this.cca = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
