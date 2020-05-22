package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes8.dex */
public class l implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId liV = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> hyS;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return liV;
    }

    public List<FeedForumData> dcG() {
        return this.hyS;
    }

    public void ez(List<FeedForumData> list) {
        this.hyS = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
