package com.baidu.tieba.person.data;

import java.io.Serializable;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.GodDetailInfo;
import tbclient.Profile.UserGodInfo;
/* loaded from: classes9.dex */
public class PersonUserGodInfo implements Serializable {
    public static final int USER_GOD_TYPE_MULTI = 1;
    public static final int USER_GOD_TYPE_SINGLE = 2;
    private static final long serialVersionUID = -1538103146882985197L;
    private List<ForumGodDetailInfo> forumGodList;
    private GodDetailInfo godDetailInfo;
    private int godType;
    private int sex;

    public int getGodType() {
        return this.godType;
    }

    public GodDetailInfo getgodDetailInfo() {
        return this.godDetailInfo;
    }

    public List<ForumGodDetailInfo> getForumGodList() {
        return this.forumGodList;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void parserProtobuf(UserGodInfo userGodInfo) {
        if (userGodInfo != null) {
            this.godType = userGodInfo.god_type.intValue();
            this.godDetailInfo = userGodInfo.god_info;
            this.forumGodList = userGodInfo.forum_god_list;
            this.sex = userGodInfo.sex.intValue();
        }
    }
}
