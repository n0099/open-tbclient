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
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes2.dex */
public class l extends i implements com.baidu.tbadk.mvc.b.l {
    private boolean buQ;
    private int gME = 0;
    private BannerListData gMF;
    public int gMG;
    public boolean gMm;
    public boolean isBrandForum;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fst.setCurScore(rVar.getCurScore());
            this.fst.setLevelupScore(rVar.getLevelupScore());
            this.fst.setLike(rVar.isLike());
            this.fst.setUser_level(rVar.bsA());
            this.fst.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fst.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fst == null) {
            return null;
        }
        return this.fst.getSignData();
    }

    public void buV() {
        be top_notice_data;
        com.baidu.adp.widget.ListView.h hVar;
        if (aZl() != null && this.threadList != null && (top_notice_data = aZl().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (hVar = this.threadList.get(0)) != null && (hVar instanceof bb) && ((bb) hVar).vf() == 2) {
                this.threadList.remove(0);
            }
            bb bbVar = new bb();
            bbVar.setTitle(top_notice_data.getTitle());
            bbVar.dh(top_notice_data.wS());
            bbVar.bV(2);
            bbVar.vS();
            this.threadList.add(0, bbVar);
        }
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.threadList != null) {
            int azH = azH();
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
            aiVar.ajR = this.isBrandForum;
            this.gME++;
            this.threadList.add(azH, aiVar);
        }
    }

    public void buW() {
        this.gME = 0;
    }

    public int azH() {
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
                } else if (((bb) next).vf() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    public void buX() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bb.ahB || this.threadList.get(i2).getType() == bb.ahC || this.threadList.get(i2).getType() == bb.ahD) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void buY() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.eHH != null && this.eHH.uq() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if ((hVar instanceof bb) && hVar.getType() == bb.aiT) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int azH = azH();
            if (i > azH) {
                this.threadList.add(azH, this.threadList.remove(i));
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
        if (!this.buQ) {
            if (this.fst != null) {
                bannerListData = this.fst.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gMF;
        }
        this.buQ = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar2.S(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.co(z);
            bVar3.R(arrayList);
            bVar3.T(arrayList2);
            bVar3.cp(z2);
            bVar3.ca(uw().uq());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.i
    public List<RecmForumInfo> bub() {
        return this.recm_forum_list;
    }

    public boolean buZ() {
        return this.isBrandForum;
    }

    private int tE(int i) {
        return Math.min((azH() + bup()) - 1, i);
    }

    public void bva() {
        f buN;
        if (this.threadList != null && aZl() != null && MessageManager.getInstance().findTask(2911003) != null && (buN = buN()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.w.z(buN.gKH)) {
                threadList.add(bH(1, threadList.size()), buN);
            }
        }
    }

    public void bvb() {
        a(f.class, getThreadList());
    }

    public void bvc() {
        e buM;
        if (this.threadList != null && aZl() != null && MessageManager.getInstance().findTask(2911003) != null && (buM = buM()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(bH(buM.gKF, threadList.size()), buM);
        }
    }

    public void bvd() {
        a(e.class, getThreadList());
    }

    private int bH(int i, int i2) {
        return Math.min((azH() + i) - 1, i2);
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

    public void bve() {
        bb but;
        if (aZl() != null && (but = but()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + but.getTid());
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(tE(threadList.size()), but);
            }
        }
    }

    public void bvf() {
        if (aZl() != null) {
            List<com.baidu.adp.widget.ListView.h> buF = buF();
            List<Integer> buE = buE();
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (buE != null && buE.size() > 0 && buF != null && buF.size() > 0 && threadList != null) {
                int size = buE.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < buF.size()) {
                        com.baidu.adp.widget.ListView.h hVar = buF.get(i);
                        int bI = bI(buE.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bI + "  Title:" + hVar.getType());
                        threadList.add(bI, hVar);
                    }
                }
            }
        }
    }

    private int bI(int i, int i2) {
        return Math.min((azH() + i) - 1, i2);
    }

    public bb mC(String str) {
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

    public void a(com.baidu.tbadk.data.i iVar) {
        if (this.threadList != null && iVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next != null && (next instanceof bb) && ((bb) next).vk() != null && currentAccount.equals(((bb) next).vk().getUserId()) && ((bb) next).vk().getPendantData() != null) {
                        ((bb) next).vk().getPendantData().Z(iVar.GZ());
                        ((bb) next).vk().getPendantData().dj(iVar.tU());
                    }
                }
            }
        }
    }

    public void aa(bb bbVar) {
        this.threadList.remove(bbVar);
    }

    public boolean e(i iVar) {
        if (iVar == null) {
            return false;
        }
        c(iVar.uh());
        a(iVar.bul());
        mm(iVar.buh());
        tz(iVar.bui());
        c(iVar.aZl());
        setGameName(iVar.getGameName());
        tA(iVar.buo());
        a(iVar.buj());
        mn(iVar.bum());
        qj(iVar.aZA());
        tA(iVar.bup());
        a(iVar.uw());
        a(iVar.buf());
        dp(iVar.bun());
        ax(iVar.getThreadList());
        m17do(iVar.buk());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.bug());
        tB(iVar.buu());
        this.gMn = iVar.gMn;
        dr(iVar.bur());
        tC(iVar.bus());
        as(iVar.but());
        a(iVar.buv());
        tC(iVar.buy());
        a(iVar.buz());
        a(iVar.buA());
        tx(iVar.buc());
        a(iVar.buC());
        ty(iVar.bud());
        tz(iVar.bue());
        this.gLj = iVar.gLj;
        this.gLD = iVar.gLD;
        this.gLH = iVar.gLH;
        a(iVar.buw());
        q(iVar.buD());
        a(iVar.bux());
        ds(iVar.buE());
        dt(iVar.buF());
        this.gLU = iVar.gLU;
        a(iVar.buG());
        a(iVar.btZ());
        a(iVar.buH());
        du(iVar.buI());
        tD(iVar.buJ());
        a(iVar.bua());
        a(iVar.buK());
        a(iVar.buL());
        this.gMd = iVar.gMd;
        b(iVar.buM());
        this.recm_forum_list = iVar.bub();
        b(iVar.buN());
        this.drW = iVar.drW;
        this.gMe = iVar.gMe;
        this.gLE = iVar.gLE;
        this.gMf = iVar.gMf;
        this.gMg = iVar.gMg;
        mo(iVar.buB());
        this.isBrandForum = iVar.isBrandForum;
        this.gMi = iVar.gMi;
        this.gMj = iVar.gMj;
        this.gMk = iVar.gMk;
        com.baidu.tieba.frs.a.atD().b(uh());
        com.baidu.tieba.frs.a.atD().setForumId(iVar.aZl().getId());
        d(iVar.buP());
        this.gMm = iVar.gMm;
        return true;
    }

    public void bvg() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fst != null && this.fst.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if (hVar instanceof bb) {
                    bb bbVar = (bb) hVar;
                    if (bbVar == null || (!bbVar.vK() && bbVar.vh() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.fst.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar2 = new h();
                hVar2.setForumId(this.fst.getId());
                hVar2.dn(feedForumList);
                this.threadList.add(i + 6, hVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mp(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.w.z(this.threadList)) {
            bvh();
            if (buG() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                    if (hVar instanceof bb) {
                        bb bbVar = (bb) hVar;
                        if (bbVar == null || (!bbVar.vK() && bbVar.vh() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((buG().aCh() + i) - 1 < this.threadList.size()) {
                    String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("game_rank_list_info", "");
                    if (StringUtils.isNull(string) || string.split(",").length != 2) {
                        z2 = true;
                    } else {
                        z2 = UtilHelper.getDayBetweenTime(com.baidu.adp.lib.g.b.c(string.split(",")[0], 0L), System.currentTimeMillis()) >= ((long) com.baidu.adp.lib.g.b.g(string.split(",")[1], 0));
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
                                this.threadList.add((buG().aCh() + i) - 1, buG());
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

    public void bvh() {
        if (!com.baidu.tbadk.core.util.w.z(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.h.b.dNq) {
                    it.remove();
                }
            }
        }
    }

    public boolean bvi() {
        com.baidu.tieba.card.data.n recomTopicData;
        if (this.threadList == null || this.fst == null || this.fst.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
            if (hVar instanceof bb) {
                bb bbVar = (bb) hVar;
                if (bbVar == null || (!bbVar.vK() && bbVar.vh() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fst.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.w.y(recomTopicData.cCA) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new an("c10835").af("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bvj() {
        if (MessageManager.getInstance().findTask(2003016) != null) {
            int buy = (buy() + azH()) - 1;
            if (buz() != null && buy >= 0 && buy <= this.threadList.size()) {
                this.threadList.add(buy, buz());
            }
        }
    }

    public void bvk() {
        int wi;
        if (buK() != null) {
            com.baidu.tieba.frs.q buK = buK();
            if (com.baidu.tbadk.core.util.w.y(buK.getUserInfo()) >= 3 && (wi = buK.wi()) > 0) {
                int azH = wi + azH();
                if (azH > this.threadList.size()) {
                    this.threadList.add(buK);
                } else {
                    this.threadList.add(azH, buK);
                }
            }
        }
    }

    public void bvl() {
        if (!com.baidu.tbadk.core.util.w.z(this.threadList)) {
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

    public void bvm() {
        if (buL() != null && !com.baidu.tbadk.core.util.w.z(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == k.gMD) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, buL());
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bvn() {
        return this.gLN;
    }

    public void dv(List<com.baidu.adp.widget.ListView.h> list) {
        this.gLN = list;
    }

    public boolean bvo() {
        if (buf() == null) {
            return false;
        }
        return buf().buQ() == 1;
    }

    public boolean bvp() {
        return (buA() == null || com.baidu.tbadk.core.util.w.z(buA().tab)) ? false : true;
    }

    public void a(BannerListData bannerListData) {
        this.buQ = true;
        this.gMF = bannerListData;
    }
}
