package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes8.dex */
public class l implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId lke = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> hzF;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return lke;
    }

    public List<FeedForumData> dcV() {
        return this.hzF;
    }

    public void eB(List<FeedForumData> list) {
        this.hzF = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
