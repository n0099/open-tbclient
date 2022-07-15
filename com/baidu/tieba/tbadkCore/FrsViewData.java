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
import com.repackage.ah8;
import com.repackage.bh8;
import com.repackage.bj5;
import com.repackage.bq4;
import com.repackage.dh8;
import com.repackage.fh8;
import com.repackage.gh8;
import com.repackage.gr6;
import com.repackage.hh8;
import com.repackage.ih8;
import com.repackage.jh8;
import com.repackage.lp4;
import com.repackage.n75;
import com.repackage.ng;
import com.repackage.nn;
import com.repackage.od6;
import com.repackage.oh8;
import com.repackage.oi;
import com.repackage.op4;
import com.repackage.qh8;
import com.repackage.qq4;
import com.repackage.qr6;
import com.repackage.sc6;
import com.repackage.tc6;
import com.repackage.tg8;
import com.repackage.ti5;
import com.repackage.uc6;
import com.repackage.vc6;
import com.repackage.wg8;
import com.repackage.xg8;
import com.repackage.xh8;
import com.repackage.xt4;
import com.repackage.zy5;
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
public class FrsViewData extends dh8 implements n75, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public gr6 funAdController;
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

    private List<nn> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        op4 op4Var;
        ArrayList<nn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<nn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (op4Var = this.page) != null && op4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    nn nnVar = this.threadList.get(i);
                    if (nnVar instanceof qq4) {
                        if (((qq4) nnVar).s.isHeadLinePost) {
                            arrayList2.add(nnVar);
                        }
                    } else if ((nnVar instanceof ThreadData) && ((ThreadData) nnVar).isHeadLinePost) {
                        arrayList2.add(nnVar);
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
            Iterator<nn> it = this.threadList.iterator();
            while (it.hasNext()) {
                nn next = it.next();
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<nn> arrayList) {
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
            nn nnVar = arrayList.get(i);
            if (nnVar.getClass() == cls) {
                arrayList2.add(nnVar);
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
        ArrayList<nn> threadList = getThreadList();
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
            nn nnVar = this.threadList.get(i2);
            if (nnVar instanceof qq4) {
                ThreadData threadData = ((qq4) nnVar).s;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (feedForumList = this.forum.getBannerListData().getFeedForumList()) == null || feedForumList.size() <= 0) {
            return;
        }
        bh8 bh8Var = new bh8();
        bh8Var.d(this.forum.getId());
        bh8Var.c(feedForumList);
        this.threadList.add(i + 6, bh8Var);
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
            nn nnVar = this.threadList.get(i2);
            if (nnVar instanceof qq4) {
                ThreadData threadData = ((qq4) nnVar).s;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String q = xt4.k().q("game_rank_list_info", "");
        if (!StringUtils.isNull(q) && q.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(ng.g(q.split(",")[0], 0L), System.currentTimeMillis()) < ng.e(q.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int l = xt4.k().l("game_rank_list_show_times", 0);
                    if (!z) {
                        l++;
                    }
                    xt4.k().w("game_rank_list_show_times", l);
                    if (l > 3) {
                        xt4 k = xt4.k();
                        k.y("game_rank_list_info", System.currentTimeMillis() + ",1");
                        xt4.k().w("game_rank_list_show_times", 0);
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
        zy5 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    nn nnVar = this.threadList.get(i2);
                    if (nnVar instanceof qq4) {
                        ThreadData threadData = ((qq4) nnVar).s;
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
        wg8 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsInsertLiveData = getFrsInsertLiveData()) == null) {
            return;
        }
        ArrayList<nn> threadList = getThreadList();
        removeTopSameClassDataFromList(wg8.class, threadList);
        threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.b, threadList.size()), frsInsertLiveData);
    }

    public void addMyNewThread(lp4 lp4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, lp4Var) == null) || lp4Var == null || StringUtils.isNull(lp4Var.getId()) || this.threadList == null) {
            return;
        }
        int topThreadSize = getTopThreadSize();
        ArrayList<nn> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            for (int i = 0; i < size; i++) {
                nn nnVar = threadList.get(i);
                if ((nnVar instanceof qq4) && lp4Var.getId().equals(((qq4) nnVar).s.getId()) && lp4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                    return;
                }
            }
        }
        lp4Var.isFromBrandForum = this.isBrandForum;
        this.postThreadCount++;
        this.threadList.add(topThreadSize, lp4Var);
    }

    public void addNoticeThreadToThreadList() {
        TopNoticeData top_notice_data;
        nn nnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getForum() == null || this.threadList == null || (top_notice_data = getForum().getTop_notice_data()) == null || top_notice_data.getTitle() == null) {
            return;
        }
        while (!this.threadList.isEmpty() && (nnVar = this.threadList.get(0)) != null && (nnVar instanceof qq4) && ((ThreadData) nnVar).getIs_top() == 2) {
            this.threadList.remove(0);
        }
        ThreadData threadData = new ThreadData();
        threadData.setTitle(top_notice_data.getTitle());
        threadData.setTid(top_notice_data.getTitle_link());
        threadData.setIs_top(2);
        threadData.parser_title();
        qq4 qq4Var = new qq4();
        qq4Var.s = threadData;
        this.threadList.add(0, qq4Var);
    }

    public void addOfficialBarToThreadList() {
        op4 op4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.forum == null || this.threadList == null || !ThreadData.isFRSExtraLoaded.get() || (op4Var = this.page) == null) {
            return;
        }
        boolean z = true;
        if (op4Var.a() == 1) {
            jh8 jh8Var = this.gconAccount;
            z = (jh8Var == null || !jh8Var.b()) ? false : false;
            if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof qh8)) {
                    this.threadList.remove(0);
                }
                qh8 qh8Var = new qh8();
                qh8Var.i(this.fortuneBag);
                qh8Var.k(this.fortuneDesc);
                qh8Var.m(this.gconAccount);
                qh8Var.setIs_top(1003);
                ArrayList<nn> arrayList = this.threadList;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                ListUtils.add(this.threadList, getTopThreadSize(), qh8Var);
            }
        }
    }

    public void addRecommendAppToThreadList(ti5 ti5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ti5Var) == null) {
            addRecommendAppToThreadList(ti5Var, false, this.threadList, null, false);
        }
    }

    public void addRecommendBarsToThreadList() {
        ArrayList<nn> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.forum == null || (arrayList = this.threadList) == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<nn> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof bq4) {
                it.remove();
            }
        }
        op4 op4Var = this.page;
        if (op4Var == null || op4Var.a() != 1) {
            return;
        }
        ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
        bq4 bq4Var = new bq4();
        if (recommendForumData != null) {
            bq4Var.c().addAll(recommendForumData);
        }
        if (isShowRecommendBars(bq4Var.c())) {
            int i = 0;
            Iterator<nn> it2 = this.threadList.iterator();
            while (it2.hasNext()) {
                nn next = it2.next();
                if ((next instanceof qq4) && ((qq4) next).s.isTop()) {
                    i++;
                }
            }
            this.threadList.add(i + 1, bq4Var);
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
        xg8 frsStageLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsStageLiveData = getFrsStageLiveData()) == null) {
            return;
        }
        ArrayList<nn> threadList = getThreadList();
        removeTopSameClassDataFromList(xg8.class, threadList);
        if (ListUtils.isEmpty(frsStageLiveData.a)) {
            return;
        }
        threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
    }

    public void addU9DataToThreadList() {
        ForumData forumData;
        op4 op4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (forumData = this.forum) == null) {
            return;
        }
        if (((forumData.getTopCode() == null || StringUtils.isNull(this.forum.getTopCode().g())) && (this.forum.getNewsInfo() == null || StringUtils.isNull(this.forum.getNewsInfo().R0()))) || (op4Var = this.page) == null || op4Var.a() != 1) {
            return;
        }
        xh8 xh8Var = new xh8();
        xh8Var.k(this.forum.getTopCode());
        xh8Var.m(this.forum.getNewsInfo());
        xh8Var.setIs_top(3);
        xh8Var.i(true);
        if (ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<nn> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            nn next = it.next();
            if (next instanceof ThreadData) {
                ThreadData threadData = (ThreadData) next;
                if (threadData.getIs_top() != 0) {
                    if (threadData.getIs_top() == 1003) {
                        xh8Var.i(false);
                    }
                    i++;
                }
            }
        }
        this.threadList.add(i, xh8Var);
    }

    public void addUserRecommendToThreadList() {
        int a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || getUserRecommend() == null) {
            return;
        }
        od6 userRecommend = getUserRecommend();
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
        Iterator<nn> it = this.threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            nn next = it.next();
            if (next != null && next.getType() == ih8.c) {
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
        List<nn> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<nn> threadList = getThreadList();
        if (cardShipinPos == null || cardShipinPos.size() <= 0 || cardShipinNew == null || cardShipinNew.size() <= 0 || threadList == null) {
            return;
        }
        int size = cardShipinPos.size();
        int size2 = threadList.size();
        for (int i = 0; i < size; i++) {
            if (i < cardShipinNew.size()) {
                nn nnVar = cardShipinNew.get(i);
                int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + nnVar.getType());
                threadList.add(videoThreadInserPos, nnVar);
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<nn> arrayList;
        op4 op4Var;
        ArrayList<nn> arrayList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (arrayList = this.threadList) == null || arrayList.size() <= 0 || (op4Var = this.page) == null || op4Var.a() != 1 || (arrayList2 = this.threadList) == null || arrayList2.size() <= 0) {
            return;
        }
        int i = -1;
        int size = this.threadList.size();
        for (int i2 = 0; i2 < size; i2++) {
            nn nnVar = this.threadList.get(i2);
            if (nnVar instanceof qq4) {
                qq4 qq4Var = (qq4) nnVar;
                if (qq4Var.s.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && qq4Var.s.getThreadAlaInfo() != null && ((ThreadData) nnVar).getThreadAlaInfo().user_info != null && qq4Var.s.getThreadAlaInfo().user_info.is_official == 2 && qq4Var.s.getThreadAlaInfo().liveStageForceTop) {
                    i = i2;
                    break;
                }
            } else {
                if (nnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) nnVar;
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
                nn nnVar2 = this.threadList.get(i3);
                if (nnVar2 instanceof qq4) {
                    if (((qq4) nnVar2).s.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        i = i3;
                        break;
                    }
                } else {
                    if ((nnVar2 instanceof ThreadData) && ((ThreadData) nnVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
        List<nn> headLineDataInThreadList = getHeadLineDataInThreadList();
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

    public void filterEnterList(List<ah8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        Iterator<ah8> it = list.iterator();
        while (it.hasNext()) {
            ah8 next = it.next();
            if (next == null) {
                it.remove();
            } else if (StringUtils.isNull(next.h()) || StringUtils.isNull(next.d())) {
                if (next.a() != 1) {
                    it.remove();
                }
            }
        }
    }

    public vc6 getBrandAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.brandAdData : (vc6) invokeV.objValue;
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
            ArrayList<nn> threadList = getThreadList();
            if (threadList == null || threadList.size() <= 0) {
                return 0;
            }
            int size = threadList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (threadList.get(i2) instanceof lp4) {
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

    @Override // com.repackage.dh8
    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.recm_forum_list : (List) invokeV.objValue;
    }

    public List<nn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<ah8> list;
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
                arrayList.add(new hh8(forum, this.forumRule));
            }
            if (forum != null && !oi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new gh8(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new gh8(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<nn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    nn nnVar = (nn) ListUtils.getItem(topThreadList, i4);
                    if (nnVar instanceof qq4) {
                        qq4 qq4Var = (qq4) nnVar;
                        arrayList.add(qq4Var.s);
                        if (qq4Var.s.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (nnVar instanceof ThreadData) {
                            arrayList.add(nnVar);
                            if (((ThreadData) nnVar).getIsMemberTop() != 1 || z) {
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
            ArrayList<nn> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<nn> it = arrayList.iterator();
            while (it.hasNext()) {
                nn next = it.next();
                if (next != null && (next instanceof qq4)) {
                    qq4 qq4Var = (qq4) next;
                    if (TextUtils.equals(str, qq4Var.s.getId())) {
                        return qq4Var.s;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public List<nn> getTopThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.topThreadList : (List) invokeV.objValue;
    }

    public int getTopThreadSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ArrayList<nn> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<nn> it = this.threadList.iterator();
                while (it.hasNext()) {
                    nn next = it.next();
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
            fh8 entelechyTabInfo = getEntelechyTabInfo();
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

    public boolean receiveData(dh8 dh8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, dh8Var)) == null) {
            if (dh8Var == null) {
                return false;
            }
            this.isFromCache = dh8Var.isFromCache;
            setBaWuNoticeNum(dh8Var.getBaWuNoticeNum());
            setSortType(dh8Var.getSortType());
            setAnti(dh8Var.getAnti());
            setChatGroup(dh8Var.getChatGroup());
            setFortuneBag(dh8Var.isFortuneBag());
            setFortuneDesc(dh8Var.getFortuneDesc());
            setForum(dh8Var.getForum());
            setGameName(dh8Var.getGameName());
            setGameUrl(dh8Var.getGameUrl());
            setGconAccount(dh8Var.getGconAccount());
            setHasGame(dh8Var.isHasGame());
            setIsNewUrl(dh8Var.getIsNewUrl());
            setPhotoLivePos(dh8Var.getPhotoLivePos());
            setPage(dh8Var.getPage());
            setStar(dh8Var.getStar());
            setStarEnter(dh8Var.getStarEnter());
            setThreadList(dh8Var.threadList);
            setThreadListIds(dh8Var.getThreadListIds());
            setUserData(dh8Var.getUserData());
            setUserMap(dh8Var.getUserMap());
            setActivityHeadData(dh8Var.getActivityHeadData());
            setFrsDefaultTabId(dh8Var.getFrsDefaultTabId());
            this.defaultShowTab = dh8Var.defaultShowTab;
            setCategoryInfos(dh8Var.getCategoryInfos());
            setBawuCenterUrl(dh8Var.getBawuCenterUrl());
            setCardVideoInfo(dh8Var.getCardVideoInfo());
            setHeadSdkData(dh8Var.getHeadSdkData());
            setSchoolRecommendPos(dh8Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(dh8Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(dh8Var.getEntelechyTabInfo());
            setAlaLiveCount(dh8Var.getAlaLiveCount());
            setCarrierEnterData(dh8Var.getCarrierEnterData());
            setForumState(dh8Var.getForumState());
            setAccessFlag(dh8Var.getAccessFlag());
            this.needLog = dh8Var.needLog;
            this.recommendBookData = dh8Var.recommendBookData;
            this.presentInfoData = dh8Var.presentInfoData;
            setBookInfo(dh8Var.getBookInfo());
            setMangaReadRecordChapterId(dh8Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(dh8Var.getHeadlineImgInfoData());
            setCardShipinPos(dh8Var.getCardShipinPos());
            setCardShipinNew(dh8Var.getCardShipinNew());
            this.enterFrsDialogInfo = dh8Var.enterFrsDialogInfo;
            setGameRankListData(dh8Var.getGameRankListData());
            setAgreeBanner(dh8Var.getAgreeBanner());
            setLiveNotify(dh8Var.getLiveNotify());
            setGameTabInfo(dh8Var.getGameTabInfo());
            setGameDefaultTabId(dh8Var.getGameDefaultTabId());
            setForumHeadIcon(dh8Var.getForumHeadIcon());
            setUserRecommend(dh8Var.getUserRecommend());
            setFrsVideoActivityData(dh8Var.getFrsVideoActivityData());
            this.mNewChapterInfo = dh8Var.mNewChapterInfo;
            setFrsInsertLiveData(dh8Var.getFrsInsertLiveData());
            this.recm_forum_list = dh8Var.getRecm_forum_list();
            setFrsStageLiveData(dh8Var.getFrsStageLiveData());
            this.forumArIno = dh8Var.forumArIno;
            this.starRank = dh8Var.starRank;
            this.postTopic = dh8Var.postTopic;
            this.mWindowToast = dh8Var.mWindowToast;
            this.activityConfig = dh8Var.activityConfig;
            setIsShowRedTip(dh8Var.isShowRedTip());
            this.isBrandForum = dh8Var.isBrandForum;
            this.brandAdData = dh8Var.brandAdData;
            this.oriForumInfoList = dh8Var.oriForumInfoList;
            this.bottomMenuList = dh8Var.bottomMenuList;
            this.adMixFloor = dh8Var.adMixFloor;
            this.adShowSelect = dh8Var.adShowSelect;
            this.adSampleMapKey = dh8Var.adSampleMapKey;
            tc6.f().n(getAnti());
            tc6.f().q(dh8Var.getForum().getId());
            tc6.f().r(dh8Var.getForum().getName());
            sc6.h().q(dh8Var.getForum().getId());
            if (dh8Var.getEntelechyTabInfo() != null) {
                sc6.h().r(dh8Var.getEntelechyTabInfo().a);
            }
            if (dh8Var.getUserData() != null) {
                uc6.c().e(dh8Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(dh8Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(dh8Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = dh8Var.smartAppAvatar;
            this.smartApp = dh8Var.smartApp;
            this.nebulaHotThreads = dh8Var.nebulaHotThreads;
            this.forumActiveInfo = dh8Var.forumActiveInfo;
            this.userList = dh8Var.userList;
            setBusinessPromot(dh8Var.getBusinessPromot());
            this.serviceAreaData = dh8Var.serviceAreaData;
            setHotUserRankData(dh8Var.getHotUserRankData());
            this.itemInfo = dh8Var.itemInfo;
            this.toLoadHorseData = dh8Var.toLoadHorseData;
            this.forumRule = dh8Var.forumRule;
            this.mSignActivityInfo = dh8Var.mSignActivityInfo;
            this.showAdsense = dh8Var.showAdsense;
            setVoiceRoomConfig(dh8Var.getVoiceRoomConfig());
            setVoiceRoomData(dh8Var.getVoiceRoomData());
            this.serviceAreaFlutterData = dh8Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = dh8Var.liveFuseForumDataList;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void removeAlaInsertLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            removeTopSameClassDataFromList(wg8.class, getThreadList());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<nn> arrayList;
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
            removeTopSameClassDataFromList(xg8.class, getThreadList());
        }
    }

    public void removeGameRankListFromThreadList() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<nn> it = this.threadList.iterator();
        while (it.hasNext()) {
            nn next = it.next();
            if (next != null && next.getType() == qr6.e) {
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
        Iterator<nn> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof od6) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void removeThread(String str) {
        ArrayList<nn> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, str) == null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<nn> it = arrayList.iterator();
        while (it.hasNext()) {
            nn next = it.next();
            if (next != null && (next instanceof qq4) && TextUtils.equals(str, ((qq4) next).s.getId())) {
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

    public void setFunAdController(gr6 gr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, gr6Var) == null) {
            this.funAdController = gr6Var;
        }
    }

    public void setTopThreadList(List<nn> list) {
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
        Iterator<nn> it = this.threadList.iterator();
        while (it.hasNext()) {
            nn next = it.next();
            if (next != null && (next instanceof qq4)) {
                qq4 qq4Var = (qq4) next;
                if (qq4Var.s.getAuthor() != null && currentAccount.equals(qq4Var.s.getAuthor().getUserId()) && qq4Var.s.getAuthor().getPendantData() != null) {
                    qq4Var.s.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                    qq4Var.s.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                }
            }
        }
    }

    public void updateLikeData(tg8 tg8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, tg8Var) == null) || tg8Var == null) {
            return;
        }
        oh8 oh8Var = new oh8();
        oh8Var.y(1);
        oh8Var.z(tg8Var.a);
        oh8Var.w(tg8Var.b);
        oh8Var.u(tg8Var.c);
        oh8Var.x(tg8Var.d);
        updateLikeData(oh8Var);
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

    public void addRecommendAppToThreadList(ti5 ti5Var, ArrayList<nn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, ti5Var, arrayList) == null) {
            addRecommendAppToThreadList(ti5Var, false, arrayList, null, false);
        }
    }

    public void addRecommendAppToThreadList(ti5 ti5Var, boolean z, ArrayList<nn> arrayList, ArrayList<nn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{ti5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
            bj5 bj5Var = new bj5(ti5Var, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.setFromFrs(true);
                next.setSortType(getSortType());
                arrayList3.add(next);
            }
            bj5Var.r(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bj5Var));
            bj5 bj5Var2 = new bj5(ti5Var, 3);
            bj5Var2.x(z);
            bj5Var2.E(arrayList);
            bj5Var2.B(arrayList2);
            bj5Var2.w(z2);
            bj5Var2.s(getPage().a());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bj5Var2));
        }
    }

    public void updateLikeData(oh8 oh8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, oh8Var) == null) || oh8Var == null) {
            return;
        }
        this.forum.setCurScore(oh8Var.c());
        this.forum.setLevelupScore(oh8Var.i());
        this.forum.setLike(oh8Var.n());
        this.forum.setUser_level(oh8Var.m());
        this.forum.setLevelName(oh8Var.h());
    }
}
