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
    private int fuw = 0;
    private boolean fux;
    private BannerListData fuy;

    public void c(v vVar) {
        if (vVar != null) {
            this.efR.setCurScore(vVar.getCurScore());
            this.efR.setLevelupScore(vVar.getLevelupScore());
            this.efR.setLike(vVar.isLike());
            this.efR.setUser_level(vVar.getUserLevel());
            this.efR.setLevelName(vVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.efR.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.efR == null) {
            return null;
        }
        return this.efR.getSignData();
    }

    public void bha() {
        bm top_notice_data;
        com.baidu.adp.widget.ListView.v vVar;
        if (aJw() != null && this.threadList != null && (top_notice_data = aJw().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
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
            int acN = acN();
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
                    this.fuw++;
                    this.threadList.add(acN, avVar);
                    return;
                }
                return;
            }
            this.fuw++;
            this.threadList.add(acN, amVar);
        }
    }

    public void bhb() {
        this.fuw = 0;
    }

    public int acN() {
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

    public void bhc() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bi.Yd || this.threadList.get(i2).getType() == bi.Ye) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bhd() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dkR != null && this.dkR.rl() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if ((vVar instanceof bi) && vVar.getType() == bi.Zj) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int acN = acN();
            if (i > acN) {
                this.threadList.add(acN, this.threadList.remove(i));
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
        if (!this.fux) {
            if (this.efR != null) {
                bannerListData = this.efR.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.fuy;
        }
        this.fux = false;
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

    public void bhe() {
        boolean z = true;
        if (this.efR != null && this.threadList != null && bi.Yg.get() && this.dkR != null && this.dkR.rl() == 1) {
            if (this.fty == null || !this.fty.bhs()) {
                z = false;
            }
            if (this.ftw || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof w)) {
                    this.threadList.remove(0);
                }
                w wVar = new w();
                wVar.lg(this.ftw);
                wVar.pY(this.ftx);
                wVar.b(this.fty);
                wVar.bT(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    com.baidu.tbadk.core.util.x.a(this.threadList, acN(), wVar);
                }
            }
        }
    }

    public void bhf() {
        if (this.efR != null) {
            if (((this.efR.getTopCode() != null && !StringUtils.isNull(this.efR.getTopCode().tw())) || (this.efR.getNewsInfo() != null && !StringUtils.isNull(this.efR.getNewsInfo().tw()))) && this.dkR != null && this.dkR.rl() == 1) {
                af afVar = new af();
                afVar.a(this.efR.getTopCode());
                afVar.a(this.efR.getNewsInfo());
                afVar.bT(3);
                afVar.lh(true);
                if (!com.baidu.tbadk.core.util.x.q(this.threadList)) {
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof bi) && ((bi) next).sk() != 0) {
                            if (((bi) next).sk() == 1003) {
                                afVar.lh(false);
                            }
                            i++;
                        }
                    }
                    this.threadList.add(i, afVar);
                }
            }
        }
    }

    public void bhg() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i);
            if (vVar instanceof bi) {
                bi biVar = (bi) vVar;
                if (biVar.isPhotoLiveThread() && !(biVar instanceof av)) {
                    av avVar = new av();
                    avVar.m(bgw());
                    avVar.a(biVar, 0);
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, avVar);
                    }
                }
            }
        }
    }

    public void bhh() {
        int i;
        if (aJw() != null) {
            List<PhotoLiveCardData> bgw = bgw();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bgw != null && bgw.size() > 0 && threadList != null && threadList.size() > 0) {
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
                int rN = rN(i);
                av avVar = new av();
                a(avVar, bgw);
                getThreadList().add(rN, avVar);
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

    private int rN(int i) {
        int acN = acN();
        int bgC = bgC();
        if (bgz()) {
            bgC++;
        }
        return Math.min((bgC + acN) - 1, i);
    }

    public void bhi() {
        bi bgG;
        int i;
        if (aJw() != null && (bgG = bgG()) != null) {
            Log.e(PbActivityConfig.VALUE_FROM_FRS, "addCardVideoInfoToThreadList cardVideoInfo:" + bgG.getTid());
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
                threadList.add(rN(i), bgG);
            }
        }
    }

    public void bhj() {
        if (aJw() != null) {
            List<com.baidu.adp.widget.ListView.v> bgS = bgS();
            List<Integer> bgR = bgR();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bgR != null && bgR.size() > 0 && bgS != null && bgS.size() > 0 && threadList != null) {
                int size = bgR.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bgS.size()) {
                        com.baidu.adp.widget.ListView.v vVar = bgS.get(i);
                        int bm = bm(bgR.get(i).intValue(), size2);
                        Log.e(PbActivityConfig.VALUE_FROM_FRS, "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bm + "  Title:" + vVar.getType());
                        threadList.add(bm, vVar);
                    }
                }
            }
        }
    }

    private int bm(int i, int i2) {
        int acN = acN();
        if (bgz()) {
            i++;
        }
        return Math.min((acN + i) - 1, i2);
    }

    public void bhk() {
        if (bgz()) {
            int acN = acN();
            if (rY() == 0) {
                acN++;
            }
            aw awVar = new aw();
            awVar.a(bgA());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(acN, awVar);
            }
        }
    }

    public bi pR(String str) {
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
        a(lVar.bgt());
        ld(lVar.bgp());
        pN(lVar.bgq());
        c(lVar.aJw());
        setGameName(lVar.getGameName());
        pO(lVar.bgx());
        a(lVar.bgr());
        le(lVar.bgu());
        mi(lVar.aJI());
        cG(lVar.bgw());
        rK(lVar.bgC());
        c(lVar.bgA());
        a(lVar.rr());
        a(lVar.bgn());
        cE(lVar.bgv());
        ax(lVar.getThreadList());
        cD(lVar.bgs());
        h(lVar.getUserData());
        setUserMap(lVar.getUserMap());
        b(lVar.bgo());
        cF(lVar.bgy());
        rL(lVar.bgH());
        cI(lVar.bgE());
        pQ(lVar.bgF());
        H(lVar.bgG());
        b(lVar.bgI());
        rM(lVar.bgL());
        a(lVar.bgM());
        a(lVar.bgN());
        rH(lVar.bgk());
        a(lVar.bgO());
        cJ(lVar.bgP());
        rI(lVar.bgl());
        rJ(lVar.bgm());
        this.ftt = lVar.ftt;
        this.ftR = lVar.ftR;
        this.ftU = lVar.ftU;
        a(lVar.bgJ());
        d(lVar.bgQ());
        a(lVar.bgK());
        a(lVar.bgB());
        cK(lVar.bgR());
        cL(lVar.bgS());
        lf(lVar.isShowDriftingBottle());
        cA(lVar.bgT());
        this.fuh = lVar.fuh;
        return true;
    }

    public void bhl() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.efR != null && this.efR.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
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
            if (this.threadList.size() - i > 7 && (feedForumList = this.efR.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar = new h();
                hVar.setForumId(this.efR.getId());
                hVar.cC(feedForumList);
                this.threadList.add(i + 6, hVar);
            }
        }
    }

    public boolean bhm() {
        com.baidu.tieba.card.data.r recomTopicData;
        if (this.threadList == null || this.efR == null || this.efR.getBannerListData() == null) {
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
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.efR.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.x.p(recomTopicData.bvB) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new as("c10835").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bhn() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bgL = (bgL() + acN()) - 1;
            if (bgM() != null && bgL >= 0 && bgL <= this.threadList.size()) {
                this.threadList.add(bgL, bgM());
            }
        }
    }

    public void bho() {
        int intValue;
        if (bgB() != null && (bgB().position.intValue() + acN()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bgB());
        }
    }

    public List<com.baidu.adp.widget.ListView.v> bhp() {
        return this.fua;
    }

    public void cM(List<com.baidu.adp.widget.ListView.v> list) {
        this.fua = list;
    }

    public boolean bhq() {
        return bgn() != null && bgn().bgU() == 1;
    }

    public boolean bhr() {
        return bgN() == null ? !com.baidu.tbadk.core.util.x.q(bgy()) : !com.baidu.tbadk.core.util.x.q(bgN().tab);
    }

    public void a(BannerListData bannerListData) {
        this.fux = true;
        this.fuy = bannerListData;
    }
}
