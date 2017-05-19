package com.baidu.tieba.write.transmit;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.likedForum.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements a.InterfaceC0070a {
    final /* synthetic */ h fOT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.fOT = hVar;
    }

    @Override // com.baidu.tieba.likedForum.a.InterfaceC0070a
    public void a(boolean z, int i, String str, List<ForumInfo> list) {
        ArrayList arrayList;
        boolean ct;
        ArrayList arrayList2 = new ArrayList();
        if (x.q(list) > 0) {
            int size = list.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                ForumInfo forumInfo = list.get(i3);
                if (forumInfo != null && forumInfo.forum_id != null && !StringUtils.isNull(forumInfo.forum_name)) {
                    ct = this.fOT.ct(forumInfo.forum_id.longValue());
                    if (!ct) {
                        arrayList2.add(new HotTopicBussinessData(forumInfo.forum_id.longValue(), forumInfo.forum_name, forumInfo.avatar, null, forumInfo.thread_count.longValue(), 0L, 0L, false, null, 0));
                    }
                }
                i2 = i3 + 1;
            }
            arrayList = this.fOT.beS;
            if (arrayList == null) {
                this.fOT.beS = arrayList2;
                this.fOT.Oe();
            }
        }
    }
}
