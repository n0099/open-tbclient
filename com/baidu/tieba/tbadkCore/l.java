package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class l implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId nxh = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> jyZ;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nxh;
    }

    public List<FeedForumData> dMU() {
        return this.jyZ;
    }

    public void fR(List<FeedForumData> list) {
        this.jyZ = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
