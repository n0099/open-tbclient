package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId dEG = BdUniqueId.gen();
    private List<FeedForumData> bfO;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dEG;
    }

    public List<FeedForumData> aDJ() {
        return this.bfO;
    }

    public void bK(List<FeedForumData> list) {
        this.bfO = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
