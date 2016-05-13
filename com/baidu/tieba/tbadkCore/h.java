package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId eqr = BdUniqueId.gen();
    private List<FeedForumData> biJ;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eqr;
    }

    public List<FeedForumData> aSb() {
        return this.biJ;
    }

    public void cp(List<FeedForumData> list) {
        this.biJ = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
