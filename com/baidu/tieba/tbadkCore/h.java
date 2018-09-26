package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes2.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId gSC = BdUniqueId.gen();
    private List<FeedForumData> dCY;
    private String forumId;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gSC;
    }

    public List<FeedForumData> bwF() {
        return this.dCY;
    }

    /* renamed from: do  reason: not valid java name */
    public void m20do(List<FeedForumData> list) {
        this.dCY = list;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }
}
