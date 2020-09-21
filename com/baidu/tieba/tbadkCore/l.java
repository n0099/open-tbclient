package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes20.dex */
public class l implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId mmO = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> ioe;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mmO;
    }

    public List<FeedForumData> dzP() {
        return this.ioe;
    }

    public void fm(List<FeedForumData> list) {
        this.ioe = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
