package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
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
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.b35;
import com.baidu.tieba.bxa;
import com.baidu.tieba.cga;
import com.baidu.tieba.cn;
import com.baidu.tieba.d46;
import com.baidu.tieba.dga;
import com.baidu.tieba.e35;
import com.baidu.tieba.ei;
import com.baidu.tieba.exa;
import com.baidu.tieba.gga;
import com.baidu.tieba.gq6;
import com.baidu.tieba.h45;
import com.baidu.tieba.hga;
import com.baidu.tieba.iz7;
import com.baidu.tieba.jga;
import com.baidu.tieba.l46;
import com.baidu.tieba.lga;
import com.baidu.tieba.mga;
import com.baidu.tieba.nga;
import com.baidu.tieba.nr5;
import com.baidu.tieba.oga;
import com.baidu.tieba.py7;
import com.baidu.tieba.si7;
import com.baidu.tieba.vh7;
import com.baidu.tieba.wh7;
import com.baidu.tieba.xh7;
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
public class FrsViewData extends jga implements nr5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public py7 funAdController;
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

    @Override // com.baidu.tieba.jga
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

    public List<cn> getTopThreadList() {
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
            removeTopSameClassDataFromList(cga.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            removeTopSameClassDataFromList(dga.class, getThreadList());
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

    public void addRecommendAppToThreadList(d46 d46Var, ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, d46Var, arrayList) == null) {
            addRecommendAppToThreadList(d46Var, false, arrayList, null, false);
        }
    }

    private List<cn> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        e35 e35Var;
        ArrayList<cn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<cn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (e35Var = this.page) != null && e35Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    cn cnVar = this.threadList.get(i);
                    if (cnVar instanceof h45) {
                        if (((h45) cnVar).t.isHeadLinePost) {
                            arrayList2.add(cnVar);
                        }
                    } else if ((cnVar instanceof ThreadData) && ((ThreadData) cnVar).isHeadLinePost) {
                        arrayList2.add(cnVar);
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
            cn cnVar = this.threadList.get(i2);
            if (cnVar instanceof h45) {
                ThreadData threadData = ((h45) cnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            hga hgaVar = new hga();
            hgaVar.d(this.forum.getId());
            hgaVar.c(feedForumList);
            this.threadList.add(i + 6, hgaVar);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        gq6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    cn cnVar = this.threadList.get(i2);
                    if (cnVar instanceof h45) {
                        ThreadData threadData = ((h45) cnVar).t;
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
        cn cnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (cnVar = this.threadList.get(0)) != null && (cnVar instanceof h45) && ((ThreadData) cnVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            h45 h45Var = new h45();
            h45Var.t = threadData;
            this.threadList.add(0, h45Var);
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || getForum() == null) {
            return;
        }
        List<cn> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<cn> threadList = getThreadList();
        if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
            int size = cardShipinPos.size();
            int size2 = threadList.size();
            for (int i = 0; i < size; i++) {
                if (i < cardShipinNew.size()) {
                    cn cnVar = cardShipinNew.get(i);
                    int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                    Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + cnVar.getType());
                    threadList.add(videoThreadInserPos, cnVar);
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

    public void addRecommendAppToThreadList(d46 d46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d46Var) == null) {
            addRecommendAppToThreadList(d46Var, false, this.threadList, null, false);
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

    public void setFunAdController(py7 py7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, py7Var) == null) {
            this.funAdController = py7Var;
        }
    }

    public void setTopThreadList(List<cn> list) {
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, cls, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                cn cnVar = arrayList.get(i);
                if (cnVar.getClass() == cls) {
                    arrayList2.add(cnVar);
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
            ArrayList<cn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addHeaderCardToThreadList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            bxa bxaVar = new bxa();
            bxaVar.e(this.headerCard);
            if (exa.i(bxaVar, true)) {
                exa exaVar = new exa();
                exaVar.g(2);
                ForumData forumData = this.forum;
                if (forumData != null) {
                    exaVar.e(forumData.getId());
                    exaVar.f(this.forum.getName());
                }
                exaVar.d(bxaVar);
                if (ListUtils.add(this.threadList, exaVar.getPosition(), exaVar)) {
                    exaVar.position = exaVar.getPosition();
                }
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        dga frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<cn> threadList = getThreadList();
            removeTopSameClassDataFromList(dga.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<cn> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                cn next = it.next();
                if (next != null && next.getType() == oga.c) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<cn> arrayList;
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
            cn cnVar = this.threadList.get(i2);
            if (cnVar instanceof h45) {
                ThreadData threadData = ((h45) cnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String string = SharedPrefHelper.getInstance().getString("game_rank_list_info", "");
        if (!StringUtils.isNull(string) && string.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(JavaTypesHelper.toLong(string.split(",")[0], 0L), System.currentTimeMillis()) < JavaTypesHelper.toInt(string.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int i3 = SharedPrefHelper.getInstance().getInt("game_rank_list_show_times", 0);
                    if (!z) {
                        i3++;
                    }
                    SharedPrefHelper.getInstance().putInt("game_rank_list_show_times", i3);
                    if (i3 > 3) {
                        SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                        sharedPrefHelper.putString("game_rank_list_info", System.currentTimeMillis() + ",1");
                        SharedPrefHelper.getInstance().putInt("game_rank_list_show_times", 0);
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
        cga frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<cn> threadList = getThreadList();
            removeTopSameClassDataFromList(cga.class, threadList);
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
            si7 userRecommend = getUserRecommend();
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
            ArrayList<cn> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<cn> it = this.threadList.iterator();
                while (it.hasNext()) {
                    cn next = it.next();
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
            lga entelechyTabInfo = getEntelechyTabInfo();
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
            Iterator<cn> it = this.threadList.iterator();
            while (it.hasNext()) {
                cn next = it.next();
                if (next != null && next.getType() == iz7.e) {
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
        Iterator<cn> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof si7) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(b35 b35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, b35Var) == null) && b35Var != null && !StringUtils.isNull(b35Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<cn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    cn cnVar = threadList.get(i);
                    if ((cnVar instanceof h45) && b35Var.getId().equals(((h45) cnVar).t.getId()) && b35Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            b35Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, b35Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<cn> it = this.threadList.iterator();
            while (it.hasNext()) {
                cn next = it.next();
                if (next != null && (next instanceof h45)) {
                    h45 h45Var = (h45) next;
                    if (h45Var.t.getAuthor() != null && currentAccount.equals(h45Var.t.getAuthor().getUserId()) && h45Var.t.getAuthor().getPendantData() != null) {
                        h45Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        h45Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(d46 d46Var, boolean z, ArrayList<cn> arrayList, ArrayList<cn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{d46Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                l46 l46Var = new l46(d46Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                l46Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, l46Var));
                l46 l46Var2 = new l46(d46Var, 3);
                l46Var2.z(z);
                l46Var2.G(arrayList);
                l46Var2.D(arrayList2);
                l46Var2.y(z2);
                l46Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    l46Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    l46Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, l46Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<cn> arrayList;
        e35 e35Var;
        ArrayList<cn> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (e35Var = this.page) != null && e35Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                cn cnVar = this.threadList.get(i2);
                if (cnVar instanceof h45) {
                    h45 h45Var = (h45) cnVar;
                    if (h45Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && h45Var.t.getThreadAlaInfo() != null && h45Var.t.getThreadAlaInfo().user_info != null && h45Var.t.getThreadAlaInfo().user_info.is_official == 2 && h45Var.t.getThreadAlaInfo().liveStageForceTop) {
                        i = i2;
                        break;
                    }
                } else {
                    if (cnVar instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) cnVar;
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
                    cn cnVar2 = this.threadList.get(i3);
                    if (cnVar2 instanceof h45) {
                        if (((h45) cnVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((cnVar2 instanceof ThreadData) && ((ThreadData) cnVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
            List<cn> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!ListUtils.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    public void filterEnterList(List<gga> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, list) == null) && list != null && list.size() != 0) {
            Iterator<gga> it = list.iterator();
            while (it.hasNext()) {
                gga next = it.next();
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

    public List<cn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<gga> list;
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
                arrayList.add(new nga(forum, this.forumRule));
            }
            if (forum != null && !ei.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new mga(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new mga(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<cn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    cn cnVar = (cn) ListUtils.getItem(topThreadList, i4);
                    if (cnVar instanceof h45) {
                        h45 h45Var = (h45) cnVar;
                        arrayList.add(h45Var.t);
                        if (h45Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (cnVar instanceof ThreadData) {
                            arrayList.add(cnVar);
                            if (((ThreadData) cnVar).getIsMemberTop() != 1 || z) {
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
            ArrayList<cn> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<cn> it = arrayList.iterator();
            while (it.hasNext()) {
                cn next = it.next();
                if (next != null && (next instanceof h45)) {
                    h45 h45Var = (h45) next;
                    if (TextUtils.equals(str, h45Var.t.getId())) {
                        return h45Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public void removeThread(String str) {
        ArrayList<cn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048615, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<cn> it = arrayList.iterator();
        while (it.hasNext()) {
            cn next = it.next();
            if (next != null && (next instanceof h45) && TextUtils.equals(str, ((h45) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(LikeReturnData likeReturnData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048621, this, likeReturnData) != null) || likeReturnData == null) {
            return;
        }
        this.forum.setCurScore(likeReturnData.getCurScore());
        this.forum.setLevelupScore(likeReturnData.getLevelupScore());
        this.forum.setLike(likeReturnData.isLike());
        this.forum.setUser_level(likeReturnData.getUserLevel());
        this.forum.setLevelName(likeReturnData.getLevelName());
    }

    public boolean receiveData(jga jgaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, jgaVar)) == null) {
            if (jgaVar == null) {
                return false;
            }
            this.isFromCache = jgaVar.isFromCache;
            setBaWuNoticeNum(jgaVar.getBaWuNoticeNum());
            setSortType(jgaVar.getSortType());
            setAnti(jgaVar.getAnti());
            setChatGroup(jgaVar.getChatGroup());
            setFortuneBag(jgaVar.isFortuneBag());
            setFortuneDesc(jgaVar.getFortuneDesc());
            setForum(jgaVar.getForum());
            setGameName(jgaVar.getGameName());
            setGameUrl(jgaVar.getGameUrl());
            setGconAccount(jgaVar.getGconAccount());
            setHasGame(jgaVar.isHasGame());
            setIsNewUrl(jgaVar.getIsNewUrl());
            setPhotoLivePos(jgaVar.getPhotoLivePos());
            setPage(jgaVar.getPage());
            setStar(jgaVar.getStar());
            setStarEnter(jgaVar.getStarEnter());
            setThreadList(jgaVar.threadList);
            setThreadListIds(jgaVar.getThreadListIds());
            setUserData(jgaVar.getUserData());
            setUserMap(jgaVar.getUserMap());
            setActivityHeadData(jgaVar.getActivityHeadData());
            setFrsDefaultTabId(jgaVar.getFrsDefaultTabId());
            this.defaultShowTab = jgaVar.defaultShowTab;
            setCategoryInfos(jgaVar.getCategoryInfos());
            setBawuCenterUrl(jgaVar.getBawuCenterUrl());
            setCardVideoInfo(jgaVar.getCardVideoInfo());
            setHeadSdkData(jgaVar.getHeadSdkData());
            setSchoolRecommendPos(jgaVar.getSchoolRecommendPos());
            setSchoolRecommendInfo(jgaVar.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(jgaVar.getEntelechyTabInfo());
            setAlaLiveCount(jgaVar.getAlaLiveCount());
            setCarrierEnterData(jgaVar.getCarrierEnterData());
            setForumState(jgaVar.getForumState());
            setAccessFlag(jgaVar.getAccessFlag());
            this.needLog = jgaVar.needLog;
            this.recommendBookData = jgaVar.recommendBookData;
            this.presentInfoData = jgaVar.presentInfoData;
            setBookInfo(jgaVar.getBookInfo());
            setMangaReadRecordChapterId(jgaVar.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(jgaVar.getHeadlineImgInfoData());
            setCardShipinPos(jgaVar.getCardShipinPos());
            setCardShipinNew(jgaVar.getCardShipinNew());
            this.enterFrsDialogInfo = jgaVar.enterFrsDialogInfo;
            setGameRankListData(jgaVar.getGameRankListData());
            setAgreeBanner(jgaVar.getAgreeBanner());
            setLiveNotify(jgaVar.getLiveNotify());
            setGameTabInfo(jgaVar.getGameTabInfo());
            setGameDefaultTabId(jgaVar.getGameDefaultTabId());
            setForumHeadIcon(jgaVar.getForumHeadIcon());
            setUserRecommend(jgaVar.getUserRecommend());
            setFrsVideoActivityData(jgaVar.getFrsVideoActivityData());
            this.mNewChapterInfo = jgaVar.mNewChapterInfo;
            setFrsInsertLiveData(jgaVar.getFrsInsertLiveData());
            this.recm_forum_list = jgaVar.getRecm_forum_list();
            setFrsStageLiveData(jgaVar.getFrsStageLiveData());
            this.forumArIno = jgaVar.forumArIno;
            this.starRank = jgaVar.starRank;
            this.postTopic = jgaVar.postTopic;
            this.mWindowToast = jgaVar.mWindowToast;
            this.activityConfig = jgaVar.activityConfig;
            setIsShowRedTip(jgaVar.isShowRedTip());
            this.isBrandForum = jgaVar.isBrandForum;
            this.brandAdData = jgaVar.brandAdData;
            this.oriForumInfoList = jgaVar.oriForumInfoList;
            this.bottomMenuList = jgaVar.bottomMenuList;
            this.adMixFloor = jgaVar.adMixFloor;
            this.adShowSelect = jgaVar.adShowSelect;
            this.adSampleMapKey = jgaVar.adSampleMapKey;
            wh7.f().n(getAnti());
            wh7.f().q(jgaVar.getForum().getId());
            wh7.f().r(jgaVar.getForum().getName());
            vh7.h().q(jgaVar.getForum().getId());
            if (jgaVar.getEntelechyTabInfo() != null) {
                vh7.h().r(jgaVar.getEntelechyTabInfo().a);
            }
            if (jgaVar.getUserData() != null) {
                xh7.c().e(jgaVar.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(jgaVar.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(jgaVar.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = jgaVar.smartAppAvatar;
            this.smartApp = jgaVar.smartApp;
            this.nebulaHotThreads = jgaVar.nebulaHotThreads;
            this.forumActiveInfo = jgaVar.forumActiveInfo;
            this.userList = jgaVar.userList;
            setBusinessPromot(jgaVar.getBusinessPromot());
            this.serviceAreaData = jgaVar.serviceAreaData;
            setHotUserRankData(jgaVar.getHotUserRankData());
            this.itemInfo = jgaVar.itemInfo;
            this.toLoadHorseData = jgaVar.toLoadHorseData;
            this.forumRule = jgaVar.forumRule;
            this.mSignActivityInfo = jgaVar.mSignActivityInfo;
            this.showAdsense = jgaVar.showAdsense;
            setVoiceRoomConfig(jgaVar.getVoiceRoomConfig());
            setVoiceRoomData(jgaVar.getVoiceRoomData());
            this.serviceAreaFlutterData = jgaVar.serviceAreaFlutterData;
            this.liveFuseForumDataList = jgaVar.liveFuseForumDataList;
            this.frsGameRankInfoData = jgaVar.frsGameRankInfoData;
            this.frsBannerHeaderData = jgaVar.frsBannerHeaderData;
            this.forumTagInfo = jgaVar.forumTagInfo;
            this.firstCategory = jgaVar.firstCategory;
            this.frsForumGroup = jgaVar.frsForumGroup;
            this.headerCard = jgaVar.headerCard;
            this.frsSpriteNewUserGuide = jgaVar.frsSpriteNewUserGuide;
            this.bountyTaskData = jgaVar.bountyTaskData;
            return true;
        }
        return invokeL.booleanValue;
    }
}
