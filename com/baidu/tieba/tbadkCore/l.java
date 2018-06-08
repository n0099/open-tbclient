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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes2.dex */
public class l extends i implements com.baidu.tbadk.mvc.b.l {
    private boolean bsI;
    private int gHH = 0;
    private BannerListData gHI;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fon.setCurScore(rVar.getCurScore());
            this.fon.setLevelupScore(rVar.getLevelupScore());
            this.fon.setLike(rVar.isLike());
            this.fon.setUser_level(rVar.btx());
            this.fon.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fon.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fon == null) {
            return null;
        }
        return this.fon.getSignData();
    }

    public void bvR() {
        bg top_notice_data;
        com.baidu.adp.widget.ListView.h hVar;
        if (bam() != null && this.threadList != null && (top_notice_data = bam().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (hVar = this.threadList.get(0)) != null && (hVar instanceof bd) && ((bd) hVar).vh() == 2) {
                this.threadList.remove(0);
            }
            bd bdVar = new bd();
            bdVar.setTitle(top_notice_data.getTitle());
            bdVar.dh(top_notice_data.wN());
            bdVar.bS(2);
            bdVar.vT();
            this.threadList.add(0, bdVar);
        }
    }

    public void a(aj ajVar) {
        if (ajVar != null && !StringUtils.isNull(ajVar.getId()) && this.threadList != null) {
            int ayv = ayv();
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.h hVar = threadList.get(i);
                    if ((hVar instanceof bd) && ajVar.getId().equals(((bd) hVar).getId())) {
                        return;
                    }
                }
            }
            this.gHH++;
            this.threadList.add(ayv, ajVar);
        }
    }

    public void bvS() {
        this.gHH = 0;
    }

    public int ayv() {
        int i = 0;
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (!(next instanceof bd)) {
                    i = i2;
                } else if (((bd) next).vh() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    public void bvT() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bd.ahN || this.threadList.get(i2).getType() == bd.ahO || this.threadList.get(i2).getType() == bd.ahP) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bvU() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.ezX != null && this.ezX.uv() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if ((hVar instanceof bd) && hVar.getType() == bd.ajb) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int ayv = ayv();
            if (i > ayv) {
                this.threadList.add(ayv, this.threadList.remove(i));
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
        if (!this.bsI) {
            if (this.fon != null) {
                bannerListData = this.fon.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gHI;
        }
        this.bsI = false;
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
            bVar3.cl(z);
            bVar3.R(arrayList);
            bVar3.T(arrayList2);
            bVar3.cm(z2);
            bVar3.bX(uB().uv());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.i
    public List<RecmForumInfo> buX() {
        return this.recm_forum_list;
    }

    private int tu(int i) {
        return Math.min((ayv() + bvl()) - 1, i);
    }

    public void bvV() {
        f bvJ;
        if (this.threadList != null && bam() != null && MessageManager.getInstance().findTask(2911003) != null && (bvJ = bvJ()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.w.z(bvJ.gFS)) {
                threadList.add(bH(1, threadList.size()), bvJ);
            }
        }
    }

    public void bvW() {
        a(f.class, getThreadList());
    }

    public void bvX() {
        e bvI;
        if (this.threadList != null && bam() != null && MessageManager.getInstance().findTask(2911003) != null && (bvI = bvI()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(bH(bvI.gFQ, threadList.size()), bvI);
        }
    }

    public void bvY() {
        a(e.class, getThreadList());
    }

    private int bH(int i, int i2) {
        return Math.min((ayv() + i) - 1, i2);
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

    public void bvZ() {
        bd bvp;
        if (bam() != null && (bvp = bvp()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + bvp.getTid());
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(tu(threadList.size()), bvp);
            }
        }
    }

    public void bwa() {
        if (bam() != null) {
            List<com.baidu.adp.widget.ListView.h> bvB = bvB();
            List<Integer> bvA = bvA();
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (bvA != null && bvA.size() > 0 && bvB != null && bvB.size() > 0 && threadList != null) {
                int size = bvA.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bvB.size()) {
                        com.baidu.adp.widget.ListView.h hVar = bvB.get(i);
                        int bI = bI(bvA.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bI + "  Title:" + hVar.getType());
                        threadList.add(bI, hVar);
                    }
                }
            }
        }
    }

    private int bI(int i, int i2) {
        return Math.min((ayv() + i) - 1, i2);
    }

    public bd mD(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.h next = it.next();
            if (next != null && (next instanceof bd) && TextUtils.equals(str, ((bd) next).getId())) {
                return (bd) next;
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
                    if (next != null && (next instanceof bd) && ((bd) next).vm() != null && currentAccount.equals(((bd) next).vm().getUserId()) && ((bd) next).vm().getPendantData() != null) {
                        ((bd) next).vm().getPendantData().W(iVar.GL());
                        ((bd) next).vm().getPendantData().dj(iVar.ub());
                    }
                }
            }
        }
    }

    public void an(bd bdVar) {
        this.threadList.remove(bdVar);
    }

    public boolean e(i iVar) {
        if (iVar == null) {
            return false;
        }
        c(iVar.uo());
        a(iVar.bvh());
        mq(iVar.bvd());
        tC(iVar.bve());
        c(iVar.bam());
        setGameName(iVar.getGameName());
        tD(iVar.bvk());
        a(iVar.bvf());
        mr(iVar.bvi());
        qf(iVar.baB());
        tq(iVar.bvl());
        a(iVar.uB());
        a(iVar.bvb());
        dp(iVar.bvj());
        av(iVar.getThreadList());
        m17do(iVar.bvg());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.bvc());
        tr(iVar.bvq());
        dr(iVar.bvn());
        tF(iVar.bvo());
        am(iVar.bvp());
        a(iVar.bvr());
        ts(iVar.bvu());
        a(iVar.bvv());
        a(iVar.bvw());
        tn(iVar.buY());
        a(iVar.bvy());
        to(iVar.buZ());
        tp(iVar.bva());
        this.gGr = iVar.gGr;
        this.gGL = iVar.gGL;
        this.gGP = iVar.gGP;
        a(iVar.bvs());
        q(iVar.bvz());
        a(iVar.bvt());
        ds(iVar.bvA());
        dt(iVar.bvB());
        this.gHc = iVar.gHc;
        a(iVar.bvC());
        a(iVar.buV());
        a(iVar.bvD());
        du(iVar.bvE());
        tt(iVar.bvF());
        a(iVar.buW());
        a(iVar.bvG());
        a(iVar.bvH());
        this.gHl = iVar.gHl;
        b(iVar.bvI());
        this.recm_forum_list = iVar.buX();
        b(iVar.bvJ());
        this.dmy = iVar.dmy;
        this.gHm = iVar.gHm;
        this.gGM = iVar.gGM;
        this.gHn = iVar.gHn;
        this.gHo = iVar.gHo;
        ms(iVar.bvx());
        d(iVar.bvL());
        return true;
    }

    public void bwb() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fon != null && this.fon.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if (hVar instanceof bd) {
                    bd bdVar = (bd) hVar;
                    if (bdVar == null || (!bdVar.vL() && bdVar.vj() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.fon.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar2 = new h();
                hVar2.setForumId(this.fon.getId());
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
    public void mt(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.w.z(this.threadList)) {
            bwc();
            if (bvC() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                    if (hVar instanceof bd) {
                        bd bdVar = (bd) hVar;
                        if (bdVar == null || (!bdVar.vL() && bdVar.vj() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bvC().aAS() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((bvC().aAS() + i) - 1, bvC());
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

    public void bwc() {
        if (!com.baidu.tbadk.core.util.w.z(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.h.b.dHk) {
                    it.remove();
                }
            }
        }
    }

    public boolean bwd() {
        com.baidu.tieba.card.data.n recomTopicData;
        if (this.threadList == null || this.fon == null || this.fon.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
            if (hVar instanceof bd) {
                bd bdVar = (bd) hVar;
                if (bdVar == null || (!bdVar.vL() && bdVar.vj() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fon.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.w.y(recomTopicData.cCb) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new am("c10835").ah("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bwe() {
        if (MessageManager.getInstance().findTask(2003016) != null) {
            int bvu = (bvu() + ayv()) - 1;
            if (bvv() != null && bvu >= 0 && bvu <= this.threadList.size()) {
                this.threadList.add(bvu, bvv());
            }
        }
    }

    public void bwf() {
        int wj;
        if (bvG() != null) {
            com.baidu.tieba.frs.o bvG = bvG();
            if (com.baidu.tbadk.core.util.w.y(bvG.getUserInfo()) >= 3 && (wj = bvG.wj()) > 0) {
                int ayv = wj + ayv();
                if (ayv > this.threadList.size()) {
                    this.threadList.add(bvG);
                } else {
                    this.threadList.add(ayv, bvG);
                }
            }
        }
    }

    public void bwg() {
        if (!com.baidu.tbadk.core.util.w.z(this.threadList)) {
            boolean z = false;
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (true) {
                boolean z2 = z;
                if (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.o) {
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

    public void bwh() {
        if (bvH() != null && !com.baidu.tbadk.core.util.w.z(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == k.gHG) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, bvH());
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bwi() {
        return this.gGV;
    }

    public void dv(List<com.baidu.adp.widget.ListView.h> list) {
        this.gGV = list;
    }

    public boolean bwj() {
        if (bvb() == null) {
            return false;
        }
        return bvb().bvM() == 1;
    }

    public boolean bwk() {
        return (bvw() == null || com.baidu.tbadk.core.util.w.z(bvw().tab)) ? false : true;
    }

    public void a(BannerListData bannerListData) {
        this.bsI = true;
        this.gHI = bannerListData;
    }
}
