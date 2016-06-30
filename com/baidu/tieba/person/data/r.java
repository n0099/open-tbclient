package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.GodDetailInfo;
/* loaded from: classes.dex */
public class r implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId eio = BdUniqueId.gen();
    private PersonUserGodInfo eip;
    private List<ForumGodDetailInfo> forumGodList;
    private GodDetailInfo godDetailInfo;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eio;
    }

    public int aLl() {
        if (this.eip == null) {
            return -1;
        }
        return this.eip.getGodType();
    }

    public GodDetailInfo aLm() {
        return this.godDetailInfo;
    }

    public List<ForumGodDetailInfo> getForumGodList() {
        return this.forumGodList;
    }
}
