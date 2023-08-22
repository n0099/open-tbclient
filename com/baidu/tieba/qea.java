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
/* loaded from: classes7.dex */
public class qea implements uq5, IResponseData {
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
    public y15 bookInfoData;
    public List<BottomMenu> bottomMenuList;
    @Nullable
    public FrsBountyTaskData bountyTaskData;
    public rg7 brandAdData;
    public lea businessPromot;
    public ThreadData cardVideoInfo;
    public r15 carrierEnterData;
    public List<CategoryInfo> categoryInfos;
    public fea chatGroup;
    public ArrayList<u15> color_eggs;
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
    public wea gconAccount;
    public boolean hasGame;
    public h25 headSdkData;
    public HeaderCard headerCard;
    public b25 headlineImgInfoData;
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
    public x15 mActivityHeadData;
    public List<bn> mCardShipinNew;
    public List<Integer> mCardShipinPos;
    public long mDataParseTime;
    public sea mEntelechyTabInfo;
    public int mErrorNo;
    public jea mFrsInsertLiveData;
    public kea mFrsStageLiveData;
    public vea mFrsVideoActivityData;
    public yx7 mGameRankListData;
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
    public z25 page;
    public int photoLivePos;
    public RecomPostTopic postTopic;
    public e25 presentInfoData;
    public i35 privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    public i25 recommendBookData;
    public p35 schoolRecommendInfo;
    public int schoolRecommendPos;
    public ffa serviceAreaData;
    public List<Map<String, Object>> serviceAreaFlutterData;
    public Integer showAdsense;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    public rea star;
    public List<nea> starEnter;
    public StarRank starRank;
    public ArrayList<bn> threadList;
    public List<Long> threadListIds;
    public Integer toLoadHorseData;
    public List<bn> topThreadList;
    public UserData userData;
    public List<User> userList;
    public HashMap<String, MetaData> userMap;
    public lh7 userRecommend;
    @Nullable
    public sd5 voiceRoomConfig;
    @Nullable
    public td5 voiceRoomData;

    @Override // com.baidu.tieba.vq5
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uq5
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

    @Override // com.baidu.tieba.uq5
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948090332, "Lcom/baidu/tieba/qea;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948090332, "Lcom/baidu/tieba/qea;");
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

