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
    private boolean bNS;
    public boolean hmN;
    public List<String> hmP;
    public SmartApp hmQ;
    private NebulaHotThreads hmR;
    private int hni = 0;
    private BannerListData hnj;
    public int hnk;
    public boolean isBrandForum;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fSF.setCurScore(rVar.getCurScore());
            this.fSF.setLevelupScore(rVar.getLevelupScore());
            this.fSF.setLike(rVar.isLike());
            this.fSF.setUser_level(rVar.bAA());
            this.fSF.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fSF.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fSF == null) {
            return null;
        }
        return this.fSF.getSignData();
    }

    public void bCY() {
        be top_notice_data;
        com.baidu.adp.widget.ListView.h hVar;
        if (bgT() != null && this.threadList != null && (top_notice_data = bgT().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (hVar = this.threadList.get(0)) != null && (hVar instanceof bb) && ((bb) hVar).zB() == 2) {
                this.threadList.remove(0);
            }
            bb bbVar = new bb();
            bbVar.setTitle(top_notice_data.getTitle());
            bbVar.setTid(top_notice_data.Bs());
            bbVar.cR(2);
            bbVar.Aq();
            this.threadList.add(0, bbVar);
        }
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.threadList != null) {
            int aHd = aHd();
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
            aiVar.avD = this.isBrandForum;
            this.hni++;
            this.threadList.add(aHd, aiVar);
        }
    }

    public void bCZ() {
        this.hni = 0;
    }

    public int aHd() {
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
                } else if (((bb) next).zB() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    public void bDa() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bb.atk || this.threadList.get(i2).getType() == bb.atl || this.threadList.get(i2).getType() == bb.atm) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bDb() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.fhz != null && this.fhz.yN() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if ((hVar instanceof bb) && hVar.getType() == bb.auD) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int aHd = aHd();
            if (i > aHd) {
                this.threadList.add(aHd, this.threadList.remove(i));
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
        if (!this.bNS) {
            if (this.fSF != null) {
                bannerListData = this.fSF.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.hnj;
        }
        this.bNS = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar2.ab(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.dh(z);
            bVar3.aa(arrayList);
            bVar3.ac(arrayList2);
            bVar3.di(z2);
            bVar3.setCurrentPage(yS().yN());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.i
    public List<RecmForumInfo> bCe() {
        return this.recm_forum_list;
    }

    public boolean bDc() {
        return this.isBrandForum;
    }

    private int vD(int i) {
        return Math.min((aHd() + bCs()) - 1, i);
    }

    public void bDd() {
        f bCQ;
        if (this.threadList != null && bgT() != null && MessageManager.getInstance().findTask(2911003) != null && (bCQ = bCQ()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.v.I(bCQ.hli)) {
                threadList.add(bP(1, threadList.size()), bCQ);
            }
        }
    }

    public void bDe() {
        a(f.class, getThreadList());
    }

    public void bDf() {
        e bCP;
        if (this.threadList != null && bgT() != null && MessageManager.getInstance().findTask(2911003) != null && (bCP = bCP()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(bP(bCP.hlg, threadList.size()), bCP);
        }
    }

    public void bDg() {
        a(e.class, getThreadList());
    }

    private int bP(int i, int i2) {
        return Math.min((aHd() + i) - 1, i2);
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

    public void bDh() {
        bb bCw;
        if (bgT() != null && (bCw = bCw()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + bCw.getTid());
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(vD(threadList.size()), bCw);
            }
        }
    }

    public void bDi() {
        if (bgT() != null) {
            List<com.baidu.adp.widget.ListView.h> bCI = bCI();
            List<Integer> bCH = bCH();
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (bCH != null && bCH.size() > 0 && bCI != null && bCI.size() > 0 && threadList != null) {
                int size = bCH.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bCI.size()) {
                        com.baidu.adp.widget.ListView.h hVar = bCI.get(i);
                        int bQ = bQ(bCH.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bQ + "  Title:" + hVar.getType());
                        threadList.add(bQ, hVar);
                    }
                }
            }
        }
    }

    private int bQ(int i, int i2) {
        return Math.min((aHd() + i) - 1, i2);
    }

    public bb vy(String str) {
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

    public void a(com.baidu.tbadk.data.j jVar) {
        if (this.threadList != null && jVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next != null && (next instanceof bb) && ((bb) next).zG() != null && currentAccount.equals(((bb) next).zG().getUserId()) && ((bb) next).zG().getPendantData() != null) {
                        ((bb) next).zG().getPendantData().ap(jVar.LF());
                        ((bb) next).zG().getPendantData().ej(jVar.ys());
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
        c(iVar.yE());
        a(iVar.bCo());
        nq(iVar.bCk());
        vu(iVar.bCl());
        c(iVar.bgT());
        setGameName(iVar.getGameName());
        vv(iVar.bCr());
        a(iVar.bCm());
        nr(iVar.bCp());
        sl(iVar.bhi());
        vz(iVar.bCs());
        a(iVar.yS());
        a(iVar.bCi());
        dH(iVar.bCq());
        ay(iVar.getThreadList());
        dG(iVar.bCn());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.bCj());
        vA(iVar.bCx());
        this.hmO = iVar.hmO;
        dJ(iVar.bCu());
        vx(iVar.bCv());
        at(iVar.bCw());
        a(iVar.bCy());
        vB(iVar.bCB());
        a(iVar.bCC());
        a(iVar.bCD());
        vw(iVar.bCf());
        a(iVar.bCF());
        vx(iVar.bCg());
        vy(iVar.bCh());
        this.hlK = iVar.hlK;
        this.hme = iVar.hme;
        this.hmi = iVar.hmi;
        a(iVar.bCz());
        q(iVar.bCG());
        a(iVar.bCA());
        dK(iVar.bCH());
        dL(iVar.bCI());
        this.hmv = iVar.hmv;
        a(iVar.bCJ());
        a(iVar.bCc());
        a(iVar.bCK());
        dM(iVar.bCL());
        vC(iVar.bCM());
        a(iVar.bCd());
        a(iVar.bCN());
        a(iVar.bCO());
        this.hmE = iVar.hmE;
        b(iVar.bCP());
        this.recm_forum_list = iVar.bCe();
        b(iVar.bCQ());
        this.dQM = iVar.dQM;
        this.hmF = iVar.hmF;
        this.hmf = iVar.hmf;
        this.hmG = iVar.hmG;
        this.hmH = iVar.hmH;
        ns(iVar.bCE());
        this.isBrandForum = iVar.isBrandForum;
        this.hmJ = iVar.hmJ;
        this.hmK = iVar.hmK;
        this.hmL = iVar.hmL;
        com.baidu.tieba.frs.a.aAJ().b(yE());
        com.baidu.tieba.frs.a.aAJ().setForumId(iVar.bgT().getId());
        d(iVar.bCS());
        this.hmN = iVar.hmN;
        this.hmP = iVar.hmP;
        this.hmQ = iVar.hmQ;
        this.hmR = iVar.hmR;
        return true;
    }

    public NebulaHotThreads bDj() {
        return this.hmR;
    }

    public void bDk() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fSF != null && this.fSF.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if (hVar instanceof bb) {
                    bb bbVar = (bb) hVar;
                    if (bbVar == null || (!bbVar.Ah() && bbVar.zD() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.fSF.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar2 = new h();
                hVar2.setForumId(this.fSF.getId());
                hVar2.dF(feedForumList);
                this.threadList.add(i + 6, hVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void nt(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.I(this.threadList)) {
            bDl();
            if (bCJ() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                    if (hVar instanceof bb) {
                        bb bbVar = (bb) hVar;
                        if (bbVar == null || (!bbVar.Ah() && bbVar.zD() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bCJ().aJN() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((bCJ().aJN() + i) - 1, bCJ());
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

    public void bDl() {
        if (!com.baidu.tbadk.core.util.v.I(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.h.b.enB) {
                    it.remove();
                }
            }
        }
    }

    public boolean bDm() {
        com.baidu.tieba.card.data.n recomTopicData;
        if (this.threadList == null || this.fSF == null || this.fSF.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
            if (hVar instanceof bb) {
                bb bbVar = (bb) hVar;
                if (bbVar == null || (!bbVar.Ah() && bbVar.zD() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fSF.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.H(recomTopicData.dbm) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new am("c10835").aA("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bDn() {
        if (MessageManager.getInstance().findTask(2003016) != null) {
            int bCB = (bCB() + aHd()) - 1;
            if (bCC() != null && bCB >= 0 && bCB <= this.threadList.size()) {
                this.threadList.add(bCB, bCC());
            }
        }
    }

    public void bDo() {
        int AG;
        if (bCN() != null) {
            com.baidu.tieba.frs.q bCN = bCN();
            if (com.baidu.tbadk.core.util.v.H(bCN.getUserInfo()) >= 3 && (AG = bCN.AG()) > 0) {
                int aHd = AG + aHd();
                if (aHd > this.threadList.size()) {
                    this.threadList.add(bCN);
                } else {
                    this.threadList.add(aHd, bCN);
                }
            }
        }
    }

    public void bDp() {
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

    public void bDq() {
        if (bCO() != null && !com.baidu.tbadk.core.util.v.I(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == k.hnh) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, bCO());
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bDr() {
        return this.hmo;
    }

    public void dN(List<com.baidu.adp.widget.ListView.h> list) {
        this.hmo = list;
    }

    public boolean bDs() {
        if (bCi() == null) {
            return false;
        }
        return bCi().bCT() == 1;
    }

    public boolean bDt() {
        return (bCD() == null || com.baidu.tbadk.core.util.v.I(bCD().tab)) ? false : true;
    }

    public void a(BannerListData bannerListData) {
        this.bNS = true;
        this.hnj = bannerListData;
    }
}
