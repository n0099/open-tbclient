package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId hfU = BdUniqueId.gen();
    private List<FeedForumData> dFH;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return hfU;
    }

    public List<FeedForumData> bAa() {
        return this.dFH;
    }

    public void dy(List<FeedForumData> list) {
        this.dFH = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
