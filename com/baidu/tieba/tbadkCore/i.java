package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId dxf = BdUniqueId.gen();
    private List<FeedForumData> bbP;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dxf;
    }

    public List<FeedForumData> aBB() {
        return this.bbP;
    }

    public void bH(List<FeedForumData> list) {
        this.bbP = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
