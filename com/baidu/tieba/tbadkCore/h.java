package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes6.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId hlz = BdUniqueId.gen();
    private List<FeedForumData> dVw;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return hlz;
    }

    public List<FeedForumData> bCb() {
        return this.dVw;
    }

    public void dF(List<FeedForumData> list) {
        this.dVw = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
