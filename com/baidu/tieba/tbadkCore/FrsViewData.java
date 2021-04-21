package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.RecommendForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import d.b.c.j.e.n;
import d.b.i0.g0.b.a;
import d.b.i0.r.d0.b;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.d2;
import d.b.i0.r.q.m1;
import d.b.i0.r.q.w0;
import d.b.i0.r.q.z0;
import d.b.i0.r.q.z1;
import d.b.j0.d3.e0;
import d.b.j0.d3.g;
import d.b.j0.d3.h;
import d.b.j0.d3.k;
import d.b.j0.d3.l;
import d.b.j0.d3.m;
import d.b.j0.d3.o;
import d.b.j0.d3.p;
import d.b.j0.d3.q;
import d.b.j0.d3.r;
import d.b.j0.d3.w;
import d.b.j0.d3.x;
import d.b.j0.q0.c;
import d.b.j0.q0.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.AnchorPower;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.NebulaHotThreads;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.SmartApp;
import tbclient.User;
/* loaded from: classes5.dex */
public class FrsViewData extends m implements a, Serializable {
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public d.b.j0.s0.a funAdController;
    public boolean isBrandForum;
    public boolean isFrsVideoAutoPlay;
    public boolean isLoadMore;
    public BannerListData loadMoreBannerListData;
    public NebulaHotThreads nebulaHotThreads;
    public List<RecmForumInfo> recm_forum_list;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    public List<User> userList;
    public int postThreadCount = 0;
    public int mHeadLineDefaultNavTabId = -1;

    private int getAlaLiveThreadCardInsertPos(int i, int i2) {
        return Math.min((getTopThreadSize() + i) - 1, i2);
    }

    private List<n> getHeadLineDataInThreadList() {
        z0 z0Var;
        ArrayList<n> arrayList;
        ArrayList arrayList2 = new ArrayList();
        ArrayList<n> arrayList3 = this.threadList;
        if (arrayList3 != null && arrayList3.size() > 0 && (z0Var = this.page) != null && z0Var.a() == 1 && (arrayList = this.threadList) != null && arrayList.size() > 0) {
            int size = this.threadList.size();
            for (int i = 0; i < size; i++) {
                n nVar = this.threadList.get(i);
                if (nVar instanceof z1) {
                    if (((z1) nVar).w.P1) {
                        arrayList2.add(nVar);
                    }
                } else if ((nVar instanceof a2) && ((a2) nVar).P1) {
                    arrayList2.add(nVar);
                }
            }
        }
        return arrayList2;
    }

