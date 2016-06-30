package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId eVb = BdUniqueId.gen();
    private List<FeedForumData> bLJ;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eVb;
    }

    public List<FeedForumData> baj() {
        return this.bLJ;
    }

    public void cF(List<FeedForumData> list) {
        this.bLJ = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
