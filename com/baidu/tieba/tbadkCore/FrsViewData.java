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
import com.baidu.tieba.bb9;
import com.baidu.tieba.eg6;
import com.baidu.tieba.gg;
import com.baidu.tieba.gi;
import com.baidu.tieba.gn;
import com.baidu.tieba.gw5;
import com.baidu.tieba.gy4;
import com.baidu.tieba.ja9;
import com.baidu.tieba.jy4;
import com.baidu.tieba.ka9;
import com.baidu.tieba.m35;
import com.baidu.tieba.mz4;
import com.baidu.tieba.na7;
import com.baidu.tieba.na9;
import com.baidu.tieba.oa9;
import com.baidu.tieba.qa9;
import com.baidu.tieba.rw6;
import com.baidu.tieba.sa9;
import com.baidu.tieba.ta9;
import com.baidu.tieba.ua9;
import com.baidu.tieba.uv6;
import com.baidu.tieba.va9;
import com.baidu.tieba.vv6;
import com.baidu.tieba.wv6;
import com.baidu.tieba.xa7;
import com.baidu.tieba.xi5;
import com.baidu.tieba.yv5;
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
public class FrsViewData extends qa9 implements xi5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public na7 funAdController;
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

    @Override // com.baidu.tieba.qa9
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

    public List<gn> getTopThreadList() {
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
            removeTopSameClassDataFromList(ja9.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            removeTopSameClassDataFromList(ka9.class, getThreadList());
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

    public void addRecommendAppToThreadList(yv5 yv5Var, ArrayList<gn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yv5Var, arrayList) == null) {
            addRecommendAppToThreadList(yv5Var, false, arrayList, null, false);
        }
    }

    private List<gn> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        jy4 jy4Var;
        ArrayList<gn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<gn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (jy4Var = this.page) != null && jy4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    gn gnVar = this.threadList.get(i);
                    if (gnVar instanceof mz4) {
                        if (((mz4) gnVar).t.isHeadLinePost) {
                            arrayList2.add(gnVar);
                        }
                    } else if ((gnVar instanceof ThreadData) && ((ThreadData) gnVar).isHeadLinePost) {
                        arrayList2.add(gnVar);
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
            gn gnVar = this.threadList.get(i2);
            if (gnVar instanceof mz4) {
                ThreadData threadData = ((mz4) gnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            oa9 oa9Var = new oa9();
            oa9Var.f(this.forum.getId());
            oa9Var.c(feedForumList);
            this.threadList.add(i + 6, oa9Var);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        eg6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    gn gnVar = this.threadList.get(i2);
                    if (gnVar instanceof mz4) {
                        ThreadData threadData = ((mz4) gnVar).t;
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
        gn gnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (gnVar = this.threadList.get(0)) != null && (gnVar instanceof mz4) && ((ThreadData) gnVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            mz4 mz4Var = new mz4();
            mz4Var.t = threadData;
            this.threadList.add(0, mz4Var);
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || getForum() == null) {
            return;
        }
        List<gn> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<gn> threadList = getThreadList();
        if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
            int size = cardShipinPos.size();
            int size2 = threadList.size();
            for (int i = 0; i < size; i++) {
                if (i < cardShipinNew.size()) {
                    gn gnVar = cardShipinNew.get(i);
                    int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                    Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + gnVar.getType());
                    threadList.add(videoThreadInserPos, gnVar);
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

    public void addRecommendAppToThreadList(yv5 yv5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, yv5Var) == null) {
            addRecommendAppToThreadList(yv5Var, false, this.threadList, null, false);
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

    public void setFunAdController(na7 na7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, na7Var) == null) {
            this.funAdController = na7Var;
        }
    }

    public void setTopThreadList(List<gn> list) {
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<gn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, cls, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                gn gnVar = arrayList.get(i);
                if (gnVar.getClass() == cls) {
                    arrayList2.add(gnVar);
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
            ArrayList<gn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        ka9 frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<gn> threadList = getThreadList();
            removeTopSameClassDataFromList(ka9.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<gn> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                gn next = it.next();
                if (next != null && next.getType() == va9.c) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<gn> arrayList;
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
            gn gnVar = this.threadList.get(i2);
            if (gnVar instanceof mz4) {
                ThreadData threadData = ((mz4) gnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String s = m35.m().s("game_rank_list_info", "");
        if (!StringUtils.isNull(s) && s.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(gg.g(s.split(",")[0], 0L), System.currentTimeMillis()) < gg.e(s.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int n = m35.m().n("game_rank_list_show_times", 0);
                    if (!z) {
                        n++;
                    }
                    m35.m().z("game_rank_list_show_times", n);
                    if (n > 3) {
                        m35 m = m35.m();
                        m.B("game_rank_list_info", System.currentTimeMillis() + ",1");
                        m35.m().z("game_rank_list_show_times", 0);
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
        ja9 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<gn> threadList = getThreadList();
            removeTopSameClassDataFromList(ja9.class, threadList);
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
            rw6 userRecommend = getUserRecommend();
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
            ArrayList<gn> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<gn> it = this.threadList.iterator();
                while (it.hasNext()) {
                    gn next = it.next();
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
            sa9 entelechyTabInfo = getEntelechyTabInfo();
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
            Iterator<gn> it = this.threadList.iterator();
            while (it.hasNext()) {
                gn next = it.next();
                if (next != null && next.getType() == xa7.e) {
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
        Iterator<gn> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof rw6) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(gy4 gy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, gy4Var) == null) && gy4Var != null && !StringUtils.isNull(gy4Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<gn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    gn gnVar = threadList.get(i);
                    if ((gnVar instanceof mz4) && gy4Var.getId().equals(((mz4) gnVar).t.getId()) && gy4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            gy4Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, gy4Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<gn> it = this.threadList.iterator();
            while (it.hasNext()) {
                gn next = it.next();
                if (next != null && (next instanceof mz4)) {
                    mz4 mz4Var = (mz4) next;
                    if (mz4Var.t.getAuthor() != null && currentAccount.equals(mz4Var.t.getAuthor().getUserId()) && mz4Var.t.getAuthor().getPendantData() != null) {
                        mz4Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        mz4Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(yv5 yv5Var, boolean z, ArrayList<gn> arrayList, ArrayList<gn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{yv5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                gw5 gw5Var = new gw5(yv5Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                gw5Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, gw5Var));
                gw5 gw5Var2 = new gw5(yv5Var, 3);
                gw5Var2.z(z);
                gw5Var2.G(arrayList);
                gw5Var2.D(arrayList2);
                gw5Var2.y(z2);
                gw5Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    gw5Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    gw5Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, gw5Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<gn> arrayList;
        jy4 jy4Var;
        ArrayList<gn> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (jy4Var = this.page) != null && jy4Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                gn gnVar = this.threadList.get(i2);
                if (gnVar instanceof mz4) {
                    mz4 mz4Var = (mz4) gnVar;
                    if (mz4Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && mz4Var.t.getThreadAlaInfo() != null && mz4Var.t.getThreadAlaInfo().user_info != null && mz4Var.t.getThreadAlaInfo().user_info.is_official == 2 && mz4Var.t.getThreadAlaInfo().liveStageForceTop) {
                        i = i2;
                        break;
                    }
                } else {
                    if (gnVar instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) gnVar;
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
                    gn gnVar2 = this.threadList.get(i3);
                    if (gnVar2 instanceof mz4) {
                        if (((mz4) gnVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((gnVar2 instanceof ThreadData) && ((ThreadData) gnVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
            List<gn> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!ListUtils.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    public void filterEnterList(List<na9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, list) == null) && list != null && list.size() != 0) {
            Iterator<na9> it = list.iterator();
            while (it.hasNext()) {
                na9 next = it.next();
                if (next == null) {
                    it.remove();
                } else if (StringUtils.isNull(next.h()) || StringUtils.isNull(next.f())) {
                    if (next.a() != 1) {
                        it.remove();
                    }
                }
            }
        }
    }

    public List<gn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<na9> list;
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
                arrayList.add(new ua9(forum, this.forumRule));
            }
            if (forum != null && !gi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new ta9(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new ta9(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<gn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    gn gnVar = (gn) ListUtils.getItem(topThreadList, i4);
                    if (gnVar instanceof mz4) {
                        mz4 mz4Var = (mz4) gnVar;
                        arrayList.add(mz4Var.t);
                        if (mz4Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (gnVar instanceof ThreadData) {
                            arrayList.add(gnVar);
                            if (((ThreadData) gnVar).getIsMemberTop() != 1 || z) {
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
            ArrayList<gn> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<gn> it = arrayList.iterator();
            while (it.hasNext()) {
                gn next = it.next();
                if (next != null && (next instanceof mz4)) {
                    mz4 mz4Var = (mz4) next;
                    if (TextUtils.equals(str, mz4Var.t.getId())) {
                        return mz4Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public void removeThread(String str) {
        ArrayList<gn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<gn> it = arrayList.iterator();
        while (it.hasNext()) {
            gn next = it.next();
            if (next != null && (next instanceof mz4) && TextUtils.equals(str, ((mz4) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(bb9 bb9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, bb9Var) != null) || bb9Var == null) {
            return;
        }
        this.forum.setCurScore(bb9Var.c());
        this.forum.setLevelupScore(bb9Var.i());
        this.forum.setLike(bb9Var.n());
        this.forum.setUser_level(bb9Var.m());
        this.forum.setLevelName(bb9Var.h());
    }

    public boolean receiveData(qa9 qa9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, qa9Var)) == null) {
            if (qa9Var == null) {
                return false;
            }
            this.isFromCache = qa9Var.isFromCache;
            setBaWuNoticeNum(qa9Var.getBaWuNoticeNum());
            setSortType(qa9Var.getSortType());
            setAnti(qa9Var.getAnti());
            setChatGroup(qa9Var.getChatGroup());
            setFortuneBag(qa9Var.isFortuneBag());
            setFortuneDesc(qa9Var.getFortuneDesc());
            setForum(qa9Var.getForum());
            setGameName(qa9Var.getGameName());
            setGameUrl(qa9Var.getGameUrl());
            setGconAccount(qa9Var.getGconAccount());
            setHasGame(qa9Var.isHasGame());
            setIsNewUrl(qa9Var.getIsNewUrl());
            setPhotoLivePos(qa9Var.getPhotoLivePos());
            setPage(qa9Var.getPage());
            setStar(qa9Var.getStar());
            setStarEnter(qa9Var.getStarEnter());
            setThreadList(qa9Var.threadList);
            setThreadListIds(qa9Var.getThreadListIds());
            setUserData(qa9Var.getUserData());
            setUserMap(qa9Var.getUserMap());
            setActivityHeadData(qa9Var.getActivityHeadData());
            setFrsDefaultTabId(qa9Var.getFrsDefaultTabId());
            this.defaultShowTab = qa9Var.defaultShowTab;
            setCategoryInfos(qa9Var.getCategoryInfos());
            setBawuCenterUrl(qa9Var.getBawuCenterUrl());
            setCardVideoInfo(qa9Var.getCardVideoInfo());
            setHeadSdkData(qa9Var.getHeadSdkData());
            setSchoolRecommendPos(qa9Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(qa9Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(qa9Var.getEntelechyTabInfo());
            setAlaLiveCount(qa9Var.getAlaLiveCount());
            setCarrierEnterData(qa9Var.getCarrierEnterData());
            setForumState(qa9Var.getForumState());
            setAccessFlag(qa9Var.getAccessFlag());
            this.needLog = qa9Var.needLog;
            this.recommendBookData = qa9Var.recommendBookData;
            this.presentInfoData = qa9Var.presentInfoData;
            setBookInfo(qa9Var.getBookInfo());
            setMangaReadRecordChapterId(qa9Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(qa9Var.getHeadlineImgInfoData());
            setCardShipinPos(qa9Var.getCardShipinPos());
            setCardShipinNew(qa9Var.getCardShipinNew());
            this.enterFrsDialogInfo = qa9Var.enterFrsDialogInfo;
            setGameRankListData(qa9Var.getGameRankListData());
            setAgreeBanner(qa9Var.getAgreeBanner());
            setLiveNotify(qa9Var.getLiveNotify());
            setGameTabInfo(qa9Var.getGameTabInfo());
            setGameDefaultTabId(qa9Var.getGameDefaultTabId());
            setForumHeadIcon(qa9Var.getForumHeadIcon());
            setUserRecommend(qa9Var.getUserRecommend());
            setFrsVideoActivityData(qa9Var.getFrsVideoActivityData());
            this.mNewChapterInfo = qa9Var.mNewChapterInfo;
            setFrsInsertLiveData(qa9Var.getFrsInsertLiveData());
            this.recm_forum_list = qa9Var.getRecm_forum_list();
            setFrsStageLiveData(qa9Var.getFrsStageLiveData());
            this.forumArIno = qa9Var.forumArIno;
            this.starRank = qa9Var.starRank;
            this.postTopic = qa9Var.postTopic;
            this.mWindowToast = qa9Var.mWindowToast;
            this.activityConfig = qa9Var.activityConfig;
            setIsShowRedTip(qa9Var.isShowRedTip());
            this.isBrandForum = qa9Var.isBrandForum;
            this.brandAdData = qa9Var.brandAdData;
            this.oriForumInfoList = qa9Var.oriForumInfoList;
            this.bottomMenuList = qa9Var.bottomMenuList;
            this.adMixFloor = qa9Var.adMixFloor;
            this.adShowSelect = qa9Var.adShowSelect;
            this.adSampleMapKey = qa9Var.adSampleMapKey;
            vv6.f().n(getAnti());
            vv6.f().q(qa9Var.getForum().getId());
            vv6.f().r(qa9Var.getForum().getName());
            uv6.h().q(qa9Var.getForum().getId());
            if (qa9Var.getEntelechyTabInfo() != null) {
                uv6.h().r(qa9Var.getEntelechyTabInfo().a);
            }
            if (qa9Var.getUserData() != null) {
                wv6.c().e(qa9Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(qa9Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(qa9Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = qa9Var.smartAppAvatar;
            this.smartApp = qa9Var.smartApp;
            this.nebulaHotThreads = qa9Var.nebulaHotThreads;
            this.forumActiveInfo = qa9Var.forumActiveInfo;
            this.userList = qa9Var.userList;
            setBusinessPromot(qa9Var.getBusinessPromot());
            this.serviceAreaData = qa9Var.serviceAreaData;
            setHotUserRankData(qa9Var.getHotUserRankData());
            this.itemInfo = qa9Var.itemInfo;
            this.toLoadHorseData = qa9Var.toLoadHorseData;
            this.forumRule = qa9Var.forumRule;
            this.mSignActivityInfo = qa9Var.mSignActivityInfo;
            this.showAdsense = qa9Var.showAdsense;
            setVoiceRoomConfig(qa9Var.getVoiceRoomConfig());
            setVoiceRoomData(qa9Var.getVoiceRoomData());
            this.serviceAreaFlutterData = qa9Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = qa9Var.liveFuseForumDataList;
            this.frsGameRankInfoData = qa9Var.frsGameRankInfoData;
            this.frsBannerHeaderData = qa9Var.frsBannerHeaderData;
            this.forumTagInfo = qa9Var.forumTagInfo;
            this.firstCategory = qa9Var.firstCategory;
            this.frsForumGroup = qa9Var.frsForumGroup;
            return true;
        }
        return invokeL.booleanValue;
    }
}
