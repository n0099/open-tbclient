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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes15.dex */
public class FrsViewData extends m implements com.baidu.tbadk.mvc.b.m, Serializable {
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

    public void updateLikeData(d dVar) {
        if (dVar != null) {
            u uVar = new u();
            uVar.setLike(1);
            uVar.EY(dVar.level);
            uVar.setLevelName(dVar.lKN);
            uVar.setCurScore(dVar.cur_score);
            uVar.setLevelupScore(dVar.levelup_score);
            updateLikeData(uVar);
        }
    }

    public void updateLikeData(u uVar) {
        if (uVar != null) {
            this.forum.setCurScore(uVar.getCurScore());
            this.forum.setLevelupScore(uVar.getLevelupScore());
            this.forum.setLike(uVar.isLike());
            this.forum.setUser_level(uVar.diA());
            this.forum.setLevelName(uVar.getLevelName());
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
        by top_notice_data;
        com.baidu.adp.widget.ListView.q qVar;
        if (getForum() != null && this.threadList != null && (top_notice_data = getForum().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (qVar = this.threadList.get(0)) != null && (qVar instanceof bu) && ((bv) qVar).aWg() == 2) {
                this.threadList.remove(0);
            }
            bv bvVar = new bv();
            bvVar.setTitle(top_notice_data.getTitle());
            bvVar.setTid(top_notice_data.aYx());
            bvVar.lc(2);
            bvVar.aXj();
            bu buVar = new bu();
            buVar.dLK = bvVar;
            this.threadList.add(0, buVar);
        }
    }

    public void addMyNewThread(ar arVar) {
        if (arVar != null && !StringUtils.isNull(arVar.getId()) && this.threadList != null) {
            int topThreadSize = getTopThreadSize();
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.q qVar = threadList.get(i);
                    if ((qVar instanceof bu) && arVar.getId().equals(((bu) qVar).dLK.getId())) {
                        return;
                    }
                }
            }
            arVar.dUu = this.isBrandForum;
            this.postThreadCount++;
            this.threadList.add(topThreadSize, arVar);
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
        ArrayList<com.baidu.adp.widget.ListView.q> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = threadList.get(i2) instanceof ar ? i + 1 : i;
                i2++;
                i = i3;
            }
        }
        return i;
    }

    private int getOperatorFlag() {
        Iterator<com.baidu.adp.widget.ListView.q> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof bv) && ((bv) next).aWi() == 1) {
                return ((bv) next).getOperatorFlag();
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
                    if (this.threadList.get(i2).getType() == bv.dRT || this.threadList.get(i2).getType() == bv.dRU || this.threadList.get(i2).getType() == bv.dRV) {
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
        if (this.threadList != null && this.threadList.size() > 0 && this.page != null && this.page.aUZ() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.q qVar = this.threadList.get(i2);
                if (qVar instanceof bu) {
                    if (((bu) qVar).dLK.getType() == bv.dRT && ((bu) qVar).dLK.aWF() != null && ((bv) qVar).aWF().user_info != null && ((bu) qVar).dLK.aWF().user_info.is_official == 2 && ((bu) qVar).dLK.aWF().liveStageForceTop) {
                        break;
                    }
                    i2++;
                } else {
                    if ((qVar instanceof bv) && ((bv) qVar).getType() == bv.dRT && ((bv) qVar).aWF() != null && ((bv) qVar).aWF().user_info != null && ((bv) qVar).aWF().user_info.is_official == 2 && ((bv) qVar).aWF().liveStageForceTop) {
                        break;
                    }
                    i2++;
                }
            }
            if (i2 < 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    com.baidu.adp.widget.ListView.q qVar2 = this.threadList.get(i3);
                    if (qVar2 instanceof bu) {
                        if (((bu) qVar2).dLK.getType() == bv.dTv) {
                            i = i3;
                            break;
                        }
                    } else {
                        if ((qVar2 instanceof bv) && ((bv) qVar2).getType() == bv.dTv) {
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
            List<com.baidu.adp.widget.ListView.q> headLineDataInThreadList = getHeadLineDataInThreadList();
            if (!com.baidu.tbadk.core.util.x.isEmpty(headLineDataInThreadList)) {
                this.threadList.removeAll(headLineDataInThreadList);
                if (topThreadSize >= 0 && topThreadSize <= this.threadList.size()) {
                    this.threadList.addAll(topThreadSize, headLineDataInThreadList);
                }
            }
        }
    }

    private List<com.baidu.adp.widget.ListView.q> getHeadLineDataInThreadList() {
        ArrayList arrayList = new ArrayList();
        if (this.threadList == null || this.threadList.size() <= 0) {
            return arrayList;
        }
        if (this.page != null && this.page.aUZ() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.q qVar = this.threadList.get(i);
                if (qVar instanceof bu) {
                    if (((bu) qVar).dLK.dUF) {
                        arrayList.add(qVar);
                    }
                } else if ((qVar instanceof bv) && ((bv) qVar).dUF) {
                    arrayList.add(qVar);
                }
            }
        }
        return arrayList;
    }

    public void addRecommendBarsToThreadList() {
        if (this.forum != null && this.threadList != null && this.threadList.size() > 0) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.threadList.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof bg) {
                    it.remove();
                }
            }
            if (this.page != null && this.page.aUZ() == 1) {
                ArrayList<RecommendForumData> recommendForumData = this.forum.getRecommendForumData();
                bg bgVar = new bg();
                if (recommendForumData != null) {
                    bgVar.aVo().addAll(recommendForumData);
                }
                if (isShowRecommendBars(bgVar.aVo())) {
                    int i = 0;
                    Iterator<com.baidu.adp.widget.ListView.q> it2 = this.threadList.iterator();
                    while (true) {
                        int i2 = i;
                        if (it2.hasNext()) {
                            com.baidu.adp.widget.ListView.q next = it2.next();
                            if ((next instanceof bu) && ((bu) next).dLK.isTop()) {
                                i2++;
                            }
                            i = i2;
                        } else {
                            this.threadList.add(i2 + 1, bgVar);
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

    public void addRecommendAppToThreadList(com.baidu.tieba.InjectPlugin.a.b bVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        addRecommendAppToThreadList(bVar, false, arrayList, null, false);
    }

    public void addRecommendAppToThreadList(com.baidu.tieba.InjectPlugin.a.b bVar, boolean z, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, ArrayList<com.baidu.adp.widget.ListView.q> arrayList2, boolean z2) {
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
                next.hI(true);
                next.setSortType(getSortType());
                arrayList3.add(next);
            }
            bVar2.bn(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.jG(z);
            bVar3.bm(arrayList);
            bVar3.bo(arrayList2);
            bVar3.jH(z2);
            bVar3.setCurrentPage(getPage().aUZ());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void addOfficialBarToThreadList() {
        boolean z = true;
        if (this.forum != null && this.threadList != null && bv.dSg.get() && this.page != null && this.page.aUZ() == 1) {
            if (this.gconAccount == null || !this.gconAccount.dkw()) {
                z = false;
            }
            if (this.fortuneBag || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof v)) {
                    this.threadList.remove(0);
                }
                v vVar = new v();
                vVar.vh(this.fortuneBag);
                vVar.NF(this.fortuneDesc);
                vVar.a(this.gconAccount);
                vVar.lc(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    com.baidu.tbadk.core.util.x.add(this.threadList, getTopThreadSize(), vVar);
                }
            }
        }
    }

    public void addU9DataToThreadList() {
        int i;
        if (this.forum != null) {
            if (((this.forum.getTopCode() != null && !StringUtils.isNull(this.forum.getTopCode().getSummary())) || (this.forum.getNewsInfo() != null && !StringUtils.isNull(this.forum.getNewsInfo().getSummary()))) && this.page != null && this.page.aUZ() == 1) {
                ab abVar = new ab();
                abVar.a(this.forum.getTopCode());
                abVar.a(this.forum.getNewsInfo());
                abVar.lc(3);
                abVar.vi(true);
                if (!com.baidu.tbadk.core.util.x.isEmpty(this.threadList)) {
                    Iterator<com.baidu.adp.widget.ListView.q> it = this.threadList.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.q next = it.next();
                        if (!(next instanceof bv)) {
                            i = i2;
                        } else if (((bv) next).aWg() != 0) {
                            if (((bv) next).aWg() == 1003) {
                                abVar.vi(false);
                            }
                            i = i2 + 1;
                        }
                        i2 = i;
                    }
                    this.threadList.add(i2, abVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.m
    public List<RecmForumInfo> getRecm_forum_list() {
        return this.recm_forum_list;
    }

    public boolean getIsBrandForum() {
        return this.isBrandForum;
    }

    public com.baidu.tieba.frs.d getBrandAdData() {
        return this.brandAdData;
    }

    private int getPhotoliveCardInsertPos(int i) {
        return Math.min((getTopThreadSize() + getPhotoLivePos()) - 1, i);
    }

    public void addStageLiveDataToThreadList() {
        h frsStageLiveData;
        if (this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null && (frsStageLiveData = getFrsStageLiveData()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = getThreadList();
            removeTopSameClassDataFromList(h.class, threadList);
            if (!com.baidu.tbadk.core.util.x.isEmpty(frsStageLiveData.lKU)) {
                threadList.add(getAlaLiveThreadCardInsertPos(1, threadList.size()), frsStageLiveData);
            }
        }
    }

    public void removeAlaStageLiveDat() {
        removeTopSameClassDataFromList(h.class, getThreadList());
    }

    public void addInsertLiveDataToThreadList() {
        g frsInsertLiveData;
        if (this.threadList != null && getForum() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null && (frsInsertLiveData = getFrsInsertLiveData()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = getThreadList();
            removeTopSameClassDataFromList(g.class, threadList);
            threadList.add(getAlaLiveThreadCardInsertPos(frsInsertLiveData.lKS, threadList.size()), frsInsertLiveData);
        }
    }

    public void removeAlaInsertLiveData() {
        removeTopSameClassDataFromList(g.class, getThreadList());
    }

    private int getAlaLiveThreadCardInsertPos(int i, int i2) {
        return Math.min((getTopThreadSize() + i) - 1, i2);
    }

    private void removeTopSameClassDataFromList(Class cls, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                com.baidu.adp.widget.ListView.q qVar = arrayList.get(i);
                if (qVar.getClass() != cls) {
                    i++;
                } else {
                    arrayList2.add(qVar);
                    break;
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.removeAll(arrayList2);
            }
        }
    }

    public void addCardVideoInfoToThreadList() {
        bv cardVideoInfo;
        if (getForum() != null && (cardVideoInfo = getCardVideoInfo()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + cardVideoInfo.getTid());
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(getPhotoliveCardInsertPos(threadList.size()), cardVideoInfo);
            }
        }
    }

    public void addVideoInfoToThreadListInTenAndFifteenFloor() {
        if (getForum() != null) {
            List<com.baidu.adp.widget.ListView.q> cardShipinNew = getCardShipinNew();
            List<Integer> cardShipinPos = getCardShipinPos();
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = getThreadList();
            if (cardShipinPos != null && cardShipinPos.size() > 0 && cardShipinNew != null && cardShipinNew.size() > 0 && threadList != null) {
                int size = cardShipinPos.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < cardShipinNew.size()) {
                        com.baidu.adp.widget.ListView.q qVar = cardShipinNew.get(i);
                        int videoThreadInserPos = getVideoThreadInserPos(cardShipinPos.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + videoThreadInserPos + "  Title:" + qVar.getType());
                        threadList.add(videoThreadInserPos, qVar);
                    }
                }
            }
        }
    }

    private int getVideoThreadInserPos(int i, int i2) {
        return Math.min((getTopThreadSize() + i) - 1, i2);
    }

    public bv getThreadDataById(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.q> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if (next != null && (next instanceof bu) && TextUtils.equals(str, ((bu) next).dLK.getId())) {
                return ((bu) next).dLK;
            }
        }
        return null;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (this.threadList != null && lVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.q> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next != null && (next instanceof bu) && ((bu) next).dLK.aWl() != null && currentAccount.equals(((bu) next).dLK.aWl().getUserId()) && ((bu) next).dLK.aWl().getPendantData() != null) {
                        ((bu) next).dLK.aWl().getPendantData().cN(lVar.bin());
                        ((bu) next).dLK.aWl().getPendantData().wU(lVar.aUh());
                    }
                }
            }
        }
    }

    public void removeThreadData(bv bvVar) {
        this.threadList.remove(bvVar);
    }

    public void removeThread(String str) {
        if (this.threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.q next = it.next();
                if (next != null && (next instanceof bu) && TextUtils.equals(str, ((bu) next).dLK.getId())) {
                    it.remove();
                }
            }
        }
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
        com.baidu.tieba.frs.b.caw().b(getAnti());
        com.baidu.tieba.frs.b.caw().setForumId(mVar.getForum().getId());
        com.baidu.tieba.frs.a.cap().setForumId(mVar.getForum().getId());
        if (mVar.getEntelechyTabInfo() != null) {
            com.baidu.tieba.frs.a.cap().cz(mVar.getEntelechyTabInfo().tab);
        }
        if (mVar.getUserData() != null) {
            com.baidu.tieba.frs.c.caA().a(mVar.getUserData().bawuThrones);
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
                com.baidu.adp.widget.ListView.q qVar = this.threadList.get(i2);
                if (qVar instanceof bu) {
                    bv bvVar = ((bu) qVar).dLK;
                    if (bvVar == null || (!bvVar.isTop() && bvVar.aWi() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.forum.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                l lVar = new l();
                lVar.setForumId(this.forum.getId());
                lVar.eV(feedForumList);
                this.threadList.add(i + 6, lVar);
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
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.threadList)) {
            removeGameRankListFromThreadList();
            if (getGameRankListData() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.q qVar = this.threadList.get(i2);
                    if (qVar instanceof bu) {
                        bv bvVar = ((bu) qVar).dLK;
                        if (bvVar == null || (!bvVar.isTop() && bvVar.aWi() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((getGameRankListData().ckr() + i) - 1 < this.threadList.size()) {
                    String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.GAME_RANK_LIST_INFO, "");
                    if (StringUtils.isNull(string) || string.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length != 2) {
                        z2 = true;
                    } else {
                        z2 = UtilHelper.getDayBetweenTime(com.baidu.adp.lib.f.b.toLong(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0], 0L), System.currentTimeMillis()) >= ((long) com.baidu.adp.lib.f.b.toInt(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1], 0));
                    }
                    if (z2) {
                        int i3 = com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.GAME_RANK_LIST_SHOW_TIMES, 0);
                        if (!z) {
                            i3++;
                        }
                        com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.GAME_RANK_LIST_SHOW_TIMES, i3);
                        if (i3 > 3) {
                            com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.GAME_RANK_LIST_INFO, System.currentTimeMillis() + ",1");
                            com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.GAME_RANK_LIST_SHOW_TIMES, 0);
                            if (!z3) {
                                this.threadList.add((getGameRankListData().ckr() + i) - 1, getGameRankListData());
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
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.q next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.h.b.imK) {
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
            com.baidu.adp.widget.ListView.q qVar = this.threadList.get(i2);
            if (qVar instanceof bu) {
                bv bvVar = ((bu) qVar).dLK;
                if (bvVar == null || (!bvVar.isTop() && bvVar.aWi() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.forum.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.x.getCount(recomTopicData.haI) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ap(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW).dn("uid", TbadkCoreApplication.getCurrentAccount()));
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
        int aXz;
        if (getUserRecommend() != null) {
            com.baidu.tieba.frs.x userRecommend = getUserRecommend();
            if (com.baidu.tbadk.core.util.x.getCount(userRecommend.getUserInfo()) >= 3 && (aXz = userRecommend.aXz()) > 0) {
                int topThreadSize = aXz + getTopThreadSize();
                if (topThreadSize > this.threadList.size()) {
                    this.threadList.add(userRecommend);
                } else {
                    this.threadList.add(topThreadSize, userRecommend);
                }
            }
        }
    }

    public void removeRedundantUserRecommendData() {
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.threadList)) {
            boolean z = false;
            Iterator<com.baidu.adp.widget.ListView.q> it = this.threadList.iterator();
            while (true) {
                boolean z2 = z;
                if (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.x) {
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
        if (getFrsVideoActivityData() != null && !com.baidu.tbadk.core.util.x.isEmpty(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q next = it.next();
                if (next != null && next.getType() == o.lLO) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, getFrsVideoActivityData());
        }
    }

    public List<com.baidu.adp.widget.ListView.q> getTopThreadList() {
        return this.topThreadList;
    }

    public void setTopThreadList(List<com.baidu.adp.widget.ListView.q> list) {
        this.topThreadList = list;
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.q> it = this.threadList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.q next = it.next();
                if (!(next instanceof bv)) {
                    i = i2;
                } else if (((bv) next).aWg() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    protected void filterEnterList(List<k> list) {
        if (list != null && list.size() != 0) {
            Iterator<k> it = list.iterator();
            while (it.hasNext()) {
                k next = it.next();
                if (next == null) {
                    it.remove();
                } else if (StringUtils.isNull(next.getUrl()) || StringUtils.isNull(next.getTitle())) {
                    if (next.dko() != 1) {
                        it.remove();
                    }
                }
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.q> getShowTopThreadList() {
        List<k> list;
        int i;
        ArrayList arrayList = new ArrayList();
        if (com.baidu.tbadk.core.util.x.isEmpty(getStarEnter())) {
            list = null;
        } else {
            List<k> starEnter = getStarEnter();
            filterEnterList(starEnter);
            list = starEnter;
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2).dko() == 1) {
                    arrayList.add(list.get(i2));
                }
            }
        }
        List<com.baidu.adp.widget.ListView.q> topThreadList = getTopThreadList();
        if (topThreadList != null) {
            int i3 = 3;
            int i4 = 0;
            while (i4 < com.baidu.tbadk.core.util.x.getCount(topThreadList) && arrayList.size() < i3) {
                com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.x.getItem(topThreadList, i4);
                if (qVar instanceof bu) {
                    arrayList.add(((bu) qVar).dLK);
                    if (((bu) qVar).dLK.aWf() == 1) {
                        i3 = 4;
                    } else if (getForum() != null && getForum().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                        break;
                    }
                    i = i3;
                    i4++;
                    i3 = i;
                } else {
                    if (qVar instanceof bv) {
                        arrayList.add(qVar);
                        if (((bv) qVar).aWf() == 1) {
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
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                if (list.get(i5).dko() != 1) {
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
        return getStar().dku() == 1;
    }

    public boolean hasTab() {
        return (getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.x.isEmpty(getEntelechyTabInfo().tab)) ? false : true;
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