    public x15 getActivityHeadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mActivityHeadData;
        }
        return (x15) invokeV.objValue;
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

    public y15 getBookInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.bookInfoData;
        }
        return (y15) invokeV.objValue;
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

    public lea getBusinessPromot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.businessPromot;
        }
        return (lea) invokeV.objValue;
    }

    public List<bn> getCardShipinNew() {
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

    public r15 getCarrierEnterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.carrierEnterData;
        }
        return (r15) invokeV.objValue;
    }

    public List<CategoryInfo> getCategoryInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.categoryInfos;
        }
        return (List) invokeV.objValue;
    }

    public fea getChatGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.chatGroup;
        }
        return (fea) invokeV.objValue;
    }

    public long getDataParseTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mDataParseTime;
        }
        return invokeV.longValue;
    }

    public sea getEntelechyTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mEntelechyTabInfo;
        }
        return (sea) invokeV.objValue;
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

    public jea getFrsInsertLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mFrsInsertLiveData;
        }
        return (jea) invokeV.objValue;
    }

    public kea getFrsStageLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mFrsStageLiveData;
        }
        return (kea) invokeV.objValue;
    }

    public vea getFrsVideoActivityData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mFrsVideoActivityData;
        }
        return (vea) invokeV.objValue;
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

    public yx7 getGameRankListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mGameRankListData;
        }
        return (yx7) invokeV.objValue;
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

    public wea getGconAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.gconAccount;
        }
        return (wea) invokeV.objValue;
    }

    public h25 getHeadSdkData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.headSdkData;
        }
        return (h25) invokeV.objValue;
    }

    public b25 getHeadlineImgInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.headlineImgInfoData;
        }
        return (b25) invokeV.objValue;
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

    public z25 getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.page;
        }
        return (z25) invokeV.objValue;
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

    public i35 getPrivateForumTotalInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.privateForumTotalData;
        }
        return (i35) invokeV.objValue;
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

    public p35 getSchoolRecommendUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.schoolRecommendInfo;
        }
        return (p35) invokeV.objValue;
    }

    public int getSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.mSortType;
        }
        return invokeV.intValue;
    }

    public rea getStar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.star;
        }
        return (rea) invokeV.objValue;
    }

    public List<nea> getStarEnter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.starEnter;
        }
        return (List) invokeV.objValue;
    }

    public ArrayList<bn> getThreadList() {
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

    public lh7 getUserRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.userRecommend;
        }
        return (lh7) invokeV.objValue;
    }

    @NonNull
    public sd5 getVoiceRoomConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            sd5 sd5Var = this.voiceRoomConfig;
            if (sd5Var != null) {
                return sd5Var;
            }
            return sd5.a;
        }
        return (sd5) invokeV.objValue;
    }

    public td5 getVoiceRoomData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.voiceRoomData;
        }
        return (td5) invokeV.objValue;
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

    public ArrayList<bn> switchThreadDataToThreadCardInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            ArrayList<bn> switchThreadDataToThreadCardInfo = switchThreadDataToThreadCardInfo(this.threadList);
            setThreadList(switchThreadDataToThreadCardInfo);
            return switchThreadDataToThreadCardInfo;
        }
        return (ArrayList) invokeV.objValue;
    }

    public qea() {
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
        this.mEntelechyTabInfo = new sea();
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
            this.page = new z25();
            this.star = new rea();
            this.userData = new UserData();
            this.gconAccount = new wea();
            setAnti(new AntiData());
            setChatGroup(new fea());
            this.privateForumTotalData = new i35();
            this.mCardShipinNew = new ArrayList();
            this.mCardShipinPos = new ArrayList();
        }
    }

    private void handleDefaultTab(int i) {
        List<FrsTabInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i) == null) {
            this.frsDefaultTabId = 1;
            sea seaVar = this.mEntelechyTabInfo;
            if (seaVar != null && (list = seaVar.a) != null && list.size() > 0) {
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

    private void insertRecommendInfo(ThreadData threadData, ArrayList<bn> arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, this, threadData, arrayList, i) == null) && threadData != null && arrayList != null && (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            c45 c45Var = new c45();
            c45Var.s = true;
            c45Var.t = threadData;
            c45Var.position = i;
            c45Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            arrayList.add(c45Var);
        }
    }

    private void setRemoveDuplicationFlag(DataRes dataRes, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, dataRes, threadData) == null) && threadData.getThreadType() == 69) {
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
                    p25 p25Var = new p25();
                    p25Var.e(threadData.getLegoCard());
                    this.threadList.add(p25Var);
                } else {
                    this.threadList.add(threadData);
                    JSONObject c = f3a.c(threadInfo, threadData.getForum_name());
                    if (c != null) {
                        arrayList.add(c);
                    }
                }
            }
        }
        f3a.f().h("FRS", arrayList);
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
                        u15 u15Var = new u15();
                        if (u15Var.c(colorEgg)) {
                            this.color_eggs.add(u15Var);
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
                x15 x15Var = new x15();
                this.mActivityHeadData = x15Var;
                x15Var.e(dataRes.brand_forum_info.head_imgs);
                rg7 rg7Var = new rg7();
                this.brandAdData = rg7Var;
                rg7Var.a(dataRes.brand_forum_info);
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
                x15 x15Var2 = new x15();
                this.mActivityHeadData = x15Var2;
                x15Var2.d(dataRes.activityhead, j);
            } else if (dataRes.private_forum_info != null && dataRes.private_forum_info.head_imgs != null && !di.isEmpty(dataRes.private_forum_info.head_imgs.img_url)) {
                x15 x15Var3 = new x15();
                this.mActivityHeadData = x15Var3;
                x15Var3.e(dataRes.private_forum_info.head_imgs);
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
                    nea neaVar = new nea();
                    neaVar.h(list2.get(i3));
                    this.starEnter.add(neaVar);
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
                aoa.g(dataRes.anti.block_pop_info);
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
            if (!di.isEmpty(dataRes.bawu_enter_url)) {
                this.bawuCenterUrl = dataRes.bawu_enter_url;
            }
            if (dataRes.head_sdk != null) {
                h25 h25Var = new h25();
                this.headSdkData = h25Var;
                h25Var.a(dataRes.head_sdk);
            }
            if (dataRes.recommend_book != null) {
                i25 i25Var = new i25();
                this.recommendBookData = i25Var;
                i25Var.c(dataRes.recommend_book);
            }
            if (dataRes.book_info != null) {
                y15 y15Var = new y15();
                this.bookInfoData = y15Var;
                y15Var.c(dataRes.book_info);
            }
            if (dataRes.forum_present_info != null) {
                e25 e25Var = new e25();
                this.presentInfoData = e25Var;
                e25Var.a(dataRes.forum_present_info);
            }
            if (dataRes.forum_headline_img_info != null) {
                b25 b25Var = new b25();
                this.headlineImgInfoData = b25Var;
                b25Var.b(dataRes.forum_headline_img_info);
            }
            if (dataRes.business_promot != null) {
                lea leaVar = new lea();
                this.businessPromot = leaVar;
                leaVar.s(dataRes.business_promot);
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
                jea jeaVar = new jea();
                this.mFrsInsertLiveData = jeaVar;
                jeaVar.b = dataRes.ala_insert_floor.intValue();
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
                this.mFrsStageLiveData = new kea();
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
                p35 p35Var = new p35();
                this.schoolRecommendInfo = p35Var;
                p35Var.d(dataRes.school_recom_info);
            }
            if (dataRes.carrier_enter != null) {
                r15 r15Var = new r15();
                this.carrierEnterData = r15Var;
                r15Var.a(dataRes.carrier_enter);
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
                yx7 yx7Var = new yx7();
                this.mGameRankListData = yx7Var;
                yx7Var.c(dataRes.esport);
            }
            this.agreeBanner = dataRes.agree_banner;
            if (dataRes.user_extend != null) {
                lh7 lh7Var = new lh7();
                this.userRecommend = lh7Var;
                lh7Var.f(dataRes.user_extend);
            }
            this.liveNotify = dataRes.live_frs_notify;
            this.gameTabInfo = dataRes.frs_game_tab_info;
            this.gameDefaultTabId = dataRes.game_default_tab_id.intValue();
            this.forumHeadIcon = dataRes.forum_head_icon;
            if (dataRes.video != null && dataRes.video.video_act != null) {
                vea veaVar = new vea();
                this.mFrsVideoActivityData = veaVar;
                veaVar.a(dataRes.video.video_act);
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
                privateForumPopInfoData.S(dataRes.bawutask_pop);
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
                this.serviceAreaData = new ffa();
                ArrayList arrayList3 = new ArrayList();
                for (ServiceArea serviceArea : dataRes.service_area) {
                    if (serviceArea != null) {
                        this.serviceAreaFlutterData.add(DataExt.toMap(serviceArea));
                        gfa gfaVar = new gfa();
                        gfaVar.b = serviceArea.picurl;
                        gfaVar.c = serviceArea.servicename;
                        String str = serviceArea.service_type;
                        gfaVar.a = str;
                        if (str != null && str.equals("原生小程序") && serviceArea.area_smart_app != null) {
                            gfaVar.b = serviceArea.area_smart_app.avatar;
                            gfaVar.c = serviceArea.area_smart_app.name;
                        }
                        gfaVar.d = serviceArea.serviceurl;
                        gfaVar.e = serviceArea.schema;
                        gfaVar.i = serviceArea.third_statistics_url;
                        String str2 = serviceArea.version;
                        String string = SharedPrefHelper.getInstance().getString("frs_service_version_" + this.forum.getName() + gfaVar.c, "");
                        if (!TextUtils.isEmpty(string)) {
                            string.equals(serviceArea.version);
                        }
                        gfaVar.j = serviceArea.tag;
                        if (serviceArea.area_smart_app != null) {
                            hfa hfaVar = new hfa();
                            hfaVar.a(serviceArea.area_smart_app);
                            gfaVar.f = hfaVar;
                        }
                        if (this.forum != null) {
                            this.forum.getName();
                            gfaVar.g = this.forum.getId();
                        }
                        gfaVar.h = i;
                        i++;
                        arrayList3.add(gfaVar);
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
            this.voiceRoomConfig = sd5.b(dataRes);
            td5 td5Var = new td5();
            this.voiceRoomData = td5Var;
            td5Var.d(dataRes);
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

    public void setActivityHeadData(x15 x15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, x15Var) == null) {
            this.mActivityHeadData = x15Var;
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

    public void setBookInfo(y15 y15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, y15Var) == null) {
            this.bookInfoData = y15Var;
        }
    }

    public void setBusinessPromot(lea leaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, leaVar) == null) {
            this.businessPromot = leaVar;
        }
    }

    public void setCardShipinNew(List<bn> list) {
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

    public void setCarrierEnterData(r15 r15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, r15Var) == null) {
            this.carrierEnterData = r15Var;
        }
    }

    public void setCategoryInfos(List<CategoryInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, list) == null) {
            this.categoryInfos = list;
        }
    }

    public void setChatGroup(fea feaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, feaVar) == null) {
            this.chatGroup = feaVar;
        }
    }

    public void setEntelechyTabInfo(sea seaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, seaVar) == null) {
            this.mEntelechyTabInfo = seaVar;
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

    public void setFrsInsertLiveData(jea jeaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, jeaVar) == null) {
            this.mFrsInsertLiveData = jeaVar;
        }
    }

    public void setFrsStageLiveData(kea keaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, keaVar) == null) {
            this.mFrsStageLiveData = keaVar;
        }
    }

    public void setFrsVideoActivityData(vea veaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, veaVar) == null) {
            this.mFrsVideoActivityData = veaVar;
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

    public void setGameRankListData(yx7 yx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, yx7Var) == null) {
            this.mGameRankListData = yx7Var;
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

    public void setGconAccount(wea weaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, weaVar) == null) {
            this.gconAccount = weaVar;
        }
    }

    public void setHasGame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048675, this, z) == null) {
            this.hasGame = z;
        }
    }

    public void setHeadSdkData(h25 h25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, h25Var) == null) {
            this.headSdkData = h25Var;
        }
    }

    public void setHeadlineImgInfoData(b25 b25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, b25Var) == null) {
            this.headlineImgInfoData = b25Var;
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

    public void setPage(z25 z25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, z25Var) == null) {
            this.page = z25Var;
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

    public void setPrivateForumTotalInfo(i35 i35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, i35Var) == null) {
            this.privateForumTotalData = i35Var;
        }
    }

    public void setSchoolRecommendInfo(p35 p35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, p35Var) == null) {
            this.schoolRecommendInfo = p35Var;
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

    public void setStar(rea reaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, reaVar) == null) {
            this.star = reaVar;
        }
    }

    public void setStarEnter(List<nea> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, list) == null) {
            this.starEnter = list;
        }
    }

    public void setThreadList(ArrayList<bn> arrayList) {
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

    public void setUserRecommend(lh7 lh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, lh7Var) == null) {
            this.userRecommend = lh7Var;
        }
    }

    public void setVoiceRoomConfig(@Nullable sd5 sd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, sd5Var) == null) {
            this.voiceRoomConfig = sd5Var;
        }
    }

    public td5 setVoiceRoomData(td5 td5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048699, this, td5Var)) == null) {
            this.voiceRoomData = td5Var;
            return td5Var;
        }
        return (td5) invokeL.objValue;
    }

    public ArrayList<bn> switchThreadDataToThreadCardInfo(ArrayList<bn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048701, this, arrayList)) == null) {
            this.mHasThreadExceptTop = false;
            ArrayList<bn> arrayList2 = new ArrayList<>();
            Iterator<bn> it = arrayList.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                bn next = it.next();
                if (next instanceof o25) {
                    ((o25) next).setPosition(i - i2);
                    arrayList2.add(next);
                } else if (next instanceof p25) {
                    ((p25) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    if (threadData.isTop()) {
                        i2++;
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        c45 c45Var = new c45();
                        c45Var.t = threadData;
                        c45Var.position = i;
                        c45Var.a = true;
                        c45Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(c45Var);
                        c45 c45Var2 = new c45();
                        c45Var2.t = threadData;
                        c45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            c45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            c45Var2.d = true;
                            c45Var2.u = imageWidthAndHeight[0];
                            c45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            c45Var2.e = true;
                        } else {
                            c45Var2.b = true;
                        }
                        c45Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(c45Var2);
                        if (threadData.getPollData() != null) {
                            c45 c45Var3 = new c45();
                            c45Var3.o = true;
                            c45Var3.t = threadData;
                            c45Var3.position = i;
                            c45Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c45Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            c45 c45Var4 = new c45();
                            c45Var4.l = true;
                            c45Var4.t = threadData;
                            c45Var4.position = i;
                            c45Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c45Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            c45 c45Var5 = new c45();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                c45Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                c45Var5.q = true;
                            }
                            c45Var5.t = threadData;
                            c45Var5.position = i;
                            c45Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c45Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            c45 c45Var6 = new c45();
                            c45Var6.h = true;
                            c45Var6.t = threadData;
                            c45Var6.position = i;
                            c45Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c45Var6);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            c45 c45Var7 = new c45();
                            c45Var7.n = true;
                            c45Var7.t = threadData;
                            c45Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c45Var7);
                        }
                        insertRecommendInfo(threadData, arrayList2, i);
                        c45 c45Var8 = new c45();
                        c45Var8.g = true;
                        c45Var8.t = threadData;
                        c45Var8.position = i;
                        c45Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c45Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        c45 c45Var9 = new c45();
                        c45Var9.t = threadData;
                        c45Var9.position = i;
                        c45Var9.a = true;
                        c45Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(c45Var9);
                        c45 c45Var10 = new c45();
                        c45Var10.t = threadData;
                        c45Var10.position = i;
                        if (threadData instanceof w25) {
                            c45Var10.j = true;
                        } else {
                            c45Var10.i = true;
                        }
                        c45Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(c45Var10);
                        if (threadData.getPollData() != null) {
                            c45 c45Var11 = new c45();
                            c45Var11.o = true;
                            c45Var11.t = threadData;
                            c45Var11.position = i;
                            c45Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c45Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            c45 c45Var12 = new c45();
                            c45Var12.l = true;
                            c45Var12.t = threadData;
                            c45Var12.position = i;
                            c45Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c45Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            c45 c45Var13 = new c45();
                            c45Var13.h = true;
                            c45Var13.t = threadData;
                            c45Var13.position = i;
                            c45Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c45Var13);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            c45 c45Var14 = new c45();
                            c45Var14.n = true;
                            c45Var14.t = threadData;
                            c45Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c45Var14);
                        }
                        insertRecommendInfo(threadData, arrayList2, i);
                        c45 c45Var15 = new c45();
                        c45Var15.g = true;
                        c45Var15.t = threadData;
                        c45Var15.position = i;
                        c45Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c45Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        c45 c45Var16 = new c45();
                        c45Var16.t = threadData;
                        c45Var16.position = i;
                        c45Var16.a = true;
                        c45Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(c45Var16);
                        c45 c45Var17 = new c45();
                        c45Var17.t = threadData;
                        c45Var17.position = i;
                        c45Var17.k = true;
                        c45Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(c45Var17);
                        if (threadData.getPollData() != null) {
                            c45 c45Var18 = new c45();
                            c45Var18.o = true;
                            c45Var18.t = threadData;
                            c45Var18.position = i;
                            c45Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c45Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            c45 c45Var19 = new c45();
                            c45Var19.l = true;
                            c45Var19.t = threadData;
                            c45Var19.position = i;
                            c45Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c45Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            c45 c45Var20 = new c45();
                            c45Var20.h = true;
                            c45Var20.t = threadData;
                            c45Var20.position = i;
                            c45Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c45Var20);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            c45 c45Var21 = new c45();
                            c45Var21.n = true;
                            c45Var21.t = threadData;
                            c45Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c45Var21);
                        }
                        insertRecommendInfo(threadData, arrayList2, i);
                        c45 c45Var22 = new c45();
                        c45Var22.g = true;
                        c45Var22.t = threadData;
                        c45Var22.position = i;
                        c45Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c45Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        c45 c45Var23 = new c45();
                        c45Var23.t = threadData;
                        c45Var23.position = i;
                        arrayList2.add(c45Var23);
                    }
                    i++;
                    threadData.setSupportType(BaseCardInfo.SupportType.TOP);
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
