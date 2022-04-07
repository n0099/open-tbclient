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
import com.baidu.tbadk.core.data.RecommendForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.TopNoticeData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ad6;
import com.repackage.aj8;
import com.repackage.bd6;
import com.repackage.dj8;
import com.repackage.dq4;
import com.repackage.ej8;
import com.repackage.ek8;
import com.repackage.gh5;
import com.repackage.hj8;
import com.repackage.hy5;
import com.repackage.i65;
import com.repackage.ij8;
import com.repackage.js6;
import com.repackage.kj8;
import com.repackage.mg;
import com.repackage.mj8;
import com.repackage.ni;
import com.repackage.nj8;
import com.repackage.np4;
import com.repackage.oh5;
import com.repackage.oj8;
import com.repackage.pj8;
import com.repackage.qj8;
import com.repackage.qp4;
import com.repackage.rq4;
import com.repackage.rs6;
import com.repackage.ud6;
import com.repackage.uo;
import com.repackage.vj8;
import com.repackage.wt4;
import com.repackage.xj8;
import com.repackage.yc6;
import com.repackage.zc6;
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
/* loaded from: classes4.dex */
public class FrsViewData extends kj8 implements i65, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public js6 funAdController;
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

    private int getAlaLiveThreadCardInsertPos(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65537, this, i, i2)) == null) ? Math.min((getTopThreadSize() + i) - 1, i2) : invokeII.intValue;
    }

    private List<uo> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        qp4 qp4Var;
        ArrayList<uo> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<uo> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (qp4Var = this.page) != null && qp4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    uo uoVar = this.threadList.get(i);
                    if (uoVar instanceof rq4) {
                        if (((rq4) uoVar).s.isHeadLinePost) {
                            arrayList2.add(uoVar);
                        }
                    } else if ((uoVar instanceof ThreadData) && ((ThreadData) uoVar).isHeadLinePost) {
                        arrayList2.add(uoVar);
                    }
                }
            }
            return arrayList2;
        }
        return (List) invokeV.objValue;
    }

    private int getOperatorFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Iterator<uo> it = this.threadList.iterator();
            while (it.hasNext()) {
                uo next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    if (threadData.getIsLive() == 1) {
                        return threadData.getOperatorFlag();
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    private int getPhotoliveCardInsertPos(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) ? Math.min((getTopThreadSize() + getPhotoLivePos()) - 1, i) : invokeI.intValue;
    }

    private int getVideoThreadInserPos(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65541, this, i, i2)) == null) ? Math.min((getTopThreadSize() + i) - 1, i2) : invokeII.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isShowRecommendBars(ArrayList<RecommendForumData> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() < 2) {
                return false;
            }
            Iterator<RecommendForumData> it = arrayList.iterator();
            while (it.hasNext()) {
                RecommendForumData next = it.next();
                if (next == null || StringUtils.isNull(next.mForumName)) {
                    return false;
                }
                while (it.hasNext()) {
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void removeTopSameClassDataFromList(Class cls, ArrayList<uo> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, this, cls, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            uo uoVar = arrayList.get(i);
            if (uoVar.getClass() == cls) {
                arrayList2.add(uoVar);
                break;
            }
            i++;
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        arrayList.removeAll(arrayList2);
    }

    public void addCardVideoInfoToThreadList() {
        ThreadData cardVideoInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || getForum() == null || (cardVideoInfo = getCardVideoInfo()) == null) {
            return;
        }
        Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + cardVideoInfo.getTid());
        ArrayList<uo> threadList = getThreadList();
        if (threadList == null || threadList.size() <= 0) {
            return;
        }
        threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
    }

    public void addFeedForumDataToThreadList() {
        ForumData forumData;
        List<FeedForumData> feedForumList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.threadList == null || (forumData = this.forum) == null || forumData.getBannerListData() == null || MessageManager.getInstance().findTask(2003016) == null) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            uo uoVar = this.threadList.get(i2);
            if (uoVar instanceof rq4) {
                ThreadData threadData = ((rq4) uoVar).s;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (feedForumList = this.forum.getBannerListData().getFeedForumList()) == null || feedForumList.size() <= 0) {
            return;
        }
        ij8 ij8Var = new ij8();
        ij8Var.f(this.forum.getId());
        ij8Var.e(feedForumList);
        this.threadList.add(i + 6, ij8Var);
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
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        removeGameRankListFromThreadList();
        if (getGameRankListData() == null) {
            return;
        }
        boolean z3 = false;
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            uo uoVar = this.threadList.get(i2);
            if (uoVar instanceof rq4) {
                ThreadData threadData = ((rq4) uoVar).s;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String q = wt4.k().q("game_rank_list_info", "");
        if (!StringUtils.isNull(q) && q.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(mg.g(q.split(",")[0], 0L), System.currentTimeMillis()) < mg.e(q.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int l = wt4.k().l("game_rank_list_show_times", 0);
                    if (!z) {
                        l++;
                    }
                    wt4.k().w("game_rank_list_show_times", l);
                    if (l > 3) {
                        wt4 k = wt4.k();
                        k.y("game_rank_list_info", System.currentTimeMillis() + ",1");
                        wt4.k().w("game_rank_list_show_times", 0);
                        if (z3) {
                            this.threadList.add((i + getGameRankListData().a()) - 1, getGameRankListData());
                            return;
                        }
                        return;
                    }
                }
                z3 = z2;
                if (z3) {
                }
            }
        }
        z2 = true;
        if (z2) {
        }
        z3 = z2;
        if (z3) {
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        hy5 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    uo uoVar = this.threadList.get(i2);
                    if (uoVar instanceof rq4) {
                        ThreadData threadData = ((rq4) uoVar).s;
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

    public void addInsertLiveDataToThreadList() {
        dj8 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsInsertLiveData = getFrsInsertLiveData()) == null) {
            return;
        }
        ArrayList<uo> threadList = getThreadList();
        removeTopSameClassDataFromList(dj8.class, threadList);
        threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.b, threadList.size()), frsInsertLiveData);
    }

    public void addMyNewThread(np4 np4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, np4Var) == null) || np4Var == null || StringUtils.isNull(np4Var.getId()) || this.threadList == null) {
            return;
        }
        int topThreadSize = getTopThreadSize();
        ArrayList<uo> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            for (int i = 0; i < size; i++) {
                uo uoVar = threadList.get(i);
                if ((uoVar instanceof rq4) && np4Var.getId().equals(((rq4) uoVar).s.getId()) && np4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                    return;
                }
            }
        }
        np4Var.isFromBrandForum = this.isBrandForum;
        this.postThreadCount++;
        this.threadList.add(topThreadSize, np4Var);
    }

    public void addNoticeThreadToThreadList() {
        TopNoticeData top_notice_data;
        uo uoVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getForum() == null || this.threadList == null || (top_notice_data = getForum().getTop_notice_data()) == null || top_notice_data.getTitle() == null) {
            return;
        }
        while (!this.threadList.isEmpty() && (uoVar = this.threadList.get(0)) != null && (uoVar instanceof rq4) && ((ThreadData) uoVar).getIs_top() == 2) {
            this.threadList.remove(0);
        }
        ThreadData threadData = new ThreadData();
        threadData.setTitle(top_notice_data.getTitle());
        threadData.setTid(top_notice_data.getTitle_link());
        threadData.setIs_top(2);
        threadData.parser_title();
        rq4 rq4Var = new rq4();
        rq4Var.s = threadData;
        this.threadList.add(0, rq4Var);
    }

    public void addOfficialBarToThreadList() {
        qp4 qp4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.forum == null || this.threadList == null || !ThreadData.isFRSExtraLoaded.get() || (qp4Var = this.page) == null) {
            return;
        }
        boolean z = true;
        if (qp4Var.a() == 1) {
            qj8 qj8Var = this.gconAccount;
            z = (qj8Var == null || !qj8Var.b()) ? false : false;
            if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof xj8)) {
                    this.threadList.remove(0);
                }
                xj8 xj8Var = new xj8();
                xj8Var.k(this.fortuneBag);
                xj8Var.m(this.fortuneDesc);
                xj8Var.q(this.gconAccount);
                xj8Var.setIs_top(1003);
                ArrayList<uo> arrayList = this.threadList;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                ListUtils.add(this.threadList, getTopThreadSize(), xj8Var);
            }
        }
    }

    public void addRecommendAppToThreadList(gh5 gh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gh5Var) == null) {
            addRecommendAppToThreadList(gh5Var, false, this.threadList, null, false);
        }
    }

    public void addRecommendBarsToThreadList() {
        ArrayList<uo> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.forum == null || (arrayList = this.threadList) == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<uo> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof dq4) {
                it.remove();
            }
        }
        qp4 qp4Var = this.page;
        if (qp4Var == null || qp4Var.a() != 1) {
            return;
        }
        ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
        dq4 dq4Var = new dq4();
        if (recommendForumData != null) {
            dq4Var.e().addAll(recommendForumData);
        }
        if (isShowRecommendBars(dq4Var.e())) {
            int i = 0;
            Iterator<uo> it2 = this.threadList.iterator();
            while (it2.hasNext()) {
                uo next = it2.next();
                if ((next instanceof rq4) && ((rq4) next).s.isTop()) {
                    i++;
                }
            }
            this.threadList.add(i + 1, dq4Var);
        }
    }

    public void addSchoolRecommendToThreadList() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || MessageManager.getInstance().findTask(2003016) == null) {
            return;
        }
        int schoolRecommendPos = (getSchoolRecommendPos() + getTopThreadSize()) - 1;
        if (getSchoolRecommendUserInfo() == null || schoolRecommendPos < 0 || schoolRecommendPos > this.threadList.size()) {
            return;
        }
        this.threadList.add(schoolRecommendPos, getSchoolRecommendUserInfo());
    }

    public void addStageLiveDataToThreadList() {
        ej8 frsStageLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsStageLiveData = getFrsStageLiveData()) == null) {
            return;
        }
        ArrayList<uo> threadList = getThreadList();
        removeTopSameClassDataFromList(ej8.class, threadList);
        if (ListUtils.isEmpty(frsStageLiveData.a)) {
            return;
        }
        threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
    }

    public void addU9DataToThreadList() {
        ForumData forumData;
        qp4 qp4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (forumData = this.forum) == null) {
            return;
        }
        if (((forumData.getTopCode() == null || StringUtils.isNull(this.forum.getTopCode().g())) && (this.forum.getNewsInfo() == null || StringUtils.isNull(this.forum.getNewsInfo().N0()))) || (qp4Var = this.page) == null || qp4Var.a() != 1) {
            return;
        }
        ek8 ek8Var = new ek8();
        ek8Var.m(this.forum.getTopCode());
        ek8Var.q(this.forum.getNewsInfo());
        ek8Var.setIs_top(3);
        ek8Var.k(true);
        if (ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<uo> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            uo next = it.next();
            if (next instanceof ThreadData) {
                ThreadData threadData = (ThreadData) next;
                if (threadData.getIs_top() != 0) {
                    if (threadData.getIs_top() == 1003) {
                        ek8Var.k(false);
                    }
                    i++;
                }
            }
        }
        this.threadList.add(i, ek8Var);
    }

    public void addUserRecommendToThreadList() {
        int a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || getUserRecommend() == null) {
            return;
        }
        ud6 userRecommend = getUserRecommend();
        if (ListUtils.getCount(userRecommend.e()) >= 3 && (a = userRecommend.a()) > 0) {
            int topThreadSize = a + getTopThreadSize();
            if (topThreadSize > this.threadList.size()) {
                this.threadList.add(userRecommend);
            } else {
                this.threadList.add(topThreadSize, userRecommend);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || getFrsVideoActivityData() == null || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<uo> it = this.threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            uo next = it.next();
            if (next != null && next.getType() == pj8.c) {
                this.threadList.remove(next);
                break;
            }
        }
        this.threadList.add(0, getFrsVideoActivityData());
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || getForum() == null) {
            return;
        }
        List<uo> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<uo> threadList = getThreadList();
        if (cardShipinPos == null || cardShipinPos.size() <= 0 || cardShipinNew == null || cardShipinNew.size() <= 0 || threadList == null) {
            return;
        }
        int size = cardShipinPos.size();
        int size2 = threadList.size();
        for (int i = 0; i < size; i++) {
            if (i < cardShipinNew.size()) {
                uo uoVar = cardShipinNew.get(i);
                int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + uoVar.getType());
                threadList.add(videoThreadInserPos, uoVar);
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<uo> arrayList;
        qp4 qp4Var;
        ArrayList<uo> arrayList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (arrayList = this.threadList) == null || arrayList.size() <= 0 || (qp4Var = this.page) == null || qp4Var.a() != 1 || (arrayList2 = this.threadList) == null || arrayList2.size() <= 0) {
            return;
        }
        int i = -1;
        int size = this.threadList.size();
        for (int i2 = 0; i2 < size; i2++) {
            uo uoVar = this.threadList.get(i2);
            if (uoVar instanceof rq4) {
                rq4 rq4Var = (rq4) uoVar;
                if (rq4Var.s.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && rq4Var.s.getThreadAlaInfo() != null && ((ThreadData) uoVar).getThreadAlaInfo().user_info != null && rq4Var.s.getThreadAlaInfo().user_info.is_official == 2 && rq4Var.s.getThreadAlaInfo().liveStageForceTop) {
                    i = i2;
                    break;
                }
            } else {
                if (uoVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) uoVar;
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
                uo uoVar2 = this.threadList.get(i3);
                if (uoVar2 instanceof rq4) {
                    if (((rq4) uoVar2).s.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        i = i3;
                        break;
                    }
                } else {
                    if ((uoVar2 instanceof ThreadData) && ((ThreadData) uoVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
        List<uo> headLineDataInThreadList = getHeadLineDataInThreadList();
        if (ListUtils.isEmpty(headLineDataInThreadList)) {
            return;
        }
        this.threadList.removeAll(headLineDataInThreadList);
        if (topThreadSize < 0 || topThreadSize > this.threadList.size()) {
            return;
        }
        this.threadList.addAll(topThreadSize, headLineDataInThreadList);
    }

    public void clearPostThreadCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.postThreadCount = 0;
        }
    }

    public void filterEnterList(List<hj8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        Iterator<hj8> it = list.iterator();
        while (it.hasNext()) {
            hj8 next = it.next();
            if (next == null) {
                it.remove();
            } else if (StringUtils.isNull(next.i()) || StringUtils.isNull(next.f())) {
                if (next.a() != 1) {
                    it.remove();
                }
            }
        }
    }

    public bd6 getBrandAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.brandAdData : (bd6) invokeV.objValue;
    }

    public ForumActiveInfo getForumActiveInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.forumActiveInfo : (ForumActiveInfo) invokeV.objValue;
    }

    public BdUniqueId getFrsFragmentTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.frsFragmentTag : (BdUniqueId) invokeV.objValue;
    }

    public boolean getIsBrandForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.isBrandForum : invokeV.booleanValue;
    }

    public int getMyNewThreadNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            ArrayList<uo> threadList = getThreadList();
            if (threadList == null || threadList.size() <= 0) {
                return 0;
            }
            int size = threadList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (threadList.get(i2) instanceof np4) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public int getPostThreadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.postThreadCount : invokeV.intValue;
    }

    @Override // com.repackage.kj8
    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.recm_forum_list : (List) invokeV.objValue;
    }

    public List<uo> getShowTopThreadList() {
        InterceptResult invokeV;
        List<hj8> list;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(getStarEnter())) {
                list = null;
            } else {
                list = getStarEnter();
                filterEnterList(list);
            }
            if (ListUtils.isEmpty(list)) {
                i = 0;
            } else {
                i = 0;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (list.get(i2).a() == 1) {
                        arrayList.add(list.get(i2));
                        i++;
                    }
                }
            }
            ForumData forum = getForum();
            if (forum != null && getForum().getIsShowRule() && this.forumRule != null && (getUserData().getIs_manager() == 1 || this.forumRule.has_forum_rule.intValue() == 1)) {
                arrayList.add(new oj8(forum, this.forumRule));
            }
            if (forum != null && !ni.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new nj8(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new nj8(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<uo> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    uo uoVar = (uo) ListUtils.getItem(topThreadList, i4);
                    if (uoVar instanceof rq4) {
                        rq4 rq4Var = (rq4) uoVar;
                        arrayList.add(rq4Var.s);
                        if (rq4Var.s.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (uoVar instanceof ThreadData) {
                            arrayList.add(uoVar);
                            if (((ThreadData) uoVar).getIsMemberTop() != 1 || z) {
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

    public SignData getSignData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            ForumData forumData = this.forum;
            if (forumData == null) {
                return null;
            }
            return forumData.getSignData();
        }
        return (SignData) invokeV.objValue;
    }

    public ThreadData getThreadDataById(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            ArrayList<uo> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<uo> it = arrayList.iterator();
            while (it.hasNext()) {
                uo next = it.next();
                if (next != null && (next instanceof rq4)) {
                    rq4 rq4Var = (rq4) next;
                    if (TextUtils.equals(str, rq4Var.s.getId())) {
                        return rq4Var.s;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public List<uo> getTopThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.topThreadList : (List) invokeV.objValue;
    }

    public int getTopThreadSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ArrayList<uo> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<uo> it = this.threadList.iterator();
                while (it.hasNext()) {
                    uo next = it.next();
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

    public NebulaHotThreads getYouhuaHotThreads() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.nebulaHotThreads : (NebulaHotThreads) invokeV.objValue;
    }

    public boolean hasTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? (getEntelechyTabInfo() == null || ListUtils.isEmpty(getEntelechyTabInfo().a)) ? false : true : invokeV.booleanValue;
    }

    public boolean isFirstTabEqualAllThread() {
        InterceptResult invokeV;
        List<FrsTabInfo> list;
        FrsTabInfo frsTabInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            mj8 entelechyTabInfo = getEntelechyTabInfo();
            return (entelechyTabInfo == null || (list = entelechyTabInfo.a) == null || list.size() <= 0 || (frsTabInfo = list.get(0)) == null || frsTabInfo.tab_id.intValue() != 1) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean isPrivateForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? (getForum() == null || getForum().getIsPrivateForum() == 0 || getForum().getIsPrivateForum() != 1) ? false : true : invokeV.booleanValue;
    }

    public boolean isStarForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? getStar() != null && getStar().b() == 1 : invokeV.booleanValue;
    }

    public boolean receiveData(kj8 kj8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, kj8Var)) == null) {
            if (kj8Var == null) {
                return false;
            }
            this.isFromCache = kj8Var.isFromCache;
            setSortType(kj8Var.getSortType());
            setAnti(kj8Var.getAnti());
            setChatGroup(kj8Var.getChatGroup());
            setFortuneBag(kj8Var.isFortuneBag());
            setFortuneDesc(kj8Var.getFortuneDesc());
            setForum(kj8Var.getForum());
            setGameName(kj8Var.getGameName());
            setGameUrl(kj8Var.getGameUrl());
            setGconAccount(kj8Var.getGconAccount());
            setHasGame(kj8Var.isHasGame());
            setIsNewUrl(kj8Var.getIsNewUrl());
            setPhotoLivePos(kj8Var.getPhotoLivePos());
            setPage(kj8Var.getPage());
            setStar(kj8Var.getStar());
            setStarEnter(kj8Var.getStarEnter());
            setThreadList(kj8Var.threadList);
            setThreadListIds(kj8Var.getThreadListIds());
            setUserData(kj8Var.getUserData());
            setUserMap(kj8Var.getUserMap());
            setActivityHeadData(kj8Var.getActivityHeadData());
            setFrsDefaultTabId(kj8Var.getFrsDefaultTabId());
            this.defaultShowTab = kj8Var.defaultShowTab;
            setCategoryInfos(kj8Var.getCategoryInfos());
            setBawuCenterUrl(kj8Var.getBawuCenterUrl());
            setCardVideoInfo(kj8Var.getCardVideoInfo());
            setHeadSdkData(kj8Var.getHeadSdkData());
            setSchoolRecommendPos(kj8Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(kj8Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(kj8Var.getEntelechyTabInfo());
            setAlaLiveCount(kj8Var.getAlaLiveCount());
            setCarrierEnterData(kj8Var.getCarrierEnterData());
            setForumState(kj8Var.getForumState());
            setAccessFlag(kj8Var.getAccessFlag());
            this.needLog = kj8Var.needLog;
            this.recommendBookData = kj8Var.recommendBookData;
            this.presentInfoData = kj8Var.presentInfoData;
            setBookInfo(kj8Var.getBookInfo());
            setMangaReadRecordChapterId(kj8Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(kj8Var.getHeadlineImgInfoData());
            setCardShipinPos(kj8Var.getCardShipinPos());
            setCardShipinNew(kj8Var.getCardShipinNew());
            this.enterFrsDialogInfo = kj8Var.enterFrsDialogInfo;
            setGameRankListData(kj8Var.getGameRankListData());
            setAgreeBanner(kj8Var.getAgreeBanner());
            setLiveNotify(kj8Var.getLiveNotify());
            setGameTabInfo(kj8Var.getGameTabInfo());
            setGameDefaultTabId(kj8Var.getGameDefaultTabId());
            setForumHeadIcon(kj8Var.getForumHeadIcon());
            setUserRecommend(kj8Var.getUserRecommend());
            setFrsVideoActivityData(kj8Var.getFrsVideoActivityData());
            this.mNewChapterInfo = kj8Var.mNewChapterInfo;
            setFrsInsertLiveData(kj8Var.getFrsInsertLiveData());
            this.recm_forum_list = kj8Var.getRecm_forum_list();
            setFrsStageLiveData(kj8Var.getFrsStageLiveData());
            this.forumArIno = kj8Var.forumArIno;
            this.starRank = kj8Var.starRank;
            this.postTopic = kj8Var.postTopic;
            this.mWindowToast = kj8Var.mWindowToast;
            this.activityConfig = kj8Var.activityConfig;
            setIsShowRedTip(kj8Var.isShowRedTip());
            this.isBrandForum = kj8Var.isBrandForum;
            this.brandAdData = kj8Var.brandAdData;
            this.oriForumInfoList = kj8Var.oriForumInfoList;
            this.bottomMenuList = kj8Var.bottomMenuList;
            this.adMixFloor = kj8Var.adMixFloor;
            this.adShowSelect = kj8Var.adShowSelect;
            this.adSampleMapKey = kj8Var.adSampleMapKey;
            zc6.f().n(getAnti());
            zc6.f().q(kj8Var.getForum().getId());
            zc6.f().r(kj8Var.getForum().getName());
            yc6.h().q(kj8Var.getForum().getId());
            if (kj8Var.getEntelechyTabInfo() != null) {
                yc6.h().r(kj8Var.getEntelechyTabInfo().a);
            }
            if (kj8Var.getUserData() != null) {
                ad6.c().e(kj8Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(kj8Var.getPrivateForumTotalInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = kj8Var.smartAppAvatar;
            this.smartApp = kj8Var.smartApp;
            this.nebulaHotThreads = kj8Var.nebulaHotThreads;
            this.forumActiveInfo = kj8Var.forumActiveInfo;
            this.userList = kj8Var.userList;
            setBusinessPromot(kj8Var.getBusinessPromot());
            this.serviceAreaData = kj8Var.serviceAreaData;
            setHotUserRankData(kj8Var.getHotUserRankData());
            this.itemInfo = kj8Var.itemInfo;
            this.toLoadHorseData = kj8Var.toLoadHorseData;
            this.forumRule = kj8Var.forumRule;
            this.mSignActivityInfo = kj8Var.mSignActivityInfo;
            this.showAdsense = kj8Var.showAdsense;
            setVoiceRoomConfig(kj8Var.getVoiceRoomConfig());
            setVoiceRoomData(kj8Var.getVoiceRoomData());
            this.serviceAreaFlutterData = kj8Var.serviceAreaFlutterData;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void removeAlaInsertLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            removeTopSameClassDataFromList(dj8.class, getThreadList());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<uo> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (arrayList = this.threadList) == null || arrayList.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.threadList.size(); i++) {
            if (this.threadList.get(i).getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE || this.threadList.get(i).getType() == ThreadData.TYPE_ALA_LIVE_EMPTY || this.threadList.get(i).getType() == ThreadData.TYPE_ALA_SHARE_THREAD) {
                this.threadList.remove(i);
            }
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            removeTopSameClassDataFromList(ej8.class, getThreadList());
        }
    }

    public void removeGameRankListFromThreadList() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<uo> it = this.threadList.iterator();
        while (it.hasNext()) {
            uo next = it.next();
            if (next != null && next.getType() == rs6.e) {
                it.remove();
            }
        }
    }

    public void removeRedundantUserRecommendData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        boolean z = false;
        Iterator<uo> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof ud6) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void removeThread(String str) {
        ArrayList<uo> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, str) == null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<uo> it = arrayList.iterator();
        while (it.hasNext()) {
            uo next = it.next();
            if (next != null && (next instanceof rq4) && TextUtils.equals(str, ((rq4) next).s.getId())) {
                it.remove();
            }
        }
    }

    public void removeThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, threadData) == null) {
            this.threadList.remove(threadData);
        }
    }

    public void setFrsFragmentTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bdUniqueId) == null) {
            this.frsFragmentTag = bdUniqueId;
        }
    }

    public void setFunAdController(js6 js6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, js6Var) == null) {
            this.funAdController = js6Var;
        }
    }

    public void setTopThreadList(List<uo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, list) == null) {
            this.topThreadList = list;
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, userPendantData) == null) || this.threadList == null || userPendantData == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        Iterator<uo> it = this.threadList.iterator();
        while (it.hasNext()) {
            uo next = it.next();
            if (next != null && (next instanceof rq4)) {
                rq4 rq4Var = (rq4) next;
                if (rq4Var.s.getAuthor() != null && currentAccount.equals(rq4Var.s.getAuthor().getUserId()) && rq4Var.s.getAuthor().getPendantData() != null) {
                    rq4Var.s.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                    rq4Var.s.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                }
            }
        }
    }

    public void updateLikeData(aj8 aj8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, aj8Var) == null) || aj8Var == null) {
            return;
        }
        vj8 vj8Var = new vj8();
        vj8Var.y(1);
        vj8Var.z(aj8Var.a);
        vj8Var.w(aj8Var.b);
        vj8Var.u(aj8Var.c);
        vj8Var.x(aj8Var.d);
        updateLikeData(vj8Var);
    }

    public void updateLoadMoreBannerListData(BannerListData bannerListData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, bannerListData) == null) {
            this.isLoadMore = true;
            this.loadMoreBannerListData = bannerListData;
        }
    }

    public void updateSignData(SignData signData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, signData) == null) || signData == null) {
            return;
        }
        this.forum.setSignData(signData);
    }

    public void addRecommendAppToThreadList(gh5 gh5Var, ArrayList<uo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, gh5Var, arrayList) == null) {
            addRecommendAppToThreadList(gh5Var, false, arrayList, null, false);
        }
    }

    public void addRecommendAppToThreadList(gh5 gh5Var, boolean z, ArrayList<uo> arrayList, ArrayList<uo> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{gh5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
            if (bannerListData == null || bannerListData.getAllAdvertList() == null || arrayList == null || arrayList.size() <= 0) {
                return;
            }
            oh5 oh5Var = new oh5(gh5Var, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.setFromFrs(true);
                next.setSortType(getSortType());
                arrayList3.add(next);
            }
            oh5Var.r(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, oh5Var));
            oh5 oh5Var2 = new oh5(gh5Var, 3);
            oh5Var2.x(z);
            oh5Var2.E(arrayList);
            oh5Var2.B(arrayList2);
            oh5Var2.w(z2);
            oh5Var2.s(getPage().a());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, oh5Var2));
        }
    }

    public void updateLikeData(vj8 vj8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, vj8Var) == null) || vj8Var == null) {
            return;
        }
        this.forum.setCurScore(vj8Var.c());
        this.forum.setLevelupScore(vj8Var.i());
        this.forum.setLike(vj8Var.n());
        this.forum.setUser_level(vj8Var.m());
        this.forum.setLevelName(vj8Var.h());
    }
}
