package com.baidu.tieba.person;

import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import java.util.List;
import tbclient.Anti;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.PostInfoList;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.TAInfo;
import tbclient.Profile.UserAgreeInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.TbBookrack;
import tbclient.User;
import tbclient.UserManChannelInfo;
/* loaded from: classes.dex */
public interface c {
    Anti GetAntiStat();

    List<PostInfoList> GetPostList();

    User GetUser();

    TbBookrack getBookrackData();

    List<ForumDynamic> getConcernedForumList();

    List<DynamicInfo> getDynamicInfoList();

    int getErrorCode();

    AlaLiveInfoCoreData getLiveInfo();

    List<AlaLiveInfoCoreData> getLiveReplayInfo();

    int getMaskType();

    NicknameInfo getNicknameInfo();

    TAInfo getTaInfo();

    UserAgreeInfo getUserAgreeInfo();

    UserManChannelInfo getUserChannelInfo();

    UserGodInfo getUserGodInfo();
}
