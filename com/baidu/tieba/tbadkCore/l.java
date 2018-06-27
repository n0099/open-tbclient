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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes2.dex */
public class l extends i implements com.baidu.tbadk.mvc.b.l {
    private boolean buk;
    private int gLG = 0;
    private BannerListData gLH;
    public int gLI;
    public boolean isBrandForum;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fsh.setCurScore(rVar.getCurScore());
            this.fsh.setLevelupScore(rVar.getLevelupScore());
            this.fsh.setLike(rVar.isLike());
            this.fsh.setUser_level(rVar.btX());
            this.fsh.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fsh.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fsh == null) {
            return null;
        }
        return this.fsh.getSignData();
    }

    public void bwr() {
        bf top_notice_data;
        com.baidu.adp.widget.ListView.h hVar;
        if (baT() != null && this.threadList != null && (top_notice_data = baT().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (hVar = this.threadList.get(0)) != null && (hVar instanceof bc) && ((bc) hVar).vr() == 2) {
                this.threadList.remove(0);
            }
            bc bcVar = new bc();
            bcVar.setTitle(top_notice_data.getTitle());
            bcVar.dk(top_notice_data.xa());
            bcVar.bT(2);
            bcVar.wd();
            this.threadList.add(0, bcVar);
        }
    }

    public void a(aj ajVar) {
        if (ajVar != null && !StringUtils.isNull(ajVar.getId()) && this.threadList != null) {
            int azb = azb();
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.h hVar = threadList.get(i);
                    if ((hVar instanceof bc) && ajVar.getId().equals(((bc) hVar).getId())) {
                        return;
                    }
                }
            }
            ajVar.aku = this.isBrandForum;
            this.gLG++;
            this.threadList.add(azb, ajVar);
        }
    }

    public void bws() {
        this.gLG = 0;
    }

    public int azb() {
        int i = 0;
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (!(next instanceof bc)) {
                    i = i2;
                } else if (((bc) next).vr() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    public void bwt() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bc.aif || this.threadList.get(i2).getType() == bc.aig || this.threadList.get(i2).getType() == bc.aih) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bwu() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.eDN != null && this.eDN.uD() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if ((hVar instanceof bc) && hVar.getType() == bc.ajw) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int azb = azb();
            if (i > azb) {
                this.threadList.add(azb, this.threadList.remove(i));
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
        if (!this.buk) {
            if (this.fsh != null) {
                bannerListData = this.fsh.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gLH;
        }
        this.buk = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar2.T(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.co(z);
            bVar3.S(arrayList);
            bVar3.U(arrayList2);
            bVar3.cp(z2);
            bVar3.bY(uJ().uD());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.i
    public List<RecmForumInfo> bvx() {
        return this.recm_forum_list;
    }

    public boolean bwv() {
        return this.isBrandForum;
    }

    private int tG(int i) {
        return Math.min((azb() + bvL()) - 1, i);
    }

    public void bww() {
        f bwj;
        if (this.threadList != null && baT() != null && MessageManager.getInstance().findTask(2911003) != null && (bwj = bwj()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.w.A(bwj.gJL)) {
                threadList.add(bG(1, threadList.size()), bwj);
            }
        }
    }

    public void bwx() {
        a(f.class, getThreadList());
    }

    public void bwy() {
        e bwi;
        if (this.threadList != null && baT() != null && MessageManager.getInstance().findTask(2911003) != null && (bwi = bwi()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(bG(bwi.gJJ, threadList.size()), bwi);
        }
    }

    public void bwz() {
        a(e.class, getThreadList());
    }

    private int bG(int i, int i2) {
        return Math.min((azb() + i) - 1, i2);
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

    public void bwA() {
        bc bvP;
        if (baT() != null && (bvP = bvP()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + bvP.getTid());
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(tG(threadList.size()), bvP);
            }
        }
    }

    public void bwB() {
        if (baT() != null) {
            List<com.baidu.adp.widget.ListView.h> bwb = bwb();
            List<Integer> bwa = bwa();
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (bwa != null && bwa.size() > 0 && bwb != null && bwb.size() > 0 && threadList != null) {
                int size = bwa.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bwb.size()) {
                        com.baidu.adp.widget.ListView.h hVar = bwb.get(i);
                        int bH = bH(bwa.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bH + "  Title:" + hVar.getType());
                        threadList.add(bH, hVar);
                    }
                }
            }
        }
    }

    private int bH(int i, int i2) {
        return Math.min((azb() + i) - 1, i2);
    }

    public bc mD(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.h next = it.next();
            if (next != null && (next instanceof bc) && TextUtils.equals(str, ((bc) next).getId())) {
                return (bc) next;
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
                    if (next != null && (next instanceof bc) && ((bc) next).vw() != null && currentAccount.equals(((bc) next).vw().getUserId()) && ((bc) next).vw().getPendantData() != null) {
                        ((bc) next).vw().getPendantData().X(iVar.Hd());
                        ((bc) next).vw().getPendantData().dm(iVar.uh());
                    }
                }
            }
        }
    }

    public void Y(bc bcVar) {
        this.threadList.remove(bcVar);
    }

    public boolean e(i iVar) {
        if (iVar == null) {
            return false;
        }
        c(iVar.uu());
        a(iVar.bvH());
        mB(iVar.bvD());
        tB(iVar.bvE());
        c(iVar.baT());
        setGameName(iVar.getGameName());
        tC(iVar.bvK());
        a(iVar.bvF());
        mC(iVar.bvI());
        qm(iVar.bbi());
        tC(iVar.bvL());
        a(iVar.uJ());
        a(iVar.bvB());
        dt(iVar.bvJ());
        az(iVar.getThreadList());
        ds(iVar.bvG());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.bvC());
        tD(iVar.bvQ());
        this.gLp = iVar.gLp;
        dv(iVar.bvN());
        tE(iVar.bvO());
        ar(iVar.bvP());
        a(iVar.bvR());
        tE(iVar.bvU());
        a(iVar.bvV());
        a(iVar.bvW());
        tz(iVar.bvy());
        a(iVar.bvY());
        tA(iVar.bvz());
        tB(iVar.bvA());
        this.gKm = iVar.gKm;
        this.gKG = iVar.gKG;
        this.gKK = iVar.gKK;
        a(iVar.bvS());
        q(iVar.bvZ());
        a(iVar.bvT());
        dw(iVar.bwa());
        dx(iVar.bwb());
        this.gKX = iVar.gKX;
        a(iVar.bwc());
        a(iVar.bvv());
        a(iVar.bwd());
        dy(iVar.bwe());
        tF(iVar.bwf());
        a(iVar.bvw());
        a(iVar.bwg());
        a(iVar.bwh());
        this.gLg = iVar.gLg;
        b(iVar.bwi());
        this.recm_forum_list = iVar.bvx();
        b(iVar.bwj());
        this.dpj = iVar.dpj;
        this.gLh = iVar.gLh;
        this.gKH = iVar.gKH;
        this.gLi = iVar.gLi;
        this.gLj = iVar.gLj;
        mD(iVar.bvX());
        this.isBrandForum = iVar.isBrandForum;
        this.gLl = iVar.gLl;
        this.gLm = iVar.gLm;
        this.gLn = iVar.gLn;
        com.baidu.tieba.frs.a.asZ().b(uu());
        com.baidu.tieba.frs.a.asZ().setForumId(iVar.baT().getId());
        d(iVar.bwl());
        return true;
    }

    public void bwC() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fsh != null && this.fsh.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if (hVar instanceof bc) {
                    bc bcVar = (bc) hVar;
                    if (bcVar == null || (!bcVar.vV() && bcVar.vt() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.fsh.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar2 = new h();
                hVar2.setForumId(this.fsh.getId());
                hVar2.dr(feedForumList);
                this.threadList.add(i + 6, hVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mE(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.w.A(this.threadList)) {
            bwD();
            if (bwc() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                    if (hVar instanceof bc) {
                        bc bcVar = (bc) hVar;
                        if (bcVar == null || (!bcVar.vV() && bcVar.vt() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bwc().aBy() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((bwc().aBy() + i) - 1, bwc());
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

    public void bwD() {
        if (!com.baidu.tbadk.core.util.w.A(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.h.b.dKD) {
                    it.remove();
                }
            }
        }
    }

    public boolean bwE() {
        com.baidu.tieba.card.data.n recomTopicData;
        if (this.threadList == null || this.fsh == null || this.fsh.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
            if (hVar instanceof bc) {
                bc bcVar = (bc) hVar;
                if (bcVar == null || (!bcVar.vV() && bcVar.vt() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fsh.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.w.z(recomTopicData.czV) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new an("c10835").ah("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bwF() {
        if (MessageManager.getInstance().findTask(2003016) != null) {
            int bvU = (bvU() + azb()) - 1;
            if (bvV() != null && bvU >= 0 && bvU <= this.threadList.size()) {
                this.threadList.add(bvU, bvV());
            }
        }
    }

    public void bwG() {
        int wt;
        if (bwg() != null) {
            com.baidu.tieba.frs.q bwg = bwg();
            if (com.baidu.tbadk.core.util.w.z(bwg.getUserInfo()) >= 3 && (wt = bwg.wt()) > 0) {
                int azb = wt + azb();
                if (azb > this.threadList.size()) {
                    this.threadList.add(bwg);
                } else {
                    this.threadList.add(azb, bwg);
                }
            }
        }
    }

    public void bwH() {
        if (!com.baidu.tbadk.core.util.w.A(this.threadList)) {
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

    public void bwI() {
        if (bwh() != null && !com.baidu.tbadk.core.util.w.A(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == k.gLF) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, bwh());
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bwJ() {
        return this.gKQ;
    }

    public void dz(List<com.baidu.adp.widget.ListView.h> list) {
        this.gKQ = list;
    }

    public boolean bwK() {
        if (bvB() == null) {
            return false;
        }
        return bvB().bwm() == 1;
    }

    public boolean bwL() {
        return (bvW() == null || com.baidu.tbadk.core.util.w.A(bvW().tab)) ? false : true;
    }

    public void a(BannerListData bannerListData) {
        this.buk = true;
        this.gLH = bannerListData;
    }
}
