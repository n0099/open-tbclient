package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes3.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId jgC = BdUniqueId.gen();
    private List<FeedForumData> fGD;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgC;
    }

    public List<FeedForumData> cnx() {
        return this.fGD;
    }

    public void ep(List<FeedForumData> list) {
        this.fGD = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
