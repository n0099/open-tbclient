package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId gVu = BdUniqueId.gen();
    private List<FeedForumData> dKi;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gVu;
    }

    public List<FeedForumData> btw() {
        return this.dKi;
    }

    public void dh(List<FeedForumData> list) {
        this.dKi = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
