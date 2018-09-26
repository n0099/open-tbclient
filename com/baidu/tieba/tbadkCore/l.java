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
/* loaded from: classes2.dex */
public class l extends i implements com.baidu.tbadk.mvc.b.l {
    private boolean bAH;
    public boolean gTQ;
    public List<String> gTS;
    public SmartApp gTT;
    private int gUk = 0;
    private BannerListData gUl;
    public int gUm;
    public boolean isBrandForum;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fzW.setCurScore(rVar.getCurScore());
            this.fzW.setLevelupScore(rVar.getLevelupScore());
            this.fzW.setLike(rVar.isLike());
            this.fzW.setUser_level(rVar.bvg());
            this.fzW.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fzW.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fzW == null) {
            return null;
        }
        return this.fzW.getSignData();
    }

    public void bxC() {
        be top_notice_data;
        com.baidu.adp.widget.ListView.h hVar;
        if (bbH() != null && this.threadList != null && (top_notice_data = bbH().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (hVar = this.threadList.get(0)) != null && (hVar instanceof bb) && ((bb) hVar).wh() == 2) {
                this.threadList.remove(0);
            }
            bb bbVar = new bb();
            bbVar.setTitle(top_notice_data.getTitle());
            bbVar.setTid(top_notice_data.xY());
            bbVar.ce(2);
            bbVar.wW();
            this.threadList.add(0, bbVar);
        }
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.threadList != null) {
            int aBN = aBN();
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
            aiVar.amv = this.isBrandForum;
            this.gUk++;
            this.threadList.add(aBN, aiVar);
        }
    }

    public void bxD() {
        this.gUk = 0;
    }

    public int aBN() {
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
                } else if (((bb) next).wh() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    public void bxE() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bb.akb || this.threadList.get(i2).getType() == bb.akc || this.threadList.get(i2).getType() == bb.akd) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bxF() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.eOS != null && this.eOS.vs() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if ((hVar instanceof bb) && hVar.getType() == bb.alv) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int aBN = aBN();
            if (i > aBN) {
                this.threadList.add(aBN, this.threadList.remove(i));
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
        if (!this.bAH) {
            if (this.fzW != null) {
                bannerListData = this.fzW.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gUl;
        }
        this.bAH = false;
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
            bVar3.cG(z);
            bVar3.S(arrayList);
            bVar3.U(arrayList2);
            bVar3.cH(z2);
            bVar3.cj(vy().vs());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.i
    public List<RecmForumInfo> bwI() {
        return this.recm_forum_list;
    }

    public boolean bxG() {
        return this.isBrandForum;
    }

    private int ue(int i) {
        return Math.min((aBN() + bwW()) - 1, i);
    }

    public void bxH() {
        f bxu;
        if (this.threadList != null && bbH() != null && MessageManager.getInstance().findTask(2911003) != null && (bxu = bxu()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.v.z(bxu.gSk)) {
                threadList.add(bJ(1, threadList.size()), bxu);
            }
        }
    }

    public void bxI() {
        a(f.class, getThreadList());
    }

    public void bxJ() {
        e bxt;
        if (this.threadList != null && bbH() != null && MessageManager.getInstance().findTask(2911003) != null && (bxt = bxt()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(bJ(bxt.gSi, threadList.size()), bxt);
        }
    }

    public void bxK() {
        a(e.class, getThreadList());
    }

    private int bJ(int i, int i2) {
        return Math.min((aBN() + i) - 1, i2);
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

    public void bxL() {
        bb bxa;
        if (bbH() != null && (bxa = bxa()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + bxa.getTid());
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(ue(threadList.size()), bxa);
            }
        }
    }

    public void bxM() {
        if (bbH() != null) {
            List<com.baidu.adp.widget.ListView.h> bxm = bxm();
            List<Integer> bxl = bxl();
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (bxl != null && bxl.size() > 0 && bxm != null && bxm.size() > 0 && threadList != null) {
                int size = bxl.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bxm.size()) {
                        com.baidu.adp.widget.ListView.h hVar = bxm.get(i);
                        int bK = bK(bxl.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bK + "  Title:" + hVar.getType());
                        threadList.add(bK, hVar);
                    }
                }
            }
        }
    }

    private int bK(int i, int i2) {
        return Math.min((aBN() + i) - 1, i2);
    }

    public bb nh(String str) {
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
                    if (next != null && (next instanceof bb) && ((bb) next).wm() != null && currentAccount.equals(((bb) next).wm().getUserId()) && ((bb) next).wm().getPendantData() != null) {
                        ((bb) next).wm().getPendantData().ad(jVar.Ip());
                        ((bb) next).wm().getPendantData().dB(jVar.uW());
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
        c(iVar.vj());
        a(iVar.bwS());
        mJ(iVar.bwO());
        uk(iVar.bwP());
        c(iVar.bbH());
        setGameName(iVar.getGameName());
        ul(iVar.bwV());
        a(iVar.bwQ());
        mK(iVar.bwT());
        qN(iVar.bbW());
        ua(iVar.bwW());
        a(iVar.vy());
        a(iVar.bwM());
        dq(iVar.bwU());
        ay(iVar.getThreadList());
        dp(iVar.bwR());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.bwN());
        ub(iVar.bxb());
        this.gTR = iVar.gTR;
        ds(iVar.bwY());
        un(iVar.bwZ());
        at(iVar.bxa());
        a(iVar.bxc());
        uc(iVar.bxf());
        a(iVar.bxg());
        a(iVar.bxh());
        tX(iVar.bwJ());
        a(iVar.bxj());
        tY(iVar.bwK());
        tZ(iVar.bwL());
        this.gSN = iVar.gSN;
        this.gTh = iVar.gTh;
        this.gTl = iVar.gTl;
        a(iVar.bxd());
        q(iVar.bxk());
        a(iVar.bxe());
        dt(iVar.bxl());
        du(iVar.bxm());
        this.gTy = iVar.gTy;
        a(iVar.bxn());
        a(iVar.bwG());
        a(iVar.bxo());
        dv(iVar.bxp());
        ud(iVar.bxq());
        a(iVar.bwH());
        a(iVar.bxr());
        a(iVar.bxs());
        this.gTH = iVar.gTH;
        b(iVar.bxt());
        this.recm_forum_list = iVar.bwI();
        b(iVar.bxu());
        this.dyj = iVar.dyj;
        this.gTI = iVar.gTI;
        this.gTi = iVar.gTi;
        this.gTJ = iVar.gTJ;
        this.gTK = iVar.gTK;
        mL(iVar.bxi());
        this.isBrandForum = iVar.isBrandForum;
        this.gTM = iVar.gTM;
        this.gTN = iVar.gTN;
        this.gTO = iVar.gTO;
        com.baidu.tieba.frs.a.avq().b(vj());
        com.baidu.tieba.frs.a.avq().setForumId(iVar.bbH().getId());
        d(iVar.bxw());
        this.gTQ = iVar.gTQ;
        this.gTS = iVar.gTS;
        this.gTT = iVar.gTT;
        return true;
    }

    public void bxN() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fzW != null && this.fzW.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if (hVar instanceof bb) {
                    bb bbVar = (bb) hVar;
                    if (bbVar == null || (!bbVar.wN() && bbVar.wj() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.fzW.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar2 = new h();
                hVar2.setForumId(this.fzW.getId());
                hVar2.m20do(feedForumList);
                this.threadList.add(i + 6, hVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mM(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.z(this.threadList)) {
            bxO();
            if (bxn() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                    if (hVar instanceof bb) {
                        bb bbVar = (bb) hVar;
                        if (bbVar == null || (!bbVar.wN() && bbVar.wj() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bxn().aEr() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((bxn().aEr() + i) - 1, bxn());
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

    public void bxO() {
        if (!com.baidu.tbadk.core.util.v.z(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.h.b.dUE) {
                    it.remove();
                }
            }
        }
    }

    public boolean bxP() {
        com.baidu.tieba.card.data.n recomTopicData;
        if (this.threadList == null || this.fzW == null || this.fzW.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
            if (hVar instanceof bb) {
                bb bbVar = (bb) hVar;
                if (bbVar == null || (!bbVar.wN() && bbVar.wj() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fzW.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.y(recomTopicData.cIo) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new am("c10835").al("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bxQ() {
        if (MessageManager.getInstance().findTask(2003016) != null) {
            int bxf = (bxf() + aBN()) - 1;
            if (bxg() != null && bxf >= 0 && bxf <= this.threadList.size()) {
                this.threadList.add(bxf, bxg());
            }
        }
    }

    public void bxR() {
        int xm;
        if (bxr() != null) {
            com.baidu.tieba.frs.q bxr = bxr();
            if (com.baidu.tbadk.core.util.v.y(bxr.getUserInfo()) >= 3 && (xm = bxr.xm()) > 0) {
                int aBN = xm + aBN();
                if (aBN > this.threadList.size()) {
                    this.threadList.add(bxr);
                } else {
                    this.threadList.add(aBN, bxr);
                }
            }
        }
    }

    public void bxS() {
        if (!com.baidu.tbadk.core.util.v.z(this.threadList)) {
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

    public void bxT() {
        if (bxs() != null && !com.baidu.tbadk.core.util.v.z(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == k.gUj) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, bxs());
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bxU() {
        return this.gTr;
    }

    public void dw(List<com.baidu.adp.widget.ListView.h> list) {
        this.gTr = list;
    }

    public boolean bxV() {
        if (bwM() == null) {
            return false;
        }
        return bwM().bxx() == 1;
    }

    public boolean bxW() {
        return (bxh() == null || com.baidu.tbadk.core.util.v.z(bxh().tab)) ? false : true;
    }

    public void a(BannerListData bannerListData) {
        this.bAH = true;
        this.gUl = bannerListData;
    }
}
