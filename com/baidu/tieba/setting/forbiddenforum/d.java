package com.baidu.tieba.setting.forbiddenforum;

import java.util.ArrayList;
import java.util.List;
import tbclient.ForumList;
import tbclient.GetDislikeList.DataRes;
/* loaded from: classes7.dex */
public class d {
    public List<b> dataList = new ArrayList();
    public boolean hasMore = true;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            for (ForumList forumList : dataRes.forum_list) {
                b bVar = new b();
                bVar.ngt = forumList.avatar;
                bVar.ngu = forumList.forum_name;
                bVar.forumId = String.valueOf(forumList.forum_id);
                this.dataList.add(bVar);
            }
            this.hasMore = dataRes.has_more.intValue() == 1;
        }
    }
}
