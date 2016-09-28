package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId fsx = BdUniqueId.gen();
    private List<FeedForumData> bYI;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fsx;
    }

    public List<FeedForumData> bhJ() {
        return this.bYI;
    }

    public void cX(List<FeedForumData> list) {
        this.bYI = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
