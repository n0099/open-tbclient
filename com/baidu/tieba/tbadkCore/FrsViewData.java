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
import com.baidu.tieba.aq9;
import com.baidu.tieba.bq9;
import com.baidu.tieba.eo7;
import com.baidu.tieba.eq9;
import com.baidu.tieba.fq9;
import com.baidu.tieba.gm5;
import com.baidu.tieba.hq9;
import com.baidu.tieba.i05;
import com.baidu.tieba.jq9;
import com.baidu.tieba.kq9;
import com.baidu.tieba.l05;
import com.baidu.tieba.lq9;
import com.baidu.tieba.mq9;
import com.baidu.tieba.o15;
import com.baidu.tieba.o65;
import com.baidu.tieba.pg;
import com.baidu.tieba.pk6;
import com.baidu.tieba.q87;
import com.baidu.tieba.qi;
import com.baidu.tieba.rn;
import com.baidu.tieba.rz5;
import com.baidu.tieba.sq9;
import com.baidu.tieba.t77;
import com.baidu.tieba.u77;
import com.baidu.tieba.un7;
import com.baidu.tieba.v77;
import com.baidu.tieba.zz5;
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
public class FrsViewData extends hq9 implements gm5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public un7 funAdController;
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

    @Override // com.baidu.tieba.hq9
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

    public List<rn> getTopThreadList() {
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
            removeTopSameClassDataFromList(aq9.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            removeTopSameClassDataFromList(bq9.class, getThreadList());
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

    public void addRecommendAppToThreadList(rz5 rz5Var, ArrayList<rn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rz5Var, arrayList) == null) {
            addRecommendAppToThreadList(rz5Var, false, arrayList, null, false);
        }
    }

    private List<rn> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        l05 l05Var;
        ArrayList<rn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<rn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (l05Var = this.page) != null && l05Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    rn rnVar = this.threadList.get(i);
                    if (rnVar instanceof o15) {
                        if (((o15) rnVar).t.isHeadLinePost) {
                            arrayList2.add(rnVar);
                        }
                    } else if ((rnVar instanceof ThreadData) && ((ThreadData) rnVar).isHeadLinePost) {
                        arrayList2.add(rnVar);
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
            rn rnVar = this.threadList.get(i2);
            if (rnVar instanceof o15) {
                ThreadData threadData = ((o15) rnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            fq9 fq9Var = new fq9();
            fq9Var.d(this.forum.getId());
            fq9Var.c(feedForumList);
            this.threadList.add(i + 6, fq9Var);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        pk6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    rn rnVar = this.threadList.get(i2);
                    if (rnVar instanceof o15) {
                        ThreadData threadData = ((o15) rnVar).t;
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
        rn rnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (rnVar = this.threadList.get(0)) != null && (rnVar instanceof o15) && ((ThreadData) rnVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            o15 o15Var = new o15();
            o15Var.t = threadData;
            this.threadList.add(0, o15Var);
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || getForum() == null) {
            return;
        }
        List<rn> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<rn> threadList = getThreadList();
        if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
            int size = cardShipinPos.size();
            int size2 = threadList.size();
            for (int i = 0; i < size; i++) {
                if (i < cardShipinNew.size()) {
                    rn rnVar = cardShipinNew.get(i);
                    int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                    Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + rnVar.getType());
                    threadList.add(videoThreadInserPos, rnVar);
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

    public void addRecommendAppToThreadList(rz5 rz5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, rz5Var) == null) {
            addRecommendAppToThreadList(rz5Var, false, this.threadList, null, false);
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

    public void setFunAdController(un7 un7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, un7Var) == null) {
            this.funAdController = un7Var;
        }
    }

    public void setTopThreadList(List<rn> list) {
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<rn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, cls, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                rn rnVar = arrayList.get(i);
                if (rnVar.getClass() == cls) {
                    arrayList2.add(rnVar);
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
            ArrayList<rn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        bq9 frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<rn> threadList = getThreadList();
            removeTopSameClassDataFromList(bq9.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<rn> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                rn next = it.next();
                if (next != null && next.getType() == mq9.c) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<rn> arrayList;
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
            rn rnVar = this.threadList.get(i2);
            if (rnVar instanceof o15) {
                ThreadData threadData = ((o15) rnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String s = o65.m().s("game_rank_list_info", "");
        if (!StringUtils.isNull(s) && s.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(pg.g(s.split(",")[0], 0L), System.currentTimeMillis()) < pg.e(s.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int n = o65.m().n("game_rank_list_show_times", 0);
                    if (!z) {
                        n++;
                    }
                    o65.m().z("game_rank_list_show_times", n);
                    if (n > 3) {
                        o65 m = o65.m();
                        m.B("game_rank_list_info", System.currentTimeMillis() + ",1");
                        o65.m().z("game_rank_list_show_times", 0);
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
        aq9 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<rn> threadList = getThreadList();
            removeTopSameClassDataFromList(aq9.class, threadList);
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
            q87 userRecommend = getUserRecommend();
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
            ArrayList<rn> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<rn> it = this.threadList.iterator();
                while (it.hasNext()) {
                    rn next = it.next();
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
            jq9 entelechyTabInfo = getEntelechyTabInfo();
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
            Iterator<rn> it = this.threadList.iterator();
            while (it.hasNext()) {
                rn next = it.next();
                if (next != null && next.getType() == eo7.e) {
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
        Iterator<rn> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof q87) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(i05 i05Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, i05Var) == null) && i05Var != null && !StringUtils.isNull(i05Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<rn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    rn rnVar = threadList.get(i);
                    if ((rnVar instanceof o15) && i05Var.getId().equals(((o15) rnVar).t.getId()) && i05Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            i05Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, i05Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<rn> it = this.threadList.iterator();
            while (it.hasNext()) {
                rn next = it.next();
                if (next != null && (next instanceof o15)) {
                    o15 o15Var = (o15) next;
                    if (o15Var.t.getAuthor() != null && currentAccount.equals(o15Var.t.getAuthor().getUserId()) && o15Var.t.getAuthor().getPendantData() != null) {
                        o15Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        o15Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(rz5 rz5Var, boolean z, ArrayList<rn> arrayList, ArrayList<rn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{rz5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                zz5 zz5Var = new zz5(rz5Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                zz5Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, zz5Var));
                zz5 zz5Var2 = new zz5(rz5Var, 3);
                zz5Var2.z(z);
                zz5Var2.G(arrayList);
                zz5Var2.D(arrayList2);
                zz5Var2.y(z2);
                zz5Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    zz5Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    zz5Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, zz5Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<rn> arrayList;
        l05 l05Var;
        ArrayList<rn> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (l05Var = this.page) != null && l05Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                rn rnVar = this.threadList.get(i2);
                if (rnVar instanceof o15) {
                    o15 o15Var = (o15) rnVar;
                    if (o15Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && o15Var.t.getThreadAlaInfo() != null && o15Var.t.getThreadAlaInfo().user_info != null && o15Var.t.getThreadAlaInfo().user_info.is_official == 2 && o15Var.t.getThreadAlaInfo().liveStageForceTop) {
                        i = i2;
                        break;
                    }
                } else {
                    if (rnVar instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) rnVar;
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
                    rn rnVar2 = this.threadList.get(i3);
                    if (rnVar2 instanceof o15) {
                        if (((o15) rnVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((rnVar2 instanceof ThreadData) && ((ThreadData) rnVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
            List<rn> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!ListUtils.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    public void filterEnterList(List<eq9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, list) == null) && list != null && list.size() != 0) {
            Iterator<eq9> it = list.iterator();
            while (it.hasNext()) {
                eq9 next = it.next();
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

    public List<rn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<eq9> list;
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
                arrayList.add(new lq9(forum, this.forumRule));
            }
            if (forum != null && !qi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new kq9(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new kq9(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<rn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    rn rnVar = (rn) ListUtils.getItem(topThreadList, i4);
                    if (rnVar instanceof o15) {
                        o15 o15Var = (o15) rnVar;
                        arrayList.add(o15Var.t);
                        if (o15Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (rnVar instanceof ThreadData) {
                            arrayList.add(rnVar);
                            if (((ThreadData) rnVar).getIsMemberTop() != 1 || z) {
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
            ArrayList<rn> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<rn> it = arrayList.iterator();
            while (it.hasNext()) {
                rn next = it.next();
                if (next != null && (next instanceof o15)) {
                    o15 o15Var = (o15) next;
                    if (TextUtils.equals(str, o15Var.t.getId())) {
                        return o15Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public void removeThread(String str) {
        ArrayList<rn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<rn> it = arrayList.iterator();
        while (it.hasNext()) {
            rn next = it.next();
            if (next != null && (next instanceof o15) && TextUtils.equals(str, ((o15) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(sq9 sq9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, sq9Var) != null) || sq9Var == null) {
            return;
        }
        this.forum.setCurScore(sq9Var.c());
        this.forum.setLevelupScore(sq9Var.i());
        this.forum.setLike(sq9Var.n());
        this.forum.setUser_level(sq9Var.m());
        this.forum.setLevelName(sq9Var.h());
    }

    public boolean receiveData(hq9 hq9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, hq9Var)) == null) {
            if (hq9Var == null) {
                return false;
            }
            this.isFromCache = hq9Var.isFromCache;
            setBaWuNoticeNum(hq9Var.getBaWuNoticeNum());
            setSortType(hq9Var.getSortType());
            setAnti(hq9Var.getAnti());
            setChatGroup(hq9Var.getChatGroup());
            setFortuneBag(hq9Var.isFortuneBag());
            setFortuneDesc(hq9Var.getFortuneDesc());
            setForum(hq9Var.getForum());
            setGameName(hq9Var.getGameName());
            setGameUrl(hq9Var.getGameUrl());
            setGconAccount(hq9Var.getGconAccount());
            setHasGame(hq9Var.isHasGame());
            setIsNewUrl(hq9Var.getIsNewUrl());
            setPhotoLivePos(hq9Var.getPhotoLivePos());
            setPage(hq9Var.getPage());
            setStar(hq9Var.getStar());
            setStarEnter(hq9Var.getStarEnter());
            setThreadList(hq9Var.threadList);
            setThreadListIds(hq9Var.getThreadListIds());
            setUserData(hq9Var.getUserData());
            setUserMap(hq9Var.getUserMap());
            setActivityHeadData(hq9Var.getActivityHeadData());
            setFrsDefaultTabId(hq9Var.getFrsDefaultTabId());
            this.defaultShowTab = hq9Var.defaultShowTab;
            setCategoryInfos(hq9Var.getCategoryInfos());
            setBawuCenterUrl(hq9Var.getBawuCenterUrl());
            setCardVideoInfo(hq9Var.getCardVideoInfo());
            setHeadSdkData(hq9Var.getHeadSdkData());
            setSchoolRecommendPos(hq9Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(hq9Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(hq9Var.getEntelechyTabInfo());
            setAlaLiveCount(hq9Var.getAlaLiveCount());
            setCarrierEnterData(hq9Var.getCarrierEnterData());
            setForumState(hq9Var.getForumState());
            setAccessFlag(hq9Var.getAccessFlag());
            this.needLog = hq9Var.needLog;
            this.recommendBookData = hq9Var.recommendBookData;
            this.presentInfoData = hq9Var.presentInfoData;
            setBookInfo(hq9Var.getBookInfo());
            setMangaReadRecordChapterId(hq9Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(hq9Var.getHeadlineImgInfoData());
            setCardShipinPos(hq9Var.getCardShipinPos());
            setCardShipinNew(hq9Var.getCardShipinNew());
            this.enterFrsDialogInfo = hq9Var.enterFrsDialogInfo;
            setGameRankListData(hq9Var.getGameRankListData());
            setAgreeBanner(hq9Var.getAgreeBanner());
            setLiveNotify(hq9Var.getLiveNotify());
            setGameTabInfo(hq9Var.getGameTabInfo());
            setGameDefaultTabId(hq9Var.getGameDefaultTabId());
            setForumHeadIcon(hq9Var.getForumHeadIcon());
            setUserRecommend(hq9Var.getUserRecommend());
            setFrsVideoActivityData(hq9Var.getFrsVideoActivityData());
            this.mNewChapterInfo = hq9Var.mNewChapterInfo;
            setFrsInsertLiveData(hq9Var.getFrsInsertLiveData());
            this.recm_forum_list = hq9Var.getRecm_forum_list();
            setFrsStageLiveData(hq9Var.getFrsStageLiveData());
            this.forumArIno = hq9Var.forumArIno;
            this.starRank = hq9Var.starRank;
            this.postTopic = hq9Var.postTopic;
            this.mWindowToast = hq9Var.mWindowToast;
            this.activityConfig = hq9Var.activityConfig;
            setIsShowRedTip(hq9Var.isShowRedTip());
            this.isBrandForum = hq9Var.isBrandForum;
            this.brandAdData = hq9Var.brandAdData;
            this.oriForumInfoList = hq9Var.oriForumInfoList;
            this.bottomMenuList = hq9Var.bottomMenuList;
            this.adMixFloor = hq9Var.adMixFloor;
            this.adShowSelect = hq9Var.adShowSelect;
            this.adSampleMapKey = hq9Var.adSampleMapKey;
            u77.f().n(getAnti());
            u77.f().q(hq9Var.getForum().getId());
            u77.f().r(hq9Var.getForum().getName());
            t77.h().q(hq9Var.getForum().getId());
            if (hq9Var.getEntelechyTabInfo() != null) {
                t77.h().r(hq9Var.getEntelechyTabInfo().a);
            }
            if (hq9Var.getUserData() != null) {
                v77.c().e(hq9Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(hq9Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(hq9Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = hq9Var.smartAppAvatar;
            this.smartApp = hq9Var.smartApp;
            this.nebulaHotThreads = hq9Var.nebulaHotThreads;
            this.forumActiveInfo = hq9Var.forumActiveInfo;
            this.userList = hq9Var.userList;
            setBusinessPromot(hq9Var.getBusinessPromot());
            this.serviceAreaData = hq9Var.serviceAreaData;
            setHotUserRankData(hq9Var.getHotUserRankData());
            this.itemInfo = hq9Var.itemInfo;
            this.toLoadHorseData = hq9Var.toLoadHorseData;
            this.forumRule = hq9Var.forumRule;
            this.mSignActivityInfo = hq9Var.mSignActivityInfo;
            this.showAdsense = hq9Var.showAdsense;
            setVoiceRoomConfig(hq9Var.getVoiceRoomConfig());
            setVoiceRoomData(hq9Var.getVoiceRoomData());
            this.serviceAreaFlutterData = hq9Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = hq9Var.liveFuseForumDataList;
            this.frsGameRankInfoData = hq9Var.frsGameRankInfoData;
            this.frsBannerHeaderData = hq9Var.frsBannerHeaderData;
            this.forumTagInfo = hq9Var.forumTagInfo;
            this.firstCategory = hq9Var.firstCategory;
            this.frsForumGroup = hq9Var.frsForumGroup;
            return true;
        }
        return invokeL.booleanValue;
    }
}
