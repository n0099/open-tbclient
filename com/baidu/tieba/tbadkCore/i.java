package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId fhZ = BdUniqueId.gen();
    private List<FeedForumData> bNt;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fhZ;
    }

    public List<FeedForumData> bdx() {
        return this.bNt;
    }

    public void cS(List<FeedForumData> list) {
        this.bNt = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
