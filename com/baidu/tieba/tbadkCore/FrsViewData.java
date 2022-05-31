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
import com.repackage.ag8;
import com.repackage.bh5;
import com.repackage.cg8;
import com.repackage.cp4;
import com.repackage.dx5;
import com.repackage.ff8;
import com.repackage.if8;
import com.repackage.jf8;
import com.repackage.jg;
import com.repackage.jg8;
import com.repackage.jn;
import com.repackage.ki;
import com.repackage.mf8;
import com.repackage.mo4;
import com.repackage.nf8;
import com.repackage.pf8;
import com.repackage.po4;
import com.repackage.rb6;
import com.repackage.rf8;
import com.repackage.rp4;
import com.repackage.rp6;
import com.repackage.sf8;
import com.repackage.tf8;
import com.repackage.tg5;
import com.repackage.uf8;
import com.repackage.va6;
import com.repackage.vf8;
import com.repackage.w55;
import com.repackage.wa6;
import com.repackage.xa6;
import com.repackage.ya6;
import com.repackage.ys4;
import com.repackage.zp6;
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
public class FrsViewData extends pf8 implements w55, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public rp6 funAdController;
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

    private List<jn> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        po4 po4Var;
        ArrayList<jn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<jn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (po4Var = this.page) != null && po4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    jn jnVar = this.threadList.get(i);
                    if (jnVar instanceof rp4) {
                        if (((rp4) jnVar).s.isHeadLinePost) {
                            arrayList2.add(jnVar);
                        }
                    } else if ((jnVar instanceof ThreadData) && ((ThreadData) jnVar).isHeadLinePost) {
                        arrayList2.add(jnVar);
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
            Iterator<jn> it = this.threadList.iterator();
            while (it.hasNext()) {
                jn next = it.next();
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<jn> arrayList) {
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
            jn jnVar = arrayList.get(i);
            if (jnVar.getClass() == cls) {
                arrayList2.add(jnVar);
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
        ArrayList<jn> threadList = getThreadList();
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
            jn jnVar = this.threadList.get(i2);
            if (jnVar instanceof rp4) {
                ThreadData threadData = ((rp4) jnVar).s;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (feedForumList = this.forum.getBannerListData().getFeedForumList()) == null || feedForumList.size() <= 0) {
            return;
        }
        nf8 nf8Var = new nf8();
        nf8Var.f(this.forum.getId());
        nf8Var.e(feedForumList);
        this.threadList.add(i + 6, nf8Var);
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
            jn jnVar = this.threadList.get(i2);
            if (jnVar instanceof rp4) {
                ThreadData threadData = ((rp4) jnVar).s;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String q = ys4.k().q("game_rank_list_info", "");
        if (!StringUtils.isNull(q) && q.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(jg.g(q.split(",")[0], 0L), System.currentTimeMillis()) < jg.e(q.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int l = ys4.k().l("game_rank_list_show_times", 0);
                    if (!z) {
                        l++;
                    }
                    ys4.k().w("game_rank_list_show_times", l);
                    if (l > 3) {
                        ys4 k = ys4.k();
                        k.y("game_rank_list_info", System.currentTimeMillis() + ",1");
                        ys4.k().w("game_rank_list_show_times", 0);
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
        dx5 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    jn jnVar = this.threadList.get(i2);
                    if (jnVar instanceof rp4) {
                        ThreadData threadData = ((rp4) jnVar).s;
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
        if8 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsInsertLiveData = getFrsInsertLiveData()) == null) {
            return;
        }
        ArrayList<jn> threadList = getThreadList();
        removeTopSameClassDataFromList(if8.class, threadList);
        threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.b, threadList.size()), frsInsertLiveData);
    }

    public void addMyNewThread(mo4 mo4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, mo4Var) == null) || mo4Var == null || StringUtils.isNull(mo4Var.getId()) || this.threadList == null) {
            return;
        }
        int topThreadSize = getTopThreadSize();
        ArrayList<jn> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            for (int i = 0; i < size; i++) {
                jn jnVar = threadList.get(i);
                if ((jnVar instanceof rp4) && mo4Var.getId().equals(((rp4) jnVar).s.getId()) && mo4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                    return;
                }
            }
        }
        mo4Var.isFromBrandForum = this.isBrandForum;
        this.postThreadCount++;
        this.threadList.add(topThreadSize, mo4Var);
    }

    public void addNoticeThreadToThreadList() {
        TopNoticeData top_notice_data;
        jn jnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getForum() == null || this.threadList == null || (top_notice_data = getForum().getTop_notice_data()) == null || top_notice_data.getTitle() == null) {
            return;
        }
        while (!this.threadList.isEmpty() && (jnVar = this.threadList.get(0)) != null && (jnVar instanceof rp4) && ((ThreadData) jnVar).getIs_top() == 2) {
            this.threadList.remove(0);
        }
        ThreadData threadData = new ThreadData();
        threadData.setTitle(top_notice_data.getTitle());
        threadData.setTid(top_notice_data.getTitle_link());
        threadData.setIs_top(2);
        threadData.parser_title();
        rp4 rp4Var = new rp4();
        rp4Var.s = threadData;
        this.threadList.add(0, rp4Var);
    }

    public void addOfficialBarToThreadList() {
        po4 po4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.forum == null || this.threadList == null || !ThreadData.isFRSExtraLoaded.get() || (po4Var = this.page) == null) {
            return;
        }
        boolean z = true;
        if (po4Var.a() == 1) {
            vf8 vf8Var = this.gconAccount;
            z = (vf8Var == null || !vf8Var.b()) ? false : false;
            if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof cg8)) {
                    this.threadList.remove(0);
                }
                cg8 cg8Var = new cg8();
                cg8Var.k(this.fortuneBag);
                cg8Var.m(this.fortuneDesc);
                cg8Var.q(this.gconAccount);
                cg8Var.setIs_top(1003);
                ArrayList<jn> arrayList = this.threadList;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                ListUtils.add(this.threadList, getTopThreadSize(), cg8Var);
            }
        }
    }

    public void addRecommendAppToThreadList(tg5 tg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tg5Var) == null) {
            addRecommendAppToThreadList(tg5Var, false, this.threadList, null, false);
        }
    }

    public void addRecommendBarsToThreadList() {
        ArrayList<jn> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.forum == null || (arrayList = this.threadList) == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<jn> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof cp4) {
                it.remove();
            }
        }
        po4 po4Var = this.page;
        if (po4Var == null || po4Var.a() != 1) {
            return;
        }
        ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
        cp4 cp4Var = new cp4();
        if (recommendForumData != null) {
            cp4Var.e().addAll(recommendForumData);
        }
        if (isShowRecommendBars(cp4Var.e())) {
            int i = 0;
            Iterator<jn> it2 = this.threadList.iterator();
            while (it2.hasNext()) {
                jn next = it2.next();
                if ((next instanceof rp4) && ((rp4) next).s.isTop()) {
                    i++;
                }
            }
            this.threadList.add(i + 1, cp4Var);
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
        jf8 frsStageLiveData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsStageLiveData = getFrsStageLiveData()) == null) {
            return;
        }
        ArrayList<jn> threadList = getThreadList();
        removeTopSameClassDataFromList(jf8.class, threadList);
        if (ListUtils.isEmpty(frsStageLiveData.a)) {
            return;
        }
        threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
    }

    public void addU9DataToThreadList() {
        ForumData forumData;
        po4 po4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (forumData = this.forum) == null) {
            return;
        }
        if (((forumData.getTopCode() == null || StringUtils.isNull(this.forum.getTopCode().g())) && (this.forum.getNewsInfo() == null || StringUtils.isNull(this.forum.getNewsInfo().N0()))) || (po4Var = this.page) == null || po4Var.a() != 1) {
            return;
        }
        jg8 jg8Var = new jg8();
        jg8Var.m(this.forum.getTopCode());
        jg8Var.q(this.forum.getNewsInfo());
        jg8Var.setIs_top(3);
        jg8Var.k(true);
        if (ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<jn> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            jn next = it.next();
            if (next instanceof ThreadData) {
                ThreadData threadData = (ThreadData) next;
                if (threadData.getIs_top() != 0) {
                    if (threadData.getIs_top() == 1003) {
                        jg8Var.k(false);
                    }
                    i++;
                }
            }
        }
        this.threadList.add(i, jg8Var);
    }

    public void addUserRecommendToThreadList() {
        int a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || getUserRecommend() == null) {
            return;
        }
        rb6 userRecommend = getUserRecommend();
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
        Iterator<jn> it = this.threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            jn next = it.next();
            if (next != null && next.getType() == uf8.c) {
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
        List<jn> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<jn> threadList = getThreadList();
        if (cardShipinPos == null || cardShipinPos.size() <= 0 || cardShipinNew == null || cardShipinNew.size() <= 0 || threadList == null) {
            return;
        }
        int size = cardShipinPos.size();
        int size2 = threadList.size();
        for (int i = 0; i < size; i++) {
            if (i < cardShipinNew.size()) {
                jn jnVar = cardShipinNew.get(i);
                int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + jnVar.getType());
                threadList.add(videoThreadInserPos, jnVar);
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<jn> arrayList;
        po4 po4Var;
        ArrayList<jn> arrayList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (arrayList = this.threadList) == null || arrayList.size() <= 0 || (po4Var = this.page) == null || po4Var.a() != 1 || (arrayList2 = this.threadList) == null || arrayList2.size() <= 0) {
            return;
        }
        int i = -1;
        int size = this.threadList.size();
        for (int i2 = 0; i2 < size; i2++) {
            jn jnVar = this.threadList.get(i2);
            if (jnVar instanceof rp4) {
                rp4 rp4Var = (rp4) jnVar;
                if (rp4Var.s.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && rp4Var.s.getThreadAlaInfo() != null && ((ThreadData) jnVar).getThreadAlaInfo().user_info != null && rp4Var.s.getThreadAlaInfo().user_info.is_official == 2 && rp4Var.s.getThreadAlaInfo().liveStageForceTop) {
                    i = i2;
                    break;
                }
            } else {
                if (jnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) jnVar;
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
                jn jnVar2 = this.threadList.get(i3);
                if (jnVar2 instanceof rp4) {
                    if (((rp4) jnVar2).s.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        i = i3;
                        break;
                    }
                } else {
                    if ((jnVar2 instanceof ThreadData) && ((ThreadData) jnVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
        List<jn> headLineDataInThreadList = getHeadLineDataInThreadList();
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

    public void filterEnterList(List<mf8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        Iterator<mf8> it = list.iterator();
        while (it.hasNext()) {
            mf8 next = it.next();
            if (next == null) {
                it.remove();
            } else if (StringUtils.isNull(next.i()) || StringUtils.isNull(next.f())) {
                if (next.a() != 1) {
                    it.remove();
                }
            }
        }
    }

    public ya6 getBrandAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.brandAdData : (ya6) invokeV.objValue;
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
            ArrayList<jn> threadList = getThreadList();
            if (threadList == null || threadList.size() <= 0) {
                return 0;
            }
            int size = threadList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (threadList.get(i2) instanceof mo4) {
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

    @Override // com.repackage.pf8
    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.recm_forum_list : (List) invokeV.objValue;
    }

    public List<jn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<mf8> list;
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
                arrayList.add(new tf8(forum, this.forumRule));
            }
            if (forum != null && !ki.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new sf8(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new sf8(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<jn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    jn jnVar = (jn) ListUtils.getItem(topThreadList, i4);
                    if (jnVar instanceof rp4) {
                        rp4 rp4Var = (rp4) jnVar;
                        arrayList.add(rp4Var.s);
                        if (rp4Var.s.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (jnVar instanceof ThreadData) {
                            arrayList.add(jnVar);
                            if (((ThreadData) jnVar).getIsMemberTop() != 1 || z) {
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
            ArrayList<jn> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<jn> it = arrayList.iterator();
            while (it.hasNext()) {
                jn next = it.next();
                if (next != null && (next instanceof rp4)) {
                    rp4 rp4Var = (rp4) next;
                    if (TextUtils.equals(str, rp4Var.s.getId())) {
                        return rp4Var.s;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public List<jn> getTopThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.topThreadList : (List) invokeV.objValue;
    }

    public int getTopThreadSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ArrayList<jn> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<jn> it = this.threadList.iterator();
                while (it.hasNext()) {
                    jn next = it.next();
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
            rf8 entelechyTabInfo = getEntelechyTabInfo();
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

    public boolean receiveData(pf8 pf8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, pf8Var)) == null) {
            if (pf8Var == null) {
                return false;
            }
            this.isFromCache = pf8Var.isFromCache;
            setSortType(pf8Var.getSortType());
            setAnti(pf8Var.getAnti());
            setChatGroup(pf8Var.getChatGroup());
            setFortuneBag(pf8Var.isFortuneBag());
            setFortuneDesc(pf8Var.getFortuneDesc());
            setForum(pf8Var.getForum());
            setGameName(pf8Var.getGameName());
            setGameUrl(pf8Var.getGameUrl());
            setGconAccount(pf8Var.getGconAccount());
            setHasGame(pf8Var.isHasGame());
            setIsNewUrl(pf8Var.getIsNewUrl());
            setPhotoLivePos(pf8Var.getPhotoLivePos());
            setPage(pf8Var.getPage());
            setStar(pf8Var.getStar());
            setStarEnter(pf8Var.getStarEnter());
            setThreadList(pf8Var.threadList);
            setThreadListIds(pf8Var.getThreadListIds());
            setUserData(pf8Var.getUserData());
            setUserMap(pf8Var.getUserMap());
            setActivityHeadData(pf8Var.getActivityHeadData());
            setFrsDefaultTabId(pf8Var.getFrsDefaultTabId());
            this.defaultShowTab = pf8Var.defaultShowTab;
            setCategoryInfos(pf8Var.getCategoryInfos());
            setBawuCenterUrl(pf8Var.getBawuCenterUrl());
            setCardVideoInfo(pf8Var.getCardVideoInfo());
            setHeadSdkData(pf8Var.getHeadSdkData());
            setSchoolRecommendPos(pf8Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(pf8Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(pf8Var.getEntelechyTabInfo());
            setAlaLiveCount(pf8Var.getAlaLiveCount());
            setCarrierEnterData(pf8Var.getCarrierEnterData());
            setForumState(pf8Var.getForumState());
            setAccessFlag(pf8Var.getAccessFlag());
            this.needLog = pf8Var.needLog;
            this.recommendBookData = pf8Var.recommendBookData;
            this.presentInfoData = pf8Var.presentInfoData;
            setBookInfo(pf8Var.getBookInfo());
            setMangaReadRecordChapterId(pf8Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(pf8Var.getHeadlineImgInfoData());
            setCardShipinPos(pf8Var.getCardShipinPos());
            setCardShipinNew(pf8Var.getCardShipinNew());
            this.enterFrsDialogInfo = pf8Var.enterFrsDialogInfo;
            setGameRankListData(pf8Var.getGameRankListData());
            setAgreeBanner(pf8Var.getAgreeBanner());
            setLiveNotify(pf8Var.getLiveNotify());
            setGameTabInfo(pf8Var.getGameTabInfo());
            setGameDefaultTabId(pf8Var.getGameDefaultTabId());
            setForumHeadIcon(pf8Var.getForumHeadIcon());
            setUserRecommend(pf8Var.getUserRecommend());
            setFrsVideoActivityData(pf8Var.getFrsVideoActivityData());
            this.mNewChapterInfo = pf8Var.mNewChapterInfo;
            setFrsInsertLiveData(pf8Var.getFrsInsertLiveData());
            this.recm_forum_list = pf8Var.getRecm_forum_list();
            setFrsStageLiveData(pf8Var.getFrsStageLiveData());
            this.forumArIno = pf8Var.forumArIno;
            this.starRank = pf8Var.starRank;
            this.postTopic = pf8Var.postTopic;
            this.mWindowToast = pf8Var.mWindowToast;
            this.activityConfig = pf8Var.activityConfig;
            setIsShowRedTip(pf8Var.isShowRedTip());
            this.isBrandForum = pf8Var.isBrandForum;
            this.brandAdData = pf8Var.brandAdData;
            this.oriForumInfoList = pf8Var.oriForumInfoList;
            this.bottomMenuList = pf8Var.bottomMenuList;
            this.adMixFloor = pf8Var.adMixFloor;
            this.adShowSelect = pf8Var.adShowSelect;
            this.adSampleMapKey = pf8Var.adSampleMapKey;
            wa6.f().n(getAnti());
            wa6.f().q(pf8Var.getForum().getId());
            wa6.f().r(pf8Var.getForum().getName());
            va6.h().q(pf8Var.getForum().getId());
            if (pf8Var.getEntelechyTabInfo() != null) {
                va6.h().r(pf8Var.getEntelechyTabInfo().a);
            }
            if (pf8Var.getUserData() != null) {
                xa6.c().e(pf8Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(pf8Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(pf8Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = pf8Var.smartAppAvatar;
            this.smartApp = pf8Var.smartApp;
            this.nebulaHotThreads = pf8Var.nebulaHotThreads;
            this.forumActiveInfo = pf8Var.forumActiveInfo;
            this.userList = pf8Var.userList;
            setBusinessPromot(pf8Var.getBusinessPromot());
            this.serviceAreaData = pf8Var.serviceAreaData;
            setHotUserRankData(pf8Var.getHotUserRankData());
            this.itemInfo = pf8Var.itemInfo;
            this.toLoadHorseData = pf8Var.toLoadHorseData;
            this.forumRule = pf8Var.forumRule;
            this.mSignActivityInfo = pf8Var.mSignActivityInfo;
            this.showAdsense = pf8Var.showAdsense;
            setVoiceRoomConfig(pf8Var.getVoiceRoomConfig());
            setVoiceRoomData(pf8Var.getVoiceRoomData());
            this.serviceAreaFlutterData = pf8Var.serviceAreaFlutterData;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void removeAlaInsertLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            removeTopSameClassDataFromList(if8.class, getThreadList());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<jn> arrayList;
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
            removeTopSameClassDataFromList(jf8.class, getThreadList());
        }
    }

    public void removeGameRankListFromThreadList() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<jn> it = this.threadList.iterator();
        while (it.hasNext()) {
            jn next = it.next();
            if (next != null && next.getType() == zp6.e) {
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
        Iterator<jn> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof rb6) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void removeThread(String str) {
        ArrayList<jn> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, str) == null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<jn> it = arrayList.iterator();
        while (it.hasNext()) {
            jn next = it.next();
            if (next != null && (next instanceof rp4) && TextUtils.equals(str, ((rp4) next).s.getId())) {
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

    public void setFunAdController(rp6 rp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, rp6Var) == null) {
            this.funAdController = rp6Var;
        }
    }

    public void setTopThreadList(List<jn> list) {
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
        Iterator<jn> it = this.threadList.iterator();
        while (it.hasNext()) {
            jn next = it.next();
            if (next != null && (next instanceof rp4)) {
                rp4 rp4Var = (rp4) next;
                if (rp4Var.s.getAuthor() != null && currentAccount.equals(rp4Var.s.getAuthor().getUserId()) && rp4Var.s.getAuthor().getPendantData() != null) {
                    rp4Var.s.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                    rp4Var.s.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                }
            }
        }
    }

    public void updateLikeData(ff8 ff8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, ff8Var) == null) || ff8Var == null) {
            return;
        }
        ag8 ag8Var = new ag8();
        ag8Var.y(1);
        ag8Var.z(ff8Var.a);
        ag8Var.w(ff8Var.b);
        ag8Var.u(ff8Var.c);
        ag8Var.x(ff8Var.d);
        updateLikeData(ag8Var);
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

    public void addRecommendAppToThreadList(tg5 tg5Var, ArrayList<jn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, tg5Var, arrayList) == null) {
            addRecommendAppToThreadList(tg5Var, false, arrayList, null, false);
        }
    }

    public void addRecommendAppToThreadList(tg5 tg5Var, boolean z, ArrayList<jn> arrayList, ArrayList<jn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{tg5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
            bh5 bh5Var = new bh5(tg5Var, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                next.setFromFrs(true);
                next.setSortType(getSortType());
                arrayList3.add(next);
            }
            bh5Var.r(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bh5Var));
            bh5 bh5Var2 = new bh5(tg5Var, 3);
            bh5Var2.x(z);
            bh5Var2.E(arrayList);
            bh5Var2.B(arrayList2);
            bh5Var2.w(z2);
            bh5Var2.s(getPage().a());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bh5Var2));
        }
    }

    public void updateLikeData(ag8 ag8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, ag8Var) == null) || ag8Var == null) {
            return;
        }
        this.forum.setCurScore(ag8Var.c());
        this.forum.setLevelupScore(ag8Var.i());
        this.forum.setLike(ag8Var.n());
        this.forum.setUser_level(ag8Var.m());
        this.forum.setLevelName(ag8Var.h());
    }
}
