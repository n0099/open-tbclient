package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.ak9;
import com.baidu.tieba.bk9;
import com.baidu.tieba.dk5;
import com.baidu.tieba.ek9;
import com.baidu.tieba.ex5;
import com.baidu.tieba.fk9;
import com.baidu.tieba.gg;
import com.baidu.tieba.hi;
import com.baidu.tieba.hk9;
import com.baidu.tieba.hn;
import com.baidu.tieba.iy4;
import com.baidu.tieba.jk9;
import com.baidu.tieba.kk7;
import com.baidu.tieba.kk9;
import com.baidu.tieba.l57;
import com.baidu.tieba.lk9;
import com.baidu.tieba.ly4;
import com.baidu.tieba.mk9;
import com.baidu.tieba.mx5;
import com.baidu.tieba.o47;
import com.baidu.tieba.oz4;
import com.baidu.tieba.p45;
import com.baidu.tieba.p47;
import com.baidu.tieba.q47;
import com.baidu.tieba.qh6;
import com.baidu.tieba.sk9;
import com.baidu.tieba.uk7;
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
/* loaded from: classes6.dex */
public class FrsViewData extends hk9 implements dk5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public kk7 funAdController;
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
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.postThreadCount = 0;
        }
    }

    public ForumActiveInfo getForumActiveInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.forumActiveInfo;
        }
        return (ForumActiveInfo) invokeV.objValue;
    }

    public BdUniqueId getFrsFragmentTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.frsFragmentTag;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean getIsBrandForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.isBrandForum;
        }
        return invokeV.booleanValue;
    }

    public int getPostThreadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.postThreadCount;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.hk9
    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.recm_forum_list;
        }
        return (List) invokeV.objValue;
    }

    public SignData getSignData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ForumData forumData = this.forum;
            if (forumData == null) {
                return null;
            }
            return forumData.getSignData();
        }
        return (SignData) invokeV.objValue;
    }

    public List<hn> getTopThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.topThreadList;
        }
        return (List) invokeV.objValue;
    }

    public boolean hasTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (getStar() == null || getStar().b() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void removeAlaInsertLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            removeTopSameClassDataFromList(ak9.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            removeTopSameClassDataFromList(bk9.class, getThreadList());
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

    public void addRecommendAppToThreadList(ex5 ex5Var, ArrayList<hn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ex5Var, arrayList) == null) {
            addRecommendAppToThreadList(ex5Var, false, arrayList, null, false);
        }
    }

    private List<hn> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        ly4 ly4Var;
        ArrayList<hn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<hn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (ly4Var = this.page) != null && ly4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    hn hnVar = this.threadList.get(i);
                    if (hnVar instanceof oz4) {
                        if (((oz4) hnVar).t.isHeadLinePost) {
                            arrayList2.add(hnVar);
                        }
                    } else if ((hnVar instanceof ThreadData) && ((ThreadData) hnVar).isHeadLinePost) {
                        arrayList2.add(hnVar);
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
            hn hnVar = this.threadList.get(i2);
            if (hnVar instanceof oz4) {
                ThreadData threadData = ((oz4) hnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            fk9 fk9Var = new fk9();
            fk9Var.d(this.forum.getId());
            fk9Var.c(feedForumList);
            this.threadList.add(i + 6, fk9Var);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        qh6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    hn hnVar = this.threadList.get(i2);
                    if (hnVar instanceof oz4) {
                        ThreadData threadData = ((oz4) hnVar).t;
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
        hn hnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (hnVar = this.threadList.get(0)) != null && (hnVar instanceof oz4) && ((ThreadData) hnVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            oz4 oz4Var = new oz4();
            oz4Var.t = threadData;
            this.threadList.add(0, oz4Var);
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || getForum() == null) {
            return;
        }
        List<hn> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<hn> threadList = getThreadList();
        if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
            int size = cardShipinPos.size();
            int size2 = threadList.size();
            for (int i = 0; i < size; i++) {
                if (i < cardShipinNew.size()) {
                    hn hnVar = cardShipinNew.get(i);
                    int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                    Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + hnVar.getType());
                    threadList.add(videoThreadInserPos, hnVar);
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

    public void addRecommendAppToThreadList(ex5 ex5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ex5Var) == null) {
            addRecommendAppToThreadList(ex5Var, false, this.threadList, null, false);
        }
    }

    public void removeThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, threadData) == null) {
            this.threadList.remove(threadData);
        }
    }

    public void setFrsFragmentTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bdUniqueId) == null) {
            this.frsFragmentTag = bdUniqueId;
        }
    }

    public void setFunAdController(kk7 kk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, kk7Var) == null) {
            this.funAdController = kk7Var;
        }
    }

    public void setTopThreadList(List<hn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, list) == null) {
            this.topThreadList = list;
        }
    }

    public void updateLoadMoreBannerListData(BannerListData bannerListData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bannerListData) == null) {
            this.isLoadMore = true;
            this.loadMoreBannerListData = bannerListData;
        }
    }

    public void updateSignData(SignData signData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048622, this, signData) != null) || signData == null) {
            return;
        }
        this.forum.setSignData(signData);
    }

    private void removeTopSameClassDataFromList(Class cls, ArrayList<hn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, cls, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                hn hnVar = arrayList.get(i);
                if (hnVar.getClass() == cls) {
                    arrayList2.add(hnVar);
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
            ArrayList<hn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        bk9 frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<hn> threadList = getThreadList();
            removeTopSameClassDataFromList(bk9.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<hn> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                hn next = it.next();
                if (next != null && next.getType() == mk9.c) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<hn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0) {
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
            hn hnVar = this.threadList.get(i2);
            if (hnVar instanceof oz4) {
                ThreadData threadData = ((oz4) hnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String s = p45.m().s("game_rank_list_info", "");
        if (!StringUtils.isNull(s) && s.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(gg.g(s.split(",")[0], 0L), System.currentTimeMillis()) < gg.e(s.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int n = p45.m().n("game_rank_list_show_times", 0);
                    if (!z) {
                        n++;
                    }
                    p45.m().z("game_rank_list_show_times", n);
                    if (n > 3) {
                        p45 m = p45.m();
                        m.B("game_rank_list_info", System.currentTimeMillis() + ",1");
                        p45.m().z("game_rank_list_show_times", 0);
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
        ak9 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<hn> threadList = getThreadList();
            removeTopSameClassDataFromList(ak9.class, threadList);
            threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.b, threadList.size()), frsInsertLiveData);
        }
    }

    public void addSchoolRecommendToThreadList() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || MessageManager.getInstance().findTask(2003016) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && getUserRecommend() != null) {
            l57 userRecommend = getUserRecommend();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            ArrayList<hn> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<hn> it = this.threadList.iterator();
                while (it.hasNext()) {
                    hn next = it.next();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            jk9 entelechyTabInfo = getEntelechyTabInfo();
            if (entelechyTabInfo == null || (list = entelechyTabInfo.a) == null || list.size() <= 0 || (frsTabInfo = list.get(0)) == null || frsTabInfo.tab_id.intValue() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void removeGameRankListFromThreadList() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && !ListUtils.isEmpty(this.threadList)) {
            Iterator<hn> it = this.threadList.iterator();
            while (it.hasNext()) {
                hn next = it.next();
                if (next != null && next.getType() == uk7.e) {
                    it.remove();
                }
            }
        }
    }

    public void removeRedundantUserRecommendData() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048613, this) != null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        boolean z = false;
        Iterator<hn> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof l57) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(iy4 iy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, iy4Var) == null) && iy4Var != null && !StringUtils.isNull(iy4Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<hn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    hn hnVar = threadList.get(i);
                    if ((hnVar instanceof oz4) && iy4Var.getId().equals(((oz4) hnVar).t.getId()) && iy4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            iy4Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, iy4Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<hn> it = this.threadList.iterator();
            while (it.hasNext()) {
                hn next = it.next();
                if (next != null && (next instanceof oz4)) {
                    oz4 oz4Var = (oz4) next;
                    if (oz4Var.t.getAuthor() != null && currentAccount.equals(oz4Var.t.getAuthor().getUserId()) && oz4Var.t.getAuthor().getPendantData() != null) {
                        oz4Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        oz4Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(ex5 ex5Var, boolean z, ArrayList<hn> arrayList, ArrayList<hn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{ex5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                mx5 mx5Var = new mx5(ex5Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                mx5Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, mx5Var));
                mx5 mx5Var2 = new mx5(ex5Var, 3);
                mx5Var2.z(z);
                mx5Var2.G(arrayList);
                mx5Var2.D(arrayList2);
                mx5Var2.y(z2);
                mx5Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    mx5Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    mx5Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, mx5Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<hn> arrayList;
        ly4 ly4Var;
        ArrayList<hn> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (ly4Var = this.page) != null && ly4Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                hn hnVar = this.threadList.get(i2);
                if (hnVar instanceof oz4) {
                    oz4 oz4Var = (oz4) hnVar;
                    if (oz4Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && oz4Var.t.getThreadAlaInfo() != null && oz4Var.t.getThreadAlaInfo().user_info != null && oz4Var.t.getThreadAlaInfo().user_info.is_official == 2 && oz4Var.t.getThreadAlaInfo().liveStageForceTop) {
                        i = i2;
                        break;
                    }
                } else {
                    if (hnVar instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) hnVar;
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
                    hn hnVar2 = this.threadList.get(i3);
                    if (hnVar2 instanceof oz4) {
                        if (((oz4) hnVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((hnVar2 instanceof ThreadData) && ((ThreadData) hnVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
            List<hn> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!ListUtils.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    public void filterEnterList(List<ek9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, list) == null) && list != null && list.size() != 0) {
            Iterator<ek9> it = list.iterator();
            while (it.hasNext()) {
                ek9 next = it.next();
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

    public List<hn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<ek9> list;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
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
                arrayList.add(new lk9(forum, this.forumRule));
            }
            if (forum != null && !hi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new kk9(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new kk9(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<hn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    hn hnVar = (hn) ListUtils.getItem(topThreadList, i4);
                    if (hnVar instanceof oz4) {
                        oz4 oz4Var = (oz4) hnVar;
                        arrayList.add(oz4Var.t);
                        if (oz4Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (hnVar instanceof ThreadData) {
                            arrayList.add(hnVar);
                            if (((ThreadData) hnVar).getIsMemberTop() != 1 || z) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            ArrayList<hn> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<hn> it = arrayList.iterator();
            while (it.hasNext()) {
                hn next = it.next();
                if (next != null && (next instanceof oz4)) {
                    oz4 oz4Var = (oz4) next;
                    if (TextUtils.equals(str, oz4Var.t.getId())) {
                        return oz4Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public void removeThread(String str) {
        ArrayList<hn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<hn> it = arrayList.iterator();
        while (it.hasNext()) {
            hn next = it.next();
            if (next != null && (next instanceof oz4) && TextUtils.equals(str, ((oz4) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(sk9 sk9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, sk9Var) != null) || sk9Var == null) {
            return;
        }
        this.forum.setCurScore(sk9Var.c());
        this.forum.setLevelupScore(sk9Var.i());
        this.forum.setLike(sk9Var.n());
        this.forum.setUser_level(sk9Var.m());
        this.forum.setLevelName(sk9Var.h());
    }

    public boolean receiveData(hk9 hk9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, hk9Var)) == null) {
            if (hk9Var == null) {
                return false;
            }
            this.isFromCache = hk9Var.isFromCache;
            setBaWuNoticeNum(hk9Var.getBaWuNoticeNum());
            setSortType(hk9Var.getSortType());
            setAnti(hk9Var.getAnti());
            setChatGroup(hk9Var.getChatGroup());
            setFortuneBag(hk9Var.isFortuneBag());
            setFortuneDesc(hk9Var.getFortuneDesc());
            setForum(hk9Var.getForum());
            setGameName(hk9Var.getGameName());
            setGameUrl(hk9Var.getGameUrl());
            setGconAccount(hk9Var.getGconAccount());
            setHasGame(hk9Var.isHasGame());
            setIsNewUrl(hk9Var.getIsNewUrl());
            setPhotoLivePos(hk9Var.getPhotoLivePos());
            setPage(hk9Var.getPage());
            setStar(hk9Var.getStar());
            setStarEnter(hk9Var.getStarEnter());
            setThreadList(hk9Var.threadList);
            setThreadListIds(hk9Var.getThreadListIds());
            setUserData(hk9Var.getUserData());
            setUserMap(hk9Var.getUserMap());
            setActivityHeadData(hk9Var.getActivityHeadData());
            setFrsDefaultTabId(hk9Var.getFrsDefaultTabId());
            this.defaultShowTab = hk9Var.defaultShowTab;
            setCategoryInfos(hk9Var.getCategoryInfos());
            setBawuCenterUrl(hk9Var.getBawuCenterUrl());
            setCardVideoInfo(hk9Var.getCardVideoInfo());
            setHeadSdkData(hk9Var.getHeadSdkData());
            setSchoolRecommendPos(hk9Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(hk9Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(hk9Var.getEntelechyTabInfo());
            setAlaLiveCount(hk9Var.getAlaLiveCount());
            setCarrierEnterData(hk9Var.getCarrierEnterData());
            setForumState(hk9Var.getForumState());
            setAccessFlag(hk9Var.getAccessFlag());
            this.needLog = hk9Var.needLog;
            this.recommendBookData = hk9Var.recommendBookData;
            this.presentInfoData = hk9Var.presentInfoData;
            setBookInfo(hk9Var.getBookInfo());
            setMangaReadRecordChapterId(hk9Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(hk9Var.getHeadlineImgInfoData());
            setCardShipinPos(hk9Var.getCardShipinPos());
            setCardShipinNew(hk9Var.getCardShipinNew());
            this.enterFrsDialogInfo = hk9Var.enterFrsDialogInfo;
            setGameRankListData(hk9Var.getGameRankListData());
            setAgreeBanner(hk9Var.getAgreeBanner());
            setLiveNotify(hk9Var.getLiveNotify());
            setGameTabInfo(hk9Var.getGameTabInfo());
            setGameDefaultTabId(hk9Var.getGameDefaultTabId());
            setForumHeadIcon(hk9Var.getForumHeadIcon());
            setUserRecommend(hk9Var.getUserRecommend());
            setFrsVideoActivityData(hk9Var.getFrsVideoActivityData());
            this.mNewChapterInfo = hk9Var.mNewChapterInfo;
            setFrsInsertLiveData(hk9Var.getFrsInsertLiveData());
            this.recm_forum_list = hk9Var.getRecm_forum_list();
            setFrsStageLiveData(hk9Var.getFrsStageLiveData());
            this.forumArIno = hk9Var.forumArIno;
            this.starRank = hk9Var.starRank;
            this.postTopic = hk9Var.postTopic;
            this.mWindowToast = hk9Var.mWindowToast;
            this.activityConfig = hk9Var.activityConfig;
            setIsShowRedTip(hk9Var.isShowRedTip());
            this.isBrandForum = hk9Var.isBrandForum;
            this.brandAdData = hk9Var.brandAdData;
            this.oriForumInfoList = hk9Var.oriForumInfoList;
            this.bottomMenuList = hk9Var.bottomMenuList;
            this.adMixFloor = hk9Var.adMixFloor;
            this.adShowSelect = hk9Var.adShowSelect;
            this.adSampleMapKey = hk9Var.adSampleMapKey;
            p47.f().n(getAnti());
            p47.f().q(hk9Var.getForum().getId());
            p47.f().r(hk9Var.getForum().getName());
            o47.h().q(hk9Var.getForum().getId());
            if (hk9Var.getEntelechyTabInfo() != null) {
                o47.h().r(hk9Var.getEntelechyTabInfo().a);
            }
            if (hk9Var.getUserData() != null) {
                q47.c().e(hk9Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(hk9Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(hk9Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = hk9Var.smartAppAvatar;
            this.smartApp = hk9Var.smartApp;
            this.nebulaHotThreads = hk9Var.nebulaHotThreads;
            this.forumActiveInfo = hk9Var.forumActiveInfo;
            this.userList = hk9Var.userList;
            setBusinessPromot(hk9Var.getBusinessPromot());
            this.serviceAreaData = hk9Var.serviceAreaData;
            setHotUserRankData(hk9Var.getHotUserRankData());
            this.itemInfo = hk9Var.itemInfo;
            this.toLoadHorseData = hk9Var.toLoadHorseData;
            this.forumRule = hk9Var.forumRule;
            this.mSignActivityInfo = hk9Var.mSignActivityInfo;
            this.showAdsense = hk9Var.showAdsense;
            setVoiceRoomConfig(hk9Var.getVoiceRoomConfig());
            setVoiceRoomData(hk9Var.getVoiceRoomData());
            this.serviceAreaFlutterData = hk9Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = hk9Var.liveFuseForumDataList;
            this.frsGameRankInfoData = hk9Var.frsGameRankInfoData;
            this.frsBannerHeaderData = hk9Var.frsBannerHeaderData;
            this.forumTagInfo = hk9Var.forumTagInfo;
            this.firstCategory = hk9Var.firstCategory;
            this.frsForumGroup = hk9Var.frsForumGroup;
            return true;
        }
        return invokeL.booleanValue;
    }
}
