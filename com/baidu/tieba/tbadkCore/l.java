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
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.NebulaHotThreads;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class l extends i implements com.baidu.tbadk.mvc.b.l {
    private boolean bOF;
    public boolean hnT;
    public List<String> hnV;
    public SmartApp hnW;
    private NebulaHotThreads hnX;
    private int hoo = 0;
    private BannerListData hop;
    public int hoq;
    public boolean isBrandForum;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fTD.setCurScore(rVar.getCurScore());
            this.fTD.setLevelupScore(rVar.getLevelupScore());
            this.fTD.setLike(rVar.isLike());
            this.fTD.setUser_level(rVar.bBj());
            this.fTD.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fTD.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fTD == null) {
            return null;
        }
        return this.fTD.getSignData();
    }

    public void bDH() {
        be top_notice_data;
        com.baidu.adp.widget.ListView.h hVar;
        if (bhx() != null && this.threadList != null && (top_notice_data = bhx().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (hVar = this.threadList.get(0)) != null && (hVar instanceof bb) && ((bb) hVar).zO() == 2) {
                this.threadList.remove(0);
            }
            bb bbVar = new bb();
            bbVar.setTitle(top_notice_data.getTitle());
            bbVar.setTid(top_notice_data.BF());
            bbVar.cR(2);
            bbVar.AD();
            this.threadList.add(0, bbVar);
        }
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.threadList != null) {
            int aHA = aHA();
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.h hVar = threadList.get(i);
                    if ((hVar instanceof bb) && aiVar.getId().equals(((bb) hVar).getId())) {
                        return;
                    }
                }
            }
            aiVar.awg = this.isBrandForum;
            this.hoo++;
            this.threadList.add(aHA, aiVar);
        }
    }

    public void bDI() {
        this.hoo = 0;
    }

    public int aHA() {
        int i = 0;
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (!(next instanceof bb)) {
                    i = i2;
                } else if (((bb) next).zO() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    public void bDJ() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bb.atN || this.threadList.get(i2).getType() == bb.atO || this.threadList.get(i2).getType() == bb.atP) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bDK() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.fip != null && this.fip.za() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if ((hVar instanceof bb) && hVar.getType() == bb.avg) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int aHA = aHA();
            if (i > aHA) {
                this.threadList.add(aHA, this.threadList.remove(i));
            }
        }
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar) {
        a(bVar, false, this.threadList, null, false);
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        a(bVar, false, arrayList, null, false);
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar, boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, ArrayList<com.baidu.adp.widget.ListView.h> arrayList2, boolean z2) {
        BannerListData bannerListData;
        if (!this.bOF) {
            if (this.fTD != null) {
                bannerListData = this.fTD.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.hop;
        }
        this.bOF = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar2.ac(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.dk(z);
            bVar3.ab(arrayList);
            bVar3.ad(arrayList2);
            bVar3.dl(z2);
            bVar3.setCurrentPage(zf().za());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.i
    public List<RecmForumInfo> bCN() {
        return this.recm_forum_list;
    }

    public boolean bDL() {
        return this.isBrandForum;
    }

    private int vG(int i) {
        return Math.min((aHA() + bDb()) - 1, i);
    }

    public void bDM() {
        f bDz;
        if (this.threadList != null && bhx() != null && MessageManager.getInstance().findTask(2911003) != null && (bDz = bDz()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.v.I(bDz.hmn)) {
                threadList.add(bP(1, threadList.size()), bDz);
            }
        }
    }

    public void bDN() {
        a(f.class, getThreadList());
    }

    public void bDO() {
        e bDy;
        if (this.threadList != null && bhx() != null && MessageManager.getInstance().findTask(2911003) != null && (bDy = bDy()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(bP(bDy.hml, threadList.size()), bDy);
        }
    }

    public void bDP() {
        a(e.class, getThreadList());
    }

    private int bP(int i, int i2) {
        return Math.min((aHA() + i) - 1, i2);
    }

    private void a(Class cls, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = arrayList.get(i);
                if (hVar.getClass() != cls) {
                    i++;
                } else {
                    arrayList2.add(hVar);
                    break;
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.removeAll(arrayList2);
            }
        }
    }

    public void bDQ() {
        bb bDf;
        if (bhx() != null && (bDf = bDf()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + bDf.getTid());
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(vG(threadList.size()), bDf);
            }
        }
    }

    public void bDR() {
        if (bhx() != null) {
            List<com.baidu.adp.widget.ListView.h> bDr = bDr();
            List<Integer> bDq = bDq();
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (bDq != null && bDq.size() > 0 && bDr != null && bDr.size() > 0 && threadList != null) {
                int size = bDq.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bDr.size()) {
                        com.baidu.adp.widget.ListView.h hVar = bDr.get(i);
                        int bQ = bQ(bDq.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bQ + "  Title:" + hVar.getType());
                        threadList.add(bQ, hVar);
                    }
                }
            }
        }
    }

    private int bQ(int i, int i2) {
        return Math.min((aHA() + i) - 1, i2);
    }

    public bb vO(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.h next = it.next();
            if (next != null && (next instanceof bb) && TextUtils.equals(str, ((bb) next).getId())) {
                return (bb) next;
            }
        }
        return null;
    }

    public void a(com.baidu.tbadk.data.l lVar) {
        if (this.threadList != null && lVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next != null && (next instanceof bb) && ((bb) next).zT() != null && currentAccount.equals(((bb) next).zT().getUserId()) && ((bb) next).zT().getPendantData() != null) {
                        ((bb) next).zT().getPendantData().ap(lVar.LW());
                        ((bb) next).zT().getPendantData().es(lVar.yF());
                    }
                }
            }
        }
    }

    public void ab(bb bbVar) {
        this.threadList.remove(bbVar);
    }

    public boolean g(i iVar) {
        if (iVar == null) {
            return false;
        }
        c(iVar.yR());
        a(iVar.bCX());
        nr(iVar.bCT());
        vK(iVar.bCU());
        c(iVar.bhx());
        setGameName(iVar.getGameName());
        vL(iVar.bDa());
        a(iVar.bCV());
        ns(iVar.bCY());
        sp(iVar.bhM());
        vC(iVar.bDb());
        a(iVar.zf());
        a(iVar.bCR());
        dI(iVar.bCZ());
        ay(iVar.getThreadList());
        dH(iVar.bCW());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.bCS());
        vD(iVar.bDg());
        this.hnU = iVar.hnU;
        dK(iVar.bDd());
        vN(iVar.bDe());
        at(iVar.bDf());
        a(iVar.bDh());
        vE(iVar.bDk());
        a(iVar.bDl());
        a(iVar.bDm());
        vz(iVar.bCO());
        a(iVar.bDo());
        vA(iVar.bCP());
        vB(iVar.bCQ());
        this.hmQ = iVar.hmQ;
        this.hnk = iVar.hnk;
        this.hno = iVar.hno;
        a(iVar.bDi());
        q(iVar.bDp());
        a(iVar.bDj());
        dL(iVar.bDq());
        dM(iVar.bDr());
        this.hnB = iVar.hnB;
        a(iVar.bDs());
        a(iVar.bCL());
        a(iVar.bDt());
        dN(iVar.bDu());
        vF(iVar.bDv());
        a(iVar.bCM());
        a(iVar.bDw());
        a(iVar.bDx());
        this.hnK = iVar.hnK;
        b(iVar.bDy());
        this.recm_forum_list = iVar.bCN();
        b(iVar.bDz());
        this.dRw = iVar.dRw;
        this.hnL = iVar.hnL;
        this.hnl = iVar.hnl;
        this.hnM = iVar.hnM;
        this.hnN = iVar.hnN;
        nt(iVar.bDn());
        this.isBrandForum = iVar.isBrandForum;
        this.hnP = iVar.hnP;
        this.hnQ = iVar.hnQ;
        this.hnR = iVar.hnR;
        com.baidu.tieba.frs.a.aBg().b(yR());
        com.baidu.tieba.frs.a.aBg().setForumId(iVar.bhx().getId());
        d(iVar.bDB());
        this.hnT = iVar.hnT;
        this.hnV = iVar.hnV;
        this.hnW = iVar.hnW;
        this.hnX = iVar.hnX;
        return true;
    }

    public NebulaHotThreads bDS() {
        return this.hnX;
    }

    public void bDT() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fTD != null && this.fTD.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if (hVar instanceof bb) {
                    bb bbVar = (bb) hVar;
                    if (bbVar == null || (!bbVar.Au() && bbVar.zQ() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.fTD.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar2 = new h();
                hVar2.setForumId(this.fTD.getId());
                hVar2.dG(feedForumList);
                this.threadList.add(i + 6, hVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void nu(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.I(this.threadList)) {
            bDU();
            if (bDs() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                    if (hVar instanceof bb) {
                        bb bbVar = (bb) hVar;
                        if (bbVar == null || (!bbVar.Au() && bbVar.zQ() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bDs().aKl() + i) - 1 < this.threadList.size()) {
                    String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("game_rank_list_info", "");
                    if (StringUtils.isNull(string) || string.split(",").length != 2) {
                        z2 = true;
                    } else {
                        z2 = UtilHelper.getDayBetweenTime(com.baidu.adp.lib.g.b.d(string.split(",")[0], 0L), System.currentTimeMillis()) >= ((long) com.baidu.adp.lib.g.b.l(string.split(",")[1], 0));
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
                                this.threadList.add((bDs().aKl() + i) - 1, bDs());
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

    public void bDU() {
        if (!com.baidu.tbadk.core.util.v.I(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.h.b.eoj) {
                    it.remove();
                }
            }
        }
    }

    public boolean bDV() {
        com.baidu.tieba.card.data.n recomTopicData;
        if (this.threadList == null || this.fTD == null || this.fTD.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
            if (hVar instanceof bb) {
                bb bbVar = (bb) hVar;
                if (bbVar == null || (!bbVar.Au() && bbVar.zQ() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fTD.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.H(recomTopicData.dbZ) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new am("c10835").aB("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bDW() {
        if (MessageManager.getInstance().findTask(2003016) != null) {
            int bDk = (bDk() + aHA()) - 1;
            if (bDl() != null && bDk >= 0 && bDk <= this.threadList.size()) {
                this.threadList.add(bDk, bDl());
            }
        }
    }

    public void bDX() {
        int AT;
        if (bDw() != null) {
            com.baidu.tieba.frs.q bDw = bDw();
            if (com.baidu.tbadk.core.util.v.H(bDw.getUserInfo()) >= 3 && (AT = bDw.AT()) > 0) {
                int aHA = AT + aHA();
                if (aHA > this.threadList.size()) {
                    this.threadList.add(bDw);
                } else {
                    this.threadList.add(aHA, bDw);
                }
            }
        }
    }

    public void bDY() {
        if (!com.baidu.tbadk.core.util.v.I(this.threadList)) {
            boolean z = false;
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
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

    public void bDZ() {
        if (bDx() != null && !com.baidu.tbadk.core.util.v.I(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == k.hon) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, bDx());
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bEa() {
        return this.hnu;
    }

    public void dO(List<com.baidu.adp.widget.ListView.h> list) {
        this.hnu = list;
    }

    public boolean bEb() {
        if (bCR() == null) {
            return false;
        }
        return bCR().bDC() == 1;
    }

    public boolean bEc() {
        return (bDm() == null || com.baidu.tbadk.core.util.v.I(bDm().tab)) ? false : true;
    }

    public void a(BannerListData bannerListData) {
        this.bOF = true;
        this.hop = bannerListData;
    }
}
