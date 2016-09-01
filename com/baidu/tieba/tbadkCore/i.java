package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId fpR = BdUniqueId.gen();
    private List<FeedForumData> bYN;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fpR;
    }

    public List<FeedForumData> bhb() {
        return this.bYN;
    }

    public void cW(List<FeedForumData> list) {
        this.bYN = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
