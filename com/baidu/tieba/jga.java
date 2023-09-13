package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ForumTagInfo;
import com.baidu.tbadk.core.data.FrsBannerHeaderData;
import com.baidu.tbadk.core.data.FrsGameRankInfoData;
import com.baidu.tbadk.core.data.FrsSpriteNewUserGuide;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.mvc.data.IResponseData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.FrsBountyTaskData;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tbclient.AdMixFloor;
import tbclient.AddBawuPopInfo;
import tbclient.AlaLiveNotify;
import tbclient.BottomMenu;
import tbclient.CategoryInfo;
import tbclient.ForumArIno;
import tbclient.ForumRuleStatus;
import tbclient.FrsPage.ActivityConfig;
import tbclient.FrsPage.AgreeBanner;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.FrsPage.ForumGroup;
import tbclient.FrsPage.ForumHeadIcon;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.HeaderCard;
import tbclient.FrsPage.LiveFuseForumData;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.NebulaHotThreads;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsPage.RecomPostTopic;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsPage.StarRank;
import tbclient.FrsTabInfo;
import tbclient.HotUserRankEntry;
import tbclient.ItemInfo;
import tbclient.OriForumInfo;
import tbclient.PopInfo;
import tbclient.ServiceArea;
import tbclient.SignActivityInfo;
import tbclient.SmartApp;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.WindowToast;
/* loaded from: classes6.dex */
public class jga implements or5, IResponseData {
    public static /* synthetic */ Interceptable $ic;
    public static final Wire WIRE;
    public transient /* synthetic */ FieldHolder $fh;
    public int accessFlag;
    public ActivityConfig activityConfig;
    public List<AdMixFloor> adMixFloor;
    public String adSampleMapKey;
    public int adShowSelect;
    public AgreeBanner agreeBanner;
    public int alaLiveCount;
    public AntiData anti;
    public int baWuNoticeNum;
    public String bawuCenterUrl;
    public AddBawuPopInfo bawuPopInfo;
    public d25 bookInfoData;
    public List<BottomMenu> bottomMenuList;
    @Nullable
    public FrsBountyTaskData bountyTaskData;
    public yh7 brandAdData;
    public ega businessPromot;
    public ThreadData cardVideoInfo;
    public w15 carrierEnterData;
    public List<CategoryInfo> categoryInfos;
    public yfa chatGroup;
    public ArrayList<z15> color_eggs;
    public int defaultShowTab;
    public PopInfo enterFrsDialogInfo;
    public String firstCategory;
    public boolean fortuneBag;
    public String fortuneDesc;
    public ForumData forum;
    public ForumActiveInfo forumActiveInfo;
    public ForumArIno forumArIno;
    public ForumHeadIcon forumHeadIcon;
    public ForumRuleStatus forumRule;
    public int forumState;
    public ForumTagInfo forumTagInfo;
    public FrsBannerHeaderData frsBannerHeaderData;
    public int frsDefaultTabId;
    public ForumGroup frsForumGroup;
    public FrsGameRankInfoData frsGameRankInfoData;
    public PopInfo frsMaskPopInfo;
    @Nullable
    public FrsSpriteNewUserGuide frsSpriteNewUserGuide;
    public int gameDefaultTabId;
    public String gameName;
    public List<FrsTabInfo> gameTabInfo;
    public String gameUrl;
    public pga gconAccount;
    public boolean hasGame;
    public m25 headSdkData;
    public HeaderCard headerCard;
    public g25 headlineImgInfoData;
    public boolean isBrandForum;
    public boolean isFromCache;
    public boolean isFrsVideoAutoPlay;
    public boolean isMemberBroadcastForum;
    public int isNewUrl;
    public boolean isShowRedTip;
    public ItemInfo itemInfo;
    public List<FeedForumData> likeFeedForumDataList;
    public List<LiveFuseForumData> liveFuseForumDataList;
    public AlaLiveNotify liveNotify;
    public c25 mActivityHeadData;
    public List<cn> mCardShipinNew;
    public List<Integer> mCardShipinPos;
    public long mDataParseTime;
    public lga mEntelechyTabInfo;
    public int mErrorNo;
    public cga mFrsInsertLiveData;
    public dga mFrsStageLiveData;
    public oga mFrsVideoActivityData;
    public iz7 mGameRankListData;
    public boolean mHasThreadExceptTop;
    public HotUserRankEntry mHotUserRankData;
    public FrsTabInfo mNewChapterInfo;
    public PrivateForumPopInfoData mPrivateForumPopInfoData;
    public SignActivityInfo mSignActivityInfo;
    public int mSortType;
    public List<WindowToast> mWindowToast;
    public Integer mangaReadRecordChapterId;
    public NebulaHotThreads nebulaHotThreads;
    public int needLog;
    public List<OriForumInfo> oriForumInfoList;
    public e35 page;
    public int photoLivePos;
    public RecomPostTopic postTopic;
    public j25 presentInfoData;
    public n35 privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    public n25 recommendBookData;
    public u35 schoolRecommendInfo;
    public int schoolRecommendPos;
    public yga serviceAreaData;
    public List<Map<String, Object>> serviceAreaFlutterData;
    public Integer showAdsense;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    public kga star;
    public List<gga> starEnter;
    public StarRank starRank;
    public ArrayList<cn> threadList;
    public List<Long> threadListIds;
    public Integer toLoadHorseData;
    public List<cn> topThreadList;
    public UserData userData;
    public List<User> userList;
    public HashMap<String, MetaData> userMap;
    public si7 userRecommend;
    @Nullable
    public ce5 voiceRoomConfig;
    @Nullable
    public de5 voiceRoomData;

