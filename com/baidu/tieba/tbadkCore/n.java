package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class n extends l implements com.baidu.tbadk.mvc.b.l {
    private int fsM = 0;
    private boolean fsN;
    private BannerListData fsO;

    public void c(v vVar) {
        if (vVar != null) {
            this.ehK.setCurScore(vVar.getCurScore());
            this.ehK.setLevelupScore(vVar.getLevelupScore());
            this.ehK.setLike(vVar.isLike());
            this.ehK.setUser_level(vVar.getUserLevel());
            this.ehK.setLevelName(vVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.ehK.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.ehK == null) {
            return null;
        }
        return this.ehK.getSignData();
    }

    public void bgn() {
        bn top_notice_data;
        com.baidu.adp.widget.ListView.v vVar;
        if (aJp() != null && this.threadList != null && (top_notice_data = aJp().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (vVar = this.threadList.get(0)) != null && (vVar instanceof bj) && ((bj) vVar).rM() == 2) {
                this.threadList.remove(0);
            }
            bj bjVar = new bj();
            bjVar.setTitle(top_notice_data.getTitle());
            bjVar.ci(top_notice_data.te());
            bjVar.bQ(2);
            bjVar.sy();
            this.threadList.add(0, bjVar);
        }
    }

    public void a(an anVar) {
        if (anVar != null && !StringUtils.isNull(anVar.getId()) && this.threadList != null) {
            int acT = acT();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = threadList.get(i);
                    if ((vVar instanceof bj) && anVar.getId().equals(((bj) vVar).getId())) {
                        return;
                    }
                }
            }
            if (anVar.isPhotoLiveThread()) {
                aw awVar = new aw();
                awVar.a(anVar, -1);
                awVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.fsM++;
                    this.threadList.add(acT, awVar);
                    return;
                }
                return;
            }
            this.fsM++;
            this.threadList.add(acT, anVar);
        }
    }

    public void bgo() {
        this.fsM = 0;
    }

    public int acT() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof bj) {
                if (((bj) next).rM() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int rA() {
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if ((next instanceof bj) && ((bj) next).rO() == 1) {
                return ((bj) next).rA();
            }
        }
        return -1;
    }

    public void bgp() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bj.XN || this.threadList.get(i2).getType() == bj.XO) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bgq() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dms != null && this.dms.qO() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if ((vVar instanceof bj) && vVar.getType() == bj.YT) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int acT = acT();
            if (i > acT) {
                this.threadList.add(acT, this.threadList.remove(i));
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
        if (!this.fsN) {
            if (this.ehK != null) {
                bannerListData = this.ehK.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.fsO;
        }
        this.fsN = false;
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
            bVar2.cd(z);
            bVar2.G(arrayList);
            bVar2.I(arrayList2);
            bVar2.ce(z2);
            bVar2.bU(getPage().qO());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        }
    }

    public void bgr() {
        boolean z = true;
        if (this.ehK != null && this.threadList != null && bj.XQ.get() && this.dms != null && this.dms.qO() == 1) {
            if (this.frN == null || !this.frN.bgH()) {
                z = false;
            }
            if (this.frL || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof w)) {
                    this.threadList.remove(0);
                }
                w wVar = new w();
                wVar.ld(this.frL);
                wVar.pH(this.frM);
                wVar.b(this.frN);
                wVar.bQ(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    com.baidu.tbadk.core.util.x.a(this.threadList, acT(), wVar);
                }
            }
        }
    }

    public void bgs() {
        if (this.ehK != null) {
            if (((this.ehK.getTopCode() != null && !StringUtils.isNull(this.ehK.getTopCode().sY())) || (this.ehK.getNewsInfo() != null && !StringUtils.isNull(this.ehK.getNewsInfo().sY()))) && this.dms != null && this.dms.qO() == 1) {
                af afVar = new af();
                afVar.a(this.ehK.getTopCode());
                afVar.a(this.ehK.getNewsInfo());
                afVar.bQ(3);
                afVar.le(true);
                if (!com.baidu.tbadk.core.util.x.q(this.threadList)) {
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof bj) && ((bj) next).rM() != 0) {
                            if (((bj) next).rM() == 1003) {
                                afVar.le(false);
                            }
                            i++;
                        }
                    }
                    this.threadList.add(i, afVar);
                }
            }
        }
    }

    public void bgt() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i);
            if (vVar instanceof bj) {
                bj bjVar = (bj) vVar;
                if (bjVar.isPhotoLiveThread() && !(bjVar instanceof aw)) {
                    aw awVar = new aw();
                    awVar.m(bfI());
                    awVar.a(bjVar, 0);
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, awVar);
                    }
                }
            }
        }
    }

    public void bgu() {
        int i;
        if (aJp() != null) {
            List<PhotoLiveCardData> bfI = bfI();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bfI != null && bfI.size() > 0 && threadList != null && threadList.size() > 0) {
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
                int rP = rP(i);
                aw awVar = new aw();
                a(awVar, bfI);
                getThreadList().add(rP, awVar);
            }
        }
    }

    private void a(aw awVar, List<PhotoLiveCardData> list) {
        if (awVar != null && !com.baidu.tbadk.core.util.x.q(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            awVar.setThreadType(33);
            awVar.setAuthor(metaData);
            awVar.co(photoLiveCardData.getForumName());
            awVar.setTitle(photoLiveCardData.getTitle());
            awVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            awVar.ci(new StringBuilder(String.valueOf(photoLiveCardData.getThreadId())).toString());
            awVar.m(photoLiveCardData.getLastModifiedTime());
            awVar.bP(photoLiveCardData.getDiscussNum());
        }
    }

    private int rP(int i) {
        int acT = acT();
        int bfP = bfP();
        if (bfL()) {
            bfP++;
        }
        return Math.min((bfP + acT) - 1, i);
    }

    public void bgv() {
        bj bfT;
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        int i;
        if (aJp() != null && (bfT = bfT()) != null && (threadList = getThreadList()) != null && threadList.size() > 0) {
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
            threadList.add(rP(i), bfT);
        }
    }

    public void bgw() {
        if (aJp() != null) {
            List<com.baidu.adp.widget.ListView.v> bgf = bgf();
            List<Integer> bge = bge();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bge != null && bge.size() > 0 && bgf != null && bgf.size() > 0 && threadList != null) {
                int size = bge.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bgf.size()) {
                        threadList.add(bp(bge.get(i).intValue(), size2), bgf.get(i));
                    }
                }
            }
        }
    }

    private int bp(int i, int i2) {
        int acT = acT();
        if (bfL()) {
            i++;
        }
        return Math.min((acT + i) - 1, i2);
    }

    public void bgx() {
        if (bfL()) {
            int acT = acT();
            if (rA() == 0) {
                acT++;
            }
            ax axVar = new ax();
            axVar.a(bfM());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(acT, axVar);
            }
        }
    }

    public void bgy() {
        com.baidu.tbadk.core.data.ab bfN;
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.uo().getLong("frs_storecard_closetime", 0L) >= 86400000 && (bfN = bfN()) != null) {
            int acT = acT();
            int rA = rA();
            if (rA == 0 || rA == 1) {
                acT++;
            }
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(acT, bfN);
            }
        }
    }

    public bj pA(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next != null && (next instanceof bj) && TextUtils.equals(str, ((bj) next).getId())) {
                return (bj) next;
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
                    if (next != null && (next instanceof bj) && ((bj) next).getAuthor() != null && currentAccount.equals(((bj) next).getAuthor().getUserId()) && ((bj) next).getAuthor().getPendantData() != null) {
                        ((bj) next).getAuthor().getPendantData().N(jVar.Cq());
                        ((bj) next).getAuthor().getPendantData().ck(jVar.qd());
                    }
                }
            }
        }
    }

    public void L(bj bjVar) {
        this.threadList.remove(bjVar);
    }

    public boolean d(l lVar) {
        if (lVar == null) {
            return false;
        }
        d(lVar.qE());
        a(lVar.bfF());
        la(lVar.bfB());
        pw(lVar.bfC());
        c(lVar.aJp());
        setGameName(lVar.getGameName());
        px(lVar.bfJ());
        a(lVar.bfD());
        lb(lVar.bfG());
        mh(lVar.aJB());
        cH(lVar.bfI());
        rM(lVar.bfP());
        c(lVar.bfM());
        a(lVar.getPage());
        a(lVar.bfz());
        cF(lVar.bfH());
        ax(lVar.getThreadList());
        cE(lVar.bfE());
        h(lVar.getUserData());
        setUserMap(lVar.getUserMap());
        b(lVar.bfA());
        cG(lVar.bfK());
        rN(lVar.bfU());
        cJ(lVar.bfR());
        pz(lVar.bfS());
        a(lVar.bfN());
        K(lVar.bfT());
        b(lVar.bfV());
        rO(lVar.bfY());
        a(lVar.bfZ());
        a(lVar.bga());
        rJ(lVar.bfw());
        a(lVar.bgb());
        cK(lVar.bgc());
        rK(lVar.bfx());
        rL(lVar.bfy());
        this.frI = lVar.frI;
        this.fsh = lVar.fsh;
        this.fsk = lVar.fsk;
        a(lVar.bfW());
        d(lVar.bgd());
        a(lVar.bfX());
        a(lVar.bfO());
        cL(lVar.bge());
        cM(lVar.bgf());
        lc(lVar.isShowDriftingBottle());
        cA(lVar.bgg());
        this.fsx = lVar.fsx;
        return true;
    }

    public void bgz() {
        if (this.threadList != null || this.threadList.size() <= 0) {
            int size = this.threadList.size();
            for (int i = 0; i < size; i++) {
                if (this.threadList.get(i) instanceof com.baidu.tbadk.core.data.ab) {
                    this.threadList.remove(i);
                    return;
                }
            }
        }
    }

    public void bgA() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.ehK != null && this.ehK.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if (vVar instanceof bj) {
                    bj bjVar = (bj) vVar;
                    if (bjVar == null || (!bjVar.sr() && bjVar.rO() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.ehK.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar = new h();
                hVar.setForumId(this.ehK.getId());
                hVar.cD(feedForumList);
                this.threadList.add(i + 6, hVar);
            }
        }
    }

    public boolean bgB() {
        com.baidu.tieba.card.data.r recomTopicData;
        if (this.threadList == null || this.ehK == null || this.ehK.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
            if (vVar instanceof bj) {
                bj bjVar = (bj) vVar;
                if (bjVar == null || (!bjVar.sr() && bjVar.rO() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.ehK.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.x.p(recomTopicData.bvI) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new as("c10835").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bgC() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bfY = (bfY() + acT()) - 1;
            if (bfZ() != null && bfY >= 0 && bfY <= this.threadList.size()) {
                this.threadList.add(bfY, bfZ());
            }
        }
    }

    public void bgD() {
        int intValue;
        if (bfO() != null && (bfO().position.intValue() + acT()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bfO());
        }
    }

    public List<com.baidu.adp.widget.ListView.v> bgE() {
        return this.fsq;
    }

    public void cN(List<com.baidu.adp.widget.ListView.v> list) {
        this.fsq = list;
    }

    public boolean bgF() {
        return bfz() != null && bfz().bgh() == 1;
    }

    public boolean bgG() {
        return bga() == null ? !com.baidu.tbadk.core.util.x.q(bfK()) : !com.baidu.tbadk.core.util.x.q(bga().tab);
    }

    public void a(BannerListData bannerListData) {
        this.fsN = true;
        this.fsO = bannerListData;
    }
}