    private int getOperatorFlag() {
        Iterator<n> it = this.threadList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof a2) {
                a2 a2Var = (a2) next;
                if (a2Var.s0() == 1) {
                    return a2Var.M0();
                }
            }
        }
        return -1;
    }

    private int getPhotoliveCardInsertPos(int i) {
        return Math.min((getTopThreadSize() + getPhotoLivePos()) - 1, i);
    }

    private int getVideoThreadInserPos(int i, int i2) {
        return Math.min((getTopThreadSize() + i) - 1, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isShowRecommendBars(ArrayList<RecommendForumData> arrayList) {
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

    private void removeTopSameClassDataFromList(Class cls, ArrayList<n> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            n nVar = arrayList.get(i);
            if (nVar.getClass() == cls) {
                arrayList2.add(nVar);
                break;
            }
            i++;
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        arrayList.removeAll(arrayList2);
    }

    public void addCardVideoInfoToThreadList() {
        a2 cardVideoInfo;
        if (getForum() == null || (cardVideoInfo = getCardVideoInfo()) == null) {
            return;
        }
        Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + cardVideoInfo.w1());
        ArrayList<n> threadList = getThreadList();
        if (threadList == null || threadList.size() <= 0) {
            return;
        }
        threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
    }

    public void addFeedForumDataToThreadList() {
        ForumData forumData;
        List<FeedForumData> feedForumList;
        if (this.threadList == null || (forumData = this.forum) == null || forumData.getBannerListData() == null || MessageManager.getInstance().findTask(2003016) == null) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            n nVar = this.threadList.get(i2);
            if (nVar instanceof z1) {
                a2 a2Var = ((z1) nVar).w;
                if (a2Var == null || (!a2Var.v2() && a2Var.s0() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (feedForumList = this.forum.getBannerListData().getFeedForumList()) == null || feedForumList.size() <= 0) {
            return;
        }
        l lVar = new l();
        lVar.g(this.forum.getId());
        lVar.f(feedForumList);
        this.threadList.add(i + 6, lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addGameRankListToThreadList(boolean z) {
        boolean z2;
        if (ListUtils.isEmpty(this.threadList)) {
            return;
        }
        removeGameRankListFromThreadList();
        if (getGameRankListData() == null) {
            return;
        }
        boolean z3 = false;
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            n nVar = this.threadList.get(i2);
            if (nVar instanceof z1) {
                a2 a2Var = ((z1) nVar).w;
                if (a2Var == null || (!a2Var.v2() && a2Var.s0() != 1)) {
                    break;
                }
                i++;
            }
        }
        if ((getGameRankListData().a() + i) - 1 >= this.threadList.size()) {
            return;
        }
        String p = b.j().p("game_rank_list_info", "");
        if (!StringUtils.isNull(p) && p.split(",").length == 2) {
            if (UtilHelper.getDayBetweenTime(d.b.c.e.m.b.f(p.split(",")[0], 0L), System.currentTimeMillis()) < d.b.c.e.m.b.d(p.split(",")[1], 0)) {
                z2 = false;
                if (z2) {
                    int k = b.j().k("game_rank_list_show_times", 0);
                    if (!z) {
                        k++;
                    }
                    b.j().v("game_rank_list_show_times", k);
                    if (k > 3) {
                        b j = b.j();
                        j.x("game_rank_list_info", System.currentTimeMillis() + ",1");
                        b.j().v("game_rank_list_show_times", 0);
                        if (z3) {
                            this.threadList.add((i + getGameRankListData().a()) - 1, getGameRankListData());
                            return;
                        }
                        return;
                    }
                }
                z3 = z2;
                if (z3) {
                }
            }
        }
        z2 = true;
        if (z2) {
        }
        z3 = z2;
        if (z3) {
        }
    }

    public boolean addHotTopicDataToThreadList() {
        ForumData forumData;
        d.b.j0.x.e0.n recomTopicData;
        if (this.threadList != null && (forumData = this.forum) != null && forumData.getBannerListData() != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                n nVar = this.threadList.get(i2);
                if (nVar instanceof z1) {
                    a2 a2Var = ((z1) nVar).w;
                    if (a2Var == null || (!a2Var.v2() && a2Var.s0() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (recomTopicData = this.forum.getBannerListData().getRecomTopicData()) != null && ListUtils.getCount(recomTopicData.f64220h) >= 4) {
                this.threadList.add(i + 6, recomTopicData);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
                return true;
            }
        }
        return false;
    }

    public void addInsertLiveDataToThreadList() {
        g frsInsertLiveData;
        if (this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsInsertLiveData = getFrsInsertLiveData()) == null) {
            return;
        }
        ArrayList<n> threadList = getThreadList();
        removeTopSameClassDataFromList(g.class, threadList);
        threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.f55217f, threadList.size()), frsInsertLiveData);
    }

    public void addMyNewThread(w0 w0Var) {
        if (w0Var == null || StringUtils.isNull(w0Var.o0()) || this.threadList == null) {
            return;
        }
        int topThreadSize = getTopThreadSize();
        ArrayList<n> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            for (int i = 0; i < size; i++) {
                n nVar = threadList.get(i);
                if ((nVar instanceof z1) && w0Var.o0().equals(((z1) nVar).w.o0()) && w0Var.getType() != a2.x3) {
                    return;
                }
            }
        }
        w0Var.D1 = this.isBrandForum;
        this.postThreadCount++;
        this.threadList.add(topThreadSize, w0Var);
    }

    public void addNoticeThreadToThreadList() {
        d2 top_notice_data;
        n nVar;
        if (getForum() == null || this.threadList == null || (top_notice_data = getForum().getTop_notice_data()) == null || top_notice_data.a() == null) {
            return;
        }
        while (!this.threadList.isEmpty() && (nVar = this.threadList.get(0)) != null && (nVar instanceof z1) && ((a2) nVar).x0() == 2) {
            this.threadList.remove(0);
        }
        a2 a2Var = new a2();
        a2Var.n4(top_notice_data.a());
        a2Var.m4(top_notice_data.b());
        a2Var.M3(2);
        a2Var.V2();
        z1 z1Var = new z1();
        z1Var.w = a2Var;
        this.threadList.add(0, z1Var);
    }

    public void addOfficialBarToThreadList() {
        z0 z0Var;
        if (this.forum == null || this.threadList == null || !a2.t3.get() || (z0Var = this.page) == null) {
            return;
        }
        boolean z = true;
        if (z0Var.a() == 1) {
            r rVar = this.gconAccount;
            z = (rVar == null || !rVar.b()) ? false : false;
            if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof x)) {
                    this.threadList.remove(0);
                }
                x xVar = new x();
                xVar.C4(this.fortuneBag);
                xVar.D4(this.fortuneDesc);
                xVar.E4(this.gconAccount);
                xVar.M3(1003);
                ArrayList<n> arrayList = this.threadList;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                ListUtils.add(this.threadList, getTopThreadSize(), xVar);
            }
        }
    }

    public void addRecommendAppToThreadList(d.b.j0.e.e.b bVar) {
        addRecommendAppToThreadList(bVar, false, this.threadList, null, false);
    }

    public void addRecommendBarsToThreadList() {
        ArrayList<n> arrayList;
        if (this.forum == null || (arrayList = this.threadList) == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<n> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof m1) {
                it.remove();
            }
        }
        z0 z0Var = this.page;
        if (z0Var == null || z0Var.a() != 1) {
            return;
        }
        ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
        m1 m1Var = new m1();
        if (recommendForumData != null) {
            m1Var.z4().addAll(recommendForumData);
        }
        if (isShowRecommendBars(m1Var.z4())) {
            int i = 0;
            Iterator<n> it2 = this.threadList.iterator();
            while (it2.hasNext()) {
                n next = it2.next();
                if ((next instanceof z1) && ((z1) next).w.v2()) {
                    i++;
                }
            }
            this.threadList.add(i + 1, m1Var);
        }
    }

    public void addSchoolRecommendToThreadList() {
        if (MessageManager.getInstance().findTask(2003016) == null) {
            return;
        }
        int schoolRecommendPos = (getSchoolRecommendPos() + getTopThreadSize()) - 1;
        if (getSchoolRecommendUserInfo() == null || schoolRecommendPos < 0 || schoolRecommendPos > this.threadList.size()) {
            return;
        }
        this.threadList.add(schoolRecommendPos, getSchoolRecommendUserInfo());
    }

    public void addStageLiveDataToThreadList() {
        h frsStageLiveData;
        if (this.threadList == null || getForum() == null || MessageManager.getInstance().findTask(2911003) == null || (frsStageLiveData = getFrsStageLiveData()) == null) {
            return;
        }
        ArrayList<n> threadList = getThreadList();
        removeTopSameClassDataFromList(h.class, threadList);
        if (ListUtils.isEmpty(frsStageLiveData.f55228e)) {
            return;
        }
        threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
    }

    public void addU9DataToThreadList() {
        z0 z0Var;
        ForumData forumData = this.forum;
        if (forumData == null) {
            return;
        }
        if (((forumData.getTopCode() == null || StringUtils.isNull(this.forum.getTopCode().g())) && (this.forum.getNewsInfo() == null || StringUtils.isNull(this.forum.getNewsInfo().D0()))) || (z0Var = this.page) == null || z0Var.a() != 1) {
            return;
        }
        e0 e0Var = new e0();
        e0Var.D4(this.forum.getTopCode());
        e0Var.E4(this.forum.getNewsInfo());
        e0Var.M3(3);
        e0Var.C4(true);
        if (ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<n> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof a2) {
                a2 a2Var = (a2) next;
                if (a2Var.x0() != 0) {
                    if (a2Var.x0() == 1003) {
                        e0Var.C4(false);
                    }
                    i++;
                }
            }
        }
        this.threadList.add(i, e0Var);
    }

    public void addUserRecommendToThreadList() {
        int a2;
        if (getUserRecommend() != null) {
            d.b.j0.q0.x userRecommend = getUserRecommend();
            if (ListUtils.getCount(userRecommend.f()) >= 3 && (a2 = userRecommend.a()) > 0) {
                int topThreadSize = a2 + getTopThreadSize();
                if (topThreadSize > this.threadList.size()) {
                    this.threadList.add(userRecommend);
                } else {
                    this.threadList.add(topThreadSize, userRecommend);
                }
            }
        }
    }

    public void addVideoActivityToTop() {
        if (getFrsVideoActivityData() == null || ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<n> it = this.threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && next.getType() == q.f55437g) {
                this.threadList.remove(next);
                break;
            }
        }
        this.threadList.add(0, getFrsVideoActivityData());
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        if (getForum() == null) {
            return;
        }
        List<n> cardShipinNew = getCardShipinNew();
        List<Integer> cardShipinPos = getCardShipinPos();
        ArrayList<n> threadList = getThreadList();
        if (cardShipinPos == null || cardShipinPos.size() <= 0 || cardShipinNew == null || cardShipinNew.size() <= 0 || threadList == null) {
            return;
        }
        int size = cardShipinPos.size();
        int size2 = threadList.size();
        for (int i = 0; i < size; i++) {
            if (i < cardShipinNew.size()) {
                n nVar = cardShipinNew.get(i);
                int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + nVar.getType());
                threadList.add(videoThreadInserPos, nVar);
            }
        }
    }

    public void checkLiveStageInThreadList() {
        z0 z0Var;
        ArrayList<n> arrayList;
        ArrayList<n> arrayList2 = this.threadList;
        if (arrayList2 == null || arrayList2.size() <= 0 || (z0Var = this.page) == null || z0Var.a() != 1 || (arrayList = this.threadList) == null || arrayList.size() <= 0) {
            return;
        }
        int i = -1;
        int size = this.threadList.size();
        for (int i2 = 0; i2 < size; i2++) {
            n nVar = this.threadList.get(i2);
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.getType() == a2.f3 && z1Var.w.q1() != null && ((a2) nVar).q1().user_info != null && z1Var.w.q1().user_info.is_official == 2 && z1Var.w.q1().liveStageForceTop) {
                    i = i2;
                    break;
                }
            } else {
                if (nVar instanceof a2) {
                    a2 a2Var = (a2) nVar;
                    if (a2Var.getType() == a2.f3 && a2Var.q1() != null && a2Var.q1().user_info != null && a2Var.q1().user_info.is_official == 2 && a2Var.q1().liveStageForceTop) {
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
                n nVar2 = this.threadList.get(i3);
                if (nVar2 instanceof z1) {
                    if (((z1) nVar2).w.getType() == a2.A3) {
                        i = i3;
                        break;
                    }
                } else {
                    if ((nVar2 instanceof a2) && ((a2) nVar2).getType() == a2.A3) {
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
        List<n> headLineDataInThreadList = getHeadLineDataInThreadList();
        if (ListUtils.isEmpty(headLineDataInThreadList)) {
            return;
        }
        this.threadList.removeAll(headLineDataInThreadList);
        if (topThreadSize < 0 || topThreadSize > this.threadList.size()) {
            return;
        }
        this.threadList.addAll(topThreadSize, headLineDataInThreadList);
    }

    public void clearPostThreadCount() {
        this.postThreadCount = 0;
    }

    public void filterEnterList(List<k> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<k> it = list.iterator();
        while (it.hasNext()) {
            k next = it.next();
            if (next == null) {
                it.remove();
            } else if (StringUtils.isNull(next.k()) || StringUtils.isNull(next.g())) {
                if (next.a() != 1) {
                    it.remove();
                }
            }
        }
    }

    public d getBrandAdData() {
        return this.brandAdData;
    }

    public ForumActiveInfo getForumActiveInfo() {
        return this.forumActiveInfo;
    }

    public boolean getIsBrandForum() {
        return this.isBrandForum;
    }

    public int getMyNewThreadNum() {
        ArrayList<n> threadList = getThreadList();
        if (threadList == null || threadList.size() <= 0) {
            return 0;
        }
        int size = threadList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (threadList.get(i2) instanceof w0) {
                i++;
            }
        }
        return i;
    }

    public int getPostThreadCount() {
        return this.postThreadCount;
    }

    @Override // d.b.j0.d3.m
    public List<RecmForumInfo> getRecm_forum_list() {
        return this.recm_forum_list;
    }

    public List<n> getShowTopThreadList() {
        List<k> list;
        int i;
        ArrayList arrayList = new ArrayList();
        if (ListUtils.isEmpty(getStarEnter())) {
            list = null;
        } else {
            list = getStarEnter();
            filterEnterList(list);
        }
        if (ListUtils.isEmpty(list)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2).a() == 1) {
                    arrayList.add(list.get(i2));
                    i++;
                }
            }
        }
        ForumData forum = getForum();
        if (forum != null && getForum().getIsShowRule() && this.forumRule != null && (getUserData().getIs_manager() == 1 || this.forumRule.has_forum_rule.intValue() == 1)) {
            arrayList.add(new p(forum, this.forumRule));
        }
        if (forum != null && !d.b.c.e.p.k.isEmpty(forum.getRiskTipNotice())) {
            arrayList.add(new o(forum, false));
        } else if (forum != null && !ListUtils.isEmpty(forum.getTipInfos())) {
            arrayList.add(new o(forum, true));
        }
        int i3 = 3 - i;
        int size = arrayList.size();
        List<n> topThreadList = getTopThreadList();
        if (topThreadList != null) {
            boolean z = false;
            for (int i4 = 0; i4 < ListUtils.getCount(topThreadList) && arrayList.size() < size + i3; i4++) {
                n nVar = (n) ListUtils.getItem(topThreadList, i4);
                if (nVar instanceof z1) {
                    z1 z1Var = (z1) nVar;
                    arrayList.add(z1Var.w);
                    if (z1Var.w.u0() != 1 || z) {
                        if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                            break;
                        }
                    }
                    i3++;
                    z = true;
                } else {
                    if (nVar instanceof a2) {
                        arrayList.add(nVar);
                        if (((a2) nVar).u0() != 1 || z) {
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

    public SignData getSignData() {
        ForumData forumData = this.forum;
        if (forumData == null) {
            return null;
        }
        return forumData.getSignData();
    }

    public a2 getThreadDataById(String str) {
        ArrayList<n> arrayList = this.threadList;
        if (arrayList == null) {
            return null;
        }
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next != null && (next instanceof z1)) {
                z1 z1Var = (z1) next;
                if (TextUtils.equals(str, z1Var.w.o0())) {
                    return z1Var.w;
                }
            }
        }
        return null;
    }

    public List<n> getTopThreadList() {
        return this.topThreadList;
    }

    public int getTopThreadSize() {
        ArrayList<n> arrayList = this.threadList;
        int i = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<n> it = this.threadList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof a2) {
                    if (((a2) next).x0() == 0) {
                        break;
                    }
                    i++;
                }
            }
        }
        return i;
    }

    public NebulaHotThreads getYouhuaHotThreads() {
        return this.nebulaHotThreads;
    }

    public boolean hasTab() {
        return (getEntelechyTabInfo() == null || ListUtils.isEmpty(getEntelechyTabInfo().tab)) ? false : true;
    }

    public boolean isFirstTabEqualAllThread() {
        List<FrsTabInfo> list;
        FrsTabInfo frsTabInfo;
        NavTabInfo entelechyTabInfo = getEntelechyTabInfo();
        return (entelechyTabInfo == null || (list = entelechyTabInfo.tab) == null || list.size() <= 0 || (frsTabInfo = list.get(0)) == null || frsTabInfo.tab_id.intValue() != 1) ? false : true;
    }

    public boolean isPrivateForum() {
        return (getForum() == null || getForum().getIsPrivateForum() == 0 || getForum().getIsPrivateForum() != 1) ? false : true;
    }

    public boolean isStarForum() {
        return getStar() != null && getStar().b() == 1;
    }

    public boolean receiveData(m mVar) {
        if (mVar == null) {
            return false;
        }
        setSortType(mVar.getSortType());
        setAnti(mVar.getAnti());
        setChatGroup(mVar.getChatGroup());
        setFortuneBag(mVar.isFortuneBag());
        setFortuneDesc(mVar.getFortuneDesc());
        setForum(mVar.getForum());
        setGameName(mVar.getGameName());
        setGameUrl(mVar.getGameUrl());
        setGconAccount(mVar.getGconAccount());
        setHasGame(mVar.isHasGame());
        setIsNewUrl(mVar.getIsNewUrl());
        setPhotoLivePos(mVar.getPhotoLivePos());
        setPage(mVar.getPage());
        setStar(mVar.getStar());
        setStarEnter(mVar.getStarEnter());
        setThreadList(mVar.threadList);
        setThreadListIds(mVar.getThreadListIds());
        setUserData(mVar.getUserData());
        setUserMap(mVar.getUserMap());
        setActivityHeadData(mVar.getActivityHeadData());
        setFrsDefaultTabId(mVar.getFrsDefaultTabId());
        this.defaultShowTab = mVar.defaultShowTab;
        setCategoryInfos(mVar.getCategoryInfos());
        setBawuCenterUrl(mVar.getBawuCenterUrl());
        setCardVideoInfo(mVar.getCardVideoInfo());
        setHeadSdkData(mVar.getHeadSdkData());
        setSchoolRecommendPos(mVar.getSchoolRecommendPos());
        setSchoolRecommendInfo(mVar.getSchoolRecommendUserInfo());
        setEntelechyTabInfo(mVar.getEntelechyTabInfo());
        setAlaLiveCount(mVar.getAlaLiveCount());
        setCarrierEnterData(mVar.getCarrierEnterData());
        setForumState(mVar.getForumState());
        setAccessFlag(mVar.getAccessFlag());
        this.needLog = mVar.needLog;
        this.recommendBookData = mVar.recommendBookData;
        this.presentInfoData = mVar.presentInfoData;
        setBookInfo(mVar.getBookInfo());
        setMangaReadRecordChapterId(mVar.getMangaReadRecordChapterId());
        setHeadlineImgInfoData(mVar.getHeadlineImgInfoData());
        setCardShipinPos(mVar.getCardShipinPos());
        setCardShipinNew(mVar.getCardShipinNew());
        this.enterFrsDialogInfo = mVar.enterFrsDialogInfo;
        setGameRankListData(mVar.getGameRankListData());
        setAgreeBanner(mVar.getAgreeBanner());
        setLiveNotify(mVar.getLiveNotify());
        setGameTabInfo(mVar.getGameTabInfo());
        setGameDefaultTabId(mVar.getGameDefaultTabId());
        setForumHeadIcon(mVar.getForumHeadIcon());
        setUserRecommend(mVar.getUserRecommend());
        setFrsVideoActivityData(mVar.getFrsVideoActivityData());
        this.mNewChapterInfo = mVar.mNewChapterInfo;
        setFrsInsertLiveData(mVar.getFrsInsertLiveData());
        this.recm_forum_list = mVar.getRecm_forum_list();
        setFrsStageLiveData(mVar.getFrsStageLiveData());
        this.forumArIno = mVar.forumArIno;
        this.starRank = mVar.starRank;
        this.postTopic = mVar.postTopic;
        this.mWindowToast = mVar.mWindowToast;
        this.activityConfig = mVar.activityConfig;
        setIsShowRedTip(mVar.isShowRedTip());
        this.isBrandForum = mVar.isBrandForum;
        this.brandAdData = mVar.brandAdData;
        this.oriForumInfoList = mVar.oriForumInfoList;
        this.bottomMenuList = mVar.bottomMenuList;
        d.b.j0.q0.b.e().l(getAnti());
        d.b.j0.q0.b.e().n(mVar.getForum().getId());
        d.b.j0.q0.a.h().q(mVar.getForum().getId());
        if (mVar.getEntelechyTabInfo() != null) {
            d.b.j0.q0.a.h().r(mVar.getEntelechyTabInfo().tab);
        }
        if (mVar.getUserData() != null) {
            c.c().e(mVar.getUserData().bawuThrones);
        }
        setPrivateForumTotalInfo(mVar.getPrivateForumTotalInfo());
        this.isFrsVideoAutoPlay = mVar.isFrsVideoAutoPlay;
        this.smartAppAvatar = mVar.smartAppAvatar;
        this.smartApp = mVar.smartApp;
        this.nebulaHotThreads = mVar.nebulaHotThreads;
        this.forumActiveInfo = mVar.forumActiveInfo;
        this.userList = mVar.userList;
        setBusinessPromot(mVar.getBusinessPromot());
        this.serviceAreaData = mVar.serviceAreaData;
        setHotUserRankData(mVar.getHotUserRankData());
        this.itemInfo = mVar.itemInfo;
        this.toLoadHorseData = mVar.toLoadHorseData;
        this.forumRule = mVar.forumRule;
        this.mSignActivityInfo = mVar.mSignActivityInfo;
        this.showAdsense = mVar.showAdsense;
        return true;
    }

    public void removeAlaInsertLiveData() {
        removeTopSameClassDataFromList(g.class, getThreadList());
    }

    public void removeAlaLiveThreadData() {
        ArrayList<n> arrayList = this.threadList;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.threadList.size(); i++) {
            if (this.threadList.get(i).getType() == a2.f3 || this.threadList.get(i).getType() == a2.g3 || this.threadList.get(i).getType() == a2.h3) {
                this.threadList.remove(i);
            }
        }
    }

    public void removeAlaStageLiveDat() {
        removeTopSameClassDataFromList(h.class, getThreadList());
    }

    public void removeGameRankListFromThreadList() {
        if (ListUtils.isEmpty(this.threadList)) {
            return;
        }
        Iterator<n> it = this.threadList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next != null && next.getType() == d.b.j0.t0.b.i) {
                it.remove();
            }
        }
    }

    public void removeRedundantUserRecommendData() {
        if (ListUtils.isEmpty(this.threadList)) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.threadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof d.b.j0.q0.x) {
                if (z) {
                    it.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void removeThread(String str) {
        ArrayList<n> arrayList = this.threadList;
        if (arrayList == null) {
            return;
        }
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next != null && (next instanceof z1) && TextUtils.equals(str, ((z1) next).w.o0())) {
                it.remove();
            }
        }
    }

    public void removeThreadData(a2 a2Var) {
        this.threadList.remove(a2Var);
    }

    public void setFunAdController(d.b.j0.s0.a aVar) {
        this.funAdController = aVar;
    }

    public void setTopThreadList(List<n> list) {
        this.topThreadList = list;
    }

    public void updateAnchorPower(AnchorPower anchorPower) {
        this.forum.setAnchorPower(anchorPower);
    }

    public void updateCurrentUserPendant(d.b.i0.t.n nVar) {
        if (this.threadList == null || nVar == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        Iterator<n> it = this.threadList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next != null && (next instanceof z1)) {
                z1 z1Var = (z1) next;
                if (z1Var.w.T() != null && currentAccount.equals(z1Var.w.T().getUserId()) && z1Var.w.T().getPendantData() != null) {
                    z1Var.w.T().getPendantData().e(nVar.b());
                    z1Var.w.T().getPendantData().d(nVar.a());
                }
            }
        }
    }

    public void updateLikeData(d.b.j0.d3.d dVar) {
        if (dVar == null) {
            return;
        }
        w wVar = new w();
        wVar.v(1);
        wVar.w(dVar.f55192a);
        wVar.t(dVar.f55193b);
        wVar.r(dVar.f55194c);
        wVar.u(dVar.f55195d);
        updateLikeData(wVar);
    }

    public void updateLoadMoreBannerListData(BannerListData bannerListData) {
        this.isLoadMore = true;
        this.loadMoreBannerListData = bannerListData;
    }

    public void updateSignData(SignData signData) {
        if (signData == null) {
            return;
        }
        this.forum.setSignData(signData);
    }

    public void addRecommendAppToThreadList(d.b.j0.e.e.b bVar, ArrayList<n> arrayList) {
        addRecommendAppToThreadList(bVar, false, arrayList, null, false);
    }

    public void addRecommendAppToThreadList(d.b.j0.e.e.b bVar, boolean z, ArrayList<n> arrayList, ArrayList<n> arrayList2, boolean z2) {
        BannerListData bannerListData;
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
        if (bannerListData == null || bannerListData.getAllAdvertList() == null || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        d.b.j0.e.f.b bVar2 = new d.b.j0.e.f.b(bVar, 2);
        ArrayList arrayList3 = new ArrayList();
        Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
        while (it.hasNext()) {
            AdvertAppInfo next = it.next();
            next.A3(true);
            next.h4(getSortType());
            arrayList3.add(next);
        }
        bVar2.r(arrayList3);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        d.b.j0.e.f.b bVar3 = new d.b.j0.e.f.b(bVar, 3);
        bVar3.x(z);
        bVar3.E(arrayList);
        bVar3.B(arrayList2);
        bVar3.w(z2);
        bVar3.s(getPage().a());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
    }

    public void updateLikeData(w wVar) {
        if (wVar == null) {
            return;
        }
        this.forum.setCurScore(wVar.c());
        this.forum.setLevelupScore(wVar.i());
        this.forum.setLike(wVar.l());
        this.forum.setUser_level(wVar.k());
        this.forum.setLevelName(wVar.h());
    }
}
