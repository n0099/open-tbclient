package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes3.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId jfL = BdUniqueId.gen();
    private List<FeedForumData> fFM;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jfL;
    }

    public List<FeedForumData> cnv() {
        return this.fFM;
    }

    public void ep(List<FeedForumData> list) {
        this.fFM = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
