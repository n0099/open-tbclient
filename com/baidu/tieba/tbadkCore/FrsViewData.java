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
import com.baidu.tbadk.core.data.RecommendForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.TopNoticeData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.ah6;
import com.baidu.tieba.am8;
import com.baidu.tieba.an8;
import com.baidu.tieba.bh6;
import com.baidu.tieba.bt4;
import com.baidu.tieba.ch6;
import com.baidu.tieba.dh6;
import com.baidu.tieba.dm8;
import com.baidu.tieba.du4;
import com.baidu.tieba.eh;
import com.baidu.tieba.ej;
import com.baidu.tieba.em8;
import com.baidu.tieba.eo;
import com.baidu.tieba.gm8;
import com.baidu.tieba.i36;
import com.baidu.tieba.im8;
import com.baidu.tieba.jm8;
import com.baidu.tieba.km8;
import com.baidu.tieba.kv6;
import com.baidu.tieba.lm8;
import com.baidu.tieba.mm8;
import com.baidu.tieba.ot4;
import com.baidu.tieba.pn5;
import com.baidu.tieba.rb5;
import com.baidu.tieba.rm8;
import com.baidu.tieba.tm8;
import com.baidu.tieba.uv6;
import com.baidu.tieba.ux4;
import com.baidu.tieba.wl8;
import com.baidu.tieba.xh6;
import com.baidu.tieba.xn5;
import com.baidu.tieba.ys4;
import com.baidu.tieba.zl8;
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
/* loaded from: classes5.dex */
public class FrsViewData extends gm8 implements rb5, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public BdUniqueId frsFragmentTag;
    public kv6 funAdController;
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
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.postThreadCount = 0;
        }
    }

    public dh6 getBrandAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.brandAdData;
        }
        return (dh6) invokeV.objValue;
    }

    public ForumActiveInfo getForumActiveInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.forumActiveInfo;
        }
        return (ForumActiveInfo) invokeV.objValue;
    }

    public BdUniqueId getFrsFragmentTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.frsFragmentTag;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean getIsBrandForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.isBrandForum;
        }
        return invokeV.booleanValue;
    }

    public int getPostThreadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.postThreadCount;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.gm8
    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.recm_forum_list;
        }
        return (List) invokeV.objValue;
    }

    public SignData getSignData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            ForumData forumData = this.forum;
            if (forumData == null) {
                return null;
            }
            return forumData.getSignData();
        }
        return (SignData) invokeV.objValue;
    }

    public List<eo> getTopThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.topThreadList;
        }
        return (List) invokeV.objValue;
    }

    public NebulaHotThreads getYouhuaHotThreads() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.nebulaHotThreads;
        }
        return (NebulaHotThreads) invokeV.objValue;
    }

    public boolean hasTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (getStar() == null || getStar().b() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void removeAlaInsertLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            removeTopSameClassDataFromList(zl8.class, getThreadList());
        }
    }

    public void removeAlaStageLiveDat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            removeTopSameClassDataFromList(am8.class, getThreadList());
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
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, this, i, i2)) == null) {
            return Math.min((getTopThreadSize() + i) - 1, i2);
        }
        return invokeII.intValue;
    }

    public void addRecommendAppToThreadList(pn5 pn5Var, ArrayList<eo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, pn5Var, arrayList) == null) {
            addRecommendAppToThreadList(pn5Var, false, arrayList, null, false);
        }
    }

    private List<eo> getHeadLineDataInThreadList() {
        InterceptResult invokeV;
        bt4 bt4Var;
        ArrayList<eo> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<eo> arrayList3 = this.threadList;
            if (arrayList3 != null && arrayList3.size() > 0 && (bt4Var = this.page) != null && bt4Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
                int size = this.threadList.size();
                for (int i = 0; i < size; i++) {
                    eo eoVar = this.threadList.get(i);
                    if (eoVar instanceof du4) {
                        if (((du4) eoVar).t.isHeadLinePost) {
                            arrayList2.add(eoVar);
                        }
                    } else if ((eoVar instanceof ThreadData) && ((ThreadData) eoVar).isHeadLinePost) {
                        arrayList2.add(eoVar);
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
            eo eoVar = this.threadList.get(i2);
            if (eoVar instanceof du4) {
                ThreadData threadData = ((du4) eoVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
            em8 em8Var = new em8();
            em8Var.f(this.forum.getId());
            em8Var.c(feedForumList);
            this.threadList.add(i + 6, em8Var);
        }
    }

    public boolean addHotTopicDataToThreadList() {
        InterceptResult invokeV;
        ForumData forumData;
        i36 recomTopicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    eo eoVar = this.threadList.get(i2);
                    if (eoVar instanceof du4) {
                        ThreadData threadData = ((du4) eoVar).t;
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
        eo eoVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (eoVar = this.threadList.get(0)) != null && (eoVar instanceof du4) && ((ThreadData) eoVar).getIs_top() == 2) {
                this.threadList.remove(0);
            }
            ThreadData threadData = new ThreadData();
            threadData.setTitle(top_notice_data.getTitle());
            threadData.setTid(top_notice_data.getTitle_link());
            threadData.setIs_top(2);
            threadData.parser_title();
            du4 du4Var = new du4();
            du4Var.t = threadData;
            this.threadList.add(0, du4Var);
        }
    }

    public void addOfficialBarToThreadList() {
        bt4 bt4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.forum != null && this.threadList != null && ThreadData.isFRSExtraLoaded.get() && (bt4Var = this.page) != null) {
            boolean z = true;
            if (bt4Var.a() == 1) {
                mm8 mm8Var = this.gconAccount;
                z = (mm8Var == null || !mm8Var.b()) ? false : false;
                if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                    while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof tm8)) {
                        this.threadList.remove(0);
                    }
                    tm8 tm8Var = new tm8();
                    tm8Var.j(this.fortuneBag);
                    tm8Var.l(this.fortuneDesc);
                    tm8Var.n(this.gconAccount);
                    tm8Var.setIs_top(1003);
                    ArrayList<eo> arrayList = this.threadList;
                    if (arrayList != null && arrayList.size() > 0) {
                        ListUtils.add(this.threadList, getTopThreadSize(), tm8Var);
                    }
                }
            }
        }
    }

    public void addRecommendBarsToThreadList() {
        ArrayList<eo> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.forum != null && (arrayList = this.threadList) != null && arrayList.size() > 0) {
            Iterator<eo> it = this.threadList.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof ot4) {
                    it.remove();
                }
            }
            bt4 bt4Var = this.page;
            if (bt4Var != null && bt4Var.a() == 1) {
                ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
                ot4 ot4Var = new ot4();
                if (recommendForumData != null) {
                    ot4Var.c().addAll(recommendForumData);
                }
                if (isShowRecommendBars(ot4Var.c())) {
                    int i = 0;
                    Iterator<eo> it2 = this.threadList.iterator();
                    while (it2.hasNext()) {
                        eo next = it2.next();
                        if ((next instanceof du4) && ((du4) next).t.isTop()) {
                            i++;
                        }
                    }
                    this.threadList.add(i + 1, ot4Var);
                }
            }
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || getForum() == null) {
            return;
        }
        List<eo> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<eo> threadList = getThreadList();
        if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
            int size = cardShipinPos.size();
            int size2 = threadList.size();
            for (int i = 0; i < size; i++) {
                if (i < cardShipinNew.size()) {
                    eo eoVar = cardShipinNew.get(i);
                    int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                    Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + eoVar.getType());
                    threadList.add(videoThreadInserPos, eoVar);
                }
            }
        }
    }

    private int getOperatorFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Iterator<eo> it = this.threadList.iterator();
            while (it.hasNext()) {
                eo next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    if (threadData.getIsLive() == 1) {
                        return threadData.getOperatorFlag();
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void addInsertLiveDataToThreadList() {
        zl8 frsInsertLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<eo> threadList = getThreadList();
            removeTopSameClassDataFromList(zl8.class, threadList);
            threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.b, threadList.size()), frsInsertLiveData);
        }
    }

    public void addSchoolRecommendToThreadList() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || MessageManager.getInstance().findTask(2003016) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && getUserRecommend() != null) {
            xh6 userRecommend = getUserRecommend();
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

    public int getMyNewThreadNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            ArrayList<eo> threadList = getThreadList();
            if (threadList == null || threadList.size() <= 0) {
                return 0;
            }
            int size = threadList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (threadList.get(i2) instanceof ys4) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public int getTopThreadSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ArrayList<eo> arrayList = this.threadList;
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<eo> it = this.threadList.iterator();
                while (it.hasNext()) {
                    eo next = it.next();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            im8 entelechyTabInfo = getEntelechyTabInfo();
            if (entelechyTabInfo == null || (list = entelechyTabInfo.a) == null || list.size() <= 0 || (frsTabInfo = list.get(0)) == null || frsTabInfo.tab_id.intValue() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void removeGameRankListFromThreadList() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && !ListUtils.isEmpty(this.threadList)) {
            Iterator<eo> it = this.threadList.iterator();
            while (it.hasNext()) {
                eo next = it.next();
                if (next != null && next.getType() == uv6.e) {
                    it.remove();
                }
            }
        }
    }

    public void removeRedundantUserRecommendData() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048619, this) != null) || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        boolean z = false;
        Iterator<eo> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof xh6) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    private int getPhotoliveCardInsertPos(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) {
            return Math.min((getTopThreadSize() + getPhotoLivePos()) - 1, i);
        }
        return invokeI.intValue;
    }

    public void addRecommendAppToThreadList(pn5 pn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pn5Var) == null) {
            addRecommendAppToThreadList(pn5Var, false, this.threadList, null, false);
        }
    }

    public void removeThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, threadData) == null) {
            this.threadList.remove(threadData);
        }
    }

    public void setFrsFragmentTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bdUniqueId) == null) {
            this.frsFragmentTag = bdUniqueId;
        }
    }

    public void setFunAdController(kv6 kv6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, kv6Var) == null) {
            this.funAdController = kv6Var;
        }
    }

    public void setTopThreadList(List<eo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, list) == null) {
            this.topThreadList = list;
        }
    }

    public void updateLoadMoreBannerListData(BannerListData bannerListData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, bannerListData) == null) {
            this.isLoadMore = true;
            this.loadMoreBannerListData = bannerListData;
        }
    }

    public void updateSignData(SignData signData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048629, this, signData) != null) || signData == null) {
            return;
        }
        this.forum.setSignData(signData);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isShowRecommendBars(ArrayList<RecommendForumData> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() < 2) {
                return false;
            }
            Iterator<RecommendForumData> it = arrayList.iterator();
            while (it.hasNext()) {
                RecommendForumData next = it.next();
                if (next == null || StringUtils.isNull(next.mForumName)) {
                    return false;
                }
                while (it.hasNext()) {
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public ThreadData getThreadDataById(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            ArrayList<eo> arrayList = this.threadList;
            if (arrayList == null) {
                return null;
            }
            Iterator<eo> it = arrayList.iterator();
            while (it.hasNext()) {
                eo next = it.next();
                if (next != null && (next instanceof du4)) {
                    du4 du4Var = (du4) next;
                    if (TextUtils.equals(str, du4Var.t.getId())) {
                        return du4Var.t;
                    }
                }
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }

    public void removeThread(String str) {
        ArrayList<eo> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, str) != null) || (arrayList = this.threadList) == null) {
            return;
        }
        Iterator<eo> it = arrayList.iterator();
        while (it.hasNext()) {
            eo next = it.next();
            if (next != null && (next instanceof du4) && TextUtils.equals(str, ((du4) next).t.getId())) {
                it.remove();
            }
        }
    }

    public void updateLikeData(rm8 rm8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048626, this, rm8Var) != null) || rm8Var == null) {
            return;
        }
        this.forum.setCurScore(rm8Var.c());
        this.forum.setLevelupScore(rm8Var.i());
        this.forum.setLike(rm8Var.m());
        this.forum.setUser_level(rm8Var.l());
        this.forum.setLevelName(rm8Var.h());
    }

    private void removeTopSameClassDataFromList(Class cls, ArrayList<eo> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65543, this, cls, arrayList) == null) && arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                eo eoVar = arrayList.get(i);
                if (eoVar.getClass() == cls) {
                    arrayList2.add(eoVar);
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
            ArrayList<eo> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addStageLiveDataToThreadList() {
        am8 frsStageLiveData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<eo> threadList = getThreadList();
            removeTopSameClassDataFromList(am8.class, threadList);
            if (!ListUtils.isEmpty(frsStageLiveData.a)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void addVideoActivityToTop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && getFrsVideoActivityData() != null && !ListUtils.isEmpty(this.threadList)) {
            Iterator<eo> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eo next = it.next();
                if (next != null && next.getType() == lm8.c) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public void removeAlaLiveThreadData() {
        ArrayList<eo> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0) {
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
            eo eoVar = this.threadList.get(i2);
            if (eoVar instanceof du4) {
                ThreadData threadData = ((du4) eoVar).t;
                if (threadData == null || (!threadData.isTop() && threadData.getIsLive() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String q = ux4.k().q("game_rank_list_info", "");
        if (!StringUtils.isNull(q) && q.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(eh.g(q.split(",")[0], 0L), System.currentTimeMillis()) < eh.e(q.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int l = ux4.k().l("game_rank_list_show_times", 0);
                    if (!z) {
                        l++;
                    }
                    ux4.k().w("game_rank_list_show_times", l);
                    if (l > 3) {
                        ux4 k = ux4.k();
                        k.y("game_rank_list_info", System.currentTimeMillis() + ",1");
                        ux4.k().w("game_rank_list_show_times", 0);
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

    public void addMyNewThread(ys4 ys4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, ys4Var) == null) && ys4Var != null && !StringUtils.isNull(ys4Var.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<eo> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    eo eoVar = threadList.get(i);
                    if ((eoVar instanceof du4) && ys4Var.getId().equals(((du4) eoVar).t.getId()) && ys4Var.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                        return;
                    }
                }
            }
            ys4Var.isFromBrandForum = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, ys4Var);
        }
    }

    public void updateCurrentUserPendant(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, userPendantData) == null) && this.threadList != null && userPendantData != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            Iterator<eo> it = this.threadList.iterator();
            while (it.hasNext()) {
                eo next = it.next();
                if (next != null && (next instanceof du4)) {
                    du4 du4Var = (du4) next;
                    if (du4Var.t.getAuthor() != null && currentAccount.equals(du4Var.t.getAuthor().getUserId()) && du4Var.t.getAuthor().getPendantData() != null) {
                        du4Var.t.getAuthor().getPendantData().setPropsId(userPendantData.getPropsId());
                        du4Var.t.getAuthor().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(pn5 pn5Var, boolean z, ArrayList<eo> arrayList, ArrayList<eo> arrayList2, boolean z2) {
        BannerListData bannerListData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{pn5Var, Boolean.valueOf(z), arrayList, arrayList2, Boolean.valueOf(z2)}) == null) {
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
                xn5 xn5Var = new xn5(pn5Var, 2);
                ArrayList arrayList3 = new ArrayList();
                Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    next.setFromFrs(true);
                    next.setSortType(getSortType());
                    arrayList3.add(next);
                }
                xn5Var.s(arrayList3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, xn5Var));
                xn5 xn5Var2 = new xn5(pn5Var, 3);
                xn5Var2.z(z);
                xn5Var2.G(arrayList);
                xn5Var2.D(arrayList2);
                xn5Var2.y(z2);
                xn5Var2.t(getPage().a());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, xn5Var2));
            }
        }
    }

    public void addU9DataToThreadList() {
        ForumData forumData;
        bt4 bt4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || (forumData = this.forum) == null) {
            return;
        }
        if (((forumData.getTopCode() != null && !StringUtils.isNull(this.forum.getTopCode().g())) || (this.forum.getNewsInfo() != null && !StringUtils.isNull(this.forum.getNewsInfo().l1()))) && (bt4Var = this.page) != null && bt4Var.a() == 1) {
            an8 an8Var = new an8();
            an8Var.l(this.forum.getTopCode());
            an8Var.n(this.forum.getNewsInfo());
            an8Var.setIs_top(3);
            an8Var.j(true);
            if (!ListUtils.isEmpty(this.threadList)) {
                Iterator<eo> it = this.threadList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    eo next = it.next();
                    if (next instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) next;
                        if (threadData.getIs_top() != 0) {
                            if (threadData.getIs_top() == 1003) {
                                an8Var.j(false);
                            }
                            i++;
                        }
                    }
                }
                this.threadList.add(i, an8Var);
            }
        }
    }

    public void checkLiveStageInThreadList() {
        ArrayList<eo> arrayList;
        bt4 bt4Var;
        ArrayList<eo> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (arrayList = this.threadList) != null && arrayList.size() > 0 && (bt4Var = this.page) != null && bt4Var.a() == 1 && (arrayList2 = this.threadList) != null && arrayList2.size() > 0) {
            int i = -1;
            int size = this.threadList.size();
            for (int i2 = 0; i2 < size; i2++) {
                eo eoVar = this.threadList.get(i2);
                if (eoVar instanceof du4) {
                    du4 du4Var = (du4) eoVar;
                    if (du4Var.t.getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && du4Var.t.getThreadAlaInfo() != null && ((ThreadData) eoVar).getThreadAlaInfo().user_info != null && du4Var.t.getThreadAlaInfo().user_info.is_official == 2 && du4Var.t.getThreadAlaInfo().liveStageForceTop) {
                        i = i2;
                        break;
                    }
                } else {
                    if (eoVar instanceof ThreadData) {
                        ThreadData threadData = (ThreadData) eoVar;
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
                    eo eoVar2 = this.threadList.get(i3);
                    if (eoVar2 instanceof du4) {
                        if (((du4) eoVar2).t.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((eoVar2 instanceof ThreadData) && ((ThreadData) eoVar2).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
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
            List<eo> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!ListUtils.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    public void filterEnterList(List<dm8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, list) == null) && list != null && list.size() != 0) {
            Iterator<dm8> it = list.iterator();
            while (it.hasNext()) {
                dm8 next = it.next();
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

    public List<eo> getShowTopThreadList() {
        InterceptResult invokeV;
        List<dm8> list;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
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
                arrayList.add(new km8(forum, this.forumRule));
            }
            if (forum != null && !ej.isEmpty(forum.getRiskTipNotice())) {
                arrayList.add(new jm8(forum, false));
            } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
                arrayList.add(new jm8(forum, true));
            }
            int i3 = 3 - i;
            int size = arrayList.size();
            List<eo> topThreadList = getTopThreadList();
            if (topThreadList != null) {
                boolean z = false;
                for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                    eo eoVar = (eo) ListUtils.getItem(topThreadList, i4);
                    if (eoVar instanceof du4) {
                        du4 du4Var = (du4) eoVar;
                        arrayList.add(du4Var.t);
                        if (du4Var.t.getIsMemberTop() != 1 || z) {
                            if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                                break;
                            }
                        }
                        i3++;
                        z = true;
                    } else {
                        if (eoVar instanceof ThreadData) {
                            arrayList.add(eoVar);
                            if (((ThreadData) eoVar).getIsMemberTop() != 1 || z) {
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

    public boolean receiveData(gm8 gm8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, gm8Var)) == null) {
            if (gm8Var == null) {
                return false;
            }
            this.isFromCache = gm8Var.isFromCache;
            setBaWuNoticeNum(gm8Var.getBaWuNoticeNum());
            setSortType(gm8Var.getSortType());
            setAnti(gm8Var.getAnti());
            setChatGroup(gm8Var.getChatGroup());
            setFortuneBag(gm8Var.isFortuneBag());
            setFortuneDesc(gm8Var.getFortuneDesc());
            setForum(gm8Var.getForum());
            setGameName(gm8Var.getGameName());
            setGameUrl(gm8Var.getGameUrl());
            setGconAccount(gm8Var.getGconAccount());
            setHasGame(gm8Var.isHasGame());
            setIsNewUrl(gm8Var.getIsNewUrl());
            setPhotoLivePos(gm8Var.getPhotoLivePos());
            setPage(gm8Var.getPage());
            setStar(gm8Var.getStar());
            setStarEnter(gm8Var.getStarEnter());
            setThreadList(gm8Var.threadList);
            setThreadListIds(gm8Var.getThreadListIds());
            setUserData(gm8Var.getUserData());
            setUserMap(gm8Var.getUserMap());
            setActivityHeadData(gm8Var.getActivityHeadData());
            setFrsDefaultTabId(gm8Var.getFrsDefaultTabId());
            this.defaultShowTab = gm8Var.defaultShowTab;
            setCategoryInfos(gm8Var.getCategoryInfos());
            setBawuCenterUrl(gm8Var.getBawuCenterUrl());
            setCardVideoInfo(gm8Var.getCardVideoInfo());
            setHeadSdkData(gm8Var.getHeadSdkData());
            setSchoolRecommendPos(gm8Var.getSchoolRecommendPos());
            setSchoolRecommendInfo(gm8Var.getSchoolRecommendUserInfo());
            setEntelechyTabInfo(gm8Var.getEntelechyTabInfo());
            setAlaLiveCount(gm8Var.getAlaLiveCount());
            setCarrierEnterData(gm8Var.getCarrierEnterData());
            setForumState(gm8Var.getForumState());
            setAccessFlag(gm8Var.getAccessFlag());
            this.needLog = gm8Var.needLog;
            this.recommendBookData = gm8Var.recommendBookData;
            this.presentInfoData = gm8Var.presentInfoData;
            setBookInfo(gm8Var.getBookInfo());
            setMangaReadRecordChapterId(gm8Var.getMangaReadRecordChapterId());
            setHeadlineImgInfoData(gm8Var.getHeadlineImgInfoData());
            setCardShipinPos(gm8Var.getCardShipinPos());
            setCardShipinNew(gm8Var.getCardShipinNew());
            this.enterFrsDialogInfo = gm8Var.enterFrsDialogInfo;
            setGameRankListData(gm8Var.getGameRankListData());
            setAgreeBanner(gm8Var.getAgreeBanner());
            setLiveNotify(gm8Var.getLiveNotify());
            setGameTabInfo(gm8Var.getGameTabInfo());
            setGameDefaultTabId(gm8Var.getGameDefaultTabId());
            setForumHeadIcon(gm8Var.getForumHeadIcon());
            setUserRecommend(gm8Var.getUserRecommend());
            setFrsVideoActivityData(gm8Var.getFrsVideoActivityData());
            this.mNewChapterInfo = gm8Var.mNewChapterInfo;
            setFrsInsertLiveData(gm8Var.getFrsInsertLiveData());
            this.recm_forum_list = gm8Var.getRecm_forum_list();
            setFrsStageLiveData(gm8Var.getFrsStageLiveData());
            this.forumArIno = gm8Var.forumArIno;
            this.starRank = gm8Var.starRank;
            this.postTopic = gm8Var.postTopic;
            this.mWindowToast = gm8Var.mWindowToast;
            this.activityConfig = gm8Var.activityConfig;
            setIsShowRedTip(gm8Var.isShowRedTip());
            this.isBrandForum = gm8Var.isBrandForum;
            this.brandAdData = gm8Var.brandAdData;
            this.oriForumInfoList = gm8Var.oriForumInfoList;
            this.bottomMenuList = gm8Var.bottomMenuList;
            this.adMixFloor = gm8Var.adMixFloor;
            this.adShowSelect = gm8Var.adShowSelect;
            this.adSampleMapKey = gm8Var.adSampleMapKey;
            bh6.f().n(getAnti());
            bh6.f().q(gm8Var.getForum().getId());
            bh6.f().r(gm8Var.getForum().getName());
            ah6.h().q(gm8Var.getForum().getId());
            if (gm8Var.getEntelechyTabInfo() != null) {
                ah6.h().r(gm8Var.getEntelechyTabInfo().a);
            }
            if (gm8Var.getUserData() != null) {
                ch6.c().e(gm8Var.getUserData().bawuThrones);
            }
            setPrivateForumTotalInfo(gm8Var.getPrivateForumTotalInfo());
            setPrivateForumPopInfoData(gm8Var.getPrivateForumPopInfo());
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = gm8Var.smartAppAvatar;
            this.smartApp = gm8Var.smartApp;
            this.nebulaHotThreads = gm8Var.nebulaHotThreads;
            this.forumActiveInfo = gm8Var.forumActiveInfo;
            this.userList = gm8Var.userList;
            setBusinessPromot(gm8Var.getBusinessPromot());
            this.serviceAreaData = gm8Var.serviceAreaData;
            setHotUserRankData(gm8Var.getHotUserRankData());
            this.itemInfo = gm8Var.itemInfo;
            this.toLoadHorseData = gm8Var.toLoadHorseData;
            this.forumRule = gm8Var.forumRule;
            this.mSignActivityInfo = gm8Var.mSignActivityInfo;
            this.showAdsense = gm8Var.showAdsense;
            setVoiceRoomConfig(gm8Var.getVoiceRoomConfig());
            setVoiceRoomData(gm8Var.getVoiceRoomData());
            this.serviceAreaFlutterData = gm8Var.serviceAreaFlutterData;
            this.liveFuseForumDataList = gm8Var.liveFuseForumDataList;
            this.forumTagInfo = gm8Var.forumTagInfo;
            this.firstCategory = gm8Var.firstCategory;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void updateLikeData(wl8 wl8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, wl8Var) != null) || wl8Var == null) {
            return;
        }
        rm8 rm8Var = new rm8();
        rm8Var.x(1);
        rm8Var.y(wl8Var.a);
        rm8Var.v(wl8Var.b);
        rm8Var.t(wl8Var.c);
        rm8Var.w(wl8Var.d);
        updateLikeData(rm8Var);
    }
}
