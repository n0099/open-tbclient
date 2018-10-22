package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes6.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId gZY = BdUniqueId.gen();
    private List<FeedForumData> dKY;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gZY;
    }

    public List<FeedForumData> bzU() {
        return this.dKY;
    }

    public void dC(List<FeedForumData> list) {
        this.dKY = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
