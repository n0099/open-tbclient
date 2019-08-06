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
import com.baidu.tbadk.core.data.RecommendForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.tbadkCore.e;
import com.xiaomi.mipush.sdk.Constants;
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
/* loaded from: classes3.dex */
public class FrsViewData extends l implements com.baidu.tbadk.mvc.b.l, Serializable {
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public boolean isBrandForum;
    public boolean isFrsVideoAutoPlay;
    private boolean isLoadMore;
    private BannerListData loadMoreBannerListData;
    private NebulaHotThreads nebulaHotThreads;
    private int postThreadCount = 0;
    private List<RecmForumInfo> recm_forum_list;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    public List<User> userList;

    public void updateLikeData(e.a aVar) {
        if (aVar != null) {
            t tVar = new t();
            tVar.setLike(1);
            tVar.AO(aVar.level);
            tVar.setLevelName(aVar.jdQ);
            tVar.setCurScore(aVar.cur_score);
            tVar.setLevelupScore(aVar.levelup_score);
            updateLikeData(tVar);
        }
    }

    public void updateLikeData(t tVar) {
        if (tVar != null) {
            this.forum.setCurScore(tVar.getCurScore());
            this.forum.setLevelupScore(tVar.getLevelupScore());
            this.forum.setLike(tVar.isLike());
            this.forum.setUser_level(tVar.cnn());
            this.forum.setLevelName(tVar.getLevelName());
        }
    }

    public void updateSignData(SignData signData) {
        if (signData != null) {
            this.forum.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.forum == null) {
            return null;
        }
        return this.forum.getSignData();
    }

    public void updateAnchorPower(AnchorPower anchorPower) {
        this.forum.setAnchorPower(anchorPower);
    }

