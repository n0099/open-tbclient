package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.TopNoticeData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.bn;
import com.baidu.tieba.c45;
import com.baidu.tieba.di;
import com.baidu.tieba.dp6;
import com.baidu.tieba.dva;
import com.baidu.tieba.fx7;
import com.baidu.tieba.gva;
import com.baidu.tieba.h36;
import com.baidu.tieba.jea;
import com.baidu.tieba.kea;
import com.baidu.tieba.lh7;
import com.baidu.tieba.nea;
import com.baidu.tieba.oea;
import com.baidu.tieba.og7;
import com.baidu.tieba.p36;
import com.baidu.tieba.pg7;
import com.baidu.tieba.qea;
import com.baidu.tieba.qg7;
import com.baidu.tieba.sea;
import com.baidu.tieba.tea;
import com.baidu.tieba.tq5;
import com.baidu.tieba.uea;
import com.baidu.tieba.vea;
import com.baidu.tieba.w25;
import com.baidu.tieba.yx7;
import com.baidu.tieba.z25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.FrsPage.NebulaHotThreads;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.SmartApp;
import tbclient.User;
/* loaded from: classes8.dex */
public class FrsViewData extends qea implements tq5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public fx7 funAdController;
    public boolean isBrandForum;
    public boolean isFrsVideoAutoPlay;
    public boolean isLoadMore;
    public BannerListData loadMoreBannerListData;
    public int mHeadLineDefaultNavTabId;
    public NebulaHotThreads nebulaHotThreads;
    public int postThreadCount;
    public List<RecmForumInfo> recm_forum_list;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    public List<User> userList;

    public FrsViewData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.postThreadCount = 0;
        this.mHeadLineDefaultNavTabId = -1;
    }

    public void clearPostThreadCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.postThreadCount = 0;
        }
    }

    public ForumActiveInfo getForumActiveInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.forumActiveInfo;
        }
        return (ForumActiveInfo) invokeV.objValue;
    }

    public BdUniqueId getFrsFragmentTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.frsFragmentTag;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean getIsBrandForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.isBrandForum;
        }
        return invokeV.booleanValue;
    }

    public int getPostThreadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.postThreadCount;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qea
    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.recm_forum_list;
        }
        return (List) invokeV.objValue;
    }

    public SignData getSignData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            ForumData forumData = this.forum;
            if (forumData == null) {
                return null;
            }
            return forumData.getSignData();
        }
        return (SignData) invokeV.objValue;
    }

    public List<bn> getTopThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.topThreadList;
        }
        return (List) invokeV.objValue;
    }

    public boolean hasTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (getEntelechyTabInfo() == null || ListUtils.isEmpty(getEntelechyTabInfo().a)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isPrivateForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (getForum() == null || getForum().getIsPrivateForum() == 0 || getForum().getIsPrivateForum() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isStarForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (getStar() == null || getStar().b() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void removeAlaInsertLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            removeTopSameClassDataFromList(jea.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            removeTopSameClassDataFromList(kea.class, getThreadList());
        }
    }

    private int getAlaLiveThreadCardInsertPos(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, this, i, i2)) == null) {
            return Math.min((getTopThreadSize() + i) - 1, i2);
        }
        return invokeII.intValue;
    }

    private int getVideoThreadInserPos(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, this, i, i2)) == null) {
            return Math.min((getTopThreadSize() + i) - 1, i2);
        }
        return invokeII.intValue;
    }

    public void addRecommendAppToThreadList(h36 h36Var, ArrayList<bn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, h36Var, arrayList) == null) {
            addRecommendAppToThreadList(h36Var, false, arrayList, null, false);
        }
    }

    private List<bn> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        z25 z25Var;
        ArrayList<bn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<bn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (z25Var = this.page) != null && z25Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    bn bnVar = this.threadList.get(i);
                    if (bnVar instanceof c45) {
                        if (((c45) bnVar).t.isHeadLinePost) {
                            arrayList2.add(bnVar);
                        }
                    } else if ((bnVar instanceof ThreadData) && ((ThreadData) bnVar).isHeadLinePost) {
                        arrayList2.add(bnVar);
                    }
                }
            }
            return arrayList2;
        }
        return (List) invokeV.objValue;
    }

    public void addFeedForumDataToThreadList() {
        ForumData forumData;
        List<FeedForumData> feedForumList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.threadList == null || (forumData = this.forum) == null || forumData.getBannerListData() == null || MessageManager.getInstance().findTask(2003016) == null) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            bn bnVar = this.threadList.get(i2);
            if (bnVar instanceof c45) {
                ThreadData threadData = ((c45) bnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            oea oeaVar = new oea();
            oeaVar.d(this.forum.getId());
            oeaVar.c(feedForumList);
            this.threadList.add(i + 6, oeaVar);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        dp6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    bn bnVar = this.threadList.get(i2);
                    if (bnVar instanceof c45) {
                        ThreadData threadData = ((c45) bnVar).t;
                        if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if (this.threadList.size() - i > 7 && (recomTopicData = this.forum.getBannerListData().getRecomTopicData()) != null && ListUtils.getCount(recomTopicData.d) >= 4) {
                    this.threadList.add(i + 6, recomTopicData);
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void addNoticeThreadToThreadList() {
        TopNoticeData top_notice_data;
        bn bnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (bnVar = this.threadList.get(0)) != null && (bnVar instanceof c45) && ((ThreadData) bnVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            c45 c45Var = new c45();
            c45Var.t = threadData;
            this.threadList.add(0, c45Var);
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || getForum() == null) {
            return;
        }
        List<bn> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<bn> threadList = getThreadList();
        if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
            int size = cardShipinPos.size();
            int size2 = threadList.size();
            for (int i = 0; i < size; i++) {
                if (i < cardShipinNew.size()) {
                    bn bnVar = cardShipinNew.get(i);
                    int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                    Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + bnVar.getType());
                    threadList.add(videoThreadInserPos, bnVar);
                }
            }
        }
    }

    private int getPhotoliveCardInsertPos(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) {
            return Math.min((getTopThreadSize() + getPhotoLivePos()) - 1, i);
        }
        return invokeI.intValue;
    }

    public void addRecommendAppToThreadList(h36 h36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, h36Var) == null) {
            addRecommendAppToThreadList(h36Var, false, this.threadList, null, false);
        }
    }

    public void removeThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, threadData) == null) {
            this.threadList.remove(threadData);
        }
    }

    public void setFrsFragmentTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, bdUniqueId) == null) {
            this.frsFragmentTag = bdUniqueId;
        }
    }

    public void setFunAdController(fx7 fx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, fx7Var) == null) {
            this.funAdController = fx7Var;
        }
    }

    public void setTopThreadList(List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, list) == null) {
            this.topThreadList = list;
        }
    }

    public void updateLoadMoreBannerListData(BannerListData bannerListData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bannerListData) == null) {
            this.isLoadMore = true;
            this.loadMoreBannerListData = bannerListData;
        }
    }

    public void updateSignData(SignData signData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048623, this, signData) != null) || signData == null) {
            return;
        }
        this.forum.setSignData(signData);
    }

    private void removeTopSameClassDataFromList(Class cls, ArrayList<bn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, cls, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                bn bnVar = arrayList.get(i);
                if (bnVar.getClass() == cls) {
                    arrayList2.add(bnVar);
                    break;
                }
                i++;
            }
            if (!arrayList2.isEmpty()) {
                arrayList.removeAll(arrayList2);
            }
        }
    }

    public void addCardVideoInfoToThreadList() {
        ThreadData cardVideoInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && getForum() != null && (cardVideoInfo = getCardVideoInfo()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + cardVideoInfo.getTid());
            ArrayList<bn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addHeaderCardToThreadList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            dva dvaVar = new dva();
            dvaVar.e(this.headerCard);
            if (gva.i(dvaVar, true)) {
                gva gvaVar = new gva();
                gvaVar.g(2);
                ForumData forumData = this.forum;
                if (forumData != null) {
                    gvaVar.e(forumData.getId());
                    gvaVar.f(this.forum.getName());
                }
                gvaVar.d(dvaVar);
                if (ListUtils.add(this.threadList, gvaVar.getPosition(), gvaVar)) {
                    gvaVar.position = gvaVar.getPosition();
                }
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        kea frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<bn> threadList = getThreadList();
            removeTopSameClassDataFromList(kea.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<bn> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                bn next = it.next();
                if (next != null && next.getType() == vea.c) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<bn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0) {
            for (int i = 0; i < this.threadList.size(); i++) {
                if (this.threadList.get(i).getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE || this.threadList.get(i).getType() == ThreadData.TYPE_ALA_LIVE_EMPTY || this.threadList.get(i).getType() == ThreadData.TYPE_ALA_SHARE_THREAD) {
                    this.threadList.remove(i);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addGameRankListToThreadList(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        removeGameRankListFromThreadList();
        if (getGameRankListData() == null) {
            return;
        }
        boolean z3 = false;
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            bn bnVar = this.threadList.get(i2);
            if (bnVar instanceof c45) {
                ThreadData threadData = ((c45) bnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String string = SharedPrefHelper.getInstance().getString("game_rank_list_info", "");
        if (!StringUtils.isNull(string) && string.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(JavaTypesHelper.toLong(string.split(",")[0], 0L), System.currentTimeMillis()) < JavaTypesHelper.toInt(string.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int i3 = SharedPrefHelper.getInstance().getInt("game_rank_list_show_times", 0);
                    if (!z) {
                        i3++;
                    }
                    SharedPrefHelper.getInstance().putInt("game_rank_list_show_times", i3);
                    if (i3 > 3) {
                        SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                        sharedPrefHelper.putString("game_rank_list_info", System.currentTimeMillis() + ",1");
                        SharedPrefHelper.getInstance().putInt("game_rank_list_show_times", 0);
                        if (!z3) {
                            return;
                        }
                        this.threadList.add((i + getGameRankListData().a()) - 1, getGameRankListData());
                        return;
                    }
                }
                z3 = z2;
                if (!z3) {
                }
            }
        }
        z2 = true;
        if (z2) {
        }
        z3 = z2;
        if (!z3) {
        }
    }

    public void addInsertLiveDataToThreadList() {
        jea frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<bn> threadList = getThreadList();
            removeTopSameClassDataFromList(jea.class, threadList);
            threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.b, threadList.size()), frsInsertLiveData);
        }
    }

    public void addSchoolRecommendToThreadList() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || MessageManager.getInstance().findTask(2003016) == null) {
            return;
        }
        int schoolRecommendPos = (getSchoolRecommendPos() + getTopThreadSize()) - 1;
        if (getSchoolRecommendUserInfo() != null && schoolRecommendPos >= 0 && schoolRecommendPos <= this.threadList.size()) {
            this.threadList.add(schoolRecommendPos, getSchoolRecommendUserInfo());
        }
    }

    public void addUserRecommendToThreadList() {
        int a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && getUserRecommend() != null) {
            lh7 userRecommend = getUserRecommend();
            if (ListUtils.getCount(userRecommend.c()) < 3 || (a = userRecommend.a()) <= 0) {
                return;
            }
            int topThreadSize = a + getTopThreadSize();
            if (topThreadSize > this.threadList.size()) {
                this.threadList.add(userRecommend);
            } else {
                this.threadList.add(topThreadSize, userRecommend);
            }
        }
    }

    public int getTopThreadSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ArrayList<bn> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<bn> it = this.threadList.iterator();
                while (it.hasNext()) {
                    bn next = it.next();
                    if (next instanceof ThreadData) {
                        if (((ThreadData) next).getIs_top() == 0) {
                            break;
                        }
                        i++;
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public boolean isFirstTabEqualAllThread() {
        InterceptResult invokeV;
        List<FrsTabInfo> list;
        FrsTabInfo frsTabInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            sea entelechyTabInfo = getEntelechyTabInfo();
            if (entelechyTabInfo == null || (list = entelechyTabInfo.a) == null || list.size() <= 0 || (frsTabInfo = list.get(0)) == null || frsTabInfo.tab_id.intValue() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void removeGameRankListFromThreadList() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && !ListUtils.isEmpty(this.threadList)) {
            Iterator<bn> it = this.threadList.iterator();
            while (it.hasNext()) {
                bn next = it.next();
                if (next != null && next.getType() == yx7.e) {
                    it.remove();
                }
            }
        }
    }

    public void removeRedundantUserRecommendData() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048614, this) != null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        boolean z = false;
        Iterator<bn> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof lh7) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(w25 w25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, w25Var) == null) && w25Var != null && !StringUtils.isNull(w25Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<bn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    bn bnVar = threadList.get(i);
                    if ((bnVar instanceof c45) && w25Var.getId().equals(((c45) bnVar).t.getId()) && w25Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            w25Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, w25Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<bn> it = this.threadList.iterator();
            while (it.hasNext()) {
                bn next = it.next();
                if (next != null && (next instanceof c45)) {
                    c45 c45Var = (c45) next;
                    if (c45Var.t.getAuthor() != null && currentAccount.equals(c45Var.t.getAuthor().getUserId()) && c45Var.t.getAuthor().getPendantData() != null) {
                        c45Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        c45Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(h36 h36Var, boolean z, ArrayList<bn> arrayList, ArrayList<bn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{h36Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
            if (!this.isLoadMore) {
                ForumData forumData = this.forum;
                if (forumData == null) {
                    return;
                }
                bannerListData = forumData.getBannerListData();
            } else {
                bannerListData = this.loadMoreBannerListData;
            }
            this.isLoadMore = false;
            if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
                p36 p36Var = new p36(h36Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                p36Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, p36Var));
                p36 p36Var2 = new p36(h36Var, 3);
                p36Var2.z(z);
                p36Var2.G(arrayList);
                p36Var2.D(arrayList2);
                p36Var2.y(z2);
                p36Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    p36Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    p36Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, p36Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<bn> arrayList;
        z25 z25Var;
        ArrayList<bn> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (z25Var = this.page) != null && z25Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                bn bnVar = this.threadList.get(i2);
                if (bnVar instanceof c45) {
                    c45 c45Var = (c45) bnVar;
                    if (c45Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && c45Var.t.getThreadAlaInfo() != null && c45Var.t.getThreadAlaInfo().user_info != null && c45Var.t.getThreadAlaInfo().user_info.is_official == 2 && c45Var.t.getThreadAlaInfo().liveStageForceTop) {
                        i = i2;
                        break;
                    }
                } else {
                    if (bnVar instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) bnVar;
                        if (threadData.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().user_info != null && threadData.getThreadAlaInfo().user_info.is_official == 2 && threadData.getThreadAlaInfo().liveStageForceTop) {
                            i = i2;
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (i < 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    bn bnVar2 = this.threadList.get(i3);
                    if (bnVar2 instanceof c45) {
                        if (((c45) bnVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((bnVar2 instanceof ThreadData) && ((ThreadData) bnVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                            i = i3;
                            break;
                        }
                    }
                }
            }
            int topThreadSize = getTopThreadSize();
            if (i > topThreadSize) {
                this.threadList.add(topThreadSize, this.threadList.remove(i));
            }
            List<bn> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!ListUtils.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    public void filterEnterList(List<nea> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, list) == null) && list != null && list.size() != 0) {
            Iterator<nea> it = list.iterator();
            while (it.hasNext()) {
                nea next = it.next();
                if (next == null) {
                    it.remove();
                } else if (StringUtils.isNull(next.f()) || StringUtils.isNull(next.d())) {
                    if (next.a() != 1) {
                        it.remove();
                    }
                }
            }
        }
    }

    public List<bn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<nea> list;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(getStarEnter())) {
                list = getStarEnter();
                filterEnterList(list);
            } else {
                list = null;
            }
            if (!ListUtils.isEmpty(list)) {
                i = 0;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (list.get(i2).a() == 1) {
                        arrayList.add(list.get(i2));
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            ForumData forum = getForum();
            if (forum != null && getForum().getIsShowRule() && this.forumRule != null && (getUserData().getIs_manager() == 1 || this.forumRule.has_forum_rule.intValue() == 1)) {
                arrayList.add(new uea(forum, this.forumRule));
            }
            if (forum != null && !di.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new tea(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new tea(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<bn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    bn bnVar = (bn) ListUtils.getItem(topThreadList, i4);
                    if (bnVar instanceof c45) {
                        c45 c45Var = (c45) bnVar;
                        arrayList.add(c45Var.t);
                        if (c45Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (bnVar instanceof ThreadData) {
                            arrayList.add(bnVar);
                            if (((ThreadData) bnVar).getIsMemberTop() != 1 || z) {
                                if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                    break;
                                }
                            }
                            i3++;
                            z = true;
                        } else {
                            continue;
                        }
                    }
                }
            }
            if (!ListUtils.isEmpty(list)) {
                for (int i5 = 0; i5 < list.size(); i5++) {
                    if (list.get(i5).a() != 1) {
                        arrayList.add(list.get(i5));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public ThreadData getThreadDataById(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            ArrayList<bn> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<bn> it = arrayList.iterator();
            while (it.hasNext()) {
                bn next = it.next();
                if (next != null && (next instanceof c45)) {
                    c45 c45Var = (c45) next;
                    if (TextUtils.equals(str, c45Var.t.getId())) {
                        return c45Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public void removeThread(String str) {
        ArrayList<bn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048615, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<bn> it = arrayList.iterator();
        while (it.hasNext()) {
            bn next = it.next();
            if (next != null && (next instanceof c45) && TextUtils.equals(str, ((c45) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(LikeReturnData likeReturnData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048621, this, likeReturnData) != null) || likeReturnData == null) {
            return;
        }
        this.forum.setCurScore(likeReturnData.getCurScore());
        this.forum.setLevelupScore(likeReturnData.getLevelupScore());
        this.forum.setLike(likeReturnData.isLike());
        this.forum.setUser_level(likeReturnData.getUserLevel());
        this.forum.setLevelName(likeReturnData.getLevelName());
    }

    public boolean receiveData(qea qeaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, qeaVar)) == null) {
            if (qeaVar == null) {
                return false;
            }
            this.isFromCache = qeaVar.isFromCache;
            setBaWuNoticeNum(qeaVar.getBaWuNoticeNum());
            setSortType(qeaVar.getSortType());
            setAnti(qeaVar.getAnti());
            setChatGroup(qeaVar.getChatGroup());
            setFortuneBag(qeaVar.isFortuneBag());
            setFortuneDesc(qeaVar.getFortuneDesc());
            setForum(qeaVar.getForum());
            setGameName(qeaVar.getGameName());
            setGameUrl(qeaVar.getGameUrl());
            setGconAccount(qeaVar.getGconAccount());
            setHasGame(qeaVar.isHasGame());
            setIsNewUrl(qeaVar.getIsNewUrl());
            setPhotoLivePos(qeaVar.getPhotoLivePos());
            setPage(qeaVar.getPage());
            setStar(qeaVar.getStar());
            setStarEnter(qeaVar.getStarEnter());
            setThreadList(qeaVar.threadList);
            setThreadListIds(qeaVar.getThreadListIds());
            setUserData(qeaVar.getUserData());
            setUserMap(qeaVar.getUserMap());
            setActivityHeadData(qeaVar.getActivityHeadData());
            setFrsDefaultTabId(qeaVar.getFrsDefaultTabId());
            this.defaultShowTab = qeaVar.defaultShowTab;
            setCategoryInfos(qeaVar.getCategoryInfos());
            setBawuCenterUrl(qeaVar.getBawuCenterUrl());
            setCardVideoInfo(qeaVar.getCardVideoInfo());
            setHeadSdkData(qeaVar.getHeadSdkData());
            setSchoolRecommendPos(qeaVar.getSchoolRecommendPos());
            setSchoolRecommendInfo(qeaVar.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(qeaVar.getEntelechyTabInfo());
            setAlaLiveCount(qeaVar.getAlaLiveCount());
            setCarrierEnterData(qeaVar.getCarrierEnterData());
            setForumState(qeaVar.getForumState());
            setAccessFlag(qeaVar.getAccessFlag());
            this.needLog = qeaVar.needLog;
            this.recommendBookData = qeaVar.recommendBookData;
            this.presentInfoData = qeaVar.presentInfoData;
            setBookInfo(qeaVar.getBookInfo());
            setMangaReadRecordChapterId(qeaVar.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(qeaVar.getHeadlineImgInfoData());
            setCardShipinPos(qeaVar.getCardShipinPos());
            setCardShipinNew(qeaVar.getCardShipinNew());
            this.enterFrsDialogInfo = qeaVar.enterFrsDialogInfo;
            setGameRankListData(qeaVar.getGameRankListData());
            setAgreeBanner(qeaVar.getAgreeBanner());
            setLiveNotify(qeaVar.getLiveNotify());
            setGameTabInfo(qeaVar.getGameTabInfo());
            setGameDefaultTabId(qeaVar.getGameDefaultTabId());
            setForumHeadIcon(qeaVar.getForumHeadIcon());
            setUserRecommend(qeaVar.getUserRecommend());
            setFrsVideoActivityData(qeaVar.getFrsVideoActivityData());
            this.mNewChapterInfo = qeaVar.mNewChapterInfo;
            setFrsInsertLiveData(qeaVar.getFrsInsertLiveData());
            this.recm_forum_list = qeaVar.getRecm_forum_list();
            setFrsStageLiveData(qeaVar.getFrsStageLiveData());
            this.forumArIno = qeaVar.forumArIno;
            this.starRank = qeaVar.starRank;
            this.postTopic = qeaVar.postTopic;
            this.mWindowToast = qeaVar.mWindowToast;
            this.activityConfig = qeaVar.activityConfig;
            setIsShowRedTip(qeaVar.isShowRedTip());
            this.isBrandForum = qeaVar.isBrandForum;
            this.brandAdData = qeaVar.brandAdData;
            this.oriForumInfoList = qeaVar.oriForumInfoList;
            this.bottomMenuList = qeaVar.bottomMenuList;
            this.adMixFloor = qeaVar.adMixFloor;
            this.adShowSelect = qeaVar.adShowSelect;
            this.adSampleMapKey = qeaVar.adSampleMapKey;
            pg7.f().n(getAnti());
            pg7.f().q(qeaVar.getForum().getId());
            pg7.f().r(qeaVar.getForum().getName());
            og7.h().q(qeaVar.getForum().getId());
            if (qeaVar.getEntelechyTabInfo() != null) {
                og7.h().r(qeaVar.getEntelechyTabInfo().a);
            }
            if (qeaVar.getUserData() != null) {
                qg7.c().e(qeaVar.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(qeaVar.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(qeaVar.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = qeaVar.smartAppAvatar;
            this.smartApp = qeaVar.smartApp;
            this.nebulaHotThreads = qeaVar.nebulaHotThreads;
            this.forumActiveInfo = qeaVar.forumActiveInfo;
            this.userList = qeaVar.userList;
            setBusinessPromot(qeaVar.getBusinessPromot());
            this.serviceAreaData = qeaVar.serviceAreaData;
            setHotUserRankData(qeaVar.getHotUserRankData());
            this.itemInfo = qeaVar.itemInfo;
            this.toLoadHorseData = qeaVar.toLoadHorseData;
            this.forumRule = qeaVar.forumRule;
            this.mSignActivityInfo = qeaVar.mSignActivityInfo;
            this.showAdsense = qeaVar.showAdsense;
            setVoiceRoomConfig(qeaVar.getVoiceRoomConfig());
            setVoiceRoomData(qeaVar.getVoiceRoomData());
            this.serviceAreaFlutterData = qeaVar.serviceAreaFlutterData;
            this.liveFuseForumDataList = qeaVar.liveFuseForumDataList;
            this.frsGameRankInfoData = qeaVar.frsGameRankInfoData;
            this.frsBannerHeaderData = qeaVar.frsBannerHeaderData;
            this.forumTagInfo = qeaVar.forumTagInfo;
            this.firstCategory = qeaVar.firstCategory;
            this.frsForumGroup = qeaVar.frsForumGroup;
            this.headerCard = qeaVar.headerCard;
            this.frsSpriteNewUserGuide = qeaVar.frsSpriteNewUserGuide;
            this.bountyTaskData = qeaVar.bountyTaskData;
            return true;
        }
        return invokeL.booleanValue;
    }
}
