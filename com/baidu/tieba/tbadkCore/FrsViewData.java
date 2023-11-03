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
import com.baidu.tieba.by4;
import com.baidu.tieba.cq7;
import com.baidu.tieba.dqa;
import com.baidu.tieba.eqa;
import com.baidu.tieba.ey4;
import com.baidu.tieba.fp7;
import com.baidu.tieba.gp7;
import com.baidu.tieba.h06;
import com.baidu.tieba.hp7;
import com.baidu.tieba.hqa;
import com.baidu.tieba.hz4;
import com.baidu.tieba.iqa;
import com.baidu.tieba.kqa;
import com.baidu.tieba.ln5;
import com.baidu.tieba.mqa;
import com.baidu.tieba.nqa;
import com.baidu.tieba.o6b;
import com.baidu.tieba.oi;
import com.baidu.tieba.oqa;
import com.baidu.tieba.p06;
import com.baidu.tieba.pqa;
import com.baidu.tieba.q68;
import com.baidu.tieba.qd;
import com.baidu.tieba.rm6;
import com.baidu.tieba.u6b;
import com.baidu.tieba.x58;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.FrsPage.NebulaHotThreads;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.SmartApp;
import tbclient.User;
/* loaded from: classes8.dex */
public class FrsViewData extends kqa implements ln5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public x58 funAdController;
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

    @Override // com.baidu.tieba.kqa
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

    public List<oi> getTopThreadList() {
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
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            removeTopSameClassDataFromList(dqa.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            removeTopSameClassDataFromList(eqa.class, getThreadList());
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

    public void addRecommendAppToThreadList(h06 h06Var, ArrayList<oi> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, h06Var, arrayList) == null) {
            addRecommendAppToThreadList(h06Var, false, arrayList, null, false);
        }
    }

    private List<oi> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        ey4 ey4Var;
        ArrayList<oi> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<oi> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (ey4Var = this.page) != null && ey4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    oi oiVar = this.threadList.get(i);
                    if (oiVar instanceof hz4) {
                        if (((hz4) oiVar).t.isHeadLinePost) {
                            arrayList2.add(oiVar);
                        }
                    } else if ((oiVar instanceof ThreadData) && ((ThreadData) oiVar).isHeadLinePost) {
                        arrayList2.add(oiVar);
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
            oi oiVar = this.threadList.get(i2);
            if (oiVar instanceof hz4) {
                ThreadData threadData = ((hz4) oiVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            iqa iqaVar = new iqa();
            iqaVar.d(this.forum.getId());
            iqaVar.c(feedForumList);
            this.threadList.add(i + 6, iqaVar);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        rm6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    oi oiVar = this.threadList.get(i2);
                    if (oiVar instanceof hz4) {
                        ThreadData threadData = ((hz4) oiVar).t;
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
        oi oiVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (oiVar = this.threadList.get(0)) != null && (oiVar instanceof hz4) && ((ThreadData) oiVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            hz4 hz4Var = new hz4();
            hz4Var.t = threadData;
            this.threadList.add(0, hz4Var);
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || getForum() == null) {
            return;
        }
        List<oi> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<oi> threadList = getThreadList();
        if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
            int size = cardShipinPos.size();
            int size2 = threadList.size();
            for (int i = 0; i < size; i++) {
                if (i < cardShipinNew.size()) {
                    oi oiVar = cardShipinNew.get(i);
                    int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                    Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + oiVar.getType());
                    threadList.add(videoThreadInserPos, oiVar);
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

    public void addRecommendAppToThreadList(h06 h06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, h06Var) == null) {
            addRecommendAppToThreadList(h06Var, false, this.threadList, null, false);
        }
    }

    public void parserData(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, dataRes) == null) {
            super.parserProtobuf(dataRes);
            this.userList = super.userList;
            this.forumActiveInfo = super.forumActiveInfo;
        }
    }

    public void removeThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, threadData) == null) {
            this.threadList.remove(threadData);
        }
    }

    public void setFrsFragmentTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bdUniqueId) == null) {
            this.frsFragmentTag = bdUniqueId;
        }
    }

    public void setFunAdController(x58 x58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, x58Var) == null) {
            this.funAdController = x58Var;
        }
    }

    public void setTopThreadList(List<oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, list) == null) {
            this.topThreadList = list;
        }
    }

    public void updateLoadMoreBannerListData(BannerListData bannerListData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, bannerListData) == null) {
            this.isLoadMore = true;
            this.loadMoreBannerListData = bannerListData;
        }
    }

    public void updateSignData(SignData signData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048624, this, signData) != null) || signData == null) {
            return;
        }
        this.forum.setSignData(signData);
    }

    private void removeTopSameClassDataFromList(Class cls, ArrayList<oi> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, cls, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                oi oiVar = arrayList.get(i);
                if (oiVar.getClass() == cls) {
                    arrayList2.add(oiVar);
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
            ArrayList<oi> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addHeaderCardToThreadList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            o6b o6bVar = new o6b();
            o6bVar.f(this.headerCard);
            if (u6b.p(o6bVar, true)) {
                u6b u6bVar = new u6b();
                u6bVar.n(2);
                ForumData forumData = this.forum;
                if (forumData != null) {
                    u6bVar.i(forumData.getId());
                    u6bVar.l(this.forum.getName());
                }
                u6bVar.h(o6bVar);
                if (ListUtils.add(this.threadList, u6bVar.getPosition(), u6bVar)) {
                    u6bVar.position = u6bVar.getPosition();
                }
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        eqa frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<oi> threadList = getThreadList();
            removeTopSameClassDataFromList(eqa.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<oi> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                oi next = it.next();
                if (next != null && next.getType() == pqa.c) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<oi> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0) {
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
            oi oiVar = this.threadList.get(i2);
            if (oiVar instanceof hz4) {
                ThreadData threadData = ((hz4) oiVar).t;
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
        dqa frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<oi> threadList = getThreadList();
            removeTopSameClassDataFromList(dqa.class, threadList);
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
            cq7 userRecommend = getUserRecommend();
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
            ArrayList<oi> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<oi> it = this.threadList.iterator();
                while (it.hasNext()) {
                    oi next = it.next();
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
            mqa entelechyTabInfo = getEntelechyTabInfo();
            if (entelechyTabInfo == null || (list = entelechyTabInfo.a) == null || list.size() <= 0 || (frsTabInfo = list.get(0)) == null || frsTabInfo.tab_id.intValue() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void removeGameRankListFromThreadList() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && !ListUtils.isEmpty(this.threadList)) {
            Iterator<oi> it = this.threadList.iterator();
            while (it.hasNext()) {
                oi next = it.next();
                if (next != null && next.getType() == q68.e) {
                    it.remove();
                }
            }
        }
    }

    public void removeRedundantUserRecommendData() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048615, this) != null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        boolean z = false;
        Iterator<oi> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof cq7) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(by4 by4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, by4Var) == null) && by4Var != null && !StringUtils.isNull(by4Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<oi> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    oi oiVar = threadList.get(i);
                    if ((oiVar instanceof hz4) && by4Var.getId().equals(((hz4) oiVar).t.getId()) && by4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            by4Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, by4Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<oi> it = this.threadList.iterator();
            while (it.hasNext()) {
                oi next = it.next();
                if (next != null && (next instanceof hz4)) {
                    hz4 hz4Var = (hz4) next;
                    if (hz4Var.t.getAuthor() != null && currentAccount.equals(hz4Var.t.getAuthor().getUserId()) && hz4Var.t.getAuthor().getPendantData() != null) {
                        hz4Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        hz4Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(h06 h06Var, boolean z, ArrayList<oi> arrayList, ArrayList<oi> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{h06Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                p06 p06Var = new p06(h06Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                p06Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, p06Var));
                p06 p06Var2 = new p06(h06Var, 3);
                p06Var2.z(z);
                p06Var2.G(arrayList);
                p06Var2.D(arrayList2);
                p06Var2.y(z2);
                p06Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    p06Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    p06Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, p06Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<oi> arrayList;
        ey4 ey4Var;
        ArrayList<oi> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (ey4Var = this.page) != null && ey4Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                oi oiVar = this.threadList.get(i2);
                if (oiVar instanceof hz4) {
                    hz4 hz4Var = (hz4) oiVar;
                    if (hz4Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && hz4Var.t.getThreadAlaInfo() != null && hz4Var.t.getThreadAlaInfo().user_info != null && hz4Var.t.getThreadAlaInfo().user_info.is_official == 2 && hz4Var.t.getThreadAlaInfo().liveStageForceTop) {
                        i = i2;
                        break;
                    }
                } else {
                    if (oiVar instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) oiVar;
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
                    oi oiVar2 = this.threadList.get(i3);
                    if (oiVar2 instanceof hz4) {
                        if (((hz4) oiVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((oiVar2 instanceof ThreadData) && ((ThreadData) oiVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
            List<oi> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!ListUtils.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    public void filterEnterList(List<hqa> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, list) == null) && list != null && list.size() != 0) {
            Iterator<hqa> it = list.iterator();
            while (it.hasNext()) {
                hqa next = it.next();
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

    public List<oi> getShowTopThreadList() {
        InterceptResult invokeV;
        List<hqa> list;
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
                arrayList.add(new oqa(forum, this.forumRule));
            }
            if (forum != null && !qd.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new nqa(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new nqa(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<oi> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    oi oiVar = (oi) ListUtils.getItem(topThreadList, i4);
                    if (oiVar instanceof hz4) {
                        hz4 hz4Var = (hz4) oiVar;
                        arrayList.add(hz4Var.t);
                        if (hz4Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (oiVar instanceof ThreadData) {
                            arrayList.add(oiVar);
                            if (((ThreadData) oiVar).getIsMemberTop() != 1 || z) {
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
            ArrayList<oi> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<oi> it = arrayList.iterator();
            while (it.hasNext()) {
                oi next = it.next();
                if (next != null && (next instanceof hz4)) {
                    hz4 hz4Var = (hz4) next;
                    if (TextUtils.equals(str, hz4Var.t.getId())) {
                        return hz4Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public void removeThread(String str) {
        ArrayList<oi> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<oi> it = arrayList.iterator();
        while (it.hasNext()) {
            oi next = it.next();
            if (next != null && (next instanceof hz4) && TextUtils.equals(str, ((hz4) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(LikeReturnData likeReturnData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048622, this, likeReturnData) != null) || likeReturnData == null) {
            return;
        }
        this.forum.setCurScore(likeReturnData.getCurScore());
        this.forum.setLevelupScore(likeReturnData.getLevelupScore());
        this.forum.setLike(likeReturnData.isLike());
        this.forum.setUser_level(likeReturnData.getUserLevel());
        this.forum.setLevelName(likeReturnData.getLevelName());
    }

    public boolean receiveData(kqa kqaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, kqaVar)) == null) {
            if (kqaVar == null) {
                return false;
            }
            this.isFromCache = kqaVar.isFromCache;
            setBaWuNoticeNum(kqaVar.getBaWuNoticeNum());
            setSortType(kqaVar.getSortType());
            setAnti(kqaVar.getAnti());
            setChatGroup(kqaVar.getChatGroup());
            setFortuneBag(kqaVar.isFortuneBag());
            setFortuneDesc(kqaVar.getFortuneDesc());
            setForum(kqaVar.getForum());
            setGameName(kqaVar.getGameName());
            setGameUrl(kqaVar.getGameUrl());
            setGconAccount(kqaVar.getGconAccount());
            setHasGame(kqaVar.isHasGame());
            setIsNewUrl(kqaVar.getIsNewUrl());
            setPhotoLivePos(kqaVar.getPhotoLivePos());
            setPage(kqaVar.getPage());
            setStar(kqaVar.getStar());
            setStarEnter(kqaVar.getStarEnter());
            setThreadList(kqaVar.threadList);
            setThreadListIds(kqaVar.getThreadListIds());
            setUserData(kqaVar.getUserData());
            setUserMap(kqaVar.getUserMap());
            setActivityHeadData(kqaVar.getActivityHeadData());
            setFrsDefaultTabId(kqaVar.getFrsDefaultTabId());
            this.defaultShowTab = kqaVar.defaultShowTab;
            setCategoryInfos(kqaVar.getCategoryInfos());
            setBawuCenterUrl(kqaVar.getBawuCenterUrl());
            setCardVideoInfo(kqaVar.getCardVideoInfo());
            setHeadSdkData(kqaVar.getHeadSdkData());
            setSchoolRecommendPos(kqaVar.getSchoolRecommendPos());
            setSchoolRecommendInfo(kqaVar.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(kqaVar.getEntelechyTabInfo());
            setAlaLiveCount(kqaVar.getAlaLiveCount());
            setCarrierEnterData(kqaVar.getCarrierEnterData());
            setForumState(kqaVar.getForumState());
            setAccessFlag(kqaVar.getAccessFlag());
            this.needLog = kqaVar.needLog;
            this.recommendBookData = kqaVar.recommendBookData;
            this.presentInfoData = kqaVar.presentInfoData;
            setBookInfo(kqaVar.getBookInfo());
            setMangaReadRecordChapterId(kqaVar.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(kqaVar.getHeadlineImgInfoData());
            setCardShipinPos(kqaVar.getCardShipinPos());
            setCardShipinNew(kqaVar.getCardShipinNew());
            this.enterFrsDialogInfo = kqaVar.enterFrsDialogInfo;
            setGameRankListData(kqaVar.getGameRankListData());
            setAgreeBanner(kqaVar.getAgreeBanner());
            setLiveNotify(kqaVar.getLiveNotify());
            setGameTabInfo(kqaVar.getGameTabInfo());
            setGameDefaultTabId(kqaVar.getGameDefaultTabId());
            setForumHeadIcon(kqaVar.getForumHeadIcon());
            setUserRecommend(kqaVar.getUserRecommend());
            setFrsVideoActivityData(kqaVar.getFrsVideoActivityData());
            setFrsInsertLiveData(kqaVar.getFrsInsertLiveData());
            this.recm_forum_list = kqaVar.getRecm_forum_list();
            setFrsStageLiveData(kqaVar.getFrsStageLiveData());
            this.forumArIno = kqaVar.forumArIno;
            this.starRank = kqaVar.starRank;
            this.postTopic = kqaVar.postTopic;
            this.mWindowToast = kqaVar.mWindowToast;
            this.activityConfig = kqaVar.activityConfig;
            setIsShowRedTip(kqaVar.isShowRedTip());
            this.isBrandForum = kqaVar.isBrandForum;
            this.brandAdData = kqaVar.brandAdData;
            this.oriForumInfoList = kqaVar.oriForumInfoList;
            this.bottomMenuList = kqaVar.bottomMenuList;
            this.adMixFloor = kqaVar.adMixFloor;
            this.adShowSelect = kqaVar.adShowSelect;
            this.adSampleMapKey = kqaVar.adSampleMapKey;
            gp7.f().n(getAnti());
            gp7.f().q(kqaVar.getForum().getId());
            gp7.f().r(kqaVar.getForum().getName());
            fp7.h().q(kqaVar.getForum().getId());
            if (kqaVar.getEntelechyTabInfo() != null) {
                fp7.h().r(kqaVar.getEntelechyTabInfo().a);
            }
            if (kqaVar.getUserData() != null) {
                hp7.c().e(kqaVar.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(kqaVar.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(kqaVar.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = kqaVar.smartAppAvatar;
            this.smartApp = kqaVar.smartApp;
            this.nebulaHotThreads = kqaVar.nebulaHotThreads;
            this.forumActiveInfo = kqaVar.forumActiveInfo;
            this.userList = kqaVar.userList;
            setBusinessPromot(kqaVar.getBusinessPromot());
            this.serviceAreaData = kqaVar.serviceAreaData;
            setHotUserRankData(kqaVar.getHotUserRankData());
            this.itemInfo = kqaVar.itemInfo;
            this.toLoadHorseData = kqaVar.toLoadHorseData;
            this.forumRule = kqaVar.forumRule;
            this.mSignActivityInfo = kqaVar.mSignActivityInfo;
            this.showAdsense = kqaVar.showAdsense;
            setVoiceRoomConfig(kqaVar.getVoiceRoomConfig());
            setVoiceRoomData(kqaVar.getVoiceRoomData());
            this.serviceAreaFlutterData = kqaVar.serviceAreaFlutterData;
            this.liveFuseForumDataList = kqaVar.liveFuseForumDataList;
            this.frsGameRankInfoData = kqaVar.frsGameRankInfoData;
            this.frsBannerHeaderData = kqaVar.frsBannerHeaderData;
            this.forumTagInfo = kqaVar.forumTagInfo;
            this.firstCategory = kqaVar.firstCategory;
            this.frsForumGroup = kqaVar.frsForumGroup;
            this.headerCard = kqaVar.headerCard;
            this.frsSpriteNewUserGuide = kqaVar.frsSpriteNewUserGuide;
            this.bountyTaskData = kqaVar.bountyTaskData;
            return true;
        }
        return invokeL.booleanValue;
    }
}
