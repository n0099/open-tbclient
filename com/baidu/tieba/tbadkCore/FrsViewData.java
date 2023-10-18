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
import com.baidu.tieba.ad;
import com.baidu.tieba.cda;
import com.baidu.tieba.ct7;
import com.baidu.tieba.dda;
import com.baidu.tieba.fda;
import com.baidu.tieba.hda;
import com.baidu.tieba.ida;
import com.baidu.tieba.jda;
import com.baidu.tieba.jx4;
import com.baidu.tieba.kda;
import com.baidu.tieba.ld7;
import com.baidu.tieba.mx4;
import com.baidu.tieba.nta;
import com.baidu.tieba.ny5;
import com.baidu.tieba.oc7;
import com.baidu.tieba.pc7;
import com.baidu.tieba.py4;
import com.baidu.tieba.qc7;
import com.baidu.tieba.tta;
import com.baidu.tieba.ul5;
import com.baidu.tieba.vk6;
import com.baidu.tieba.vt7;
import com.baidu.tieba.vy5;
import com.baidu.tieba.yca;
import com.baidu.tieba.yh;
import com.baidu.tieba.zca;
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
public class FrsViewData extends fda implements ul5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public ct7 funAdController;
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

    @Override // com.baidu.tieba.fda
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

    public List<yh> getTopThreadList() {
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
            removeTopSameClassDataFromList(yca.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            removeTopSameClassDataFromList(zca.class, getThreadList());
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

    public void addRecommendAppToThreadList(ny5 ny5Var, ArrayList<yh> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, ny5Var, arrayList) == null) {
            addRecommendAppToThreadList(ny5Var, false, arrayList, null, false);
        }
    }

    private List<yh> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        mx4 mx4Var;
        ArrayList<yh> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<yh> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (mx4Var = this.page) != null && mx4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    yh yhVar = this.threadList.get(i);
                    if (yhVar instanceof py4) {
                        if (((py4) yhVar).t.isHeadLinePost) {
                            arrayList2.add(yhVar);
                        }
                    } else if ((yhVar instanceof ThreadData) && ((ThreadData) yhVar).isHeadLinePost) {
                        arrayList2.add(yhVar);
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
            yh yhVar = this.threadList.get(i2);
            if (yhVar instanceof py4) {
                ThreadData threadData = ((py4) yhVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            dda ddaVar = new dda();
            ddaVar.d(this.forum.getId());
            ddaVar.c(feedForumList);
            this.threadList.add(i + 6, ddaVar);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        vk6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    yh yhVar = this.threadList.get(i2);
                    if (yhVar instanceof py4) {
                        ThreadData threadData = ((py4) yhVar).t;
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
        yh yhVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (yhVar = this.threadList.get(0)) != null && (yhVar instanceof py4) && ((ThreadData) yhVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            py4 py4Var = new py4();
            py4Var.t = threadData;
            this.threadList.add(0, py4Var);
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || getForum() == null) {
            return;
        }
        List<yh> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<yh> threadList = getThreadList();
        if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
            int size = cardShipinPos.size();
            int size2 = threadList.size();
            for (int i = 0; i < size; i++) {
                if (i < cardShipinNew.size()) {
                    yh yhVar = cardShipinNew.get(i);
                    int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                    Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + yhVar.getType());
                    threadList.add(videoThreadInserPos, yhVar);
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

    public void addRecommendAppToThreadList(ny5 ny5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ny5Var) == null) {
            addRecommendAppToThreadList(ny5Var, false, this.threadList, null, false);
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

    public void setFunAdController(ct7 ct7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, ct7Var) == null) {
            this.funAdController = ct7Var;
        }
    }

    public void setTopThreadList(List<yh> list) {
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<yh> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, cls, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                yh yhVar = arrayList.get(i);
                if (yhVar.getClass() == cls) {
                    arrayList2.add(yhVar);
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
            ArrayList<yh> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addHeaderCardToThreadList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            nta ntaVar = new nta();
            ntaVar.f(this.headerCard);
            if (tta.p(ntaVar, true)) {
                tta ttaVar = new tta();
                ttaVar.m(2);
                ForumData forumData = this.forum;
                if (forumData != null) {
                    ttaVar.i(forumData.getId());
                    ttaVar.l(this.forum.getName());
                }
                ttaVar.h(ntaVar);
                if (ListUtils.add(this.threadList, ttaVar.getPosition(), ttaVar)) {
                    ttaVar.position = ttaVar.getPosition();
                }
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        zca frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<yh> threadList = getThreadList();
            removeTopSameClassDataFromList(zca.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<yh> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                yh next = it.next();
                if (next != null && next.getType() == kda.c) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<yh> arrayList;
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
            yh yhVar = this.threadList.get(i2);
            if (yhVar instanceof py4) {
                ThreadData threadData = ((py4) yhVar).t;
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
        yca frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<yh> threadList = getThreadList();
            removeTopSameClassDataFromList(yca.class, threadList);
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
            ld7 userRecommend = getUserRecommend();
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
            ArrayList<yh> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<yh> it = this.threadList.iterator();
                while (it.hasNext()) {
                    yh next = it.next();
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
            hda entelechyTabInfo = getEntelechyTabInfo();
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
            Iterator<yh> it = this.threadList.iterator();
            while (it.hasNext()) {
                yh next = it.next();
                if (next != null && next.getType() == vt7.e) {
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
        Iterator<yh> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof ld7) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(jx4 jx4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, jx4Var) == null) && jx4Var != null && !StringUtils.isNull(jx4Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<yh> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    yh yhVar = threadList.get(i);
                    if ((yhVar instanceof py4) && jx4Var.getId().equals(((py4) yhVar).t.getId()) && jx4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            jx4Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, jx4Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<yh> it = this.threadList.iterator();
            while (it.hasNext()) {
                yh next = it.next();
                if (next != null && (next instanceof py4)) {
                    py4 py4Var = (py4) next;
                    if (py4Var.t.getAuthor() != null && currentAccount.equals(py4Var.t.getAuthor().getUserId()) && py4Var.t.getAuthor().getPendantData() != null) {
                        py4Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        py4Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(ny5 ny5Var, boolean z, ArrayList<yh> arrayList, ArrayList<yh> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{ny5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                vy5 vy5Var = new vy5(ny5Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                vy5Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, vy5Var));
                vy5 vy5Var2 = new vy5(ny5Var, 3);
                vy5Var2.z(z);
                vy5Var2.G(arrayList);
                vy5Var2.D(arrayList2);
                vy5Var2.y(z2);
                vy5Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    vy5Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    vy5Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, vy5Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<yh> arrayList;
        mx4 mx4Var;
        ArrayList<yh> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (mx4Var = this.page) != null && mx4Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                yh yhVar = this.threadList.get(i2);
                if (yhVar instanceof py4) {
                    py4 py4Var = (py4) yhVar;
                    if (py4Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && py4Var.t.getThreadAlaInfo() != null && py4Var.t.getThreadAlaInfo().user_info != null && py4Var.t.getThreadAlaInfo().user_info.is_official == 2 && py4Var.t.getThreadAlaInfo().liveStageForceTop) {
                        i = i2;
                        break;
                    }
                } else {
                    if (yhVar instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) yhVar;
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
                    yh yhVar2 = this.threadList.get(i3);
                    if (yhVar2 instanceof py4) {
                        if (((py4) yhVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((yhVar2 instanceof ThreadData) && ((ThreadData) yhVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
            List<yh> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!ListUtils.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    public void filterEnterList(List<cda> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, list) == null) && list != null && list.size() != 0) {
            Iterator<cda> it = list.iterator();
            while (it.hasNext()) {
                cda next = it.next();
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

    public List<yh> getShowTopThreadList() {
        InterceptResult invokeV;
        List<cda> list;
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
                arrayList.add(new jda(forum, this.forumRule));
            }
            if (forum != null && !ad.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new ida(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new ida(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<yh> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    yh yhVar = (yh) ListUtils.getItem(topThreadList, i4);
                    if (yhVar instanceof py4) {
                        py4 py4Var = (py4) yhVar;
                        arrayList.add(py4Var.t);
                        if (py4Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (yhVar instanceof ThreadData) {
                            arrayList.add(yhVar);
                            if (((ThreadData) yhVar).getIsMemberTop() != 1 || z) {
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
            ArrayList<yh> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<yh> it = arrayList.iterator();
            while (it.hasNext()) {
                yh next = it.next();
                if (next != null && (next instanceof py4)) {
                    py4 py4Var = (py4) next;
                    if (TextUtils.equals(str, py4Var.t.getId())) {
                        return py4Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public void removeThread(String str) {
        ArrayList<yh> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048615, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<yh> it = arrayList.iterator();
        while (it.hasNext()) {
            yh next = it.next();
            if (next != null && (next instanceof py4) && TextUtils.equals(str, ((py4) next).t.getId())) {
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

    public boolean receiveData(fda fdaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, fdaVar)) == null) {
            if (fdaVar == null) {
                return false;
            }
            this.isFromCache = fdaVar.isFromCache;
            setBaWuNoticeNum(fdaVar.getBaWuNoticeNum());
            setSortType(fdaVar.getSortType());
            setAnti(fdaVar.getAnti());
            setChatGroup(fdaVar.getChatGroup());
            setFortuneBag(fdaVar.isFortuneBag());
            setFortuneDesc(fdaVar.getFortuneDesc());
            setForum(fdaVar.getForum());
            setGameName(fdaVar.getGameName());
            setGameUrl(fdaVar.getGameUrl());
            setGconAccount(fdaVar.getGconAccount());
            setHasGame(fdaVar.isHasGame());
            setIsNewUrl(fdaVar.getIsNewUrl());
            setPhotoLivePos(fdaVar.getPhotoLivePos());
            setPage(fdaVar.getPage());
            setStar(fdaVar.getStar());
            setStarEnter(fdaVar.getStarEnter());
            setThreadList(fdaVar.threadList);
            setThreadListIds(fdaVar.getThreadListIds());
            setUserData(fdaVar.getUserData());
            setUserMap(fdaVar.getUserMap());
            setActivityHeadData(fdaVar.getActivityHeadData());
            setFrsDefaultTabId(fdaVar.getFrsDefaultTabId());
            this.defaultShowTab = fdaVar.defaultShowTab;
            setCategoryInfos(fdaVar.getCategoryInfos());
            setBawuCenterUrl(fdaVar.getBawuCenterUrl());
            setCardVideoInfo(fdaVar.getCardVideoInfo());
            setHeadSdkData(fdaVar.getHeadSdkData());
            setSchoolRecommendPos(fdaVar.getSchoolRecommendPos());
            setSchoolRecommendInfo(fdaVar.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(fdaVar.getEntelechyTabInfo());
            setAlaLiveCount(fdaVar.getAlaLiveCount());
            setCarrierEnterData(fdaVar.getCarrierEnterData());
            setForumState(fdaVar.getForumState());
            setAccessFlag(fdaVar.getAccessFlag());
            this.needLog = fdaVar.needLog;
            this.recommendBookData = fdaVar.recommendBookData;
            this.presentInfoData = fdaVar.presentInfoData;
            setBookInfo(fdaVar.getBookInfo());
            setMangaReadRecordChapterId(fdaVar.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(fdaVar.getHeadlineImgInfoData());
            setCardShipinPos(fdaVar.getCardShipinPos());
            setCardShipinNew(fdaVar.getCardShipinNew());
            this.enterFrsDialogInfo = fdaVar.enterFrsDialogInfo;
            setGameRankListData(fdaVar.getGameRankListData());
            setAgreeBanner(fdaVar.getAgreeBanner());
            setLiveNotify(fdaVar.getLiveNotify());
            setGameTabInfo(fdaVar.getGameTabInfo());
            setGameDefaultTabId(fdaVar.getGameDefaultTabId());
            setForumHeadIcon(fdaVar.getForumHeadIcon());
            setUserRecommend(fdaVar.getUserRecommend());
            setFrsVideoActivityData(fdaVar.getFrsVideoActivityData());
            this.mNewChapterInfo = fdaVar.mNewChapterInfo;
            setFrsInsertLiveData(fdaVar.getFrsInsertLiveData());
            this.recm_forum_list = fdaVar.getRecm_forum_list();
            setFrsStageLiveData(fdaVar.getFrsStageLiveData());
            this.forumArIno = fdaVar.forumArIno;
            this.starRank = fdaVar.starRank;
            this.postTopic = fdaVar.postTopic;
            this.mWindowToast = fdaVar.mWindowToast;
            this.activityConfig = fdaVar.activityConfig;
            setIsShowRedTip(fdaVar.isShowRedTip());
            this.isBrandForum = fdaVar.isBrandForum;
            this.brandAdData = fdaVar.brandAdData;
            this.oriForumInfoList = fdaVar.oriForumInfoList;
            this.bottomMenuList = fdaVar.bottomMenuList;
            this.adMixFloor = fdaVar.adMixFloor;
            this.adShowSelect = fdaVar.adShowSelect;
            this.adSampleMapKey = fdaVar.adSampleMapKey;
            pc7.f().n(getAnti());
            pc7.f().q(fdaVar.getForum().getId());
            pc7.f().r(fdaVar.getForum().getName());
            oc7.h().q(fdaVar.getForum().getId());
            if (fdaVar.getEntelechyTabInfo() != null) {
                oc7.h().r(fdaVar.getEntelechyTabInfo().a);
            }
            if (fdaVar.getUserData() != null) {
                qc7.c().e(fdaVar.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(fdaVar.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(fdaVar.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = fdaVar.smartAppAvatar;
            this.smartApp = fdaVar.smartApp;
            this.nebulaHotThreads = fdaVar.nebulaHotThreads;
            this.forumActiveInfo = fdaVar.forumActiveInfo;
            this.userList = fdaVar.userList;
            setBusinessPromot(fdaVar.getBusinessPromot());
            this.serviceAreaData = fdaVar.serviceAreaData;
            setHotUserRankData(fdaVar.getHotUserRankData());
            this.itemInfo = fdaVar.itemInfo;
            this.toLoadHorseData = fdaVar.toLoadHorseData;
            this.forumRule = fdaVar.forumRule;
            this.mSignActivityInfo = fdaVar.mSignActivityInfo;
            this.showAdsense = fdaVar.showAdsense;
            setVoiceRoomConfig(fdaVar.getVoiceRoomConfig());
            setVoiceRoomData(fdaVar.getVoiceRoomData());
            this.serviceAreaFlutterData = fdaVar.serviceAreaFlutterData;
            this.liveFuseForumDataList = fdaVar.liveFuseForumDataList;
            this.frsGameRankInfoData = fdaVar.frsGameRankInfoData;
            this.frsBannerHeaderData = fdaVar.frsBannerHeaderData;
            this.forumTagInfo = fdaVar.forumTagInfo;
            this.firstCategory = fdaVar.firstCategory;
            this.frsForumGroup = fdaVar.frsForumGroup;
            this.headerCard = fdaVar.headerCard;
            this.frsSpriteNewUserGuide = fdaVar.frsSpriteNewUserGuide;
            this.bountyTaskData = fdaVar.bountyTaskData;
            return true;
        }
        return invokeL.booleanValue;
    }
}
