package com.baidu.tieba.square.data;

import java.util.List;
import tbclient.GetForumSquare.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes16.dex */
public class d {
    public String className;
    public List<RecommendForumInfo> forumList;
    public List<String> lGq;
    public Page page;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.className = dataRes.class_name;
            this.page = dataRes.page;
            this.lGq = dataRes.page_structure;
            this.forumList = dataRes.forum_info;
        }
    }
}
