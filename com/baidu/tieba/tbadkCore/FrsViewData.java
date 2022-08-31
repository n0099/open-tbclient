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
import com.baidu.tieba.ak8;
import com.baidu.tieba.bk8;
import com.baidu.tieba.ck8;
import com.baidu.tieba.eq4;
import com.baidu.tieba.et6;
import com.baidu.tieba.hk8;
import com.baidu.tieba.hq4;
import com.baidu.tieba.jk8;
import com.baidu.tieba.jr4;
import com.baidu.tieba.mf6;
import com.baidu.tieba.mj8;
import com.baidu.tieba.mk5;
import com.baidu.tieba.ot6;
import com.baidu.tieba.pg;
import com.baidu.tieba.pj8;
import com.baidu.tieba.pn;
import com.baidu.tieba.qe6;
import com.baidu.tieba.qi;
import com.baidu.tieba.qj8;
import com.baidu.tieba.qk8;
import com.baidu.tieba.r85;
import com.baidu.tieba.re6;
import com.baidu.tieba.se6;
import com.baidu.tieba.su4;
import com.baidu.tieba.te6;
import com.baidu.tieba.tj8;
import com.baidu.tieba.uj8;
import com.baidu.tieba.uk5;
import com.baidu.tieba.uq4;
import com.baidu.tieba.wj8;
import com.baidu.tieba.x06;
import com.baidu.tieba.yj8;
import com.baidu.tieba.zj8;
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
/* loaded from: classes5.dex */
public class FrsViewData extends wj8 implements r85, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public et6 funAdController;
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

    private List<pn> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        hq4 hq4Var;
        ArrayList<pn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<pn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (hq4Var = this.page) != null && hq4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    pn pnVar = this.threadList.get(i);
                    if (pnVar instanceof jr4) {
                        if (((jr4) pnVar).t.isHeadLinePost) {
                            arrayList2.add(pnVar);
                        }
                    } else if ((pnVar instanceof ThreadData) && ((ThreadData) pnVar).isHeadLinePost) {
                        arrayList2.add(pnVar);
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
            Iterator<pn> it = this.threadList.iterator();
            while (it.hasNext()) {
                pn next = it.next();
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<pn> arrayList) {
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
            pn pnVar = arrayList.get(i);
            if (pnVar.getClass() == cls) {
                arrayList2.add(pnVar);
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
        ArrayList<pn> threadList = getThreadList();
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
            pn pnVar = this.threadList.get(i2);
            if (pnVar instanceof jr4) {
                ThreadData threadData = ((jr4) pnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (feedForumList = this.forum.getBannerListData().getFeedForumList()) == null || feedForumList.size() <= 0) {
            return;
        }
        uj8 uj8Var = new uj8();
        uj8Var.f(this.forum.getId());
        uj8Var.c(feedForumList);
        this.threadList.add(i + 6, uj8Var);
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
            pn pnVar = this.threadList.get(i2);
            if (pnVar instanceof jr4) {
                ThreadData threadData = ((jr4) pnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String q = su4.k().q("game_rank_list_info", "");
        if (!StringUtils.isNull(q) && q.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(pg.g(q.split(",")[0], 0L), System.currentTimeMillis()) < pg.e(q.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int l = su4.k().l("game_rank_list_show_times", 0);
                    if (!z) {
                        l++;
                    }
                    su4.k().w("game_rank_list_show_times", l);
                    if (l > 3) {
                        su4 k = su4.k();
                        k.y("game_rank_list_info", System.currentTimeMillis() + ",1");
                        su4.k().w("game_rank_list_show_times", 0);
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
        x06 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    pn pnVar = this.threadList.get(i2);
                    if (pnVar instanceof jr4) {
                        ThreadData threadData = ((jr4) pnVar).t;
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
        pj8 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsInsertLiveData = getFrsInsertLiveData()) == null) {
            return;
        }
        ArrayList<pn> threadList = getThreadList();
        removeTopSameClassDataFromList(pj8.class, threadList);
        threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.b, threadList.size()), frsInsertLiveData);
    }

    public void addMyNewThread(eq4 eq4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, eq4Var) == null) || eq4Var == null || StringUtils.isNull(eq4Var.getId()) || this.threadList == null) {
            return;
        }
        int topThreadSize = getTopThreadSize();
        ArrayList<pn> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            for (int i = 0; i < size; i++) {
                pn pnVar = threadList.get(i);
                if ((pnVar instanceof jr4) && eq4Var.getId().equals(((jr4) pnVar).t.getId()) && eq4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                    return;
                }
            }
        }
        eq4Var.isFromBrandForum = this.isBrandForum;
        this.postThreadCount++;
        this.threadList.add(topThreadSize, eq4Var);
    }

    public void addNoticeThreadToThreadList() {
        TopNoticeData top_notice_data;
        pn pnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getForum() == null || this.threadList == null || (top_notice_data = getForum().getTop_notice_data()) == null || top_notice_data.getTitle() == null) {
            return;
        }
        while (!this.threadList.isEmpty() && (pnVar = this.threadList.get(0)) != null && (pnVar instanceof jr4) && ((ThreadData) pnVar).getIs_top() == 2) {
            this.threadList.remove(0);
        }
        ThreadData threadData = new ThreadData();
        threadData.setTitle(top_notice_data.getTitle());
        threadData.setTid(top_notice_data.getTitle_link());
        threadData.setIs_top(2);
        threadData.parser_title();
        jr4 jr4Var = new jr4();
        jr4Var.t = threadData;
        this.threadList.add(0, jr4Var);
    }

    public void addOfficialBarToThreadList() {
        hq4 hq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.forum == null || this.threadList == null || !ThreadData.isFRSExtraLoaded.get() || (hq4Var = this.page) == null) {
            return;
        }
        boolean z = true;
        if (hq4Var.a() == 1) {
            ck8 ck8Var = this.gconAccount;
            z = (ck8Var == null || !ck8Var.b()) ? false : false;
            if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof jk8)) {
                    this.threadList.remove(0);
                }
                jk8 jk8Var = new jk8();
                jk8Var.j(this.fortuneBag);
                jk8Var.l(this.fortuneDesc);
                jk8Var.n(this.gconAccount);
                jk8Var.setIs_top(1003);
                ArrayList<pn> arrayList = this.threadList;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                ListUtils.add(this.threadList, getTopThreadSize(), jk8Var);
            }
        }
    }

    public void addRecommendAppToThreadList(mk5 mk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mk5Var) == null) {
            addRecommendAppToThreadList(mk5Var, false, this.threadList, null, false);
        }
    }

    public void addRecommendBarsToThreadList() {
        ArrayList<pn> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.forum == null || (arrayList = this.threadList) == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<pn> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof uq4) {
                it.remove();
            }
        }
        hq4 hq4Var = this.page;
        if (hq4Var == null || hq4Var.a() != 1) {
            return;
        }
        ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
        uq4 uq4Var = new uq4();
        if (recommendForumData != null) {
            uq4Var.c().addAll(recommendForumData);
        }
        if (isShowRecommendBars(uq4Var.c())) {
            int i = 0;
            Iterator<pn> it2 = this.threadList.iterator();
            while (it2.hasNext()) {
                pn next = it2.next();
                if ((next instanceof jr4) && ((jr4) next).t.isTop()) {
                    i++;
                }
            }
            this.threadList.add(i + 1, uq4Var);
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
        qj8 frsStageLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsStageLiveData = getFrsStageLiveData()) == null) {
            return;
        }
        ArrayList<pn> threadList = getThreadList();
        removeTopSameClassDataFromList(qj8.class, threadList);
        if (ListUtils.isEmpty(frsStageLiveData.a)) {
            return;
        }
        threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
    }

    public void addU9DataToThreadList() {
        ForumData forumData;
        hq4 hq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (forumData = this.forum) == null) {
            return;
        }
        if (((forumData.getTopCode() == null || StringUtils.isNull(this.forum.getTopCode().g())) && (this.forum.getNewsInfo() == null || StringUtils.isNull(this.forum.getNewsInfo().j1()))) || (hq4Var = this.page) == null || hq4Var.a() != 1) {
            return;
        }
        qk8 qk8Var = new qk8();
        qk8Var.l(this.forum.getTopCode());
        qk8Var.n(this.forum.getNewsInfo());
        qk8Var.setIs_top(3);
        qk8Var.j(true);
        if (ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<pn> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            pn next = it.next();
            if (next instanceof ThreadData) {
                ThreadData threadData = (ThreadData) next;
                if (threadData.getIs_top() != 0) {
                    if (threadData.getIs_top() == 1003) {
                        qk8Var.j(false);
                    }
                    i++;
                }
            }
        }
        this.threadList.add(i, qk8Var);
    }

    public void addUserRecommendToThreadList() {
        int a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || getUserRecommend() == null) {
            return;
        }
        mf6 userRecommend = getUserRecommend();
        if (ListUtils.getCount(userRecommend.c()) >= 3 && (a = userRecommend.a()) > 0) {
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
        Iterator<pn> it = this.threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            pn next = it.next();
            if (next != null && next.getType() == bk8.c) {
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
        List<pn> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<pn> threadList = getThreadList();
        if (cardShipinPos == null || cardShipinPos.size() <= 0 || cardShipinNew == null || cardShipinNew.size() <= 0 || threadList == null) {
            return;
        }
        int size = cardShipinPos.size();
        int size2 = threadList.size();
        for (int i = 0; i < size; i++) {
            if (i < cardShipinNew.size()) {
                pn pnVar = cardShipinNew.get(i);
                int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + pnVar.getType());
                threadList.add(videoThreadInserPos, pnVar);
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<pn> arrayList;
        hq4 hq4Var;
        ArrayList<pn> arrayList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (arrayList = this.threadList) == null || arrayList.size() <= 0 || (hq4Var = this.page) == null || hq4Var.a() != 1 || (arrayList2 = this.threadList) == null || arrayList2.size() <= 0) {
            return;
        }
        int i = -1;
        int size = this.threadList.size();
        for (int i2 = 0; i2 < size; i2++) {
            pn pnVar = this.threadList.get(i2);
            if (pnVar instanceof jr4) {
                jr4 jr4Var = (jr4) pnVar;
                if (jr4Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && jr4Var.t.getThreadAlaInfo() != null && ((ThreadData) pnVar).getThreadAlaInfo().user_info != null && jr4Var.t.getThreadAlaInfo().user_info.is_official == 2 && jr4Var.t.getThreadAlaInfo().liveStageForceTop) {
                    i = i2;
                    break;
                }
            } else {
                if (pnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) pnVar;
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
                pn pnVar2 = this.threadList.get(i3);
                if (pnVar2 instanceof jr4) {
                    if (((jr4) pnVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        i = i3;
                        break;
                    }
                } else {
                    if ((pnVar2 instanceof ThreadData) && ((ThreadData) pnVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
        List<pn> headLineDataInThreadList = getHeadLineDataInThreadList();
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

    public void filterEnterList(List<tj8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        Iterator<tj8> it = list.iterator();
        while (it.hasNext()) {
            tj8 next = it.next();
            if (next == null) {
                it.remove();
            } else if (StringUtils.isNull(next.h()) || StringUtils.isNull(next.f())) {
                if (next.a() != 1) {
                    it.remove();
                }
            }
        }
    }

    public te6 getBrandAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.brandAdData : (te6) invokeV.objValue;
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
            ArrayList<pn> threadList = getThreadList();
            if (threadList == null || threadList.size() <= 0) {
                return 0;
            }
            int size = threadList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (threadList.get(i2) instanceof eq4) {
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

    @Override // com.baidu.tieba.wj8
    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.recm_forum_list : (List) invokeV.objValue;
    }

    public List<pn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<tj8> list;
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
                arrayList.add(new ak8(forum, this.forumRule));
            }
            if (forum != null && !qi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new zj8(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new zj8(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<pn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    pn pnVar = (pn) ListUtils.getItem(topThreadList, i4);
                    if (pnVar instanceof jr4) {
                        jr4 jr4Var = (jr4) pnVar;
                        arrayList.add(jr4Var.t);
                        if (jr4Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (pnVar instanceof ThreadData) {
                            arrayList.add(pnVar);
                            if (((ThreadData) pnVar).getIsMemberTop() != 1 || z) {
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
            ArrayList<pn> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<pn> it = arrayList.iterator();
            while (it.hasNext()) {
                pn next = it.next();
                if (next != null && (next instanceof jr4)) {
                    jr4 jr4Var = (jr4) next;
                    if (TextUtils.equals(str, jr4Var.t.getId())) {
                        return jr4Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public List<pn> getTopThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.topThreadList : (List) invokeV.objValue;
    }

    public int getTopThreadSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ArrayList<pn> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<pn> it = this.threadList.iterator();
                while (it.hasNext()) {
                    pn next = it.next();
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
            yj8 entelechyTabInfo = getEntelechyTabInfo();
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

    public boolean receiveData(wj8 wj8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, wj8Var)) == null) {
            if (wj8Var == null) {
                return false;
            }
            this.isFromCache = wj8Var.isFromCache;
            setBaWuNoticeNum(wj8Var.getBaWuNoticeNum());
            setSortType(wj8Var.getSortType());
            setAnti(wj8Var.getAnti());
            setChatGroup(wj8Var.getChatGroup());
            setFortuneBag(wj8Var.isFortuneBag());
            setFortuneDesc(wj8Var.getFortuneDesc());
            setForum(wj8Var.getForum());
            setGameName(wj8Var.getGameName());
            setGameUrl(wj8Var.getGameUrl());
            setGconAccount(wj8Var.getGconAccount());
            setHasGame(wj8Var.isHasGame());
            setIsNewUrl(wj8Var.getIsNewUrl());
            setPhotoLivePos(wj8Var.getPhotoLivePos());
            setPage(wj8Var.getPage());
            setStar(wj8Var.getStar());
            setStarEnter(wj8Var.getStarEnter());
            setThreadList(wj8Var.threadList);
            setThreadListIds(wj8Var.getThreadListIds());
            setUserData(wj8Var.getUserData());
            setUserMap(wj8Var.getUserMap());
            setActivityHeadData(wj8Var.getActivityHeadData());
            setFrsDefaultTabId(wj8Var.getFrsDefaultTabId());
            this.defaultShowTab = wj8Var.defaultShowTab;
            setCategoryInfos(wj8Var.getCategoryInfos());
            setBawuCenterUrl(wj8Var.getBawuCenterUrl());
            setCardVideoInfo(wj8Var.getCardVideoInfo());
            setHeadSdkData(wj8Var.getHeadSdkData());
            setSchoolRecommendPos(wj8Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(wj8Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(wj8Var.getEntelechyTabInfo());
            setAlaLiveCount(wj8Var.getAlaLiveCount());
            setCarrierEnterData(wj8Var.getCarrierEnterData());
            setForumState(wj8Var.getForumState());
            setAccessFlag(wj8Var.getAccessFlag());
            this.needLog = wj8Var.needLog;
            this.recommendBookData = wj8Var.recommendBookData;
            this.presentInfoData = wj8Var.presentInfoData;
            setBookInfo(wj8Var.getBookInfo());
            setMangaReadRecordChapterId(wj8Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(wj8Var.getHeadlineImgInfoData());
            setCardShipinPos(wj8Var.getCardShipinPos());
            setCardShipinNew(wj8Var.getCardShipinNew());
            this.enterFrsDialogInfo = wj8Var.enterFrsDialogInfo;
            setGameRankListData(wj8Var.getGameRankListData());
            setAgreeBanner(wj8Var.getAgreeBanner());
            setLiveNotify(wj8Var.getLiveNotify());
            setGameTabInfo(wj8Var.getGameTabInfo());
            setGameDefaultTabId(wj8Var.getGameDefaultTabId());
            setForumHeadIcon(wj8Var.getForumHeadIcon());
            setUserRecommend(wj8Var.getUserRecommend());
            setFrsVideoActivityData(wj8Var.getFrsVideoActivityData());
            this.mNewChapterInfo = wj8Var.mNewChapterInfo;
            setFrsInsertLiveData(wj8Var.getFrsInsertLiveData());
            this.recm_forum_list = wj8Var.getRecm_forum_list();
            setFrsStageLiveData(wj8Var.getFrsStageLiveData());
            this.forumArIno = wj8Var.forumArIno;
            this.starRank = wj8Var.starRank;
            this.postTopic = wj8Var.postTopic;
            this.mWindowToast = wj8Var.mWindowToast;
            this.activityConfig = wj8Var.activityConfig;
            setIsShowRedTip(wj8Var.isShowRedTip());
            this.isBrandForum = wj8Var.isBrandForum;
            this.brandAdData = wj8Var.brandAdData;
            this.oriForumInfoList = wj8Var.oriForumInfoList;
            this.bottomMenuList = wj8Var.bottomMenuList;
            this.adMixFloor = wj8Var.adMixFloor;
            this.adShowSelect = wj8Var.adShowSelect;
            this.adSampleMapKey = wj8Var.adSampleMapKey;
            re6.f().n(getAnti());
            re6.f().q(wj8Var.getForum().getId());
            re6.f().r(wj8Var.getForum().getName());
            qe6.h().q(wj8Var.getForum().getId());
            if (wj8Var.getEntelechyTabInfo() != null) {
                qe6.h().r(wj8Var.getEntelechyTabInfo().a);
            }
            if (wj8Var.getUserData() != null) {
                se6.c().e(wj8Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(wj8Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(wj8Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = wj8Var.smartAppAvatar;
            this.smartApp = wj8Var.smartApp;
            this.nebulaHotThreads = wj8Var.nebulaHotThreads;
            this.forumActiveInfo = wj8Var.forumActiveInfo;
            this.userList = wj8Var.userList;
            setBusinessPromot(wj8Var.getBusinessPromot());
            this.serviceAreaData = wj8Var.serviceAreaData;
            setHotUserRankData(wj8Var.getHotUserRankData());
            this.itemInfo = wj8Var.itemInfo;
            this.toLoadHorseData = wj8Var.toLoadHorseData;
            this.forumRule = wj8Var.forumRule;
            this.mSignActivityInfo = wj8Var.mSignActivityInfo;
            this.showAdsense = wj8Var.showAdsense;
            setVoiceRoomConfig(wj8Var.getVoiceRoomConfig());
            setVoiceRoomData(wj8Var.getVoiceRoomData());
            this.serviceAreaFlutterData = wj8Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = wj8Var.liveFuseForumDataList;
            this.forumTagInfo = wj8Var.forumTagInfo;
            this.firstCategory = wj8Var.firstCategory;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void removeAlaInsertLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            removeTopSameClassDataFromList(pj8.class, getThreadList());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<pn> arrayList;
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
            removeTopSameClassDataFromList(qj8.class, getThreadList());
        }
    }

    public void removeGameRankListFromThreadList() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<pn> it = this.threadList.iterator();
        while (it.hasNext()) {
            pn next = it.next();
            if (next != null && next.getType() == ot6.e) {
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
        Iterator<pn> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof mf6) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void removeThread(String str) {
        ArrayList<pn> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, str) == null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<pn> it = arrayList.iterator();
        while (it.hasNext()) {
            pn next = it.next();
            if (next != null && (next instanceof jr4) && TextUtils.equals(str, ((jr4) next).t.getId())) {
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

    public void setFunAdController(et6 et6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, et6Var) == null) {
            this.funAdController = et6Var;
        }
    }

    public void setTopThreadList(List<pn> list) {
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
        Iterator<pn> it = this.threadList.iterator();
        while (it.hasNext()) {
            pn next = it.next();
            if (next != null && (next instanceof jr4)) {
                jr4 jr4Var = (jr4) next;
                if (jr4Var.t.getAuthor() != null && currentAccount.equals(jr4Var.t.getAuthor().getUserId()) && jr4Var.t.getAuthor().getPendantData() != null) {
                    jr4Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                    jr4Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                }
            }
        }
    }

    public void updateLikeData(mj8 mj8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, mj8Var) == null) || mj8Var == null) {
            return;
        }
        hk8 hk8Var = new hk8();
        hk8Var.x(1);
        hk8Var.y(mj8Var.a);
        hk8Var.v(mj8Var.b);
        hk8Var.t(mj8Var.c);
        hk8Var.w(mj8Var.d);
        updateLikeData(hk8Var);
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

    public void addRecommendAppToThreadList(mk5 mk5Var, ArrayList<pn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, mk5Var, arrayList) == null) {
            addRecommendAppToThreadList(mk5Var, false, arrayList, null, false);
        }
    }

    public void addRecommendAppToThreadList(mk5 mk5Var, boolean z, ArrayList<pn> arrayList, ArrayList<pn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{mk5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
            uk5 uk5Var = new uk5(mk5Var, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.setFromFrs(true);
                next.setSortType(getSortType());
                arrayList3.add(next);
            }
            uk5Var.s(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, uk5Var));
            uk5 uk5Var2 = new uk5(mk5Var, 3);
            uk5Var2.z(z);
            uk5Var2.G(arrayList);
            uk5Var2.D(arrayList2);
            uk5Var2.y(z2);
            uk5Var2.t(getPage().a());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, uk5Var2));
        }
    }

    public void updateLikeData(hk8 hk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, hk8Var) == null) || hk8Var == null) {
            return;
        }
        this.forum.setCurScore(hk8Var.c());
        this.forum.setLevelupScore(hk8Var.i());
        this.forum.setLike(hk8Var.m());
        this.forum.setUser_level(hk8Var.l());
        this.forum.setLevelName(hk8Var.h());
    }
}
