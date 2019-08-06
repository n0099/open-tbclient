package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes3.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId jer = BdUniqueId.gen();
    private List<FeedForumData> fFz;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jer;
    }

    public List<FeedForumData> coT() {
        return this.fFz;
    }

    public void ec(List<FeedForumData> list) {
        this.fFz = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
