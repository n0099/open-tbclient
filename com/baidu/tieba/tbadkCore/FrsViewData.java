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
import com.baidu.tieba.ad7;
import com.baidu.tieba.ap6;
import com.baidu.tieba.ax9;
import com.baidu.tieba.bx9;
import com.baidu.tieba.c46;
import com.baidu.tieba.cx9;
import com.baidu.tieba.dx9;
import com.baidu.tieba.h35;
import com.baidu.tieba.jx9;
import com.baidu.tieba.k35;
import com.baidu.tieba.kq5;
import com.baidu.tieba.n45;
import com.baidu.tieba.n95;
import com.baidu.tieba.rw9;
import com.baidu.tieba.st7;
import com.baidu.tieba.sw9;
import com.baidu.tieba.tg;
import com.baidu.tieba.u36;
import com.baidu.tieba.ui;
import com.baidu.tieba.vd7;
import com.baidu.tieba.vn;
import com.baidu.tieba.vw9;
import com.baidu.tieba.ww9;
import com.baidu.tieba.yc7;
import com.baidu.tieba.yw9;
import com.baidu.tieba.zc7;
import com.baidu.tieba.zs7;
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
public class FrsViewData extends yw9 implements kq5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public zs7 funAdController;
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

    @Override // com.baidu.tieba.yw9
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

    public List<vn> getTopThreadList() {
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
            removeTopSameClassDataFromList(rw9.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            removeTopSameClassDataFromList(sw9.class, getThreadList());
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

    public void addRecommendAppToThreadList(u36 u36Var, ArrayList<vn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, u36Var, arrayList) == null) {
            addRecommendAppToThreadList(u36Var, false, arrayList, null, false);
        }
    }

    private List<vn> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        k35 k35Var;
        ArrayList<vn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<vn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (k35Var = this.page) != null && k35Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    vn vnVar = this.threadList.get(i);
                    if (vnVar instanceof n45) {
                        if (((n45) vnVar).t.isHeadLinePost) {
                            arrayList2.add(vnVar);
                        }
                    } else if ((vnVar instanceof ThreadData) && ((ThreadData) vnVar).isHeadLinePost) {
                        arrayList2.add(vnVar);
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
            vn vnVar = this.threadList.get(i2);
            if (vnVar instanceof n45) {
                ThreadData threadData = ((n45) vnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            ww9 ww9Var = new ww9();
            ww9Var.d(this.forum.getId());
            ww9Var.c(feedForumList);
            this.threadList.add(i + 6, ww9Var);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        ap6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    vn vnVar = this.threadList.get(i2);
                    if (vnVar instanceof n45) {
                        ThreadData threadData = ((n45) vnVar).t;
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
        vn vnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (vnVar = this.threadList.get(0)) != null && (vnVar instanceof n45) && ((ThreadData) vnVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            n45 n45Var = new n45();
            n45Var.t = threadData;
            this.threadList.add(0, n45Var);
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || getForum() == null) {
            return;
        }
        List<vn> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<vn> threadList = getThreadList();
        if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
            int size = cardShipinPos.size();
            int size2 = threadList.size();
            for (int i = 0; i < size; i++) {
                if (i < cardShipinNew.size()) {
                    vn vnVar = cardShipinNew.get(i);
                    int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                    Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + vnVar.getType());
                    threadList.add(videoThreadInserPos, vnVar);
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

    public void addRecommendAppToThreadList(u36 u36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, u36Var) == null) {
            addRecommendAppToThreadList(u36Var, false, this.threadList, null, false);
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

    public void setFunAdController(zs7 zs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, zs7Var) == null) {
            this.funAdController = zs7Var;
        }
    }

    public void setTopThreadList(List<vn> list) {
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<vn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, cls, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                vn vnVar = arrayList.get(i);
                if (vnVar.getClass() == cls) {
                    arrayList2.add(vnVar);
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
            ArrayList<vn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        sw9 frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<vn> threadList = getThreadList();
            removeTopSameClassDataFromList(sw9.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<vn> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                vn next = it.next();
                if (next != null && next.getType() == dx9.c) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<vn> arrayList;
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
            vn vnVar = this.threadList.get(i2);
            if (vnVar instanceof n45) {
                ThreadData threadData = ((n45) vnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String s = n95.m().s("game_rank_list_info", "");
        if (!StringUtils.isNull(s) && s.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(tg.g(s.split(",")[0], 0L), System.currentTimeMillis()) < tg.e(s.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int n = n95.m().n("game_rank_list_show_times", 0);
                    if (!z) {
                        n++;
                    }
                    n95.m().z("game_rank_list_show_times", n);
                    if (n > 3) {
                        n95 m = n95.m();
                        m.B("game_rank_list_info", System.currentTimeMillis() + ",1");
                        n95.m().z("game_rank_list_show_times", 0);
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
        rw9 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<vn> threadList = getThreadList();
            removeTopSameClassDataFromList(rw9.class, threadList);
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
            vd7 userRecommend = getUserRecommend();
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
            ArrayList<vn> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<vn> it = this.threadList.iterator();
                while (it.hasNext()) {
                    vn next = it.next();
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
            ax9 entelechyTabInfo = getEntelechyTabInfo();
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
            Iterator<vn> it = this.threadList.iterator();
            while (it.hasNext()) {
                vn next = it.next();
                if (next != null && next.getType() == st7.e) {
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
        Iterator<vn> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof vd7) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(h35 h35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, h35Var) == null) && h35Var != null && !StringUtils.isNull(h35Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<vn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    vn vnVar = threadList.get(i);
                    if ((vnVar instanceof n45) && h35Var.getId().equals(((n45) vnVar).t.getId()) && h35Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            h35Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, h35Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<vn> it = this.threadList.iterator();
            while (it.hasNext()) {
                vn next = it.next();
                if (next != null && (next instanceof n45)) {
                    n45 n45Var = (n45) next;
                    if (n45Var.t.getAuthor() != null && currentAccount.equals(n45Var.t.getAuthor().getUserId()) && n45Var.t.getAuthor().getPendantData() != null) {
                        n45Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        n45Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(u36 u36Var, boolean z, ArrayList<vn> arrayList, ArrayList<vn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{u36Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                c46 c46Var = new c46(u36Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                c46Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, c46Var));
                c46 c46Var2 = new c46(u36Var, 3);
                c46Var2.z(z);
                c46Var2.G(arrayList);
                c46Var2.D(arrayList2);
                c46Var2.y(z2);
                c46Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    c46Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    c46Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, c46Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<vn> arrayList;
        k35 k35Var;
        ArrayList<vn> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (k35Var = this.page) != null && k35Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                vn vnVar = this.threadList.get(i2);
                if (vnVar instanceof n45) {
                    n45 n45Var = (n45) vnVar;
                    if (n45Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && n45Var.t.getThreadAlaInfo() != null && n45Var.t.getThreadAlaInfo().user_info != null && n45Var.t.getThreadAlaInfo().user_info.is_official == 2 && n45Var.t.getThreadAlaInfo().liveStageForceTop) {
                        i = i2;
                        break;
                    }
                } else {
                    if (vnVar instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) vnVar;
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
                    vn vnVar2 = this.threadList.get(i3);
                    if (vnVar2 instanceof n45) {
                        if (((n45) vnVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((vnVar2 instanceof ThreadData) && ((ThreadData) vnVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
            List<vn> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!ListUtils.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    public void filterEnterList(List<vw9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, list) == null) && list != null && list.size() != 0) {
            Iterator<vw9> it = list.iterator();
            while (it.hasNext()) {
                vw9 next = it.next();
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

    public List<vn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<vw9> list;
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
                arrayList.add(new cx9(forum, this.forumRule));
            }
            if (forum != null && !ui.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new bx9(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new bx9(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<vn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    vn vnVar = (vn) ListUtils.getItem(topThreadList, i4);
                    if (vnVar instanceof n45) {
                        n45 n45Var = (n45) vnVar;
                        arrayList.add(n45Var.t);
                        if (n45Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (vnVar instanceof ThreadData) {
                            arrayList.add(vnVar);
                            if (((ThreadData) vnVar).getIsMemberTop() != 1 || z) {
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
            ArrayList<vn> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<vn> it = arrayList.iterator();
            while (it.hasNext()) {
                vn next = it.next();
                if (next != null && (next instanceof n45)) {
                    n45 n45Var = (n45) next;
                    if (TextUtils.equals(str, n45Var.t.getId())) {
                        return n45Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public void removeThread(String str) {
        ArrayList<vn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<vn> it = arrayList.iterator();
        while (it.hasNext()) {
            vn next = it.next();
            if (next != null && (next instanceof n45) && TextUtils.equals(str, ((n45) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(jx9 jx9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, jx9Var) != null) || jx9Var == null) {
            return;
        }
        this.forum.setCurScore(jx9Var.c());
        this.forum.setLevelupScore(jx9Var.i());
        this.forum.setLike(jx9Var.n());
        this.forum.setUser_level(jx9Var.m());
        this.forum.setLevelName(jx9Var.h());
    }

    public boolean receiveData(yw9 yw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, yw9Var)) == null) {
            if (yw9Var == null) {
                return false;
            }
            this.isFromCache = yw9Var.isFromCache;
            setBaWuNoticeNum(yw9Var.getBaWuNoticeNum());
            setSortType(yw9Var.getSortType());
            setAnti(yw9Var.getAnti());
            setChatGroup(yw9Var.getChatGroup());
            setFortuneBag(yw9Var.isFortuneBag());
            setFortuneDesc(yw9Var.getFortuneDesc());
            setForum(yw9Var.getForum());
            setGameName(yw9Var.getGameName());
            setGameUrl(yw9Var.getGameUrl());
            setGconAccount(yw9Var.getGconAccount());
            setHasGame(yw9Var.isHasGame());
            setIsNewUrl(yw9Var.getIsNewUrl());
            setPhotoLivePos(yw9Var.getPhotoLivePos());
            setPage(yw9Var.getPage());
            setStar(yw9Var.getStar());
            setStarEnter(yw9Var.getStarEnter());
            setThreadList(yw9Var.threadList);
            setThreadListIds(yw9Var.getThreadListIds());
            setUserData(yw9Var.getUserData());
            setUserMap(yw9Var.getUserMap());
            setActivityHeadData(yw9Var.getActivityHeadData());
            setFrsDefaultTabId(yw9Var.getFrsDefaultTabId());
            this.defaultShowTab = yw9Var.defaultShowTab;
            setCategoryInfos(yw9Var.getCategoryInfos());
            setBawuCenterUrl(yw9Var.getBawuCenterUrl());
            setCardVideoInfo(yw9Var.getCardVideoInfo());
            setHeadSdkData(yw9Var.getHeadSdkData());
            setSchoolRecommendPos(yw9Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(yw9Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(yw9Var.getEntelechyTabInfo());
            setAlaLiveCount(yw9Var.getAlaLiveCount());
            setCarrierEnterData(yw9Var.getCarrierEnterData());
            setForumState(yw9Var.getForumState());
            setAccessFlag(yw9Var.getAccessFlag());
            this.needLog = yw9Var.needLog;
            this.recommendBookData = yw9Var.recommendBookData;
            this.presentInfoData = yw9Var.presentInfoData;
            setBookInfo(yw9Var.getBookInfo());
            setMangaReadRecordChapterId(yw9Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(yw9Var.getHeadlineImgInfoData());
            setCardShipinPos(yw9Var.getCardShipinPos());
            setCardShipinNew(yw9Var.getCardShipinNew());
            this.enterFrsDialogInfo = yw9Var.enterFrsDialogInfo;
            setGameRankListData(yw9Var.getGameRankListData());
            setAgreeBanner(yw9Var.getAgreeBanner());
            setLiveNotify(yw9Var.getLiveNotify());
            setGameTabInfo(yw9Var.getGameTabInfo());
            setGameDefaultTabId(yw9Var.getGameDefaultTabId());
            setForumHeadIcon(yw9Var.getForumHeadIcon());
            setUserRecommend(yw9Var.getUserRecommend());
            setFrsVideoActivityData(yw9Var.getFrsVideoActivityData());
            this.mNewChapterInfo = yw9Var.mNewChapterInfo;
            setFrsInsertLiveData(yw9Var.getFrsInsertLiveData());
            this.recm_forum_list = yw9Var.getRecm_forum_list();
            setFrsStageLiveData(yw9Var.getFrsStageLiveData());
            this.forumArIno = yw9Var.forumArIno;
            this.starRank = yw9Var.starRank;
            this.postTopic = yw9Var.postTopic;
            this.mWindowToast = yw9Var.mWindowToast;
            this.activityConfig = yw9Var.activityConfig;
            setIsShowRedTip(yw9Var.isShowRedTip());
            this.isBrandForum = yw9Var.isBrandForum;
            this.brandAdData = yw9Var.brandAdData;
            this.oriForumInfoList = yw9Var.oriForumInfoList;
            this.bottomMenuList = yw9Var.bottomMenuList;
            this.adMixFloor = yw9Var.adMixFloor;
            this.adShowSelect = yw9Var.adShowSelect;
            this.adSampleMapKey = yw9Var.adSampleMapKey;
            zc7.f().n(getAnti());
            zc7.f().q(yw9Var.getForum().getId());
            zc7.f().r(yw9Var.getForum().getName());
            yc7.h().q(yw9Var.getForum().getId());
            if (yw9Var.getEntelechyTabInfo() != null) {
                yc7.h().r(yw9Var.getEntelechyTabInfo().a);
            }
            if (yw9Var.getUserData() != null) {
                ad7.c().e(yw9Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(yw9Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(yw9Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = yw9Var.smartAppAvatar;
            this.smartApp = yw9Var.smartApp;
            this.nebulaHotThreads = yw9Var.nebulaHotThreads;
            this.forumActiveInfo = yw9Var.forumActiveInfo;
            this.userList = yw9Var.userList;
            setBusinessPromot(yw9Var.getBusinessPromot());
            this.serviceAreaData = yw9Var.serviceAreaData;
            setHotUserRankData(yw9Var.getHotUserRankData());
            this.itemInfo = yw9Var.itemInfo;
            this.toLoadHorseData = yw9Var.toLoadHorseData;
            this.forumRule = yw9Var.forumRule;
            this.mSignActivityInfo = yw9Var.mSignActivityInfo;
            this.showAdsense = yw9Var.showAdsense;
            setVoiceRoomConfig(yw9Var.getVoiceRoomConfig());
            setVoiceRoomData(yw9Var.getVoiceRoomData());
            this.serviceAreaFlutterData = yw9Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = yw9Var.liveFuseForumDataList;
            this.frsGameRankInfoData = yw9Var.frsGameRankInfoData;
            this.frsBannerHeaderData = yw9Var.frsBannerHeaderData;
            this.forumTagInfo = yw9Var.forumTagInfo;
            this.firstCategory = yw9Var.firstCategory;
            this.frsForumGroup = yw9Var.frsForumGroup;
            return true;
        }
        return invokeL.booleanValue;
    }
}
