package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes3.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId jgM = BdUniqueId.gen();
    private List<FeedForumData> fHo;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgM;
    }

    public List<FeedForumData> cpG() {
        return this.fHo;
    }

    public void ec(List<FeedForumData> list) {
        this.fHo = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
