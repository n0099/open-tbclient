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
import com.baidu.tieba.a3a;
import com.baidu.tieba.c3a;
import com.baidu.tieba.e3a;
import com.baidu.tieba.e46;
import com.baidu.tieba.f3a;
import com.baidu.tieba.fe7;
import com.baidu.tieba.fu7;
import com.baidu.tieba.g3a;
import com.baidu.tieba.h3a;
import com.baidu.tieba.id7;
import com.baidu.tieba.jd7;
import com.baidu.tieba.kd7;
import com.baidu.tieba.kp6;
import com.baidu.tieba.l35;
import com.baidu.tieba.m46;
import com.baidu.tieba.mt7;
import com.baidu.tieba.n3a;
import com.baidu.tieba.o35;
import com.baidu.tieba.r45;
import com.baidu.tieba.r95;
import com.baidu.tieba.uq5;
import com.baidu.tieba.v2a;
import com.baidu.tieba.vg;
import com.baidu.tieba.w2a;
import com.baidu.tieba.wi;
import com.baidu.tieba.xn;
import com.baidu.tieba.z2a;
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
/* loaded from: classes7.dex */
public class FrsViewData extends c3a implements uq5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public mt7 funAdController;
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
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.postThreadCount = 0;
        }
    }

    public ForumActiveInfo getForumActiveInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.forumActiveInfo;
        }
        return (ForumActiveInfo) invokeV.objValue;
    }

    public BdUniqueId getFrsFragmentTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.frsFragmentTag;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean getIsBrandForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.isBrandForum;
        }
        return invokeV.booleanValue;
    }

    public int getPostThreadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.postThreadCount;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.c3a
    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.recm_forum_list;
        }
        return (List) invokeV.objValue;
    }

    public SignData getSignData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ForumData forumData = this.forum;
            if (forumData == null) {
                return null;
            }
            return forumData.getSignData();
        }
        return (SignData) invokeV.objValue;
    }

    public List<xn> getTopThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.topThreadList;
        }
        return (List) invokeV.objValue;
    }

    public boolean hasTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (getStar() == null || getStar().b() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void removeAlaInsertLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            removeTopSameClassDataFromList(v2a.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            removeTopSameClassDataFromList(w2a.class, getThreadList());
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

    public void addRecommendAppToThreadList(e46 e46Var, ArrayList<xn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e46Var, arrayList) == null) {
            addRecommendAppToThreadList(e46Var, false, arrayList, null, false);
        }
    }

    private List<xn> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        o35 o35Var;
        ArrayList<xn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<xn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (o35Var = this.page) != null && o35Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    xn xnVar = this.threadList.get(i);
                    if (xnVar instanceof r45) {
                        if (((r45) xnVar).t.isHeadLinePost) {
                            arrayList2.add(xnVar);
                        }
                    } else if ((xnVar instanceof ThreadData) && ((ThreadData) xnVar).isHeadLinePost) {
                        arrayList2.add(xnVar);
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
            xn xnVar = this.threadList.get(i2);
            if (xnVar instanceof r45) {
                ThreadData threadData = ((r45) xnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            a3a a3aVar = new a3a();
            a3aVar.d(this.forum.getId());
            a3aVar.c(feedForumList);
            this.threadList.add(i + 6, a3aVar);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        kp6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    xn xnVar = this.threadList.get(i2);
                    if (xnVar instanceof r45) {
                        ThreadData threadData = ((r45) xnVar).t;
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
        xn xnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (xnVar = this.threadList.get(0)) != null && (xnVar instanceof r45) && ((ThreadData) xnVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            r45 r45Var = new r45();
            r45Var.t = threadData;
            this.threadList.add(0, r45Var);
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || getForum() == null) {
            return;
        }
        List<xn> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<xn> threadList = getThreadList();
        if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
            int size = cardShipinPos.size();
            int size2 = threadList.size();
            for (int i = 0; i < size; i++) {
                if (i < cardShipinNew.size()) {
                    xn xnVar = cardShipinNew.get(i);
                    int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                    Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + xnVar.getType());
                    threadList.add(videoThreadInserPos, xnVar);
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

    public void addRecommendAppToThreadList(e46 e46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, e46Var) == null) {
            addRecommendAppToThreadList(e46Var, false, this.threadList, null, false);
        }
    }

    public void removeThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, threadData) == null) {
            this.threadList.remove(threadData);
        }
    }

    public void setFrsFragmentTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bdUniqueId) == null) {
            this.frsFragmentTag = bdUniqueId;
        }
    }

    public void setFunAdController(mt7 mt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, mt7Var) == null) {
            this.funAdController = mt7Var;
        }
    }

    public void setTopThreadList(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, list) == null) {
            this.topThreadList = list;
        }
    }

    public void updateLoadMoreBannerListData(BannerListData bannerListData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bannerListData) == null) {
            this.isLoadMore = true;
            this.loadMoreBannerListData = bannerListData;
        }
    }

    public void updateSignData(SignData signData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048622, this, signData) != null) || signData == null) {
            return;
        }
        this.forum.setSignData(signData);
    }

    private void removeTopSameClassDataFromList(Class cls, ArrayList<xn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, cls, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                xn xnVar = arrayList.get(i);
                if (xnVar.getClass() == cls) {
                    arrayList2.add(xnVar);
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
            ArrayList<xn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        w2a frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<xn> threadList = getThreadList();
            removeTopSameClassDataFromList(w2a.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<xn> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                xn next = it.next();
                if (next != null && next.getType() == h3a.c) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<xn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0) {
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
            xn xnVar = this.threadList.get(i2);
            if (xnVar instanceof r45) {
                ThreadData threadData = ((r45) xnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String w = r95.p().w("game_rank_list_info", "");
        if (!StringUtils.isNull(w) && w.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(vg.g(w.split(",")[0], 0L), System.currentTimeMillis()) < vg.e(w.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int q = r95.p().q("game_rank_list_show_times", 0);
                    if (!z) {
                        q++;
                    }
                    r95.p().F("game_rank_list_show_times", q);
                    if (q > 3) {
                        r95 p = r95.p();
                        p.J("game_rank_list_info", System.currentTimeMillis() + ",1");
                        r95.p().F("game_rank_list_show_times", 0);
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
        v2a frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<xn> threadList = getThreadList();
            removeTopSameClassDataFromList(v2a.class, threadList);
            threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.b, threadList.size()), frsInsertLiveData);
        }
    }

    public void addSchoolRecommendToThreadList() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || MessageManager.getInstance().findTask(2003016) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && getUserRecommend() != null) {
            fe7 userRecommend = getUserRecommend();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            ArrayList<xn> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<xn> it = this.threadList.iterator();
                while (it.hasNext()) {
                    xn next = it.next();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            e3a entelechyTabInfo = getEntelechyTabInfo();
            if (entelechyTabInfo == null || (list = entelechyTabInfo.a) == null || list.size() <= 0 || (frsTabInfo = list.get(0)) == null || frsTabInfo.tab_id.intValue() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void removeGameRankListFromThreadList() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && !ListUtils.isEmpty(this.threadList)) {
            Iterator<xn> it = this.threadList.iterator();
            while (it.hasNext()) {
                xn next = it.next();
                if (next != null && next.getType() == fu7.e) {
                    it.remove();
                }
            }
        }
    }

    public void removeRedundantUserRecommendData() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048613, this) != null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        boolean z = false;
        Iterator<xn> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof fe7) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(l35 l35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, l35Var) == null) && l35Var != null && !StringUtils.isNull(l35Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<xn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    xn xnVar = threadList.get(i);
                    if ((xnVar instanceof r45) && l35Var.getId().equals(((r45) xnVar).t.getId()) && l35Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            l35Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, l35Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<xn> it = this.threadList.iterator();
            while (it.hasNext()) {
                xn next = it.next();
                if (next != null && (next instanceof r45)) {
                    r45 r45Var = (r45) next;
                    if (r45Var.t.getAuthor() != null && currentAccount.equals(r45Var.t.getAuthor().getUserId()) && r45Var.t.getAuthor().getPendantData() != null) {
                        r45Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        r45Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(e46 e46Var, boolean z, ArrayList<xn> arrayList, ArrayList<xn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{e46Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                m46 m46Var = new m46(e46Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                m46Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, m46Var));
                m46 m46Var2 = new m46(e46Var, 3);
                m46Var2.z(z);
                m46Var2.G(arrayList);
                m46Var2.D(arrayList2);
                m46Var2.y(z2);
                m46Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    m46Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    m46Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, m46Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<xn> arrayList;
        o35 o35Var;
        ArrayList<xn> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (o35Var = this.page) != null && o35Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                xn xnVar = this.threadList.get(i2);
                if (xnVar instanceof r45) {
                    r45 r45Var = (r45) xnVar;
                    if (r45Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && r45Var.t.getThreadAlaInfo() != null && r45Var.t.getThreadAlaInfo().user_info != null && r45Var.t.getThreadAlaInfo().user_info.is_official == 2 && r45Var.t.getThreadAlaInfo().liveStageForceTop) {
                        i = i2;
                        break;
                    }
                } else {
                    if (xnVar instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) xnVar;
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
                    xn xnVar2 = this.threadList.get(i3);
                    if (xnVar2 instanceof r45) {
                        if (((r45) xnVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((xnVar2 instanceof ThreadData) && ((ThreadData) xnVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
            List<xn> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!ListUtils.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    public void filterEnterList(List<z2a> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, list) == null) && list != null && list.size() != 0) {
            Iterator<z2a> it = list.iterator();
            while (it.hasNext()) {
                z2a next = it.next();
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

    public List<xn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<z2a> list;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
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
                arrayList.add(new g3a(forum, this.forumRule));
            }
            if (forum != null && !wi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new f3a(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new f3a(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<xn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    xn xnVar = (xn) ListUtils.getItem(topThreadList, i4);
                    if (xnVar instanceof r45) {
                        r45 r45Var = (r45) xnVar;
                        arrayList.add(r45Var.t);
                        if (r45Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (xnVar instanceof ThreadData) {
                            arrayList.add(xnVar);
                            if (((ThreadData) xnVar).getIsMemberTop() != 1 || z) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            ArrayList<xn> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<xn> it = arrayList.iterator();
            while (it.hasNext()) {
                xn next = it.next();
                if (next != null && (next instanceof r45)) {
                    r45 r45Var = (r45) next;
                    if (TextUtils.equals(str, r45Var.t.getId())) {
                        return r45Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public void removeThread(String str) {
        ArrayList<xn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<xn> it = arrayList.iterator();
        while (it.hasNext()) {
            xn next = it.next();
            if (next != null && (next instanceof r45) && TextUtils.equals(str, ((r45) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(n3a n3aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, n3aVar) != null) || n3aVar == null) {
            return;
        }
        this.forum.setCurScore(n3aVar.c());
        this.forum.setLevelupScore(n3aVar.i());
        this.forum.setLike(n3aVar.n());
        this.forum.setUser_level(n3aVar.m());
        this.forum.setLevelName(n3aVar.h());
    }

    public boolean receiveData(c3a c3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, c3aVar)) == null) {
            if (c3aVar == null) {
                return false;
            }
            this.isFromCache = c3aVar.isFromCache;
            setBaWuNoticeNum(c3aVar.getBaWuNoticeNum());
            setSortType(c3aVar.getSortType());
            setAnti(c3aVar.getAnti());
            setChatGroup(c3aVar.getChatGroup());
            setFortuneBag(c3aVar.isFortuneBag());
            setFortuneDesc(c3aVar.getFortuneDesc());
            setForum(c3aVar.getForum());
            setGameName(c3aVar.getGameName());
            setGameUrl(c3aVar.getGameUrl());
            setGconAccount(c3aVar.getGconAccount());
            setHasGame(c3aVar.isHasGame());
            setIsNewUrl(c3aVar.getIsNewUrl());
            setPhotoLivePos(c3aVar.getPhotoLivePos());
            setPage(c3aVar.getPage());
            setStar(c3aVar.getStar());
            setStarEnter(c3aVar.getStarEnter());
            setThreadList(c3aVar.threadList);
            setThreadListIds(c3aVar.getThreadListIds());
            setUserData(c3aVar.getUserData());
            setUserMap(c3aVar.getUserMap());
            setActivityHeadData(c3aVar.getActivityHeadData());
            setFrsDefaultTabId(c3aVar.getFrsDefaultTabId());
            this.defaultShowTab = c3aVar.defaultShowTab;
            setCategoryInfos(c3aVar.getCategoryInfos());
            setBawuCenterUrl(c3aVar.getBawuCenterUrl());
            setCardVideoInfo(c3aVar.getCardVideoInfo());
            setHeadSdkData(c3aVar.getHeadSdkData());
            setSchoolRecommendPos(c3aVar.getSchoolRecommendPos());
            setSchoolRecommendInfo(c3aVar.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(c3aVar.getEntelechyTabInfo());
            setAlaLiveCount(c3aVar.getAlaLiveCount());
            setCarrierEnterData(c3aVar.getCarrierEnterData());
            setForumState(c3aVar.getForumState());
            setAccessFlag(c3aVar.getAccessFlag());
            this.needLog = c3aVar.needLog;
            this.recommendBookData = c3aVar.recommendBookData;
            this.presentInfoData = c3aVar.presentInfoData;
            setBookInfo(c3aVar.getBookInfo());
            setMangaReadRecordChapterId(c3aVar.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(c3aVar.getHeadlineImgInfoData());
            setCardShipinPos(c3aVar.getCardShipinPos());
            setCardShipinNew(c3aVar.getCardShipinNew());
            this.enterFrsDialogInfo = c3aVar.enterFrsDialogInfo;
            setGameRankListData(c3aVar.getGameRankListData());
            setAgreeBanner(c3aVar.getAgreeBanner());
            setLiveNotify(c3aVar.getLiveNotify());
            setGameTabInfo(c3aVar.getGameTabInfo());
            setGameDefaultTabId(c3aVar.getGameDefaultTabId());
            setForumHeadIcon(c3aVar.getForumHeadIcon());
            setUserRecommend(c3aVar.getUserRecommend());
            setFrsVideoActivityData(c3aVar.getFrsVideoActivityData());
            this.mNewChapterInfo = c3aVar.mNewChapterInfo;
            setFrsInsertLiveData(c3aVar.getFrsInsertLiveData());
            this.recm_forum_list = c3aVar.getRecm_forum_list();
            setFrsStageLiveData(c3aVar.getFrsStageLiveData());
            this.forumArIno = c3aVar.forumArIno;
            this.starRank = c3aVar.starRank;
            this.postTopic = c3aVar.postTopic;
            this.mWindowToast = c3aVar.mWindowToast;
            this.activityConfig = c3aVar.activityConfig;
            setIsShowRedTip(c3aVar.isShowRedTip());
            this.isBrandForum = c3aVar.isBrandForum;
            this.brandAdData = c3aVar.brandAdData;
            this.oriForumInfoList = c3aVar.oriForumInfoList;
            this.bottomMenuList = c3aVar.bottomMenuList;
            this.adMixFloor = c3aVar.adMixFloor;
            this.adShowSelect = c3aVar.adShowSelect;
            this.adSampleMapKey = c3aVar.adSampleMapKey;
            jd7.f().n(getAnti());
            jd7.f().q(c3aVar.getForum().getId());
            jd7.f().r(c3aVar.getForum().getName());
            id7.h().q(c3aVar.getForum().getId());
            if (c3aVar.getEntelechyTabInfo() != null) {
                id7.h().r(c3aVar.getEntelechyTabInfo().a);
            }
            if (c3aVar.getUserData() != null) {
                kd7.c().e(c3aVar.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(c3aVar.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(c3aVar.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = c3aVar.smartAppAvatar;
            this.smartApp = c3aVar.smartApp;
            this.nebulaHotThreads = c3aVar.nebulaHotThreads;
            this.forumActiveInfo = c3aVar.forumActiveInfo;
            this.userList = c3aVar.userList;
            setBusinessPromot(c3aVar.getBusinessPromot());
            this.serviceAreaData = c3aVar.serviceAreaData;
            setHotUserRankData(c3aVar.getHotUserRankData());
            this.itemInfo = c3aVar.itemInfo;
            this.toLoadHorseData = c3aVar.toLoadHorseData;
            this.forumRule = c3aVar.forumRule;
            this.mSignActivityInfo = c3aVar.mSignActivityInfo;
            this.showAdsense = c3aVar.showAdsense;
            setVoiceRoomConfig(c3aVar.getVoiceRoomConfig());
            setVoiceRoomData(c3aVar.getVoiceRoomData());
            this.serviceAreaFlutterData = c3aVar.serviceAreaFlutterData;
            this.liveFuseForumDataList = c3aVar.liveFuseForumDataList;
            this.frsGameRankInfoData = c3aVar.frsGameRankInfoData;
            this.frsBannerHeaderData = c3aVar.frsBannerHeaderData;
            this.forumTagInfo = c3aVar.forumTagInfo;
            this.firstCategory = c3aVar.firstCategory;
            this.frsForumGroup = c3aVar.frsForumGroup;
            return true;
        }
        return invokeL.booleanValue;
    }
}
