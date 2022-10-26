package com.baidu.tieba;

import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import java.util.List;
import tbclient.Anti;
import tbclient.HotUserRankEntry;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.TAInfo;
import tbclient.Profile.UserAgreeInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.TbBookrack;
import tbclient.User;
/* loaded from: classes5.dex */
public interface n48 {
    Anti GetAntiStat();

    List GetPostList();

    User GetUser();

    TbBookrack getBookrackData();

    List getConcernedForumList();

    List getDynamicInfoList();

    int getErrorCode();

    hw6 getGoodsWindowInfo();

    HotUserRankEntry getHotRankEntry();

    AlaLiveInfoCoreData getLiveInfo();

    List getLiveReplayInfo();

    int getMaskType();

    List getNewestThreadList();

    NicknameInfo getNicknameInfo();

    TAInfo getTaInfo();

    UserAgreeInfo getUserAgreeInfo();

    UserGodInfo getUserGodInfo();
}
