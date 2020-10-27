package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes21.dex */
public class l implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId mOY = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> iPt;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mOY;
    }

    public List<FeedForumData> dGI() {
        return this.iPt;
    }

    public void fy(List<FeedForumData> list) {
        this.iPt = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
