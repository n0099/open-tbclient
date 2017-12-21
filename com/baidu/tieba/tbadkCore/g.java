package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class g implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId gzi = BdUniqueId.gen();
    private List<FeedForumData> cQQ;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gzi;
    }

    public List<FeedForumData> buN() {
        return this.cQQ;
    }

    public void dr(List<FeedForumData> list) {
        this.cQQ = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
