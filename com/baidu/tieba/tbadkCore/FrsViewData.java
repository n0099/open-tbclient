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
import com.baidu.tieba.a27;
import com.baidu.tieba.aw8;
import com.baidu.tieba.bw8;
import com.baidu.tieba.ce5;
import com.baidu.tieba.co6;
import com.baidu.tieba.cw8;
import com.baidu.tieba.cz4;
import com.baidu.tieba.du4;
import com.baidu.tieba.fn6;
import com.baidu.tieba.gn6;
import com.baidu.tieba.gu4;
import com.baidu.tieba.hn6;
import com.baidu.tieba.iw8;
import com.baidu.tieba.jv4;
import com.baidu.tieba.k27;
import com.baidu.tieba.qq5;
import com.baidu.tieba.qv8;
import com.baidu.tieba.rv8;
import com.baidu.tieba.s96;
import com.baidu.tieba.uv8;
import com.baidu.tieba.vv8;
import com.baidu.tieba.xv8;
import com.baidu.tieba.yg;
import com.baidu.tieba.yi;
import com.baidu.tieba.yn;
import com.baidu.tieba.yq5;
import com.baidu.tieba.zv8;
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
/* loaded from: classes6.dex */
public class FrsViewData extends xv8 implements ce5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public a27 funAdController;
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

    @Override // com.baidu.tieba.xv8
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

    public List<yn> getTopThreadList() {
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
            removeTopSameClassDataFromList(qv8.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            removeTopSameClassDataFromList(rv8.class, getThreadList());
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

    public void addRecommendAppToThreadList(qq5 qq5Var, ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qq5Var, arrayList) == null) {
            addRecommendAppToThreadList(qq5Var, false, arrayList, null, false);
        }
    }

    private List<yn> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        gu4 gu4Var;
        ArrayList<yn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<yn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (gu4Var = this.page) != null && gu4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    yn ynVar = this.threadList.get(i);
                    if (ynVar instanceof jv4) {
                        if (((jv4) ynVar).t.isHeadLinePost) {
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
            if (ynVar instanceof jv4) {
                ThreadData threadData = ((jv4) ynVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            vv8 vv8Var = new vv8();
            vv8Var.f(this.forum.getId());
            vv8Var.c(feedForumList);
            this.threadList.add(i + 6, vv8Var);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        s96 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    yn ynVar = this.threadList.get(i2);
                    if (ynVar instanceof jv4) {
                        ThreadData threadData = ((jv4) ynVar).t;
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
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (ynVar = this.threadList.get(0)) != null && (ynVar instanceof jv4) && ((ThreadData) ynVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            jv4 jv4Var = new jv4();
            jv4Var.t = threadData;
            this.threadList.add(0, jv4Var);
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || getForum() == null) {
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

    public void addRecommendAppToThreadList(qq5 qq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, qq5Var) == null) {
            addRecommendAppToThreadList(qq5Var, false, this.threadList, null, false);
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

    public void setFunAdController(a27 a27Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, a27Var) == null) {
            this.funAdController = a27Var;
        }
    }

    public void setTopThreadList(List<yn> list) {
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

    public void addStageLiveDataToThreadList() {
        rv8 frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<yn> threadList = getThreadList();
            removeTopSameClassDataFromList(rv8.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<yn> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                yn next = it.next();
                if (next != null && next.getType() == cw8.c) {
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
            yn ynVar = this.threadList.get(i2);
            if (ynVar instanceof jv4) {
                ThreadData threadData = ((jv4) ynVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String r = cz4.l().r("game_rank_list_info", "");
        if (!StringUtils.isNull(r) && r.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(yg.g(r.split(",")[0], 0L), System.currentTimeMillis()) < yg.e(r.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int m = cz4.l().m("game_rank_list_show_times", 0);
                    if (!z) {
                        m++;
                    }
                    cz4.l().x("game_rank_list_show_times", m);
                    if (m > 3) {
                        cz4 l = cz4.l();
                        l.z("game_rank_list_info", System.currentTimeMillis() + ",1");
                        cz4.l().x("game_rank_list_show_times", 0);
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
        qv8 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<yn> threadList = getThreadList();
            removeTopSameClassDataFromList(qv8.class, threadList);
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
            co6 userRecommend = getUserRecommend();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            zv8 entelechyTabInfo = getEntelechyTabInfo();
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
            Iterator<yn> it = this.threadList.iterator();
            while (it.hasNext()) {
                yn next = it.next();
                if (next != null && next.getType() == k27.e) {
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
        Iterator<yn> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof co6) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(du4 du4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, du4Var) == null) && du4Var != null && !StringUtils.isNull(du4Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<yn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    yn ynVar = threadList.get(i);
                    if ((ynVar instanceof jv4) && du4Var.getId().equals(((jv4) ynVar).t.getId()) && du4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            du4Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, du4Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<yn> it = this.threadList.iterator();
            while (it.hasNext()) {
                yn next = it.next();
                if (next != null && (next instanceof jv4)) {
                    jv4 jv4Var = (jv4) next;
                    if (jv4Var.t.getAuthor() != null && currentAccount.equals(jv4Var.t.getAuthor().getUserId()) && jv4Var.t.getAuthor().getPendantData() != null) {
                        jv4Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        jv4Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(qq5 qq5Var, boolean z, ArrayList<yn> arrayList, ArrayList<yn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{qq5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                yq5 yq5Var = new yq5(qq5Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                yq5Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, yq5Var));
                yq5 yq5Var2 = new yq5(qq5Var, 3);
                yq5Var2.z(z);
                yq5Var2.G(arrayList);
                yq5Var2.D(arrayList2);
                yq5Var2.y(z2);
                yq5Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    yq5Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    yq5Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, yq5Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<yn> arrayList;
        gu4 gu4Var;
        ArrayList<yn> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (gu4Var = this.page) != null && gu4Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                yn ynVar = this.threadList.get(i2);
                if (ynVar instanceof jv4) {
                    jv4 jv4Var = (jv4) ynVar;
                    if (jv4Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && jv4Var.t.getThreadAlaInfo() != null && jv4Var.t.getThreadAlaInfo().user_info != null && jv4Var.t.getThreadAlaInfo().user_info.is_official == 2 && jv4Var.t.getThreadAlaInfo().liveStageForceTop) {
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
                    if (ynVar2 instanceof jv4) {
                        if (((jv4) ynVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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

    public void filterEnterList(List<uv8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, list) == null) && list != null && list.size() != 0) {
            Iterator<uv8> it = list.iterator();
            while (it.hasNext()) {
                uv8 next = it.next();
                if (next == null) {
                    it.remove();
                } else if (StringUtils.isNull(next.h()) || StringUtils.isNull(next.f())) {
                    if (next.a() != 1) {
                        it.remove();
                    }
                }
            }
        }
    }

    public List<yn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<uv8> list;
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
                arrayList.add(new bw8(forum, this.forumRule));
            }
            if (forum != null && !yi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new aw8(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new aw8(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<yn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    yn ynVar = (yn) ListUtils.getItem(topThreadList, i4);
                    if (ynVar instanceof jv4) {
                        jv4 jv4Var = (jv4) ynVar;
                        arrayList.add(jv4Var.t);
                        if (jv4Var.t.getIsMemberTop() != 1 || z) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            ArrayList<yn> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<yn> it = arrayList.iterator();
            while (it.hasNext()) {
                yn next = it.next();
                if (next != null && (next instanceof jv4)) {
                    jv4 jv4Var = (jv4) next;
                    if (TextUtils.equals(str, jv4Var.t.getId())) {
                        return jv4Var.t;
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
        if ((interceptable != null && interceptable.invokeL(1048614, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<yn> it = arrayList.iterator();
        while (it.hasNext()) {
            yn next = it.next();
            if (next != null && (next instanceof jv4) && TextUtils.equals(str, ((jv4) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(iw8 iw8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, iw8Var) != null) || iw8Var == null) {
            return;
        }
        this.forum.setCurScore(iw8Var.c());
        this.forum.setLevelupScore(iw8Var.i());
        this.forum.setLike(iw8Var.n());
        this.forum.setUser_level(iw8Var.m());
        this.forum.setLevelName(iw8Var.h());
    }

    public boolean receiveData(xv8 xv8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, xv8Var)) == null) {
            if (xv8Var == null) {
                return false;
            }
            this.isFromCache = xv8Var.isFromCache;
            setBaWuNoticeNum(xv8Var.getBaWuNoticeNum());
            setSortType(xv8Var.getSortType());
            setAnti(xv8Var.getAnti());
            setChatGroup(xv8Var.getChatGroup());
            setFortuneBag(xv8Var.isFortuneBag());
            setFortuneDesc(xv8Var.getFortuneDesc());
            setForum(xv8Var.getForum());
            setGameName(xv8Var.getGameName());
            setGameUrl(xv8Var.getGameUrl());
            setGconAccount(xv8Var.getGconAccount());
            setHasGame(xv8Var.isHasGame());
            setIsNewUrl(xv8Var.getIsNewUrl());
            setPhotoLivePos(xv8Var.getPhotoLivePos());
            setPage(xv8Var.getPage());
            setStar(xv8Var.getStar());
            setStarEnter(xv8Var.getStarEnter());
            setThreadList(xv8Var.threadList);
            setThreadListIds(xv8Var.getThreadListIds());
            setUserData(xv8Var.getUserData());
            setUserMap(xv8Var.getUserMap());
            setActivityHeadData(xv8Var.getActivityHeadData());
            setFrsDefaultTabId(xv8Var.getFrsDefaultTabId());
            this.defaultShowTab = xv8Var.defaultShowTab;
            setCategoryInfos(xv8Var.getCategoryInfos());
            setBawuCenterUrl(xv8Var.getBawuCenterUrl());
            setCardVideoInfo(xv8Var.getCardVideoInfo());
            setHeadSdkData(xv8Var.getHeadSdkData());
            setSchoolRecommendPos(xv8Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(xv8Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(xv8Var.getEntelechyTabInfo());
            setAlaLiveCount(xv8Var.getAlaLiveCount());
            setCarrierEnterData(xv8Var.getCarrierEnterData());
            setForumState(xv8Var.getForumState());
            setAccessFlag(xv8Var.getAccessFlag());
            this.needLog = xv8Var.needLog;
            this.recommendBookData = xv8Var.recommendBookData;
            this.presentInfoData = xv8Var.presentInfoData;
            setBookInfo(xv8Var.getBookInfo());
            setMangaReadRecordChapterId(xv8Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(xv8Var.getHeadlineImgInfoData());
            setCardShipinPos(xv8Var.getCardShipinPos());
            setCardShipinNew(xv8Var.getCardShipinNew());
            this.enterFrsDialogInfo = xv8Var.enterFrsDialogInfo;
            setGameRankListData(xv8Var.getGameRankListData());
            setAgreeBanner(xv8Var.getAgreeBanner());
            setLiveNotify(xv8Var.getLiveNotify());
            setGameTabInfo(xv8Var.getGameTabInfo());
            setGameDefaultTabId(xv8Var.getGameDefaultTabId());
            setForumHeadIcon(xv8Var.getForumHeadIcon());
            setUserRecommend(xv8Var.getUserRecommend());
            setFrsVideoActivityData(xv8Var.getFrsVideoActivityData());
            this.mNewChapterInfo = xv8Var.mNewChapterInfo;
            setFrsInsertLiveData(xv8Var.getFrsInsertLiveData());
            this.recm_forum_list = xv8Var.getRecm_forum_list();
            setFrsStageLiveData(xv8Var.getFrsStageLiveData());
            this.forumArIno = xv8Var.forumArIno;
            this.starRank = xv8Var.starRank;
            this.postTopic = xv8Var.postTopic;
            this.mWindowToast = xv8Var.mWindowToast;
            this.activityConfig = xv8Var.activityConfig;
            setIsShowRedTip(xv8Var.isShowRedTip());
            this.isBrandForum = xv8Var.isBrandForum;
            this.brandAdData = xv8Var.brandAdData;
            this.oriForumInfoList = xv8Var.oriForumInfoList;
            this.bottomMenuList = xv8Var.bottomMenuList;
            this.adMixFloor = xv8Var.adMixFloor;
            this.adShowSelect = xv8Var.adShowSelect;
            this.adSampleMapKey = xv8Var.adSampleMapKey;
            gn6.f().n(getAnti());
            gn6.f().q(xv8Var.getForum().getId());
            gn6.f().r(xv8Var.getForum().getName());
            fn6.h().q(xv8Var.getForum().getId());
            if (xv8Var.getEntelechyTabInfo() != null) {
                fn6.h().r(xv8Var.getEntelechyTabInfo().a);
            }
            if (xv8Var.getUserData() != null) {
                hn6.c().e(xv8Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(xv8Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(xv8Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = xv8Var.smartAppAvatar;
            this.smartApp = xv8Var.smartApp;
            this.nebulaHotThreads = xv8Var.nebulaHotThreads;
            this.forumActiveInfo = xv8Var.forumActiveInfo;
            this.userList = xv8Var.userList;
            setBusinessPromot(xv8Var.getBusinessPromot());
            this.serviceAreaData = xv8Var.serviceAreaData;
            setHotUserRankData(xv8Var.getHotUserRankData());
            this.itemInfo = xv8Var.itemInfo;
            this.toLoadHorseData = xv8Var.toLoadHorseData;
            this.forumRule = xv8Var.forumRule;
            this.mSignActivityInfo = xv8Var.mSignActivityInfo;
            this.showAdsense = xv8Var.showAdsense;
            setVoiceRoomConfig(xv8Var.getVoiceRoomConfig());
            setVoiceRoomData(xv8Var.getVoiceRoomData());
            this.serviceAreaFlutterData = xv8Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = xv8Var.liveFuseForumDataList;
            this.frsGameRankInfoData = xv8Var.frsGameRankInfoData;
            this.frsBannerHeaderData = xv8Var.frsBannerHeaderData;
            this.forumTagInfo = xv8Var.forumTagInfo;
            this.firstCategory = xv8Var.firstCategory;
            this.frsForumGroup = xv8Var.frsForumGroup;
            return true;
        }
        return invokeL.booleanValue;
    }
}
