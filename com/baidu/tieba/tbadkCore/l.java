package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class l implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId nuD = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> jxc;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nuD;
    }

    public List<FeedForumData> dME() {
        return this.jxc;
    }

    public void fR(List<FeedForumData> list) {
        this.jxc = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
