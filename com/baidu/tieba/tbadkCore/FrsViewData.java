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
import com.baidu.tieba.ao8;
import com.baidu.tieba.dx6;
import com.baidu.tieba.hj6;
import com.baidu.tieba.in8;
import com.baidu.tieba.jn8;
import com.baidu.tieba.ki6;
import com.baidu.tieba.ky4;
import com.baidu.tieba.li6;
import com.baidu.tieba.mi6;
import com.baidu.tieba.mn8;
import com.baidu.tieba.nc5;
import com.baidu.tieba.nn8;
import com.baidu.tieba.oo5;
import com.baidu.tieba.pn8;
import com.baidu.tieba.pt4;
import com.baidu.tieba.rn8;
import com.baidu.tieba.s46;
import com.baidu.tieba.sn8;
import com.baidu.tieba.st4;
import com.baidu.tieba.tn8;
import com.baidu.tieba.tw6;
import com.baidu.tieba.un8;
import com.baidu.tieba.vu4;
import com.baidu.tieba.wg;
import com.baidu.tieba.wi;
import com.baidu.tieba.wn;
import com.baidu.tieba.wo5;
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
public class FrsViewData extends pn8 implements nc5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public tw6 funAdController;
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

    @Override // com.baidu.tieba.pn8
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
            removeTopSameClassDataFromList(in8.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            removeTopSameClassDataFromList(jn8.class, getThreadList());
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

    public void addRecommendAppToThreadList(oo5 oo5Var, ArrayList<wn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, oo5Var, arrayList) == null) {
            addRecommendAppToThreadList(oo5Var, false, arrayList, null, false);
        }
    }

    private List<wn> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        st4 st4Var;
        ArrayList<wn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<wn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (st4Var = this.page) != null && st4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    wn wnVar = this.threadList.get(i);
                    if (wnVar instanceof vu4) {
                        if (((vu4) wnVar).t.isHeadLinePost) {
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
            if (wnVar instanceof vu4) {
                ThreadData threadData = ((vu4) wnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            nn8 nn8Var = new nn8();
            nn8Var.f(this.forum.getId());
            nn8Var.c(feedForumList);
            this.threadList.add(i + 6, nn8Var);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        s46 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    wn wnVar = this.threadList.get(i2);
                    if (wnVar instanceof vu4) {
                        ThreadData threadData = ((vu4) wnVar).t;
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
            while (!this.threadList.isEmpty() && (wnVar = this.threadList.get(0)) != null && (wnVar instanceof vu4) && ((ThreadData) wnVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            vu4 vu4Var = new vu4();
            vu4Var.t = threadData;
            this.threadList.add(0, vu4Var);
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

    public void addRecommendAppToThreadList(oo5 oo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, oo5Var) == null) {
            addRecommendAppToThreadList(oo5Var, false, this.threadList, null, false);
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

    public void setFunAdController(tw6 tw6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, tw6Var) == null) {
            this.funAdController = tw6Var;
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
        jn8 frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<wn> threadList = getThreadList();
            removeTopSameClassDataFromList(jn8.class, threadList);
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
                if (next != null && next.getType() == un8.c) {
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
            if (wnVar instanceof vu4) {
                ThreadData threadData = ((vu4) wnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String q = ky4.k().q("game_rank_list_info", "");
        if (!StringUtils.isNull(q) && q.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(wg.g(q.split(",")[0], 0L), System.currentTimeMillis()) < wg.e(q.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int l = ky4.k().l("game_rank_list_show_times", 0);
                    if (!z) {
                        l++;
                    }
                    ky4.k().w("game_rank_list_show_times", l);
                    if (l > 3) {
                        ky4 k = ky4.k();
                        k.y("game_rank_list_info", System.currentTimeMillis() + ",1");
                        ky4.k().w("game_rank_list_show_times", 0);
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
        in8 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<wn> threadList = getThreadList();
            removeTopSameClassDataFromList(in8.class, threadList);
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
            hj6 userRecommend = getUserRecommend();
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
            rn8 entelechyTabInfo = getEntelechyTabInfo();
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
                if (next != null && next.getType() == dx6.e) {
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
            if (it.next() instanceof hj6) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(pt4 pt4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, pt4Var) == null) && pt4Var != null && !StringUtils.isNull(pt4Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<wn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    wn wnVar = threadList.get(i);
                    if ((wnVar instanceof vu4) && pt4Var.getId().equals(((vu4) wnVar).t.getId()) && pt4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            pt4Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, pt4Var);
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
                if (next != null && (next instanceof vu4)) {
                    vu4 vu4Var = (vu4) next;
                    if (vu4Var.t.getAuthor() != null && currentAccount.equals(vu4Var.t.getAuthor().getUserId()) && vu4Var.t.getAuthor().getPendantData() != null) {
                        vu4Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        vu4Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(oo5 oo5Var, boolean z, ArrayList<wn> arrayList, ArrayList<wn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{oo5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                wo5 wo5Var = new wo5(oo5Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                wo5Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, wo5Var));
                wo5 wo5Var2 = new wo5(oo5Var, 3);
                wo5Var2.z(z);
                wo5Var2.G(arrayList);
                wo5Var2.D(arrayList2);
                wo5Var2.y(z2);
                wo5Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    wo5Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    wo5Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, wo5Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<wn> arrayList;
        st4 st4Var;
        ArrayList<wn> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (st4Var = this.page) != null && st4Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                wn wnVar = this.threadList.get(i2);
                if (wnVar instanceof vu4) {
                    vu4 vu4Var = (vu4) wnVar;
                    if (vu4Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && vu4Var.t.getThreadAlaInfo() != null && vu4Var.t.getThreadAlaInfo().user_info != null && vu4Var.t.getThreadAlaInfo().user_info.is_official == 2 && vu4Var.t.getThreadAlaInfo().liveStageForceTop) {
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
                    if (wnVar2 instanceof vu4) {
                        if (((vu4) wnVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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

    public void filterEnterList(List<mn8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, list) == null) && list != null && list.size() != 0) {
            Iterator<mn8> it = list.iterator();
            while (it.hasNext()) {
                mn8 next = it.next();
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

    public List<wn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<mn8> list;
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
                arrayList.add(new tn8(forum, this.forumRule));
            }
            if (forum != null && !wi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new sn8(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new sn8(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<wn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    wn wnVar = (wn) ListUtils.getItem(topThreadList, i4);
                    if (wnVar instanceof vu4) {
                        vu4 vu4Var = (vu4) wnVar;
                        arrayList.add(vu4Var.t);
                        if (vu4Var.t.getIsMemberTop() != 1 || z) {
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
                if (next != null && (next instanceof vu4)) {
                    vu4 vu4Var = (vu4) next;
                    if (TextUtils.equals(str, vu4Var.t.getId())) {
                        return vu4Var.t;
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
            if (next != null && (next instanceof vu4) && TextUtils.equals(str, ((vu4) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(ao8 ao8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, ao8Var) != null) || ao8Var == null) {
            return;
        }
        this.forum.setCurScore(ao8Var.c());
        this.forum.setLevelupScore(ao8Var.i());
        this.forum.setLike(ao8Var.m());
        this.forum.setUser_level(ao8Var.l());
        this.forum.setLevelName(ao8Var.h());
    }

    public boolean receiveData(pn8 pn8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, pn8Var)) == null) {
            if (pn8Var == null) {
                return false;
            }
            this.isFromCache = pn8Var.isFromCache;
            setBaWuNoticeNum(pn8Var.getBaWuNoticeNum());
            setSortType(pn8Var.getSortType());
            setAnti(pn8Var.getAnti());
            setChatGroup(pn8Var.getChatGroup());
            setFortuneBag(pn8Var.isFortuneBag());
            setFortuneDesc(pn8Var.getFortuneDesc());
            setForum(pn8Var.getForum());
            setGameName(pn8Var.getGameName());
            setGameUrl(pn8Var.getGameUrl());
            setGconAccount(pn8Var.getGconAccount());
            setHasGame(pn8Var.isHasGame());
            setIsNewUrl(pn8Var.getIsNewUrl());
            setPhotoLivePos(pn8Var.getPhotoLivePos());
            setPage(pn8Var.getPage());
            setStar(pn8Var.getStar());
            setStarEnter(pn8Var.getStarEnter());
            setThreadList(pn8Var.threadList);
            setThreadListIds(pn8Var.getThreadListIds());
            setUserData(pn8Var.getUserData());
            setUserMap(pn8Var.getUserMap());
            setActivityHeadData(pn8Var.getActivityHeadData());
            setFrsDefaultTabId(pn8Var.getFrsDefaultTabId());
            this.defaultShowTab = pn8Var.defaultShowTab;
            setCategoryInfos(pn8Var.getCategoryInfos());
            setBawuCenterUrl(pn8Var.getBawuCenterUrl());
            setCardVideoInfo(pn8Var.getCardVideoInfo());
            setHeadSdkData(pn8Var.getHeadSdkData());
            setSchoolRecommendPos(pn8Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(pn8Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(pn8Var.getEntelechyTabInfo());
            setAlaLiveCount(pn8Var.getAlaLiveCount());
            setCarrierEnterData(pn8Var.getCarrierEnterData());
            setForumState(pn8Var.getForumState());
            setAccessFlag(pn8Var.getAccessFlag());
            this.needLog = pn8Var.needLog;
            this.recommendBookData = pn8Var.recommendBookData;
            this.presentInfoData = pn8Var.presentInfoData;
            setBookInfo(pn8Var.getBookInfo());
            setMangaReadRecordChapterId(pn8Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(pn8Var.getHeadlineImgInfoData());
            setCardShipinPos(pn8Var.getCardShipinPos());
            setCardShipinNew(pn8Var.getCardShipinNew());
            this.enterFrsDialogInfo = pn8Var.enterFrsDialogInfo;
            setGameRankListData(pn8Var.getGameRankListData());
            setAgreeBanner(pn8Var.getAgreeBanner());
            setLiveNotify(pn8Var.getLiveNotify());
            setGameTabInfo(pn8Var.getGameTabInfo());
            setGameDefaultTabId(pn8Var.getGameDefaultTabId());
            setForumHeadIcon(pn8Var.getForumHeadIcon());
            setUserRecommend(pn8Var.getUserRecommend());
            setFrsVideoActivityData(pn8Var.getFrsVideoActivityData());
            this.mNewChapterInfo = pn8Var.mNewChapterInfo;
            setFrsInsertLiveData(pn8Var.getFrsInsertLiveData());
            this.recm_forum_list = pn8Var.getRecm_forum_list();
            setFrsStageLiveData(pn8Var.getFrsStageLiveData());
            this.forumArIno = pn8Var.forumArIno;
            this.starRank = pn8Var.starRank;
            this.postTopic = pn8Var.postTopic;
            this.mWindowToast = pn8Var.mWindowToast;
            this.activityConfig = pn8Var.activityConfig;
            setIsShowRedTip(pn8Var.isShowRedTip());
            this.isBrandForum = pn8Var.isBrandForum;
            this.brandAdData = pn8Var.brandAdData;
            this.oriForumInfoList = pn8Var.oriForumInfoList;
            this.bottomMenuList = pn8Var.bottomMenuList;
            this.adMixFloor = pn8Var.adMixFloor;
            this.adShowSelect = pn8Var.adShowSelect;
            this.adSampleMapKey = pn8Var.adSampleMapKey;
            li6.f().n(getAnti());
            li6.f().q(pn8Var.getForum().getId());
            li6.f().r(pn8Var.getForum().getName());
            ki6.h().q(pn8Var.getForum().getId());
            if (pn8Var.getEntelechyTabInfo() != null) {
                ki6.h().r(pn8Var.getEntelechyTabInfo().a);
            }
            if (pn8Var.getUserData() != null) {
                mi6.c().e(pn8Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(pn8Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(pn8Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = pn8Var.smartAppAvatar;
            this.smartApp = pn8Var.smartApp;
            this.nebulaHotThreads = pn8Var.nebulaHotThreads;
            this.forumActiveInfo = pn8Var.forumActiveInfo;
            this.userList = pn8Var.userList;
            setBusinessPromot(pn8Var.getBusinessPromot());
            this.serviceAreaData = pn8Var.serviceAreaData;
            setHotUserRankData(pn8Var.getHotUserRankData());
            this.itemInfo = pn8Var.itemInfo;
            this.toLoadHorseData = pn8Var.toLoadHorseData;
            this.forumRule = pn8Var.forumRule;
            this.mSignActivityInfo = pn8Var.mSignActivityInfo;
            this.showAdsense = pn8Var.showAdsense;
            setVoiceRoomConfig(pn8Var.getVoiceRoomConfig());
            setVoiceRoomData(pn8Var.getVoiceRoomData());
            this.serviceAreaFlutterData = pn8Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = pn8Var.liveFuseForumDataList;
            this.frsGameRankInfoData = pn8Var.frsGameRankInfoData;
            this.forumTagInfo = pn8Var.forumTagInfo;
            this.firstCategory = pn8Var.firstCategory;
            return true;
        }
        return invokeL.booleanValue;
    }
}
