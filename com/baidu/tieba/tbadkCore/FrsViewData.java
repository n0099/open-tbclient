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
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.tbadkCore.e;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.AnchorPower;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.NebulaHotThreads;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class FrsViewData extends j implements com.baidu.tbadk.mvc.b.l, Serializable {
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

    public void updateLikeData(e.a aVar) {
        if (aVar != null) {
            r rVar = new r();
            rVar.setLike(1);
            rVar.yY(aVar.level);
            rVar.setLevelName(aVar.iDz);
            rVar.setCurScore(aVar.cur_score);
            rVar.setLevelupScore(aVar.levelup_score);
            updateLikeData(rVar);
        }
    }

    public void updateLikeData(r rVar) {
        if (rVar != null) {
            this.forum.setCurScore(rVar.getCurScore());
            this.forum.setLevelupScore(rVar.getLevelupScore());
            this.forum.setLike(rVar.isLike());
            this.forum.setUser_level(rVar.cbW());
            this.forum.setLevelName(rVar.getLevelName());
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
        bj top_notice_data;
        com.baidu.adp.widget.ListView.m mVar;
        if (getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (mVar = this.threadList.get(0)) != null && (mVar instanceof bf) && ((bg) mVar).YJ() == 2) {
                this.threadList.remove(0);
            }
            bg bgVar = new bg();
            bgVar.setTitle(top_notice_data.getTitle());
            bgVar.setTid(top_notice_data.aaK());
            bgVar.gs(2);
            bgVar.ZE();
            bf bfVar = new bf();
            bfVar.threadData = bgVar;
            this.threadList.add(0, bfVar);
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
                    if ((mVar instanceof bf) && akVar.getId().equals(((bf) mVar).threadData.getId())) {
                        return;
                    }
                }
            }
            akVar.bDI = this.isBrandForum;
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
    private boolean aC(ArrayList<RecommendForumData> arrayList) {
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
                    if (this.threadList.get(i2).getType() == bg.bBh || this.threadList.get(i2).getType() == bg.bBi || this.threadList.get(i2).getType() == bg.bBj) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void updateInterviewTaskInfoDataInThreadList() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.page != null && this.page.XF() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.threadList.get(i2);
                if ((mVar instanceof bf) && ((bf) mVar).threadData.getType() == bg.bCD) {
                    i = i2;
                    break;
                }
                i2++;
            }
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
                if (it.next() instanceof aw) {
                    it.remove();
                }
            }
            if (this.page != null && this.page.XF() == 1) {
                ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
                aw awVar = new aw();
                if (recommendForumData != null) {
                    awVar.XV().addAll(recommendForumData);
                }
                if (aC(awVar.XV())) {
                    int i = 0;
                    Iterator<com.baidu.adp.widget.ListView.m> it2 = this.threadList.iterator();
                    while (true) {
                        int i2 = i;
                        if (it2.hasNext()) {
                            com.baidu.adp.widget.ListView.m next = it2.next();
                            if ((next instanceof bf) && ((bf) next).threadData.Zv()) {
                                i2++;
                            }
                            i = i2;
                        } else {
                            this.threadList.add(i2 + 1, awVar);
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
            bVar2.ap(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.fA(z);
            bVar3.ao(arrayList);
            bVar3.aq(arrayList2);
            bVar3.fB(z2);
            bVar3.setCurrentPage(getPage().XF());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    public void addOfficialBarToThreadList() {
        boolean z = true;
        if (this.forum != null && this.threadList != null && bg.bBq.get() && this.page != null && this.page.XF() == 1) {
            if (this.gconAccount == null || !this.gconAccount.cdA()) {
                z = false;
            }
            if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof s)) {
                    this.threadList.remove(0);
                }
                s sVar = new s();
                sVar.pS(this.fortuneBag);
                sVar.Cr(this.fortuneDesc);
                sVar.a(this.gconAccount);
                sVar.gs(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    com.baidu.tbadk.core.util.v.a(this.threadList, getTopThreadSize(), sVar);
                }
            }
        }
    }

    public void addU9DataToThreadList() {
        int i;
        if (this.forum != null) {
            if (((this.forum.getTopCode() != null && !StringUtils.isNull(this.forum.getTopCode().getSummary())) || (this.forum.getNewsInfo() != null && !StringUtils.isNull(this.forum.getNewsInfo().getSummary()))) && this.page != null && this.page.XF() == 1) {
                v vVar = new v();
                vVar.a(this.forum.getTopCode());
                vVar.a(this.forum.getNewsInfo());
                vVar.gs(3);
                vVar.pT(true);
                if (!com.baidu.tbadk.core.util.v.T(this.threadList)) {
                    Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.m next = it.next();
                        if (!(next instanceof bg)) {
                            i = i2;
                        } else if (((bg) next).YJ() != 0) {
                            if (((bg) next).YJ() == 1003) {
                                vVar.pT(false);
                            }
                            i = i2 + 1;
                        }
                        i2 = i;
                    }
                    this.threadList.add(i2, vVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.j
    public List<RecmForumInfo> getRecm_forum_list() {
        return this.recm_forum_list;
    }

    public boolean getIsBrandForum() {
        return this.isBrandForum;
    }

    public com.baidu.tieba.frs.b getBrandAdData() {
        return this.brandAdData;
    }

    private int zl(int i) {
        return Math.min((getTopThreadSize() + getPhotoLivePos()) - 1, i);
    }

    public void addStageLiveDataToThreadList() {
        g frsStageLiveData;
        if (this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(2911003) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = getThreadList();
            a(g.class, threadList);
            if (!com.baidu.tbadk.core.util.v.T(frsStageLiveData.iDG)) {
                threadList.add(cl(1, threadList.size()), frsStageLiveData);
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
            threadList.add(cl(frsInsertLiveData.iDE, threadList.size()), frsInsertLiveData);
        }
    }

    public void removeAlaInsertLiveData() {
        a(f.class, getThreadList());
    }

    private int cl(int i, int i2) {
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
        bg cardVideoInfo;
        if (getForum() != null && (cardVideoInfo = getCardVideoInfo()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + cardVideoInfo.getTid());
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(zl(threadList.size()), cardVideoInfo);
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
                        int cm = cm(cardShipinPos.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + cm + "  Title:" + mVar.getType());
                        threadList.add(cm, mVar);
                    }
                }
            }
        }
    }

    private int cm(int i, int i2) {
        return Math.min((getTopThreadSize() + i) - 1, i2);
    }

    public bg getThreadDataById(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if (next != null && (next instanceof bf) && TextUtils.equals(str, ((bf) next).threadData.getId())) {
                return ((bf) next).threadData;
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
                    if (next != null && (next instanceof bf) && ((bf) next).threadData.YO() != null && currentAccount.equals(((bf) next).threadData.YO().getUserId()) && ((bf) next).threadData.YO().getPendantData() != null) {
                        ((bf) next).threadData.YO().getPendantData().aR(lVar.alu());
                        ((bf) next).threadData.YO().getPendantData().lg(lVar.Xk());
                    }
                }
            }
        }
    }

    public void removeThreadData(bg bgVar) {
        this.threadList.remove(bgVar);
    }

    public void removeThread(String str) {
        if (this.threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next != null && (next instanceof bf) && TextUtils.equals(str, ((bf) next).threadData.getId())) {
                    it.remove();
                }
            }
        }
    }

    public boolean receiveData(j jVar) {
        if (jVar == null) {
            return false;
        }
        setAnti(jVar.getAnti());
        setChatGroup(jVar.getChatGroup());
        setFortuneBag(jVar.isFortuneBag());
        setFortuneDesc(jVar.getFortuneDesc());
        setForum(jVar.getForum());
        setGameName(jVar.getGameName());
        setGameUrl(jVar.getGameUrl());
        setGconAccount(jVar.getGconAccount());
        setHasGame(jVar.isHasGame());
        setIsNewUrl(jVar.getIsNewUrl());
        setPhotoLivePos(jVar.getPhotoLivePos());
        setPage(jVar.getPage());
        setStar(jVar.getStar());
        setStarEnter(jVar.getStarEnter());
        setThreadList(jVar.threadList);
        setThreadListIds(jVar.getThreadListIds());
        setUserData(jVar.getUserData());
        setUserMap(jVar.getUserMap());
        setActivityHeadData(jVar.getActivityHeadData());
        setFrsDefaultTabId(jVar.getFrsDefaultTabId());
        this.defaultShowTab = jVar.defaultShowTab;
        setCategoryInfos(jVar.getCategoryInfos());
        setBawuCenterUrl(jVar.getBawuCenterUrl());
        setCardVideoInfo(jVar.getCardVideoInfo());
        setHeadSdkData(jVar.getHeadSdkData());
        setSchoolRecommendPos(jVar.getSchoolRecommendPos());
        setSchoolRecommendInfo(jVar.getSchoolRecommendUserInfo());
        setEntelechyTabInfo(jVar.getEntelechyTabInfo());
        setAlaLiveCount(jVar.getAlaLiveCount());
        setCarrierEnterData(jVar.getCarrierEnterData());
        setForumState(jVar.getForumState());
        setAccessFlag(jVar.getAccessFlag());
        this.needLog = jVar.needLog;
        this.recommendBookData = jVar.recommendBookData;
        this.presentInfoData = jVar.presentInfoData;
        setBookInfo(jVar.getBookInfo());
        setMangaReadRecordChapterId(jVar.getMangaReadRecordChapterId());
        setHeadlineImgInfoData(jVar.getHeadlineImgInfoData());
        setCardShipinPos(jVar.getCardShipinPos());
        setCardShipinNew(jVar.getCardShipinNew());
        this.enterFrsDialogInfo = jVar.enterFrsDialogInfo;
        setGameRankListData(jVar.getGameRankListData());
        setAgreeBanner(jVar.getAgreeBanner());
        setLiveNotify(jVar.getLiveNotify());
        setGameTabInfo(jVar.getGameTabInfo());
        setGameDefaultTabId(jVar.getGameDefaultTabId());
        setForumHeadIcon(jVar.getForumHeadIcon());
        setUserRecommend(jVar.getUserRecommend());
        setFrsVideoActivityData(jVar.getFrsVideoActivityData());
        this.mNewChapterInfo = jVar.mNewChapterInfo;
        setFrsInsertLiveData(jVar.getFrsInsertLiveData());
        this.recm_forum_list = jVar.getRecm_forum_list();
        setFrsStageLiveData(jVar.getFrsStageLiveData());
        this.forumArIno = jVar.forumArIno;
        this.starRank = jVar.starRank;
        this.postTopic = jVar.postTopic;
        this.mWindowToast = jVar.mWindowToast;
        this.activityConfig = jVar.activityConfig;
        setIsShowRedTip(jVar.isShowRedTip());
        this.isBrandForum = jVar.isBrandForum;
        this.brandAdData = jVar.brandAdData;
        this.oriForumInfoList = jVar.oriForumInfoList;
        this.bottomMenuList = jVar.bottomMenuList;
        com.baidu.tieba.frs.a.bbD().b(getAnti());
        com.baidu.tieba.frs.a.bbD().setForumId(jVar.getForum().getId());
        setRedpacketRainData(jVar.getRedpacketRainData());
        setPrivateForumTotalInfo(jVar.getPrivateForumTotalInfo());
        this.isFrsVideoAutoPlay = jVar.isFrsVideoAutoPlay;
        this.smartAppAvatar = jVar.smartAppAvatar;
        this.smartApp = jVar.smartApp;
        this.nebulaHotThreads = jVar.nebulaHotThreads;
        return true;
    }

    public NebulaHotThreads getYouhuaHotThreads() {
        return this.nebulaHotThreads;
    }

    public void addFeedForumDataToThreadList() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.forum != null && this.forum.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.m mVar = this.threadList.get(i2);
                if (mVar instanceof bf) {
                    bg bgVar = ((bf) mVar).threadData;
                    if (bgVar == null || (!bgVar.Zv() && bgVar.YL() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                i iVar = new i();
                iVar.setForumId(this.forum.getId());
                iVar.dR(feedForumList);
                this.threadList.add(i + 6, iVar);
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
        if (!com.baidu.tbadk.core.util.v.T(this.threadList)) {
            removeGameRankListFromThreadList();
            if (getGameRankListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.m mVar = this.threadList.get(i2);
                    if (mVar instanceof bf) {
                        bg bgVar = ((bf) mVar).threadData;
                        if (bgVar == null || (!bgVar.Zv() && bgVar.YL() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((getGameRankListData().bkq() + i) - 1 < this.threadList.size()) {
                    String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("game_rank_list_info", "");
                    if (StringUtils.isNull(string) || string.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length != 2) {
                        z2 = true;
                    } else {
                        z2 = UtilHelper.getDayBetweenTime(com.baidu.adp.lib.g.b.d(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0], 0L), System.currentTimeMillis()) >= ((long) com.baidu.adp.lib.g.b.l(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1], 0));
                    }
                    if (z2) {
                        int i3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("game_rank_list_show_times", 0);
                        if (!z) {
                            i3++;
                        }
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("game_rank_list_show_times", i3);
                        if (i3 > 3) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("game_rank_list_info", System.currentTimeMillis() + ",1");
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("game_rank_list_show_times", 0);
                            if (!z3) {
                                this.threadList.add((getGameRankListData().bkq() + i) - 1, getGameRankListData());
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
        if (!com.baidu.tbadk.core.util.v.T(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.h.b.fAw) {
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
            if (mVar instanceof bf) {
                bg bgVar = ((bf) mVar).threadData;
                if (bgVar == null || (!bgVar.Zv() && bgVar.YL() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.forum.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.S(recomTopicData.elI) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new am("c10835").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
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
        int ZV;
        if (getUserRecommend() != null) {
            com.baidu.tieba.frs.q userRecommend = getUserRecommend();
            if (com.baidu.tbadk.core.util.v.S(userRecommend.getUserInfo()) >= 3 && (ZV = userRecommend.ZV()) > 0) {
                int topThreadSize = ZV + getTopThreadSize();
                if (topThreadSize > this.threadList.size()) {
                    this.threadList.add(userRecommend);
                } else {
                    this.threadList.add(topThreadSize, userRecommend);
                }
            }
        }
    }

    public void removeRedundantUserRecommendData() {
        if (!com.baidu.tbadk.core.util.v.T(this.threadList)) {
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
        if (getFrsVideoActivityData() != null && !com.baidu.tbadk.core.util.v.T(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next != null && next.getType() == l.iEz) {
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
                if (!(next instanceof bg)) {
                    i = i2;
                } else if (((bg) next).YJ() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    protected void filterEnterList(List<h> list) {
        if (list != null && list.size() != 0) {
            Iterator<h> it = list.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next == null || StringUtils.isNull(next.getIcon()) || StringUtils.isNull(next.getTitle()) || StringUtils.isNull(next.getUrl())) {
                    it.remove();
                }
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getShowTopThreadList() {
        List<h> list;
        int i;
        ArrayList arrayList = new ArrayList();
        if (com.baidu.tbadk.core.util.v.T(getStarEnter())) {
            list = null;
        } else {
            List<h> starEnter = getStarEnter();
            filterEnterList(starEnter);
            list = starEnter;
        }
        if (!com.baidu.tbadk.core.util.v.T(list)) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2).cdt() == 1) {
                    arrayList.add(list.get(i2));
                }
            }
        }
        List<com.baidu.adp.widget.ListView.m> topThreadList = getTopThreadList();
        if (topThreadList != null) {
            int i3 = 3;
            int i4 = 0;
            while (i4 < com.baidu.tbadk.core.util.v.S(topThreadList) && arrayList.size() < i3) {
                com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(topThreadList, i4);
                if (mVar instanceof bf) {
                    arrayList.add(((bf) mVar).threadData);
                    if (((bf) mVar).threadData.YI() == 1) {
                        i3 = 4;
                    } else if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                        break;
                    }
                    i = i3;
                    i4++;
                    i3 = i;
                } else {
                    if (mVar instanceof bg) {
                        arrayList.add(mVar);
                        if (((bg) mVar).YI() == 1) {
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
        if (!com.baidu.tbadk.core.util.v.T(list)) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                if (list.get(i5).cdt() != 1) {
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
        return getStar().cdy() == 1;
    }

    public boolean hasTab() {
        return (getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.v.T(getEntelechyTabInfo().tab)) ? false : true;
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
