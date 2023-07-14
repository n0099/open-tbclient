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
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.TopNoticeData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.by7;
import com.baidu.tieba.da5;
import com.baidu.tieba.gba;
import com.baidu.tieba.hba;
import com.baidu.tieba.i56;
import com.baidu.tieba.kba;
import com.baidu.tieba.lba;
import com.baidu.tieba.li7;
import com.baidu.tieba.nba;
import com.baidu.tieba.oh7;
import com.baidu.tieba.oq6;
import com.baidu.tieba.pba;
import com.baidu.tieba.ph7;
import com.baidu.tieba.pra;
import com.baidu.tieba.q56;
import com.baidu.tieba.qba;
import com.baidu.tieba.qh7;
import com.baidu.tieba.rba;
import com.baidu.tieba.sba;
import com.baidu.tieba.sra;
import com.baidu.tieba.t35;
import com.baidu.tieba.uy7;
import com.baidu.tieba.w35;
import com.baidu.tieba.wg;
import com.baidu.tieba.xi;
import com.baidu.tieba.yba;
import com.baidu.tieba.yn;
import com.baidu.tieba.yr5;
import com.baidu.tieba.z45;
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
/* loaded from: classes8.dex */
public class FrsViewData extends nba implements yr5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public by7 funAdController;
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

    public void clearPostThreadCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.postThreadCount = 0;
        }
    }

    public ForumActiveInfo getForumActiveInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.forumActiveInfo;
        }
        return (ForumActiveInfo) invokeV.objValue;
    }

    public BdUniqueId getFrsFragmentTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.frsFragmentTag;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean getIsBrandForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.isBrandForum;
        }
        return invokeV.booleanValue;
    }

    public int getPostThreadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.postThreadCount;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.nba
    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.recm_forum_list;
        }
        return (List) invokeV.objValue;
    }

    public SignData getSignData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            ForumData forumData = this.forum;
            if (forumData == null) {
                return null;
            }
            return forumData.getSignData();
        }
        return (SignData) invokeV.objValue;
    }

    public List<yn> getTopThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.topThreadList;
        }
        return (List) invokeV.objValue;
    }

    public boolean hasTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (getEntelechyTabInfo() == null || ListUtils.isEmpty(getEntelechyTabInfo().a)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isPrivateForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (getForum() == null || getForum().getIsPrivateForum() == 0 || getForum().getIsPrivateForum() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isStarForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (getStar() == null || getStar().b() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void removeAlaInsertLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            removeTopSameClassDataFromList(gba.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            removeTopSameClassDataFromList(hba.class, getThreadList());
        }
    }

    private int getAlaLiveThreadCardInsertPos(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, this, i, i2)) == null) {
            return Math.min((getTopThreadSize() + i) - 1, i2);
        }
        return invokeII.intValue;
    }

    private int getVideoThreadInserPos(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, this, i, i2)) == null) {
            return Math.min((getTopThreadSize() + i) - 1, i2);
        }
        return invokeII.intValue;
    }

    public void addRecommendAppToThreadList(i56 i56Var, ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, i56Var, arrayList) == null) {
            addRecommendAppToThreadList(i56Var, false, arrayList, null, false);
        }
    }

    private List<yn> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        w35 w35Var;
        ArrayList<yn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<yn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (w35Var = this.page) != null && w35Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    yn ynVar = this.threadList.get(i);
                    if (ynVar instanceof z45) {
                        if (((z45) ynVar).t.isHeadLinePost) {
                            arrayList2.add(ynVar);
                        }
                    } else if ((ynVar instanceof ThreadData) && ((ThreadData) ynVar).isHeadLinePost) {
                        arrayList2.add(ynVar);
                    }
                }
            }
            return arrayList2;
        }
        return (List) invokeV.objValue;
    }

    public void addFeedForumDataToThreadList() {
        ForumData forumData;
        List<FeedForumData> feedForumList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.threadList == null || (forumData = this.forum) == null || forumData.getBannerListData() == null || MessageManager.getInstance().findTask(2003016) == null) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            yn ynVar = this.threadList.get(i2);
            if (ynVar instanceof z45) {
                ThreadData threadData = ((z45) ynVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            lba lbaVar = new lba();
            lbaVar.d(this.forum.getId());
            lbaVar.c(feedForumList);
            this.threadList.add(i + 6, lbaVar);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        oq6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    yn ynVar = this.threadList.get(i2);
                    if (ynVar instanceof z45) {
                        ThreadData threadData = ((z45) ynVar).t;
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

    public void addNoticeThreadToThreadList() {
        TopNoticeData top_notice_data;
        yn ynVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (ynVar = this.threadList.get(0)) != null && (ynVar instanceof z45) && ((ThreadData) ynVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            z45 z45Var = new z45();
            z45Var.t = threadData;
            this.threadList.add(0, z45Var);
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || getForum() == null) {
            return;
        }
        List<yn> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<yn> threadList = getThreadList();
        if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
            int size = cardShipinPos.size();
            int size2 = threadList.size();
            for (int i = 0; i < size; i++) {
                if (i < cardShipinNew.size()) {
                    yn ynVar = cardShipinNew.get(i);
                    int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                    Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + ynVar.getType());
                    threadList.add(videoThreadInserPos, ynVar);
                }
            }
        }
    }

    private int getPhotoliveCardInsertPos(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) {
            return Math.min((getTopThreadSize() + getPhotoLivePos()) - 1, i);
        }
        return invokeI.intValue;
    }

    public void addRecommendAppToThreadList(i56 i56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i56Var) == null) {
            addRecommendAppToThreadList(i56Var, false, this.threadList, null, false);
        }
    }

    public void removeThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, threadData) == null) {
            this.threadList.remove(threadData);
        }
    }

    public void setFrsFragmentTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, bdUniqueId) == null) {
            this.frsFragmentTag = bdUniqueId;
        }
    }

    public void setFunAdController(by7 by7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, by7Var) == null) {
            this.funAdController = by7Var;
        }
    }

    public void setTopThreadList(List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, list) == null) {
            this.topThreadList = list;
        }
    }

    public void updateLoadMoreBannerListData(BannerListData bannerListData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bannerListData) == null) {
            this.isLoadMore = true;
            this.loadMoreBannerListData = bannerListData;
        }
    }

    public void updateSignData(SignData signData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048623, this, signData) != null) || signData == null) {
            return;
        }
        this.forum.setSignData(signData);
    }

    private void removeTopSameClassDataFromList(Class cls, ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, cls, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                yn ynVar = arrayList.get(i);
                if (ynVar.getClass() == cls) {
                    arrayList2.add(ynVar);
                    break;
                }
                i++;
            }
            if (!arrayList2.isEmpty()) {
                arrayList.removeAll(arrayList2);
            }
        }
    }

    public void addCardVideoInfoToThreadList() {
        ThreadData cardVideoInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && getForum() != null && (cardVideoInfo = getCardVideoInfo()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + cardVideoInfo.getTid());
            ArrayList<yn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addHeaderCardToThreadList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            pra praVar = new pra();
            praVar.e(this.headerCard);
            if (sra.i(praVar, true)) {
                sra sraVar = new sra();
                sraVar.g(2);
                ForumData forumData = this.forum;
                if (forumData != null) {
                    sraVar.e(forumData.getId());
                    sraVar.f(this.forum.getName());
                }
                sraVar.d(praVar);
                if (ListUtils.add(this.threadList, sraVar.getPosition(), sraVar)) {
                    sraVar.position = sraVar.getPosition();
                }
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        hba frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<yn> threadList = getThreadList();
            removeTopSameClassDataFromList(hba.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<yn> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                yn next = it.next();
                if (next != null && next.getType() == sba.c) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<yn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0) {
            for (int i = 0; i < this.threadList.size(); i++) {
                if (this.threadList.get(i).getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE || this.threadList.get(i).getType() == ThreadData.TYPE_ALA_LIVE_EMPTY || this.threadList.get(i).getType() == ThreadData.TYPE_ALA_SHARE_THREAD) {
                    this.threadList.remove(i);
                }
            }
        }
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
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        removeGameRankListFromThreadList();
        if (getGameRankListData() == null) {
            return;
        }
        boolean z3 = false;
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            yn ynVar = this.threadList.get(i2);
            if (ynVar instanceof z45) {
                ThreadData threadData = ((z45) ynVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String w = da5.p().w("game_rank_list_info", "");
        if (!StringUtils.isNull(w) && w.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(wg.g(w.split(",")[0], 0L), System.currentTimeMillis()) < wg.e(w.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int q = da5.p().q("game_rank_list_show_times", 0);
                    if (!z) {
                        q++;
                    }
                    da5.p().F("game_rank_list_show_times", q);
                    if (q > 3) {
                        da5 p = da5.p();
                        p.J("game_rank_list_info", System.currentTimeMillis() + ",1");
                        da5.p().F("game_rank_list_show_times", 0);
                        if (!z3) {
                            return;
                        }
                        this.threadList.add((i + getGameRankListData().a()) - 1, getGameRankListData());
                        return;
                    }
                }
                z3 = z2;
                if (!z3) {
                }
            }
        }
        z2 = true;
        if (z2) {
        }
        z3 = z2;
        if (!z3) {
        }
    }

    public void addInsertLiveDataToThreadList() {
        gba frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<yn> threadList = getThreadList();
            removeTopSameClassDataFromList(gba.class, threadList);
            threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.b, threadList.size()), frsInsertLiveData);
        }
    }

    public void addSchoolRecommendToThreadList() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || MessageManager.getInstance().findTask(2003016) == null) {
            return;
        }
        int schoolRecommendPos = (getSchoolRecommendPos() + getTopThreadSize()) - 1;
        if (getSchoolRecommendUserInfo() != null && schoolRecommendPos >= 0 && schoolRecommendPos <= this.threadList.size()) {
            this.threadList.add(schoolRecommendPos, getSchoolRecommendUserInfo());
        }
    }

    public void addUserRecommendToThreadList() {
        int a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && getUserRecommend() != null) {
            li7 userRecommend = getUserRecommend();
            if (ListUtils.getCount(userRecommend.c()) < 3 || (a = userRecommend.a()) <= 0) {
                return;
            }
            int topThreadSize = a + getTopThreadSize();
            if (topThreadSize > this.threadList.size()) {
                this.threadList.add(userRecommend);
            } else {
                this.threadList.add(topThreadSize, userRecommend);
            }
        }
    }

    public int getTopThreadSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ArrayList<yn> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<yn> it = this.threadList.iterator();
                while (it.hasNext()) {
                    yn next = it.next();
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

    public boolean isFirstTabEqualAllThread() {
        InterceptResult invokeV;
        List<FrsTabInfo> list;
        FrsTabInfo frsTabInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            pba entelechyTabInfo = getEntelechyTabInfo();
            if (entelechyTabInfo == null || (list = entelechyTabInfo.a) == null || list.size() <= 0 || (frsTabInfo = list.get(0)) == null || frsTabInfo.tab_id.intValue() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void removeGameRankListFromThreadList() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && !ListUtils.isEmpty(this.threadList)) {
            Iterator<yn> it = this.threadList.iterator();
            while (it.hasNext()) {
                yn next = it.next();
                if (next != null && next.getType() == uy7.e) {
                    it.remove();
                }
            }
        }
    }

    public void removeRedundantUserRecommendData() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048614, this) != null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        boolean z = false;
        Iterator<yn> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof li7) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(t35 t35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, t35Var) == null) && t35Var != null && !StringUtils.isNull(t35Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<yn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    yn ynVar = threadList.get(i);
                    if ((ynVar instanceof z45) && t35Var.getId().equals(((z45) ynVar).t.getId()) && t35Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            t35Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, t35Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<yn> it = this.threadList.iterator();
            while (it.hasNext()) {
                yn next = it.next();
                if (next != null && (next instanceof z45)) {
                    z45 z45Var = (z45) next;
                    if (z45Var.t.getAuthor() != null && currentAccount.equals(z45Var.t.getAuthor().getUserId()) && z45Var.t.getAuthor().getPendantData() != null) {
                        z45Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        z45Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(i56 i56Var, boolean z, ArrayList<yn> arrayList, ArrayList<yn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{i56Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
            if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
                q56 q56Var = new q56(i56Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                q56Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, q56Var));
                q56 q56Var2 = new q56(i56Var, 3);
                q56Var2.z(z);
                q56Var2.G(arrayList);
                q56Var2.D(arrayList2);
                q56Var2.y(z2);
                q56Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    q56Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    q56Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, q56Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<yn> arrayList;
        w35 w35Var;
        ArrayList<yn> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (w35Var = this.page) != null && w35Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                yn ynVar = this.threadList.get(i2);
                if (ynVar instanceof z45) {
                    z45 z45Var = (z45) ynVar;
                    if (z45Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && z45Var.t.getThreadAlaInfo() != null && z45Var.t.getThreadAlaInfo().user_info != null && z45Var.t.getThreadAlaInfo().user_info.is_official == 2 && z45Var.t.getThreadAlaInfo().liveStageForceTop) {
                        i = i2;
                        break;
                    }
                } else {
                    if (ynVar instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) ynVar;
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
                    yn ynVar2 = this.threadList.get(i3);
                    if (ynVar2 instanceof z45) {
                        if (((z45) ynVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((ynVar2 instanceof ThreadData) && ((ThreadData) ynVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
            List<yn> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!ListUtils.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    public void filterEnterList(List<kba> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, list) == null) && list != null && list.size() != 0) {
            Iterator<kba> it = list.iterator();
            while (it.hasNext()) {
                kba next = it.next();
                if (next == null) {
                    it.remove();
                } else if (StringUtils.isNull(next.f()) || StringUtils.isNull(next.d())) {
                    if (next.a() != 1) {
                        it.remove();
                    }
                }
            }
        }
    }

    public List<yn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<kba> list;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(getStarEnter())) {
                list = getStarEnter();
                filterEnterList(list);
            } else {
                list = null;
            }
            if (!ListUtils.isEmpty(list)) {
                i = 0;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (list.get(i2).a() == 1) {
                        arrayList.add(list.get(i2));
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            ForumData forum = getForum();
            if (forum != null && getForum().getIsShowRule() && this.forumRule != null && (getUserData().getIs_manager() == 1 || this.forumRule.has_forum_rule.intValue() == 1)) {
                arrayList.add(new rba(forum, this.forumRule));
            }
            if (forum != null && !xi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new qba(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new qba(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<yn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    yn ynVar = (yn) ListUtils.getItem(topThreadList, i4);
                    if (ynVar instanceof z45) {
                        z45 z45Var = (z45) ynVar;
                        arrayList.add(z45Var.t);
                        if (z45Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (ynVar instanceof ThreadData) {
                            arrayList.add(ynVar);
                            if (((ThreadData) ynVar).getIsMemberTop() != 1 || z) {
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

    public ThreadData getThreadDataById(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            ArrayList<yn> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<yn> it = arrayList.iterator();
            while (it.hasNext()) {
                yn next = it.next();
                if (next != null && (next instanceof z45)) {
                    z45 z45Var = (z45) next;
                    if (TextUtils.equals(str, z45Var.t.getId())) {
                        return z45Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public void removeThread(String str) {
        ArrayList<yn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048615, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<yn> it = arrayList.iterator();
        while (it.hasNext()) {
            yn next = it.next();
            if (next != null && (next instanceof z45) && TextUtils.equals(str, ((z45) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(yba ybaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048621, this, ybaVar) != null) || ybaVar == null) {
            return;
        }
        this.forum.setCurScore(ybaVar.c());
        this.forum.setLevelupScore(ybaVar.i());
        this.forum.setLike(ybaVar.n());
        this.forum.setUser_level(ybaVar.m());
        this.forum.setLevelName(ybaVar.h());
    }

    public boolean receiveData(nba nbaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, nbaVar)) == null) {
            if (nbaVar == null) {
                return false;
            }
            this.isFromCache = nbaVar.isFromCache;
            setBaWuNoticeNum(nbaVar.getBaWuNoticeNum());
            setSortType(nbaVar.getSortType());
            setAnti(nbaVar.getAnti());
            setChatGroup(nbaVar.getChatGroup());
            setFortuneBag(nbaVar.isFortuneBag());
            setFortuneDesc(nbaVar.getFortuneDesc());
            setForum(nbaVar.getForum());
            setGameName(nbaVar.getGameName());
            setGameUrl(nbaVar.getGameUrl());
            setGconAccount(nbaVar.getGconAccount());
            setHasGame(nbaVar.isHasGame());
            setIsNewUrl(nbaVar.getIsNewUrl());
            setPhotoLivePos(nbaVar.getPhotoLivePos());
            setPage(nbaVar.getPage());
            setStar(nbaVar.getStar());
            setStarEnter(nbaVar.getStarEnter());
            setThreadList(nbaVar.threadList);
            setThreadListIds(nbaVar.getThreadListIds());
            setUserData(nbaVar.getUserData());
            setUserMap(nbaVar.getUserMap());
            setActivityHeadData(nbaVar.getActivityHeadData());
            setFrsDefaultTabId(nbaVar.getFrsDefaultTabId());
            this.defaultShowTab = nbaVar.defaultShowTab;
            setCategoryInfos(nbaVar.getCategoryInfos());
            setBawuCenterUrl(nbaVar.getBawuCenterUrl());
            setCardVideoInfo(nbaVar.getCardVideoInfo());
            setHeadSdkData(nbaVar.getHeadSdkData());
            setSchoolRecommendPos(nbaVar.getSchoolRecommendPos());
            setSchoolRecommendInfo(nbaVar.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(nbaVar.getEntelechyTabInfo());
            setAlaLiveCount(nbaVar.getAlaLiveCount());
            setCarrierEnterData(nbaVar.getCarrierEnterData());
            setForumState(nbaVar.getForumState());
            setAccessFlag(nbaVar.getAccessFlag());
            this.needLog = nbaVar.needLog;
            this.recommendBookData = nbaVar.recommendBookData;
            this.presentInfoData = nbaVar.presentInfoData;
            setBookInfo(nbaVar.getBookInfo());
            setMangaReadRecordChapterId(nbaVar.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(nbaVar.getHeadlineImgInfoData());
            setCardShipinPos(nbaVar.getCardShipinPos());
            setCardShipinNew(nbaVar.getCardShipinNew());
            this.enterFrsDialogInfo = nbaVar.enterFrsDialogInfo;
            setGameRankListData(nbaVar.getGameRankListData());
            setAgreeBanner(nbaVar.getAgreeBanner());
            setLiveNotify(nbaVar.getLiveNotify());
            setGameTabInfo(nbaVar.getGameTabInfo());
            setGameDefaultTabId(nbaVar.getGameDefaultTabId());
            setForumHeadIcon(nbaVar.getForumHeadIcon());
            setUserRecommend(nbaVar.getUserRecommend());
            setFrsVideoActivityData(nbaVar.getFrsVideoActivityData());
            this.mNewChapterInfo = nbaVar.mNewChapterInfo;
            setFrsInsertLiveData(nbaVar.getFrsInsertLiveData());
            this.recm_forum_list = nbaVar.getRecm_forum_list();
            setFrsStageLiveData(nbaVar.getFrsStageLiveData());
            this.forumArIno = nbaVar.forumArIno;
            this.starRank = nbaVar.starRank;
            this.postTopic = nbaVar.postTopic;
            this.mWindowToast = nbaVar.mWindowToast;
            this.activityConfig = nbaVar.activityConfig;
            setIsShowRedTip(nbaVar.isShowRedTip());
            this.isBrandForum = nbaVar.isBrandForum;
            this.brandAdData = nbaVar.brandAdData;
            this.oriForumInfoList = nbaVar.oriForumInfoList;
            this.bottomMenuList = nbaVar.bottomMenuList;
            this.adMixFloor = nbaVar.adMixFloor;
            this.adShowSelect = nbaVar.adShowSelect;
            this.adSampleMapKey = nbaVar.adSampleMapKey;
            ph7.f().n(getAnti());
            ph7.f().q(nbaVar.getForum().getId());
            ph7.f().r(nbaVar.getForum().getName());
            oh7.h().q(nbaVar.getForum().getId());
            if (nbaVar.getEntelechyTabInfo() != null) {
                oh7.h().r(nbaVar.getEntelechyTabInfo().a);
            }
            if (nbaVar.getUserData() != null) {
                qh7.c().e(nbaVar.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(nbaVar.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(nbaVar.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = nbaVar.smartAppAvatar;
            this.smartApp = nbaVar.smartApp;
            this.nebulaHotThreads = nbaVar.nebulaHotThreads;
            this.forumActiveInfo = nbaVar.forumActiveInfo;
            this.userList = nbaVar.userList;
            setBusinessPromot(nbaVar.getBusinessPromot());
            this.serviceAreaData = nbaVar.serviceAreaData;
            setHotUserRankData(nbaVar.getHotUserRankData());
            this.itemInfo = nbaVar.itemInfo;
            this.toLoadHorseData = nbaVar.toLoadHorseData;
            this.forumRule = nbaVar.forumRule;
            this.mSignActivityInfo = nbaVar.mSignActivityInfo;
            this.showAdsense = nbaVar.showAdsense;
            setVoiceRoomConfig(nbaVar.getVoiceRoomConfig());
            setVoiceRoomData(nbaVar.getVoiceRoomData());
            this.serviceAreaFlutterData = nbaVar.serviceAreaFlutterData;
            this.liveFuseForumDataList = nbaVar.liveFuseForumDataList;
            this.frsGameRankInfoData = nbaVar.frsGameRankInfoData;
            this.frsBannerHeaderData = nbaVar.frsBannerHeaderData;
            this.forumTagInfo = nbaVar.forumTagInfo;
            this.firstCategory = nbaVar.firstCategory;
            this.frsForumGroup = nbaVar.frsForumGroup;
            this.headerCard = nbaVar.headerCard;
            this.frsSpriteNewUserGuide = nbaVar.frsSpriteNewUserGuide;
            return true;
        }
        return invokeL.booleanValue;
    }
}
