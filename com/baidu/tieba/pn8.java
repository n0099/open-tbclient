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
import com.baidu.tbadk.core.data.FrsGameRankInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.card.data.BaseCardInfo;
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
import tbclient.FrsPage.ForumHeadIcon;
import tbclient.FrsPage.FrsPageResIdl;
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
/* loaded from: classes5.dex */
public class pn8 implements oc5, uc5 {
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
    public rs4 bookInfoData;
    public List<BottomMenu> bottomMenuList;
    public ni6 brandAdData;
    public kn8 businessPromot;
    public ThreadData cardVideoInfo;
    public ls4 carrierEnterData;
    public List<CategoryInfo> categoryInfos;
    public en8 chatGroup;
    public ArrayList<ns4> color_eggs;
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
    public int frsDefaultTabId;
    public FrsGameRankInfoData frsGameRankInfoData;
    public PopInfo frsMaskPopInfo;
    public int gameDefaultTabId;
    public String gameName;
    public List<FrsTabInfo> gameTabInfo;
    public String gameUrl;
    public vn8 gconAccount;
    public boolean hasGame;
    public zs4 headSdkData;
    public us4 headlineImgInfoData;
    public boolean isBrandForum;
    public boolean isFromCache;
    public boolean isFrsVideoAutoPlay;
    public int isNewUrl;
    public boolean isShowRedTip;
    public ItemInfo itemInfo;
    public List<FeedForumData> likeFeedForumDataList;
    public List<LiveFuseForumData> liveFuseForumDataList;
    public AlaLiveNotify liveNotify;
    public qs4 mActivityHeadData;
    public List<wn> mCardShipinNew;
    public List<Integer> mCardShipinPos;
    public long mDataParseTime;
    public rn8 mEntelechyTabInfo;
    public int mErrorNo;
    public in8 mFrsInsertLiveData;
    public jn8 mFrsStageLiveData;
    public un8 mFrsVideoActivityData;
    public dx6 mGameRankListData;
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
    public st4 page;
    public int photoLivePos;
    public RecomPostTopic postTopic;
    public xs4 presentInfoData;
    public bu4 privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    public at4 recommendBookData;
    public iu4 schoolRecommendInfo;
    public int schoolRecommendPos;
    public fo8 serviceAreaData;
    public List<Map<String, Object>> serviceAreaFlutterData;
    public Integer showAdsense;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    public qn8 star;
    public List<mn8> starEnter;
    public StarRank starRank;
    public ArrayList<wn> threadList;
    public List<Long> threadListIds;
    public Integer toLoadHorseData;
    public List<wn> topThreadList;
    public UserData userData;
    public List<User> userList;
    public HashMap<String, MetaData> userMap;
    public hj6 userRecommend;
    @Nullable
    public y25 voiceRoomConfig;
    @Nullable
    public z25 voiceRoomData;

