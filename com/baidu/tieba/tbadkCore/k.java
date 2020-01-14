package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes6.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId kdG = BdUniqueId.gen();
    private String forumId;
    private List<FeedForumData> gxp;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kdG;
    }

    public List<FeedForumData> cIH() {
        return this.gxp;
    }

    public void eh(List<FeedForumData> list) {
        this.gxp = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
