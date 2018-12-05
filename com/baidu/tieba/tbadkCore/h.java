package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes6.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId hio = BdUniqueId.gen();
    private List<FeedForumData> dSF;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return hio;
    }

    public List<FeedForumData> bBk() {
        return this.dSF;
    }

    public void dE(List<FeedForumData> list) {
        this.dSF = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
