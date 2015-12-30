package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.GodDetailInfo;
/* loaded from: classes.dex */
public class o implements u {
    public static final BdUniqueId cSj = BdUniqueId.gen();
    private PersonUserGodInfo cSk;
    private List<ForumGodDetailInfo> forumGodList;
    private GodDetailInfo godDetailInfo;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cSj;
    }

    public void a(PersonUserGodInfo personUserGodInfo) {
        if (personUserGodInfo != null) {
            this.cSk = personUserGodInfo;
            this.godDetailInfo = personUserGodInfo.getgodDetailInfo();
            this.forumGodList = personUserGodInfo.getForumGodList();
        }
    }

    public int apx() {
        if (this.cSk == null) {
            return -1;
        }
        return this.cSk.getGodType();
    }

    public GodDetailInfo apy() {
        return this.godDetailInfo;
    }

    public List<ForumGodDetailInfo> getForumGodList() {
        return this.forumGodList;
    }
}
