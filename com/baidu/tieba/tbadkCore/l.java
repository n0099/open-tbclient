package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class l implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId nvd = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> jxq;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nvd;
    }

    public List<FeedForumData> dMM() {
        return this.jxq;
    }

    public void fR(List<FeedForumData> list) {
        this.jxq = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
