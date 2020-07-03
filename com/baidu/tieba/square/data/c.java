package com.baidu.tieba.square.data;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class c {
    public String className;
    private List<RecommendForumInfo> forumList;
    private Page page;
    private List<q> dataList = new ArrayList();
    public boolean hasMore = true;
    public int pn = 0;
    public int lyZ = 0;
    public int dZy = 0;

    public List<q> getDataList() {
        return this.dataList;
    }

    public void a(d dVar) {
        this.className = dVar.className;
        this.page = dVar.page;
        this.forumList = dVar.forumList;
        if (!w.isEmpty(this.forumList)) {
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
