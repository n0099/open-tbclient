package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.RecommendForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bm;
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
/* loaded from: classes8.dex */
public class FrsViewData extends l implements com.baidu.tbadk.mvc.b.l, Serializable {
    public ForumActiveInfo forumActiveInfo;
    public int frsCurrentTabId;
    public boolean isBrandForum;
    public boolean isFrsVideoAutoPlay;
    private boolean isLoadMore;
    private BannerListData loadMoreBannerListData;
    private NebulaHotThreads nebulaHotThreads;
    private List<RecmForumInfo> recm_forum_list;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    public List<User> userList;
    private int postThreadCount = 0;
    public int mHeadLineDefaultNavTabId = -1;

    public void updateLikeData(e.a aVar) {
        if (aVar != null) {
            t tVar = new t();
            tVar.setLike(1);
            tVar.Cg(aVar.level);
            tVar.setLevelName(aVar.ket);
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
            this.forum.setUser_level(tVar.cIL());
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
        bm top_notice_data;
        com.baidu.adp.widget.ListView.m mVar;
        if (getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (mVar = this.threadList.get(0)) != null && (mVar instanceof bi) && ((bj) mVar).aCj() == 2) {
                this.threadList.remove(0);
            }
            bj bjVar = new bj();
            bjVar.setTitle(top_notice_data.getTitle());
            bjVar.setTid(top_notice_data.aEs());
            bjVar.jL(2);
            bjVar.aDj();
            bi biVar = new bi();
            biVar.cRg = bjVar;
            this.threadList.add(0, biVar);
        }
    }

