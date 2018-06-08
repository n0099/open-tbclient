package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes2.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId gGj = BdUniqueId.gen();
    private List<FeedForumData> dqv;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gGj;
    }

    public List<FeedForumData> buU() {
        return this.dqv;
    }

    public void dn(List<FeedForumData> list) {
        this.dqv = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
