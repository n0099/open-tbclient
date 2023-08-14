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
import com.baidu.tieba.baa;
import com.baidu.tieba.bi;
import com.baidu.tieba.caa;
import com.baidu.tieba.cq5;
import com.baidu.tieba.dw7;
import com.baidu.tieba.faa;
import com.baidu.tieba.gaa;
import com.baidu.tieba.iaa;
import com.baidu.tieba.kaa;
import com.baidu.tieba.kv7;
import com.baidu.tieba.laa;
import com.baidu.tieba.maa;
import com.baidu.tieba.naa;
import com.baidu.tieba.q25;
import com.baidu.tieba.q26;
import com.baidu.tieba.t25;
import com.baidu.tieba.uf7;
import com.baidu.tieba.uqa;
import com.baidu.tieba.w35;
import com.baidu.tieba.wn6;
import com.baidu.tieba.xe7;
import com.baidu.tieba.xqa;
import com.baidu.tieba.y26;
import com.baidu.tieba.ye7;
import com.baidu.tieba.ym;
import com.baidu.tieba.ze7;
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
public class FrsViewData extends iaa implements cq5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public kv7 funAdController;
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

    @Override // com.baidu.tieba.iaa
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

    public List<ym> getTopThreadList() {
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
            removeTopSameClassDataFromList(baa.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            removeTopSameClassDataFromList(caa.class, getThreadList());
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

    public void addRecommendAppToThreadList(q26 q26Var, ArrayList<ym> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, q26Var, arrayList) == null) {
            addRecommendAppToThreadList(q26Var, false, arrayList, null, false);
        }
    }

    private List<ym> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        t25 t25Var;
        ArrayList<ym> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<ym> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (t25Var = this.page) != null && t25Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    ym ymVar = this.threadList.get(i);
                    if (ymVar instanceof w35) {
                        if (((w35) ymVar).t.isHeadLinePost) {
                            arrayList2.add(ymVar);
                        }
                    } else if ((ymVar instanceof ThreadData) && ((ThreadData) ymVar).isHeadLinePost) {
                        arrayList2.add(ymVar);
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
            ym ymVar = this.threadList.get(i2);
            if (ymVar instanceof w35) {
                ThreadData threadData = ((w35) ymVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            gaa gaaVar = new gaa();
            gaaVar.d(this.forum.getId());
            gaaVar.c(feedForumList);
            this.threadList.add(i + 6, gaaVar);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        wn6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    ym ymVar = this.threadList.get(i2);
                    if (ymVar instanceof w35) {
                        ThreadData threadData = ((w35) ymVar).t;
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
        ym ymVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (ymVar = this.threadList.get(0)) != null && (ymVar instanceof w35) && ((ThreadData) ymVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            w35 w35Var = new w35();
            w35Var.t = threadData;
            this.threadList.add(0, w35Var);
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || getForum() == null) {
            return;
        }
        List<ym> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<ym> threadList = getThreadList();
        if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
            int size = cardShipinPos.size();
            int size2 = threadList.size();
            for (int i = 0; i < size; i++) {
                if (i < cardShipinNew.size()) {
                    ym ymVar = cardShipinNew.get(i);
                    int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                    Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + ymVar.getType());
                    threadList.add(videoThreadInserPos, ymVar);
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

    public void addRecommendAppToThreadList(q26 q26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, q26Var) == null) {
            addRecommendAppToThreadList(q26Var, false, this.threadList, null, false);
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

    public void setFunAdController(kv7 kv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, kv7Var) == null) {
            this.funAdController = kv7Var;
        }
    }

    public void setTopThreadList(List<ym> list) {
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<ym> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, cls, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                ym ymVar = arrayList.get(i);
                if (ymVar.getClass() == cls) {
                    arrayList2.add(ymVar);
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
            ArrayList<ym> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addHeaderCardToThreadList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            uqa uqaVar = new uqa();
            uqaVar.e(this.headerCard);
            if (xqa.i(uqaVar, true)) {
                xqa xqaVar = new xqa();
                xqaVar.g(2);
                ForumData forumData = this.forum;
                if (forumData != null) {
                    xqaVar.e(forumData.getId());
                    xqaVar.f(this.forum.getName());
                }
                xqaVar.d(uqaVar);
                if (ListUtils.add(this.threadList, xqaVar.getPosition(), xqaVar)) {
                    xqaVar.position = xqaVar.getPosition();
                }
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        caa frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<ym> threadList = getThreadList();
            removeTopSameClassDataFromList(caa.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<ym> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ym next = it.next();
                if (next != null && next.getType() == naa.c) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<ym> arrayList;
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
            ym ymVar = this.threadList.get(i2);
            if (ymVar instanceof w35) {
                ThreadData threadData = ((w35) ymVar).t;
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
        baa frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<ym> threadList = getThreadList();
            removeTopSameClassDataFromList(baa.class, threadList);
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
            uf7 userRecommend = getUserRecommend();
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
            ArrayList<ym> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<ym> it = this.threadList.iterator();
                while (it.hasNext()) {
                    ym next = it.next();
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
            kaa entelechyTabInfo = getEntelechyTabInfo();
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
            Iterator<ym> it = this.threadList.iterator();
            while (it.hasNext()) {
                ym next = it.next();
                if (next != null && next.getType() == dw7.e) {
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
        Iterator<ym> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof uf7) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(q25 q25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, q25Var) == null) && q25Var != null && !StringUtils.isNull(q25Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<ym> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    ym ymVar = threadList.get(i);
                    if ((ymVar instanceof w35) && q25Var.getId().equals(((w35) ymVar).t.getId()) && q25Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            q25Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, q25Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<ym> it = this.threadList.iterator();
            while (it.hasNext()) {
                ym next = it.next();
                if (next != null && (next instanceof w35)) {
                    w35 w35Var = (w35) next;
                    if (w35Var.t.getAuthor() != null && currentAccount.equals(w35Var.t.getAuthor().getUserId()) && w35Var.t.getAuthor().getPendantData() != null) {
                        w35Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        w35Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(q26 q26Var, boolean z, ArrayList<ym> arrayList, ArrayList<ym> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{q26Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                y26 y26Var = new y26(q26Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                y26Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, y26Var));
                y26 y26Var2 = new y26(q26Var, 3);
                y26Var2.z(z);
                y26Var2.G(arrayList);
                y26Var2.D(arrayList2);
                y26Var2.y(z2);
                y26Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    y26Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    y26Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, y26Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<ym> arrayList;
        t25 t25Var;
        ArrayList<ym> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (t25Var = this.page) != null && t25Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ym ymVar = this.threadList.get(i2);
                if (ymVar instanceof w35) {
                    w35 w35Var = (w35) ymVar;
                    if (w35Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && w35Var.t.getThreadAlaInfo() != null && w35Var.t.getThreadAlaInfo().user_info != null && w35Var.t.getThreadAlaInfo().user_info.is_official == 2 && w35Var.t.getThreadAlaInfo().liveStageForceTop) {
                        i = i2;
                        break;
                    }
                } else {
                    if (ymVar instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) ymVar;
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
                    ym ymVar2 = this.threadList.get(i3);
                    if (ymVar2 instanceof w35) {
                        if (((w35) ymVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((ymVar2 instanceof ThreadData) && ((ThreadData) ymVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
            List<ym> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!ListUtils.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    public void filterEnterList(List<faa> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, list) == null) && list != null && list.size() != 0) {
            Iterator<faa> it = list.iterator();
            while (it.hasNext()) {
                faa next = it.next();
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

    public List<ym> getShowTopThreadList() {
        InterceptResult invokeV;
        List<faa> list;
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
                arrayList.add(new maa(forum, this.forumRule));
            }
            if (forum != null && !bi.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new laa(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new laa(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<ym> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    ym ymVar = (ym) ListUtils.getItem(topThreadList, i4);
                    if (ymVar instanceof w35) {
                        w35 w35Var = (w35) ymVar;
                        arrayList.add(w35Var.t);
                        if (w35Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (ymVar instanceof ThreadData) {
                            arrayList.add(ymVar);
                            if (((ThreadData) ymVar).getIsMemberTop() != 1 || z) {
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
            ArrayList<ym> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<ym> it = arrayList.iterator();
            while (it.hasNext()) {
                ym next = it.next();
                if (next != null && (next instanceof w35)) {
                    w35 w35Var = (w35) next;
                    if (TextUtils.equals(str, w35Var.t.getId())) {
                        return w35Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public void removeThread(String str) {
        ArrayList<ym> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048615, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<ym> it = arrayList.iterator();
        while (it.hasNext()) {
            ym next = it.next();
            if (next != null && (next instanceof w35) && TextUtils.equals(str, ((w35) next).t.getId())) {
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

    public boolean receiveData(iaa iaaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, iaaVar)) == null) {
            if (iaaVar == null) {
                return false;
            }
            this.isFromCache = iaaVar.isFromCache;
            setBaWuNoticeNum(iaaVar.getBaWuNoticeNum());
            setSortType(iaaVar.getSortType());
            setAnti(iaaVar.getAnti());
            setChatGroup(iaaVar.getChatGroup());
            setFortuneBag(iaaVar.isFortuneBag());
            setFortuneDesc(iaaVar.getFortuneDesc());
            setForum(iaaVar.getForum());
            setGameName(iaaVar.getGameName());
            setGameUrl(iaaVar.getGameUrl());
            setGconAccount(iaaVar.getGconAccount());
            setHasGame(iaaVar.isHasGame());
            setIsNewUrl(iaaVar.getIsNewUrl());
            setPhotoLivePos(iaaVar.getPhotoLivePos());
            setPage(iaaVar.getPage());
            setStar(iaaVar.getStar());
            setStarEnter(iaaVar.getStarEnter());
            setThreadList(iaaVar.threadList);
            setThreadListIds(iaaVar.getThreadListIds());
            setUserData(iaaVar.getUserData());
            setUserMap(iaaVar.getUserMap());
            setActivityHeadData(iaaVar.getActivityHeadData());
            setFrsDefaultTabId(iaaVar.getFrsDefaultTabId());
            this.defaultShowTab = iaaVar.defaultShowTab;
            setCategoryInfos(iaaVar.getCategoryInfos());
            setBawuCenterUrl(iaaVar.getBawuCenterUrl());
            setCardVideoInfo(iaaVar.getCardVideoInfo());
            setHeadSdkData(iaaVar.getHeadSdkData());
            setSchoolRecommendPos(iaaVar.getSchoolRecommendPos());
            setSchoolRecommendInfo(iaaVar.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(iaaVar.getEntelechyTabInfo());
            setAlaLiveCount(iaaVar.getAlaLiveCount());
            setCarrierEnterData(iaaVar.getCarrierEnterData());
            setForumState(iaaVar.getForumState());
            setAccessFlag(iaaVar.getAccessFlag());
            this.needLog = iaaVar.needLog;
            this.recommendBookData = iaaVar.recommendBookData;
            this.presentInfoData = iaaVar.presentInfoData;
            setBookInfo(iaaVar.getBookInfo());
            setMangaReadRecordChapterId(iaaVar.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(iaaVar.getHeadlineImgInfoData());
            setCardShipinPos(iaaVar.getCardShipinPos());
            setCardShipinNew(iaaVar.getCardShipinNew());
            this.enterFrsDialogInfo = iaaVar.enterFrsDialogInfo;
            setGameRankListData(iaaVar.getGameRankListData());
            setAgreeBanner(iaaVar.getAgreeBanner());
            setLiveNotify(iaaVar.getLiveNotify());
            setGameTabInfo(iaaVar.getGameTabInfo());
            setGameDefaultTabId(iaaVar.getGameDefaultTabId());
            setForumHeadIcon(iaaVar.getForumHeadIcon());
            setUserRecommend(iaaVar.getUserRecommend());
            setFrsVideoActivityData(iaaVar.getFrsVideoActivityData());
            this.mNewChapterInfo = iaaVar.mNewChapterInfo;
            setFrsInsertLiveData(iaaVar.getFrsInsertLiveData());
            this.recm_forum_list = iaaVar.getRecm_forum_list();
            setFrsStageLiveData(iaaVar.getFrsStageLiveData());
            this.forumArIno = iaaVar.forumArIno;
            this.starRank = iaaVar.starRank;
            this.postTopic = iaaVar.postTopic;
            this.mWindowToast = iaaVar.mWindowToast;
            this.activityConfig = iaaVar.activityConfig;
            setIsShowRedTip(iaaVar.isShowRedTip());
            this.isBrandForum = iaaVar.isBrandForum;
            this.brandAdData = iaaVar.brandAdData;
            this.oriForumInfoList = iaaVar.oriForumInfoList;
            this.bottomMenuList = iaaVar.bottomMenuList;
            this.adMixFloor = iaaVar.adMixFloor;
            this.adShowSelect = iaaVar.adShowSelect;
            this.adSampleMapKey = iaaVar.adSampleMapKey;
            ye7.f().n(getAnti());
            ye7.f().q(iaaVar.getForum().getId());
            ye7.f().r(iaaVar.getForum().getName());
            xe7.h().q(iaaVar.getForum().getId());
            if (iaaVar.getEntelechyTabInfo() != null) {
                xe7.h().r(iaaVar.getEntelechyTabInfo().a);
            }
            if (iaaVar.getUserData() != null) {
                ze7.c().e(iaaVar.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(iaaVar.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(iaaVar.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = iaaVar.smartAppAvatar;
            this.smartApp = iaaVar.smartApp;
            this.nebulaHotThreads = iaaVar.nebulaHotThreads;
            this.forumActiveInfo = iaaVar.forumActiveInfo;
            this.userList = iaaVar.userList;
            setBusinessPromot(iaaVar.getBusinessPromot());
            this.serviceAreaData = iaaVar.serviceAreaData;
            setHotUserRankData(iaaVar.getHotUserRankData());
            this.itemInfo = iaaVar.itemInfo;
            this.toLoadHorseData = iaaVar.toLoadHorseData;
            this.forumRule = iaaVar.forumRule;
            this.mSignActivityInfo = iaaVar.mSignActivityInfo;
            this.showAdsense = iaaVar.showAdsense;
            setVoiceRoomConfig(iaaVar.getVoiceRoomConfig());
            setVoiceRoomData(iaaVar.getVoiceRoomData());
            this.serviceAreaFlutterData = iaaVar.serviceAreaFlutterData;
            this.liveFuseForumDataList = iaaVar.liveFuseForumDataList;
            this.frsGameRankInfoData = iaaVar.frsGameRankInfoData;
            this.frsBannerHeaderData = iaaVar.frsBannerHeaderData;
            this.forumTagInfo = iaaVar.forumTagInfo;
            this.firstCategory = iaaVar.firstCategory;
            this.frsForumGroup = iaaVar.frsForumGroup;
            this.headerCard = iaaVar.headerCard;
            this.frsSpriteNewUserGuide = iaaVar.frsSpriteNewUserGuide;
            return true;
        }
        return invokeL.booleanValue;
    }
}
