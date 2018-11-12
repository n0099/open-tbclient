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
    private boolean bKa;
    public boolean hcJ;
    public List<String> hcL;
    public SmartApp hcM;
    private int hdd = 0;
    private BannerListData hde;
    public int hdf;
    public boolean isBrandForum;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fIX.setCurScore(rVar.getCurScore());
            this.fIX.setLevelupScore(rVar.getLevelupScore());
            this.fIX.setLike(rVar.isLike());
            this.fIX.setUser_level(rVar.bxR());
            this.fIX.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fIX.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fIX == null) {
            return null;
        }
        return this.fIX.getSignData();
    }

    public void bAn() {
        be top_notice_data;
        com.baidu.adp.widget.ListView.h hVar;
        if (ber() != null && this.threadList != null && (top_notice_data = ber().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (hVar = this.threadList.get(0)) != null && (hVar instanceof bb) && ((bb) hVar).yx() == 2) {
                this.threadList.remove(0);
            }
            bb bbVar = new bb();
            bbVar.setTitle(top_notice_data.getTitle());
            bbVar.setTid(top_notice_data.Ao());
            bbVar.cD(2);
            bbVar.zm();
            this.threadList.add(0, bbVar);
        }
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.threadList != null) {
            int aEC = aEC();
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
            aiVar.asd = this.isBrandForum;
            this.hdd++;
            this.threadList.add(aEC, aiVar);
        }
    }

    public void bAo() {
        this.hdd = 0;
    }

    public int aEC() {
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
                } else if (((bb) next).yx() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    public void bAp() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bb.apK || this.threadList.get(i2).getType() == bb.apL || this.threadList.get(i2).getType() == bb.apM) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bAq() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.eXT != null && this.eXT.xJ() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if ((hVar instanceof bb) && hVar.getType() == bb.ard) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int aEC = aEC();
            if (i > aEC) {
                this.threadList.add(aEC, this.threadList.remove(i));
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
        if (!this.bKa) {
            if (this.fIX != null) {
                bannerListData = this.fIX.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.hde;
        }
        this.bKa = false;
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
            bVar3.dg(z);
            bVar3.aa(arrayList);
            bVar3.ac(arrayList2);
            bVar3.dh(z2);
            bVar3.setCurrentPage(xO().xJ());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.i
    public List<RecmForumInfo> bzt() {
        return this.recm_forum_list;
    }

    public boolean bAr() {
        return this.isBrandForum;
    }

    private int uU(int i) {
        return Math.min((aEC() + bzH()) - 1, i);
    }

    public void bAs() {
        f bAf;
        if (this.threadList != null && ber() != null && MessageManager.getInstance().findTask(2911003) != null && (bAf = bAf()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.v.I(bAf.hbe)) {
                threadList.add(bQ(1, threadList.size()), bAf);
            }
        }
    }

    public void bAt() {
        a(f.class, getThreadList());
    }

    public void bAu() {
        e bAe;
        if (this.threadList != null && ber() != null && MessageManager.getInstance().findTask(2911003) != null && (bAe = bAe()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(bQ(bAe.hbc, threadList.size()), bAe);
        }
    }

    public void bAv() {
        a(e.class, getThreadList());
    }

    private int bQ(int i, int i2) {
        return Math.min((aEC() + i) - 1, i2);
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

    public void bAw() {
        bb bzL;
        if (ber() != null && (bzL = bzL()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + bzL.getTid());
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(uU(threadList.size()), bzL);
            }
        }
    }

    public void bAx() {
        if (ber() != null) {
            List<com.baidu.adp.widget.ListView.h> bzX = bzX();
            List<Integer> bzW = bzW();
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (bzW != null && bzW.size() > 0 && bzX != null && bzX.size() > 0 && threadList != null) {
                int size = bzW.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bzX.size()) {
                        com.baidu.adp.widget.ListView.h hVar = bzX.get(i);
                        int bR = bR(bzW.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bR + "  Title:" + hVar.getType());
                        threadList.add(bR, hVar);
                    }
                }
            }
        }
    }

    private int bR(int i, int i2) {
        return Math.min((aEC() + i) - 1, i2);
    }

    public bb uU(String str) {
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
                    if (next != null && (next instanceof bb) && ((bb) next).yC() != null && currentAccount.equals(((bb) next).yC().getUserId()) && ((bb) next).yC().getPendantData() != null) {
                        ((bb) next).yC().getPendantData().ah(jVar.KA());
                        ((bb) next).yC().getPendantData().dR(jVar.xn());
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
        c(iVar.xA());
        a(iVar.bzD());
        nl(iVar.bzz());
        uQ(iVar.bzA());
        c(iVar.ber());
        setGameName(iVar.getGameName());
        uR(iVar.bzG());
        a(iVar.bzB());
        nm(iVar.bzE());
        rE(iVar.beG());
        uQ(iVar.bzH());
        a(iVar.xO());
        a(iVar.bzx());
        dC(iVar.bzF());
        ax(iVar.getThreadList());
        dB(iVar.bzC());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.bzy());
        uR(iVar.bzM());
        this.hcK = iVar.hcK;
        dE(iVar.bzJ());
        uT(iVar.bzK());
        at(iVar.bzL());
        a(iVar.bzN());
        uS(iVar.bzQ());
        a(iVar.bzR());
        a(iVar.bzS());
        uN(iVar.bzu());
        a(iVar.bzU());
        uO(iVar.bzv());
        uP(iVar.bzw());
        this.hbG = iVar.hbG;
        this.hca = iVar.hca;
        this.hce = iVar.hce;
        a(iVar.bzO());
        q(iVar.bzV());
        a(iVar.bzP());
        dF(iVar.bzW());
        dG(iVar.bzX());
        this.hcr = iVar.hcr;
        a(iVar.bzY());
        a(iVar.bzr());
        a(iVar.bzZ());
        dH(iVar.bAa());
        uT(iVar.bAb());
        a(iVar.bzs());
        a(iVar.bAc());
        a(iVar.bAd());
        this.hcA = iVar.hcA;
        b(iVar.bAe());
        this.recm_forum_list = iVar.bzt();
        b(iVar.bAf());
        this.dHz = iVar.dHz;
        this.hcB = iVar.hcB;
        this.hcb = iVar.hcb;
        this.hcC = iVar.hcC;
        this.hcD = iVar.hcD;
        nn(iVar.bzT());
        this.isBrandForum = iVar.isBrandForum;
        this.hcF = iVar.hcF;
        this.hcG = iVar.hcG;
        this.hcH = iVar.hcH;
        com.baidu.tieba.frs.a.ayk().b(xA());
        com.baidu.tieba.frs.a.ayk().setForumId(iVar.ber().getId());
        d(iVar.bAh());
        this.hcJ = iVar.hcJ;
        this.hcL = iVar.hcL;
        this.hcM = iVar.hcM;
        return true;
    }

    public void bAy() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fIX != null && this.fIX.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if (hVar instanceof bb) {
                    bb bbVar = (bb) hVar;
                    if (bbVar == null || (!bbVar.zd() && bbVar.yz() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.fIX.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar2 = new h();
                hVar2.setForumId(this.fIX.getId());
                hVar2.dA(feedForumList);
                this.threadList.add(i + 6, hVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void no(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.I(this.threadList)) {
            bAz();
            if (bzY() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                    if (hVar instanceof bb) {
                        bb bbVar = (bb) hVar;
                        if (bbVar == null || (!bbVar.zd() && bbVar.yz() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bzY().aHh() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((bzY().aHh() + i) - 1, bzY());
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

    public void bAz() {
        if (!com.baidu.tbadk.core.util.v.I(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.h.b.edS) {
                    it.remove();
                }
            }
        }
    }

    public boolean bAA() {
        com.baidu.tieba.card.data.n recomTopicData;
        if (this.threadList == null || this.fIX == null || this.fIX.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
            if (hVar instanceof bb) {
                bb bbVar = (bb) hVar;
                if (bbVar == null || (!bbVar.zd() && bbVar.yz() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fIX.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.H(recomTopicData.cRN) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new am("c10835").ax("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bAB() {
        if (MessageManager.getInstance().findTask(2003016) != null) {
            int bzQ = (bzQ() + aEC()) - 1;
            if (bzR() != null && bzQ >= 0 && bzQ <= this.threadList.size()) {
                this.threadList.add(bzQ, bzR());
            }
        }
    }

    public void bAC() {
        int zC;
        if (bAc() != null) {
            com.baidu.tieba.frs.q bAc = bAc();
            if (com.baidu.tbadk.core.util.v.H(bAc.getUserInfo()) >= 3 && (zC = bAc.zC()) > 0) {
                int aEC = zC + aEC();
                if (aEC > this.threadList.size()) {
                    this.threadList.add(bAc);
                } else {
                    this.threadList.add(aEC, bAc);
                }
            }
        }
    }

    public void bAD() {
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

    public void bAE() {
        if (bAd() != null && !com.baidu.tbadk.core.util.v.I(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == k.hdc) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, bAd());
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bAF() {
        return this.hck;
    }

    public void dI(List<com.baidu.adp.widget.ListView.h> list) {
        this.hck = list;
    }

    public boolean bAG() {
        if (bzx() == null) {
            return false;
        }
        return bzx().bAi() == 1;
    }

    public boolean bAH() {
        return (bzS() == null || com.baidu.tbadk.core.util.v.I(bzS().tab)) ? false : true;
    }

    public void a(BannerListData bannerListData) {
        this.bKa = true;
        this.hde = bannerListData;
    }
}
