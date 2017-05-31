package com.baidu.tieba.person;

import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import java.util.List;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.ModuleInfo;
import tbclient.Profile.TAInfo;
import tbclient.Profile.UserAgreeInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.TbBookrack;
import tbclient.User;
import tbclient.UserManChannelInfo;
/* loaded from: classes.dex */
public interface f {
    User GetUser();

    TbBookrack getBookrackData();

    List<ForumDynamic> getConcernedForumList();

    List<DynamicInfo> getDynamicInfoList();

    int getErrorCode();

    AlaLiveInfoCoreData getLiveInfo();

    ModuleInfo getModuleInfo();

    TAInfo getTaInfo();

    UserAgreeInfo getUserAgreeInfo();

    UserManChannelInfo getUserChannelInfo();

    UserGodInfo getUserGodInfo();
}
