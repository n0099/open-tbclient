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
import com.baidu.tieba.al9;
import com.baidu.tieba.ek5;
import com.baidu.tieba.fx5;
import com.baidu.tieba.gg;
import com.baidu.tieba.hi;
import com.baidu.tieba.ik9;
import com.baidu.tieba.in;
import com.baidu.tieba.jk9;
import com.baidu.tieba.jy4;
import com.baidu.tieba.lk7;
import com.baidu.tieba.m57;
import com.baidu.tieba.mk9;
import com.baidu.tieba.my4;
import com.baidu.tieba.nk9;
import com.baidu.tieba.nx5;
import com.baidu.tieba.p47;
import com.baidu.tieba.pk9;
import com.baidu.tieba.pz4;
import com.baidu.tieba.q45;
import com.baidu.tieba.q47;
import com.baidu.tieba.r47;
import com.baidu.tieba.rh6;
import com.baidu.tieba.rk9;
import com.baidu.tieba.sk9;
import com.baidu.tieba.tk9;
import com.baidu.tieba.uk9;
import com.baidu.tieba.vk7;
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
public class FrsViewData extends pk9 implements ek5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public lk7 funAdController;
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

    @Override // com.baidu.tieba.pk9
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

    public List<in> getTopThreadList() {
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
            removeTopSameClassDataFromList(ik9.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            removeTopSameClassDataFromList(jk9.class, getThreadList());
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

    public void addRecommendAppToThreadList(fx5 fx5Var, ArrayList<in> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fx5Var, arrayList) == null) {
            addRecommendAppToThreadList(fx5Var, false, arrayList, null, false);
        }
    }

    private List<in> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        my4 my4Var;
        ArrayList<in> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<in> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (my4Var = this.page) != null && my4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    in inVar = this.threadList.get(i);
                    if (inVar instanceof pz4) {
                        if (((pz4) inVar).t.isHeadLinePost) {
                            arrayList2.add(inVar);
                        }
                    } else if ((inVar instanceof ThreadData) && ((ThreadData) inVar).isHeadLinePost) {
                        arrayList2.add(inVar);
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
            in inVar = this.threadList.get(i2);
            if (inVar instanceof pz4) {
                ThreadData threadData = ((pz4) inVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            nk9 nk9Var = new nk9();
            nk9Var.d(this.forum.getId());
            nk9Var.c(feedForumList);
            this.threadList.add(i + 6, nk9Var);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        rh6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    in inVar = this.threadList.get(i2);
                    if (inVar instanceof pz4) {
                        ThreadData threadData = ((pz4) inVar).t;
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
        in inVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (inVar = this.threadList.get(0)) != null && (inVar instanceof pz4) && ((ThreadData) inVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            pz4 pz4Var = new pz4();
            pz4Var.t = threadData;
            this.threadList.add(0, pz4Var);
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || getForum() == null) {
            return;
        }
        List<in> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<in> threadList = getThreadList();
        if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
            int size = cardShipinPos.size();
            int size2 = threadList.size();
            for (int i = 0; i < size; i++) {
                if (i < cardShipinNew.size()) {
                    in inVar = cardShipinNew.get(i);
                    int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                    Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + inVar.getType());
                    threadList.add(videoThreadInserPos, inVar);
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

    public void addRecommendAppToThreadList(fx5 fx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fx5Var) == null) {
            addRecommendAppToThreadList(fx5Var, false, this.threadList, null, false);
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

    public void setFunAdController(lk7 lk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, lk7Var) == null) {
            this.funAdController = lk7Var;
        }
    }

    public void setTopThreadList(List<in> list) {
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<in> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, cls, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                in inVar = arrayList.get(i);
                if (inVar.getClass() == cls) {
                    arrayList2.add(inVar);
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
            ArrayList<in> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        jk9 frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<in> threadList = getThreadList();
            removeTopSameClassDataFromList(jk9.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<in> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                in next = it.next();
                if (next != null && next.getType() == uk9.c) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<in> arrayList;
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
            in inVar = this.threadList.get(i2);
            if (inVar instanceof pz4) {
                ThreadData threadData = ((pz4) inVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String s = q45.m().s("game_rank_list_info", "");
        if (!StringUtils.isNull(s) && s.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(gg.g(s.split(",")[0], 0L), System.currentTimeMillis()) < gg.e(s.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int n = q45.m().n("game_rank_list_show_times", 0);
                    if (!z) {
                        n++;
                    }
                    q45.m().z("game_rank_list_show_times", n);
                    if (n > 3) {
                        q45 m = q45.m();
                        m.B("game_rank_list_info", System.currentTimeMillis() + ",1");
                        q45.m().z("game_rank_list_show_times", 0);
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
        ik9 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<in> threadList = getThreadList();
            removeTopSameClassDataFromList(ik9.class, threadList);
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
            m57 userRecommend = getUserRecommend();
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
            ArrayList<in> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<in> it = this.threadList.iterator();
                while (it.hasNext()) {
                    in next = it.next();
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
            rk9 entelechyTabInfo = getEntelechyTabInfo();
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
            Iterator<in> it = this.threadList.iterator();
            while (it.hasNext()) {
                in next = it.next();
                if (next != null && next.getType() == vk7.e) {
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
        Iterator<in> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof m57) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(jy4 jy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, jy4Var) == null) && jy4Var != null && !StringUtils.isNull(jy4Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<in> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    in inVar = threadList.get(i);
                    if ((inVar instanceof pz4) && jy4Var.getId().equals(((pz4) inVar).t.getId()) && jy4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            jy4Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, jy4Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<in> it = this.threadList.iterator();
            while (it.hasNext()) {
                in next = it.next();
                if (next != null && (next instanceof pz4)) {
                    pz4 pz4Var = (pz4) next;
                    if (pz4Var.t.getAuthor() != null && currentAccount.equals(pz4Var.t.getAuthor().getUserId()) && pz4Var.t.getAuthor().getPendantData() != null) {
                        pz4Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        pz4Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(fx5 fx5Var, boolean z, ArrayList<in> arrayList, ArrayList<in> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{fx5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                nx5 nx5Var = new nx5(fx5Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                nx5Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, nx5Var));
                nx5 nx5Var2 = new nx5(fx5Var, 3);
                nx5Var2.z(z);
                nx5Var2.G(arrayList);
                nx5Var2.D(arrayList2);
                nx5Var2.y(z2);
                nx5Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    nx5Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    nx5Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, nx5Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<in> arrayList;
        my4 my4Var;
        ArrayList<in> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (my4Var = this.page) != null && my4Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                in inVar = this.threadList.get(i2);
                if (inVar instanceof pz4) {
                    pz4 pz4Var = (pz4) inVar;
                    if (pz4Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && pz4Var.t.getThreadAlaInfo() != null && pz4Var.t.getThreadAlaInfo().user_info != null && pz4Var.t.getThreadAlaInfo().user_info.is_official == 2 && pz4Var.t.getThreadAlaInfo().liveStageForceTop) {
                        i = i2;
                        break;
                    }
                } else {
                    if (inVar instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) inVar;
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
                    in inVar2 = this.threadList.get(i3);
                    if (inVar2 instanceof pz4) {
                        if (((pz4) inVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((inVar2 instanceof ThreadData) && ((ThreadData) inVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
            List<in> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!ListUtils.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    public void filterEnterList(List<mk9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, list) == null) && list != null && list.size() != 0) {
            Iterator<mk9> it = list.iterator();
            while (it.hasNext()) {
                mk9 next = it.next();
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

    public List<in> getShowTopThreadList() {
        InterceptResult invokeV;
        List<mk9> list;
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
                arrayList.add(new tk9(forum, this.forumRule));
            }
            if (forum != null && !hi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new sk9(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new sk9(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<in> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    in inVar = (in) ListUtils.getItem(topThreadList, i4);
                    if (inVar instanceof pz4) {
                        pz4 pz4Var = (pz4) inVar;
                        arrayList.add(pz4Var.t);
                        if (pz4Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (inVar instanceof ThreadData) {
                            arrayList.add(inVar);
                            if (((ThreadData) inVar).getIsMemberTop() != 1 || z) {
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
            ArrayList<in> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<in> it = arrayList.iterator();
            while (it.hasNext()) {
                in next = it.next();
                if (next != null && (next instanceof pz4)) {
                    pz4 pz4Var = (pz4) next;
                    if (TextUtils.equals(str, pz4Var.t.getId())) {
                        return pz4Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public void removeThread(String str) {
        ArrayList<in> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<in> it = arrayList.iterator();
        while (it.hasNext()) {
            in next = it.next();
            if (next != null && (next instanceof pz4) && TextUtils.equals(str, ((pz4) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(al9 al9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, al9Var) != null) || al9Var == null) {
            return;
        }
        this.forum.setCurScore(al9Var.c());
        this.forum.setLevelupScore(al9Var.i());
        this.forum.setLike(al9Var.n());
        this.forum.setUser_level(al9Var.m());
        this.forum.setLevelName(al9Var.h());
    }

    public boolean receiveData(pk9 pk9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, pk9Var)) == null) {
            if (pk9Var == null) {
                return false;
            }
            this.isFromCache = pk9Var.isFromCache;
            setBaWuNoticeNum(pk9Var.getBaWuNoticeNum());
            setSortType(pk9Var.getSortType());
            setAnti(pk9Var.getAnti());
            setChatGroup(pk9Var.getChatGroup());
            setFortuneBag(pk9Var.isFortuneBag());
            setFortuneDesc(pk9Var.getFortuneDesc());
            setForum(pk9Var.getForum());
            setGameName(pk9Var.getGameName());
            setGameUrl(pk9Var.getGameUrl());
            setGconAccount(pk9Var.getGconAccount());
            setHasGame(pk9Var.isHasGame());
            setIsNewUrl(pk9Var.getIsNewUrl());
            setPhotoLivePos(pk9Var.getPhotoLivePos());
            setPage(pk9Var.getPage());
            setStar(pk9Var.getStar());
            setStarEnter(pk9Var.getStarEnter());
            setThreadList(pk9Var.threadList);
            setThreadListIds(pk9Var.getThreadListIds());
            setUserData(pk9Var.getUserData());
            setUserMap(pk9Var.getUserMap());
            setActivityHeadData(pk9Var.getActivityHeadData());
            setFrsDefaultTabId(pk9Var.getFrsDefaultTabId());
            this.defaultShowTab = pk9Var.defaultShowTab;
            setCategoryInfos(pk9Var.getCategoryInfos());
            setBawuCenterUrl(pk9Var.getBawuCenterUrl());
            setCardVideoInfo(pk9Var.getCardVideoInfo());
            setHeadSdkData(pk9Var.getHeadSdkData());
            setSchoolRecommendPos(pk9Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(pk9Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(pk9Var.getEntelechyTabInfo());
            setAlaLiveCount(pk9Var.getAlaLiveCount());
            setCarrierEnterData(pk9Var.getCarrierEnterData());
            setForumState(pk9Var.getForumState());
            setAccessFlag(pk9Var.getAccessFlag());
            this.needLog = pk9Var.needLog;
            this.recommendBookData = pk9Var.recommendBookData;
            this.presentInfoData = pk9Var.presentInfoData;
            setBookInfo(pk9Var.getBookInfo());
            setMangaReadRecordChapterId(pk9Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(pk9Var.getHeadlineImgInfoData());
            setCardShipinPos(pk9Var.getCardShipinPos());
            setCardShipinNew(pk9Var.getCardShipinNew());
            this.enterFrsDialogInfo = pk9Var.enterFrsDialogInfo;
            setGameRankListData(pk9Var.getGameRankListData());
            setAgreeBanner(pk9Var.getAgreeBanner());
            setLiveNotify(pk9Var.getLiveNotify());
            setGameTabInfo(pk9Var.getGameTabInfo());
            setGameDefaultTabId(pk9Var.getGameDefaultTabId());
            setForumHeadIcon(pk9Var.getForumHeadIcon());
            setUserRecommend(pk9Var.getUserRecommend());
            setFrsVideoActivityData(pk9Var.getFrsVideoActivityData());
            this.mNewChapterInfo = pk9Var.mNewChapterInfo;
            setFrsInsertLiveData(pk9Var.getFrsInsertLiveData());
            this.recm_forum_list = pk9Var.getRecm_forum_list();
            setFrsStageLiveData(pk9Var.getFrsStageLiveData());
            this.forumArIno = pk9Var.forumArIno;
            this.starRank = pk9Var.starRank;
            this.postTopic = pk9Var.postTopic;
            this.mWindowToast = pk9Var.mWindowToast;
            this.activityConfig = pk9Var.activityConfig;
            setIsShowRedTip(pk9Var.isShowRedTip());
            this.isBrandForum = pk9Var.isBrandForum;
            this.brandAdData = pk9Var.brandAdData;
            this.oriForumInfoList = pk9Var.oriForumInfoList;
            this.bottomMenuList = pk9Var.bottomMenuList;
            this.adMixFloor = pk9Var.adMixFloor;
            this.adShowSelect = pk9Var.adShowSelect;
            this.adSampleMapKey = pk9Var.adSampleMapKey;
            q47.f().n(getAnti());
            q47.f().q(pk9Var.getForum().getId());
            q47.f().r(pk9Var.getForum().getName());
            p47.h().q(pk9Var.getForum().getId());
            if (pk9Var.getEntelechyTabInfo() != null) {
                p47.h().r(pk9Var.getEntelechyTabInfo().a);
            }
            if (pk9Var.getUserData() != null) {
                r47.c().e(pk9Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(pk9Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(pk9Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = pk9Var.smartAppAvatar;
            this.smartApp = pk9Var.smartApp;
            this.nebulaHotThreads = pk9Var.nebulaHotThreads;
            this.forumActiveInfo = pk9Var.forumActiveInfo;
            this.userList = pk9Var.userList;
            setBusinessPromot(pk9Var.getBusinessPromot());
            this.serviceAreaData = pk9Var.serviceAreaData;
            setHotUserRankData(pk9Var.getHotUserRankData());
            this.itemInfo = pk9Var.itemInfo;
            this.toLoadHorseData = pk9Var.toLoadHorseData;
            this.forumRule = pk9Var.forumRule;
            this.mSignActivityInfo = pk9Var.mSignActivityInfo;
            this.showAdsense = pk9Var.showAdsense;
            setVoiceRoomConfig(pk9Var.getVoiceRoomConfig());
            setVoiceRoomData(pk9Var.getVoiceRoomData());
            this.serviceAreaFlutterData = pk9Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = pk9Var.liveFuseForumDataList;
            this.frsGameRankInfoData = pk9Var.frsGameRankInfoData;
            this.frsBannerHeaderData = pk9Var.frsBannerHeaderData;
            this.forumTagInfo = pk9Var.forumTagInfo;
            this.firstCategory = pk9Var.firstCategory;
            this.frsForumGroup = pk9Var.frsForumGroup;
            return true;
        }
        return invokeL.booleanValue;
    }
}
