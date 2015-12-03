package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.GodDetailInfo;
/* loaded from: classes.dex */
public class m implements u {
    public static final BdUniqueId cND = BdUniqueId.gen();
    private PersonUserGodInfo cNE;
    private List<ForumGodDetailInfo> forumGodList;
    private GodDetailInfo godDetailInfo;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cND;
    }

    public void a(PersonUserGodInfo personUserGodInfo) {
        if (personUserGodInfo != null) {
            this.cNE = personUserGodInfo;
            this.godDetailInfo = personUserGodInfo.getgodDetailInfo();
            this.forumGodList = personUserGodInfo.getForumGodList();
        }
    }

    public int aon() {
        if (this.cNE == null) {
            return -1;
        }
        return this.cNE.getGodType();
    }

    public GodDetailInfo aoo() {
        return this.godDetailInfo;
    }

    public List<ForumGodDetailInfo> getForumGodList() {
        return this.forumGodList;
    }
}
