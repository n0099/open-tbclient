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
import com.baidu.tieba.ae7;
import com.baidu.tieba.au7;
import com.baidu.tieba.bz9;
import com.baidu.tieba.dd7;
import com.baidu.tieba.ed7;
import com.baidu.tieba.fd7;
import com.baidu.tieba.fp6;
import com.baidu.tieba.h46;
import com.baidu.tieba.ht7;
import com.baidu.tieba.i35;
import com.baidu.tieba.jy9;
import com.baidu.tieba.ky9;
import com.baidu.tieba.l35;
import com.baidu.tieba.ny9;
import com.baidu.tieba.o45;
import com.baidu.tieba.o95;
import com.baidu.tieba.oy9;
import com.baidu.tieba.pq5;
import com.baidu.tieba.qy9;
import com.baidu.tieba.sy9;
import com.baidu.tieba.ty9;
import com.baidu.tieba.ug;
import com.baidu.tieba.uy9;
import com.baidu.tieba.vi;
import com.baidu.tieba.vy9;
import com.baidu.tieba.wn;
import com.baidu.tieba.z36;
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
public class FrsViewData extends qy9 implements pq5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public ht7 funAdController;
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

    @Override // com.baidu.tieba.qy9
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

    public List<wn> getTopThreadList() {
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
            removeTopSameClassDataFromList(jy9.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            removeTopSameClassDataFromList(ky9.class, getThreadList());
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

    public void addRecommendAppToThreadList(z36 z36Var, ArrayList<wn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z36Var, arrayList) == null) {
            addRecommendAppToThreadList(z36Var, false, arrayList, null, false);
        }
    }

    private List<wn> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        l35 l35Var;
        ArrayList<wn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<wn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (l35Var = this.page) != null && l35Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    wn wnVar = this.threadList.get(i);
                    if (wnVar instanceof o45) {
                        if (((o45) wnVar).t.isHeadLinePost) {
                            arrayList2.add(wnVar);
                        }
                    } else if ((wnVar instanceof ThreadData) && ((ThreadData) wnVar).isHeadLinePost) {
                        arrayList2.add(wnVar);
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
            wn wnVar = this.threadList.get(i2);
            if (wnVar instanceof o45) {
                ThreadData threadData = ((o45) wnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            oy9 oy9Var = new oy9();
            oy9Var.d(this.forum.getId());
            oy9Var.c(feedForumList);
            this.threadList.add(i + 6, oy9Var);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        fp6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    wn wnVar = this.threadList.get(i2);
                    if (wnVar instanceof o45) {
                        ThreadData threadData = ((o45) wnVar).t;
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
        wn wnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (wnVar = this.threadList.get(0)) != null && (wnVar instanceof o45) && ((ThreadData) wnVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            o45 o45Var = new o45();
            o45Var.t = threadData;
            this.threadList.add(0, o45Var);
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || getForum() == null) {
            return;
        }
        List<wn> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<wn> threadList = getThreadList();
        if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
            int size = cardShipinPos.size();
            int size2 = threadList.size();
            for (int i = 0; i < size; i++) {
                if (i < cardShipinNew.size()) {
                    wn wnVar = cardShipinNew.get(i);
                    int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                    Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + wnVar.getType());
                    threadList.add(videoThreadInserPos, wnVar);
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

    public void addRecommendAppToThreadList(z36 z36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, z36Var) == null) {
            addRecommendAppToThreadList(z36Var, false, this.threadList, null, false);
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

    public void setFunAdController(ht7 ht7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, ht7Var) == null) {
            this.funAdController = ht7Var;
        }
    }

    public void setTopThreadList(List<wn> list) {
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<wn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, cls, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                wn wnVar = arrayList.get(i);
                if (wnVar.getClass() == cls) {
                    arrayList2.add(wnVar);
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
            ArrayList<wn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        ky9 frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<wn> threadList = getThreadList();
            removeTopSameClassDataFromList(ky9.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<wn> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                wn next = it.next();
                if (next != null && next.getType() == vy9.c) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<wn> arrayList;
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
            wn wnVar = this.threadList.get(i2);
            if (wnVar instanceof o45) {
                ThreadData threadData = ((o45) wnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String w = o95.p().w("game_rank_list_info", "");
        if (!StringUtils.isNull(w) && w.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(ug.g(w.split(",")[0], 0L), System.currentTimeMillis()) < ug.e(w.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int q = o95.p().q("game_rank_list_show_times", 0);
                    if (!z) {
                        q++;
                    }
                    o95.p().F("game_rank_list_show_times", q);
                    if (q > 3) {
                        o95 p = o95.p();
                        p.J("game_rank_list_info", System.currentTimeMillis() + ",1");
                        o95.p().F("game_rank_list_show_times", 0);
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
        jy9 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<wn> threadList = getThreadList();
            removeTopSameClassDataFromList(jy9.class, threadList);
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
            ae7 userRecommend = getUserRecommend();
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
            ArrayList<wn> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<wn> it = this.threadList.iterator();
                while (it.hasNext()) {
                    wn next = it.next();
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
            sy9 entelechyTabInfo = getEntelechyTabInfo();
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
            Iterator<wn> it = this.threadList.iterator();
            while (it.hasNext()) {
                wn next = it.next();
                if (next != null && next.getType() == au7.e) {
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
        Iterator<wn> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof ae7) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(i35 i35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, i35Var) == null) && i35Var != null && !StringUtils.isNull(i35Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<wn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    wn wnVar = threadList.get(i);
                    if ((wnVar instanceof o45) && i35Var.getId().equals(((o45) wnVar).t.getId()) && i35Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            i35Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, i35Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<wn> it = this.threadList.iterator();
            while (it.hasNext()) {
                wn next = it.next();
                if (next != null && (next instanceof o45)) {
                    o45 o45Var = (o45) next;
                    if (o45Var.t.getAuthor() != null && currentAccount.equals(o45Var.t.getAuthor().getUserId()) && o45Var.t.getAuthor().getPendantData() != null) {
                        o45Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        o45Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(z36 z36Var, boolean z, ArrayList<wn> arrayList, ArrayList<wn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{z36Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                h46 h46Var = new h46(z36Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                h46Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, h46Var));
                h46 h46Var2 = new h46(z36Var, 3);
                h46Var2.z(z);
                h46Var2.G(arrayList);
                h46Var2.D(arrayList2);
                h46Var2.y(z2);
                h46Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    h46Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    h46Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, h46Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<wn> arrayList;
        l35 l35Var;
        ArrayList<wn> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (l35Var = this.page) != null && l35Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                wn wnVar = this.threadList.get(i2);
                if (wnVar instanceof o45) {
                    o45 o45Var = (o45) wnVar;
                    if (o45Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && o45Var.t.getThreadAlaInfo() != null && o45Var.t.getThreadAlaInfo().user_info != null && o45Var.t.getThreadAlaInfo().user_info.is_official == 2 && o45Var.t.getThreadAlaInfo().liveStageForceTop) {
                        i = i2;
                        break;
                    }
                } else {
                    if (wnVar instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) wnVar;
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
                    wn wnVar2 = this.threadList.get(i3);
                    if (wnVar2 instanceof o45) {
                        if (((o45) wnVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((wnVar2 instanceof ThreadData) && ((ThreadData) wnVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
            List<wn> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!ListUtils.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    public void filterEnterList(List<ny9> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, list) == null) && list != null && list.size() != 0) {
            Iterator<ny9> it = list.iterator();
            while (it.hasNext()) {
                ny9 next = it.next();
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

    public List<wn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<ny9> list;
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
                arrayList.add(new uy9(forum, this.forumRule));
            }
            if (forum != null && !vi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new ty9(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new ty9(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<wn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    wn wnVar = (wn) ListUtils.getItem(topThreadList, i4);
                    if (wnVar instanceof o45) {
                        o45 o45Var = (o45) wnVar;
                        arrayList.add(o45Var.t);
                        if (o45Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (wnVar instanceof ThreadData) {
                            arrayList.add(wnVar);
                            if (((ThreadData) wnVar).getIsMemberTop() != 1 || z) {
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
            ArrayList<wn> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<wn> it = arrayList.iterator();
            while (it.hasNext()) {
                wn next = it.next();
                if (next != null && (next instanceof o45)) {
                    o45 o45Var = (o45) next;
                    if (TextUtils.equals(str, o45Var.t.getId())) {
                        return o45Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public void removeThread(String str) {
        ArrayList<wn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<wn> it = arrayList.iterator();
        while (it.hasNext()) {
            wn next = it.next();
            if (next != null && (next instanceof o45) && TextUtils.equals(str, ((o45) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(bz9 bz9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, bz9Var) != null) || bz9Var == null) {
            return;
        }
        this.forum.setCurScore(bz9Var.c());
        this.forum.setLevelupScore(bz9Var.i());
        this.forum.setLike(bz9Var.n());
        this.forum.setUser_level(bz9Var.m());
        this.forum.setLevelName(bz9Var.h());
    }

    public boolean receiveData(qy9 qy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, qy9Var)) == null) {
            if (qy9Var == null) {
                return false;
            }
            this.isFromCache = qy9Var.isFromCache;
            setBaWuNoticeNum(qy9Var.getBaWuNoticeNum());
            setSortType(qy9Var.getSortType());
            setAnti(qy9Var.getAnti());
            setChatGroup(qy9Var.getChatGroup());
            setFortuneBag(qy9Var.isFortuneBag());
            setFortuneDesc(qy9Var.getFortuneDesc());
            setForum(qy9Var.getForum());
            setGameName(qy9Var.getGameName());
            setGameUrl(qy9Var.getGameUrl());
            setGconAccount(qy9Var.getGconAccount());
            setHasGame(qy9Var.isHasGame());
            setIsNewUrl(qy9Var.getIsNewUrl());
            setPhotoLivePos(qy9Var.getPhotoLivePos());
            setPage(qy9Var.getPage());
            setStar(qy9Var.getStar());
            setStarEnter(qy9Var.getStarEnter());
            setThreadList(qy9Var.threadList);
            setThreadListIds(qy9Var.getThreadListIds());
            setUserData(qy9Var.getUserData());
            setUserMap(qy9Var.getUserMap());
            setActivityHeadData(qy9Var.getActivityHeadData());
            setFrsDefaultTabId(qy9Var.getFrsDefaultTabId());
            this.defaultShowTab = qy9Var.defaultShowTab;
            setCategoryInfos(qy9Var.getCategoryInfos());
            setBawuCenterUrl(qy9Var.getBawuCenterUrl());
            setCardVideoInfo(qy9Var.getCardVideoInfo());
            setHeadSdkData(qy9Var.getHeadSdkData());
            setSchoolRecommendPos(qy9Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(qy9Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(qy9Var.getEntelechyTabInfo());
            setAlaLiveCount(qy9Var.getAlaLiveCount());
            setCarrierEnterData(qy9Var.getCarrierEnterData());
            setForumState(qy9Var.getForumState());
            setAccessFlag(qy9Var.getAccessFlag());
            this.needLog = qy9Var.needLog;
            this.recommendBookData = qy9Var.recommendBookData;
            this.presentInfoData = qy9Var.presentInfoData;
            setBookInfo(qy9Var.getBookInfo());
            setMangaReadRecordChapterId(qy9Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(qy9Var.getHeadlineImgInfoData());
            setCardShipinPos(qy9Var.getCardShipinPos());
            setCardShipinNew(qy9Var.getCardShipinNew());
            this.enterFrsDialogInfo = qy9Var.enterFrsDialogInfo;
            setGameRankListData(qy9Var.getGameRankListData());
            setAgreeBanner(qy9Var.getAgreeBanner());
            setLiveNotify(qy9Var.getLiveNotify());
            setGameTabInfo(qy9Var.getGameTabInfo());
            setGameDefaultTabId(qy9Var.getGameDefaultTabId());
            setForumHeadIcon(qy9Var.getForumHeadIcon());
            setUserRecommend(qy9Var.getUserRecommend());
            setFrsVideoActivityData(qy9Var.getFrsVideoActivityData());
            this.mNewChapterInfo = qy9Var.mNewChapterInfo;
            setFrsInsertLiveData(qy9Var.getFrsInsertLiveData());
            this.recm_forum_list = qy9Var.getRecm_forum_list();
            setFrsStageLiveData(qy9Var.getFrsStageLiveData());
            this.forumArIno = qy9Var.forumArIno;
            this.starRank = qy9Var.starRank;
            this.postTopic = qy9Var.postTopic;
            this.mWindowToast = qy9Var.mWindowToast;
            this.activityConfig = qy9Var.activityConfig;
            setIsShowRedTip(qy9Var.isShowRedTip());
            this.isBrandForum = qy9Var.isBrandForum;
            this.brandAdData = qy9Var.brandAdData;
            this.oriForumInfoList = qy9Var.oriForumInfoList;
            this.bottomMenuList = qy9Var.bottomMenuList;
            this.adMixFloor = qy9Var.adMixFloor;
            this.adShowSelect = qy9Var.adShowSelect;
            this.adSampleMapKey = qy9Var.adSampleMapKey;
            ed7.f().n(getAnti());
            ed7.f().q(qy9Var.getForum().getId());
            ed7.f().r(qy9Var.getForum().getName());
            dd7.h().q(qy9Var.getForum().getId());
            if (qy9Var.getEntelechyTabInfo() != null) {
                dd7.h().r(qy9Var.getEntelechyTabInfo().a);
            }
            if (qy9Var.getUserData() != null) {
                fd7.c().e(qy9Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(qy9Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(qy9Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = qy9Var.smartAppAvatar;
            this.smartApp = qy9Var.smartApp;
            this.nebulaHotThreads = qy9Var.nebulaHotThreads;
            this.forumActiveInfo = qy9Var.forumActiveInfo;
            this.userList = qy9Var.userList;
            setBusinessPromot(qy9Var.getBusinessPromot());
            this.serviceAreaData = qy9Var.serviceAreaData;
            setHotUserRankData(qy9Var.getHotUserRankData());
            this.itemInfo = qy9Var.itemInfo;
            this.toLoadHorseData = qy9Var.toLoadHorseData;
            this.forumRule = qy9Var.forumRule;
            this.mSignActivityInfo = qy9Var.mSignActivityInfo;
            this.showAdsense = qy9Var.showAdsense;
            setVoiceRoomConfig(qy9Var.getVoiceRoomConfig());
            setVoiceRoomData(qy9Var.getVoiceRoomData());
            this.serviceAreaFlutterData = qy9Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = qy9Var.liveFuseForumDataList;
            this.frsGameRankInfoData = qy9Var.frsGameRankInfoData;
            this.frsBannerHeaderData = qy9Var.frsBannerHeaderData;
            this.forumTagInfo = qy9Var.forumTagInfo;
            this.firstCategory = qy9Var.firstCategory;
            this.frsForumGroup = qy9Var.frsForumGroup;
            return true;
        }
        return invokeL.booleanValue;
    }
}
