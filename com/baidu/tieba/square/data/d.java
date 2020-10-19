package com.baidu.tieba.square.data;

import java.util.List;
import tbclient.GetForumSquare.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes22.dex */
public class d {
    public String className;
    public List<RecommendForumInfo> forumList;
    public List<String> mxs;
    public Page page;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.className = dataRes.class_name;
            this.page = dataRes.page;
            this.mxs = dataRes.page_structure;
            this.forumList = dataRes.forum_info;
        }
    }
}
