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
import com.baidu.tieba.bva;
import com.baidu.tieba.cva;
import com.baidu.tieba.dn6;
import com.baidu.tieba.dy4;
import com.baidu.tieba.eva;
import com.baidu.tieba.gva;
import com.baidu.tieba.gy4;
import com.baidu.tieba.hva;
import com.baidu.tieba.iva;
import com.baidu.tieba.jva;
import com.baidu.tieba.jz4;
import com.baidu.tieba.l98;
import com.baidu.tieba.lbb;
import com.baidu.tieba.p06;
import com.baidu.tieba.pi;
import com.baidu.tieba.ps7;
import com.baidu.tieba.rbb;
import com.baidu.tieba.rd;
import com.baidu.tieba.s88;
import com.baidu.tieba.sr7;
import com.baidu.tieba.tr7;
import com.baidu.tieba.un5;
import com.baidu.tieba.ur7;
import com.baidu.tieba.x06;
import com.baidu.tieba.xua;
import com.baidu.tieba.yua;
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
public class FrsViewData extends eva implements un5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public s88 funAdController;
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

    @Override // com.baidu.tieba.eva
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
            removeTopSameClassDataFromList(xua.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            removeTopSameClassDataFromList(yua.class, getThreadList());
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

    public void addRecommendAppToThreadList(p06 p06Var, ArrayList<pi> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, p06Var, arrayList) == null) {
            addRecommendAppToThreadList(p06Var, false, arrayList, null, false);
        }
    }

    private List<pi> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        gy4 gy4Var;
        ArrayList<pi> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<pi> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (gy4Var = this.page) != null && gy4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    pi piVar = this.threadList.get(i);
                    if (piVar instanceof jz4) {
                        if (((jz4) piVar).t.isHeadLinePost) {
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
            if (piVar instanceof jz4) {
                ThreadData threadData = ((jz4) piVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            cva cvaVar = new cva();
            cvaVar.d(this.forum.getId());
            cvaVar.c(feedForumList);
            this.threadList.add(i + 6, cvaVar);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        dn6 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    pi piVar = this.threadList.get(i2);
                    if (piVar instanceof jz4) {
                        ThreadData threadData = ((jz4) piVar).t;
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
            while (!this.threadList.isEmpty() && (piVar = this.threadList.get(0)) != null && (piVar instanceof jz4) && ((ThreadData) piVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            jz4 jz4Var = new jz4();
            jz4Var.t = threadData;
            this.threadList.add(0, jz4Var);
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

    public void addRecommendAppToThreadList(p06 p06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, p06Var) == null) {
            addRecommendAppToThreadList(p06Var, false, this.threadList, null, false);
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

    public void setFunAdController(s88 s88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, s88Var) == null) {
            this.funAdController = s88Var;
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
            lbb lbbVar = new lbb();
            lbbVar.f(this.headerCard);
            if (rbb.p(lbbVar, true)) {
                rbb rbbVar = new rbb();
                rbbVar.n(2);
                ForumData forumData = this.forum;
                if (forumData != null) {
                    rbbVar.k(forumData.getId());
                    rbbVar.l(this.forum.getName());
                }
                rbbVar.h(lbbVar);
                if (ListUtils.add(this.threadList, rbbVar.getPosition(), rbbVar)) {
                    rbbVar.position = rbbVar.getPosition();
                }
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        yua frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<pi> threadList = getThreadList();
            removeTopSameClassDataFromList(yua.class, threadList);
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
                if (next != null && next.getType() == jva.c) {
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
            if (piVar instanceof jz4) {
                ThreadData threadData = ((jz4) piVar).t;
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
        xua frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<pi> threadList = getThreadList();
            removeTopSameClassDataFromList(xua.class, threadList);
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
            ps7 userRecommend = getUserRecommend();
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
            gva entelechyTabInfo = getEntelechyTabInfo();
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
                if (next != null && next.getType() == l98.e) {
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
            if (it.next() instanceof ps7) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void addMyNewThread(dy4 dy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, dy4Var) == null) && dy4Var != null && !StringUtils.isNull(dy4Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<pi> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    pi piVar = threadList.get(i);
                    if ((piVar instanceof jz4) && dy4Var.getId().equals(((jz4) piVar).t.getId()) && dy4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            dy4Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, dy4Var);
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
                if (next != null && (next instanceof jz4)) {
                    jz4 jz4Var = (jz4) next;
                    if (jz4Var.t.getAuthor() != null && currentAccount.equals(jz4Var.t.getAuthor().getUserId()) && jz4Var.t.getAuthor().getPendantData() != null) {
                        jz4Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        jz4Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(p06 p06Var, boolean z, ArrayList<pi> arrayList, ArrayList<pi> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{p06Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                x06 x06Var = new x06(p06Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                x06Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, x06Var));
                x06 x06Var2 = new x06(p06Var, 3);
                x06Var2.z(z);
                x06Var2.G(arrayList);
                x06Var2.D(arrayList2);
                x06Var2.y(z2);
                x06Var2.t(getPage().a());
                int i = this.frsCurrentTabId;
                if (i == 1) {
                    x06Var2.x("frs_hot_tab");
                } else if (i == 503) {
                    x06Var2.x("frs_new_tab");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, x06Var2));
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<pi> arrayList;
        gy4 gy4Var;
        ArrayList<pi> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (gy4Var = this.page) != null && gy4Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                pi piVar = this.threadList.get(i2);
                if (piVar instanceof jz4) {
                    jz4 jz4Var = (jz4) piVar;
                    if (jz4Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && jz4Var.t.getThreadAlaInfo() != null && jz4Var.t.getThreadAlaInfo().user_info != null && jz4Var.t.getThreadAlaInfo().user_info.is_official == 2 && jz4Var.t.getThreadAlaInfo().liveStageForceTop) {
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
                    if (piVar2 instanceof jz4) {
                        if (((jz4) piVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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

    public void filterEnterList(List<bva> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, list) == null) && list != null && list.size() != 0) {
            Iterator<bva> it = list.iterator();
            while (it.hasNext()) {
                bva next = it.next();
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
        List<bva> list;
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
                arrayList.add(new iva(forum, this.forumRule));
            }
            if (forum != null && !rd.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new hva(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new hva(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<pi> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    pi piVar = (pi) ListUtils.getItem(topThreadList, i4);
                    if (piVar instanceof jz4) {
                        jz4 jz4Var = (jz4) piVar;
                        arrayList.add(jz4Var.t);
                        if (jz4Var.t.getIsMemberTop() != 1 || z) {
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
                if (next != null && (next instanceof jz4)) {
                    jz4 jz4Var = (jz4) next;
                    if (TextUtils.equals(str, jz4Var.t.getId())) {
                        return jz4Var.t;
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
            if (next != null && (next instanceof jz4) && TextUtils.equals(str, ((jz4) next).t.getId())) {
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

    public boolean receiveData(eva evaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, evaVar)) == null) {
            if (evaVar == null) {
                return false;
            }
            this.isFromCache = evaVar.isFromCache;
            setBaWuNoticeNum(evaVar.getBaWuNoticeNum());
            setSortType(evaVar.getSortType());
            setAnti(evaVar.getAnti());
            setChatGroup(evaVar.getChatGroup());
            setFortuneBag(evaVar.isFortuneBag());
            setFortuneDesc(evaVar.getFortuneDesc());
            setForum(evaVar.getForum());
            setGameName(evaVar.getGameName());
            setGameUrl(evaVar.getGameUrl());
            setGconAccount(evaVar.getGconAccount());
            setHasGame(evaVar.isHasGame());
            setIsNewUrl(evaVar.getIsNewUrl());
            setPhotoLivePos(evaVar.getPhotoLivePos());
            setPage(evaVar.getPage());
            setStar(evaVar.getStar());
            setStarEnter(evaVar.getStarEnter());
            setThreadList(evaVar.threadList);
            setThreadListIds(evaVar.getThreadListIds());
            setUserData(evaVar.getUserData());
            setUserMap(evaVar.getUserMap());
            setActivityHeadData(evaVar.getActivityHeadData());
            setFrsDefaultTabId(evaVar.getFrsDefaultTabId());
            this.defaultShowTab = evaVar.defaultShowTab;
            setCategoryInfos(evaVar.getCategoryInfos());
            setBawuCenterUrl(evaVar.getBawuCenterUrl());
            setCardVideoInfo(evaVar.getCardVideoInfo());
            setHeadSdkData(evaVar.getHeadSdkData());
            setSchoolRecommendPos(evaVar.getSchoolRecommendPos());
            setSchoolRecommendInfo(evaVar.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(evaVar.getEntelechyTabInfo());
            setAlaLiveCount(evaVar.getAlaLiveCount());
            setCarrierEnterData(evaVar.getCarrierEnterData());
            setForumState(evaVar.getForumState());
            setAccessFlag(evaVar.getAccessFlag());
            this.needLog = evaVar.needLog;
            this.recommendBookData = evaVar.recommendBookData;
            this.presentInfoData = evaVar.presentInfoData;
            setBookInfo(evaVar.getBookInfo());
            setMangaReadRecordChapterId(evaVar.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(evaVar.getHeadlineImgInfoData());
            setCardShipinPos(evaVar.getCardShipinPos());
            setCardShipinNew(evaVar.getCardShipinNew());
            this.enterFrsDialogInfo = evaVar.enterFrsDialogInfo;
            setGameRankListData(evaVar.getGameRankListData());
            setAgreeBanner(evaVar.getAgreeBanner());
            setLiveNotify(evaVar.getLiveNotify());
            setGameTabInfo(evaVar.getGameTabInfo());
            setGameDefaultTabId(evaVar.getGameDefaultTabId());
            setForumHeadIcon(evaVar.getForumHeadIcon());
            setUserRecommend(evaVar.getUserRecommend());
            setFrsVideoActivityData(evaVar.getFrsVideoActivityData());
            setFrsInsertLiveData(evaVar.getFrsInsertLiveData());
            this.recm_forum_list = evaVar.getRecm_forum_list();
            setFrsStageLiveData(evaVar.getFrsStageLiveData());
            this.forumArIno = evaVar.forumArIno;
            this.starRank = evaVar.starRank;
            this.postTopic = evaVar.postTopic;
            this.mWindowToast = evaVar.mWindowToast;
            this.activityConfig = evaVar.activityConfig;
            setIsShowRedTip(evaVar.isShowRedTip());
            this.isBrandForum = evaVar.isBrandForum;
            this.brandAdData = evaVar.brandAdData;
            this.oriForumInfoList = evaVar.oriForumInfoList;
            this.bottomMenuList = evaVar.bottomMenuList;
            this.adMixFloor = evaVar.adMixFloor;
            this.adShowSelect = evaVar.adShowSelect;
            this.adSampleMapKey = evaVar.adSampleMapKey;
            tr7.f().n(getAnti());
            tr7.f().q(evaVar.getForum().getId());
            tr7.f().r(evaVar.getForum().getName());
            sr7.h().q(evaVar.getForum().getId());
            if (evaVar.getEntelechyTabInfo() != null) {
                sr7.h().r(evaVar.getEntelechyTabInfo().a);
            }
            if (evaVar.getUserData() != null) {
                ur7.c().e(evaVar.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(evaVar.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(evaVar.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = evaVar.smartAppAvatar;
            this.smartApp = evaVar.smartApp;
            this.nebulaHotThreads = evaVar.nebulaHotThreads;
            this.forumActiveInfo = evaVar.forumActiveInfo;
            this.userList = evaVar.userList;
            setBusinessPromot(evaVar.getBusinessPromot());
            this.serviceAreaData = evaVar.serviceAreaData;
            setHotUserRankData(evaVar.getHotUserRankData());
            this.itemInfo = evaVar.itemInfo;
            this.toLoadHorseData = evaVar.toLoadHorseData;
            this.forumRule = evaVar.forumRule;
            this.mSignActivityInfo = evaVar.mSignActivityInfo;
            this.showAdsense = evaVar.showAdsense;
            setVoiceRoomConfig(evaVar.getVoiceRoomConfig());
            setVoiceRoomData(evaVar.getVoiceRoomData());
            this.serviceAreaFlutterData = evaVar.serviceAreaFlutterData;
            this.liveFuseForumDataList = evaVar.liveFuseForumDataList;
            this.frsGameRankInfoData = evaVar.frsGameRankInfoData;
            this.frsBannerHeaderData = evaVar.frsBannerHeaderData;
            this.forumTagInfo = evaVar.forumTagInfo;
            this.firstCategory = evaVar.firstCategory;
            this.frsForumGroup = evaVar.frsForumGroup;
            this.headerCard = evaVar.headerCard;
            this.frsSpriteNewUserGuide = evaVar.frsSpriteNewUserGuide;
            this.bountyTaskData = evaVar.bountyTaskData;
            return true;
        }
        return invokeL.booleanValue;
    }
}
