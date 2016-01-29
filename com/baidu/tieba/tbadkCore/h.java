package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId dUB = BdUniqueId.gen();
    private List<FeedForumData> biw;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dUB;
    }

    public List<FeedForumData> aKO() {
        return this.biw;
    }

    public void bW(List<FeedForumData> list) {
        this.biw = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
