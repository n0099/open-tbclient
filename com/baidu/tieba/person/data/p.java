package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.GodDetailInfo;
/* loaded from: classes.dex */
public class p implements u {
    public static final BdUniqueId dcc = BdUniqueId.gen();
    private PersonUserGodInfo dcd;
    private List<ForumGodDetailInfo> forumGodList;
    private GodDetailInfo godDetailInfo;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dcc;
    }

    public int aur() {
        if (this.dcd == null) {
            return -1;
        }
        return this.dcd.getGodType();
    }

    public GodDetailInfo aus() {
        return this.godDetailInfo;
    }

    public List<ForumGodDetailInfo> getForumGodList() {
        return this.forumGodList;
    }
}
