package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes6.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId hbv = BdUniqueId.gen();
    private List<FeedForumData> dMc;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return hbv;
    }

    public List<FeedForumData> bzq() {
        return this.dMc;
    }

    public void dA(List<FeedForumData> list) {
        this.dMc = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
