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
import com.repackage.bg8;
import com.repackage.bq4;
import com.repackage.cg8;
import com.repackage.ch8;
import com.repackage.cr6;
import com.repackage.cy5;
import com.repackage.fg8;
import com.repackage.gg8;
import com.repackage.ht4;
import com.repackage.ig8;
import com.repackage.kg8;
import com.repackage.l65;
import com.repackage.lg8;
import com.repackage.mg8;
import com.repackage.mp4;
import com.repackage.ng;
import com.repackage.ng8;
import com.repackage.nn;
import com.repackage.og8;
import com.repackage.oi;
import com.repackage.qh5;
import com.repackage.rc6;
import com.repackage.tg8;
import com.repackage.uq6;
import com.repackage.vb6;
import com.repackage.vg8;
import com.repackage.wb6;
import com.repackage.wo4;
import com.repackage.xb6;
import com.repackage.yb6;
import com.repackage.yf8;
import com.repackage.yh5;
import com.repackage.zo4;
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
public class FrsViewData extends ig8 implements l65, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public uq6 funAdController;
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
        zo4 zo4Var;
        ArrayList<nn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<nn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (zo4Var = this.page) != null && zo4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    nn nnVar = this.threadList.get(i);
                    if (nnVar instanceof bq4) {
                        if (((bq4) nnVar).s.isHeadLinePost) {
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
            if (nnVar instanceof bq4) {
                ThreadData threadData = ((bq4) nnVar).s;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (feedForumList = this.forum.getBannerListData().getFeedForumList()) == null || feedForumList.size() <= 0) {
            return;
        }
        gg8 gg8Var = new gg8();
        gg8Var.f(this.forum.getId());
        gg8Var.c(feedForumList);
        this.threadList.add(i + 6, gg8Var);
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
            if (nnVar instanceof bq4) {
                ThreadData threadData = ((bq4) nnVar).s;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String q = ht4.k().q("game_rank_list_info", "");
        if (!StringUtils.isNull(q) && q.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(ng.g(q.split(",")[0], 0L), System.currentTimeMillis()) < ng.e(q.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int l = ht4.k().l("game_rank_list_show_times", 0);
                    if (!z) {
                        l++;
                    }
                    ht4.k().w("game_rank_list_show_times", l);
                    if (l > 3) {
                        ht4 k = ht4.k();
                        k.y("game_rank_list_info", System.currentTimeMillis() + ",1");
                        ht4.k().w("game_rank_list_show_times", 0);
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
        cy5 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    nn nnVar = this.threadList.get(i2);
                    if (nnVar instanceof bq4) {
                        ThreadData threadData = ((bq4) nnVar).s;
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
        bg8 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsInsertLiveData = getFrsInsertLiveData()) == null) {
            return;
        }
        ArrayList<nn> threadList = getThreadList();
        removeTopSameClassDataFromList(bg8.class, threadList);
        threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.b, threadList.size()), frsInsertLiveData);
    }

    public void addMyNewThread(wo4 wo4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, wo4Var) == null) || wo4Var == null || StringUtils.isNull(wo4Var.getId()) || this.threadList == null) {
            return;
        }
        int topThreadSize = getTopThreadSize();
        ArrayList<nn> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            for (int i = 0; i < size; i++) {
                nn nnVar = threadList.get(i);
                if ((nnVar instanceof bq4) && wo4Var.getId().equals(((bq4) nnVar).s.getId()) && wo4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                    return;
                }
            }
        }
        wo4Var.isFromBrandForum = this.isBrandForum;
        this.postThreadCount++;
        this.threadList.add(topThreadSize, wo4Var);
    }

    public void addNoticeThreadToThreadList() {
        TopNoticeData top_notice_data;
        nn nnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getForum() == null || this.threadList == null || (top_notice_data = getForum().getTop_notice_data()) == null || top_notice_data.getTitle() == null) {
            return;
        }
        while (!this.threadList.isEmpty() && (nnVar = this.threadList.get(0)) != null && (nnVar instanceof bq4) && ((ThreadData) nnVar).getIs_top() == 2) {
            this.threadList.remove(0);
        }
        ThreadData threadData = new ThreadData();
        threadData.setTitle(top_notice_data.getTitle());
        threadData.setTid(top_notice_data.getTitle_link());
        threadData.setIs_top(2);
        threadData.parser_title();
        bq4 bq4Var = new bq4();
        bq4Var.s = threadData;
        this.threadList.add(0, bq4Var);
    }

    public void addOfficialBarToThreadList() {
        zo4 zo4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.forum == null || this.threadList == null || !ThreadData.isFRSExtraLoaded.get() || (zo4Var = this.page) == null) {
            return;
        }
        boolean z = true;
        if (zo4Var.a() == 1) {
            og8 og8Var = this.gconAccount;
            z = (og8Var == null || !og8Var.b()) ? false : false;
            if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof vg8)) {
                    this.threadList.remove(0);
                }
                vg8 vg8Var = new vg8();
                vg8Var.j(this.fortuneBag);
                vg8Var.l(this.fortuneDesc);
                vg8Var.n(this.gconAccount);
                vg8Var.setIs_top(1003);
                ArrayList<nn> arrayList = this.threadList;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                ListUtils.add(this.threadList, getTopThreadSize(), vg8Var);
            }
        }
    }

    public void addRecommendAppToThreadList(qh5 qh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qh5Var) == null) {
            addRecommendAppToThreadList(qh5Var, false, this.threadList, null, false);
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
            if (it.next() instanceof mp4) {
                it.remove();
            }
        }
        zo4 zo4Var = this.page;
        if (zo4Var == null || zo4Var.a() != 1) {
            return;
        }
        ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
        mp4 mp4Var = new mp4();
        if (recommendForumData != null) {
            mp4Var.c().addAll(recommendForumData);
        }
        if (isShowRecommendBars(mp4Var.c())) {
            int i = 0;
            Iterator<nn> it2 = this.threadList.iterator();
            while (it2.hasNext()) {
                nn next = it2.next();
                if ((next instanceof bq4) && ((bq4) next).s.isTop()) {
                    i++;
                }
            }
            this.threadList.add(i + 1, mp4Var);
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
        cg8 frsStageLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsStageLiveData = getFrsStageLiveData()) == null) {
            return;
        }
        ArrayList<nn> threadList = getThreadList();
        removeTopSameClassDataFromList(cg8.class, threadList);
        if (ListUtils.isEmpty(frsStageLiveData.a)) {
            return;
        }
        threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
    }

    public void addU9DataToThreadList() {
        ForumData forumData;
        zo4 zo4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (forumData = this.forum) == null) {
            return;
        }
        if (((forumData.getTopCode() == null || StringUtils.isNull(this.forum.getTopCode().g())) && (this.forum.getNewsInfo() == null || StringUtils.isNull(this.forum.getNewsInfo().O0()))) || (zo4Var = this.page) == null || zo4Var.a() != 1) {
            return;
        }
        ch8 ch8Var = new ch8();
        ch8Var.l(this.forum.getTopCode());
        ch8Var.n(this.forum.getNewsInfo());
        ch8Var.setIs_top(3);
        ch8Var.j(true);
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
                        ch8Var.j(false);
                    }
                    i++;
                }
            }
        }
        this.threadList.add(i, ch8Var);
    }

    public void addUserRecommendToThreadList() {
        int a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || getUserRecommend() == null) {
            return;
        }
        rc6 userRecommend = getUserRecommend();
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
            if (next != null && next.getType() == ng8.c) {
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
        zo4 zo4Var;
        ArrayList<nn> arrayList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (arrayList = this.threadList) == null || arrayList.size() <= 0 || (zo4Var = this.page) == null || zo4Var.a() != 1 || (arrayList2 = this.threadList) == null || arrayList2.size() <= 0) {
            return;
        }
        int i = -1;
        int size = this.threadList.size();
        for (int i2 = 0; i2 < size; i2++) {
            nn nnVar = this.threadList.get(i2);
            if (nnVar instanceof bq4) {
                bq4 bq4Var = (bq4) nnVar;
                if (bq4Var.s.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && bq4Var.s.getThreadAlaInfo() != null && ((ThreadData) nnVar).getThreadAlaInfo().user_info != null && bq4Var.s.getThreadAlaInfo().user_info.is_official == 2 && bq4Var.s.getThreadAlaInfo().liveStageForceTop) {
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
                if (nnVar2 instanceof bq4) {
                    if (((bq4) nnVar2).s.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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

    public void filterEnterList(List<fg8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        Iterator<fg8> it = list.iterator();
        while (it.hasNext()) {
            fg8 next = it.next();
            if (next == null) {
                it.remove();
            } else if (StringUtils.isNull(next.h()) || StringUtils.isNull(next.f())) {
                if (next.a() != 1) {
                    it.remove();
                }
            }
        }
    }

    public yb6 getBrandAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.brandAdData : (yb6) invokeV.objValue;
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
                if (threadList.get(i2) instanceof wo4) {
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

    @Override // com.repackage.ig8
    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.recm_forum_list : (List) invokeV.objValue;
    }

    public List<nn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<fg8> list;
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
                arrayList.add(new mg8(forum, this.forumRule));
            }
            if (forum != null && !oi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new lg8(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new lg8(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<nn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    nn nnVar = (nn) ListUtils.getItem(topThreadList, i4);
                    if (nnVar instanceof bq4) {
                        bq4 bq4Var = (bq4) nnVar;
                        arrayList.add(bq4Var.s);
                        if (bq4Var.s.getIsMemberTop() != 1 || z) {
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
                if (next != null && (next instanceof bq4)) {
                    bq4 bq4Var = (bq4) next;
                    if (TextUtils.equals(str, bq4Var.s.getId())) {
                        return bq4Var.s;
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
            kg8 entelechyTabInfo = getEntelechyTabInfo();
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

    public boolean receiveData(ig8 ig8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, ig8Var)) == null) {
            if (ig8Var == null) {
                return false;
            }
            this.isFromCache = ig8Var.isFromCache;
            setSortType(ig8Var.getSortType());
            setAnti(ig8Var.getAnti());
            setChatGroup(ig8Var.getChatGroup());
            setFortuneBag(ig8Var.isFortuneBag());
            setFortuneDesc(ig8Var.getFortuneDesc());
            setForum(ig8Var.getForum());
            setGameName(ig8Var.getGameName());
            setGameUrl(ig8Var.getGameUrl());
            setGconAccount(ig8Var.getGconAccount());
            setHasGame(ig8Var.isHasGame());
            setIsNewUrl(ig8Var.getIsNewUrl());
            setPhotoLivePos(ig8Var.getPhotoLivePos());
            setPage(ig8Var.getPage());
            setStar(ig8Var.getStar());
            setStarEnter(ig8Var.getStarEnter());
            setThreadList(ig8Var.threadList);
            setThreadListIds(ig8Var.getThreadListIds());
            setUserData(ig8Var.getUserData());
            setUserMap(ig8Var.getUserMap());
            setActivityHeadData(ig8Var.getActivityHeadData());
            setFrsDefaultTabId(ig8Var.getFrsDefaultTabId());
            this.defaultShowTab = ig8Var.defaultShowTab;
            setCategoryInfos(ig8Var.getCategoryInfos());
            setBawuCenterUrl(ig8Var.getBawuCenterUrl());
            setCardVideoInfo(ig8Var.getCardVideoInfo());
            setHeadSdkData(ig8Var.getHeadSdkData());
            setSchoolRecommendPos(ig8Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(ig8Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(ig8Var.getEntelechyTabInfo());
            setAlaLiveCount(ig8Var.getAlaLiveCount());
            setCarrierEnterData(ig8Var.getCarrierEnterData());
            setForumState(ig8Var.getForumState());
            setAccessFlag(ig8Var.getAccessFlag());
            this.needLog = ig8Var.needLog;
            this.recommendBookData = ig8Var.recommendBookData;
            this.presentInfoData = ig8Var.presentInfoData;
            setBookInfo(ig8Var.getBookInfo());
            setMangaReadRecordChapterId(ig8Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(ig8Var.getHeadlineImgInfoData());
            setCardShipinPos(ig8Var.getCardShipinPos());
            setCardShipinNew(ig8Var.getCardShipinNew());
            this.enterFrsDialogInfo = ig8Var.enterFrsDialogInfo;
            setGameRankListData(ig8Var.getGameRankListData());
            setAgreeBanner(ig8Var.getAgreeBanner());
            setLiveNotify(ig8Var.getLiveNotify());
            setGameTabInfo(ig8Var.getGameTabInfo());
            setGameDefaultTabId(ig8Var.getGameDefaultTabId());
            setForumHeadIcon(ig8Var.getForumHeadIcon());
            setUserRecommend(ig8Var.getUserRecommend());
            setFrsVideoActivityData(ig8Var.getFrsVideoActivityData());
            this.mNewChapterInfo = ig8Var.mNewChapterInfo;
            setFrsInsertLiveData(ig8Var.getFrsInsertLiveData());
            this.recm_forum_list = ig8Var.getRecm_forum_list();
            setFrsStageLiveData(ig8Var.getFrsStageLiveData());
            this.forumArIno = ig8Var.forumArIno;
            this.starRank = ig8Var.starRank;
            this.postTopic = ig8Var.postTopic;
            this.mWindowToast = ig8Var.mWindowToast;
            this.activityConfig = ig8Var.activityConfig;
            setIsShowRedTip(ig8Var.isShowRedTip());
            this.isBrandForum = ig8Var.isBrandForum;
            this.brandAdData = ig8Var.brandAdData;
            this.oriForumInfoList = ig8Var.oriForumInfoList;
            this.bottomMenuList = ig8Var.bottomMenuList;
            this.adMixFloor = ig8Var.adMixFloor;
            this.adShowSelect = ig8Var.adShowSelect;
            this.adSampleMapKey = ig8Var.adSampleMapKey;
            wb6.f().n(getAnti());
            wb6.f().q(ig8Var.getForum().getId());
            wb6.f().r(ig8Var.getForum().getName());
            vb6.h().q(ig8Var.getForum().getId());
            if (ig8Var.getEntelechyTabInfo() != null) {
                vb6.h().r(ig8Var.getEntelechyTabInfo().a);
            }
            if (ig8Var.getUserData() != null) {
                xb6.c().e(ig8Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(ig8Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(ig8Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = ig8Var.smartAppAvatar;
            this.smartApp = ig8Var.smartApp;
            this.nebulaHotThreads = ig8Var.nebulaHotThreads;
            this.forumActiveInfo = ig8Var.forumActiveInfo;
            this.userList = ig8Var.userList;
            setBusinessPromot(ig8Var.getBusinessPromot());
            this.serviceAreaData = ig8Var.serviceAreaData;
            setHotUserRankData(ig8Var.getHotUserRankData());
            this.itemInfo = ig8Var.itemInfo;
            this.toLoadHorseData = ig8Var.toLoadHorseData;
            this.forumRule = ig8Var.forumRule;
            this.mSignActivityInfo = ig8Var.mSignActivityInfo;
            this.showAdsense = ig8Var.showAdsense;
            setVoiceRoomConfig(ig8Var.getVoiceRoomConfig());
            setVoiceRoomData(ig8Var.getVoiceRoomData());
            this.serviceAreaFlutterData = ig8Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = ig8Var.liveFuseForumDataList;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void removeAlaInsertLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            removeTopSameClassDataFromList(bg8.class, getThreadList());
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
            removeTopSameClassDataFromList(cg8.class, getThreadList());
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
            if (next != null && next.getType() == cr6.e) {
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
            if (it.next() instanceof rc6) {
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
            if (next != null && (next instanceof bq4) && TextUtils.equals(str, ((bq4) next).s.getId())) {
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

    public void setFunAdController(uq6 uq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, uq6Var) == null) {
            this.funAdController = uq6Var;
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
            if (next != null && (next instanceof bq4)) {
                bq4 bq4Var = (bq4) next;
                if (bq4Var.s.getAuthor() != null && currentAccount.equals(bq4Var.s.getAuthor().getUserId()) && bq4Var.s.getAuthor().getPendantData() != null) {
                    bq4Var.s.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                    bq4Var.s.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                }
            }
        }
    }

    public void updateLikeData(yf8 yf8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, yf8Var) == null) || yf8Var == null) {
            return;
        }
        tg8 tg8Var = new tg8();
        tg8Var.y(1);
        tg8Var.z(yf8Var.a);
        tg8Var.w(yf8Var.b);
        tg8Var.u(yf8Var.c);
        tg8Var.x(yf8Var.d);
        updateLikeData(tg8Var);
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

    public void addRecommendAppToThreadList(qh5 qh5Var, ArrayList<nn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, qh5Var, arrayList) == null) {
            addRecommendAppToThreadList(qh5Var, false, arrayList, null, false);
        }
    }

    public void addRecommendAppToThreadList(qh5 qh5Var, boolean z, ArrayList<nn> arrayList, ArrayList<nn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{qh5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
            yh5 yh5Var = new yh5(qh5Var, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.setFromFrs(true);
                next.setSortType(getSortType());
                arrayList3.add(next);
            }
            yh5Var.r(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, yh5Var));
            yh5 yh5Var2 = new yh5(qh5Var, 3);
            yh5Var2.x(z);
            yh5Var2.E(arrayList);
            yh5Var2.B(arrayList2);
            yh5Var2.w(z2);
            yh5Var2.s(getPage().a());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, yh5Var2));
        }
    }

    public void updateLikeData(tg8 tg8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, tg8Var) == null) || tg8Var == null) {
            return;
        }
        this.forum.setCurScore(tg8Var.c());
        this.forum.setLevelupScore(tg8Var.i());
        this.forum.setLike(tg8Var.n());
        this.forum.setUser_level(tg8Var.m());
        this.forum.setLevelName(tg8Var.h());
    }
}
