package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.o0.k0.b.a;
import c.a.o0.r.j0.b;
import c.a.o0.r.r.a2;
import c.a.o0.r.r.m1;
import c.a.o0.r.r.w0;
import c.a.o0.r.r.z0;
import c.a.p0.a4.a0;
import c.a.p0.a4.g;
import c.a.p0.a4.h;
import c.a.p0.a4.h0;
import c.a.p0.a4.k;
import c.a.p0.a4.l;
import c.a.p0.a4.n;
import c.a.p0.a4.p;
import c.a.p0.a4.q;
import c.a.p0.a4.r;
import c.a.p0.a4.s;
import c.a.p0.a4.t;
import c.a.p0.a4.y;
import c.a.p0.f1.c;
import c.a.p0.f1.d;
import c.a.p0.f1.w;
import c.a.p0.h0.e0.o;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.AnchorPower;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.FrsPage.NebulaHotThreads;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.SmartApp;
import tbclient.User;
/* loaded from: classes6.dex */
public class FrsViewData extends n implements a, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public c.a.p0.h1.a funAdController;
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

    private List<c.a.d.o.e.n> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        z0 z0Var;
        ArrayList<c.a.d.o.e.n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<c.a.d.o.e.n> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (z0Var = this.page) != null && z0Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    c.a.d.o.e.n nVar = this.threadList.get(i);
                    if (nVar instanceof a2) {
                        if (((a2) nVar).s.isHeadLinePost) {
                            arrayList2.add(nVar);
                        }
                    } else if ((nVar instanceof ThreadData) && ((ThreadData) nVar).isHeadLinePost) {
                        arrayList2.add(nVar);
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
            Iterator<c.a.d.o.e.n> it = this.threadList.iterator();
            while (it.hasNext()) {
                c.a.d.o.e.n next = it.next();
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<c.a.d.o.e.n> arrayList) {
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
            c.a.d.o.e.n nVar = arrayList.get(i);
            if (nVar.getClass() == cls) {
                arrayList2.add(nVar);
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
        ArrayList<c.a.d.o.e.n> threadList = getThreadList();
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
            c.a.d.o.e.n nVar = this.threadList.get(i2);
            if (nVar instanceof a2) {
                ThreadData threadData = ((a2) nVar).s;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (feedForumList = this.forum.getBannerListData().getFeedForumList()) == null || feedForumList.size() <= 0) {
            return;
        }
        l lVar = new l();
        lVar.f(this.forum.getId());
        lVar.e(feedForumList);
        this.threadList.add(i + 6, lVar);
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
            c.a.d.o.e.n nVar = this.threadList.get(i2);
            if (nVar instanceof a2) {
                ThreadData threadData = ((a2) nVar).s;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String q = b.k().q("game_rank_list_info", "");
        if (!StringUtils.isNull(q) && q.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(c.a.d.f.m.b.g(q.split(",")[0], 0L), System.currentTimeMillis()) < c.a.d.f.m.b.e(q.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int l = b.k().l("game_rank_list_show_times", 0);
                    if (!z) {
                        l++;
                    }
                    b.k().w("game_rank_list_show_times", l);
                    if (l > 3) {
                        b k = b.k();
                        k.y("game_rank_list_info", System.currentTimeMillis() + ",1");
                        b.k().w("game_rank_list_show_times", 0);
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
        o recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    c.a.d.o.e.n nVar = this.threadList.get(i2);
                    if (nVar instanceof a2) {
                        ThreadData threadData = ((a2) nVar).s;
                        if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if (this.threadList.size() - i > 7 && (recomTopicData = this.forum.getBannerListData().getRecomTopicData()) != null && ListUtils.getCount(recomTopicData.f15342d) >= 4) {
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
        g frsInsertLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsInsertLiveData = getFrsInsertLiveData()) == null) {
            return;
        }
        ArrayList<c.a.d.o.e.n> threadList = getThreadList();
        removeTopSameClassDataFromList(g.class, threadList);
        threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.f12196b, threadList.size()), frsInsertLiveData);
    }

    public void addMyNewThread(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, w0Var) == null) || w0Var == null || StringUtils.isNull(w0Var.getId()) || this.threadList == null) {
            return;
        }
        int topThreadSize = getTopThreadSize();
        ArrayList<c.a.d.o.e.n> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            for (int i = 0; i < size; i++) {
                c.a.d.o.e.n nVar = threadList.get(i);
                if ((nVar instanceof a2) && w0Var.getId().equals(((a2) nVar).s.getId()) && w0Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                    return;
                }
            }
        }
        w0Var.isFromBrandForum = this.isBrandForum;
        this.postThreadCount++;
        this.threadList.add(topThreadSize, w0Var);
    }

    public void addNoticeThreadToThreadList() {
        TopNoticeData top_notice_data;
        c.a.d.o.e.n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getForum() == null || this.threadList == null || (top_notice_data = getForum().getTop_notice_data()) == null || top_notice_data.getTitle() == null) {
            return;
        }
        while (!this.threadList.isEmpty() && (nVar = this.threadList.get(0)) != null && (nVar instanceof a2) && ((ThreadData) nVar).getIs_top() == 2) {
            this.threadList.remove(0);
        }
        ThreadData threadData = new ThreadData();
        threadData.setTitle(top_notice_data.getTitle());
        threadData.setTid(top_notice_data.getTitle_link());
        threadData.setIs_top(2);
        threadData.parser_title();
        a2 a2Var = new a2();
        a2Var.s = threadData;
        this.threadList.add(0, a2Var);
    }

    public void addOfficialBarToThreadList() {
        z0 z0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.forum == null || this.threadList == null || !ThreadData.isFRSExtraLoaded.get() || (z0Var = this.page) == null) {
            return;
        }
        boolean z = true;
        if (z0Var.a() == 1) {
            t tVar = this.gconAccount;
            z = (tVar == null || !tVar.b()) ? false : false;
            if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof a0)) {
                    this.threadList.remove(0);
                }
                a0 a0Var = new a0();
                a0Var.k(this.fortuneBag);
                a0Var.m(this.fortuneDesc);
                a0Var.q(this.gconAccount);
                a0Var.setIs_top(1003);
                ArrayList<c.a.d.o.e.n> arrayList = this.threadList;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                ListUtils.add(this.threadList, getTopThreadSize(), a0Var);
            }
        }
    }

    public void addRecommendAppToThreadList(c.a.p0.h.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            addRecommendAppToThreadList(bVar, false, this.threadList, null, false);
        }
    }

    public void addRecommendBarsToThreadList() {
        ArrayList<c.a.d.o.e.n> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.forum == null || (arrayList = this.threadList) == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<c.a.d.o.e.n> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof m1) {
                it.remove();
            }
        }
        z0 z0Var = this.page;
        if (z0Var == null || z0Var.a() != 1) {
            return;
        }
        ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
        m1 m1Var = new m1();
        if (recommendForumData != null) {
            m1Var.e().addAll(recommendForumData);
        }
        if (isShowRecommendBars(m1Var.e())) {
            int i = 0;
            Iterator<c.a.d.o.e.n> it2 = this.threadList.iterator();
            while (it2.hasNext()) {
                c.a.d.o.e.n next = it2.next();
                if ((next instanceof a2) && ((a2) next).s.isTop()) {
                    i++;
                }
            }
            this.threadList.add(i + 1, m1Var);
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
        h frsStageLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsStageLiveData = getFrsStageLiveData()) == null) {
            return;
        }
        ArrayList<c.a.d.o.e.n> threadList = getThreadList();
        removeTopSameClassDataFromList(h.class, threadList);
        if (ListUtils.isEmpty(frsStageLiveData.a)) {
            return;
        }
        threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
    }

    public void addU9DataToThreadList() {
        ForumData forumData;
        z0 z0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (forumData = this.forum) == null) {
            return;
        }
        if (((forumData.getTopCode() == null || StringUtils.isNull(this.forum.getTopCode().g())) && (this.forum.getNewsInfo() == null || StringUtils.isNull(this.forum.getNewsInfo().K0()))) || (z0Var = this.page) == null || z0Var.a() != 1) {
            return;
        }
        h0 h0Var = new h0();
        h0Var.m(this.forum.getTopCode());
        h0Var.q(this.forum.getNewsInfo());
        h0Var.setIs_top(3);
        h0Var.k(true);
        if (ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<c.a.d.o.e.n> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            c.a.d.o.e.n next = it.next();
            if (next instanceof ThreadData) {
                ThreadData threadData = (ThreadData) next;
                if (threadData.getIs_top() != 0) {
                    if (threadData.getIs_top() == 1003) {
                        h0Var.k(false);
                    }
                    i++;
                }
            }
        }
        this.threadList.add(i, h0Var);
    }

    public void addUserRecommendToThreadList() {
        int a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || getUserRecommend() == null) {
            return;
        }
        w userRecommend = getUserRecommend();
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
        Iterator<c.a.d.o.e.n> it = this.threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.d.o.e.n next = it.next();
            if (next != null && next.getType() == s.f12379c) {
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
        List<c.a.d.o.e.n> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<c.a.d.o.e.n> threadList = getThreadList();
        if (cardShipinPos == null || cardShipinPos.size() <= 0 || cardShipinNew == null || cardShipinNew.size() <= 0 || threadList == null) {
            return;
        }
        int size = cardShipinPos.size();
        int size2 = threadList.size();
        for (int i = 0; i < size; i++) {
            if (i < cardShipinNew.size()) {
                c.a.d.o.e.n nVar = cardShipinNew.get(i);
                int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + nVar.getType());
                threadList.add(videoThreadInserPos, nVar);
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<c.a.d.o.e.n> arrayList;
        z0 z0Var;
        ArrayList<c.a.d.o.e.n> arrayList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (arrayList = this.threadList) == null || arrayList.size() <= 0 || (z0Var = this.page) == null || z0Var.a() != 1 || (arrayList2 = this.threadList) == null || arrayList2.size() <= 0) {
            return;
        }
        int i = -1;
        int size = this.threadList.size();
        for (int i2 = 0; i2 < size; i2++) {
            c.a.d.o.e.n nVar = this.threadList.get(i2);
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.s.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && a2Var.s.getThreadAlaInfo() != null && ((ThreadData) nVar).getThreadAlaInfo().user_info != null && a2Var.s.getThreadAlaInfo().user_info.is_official == 2 && a2Var.s.getThreadAlaInfo().liveStageForceTop) {
                    i = i2;
                    break;
                }
            } else {
                if (nVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) nVar;
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
                c.a.d.o.e.n nVar2 = this.threadList.get(i3);
                if (nVar2 instanceof a2) {
                    if (((a2) nVar2).s.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        i = i3;
                        break;
                    }
                } else {
                    if ((nVar2 instanceof ThreadData) && ((ThreadData) nVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
        List<c.a.d.o.e.n> headLineDataInThreadList = getHeadLineDataInThreadList();
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

    public void filterEnterList(List<k> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        Iterator<k> it = list.iterator();
        while (it.hasNext()) {
            k next = it.next();
            if (next == null) {
                it.remove();
            } else if (StringUtils.isNull(next.i()) || StringUtils.isNull(next.f())) {
                if (next.a() != 1) {
                    it.remove();
                }
            }
        }
    }

    public d getBrandAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.brandAdData : (d) invokeV.objValue;
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
            ArrayList<c.a.d.o.e.n> threadList = getThreadList();
            if (threadList == null || threadList.size() <= 0) {
                return 0;
            }
            int size = threadList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (threadList.get(i2) instanceof w0) {
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

    @Override // c.a.p0.a4.n
    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.recm_forum_list : (List) invokeV.objValue;
    }

    public List<c.a.d.o.e.n> getShowTopThreadList() {
        InterceptResult invokeV;
        List<k> list;
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
                arrayList.add(new r(forum, this.forumRule));
            }
            if (forum != null && !m.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new q(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new q(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<c.a.d.o.e.n> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    c.a.d.o.e.n nVar = (c.a.d.o.e.n) ListUtils.getItem(topThreadList, i4);
                    if (nVar instanceof a2) {
                        a2 a2Var = (a2) nVar;
                        arrayList.add(a2Var.s);
                        if (a2Var.s.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (nVar instanceof ThreadData) {
                            arrayList.add(nVar);
                            if (((ThreadData) nVar).getIsMemberTop() != 1 || z) {
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
            ArrayList<c.a.d.o.e.n> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<c.a.d.o.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.d.o.e.n next = it.next();
                if (next != null && (next instanceof a2)) {
                    a2 a2Var = (a2) next;
                    if (TextUtils.equals(str, a2Var.s.getId())) {
                        return a2Var.s;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public List<c.a.d.o.e.n> getTopThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.topThreadList : (List) invokeV.objValue;
    }

    public int getTopThreadSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ArrayList<c.a.d.o.e.n> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<c.a.d.o.e.n> it = this.threadList.iterator();
                while (it.hasNext()) {
                    c.a.d.o.e.n next = it.next();
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
            p entelechyTabInfo = getEntelechyTabInfo();
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

    public boolean receiveData(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, nVar)) == null) {
            if (nVar == null) {
                return false;
            }
            setSortType(nVar.getSortType());
            setAnti(nVar.getAnti());
            setChatGroup(nVar.getChatGroup());
            setFortuneBag(nVar.isFortuneBag());
            setFortuneDesc(nVar.getFortuneDesc());
            setForum(nVar.getForum());
            setGameName(nVar.getGameName());
            setGameUrl(nVar.getGameUrl());
            setGconAccount(nVar.getGconAccount());
            setHasGame(nVar.isHasGame());
            setIsNewUrl(nVar.getIsNewUrl());
            setPhotoLivePos(nVar.getPhotoLivePos());
            setPage(nVar.getPage());
            setStar(nVar.getStar());
            setStarEnter(nVar.getStarEnter());
            setThreadList(nVar.threadList);
            setThreadListIds(nVar.getThreadListIds());
            setUserData(nVar.getUserData());
            setUserMap(nVar.getUserMap());
            setActivityHeadData(nVar.getActivityHeadData());
            setFrsDefaultTabId(nVar.getFrsDefaultTabId());
            this.defaultShowTab = nVar.defaultShowTab;
            setCategoryInfos(nVar.getCategoryInfos());
            setBawuCenterUrl(nVar.getBawuCenterUrl());
            setCardVideoInfo(nVar.getCardVideoInfo());
            setHeadSdkData(nVar.getHeadSdkData());
            setSchoolRecommendPos(nVar.getSchoolRecommendPos());
            setSchoolRecommendInfo(nVar.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(nVar.getEntelechyTabInfo());
            setAlaLiveCount(nVar.getAlaLiveCount());
            setCarrierEnterData(nVar.getCarrierEnterData());
            setForumState(nVar.getForumState());
            setAccessFlag(nVar.getAccessFlag());
            this.needLog = nVar.needLog;
            this.recommendBookData = nVar.recommendBookData;
            this.presentInfoData = nVar.presentInfoData;
            setBookInfo(nVar.getBookInfo());
            setMangaReadRecordChapterId(nVar.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(nVar.getHeadlineImgInfoData());
            setCardShipinPos(nVar.getCardShipinPos());
            setCardShipinNew(nVar.getCardShipinNew());
            this.enterFrsDialogInfo = nVar.enterFrsDialogInfo;
            setGameRankListData(nVar.getGameRankListData());
            setAgreeBanner(nVar.getAgreeBanner());
            setLiveNotify(nVar.getLiveNotify());
            setGameTabInfo(nVar.getGameTabInfo());
            setGameDefaultTabId(nVar.getGameDefaultTabId());
            setForumHeadIcon(nVar.getForumHeadIcon());
            setUserRecommend(nVar.getUserRecommend());
            setFrsVideoActivityData(nVar.getFrsVideoActivityData());
            this.mNewChapterInfo = nVar.mNewChapterInfo;
            setFrsInsertLiveData(nVar.getFrsInsertLiveData());
            this.recm_forum_list = nVar.getRecm_forum_list();
            setFrsStageLiveData(nVar.getFrsStageLiveData());
            this.forumArIno = nVar.forumArIno;
            this.starRank = nVar.starRank;
            this.postTopic = nVar.postTopic;
            this.mWindowToast = nVar.mWindowToast;
            this.activityConfig = nVar.activityConfig;
            setIsShowRedTip(nVar.isShowRedTip());
            this.isBrandForum = nVar.isBrandForum;
            this.brandAdData = nVar.brandAdData;
            this.oriForumInfoList = nVar.oriForumInfoList;
            this.bottomMenuList = nVar.bottomMenuList;
            this.adMixFloor = nVar.adMixFloor;
            this.adShowSelect = nVar.adShowSelect;
            this.adSampleMapKey = nVar.adSampleMapKey;
            c.a.p0.f1.b.f().n(getAnti());
            c.a.p0.f1.b.f().q(nVar.getForum().getId());
            c.a.p0.f1.b.f().r(nVar.getForum().getName());
            c.a.p0.f1.a.h().q(nVar.getForum().getId());
            if (nVar.getEntelechyTabInfo() != null) {
                c.a.p0.f1.a.h().r(nVar.getEntelechyTabInfo().a);
            }
            if (nVar.getUserData() != null) {
                c.c().e(nVar.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(nVar.getPrivateForumTotalInfo());
            this.isFrsVideoAutoPlay = nVar.isFrsVideoAutoPlay;
            this.smartAppAvatar = nVar.smartAppAvatar;
            this.smartApp = nVar.smartApp;
            this.nebulaHotThreads = nVar.nebulaHotThreads;
            this.forumActiveInfo = nVar.forumActiveInfo;
            this.userList = nVar.userList;
            setBusinessPromot(nVar.getBusinessPromot());
            this.serviceAreaData = nVar.serviceAreaData;
            setHotUserRankData(nVar.getHotUserRankData());
            this.itemInfo = nVar.itemInfo;
            this.toLoadHorseData = nVar.toLoadHorseData;
            this.forumRule = nVar.forumRule;
            this.mSignActivityInfo = nVar.mSignActivityInfo;
            this.showAdsense = nVar.showAdsense;
            setVoiceRoomConfig(nVar.getVoiceRoomConfig());
            setVoiceRoomData(nVar.getVoiceRoomData());
            this.serviceAreaFlutterData = nVar.serviceAreaFlutterData;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void removeAlaInsertLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            removeTopSameClassDataFromList(g.class, getThreadList());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<c.a.d.o.e.n> arrayList;
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
            removeTopSameClassDataFromList(h.class, getThreadList());
        }
    }

    public void removeGameRankListFromThreadList() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<c.a.d.o.e.n> it = this.threadList.iterator();
        while (it.hasNext()) {
            c.a.d.o.e.n next = it.next();
            if (next != null && next.getType() == c.a.p0.i1.b.f15492e) {
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
        Iterator<c.a.d.o.e.n> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof w) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void removeThread(String str) {
        ArrayList<c.a.d.o.e.n> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, str) == null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<c.a.d.o.e.n> it = arrayList.iterator();
        while (it.hasNext()) {
            c.a.d.o.e.n next = it.next();
            if (next != null && (next instanceof a2) && TextUtils.equals(str, ((a2) next).s.getId())) {
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

    public void setFunAdController(c.a.p0.h1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, aVar) == null) {
            this.funAdController = aVar;
        }
    }

    public void setTopThreadList(List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, list) == null) {
            this.topThreadList = list;
        }
    }

    public void updateAnchorPower(AnchorPower anchorPower) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, anchorPower) == null) {
            this.forum.setAnchorPower(anchorPower);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, userPendantData) == null) || this.threadList == null || userPendantData == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        Iterator<c.a.d.o.e.n> it = this.threadList.iterator();
        while (it.hasNext()) {
            c.a.d.o.e.n next = it.next();
            if (next != null && (next instanceof a2)) {
                a2 a2Var = (a2) next;
                if (a2Var.s.getAuthor() != null && currentAccount.equals(a2Var.s.getAuthor().getUserId()) && a2Var.s.getAuthor().getPendantData() != null) {
                    a2Var.s.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                    a2Var.s.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                }
            }
        }
    }

    public void updateLikeData(c.a.p0.a4.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, dVar) == null) || dVar == null) {
            return;
        }
        y yVar = new y();
        yVar.y(1);
        yVar.z(dVar.a);
        yVar.w(dVar.f12174b);
        yVar.u(dVar.f12175c);
        yVar.x(dVar.f12176d);
        updateLikeData(yVar);
    }

    public void updateLoadMoreBannerListData(BannerListData bannerListData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bannerListData) == null) {
            this.isLoadMore = true;
            this.loadMoreBannerListData = bannerListData;
        }
    }

    public void updateSignData(SignData signData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, signData) == null) || signData == null) {
            return;
        }
        this.forum.setSignData(signData);
    }

    public void addRecommendAppToThreadList(c.a.p0.h.e.b bVar, ArrayList<c.a.d.o.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bVar, arrayList) == null) {
            addRecommendAppToThreadList(bVar, false, arrayList, null, false);
        }
    }

    public void addRecommendAppToThreadList(c.a.p0.h.e.b bVar, boolean z, ArrayList<c.a.d.o.e.n> arrayList, ArrayList<c.a.d.o.e.n> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{bVar, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
            c.a.p0.h.f.b bVar2 = new c.a.p0.h.f.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.setFromFrs(true);
                next.setSortType(getSortType());
                arrayList3.add(next);
            }
            bVar2.r(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            c.a.p0.h.f.b bVar3 = new c.a.p0.h.f.b(bVar, 3);
            bVar3.x(z);
            bVar3.E(arrayList);
            bVar3.B(arrayList2);
            bVar3.w(z2);
            bVar3.s(getPage().a());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    public void updateLikeData(y yVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, yVar) == null) || yVar == null) {
            return;
        }
        this.forum.setCurScore(yVar.c());
        this.forum.setLevelupScore(yVar.i());
        this.forum.setLike(yVar.n());
        this.forum.setUser_level(yVar.m());
        this.forum.setLevelName(yVar.h());
    }
}
