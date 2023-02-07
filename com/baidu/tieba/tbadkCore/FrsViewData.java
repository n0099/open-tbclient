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
import com.baidu.tieba.Cdo;
import com.baidu.tieba.a09;
import com.baidu.tieba.bv5;
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.ee6;
import com.baidu.tieba.g09;
import com.baidu.tieba.jv5;
import com.baidu.tieba.l67;
import com.baidu.tieba.ni5;
import com.baidu.tieba.ns6;
import com.baidu.tieba.oz8;
import com.baidu.tieba.p35;
import com.baidu.tieba.pz8;
import com.baidu.tieba.qr6;
import com.baidu.tieba.qy4;
import com.baidu.tieba.rr6;
import com.baidu.tieba.sr6;
import com.baidu.tieba.sz8;
import com.baidu.tieba.ty4;
import com.baidu.tieba.tz8;
import com.baidu.tieba.v67;
import com.baidu.tieba.vz8;
import com.baidu.tieba.wz4;
import com.baidu.tieba.xz8;
import com.baidu.tieba.yz8;
import com.baidu.tieba.zz8;
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
public class FrsViewData extends vz8 implements ni5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public l67 funAdController;
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

    @Override // com.baidu.tieba.vz8
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

    public List<Cdo> getTopThreadList() {
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
            removeTopSameClassDataFromList(oz8.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            removeTopSameClassDataFromList(pz8.class, getThreadList());
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

    public void addRecommendAppToThreadList(bv5 bv5Var, ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bv5Var, arrayList) == null) {
            addRecommendAppToThreadList(bv5Var, false, arrayList, null, false);
        }
    }

    private List<Cdo> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        ty4 ty4Var;
        ArrayList<Cdo> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<Cdo> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (ty4Var = this.page) != null && ty4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    Cdo cdo = this.threadList.get(i);
                    if (cdo instanceof wz4) {
                        if (((wz4) cdo).t.isHeadLinePost) {
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

    public void addFeedForumDataToThreadList() {
        ForumData forumData;
        List<FeedForumData> feedForumList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.threadList == null || (forumData = this.forum) == null || forumData.getBannerListData() == null || MessageManager.getInstance().findTask(2003016) == null) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            Cdo cdo = this.threadList.get(i2);
            if (cdo instanceof wz4) {
                ThreadData threadData = ((wz4) cdo).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            tz8 tz8Var = new tz8();
            tz8Var.f(this.forum.getId());
            tz8Var.c(feedForumList);
            this.threadList.add(i + 6, tz8Var);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        ee6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    Cdo cdo = this.threadList.get(i2);
                    if (cdo instanceof wz4) {
                        ThreadData threadData = ((wz4) cdo).t;
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
        Cdo cdo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (cdo = this.threadList.get(0)) != null && (cdo instanceof wz4) && ((ThreadData) cdo).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            wz4 wz4Var = new wz4();
            wz4Var.t = threadData;
            this.threadList.add(0, wz4Var);
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || getForum() == null) {
            return;
        }
        List<Cdo> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<Cdo> threadList = getThreadList();
        if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
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
    }

    private int getPhotoliveCardInsertPos(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) {
            return Math.min((getTopThreadSize() + getPhotoLivePos()) - 1, i);
        }
        return invokeI.intValue;
    }

    public void addRecommendAppToThreadList(bv5 bv5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bv5Var) == null) {
            addRecommendAppToThreadList(bv5Var, false, this.threadList, null, false);
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

    public void setFunAdController(l67 l67Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, l67Var) == null) {
            this.funAdController = l67Var;
        }
    }

    public void setTopThreadList(List<Cdo> list) {
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, cls, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
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
            ArrayList<Cdo> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        pz8 frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<Cdo> threadList = getThreadList();
            removeTopSameClassDataFromList(pz8.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<Cdo> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Cdo next = it.next();
                if (next != null && next.getType() == a09.c) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<Cdo> arrayList;
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
            Cdo cdo = this.threadList.get(i2);
            if (cdo instanceof wz4) {
                ThreadData threadData = ((wz4) cdo).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String s = p35.m().s("game_rank_list_info", "");
        if (!StringUtils.isNull(s) && s.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(dh.g(s.split(",")[0], 0L), System.currentTimeMillis()) < dh.e(s.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int n = p35.m().n("game_rank_list_show_times", 0);
                    if (!z) {
                        n++;
                    }
                    p35.m().z("game_rank_list_show_times", n);
                    if (n > 3) {
                        p35 m = p35.m();
                        m.B("game_rank_list_info", System.currentTimeMillis() + ",1");
                        p35.m().z("game_rank_list_show_times", 0);
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
        oz8 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<Cdo> threadList = getThreadList();
            removeTopSameClassDataFromList(oz8.class, threadList);
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
            ns6 userRecommend = getUserRecommend();
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

    public boolean isFirstTabEqualAllThread() {
        InterceptResult invokeV;
        List<FrsTabInfo> list;
        FrsTabInfo frsTabInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            xz8 entelechyTabInfo = getEntelechyTabInfo();
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
            Iterator<Cdo> it = this.threadList.iterator();
            while (it.hasNext()) {
                Cdo next = it.next();
                if (next != null && next.getType() == v67.e) {
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
        Iterator<Cdo> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof ns6) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(qy4 qy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, qy4Var) == null) && qy4Var != null && !StringUtils.isNull(qy4Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<Cdo> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    Cdo cdo = threadList.get(i);
                    if ((cdo instanceof wz4) && qy4Var.getId().equals(((wz4) cdo).t.getId()) && qy4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            qy4Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, qy4Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<Cdo> it = this.threadList.iterator();
            while (it.hasNext()) {
                Cdo next = it.next();
                if (next != null && (next instanceof wz4)) {
                    wz4 wz4Var = (wz4) next;
                    if (wz4Var.t.getAuthor() != null && currentAccount.equals(wz4Var.t.getAuthor().getUserId()) && wz4Var.t.getAuthor().getPendantData() != null) {
                        wz4Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        wz4Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(bv5 bv5Var, boolean z, ArrayList<Cdo> arrayList, ArrayList<Cdo> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{bv5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                jv5 jv5Var = new jv5(bv5Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                jv5Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, jv5Var));
                jv5 jv5Var2 = new jv5(bv5Var, 3);
                jv5Var2.z(z);
                jv5Var2.G(arrayList);
                jv5Var2.D(arrayList2);
                jv5Var2.y(z2);
                jv5Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    jv5Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    jv5Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, jv5Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<Cdo> arrayList;
        ty4 ty4Var;
        ArrayList<Cdo> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (ty4Var = this.page) != null && ty4Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Cdo cdo = this.threadList.get(i2);
                if (cdo instanceof wz4) {
                    wz4 wz4Var = (wz4) cdo;
                    if (wz4Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && wz4Var.t.getThreadAlaInfo() != null && wz4Var.t.getThreadAlaInfo().user_info != null && wz4Var.t.getThreadAlaInfo().user_info.is_official == 2 && wz4Var.t.getThreadAlaInfo().liveStageForceTop) {
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
                    if (cdo2 instanceof wz4) {
                        if (((wz4) cdo2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
            if (!ListUtils.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    public void filterEnterList(List<sz8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, list) == null) && list != null && list.size() != 0) {
            Iterator<sz8> it = list.iterator();
            while (it.hasNext()) {
                sz8 next = it.next();
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

    public List<Cdo> getShowTopThreadList() {
        InterceptResult invokeV;
        List<sz8> list;
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
                arrayList.add(new zz8(forum, this.forumRule));
            }
            if (forum != null && !dj.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new yz8(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new yz8(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<Cdo> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    Cdo cdo = (Cdo) ListUtils.getItem(topThreadList, i4);
                    if (cdo instanceof wz4) {
                        wz4 wz4Var = (wz4) cdo;
                        arrayList.add(wz4Var.t);
                        if (wz4Var.t.getIsMemberTop() != 1 || z) {
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

    public ThreadData getThreadDataById(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            ArrayList<Cdo> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<Cdo> it = arrayList.iterator();
            while (it.hasNext()) {
                Cdo next = it.next();
                if (next != null && (next instanceof wz4)) {
                    wz4 wz4Var = (wz4) next;
                    if (TextUtils.equals(str, wz4Var.t.getId())) {
                        return wz4Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public void removeThread(String str) {
        ArrayList<Cdo> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<Cdo> it = arrayList.iterator();
        while (it.hasNext()) {
            Cdo next = it.next();
            if (next != null && (next instanceof wz4) && TextUtils.equals(str, ((wz4) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(g09 g09Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, g09Var) != null) || g09Var == null) {
            return;
        }
        this.forum.setCurScore(g09Var.c());
        this.forum.setLevelupScore(g09Var.i());
        this.forum.setLike(g09Var.n());
        this.forum.setUser_level(g09Var.m());
        this.forum.setLevelName(g09Var.h());
    }

    public boolean receiveData(vz8 vz8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, vz8Var)) == null) {
            if (vz8Var == null) {
                return false;
            }
            this.isFromCache = vz8Var.isFromCache;
            setBaWuNoticeNum(vz8Var.getBaWuNoticeNum());
            setSortType(vz8Var.getSortType());
            setAnti(vz8Var.getAnti());
            setChatGroup(vz8Var.getChatGroup());
            setFortuneBag(vz8Var.isFortuneBag());
            setFortuneDesc(vz8Var.getFortuneDesc());
            setForum(vz8Var.getForum());
            setGameName(vz8Var.getGameName());
            setGameUrl(vz8Var.getGameUrl());
            setGconAccount(vz8Var.getGconAccount());
            setHasGame(vz8Var.isHasGame());
            setIsNewUrl(vz8Var.getIsNewUrl());
            setPhotoLivePos(vz8Var.getPhotoLivePos());
            setPage(vz8Var.getPage());
            setStar(vz8Var.getStar());
            setStarEnter(vz8Var.getStarEnter());
            setThreadList(vz8Var.threadList);
            setThreadListIds(vz8Var.getThreadListIds());
            setUserData(vz8Var.getUserData());
            setUserMap(vz8Var.getUserMap());
            setActivityHeadData(vz8Var.getActivityHeadData());
            setFrsDefaultTabId(vz8Var.getFrsDefaultTabId());
            this.defaultShowTab = vz8Var.defaultShowTab;
            setCategoryInfos(vz8Var.getCategoryInfos());
            setBawuCenterUrl(vz8Var.getBawuCenterUrl());
            setCardVideoInfo(vz8Var.getCardVideoInfo());
            setHeadSdkData(vz8Var.getHeadSdkData());
            setSchoolRecommendPos(vz8Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(vz8Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(vz8Var.getEntelechyTabInfo());
            setAlaLiveCount(vz8Var.getAlaLiveCount());
            setCarrierEnterData(vz8Var.getCarrierEnterData());
            setForumState(vz8Var.getForumState());
            setAccessFlag(vz8Var.getAccessFlag());
            this.needLog = vz8Var.needLog;
            this.recommendBookData = vz8Var.recommendBookData;
            this.presentInfoData = vz8Var.presentInfoData;
            setBookInfo(vz8Var.getBookInfo());
            setMangaReadRecordChapterId(vz8Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(vz8Var.getHeadlineImgInfoData());
            setCardShipinPos(vz8Var.getCardShipinPos());
            setCardShipinNew(vz8Var.getCardShipinNew());
            this.enterFrsDialogInfo = vz8Var.enterFrsDialogInfo;
            setGameRankListData(vz8Var.getGameRankListData());
            setAgreeBanner(vz8Var.getAgreeBanner());
            setLiveNotify(vz8Var.getLiveNotify());
            setGameTabInfo(vz8Var.getGameTabInfo());
            setGameDefaultTabId(vz8Var.getGameDefaultTabId());
            setForumHeadIcon(vz8Var.getForumHeadIcon());
            setUserRecommend(vz8Var.getUserRecommend());
            setFrsVideoActivityData(vz8Var.getFrsVideoActivityData());
            this.mNewChapterInfo = vz8Var.mNewChapterInfo;
            setFrsInsertLiveData(vz8Var.getFrsInsertLiveData());
            this.recm_forum_list = vz8Var.getRecm_forum_list();
            setFrsStageLiveData(vz8Var.getFrsStageLiveData());
            this.forumArIno = vz8Var.forumArIno;
            this.starRank = vz8Var.starRank;
            this.postTopic = vz8Var.postTopic;
            this.mWindowToast = vz8Var.mWindowToast;
            this.activityConfig = vz8Var.activityConfig;
            setIsShowRedTip(vz8Var.isShowRedTip());
            this.isBrandForum = vz8Var.isBrandForum;
            this.brandAdData = vz8Var.brandAdData;
            this.oriForumInfoList = vz8Var.oriForumInfoList;
            this.bottomMenuList = vz8Var.bottomMenuList;
            this.adMixFloor = vz8Var.adMixFloor;
            this.adShowSelect = vz8Var.adShowSelect;
            this.adSampleMapKey = vz8Var.adSampleMapKey;
            rr6.f().n(getAnti());
            rr6.f().q(vz8Var.getForum().getId());
            rr6.f().r(vz8Var.getForum().getName());
            qr6.h().q(vz8Var.getForum().getId());
            if (vz8Var.getEntelechyTabInfo() != null) {
                qr6.h().r(vz8Var.getEntelechyTabInfo().a);
            }
            if (vz8Var.getUserData() != null) {
                sr6.c().e(vz8Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(vz8Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(vz8Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = vz8Var.smartAppAvatar;
            this.smartApp = vz8Var.smartApp;
            this.nebulaHotThreads = vz8Var.nebulaHotThreads;
            this.forumActiveInfo = vz8Var.forumActiveInfo;
            this.userList = vz8Var.userList;
            setBusinessPromot(vz8Var.getBusinessPromot());
            this.serviceAreaData = vz8Var.serviceAreaData;
            setHotUserRankData(vz8Var.getHotUserRankData());
            this.itemInfo = vz8Var.itemInfo;
            this.toLoadHorseData = vz8Var.toLoadHorseData;
            this.forumRule = vz8Var.forumRule;
            this.mSignActivityInfo = vz8Var.mSignActivityInfo;
            this.showAdsense = vz8Var.showAdsense;
            setVoiceRoomConfig(vz8Var.getVoiceRoomConfig());
            setVoiceRoomData(vz8Var.getVoiceRoomData());
            this.serviceAreaFlutterData = vz8Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = vz8Var.liveFuseForumDataList;
            this.frsGameRankInfoData = vz8Var.frsGameRankInfoData;
            this.frsBannerHeaderData = vz8Var.frsBannerHeaderData;
            this.forumTagInfo = vz8Var.forumTagInfo;
            this.firstCategory = vz8Var.firstCategory;
            this.frsForumGroup = vz8Var.frsForumGroup;
            return true;
        }
        return invokeL.booleanValue;
    }
}
