package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class l implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId nkU = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> jrw;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nkU;
    }

    public List<FeedForumData> dKt() {
        return this.jrw;
    }

    public void fT(List<FeedForumData> list) {
        this.jrw = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
