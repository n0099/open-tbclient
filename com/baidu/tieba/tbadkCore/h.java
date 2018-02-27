package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId gXS = BdUniqueId.gen();
    private List<FeedForumData> dNq;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gXS;
    }

    public List<FeedForumData> buM() {
        return this.dNq;
    }

    public void dn(List<FeedForumData> list) {
        this.dNq = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