    public void addNoticeThreadToThreadList() {
        bk top_notice_data;
        com.baidu.adp.widget.ListView.m mVar;
        if (getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (mVar = this.threadList.get(0)) != null && (mVar instanceof bg) && ((bh) mVar).aet() == 2) {
                this.threadList.remove(0);
            }
            bh bhVar = new bh();
            bhVar.setTitle(top_notice_data.getTitle());
            bhVar.setTid(top_notice_data.agy());
            bhVar.hk(2);
            bhVar.afo();
            bg bgVar = new bg();
            bgVar.threadData = bhVar;
            this.threadList.add(0, bgVar);
        }
    }

    public void addMyNewThread(ak akVar) {
        if (akVar != null && !StringUtils.isNull(akVar.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.m mVar = threadList.get(i);
                    if ((mVar instanceof bg) && akVar.getId().equals(((bg) mVar).threadData.getId())) {
                        return;
                    }
                }
            }
            akVar.bMg = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, akVar);
        }
    }

    public void clearPostThreadCount() {
        this.postThreadCount = 0;
    }

    public int getPostThreadCount() {
        return this.postThreadCount;
    }

    public int getMyNewThreadNum() {
        int i = 0;
        ArrayList<com.baidu.adp.widget.ListView.m> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = threadList.get(i2) instanceof ak ? i + 1 : i;
                i2++;
                i = i3;
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean aG(ArrayList<RecommendForumData> arrayList) {
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

    public void removeAlaLiveThreadData() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bh.bJD || this.threadList.get(i2).getType() == bh.bJE || this.threadList.get(i2).getType() == bh.bJF) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void checkLiveStageInThreadList() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.page != null && this.page.adq() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.threadList.get(i2);
                if (mVar instanceof bg) {
                    if (((bg) mVar).threadData.getType() == bh.bJD && ((bg) mVar).threadData.aeR() != null && ((bg) mVar).threadData.aeR().user_info.is_official == 2 && ((bg) mVar).threadData.aeR().liveStageForceTop) {
                        break;
                    }
                    i2++;
                } else {
                    if ((mVar instanceof bh) && ((bh) mVar).getType() == bh.bJD && ((bh) mVar).aeR() != null && ((bh) mVar).aeR().user_info.is_official == 2 && ((bh) mVar).aeR().liveStageForceTop) {
                        break;
                    }
                    i2++;
                }
            }
            if (i2 < 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    com.baidu.adp.widget.ListView.m mVar2 = this.threadList.get(i3);
                    if (mVar2 instanceof bg) {
                        if (((bg) mVar2).threadData.getType() == bh.bLa) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((mVar2 instanceof bh) && ((bh) mVar2).getType() == bh.bLa) {
                            i = i3;
                            break;
                        }
                    }
                }
            }
            i = i2;
            int topThreadSize = getTopThreadSize();
            if (i > topThreadSize) {
                this.threadList.add(topThreadSize, this.threadList.remove(i));
            }
        }
    }

    public void addRecommendBarsToThreadList() {
        if (this.forum != null && this.threadList != null && this.threadList.size() > 0) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof ax) {
                    it.remove();
                }
            }
            if (this.page != null && this.page.adq() == 1) {
                ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
                ax axVar = new ax();
                if (recommendForumData != null) {
                    axVar.adF().addAll(recommendForumData);
                }
                if (aG(axVar.adF())) {
                    int i = 0;
                    Iterator<com.baidu.adp.widget.ListView.m> it2 = this.threadList.iterator();
                    while (true) {
                        int i2 = i;
                        if (it2.hasNext()) {
                            com.baidu.adp.widget.ListView.m next = it2.next();
                            if ((next instanceof bg) && ((bg) next).threadData.aff()) {
                                i2++;
                            }
                            i = i2;
                        } else {
                            this.threadList.add(i2 + 1, axVar);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void addRecommendAppToThreadList(com.baidu.tieba.InjectPlugin.a.b bVar) {
        addRecommendAppToThreadList(bVar, false, this.threadList, null, false);
    }

    public void addRecommendAppToThreadList(com.baidu.tieba.InjectPlugin.a.b bVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        addRecommendAppToThreadList(bVar, false, arrayList, null, false);
    }

    public void addRecommendAppToThreadList(com.baidu.tieba.InjectPlugin.a.b bVar, boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, ArrayList<com.baidu.adp.widget.ListView.m> arrayList2, boolean z2) {
        BannerListData bannerListData;
        if (!this.isLoadMore) {
            if (this.forum != null) {
                bannerListData = this.forum.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.loadMoreBannerListData;
        }
        this.isLoadMore = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar2.aw(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.gb(z);
            bVar3.av(arrayList);
            bVar3.ax(arrayList2);
            bVar3.gc(z2);
            bVar3.setCurrentPage(getPage().adq());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    public void addOfficialBarToThreadList() {
        boolean z = true;
        if (this.forum != null && this.threadList != null && bh.bJN.get() && this.page != null && this.page.adq() == 1) {
            if (this.gconAccount == null || !this.gconAccount.coW()) {
                z = false;
            }
            if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof u)) {
                    this.threadList.remove(0);
                }
                u uVar = new u();
                uVar.qY(this.fortuneBag);
                uVar.ED(this.fortuneDesc);
                uVar.a(this.gconAccount);
                uVar.hk(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    com.baidu.tbadk.core.util.v.a(this.threadList, getTopThreadSize(), uVar);
                }
            }
        }
    }

    public void addU9DataToThreadList() {
        int i;
        if (this.forum != null) {
            if (((this.forum.getTopCode() != null && !StringUtils.isNull(this.forum.getTopCode().getSummary())) || (this.forum.getNewsInfo() != null && !StringUtils.isNull(this.forum.getNewsInfo().getSummary()))) && this.page != null && this.page.adq() == 1) {
                x xVar = new x();
                xVar.a(this.forum.getTopCode());
                xVar.a(this.forum.getNewsInfo());
                xVar.hk(3);
                xVar.qZ(true);
                if (!com.baidu.tbadk.core.util.v.aa(this.threadList)) {
                    Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.m next = it.next();
                        if (!(next instanceof bh)) {
                            i = i2;
                        } else if (((bh) next).aet() != 0) {
                            if (((bh) next).aet() == 1003) {
                                xVar.qZ(false);
                            }
                            i = i2 + 1;
                        }
                        i2 = i;
                    }
                    this.threadList.add(i2, xVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public List<RecmForumInfo> getRecm_forum_list() {
        return this.recm_forum_list;
    }

    public boolean getIsBrandForum() {
        return this.isBrandForum;
    }

    public com.baidu.tieba.frs.b getBrandAdData() {
        return this.brandAdData;
    }

    private int Bb(int i) {
        return Math.min((getTopThreadSize() + getPhotoLivePos()) - 1, i);
    }

    public void addStageLiveDataToThreadList() {
        g frsStageLiveData;
        if (this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = getThreadList();
            a(g.class, threadList);
            if (!com.baidu.tbadk.core.util.v.aa(frsStageLiveData.jdW)) {
                threadList.add(cx(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void removeAlaStageLiveDat() {
        a(g.class, getThreadList());
    }

    public void addInsertLiveDataToThreadList() {
        f frsInsertLiveData;
        if (this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = getThreadList();
            a(f.class, threadList);
            threadList.add(cx(frsInsertLiveData.jdU, threadList.size()), frsInsertLiveData);
        }
    }

    public void removeAlaInsertLiveData() {
        a(f.class, getThreadList());
    }

    private int cx(int i, int i2) {
        return Math.min((getTopThreadSize() + i) - 1, i2);
    }

    private void a(Class cls, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = arrayList.get(i);
                if (mVar.getClass() != cls) {
                    i++;
                } else {
                    arrayList2.add(mVar);
                    break;
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.removeAll(arrayList2);
            }
        }
    }

    public void addCardVideoInfoToThreadList() {
        bh cardVideoInfo;
        if (getForum() != null && (cardVideoInfo = getCardVideoInfo()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + cardVideoInfo.getTid());
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(Bb(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        if (getForum() != null) {
            List<com.baidu.adp.widget.ListView.m> cardShipinNew = getCardShipinNew();
            List<Integer> cardShipinPos = getCardShipinPos();
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = getThreadList();
            if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
                int size = cardShipinPos.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < cardShipinNew.size()) {
                        com.baidu.adp.widget.ListView.m mVar = cardShipinNew.get(i);
                        int cy = cy(cardShipinPos.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + cy + "  Title:" + mVar.getType());
                        threadList.add(cy, mVar);
                    }
                }
            }
        }
    }

    private int cy(int i, int i2) {
        return Math.min((getTopThreadSize() + i) - 1, i2);
    }

    public bh getThreadDataById(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if (next != null && (next instanceof bg) && TextUtils.equals(str, ((bg) next).threadData.getId())) {
                return ((bg) next).threadData;
            }
        }
        return null;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (this.threadList != null && lVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next != null && (next instanceof bg) && ((bg) next).threadData.aey() != null && currentAccount.equals(((bg) next).threadData.aey().getUserId()) && ((bg) next).threadData.aey().getPendantData() != null) {
                        ((bg) next).threadData.aey().getPendantData().bh(lVar.arE());
                        ((bg) next).threadData.aey().getPendantData().mv(lVar.acV());
                    }
                }
            }
        }
    }

    public void removeThreadData(bh bhVar) {
        this.threadList.remove(bhVar);
    }

    public void removeThread(String str) {
        if (this.threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next != null && (next instanceof bg) && TextUtils.equals(str, ((bg) next).threadData.getId())) {
                    it.remove();
                }
            }
        }
    }

    public boolean receiveData(l lVar) {
        if (lVar == null) {
            return false;
        }
        setAnti(lVar.getAnti());
        setChatGroup(lVar.getChatGroup());
        setFortuneBag(lVar.isFortuneBag());
        setFortuneDesc(lVar.getFortuneDesc());
        setForum(lVar.getForum());
        setGameName(lVar.getGameName());
        setGameUrl(lVar.getGameUrl());
        setGconAccount(lVar.getGconAccount());
        setHasGame(lVar.isHasGame());
        setIsNewUrl(lVar.getIsNewUrl());
        setPhotoLivePos(lVar.getPhotoLivePos());
        setPage(lVar.getPage());
        setStar(lVar.getStar());
        setStarEnter(lVar.getStarEnter());
        setThreadList(lVar.threadList);
        setThreadListIds(lVar.getThreadListIds());
        setUserData(lVar.getUserData());
        setUserMap(lVar.getUserMap());
        setActivityHeadData(lVar.getActivityHeadData());
        setFrsDefaultTabId(lVar.getFrsDefaultTabId());
        this.defaultShowTab = lVar.defaultShowTab;
        setCategoryInfos(lVar.getCategoryInfos());
        setBawuCenterUrl(lVar.getBawuCenterUrl());
        setCardVideoInfo(lVar.getCardVideoInfo());
        setHeadSdkData(lVar.getHeadSdkData());
        setSchoolRecommendPos(lVar.getSchoolRecommendPos());
        setSchoolRecommendInfo(lVar.getSchoolRecommendUserInfo());
        setEntelechyTabInfo(lVar.getEntelechyTabInfo());
        setAlaLiveCount(lVar.getAlaLiveCount());
        setCarrierEnterData(lVar.getCarrierEnterData());
        setForumState(lVar.getForumState());
        setAccessFlag(lVar.getAccessFlag());
        this.needLog = lVar.needLog;
        this.recommendBookData = lVar.recommendBookData;
        this.presentInfoData = lVar.presentInfoData;
        setBookInfo(lVar.getBookInfo());
        setMangaReadRecordChapterId(lVar.getMangaReadRecordChapterId());
        setHeadlineImgInfoData(lVar.getHeadlineImgInfoData());
        setCardShipinPos(lVar.getCardShipinPos());
        setCardShipinNew(lVar.getCardShipinNew());
        this.enterFrsDialogInfo = lVar.enterFrsDialogInfo;
        setGameRankListData(lVar.getGameRankListData());
        setAgreeBanner(lVar.getAgreeBanner());
        setLiveNotify(lVar.getLiveNotify());
        setGameTabInfo(lVar.getGameTabInfo());
        setGameDefaultTabId(lVar.getGameDefaultTabId());
        setForumHeadIcon(lVar.getForumHeadIcon());
        setUserRecommend(lVar.getUserRecommend());
        setFrsVideoActivityData(lVar.getFrsVideoActivityData());
        this.mNewChapterInfo = lVar.mNewChapterInfo;
        setFrsInsertLiveData(lVar.getFrsInsertLiveData());
        this.recm_forum_list = lVar.getRecm_forum_list();
        setFrsStageLiveData(lVar.getFrsStageLiveData());
        this.forumArIno = lVar.forumArIno;
        this.starRank = lVar.starRank;
        this.postTopic = lVar.postTopic;
        this.mWindowToast = lVar.mWindowToast;
        this.activityConfig = lVar.activityConfig;
        setIsShowRedTip(lVar.isShowRedTip());
        this.isBrandForum = lVar.isBrandForum;
        this.brandAdData = lVar.brandAdData;
        this.oriForumInfoList = lVar.oriForumInfoList;
        this.bottomMenuList = lVar.bottomMenuList;
        com.baidu.tieba.frs.a.blf().b(getAnti());
        com.baidu.tieba.frs.a.blf().setForumId(lVar.getForum().getId());
        setRedpacketRainData(lVar.getRedpacketRainData());
        setPrivateForumTotalInfo(lVar.getPrivateForumTotalInfo());
        this.isFrsVideoAutoPlay = lVar.isFrsVideoAutoPlay;
        this.smartAppAvatar = lVar.smartAppAvatar;
        this.smartApp = lVar.smartApp;
        this.nebulaHotThreads = lVar.nebulaHotThreads;
        this.forumActiveInfo = lVar.forumActiveInfo;
        this.userList = lVar.userList;
        setBusinessPromot(lVar.getBusinessPromot());
        return true;
    }

    public NebulaHotThreads getYouhuaHotThreads() {
        return this.nebulaHotThreads;
    }

    public ForumActiveInfo getForumActiveInfo() {
        return this.forumActiveInfo;
    }

    public void addFeedForumDataToThreadList() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.forum != null && this.forum.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.m mVar = this.threadList.get(i2);
                if (mVar instanceof bg) {
                    bh bhVar = ((bg) mVar).threadData;
                    if (bhVar == null || (!bhVar.aff() && bhVar.aev() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                k kVar = new k();
                kVar.setForumId(this.forum.getId());
                kVar.ec(feedForumList);
                this.threadList.add(i + 6, kVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addGameRankListToThreadList(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.aa(this.threadList)) {
            removeGameRankListFromThreadList();
            if (getGameRankListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.m mVar = this.threadList.get(i2);
                    if (mVar instanceof bg) {
                        bh bhVar = ((bg) mVar).threadData;
                        if (bhVar == null || (!bhVar.aff() && bhVar.aev() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((getGameRankListData().bub() + i) - 1 < this.threadList.size()) {
                    String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("game_rank_list_info", "");
                    if (StringUtils.isNull(string) || string.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length != 2) {
                        z2 = true;
                    } else {
                        z2 = UtilHelper.getDayBetweenTime(com.baidu.adp.lib.g.b.c(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0], 0L), System.currentTimeMillis()) >= ((long) com.baidu.adp.lib.g.b.f(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1], 0));
                    }
                    if (z2) {
                        int i3 = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("game_rank_list_show_times", 0);
                        if (!z) {
                            i3++;
                        }
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("game_rank_list_show_times", i3);
                        if (i3 > 3) {
                            com.baidu.tbadk.core.sharedPref.b.ahQ().putString("game_rank_list_info", System.currentTimeMillis() + ",1");
                            com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("game_rank_list_show_times", 0);
                            if (!z3) {
                                this.threadList.add((getGameRankListData().bub() + i) - 1, getGameRankListData());
                                return;
                            }
                            return;
                        }
                    }
                    z3 = z2;
                    if (!z3) {
                    }
                }
            }
        }
    }

    public void removeGameRankListFromThreadList() {
        if (!com.baidu.tbadk.core.util.v.aa(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.h.b.fXj) {
                    it.remove();
                }
            }
        }
    }

    public boolean addHotTopicDataToThreadList() {
        com.baidu.tieba.card.data.n recomTopicData;
        if (this.threadList == null || this.forum == null || this.forum.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.m mVar = this.threadList.get(i2);
            if (mVar instanceof bg) {
                bh bhVar = ((bg) mVar).threadData;
                if (bhVar == null || (!bhVar.aff() && bhVar.aev() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.forum.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.Z(recomTopicData.eGA) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new an("c10835").bT("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void addSchoolRecommendToThreadList() {
        if (MessageManager.getInstance().findTask(2003016) != null) {
            int schoolRecommendPos = (getSchoolRecommendPos() + getTopThreadSize()) - 1;
            if (getSchoolRecommendUserInfo() != null && schoolRecommendPos >= 0 && schoolRecommendPos <= this.threadList.size()) {
                this.threadList.add(schoolRecommendPos, getSchoolRecommendUserInfo());
            }
        }
    }

    public void addUserRecommendToThreadList() {
        int afF;
        if (getUserRecommend() != null) {
            com.baidu.tieba.frs.q userRecommend = getUserRecommend();
            if (com.baidu.tbadk.core.util.v.Z(userRecommend.getUserInfo()) >= 3 && (afF = userRecommend.afF()) > 0) {
                int topThreadSize = afF + getTopThreadSize();
                if (topThreadSize > this.threadList.size()) {
                    this.threadList.add(userRecommend);
                } else {
                    this.threadList.add(topThreadSize, userRecommend);
                }
            }
        }
    }

    public void removeRedundantUserRecommendData() {
        if (!com.baidu.tbadk.core.util.v.aa(this.threadList)) {
            boolean z = false;
            Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
            while (true) {
                boolean z2 = z;
                if (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.q) {
                        if (z2) {
                            it.remove();
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    return;
                }
            }
        }
    }

    public void addVideoActivityToTop() {
        if (getFrsVideoActivityData() != null && !com.baidu.tbadk.core.util.v.aa(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next != null && next.getType() == n.jeS) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getTopThreadList() {
        return this.topThreadList;
    }

    public void setTopThreadList(List<com.baidu.adp.widget.ListView.m> list) {
        this.topThreadList = list;
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (!(next instanceof bh)) {
                    i = i2;
                } else if (((bh) next).aet() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    protected void filterEnterList(List<j> list) {
        if (list != null && list.size() != 0) {
            Iterator<j> it = list.iterator();
            while (it.hasNext()) {
                j next = it.next();
                if (next == null) {
                    it.remove();
                } else if (StringUtils.isNull(next.getUrl()) || StringUtils.isNull(next.getTitle())) {
                    if (next.coO() != 1) {
                        it.remove();
                    }
                }
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getShowTopThreadList() {
        List<j> list;
        int i;
        ArrayList arrayList = new ArrayList();
        if (com.baidu.tbadk.core.util.v.aa(getStarEnter())) {
            list = null;
        } else {
            List<j> starEnter = getStarEnter();
            filterEnterList(starEnter);
            list = starEnter;
        }
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2).coO() == 1) {
                    arrayList.add(list.get(i2));
                }
            }
        }
        List<com.baidu.adp.widget.ListView.m> topThreadList = getTopThreadList();
        if (topThreadList != null) {
            int i3 = 3;
            int i4 = 0;
            while (i4 < com.baidu.tbadk.core.util.v.Z(topThreadList) && arrayList.size() < i3) {
                com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(topThreadList, i4);
                if (mVar instanceof bg) {
                    arrayList.add(((bg) mVar).threadData);
                    if (((bg) mVar).threadData.aes() == 1) {
                        i3 = 4;
                    } else if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                        break;
                    }
                    i = i3;
                    i4++;
                    i3 = i;
                } else {
                    if (mVar instanceof bh) {
                        arrayList.add(mVar);
                        if (((bh) mVar).aes() == 1) {
                            i = 4;
                            i4++;
                            i3 = i;
                        } else if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                            break;
                        }
                    }
                    i = i3;
                    i4++;
                    i3 = i;
                }
            }
        }
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                if (list.get(i5).coO() != 1) {
                    arrayList.add(list.get(i5));
                }
            }
        }
        return arrayList;
    }

    public boolean isStarForum() {
        if (getStar() == null) {
            return false;
        }
        return getStar().coU() == 1;
    }

    public boolean hasTab() {
        return (getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.v.aa(getEntelechyTabInfo().tab)) ? false : true;
    }

    public void updateLoadMoreBannerListData(BannerListData bannerListData) {
        this.isLoadMore = true;
        this.loadMoreBannerListData = bannerListData;
    }

    public boolean isPrivateForum() {
        if (getForum() == null || getForum().getIsPrivateForum() == 0) {
            return false;
        }
        return getForum().getIsPrivateForum() == 1;
    }

    public boolean isFirstTabEqualAllThread() {
        List<FrsTabInfo> list;
        FrsTabInfo frsTabInfo;
        NavTabInfo entelechyTabInfo = getEntelechyTabInfo();
        if (entelechyTabInfo == null || (list = entelechyTabInfo.tab) == null || list.size() <= 0 || (frsTabInfo = list.get(0)) == null) {
            return false;
        }
        return frsTabInfo.tab_id.intValue() == 1;
    }
}
