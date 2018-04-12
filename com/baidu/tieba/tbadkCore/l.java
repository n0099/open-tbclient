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
    private boolean bkp;
    private int gvh = 0;
    private BannerListData gvi;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fbO.setCurScore(rVar.getCurScore());
            this.fbO.setLevelupScore(rVar.getLevelupScore());
            this.fbO.setLike(rVar.isLike());
            this.fbO.setUser_level(rVar.boz());
            this.fbO.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fbO.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fbO == null) {
            return null;
        }
        return this.fbO.getSignData();
    }

    public void bqR() {
        bg top_notice_data;
        com.baidu.adp.widget.ListView.h hVar;
        if (aVq() != null && this.threadList != null && (top_notice_data = aVq().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (hVar = this.threadList.get(0)) != null && (hVar instanceof bd) && ((bd) hVar).rL() == 2) {
                this.threadList.remove(0);
            }
            bd bdVar = new bd();
            bdVar.setTitle(top_notice_data.getTitle());
            bdVar.cJ(top_notice_data.tq());
            bdVar.bQ(2);
            bdVar.sx();
            this.threadList.add(0, bdVar);
        }
    }

    public void a(aj ajVar) {
        if (ajVar != null && !StringUtils.isNull(ajVar.getId()) && this.threadList != null) {
            int auj = auj();
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
            this.gvh++;
            this.threadList.add(auj, ajVar);
        }
    }

    public void bqS() {
        this.gvh = 0;
    }

    public int auj() {
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
                } else if (((bd) next).rL() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    public void bqT() {
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

    public void bqU() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.enA != null && this.enA.ra() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if ((hVar instanceof bd) && hVar.getType() == bd.aaV) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int auj = auj();
            if (i > auj) {
                this.threadList.add(auj, this.threadList.remove(i));
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
        if (!this.bkp) {
            if (this.fbO != null) {
                bannerListData = this.fbO.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gvi;
        }
        this.bkp = false;
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
            bVar3.bV(rg().ra());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.i
    public List<RecmForumInfo> bpY() {
        return this.recm_forum_list;
    }

    private int tk(int i) {
        return Math.min((auj() + bqn()) - 1, i);
    }

    public void bqV() {
        f bqL;
        if (this.threadList != null && aVq() != null && MessageManager.getInstance().findTask(2911003) != null && (bqL = bqL()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.v.w(bqL.gtt)) {
                threadList.add(bG(1, threadList.size()), bqL);
            }
        }
    }

    public void bqW() {
        a(f.class, getThreadList());
    }

    public void bqX() {
        e bqK;
        if (this.threadList != null && aVq() != null && MessageManager.getInstance().findTask(2911003) != null && (bqK = bqK()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(bG(bqK.gtr, threadList.size()), bqK);
        }
    }

    public void bqY() {
        a(e.class, getThreadList());
    }

    private int bG(int i, int i2) {
        return Math.min((auj() + i) - 1, i2);
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

    public void bqZ() {
        bd bqr;
        if (aVq() != null && (bqr = bqr()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + bqr.getTid());
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(tk(threadList.size()), bqr);
            }
        }
    }

    public void bra() {
        if (aVq() != null) {
            List<com.baidu.adp.widget.ListView.h> bqD = bqD();
            List<Integer> bqC = bqC();
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (bqC != null && bqC.size() > 0 && bqD != null && bqD.size() > 0 && threadList != null) {
                int size = bqC.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bqD.size()) {
                        com.baidu.adp.widget.ListView.h hVar = bqD.get(i);
                        int bH = bH(bqC.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bH + "  Title:" + hVar.getType());
                        threadList.add(bH, hVar);
                    }
                }
            }
        }
    }

    private int bH(int i, int i2) {
        return Math.min((auj() + i) - 1, i2);
    }

    public bd lT(String str) {
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
                    if (next != null && (next instanceof bd) && ((bd) next).rQ() != null && currentAccount.equals(((bd) next).rQ().getUserId()) && ((bd) next).rQ().getPendantData() != null) {
                        ((bd) next).rQ().getPendantData().T(hVar.Dk());
                        ((bd) next).rQ().getPendantData().cL(hVar.qG());
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
        c(iVar.qT());
        a(iVar.bqi());
        mj(iVar.bqe());
        sI(iVar.bqf());
        c(iVar.aVq());
        setGameName(iVar.getGameName());
        sJ(iVar.bql());
        a(iVar.bqg());
        mk(iVar.bqj());
        pV(iVar.aVF());
        tg(iVar.bqn());
        a(iVar.rg());
        a(iVar.bqc());
        dh(iVar.bqk());
        av(iVar.getThreadList());
        dg(iVar.bqh());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.bqd());
        di(iVar.bqm());
        th(iVar.bqs());
        dk(iVar.bqp());
        sL(iVar.bqq());
        ak(iVar.bqr());
        a(iVar.bqt());
        ti(iVar.bqw());
        a(iVar.bqx());
        a(iVar.bqy());
        td(iVar.bpZ());
        a(iVar.bqA());
        te(iVar.bqa());
        tf(iVar.bqb());
        this.gtS = iVar.gtS;
        this.gun = iVar.gun;
        this.gur = iVar.gur;
        a(iVar.bqu());
        k(iVar.bqB());
        a(iVar.bqv());
        dl(iVar.bqC());
        dm(iVar.bqD());
        this.guE = iVar.guE;
        a(iVar.bqE());
        a(iVar.bpW());
        a(iVar.bqF());
        dn(iVar.bqG());
        tj(iVar.bqH());
        a(iVar.bpX());
        a(iVar.bqI());
        a(iVar.bqJ());
        this.guN = iVar.guN;
        b(iVar.bqK());
        this.recm_forum_list = iVar.bpY();
        b(iVar.bqL());
        this.dce = iVar.dce;
        this.guO = iVar.guO;
        this.guo = iVar.guo;
        this.guP = iVar.guP;
        this.guQ = iVar.guQ;
        ml(iVar.bqz());
        return true;
    }

    public void brb() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fbO != null && this.fbO.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                if (hVar instanceof bd) {
                    bd bdVar = (bd) hVar;
                    if (bdVar == null || (!bdVar.sp() && bdVar.rN() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.fbO.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar2 = new h();
                hVar2.setForumId(this.fbO.getId());
                hVar2.df(feedForumList);
                this.threadList.add(i + 6, hVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mm(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.w(this.threadList)) {
            brc();
            if (bqE() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
                    if (hVar instanceof bd) {
                        bd bdVar = (bd) hVar;
                        if (bdVar == null || (!bdVar.sp() && bdVar.rN() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bqE().awb() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((bqE().awb() + i) - 1, bqE());
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

    public void brc() {
        if (!com.baidu.tbadk.core.util.v.w(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.h.b.duW) {
                    it.remove();
                }
            }
        }
    }

    public boolean brd() {
        com.baidu.tieba.card.data.n recomTopicData;
        if (this.threadList == null || this.fbO == null || this.fbO.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.h hVar = this.threadList.get(i2);
            if (hVar instanceof bd) {
                bd bdVar = (bd) hVar;
                if (bdVar == null || (!bdVar.sp() && bdVar.rN() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fbO.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.v(recomTopicData.csq) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new al("c10835").ac("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bre() {
        if (MessageManager.getInstance().findTask(2003016) != null) {
            int bqw = (bqw() + auj()) - 1;
            if (bqx() != null && bqw >= 0 && bqw <= this.threadList.size()) {
                this.threadList.add(bqw, bqx());
            }
        }
    }

    public void brf() {
        int sN;
        if (bqI() != null) {
            com.baidu.tieba.frs.o bqI = bqI();
            if (com.baidu.tbadk.core.util.v.v(bqI.getUserInfo()) >= 3 && (sN = bqI.sN()) > 0) {
                int auj = sN + auj();
                if (auj > this.threadList.size()) {
                    this.threadList.add(bqI);
                } else {
                    this.threadList.add(auj, bqI);
                }
            }
        }
    }

    public void brg() {
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

    public void brh() {
        if (bqJ() != null && !com.baidu.tbadk.core.util.v.w(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == k.gvg) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, bqJ());
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bri() {
        return this.gux;
    }

    /* renamed from: do  reason: not valid java name */
    public void m19do(List<com.baidu.adp.widget.ListView.h> list) {
        this.gux = list;
    }

    public boolean brj() {
        if (bqc() == null) {
            return false;
        }
        return bqc().bqM() == 1;
    }

    public boolean brk() {
        return bqy() == null ? !com.baidu.tbadk.core.util.v.w(bqm()) : !com.baidu.tbadk.core.util.v.w(bqy().tab);
    }

    public void a(BannerListData bannerListData) {
        this.bkp = true;
        this.gvi = bannerListData;
    }
}
