package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class l implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId npB = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> jwc;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return npB;
    }

    public List<FeedForumData> dOl() {
        return this.jwc;
    }

    public void fT(List<FeedForumData> list) {
        this.jwc = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
