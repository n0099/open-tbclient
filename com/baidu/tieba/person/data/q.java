package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.GodDetailInfo;
/* loaded from: classes.dex */
public class q implements v {
    public static final BdUniqueId ess = BdUniqueId.gen();
    private PersonUserGodInfo est;
    private List<ForumGodDetailInfo> forumGodList;
    private GodDetailInfo godDetailInfo;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ess;
    }

    public int aNO() {
        if (this.est == null) {
            return -1;
        }
        return this.est.getGodType();
    }

    public GodDetailInfo aNP() {
        return this.godDetailInfo;
    }

    public List<ForumGodDetailInfo> getForumGodList() {
        return this.forumGodList;
    }
}
