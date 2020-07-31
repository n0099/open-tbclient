package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes15.dex */
public class l implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId lLo = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> hSM;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lLo;
    }

    public List<FeedForumData> dkt() {
        return this.hSM;
    }

    public void eV(List<FeedForumData> list) {
        this.hSM = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
