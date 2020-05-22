package com.baidu.tieba.square.data;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class c {
    public String className;
    private List<RecommendForumInfo> forumList;
    private Page page;
    private List<o> dataList = new ArrayList();
    public boolean hasMore = true;
    public int pn = 0;
    public int ldS = 0;
    public int dSG = 0;

    public List<o> getDataList() {
        return this.dataList;
    }

    public void a(d dVar) {
        this.className = dVar.className;
        this.page = dVar.page;
        this.forumList = dVar.forumList;
        if (!v.isEmpty(this.forumList)) {
            for (RecommendForumInfo recommendForumInfo : this.forumList) {
                b bVar = new b();
                bVar.c(recommendForumInfo);
                this.dataList.add(bVar);
            }
        }
        if (this.page != null) {
            this.hasMore = this.page.has_more.intValue() == 1;
            this.pn = this.page.current_page.intValue();
        }
    }
}
