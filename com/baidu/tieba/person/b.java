package com.baidu.tieba.person;

import java.util.List;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.Profile.TAInfo;
import tbclient.TbBookrack;
import tbclient.User;
import tbclient.UserManChannelInfo;
/* loaded from: classes.dex */
public interface b {
    User GetUser();

    TbBookrack getBookrackData();

    List<ForumDynamic> getConcernedForumList();

    List<DynamicInfo> getDynamicInfoList();

    int getErrorCode();

    TAInfo getTaInfo();

    UserManChannelInfo getUserChannelInfo();
}
