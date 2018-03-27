package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId gYn = BdUniqueId.gen();
    private List<FeedForumData> dNv;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gYn;
    }

    public List<FeedForumData> buO() {
        return this.dNv;
    }

    public void dn(List<FeedForumData> list) {
        this.dNv = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
