package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId fJB = BdUniqueId.gen();
    private List<FeedForumData> cjs;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fJB;
    }

    public List<FeedForumData> bkv() {
        return this.cjs;
    }

    public void cL(List<FeedForumData> list) {
        this.cjs = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
