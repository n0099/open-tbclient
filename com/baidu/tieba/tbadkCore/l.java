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
import tbclient.FrsPage.RecmForumInfo;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class l extends i implements com.baidu.tbadk.mvc.b.l {
    private boolean bJp;
    private int hbF = 0;
    private BannerListData hbG;
    public int hbH;
    public boolean hbl;
    public List<String> hbn;
    public SmartApp hbo;
    public boolean isBrandForum;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fHy.setCurScore(rVar.getCurScore());
            this.fHy.setLevelupScore(rVar.getLevelupScore());
            this.fHy.setLike(rVar.isLike());
            this.fHy.setUser_level(rVar.byv());
            this.fHy.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fHy.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fHy == null) {
            return null;
        }
        return this.fHy.getSignData();
    }

    public void bAR() {
        be top_notice_data;
        com.baidu.adp.widget.ListView.h hVar;
        if (beT() != null && this.threadList != null && (top_notice_data = beT().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (hVar = this.threadList.get(0)) != null && (hVar instanceof bb) && ((bb) hVar).yq() == 2) {
                this.threadList.remove(0);
            }
            bb bbVar = new bb();
            bbVar.setTitle(top_notice_data.getTitle());
            bbVar.setTid(top_notice_data.Ah());
            bbVar.cp(2);
            bbVar.zf();
            this.threadList.add(0, bbVar);
        }
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.threadList != null) {
            int aFg = aFg();
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
            aiVar.arq = this.isBrandForum;
            this.hbF++;
            this.threadList.add(aFg, aiVar);
        }
    }

    public void bAS() {
        this.hbF = 0;
    }

    public int aFg() {
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
                } else if (((bb) next).yq() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    public void bAT() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bb.aoW || this.threadList.get(i2).getType() == bb.aoX || this.threadList.get(i2).getType() == bb.aoY) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bAU() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.eWA != null && this.eWA.xB() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if ((hVar instanceof bb) && hVar.getType() == bb.aqq) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int aFg = aFg();
            if (i > aFg) {
                this.threadList.add(aFg, this.threadList.remove(i));
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
        if (!this.bJp) {
            if (this.fHy != null) {
                bannerListData = this.fHy.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.hbG;
        }
        this.bJp = false;
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
            bVar3.cP(z);
            bVar3.ab(arrayList);
            bVar3.ad(arrayList2);
            bVar3.cQ(z2);
            bVar3.setCurrentPage(xH().xB());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.i
    public List<RecmForumInfo> bzX() {
        return this.recm_forum_list;
    }

    public boolean bAV() {
        return this.isBrandForum;
    }

    private int uB(int i) {
        return Math.min((aFg() + bAl()) - 1, i);
    }

    public void bAW() {
        f bAJ;
        if (this.threadList != null && beT() != null && MessageManager.getInstance().findTask(2911003) != null && (bAJ = bAJ()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.v.J(bAJ.gZF)) {
                threadList.add(bM(1, threadList.size()), bAJ);
            }
        }
    }

    public void bAX() {
        a(f.class, getThreadList());
    }

    public void bAY() {
        e bAI;
        if (this.threadList != null && beT() != null && MessageManager.getInstance().findTask(2911003) != null && (bAI = bAI()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(bM(bAI.gZD, threadList.size()), bAI);
        }
    }

    public void bAZ() {
        a(e.class, getThreadList());
    }

    private int bM(int i, int i2) {
        return Math.min((aFg() + i) - 1, i2);
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

    public void bBa() {
        bb bAp;
        if (beT() != null && (bAp = bAp()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + bAp.getTid());
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(uB(threadList.size()), bAp);
            }
        }
    }

    public void bBb() {
        if (beT() != null) {
            List<com.baidu.adp.widget.ListView.h> bAB = bAB();
            List<Integer> bAA = bAA();
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (bAA != null && bAA.size() > 0 && bAB != null && bAB.size() > 0 && threadList != null) {
                int size = bAA.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bAB.size()) {
                        com.baidu.adp.widget.ListView.h hVar = bAB.get(i);
                        int bN = bN(bAA.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bN + "  Title:" + hVar.getType());
                        threadList.add(bN, hVar);
                    }
                }
            }
        }
    }

    private int bN(int i, int i2) {
        return Math.min((aFg() + i) - 1, i2);
    }

    public bb nJ(String str) {
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
                    if (next != null && (next instanceof bb) && ((bb) next).yv() != null && currentAccount.equals(((bb) next).yv().getUserId()) && ((bb) next).yv().getPendantData() != null) {
                        ((bb) next).yv().getPendantData().af(jVar.Ko());
                        ((bb) next).yv().getPendantData().dR(jVar.xf());
                    }
                }
            }
        }
    }

    public void ab(bb bbVar) {
        this.threadList.remove(bbVar);
    }

    public boolean e(i iVar) {
        if (iVar == null) {
            return false;
        }
        c(iVar.xs());
        a(iVar.bAh());
        na(iVar.bAd());
        uM(iVar.bAe());
        c(iVar.beT());
        setGameName(iVar.getGameName());
        uN(iVar.bAk());
        a(iVar.bAf());
        nb(iVar.bAi());
        rl(iVar.bfi());
        ux(iVar.bAl());
        a(iVar.xH());
        a(iVar.bAb());
        dE(iVar.bAj());
        ay(iVar.getThreadList());
        dD(iVar.bAg());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.bAc());
        uy(iVar.bAq());
        this.hbm = iVar.hbm;
        dG(iVar.bAn());
        uP(iVar.bAo());
        at(iVar.bAp());
        a(iVar.bAr());
        uz(iVar.bAu());
        a(iVar.bAv());
        a(iVar.bAw());
        uu(iVar.bzY());
        a(iVar.bAy());
        uv(iVar.bzZ());
        uw(iVar.bAa());
        this.hai = iVar.hai;
        this.haC = iVar.haC;
        this.haG = iVar.haG;
        a(iVar.bAs());
        q(iVar.bAz());
        a(iVar.bAt());
        dH(iVar.bAA());
        dI(iVar.bAB());
        this.haT = iVar.haT;
        a(iVar.bAC());
        a(iVar.bzV());
        a(iVar.bAD());
        dJ(iVar.bAE());
        uA(iVar.bAF());
        a(iVar.bzW());
        a(iVar.bAG());
        a(iVar.bAH());
        this.hbc = iVar.hbc;
        b(iVar.bAI());
        this.recm_forum_list = iVar.bzX();
        b(iVar.bAJ());
        this.dGk = iVar.dGk;
        this.hbd = iVar.hbd;
        this.haD = iVar.haD;
        this.hbe = iVar.hbe;
        this.hbf = iVar.hbf;
        nc(iVar.bAx());
        this.isBrandForum = iVar.isBrandForum;
        this.hbh = iVar.hbh;
        this.hbi = iVar.hbi;
        this.hbj = iVar.hbj;
        com.baidu.tieba.frs.a.ayM().b(xs());
        com.baidu.tieba.frs.a.ayM().setForumId(iVar.beT().getId());
        d(iVar.bAL());
        this.hbl = iVar.hbl;
        this.hbn = iVar.hbn;
        this.hbo = iVar.hbo;
        return true;
    }

    public void bBc() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fHy != null && this.fHy.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if (hVar instanceof bb) {
                    bb bbVar = (bb) hVar;
                    if (bbVar == null || (!bbVar.yW() && bbVar.ys() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.fHy.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar2 = new h();
                hVar2.setForumId(this.fHy.getId());
                hVar2.dC(feedForumList);
                this.threadList.add(i + 6, hVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void nd(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.J(this.threadList)) {
            bBd();
            if (bAC() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                    if (hVar instanceof bb) {
                        bb bbVar = (bb) hVar;
                        if (bbVar == null || (!bbVar.yW() && bbVar.ys() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bAC().aHJ() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((bAC().aHJ() + i) - 1, bAC());
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

    public void bBd() {
        if (!com.baidu.tbadk.core.util.v.J(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.h.b.ecx) {
                    it.remove();
                }
            }
        }
    }

    public boolean bBe() {
        com.baidu.tieba.card.data.n recomTopicData;
        if (this.threadList == null || this.fHy == null || this.fHy.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
            if (hVar instanceof bb) {
                bb bbVar = (bb) hVar;
                if (bbVar == null || (!bbVar.yW() && bbVar.ys() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fHy.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.I(recomTopicData.cQH) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new am("c10835").ax("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bBf() {
        if (MessageManager.getInstance().findTask(2003016) != null) {
            int bAu = (bAu() + aFg()) - 1;
            if (bAv() != null && bAu >= 0 && bAu <= this.threadList.size()) {
                this.threadList.add(bAu, bAv());
            }
        }
    }

    public void bBg() {
        int zv;
        if (bAG() != null) {
            com.baidu.tieba.frs.q bAG = bAG();
            if (com.baidu.tbadk.core.util.v.I(bAG.getUserInfo()) >= 3 && (zv = bAG.zv()) > 0) {
                int aFg = zv + aFg();
                if (aFg > this.threadList.size()) {
                    this.threadList.add(bAG);
                } else {
                    this.threadList.add(aFg, bAG);
                }
            }
        }
    }

    public void bBh() {
        if (!com.baidu.tbadk.core.util.v.J(this.threadList)) {
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

    public void bBi() {
        if (bAH() != null && !com.baidu.tbadk.core.util.v.J(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == k.hbE) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, bAH());
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bBj() {
        return this.haM;
    }

    public void dK(List<com.baidu.adp.widget.ListView.h> list) {
        this.haM = list;
    }

    public boolean bBk() {
        if (bAb() == null) {
            return false;
        }
        return bAb().bAM() == 1;
    }

    public boolean bBl() {
        return (bAw() == null || com.baidu.tbadk.core.util.v.J(bAw().tab)) ? false : true;
    }

    public void a(BannerListData bannerListData) {
        this.bJp = true;
        this.hbG = bannerListData;
    }
}
