package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class f implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId gdO = BdUniqueId.gen();
    private List<FeedForumData> czj;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return gdO;
    }

    public List<FeedForumData> bpl() {
        return this.czj;
    }

    public void de(List<FeedForumData> list) {
        this.czj = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
