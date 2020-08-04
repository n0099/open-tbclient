package com.baidu.tieba.newinterest.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ClassForumInfo;
import tbclient.GetVerticalForumList.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes17.dex */
public class c {
    public List<a> kcN;
    private Page page;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.class_foruminfo != null) {
                this.kcN = new ArrayList();
                for (ClassForumInfo classForumInfo : dataRes.class_foruminfo) {
                    a aVar = new a();
                    aVar.class_id = classForumInfo.class_id;
                    aVar.class_name = classForumInfo.class_name;
                    ArrayList arrayList = new ArrayList();
                    for (RecommendForumInfo recommendForumInfo : classForumInfo.forum_info) {
                        arrayList.add(new d(recommendForumInfo, false));
                    }
                    aVar.forum_info = arrayList;
                    this.kcN.add(aVar);
                }
            }
            if (dataRes.page != null) {
                this.page = dataRes.page;
            }
        }
    }
}
