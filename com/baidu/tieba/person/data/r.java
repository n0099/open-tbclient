package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.GodDetailInfo;
/* loaded from: classes.dex */
public class r implements v {
    public static final BdUniqueId dzK = BdUniqueId.gen();
    private PersonUserGodInfo dzL;
    private List<ForumGodDetailInfo> forumGodList;
    private GodDetailInfo godDetailInfo;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dzK;
    }

    public int aCp() {
        if (this.dzL == null) {
            return -1;
        }
        return this.dzL.getGodType();
    }

    public GodDetailInfo aCq() {
        return this.godDetailInfo;
    }

    public List<ForumGodDetailInfo> getForumGodList() {
        return this.forumGodList;
    }
}
