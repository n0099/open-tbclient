package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class n extends l implements com.baidu.tbadk.mvc.b.l {
    private int fwM = 0;
    private boolean fwN;
    private BannerListData fwO;

    public void c(v vVar) {
        if (vVar != null) {
            this.eih.setCurScore(vVar.getCurScore());
            this.eih.setLevelupScore(vVar.getLevelupScore());
            this.eih.setLike(vVar.isLike());
            this.eih.setUser_level(vVar.getUserLevel());
            this.eih.setLevelName(vVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.eih.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.eih == null) {
            return null;
        }
        return this.eih.getSignData();
    }

    public void bib() {
        bm top_notice_data;
        com.baidu.adp.widget.ListView.v vVar;
        if (aKx() != null && this.threadList != null && (top_notice_data = aKx().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (vVar = this.threadList.get(0)) != null && (vVar instanceof bi) && ((bi) vVar).sk() == 2) {
                this.threadList.remove(0);
            }
            bi biVar = new bi();
            biVar.setTitle(top_notice_data.getTitle());
            biVar.cp(top_notice_data.tC());
            biVar.bT(2);
            biVar.sW();
            this.threadList.add(0, biVar);
        }
    }

    public void a(am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && this.threadList != null) {
            int adO = adO();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = threadList.get(i);
                    if ((vVar instanceof bi) && amVar.getId().equals(((bi) vVar).getId())) {
                        return;
                    }
                }
            }
            if (amVar.isPhotoLiveThread()) {
                av avVar = new av();
                avVar.a(amVar, -1);
                avVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.fwM++;
                    this.threadList.add(adO, avVar);
                    return;
                }
                return;
            }
            this.fwM++;
            this.threadList.add(adO, amVar);
        }
    }

    public void bic() {
        this.fwM = 0;
    }

    public int adO() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof bi) {
                if (((bi) next).sk() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int rY() {
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if ((next instanceof bi) && ((bi) next).sm() == 1) {
                return ((bi) next).rY();
            }
        }
        return -1;
    }

    public void bid() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bi.Ye || this.threadList.get(i2).getType() == bi.Yf) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bie() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dni != null && this.dni.rl() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if ((vVar instanceof bi) && vVar.getType() == bi.Zk) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int adO = adO();
            if (i > adO) {
                this.threadList.add(adO, this.threadList.remove(i));
            }
        }
    }

    public void g(BaseActivity baseActivity) {
        a(baseActivity, false, this.threadList, null, false);
    }

    public void a(BaseActivity baseActivity, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        a(baseActivity, false, arrayList, null, false);
    }

    public void a(BaseActivity baseActivity, boolean z, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, ArrayList<com.baidu.adp.widget.ListView.v> arrayList2, boolean z2) {
        BannerListData bannerListData;
        if (!this.fwN) {
            if (this.eih != null) {
                bannerListData = this.eih.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.fwO;
        }
        this.fwN = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(baseActivity.getPageContext(), 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar.H(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(baseActivity.getPageContext(), 3);
            bVar2.cf(z);
            bVar2.G(arrayList);
            bVar2.I(arrayList2);
            bVar2.cg(z2);
            bVar2.bX(rr().rl());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        }
    }

    public void bif() {
        boolean z = true;
        if (this.eih != null && this.threadList != null && bi.Yh.get() && this.dni != null && this.dni.rl() == 1) {
            if (this.fvP == null || !this.fvP.bit()) {
                z = false;
            }
            if (this.fvN || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof w)) {
                    this.threadList.remove(0);
                }
                w wVar = new w();
                wVar.lq(this.fvN);
                wVar.pZ(this.fvO);
                wVar.b(this.fvP);
                wVar.bT(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    com.baidu.tbadk.core.util.x.a(this.threadList, adO(), wVar);
                }
            }
        }
    }

    public void big() {
        if (this.eih != null) {
            if (((this.eih.getTopCode() != null && !StringUtils.isNull(this.eih.getTopCode().tw())) || (this.eih.getNewsInfo() != null && !StringUtils.isNull(this.eih.getNewsInfo().tw()))) && this.dni != null && this.dni.rl() == 1) {
                af afVar = new af();
                afVar.a(this.eih.getTopCode());
                afVar.a(this.eih.getNewsInfo());
                afVar.bT(3);
                afVar.lr(true);
                if (!com.baidu.tbadk.core.util.x.q(this.threadList)) {
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof bi) && ((bi) next).sk() != 0) {
                            if (((bi) next).sk() == 1003) {
                                afVar.lr(false);
                            }
                            i++;
                        }
                    }
                    this.threadList.add(i, afVar);
                }
            }
        }
    }

    public void bih() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i);
            if (vVar instanceof bi) {
                bi biVar = (bi) vVar;
                if (biVar.isPhotoLiveThread() && !(biVar instanceof av)) {
                    av avVar = new av();
                    avVar.m(bhy());
                    avVar.a(biVar, 0);
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, avVar);
                    }
                }
            }
        }
    }

    public void bii() {
        int i;
        if (aKx() != null) {
            List<PhotoLiveCardData> bhy = bhy();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bhy != null && bhy.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof av)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int rT = rT(i);
                av avVar = new av();
                a(avVar, bhy);
                getThreadList().add(rT, avVar);
            }
        }
    }

    private void a(av avVar, List<PhotoLiveCardData> list) {
        if (avVar != null && !com.baidu.tbadk.core.util.x.q(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            avVar.setThreadType(33);
            avVar.setAuthor(metaData);
            avVar.cv(photoLiveCardData.getForumName());
            avVar.setTitle(photoLiveCardData.getTitle());
            avVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            avVar.cp(new StringBuilder(String.valueOf(photoLiveCardData.getThreadId())).toString());
            avVar.m(photoLiveCardData.getLastModifiedTime());
            avVar.bS(photoLiveCardData.getDiscussNum());
        }
    }

    private int rT(int i) {
        int adO = adO();
        int bhE = bhE();
        if (bhB()) {
            bhE++;
        }
        return Math.min((bhE + adO) - 1, i);
    }

    public void bij() {
        bi bhI;
        int i;
        if (aKx() != null && (bhI = bhI()) != null) {
            Log.e(PbActivityConfig.VALUE_FROM_FRS, "addCardVideoInfoToThreadList cardVideoInfo:" + bhI.getTid());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof av)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                threadList.add(rT(i), bhI);
            }
        }
    }

    public void bik() {
        if (aKx() != null) {
            List<com.baidu.adp.widget.ListView.v> bhT = bhT();
            List<Integer> bhS = bhS();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bhS != null && bhS.size() > 0 && bhT != null && bhT.size() > 0 && threadList != null) {
                int size = bhS.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bhT.size()) {
                        com.baidu.adp.widget.ListView.v vVar = bhT.get(i);
                        int bm = bm(bhS.get(i).intValue(), size2);
                        Log.e(PbActivityConfig.VALUE_FROM_FRS, "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bm + "  Title:" + vVar.getType());
                        threadList.add(bm, vVar);
                    }
                }
            }
        }
    }

    private int bm(int i, int i2) {
        int adO = adO();
        if (bhB()) {
            i++;
        }
        return Math.min((adO + i) - 1, i2);
    }

    public void bil() {
        if (bhB()) {
            int adO = adO();
            if (rY() == 0) {
                adO++;
            }
            aw awVar = new aw();
            awVar.a(bhC());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(adO, awVar);
            }
        }
    }

    public bi pS(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next != null && (next instanceof bi) && TextUtils.equals(str, ((bi) next).getId())) {
                return (bi) next;
            }
        }
        return null;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (this.threadList != null && jVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.v next = it.next();
                    if (next != null && (next instanceof bi) && ((bi) next).getAuthor() != null && currentAccount.equals(((bi) next).getAuthor().getUserId()) && ((bi) next).getAuthor().getPendantData() != null) {
                        ((bi) next).getAuthor().getPendantData().N(jVar.CO());
                        ((bi) next).getAuthor().getPendantData().cr(jVar.qB());
                    }
                }
            }
        }
    }

    public void I(bi biVar) {
        this.threadList.remove(biVar);
    }

    public boolean d(l lVar) {
        if (lVar == null) {
            return false;
        }
        d(lVar.rb());
        a(lVar.bhv());
        ln(lVar.bhr());
        pO(lVar.bhs());
        c(lVar.aKx());
        setGameName(lVar.getGameName());
        pP(lVar.bhz());
        a(lVar.bht());
        lo(lVar.bhw());
        mo(lVar.aKJ());
        cH(lVar.bhy());
        rQ(lVar.bhE());
        c(lVar.bhC());
        a(lVar.rr());
        a(lVar.bhp());
        cF(lVar.bhx());
        ax(lVar.getThreadList());
        cE(lVar.bhu());
        h(lVar.getUserData());
        setUserMap(lVar.getUserMap());
        b(lVar.bhq());
        cG(lVar.bhA());
        rR(lVar.bhJ());
        cJ(lVar.bhG());
        pR(lVar.bhH());
        H(lVar.bhI());
        b(lVar.bhK());
        rS(lVar.bhN());
        a(lVar.bhO());
        a(lVar.bhP());
        rN(lVar.bhm());
        a(lVar.bhQ());
        rO(lVar.bhn());
        rP(lVar.bho());
        this.fvK = lVar.fvK;
        this.fwi = lVar.fwi;
        this.fwl = lVar.fwl;
        a(lVar.bhL());
        d(lVar.bhR());
        a(lVar.bhM());
        a(lVar.bhD());
        cK(lVar.bhS());
        cL(lVar.bhT());
        lp(lVar.isShowDriftingBottle());
        cA(lVar.bhU());
        this.fwx = lVar.fwx;
        return true;
    }

    public void bim() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.eih != null && this.eih.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if (vVar instanceof bi) {
                    bi biVar = (bi) vVar;
                    if (biVar == null || (!biVar.sP() && biVar.sm() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.eih.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar = new h();
                hVar.setForumId(this.eih.getId());
                hVar.cD(feedForumList);
                this.threadList.add(i + 6, hVar);
            }
        }
    }

    public boolean bin() {
        com.baidu.tieba.card.data.r recomTopicData;
        if (this.threadList == null || this.eih == null || this.eih.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
            if (vVar instanceof bi) {
                bi biVar = (bi) vVar;
                if (biVar == null || (!biVar.sP() && biVar.sm() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.eih.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.x.p(recomTopicData.bxS) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new as("c10835").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bio() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bhN = (bhN() + adO()) - 1;
            if (bhO() != null && bhN >= 0 && bhN <= this.threadList.size()) {
                this.threadList.add(bhN, bhO());
            }
        }
    }

    public void bip() {
        int intValue;
        if (bhD() != null && (bhD().position.intValue() + adO()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bhD());
        }
    }

    public List<com.baidu.adp.widget.ListView.v> biq() {
        return this.fwr;
    }

    public void cM(List<com.baidu.adp.widget.ListView.v> list) {
        this.fwr = list;
    }

    public boolean bir() {
        return bhp() != null && bhp().bhV() == 1;
    }

    public boolean bis() {
        return bhP() == null ? !com.baidu.tbadk.core.util.x.q(bhA()) : !com.baidu.tbadk.core.util.x.q(bhP().tab);
    }

    public void a(BannerListData bannerListData) {
        this.fwN = true;
        this.fwO = bannerListData;
    }
}
