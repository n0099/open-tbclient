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
import com.baidu.tbadk.core.util.al;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes2.dex */
public class l extends i implements com.baidu.tbadk.mvc.b.l {
    private boolean bkE;
    private int gwi = 0;
    private BannerListData gwj;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fcS.setCurScore(rVar.getCurScore());
            this.fcS.setLevelupScore(rVar.getLevelupScore());
            this.fcS.setLike(rVar.isLike());
            this.fcS.setUser_level(rVar.box());
            this.fcS.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fcS.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fcS == null) {
            return null;
        }
        return this.fcS.getSignData();
    }

    public void bqP() {
        bg top_notice_data;
        com.baidu.adp.widget.ListView.h hVar;
        if (aVq() != null && this.threadList != null && (top_notice_data = aVq().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (hVar = this.threadList.get(0)) != null && (hVar instanceof bd) && ((bd) hVar).rK() == 2) {
                this.threadList.remove(0);
            }
            bd bdVar = new bd();
            bdVar.setTitle(top_notice_data.getTitle());
            bdVar.cJ(top_notice_data.tp());
            bdVar.bQ(2);
            bdVar.sw();
            this.threadList.add(0, bdVar);
        }
    }

    public void a(aj ajVar) {
        if (ajVar != null && !StringUtils.isNull(ajVar.getId()) && this.threadList != null) {
            int aui = aui();
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
            this.gwi++;
            this.threadList.add(aui, ajVar);
        }
    }

    public void bqQ() {
        this.gwi = 0;
    }

    public int aui() {
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
                } else if (((bd) next).rK() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    public void bqR() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bd.ZL || this.threadList.get(i2).getType() == bd.ZM || this.threadList.get(i2).getType() == bd.ZN) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bqS() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.eoG != null && this.eoG.qZ() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if ((hVar instanceof bd) && hVar.getType() == bd.aaW) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int aui = aui();
            if (i > aui) {
                this.threadList.add(aui, this.threadList.remove(i));
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
        if (!this.bkE) {
            if (this.fcS != null) {
                bannerListData = this.fcS.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gwj;
        }
        this.bkE = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar2.P(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.cg(z);
            bVar3.O(arrayList);
            bVar3.Q(arrayList2);
            bVar3.ch(z2);
            bVar3.bV(rf().qZ());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.i
    public List<RecmForumInfo> bpW() {
        return this.recm_forum_list;
    }

    private int ti(int i) {
        return Math.min((aui() + bql()) - 1, i);
    }

    public void bqT() {
        f bqJ;
        if (this.threadList != null && aVq() != null && MessageManager.getInstance().findTask(2911003) != null && (bqJ = bqJ()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.v.w(bqJ.guu)) {
                threadList.add(bF(1, threadList.size()), bqJ);
            }
        }
    }

    public void bqU() {
        a(f.class, getThreadList());
    }

    public void bqV() {
        e bqI;
        if (this.threadList != null && aVq() != null && MessageManager.getInstance().findTask(2911003) != null && (bqI = bqI()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(bF(bqI.gus, threadList.size()), bqI);
        }
    }

    public void bqW() {
        a(e.class, getThreadList());
    }

    private int bF(int i, int i2) {
        return Math.min((aui() + i) - 1, i2);
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

    public void bqX() {
        bd bqp;
        if (aVq() != null && (bqp = bqp()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + bqp.getTid());
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(ti(threadList.size()), bqp);
            }
        }
    }

    public void bqY() {
        if (aVq() != null) {
            List<com.baidu.adp.widget.ListView.h> bqB = bqB();
            List<Integer> bqA = bqA();
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (bqA != null && bqA.size() > 0 && bqB != null && bqB.size() > 0 && threadList != null) {
                int size = bqA.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bqB.size()) {
                        com.baidu.adp.widget.ListView.h hVar = bqB.get(i);
                        int bG = bG(bqA.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bG + "  Title:" + hVar.getType());
                        threadList.add(bG, hVar);
                    }
                }
            }
        }
    }

    private int bG(int i, int i2) {
        return Math.min((aui() + i) - 1, i2);
    }

    public bd lW(String str) {
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

    public void a(com.baidu.tbadk.data.h hVar) {
        if (this.threadList != null && hVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next != null && (next instanceof bd) && ((bd) next).rP() != null && currentAccount.equals(((bd) next).rP().getUserId()) && ((bd) next).rP().getPendantData() != null) {
                        ((bd) next).rP().getPendantData().T(hVar.Di());
                        ((bd) next).rP().getPendantData().cL(hVar.qF());
                    }
                }
            }
        }
    }

    public void al(bd bdVar) {
        this.threadList.remove(bdVar);
    }

    public boolean e(i iVar) {
        if (iVar == null) {
            return false;
        }
        c(iVar.qS());
        a(iVar.bqg());
        mk(iVar.bqc());
        sL(iVar.bqd());
        c(iVar.aVq());
        setGameName(iVar.getGameName());
        sM(iVar.bqj());
        a(iVar.bqe());
        ml(iVar.bqh());
        pT(iVar.aVF());
        te(iVar.bql());
        a(iVar.rf());
        a(iVar.bqa());
        dk(iVar.bqi());
        av(iVar.getThreadList());
        dj(iVar.bqf());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.bqb());
        dl(iVar.bqk());
        tf(iVar.bqq());
        dn(iVar.bqn());
        sO(iVar.bqo());
        ak(iVar.bqp());
        a(iVar.bqr());
        tg(iVar.bqu());
        a(iVar.bqv());
        a(iVar.bqw());
        tb(iVar.bpX());
        a(iVar.bqy());
        tc(iVar.bpY());
        td(iVar.bpZ());
        this.guT = iVar.guT;
        this.gvo = iVar.gvo;
        this.gvs = iVar.gvs;
        a(iVar.bqs());
        k(iVar.bqz());
        a(iVar.bqt());
        m19do(iVar.bqA());
        dp(iVar.bqB());
        this.gvF = iVar.gvF;
        a(iVar.bqC());
        a(iVar.bpU());
        a(iVar.bqD());
        dq(iVar.bqE());
        th(iVar.bqF());
        a(iVar.bpV());
        a(iVar.bqG());
        a(iVar.bqH());
        this.gvO = iVar.gvO;
        b(iVar.bqI());
        this.recm_forum_list = iVar.bpW();
        b(iVar.bqJ());
        this.ddj = iVar.ddj;
        this.gvP = iVar.gvP;
        this.gvp = iVar.gvp;
        this.gvQ = iVar.gvQ;
        this.gvR = iVar.gvR;
        mm(iVar.bqx());
        return true;
    }

    public void bqZ() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fcS != null && this.fcS.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if (hVar instanceof bd) {
                    bd bdVar = (bd) hVar;
                    if (bdVar == null || (!bdVar.so() && bdVar.rM() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.fcS.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar2 = new h();
                hVar2.setForumId(this.fcS.getId());
                hVar2.di(feedForumList);
                this.threadList.add(i + 6, hVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mn(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.w(this.threadList)) {
            bra();
            if (bqC() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                    if (hVar instanceof bd) {
                        bd bdVar = (bd) hVar;
                        if (bdVar == null || (!bdVar.so() && bdVar.rM() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bqC().awa() + i) - 1 < this.threadList.size()) {
                    String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("game_rank_list_info", "");
                    if (StringUtils.isNull(string) || string.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length != 2) {
                        z2 = true;
                    } else {
                        z2 = UtilHelper.getDayBetweenTime(com.baidu.adp.lib.g.b.c(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0], 0L), System.currentTimeMillis()) >= ((long) com.baidu.adp.lib.g.b.g(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1], 0));
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
                                this.threadList.add((bqC().awa() + i) - 1, bqC());
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

    public void bra() {
        if (!com.baidu.tbadk.core.util.v.w(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.h.b.dwa) {
                    it.remove();
                }
            }
        }
    }

    public boolean brb() {
        com.baidu.tieba.card.data.n recomTopicData;
        if (this.threadList == null || this.fcS == null || this.fcS.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
            if (hVar instanceof bd) {
                bd bdVar = (bd) hVar;
                if (bdVar == null || (!bdVar.so() && bdVar.rM() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fcS.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.v(recomTopicData.ctw) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new al("c10835").ac("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void brc() {
        if (MessageManager.getInstance().findTask(2003016) != null) {
            int bqu = (bqu() + aui()) - 1;
            if (bqv() != null && bqu >= 0 && bqu <= this.threadList.size()) {
                this.threadList.add(bqu, bqv());
            }
        }
    }

    public void brd() {
        int sM;
        if (bqG() != null) {
            com.baidu.tieba.frs.o bqG = bqG();
            if (com.baidu.tbadk.core.util.v.v(bqG.getUserInfo()) >= 3 && (sM = bqG.sM()) > 0) {
                int aui = sM + aui();
                if (aui > this.threadList.size()) {
                    this.threadList.add(bqG);
                } else {
                    this.threadList.add(aui, bqG);
                }
            }
        }
    }

    public void bre() {
        if (!com.baidu.tbadk.core.util.v.w(this.threadList)) {
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

    public void brf() {
        if (bqH() != null && !com.baidu.tbadk.core.util.v.w(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == k.gwh) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, bqH());
        }
    }

    public List<com.baidu.adp.widget.ListView.h> brg() {
        return this.gvy;
    }

    public void dr(List<com.baidu.adp.widget.ListView.h> list) {
        this.gvy = list;
    }

    public boolean brh() {
        if (bqa() == null) {
            return false;
        }
        return bqa().bqK() == 1;
    }

    public boolean bri() {
        return bqw() == null ? !com.baidu.tbadk.core.util.v.w(bqk()) : !com.baidu.tbadk.core.util.v.w(bqw().tab);
    }

    public void a(BannerListData bannerListData) {
        this.bkE = true;
        this.gwj = bannerListData;
    }
}
