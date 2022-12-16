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
import com.baidu.tieba.a66;
import com.baidu.tieba.ar8;
import com.baidu.tieba.cr8;
import com.baidu.tieba.cy6;
import com.baidu.tieba.dr8;
import com.baidu.tieba.eq5;
import com.baidu.tieba.er8;
import com.baidu.tieba.fr8;
import com.baidu.tieba.lr8;
import com.baidu.tieba.my6;
import com.baidu.tieba.nd5;
import com.baidu.tieba.pk6;
import com.baidu.tieba.ry4;
import com.baidu.tieba.sj6;
import com.baidu.tieba.st4;
import com.baidu.tieba.tj6;
import com.baidu.tieba.tq8;
import com.baidu.tieba.uj6;
import com.baidu.tieba.uq8;
import com.baidu.tieba.vt4;
import com.baidu.tieba.wp5;
import com.baidu.tieba.xg;
import com.baidu.tieba.xi;
import com.baidu.tieba.xn;
import com.baidu.tieba.xq8;
import com.baidu.tieba.yq8;
import com.baidu.tieba.yu4;
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
public class FrsViewData extends ar8 implements nd5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public cy6 funAdController;
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

    @Override // com.baidu.tieba.ar8
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
            removeTopSameClassDataFromList(tq8.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            removeTopSameClassDataFromList(uq8.class, getThreadList());
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

    public void addRecommendAppToThreadList(wp5 wp5Var, ArrayList<xn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wp5Var, arrayList) == null) {
            addRecommendAppToThreadList(wp5Var, false, arrayList, null, false);
        }
    }

    private List<xn> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        vt4 vt4Var;
        ArrayList<xn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<xn> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (vt4Var = this.page) != null && vt4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    xn xnVar = this.threadList.get(i);
                    if (xnVar instanceof yu4) {
                        if (((yu4) xnVar).t.isHeadLinePost) {
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
            if (xnVar instanceof yu4) {
                ThreadData threadData = ((yu4) xnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            yq8 yq8Var = new yq8();
            yq8Var.f(this.forum.getId());
            yq8Var.c(feedForumList);
            this.threadList.add(i + 6, yq8Var);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        a66 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    xn xnVar = this.threadList.get(i2);
                    if (xnVar instanceof yu4) {
                        ThreadData threadData = ((yu4) xnVar).t;
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
            while (!this.threadList.isEmpty() && (xnVar = this.threadList.get(0)) != null && (xnVar instanceof yu4) && ((ThreadData) xnVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            yu4 yu4Var = new yu4();
            yu4Var.t = threadData;
            this.threadList.add(0, yu4Var);
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

    public void addRecommendAppToThreadList(wp5 wp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, wp5Var) == null) {
            addRecommendAppToThreadList(wp5Var, false, this.threadList, null, false);
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

    public void setFunAdController(cy6 cy6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, cy6Var) == null) {
            this.funAdController = cy6Var;
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
        uq8 frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<xn> threadList = getThreadList();
            removeTopSameClassDataFromList(uq8.class, threadList);
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
                if (next != null && next.getType() == fr8.c) {
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
            if (xnVar instanceof yu4) {
                ThreadData threadData = ((yu4) xnVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String r = ry4.l().r("game_rank_list_info", "");
        if (!StringUtils.isNull(r) && r.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(xg.g(r.split(",")[0], 0L), System.currentTimeMillis()) < xg.e(r.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int m = ry4.l().m("game_rank_list_show_times", 0);
                    if (!z) {
                        m++;
                    }
                    ry4.l().x("game_rank_list_show_times", m);
                    if (m > 3) {
                        ry4 l = ry4.l();
                        l.z("game_rank_list_info", System.currentTimeMillis() + ",1");
                        ry4.l().x("game_rank_list_show_times", 0);
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
        tq8 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<xn> threadList = getThreadList();
            removeTopSameClassDataFromList(tq8.class, threadList);
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
            pk6 userRecommend = getUserRecommend();
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
            cr8 entelechyTabInfo = getEntelechyTabInfo();
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
                if (next != null && next.getType() == my6.e) {
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
            if (it.next() instanceof pk6) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(st4 st4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, st4Var) == null) && st4Var != null && !StringUtils.isNull(st4Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<xn> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    xn xnVar = threadList.get(i);
                    if ((xnVar instanceof yu4) && st4Var.getId().equals(((yu4) xnVar).t.getId()) && st4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            st4Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, st4Var);
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
                if (next != null && (next instanceof yu4)) {
                    yu4 yu4Var = (yu4) next;
                    if (yu4Var.t.getAuthor() != null && currentAccount.equals(yu4Var.t.getAuthor().getUserId()) && yu4Var.t.getAuthor().getPendantData() != null) {
                        yu4Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        yu4Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(wp5 wp5Var, boolean z, ArrayList<xn> arrayList, ArrayList<xn> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{wp5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                eq5 eq5Var = new eq5(wp5Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                eq5Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, eq5Var));
                eq5 eq5Var2 = new eq5(wp5Var, 3);
                eq5Var2.z(z);
                eq5Var2.G(arrayList);
                eq5Var2.D(arrayList2);
                eq5Var2.y(z2);
                eq5Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    eq5Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    eq5Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, eq5Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<xn> arrayList;
        vt4 vt4Var;
        ArrayList<xn> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (vt4Var = this.page) != null && vt4Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                xn xnVar = this.threadList.get(i2);
                if (xnVar instanceof yu4) {
                    yu4 yu4Var = (yu4) xnVar;
                    if (yu4Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && yu4Var.t.getThreadAlaInfo() != null && yu4Var.t.getThreadAlaInfo().user_info != null && yu4Var.t.getThreadAlaInfo().user_info.is_official == 2 && yu4Var.t.getThreadAlaInfo().liveStageForceTop) {
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
                    if (xnVar2 instanceof yu4) {
                        if (((yu4) xnVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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

    public void filterEnterList(List<xq8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, list) == null) && list != null && list.size() != 0) {
            Iterator<xq8> it = list.iterator();
            while (it.hasNext()) {
                xq8 next = it.next();
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

    public List<xn> getShowTopThreadList() {
        InterceptResult invokeV;
        List<xq8> list;
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
                arrayList.add(new er8(forum, this.forumRule));
            }
            if (forum != null && !xi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new dr8(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new dr8(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<xn> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    xn xnVar = (xn) ListUtils.getItem(topThreadList, i4);
                    if (xnVar instanceof yu4) {
                        yu4 yu4Var = (yu4) xnVar;
                        arrayList.add(yu4Var.t);
                        if (yu4Var.t.getIsMemberTop() != 1 || z) {
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
                if (next != null && (next instanceof yu4)) {
                    yu4 yu4Var = (yu4) next;
                    if (TextUtils.equals(str, yu4Var.t.getId())) {
                        return yu4Var.t;
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
            if (next != null && (next instanceof yu4) && TextUtils.equals(str, ((yu4) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(lr8 lr8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, lr8Var) != null) || lr8Var == null) {
            return;
        }
        this.forum.setCurScore(lr8Var.c());
        this.forum.setLevelupScore(lr8Var.i());
        this.forum.setLike(lr8Var.m());
        this.forum.setUser_level(lr8Var.l());
        this.forum.setLevelName(lr8Var.h());
    }

    public boolean receiveData(ar8 ar8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, ar8Var)) == null) {
            if (ar8Var == null) {
                return false;
            }
            this.isFromCache = ar8Var.isFromCache;
            setBaWuNoticeNum(ar8Var.getBaWuNoticeNum());
            setSortType(ar8Var.getSortType());
            setAnti(ar8Var.getAnti());
            setChatGroup(ar8Var.getChatGroup());
            setFortuneBag(ar8Var.isFortuneBag());
            setFortuneDesc(ar8Var.getFortuneDesc());
            setForum(ar8Var.getForum());
            setGameName(ar8Var.getGameName());
            setGameUrl(ar8Var.getGameUrl());
            setGconAccount(ar8Var.getGconAccount());
            setHasGame(ar8Var.isHasGame());
            setIsNewUrl(ar8Var.getIsNewUrl());
            setPhotoLivePos(ar8Var.getPhotoLivePos());
            setPage(ar8Var.getPage());
            setStar(ar8Var.getStar());
            setStarEnter(ar8Var.getStarEnter());
            setThreadList(ar8Var.threadList);
            setThreadListIds(ar8Var.getThreadListIds());
            setUserData(ar8Var.getUserData());
            setUserMap(ar8Var.getUserMap());
            setActivityHeadData(ar8Var.getActivityHeadData());
            setFrsDefaultTabId(ar8Var.getFrsDefaultTabId());
            this.defaultShowTab = ar8Var.defaultShowTab;
            setCategoryInfos(ar8Var.getCategoryInfos());
            setBawuCenterUrl(ar8Var.getBawuCenterUrl());
            setCardVideoInfo(ar8Var.getCardVideoInfo());
            setHeadSdkData(ar8Var.getHeadSdkData());
            setSchoolRecommendPos(ar8Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(ar8Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(ar8Var.getEntelechyTabInfo());
            setAlaLiveCount(ar8Var.getAlaLiveCount());
            setCarrierEnterData(ar8Var.getCarrierEnterData());
            setForumState(ar8Var.getForumState());
            setAccessFlag(ar8Var.getAccessFlag());
            this.needLog = ar8Var.needLog;
            this.recommendBookData = ar8Var.recommendBookData;
            this.presentInfoData = ar8Var.presentInfoData;
            setBookInfo(ar8Var.getBookInfo());
            setMangaReadRecordChapterId(ar8Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(ar8Var.getHeadlineImgInfoData());
            setCardShipinPos(ar8Var.getCardShipinPos());
            setCardShipinNew(ar8Var.getCardShipinNew());
            this.enterFrsDialogInfo = ar8Var.enterFrsDialogInfo;
            setGameRankListData(ar8Var.getGameRankListData());
            setAgreeBanner(ar8Var.getAgreeBanner());
            setLiveNotify(ar8Var.getLiveNotify());
            setGameTabInfo(ar8Var.getGameTabInfo());
            setGameDefaultTabId(ar8Var.getGameDefaultTabId());
            setForumHeadIcon(ar8Var.getForumHeadIcon());
            setUserRecommend(ar8Var.getUserRecommend());
            setFrsVideoActivityData(ar8Var.getFrsVideoActivityData());
            this.mNewChapterInfo = ar8Var.mNewChapterInfo;
            setFrsInsertLiveData(ar8Var.getFrsInsertLiveData());
            this.recm_forum_list = ar8Var.getRecm_forum_list();
            setFrsStageLiveData(ar8Var.getFrsStageLiveData());
            this.forumArIno = ar8Var.forumArIno;
            this.starRank = ar8Var.starRank;
            this.postTopic = ar8Var.postTopic;
            this.mWindowToast = ar8Var.mWindowToast;
            this.activityConfig = ar8Var.activityConfig;
            setIsShowRedTip(ar8Var.isShowRedTip());
            this.isBrandForum = ar8Var.isBrandForum;
            this.brandAdData = ar8Var.brandAdData;
            this.oriForumInfoList = ar8Var.oriForumInfoList;
            this.bottomMenuList = ar8Var.bottomMenuList;
            this.adMixFloor = ar8Var.adMixFloor;
            this.adShowSelect = ar8Var.adShowSelect;
            this.adSampleMapKey = ar8Var.adSampleMapKey;
            tj6.f().n(getAnti());
            tj6.f().q(ar8Var.getForum().getId());
            tj6.f().r(ar8Var.getForum().getName());
            sj6.h().q(ar8Var.getForum().getId());
            if (ar8Var.getEntelechyTabInfo() != null) {
                sj6.h().r(ar8Var.getEntelechyTabInfo().a);
            }
            if (ar8Var.getUserData() != null) {
                uj6.c().e(ar8Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(ar8Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(ar8Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = ar8Var.smartAppAvatar;
            this.smartApp = ar8Var.smartApp;
            this.nebulaHotThreads = ar8Var.nebulaHotThreads;
            this.forumActiveInfo = ar8Var.forumActiveInfo;
            this.userList = ar8Var.userList;
            setBusinessPromot(ar8Var.getBusinessPromot());
            this.serviceAreaData = ar8Var.serviceAreaData;
            setHotUserRankData(ar8Var.getHotUserRankData());
            this.itemInfo = ar8Var.itemInfo;
            this.toLoadHorseData = ar8Var.toLoadHorseData;
            this.forumRule = ar8Var.forumRule;
            this.mSignActivityInfo = ar8Var.mSignActivityInfo;
            this.showAdsense = ar8Var.showAdsense;
            setVoiceRoomConfig(ar8Var.getVoiceRoomConfig());
            setVoiceRoomData(ar8Var.getVoiceRoomData());
            this.serviceAreaFlutterData = ar8Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = ar8Var.liveFuseForumDataList;
            this.frsGameRankInfoData = ar8Var.frsGameRankInfoData;
            this.forumTagInfo = ar8Var.forumTagInfo;
            this.firstCategory = ar8Var.firstCategory;
            return true;
        }
        return invokeL.booleanValue;
    }
}
