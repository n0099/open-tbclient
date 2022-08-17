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
import com.repackage.bk8;
import com.repackage.dk8;
import com.repackage.dq4;
import com.repackage.gf6;
import com.repackage.gj8;
import com.repackage.gk5;
import com.repackage.gq4;
import com.repackage.ir4;
import com.repackage.it6;
import com.repackage.jj8;
import com.repackage.ke6;
import com.repackage.kj8;
import com.repackage.kk8;
import com.repackage.le6;
import com.repackage.m85;
import com.repackage.me6;
import com.repackage.ne6;
import com.repackage.nj8;
import com.repackage.og;
import com.repackage.oj8;
import com.repackage.ok5;
import com.repackage.on;
import com.repackage.pi;
import com.repackage.qj8;
import com.repackage.r06;
import com.repackage.ru4;
import com.repackage.sj8;
import com.repackage.tj8;
import com.repackage.tq4;
import com.repackage.uj8;
import com.repackage.vj8;
import com.repackage.wj8;
import com.repackage.ys6;
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
public class FrsViewData extends qj8 implements m85, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public ys6 funAdController;
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

    private List<on> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        gq4 gq4Var;
        ArrayList<on> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<on> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (gq4Var = this.page) != null && gq4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    on onVar = this.threadList.get(i);
                    if (onVar instanceof ir4) {
                        if (((ir4) onVar).t.isHeadLinePost) {
                            arrayList2.add(onVar);
                        }
                    } else if ((onVar instanceof ThreadData) && ((ThreadData) onVar).isHeadLinePost) {
                        arrayList2.add(onVar);
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
            Iterator<on> it = this.threadList.iterator();
            while (it.hasNext()) {
                on next = it.next();
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<on> arrayList) {
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
            on onVar = arrayList.get(i);
            if (onVar.getClass() == cls) {
                arrayList2.add(onVar);
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
        ArrayList<on> threadList = getThreadList();
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
            on onVar = this.threadList.get(i2);
            if (onVar instanceof ir4) {
                ThreadData threadData = ((ir4) onVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (feedForumList = this.forum.getBannerListData().getFeedForumList()) == null || feedForumList.size() <= 0) {
            return;
        }
        oj8 oj8Var = new oj8();
        oj8Var.f(this.forum.getId());
        oj8Var.c(feedForumList);
        this.threadList.add(i + 6, oj8Var);
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
            on onVar = this.threadList.get(i2);
            if (onVar instanceof ir4) {
                ThreadData threadData = ((ir4) onVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String q = ru4.k().q("game_rank_list_info", "");
        if (!StringUtils.isNull(q) && q.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(og.g(q.split(",")[0], 0L), System.currentTimeMillis()) < og.e(q.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int l = ru4.k().l("game_rank_list_show_times", 0);
                    if (!z) {
                        l++;
                    }
                    ru4.k().w("game_rank_list_show_times", l);
                    if (l > 3) {
                        ru4 k = ru4.k();
                        k.y("game_rank_list_info", System.currentTimeMillis() + ",1");
                        ru4.k().w("game_rank_list_show_times", 0);
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
        r06 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    on onVar = this.threadList.get(i2);
                    if (onVar instanceof ir4) {
                        ThreadData threadData = ((ir4) onVar).t;
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
        jj8 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsInsertLiveData = getFrsInsertLiveData()) == null) {
            return;
        }
        ArrayList<on> threadList = getThreadList();
        removeTopSameClassDataFromList(jj8.class, threadList);
        threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.b, threadList.size()), frsInsertLiveData);
    }

    public void addMyNewThread(dq4 dq4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dq4Var) == null) || dq4Var == null || StringUtils.isNull(dq4Var.getId()) || this.threadList == null) {
            return;
        }
        int topThreadSize = getTopThreadSize();
        ArrayList<on> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            for (int i = 0; i < size; i++) {
                on onVar = threadList.get(i);
                if ((onVar instanceof ir4) && dq4Var.getId().equals(((ir4) onVar).t.getId()) && dq4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                    return;
                }
            }
        }
        dq4Var.isFromBrandForum = this.isBrandForum;
        this.postThreadCount++;
        this.threadList.add(topThreadSize, dq4Var);
    }

    public void addNoticeThreadToThreadList() {
        TopNoticeData top_notice_data;
        on onVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getForum() == null || this.threadList == null || (top_notice_data = getForum().getTop_notice_data()) == null || top_notice_data.getTitle() == null) {
            return;
        }
        while (!this.threadList.isEmpty() && (onVar = this.threadList.get(0)) != null && (onVar instanceof ir4) && ((ThreadData) onVar).getIs_top() == 2) {
            this.threadList.remove(0);
        }
        ThreadData threadData = new ThreadData();
        threadData.setTitle(top_notice_data.getTitle());
        threadData.setTid(top_notice_data.getTitle_link());
        threadData.setIs_top(2);
        threadData.parser_title();
        ir4 ir4Var = new ir4();
        ir4Var.t = threadData;
        this.threadList.add(0, ir4Var);
    }

    public void addOfficialBarToThreadList() {
        gq4 gq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.forum == null || this.threadList == null || !ThreadData.isFRSExtraLoaded.get() || (gq4Var = this.page) == null) {
            return;
        }
        boolean z = true;
        if (gq4Var.a() == 1) {
            wj8 wj8Var = this.gconAccount;
            z = (wj8Var == null || !wj8Var.b()) ? false : false;
            if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof dk8)) {
                    this.threadList.remove(0);
                }
                dk8 dk8Var = new dk8();
                dk8Var.j(this.fortuneBag);
                dk8Var.l(this.fortuneDesc);
                dk8Var.n(this.gconAccount);
                dk8Var.setIs_top(1003);
                ArrayList<on> arrayList = this.threadList;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                ListUtils.add(this.threadList, getTopThreadSize(), dk8Var);
            }
        }
    }

    public void addRecommendAppToThreadList(gk5 gk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gk5Var) == null) {
            addRecommendAppToThreadList(gk5Var, false, this.threadList, null, false);
        }
    }

    public void addRecommendBarsToThreadList() {
        ArrayList<on> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.forum == null || (arrayList = this.threadList) == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<on> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof tq4) {
                it.remove();
            }
        }
        gq4 gq4Var = this.page;
        if (gq4Var == null || gq4Var.a() != 1) {
            return;
        }
        ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
        tq4 tq4Var = new tq4();
        if (recommendForumData != null) {
            tq4Var.c().addAll(recommendForumData);
        }
        if (isShowRecommendBars(tq4Var.c())) {
            int i = 0;
            Iterator<on> it2 = this.threadList.iterator();
            while (it2.hasNext()) {
                on next = it2.next();
                if ((next instanceof ir4) && ((ir4) next).t.isTop()) {
                    i++;
                }
            }
            this.threadList.add(i + 1, tq4Var);
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
        kj8 frsStageLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsStageLiveData = getFrsStageLiveData()) == null) {
            return;
        }
        ArrayList<on> threadList = getThreadList();
        removeTopSameClassDataFromList(kj8.class, threadList);
        if (ListUtils.isEmpty(frsStageLiveData.a)) {
            return;
        }
        threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
    }

    public void addU9DataToThreadList() {
        ForumData forumData;
        gq4 gq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (forumData = this.forum) == null) {
            return;
        }
        if (((forumData.getTopCode() == null || StringUtils.isNull(this.forum.getTopCode().g())) && (this.forum.getNewsInfo() == null || StringUtils.isNull(this.forum.getNewsInfo().j1()))) || (gq4Var = this.page) == null || gq4Var.a() != 1) {
            return;
        }
        kk8 kk8Var = new kk8();
        kk8Var.l(this.forum.getTopCode());
        kk8Var.n(this.forum.getNewsInfo());
        kk8Var.setIs_top(3);
        kk8Var.j(true);
        if (ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<on> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            on next = it.next();
            if (next instanceof ThreadData) {
                ThreadData threadData = (ThreadData) next;
                if (threadData.getIs_top() != 0) {
                    if (threadData.getIs_top() == 1003) {
                        kk8Var.j(false);
                    }
                    i++;
                }
            }
        }
        this.threadList.add(i, kk8Var);
    }

    public void addUserRecommendToThreadList() {
        int a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || getUserRecommend() == null) {
            return;
        }
        gf6 userRecommend = getUserRecommend();
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
        Iterator<on> it = this.threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            on next = it.next();
            if (next != null && next.getType() == vj8.c) {
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
        List<on> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<on> threadList = getThreadList();
        if (cardShipinPos == null || cardShipinPos.size() <= 0 || cardShipinNew == null || cardShipinNew.size() <= 0 || threadList == null) {
            return;
        }
        int size = cardShipinPos.size();
        int size2 = threadList.size();
        for (int i = 0; i < size; i++) {
            if (i < cardShipinNew.size()) {
                on onVar = cardShipinNew.get(i);
                int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + onVar.getType());
                threadList.add(videoThreadInserPos, onVar);
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<on> arrayList;
        gq4 gq4Var;
        ArrayList<on> arrayList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (arrayList = this.threadList) == null || arrayList.size() <= 0 || (gq4Var = this.page) == null || gq4Var.a() != 1 || (arrayList2 = this.threadList) == null || arrayList2.size() <= 0) {
            return;
        }
        int i = -1;
        int size = this.threadList.size();
        for (int i2 = 0; i2 < size; i2++) {
            on onVar = this.threadList.get(i2);
            if (onVar instanceof ir4) {
                ir4 ir4Var = (ir4) onVar;
                if (ir4Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && ir4Var.t.getThreadAlaInfo() != null && ((ThreadData) onVar).getThreadAlaInfo().user_info != null && ir4Var.t.getThreadAlaInfo().user_info.is_official == 2 && ir4Var.t.getThreadAlaInfo().liveStageForceTop) {
                    i = i2;
                    break;
                }
            } else {
                if (onVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) onVar;
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
                on onVar2 = this.threadList.get(i3);
                if (onVar2 instanceof ir4) {
                    if (((ir4) onVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        i = i3;
                        break;
                    }
                } else {
                    if ((onVar2 instanceof ThreadData) && ((ThreadData) onVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
        List<on> headLineDataInThreadList = getHeadLineDataInThreadList();
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

    public void filterEnterList(List<nj8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        Iterator<nj8> it = list.iterator();
        while (it.hasNext()) {
            nj8 next = it.next();
            if (next == null) {
                it.remove();
            } else if (StringUtils.isNull(next.h()) || StringUtils.isNull(next.f())) {
                if (next.a() != 1) {
                    it.remove();
                }
            }
        }
    }

    public ne6 getBrandAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.brandAdData : (ne6) invokeV.objValue;
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
            ArrayList<on> threadList = getThreadList();
            if (threadList == null || threadList.size() <= 0) {
                return 0;
            }
            int size = threadList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (threadList.get(i2) instanceof dq4) {
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

    @Override // com.repackage.qj8
    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.recm_forum_list : (List) invokeV.objValue;
    }

    public List<on> getShowTopThreadList() {
        InterceptResult invokeV;
        List<nj8> list;
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
                arrayList.add(new uj8(forum, this.forumRule));
            }
            if (forum != null && !pi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new tj8(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new tj8(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<on> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    on onVar = (on) ListUtils.getItem(topThreadList, i4);
                    if (onVar instanceof ir4) {
                        ir4 ir4Var = (ir4) onVar;
                        arrayList.add(ir4Var.t);
                        if (ir4Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (onVar instanceof ThreadData) {
                            arrayList.add(onVar);
                            if (((ThreadData) onVar).getIsMemberTop() != 1 || z) {
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
            ArrayList<on> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<on> it = arrayList.iterator();
            while (it.hasNext()) {
                on next = it.next();
                if (next != null && (next instanceof ir4)) {
                    ir4 ir4Var = (ir4) next;
                    if (TextUtils.equals(str, ir4Var.t.getId())) {
                        return ir4Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public List<on> getTopThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.topThreadList : (List) invokeV.objValue;
    }

    public int getTopThreadSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ArrayList<on> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<on> it = this.threadList.iterator();
                while (it.hasNext()) {
                    on next = it.next();
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
            sj8 entelechyTabInfo = getEntelechyTabInfo();
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

    public boolean receiveData(qj8 qj8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, qj8Var)) == null) {
            if (qj8Var == null) {
                return false;
            }
            this.isFromCache = qj8Var.isFromCache;
            setBaWuNoticeNum(qj8Var.getBaWuNoticeNum());
            setSortType(qj8Var.getSortType());
            setAnti(qj8Var.getAnti());
            setChatGroup(qj8Var.getChatGroup());
            setFortuneBag(qj8Var.isFortuneBag());
            setFortuneDesc(qj8Var.getFortuneDesc());
            setForum(qj8Var.getForum());
            setGameName(qj8Var.getGameName());
            setGameUrl(qj8Var.getGameUrl());
            setGconAccount(qj8Var.getGconAccount());
            setHasGame(qj8Var.isHasGame());
            setIsNewUrl(qj8Var.getIsNewUrl());
            setPhotoLivePos(qj8Var.getPhotoLivePos());
            setPage(qj8Var.getPage());
            setStar(qj8Var.getStar());
            setStarEnter(qj8Var.getStarEnter());
            setThreadList(qj8Var.threadList);
            setThreadListIds(qj8Var.getThreadListIds());
            setUserData(qj8Var.getUserData());
            setUserMap(qj8Var.getUserMap());
            setActivityHeadData(qj8Var.getActivityHeadData());
            setFrsDefaultTabId(qj8Var.getFrsDefaultTabId());
            this.defaultShowTab = qj8Var.defaultShowTab;
            setCategoryInfos(qj8Var.getCategoryInfos());
            setBawuCenterUrl(qj8Var.getBawuCenterUrl());
            setCardVideoInfo(qj8Var.getCardVideoInfo());
            setHeadSdkData(qj8Var.getHeadSdkData());
            setSchoolRecommendPos(qj8Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(qj8Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(qj8Var.getEntelechyTabInfo());
            setAlaLiveCount(qj8Var.getAlaLiveCount());
            setCarrierEnterData(qj8Var.getCarrierEnterData());
            setForumState(qj8Var.getForumState());
            setAccessFlag(qj8Var.getAccessFlag());
            this.needLog = qj8Var.needLog;
            this.recommendBookData = qj8Var.recommendBookData;
            this.presentInfoData = qj8Var.presentInfoData;
            setBookInfo(qj8Var.getBookInfo());
            setMangaReadRecordChapterId(qj8Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(qj8Var.getHeadlineImgInfoData());
            setCardShipinPos(qj8Var.getCardShipinPos());
            setCardShipinNew(qj8Var.getCardShipinNew());
            this.enterFrsDialogInfo = qj8Var.enterFrsDialogInfo;
            setGameRankListData(qj8Var.getGameRankListData());
            setAgreeBanner(qj8Var.getAgreeBanner());
            setLiveNotify(qj8Var.getLiveNotify());
            setGameTabInfo(qj8Var.getGameTabInfo());
            setGameDefaultTabId(qj8Var.getGameDefaultTabId());
            setForumHeadIcon(qj8Var.getForumHeadIcon());
            setUserRecommend(qj8Var.getUserRecommend());
            setFrsVideoActivityData(qj8Var.getFrsVideoActivityData());
            this.mNewChapterInfo = qj8Var.mNewChapterInfo;
            setFrsInsertLiveData(qj8Var.getFrsInsertLiveData());
            this.recm_forum_list = qj8Var.getRecm_forum_list();
            setFrsStageLiveData(qj8Var.getFrsStageLiveData());
            this.forumArIno = qj8Var.forumArIno;
            this.starRank = qj8Var.starRank;
            this.postTopic = qj8Var.postTopic;
            this.mWindowToast = qj8Var.mWindowToast;
            this.activityConfig = qj8Var.activityConfig;
            setIsShowRedTip(qj8Var.isShowRedTip());
            this.isBrandForum = qj8Var.isBrandForum;
            this.brandAdData = qj8Var.brandAdData;
            this.oriForumInfoList = qj8Var.oriForumInfoList;
            this.bottomMenuList = qj8Var.bottomMenuList;
            this.adMixFloor = qj8Var.adMixFloor;
            this.adShowSelect = qj8Var.adShowSelect;
            this.adSampleMapKey = qj8Var.adSampleMapKey;
            le6.f().n(getAnti());
            le6.f().q(qj8Var.getForum().getId());
            le6.f().r(qj8Var.getForum().getName());
            ke6.h().q(qj8Var.getForum().getId());
            if (qj8Var.getEntelechyTabInfo() != null) {
                ke6.h().r(qj8Var.getEntelechyTabInfo().a);
            }
            if (qj8Var.getUserData() != null) {
                me6.c().e(qj8Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(qj8Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(qj8Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = qj8Var.smartAppAvatar;
            this.smartApp = qj8Var.smartApp;
            this.nebulaHotThreads = qj8Var.nebulaHotThreads;
            this.forumActiveInfo = qj8Var.forumActiveInfo;
            this.userList = qj8Var.userList;
            setBusinessPromot(qj8Var.getBusinessPromot());
            this.serviceAreaData = qj8Var.serviceAreaData;
            setHotUserRankData(qj8Var.getHotUserRankData());
            this.itemInfo = qj8Var.itemInfo;
            this.toLoadHorseData = qj8Var.toLoadHorseData;
            this.forumRule = qj8Var.forumRule;
            this.mSignActivityInfo = qj8Var.mSignActivityInfo;
            this.showAdsense = qj8Var.showAdsense;
            setVoiceRoomConfig(qj8Var.getVoiceRoomConfig());
            setVoiceRoomData(qj8Var.getVoiceRoomData());
            this.serviceAreaFlutterData = qj8Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = qj8Var.liveFuseForumDataList;
            this.forumTagInfo = qj8Var.forumTagInfo;
            this.firstCategory = qj8Var.firstCategory;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void removeAlaInsertLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            removeTopSameClassDataFromList(jj8.class, getThreadList());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<on> arrayList;
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
            removeTopSameClassDataFromList(kj8.class, getThreadList());
        }
    }

    public void removeGameRankListFromThreadList() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<on> it = this.threadList.iterator();
        while (it.hasNext()) {
            on next = it.next();
            if (next != null && next.getType() == it6.e) {
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
        Iterator<on> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof gf6) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void removeThread(String str) {
        ArrayList<on> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, str) == null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<on> it = arrayList.iterator();
        while (it.hasNext()) {
            on next = it.next();
            if (next != null && (next instanceof ir4) && TextUtils.equals(str, ((ir4) next).t.getId())) {
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

    public void setFunAdController(ys6 ys6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, ys6Var) == null) {
            this.funAdController = ys6Var;
        }
    }

    public void setTopThreadList(List<on> list) {
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
        Iterator<on> it = this.threadList.iterator();
        while (it.hasNext()) {
            on next = it.next();
            if (next != null && (next instanceof ir4)) {
                ir4 ir4Var = (ir4) next;
                if (ir4Var.t.getAuthor() != null && currentAccount.equals(ir4Var.t.getAuthor().getUserId()) && ir4Var.t.getAuthor().getPendantData() != null) {
                    ir4Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                    ir4Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                }
            }
        }
    }

    public void updateLikeData(gj8 gj8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, gj8Var) == null) || gj8Var == null) {
            return;
        }
        bk8 bk8Var = new bk8();
        bk8Var.x(1);
        bk8Var.y(gj8Var.a);
        bk8Var.v(gj8Var.b);
        bk8Var.t(gj8Var.c);
        bk8Var.w(gj8Var.d);
        updateLikeData(bk8Var);
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

    public void addRecommendAppToThreadList(gk5 gk5Var, ArrayList<on> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, gk5Var, arrayList) == null) {
            addRecommendAppToThreadList(gk5Var, false, arrayList, null, false);
        }
    }

    public void addRecommendAppToThreadList(gk5 gk5Var, boolean z, ArrayList<on> arrayList, ArrayList<on> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{gk5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
            ok5 ok5Var = new ok5(gk5Var, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.setFromFrs(true);
                next.setSortType(getSortType());
                arrayList3.add(next);
            }
            ok5Var.s(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ok5Var));
            ok5 ok5Var2 = new ok5(gk5Var, 3);
            ok5Var2.z(z);
            ok5Var2.G(arrayList);
            ok5Var2.D(arrayList2);
            ok5Var2.y(z2);
            ok5Var2.t(getPage().a());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ok5Var2));
        }
    }

    public void updateLikeData(bk8 bk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, bk8Var) == null) || bk8Var == null) {
            return;
        }
        this.forum.setCurScore(bk8Var.c());
        this.forum.setLevelupScore(bk8Var.i());
        this.forum.setLike(bk8Var.m());
        this.forum.setUser_level(bk8Var.l());
        this.forum.setLevelName(bk8Var.h());
    }
}
