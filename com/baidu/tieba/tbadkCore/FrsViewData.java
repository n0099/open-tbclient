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
import com.repackage.aq4;
import com.repackage.bd6;
import com.repackage.bj8;
import com.repackage.br4;
import com.repackage.ei8;
import com.repackage.fc6;
import com.repackage.gc6;
import com.repackage.hc6;
import com.repackage.hi5;
import com.repackage.hi8;
import com.repackage.ic6;
import com.repackage.ii8;
import com.repackage.ij8;
import com.repackage.iu4;
import com.repackage.kg;
import com.repackage.ky5;
import com.repackage.li;
import com.repackage.li8;
import com.repackage.lr6;
import com.repackage.mi8;
import com.repackage.nq4;
import com.repackage.oi8;
import com.repackage.qi8;
import com.repackage.ri8;
import com.repackage.ro;
import com.repackage.si8;
import com.repackage.ti8;
import com.repackage.tr6;
import com.repackage.ui8;
import com.repackage.xp4;
import com.repackage.y65;
import com.repackage.zh5;
import com.repackage.zi8;
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
public class FrsViewData extends oi8 implements y65, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public lr6 funAdController;
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

    private List<ro> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        aq4 aq4Var;
        ArrayList<ro> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<ro> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (aq4Var = this.page) != null && aq4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    ro roVar = this.threadList.get(i);
                    if (roVar instanceof br4) {
                        if (((br4) roVar).s.isHeadLinePost) {
                            arrayList2.add(roVar);
                        }
                    } else if ((roVar instanceof ThreadData) && ((ThreadData) roVar).isHeadLinePost) {
                        arrayList2.add(roVar);
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
            Iterator<ro> it = this.threadList.iterator();
            while (it.hasNext()) {
                ro next = it.next();
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<ro> arrayList) {
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
            ro roVar = arrayList.get(i);
            if (roVar.getClass() == cls) {
                arrayList2.add(roVar);
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
        ArrayList<ro> threadList = getThreadList();
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
            ro roVar = this.threadList.get(i2);
            if (roVar instanceof br4) {
                ThreadData threadData = ((br4) roVar).s;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (feedForumList = this.forum.getBannerListData().getFeedForumList()) == null || feedForumList.size() <= 0) {
            return;
        }
        mi8 mi8Var = new mi8();
        mi8Var.f(this.forum.getId());
        mi8Var.e(feedForumList);
        this.threadList.add(i + 6, mi8Var);
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
            ro roVar = this.threadList.get(i2);
            if (roVar instanceof br4) {
                ThreadData threadData = ((br4) roVar).s;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String q = iu4.k().q("game_rank_list_info", "");
        if (!StringUtils.isNull(q) && q.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(kg.g(q.split(",")[0], 0L), System.currentTimeMillis()) < kg.e(q.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int l = iu4.k().l("game_rank_list_show_times", 0);
                    if (!z) {
                        l++;
                    }
                    iu4.k().w("game_rank_list_show_times", l);
                    if (l > 3) {
                        iu4 k = iu4.k();
                        k.y("game_rank_list_info", System.currentTimeMillis() + ",1");
                        iu4.k().w("game_rank_list_show_times", 0);
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
        ky5 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    ro roVar = this.threadList.get(i2);
                    if (roVar instanceof br4) {
                        ThreadData threadData = ((br4) roVar).s;
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
        hi8 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsInsertLiveData = getFrsInsertLiveData()) == null) {
            return;
        }
        ArrayList<ro> threadList = getThreadList();
        removeTopSameClassDataFromList(hi8.class, threadList);
        threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.b, threadList.size()), frsInsertLiveData);
    }

    public void addMyNewThread(xp4 xp4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, xp4Var) == null) || xp4Var == null || StringUtils.isNull(xp4Var.getId()) || this.threadList == null) {
            return;
        }
        int topThreadSize = getTopThreadSize();
        ArrayList<ro> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            for (int i = 0; i < size; i++) {
                ro roVar = threadList.get(i);
                if ((roVar instanceof br4) && xp4Var.getId().equals(((br4) roVar).s.getId()) && xp4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                    return;
                }
            }
        }
        xp4Var.isFromBrandForum = this.isBrandForum;
        this.postThreadCount++;
        this.threadList.add(topThreadSize, xp4Var);
    }

    public void addNoticeThreadToThreadList() {
        TopNoticeData top_notice_data;
        ro roVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getForum() == null || this.threadList == null || (top_notice_data = getForum().getTop_notice_data()) == null || top_notice_data.getTitle() == null) {
            return;
        }
        while (!this.threadList.isEmpty() && (roVar = this.threadList.get(0)) != null && (roVar instanceof br4) && ((ThreadData) roVar).getIs_top() == 2) {
            this.threadList.remove(0);
        }
        ThreadData threadData = new ThreadData();
        threadData.setTitle(top_notice_data.getTitle());
        threadData.setTid(top_notice_data.getTitle_link());
        threadData.setIs_top(2);
        threadData.parser_title();
        br4 br4Var = new br4();
        br4Var.s = threadData;
        this.threadList.add(0, br4Var);
    }

    public void addOfficialBarToThreadList() {
        aq4 aq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.forum == null || this.threadList == null || !ThreadData.isFRSExtraLoaded.get() || (aq4Var = this.page) == null) {
            return;
        }
        boolean z = true;
        if (aq4Var.a() == 1) {
            ui8 ui8Var = this.gconAccount;
            z = (ui8Var == null || !ui8Var.b()) ? false : false;
            if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof bj8)) {
                    this.threadList.remove(0);
                }
                bj8 bj8Var = new bj8();
                bj8Var.k(this.fortuneBag);
                bj8Var.m(this.fortuneDesc);
                bj8Var.q(this.gconAccount);
                bj8Var.setIs_top(1003);
                ArrayList<ro> arrayList = this.threadList;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                ListUtils.add(this.threadList, getTopThreadSize(), bj8Var);
            }
        }
    }

    public void addRecommendAppToThreadList(zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zh5Var) == null) {
            addRecommendAppToThreadList(zh5Var, false, this.threadList, null, false);
        }
    }

    public void addRecommendBarsToThreadList() {
        ArrayList<ro> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.forum == null || (arrayList = this.threadList) == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<ro> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof nq4) {
                it.remove();
            }
        }
        aq4 aq4Var = this.page;
        if (aq4Var == null || aq4Var.a() != 1) {
            return;
        }
        ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
        nq4 nq4Var = new nq4();
        if (recommendForumData != null) {
            nq4Var.e().addAll(recommendForumData);
        }
        if (isShowRecommendBars(nq4Var.e())) {
            int i = 0;
            Iterator<ro> it2 = this.threadList.iterator();
            while (it2.hasNext()) {
                ro next = it2.next();
                if ((next instanceof br4) && ((br4) next).s.isTop()) {
                    i++;
                }
            }
            this.threadList.add(i + 1, nq4Var);
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
        ii8 frsStageLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsStageLiveData = getFrsStageLiveData()) == null) {
            return;
        }
        ArrayList<ro> threadList = getThreadList();
        removeTopSameClassDataFromList(ii8.class, threadList);
        if (ListUtils.isEmpty(frsStageLiveData.a)) {
            return;
        }
        threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
    }

    public void addU9DataToThreadList() {
        ForumData forumData;
        aq4 aq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (forumData = this.forum) == null) {
            return;
        }
        if (((forumData.getTopCode() == null || StringUtils.isNull(this.forum.getTopCode().g())) && (this.forum.getNewsInfo() == null || StringUtils.isNull(this.forum.getNewsInfo().N0()))) || (aq4Var = this.page) == null || aq4Var.a() != 1) {
            return;
        }
        ij8 ij8Var = new ij8();
        ij8Var.m(this.forum.getTopCode());
        ij8Var.q(this.forum.getNewsInfo());
        ij8Var.setIs_top(3);
        ij8Var.k(true);
        if (ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<ro> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            ro next = it.next();
            if (next instanceof ThreadData) {
                ThreadData threadData = (ThreadData) next;
                if (threadData.getIs_top() != 0) {
                    if (threadData.getIs_top() == 1003) {
                        ij8Var.k(false);
                    }
                    i++;
                }
            }
        }
        this.threadList.add(i, ij8Var);
    }

    public void addUserRecommendToThreadList() {
        int a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || getUserRecommend() == null) {
            return;
        }
        bd6 userRecommend = getUserRecommend();
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
        Iterator<ro> it = this.threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ro next = it.next();
            if (next != null && next.getType() == ti8.c) {
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
        List<ro> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<ro> threadList = getThreadList();
        if (cardShipinPos == null || cardShipinPos.size() <= 0 || cardShipinNew == null || cardShipinNew.size() <= 0 || threadList == null) {
            return;
        }
        int size = cardShipinPos.size();
        int size2 = threadList.size();
        for (int i = 0; i < size; i++) {
            if (i < cardShipinNew.size()) {
                ro roVar = cardShipinNew.get(i);
                int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + roVar.getType());
                threadList.add(videoThreadInserPos, roVar);
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<ro> arrayList;
        aq4 aq4Var;
        ArrayList<ro> arrayList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (arrayList = this.threadList) == null || arrayList.size() <= 0 || (aq4Var = this.page) == null || aq4Var.a() != 1 || (arrayList2 = this.threadList) == null || arrayList2.size() <= 0) {
            return;
        }
        int i = -1;
        int size = this.threadList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ro roVar = this.threadList.get(i2);
            if (roVar instanceof br4) {
                br4 br4Var = (br4) roVar;
                if (br4Var.s.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && br4Var.s.getThreadAlaInfo() != null && ((ThreadData) roVar).getThreadAlaInfo().user_info != null && br4Var.s.getThreadAlaInfo().user_info.is_official == 2 && br4Var.s.getThreadAlaInfo().liveStageForceTop) {
                    i = i2;
                    break;
                }
            } else {
                if (roVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) roVar;
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
                ro roVar2 = this.threadList.get(i3);
                if (roVar2 instanceof br4) {
                    if (((br4) roVar2).s.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        i = i3;
                        break;
                    }
                } else {
                    if ((roVar2 instanceof ThreadData) && ((ThreadData) roVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
        List<ro> headLineDataInThreadList = getHeadLineDataInThreadList();
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

    public void filterEnterList(List<li8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        Iterator<li8> it = list.iterator();
        while (it.hasNext()) {
            li8 next = it.next();
            if (next == null) {
                it.remove();
            } else if (StringUtils.isNull(next.i()) || StringUtils.isNull(next.f())) {
                if (next.a() != 1) {
                    it.remove();
                }
            }
        }
    }

    public ic6 getBrandAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.brandAdData : (ic6) invokeV.objValue;
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
            ArrayList<ro> threadList = getThreadList();
            if (threadList == null || threadList.size() <= 0) {
                return 0;
            }
            int size = threadList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (threadList.get(i2) instanceof xp4) {
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

    @Override // com.repackage.oi8
    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.recm_forum_list : (List) invokeV.objValue;
    }

    public List<ro> getShowTopThreadList() {
        InterceptResult invokeV;
        List<li8> list;
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
                arrayList.add(new si8(forum, this.forumRule));
            }
            if (forum != null && !li.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new ri8(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new ri8(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<ro> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    ro roVar = (ro) ListUtils.getItem(topThreadList, i4);
                    if (roVar instanceof br4) {
                        br4 br4Var = (br4) roVar;
                        arrayList.add(br4Var.s);
                        if (br4Var.s.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (roVar instanceof ThreadData) {
                            arrayList.add(roVar);
                            if (((ThreadData) roVar).getIsMemberTop() != 1 || z) {
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
            ArrayList<ro> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<ro> it = arrayList.iterator();
            while (it.hasNext()) {
                ro next = it.next();
                if (next != null && (next instanceof br4)) {
                    br4 br4Var = (br4) next;
                    if (TextUtils.equals(str, br4Var.s.getId())) {
                        return br4Var.s;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public List<ro> getTopThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.topThreadList : (List) invokeV.objValue;
    }

    public int getTopThreadSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ArrayList<ro> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<ro> it = this.threadList.iterator();
                while (it.hasNext()) {
                    ro next = it.next();
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
            qi8 entelechyTabInfo = getEntelechyTabInfo();
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

    public boolean receiveData(oi8 oi8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, oi8Var)) == null) {
            if (oi8Var == null) {
                return false;
            }
            this.isFromCache = oi8Var.isFromCache;
            setSortType(oi8Var.getSortType());
            setAnti(oi8Var.getAnti());
            setChatGroup(oi8Var.getChatGroup());
            setFortuneBag(oi8Var.isFortuneBag());
            setFortuneDesc(oi8Var.getFortuneDesc());
            setForum(oi8Var.getForum());
            setGameName(oi8Var.getGameName());
            setGameUrl(oi8Var.getGameUrl());
            setGconAccount(oi8Var.getGconAccount());
            setHasGame(oi8Var.isHasGame());
            setIsNewUrl(oi8Var.getIsNewUrl());
            setPhotoLivePos(oi8Var.getPhotoLivePos());
            setPage(oi8Var.getPage());
            setStar(oi8Var.getStar());
            setStarEnter(oi8Var.getStarEnter());
            setThreadList(oi8Var.threadList);
            setThreadListIds(oi8Var.getThreadListIds());
            setUserData(oi8Var.getUserData());
            setUserMap(oi8Var.getUserMap());
            setActivityHeadData(oi8Var.getActivityHeadData());
            setFrsDefaultTabId(oi8Var.getFrsDefaultTabId());
            this.defaultShowTab = oi8Var.defaultShowTab;
            setCategoryInfos(oi8Var.getCategoryInfos());
            setBawuCenterUrl(oi8Var.getBawuCenterUrl());
            setCardVideoInfo(oi8Var.getCardVideoInfo());
            setHeadSdkData(oi8Var.getHeadSdkData());
            setSchoolRecommendPos(oi8Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(oi8Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(oi8Var.getEntelechyTabInfo());
            setAlaLiveCount(oi8Var.getAlaLiveCount());
            setCarrierEnterData(oi8Var.getCarrierEnterData());
            setForumState(oi8Var.getForumState());
            setAccessFlag(oi8Var.getAccessFlag());
            this.needLog = oi8Var.needLog;
            this.recommendBookData = oi8Var.recommendBookData;
            this.presentInfoData = oi8Var.presentInfoData;
            setBookInfo(oi8Var.getBookInfo());
            setMangaReadRecordChapterId(oi8Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(oi8Var.getHeadlineImgInfoData());
            setCardShipinPos(oi8Var.getCardShipinPos());
            setCardShipinNew(oi8Var.getCardShipinNew());
            this.enterFrsDialogInfo = oi8Var.enterFrsDialogInfo;
            setGameRankListData(oi8Var.getGameRankListData());
            setAgreeBanner(oi8Var.getAgreeBanner());
            setLiveNotify(oi8Var.getLiveNotify());
            setGameTabInfo(oi8Var.getGameTabInfo());
            setGameDefaultTabId(oi8Var.getGameDefaultTabId());
            setForumHeadIcon(oi8Var.getForumHeadIcon());
            setUserRecommend(oi8Var.getUserRecommend());
            setFrsVideoActivityData(oi8Var.getFrsVideoActivityData());
            this.mNewChapterInfo = oi8Var.mNewChapterInfo;
            setFrsInsertLiveData(oi8Var.getFrsInsertLiveData());
            this.recm_forum_list = oi8Var.getRecm_forum_list();
            setFrsStageLiveData(oi8Var.getFrsStageLiveData());
            this.forumArIno = oi8Var.forumArIno;
            this.starRank = oi8Var.starRank;
            this.postTopic = oi8Var.postTopic;
            this.mWindowToast = oi8Var.mWindowToast;
            this.activityConfig = oi8Var.activityConfig;
            setIsShowRedTip(oi8Var.isShowRedTip());
            this.isBrandForum = oi8Var.isBrandForum;
            this.brandAdData = oi8Var.brandAdData;
            this.oriForumInfoList = oi8Var.oriForumInfoList;
            this.bottomMenuList = oi8Var.bottomMenuList;
            this.adMixFloor = oi8Var.adMixFloor;
            this.adShowSelect = oi8Var.adShowSelect;
            this.adSampleMapKey = oi8Var.adSampleMapKey;
            gc6.f().n(getAnti());
            gc6.f().q(oi8Var.getForum().getId());
            gc6.f().r(oi8Var.getForum().getName());
            fc6.h().q(oi8Var.getForum().getId());
            if (oi8Var.getEntelechyTabInfo() != null) {
                fc6.h().r(oi8Var.getEntelechyTabInfo().a);
            }
            if (oi8Var.getUserData() != null) {
                hc6.c().e(oi8Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(oi8Var.getPrivateForumTotalInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = oi8Var.smartAppAvatar;
            this.smartApp = oi8Var.smartApp;
            this.nebulaHotThreads = oi8Var.nebulaHotThreads;
            this.forumActiveInfo = oi8Var.forumActiveInfo;
            this.userList = oi8Var.userList;
            setBusinessPromot(oi8Var.getBusinessPromot());
            this.serviceAreaData = oi8Var.serviceAreaData;
            setHotUserRankData(oi8Var.getHotUserRankData());
            this.itemInfo = oi8Var.itemInfo;
            this.toLoadHorseData = oi8Var.toLoadHorseData;
            this.forumRule = oi8Var.forumRule;
            this.mSignActivityInfo = oi8Var.mSignActivityInfo;
            this.showAdsense = oi8Var.showAdsense;
            setVoiceRoomConfig(oi8Var.getVoiceRoomConfig());
            setVoiceRoomData(oi8Var.getVoiceRoomData());
            this.serviceAreaFlutterData = oi8Var.serviceAreaFlutterData;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void removeAlaInsertLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            removeTopSameClassDataFromList(hi8.class, getThreadList());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<ro> arrayList;
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
            removeTopSameClassDataFromList(ii8.class, getThreadList());
        }
    }

    public void removeGameRankListFromThreadList() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<ro> it = this.threadList.iterator();
        while (it.hasNext()) {
            ro next = it.next();
            if (next != null && next.getType() == tr6.e) {
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
        Iterator<ro> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof bd6) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void removeThread(String str) {
        ArrayList<ro> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, str) == null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<ro> it = arrayList.iterator();
        while (it.hasNext()) {
            ro next = it.next();
            if (next != null && (next instanceof br4) && TextUtils.equals(str, ((br4) next).s.getId())) {
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

    public void setFunAdController(lr6 lr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, lr6Var) == null) {
            this.funAdController = lr6Var;
        }
    }

    public void setTopThreadList(List<ro> list) {
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
        Iterator<ro> it = this.threadList.iterator();
        while (it.hasNext()) {
            ro next = it.next();
            if (next != null && (next instanceof br4)) {
                br4 br4Var = (br4) next;
                if (br4Var.s.getAuthor() != null && currentAccount.equals(br4Var.s.getAuthor().getUserId()) && br4Var.s.getAuthor().getPendantData() != null) {
                    br4Var.s.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                    br4Var.s.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                }
            }
        }
    }

    public void updateLikeData(ei8 ei8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, ei8Var) == null) || ei8Var == null) {
            return;
        }
        zi8 zi8Var = new zi8();
        zi8Var.y(1);
        zi8Var.z(ei8Var.a);
        zi8Var.w(ei8Var.b);
        zi8Var.u(ei8Var.c);
        zi8Var.x(ei8Var.d);
        updateLikeData(zi8Var);
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

    public void addRecommendAppToThreadList(zh5 zh5Var, ArrayList<ro> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, zh5Var, arrayList) == null) {
            addRecommendAppToThreadList(zh5Var, false, arrayList, null, false);
        }
    }

    public void addRecommendAppToThreadList(zh5 zh5Var, boolean z, ArrayList<ro> arrayList, ArrayList<ro> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{zh5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
            hi5 hi5Var = new hi5(zh5Var, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.setFromFrs(true);
                next.setSortType(getSortType());
                arrayList3.add(next);
            }
            hi5Var.r(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, hi5Var));
            hi5 hi5Var2 = new hi5(zh5Var, 3);
            hi5Var2.x(z);
            hi5Var2.E(arrayList);
            hi5Var2.B(arrayList2);
            hi5Var2.w(z2);
            hi5Var2.s(getPage().a());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, hi5Var2));
        }
    }

    public void updateLikeData(zi8 zi8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, zi8Var) == null) || zi8Var == null) {
            return;
        }
        this.forum.setCurScore(zi8Var.c());
        this.forum.setLevelupScore(zi8Var.i());
        this.forum.setLike(zi8Var.n());
        this.forum.setUser_level(zi8Var.m());
        this.forum.setLevelName(zi8Var.h());
    }
}
