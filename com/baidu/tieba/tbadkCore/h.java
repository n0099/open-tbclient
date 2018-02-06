package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId gYh = BdUniqueId.gen();
    private List<FeedForumData> dNC;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gYh;
    }

    public List<FeedForumData> buN() {
        return this.dNC;
    }

    public void dn(List<FeedForumData> list) {
        this.dNC = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
