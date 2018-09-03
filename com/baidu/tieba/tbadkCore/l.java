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
    private boolean buS;
    private int gMG = 0;
    private BannerListData gMH;
    public int gMI;
    public boolean gMo;
    public boolean isBrandForum;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fsm.setCurScore(rVar.getCurScore());
            this.fsm.setLevelupScore(rVar.getLevelupScore());
            this.fsm.setLike(rVar.isLike());
            this.fsm.setUser_level(rVar.bsB());
            this.fsm.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fsm.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fsm == null) {
            return null;
        }
        return this.fsm.getSignData();
    }

    public void buW() {
        be top_notice_data;
        com.baidu.adp.widget.ListView.h hVar;
        if (aZg() != null && this.threadList != null && (top_notice_data = aZg().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (hVar = this.threadList.get(0)) != null && (hVar instanceof bb) && ((bb) hVar).ve() == 2) {
                this.threadList.remove(0);
            }
            bb bbVar = new bb();
            bbVar.setTitle(top_notice_data.getTitle());
            bbVar.setTid(top_notice_data.wR());
            bbVar.bV(2);
            bbVar.vR();
            this.threadList.add(0, bbVar);
        }
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.threadList != null) {
            int azE = azE();
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
            this.gMG++;
            this.threadList.add(azE, aiVar);
        }
    }

    public void buX() {
        this.gMG = 0;
    }

    public int azE() {
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
                } else if (((bb) next).ve() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    public void buY() {
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

    public void buZ() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.eHC != null && this.eHC.up() == 1 && this.threadList != null && this.threadList.size() > 0) {
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
            int azE = azE();
            if (i > azE) {
                this.threadList.add(azE, this.threadList.remove(i));
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
        if (!this.buS) {
            if (this.fsm != null) {
                bannerListData = this.fsm.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gMH;
        }
        this.buS = false;
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
            bVar3.cp(z);
            bVar3.R(arrayList);
            bVar3.T(arrayList2);
            bVar3.cq(z2);
            bVar3.ca(uv().up());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.i
    public List<RecmForumInfo> buc() {
        return this.recm_forum_list;
    }

    public boolean bva() {
        return this.isBrandForum;
    }

    private int tE(int i) {
        return Math.min((azE() + buq()) - 1, i);
    }

    public void bvb() {
        f buO;
        if (this.threadList != null && aZg() != null && MessageManager.getInstance().findTask(2911003) != null && (buO = buO()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.w.z(buO.gKJ)) {
                threadList.add(bH(1, threadList.size()), buO);
            }
        }
    }

    public void bvc() {
        a(f.class, getThreadList());
    }

    public void bvd() {
        e buN;
        if (this.threadList != null && aZg() != null && MessageManager.getInstance().findTask(2911003) != null && (buN = buN()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(bH(buN.gKH, threadList.size()), buN);
        }
    }

    public void bve() {
        a(e.class, getThreadList());
    }

    private int bH(int i, int i2) {
        return Math.min((azE() + i) - 1, i2);
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

    public void bvf() {
        bb buu;
        if (aZg() != null && (buu = buu()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + buu.getTid());
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(tE(threadList.size()), buu);
            }
        }
    }

    public void bvg() {
        if (aZg() != null) {
            List<com.baidu.adp.widget.ListView.h> buG = buG();
            List<Integer> buF = buF();
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (buF != null && buF.size() > 0 && buG != null && buG.size() > 0 && threadList != null) {
                int size = buF.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < buG.size()) {
                        com.baidu.adp.widget.ListView.h hVar = buG.get(i);
                        int bI = bI(buF.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bI + "  Title:" + hVar.getType());
                        threadList.add(bI, hVar);
                    }
                }
            }
        }
    }

    private int bI(int i, int i2) {
        return Math.min((azE() + i) - 1, i2);
    }

    public bb mE(String str) {
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
                    if (next != null && (next instanceof bb) && ((bb) next).vj() != null && currentAccount.equals(((bb) next).vj().getUserId()) && ((bb) next).vj().getPendantData() != null) {
                        ((bb) next).vj().getPendantData().Z(iVar.GZ());
                        ((bb) next).vj().getPendantData().dj(iVar.tT());
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
        c(iVar.ug());
        a(iVar.bum());
        mm(iVar.bui());
        tD(iVar.buj());
        c(iVar.aZg());
        setGameName(iVar.getGameName());
        tE(iVar.bup());
        a(iVar.buk());
        mn(iVar.bun());
        qj(iVar.aZv());
        tA(iVar.buq());
        a(iVar.uv());
        a(iVar.bug());
        dp(iVar.buo());
        ax(iVar.getThreadList());
        m17do(iVar.bul());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.buh());
        tB(iVar.buv());
        this.gMp = iVar.gMp;
        dr(iVar.bus());
        tG(iVar.but());
        as(iVar.buu());
        a(iVar.buw());
        tC(iVar.buz());
        a(iVar.buA());
        a(iVar.buB());
        tx(iVar.bud());
        a(iVar.buD());
        ty(iVar.bue());
        tz(iVar.buf());
        this.gLl = iVar.gLl;
        this.gLF = iVar.gLF;
        this.gLJ = iVar.gLJ;
        a(iVar.bux());
        q(iVar.buE());
        a(iVar.buy());
        ds(iVar.buF());
        dt(iVar.buG());
        this.gLW = iVar.gLW;
        a(iVar.buH());
        a(iVar.bua());
        a(iVar.buI());
        du(iVar.buJ());
        tD(iVar.buK());
        a(iVar.bub());
        a(iVar.buL());
        a(iVar.buM());
        this.gMf = iVar.gMf;
        b(iVar.buN());
        this.recm_forum_list = iVar.buc();
        b(iVar.buO());
        this.drT = iVar.drT;
        this.gMg = iVar.gMg;
        this.gLG = iVar.gLG;
        this.gMh = iVar.gMh;
        this.gMi = iVar.gMi;
        mo(iVar.buC());
        this.isBrandForum = iVar.isBrandForum;
        this.gMk = iVar.gMk;
        this.gMl = iVar.gMl;
        this.gMm = iVar.gMm;
        com.baidu.tieba.frs.a.atC().b(ug());
        com.baidu.tieba.frs.a.atC().setForumId(iVar.aZg().getId());
        d(iVar.buQ());
        this.gMo = iVar.gMo;
        return true;
    }

    public void bvh() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fsm != null && this.fsm.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if (hVar instanceof bb) {
                    bb bbVar = (bb) hVar;
                    if (bbVar == null || (!bbVar.vJ() && bbVar.vg() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.fsm.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar2 = new h();
                hVar2.setForumId(this.fsm.getId());
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
            bvi();
            if (buH() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                    if (hVar instanceof bb) {
                        bb bbVar = (bb) hVar;
                        if (bbVar == null || (!bbVar.vJ() && bbVar.vg() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((buH().aCe() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((buH().aCe() + i) - 1, buH());
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

    public void bvi() {
        if (!com.baidu.tbadk.core.util.w.z(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.h.b.dNm) {
                    it.remove();
                }
            }
        }
    }

    public boolean bvj() {
        com.baidu.tieba.card.data.n recomTopicData;
        if (this.threadList == null || this.fsm == null || this.fsm.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
            if (hVar instanceof bb) {
                bb bbVar = (bb) hVar;
                if (bbVar == null || (!bbVar.vJ() && bbVar.vg() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fsm.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.w.y(recomTopicData.cCx) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new an("c10835").ae("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bvk() {
        if (MessageManager.getInstance().findTask(2003016) != null) {
            int buz = (buz() + azE()) - 1;
            if (buA() != null && buz >= 0 && buz <= this.threadList.size()) {
                this.threadList.add(buz, buA());
            }
        }
    }

    public void bvl() {
        int wh;
        if (buL() != null) {
            com.baidu.tieba.frs.q buL = buL();
            if (com.baidu.tbadk.core.util.w.y(buL.getUserInfo()) >= 3 && (wh = buL.wh()) > 0) {
                int azE = wh + azE();
                if (azE > this.threadList.size()) {
                    this.threadList.add(buL);
                } else {
                    this.threadList.add(azE, buL);
                }
            }
        }
    }

    public void bvm() {
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

    public void bvn() {
        if (buM() != null && !com.baidu.tbadk.core.util.w.z(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == k.gMF) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, buM());
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bvo() {
        return this.gLP;
    }

    public void dv(List<com.baidu.adp.widget.ListView.h> list) {
        this.gLP = list;
    }

    public boolean bvp() {
        if (bug() == null) {
            return false;
        }
        return bug().buR() == 1;
    }

    public boolean bvq() {
        return (buB() == null || com.baidu.tbadk.core.util.w.z(buB().tab)) ? false : true;
    }

    public void a(BannerListData bannerListData) {
        this.buS = true;
        this.gMH = bannerListData;
    }
}