    @Override // com.baidu.tieba.pr5
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.or5
    public boolean initByByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, bArr)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.data.IResponseData
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tbadk.mvc.data.IResponseData
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, message) == null) {
        }
    }

    @Override // com.baidu.tieba.or5
    public byte[] toCacheByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947883717, "Lcom/baidu/tieba/jga;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947883717, "Lcom/baidu/tieba/jga;");
                return;
            }
        }
        WIRE = new Wire(new Class[0]);
    }

    public int getAccessFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.accessFlag;
        }
        return invokeV.intValue;
    }

    public c25 getActivityHeadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mActivityHeadData;
        }
        return (c25) invokeV.objValue;
    }

    public AgreeBanner getAgreeBanner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.agreeBanner;
        }
        return (AgreeBanner) invokeV.objValue;
    }

    public int getAlaLiveCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.alaLiveCount;
        }
        return invokeV.intValue;
    }

    public AntiData getAnti() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.anti;
        }
        return (AntiData) invokeV.objValue;
    }

    public int getBaWuNoticeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.baWuNoticeNum;
        }
        return invokeV.intValue;
    }

    public String getBawuCenterUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.bawuCenterUrl;
        }
        return (String) invokeV.objValue;
    }

    public d25 getBookInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.bookInfoData;
        }
        return (d25) invokeV.objValue;
    }

    @Nullable
    public FrsBountyTaskData getBountyTaskData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.bountyTaskData;
        }
        return (FrsBountyTaskData) invokeV.objValue;
    }

    public ega getBusinessPromot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.businessPromot;
        }
        return (ega) invokeV.objValue;
    }

    public List<cn> getCardShipinNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mCardShipinNew;
        }
        return (List) invokeV.objValue;
    }

    public List<Integer> getCardShipinPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mCardShipinPos;
        }
        return (List) invokeV.objValue;
    }

    public ThreadData getCardVideoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.cardVideoInfo;
        }
        return (ThreadData) invokeV.objValue;
    }

    public w15 getCarrierEnterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.carrierEnterData;
        }
        return (w15) invokeV.objValue;
    }

    public List<CategoryInfo> getCategoryInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.categoryInfos;
        }
        return (List) invokeV.objValue;
    }

    public yfa getChatGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.chatGroup;
        }
        return (yfa) invokeV.objValue;
    }

    public long getDataParseTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mDataParseTime;
        }
        return invokeV.longValue;
    }

    public lga getEntelechyTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mEntelechyTabInfo;
        }
        return (lga) invokeV.objValue;
    }

    public String getFortuneDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.fortuneDesc;
        }
        return (String) invokeV.objValue;
    }

    public ForumData getForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.forum;
        }
        return (ForumData) invokeV.objValue;
    }

    public ForumHeadIcon getForumHeadIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.forumHeadIcon;
        }
        return (ForumHeadIcon) invokeV.objValue;
    }

    public int getForumState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.forumState;
        }
        return invokeV.intValue;
    }

    public int getFrsDefaultTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.frsDefaultTabId;
        }
        return invokeV.intValue;
    }

    public cga getFrsInsertLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mFrsInsertLiveData;
        }
        return (cga) invokeV.objValue;
    }

    public dga getFrsStageLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mFrsStageLiveData;
        }
        return (dga) invokeV.objValue;
    }

    public oga getFrsVideoActivityData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mFrsVideoActivityData;
        }
        return (oga) invokeV.objValue;
    }

    public int getGameDefaultTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.gameDefaultTabId;
        }
        return invokeV.intValue;
    }

    public String getGameName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.gameName;
        }
        return (String) invokeV.objValue;
    }

    public iz7 getGameRankListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mGameRankListData;
        }
        return (iz7) invokeV.objValue;
    }

    public List<FrsTabInfo> getGameTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.gameTabInfo;
        }
        return (List) invokeV.objValue;
    }

    public String getGameUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.gameUrl;
        }
        return (String) invokeV.objValue;
    }

    public pga getGconAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.gconAccount;
        }
        return (pga) invokeV.objValue;
    }

    public m25 getHeadSdkData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.headSdkData;
        }
        return (m25) invokeV.objValue;
    }

    public g25 getHeadlineImgInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.headlineImgInfoData;
        }
        return (g25) invokeV.objValue;
    }

    public HotUserRankEntry getHotUserRankData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.mHotUserRankData;
        }
        return (HotUserRankEntry) invokeV.objValue;
    }

    public int getIsNewUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.isNewUrl;
        }
        return invokeV.intValue;
    }

    public List<FeedForumData> getLikeFeedForumDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.likeFeedForumDataList;
        }
        return (List) invokeV.objValue;
    }

    public AlaLiveNotify getLiveNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.liveNotify;
        }
        return (AlaLiveNotify) invokeV.objValue;
    }

    public Integer getMangaReadRecordChapterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.mangaReadRecordChapterId;
        }
        return (Integer) invokeV.objValue;
    }

    public e35 getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.page;
        }
        return (e35) invokeV.objValue;
    }

    public int getPhotoLivePos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.photoLivePos;
        }
        return invokeV.intValue;
    }

    public PrivateForumPopInfoData getPrivateForumPopInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.mPrivateForumPopInfoData;
        }
        return (PrivateForumPopInfoData) invokeV.objValue;
    }

    public n35 getPrivateForumTotalInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.privateForumTotalData;
        }
        return (n35) invokeV.objValue;
    }

    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.recm_forum_list;
        }
        return (List) invokeV.objValue;
    }

    public int getSchoolRecommendPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.schoolRecommendPos;
        }
        return invokeV.intValue;
    }

    public u35 getSchoolRecommendUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.schoolRecommendInfo;
        }
        return (u35) invokeV.objValue;
    }

    public int getSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.mSortType;
        }
        return invokeV.intValue;
    }

    public kga getStar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.star;
        }
        return (kga) invokeV.objValue;
    }

    public List<gga> getStarEnter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.starEnter;
        }
        return (List) invokeV.objValue;
    }

    public ArrayList<cn> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.threadList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<Long> getThreadListIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.threadListIds;
        }
        return (List) invokeV.objValue;
    }

    public Integer getToLoadHorseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.toLoadHorseData;
        }
        return (Integer) invokeV.objValue;
    }

    public UserData getUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.userData;
        }
        return (UserData) invokeV.objValue;
    }

    public HashMap<String, MetaData> getUserMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.userMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public si7 getUserRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.userRecommend;
        }
        return (si7) invokeV.objValue;
    }

    @NonNull
    public ce5 getVoiceRoomConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            ce5 ce5Var = this.voiceRoomConfig;
            if (ce5Var != null) {
                return ce5Var;
            }
            return ce5.a;
        }
        return (ce5) invokeV.objValue;
    }

    public de5 getVoiceRoomData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.voiceRoomData;
        }
        return (de5) invokeV.objValue;
    }

    public boolean isFortuneBag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.fortuneBag;
        }
        return invokeV.booleanValue;
    }

    public boolean isHasGame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.hasGame;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowRedTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.isShowRedTip;
        }
        return invokeV.booleanValue;
    }

    public ArrayList<cn> switchThreadDataToThreadCardInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            ArrayList<cn> switchThreadDataToThreadCardInfo = switchThreadDataToThreadCardInfo(this.threadList);
            setThreadList(switchThreadDataToThreadCardInfo);
            return switchThreadDataToThreadCardInfo;
        }
        return (ArrayList) invokeV.objValue;
    }

    public jga() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.needLog = 0;
        this.starEnter = new ArrayList();
        this.isNewUrl = 0;
        this.color_eggs = new ArrayList<>();
        this.mActivityHeadData = null;
        this.mEntelechyTabInfo = new lga();
        this.frsDefaultTabId = 1;
        this.isShowRedTip = false;
        this.bawuCenterUrl = null;
        this.headSdkData = null;
        this.recommendBookData = null;
        this.postTopic = null;
        this.bookInfoData = null;
        this.mangaReadRecordChapterId = -1;
        this.presentInfoData = null;
        this.headlineImgInfoData = null;
        this.schoolRecommendPos = -1;
        this.topThreadList = null;
        this.forumState = 0;
        this.accessFlag = 0;
        this.alaLiveCount = 0;
        this.gameDefaultTabId = 0;
        this.mErrorNo = 0;
        this.defaultShowTab = 1;
        this.mDataParseTime = 0L;
        this.serviceAreaFlutterData = new ArrayList();
        initData();
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.forum = new ForumData();
            this.threadList = new ArrayList<>();
            this.topThreadList = new ArrayList();
            this.userMap = new HashMap<>();
            this.page = new e35();
            this.star = new kga();
            this.userData = new UserData();
            this.gconAccount = new pga();
            setAnti(new AntiData());
            setChatGroup(new yfa());
            this.privateForumTotalData = new n35();
            this.mCardShipinNew = new ArrayList();
            this.mCardShipinPos = new ArrayList();
        }
    }

    private void handleDefaultTab(int i) {
        List<FrsTabInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i) == null) {
            this.frsDefaultTabId = 1;
            lga lgaVar = this.mEntelechyTabInfo;
            if (lgaVar != null && (list = lgaVar.a) != null && list.size() > 0) {
                for (FrsTabInfo frsTabInfo : this.mEntelechyTabInfo.a) {
                    if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                        this.frsDefaultTabId = i;
                        return;
                    }
                }
            }
        }
    }

    public void deleteLikeFeedForum(String str) {
        List<FeedForumData> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (list = this.likeFeedForumDataList) != null && str != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.likeFeedForumDataList.remove(feedForumData);
                    return;
                }
            }
        }
    }

    private void insertPeiWanData(ThreadData threadData, ArrayList<cn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, this, threadData, arrayList, i) == null) && threadData != null && arrayList != null && threadData.getPeiwanInfo() != null) {
            hq6 hq6Var = new hq6();
            hq6Var.p(threadData.getPeiwanInfo().room_status);
            hq6Var.q(threadData.getPeiwanInfo().room_status_text);
            hq6Var.l(threadData.getPeiwanInfo().cover);
            hq6Var.s(threadData.getPeiwanInfo().scheme);
            hq6Var.v(threadData.getPeiwanInfo().voice);
            hq6Var.t(threadData.getPeiwanInfo().tag_list);
            hq6Var.o(threadData.getPeiwanInfo().room_id.longValue());
            threadData.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            hq6Var.u(threadData);
            hq6Var.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            hq6Var.position = i + 1;
            hq6Var.setTid(threadData.tid);
            hq6Var.m(!this.isFromCache);
            arrayList.add(hq6Var);
        }
    }

    private void insertRecommendInfo(ThreadData threadData, ArrayList<cn> arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65541, this, threadData, arrayList, i) == null) && threadData != null && arrayList != null && (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            h45 h45Var = new h45();
            h45Var.s = true;
            h45Var.t = threadData;
            h45Var.position = i;
            h45Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            arrayList.add(h45Var);
        }
    }

    private void setRemoveDuplicationFlag(DataRes dataRes, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, this, dataRes, threadData) == null) && threadData.getThreadType() == 69) {
            if (dataRes.is_need_live_ununiq.intValue() == 1) {
                threadData.setNeedRemoveDuplicationFlag(ThreadData.RemoveDuplication.NOT_NEED);
            } else {
                threadData.setNeedRemoveDuplicationFlag(ThreadData.RemoveDuplication.NEED);
            }
        }
    }

    public void convertThreadInfoToThreadData(DataRes dataRes, List<ThreadInfo> list, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{dataRes, list, Long.valueOf(j)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                ThreadData threadData = new ThreadData();
                threadData.setDispatchedForumId(dataRes.forum.id.longValue());
                SpecHotTopicHelper.setSpecTopicIcon(j, threadData);
                threadData.setUserMap(this.userMap);
                threadData.setFromFrs(true);
                threadData.parserProtobuf(threadInfo);
                threadData.parser_title();
                threadData.insertItemToTitleOrAbstractText();
                if (threadData.getFid() == 0 && j != 0) {
                    threadData.setFid(j);
                }
                if (StringUtils.isNull(threadData.getForum_name())) {
                    threadData.setForum_name(this.forum.getName());
                }
                threadData.setForumAvatar(this.forum.getImage_url());
                threadData.parseStyle_flag(this.color_eggs);
                threadData.isFromBrandForum = this.forum.isBrandForum;
                setRemoveDuplicationFlag(dataRes, threadData);
                if (!TextUtils.isEmpty(threadData.getLegoCard())) {
                    u25 u25Var = new u25();
                    u25Var.e(threadData.getLegoCard());
                    this.threadList.add(u25Var);
                } else {
                    this.threadList.add(threadData);
                    JSONObject c = w4a.c(threadInfo, threadData.getForum_name());
                    if (c != null) {
                        arrayList.add(c);
                    }
                }
            }
        }
        w4a.f().h("FRS", arrayList);
    }

    public FrsPageResIdl parserProtobuf(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048642, this, bArr, z)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (bArr == null) {
                return null;
            }
            try {
                FrsPageResIdl frsPageResIdl = (FrsPageResIdl) WIRE.parseFrom(bArr, FrsPageResIdl.class);
                if (frsPageResIdl != null && frsPageResIdl.data != null) {
                    parserProtobuf(frsPageResIdl.data);
                }
                if (z) {
                    if (this.mDataParseTime == 0) {
                        this.mDataParseTime = System.currentTimeMillis() - currentTimeMillis;
                    }
                } else {
                    this.mDataParseTime = 0L;
                }
                return frsPageResIdl;
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (FrsPageResIdl) invokeLZ.objValue;
    }

    public void parserProtobuf(DataRes dataRes) {
        long j;
        boolean z;
        boolean z2;
        long j2;
        boolean z3;
        boolean z4;
        MetaData metaData;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048643, this, dataRes) != null) || dataRes == null) {
            return;
        }
        try {
            initData();
            if (!ListUtils.isEmpty(dataRes.color_egg)) {
                for (ColorEgg colorEgg : dataRes.color_egg) {
                    if (colorEgg != null && !ListUtils.isEmpty(colorEgg.holiday_words)) {
                        z15 z15Var = new z15();
                        if (z15Var.c(colorEgg)) {
                            this.color_eggs.add(z15Var);
                        }
                    }
                }
            }
            int i = 0;
            if (dataRes.forum != null) {
                if (dataRes.forum.has_game.intValue() == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                this.hasGame = z5;
                this.gameUrl = dataRes.forum.game_url;
                this.gameName = dataRes.forum.game_name;
                if (dataRes.forum.is_brand_forum.intValue() == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                this.isBrandForum = z6;
                if (dataRes.forum.tag_info != null) {
                    this.firstCategory = dataRes.forum.tag_info.first_category;
                    if (dataRes.forum.tag_info.recom_tag != null) {
                        ForumTagInfo forumTagInfo = new ForumTagInfo();
                        this.forumTagInfo = forumTagInfo;
                        forumTagInfo.id = String.valueOf(dataRes.forum.tag_info.recom_tag.id);
                        this.forumTagInfo.name = dataRes.forum.tag_info.recom_tag.name;
                        this.forumTagInfo.pic = dataRes.forum.tag_info.recom_tag.pic;
                    }
                }
            }
            this.frsSpriteNewUserGuide = FrsSpriteNewUserGuide.parse(dataRes.sprite_bubble_guide);
            this.bountyTaskData = FrsBountyTaskData.parseProto(dataRes.bounty_card);
            if (this.isBrandForum && dataRes.brand_forum_info != null) {
                c25 c25Var = new c25();
                this.mActivityHeadData = c25Var;
                c25Var.e(dataRes.brand_forum_info.head_imgs);
                yh7 yh7Var = new yh7();
                this.brandAdData = yh7Var;
                yh7Var.a(dataRes.brand_forum_info);
                if (!ListUtils.isEmpty(dataRes.brand_forum_info.relation_forum)) {
                    this.oriForumInfoList = new ArrayList();
                    for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                        if (oriForumInfo != null) {
                            this.oriForumInfoList.add(oriForumInfo);
                        }
                    }
                }
            } else if (dataRes.activityhead != null) {
                if (dataRes.forum != null) {
                    j = dataRes.forum.id.longValue();
                } else {
                    j = 0;
                }
                c25 c25Var2 = new c25();
                this.mActivityHeadData = c25Var2;
                c25Var2.d(dataRes.activityhead, j);
            } else if (dataRes.private_forum_info != null && dataRes.private_forum_info.head_imgs != null && !ei.isEmpty(dataRes.private_forum_info.head_imgs.img_url)) {
                c25 c25Var3 = new c25();
                this.mActivityHeadData = c25Var3;
                c25Var3.e(dataRes.private_forum_info.head_imgs);
            }
            this.bottomMenuList = dataRes.bottom_menu;
            this.adMixFloor = dataRes.ad_mix_list;
            this.adShowSelect = dataRes.ad_show_select.intValue();
            this.adSampleMapKey = dataRes.ad_sample_map_key;
            this.liveFuseForumDataList = dataRes.live_fuse_forum;
            this.baWuNoticeNum = dataRes.bawu_unread_notice_num.intValue();
            if (dataRes.recreation_rank_info != null) {
                this.frsGameRankInfoData = FrsGameRankInfoData.ofRecreationRankInfo(dataRes.recreation_rank_info);
            }
            if (dataRes.is_member_broadcast_forum.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.isMemberBroadcastForum = z;
            this.frsForumGroup = dataRes.forum_group;
            if (dataRes.frs_banner_header != null) {
                FrsBannerHeaderData frsBannerHeaderData = new FrsBannerHeaderData();
                this.frsBannerHeaderData = frsBannerHeaderData;
                frsBannerHeaderData.parseData(dataRes.frs_banner_header);
            }
            this.headerCard = dataRes.header_card;
            List<User> list = dataRes.user_list;
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    MetaData metaData2 = new MetaData();
                    metaData2.parserProtobuf(list.get(i2));
                    String userId = metaData2.getUserId();
                    if (userId != null && !userId.equals("0")) {
                        this.userMap.put(metaData2.getUserId(), metaData2);
                    }
                }
            }
            this.userList = dataRes.user_list;
            setIsNewUrl(dataRes.is_new_url.intValue());
            if (dataRes.fortune_bag.intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.fortuneBag = z2;
            this.fortuneDesc = dataRes.fortune_desc;
            List<StarEnter> list2 = dataRes.star_enter;
            this.starEnter.clear();
            if (list2 != null) {
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    gga ggaVar = new gga();
                    ggaVar.h(list2.get(i3));
                    this.starEnter.add(ggaVar);
                }
            }
            this.gconAccount.c(dataRes.gcon_account);
            this.forum.parserProtobuf(dataRes.forum);
            if (dataRes.forum != null) {
                j2 = dataRes.forum.id.longValue();
                SpecHotTopicHelper.putSpecialTopicIcon(Long.valueOf(j2), dataRes.forum.topic_special_icon, dataRes.forum.topic_special_icon_right);
            } else {
                j2 = 0;
            }
            this.threadListIds = dataRes.thread_id_list;
            this.anti.parserProtobuf(dataRes.anti);
            if (dataRes.anti != null) {
                ypa.g(dataRes.anti.block_pop_info);
            }
            this.chatGroup.a(dataRes.group);
            this.page.j(dataRes.page);
            this.star.c(dataRes.frs_star);
            this.userData.parserProtobuf(dataRes.user);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
            }
            if (dataRes.nav_tab_info == null) {
                NavTabInfo.Builder builder = new NavTabInfo.Builder();
                builder.tab = dataRes.frs_tab_info;
                this.mEntelechyTabInfo.a(builder.build(true));
            } else {
                this.mEntelechyTabInfo.a(dataRes.nav_tab_info);
            }
            this.defaultShowTab = 1;
            if (this.mEntelechyTabInfo != null && !ListUtils.isEmpty(this.mEntelechyTabInfo.c)) {
                this.mNewChapterInfo = this.mEntelechyTabInfo.c.get(0);
            }
            this.alaLiveCount = dataRes.ala_live_count.intValue();
            handleDefaultTab(dataRes.frs_tab_default.intValue());
            this.photoLivePos = dataRes.twzhibo_pos.intValue();
            if (dataRes.trends_redpoint.intValue() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.isShowRedTip = z3;
            convertThreadInfoToThreadData(dataRes, dataRes.thread_list, j2);
            this.categoryInfos = dataRes.category_list;
            if (!ei.isEmpty(dataRes.bawu_enter_url)) {
                this.bawuCenterUrl = dataRes.bawu_enter_url;
            }
            if (dataRes.head_sdk != null) {
                m25 m25Var = new m25();
                this.headSdkData = m25Var;
                m25Var.a(dataRes.head_sdk);
            }
            if (dataRes.recommend_book != null) {
                n25 n25Var = new n25();
                this.recommendBookData = n25Var;
                n25Var.c(dataRes.recommend_book);
            }
            if (dataRes.book_info != null) {
                d25 d25Var = new d25();
                this.bookInfoData = d25Var;
                d25Var.c(dataRes.book_info);
            }
            if (dataRes.forum_present_info != null) {
                j25 j25Var = new j25();
                this.presentInfoData = j25Var;
                j25Var.a(dataRes.forum_present_info);
            }
            if (dataRes.forum_headline_img_info != null) {
                g25 g25Var = new g25();
                this.headlineImgInfoData = g25Var;
                g25Var.b(dataRes.forum_headline_img_info);
            }
            if (dataRes.business_promot != null) {
                ega egaVar = new ega();
                this.businessPromot = egaVar;
                egaVar.s(dataRes.business_promot);
            }
            if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                ThreadData threadData = new ThreadData();
                this.cardVideoInfo = threadData;
                threadData.setIsInsertThread(true);
                this.cardVideoInfo.setInsertFloor(this.photoLivePos);
                this.cardVideoInfo.setUserMap(this.userMap);
                this.cardVideoInfo.parserProtobuf(dataRes.card_shipin_info.get(0));
                this.cardVideoInfo.parser_title();
                this.cardVideoInfo.isFromBrandForum = this.isBrandForum;
                if (this.cardVideoInfo.getFid() == 0 && j2 != 0) {
                    this.cardVideoInfo.setFid(j2);
                }
                this.cardVideoInfo.parseStyle_flag(this.color_eggs);
                ThreadData threadData2 = this.cardVideoInfo;
                if (!this.cardVideoInfo.isTbReadDispatch()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                threadData2.setFloor5Video(z4);
                if (this.cardVideoInfo.getAuthor() != null && this.cardVideoInfo.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.cardVideoInfo.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                    UserPendantData userPendantData = new UserPendantData();
                    userPendantData.setPropsId(metaData.getPendantData().getPropsId());
                    userPendantData.setImgUrl(metaData.getPendantData().getImgUrl());
                    this.cardVideoInfo.getAuthor().setPendantData(userPendantData);
                }
            }
            if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                cga cgaVar = new cga();
                this.mFrsInsertLiveData = cgaVar;
                cgaVar.b = dataRes.ala_insert_floor.intValue();
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < dataRes.ala_live_insert.ala_live_list.size(); i4++) {
                    if (dataRes.ala_live_insert.ala_live_list.get(i4) != null) {
                        ThreadData threadData3 = new ThreadData();
                        threadData3.parserProtobuf(dataRes.ala_live_insert.ala_live_list.get(i4));
                        threadData3.isFromBrandForum = this.isBrandForum;
                        arrayList.add(threadData3);
                    }
                }
                this.mFrsInsertLiveData.a = arrayList;
            }
            if (dataRes.ala_stage_list != null) {
                this.mFrsStageLiveData = new dga();
                ArrayList arrayList2 = new ArrayList();
                for (int i5 = 0; i5 < dataRes.ala_stage_list.size(); i5++) {
                    if (dataRes.ala_stage_list.get(i5) != null) {
                        ThreadData threadData4 = new ThreadData();
                        threadData4.parserProtobuf(dataRes.ala_stage_list.get(i5));
                        threadData4.isFromBrandForum = this.isBrandForum;
                        arrayList2.add(threadData4);
                    }
                }
                this.mFrsStageLiveData.a = arrayList2;
            }
            if (dataRes.school_recom_info != null) {
                this.schoolRecommendPos = dataRes.school_recom_pos.intValue();
                u35 u35Var = new u35();
                this.schoolRecommendInfo = u35Var;
                u35Var.d(dataRes.school_recom_info);
            }
            if (dataRes.carrier_enter != null) {
                w15 w15Var = new w15();
                this.carrierEnterData = w15Var;
                w15Var.a(dataRes.carrier_enter);
            }
            if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                this.forumState = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                this.accessFlag = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
            }
            this.mSortType = dataRes.sort_type.intValue();
            this.needLog = dataRes.need_log.intValue();
            LocationCacheData.getInstance().setAspShowInfo(dataRes.asp_shown_info);
            this.mCardShipinPos = dataRes.card_shipin_pos;
            if (dataRes.card_shipin_new != null) {
                for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                    ThreadData threadData5 = new ThreadData();
                    if (this.mCardShipinPos != null && this.mCardShipinPos.size() >= dataRes.card_shipin_new.size()) {
                        threadData5.setInsertFloor(this.mCardShipinPos.get(i6).intValue());
                    }
                    threadData5.setIsInsertThread(true);
                    threadData5.parserProtobuf(dataRes.card_shipin_new.get(i6));
                    threadData5.isFromBrandForum = this.isBrandForum;
                    this.mCardShipinNew.add(threadData5);
                }
            }
            this.enterFrsDialogInfo = dataRes.enter_pop_info;
            if (dataRes.esport != null) {
                iz7 iz7Var = new iz7();
                this.mGameRankListData = iz7Var;
                iz7Var.c(dataRes.esport);
            }
            this.agreeBanner = dataRes.agree_banner;
            if (dataRes.user_extend != null) {
                si7 si7Var = new si7();
                this.userRecommend = si7Var;
                si7Var.f(dataRes.user_extend);
            }
            this.liveNotify = dataRes.live_frs_notify;
            this.gameTabInfo = dataRes.frs_game_tab_info;
            this.gameDefaultTabId = dataRes.game_default_tab_id.intValue();
            this.forumHeadIcon = dataRes.forum_head_icon;
            if (dataRes.video != null && dataRes.video.video_act != null) {
                oga ogaVar = new oga();
                this.mFrsVideoActivityData = ogaVar;
                ogaVar.a(dataRes.video.video_act);
            }
            if (dataRes.info != null) {
                this.recm_forum_list = dataRes.info.recm_forum_list;
            }
            this.forumArIno = dataRes.forum_ar_info;
            if (dataRes.star_rank_info != null) {
                this.starRank = dataRes.star_rank_info;
            }
            if (dataRes.recom_post_topic != null) {
                this.postTopic = dataRes.recom_post_topic;
            }
            this.mWindowToast = dataRes.window_toast;
            this.activityConfig = dataRes.activity_config;
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = dataRes.smart_app_avatar;
            this.smartApp = dataRes.smart_app;
            this.nebulaHotThreads = dataRes.nebula_hot_threads;
            if (dataRes.private_forum_info != null) {
                this.privateForumTotalData.d(dataRes.private_forum_info);
            }
            if (dataRes.bawutask_pop != null) {
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                this.mPrivateForumPopInfoData = privateForumPopInfoData;
                privateForumPopInfoData.R(dataRes.bawutask_pop);
            }
            this.forumActiveInfo = dataRes.private_forum_active_info;
            this.userList = dataRes.user_list;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_user_entry;
            this.mHotUserRankData = hotUserRankEntry;
            if (hotUserRankEntry != null) {
                ServiceArea.Builder builder2 = new ServiceArea.Builder();
                builder2.picurl = "icon_mask_service_celebrity24";
                builder2.servicename = "本吧红人榜";
                builder2.service_type = "本吧红人榜";
                this.serviceAreaFlutterData.add(DataExt.toMap(builder2.build(true)));
            }
            if (dataRes.sign_activity_info != null) {
                this.mSignActivityInfo = dataRes.sign_activity_info;
            }
            if (dataRes.add_bawu_pop != null) {
                this.bawuPopInfo = dataRes.add_bawu_pop;
            }
            if (!ListUtils.isEmpty(dataRes.service_area)) {
                this.serviceAreaData = new yga();
                ArrayList arrayList3 = new ArrayList();
                for (ServiceArea serviceArea : dataRes.service_area) {
                    if (serviceArea != null) {
                        this.serviceAreaFlutterData.add(DataExt.toMap(serviceArea));
                        zga zgaVar = new zga();
                        zgaVar.b = serviceArea.picurl;
                        zgaVar.c = serviceArea.servicename;
                        String str = serviceArea.service_type;
                        zgaVar.a = str;
                        if (str != null && str.equals("原生小程序") && serviceArea.area_smart_app != null) {
                            zgaVar.b = serviceArea.area_smart_app.avatar;
                            zgaVar.c = serviceArea.area_smart_app.name;
                        }
                        zgaVar.d = serviceArea.serviceurl;
                        zgaVar.e = serviceArea.schema;
                        zgaVar.i = serviceArea.third_statistics_url;
                        String str2 = serviceArea.version;
                        String string = SharedPrefHelper.getInstance().getString("frs_service_version_" + this.forum.getName() + zgaVar.c, "");
                        if (!TextUtils.isEmpty(string)) {
                            string.equals(serviceArea.version);
                        }
                        zgaVar.j = serviceArea.tag;
                        if (serviceArea.area_smart_app != null) {
                            aha ahaVar = new aha();
                            ahaVar.a(serviceArea.area_smart_app);
                            zgaVar.f = ahaVar;
                        }
                        if (this.forum != null) {
                            this.forum.getName();
                            zgaVar.g = this.forum.getId();
                        }
                        zgaVar.h = i;
                        i++;
                        arrayList3.add(zgaVar);
                    }
                }
                this.serviceAreaData.a = arrayList3.size();
                this.serviceAreaData.b = arrayList3;
            }
            this.itemInfo = dataRes.item_info;
            this.toLoadHorseData = dataRes.is_get_horse_race_lamp;
            this.forumRule = dataRes.forum_rule;
            this.showAdsense = dataRes.show_adsense;
            this.frsMaskPopInfo = dataRes.frsmask_pop_info;
            this.voiceRoomConfig = ce5.b(dataRes);
            de5 de5Var = new de5();
            this.voiceRoomData = de5Var;
            de5Var.d(dataRes);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void setAccessFlag(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            this.accessFlag = i;
        }
    }

    public void setActivityHeadData(c25 c25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, c25Var) == null) {
            this.mActivityHeadData = c25Var;
        }
    }

    public void setAgreeBanner(AgreeBanner agreeBanner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, agreeBanner) == null) {
            this.agreeBanner = agreeBanner;
        }
    }

    public void setAlaLiveCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i) == null) {
            this.alaLiveCount = i;
        }
    }

    public void setAnti(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, antiData) == null) {
            this.anti = antiData;
        }
    }

    public void setBaWuNoticeNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i) == null) {
            this.baWuNoticeNum = i;
        }
    }

    public void setBawuCenterUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            this.bawuCenterUrl = str;
        }
    }

    public void setBookInfo(d25 d25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, d25Var) == null) {
            this.bookInfoData = d25Var;
        }
    }

    public void setBusinessPromot(ega egaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, egaVar) == null) {
            this.businessPromot = egaVar;
        }
    }

    public void setCardShipinNew(List<cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, list) == null) {
            this.mCardShipinNew = list;
        }
    }

    public void setCardShipinPos(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, list) == null) {
            this.mCardShipinPos = list;
        }
    }

    public void setCardVideoInfo(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, threadData) == null) {
            this.cardVideoInfo = threadData;
        }
    }

    public void setCarrierEnterData(w15 w15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, w15Var) == null) {
            this.carrierEnterData = w15Var;
        }
    }

    public void setCategoryInfos(List<CategoryInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, list) == null) {
            this.categoryInfos = list;
        }
    }

    public void setChatGroup(yfa yfaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, yfaVar) == null) {
            this.chatGroup = yfaVar;
        }
    }

    public void setEntelechyTabInfo(lga lgaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, lgaVar) == null) {
            this.mEntelechyTabInfo = lgaVar;
        }
    }

    public void setFortuneBag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z) == null) {
            this.fortuneBag = z;
        }
    }

    public void setFortuneDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, str) == null) {
            this.fortuneDesc = str;
        }
    }

    public void setForum(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, forumData) == null) {
            this.forum = forumData;
        }
    }

    public void setForumHeadIcon(ForumHeadIcon forumHeadIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, forumHeadIcon) == null) {
            this.forumHeadIcon = forumHeadIcon;
        }
    }

    public void setForumState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048664, this, i) == null) {
            this.forumState = i;
        }
    }

    public void setFrsDefaultTabId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048665, this, i) == null) {
            this.frsDefaultTabId = i;
        }
    }

    public void setFrsInsertLiveData(cga cgaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, cgaVar) == null) {
            this.mFrsInsertLiveData = cgaVar;
        }
    }

    public void setFrsStageLiveData(dga dgaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, dgaVar) == null) {
            this.mFrsStageLiveData = dgaVar;
        }
    }

    public void setFrsVideoActivityData(oga ogaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, ogaVar) == null) {
            this.mFrsVideoActivityData = ogaVar;
        }
    }

    public void setGameDefaultTabId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048669, this, i) == null) {
            this.gameDefaultTabId = i;
        }
    }

    public void setGameName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, str) == null) {
            this.gameName = str;
        }
    }

    public void setGameRankListData(iz7 iz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, iz7Var) == null) {
            this.mGameRankListData = iz7Var;
        }
    }

    public void setGameTabInfo(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, list) == null) {
            this.gameTabInfo = list;
        }
    }

    public void setGameUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, str) == null) {
            this.gameUrl = str;
        }
    }

    public void setGconAccount(pga pgaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, pgaVar) == null) {
            this.gconAccount = pgaVar;
        }
    }

    public void setHasGame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048675, this, z) == null) {
            this.hasGame = z;
        }
    }

    public void setHeadSdkData(m25 m25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, m25Var) == null) {
            this.headSdkData = m25Var;
        }
    }

    public void setHeadlineImgInfoData(g25 g25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, g25Var) == null) {
            this.headlineImgInfoData = g25Var;
        }
    }

    public void setHotUserRankData(HotUserRankEntry hotUserRankEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, hotUserRankEntry) == null) {
            this.mHotUserRankData = hotUserRankEntry;
        }
    }

    public void setIsNewUrl(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048679, this, i) == null) {
            this.isNewUrl = i;
        }
    }

    public void setIsShowRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048680, this, z) == null) {
            this.isShowRedTip = z;
        }
    }

    public void setLikeFeedForumDataList(List<FeedForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, list) == null) {
            this.likeFeedForumDataList = list;
        }
    }

    public void setLiveNotify(AlaLiveNotify alaLiveNotify) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, alaLiveNotify) == null) {
            this.liveNotify = alaLiveNotify;
        }
    }

    public void setMangaReadRecordChapterId(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, num) == null) {
            this.mangaReadRecordChapterId = num;
        }
    }

    public void setPage(e35 e35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, e35Var) == null) {
            this.page = e35Var;
        }
    }

    public void setPhotoLivePos(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048685, this, i) == null) {
            this.photoLivePos = i;
        }
    }

    public void setPrivateForumPopInfoData(PrivateForumPopInfoData privateForumPopInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, privateForumPopInfoData) == null) {
            this.mPrivateForumPopInfoData = privateForumPopInfoData;
        }
    }

    public void setPrivateForumTotalInfo(n35 n35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, n35Var) == null) {
            this.privateForumTotalData = n35Var;
        }
    }

    public void setSchoolRecommendInfo(u35 u35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, u35Var) == null) {
            this.schoolRecommendInfo = u35Var;
        }
    }

    public void setSchoolRecommendPos(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048689, this, i) == null) {
            this.schoolRecommendPos = i;
        }
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048690, this, i) == null) {
            this.mSortType = i;
        }
    }

    public void setStar(kga kgaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, kgaVar) == null) {
            this.star = kgaVar;
        }
    }

    public void setStarEnter(List<gga> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, list) == null) {
            this.starEnter = list;
        }
    }

    public void setThreadList(ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, arrayList) == null) {
            this.threadList = arrayList;
        }
    }

    public void setThreadListIds(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, list) == null) {
            this.threadListIds = list;
        }
    }

    public void setUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, userData) == null) {
            this.userData = userData;
        }
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, hashMap) == null) {
            this.userMap = hashMap;
        }
    }

    public void setUserRecommend(si7 si7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, si7Var) == null) {
            this.userRecommend = si7Var;
        }
    }

    public void setVoiceRoomConfig(@Nullable ce5 ce5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, ce5Var) == null) {
            this.voiceRoomConfig = ce5Var;
        }
    }

    public de5 setVoiceRoomData(de5 de5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048699, this, de5Var)) == null) {
            this.voiceRoomData = de5Var;
            return de5Var;
        }
        return (de5) invokeL.objValue;
    }

    public ArrayList<cn> switchThreadDataToThreadCardInfo(ArrayList<cn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048701, this, arrayList)) == null) {
            this.mHasThreadExceptTop = false;
            ArrayList<cn> arrayList2 = new ArrayList<>();
            Iterator<cn> it = arrayList.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                cn next = it.next();
                if (next instanceof t25) {
                    ((t25) next).setPosition(i - i2);
                    arrayList2.add(next);
                } else if (next instanceof u25) {
                    ((u25) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int i3 = i + 1;
                    threadData.floorPosition = i3;
                    threadData.isFromNet = !this.isFromCache;
                    if (threadData.isTop()) {
                        i2++;
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        h45 h45Var = new h45();
                        h45Var.t = threadData;
                        h45Var.position = i;
                        h45Var.a = true;
                        h45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(h45Var);
                        h45 h45Var2 = new h45();
                        h45Var2.t = threadData;
                        h45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            h45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            h45Var2.d = true;
                            h45Var2.u = imageWidthAndHeight[0];
                            h45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            h45Var2.e = true;
                        } else {
                            h45Var2.b = true;
                        }
                        h45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(h45Var2);
                        if (threadData.getPollData() != null) {
                            h45 h45Var3 = new h45();
                            h45Var3.o = true;
                            h45Var3.t = threadData;
                            h45Var3.position = i;
                            h45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            h45 h45Var4 = new h45();
                            h45Var4.l = true;
                            h45Var4.t = threadData;
                            h45Var4.position = i;
                            h45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            h45 h45Var5 = new h45();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                h45Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                h45Var5.q = true;
                            }
                            h45Var5.t = threadData;
                            h45Var5.position = i;
                            h45Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            h45 h45Var6 = new h45();
                            h45Var6.h = true;
                            h45Var6.t = threadData;
                            h45Var6.position = i;
                            h45Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var6);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            h45 h45Var7 = new h45();
                            h45Var7.n = true;
                            h45Var7.t = threadData;
                            h45Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var7);
                        }
                        insertRecommendInfo(threadData, arrayList2, i);
                        insertPeiWanData(threadData, arrayList2, i);
                        h45 h45Var8 = new h45();
                        h45Var8.g = true;
                        h45Var8.t = threadData;
                        h45Var8.position = i;
                        h45Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        if (ThreadCardUtils.isBottomShowOp(threadData)) {
                            arrayList2.add(h45Var8);
                        }
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        h45 h45Var9 = new h45();
                        h45Var9.t = threadData;
                        h45Var9.position = i;
                        h45Var9.a = true;
                        h45Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(h45Var9);
                        h45 h45Var10 = new h45();
                        h45Var10.t = threadData;
                        h45Var10.position = i;
                        if (threadData instanceof b35) {
                            h45Var10.j = true;
                        } else {
                            h45Var10.i = true;
                        }
                        h45Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(h45Var10);
                        if (threadData.getPollData() != null) {
                            h45 h45Var11 = new h45();
                            h45Var11.o = true;
                            h45Var11.t = threadData;
                            h45Var11.position = i;
                            h45Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            h45 h45Var12 = new h45();
                            h45Var12.l = true;
                            h45Var12.t = threadData;
                            h45Var12.position = i;
                            h45Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            h45 h45Var13 = new h45();
                            h45Var13.h = true;
                            h45Var13.t = threadData;
                            h45Var13.position = i;
                            h45Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var13);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            h45 h45Var14 = new h45();
                            h45Var14.n = true;
                            h45Var14.t = threadData;
                            h45Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var14);
                        }
                        insertRecommendInfo(threadData, arrayList2, i);
                        insertPeiWanData(threadData, arrayList2, i);
                        h45 h45Var15 = new h45();
                        h45Var15.g = true;
                        h45Var15.t = threadData;
                        h45Var15.position = i;
                        h45Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        if (ThreadCardUtils.isBottomShowOp(threadData)) {
                            arrayList2.add(h45Var15);
                        }
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        h45 h45Var16 = new h45();
                        h45Var16.t = threadData;
                        h45Var16.position = i;
                        h45Var16.a = true;
                        h45Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(h45Var16);
                        h45 h45Var17 = new h45();
                        h45Var17.t = threadData;
                        h45Var17.position = i;
                        h45Var17.k = true;
                        h45Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(h45Var17);
                        if (threadData.getPollData() != null) {
                            h45 h45Var18 = new h45();
                            h45Var18.o = true;
                            h45Var18.t = threadData;
                            h45Var18.position = i;
                            h45Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            h45 h45Var19 = new h45();
                            h45Var19.l = true;
                            h45Var19.t = threadData;
                            h45Var19.position = i;
                            h45Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            h45 h45Var20 = new h45();
                            h45Var20.h = true;
                            h45Var20.t = threadData;
                            h45Var20.position = i;
                            h45Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var20);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            h45 h45Var21 = new h45();
                            h45Var21.n = true;
                            h45Var21.t = threadData;
                            h45Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(h45Var21);
                        }
                        insertRecommendInfo(threadData, arrayList2, i);
                        insertPeiWanData(threadData, arrayList2, i);
                        h45 h45Var22 = new h45();
                        h45Var22.g = true;
                        h45Var22.t = threadData;
                        h45Var22.position = i;
                        h45Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        if (ThreadCardUtils.isBottomShowOp(threadData)) {
                            arrayList2.add(h45Var22);
                        }
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        h45 h45Var23 = new h45();
                        h45Var23.t = threadData;
                        h45Var23.position = i;
                        arrayList2.add(h45Var23);
                    }
                    threadData.setSupportType(BaseCardInfo.SupportType.TOP);
                    i = i3;
                    if (next != null && next.getType() != ThreadData.TYPE_TOP) {
                        this.mHasThreadExceptTop = true;
                    }
                } else {
                    arrayList2.add(next);
                }
                i++;
                if (next != null) {
                    this.mHasThreadExceptTop = true;
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }
}
