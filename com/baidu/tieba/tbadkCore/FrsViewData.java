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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
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
import com.baidu.tieba.ava;
import com.baidu.tieba.b16;
import com.baidu.tieba.bva;
import com.baidu.tieba.dva;
import com.baidu.tieba.fva;
import com.baidu.tieba.gva;
import com.baidu.tieba.gy4;
import com.baidu.tieba.hn6;
import com.baidu.tieba.hva;
import com.baidu.tieba.iva;
import com.baidu.tieba.jy4;
import com.baidu.tieba.kbb;
import com.baidu.tieba.mz4;
import com.baidu.tieba.p98;
import com.baidu.tieba.pi;
import com.baidu.tieba.qbb;
import com.baidu.tieba.rd;
import com.baidu.tieba.t06;
import com.baidu.tieba.ts7;
import com.baidu.tieba.w88;
import com.baidu.tieba.wr7;
import com.baidu.tieba.wua;
import com.baidu.tieba.xr7;
import com.baidu.tieba.xua;
import com.baidu.tieba.yn5;
import com.baidu.tieba.yr7;
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
public class FrsViewData extends dva implements yn5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public w88 funAdController;
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

    @Override // com.baidu.tieba.dva
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

    public List<pi> getTopThreadList() {
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
            removeTopSameClassDataFromList(wua.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            removeTopSameClassDataFromList(xua.class, getThreadList());
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

    public void addRecommendAppToThreadList(t06 t06Var, ArrayList<pi> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, t06Var, arrayList) == null) {
            addRecommendAppToThreadList(t06Var, false, arrayList, null, false);
        }
    }

    private List<pi> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        jy4 jy4Var;
        ArrayList<pi> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<pi> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (jy4Var = this.page) != null && jy4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    pi piVar = this.threadList.get(i);
                    if (piVar instanceof mz4) {
                        if (((mz4) piVar).t.isHeadLinePost) {
                            arrayList2.add(piVar);
                        }
                    } else if ((piVar instanceof ThreadData) && ((ThreadData) piVar).isHeadLinePost) {
                        arrayList2.add(piVar);
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
            pi piVar = this.threadList.get(i2);
            if (piVar instanceof mz4) {
                ThreadData threadData = ((mz4) piVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            bva bvaVar = new bva();
            bvaVar.d(this.forum.getId());
            bvaVar.c(feedForumList);
            this.threadList.add(i + 6, bvaVar);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        hn6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    pi piVar = this.threadList.get(i2);
                    if (piVar instanceof mz4) {
                        ThreadData threadData = ((mz4) piVar).t;
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
        pi piVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (piVar = this.threadList.get(0)) != null && (piVar instanceof mz4) && ((ThreadData) piVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            mz4 mz4Var = new mz4();
            mz4Var.t = threadData;
            this.threadList.add(0, mz4Var);
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || getForum() == null) {
            return;
        }
        List<pi> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<pi> threadList = getThreadList();
        if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
            int size = cardShipinPos.size();
            int size2 = threadList.size();
            for (int i = 0; i < size; i++) {
                if (i < cardShipinNew.size()) {
                    pi piVar = cardShipinNew.get(i);
                    int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                    Log.e(PbActivityConfig.VALUE_FROM_FRS, "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + piVar.getType());
                    threadList.add(videoThreadInserPos, piVar);
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

    public void addRecommendAppToThreadList(t06 t06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t06Var) == null) {
            addRecommendAppToThreadList(t06Var, false, this.threadList, null, false);
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

    public void setFunAdController(w88 w88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, w88Var) == null) {
            this.funAdController = w88Var;
        }
    }

    public void setTopThreadList(List<pi> list) {
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<pi> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, this, cls, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                pi piVar = arrayList.get(i);
                if (piVar.getClass() == cls) {
                    arrayList2.add(piVar);
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
            Log.e(PbActivityConfig.VALUE_FROM_FRS, "addCardVideoInfoToThreadList cardVideoInfo:" + cardVideoInfo.getTid());
            ArrayList<pi> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addHeaderCardToThreadList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            kbb kbbVar = new kbb();
            kbbVar.f(this.headerCard);
            if (qbb.p(kbbVar, true)) {
                qbb qbbVar = new qbb();
                qbbVar.n(2);
                ForumData forumData = this.forum;
                if (forumData != null) {
                    qbbVar.k(forumData.getId());
                    qbbVar.l(this.forum.getName());
                }
                qbbVar.h(kbbVar);
                if (ListUtils.add(this.threadList, qbbVar.getPosition(), qbbVar)) {
                    qbbVar.position = qbbVar.getPosition();
                }
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        xua frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<pi> threadList = getThreadList();
            removeTopSameClassDataFromList(xua.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<pi> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                pi next = it.next();
                if (next != null && next.getType() == iva.c) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<pi> arrayList;
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
            pi piVar = this.threadList.get(i2);
            if (piVar instanceof mz4) {
                ThreadData threadData = ((mz4) piVar).t;
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
        wua frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<pi> threadList = getThreadList();
            removeTopSameClassDataFromList(wua.class, threadList);
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
            ts7 userRecommend = getUserRecommend();
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
            ArrayList<pi> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<pi> it = this.threadList.iterator();
                while (it.hasNext()) {
                    pi next = it.next();
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
            fva entelechyTabInfo = getEntelechyTabInfo();
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
            Iterator<pi> it = this.threadList.iterator();
            while (it.hasNext()) {
                pi next = it.next();
                if (next != null && next.getType() == p98.e) {
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
        Iterator<pi> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof ts7) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(gy4 gy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, gy4Var) == null) && gy4Var != null && !StringUtils.isNull(gy4Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<pi> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    pi piVar = threadList.get(i);
                    if ((piVar instanceof mz4) && gy4Var.getId().equals(((mz4) piVar).t.getId()) && gy4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            gy4Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, gy4Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<pi> it = this.threadList.iterator();
            while (it.hasNext()) {
                pi next = it.next();
                if (next != null && (next instanceof mz4)) {
                    mz4 mz4Var = (mz4) next;
                    if (mz4Var.t.getAuthor() != null && currentAccount.equals(mz4Var.t.getAuthor().getUserId()) && mz4Var.t.getAuthor().getPendantData() != null) {
                        mz4Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        mz4Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(t06 t06Var, boolean z, ArrayList<pi> arrayList, ArrayList<pi> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{t06Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                b16 b16Var = new b16(t06Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                b16Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, b16Var));
                b16 b16Var2 = new b16(t06Var, 3);
                b16Var2.z(z);
                b16Var2.G(arrayList);
                b16Var2.D(arrayList2);
                b16Var2.y(z2);
                b16Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    b16Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    b16Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, b16Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<pi> arrayList;
        jy4 jy4Var;
        ArrayList<pi> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (jy4Var = this.page) != null && jy4Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                pi piVar = this.threadList.get(i2);
                if (piVar instanceof mz4) {
                    mz4 mz4Var = (mz4) piVar;
                    if (mz4Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && mz4Var.t.getThreadAlaInfo() != null && mz4Var.t.getThreadAlaInfo().user_info != null && mz4Var.t.getThreadAlaInfo().user_info.is_official == 2 && mz4Var.t.getThreadAlaInfo().liveStageForceTop) {
                        i = i2;
                        break;
                    }
                } else {
                    if (piVar instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) piVar;
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
                    pi piVar2 = this.threadList.get(i3);
                    if (piVar2 instanceof mz4) {
                        if (((mz4) piVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((piVar2 instanceof ThreadData) && ((ThreadData) piVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
            List<pi> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!ListUtils.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    public void filterEnterList(List<ava> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, list) == null) && list != null && list.size() != 0) {
            Iterator<ava> it = list.iterator();
            while (it.hasNext()) {
                ava next = it.next();
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

    public List<pi> getShowTopThreadList() {
        InterceptResult invokeV;
        List<ava> list;
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
                arrayList.add(new hva(forum, this.forumRule));
            }
            if (forum != null && !rd.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new gva(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new gva(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<pi> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    pi piVar = (pi) ListUtils.getItem(topThreadList, i4);
                    if (piVar instanceof mz4) {
                        mz4 mz4Var = (mz4) piVar;
                        arrayList.add(mz4Var.t);
                        if (mz4Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (piVar instanceof ThreadData) {
                            arrayList.add(piVar);
                            if (((ThreadData) piVar).getIsMemberTop() != 1 || z) {
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
            ArrayList<pi> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<pi> it = arrayList.iterator();
            while (it.hasNext()) {
                pi next = it.next();
                if (next != null && (next instanceof mz4)) {
                    mz4 mz4Var = (mz4) next;
                    if (TextUtils.equals(str, mz4Var.t.getId())) {
                        return mz4Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public void removeThread(String str) {
        ArrayList<pi> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<pi> it = arrayList.iterator();
        while (it.hasNext()) {
            pi next = it.next();
            if (next != null && (next instanceof mz4) && TextUtils.equals(str, ((mz4) next).t.getId())) {
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

    public boolean receiveData(dva dvaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, dvaVar)) == null) {
            if (dvaVar == null) {
                return false;
            }
            this.isFromCache = dvaVar.isFromCache;
            setBaWuNoticeNum(dvaVar.getBaWuNoticeNum());
            setSortType(dvaVar.getSortType());
            setAnti(dvaVar.getAnti());
            setChatGroup(dvaVar.getChatGroup());
            setFortuneBag(dvaVar.isFortuneBag());
            setFortuneDesc(dvaVar.getFortuneDesc());
            setForum(dvaVar.getForum());
            setGameName(dvaVar.getGameName());
            setGameUrl(dvaVar.getGameUrl());
            setGconAccount(dvaVar.getGconAccount());
            setHasGame(dvaVar.isHasGame());
            setIsNewUrl(dvaVar.getIsNewUrl());
            setPhotoLivePos(dvaVar.getPhotoLivePos());
            setPage(dvaVar.getPage());
            setStar(dvaVar.getStar());
            setStarEnter(dvaVar.getStarEnter());
            setThreadList(dvaVar.threadList);
            setThreadListIds(dvaVar.getThreadListIds());
            setUserData(dvaVar.getUserData());
            setUserMap(dvaVar.getUserMap());
            setActivityHeadData(dvaVar.getActivityHeadData());
            setFrsDefaultTabId(dvaVar.getFrsDefaultTabId());
            this.defaultShowTab = dvaVar.defaultShowTab;
            setCategoryInfos(dvaVar.getCategoryInfos());
            setBawuCenterUrl(dvaVar.getBawuCenterUrl());
            setCardVideoInfo(dvaVar.getCardVideoInfo());
            setHeadSdkData(dvaVar.getHeadSdkData());
            setSchoolRecommendPos(dvaVar.getSchoolRecommendPos());
            setSchoolRecommendInfo(dvaVar.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(dvaVar.getEntelechyTabInfo());
            setAlaLiveCount(dvaVar.getAlaLiveCount());
            setCarrierEnterData(dvaVar.getCarrierEnterData());
            setForumState(dvaVar.getForumState());
            setAccessFlag(dvaVar.getAccessFlag());
            this.needLog = dvaVar.needLog;
            this.recommendBookData = dvaVar.recommendBookData;
            this.presentInfoData = dvaVar.presentInfoData;
            setBookInfo(dvaVar.getBookInfo());
            setMangaReadRecordChapterId(dvaVar.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(dvaVar.getHeadlineImgInfoData());
            setCardShipinPos(dvaVar.getCardShipinPos());
            setCardShipinNew(dvaVar.getCardShipinNew());
            this.enterFrsDialogInfo = dvaVar.enterFrsDialogInfo;
            setGameRankListData(dvaVar.getGameRankListData());
            setAgreeBanner(dvaVar.getAgreeBanner());
            setLiveNotify(dvaVar.getLiveNotify());
            setGameTabInfo(dvaVar.getGameTabInfo());
            setGameDefaultTabId(dvaVar.getGameDefaultTabId());
            setForumHeadIcon(dvaVar.getForumHeadIcon());
            setUserRecommend(dvaVar.getUserRecommend());
            setFrsVideoActivityData(dvaVar.getFrsVideoActivityData());
            setFrsInsertLiveData(dvaVar.getFrsInsertLiveData());
            this.recm_forum_list = dvaVar.getRecm_forum_list();
            setFrsStageLiveData(dvaVar.getFrsStageLiveData());
            this.forumArIno = dvaVar.forumArIno;
            this.starRank = dvaVar.starRank;
            this.postTopic = dvaVar.postTopic;
            this.mWindowToast = dvaVar.mWindowToast;
            this.activityConfig = dvaVar.activityConfig;
            setIsShowRedTip(dvaVar.isShowRedTip());
            this.isBrandForum = dvaVar.isBrandForum;
            this.brandAdData = dvaVar.brandAdData;
            this.oriForumInfoList = dvaVar.oriForumInfoList;
            this.bottomMenuList = dvaVar.bottomMenuList;
            this.adMixFloor = dvaVar.adMixFloor;
            this.adShowSelect = dvaVar.adShowSelect;
            this.adSampleMapKey = dvaVar.adSampleMapKey;
            xr7.f().n(getAnti());
            xr7.f().q(dvaVar.getForum().getId());
            xr7.f().r(dvaVar.getForum().getName());
            wr7.h().q(dvaVar.getForum().getId());
            if (dvaVar.getEntelechyTabInfo() != null) {
                wr7.h().r(dvaVar.getEntelechyTabInfo().a);
            }
            if (dvaVar.getUserData() != null) {
                yr7.c().e(dvaVar.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(dvaVar.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(dvaVar.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = dvaVar.smartAppAvatar;
            this.smartApp = dvaVar.smartApp;
            this.nebulaHotThreads = dvaVar.nebulaHotThreads;
            this.forumActiveInfo = dvaVar.forumActiveInfo;
            this.userList = dvaVar.userList;
            setBusinessPromot(dvaVar.getBusinessPromot());
            this.serviceAreaData = dvaVar.serviceAreaData;
            setHotUserRankData(dvaVar.getHotUserRankData());
            this.itemInfo = dvaVar.itemInfo;
            this.toLoadHorseData = dvaVar.toLoadHorseData;
            this.forumRule = dvaVar.forumRule;
            this.mSignActivityInfo = dvaVar.mSignActivityInfo;
            this.showAdsense = dvaVar.showAdsense;
            setVoiceRoomConfig(dvaVar.getVoiceRoomConfig());
            setVoiceRoomData(dvaVar.getVoiceRoomData());
            this.serviceAreaFlutterData = dvaVar.serviceAreaFlutterData;
            this.liveFuseForumDataList = dvaVar.liveFuseForumDataList;
            this.frsGameRankInfoData = dvaVar.frsGameRankInfoData;
            this.frsBannerHeaderData = dvaVar.frsBannerHeaderData;
            this.forumTagInfo = dvaVar.forumTagInfo;
            this.firstCategory = dvaVar.firstCategory;
            this.frsForumGroup = dvaVar.frsForumGroup;
            this.headerCard = dvaVar.headerCard;
            this.frsSpriteNewUserGuide = dvaVar.frsSpriteNewUserGuide;
            this.bountyTaskData = dvaVar.bountyTaskData;
            return true;
        }
        return invokeL.booleanValue;
    }
}