    public void addMyNewThread(am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.m mVar = threadList.get(i);
                    if ((mVar instanceof bi) && amVar.getId().equals(((bi) mVar).cRg.getId())) {
                        return;
                    }
                }
            }
            amVar.cUc = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, amVar);
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
                int i3 = threadList.get(i2) instanceof am ? i + 1 : i;
                i2++;
                i = i3;
            }
        }
        return i;
    }

    private int getOperatorFlag() {
        Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if ((next instanceof bj) && ((bj) next).aCl() == 1) {
                return ((bj) next).getOperatorFlag();
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0016  */
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

    public void removeAlaLiveThreadData() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bj.cRB || this.threadList.get(i2).getType() == bj.cRC || this.threadList.get(i2).getType() == bj.cRD) {
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
        if (this.threadList != null && this.threadList.size() > 0 && this.page != null && this.page.aBi() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.threadList.get(i2);
                if (mVar instanceof bi) {
                    if (((bi) mVar).cRg.getType() == bj.cRB && ((bi) mVar).cRg.aCH() != null && ((bj) mVar).aCH().user_info != null && ((bi) mVar).cRg.aCH().user_info.is_official == 2 && ((bi) mVar).cRg.aCH().liveStageForceTop) {
                        break;
                    }
                    i2++;
                } else {
                    if ((mVar instanceof bj) && ((bj) mVar).getType() == bj.cRB && ((bj) mVar).aCH() != null && ((bj) mVar).aCH().user_info != null && ((bj) mVar).aCH().user_info.is_official == 2 && ((bj) mVar).aCH().liveStageForceTop) {
                        break;
                    }
                    i2++;
                }
            }
            if (i2 < 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    com.baidu.adp.widget.ListView.m mVar2 = this.threadList.get(i3);
                    if (mVar2 instanceof bi) {
                        if (((bi) mVar2).cRg.getType() == bj.cTe) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((mVar2 instanceof bj) && ((bj) mVar2).getType() == bj.cTe) {
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
            List<com.baidu.adp.widget.ListView.m> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    private List<com.baidu.adp.widget.ListView.m> getHeadLineDataInThreadList() {
        ArrayList arrayList = new ArrayList();
        if (this.threadList == null || this.threadList.size() <= 0) {
            return arrayList;
        }
        if (this.page != null && this.page.aBi() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = this.threadList.get(i);
                if (mVar instanceof bi) {
                    if (((bi) mVar).cRg.cUn) {
                        arrayList.add(mVar);
                    }
                } else if ((mVar instanceof bj) && ((bj) mVar).cUn) {
                    arrayList.add(mVar);
                }
            }
        }
        return arrayList;
    }

    public void addRecommendBarsToThreadList() {
        if (this.forum != null && this.threadList != null && this.threadList.size() > 0) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof az) {
                    it.remove();
                }
            }
            if (this.page != null && this.page.aBi() == 1) {
                ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
                az azVar = new az();
                if (recommendForumData != null) {
                    azVar.aBx().addAll(recommendForumData);
                }
                if (isShowRecommendBars(azVar.aBx())) {
                    int i = 0;
                    Iterator<com.baidu.adp.widget.ListView.m> it2 = this.threadList.iterator();
                    while (true) {
                        int i2 = i;
                        if (it2.hasNext()) {
                            com.baidu.adp.widget.ListView.m next = it2.next();
                            if ((next instanceof bi) && ((bi) next).cRg.isTop()) {
                                i2++;
                            }
                            i = i2;
                        } else {
                            this.threadList.add(i2 + 1, azVar);
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
                AdvertAppInfo next = it.next();
                next.fF(true);
                next.setSortType(getSortType());
                arrayList3.add(next);
            }
            bVar2.aU(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.ht(z);
            bVar3.aT(arrayList);
            bVar3.aV(arrayList2);
            bVar3.hu(z2);
            bVar3.setCurrentPage(getPage().aBi());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void addOfficialBarToThreadList() {
        boolean z = true;
        if (this.forum != null && this.threadList != null && bj.cRO.get() && this.page != null && this.page.aBi() == 1) {
            if (this.gconAccount == null || !this.gconAccount.cKr()) {
                z = false;
            }
            if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof u)) {
                    this.threadList.remove(0);
                }
                u uVar = new u();
                uVar.sI(this.fortuneBag);
                uVar.IW(this.fortuneDesc);
                uVar.a(this.gconAccount);
                uVar.jL(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    com.baidu.tbadk.core.util.v.add(this.threadList, getTopThreadSize(), uVar);
                }
            }
        }
    }

    public void addU9DataToThreadList() {
        int i;
        if (this.forum != null) {
            if (((this.forum.getTopCode() != null && !StringUtils.isNull(this.forum.getTopCode().getSummary())) || (this.forum.getNewsInfo() != null && !StringUtils.isNull(this.forum.getNewsInfo().getSummary()))) && this.page != null && this.page.aBi() == 1) {
                x xVar = new x();
                xVar.a(this.forum.getTopCode());
                xVar.a(this.forum.getNewsInfo());
                xVar.jL(3);
                xVar.sJ(true);
                if (!com.baidu.tbadk.core.util.v.isEmpty(this.threadList)) {
                    Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.m next = it.next();
                        if (!(next instanceof bj)) {
                            i = i2;
                        } else if (((bj) next).aCj() != 0) {
                            if (((bj) next).aCj() == 1003) {
                                xVar.sJ(false);
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

    private int getPhotoliveCardInsertPos(int i) {
        return Math.min((getTopThreadSize() + getPhotoLivePos()) - 1, i);
    }

    public void addStageLiveDataToThreadList() {
        g frsStageLiveData;
        if (this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = getThreadList();
            removeTopSameClassDataFromList(g.class, threadList);
            if (!com.baidu.tbadk.core.util.v.isEmpty(frsStageLiveData.keA)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void removeAlaStageLiveDat() {
        removeTopSameClassDataFromList(g.class, getThreadList());
    }

    public void addInsertLiveDataToThreadList() {
        f frsInsertLiveData;
        if (this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = getThreadList();
            removeTopSameClassDataFromList(f.class, threadList);
            threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.kex, threadList.size()), frsInsertLiveData);
        }
    }

    public void removeAlaInsertLiveData() {
        removeTopSameClassDataFromList(f.class, getThreadList());
    }

    private int getAlaLiveThreadCardInsertPos(int i, int i2) {
        return Math.min((getTopThreadSize() + i) - 1, i2);
    }

    private void removeTopSameClassDataFromList(Class cls, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
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
        bj cardVideoInfo;
        if (getForum() != null && (cardVideoInfo = getCardVideoInfo()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + cardVideoInfo.getTid());
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
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
                        int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + mVar.getType());
                        threadList.add(videoThreadInserPos, mVar);
                    }
                }
            }
        }
    }

    private int getVideoThreadInserPos(int i, int i2) {
        return Math.min((getTopThreadSize() + i) - 1, i2);
    }

    public bj getThreadDataById(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if (next != null && (next instanceof bi) && TextUtils.equals(str, ((bi) next).cRg.getId())) {
                return ((bi) next).cRg;
            }
        }
        return null;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.m mVar) {
        if (this.threadList != null && mVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next != null && (next instanceof bi) && ((bi) next).cRg.aCo() != null && currentAccount.equals(((bi) next).cRg.aCo().getUserId()) && ((bi) next).cRg.aCo().getPendantData() != null) {
                        ((bi) next).cRg.aCo().getPendantData().bI(mVar.aNZ());
                        ((bi) next).cRg.aCo().getPendantData().sB(mVar.aAG());
                    }
                }
            }
        }
    }

    public void removeThreadData(bj bjVar) {
        this.threadList.remove(bjVar);
    }

    public void removeThread(String str) {
        if (this.threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next != null && (next instanceof bi) && TextUtils.equals(str, ((bi) next).cRg.getId())) {
                    it.remove();
                }
            }
        }
    }

    public boolean receiveData(l lVar) {
        if (lVar == null) {
            return false;
        }
        setSortType(lVar.getSortType());
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
        com.baidu.tieba.frs.a.bCW().b(getAnti());
        com.baidu.tieba.frs.a.bCW().setForumId(lVar.getForum().getId());
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
        if (this.threadList != null && this.forum != null && this.forum.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.m mVar = this.threadList.get(i2);
                if (mVar instanceof bi) {
                    bj bjVar = ((bi) mVar).cRg;
                    if (bjVar == null || (!bjVar.isTop() && bjVar.aCl() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                k kVar = new k();
                kVar.setForumId(this.forum.getId());
                kVar.ed(feedForumList);
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
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.threadList)) {
            removeGameRankListFromThreadList();
            if (getGameRankListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.m mVar = this.threadList.get(i2);
                    if (mVar instanceof bi) {
                        bj bjVar = ((bi) mVar).cRg;
                        if (bjVar == null || (!bjVar.isTop() && bjVar.aCl() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((getGameRankListData().bMa() + i) - 1 < this.threadList.size()) {
                    String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.GAME_RANK_LIST_INFO, "");
                    if (StringUtils.isNull(string) || string.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length != 2) {
                        z2 = true;
                    } else {
                        z2 = UtilHelper.getDayBetweenTime(com.baidu.adp.lib.f.b.toLong(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0], 0L), System.currentTimeMillis()) >= ((long) com.baidu.adp.lib.f.b.toInt(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1], 0));
                    }
                    if (z2) {
                        int i3 = com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.GAME_RANK_LIST_SHOW_TIMES, 0);
                        if (!z) {
                            i3++;
                        }
                        com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.GAME_RANK_LIST_SHOW_TIMES, i3);
                        if (i3 > 3) {
                            com.baidu.tbadk.core.sharedPref.b.aFD().putString(SharedPrefConfig.GAME_RANK_LIST_INFO, System.currentTimeMillis() + ",1");
                            com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.GAME_RANK_LIST_SHOW_TIMES, 0);
                            if (!z3) {
                                this.threadList.add((getGameRankListData().bMa() + i) - 1, getGameRankListData());
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
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.h.b.gRK) {
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
            if (mVar instanceof bi) {
                bj bjVar = ((bi) mVar).cRg;
                if (bjVar == null || (!bjVar.isTop() && bjVar.aCl() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.forum.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.getCount(recomTopicData.fNN) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new an(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW).cy("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void addSchoolRecommendToThreadList() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int schoolRecommendPos = (getSchoolRecommendPos() + getTopThreadSize()) - 1;
            if (getSchoolRecommendUserInfo() != null && schoolRecommendPos >= 0 && schoolRecommendPos <= this.threadList.size()) {
                this.threadList.add(schoolRecommendPos, getSchoolRecommendUserInfo());
            }
        }
    }

    public void addUserRecommendToThreadList() {
        int aDy;
        if (getUserRecommend() != null) {
            com.baidu.tieba.frs.r userRecommend = getUserRecommend();
            if (com.baidu.tbadk.core.util.v.getCount(userRecommend.getUserInfo()) >= 3 && (aDy = userRecommend.aDy()) > 0) {
                int topThreadSize = aDy + getTopThreadSize();
                if (topThreadSize > this.threadList.size()) {
                    this.threadList.add(userRecommend);
                } else {
                    this.threadList.add(topThreadSize, userRecommend);
                }
            }
        }
    }

    public void removeRedundantUserRecommendData() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.threadList)) {
            boolean z = false;
            Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
            while (true) {
                boolean z2 = z;
                if (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.r) {
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
        if (getFrsVideoActivityData() != null && !com.baidu.tbadk.core.util.v.isEmpty(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next != null && next.getType() == n.kfv) {
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
                if (!(next instanceof bj)) {
                    i = i2;
                } else if (((bj) next).aCj() != 0) {
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
                    if (next.cKj() != 1) {
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
        if (com.baidu.tbadk.core.util.v.isEmpty(getStarEnter())) {
            list = null;
        } else {
            List<j> starEnter = getStarEnter();
            filterEnterList(starEnter);
            list = starEnter;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2).cKj() == 1) {
                    arrayList.add(list.get(i2));
                }
            }
        }
        List<com.baidu.adp.widget.ListView.m> topThreadList = getTopThreadList();
        if (topThreadList != null) {
            int i3 = 3;
            int i4 = 0;
            while (i4 < com.baidu.tbadk.core.util.v.getCount(topThreadList) && arrayList.size() < i3) {
                com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(topThreadList, i4);
                if (mVar instanceof bi) {
                    arrayList.add(((bi) mVar).cRg);
                    if (((bi) mVar).cRg.aCi() == 1) {
                        i3 = 4;
                    } else if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                        break;
                    }
                    i = i3;
                    i4++;
                    i3 = i;
                } else {
                    if (mVar instanceof bj) {
                        arrayList.add(mVar);
                        if (((bj) mVar).aCi() == 1) {
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
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                if (list.get(i5).cKj() != 1) {
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
        return getStar().cKp() == 1;
    }

    public boolean hasTab() {
        return (getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.v.isEmpty(getEntelechyTabInfo().tab)) ? false : true;
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