    @Override // com.baidu.tieba.pc5
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oc5
    public boolean initByByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, bArr)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.uc5
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tieba.uc5
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, message) == null) {
        }
    }

    @Override // com.baidu.tieba.oc5
    public byte[] toCacheByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948067919, "Lcom/baidu/tieba/pn8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948067919, "Lcom/baidu/tieba/pn8;");
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

    public qs4 getActivityHeadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mActivityHeadData;
        }
        return (qs4) invokeV.objValue;
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

    public rs4 getBookInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.bookInfoData;
        }
        return (rs4) invokeV.objValue;
    }

    public kn8 getBusinessPromot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.businessPromot;
        }
        return (kn8) invokeV.objValue;
    }

    public List<wn> getCardShipinNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mCardShipinNew;
        }
        return (List) invokeV.objValue;
    }

    public List<Integer> getCardShipinPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mCardShipinPos;
        }
        return (List) invokeV.objValue;
    }

    public ThreadData getCardVideoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.cardVideoInfo;
        }
        return (ThreadData) invokeV.objValue;
    }

    public ls4 getCarrierEnterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.carrierEnterData;
        }
        return (ls4) invokeV.objValue;
    }

    public List<CategoryInfo> getCategoryInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.categoryInfos;
        }
        return (List) invokeV.objValue;
    }

    public en8 getChatGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.chatGroup;
        }
        return (en8) invokeV.objValue;
    }

    public long getDataParseTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mDataParseTime;
        }
        return invokeV.longValue;
    }

    public rn8 getEntelechyTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mEntelechyTabInfo;
        }
        return (rn8) invokeV.objValue;
    }

    public String getFortuneDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.fortuneDesc;
        }
        return (String) invokeV.objValue;
    }

    public ForumData getForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.forum;
        }
        return (ForumData) invokeV.objValue;
    }

    public ForumHeadIcon getForumHeadIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.forumHeadIcon;
        }
        return (ForumHeadIcon) invokeV.objValue;
    }

    public int getForumState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.forumState;
        }
        return invokeV.intValue;
    }

    public int getFrsDefaultTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.frsDefaultTabId;
        }
        return invokeV.intValue;
    }

    public in8 getFrsInsertLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mFrsInsertLiveData;
        }
        return (in8) invokeV.objValue;
    }

    public jn8 getFrsStageLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mFrsStageLiveData;
        }
        return (jn8) invokeV.objValue;
    }

    public un8 getFrsVideoActivityData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mFrsVideoActivityData;
        }
        return (un8) invokeV.objValue;
    }

    public int getGameDefaultTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.gameDefaultTabId;
        }
        return invokeV.intValue;
    }

    public String getGameName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.gameName;
        }
        return (String) invokeV.objValue;
    }

    public dx6 getGameRankListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mGameRankListData;
        }
        return (dx6) invokeV.objValue;
    }

    public List<FrsTabInfo> getGameTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.gameTabInfo;
        }
        return (List) invokeV.objValue;
    }

    public String getGameUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.gameUrl;
        }
        return (String) invokeV.objValue;
    }

    public vn8 getGconAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.gconAccount;
        }
        return (vn8) invokeV.objValue;
    }

    public zs4 getHeadSdkData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.headSdkData;
        }
        return (zs4) invokeV.objValue;
    }

    public us4 getHeadlineImgInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.headlineImgInfoData;
        }
        return (us4) invokeV.objValue;
    }

    public HotUserRankEntry getHotUserRankData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.mHotUserRankData;
        }
        return (HotUserRankEntry) invokeV.objValue;
    }

    public int getIsNewUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.isNewUrl;
        }
        return invokeV.intValue;
    }

    public List<FeedForumData> getLikeFeedForumDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.likeFeedForumDataList;
        }
        return (List) invokeV.objValue;
    }

    public AlaLiveNotify getLiveNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.liveNotify;
        }
        return (AlaLiveNotify) invokeV.objValue;
    }

    public Integer getMangaReadRecordChapterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.mangaReadRecordChapterId;
        }
        return (Integer) invokeV.objValue;
    }

    public st4 getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.page;
        }
        return (st4) invokeV.objValue;
    }

    public int getPhotoLivePos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.photoLivePos;
        }
        return invokeV.intValue;
    }

    public PrivateForumPopInfoData getPrivateForumPopInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.mPrivateForumPopInfoData;
        }
        return (PrivateForumPopInfoData) invokeV.objValue;
    }

    public bu4 getPrivateForumTotalInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.privateForumTotalData;
        }
        return (bu4) invokeV.objValue;
    }

    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.recm_forum_list;
        }
        return (List) invokeV.objValue;
    }

    public int getSchoolRecommendPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.schoolRecommendPos;
        }
        return invokeV.intValue;
    }

    public iu4 getSchoolRecommendUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.schoolRecommendInfo;
        }
        return (iu4) invokeV.objValue;
    }

    public int getSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.mSortType;
        }
        return invokeV.intValue;
    }

    public qn8 getStar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.star;
        }
        return (qn8) invokeV.objValue;
    }

    public List<mn8> getStarEnter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.starEnter;
        }
        return (List) invokeV.objValue;
    }

    public ArrayList<wn> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.threadList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<Long> getThreadListIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.threadListIds;
        }
        return (List) invokeV.objValue;
    }

    public Integer getToLoadHorseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.toLoadHorseData;
        }
        return (Integer) invokeV.objValue;
    }

    public UserData getUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.userData;
        }
        return (UserData) invokeV.objValue;
    }

    public HashMap<String, MetaData> getUserMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.userMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public hj6 getUserRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.userRecommend;
        }
        return (hj6) invokeV.objValue;
    }

    @NonNull
    public y25 getVoiceRoomConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            y25 y25Var = this.voiceRoomConfig;
            if (y25Var != null) {
                return y25Var;
            }
            return y25.a;
        }
        return (y25) invokeV.objValue;
    }

    public z25 getVoiceRoomData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.voiceRoomData;
        }
        return (z25) invokeV.objValue;
    }

    public boolean isFortuneBag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.fortuneBag;
        }
        return invokeV.booleanValue;
    }

    public boolean isHasGame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.hasGame;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowRedTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.isShowRedTip;
        }
        return invokeV.booleanValue;
    }

    public ArrayList<wn> switchThreadDataToThreadCardInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            ArrayList<wn> switchThreadDataToThreadCardInfo = switchThreadDataToThreadCardInfo(this.threadList);
            setThreadList(switchThreadDataToThreadCardInfo);
            return switchThreadDataToThreadCardInfo;
        }
        return (ArrayList) invokeV.objValue;
    }

    public pn8() {
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
        this.mEntelechyTabInfo = new rn8();
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
            this.page = new st4();
            this.star = new qn8();
            this.userData = new UserData();
            this.gconAccount = new vn8();
            setAnti(new AntiData());
            setChatGroup(new en8());
            this.privateForumTotalData = new bu4();
            this.mCardShipinNew = new ArrayList();
            this.mCardShipinPos = new ArrayList();
        }
    }

    private void handleDefaultTab(int i) {
        List<FrsTabInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i) == null) {
            this.frsDefaultTabId = 1;
            rn8 rn8Var = this.mEntelechyTabInfo;
            if (rn8Var != null && (list = rn8Var.a) != null && list.size() > 0) {
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

    private void insertRecommendInfo(ThreadData threadData, ArrayList<wn> arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, this, threadData, arrayList, i) == null) && threadData != null && arrayList != null && (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            vu4 vu4Var = new vu4();
            vu4Var.s = true;
            vu4Var.t = threadData;
            vu4Var.position = i;
            vu4Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            arrayList.add(vu4Var);
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
                if (!TextUtils.isEmpty(threadData.getLegoCard())) {
                    ht4 ht4Var = new ht4();
                    ht4Var.h(threadData.getLegoCard());
                    this.threadList.add(ht4Var);
                } else {
                    this.threadList.add(threadData);
                    JSONObject c = hh8.c(threadInfo, threadData.getForum_name());
                    if (c != null) {
                        arrayList.add(c);
                    }
                }
            }
        }
        hh8.f().h("FRS", arrayList);
    }

    public FrsPageResIdl parserProtobuf(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048641, this, bArr, z)) == null) {
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
        long j2;
        boolean z2;
        boolean z3;
        MetaData metaData;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048642, this, dataRes) != null) || dataRes == null) {
            return;
        }
        try {
            initData();
            if (!ListUtils.isEmpty(dataRes.color_egg)) {
                for (ColorEgg colorEgg : dataRes.color_egg) {
                    if (colorEgg != null && !ListUtils.isEmpty(colorEgg.holiday_words)) {
                        ns4 ns4Var = new ns4();
                        if (ns4Var.c(colorEgg)) {
                            this.color_eggs.add(ns4Var);
                        }
                    }
                }
            }
            int i = 0;
            if (dataRes.forum != null) {
                if (dataRes.forum.has_game.intValue() == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.hasGame = z4;
                this.gameUrl = dataRes.forum.game_url;
                this.gameName = dataRes.forum.game_name;
                if (dataRes.forum.is_brand_forum.intValue() == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                this.isBrandForum = z5;
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
            if (this.isBrandForum && dataRes.brand_forum_info != null) {
                qs4 qs4Var = new qs4();
                this.mActivityHeadData = qs4Var;
                qs4Var.e(dataRes.brand_forum_info.head_imgs);
                ni6 ni6Var = new ni6();
                this.brandAdData = ni6Var;
                ni6Var.a(dataRes.brand_forum_info);
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
                qs4 qs4Var2 = new qs4();
                this.mActivityHeadData = qs4Var2;
                qs4Var2.d(dataRes.activityhead, j);
            } else if (dataRes.private_forum_info != null && dataRes.private_forum_info.head_imgs != null && !wi.isEmpty(dataRes.private_forum_info.head_imgs.img_url)) {
                qs4 qs4Var3 = new qs4();
                this.mActivityHeadData = qs4Var3;
                qs4Var3.e(dataRes.private_forum_info.head_imgs);
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
                z = true;
            } else {
                z = false;
            }
            this.fortuneBag = z;
            this.fortuneDesc = dataRes.fortune_desc;
            List<StarEnter> list2 = dataRes.star_enter;
            this.starEnter.clear();
            if (list2 != null) {
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    mn8 mn8Var = new mn8();
                    mn8Var.k(list2.get(i3));
                    this.starEnter.add(mn8Var);
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
                tv8.g(dataRes.anti.block_pop_info);
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
                z2 = true;
            } else {
                z2 = false;
            }
            this.isShowRedTip = z2;
            convertThreadInfoToThreadData(dataRes, dataRes.thread_list, j2);
            this.categoryInfos = dataRes.category_list;
            if (!wi.isEmpty(dataRes.bawu_enter_url)) {
                this.bawuCenterUrl = dataRes.bawu_enter_url;
            }
            if (dataRes.head_sdk != null) {
                zs4 zs4Var = new zs4();
                this.headSdkData = zs4Var;
                zs4Var.a(dataRes.head_sdk);
            }
            if (dataRes.recommend_book != null) {
                at4 at4Var = new at4();
                this.recommendBookData = at4Var;
                at4Var.c(dataRes.recommend_book);
            }
            if (dataRes.book_info != null) {
                rs4 rs4Var = new rs4();
                this.bookInfoData = rs4Var;
                rs4Var.c(dataRes.book_info);
            }
            if (dataRes.forum_present_info != null) {
                xs4 xs4Var = new xs4();
                this.presentInfoData = xs4Var;
                xs4Var.a(dataRes.forum_present_info);
            }
            if (dataRes.forum_headline_img_info != null) {
                us4 us4Var = new us4();
                this.headlineImgInfoData = us4Var;
                us4Var.b(dataRes.forum_headline_img_info);
            }
            if (dataRes.business_promot != null) {
                kn8 kn8Var = new kn8();
                this.businessPromot = kn8Var;
                kn8Var.s(dataRes.business_promot);
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
                    z3 = true;
                } else {
                    z3 = false;
                }
                threadData2.setFloor5Video(z3);
                if (this.cardVideoInfo.getAuthor() != null && this.cardVideoInfo.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.cardVideoInfo.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                    UserPendantData userPendantData = new UserPendantData();
                    userPendantData.setPropsId(metaData.getPendantData().getPropsId());
                    userPendantData.setImgUrl(metaData.getPendantData().getImgUrl());
                    this.cardVideoInfo.getAuthor().setPendantData(userPendantData);
                }
            }
            if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                in8 in8Var = new in8();
                this.mFrsInsertLiveData = in8Var;
                in8Var.b = dataRes.ala_insert_floor.intValue();
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
                this.mFrsStageLiveData = new jn8();
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
                iu4 iu4Var = new iu4();
                this.schoolRecommendInfo = iu4Var;
                iu4Var.f(dataRes.school_recom_info);
            }
            if (dataRes.carrier_enter != null) {
                ls4 ls4Var = new ls4();
                this.carrierEnterData = ls4Var;
                ls4Var.a(dataRes.carrier_enter);
            }
            if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                this.forumState = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                this.accessFlag = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
            }
            this.mSortType = dataRes.sort_type.intValue();
            this.needLog = dataRes.need_log.intValue();
            eh8.e().h(dataRes.asp_shown_info);
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
                dx6 dx6Var = new dx6();
                this.mGameRankListData = dx6Var;
                dx6Var.c(dataRes.esport);
            }
            this.agreeBanner = dataRes.agree_banner;
            if (dataRes.user_extend != null) {
                hj6 hj6Var = new hj6();
                this.userRecommend = hj6Var;
                hj6Var.h(dataRes.user_extend);
            }
            this.liveNotify = dataRes.live_frs_notify;
            this.gameTabInfo = dataRes.frs_game_tab_info;
            this.gameDefaultTabId = dataRes.game_default_tab_id.intValue();
            this.forumHeadIcon = dataRes.forum_head_icon;
            if (dataRes.video != null && dataRes.video.video_act != null) {
                un8 un8Var = new un8();
                this.mFrsVideoActivityData = un8Var;
                un8Var.a(dataRes.video.video_act);
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
                privateForumPopInfoData.E(dataRes.bawutask_pop);
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
                this.serviceAreaData = new fo8();
                ArrayList arrayList3 = new ArrayList();
                for (ServiceArea serviceArea : dataRes.service_area) {
                    if (serviceArea != null) {
                        this.serviceAreaFlutterData.add(DataExt.toMap(serviceArea));
                        go8 go8Var = new go8();
                        go8Var.b = serviceArea.picurl;
                        go8Var.c = serviceArea.servicename;
                        String str = serviceArea.service_type;
                        go8Var.a = str;
                        if (str != null && str.equals("原生小程序") && serviceArea.area_smart_app != null) {
                            go8Var.b = serviceArea.area_smart_app.avatar;
                            go8Var.c = serviceArea.area_smart_app.name;
                        }
                        go8Var.d = serviceArea.serviceurl;
                        go8Var.e = serviceArea.schema;
                        go8Var.i = serviceArea.third_statistics_url;
                        String str2 = serviceArea.version;
                        String q = ky4.k().q("frs_service_version_" + this.forum.getName() + go8Var.c, "");
                        if (!TextUtils.isEmpty(q)) {
                            q.equals(serviceArea.version);
                        }
                        if (serviceArea.area_smart_app != null) {
                            ho8 ho8Var = new ho8();
                            ho8Var.a(serviceArea.area_smart_app);
                            go8Var.f = ho8Var;
                        }
                        if (this.forum != null) {
                            this.forum.getName();
                            go8Var.g = this.forum.getId();
                        }
                        go8Var.h = i;
                        i++;
                        arrayList3.add(go8Var);
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
            this.voiceRoomConfig = y25.b(dataRes);
            z25 z25Var = new z25();
            this.voiceRoomData = z25Var;
            z25Var.d(dataRes);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void setAccessFlag(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i) == null) {
            this.accessFlag = i;
        }
    }

    public void setActivityHeadData(qs4 qs4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, qs4Var) == null) {
            this.mActivityHeadData = qs4Var;
        }
    }

    public void setAgreeBanner(AgreeBanner agreeBanner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, agreeBanner) == null) {
            this.agreeBanner = agreeBanner;
        }
    }

    public void setAlaLiveCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i) == null) {
            this.alaLiveCount = i;
        }
    }

    public void setAnti(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, antiData) == null) {
            this.anti = antiData;
        }
    }

    public void setBaWuNoticeNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i) == null) {
            this.baWuNoticeNum = i;
        }
    }

    public void setBawuCenterUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, str) == null) {
            this.bawuCenterUrl = str;
        }
    }

    public void setBookInfo(rs4 rs4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, rs4Var) == null) {
            this.bookInfoData = rs4Var;
        }
    }

    public void setBusinessPromot(kn8 kn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, kn8Var) == null) {
            this.businessPromot = kn8Var;
        }
    }

    public void setCardShipinNew(List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, list) == null) {
            this.mCardShipinNew = list;
        }
    }

    public void setCardShipinPos(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, list) == null) {
            this.mCardShipinPos = list;
        }
    }

    public void setCardVideoInfo(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, threadData) == null) {
            this.cardVideoInfo = threadData;
        }
    }

    public void setCarrierEnterData(ls4 ls4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, ls4Var) == null) {
            this.carrierEnterData = ls4Var;
        }
    }

    public void setCategoryInfos(List<CategoryInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, list) == null) {
            this.categoryInfos = list;
        }
    }

    public void setChatGroup(en8 en8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, en8Var) == null) {
            this.chatGroup = en8Var;
        }
    }

    public void setEntelechyTabInfo(rn8 rn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, rn8Var) == null) {
            this.mEntelechyTabInfo = rn8Var;
        }
    }

    public void setFortuneBag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z) == null) {
            this.fortuneBag = z;
        }
    }

    public void setFortuneDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            this.fortuneDesc = str;
        }
    }

    public void setForum(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, forumData) == null) {
            this.forum = forumData;
        }
    }

    public void setForumHeadIcon(ForumHeadIcon forumHeadIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, forumHeadIcon) == null) {
            this.forumHeadIcon = forumHeadIcon;
        }
    }

    public void setForumState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048663, this, i) == null) {
            this.forumState = i;
        }
    }

    public void setFrsDefaultTabId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048664, this, i) == null) {
            this.frsDefaultTabId = i;
        }
    }

    public void setFrsInsertLiveData(in8 in8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, in8Var) == null) {
            this.mFrsInsertLiveData = in8Var;
        }
    }

    public void setFrsStageLiveData(jn8 jn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, jn8Var) == null) {
            this.mFrsStageLiveData = jn8Var;
        }
    }

    public void setFrsVideoActivityData(un8 un8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, un8Var) == null) {
            this.mFrsVideoActivityData = un8Var;
        }
    }

    public void setGameDefaultTabId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048668, this, i) == null) {
            this.gameDefaultTabId = i;
        }
    }

    public void setGameName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, str) == null) {
            this.gameName = str;
        }
    }

    public void setGameRankListData(dx6 dx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, dx6Var) == null) {
            this.mGameRankListData = dx6Var;
        }
    }

    public void setGameTabInfo(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, list) == null) {
            this.gameTabInfo = list;
        }
    }

    public void setGameUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, str) == null) {
            this.gameUrl = str;
        }
    }

    public void setGconAccount(vn8 vn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, vn8Var) == null) {
            this.gconAccount = vn8Var;
        }
    }

    public void setHasGame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z) == null) {
            this.hasGame = z;
        }
    }

    public void setHeadSdkData(zs4 zs4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, zs4Var) == null) {
            this.headSdkData = zs4Var;
        }
    }

    public void setHeadlineImgInfoData(us4 us4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, us4Var) == null) {
            this.headlineImgInfoData = us4Var;
        }
    }

    public void setHotUserRankData(HotUserRankEntry hotUserRankEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, hotUserRankEntry) == null) {
            this.mHotUserRankData = hotUserRankEntry;
        }
    }

    public void setIsNewUrl(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048678, this, i) == null) {
            this.isNewUrl = i;
        }
    }

    public void setIsShowRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048679, this, z) == null) {
            this.isShowRedTip = z;
        }
    }

    public void setLikeFeedForumDataList(List<FeedForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, list) == null) {
            this.likeFeedForumDataList = list;
        }
    }

    public void setLiveNotify(AlaLiveNotify alaLiveNotify) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, alaLiveNotify) == null) {
            this.liveNotify = alaLiveNotify;
        }
    }

    public void setMangaReadRecordChapterId(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, num) == null) {
            this.mangaReadRecordChapterId = num;
        }
    }

    public void setPage(st4 st4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, st4Var) == null) {
            this.page = st4Var;
        }
    }

    public void setPhotoLivePos(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i) == null) {
            this.photoLivePos = i;
        }
    }

    public void setPrivateForumPopInfoData(PrivateForumPopInfoData privateForumPopInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, privateForumPopInfoData) == null) {
            this.mPrivateForumPopInfoData = privateForumPopInfoData;
        }
    }

    public void setPrivateForumTotalInfo(bu4 bu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, bu4Var) == null) {
            this.privateForumTotalData = bu4Var;
        }
    }

    public void setSchoolRecommendInfo(iu4 iu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, iu4Var) == null) {
            this.schoolRecommendInfo = iu4Var;
        }
    }

    public void setSchoolRecommendPos(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048688, this, i) == null) {
            this.schoolRecommendPos = i;
        }
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048689, this, i) == null) {
            this.mSortType = i;
        }
    }

    public void setStar(qn8 qn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, qn8Var) == null) {
            this.star = qn8Var;
        }
    }

    public void setStarEnter(List<mn8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, list) == null) {
            this.starEnter = list;
        }
    }

    public void setThreadList(ArrayList<wn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, arrayList) == null) {
            this.threadList = arrayList;
        }
    }

    public void setThreadListIds(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, list) == null) {
            this.threadListIds = list;
        }
    }

    public void setUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, userData) == null) {
            this.userData = userData;
        }
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, hashMap) == null) {
            this.userMap = hashMap;
        }
    }

    public void setUserRecommend(hj6 hj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, hj6Var) == null) {
            this.userRecommend = hj6Var;
        }
    }

    public void setVoiceRoomConfig(@Nullable y25 y25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, y25Var) == null) {
            this.voiceRoomConfig = y25Var;
        }
    }

    public z25 setVoiceRoomData(z25 z25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048698, this, z25Var)) == null) {
            this.voiceRoomData = z25Var;
            return z25Var;
        }
        return (z25) invokeL.objValue;
    }

    public ArrayList<wn> switchThreadDataToThreadCardInfo(ArrayList<wn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048700, this, arrayList)) == null) {
            this.mHasThreadExceptTop = false;
            ArrayList<wn> arrayList2 = new ArrayList<>();
            Iterator<wn> it = arrayList.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                wn next = it.next();
                if (next instanceof ft4) {
                    ((ft4) next).setPosition(i - i2);
                    arrayList2.add(next);
                } else if (next instanceof ht4) {
                    ((ht4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    if (threadData.isTop()) {
                        i2++;
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        vu4 vu4Var = new vu4();
                        vu4Var.t = threadData;
                        vu4Var.position = i;
                        vu4Var.a = true;
                        vu4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(vu4Var);
                        vu4 vu4Var2 = new vu4();
                        vu4Var2.t = threadData;
                        vu4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            vu4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            vu4Var2.d = true;
                            vu4Var2.u = imageWidthAndHeight[0];
                            vu4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            vu4Var2.e = true;
                        } else {
                            vu4Var2.b = true;
                        }
                        vu4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(vu4Var2);
                        if (threadData.getPollData() != null) {
                            vu4 vu4Var3 = new vu4();
                            vu4Var3.o = true;
                            vu4Var3.t = threadData;
                            vu4Var3.position = i;
                            vu4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            vu4 vu4Var4 = new vu4();
                            vu4Var4.l = true;
                            vu4Var4.t = threadData;
                            vu4Var4.position = i;
                            vu4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            vu4 vu4Var5 = new vu4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                vu4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                vu4Var5.q = true;
                            }
                            vu4Var5.t = threadData;
                            vu4Var5.position = i;
                            vu4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            vu4 vu4Var6 = new vu4();
                            vu4Var6.h = true;
                            vu4Var6.t = threadData;
                            vu4Var6.position = i;
                            vu4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var6);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            vu4 vu4Var7 = new vu4();
                            vu4Var7.n = true;
                            vu4Var7.t = threadData;
                            vu4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var7);
                        }
                        insertRecommendInfo(threadData, arrayList2, i);
                        vu4 vu4Var8 = new vu4();
                        vu4Var8.g = true;
                        vu4Var8.t = threadData;
                        vu4Var8.position = i;
                        vu4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(vu4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        vu4 vu4Var9 = new vu4();
                        vu4Var9.t = threadData;
                        vu4Var9.position = i;
                        vu4Var9.a = true;
                        vu4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(vu4Var9);
                        vu4 vu4Var10 = new vu4();
                        vu4Var10.t = threadData;
                        vu4Var10.position = i;
                        if (threadData instanceof pt4) {
                            vu4Var10.j = true;
                        } else {
                            vu4Var10.i = true;
                        }
                        vu4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(vu4Var10);
                        if (threadData.getPollData() != null) {
                            vu4 vu4Var11 = new vu4();
                            vu4Var11.o = true;
                            vu4Var11.t = threadData;
                            vu4Var11.position = i;
                            vu4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            vu4 vu4Var12 = new vu4();
                            vu4Var12.l = true;
                            vu4Var12.t = threadData;
                            vu4Var12.position = i;
                            vu4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            vu4 vu4Var13 = new vu4();
                            vu4Var13.h = true;
                            vu4Var13.t = threadData;
                            vu4Var13.position = i;
                            vu4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var13);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            vu4 vu4Var14 = new vu4();
                            vu4Var14.n = true;
                            vu4Var14.t = threadData;
                            vu4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var14);
                        }
                        insertRecommendInfo(threadData, arrayList2, i);
                        vu4 vu4Var15 = new vu4();
                        vu4Var15.g = true;
                        vu4Var15.t = threadData;
                        vu4Var15.position = i;
                        vu4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(vu4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        vu4 vu4Var16 = new vu4();
                        vu4Var16.t = threadData;
                        vu4Var16.position = i;
                        vu4Var16.a = true;
                        vu4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(vu4Var16);
                        vu4 vu4Var17 = new vu4();
                        vu4Var17.t = threadData;
                        vu4Var17.position = i;
                        vu4Var17.k = true;
                        vu4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(vu4Var17);
                        if (threadData.getPollData() != null) {
                            vu4 vu4Var18 = new vu4();
                            vu4Var18.o = true;
                            vu4Var18.t = threadData;
                            vu4Var18.position = i;
                            vu4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            vu4 vu4Var19 = new vu4();
                            vu4Var19.l = true;
                            vu4Var19.t = threadData;
                            vu4Var19.position = i;
                            vu4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            vu4 vu4Var20 = new vu4();
                            vu4Var20.h = true;
                            vu4Var20.t = threadData;
                            vu4Var20.position = i;
                            vu4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var20);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            vu4 vu4Var21 = new vu4();
                            vu4Var21.n = true;
                            vu4Var21.t = threadData;
                            vu4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(vu4Var21);
                        }
                        insertRecommendInfo(threadData, arrayList2, i);
                        vu4 vu4Var22 = new vu4();
                        vu4Var22.g = true;
                        vu4Var22.t = threadData;
                        vu4Var22.position = i;
                        vu4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(vu4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        vu4 vu4Var23 = new vu4();
                        vu4Var23.t = threadData;
                        vu4Var23.position = i;
                        arrayList2.add(vu4Var23);
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
