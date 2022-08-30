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
import com.baidu.tieba.dk8;
import com.baidu.tieba.ek8;
import com.baidu.tieba.fq4;
import com.baidu.tieba.gt6;
import com.baidu.tieba.iq4;
import com.baidu.tieba.jk8;
import com.baidu.tieba.kr4;
import com.baidu.tieba.lk8;
import com.baidu.tieba.of6;
import com.baidu.tieba.oj8;
import com.baidu.tieba.ok5;
import com.baidu.tieba.pg;
import com.baidu.tieba.pn;
import com.baidu.tieba.qi;
import com.baidu.tieba.qt6;
import com.baidu.tieba.rj8;
import com.baidu.tieba.se6;
import com.baidu.tieba.sj8;
import com.baidu.tieba.sk8;
import com.baidu.tieba.t85;
import com.baidu.tieba.te6;
import com.baidu.tieba.tu4;
import com.baidu.tieba.ue6;
import com.baidu.tieba.ve6;
import com.baidu.tieba.vj8;
import com.baidu.tieba.vq4;
import com.baidu.tieba.wj8;
import com.baidu.tieba.wk5;
import com.baidu.tieba.yj8;
import com.baidu.tieba.z06;
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
public class FrsViewData extends yj8 implements t85, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public gt6 funAdController;
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
        iq4 iq4Var;
        ArrayList<pn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<pn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (iq4Var = this.page) != null && iq4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    pn pnVar = this.threadList.get(i);
                    if (pnVar instanceof kr4) {
                        if (((kr4) pnVar).t.isHeadLinePost) {
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
            if (pnVar instanceof kr4) {
                ThreadData threadData = ((kr4) pnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (feedForumList = this.forum.getBannerListData().getFeedForumList()) == null || feedForumList.size() <= 0) {
            return;
        }
        wj8 wj8Var = new wj8();
        wj8Var.f(this.forum.getId());
        wj8Var.c(feedForumList);
        this.threadList.add(i + 6, wj8Var);
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
            if (pnVar instanceof kr4) {
                ThreadData threadData = ((kr4) pnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String q = tu4.k().q("game_rank_list_info", "");
        if (!StringUtils.isNull(q) && q.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(pg.g(q.split(",")[0], 0L), System.currentTimeMillis()) < pg.e(q.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int l = tu4.k().l("game_rank_list_show_times", 0);
                    if (!z) {
                        l++;
                    }
                    tu4.k().w("game_rank_list_show_times", l);
                    if (l > 3) {
                        tu4 k = tu4.k();
                        k.y("game_rank_list_info", System.currentTimeMillis() + ",1");
                        tu4.k().w("game_rank_list_show_times", 0);
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
        z06 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    pn pnVar = this.threadList.get(i2);
                    if (pnVar instanceof kr4) {
                        ThreadData threadData = ((kr4) pnVar).t;
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
        rj8 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsInsertLiveData = getFrsInsertLiveData()) == null) {
            return;
        }
        ArrayList<pn> threadList = getThreadList();
        removeTopSameClassDataFromList(rj8.class, threadList);
        threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.b, threadList.size()), frsInsertLiveData);
    }

    public void addMyNewThread(fq4 fq4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fq4Var) == null) || fq4Var == null || StringUtils.isNull(fq4Var.getId()) || this.threadList == null) {
            return;
        }
        int topThreadSize = getTopThreadSize();
        ArrayList<pn> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            for (int i = 0; i < size; i++) {
                pn pnVar = threadList.get(i);
                if ((pnVar instanceof kr4) && fq4Var.getId().equals(((kr4) pnVar).t.getId()) && fq4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                    return;
                }
            }
        }
        fq4Var.isFromBrandForum = this.isBrandForum;
        this.postThreadCount++;
        this.threadList.add(topThreadSize, fq4Var);
    }

    public void addNoticeThreadToThreadList() {
        TopNoticeData top_notice_data;
        pn pnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getForum() == null || this.threadList == null || (top_notice_data = getForum().getTop_notice_data()) == null || top_notice_data.getTitle() == null) {
            return;
        }
        while (!this.threadList.isEmpty() && (pnVar = this.threadList.get(0)) != null && (pnVar instanceof kr4) && ((ThreadData) pnVar).getIs_top() == 2) {
            this.threadList.remove(0);
        }
        ThreadData threadData = new ThreadData();
        threadData.setTitle(top_notice_data.getTitle());
        threadData.setTid(top_notice_data.getTitle_link());
        threadData.setIs_top(2);
        threadData.parser_title();
        kr4 kr4Var = new kr4();
        kr4Var.t = threadData;
        this.threadList.add(0, kr4Var);
    }

    public void addOfficialBarToThreadList() {
        iq4 iq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.forum == null || this.threadList == null || !ThreadData.isFRSExtraLoaded.get() || (iq4Var = this.page) == null) {
            return;
        }
        boolean z = true;
        if (iq4Var.a() == 1) {
            ek8 ek8Var = this.gconAccount;
            z = (ek8Var == null || !ek8Var.b()) ? false : false;
            if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof lk8)) {
                    this.threadList.remove(0);
                }
                lk8 lk8Var = new lk8();
                lk8Var.j(this.fortuneBag);
                lk8Var.l(this.fortuneDesc);
                lk8Var.n(this.gconAccount);
                lk8Var.setIs_top(1003);
                ArrayList<pn> arrayList = this.threadList;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                ListUtils.add(this.threadList, getTopThreadSize(), lk8Var);
            }
        }
    }

    public void addRecommendAppToThreadList(ok5 ok5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ok5Var) == null) {
            addRecommendAppToThreadList(ok5Var, false, this.threadList, null, false);
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
            if (it.next() instanceof vq4) {
                it.remove();
            }
        }
        iq4 iq4Var = this.page;
        if (iq4Var == null || iq4Var.a() != 1) {
            return;
        }
        ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
        vq4 vq4Var = new vq4();
        if (recommendForumData != null) {
            vq4Var.c().addAll(recommendForumData);
        }
        if (isShowRecommendBars(vq4Var.c())) {
            int i = 0;
            Iterator<pn> it2 = this.threadList.iterator();
            while (it2.hasNext()) {
                pn next = it2.next();
                if ((next instanceof kr4) && ((kr4) next).t.isTop()) {
                    i++;
                }
            }
            this.threadList.add(i + 1, vq4Var);
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
        sj8 frsStageLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsStageLiveData = getFrsStageLiveData()) == null) {
            return;
        }
        ArrayList<pn> threadList = getThreadList();
        removeTopSameClassDataFromList(sj8.class, threadList);
        if (ListUtils.isEmpty(frsStageLiveData.a)) {
            return;
        }
        threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
    }

    public void addU9DataToThreadList() {
        ForumData forumData;
        iq4 iq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (forumData = this.forum) == null) {
            return;
        }
        if (((forumData.getTopCode() == null || StringUtils.isNull(this.forum.getTopCode().g())) && (this.forum.getNewsInfo() == null || StringUtils.isNull(this.forum.getNewsInfo().j1()))) || (iq4Var = this.page) == null || iq4Var.a() != 1) {
            return;
        }
        sk8 sk8Var = new sk8();
        sk8Var.l(this.forum.getTopCode());
        sk8Var.n(this.forum.getNewsInfo());
        sk8Var.setIs_top(3);
        sk8Var.j(true);
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
                        sk8Var.j(false);
                    }
                    i++;
                }
            }
        }
        this.threadList.add(i, sk8Var);
    }

    public void addUserRecommendToThreadList() {
        int a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || getUserRecommend() == null) {
            return;
        }
        of6 userRecommend = getUserRecommend();
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
            if (next != null && next.getType() == dk8.c) {
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
        iq4 iq4Var;
        ArrayList<pn> arrayList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (arrayList = this.threadList) == null || arrayList.size() <= 0 || (iq4Var = this.page) == null || iq4Var.a() != 1 || (arrayList2 = this.threadList) == null || arrayList2.size() <= 0) {
            return;
        }
        int i = -1;
        int size = this.threadList.size();
        for (int i2 = 0; i2 < size; i2++) {
            pn pnVar = this.threadList.get(i2);
            if (pnVar instanceof kr4) {
                kr4 kr4Var = (kr4) pnVar;
                if (kr4Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && kr4Var.t.getThreadAlaInfo() != null && ((ThreadData) pnVar).getThreadAlaInfo().user_info != null && kr4Var.t.getThreadAlaInfo().user_info.is_official == 2 && kr4Var.t.getThreadAlaInfo().liveStageForceTop) {
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
                if (pnVar2 instanceof kr4) {
                    if (((kr4) pnVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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

    public void filterEnterList(List<vj8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        Iterator<vj8> it = list.iterator();
        while (it.hasNext()) {
            vj8 next = it.next();
            if (next == null) {
                it.remove();
            } else if (StringUtils.isNull(next.h()) || StringUtils.isNull(next.f())) {
                if (next.a() != 1) {
                    it.remove();
                }
            }
        }
    }

    public ve6 getBrandAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.brandAdData : (ve6) invokeV.objValue;
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
                if (threadList.get(i2) instanceof fq4) {
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

    @Override // com.baidu.tieba.yj8
    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.recm_forum_list : (List) invokeV.objValue;
    }

    public List<pn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<vj8> list;
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
                arrayList.add(new ck8(forum, this.forumRule));
            }
            if (forum != null && !qi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new bk8(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new bk8(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<pn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    pn pnVar = (pn) ListUtils.getItem(topThreadList, i4);
                    if (pnVar instanceof kr4) {
                        kr4 kr4Var = (kr4) pnVar;
                        arrayList.add(kr4Var.t);
                        if (kr4Var.t.getIsMemberTop() != 1 || z) {
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
                if (next != null && (next instanceof kr4)) {
                    kr4 kr4Var = (kr4) next;
                    if (TextUtils.equals(str, kr4Var.t.getId())) {
                        return kr4Var.t;
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
            ak8 entelechyTabInfo = getEntelechyTabInfo();
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

    public boolean receiveData(yj8 yj8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, yj8Var)) == null) {
            if (yj8Var == null) {
                return false;
            }
            this.isFromCache = yj8Var.isFromCache;
            setBaWuNoticeNum(yj8Var.getBaWuNoticeNum());
            setSortType(yj8Var.getSortType());
            setAnti(yj8Var.getAnti());
            setChatGroup(yj8Var.getChatGroup());
            setFortuneBag(yj8Var.isFortuneBag());
            setFortuneDesc(yj8Var.getFortuneDesc());
            setForum(yj8Var.getForum());
            setGameName(yj8Var.getGameName());
            setGameUrl(yj8Var.getGameUrl());
            setGconAccount(yj8Var.getGconAccount());
            setHasGame(yj8Var.isHasGame());
            setIsNewUrl(yj8Var.getIsNewUrl());
            setPhotoLivePos(yj8Var.getPhotoLivePos());
            setPage(yj8Var.getPage());
            setStar(yj8Var.getStar());
            setStarEnter(yj8Var.getStarEnter());
            setThreadList(yj8Var.threadList);
            setThreadListIds(yj8Var.getThreadListIds());
            setUserData(yj8Var.getUserData());
            setUserMap(yj8Var.getUserMap());
            setActivityHeadData(yj8Var.getActivityHeadData());
            setFrsDefaultTabId(yj8Var.getFrsDefaultTabId());
            this.defaultShowTab = yj8Var.defaultShowTab;
            setCategoryInfos(yj8Var.getCategoryInfos());
            setBawuCenterUrl(yj8Var.getBawuCenterUrl());
            setCardVideoInfo(yj8Var.getCardVideoInfo());
            setHeadSdkData(yj8Var.getHeadSdkData());
            setSchoolRecommendPos(yj8Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(yj8Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(yj8Var.getEntelechyTabInfo());
            setAlaLiveCount(yj8Var.getAlaLiveCount());
            setCarrierEnterData(yj8Var.getCarrierEnterData());
            setForumState(yj8Var.getForumState());
            setAccessFlag(yj8Var.getAccessFlag());
            this.needLog = yj8Var.needLog;
            this.recommendBookData = yj8Var.recommendBookData;
            this.presentInfoData = yj8Var.presentInfoData;
            setBookInfo(yj8Var.getBookInfo());
            setMangaReadRecordChapterId(yj8Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(yj8Var.getHeadlineImgInfoData());
            setCardShipinPos(yj8Var.getCardShipinPos());
            setCardShipinNew(yj8Var.getCardShipinNew());
            this.enterFrsDialogInfo = yj8Var.enterFrsDialogInfo;
            setGameRankListData(yj8Var.getGameRankListData());
            setAgreeBanner(yj8Var.getAgreeBanner());
            setLiveNotify(yj8Var.getLiveNotify());
            setGameTabInfo(yj8Var.getGameTabInfo());
            setGameDefaultTabId(yj8Var.getGameDefaultTabId());
            setForumHeadIcon(yj8Var.getForumHeadIcon());
            setUserRecommend(yj8Var.getUserRecommend());
            setFrsVideoActivityData(yj8Var.getFrsVideoActivityData());
            this.mNewChapterInfo = yj8Var.mNewChapterInfo;
            setFrsInsertLiveData(yj8Var.getFrsInsertLiveData());
            this.recm_forum_list = yj8Var.getRecm_forum_list();
            setFrsStageLiveData(yj8Var.getFrsStageLiveData());
            this.forumArIno = yj8Var.forumArIno;
            this.starRank = yj8Var.starRank;
            this.postTopic = yj8Var.postTopic;
            this.mWindowToast = yj8Var.mWindowToast;
            this.activityConfig = yj8Var.activityConfig;
            setIsShowRedTip(yj8Var.isShowRedTip());
            this.isBrandForum = yj8Var.isBrandForum;
            this.brandAdData = yj8Var.brandAdData;
            this.oriForumInfoList = yj8Var.oriForumInfoList;
            this.bottomMenuList = yj8Var.bottomMenuList;
            this.adMixFloor = yj8Var.adMixFloor;
            this.adShowSelect = yj8Var.adShowSelect;
            this.adSampleMapKey = yj8Var.adSampleMapKey;
            te6.f().n(getAnti());
            te6.f().q(yj8Var.getForum().getId());
            te6.f().r(yj8Var.getForum().getName());
            se6.h().q(yj8Var.getForum().getId());
            if (yj8Var.getEntelechyTabInfo() != null) {
                se6.h().r(yj8Var.getEntelechyTabInfo().a);
            }
            if (yj8Var.getUserData() != null) {
                ue6.c().e(yj8Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(yj8Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(yj8Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = yj8Var.smartAppAvatar;
            this.smartApp = yj8Var.smartApp;
            this.nebulaHotThreads = yj8Var.nebulaHotThreads;
            this.forumActiveInfo = yj8Var.forumActiveInfo;
            this.userList = yj8Var.userList;
            setBusinessPromot(yj8Var.getBusinessPromot());
            this.serviceAreaData = yj8Var.serviceAreaData;
            setHotUserRankData(yj8Var.getHotUserRankData());
            this.itemInfo = yj8Var.itemInfo;
            this.toLoadHorseData = yj8Var.toLoadHorseData;
            this.forumRule = yj8Var.forumRule;
            this.mSignActivityInfo = yj8Var.mSignActivityInfo;
            this.showAdsense = yj8Var.showAdsense;
            setVoiceRoomConfig(yj8Var.getVoiceRoomConfig());
            setVoiceRoomData(yj8Var.getVoiceRoomData());
            this.serviceAreaFlutterData = yj8Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = yj8Var.liveFuseForumDataList;
            this.forumTagInfo = yj8Var.forumTagInfo;
            this.firstCategory = yj8Var.firstCategory;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void removeAlaInsertLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            removeTopSameClassDataFromList(rj8.class, getThreadList());
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
            removeTopSameClassDataFromList(sj8.class, getThreadList());
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
            if (next != null && next.getType() == qt6.e) {
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
            if (it.next() instanceof of6) {
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
            if (next != null && (next instanceof kr4) && TextUtils.equals(str, ((kr4) next).t.getId())) {
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

    public void setFunAdController(gt6 gt6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, gt6Var) == null) {
            this.funAdController = gt6Var;
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
            if (next != null && (next instanceof kr4)) {
                kr4 kr4Var = (kr4) next;
                if (kr4Var.t.getAuthor() != null && currentAccount.equals(kr4Var.t.getAuthor().getUserId()) && kr4Var.t.getAuthor().getPendantData() != null) {
                    kr4Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                    kr4Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                }
            }
        }
    }

    public void updateLikeData(oj8 oj8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, oj8Var) == null) || oj8Var == null) {
            return;
        }
        jk8 jk8Var = new jk8();
        jk8Var.x(1);
        jk8Var.y(oj8Var.a);
        jk8Var.v(oj8Var.b);
        jk8Var.t(oj8Var.c);
        jk8Var.w(oj8Var.d);
        updateLikeData(jk8Var);
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

    public void addRecommendAppToThreadList(ok5 ok5Var, ArrayList<pn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, ok5Var, arrayList) == null) {
            addRecommendAppToThreadList(ok5Var, false, arrayList, null, false);
        }
    }

    public void addRecommendAppToThreadList(ok5 ok5Var, boolean z, ArrayList<pn> arrayList, ArrayList<pn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{ok5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
            wk5 wk5Var = new wk5(ok5Var, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.setFromFrs(true);
                next.setSortType(getSortType());
                arrayList3.add(next);
            }
            wk5Var.s(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, wk5Var));
            wk5 wk5Var2 = new wk5(ok5Var, 3);
            wk5Var2.z(z);
            wk5Var2.G(arrayList);
            wk5Var2.D(arrayList2);
            wk5Var2.y(z2);
            wk5Var2.t(getPage().a());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, wk5Var2));
        }
    }

    public void updateLikeData(jk8 jk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, jk8Var) == null) || jk8Var == null) {
            return;
        }
        this.forum.setCurScore(jk8Var.c());
        this.forum.setLevelupScore(jk8Var.i());
        this.forum.setLike(jk8Var.m());
        this.forum.setUser_level(jk8Var.l());
        this.forum.setLevelName(jk8Var.h());
    }
}
