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
import com.baidu.tieba.Cdo;
import com.baidu.tieba.b36;
import com.baidu.tieba.bm8;
import com.baidu.tieba.bu4;
import com.baidu.tieba.cm8;
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.dm8;
import com.baidu.tieba.dv6;
import com.baidu.tieba.em8;
import com.baidu.tieba.fm8;
import com.baidu.tieba.in5;
import com.baidu.tieba.km8;
import com.baidu.tieba.mb5;
import com.baidu.tieba.mm8;
import com.baidu.tieba.mt4;
import com.baidu.tieba.nv6;
import com.baidu.tieba.ox4;
import com.baidu.tieba.pl8;
import com.baidu.tieba.qh6;
import com.baidu.tieba.qn5;
import com.baidu.tieba.sl8;
import com.baidu.tieba.tg6;
import com.baidu.tieba.tl8;
import com.baidu.tieba.tm8;
import com.baidu.tieba.ug6;
import com.baidu.tieba.vg6;
import com.baidu.tieba.wg6;
import com.baidu.tieba.wl8;
import com.baidu.tieba.ws4;
import com.baidu.tieba.xl8;
import com.baidu.tieba.zl8;
import com.baidu.tieba.zs4;
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
public class FrsViewData extends zl8 implements mb5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public dv6 funAdController;
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

    private List<Cdo> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        zs4 zs4Var;
        ArrayList<Cdo> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<Cdo> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (zs4Var = this.page) != null && zs4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    Cdo cdo = this.threadList.get(i);
                    if (cdo instanceof bu4) {
                        if (((bu4) cdo).t.isHeadLinePost) {
                            arrayList2.add(cdo);
                        }
                    } else if ((cdo instanceof ThreadData) && ((ThreadData) cdo).isHeadLinePost) {
                        arrayList2.add(cdo);
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
            Iterator<Cdo> it = this.threadList.iterator();
            while (it.hasNext()) {
                Cdo next = it.next();
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<Cdo> arrayList) {
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
            Cdo cdo = arrayList.get(i);
            if (cdo.getClass() == cls) {
                arrayList2.add(cdo);
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
        ArrayList<Cdo> threadList = getThreadList();
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
            Cdo cdo = this.threadList.get(i2);
            if (cdo instanceof bu4) {
                ThreadData threadData = ((bu4) cdo).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (feedForumList = this.forum.getBannerListData().getFeedForumList()) == null || feedForumList.size() <= 0) {
            return;
        }
        xl8 xl8Var = new xl8();
        xl8Var.f(this.forum.getId());
        xl8Var.c(feedForumList);
        this.threadList.add(i + 6, xl8Var);
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
            Cdo cdo = this.threadList.get(i2);
            if (cdo instanceof bu4) {
                ThreadData threadData = ((bu4) cdo).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String q = ox4.k().q("game_rank_list_info", "");
        if (!StringUtils.isNull(q) && q.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(dh.g(q.split(",")[0], 0L), System.currentTimeMillis()) < dh.e(q.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int l = ox4.k().l("game_rank_list_show_times", 0);
                    if (!z) {
                        l++;
                    }
                    ox4.k().w("game_rank_list_show_times", l);
                    if (l > 3) {
                        ox4 k = ox4.k();
                        k.y("game_rank_list_info", System.currentTimeMillis() + ",1");
                        ox4.k().w("game_rank_list_show_times", 0);
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
        b36 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    Cdo cdo = this.threadList.get(i2);
                    if (cdo instanceof bu4) {
                        ThreadData threadData = ((bu4) cdo).t;
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
        sl8 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsInsertLiveData = getFrsInsertLiveData()) == null) {
            return;
        }
        ArrayList<Cdo> threadList = getThreadList();
        removeTopSameClassDataFromList(sl8.class, threadList);
        threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.b, threadList.size()), frsInsertLiveData);
    }

    public void addMyNewThread(ws4 ws4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ws4Var) == null) || ws4Var == null || StringUtils.isNull(ws4Var.getId()) || this.threadList == null) {
            return;
        }
        int topThreadSize = getTopThreadSize();
        ArrayList<Cdo> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            for (int i = 0; i < size; i++) {
                Cdo cdo = threadList.get(i);
                if ((cdo instanceof bu4) && ws4Var.getId().equals(((bu4) cdo).t.getId()) && ws4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                    return;
                }
            }
        }
        ws4Var.isFromBrandForum = this.isBrandForum;
        this.postThreadCount++;
        this.threadList.add(topThreadSize, ws4Var);
    }

    public void addNoticeThreadToThreadList() {
        TopNoticeData top_notice_data;
        Cdo cdo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getForum() == null || this.threadList == null || (top_notice_data = getForum().getTop_notice_data()) == null || top_notice_data.getTitle() == null) {
            return;
        }
        while (!this.threadList.isEmpty() && (cdo = this.threadList.get(0)) != null && (cdo instanceof bu4) && ((ThreadData) cdo).getIs_top() == 2) {
            this.threadList.remove(0);
        }
        ThreadData threadData = new ThreadData();
        threadData.setTitle(top_notice_data.getTitle());
        threadData.setTid(top_notice_data.getTitle_link());
        threadData.setIs_top(2);
        threadData.parser_title();
        bu4 bu4Var = new bu4();
        bu4Var.t = threadData;
        this.threadList.add(0, bu4Var);
    }

    public void addOfficialBarToThreadList() {
        zs4 zs4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.forum == null || this.threadList == null || !ThreadData.isFRSExtraLoaded.get() || (zs4Var = this.page) == null) {
            return;
        }
        boolean z = true;
        if (zs4Var.a() == 1) {
            fm8 fm8Var = this.gconAccount;
            z = (fm8Var == null || !fm8Var.b()) ? false : false;
            if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof mm8)) {
                    this.threadList.remove(0);
                }
                mm8 mm8Var = new mm8();
                mm8Var.j(this.fortuneBag);
                mm8Var.l(this.fortuneDesc);
                mm8Var.n(this.gconAccount);
                mm8Var.setIs_top(1003);
                ArrayList<Cdo> arrayList = this.threadList;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                ListUtils.add(this.threadList, getTopThreadSize(), mm8Var);
            }
        }
    }

    public void addRecommendAppToThreadList(in5 in5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, in5Var) == null) {
            addRecommendAppToThreadList(in5Var, false, this.threadList, null, false);
        }
    }

    public void addRecommendBarsToThreadList() {
        ArrayList<Cdo> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.forum == null || (arrayList = this.threadList) == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<Cdo> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof mt4) {
                it.remove();
            }
        }
        zs4 zs4Var = this.page;
        if (zs4Var == null || zs4Var.a() != 1) {
            return;
        }
        ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
        mt4 mt4Var = new mt4();
        if (recommendForumData != null) {
            mt4Var.c().addAll(recommendForumData);
        }
        if (isShowRecommendBars(mt4Var.c())) {
            int i = 0;
            Iterator<Cdo> it2 = this.threadList.iterator();
            while (it2.hasNext()) {
                Cdo next = it2.next();
                if ((next instanceof bu4) && ((bu4) next).t.isTop()) {
                    i++;
                }
            }
            this.threadList.add(i + 1, mt4Var);
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
        tl8 frsStageLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsStageLiveData = getFrsStageLiveData()) == null) {
            return;
        }
        ArrayList<Cdo> threadList = getThreadList();
        removeTopSameClassDataFromList(tl8.class, threadList);
        if (ListUtils.isEmpty(frsStageLiveData.a)) {
            return;
        }
        threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
    }

    public void addU9DataToThreadList() {
        ForumData forumData;
        zs4 zs4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (forumData = this.forum) == null) {
            return;
        }
        if (((forumData.getTopCode() == null || StringUtils.isNull(this.forum.getTopCode().g())) && (this.forum.getNewsInfo() == null || StringUtils.isNull(this.forum.getNewsInfo().k1()))) || (zs4Var = this.page) == null || zs4Var.a() != 1) {
            return;
        }
        tm8 tm8Var = new tm8();
        tm8Var.l(this.forum.getTopCode());
        tm8Var.n(this.forum.getNewsInfo());
        tm8Var.setIs_top(3);
        tm8Var.j(true);
        if (ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<Cdo> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            Cdo next = it.next();
            if (next instanceof ThreadData) {
                ThreadData threadData = (ThreadData) next;
                if (threadData.getIs_top() != 0) {
                    if (threadData.getIs_top() == 1003) {
                        tm8Var.j(false);
                    }
                    i++;
                }
            }
        }
        this.threadList.add(i, tm8Var);
    }

    public void addUserRecommendToThreadList() {
        int a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || getUserRecommend() == null) {
            return;
        }
        qh6 userRecommend = getUserRecommend();
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
        Iterator<Cdo> it = this.threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Cdo next = it.next();
            if (next != null && next.getType() == em8.c) {
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
        List<Cdo> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<Cdo> threadList = getThreadList();
        if (cardShipinPos == null || cardShipinPos.size() <= 0 || cardShipinNew == null || cardShipinNew.size() <= 0 || threadList == null) {
            return;
        }
        int size = cardShipinPos.size();
        int size2 = threadList.size();
        for (int i = 0; i < size; i++) {
            if (i < cardShipinNew.size()) {
                Cdo cdo = cardShipinNew.get(i);
                int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + cdo.getType());
                threadList.add(videoThreadInserPos, cdo);
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<Cdo> arrayList;
        zs4 zs4Var;
        ArrayList<Cdo> arrayList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (arrayList = this.threadList) == null || arrayList.size() <= 0 || (zs4Var = this.page) == null || zs4Var.a() != 1 || (arrayList2 = this.threadList) == null || arrayList2.size() <= 0) {
            return;
        }
        int i = -1;
        int size = this.threadList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Cdo cdo = this.threadList.get(i2);
            if (cdo instanceof bu4) {
                bu4 bu4Var = (bu4) cdo;
                if (bu4Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && bu4Var.t.getThreadAlaInfo() != null && ((ThreadData) cdo).getThreadAlaInfo().user_info != null && bu4Var.t.getThreadAlaInfo().user_info.is_official == 2 && bu4Var.t.getThreadAlaInfo().liveStageForceTop) {
                    i = i2;
                    break;
                }
            } else {
                if (cdo instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) cdo;
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
                Cdo cdo2 = this.threadList.get(i3);
                if (cdo2 instanceof bu4) {
                    if (((bu4) cdo2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        i = i3;
                        break;
                    }
                } else {
                    if ((cdo2 instanceof ThreadData) && ((ThreadData) cdo2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
        List<Cdo> headLineDataInThreadList = getHeadLineDataInThreadList();
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

    public void filterEnterList(List<wl8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        Iterator<wl8> it = list.iterator();
        while (it.hasNext()) {
            wl8 next = it.next();
            if (next == null) {
                it.remove();
            } else if (StringUtils.isNull(next.h()) || StringUtils.isNull(next.f())) {
                if (next.a() != 1) {
                    it.remove();
                }
            }
        }
    }

    public wg6 getBrandAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.brandAdData : (wg6) invokeV.objValue;
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
            ArrayList<Cdo> threadList = getThreadList();
            if (threadList == null || threadList.size() <= 0) {
                return 0;
            }
            int size = threadList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (threadList.get(i2) instanceof ws4) {
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

    @Override // com.baidu.tieba.zl8
    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.recm_forum_list : (List) invokeV.objValue;
    }

    public List<Cdo> getShowTopThreadList() {
        InterceptResult invokeV;
        List<wl8> list;
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
                arrayList.add(new dm8(forum, this.forumRule));
            }
            if (forum != null && !dj.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new cm8(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new cm8(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<Cdo> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    Cdo cdo = (Cdo) ListUtils.getItem(topThreadList, i4);
                    if (cdo instanceof bu4) {
                        bu4 bu4Var = (bu4) cdo;
                        arrayList.add(bu4Var.t);
                        if (bu4Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (cdo instanceof ThreadData) {
                            arrayList.add(cdo);
                            if (((ThreadData) cdo).getIsMemberTop() != 1 || z) {
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
            ArrayList<Cdo> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<Cdo> it = arrayList.iterator();
            while (it.hasNext()) {
                Cdo next = it.next();
                if (next != null && (next instanceof bu4)) {
                    bu4 bu4Var = (bu4) next;
                    if (TextUtils.equals(str, bu4Var.t.getId())) {
                        return bu4Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public List<Cdo> getTopThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.topThreadList : (List) invokeV.objValue;
    }

    public int getTopThreadSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ArrayList<Cdo> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Cdo> it = this.threadList.iterator();
                while (it.hasNext()) {
                    Cdo next = it.next();
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
            bm8 entelechyTabInfo = getEntelechyTabInfo();
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

    public boolean receiveData(zl8 zl8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, zl8Var)) == null) {
            if (zl8Var == null) {
                return false;
            }
            this.isFromCache = zl8Var.isFromCache;
            setBaWuNoticeNum(zl8Var.getBaWuNoticeNum());
            setSortType(zl8Var.getSortType());
            setAnti(zl8Var.getAnti());
            setChatGroup(zl8Var.getChatGroup());
            setFortuneBag(zl8Var.isFortuneBag());
            setFortuneDesc(zl8Var.getFortuneDesc());
            setForum(zl8Var.getForum());
            setGameName(zl8Var.getGameName());
            setGameUrl(zl8Var.getGameUrl());
            setGconAccount(zl8Var.getGconAccount());
            setHasGame(zl8Var.isHasGame());
            setIsNewUrl(zl8Var.getIsNewUrl());
            setPhotoLivePos(zl8Var.getPhotoLivePos());
            setPage(zl8Var.getPage());
            setStar(zl8Var.getStar());
            setStarEnter(zl8Var.getStarEnter());
            setThreadList(zl8Var.threadList);
            setThreadListIds(zl8Var.getThreadListIds());
            setUserData(zl8Var.getUserData());
            setUserMap(zl8Var.getUserMap());
            setActivityHeadData(zl8Var.getActivityHeadData());
            setFrsDefaultTabId(zl8Var.getFrsDefaultTabId());
            this.defaultShowTab = zl8Var.defaultShowTab;
            setCategoryInfos(zl8Var.getCategoryInfos());
            setBawuCenterUrl(zl8Var.getBawuCenterUrl());
            setCardVideoInfo(zl8Var.getCardVideoInfo());
            setHeadSdkData(zl8Var.getHeadSdkData());
            setSchoolRecommendPos(zl8Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(zl8Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(zl8Var.getEntelechyTabInfo());
            setAlaLiveCount(zl8Var.getAlaLiveCount());
            setCarrierEnterData(zl8Var.getCarrierEnterData());
            setForumState(zl8Var.getForumState());
            setAccessFlag(zl8Var.getAccessFlag());
            this.needLog = zl8Var.needLog;
            this.recommendBookData = zl8Var.recommendBookData;
            this.presentInfoData = zl8Var.presentInfoData;
            setBookInfo(zl8Var.getBookInfo());
            setMangaReadRecordChapterId(zl8Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(zl8Var.getHeadlineImgInfoData());
            setCardShipinPos(zl8Var.getCardShipinPos());
            setCardShipinNew(zl8Var.getCardShipinNew());
            this.enterFrsDialogInfo = zl8Var.enterFrsDialogInfo;
            setGameRankListData(zl8Var.getGameRankListData());
            setAgreeBanner(zl8Var.getAgreeBanner());
            setLiveNotify(zl8Var.getLiveNotify());
            setGameTabInfo(zl8Var.getGameTabInfo());
            setGameDefaultTabId(zl8Var.getGameDefaultTabId());
            setForumHeadIcon(zl8Var.getForumHeadIcon());
            setUserRecommend(zl8Var.getUserRecommend());
            setFrsVideoActivityData(zl8Var.getFrsVideoActivityData());
            this.mNewChapterInfo = zl8Var.mNewChapterInfo;
            setFrsInsertLiveData(zl8Var.getFrsInsertLiveData());
            this.recm_forum_list = zl8Var.getRecm_forum_list();
            setFrsStageLiveData(zl8Var.getFrsStageLiveData());
            this.forumArIno = zl8Var.forumArIno;
            this.starRank = zl8Var.starRank;
            this.postTopic = zl8Var.postTopic;
            this.mWindowToast = zl8Var.mWindowToast;
            this.activityConfig = zl8Var.activityConfig;
            setIsShowRedTip(zl8Var.isShowRedTip());
            this.isBrandForum = zl8Var.isBrandForum;
            this.brandAdData = zl8Var.brandAdData;
            this.oriForumInfoList = zl8Var.oriForumInfoList;
            this.bottomMenuList = zl8Var.bottomMenuList;
            this.adMixFloor = zl8Var.adMixFloor;
            this.adShowSelect = zl8Var.adShowSelect;
            this.adSampleMapKey = zl8Var.adSampleMapKey;
            ug6.f().n(getAnti());
            ug6.f().q(zl8Var.getForum().getId());
            ug6.f().r(zl8Var.getForum().getName());
            tg6.h().q(zl8Var.getForum().getId());
            if (zl8Var.getEntelechyTabInfo() != null) {
                tg6.h().r(zl8Var.getEntelechyTabInfo().a);
            }
            if (zl8Var.getUserData() != null) {
                vg6.c().e(zl8Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(zl8Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(zl8Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = zl8Var.smartAppAvatar;
            this.smartApp = zl8Var.smartApp;
            this.nebulaHotThreads = zl8Var.nebulaHotThreads;
            this.forumActiveInfo = zl8Var.forumActiveInfo;
            this.userList = zl8Var.userList;
            setBusinessPromot(zl8Var.getBusinessPromot());
            this.serviceAreaData = zl8Var.serviceAreaData;
            setHotUserRankData(zl8Var.getHotUserRankData());
            this.itemInfo = zl8Var.itemInfo;
            this.toLoadHorseData = zl8Var.toLoadHorseData;
            this.forumRule = zl8Var.forumRule;
            this.mSignActivityInfo = zl8Var.mSignActivityInfo;
            this.showAdsense = zl8Var.showAdsense;
            setVoiceRoomConfig(zl8Var.getVoiceRoomConfig());
            setVoiceRoomData(zl8Var.getVoiceRoomData());
            this.serviceAreaFlutterData = zl8Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = zl8Var.liveFuseForumDataList;
            this.forumTagInfo = zl8Var.forumTagInfo;
            this.firstCategory = zl8Var.firstCategory;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void removeAlaInsertLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            removeTopSameClassDataFromList(sl8.class, getThreadList());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<Cdo> arrayList;
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
            removeTopSameClassDataFromList(tl8.class, getThreadList());
        }
    }

    public void removeGameRankListFromThreadList() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<Cdo> it = this.threadList.iterator();
        while (it.hasNext()) {
            Cdo next = it.next();
            if (next != null && next.getType() == nv6.e) {
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
        Iterator<Cdo> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof qh6) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void removeThread(String str) {
        ArrayList<Cdo> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, str) == null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<Cdo> it = arrayList.iterator();
        while (it.hasNext()) {
            Cdo next = it.next();
            if (next != null && (next instanceof bu4) && TextUtils.equals(str, ((bu4) next).t.getId())) {
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

    public void setFunAdController(dv6 dv6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, dv6Var) == null) {
            this.funAdController = dv6Var;
        }
    }

    public void setTopThreadList(List<Cdo> list) {
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
        Iterator<Cdo> it = this.threadList.iterator();
        while (it.hasNext()) {
            Cdo next = it.next();
            if (next != null && (next instanceof bu4)) {
                bu4 bu4Var = (bu4) next;
                if (bu4Var.t.getAuthor() != null && currentAccount.equals(bu4Var.t.getAuthor().getUserId()) && bu4Var.t.getAuthor().getPendantData() != null) {
                    bu4Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                    bu4Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                }
            }
        }
    }

    public void updateLikeData(pl8 pl8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, pl8Var) == null) || pl8Var == null) {
            return;
        }
        km8 km8Var = new km8();
        km8Var.x(1);
        km8Var.y(pl8Var.a);
        km8Var.v(pl8Var.b);
        km8Var.t(pl8Var.c);
        km8Var.w(pl8Var.d);
        updateLikeData(km8Var);
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

    public void addRecommendAppToThreadList(in5 in5Var, ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, in5Var, arrayList) == null) {
            addRecommendAppToThreadList(in5Var, false, arrayList, null, false);
        }
    }

    public void addRecommendAppToThreadList(in5 in5Var, boolean z, ArrayList<Cdo> arrayList, ArrayList<Cdo> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{in5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
            qn5 qn5Var = new qn5(in5Var, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.setFromFrs(true);
                next.setSortType(getSortType());
                arrayList3.add(next);
            }
            qn5Var.s(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, qn5Var));
            qn5 qn5Var2 = new qn5(in5Var, 3);
            qn5Var2.z(z);
            qn5Var2.G(arrayList);
            qn5Var2.D(arrayList2);
            qn5Var2.y(z2);
            qn5Var2.t(getPage().a());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, qn5Var2));
        }
    }

    public void updateLikeData(km8 km8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, km8Var) == null) || km8Var == null) {
            return;
        }
        this.forum.setCurScore(km8Var.c());
        this.forum.setLevelupScore(km8Var.i());
        this.forum.setLike(km8Var.m());
        this.forum.setUser_level(km8Var.l());
        this.forum.setLevelName(km8Var.h());
    }
}
