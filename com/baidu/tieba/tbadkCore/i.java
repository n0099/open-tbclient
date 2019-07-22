package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId jdk = BdUniqueId.gen();
    private List<FeedForumData> fEL;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jdk;
    }

    public List<FeedForumData> cox() {
        return this.fEL;
    }

    public void ed(List<FeedForumData> list) {
        this.fEL = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
