package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.RecommendForumData;
import com.baidu.tbadk.core.data.SignData;
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
import d.a.d.k.e.n;
import d.a.p0.i0.b.a;
import d.a.p0.s.d0.b;
import d.a.p0.s.q.a1;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.e2;
import d.a.p0.s.q.n1;
import d.a.p0.s.q.x0;
import d.a.q0.h3.e0;
import d.a.q0.h3.g;
import d.a.q0.h3.h;
import d.a.q0.h3.k;
import d.a.q0.h3.l;
import d.a.q0.h3.m;
import d.a.q0.h3.o;
import d.a.q0.h3.p;
import d.a.q0.h3.q;
import d.a.q0.h3.r;
import d.a.q0.h3.x;
import d.a.q0.u0.c;
import d.a.q0.u0.d;
import d.a.q0.u0.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.AnchorPower;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.NebulaHotThreads;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.SmartApp;
import tbclient.User;
/* loaded from: classes4.dex */
public class FrsViewData extends m implements a, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public d.a.q0.w0.a funAdController;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.postThreadCount = 0;
        this.mHeadLineDefaultNavTabId = -1;
    }

    private int getAlaLiveThreadCardInsertPos(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65537, this, i2, i3)) == null) ? Math.min((getTopThreadSize() + i2) - 1, i3) : invokeII.intValue;
    }

    private List<n> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        a1 a1Var;
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<n> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (a1Var = this.page) != null && a1Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    n nVar = this.threadList.get(i2);
                    if (nVar instanceof a2) {
                        if (((a2) nVar).w.S1) {
                            arrayList2.add(nVar);
                        }
                    } else if ((nVar instanceof b2) && ((b2) nVar).S1) {
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
            Iterator<n> it = this.threadList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof b2) {
                    b2 b2Var = (b2) next;
                    if (b2Var.h0() == 1) {
                        return b2Var.C0();
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    private int getPhotoliveCardInsertPos(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) ? Math.min((getTopThreadSize() + getPhotoLivePos()) - 1, i2) : invokeI.intValue;
    }

    private int getVideoThreadInserPos(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, this, i2, i3)) == null) ? Math.min((getTopThreadSize() + i2) - 1, i3) : invokeII.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isShowRecommendBars(ArrayList<RecommendForumData> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, arrayList)) == null) {
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, this, cls, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            n nVar = arrayList.get(i2);
            if (nVar.getClass() == cls) {
                arrayList2.add(nVar);
                break;
            }
            i2++;
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        arrayList.removeAll(arrayList2);
    }

    public void addCardVideoInfoToThreadList() {
        b2 cardVideoInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || getForum() == null || (cardVideoInfo = getCardVideoInfo()) == null) {
            return;
        }
        Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + cardVideoInfo.o1());
        ArrayList<n> threadList = getThreadList();
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
        int i2 = 0;
        for (int i3 = 0; i3 < this.threadList.size(); i3++) {
            n nVar = this.threadList.get(i3);
            if (nVar instanceof a2) {
                b2 b2Var = ((a2) nVar).w;
                if (b2Var == null || (!b2Var.o2() && b2Var.h0() != 1)) {
                    break;
                }
                i2++;
            }
        }
        if (this.threadList.size() - i2 <= 7 || (feedForumList = this.forum.getBannerListData().getFeedForumList()) == null || feedForumList.size() <= 0) {
            return;
        }
        l lVar = new l();
        lVar.e(this.forum.getId());
        lVar.d(feedForumList);
        this.threadList.add(i2 + 6, lVar);
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
        int i2 = 0;
        for (int i3 = 0; i3 < this.threadList.size(); i3++) {
            n nVar = this.threadList.get(i3);
            if (nVar instanceof a2) {
                b2 b2Var = ((a2) nVar).w;
                if (b2Var == null || (!b2Var.o2() && b2Var.h0() != 1)) {
                    break;
                }
                i2++;
            }
        }
        if ((getGameRankListData().b() + i2) - 1 >= this.threadList.size()) {
            return;
        }
        String p = b.j().p("game_rank_list_info", "");
        if (!StringUtils.isNull(p) && p.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(d.a.d.e.m.b.f(p.split(",")[0], 0L), System.currentTimeMillis()) < d.a.d.e.m.b.d(p.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int k = b.j().k("game_rank_list_show_times", 0);
                    if (!z) {
                        k++;
                    }
                    b.j().v("game_rank_list_show_times", k);
                    if (k > 3) {
                        b j = b.j();
                        j.x("game_rank_list_info", System.currentTimeMillis() + ",1");
                        b.j().v("game_rank_list_show_times", 0);
                        if (z3) {
                            this.threadList.add((i2 + getGameRankListData().b()) - 1, getGameRankListData());
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
        d.a.q0.a0.e0.n recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i2 = 0;
                for (int i3 = 0; i3 < this.threadList.size(); i3++) {
                    n nVar = this.threadList.get(i3);
                    if (nVar instanceof a2) {
                        b2 b2Var = ((a2) nVar).w;
                        if (b2Var == null || (!b2Var.o2() && b2Var.h0() != 1)) {
                            break;
                        }
                        i2++;
                    }
                }
                if (this.threadList.size() - i2 > 7 && (recomTopicData = this.forum.getBannerListData().getRecomTopicData()) != null && ListUtils.getCount(recomTopicData.f54367h) >= 4) {
                    this.threadList.add(i2 + 6, recomTopicData);
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
        ArrayList<n> threadList = getThreadList();
        removeTopSameClassDataFromList(g.class, threadList);
        threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.f58524f, threadList.size()), frsInsertLiveData);
    }

    public void addMyNewThread(x0 x0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, x0Var) == null) || x0Var == null || StringUtils.isNull(x0Var.d0()) || this.threadList == null) {
            return;
        }
        int topThreadSize = getTopThreadSize();
        ArrayList<n> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                n nVar = threadList.get(i2);
                if ((nVar instanceof a2) && x0Var.d0().equals(((a2) nVar).w.d0()) && x0Var.getType() != b2.K3) {
                    return;
                }
            }
        }
        x0Var.G1 = this.isBrandForum;
        this.postThreadCount++;
        this.threadList.add(topThreadSize, x0Var);
    }

    public void addNoticeThreadToThreadList() {
        e2 top_notice_data;
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getForum() == null || this.threadList == null || (top_notice_data = getForum().getTop_notice_data()) == null || top_notice_data.a() == null) {
            return;
        }
        while (!this.threadList.isEmpty() && (nVar = this.threadList.get(0)) != null && (nVar instanceof a2) && ((b2) nVar).n0() == 2) {
            this.threadList.remove(0);
        }
        b2 b2Var = new b2();
        b2Var.i4(top_notice_data.a());
        b2Var.h4(top_notice_data.b());
        b2Var.G3(2);
        b2Var.O2();
        a2 a2Var = new a2();
        a2Var.w = b2Var;
        this.threadList.add(0, a2Var);
    }

    public void addOfficialBarToThreadList() {
        a1 a1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.forum == null || this.threadList == null || !b2.G3.get() || (a1Var = this.page) == null) {
            return;
        }
        boolean z = true;
        if (a1Var.a() == 1) {
            r rVar = this.gconAccount;
            z = (rVar == null || !rVar.b()) ? false : false;
            if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof x)) {
                    this.threadList.remove(0);
                }
                x xVar = new x();
                xVar.x4(this.fortuneBag);
                xVar.y4(this.fortuneDesc);
                xVar.z4(this.gconAccount);
                xVar.G3(1003);
                ArrayList<n> arrayList = this.threadList;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                ListUtils.add(this.threadList, getTopThreadSize(), xVar);
            }
        }
    }

    public void addRecommendAppToThreadList(d.a.q0.e.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            addRecommendAppToThreadList(bVar, false, this.threadList, null, false);
        }
    }

    public void addRecommendBarsToThreadList() {
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.forum == null || (arrayList = this.threadList) == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<n> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof n1) {
                it.remove();
            }
        }
        a1 a1Var = this.page;
        if (a1Var == null || a1Var.a() != 1) {
            return;
        }
        ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
        n1 n1Var = new n1();
        if (recommendForumData != null) {
            n1Var.u4().addAll(recommendForumData);
        }
        if (isShowRecommendBars(n1Var.u4())) {
            int i2 = 0;
            Iterator<n> it2 = this.threadList.iterator();
            while (it2.hasNext()) {
                n next = it2.next();
                if ((next instanceof a2) && ((a2) next).w.o2()) {
                    i2++;
                }
            }
            this.threadList.add(i2 + 1, n1Var);
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
        ArrayList<n> threadList = getThreadList();
        removeTopSameClassDataFromList(h.class, threadList);
        if (ListUtils.isEmpty(frsStageLiveData.f58535e)) {
            return;
        }
        threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
    }

    public void addU9DataToThreadList() {
        ForumData forumData;
        a1 a1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (forumData = this.forum) == null) {
            return;
        }
        if (((forumData.getTopCode() == null || StringUtils.isNull(this.forum.getTopCode().g())) && (this.forum.getNewsInfo() == null || StringUtils.isNull(this.forum.getNewsInfo().D0()))) || (a1Var = this.page) == null || a1Var.a() != 1) {
            return;
        }
        e0 e0Var = new e0();
        e0Var.y4(this.forum.getTopCode());
        e0Var.z4(this.forum.getNewsInfo());
        e0Var.G3(3);
        e0Var.x4(true);
        if (ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<n> it = this.threadList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof b2) {
                b2 b2Var = (b2) next;
                if (b2Var.n0() != 0) {
                    if (b2Var.n0() == 1003) {
                        e0Var.x4(false);
                    }
                    i2++;
                }
            }
        }
        this.threadList.add(i2, e0Var);
    }

    public void addUserRecommendToThreadList() {
        int b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || getUserRecommend() == null) {
            return;
        }
        w userRecommend = getUserRecommend();
        if (ListUtils.getCount(userRecommend.d()) >= 3 && (b2 = userRecommend.b()) > 0) {
            int topThreadSize = b2 + getTopThreadSize();
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
        Iterator<n> it = this.threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && next.getType() == q.f58751g) {
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
        List<n> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<n> threadList = getThreadList();
        if (cardShipinPos == null || cardShipinPos.size() <= 0 || cardShipinNew == null || cardShipinNew.size() <= 0 || threadList == null) {
            return;
        }
        int size = cardShipinPos.size();
        int size2 = threadList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 < cardShipinNew.size()) {
                n nVar = cardShipinNew.get(i2);
                int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i2).intValue(), size2);
                Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + nVar.getType());
                threadList.add(videoThreadInserPos, nVar);
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<n> arrayList;
        a1 a1Var;
        ArrayList<n> arrayList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (arrayList = this.threadList) == null || arrayList.size() <= 0 || (a1Var = this.page) == null || a1Var.a() != 1 || (arrayList2 = this.threadList) == null || arrayList2.size() <= 0) {
            return;
        }
        int i2 = -1;
        int size = this.threadList.size();
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = this.threadList.get(i3);
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.w.getType() == b2.s3 && a2Var.w.h1() != null && ((b2) nVar).h1().user_info != null && a2Var.w.h1().user_info.is_official == 2 && a2Var.w.h1().liveStageForceTop) {
                    i2 = i3;
                    break;
                }
            } else {
                if (nVar instanceof b2) {
                    b2 b2Var = (b2) nVar;
                    if (b2Var.getType() == b2.s3 && b2Var.h1() != null && b2Var.h1().user_info != null && b2Var.h1().user_info.is_official == 2 && b2Var.h1().liveStageForceTop) {
                        i2 = i3;
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        if (i2 < 0) {
            for (int i4 = 0; i4 < size; i4++) {
                n nVar2 = this.threadList.get(i4);
                if (nVar2 instanceof a2) {
                    if (((a2) nVar2).w.getType() == b2.N3) {
                        i2 = i4;
                        break;
                    }
                } else {
                    if ((nVar2 instanceof b2) && ((b2) nVar2).getType() == b2.N3) {
                        i2 = i4;
                        break;
                    }
                }
            }
        }
        int topThreadSize = getTopThreadSize();
        if (i2 > topThreadSize) {
            this.threadList.add(topThreadSize, this.threadList.remove(i2));
        }
        List<n> headLineDataInThreadList = getHeadLineDataInThreadList();
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
            } else if (StringUtils.isNull(next.i()) || StringUtils.isNull(next.e())) {
                if (next.b() != 1) {
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

    public boolean getIsBrandForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.isBrandForum : invokeV.booleanValue;
    }

    public int getMyNewThreadNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ArrayList<n> threadList = getThreadList();
            if (threadList == null || threadList.size() <= 0) {
                return 0;
            }
            int size = threadList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (threadList.get(i3) instanceof x0) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int getPostThreadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.postThreadCount : invokeV.intValue;
    }

    @Override // d.a.q0.h3.m
    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.recm_forum_list : (List) invokeV.objValue;
    }

    public List<n> getShowTopThreadList() {
        InterceptResult invokeV;
        List<k> list;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(getStarEnter())) {
                list = null;
            } else {
                list = getStarEnter();
                filterEnterList(list);
            }
            if (ListUtils.isEmpty(list)) {
                i2 = 0;
            } else {
                i2 = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    if (list.get(i3).b() == 1) {
                        arrayList.add(list.get(i3));
                        i2++;
                    }
                }
            }
            ForumData forum = getForum();
            if (forum != null && getForum().getIsShowRule() && this.forumRule != null && (getUserData().getIs_manager() == 1 || this.forumRule.has_forum_rule.intValue() == 1)) {
                arrayList.add(new p(forum, this.forumRule));
            }
            if (forum != null && !d.a.d.e.p.k.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new o(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new o(forum, true));
            }
            int i4 = 3 - i2;
            int size = arrayList.size();
            List<n> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i5 = 0; i5 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i4; i5++) {
                    n nVar = (n) ListUtils.getItem(topThreadList, i5);
                    if (nVar instanceof a2) {
                        a2 a2Var = (a2) nVar;
                        arrayList.add(a2Var.w);
                        if (a2Var.w.j0() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i4++;
                        z = true;
                    } else {
                        if (nVar instanceof b2) {
                            arrayList.add(nVar);
                            if (((b2) nVar).j0() != 1 || z) {
                                if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                    break;
                                }
                            }
                            i4++;
                            z = true;
                        } else {
                            continue;
                        }
                    }
                }
            }
            if (!ListUtils.isEmpty(list)) {
                for (int i6 = 0; i6 < list.size(); i6++) {
                    if (list.get(i6).b() != 1) {
                        arrayList.add(list.get(i6));
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ForumData forumData = this.forum;
            if (forumData == null) {
                return null;
            }
            return forumData.getSignData();
        }
        return (SignData) invokeV.objValue;
    }

    public b2 getThreadDataById(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            ArrayList<n> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && (next instanceof a2)) {
                    a2 a2Var = (a2) next;
                    if (TextUtils.equals(str, a2Var.w.d0())) {
                        return a2Var.w;
                    }
                }
            }
            return null;
        }
        return (b2) invokeL.objValue;
    }

    public List<n> getTopThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.topThreadList : (List) invokeV.objValue;
    }

    public int getTopThreadSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            ArrayList<n> arrayList = this.threadList;
            int i2 = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<n> it = this.threadList.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next instanceof b2) {
                        if (((b2) next).n0() == 0) {
                            break;
                        }
                        i2++;
                    }
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public NebulaHotThreads getYouhuaHotThreads() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.nebulaHotThreads : (NebulaHotThreads) invokeV.objValue;
    }

    public boolean hasTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (getEntelechyTabInfo() == null || ListUtils.isEmpty(getEntelechyTabInfo().tab)) ? false : true : invokeV.booleanValue;
    }

    public boolean isFirstTabEqualAllThread() {
        InterceptResult invokeV;
        List<FrsTabInfo> list;
        FrsTabInfo frsTabInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            NavTabInfo entelechyTabInfo = getEntelechyTabInfo();
            return (entelechyTabInfo == null || (list = entelechyTabInfo.tab) == null || list.size() <= 0 || (frsTabInfo = list.get(0)) == null || frsTabInfo.tab_id.intValue() != 1) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean isPrivateForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? (getForum() == null || getForum().getIsPrivateForum() == 0 || getForum().getIsPrivateForum() != 1) ? false : true : invokeV.booleanValue;
    }

    public boolean isStarForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? getStar() != null && getStar().b() == 1 : invokeV.booleanValue;
    }

    public boolean receiveData(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, mVar)) == null) {
            if (mVar == null) {
                return false;
            }
            setSortType(mVar.getSortType());
            setAnti(mVar.getAnti());
            setChatGroup(mVar.getChatGroup());
            setFortuneBag(mVar.isFortuneBag());
            setFortuneDesc(mVar.getFortuneDesc());
            setForum(mVar.getForum());
            setGameName(mVar.getGameName());
            setGameUrl(mVar.getGameUrl());
            setGconAccount(mVar.getGconAccount());
            setHasGame(mVar.isHasGame());
            setIsNewUrl(mVar.getIsNewUrl());
            setPhotoLivePos(mVar.getPhotoLivePos());
            setPage(mVar.getPage());
            setStar(mVar.getStar());
            setStarEnter(mVar.getStarEnter());
            setThreadList(mVar.threadList);
            setThreadListIds(mVar.getThreadListIds());
            setUserData(mVar.getUserData());
            setUserMap(mVar.getUserMap());
            setActivityHeadData(mVar.getActivityHeadData());
            setFrsDefaultTabId(mVar.getFrsDefaultTabId());
            this.defaultShowTab = mVar.defaultShowTab;
            setCategoryInfos(mVar.getCategoryInfos());
            setBawuCenterUrl(mVar.getBawuCenterUrl());
            setCardVideoInfo(mVar.getCardVideoInfo());
            setHeadSdkData(mVar.getHeadSdkData());
            setSchoolRecommendPos(mVar.getSchoolRecommendPos());
            setSchoolRecommendInfo(mVar.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(mVar.getEntelechyTabInfo());
            setAlaLiveCount(mVar.getAlaLiveCount());
            setCarrierEnterData(mVar.getCarrierEnterData());
            setForumState(mVar.getForumState());
            setAccessFlag(mVar.getAccessFlag());
            this.needLog = mVar.needLog;
            this.recommendBookData = mVar.recommendBookData;
            this.presentInfoData = mVar.presentInfoData;
            setBookInfo(mVar.getBookInfo());
            setMangaReadRecordChapterId(mVar.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(mVar.getHeadlineImgInfoData());
            setCardShipinPos(mVar.getCardShipinPos());
            setCardShipinNew(mVar.getCardShipinNew());
            this.enterFrsDialogInfo = mVar.enterFrsDialogInfo;
            setGameRankListData(mVar.getGameRankListData());
            setAgreeBanner(mVar.getAgreeBanner());
            setLiveNotify(mVar.getLiveNotify());
            setGameTabInfo(mVar.getGameTabInfo());
            setGameDefaultTabId(mVar.getGameDefaultTabId());
            setForumHeadIcon(mVar.getForumHeadIcon());
            setUserRecommend(mVar.getUserRecommend());
            setFrsVideoActivityData(mVar.getFrsVideoActivityData());
            this.mNewChapterInfo = mVar.mNewChapterInfo;
            setFrsInsertLiveData(mVar.getFrsInsertLiveData());
            this.recm_forum_list = mVar.getRecm_forum_list();
            setFrsStageLiveData(mVar.getFrsStageLiveData());
            this.forumArIno = mVar.forumArIno;
            this.starRank = mVar.starRank;
            this.postTopic = mVar.postTopic;
            this.mWindowToast = mVar.mWindowToast;
            this.activityConfig = mVar.activityConfig;
            setIsShowRedTip(mVar.isShowRedTip());
            this.isBrandForum = mVar.isBrandForum;
            this.brandAdData = mVar.brandAdData;
            this.oriForumInfoList = mVar.oriForumInfoList;
            this.bottomMenuList = mVar.bottomMenuList;
            d.a.q0.u0.b.e().l(getAnti());
            d.a.q0.u0.b.e().n(mVar.getForum().getId());
            d.a.q0.u0.a.h().q(mVar.getForum().getId());
            if (mVar.getEntelechyTabInfo() != null) {
                d.a.q0.u0.a.h().r(mVar.getEntelechyTabInfo().tab);
            }
            if (mVar.getUserData() != null) {
                c.c().e(mVar.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(mVar.getPrivateForumTotalInfo());
            this.isFrsVideoAutoPlay = mVar.isFrsVideoAutoPlay;
            this.smartAppAvatar = mVar.smartAppAvatar;
            this.smartApp = mVar.smartApp;
            this.nebulaHotThreads = mVar.nebulaHotThreads;
            this.forumActiveInfo = mVar.forumActiveInfo;
            this.userList = mVar.userList;
            setBusinessPromot(mVar.getBusinessPromot());
            this.serviceAreaData = mVar.serviceAreaData;
            setHotUserRankData(mVar.getHotUserRankData());
            this.itemInfo = mVar.itemInfo;
            this.toLoadHorseData = mVar.toLoadHorseData;
            this.forumRule = mVar.forumRule;
            this.mSignActivityInfo = mVar.mSignActivityInfo;
            this.showAdsense = mVar.showAdsense;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void removeAlaInsertLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            removeTopSameClassDataFromList(g.class, getThreadList());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (arrayList = this.threadList) == null || arrayList.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            if (this.threadList.get(i2).getType() == b2.s3 || this.threadList.get(i2).getType() == b2.t3 || this.threadList.get(i2).getType() == b2.u3) {
                this.threadList.remove(i2);
            }
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            removeTopSameClassDataFromList(h.class, getThreadList());
        }
    }

    public void removeGameRankListFromThreadList() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<n> it = this.threadList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next != null && next.getType() == d.a.q0.x0.b.f66863i) {
                it.remove();
            }
        }
    }

    public void removeRedundantUserRecommendData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.threadList.iterator();
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
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, str) == null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next != null && (next instanceof a2) && TextUtils.equals(str, ((a2) next).w.d0())) {
                it.remove();
            }
        }
    }

    public void removeThreadData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, b2Var) == null) {
            this.threadList.remove(b2Var);
        }
    }

    public void setFunAdController(d.a.q0.w0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, aVar) == null) {
            this.funAdController = aVar;
        }
    }

    public void setTopThreadList(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, list) == null) {
            this.topThreadList = list;
        }
    }

    public void updateAnchorPower(AnchorPower anchorPower) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, anchorPower) == null) {
            this.forum.setAnchorPower(anchorPower);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, userPendantData) == null) || this.threadList == null || userPendantData == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        Iterator<n> it = this.threadList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next != null && (next instanceof a2)) {
                a2 a2Var = (a2) next;
                if (a2Var.w.H() != null && currentAccount.equals(a2Var.w.H().getUserId()) && a2Var.w.H().getPendantData() != null) {
                    a2Var.w.H().getPendantData().setPropsId(userPendantData.getPropsId());
                    a2Var.w.H().getPendantData().setImgUrl(userPendantData.getImgUrl());
                }
            }
        }
    }

    public void updateLikeData(d.a.q0.h3.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, dVar) == null) || dVar == null) {
            return;
        }
        d.a.q0.h3.w wVar = new d.a.q0.h3.w();
        wVar.v(1);
        wVar.w(dVar.f58499a);
        wVar.t(dVar.f58500b);
        wVar.r(dVar.f58501c);
        wVar.u(dVar.f58502d);
        updateLikeData(wVar);
    }

    public void updateLoadMoreBannerListData(BannerListData bannerListData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bannerListData) == null) {
            this.isLoadMore = true;
            this.loadMoreBannerListData = bannerListData;
        }
    }

    public void updateSignData(SignData signData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, signData) == null) || signData == null) {
            return;
        }
        this.forum.setSignData(signData);
    }

    public void addRecommendAppToThreadList(d.a.q0.e.e.b bVar, ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bVar, arrayList) == null) {
            addRecommendAppToThreadList(bVar, false, arrayList, null, false);
        }
    }

    public void addRecommendAppToThreadList(d.a.q0.e.e.b bVar, boolean z, ArrayList<n> arrayList, ArrayList<n> arrayList2, boolean z2) {
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
            d.a.q0.e.f.b bVar2 = new d.a.q0.e.f.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.u3(true);
                next.c4(getSortType());
                arrayList3.add(next);
            }
            bVar2.r(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            d.a.q0.e.f.b bVar3 = new d.a.q0.e.f.b(bVar, 3);
            bVar3.x(z);
            bVar3.E(arrayList);
            bVar3.B(arrayList2);
            bVar3.w(z2);
            bVar3.s(getPage().a());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    public void updateLikeData(d.a.q0.h3.w wVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, wVar) == null) || wVar == null) {
            return;
        }
        this.forum.setCurScore(wVar.c());
        this.forum.setLevelupScore(wVar.i());
        this.forum.setLike(wVar.l());
        this.forum.setUser_level(wVar.k());
        this.forum.setLevelName(wVar.h());
    }
}
