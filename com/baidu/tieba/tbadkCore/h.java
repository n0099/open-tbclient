package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes2.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId gKZ = BdUniqueId.gen();
    private List<FeedForumData> dwr;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gKZ;
    }

    public List<FeedForumData> btY() {
        return this.dwr;
    }

    public void dn(List<FeedForumData> list) {
        this.dwr = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
