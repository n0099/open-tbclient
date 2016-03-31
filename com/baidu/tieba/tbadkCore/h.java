package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId enc = BdUniqueId.gen();
    private List<FeedForumData> bnh;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return enc;
    }

    public List<FeedForumData> aRD() {
        return this.bnh;
    }

    public void cn(List<FeedForumData> list) {
        this.bnh = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
