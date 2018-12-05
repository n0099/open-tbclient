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
    private boolean bNP;
    public boolean hjC;
    public List<String> hjE;
    public SmartApp hjF;
    private NebulaHotThreads hjG;
    private int hjX = 0;
    private BannerListData hjY;
    public int hjZ;
    public boolean isBrandForum;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fPN.setCurScore(rVar.getCurScore());
            this.fPN.setLevelupScore(rVar.getLevelupScore());
            this.fPN.setLike(rVar.isLike());
            this.fPN.setUser_level(rVar.bzL());
            this.fPN.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fPN.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fPN == null) {
            return null;
        }
        return this.fPN.getSignData();
    }

    public void bCh() {
        be top_notice_data;
        com.baidu.adp.widget.ListView.h hVar;
        if (bgi() != null && this.threadList != null && (top_notice_data = bgi().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
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
            int aGo = aGo();
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
            this.hjX++;
            this.threadList.add(aGo, aiVar);
        }
    }

    public void bCi() {
        this.hjX = 0;
    }

    public int aGo() {
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

    public void bCj() {
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

    public void bCk() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.feI != null && this.feI.yN() == 1 && this.threadList != null && this.threadList.size() > 0) {
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
            int aGo = aGo();
            if (i > aGo) {
                this.threadList.add(aGo, this.threadList.remove(i));
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
        if (!this.bNP) {
            if (this.fPN != null) {
                bannerListData = this.fPN.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.hjY;
        }
        this.bNP = false;
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
    public List<RecmForumInfo> bBn() {
        return this.recm_forum_list;
    }

    public boolean bCl() {
        return this.isBrandForum;
    }

    private int vq(int i) {
        return Math.min((aGo() + bBB()) - 1, i);
    }

    public void bCm() {
        f bBZ;
        if (this.threadList != null && bgi() != null && MessageManager.getInstance().findTask(2911003) != null && (bBZ = bBZ()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.v.I(bBZ.hhW)) {
                threadList.add(bO(1, threadList.size()), bBZ);
            }
        }
    }

    public void bCn() {
        a(f.class, getThreadList());
    }

    public void bCo() {
        e bBY;
        if (this.threadList != null && bgi() != null && MessageManager.getInstance().findTask(2911003) != null && (bBY = bBY()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(bO(bBY.hhU, threadList.size()), bBY);
        }
    }

    public void bCp() {
        a(e.class, getThreadList());
    }

    private int bO(int i, int i2) {
        return Math.min((aGo() + i) - 1, i2);
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

    public void bCq() {
        bb bBF;
        if (bgi() != null && (bBF = bBF()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + bBF.getTid());
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(vq(threadList.size()), bBF);
            }
        }
    }

    public void bCr() {
        if (bgi() != null) {
            List<com.baidu.adp.widget.ListView.h> bBR = bBR();
            List<Integer> bBQ = bBQ();
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = getThreadList();
            if (bBQ != null && bBQ.size() > 0 && bBR != null && bBR.size() > 0 && threadList != null) {
                int size = bBQ.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bBR.size()) {
                        com.baidu.adp.widget.ListView.h hVar = bBR.get(i);
                        int bP = bP(bBQ.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bP + "  Title:" + hVar.getType());
                        threadList.add(bP, hVar);
                    }
                }
            }
        }
    }

    private int bP(int i, int i2) {
        return Math.min((aGo() + i) - 1, i2);
    }

    public bb vv(String str) {
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
                        ((bb) next).zG().getPendantData().ao(jVar.LE());
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
        a(iVar.bBx());
        nn(iVar.bBt());
        vr(iVar.bBu());
        c(iVar.bgi());
        setGameName(iVar.getGameName());
        vs(iVar.bBA());
        a(iVar.bBv());
        no(iVar.bBy());
        rY(iVar.bgx());
        vm(iVar.bBB());
        a(iVar.yS());
        a(iVar.bBr());
        dG(iVar.bBz());
        ax(iVar.getThreadList());
        dF(iVar.bBw());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.bBs());
        vn(iVar.bBG());
        this.hjD = iVar.hjD;
        dI(iVar.bBD());
        vu(iVar.bBE());
        at(iVar.bBF());
        a(iVar.bBH());
        vo(iVar.bBK());
        a(iVar.bBL());
        a(iVar.bBM());
        vj(iVar.bBo());
        a(iVar.bBO());
        vk(iVar.bBp());
        vl(iVar.bBq());
        this.hiz = iVar.hiz;
        this.hiT = iVar.hiT;
        this.hiX = iVar.hiX;
        a(iVar.bBI());
        q(iVar.bBP());
        a(iVar.bBJ());
        dJ(iVar.bBQ());
        dK(iVar.bBR());
        this.hjk = iVar.hjk;
        a(iVar.bBS());
        a(iVar.bBl());
        a(iVar.bBT());
        dL(iVar.bBU());
        vp(iVar.bBV());
        a(iVar.bBm());
        a(iVar.bBW());
        a(iVar.bBX());
        this.hjt = iVar.hjt;
        b(iVar.bBY());
        this.recm_forum_list = iVar.bBn();
        b(iVar.bBZ());
        this.dNY = iVar.dNY;
        this.hju = iVar.hju;
        this.hiU = iVar.hiU;
        this.hjv = iVar.hjv;
        this.hjw = iVar.hjw;
        np(iVar.bBN());
        this.isBrandForum = iVar.isBrandForum;
        this.hjy = iVar.hjy;
        this.hjz = iVar.hjz;
        this.hjA = iVar.hjA;
        com.baidu.tieba.frs.a.azU().b(yE());
        com.baidu.tieba.frs.a.azU().setForumId(iVar.bgi().getId());
        d(iVar.bCb());
        this.hjC = iVar.hjC;
        this.hjE = iVar.hjE;
        this.hjF = iVar.hjF;
        this.hjG = iVar.hjG;
        return true;
    }

    public NebulaHotThreads bCs() {
        return this.hjG;
    }

    public void bCt() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fPN != null && this.fPN.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
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
            if (this.threadList.size() - i > 7 && (feedForumList = this.fPN.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar2 = new h();
                hVar2.setForumId(this.fPN.getId());
                hVar2.dE(feedForumList);
                this.threadList.add(i + 6, hVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void nq(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.I(this.threadList)) {
            bCu();
            if (bBS() != null) {
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
                if ((bBS().aIY() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((bBS().aIY() + i) - 1, bBS());
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

    public void bCu() {
        if (!com.baidu.tbadk.core.util.v.I(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.h.b.ekK) {
                    it.remove();
                }
            }
        }
    }

    public boolean bCv() {
        com.baidu.tieba.card.data.n recomTopicData;
        if (this.threadList == null || this.fPN == null || this.fPN.getBannerListData() == null) {
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
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fPN.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.H(recomTopicData.cYu) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new am("c10835").aA("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bCw() {
        if (MessageManager.getInstance().findTask(2003016) != null) {
            int bBK = (bBK() + aGo()) - 1;
            if (bBL() != null && bBK >= 0 && bBK <= this.threadList.size()) {
                this.threadList.add(bBK, bBL());
            }
        }
    }

    public void bCx() {
        int AG;
        if (bBW() != null) {
            com.baidu.tieba.frs.q bBW = bBW();
            if (com.baidu.tbadk.core.util.v.H(bBW.getUserInfo()) >= 3 && (AG = bBW.AG()) > 0) {
                int aGo = AG + aGo();
                if (aGo > this.threadList.size()) {
                    this.threadList.add(bBW);
                } else {
                    this.threadList.add(aGo, bBW);
                }
            }
        }
    }

    public void bCy() {
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

    public void bCz() {
        if (bBX() != null && !com.baidu.tbadk.core.util.v.I(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && next.getType() == k.hjW) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, bBX());
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bCA() {
        return this.hjd;
    }

    public void dM(List<com.baidu.adp.widget.ListView.h> list) {
        this.hjd = list;
    }

    public boolean bCB() {
        if (bBr() == null) {
            return false;
        }
        return bBr().bCc() == 1;
    }

    public boolean bCC() {
        return (bBM() == null || com.baidu.tbadk.core.util.v.I(bBM().tab)) ? false : true;
    }

    public void a(BannerListData bannerListData) {
        this.bNP = true;
        this.hjY = bannerListData;
    }
}
