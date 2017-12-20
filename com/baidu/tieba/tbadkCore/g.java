package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class g implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId gzd = BdUniqueId.gen();
    private List<FeedForumData> cQM;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gzd;
    }

    public List<FeedForumData> buM() {
        return this.cQM;
    }

    public void dr(List<FeedForumData> list) {
        this.cQM = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
