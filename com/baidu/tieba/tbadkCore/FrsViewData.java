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
import com.baidu.tieba.bo9;
import com.baidu.tieba.c77;
import com.baidu.tieba.cj6;
import com.baidu.tieba.co9;
import com.baidu.tieba.cz4;
import com.baidu.tieba.eo9;
import com.baidu.tieba.f05;
import com.baidu.tieba.f55;
import com.baidu.tieba.f67;
import com.baidu.tieba.fy5;
import com.baidu.tieba.g67;
import com.baidu.tieba.gg;
import com.baidu.tieba.gm7;
import com.baidu.tieba.go9;
import com.baidu.tieba.h67;
import com.baidu.tieba.hi;
import com.baidu.tieba.ho9;
import com.baidu.tieba.in;
import com.baidu.tieba.io9;
import com.baidu.tieba.jo9;
import com.baidu.tieba.ny5;
import com.baidu.tieba.po9;
import com.baidu.tieba.qm7;
import com.baidu.tieba.xk5;
import com.baidu.tieba.xn9;
import com.baidu.tieba.yn9;
import com.baidu.tieba.zy4;
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
public class FrsViewData extends eo9 implements xk5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public gm7 funAdController;
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

    @Override // com.baidu.tieba.eo9
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
            removeTopSameClassDataFromList(xn9.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            removeTopSameClassDataFromList(yn9.class, getThreadList());
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

    public void addRecommendAppToThreadList(fy5 fy5Var, ArrayList<in> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fy5Var, arrayList) == null) {
            addRecommendAppToThreadList(fy5Var, false, arrayList, null, false);
        }
    }

    private List<in> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        cz4 cz4Var;
        ArrayList<in> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<in> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (cz4Var = this.page) != null && cz4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    in inVar = this.threadList.get(i);
                    if (inVar instanceof f05) {
                        if (((f05) inVar).t.isHeadLinePost) {
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
            if (inVar instanceof f05) {
                ThreadData threadData = ((f05) inVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            co9 co9Var = new co9();
            co9Var.d(this.forum.getId());
            co9Var.c(feedForumList);
            this.threadList.add(i + 6, co9Var);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        cj6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    in inVar = this.threadList.get(i2);
                    if (inVar instanceof f05) {
                        ThreadData threadData = ((f05) inVar).t;
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
            while (!this.threadList.isEmpty() && (inVar = this.threadList.get(0)) != null && (inVar instanceof f05) && ((ThreadData) inVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            f05 f05Var = new f05();
            f05Var.t = threadData;
            this.threadList.add(0, f05Var);
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

    public void addRecommendAppToThreadList(fy5 fy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fy5Var) == null) {
            addRecommendAppToThreadList(fy5Var, false, this.threadList, null, false);
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

    public void setFunAdController(gm7 gm7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, gm7Var) == null) {
            this.funAdController = gm7Var;
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
        yn9 frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<in> threadList = getThreadList();
            removeTopSameClassDataFromList(yn9.class, threadList);
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
                if (next != null && next.getType() == jo9.c) {
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
            if (inVar instanceof f05) {
                ThreadData threadData = ((f05) inVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String s = f55.m().s("game_rank_list_info", "");
        if (!StringUtils.isNull(s) && s.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(gg.g(s.split(",")[0], 0L), System.currentTimeMillis()) < gg.e(s.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int n = f55.m().n("game_rank_list_show_times", 0);
                    if (!z) {
                        n++;
                    }
                    f55.m().z("game_rank_list_show_times", n);
                    if (n > 3) {
                        f55 m = f55.m();
                        m.B("game_rank_list_info", System.currentTimeMillis() + ",1");
                        f55.m().z("game_rank_list_show_times", 0);
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
        xn9 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<in> threadList = getThreadList();
            removeTopSameClassDataFromList(xn9.class, threadList);
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
            c77 userRecommend = getUserRecommend();
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
            go9 entelechyTabInfo = getEntelechyTabInfo();
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
                if (next != null && next.getType() == qm7.e) {
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
            if (it.next() instanceof c77) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(zy4 zy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, zy4Var) == null) && zy4Var != null && !StringUtils.isNull(zy4Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<in> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    in inVar = threadList.get(i);
                    if ((inVar instanceof f05) && zy4Var.getId().equals(((f05) inVar).t.getId()) && zy4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            zy4Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, zy4Var);
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
                if (next != null && (next instanceof f05)) {
                    f05 f05Var = (f05) next;
                    if (f05Var.t.getAuthor() != null && currentAccount.equals(f05Var.t.getAuthor().getUserId()) && f05Var.t.getAuthor().getPendantData() != null) {
                        f05Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        f05Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(fy5 fy5Var, boolean z, ArrayList<in> arrayList, ArrayList<in> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{fy5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                ny5 ny5Var = new ny5(fy5Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                ny5Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ny5Var));
                ny5 ny5Var2 = new ny5(fy5Var, 3);
                ny5Var2.z(z);
                ny5Var2.G(arrayList);
                ny5Var2.D(arrayList2);
                ny5Var2.y(z2);
                ny5Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    ny5Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    ny5Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ny5Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<in> arrayList;
        cz4 cz4Var;
        ArrayList<in> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (cz4Var = this.page) != null && cz4Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                in inVar = this.threadList.get(i2);
                if (inVar instanceof f05) {
                    f05 f05Var = (f05) inVar;
                    if (f05Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && f05Var.t.getThreadAlaInfo() != null && f05Var.t.getThreadAlaInfo().user_info != null && f05Var.t.getThreadAlaInfo().user_info.is_official == 2 && f05Var.t.getThreadAlaInfo().liveStageForceTop) {
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
                    if (inVar2 instanceof f05) {
                        if (((f05) inVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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

    public void filterEnterList(List<bo9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, list) == null) && list != null && list.size() != 0) {
            Iterator<bo9> it = list.iterator();
            while (it.hasNext()) {
                bo9 next = it.next();
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
        List<bo9> list;
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
                arrayList.add(new io9(forum, this.forumRule));
            }
            if (forum != null && !hi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new ho9(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new ho9(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<in> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    in inVar = (in) ListUtils.getItem(topThreadList, i4);
                    if (inVar instanceof f05) {
                        f05 f05Var = (f05) inVar;
                        arrayList.add(f05Var.t);
                        if (f05Var.t.getIsMemberTop() != 1 || z) {
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
                if (next != null && (next instanceof f05)) {
                    f05 f05Var = (f05) next;
                    if (TextUtils.equals(str, f05Var.t.getId())) {
                        return f05Var.t;
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
            if (next != null && (next instanceof f05) && TextUtils.equals(str, ((f05) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(po9 po9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, po9Var) != null) || po9Var == null) {
            return;
        }
        this.forum.setCurScore(po9Var.c());
        this.forum.setLevelupScore(po9Var.i());
        this.forum.setLike(po9Var.n());
        this.forum.setUser_level(po9Var.m());
        this.forum.setLevelName(po9Var.h());
    }

    public boolean receiveData(eo9 eo9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, eo9Var)) == null) {
            if (eo9Var == null) {
                return false;
            }
            this.isFromCache = eo9Var.isFromCache;
            setBaWuNoticeNum(eo9Var.getBaWuNoticeNum());
            setSortType(eo9Var.getSortType());
            setAnti(eo9Var.getAnti());
            setChatGroup(eo9Var.getChatGroup());
            setFortuneBag(eo9Var.isFortuneBag());
            setFortuneDesc(eo9Var.getFortuneDesc());
            setForum(eo9Var.getForum());
            setGameName(eo9Var.getGameName());
            setGameUrl(eo9Var.getGameUrl());
            setGconAccount(eo9Var.getGconAccount());
            setHasGame(eo9Var.isHasGame());
            setIsNewUrl(eo9Var.getIsNewUrl());
            setPhotoLivePos(eo9Var.getPhotoLivePos());
            setPage(eo9Var.getPage());
            setStar(eo9Var.getStar());
            setStarEnter(eo9Var.getStarEnter());
            setThreadList(eo9Var.threadList);
            setThreadListIds(eo9Var.getThreadListIds());
            setUserData(eo9Var.getUserData());
            setUserMap(eo9Var.getUserMap());
            setActivityHeadData(eo9Var.getActivityHeadData());
            setFrsDefaultTabId(eo9Var.getFrsDefaultTabId());
            this.defaultShowTab = eo9Var.defaultShowTab;
            setCategoryInfos(eo9Var.getCategoryInfos());
            setBawuCenterUrl(eo9Var.getBawuCenterUrl());
            setCardVideoInfo(eo9Var.getCardVideoInfo());
            setHeadSdkData(eo9Var.getHeadSdkData());
            setSchoolRecommendPos(eo9Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(eo9Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(eo9Var.getEntelechyTabInfo());
            setAlaLiveCount(eo9Var.getAlaLiveCount());
            setCarrierEnterData(eo9Var.getCarrierEnterData());
            setForumState(eo9Var.getForumState());
            setAccessFlag(eo9Var.getAccessFlag());
            this.needLog = eo9Var.needLog;
            this.recommendBookData = eo9Var.recommendBookData;
            this.presentInfoData = eo9Var.presentInfoData;
            setBookInfo(eo9Var.getBookInfo());
            setMangaReadRecordChapterId(eo9Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(eo9Var.getHeadlineImgInfoData());
            setCardShipinPos(eo9Var.getCardShipinPos());
            setCardShipinNew(eo9Var.getCardShipinNew());
            this.enterFrsDialogInfo = eo9Var.enterFrsDialogInfo;
            setGameRankListData(eo9Var.getGameRankListData());
            setAgreeBanner(eo9Var.getAgreeBanner());
            setLiveNotify(eo9Var.getLiveNotify());
            setGameTabInfo(eo9Var.getGameTabInfo());
            setGameDefaultTabId(eo9Var.getGameDefaultTabId());
            setForumHeadIcon(eo9Var.getForumHeadIcon());
            setUserRecommend(eo9Var.getUserRecommend());
            setFrsVideoActivityData(eo9Var.getFrsVideoActivityData());
            this.mNewChapterInfo = eo9Var.mNewChapterInfo;
            setFrsInsertLiveData(eo9Var.getFrsInsertLiveData());
            this.recm_forum_list = eo9Var.getRecm_forum_list();
            setFrsStageLiveData(eo9Var.getFrsStageLiveData());
            this.forumArIno = eo9Var.forumArIno;
            this.starRank = eo9Var.starRank;
            this.postTopic = eo9Var.postTopic;
            this.mWindowToast = eo9Var.mWindowToast;
            this.activityConfig = eo9Var.activityConfig;
            setIsShowRedTip(eo9Var.isShowRedTip());
            this.isBrandForum = eo9Var.isBrandForum;
            this.brandAdData = eo9Var.brandAdData;
            this.oriForumInfoList = eo9Var.oriForumInfoList;
            this.bottomMenuList = eo9Var.bottomMenuList;
            this.adMixFloor = eo9Var.adMixFloor;
            this.adShowSelect = eo9Var.adShowSelect;
            this.adSampleMapKey = eo9Var.adSampleMapKey;
            g67.f().n(getAnti());
            g67.f().q(eo9Var.getForum().getId());
            g67.f().r(eo9Var.getForum().getName());
            f67.h().q(eo9Var.getForum().getId());
            if (eo9Var.getEntelechyTabInfo() != null) {
                f67.h().r(eo9Var.getEntelechyTabInfo().a);
            }
            if (eo9Var.getUserData() != null) {
                h67.c().e(eo9Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(eo9Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(eo9Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = eo9Var.smartAppAvatar;
            this.smartApp = eo9Var.smartApp;
            this.nebulaHotThreads = eo9Var.nebulaHotThreads;
            this.forumActiveInfo = eo9Var.forumActiveInfo;
            this.userList = eo9Var.userList;
            setBusinessPromot(eo9Var.getBusinessPromot());
            this.serviceAreaData = eo9Var.serviceAreaData;
            setHotUserRankData(eo9Var.getHotUserRankData());
            this.itemInfo = eo9Var.itemInfo;
            this.toLoadHorseData = eo9Var.toLoadHorseData;
            this.forumRule = eo9Var.forumRule;
            this.mSignActivityInfo = eo9Var.mSignActivityInfo;
            this.showAdsense = eo9Var.showAdsense;
            setVoiceRoomConfig(eo9Var.getVoiceRoomConfig());
            setVoiceRoomData(eo9Var.getVoiceRoomData());
            this.serviceAreaFlutterData = eo9Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = eo9Var.liveFuseForumDataList;
            this.frsGameRankInfoData = eo9Var.frsGameRankInfoData;
            this.frsBannerHeaderData = eo9Var.frsBannerHeaderData;
            this.forumTagInfo = eo9Var.forumTagInfo;
            this.firstCategory = eo9Var.firstCategory;
            this.frsForumGroup = eo9Var.frsForumGroup;
            return true;
        }
        return invokeL.booleanValue;
    }
}
