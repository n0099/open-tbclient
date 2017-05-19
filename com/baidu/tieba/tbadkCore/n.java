package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class n extends l implements com.baidu.tbadk.mvc.b.l {
    private int fsS = 0;
    private boolean fsT;
    private BannerListData fsU;

    public void c(t tVar) {
        if (tVar != null) {
            this.ecV.setCurScore(tVar.getCurScore());
            this.ecV.setLevelupScore(tVar.getLevelupScore());
            this.ecV.setLike(tVar.isLike());
            this.ecV.setUser_level(tVar.getUserLevel());
            this.ecV.setLevelName(tVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.ecV.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.ecV == null) {
            return null;
        }
        return this.ecV.getSignData();
    }

    public void bfB() {
        bo top_notice_data;
        com.baidu.adp.widget.ListView.v vVar;
        if (aHE() != null && this.threadList != null && (top_notice_data = aHE().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (vVar = this.threadList.get(0)) != null && (vVar instanceof bk) && ((bk) vVar).ru() == 2) {
                this.threadList.remove(0);
            }
            bk bkVar = new bk();
            bkVar.setTitle(top_notice_data.getTitle());
            bkVar.cp(top_notice_data.sP());
            bkVar.bR(2);
            bkVar.sg();
            this.threadList.add(0, bkVar);
        }
    }

    public void a(an anVar) {
        if (anVar != null && !StringUtils.isNull(anVar.getId()) && this.threadList != null) {
            int abS = abS();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = threadList.get(i);
                    if ((vVar instanceof bk) && anVar.getId().equals(((bk) vVar).getId())) {
                        return;
                    }
                }
            }
            if (anVar.isPhotoLiveThread()) {
                aw awVar = new aw();
                awVar.a(anVar, -1);
                awVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.fsS++;
                    this.threadList.add(abS, awVar);
                    return;
                }
                return;
            }
            this.fsS++;
            this.threadList.add(abS, anVar);
        }
    }

    public void bfC() {
        this.fsS = 0;
    }

    public int abS() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof bk) {
                if (((bk) next).ru() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int ri() {
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if ((next instanceof bk) && ((bk) next).rw() == 1) {
                return ((bk) next).ri();
            }
        }
        return -1;
    }

    public void bfD() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bk.Xw || this.threadList.get(i2).getType() == bk.Xx) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bfE() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dhn != null && this.dhn.qv() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if ((vVar instanceof bk) && vVar.getType() == bk.YC) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int abS = abS();
            if (i > abS) {
                this.threadList.add(abS, this.threadList.remove(i));
            }
        }
    }

    public void D(TbPageContext tbPageContext) {
        a(tbPageContext, false, this.threadList, null, false);
    }

    public void a(TbPageContext tbPageContext, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        a(tbPageContext, false, arrayList, null, false);
    }

    public void a(TbPageContext tbPageContext, boolean z, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, ArrayList<com.baidu.adp.widget.ListView.v> arrayList2, boolean z2) {
        BannerListData bannerListData;
        if (!this.fsT) {
            if (this.ecV != null) {
                bannerListData = this.ecV.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.fsU;
        }
        this.fsT = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(tbPageContext, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar.J(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(tbPageContext, 3);
            bVar2.ch(z);
            bVar2.I(arrayList);
            bVar2.K(arrayList2);
            bVar2.ci(z2);
            bVar2.bV(qB().qv());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        }
    }

    public void bfF() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i);
            if (vVar instanceof bk) {
                bk bkVar = (bk) vVar;
                if (bkVar.isPhotoLiveThread() && !(bkVar instanceof aw)) {
                    aw awVar = new aw();
                    awVar.n(bfa());
                    awVar.a(bkVar, 0);
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, awVar);
                    }
                }
            }
        }
    }

    public void bfG() {
        int i;
        if (aHE() != null) {
            List<PhotoLiveCardData> bfa = bfa();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bfa != null && bfa.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof aw)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int rL = rL(i);
                aw awVar = new aw();
                a(awVar, bfa);
                getThreadList().add(rL, awVar);
            }
        }
    }

    private void a(aw awVar, List<PhotoLiveCardData> list) {
        if (awVar != null && !com.baidu.tbadk.core.util.x.r(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            awVar.setThreadType(33);
            awVar.setAuthor(metaData);
            awVar.ct(photoLiveCardData.getForumName());
            awVar.setTitle(photoLiveCardData.getTitle());
            awVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            awVar.cp(new StringBuilder(String.valueOf(photoLiveCardData.getThreadId())).toString());
            awVar.m(photoLiveCardData.getLastModifiedTime());
            awVar.bP(photoLiveCardData.getDiscussNum());
        }
    }

    private int rL(int i) {
        int abS = abS();
        int bfg = bfg();
        if (bfd()) {
            bfg++;
        }
        return Math.min((bfg + abS) - 1, i);
    }

    public void bfH() {
        bk bfk;
        int i;
        if (aHE() != null && (bfk = bfk()) != null) {
            Log.e(PbActivityConfig.VALUE_FROM_FRS, "addCardVideoInfoToThreadList cardVideoInfo:" + bfk.getTid());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof aw)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                threadList.add(rL(i), bfk);
            }
        }
    }

    public void bfI() {
        if (aHE() != null) {
            List<com.baidu.adp.widget.ListView.v> bfv = bfv();
            List<Integer> bfu = bfu();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bfu != null && bfu.size() > 0 && bfv != null && bfv.size() > 0 && threadList != null) {
                int size = bfu.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bfv.size()) {
                        com.baidu.adp.widget.ListView.v vVar = bfv.get(i);
                        int bj = bj(bfu.get(i).intValue(), size2);
                        Log.e(PbActivityConfig.VALUE_FROM_FRS, "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bj + "  Title:" + vVar.getType());
                        threadList.add(bj, vVar);
                    }
                }
            }
        }
    }

    private int bj(int i, int i2) {
        int abS = abS();
        if (bfd()) {
            i++;
        }
        return Math.min((abS + i) - 1, i2);
    }

    public void bfJ() {
        if (bfd()) {
            int abS = abS();
            if (ri() == 0) {
                abS++;
            }
            ax axVar = new ax();
            axVar.a(bfe());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(abS, axVar);
            }
        }
    }

    public bk pR(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next != null && (next instanceof bk) && TextUtils.equals(str, ((bk) next).getId())) {
                return (bk) next;
            }
        }
        return null;
    }

    public void a(com.baidu.tbadk.data.i iVar) {
        if (this.threadList != null && iVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.v next = it.next();
                    if (next != null && (next instanceof bk) && ((bk) next).getAuthor() != null && currentAccount.equals(((bk) next).getAuthor().getUserId()) && ((bk) next).getAuthor().getPendantData() != null) {
                        ((bk) next).getAuthor().getPendantData().O(iVar.BT());
                        ((bk) next).getAuthor().getPendantData().cr(iVar.pT());
                    }
                }
            }
        }
    }

    public void M(bk bkVar) {
        this.threadList.remove(bkVar);
    }

    public boolean d(l lVar) {
        if (lVar == null) {
            return false;
        }
        d(lVar.ql());
        a(lVar.beX());
        kT(lVar.beT());
        pN(lVar.beU());
        c(lVar.aHE());
        setGameName(lVar.getGameName());
        pO(lVar.bfb());
        a(lVar.beV());
        kU(lVar.beY());
        mb(lVar.aHS());
        cx(lVar.bfa());
        rI(lVar.bfg());
        c(lVar.bfe());
        a(lVar.qB());
        a(lVar.beR());
        cv(lVar.beZ());
        ay(lVar.getThreadList());
        cu(lVar.beW());
        e(lVar.getUserData());
        setUserMap(lVar.getUserMap());
        a(lVar.beS());
        cw(lVar.bfc());
        rJ(lVar.bfl());
        cz(lVar.bfi());
        pQ(lVar.bfj());
        L(lVar.bfk());
        a(lVar.bfm());
        rK(lVar.bfp());
        a(lVar.bfq());
        a(lVar.bfr());
        rF(lVar.beO());
        a(lVar.bfs());
        rG(lVar.beP());
        rH(lVar.beQ());
        this.frQ = lVar.frQ;
        this.fso = lVar.fso;
        this.fsr = lVar.fsr;
        a(lVar.bfn());
        d(lVar.bft());
        a(lVar.bfo());
        a(lVar.bff());
        cA(lVar.bfu());
        cB(lVar.bfv());
        kV(lVar.isShowDriftingBottle());
        cl(lVar.bfw());
        this.fsD = lVar.fsD;
        return true;
    }

    public void bfK() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.ecV != null && this.ecV.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if (vVar instanceof bk) {
                    bk bkVar = (bk) vVar;
                    if (bkVar == null || (!bkVar.rZ() && bkVar.rw() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.ecV.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar = new h();
                hVar.setForumId(this.ecV.getId());
                hVar.ct(feedForumList);
                this.threadList.add(i + 6, hVar);
            }
        }
    }

    public boolean bfL() {
        com.baidu.tieba.card.data.p recomTopicData;
        if (this.threadList == null || this.ecV == null || this.ecV.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
            if (vVar instanceof bk) {
                bk bkVar = (bk) vVar;
                if (bkVar == null || (!bkVar.rZ() && bkVar.rw() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.ecV.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.x.q(recomTopicData.bxQ) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new as("c10835").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bfM() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bfp = (bfp() + abS()) - 1;
            if (bfq() != null && bfp >= 0 && bfp <= this.threadList.size()) {
                this.threadList.add(bfp, bfq());
            }
        }
    }

    public void bfN() {
        int intValue;
        if (bff() != null && (bff().position.intValue() + abS()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bff());
        }
    }

    public List<com.baidu.adp.widget.ListView.v> bfO() {
        return this.fsx;
    }

    public void cC(List<com.baidu.adp.widget.ListView.v> list) {
        this.fsx = list;
    }

    public boolean bfP() {
        return beR() != null && beR().bfx() == 1;
    }

    public boolean bfQ() {
        return bfr() == null ? !com.baidu.tbadk.core.util.x.r(bfc()) : !com.baidu.tbadk.core.util.x.r(bfr().tab);
    }

    public void a(BannerListData bannerListData) {
        this.fsT = true;
        this.fsU = bannerListData;
    }
}
