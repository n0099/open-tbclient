package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class k extends h implements com.baidu.tbadk.mvc.b.l {
    private boolean bkL;
    private int gxP = 0;
    private BannerListData gxQ;

    public void c(q qVar) {
        if (qVar != null) {
            this.eOi.setCurScore(qVar.getCurScore());
            this.eOi.setLevelupScore(qVar.getLevelupScore());
            this.eOi.setLike(qVar.isLike());
            this.eOi.setUser_level(qVar.getUserLevel());
            this.eOi.setLevelName(qVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.eOi.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.eOi == null) {
            return null;
        }
        return this.eOi.getSignData();
    }

    public void bvd() {
        bg top_notice_data;
        com.baidu.adp.widget.ListView.f fVar;
        if (aRf() != null && this.threadList != null && (top_notice_data = aRf().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (fVar = this.threadList.get(0)) != null && (fVar instanceof bd) && ((bd) fVar).rs() == 2) {
                this.threadList.remove(0);
            }
            bd bdVar = new bd();
            bdVar.setTitle(top_notice_data.getTitle());
            bdVar.cD(top_notice_data.sX());
            bdVar.bS(2);
            bdVar.sf();
            this.threadList.add(0, bdVar);
        }
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.threadList != null) {
            int apO = apO();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = threadList.get(i);
                    if ((fVar instanceof bd) && aiVar.getId().equals(((bd) fVar).getId())) {
                        return;
                    }
                }
            }
            if (aiVar.isPhotoLiveThread()) {
                ar arVar = new ar();
                arVar.a(aiVar, -1);
                arVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.gxP++;
                    this.threadList.add(apO, arVar);
                    return;
                }
                return;
            }
            this.gxP++;
            this.threadList.add(apO, aiVar);
        }
    }

    public void bve() {
        this.gxP = 0;
    }

    public int apO() {
        int i = 0;
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof bd)) {
                    i = i2;
                } else if (((bd) next).rs() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    private int re() {
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
            if ((next instanceof bd) && ((bd) next).ru() == 1) {
                return ((bd) next).re();
            }
        }
        return -1;
    }

    public void bvf() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bd.YK || this.threadList.get(i2).getType() == bd.YL || this.threadList.get(i2).getType() == bd.YM) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bvg() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dZC != null && this.dZC.qu() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if ((fVar instanceof bd) && fVar.getType() == bd.ZU) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int apO = apO();
            if (i > apO) {
                this.threadList.add(apO, this.threadList.remove(i));
            }
        }
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar) {
        a(bVar, false, this.threadList, null, false);
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        a(bVar, false, arrayList, null, false);
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar, boolean z, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, ArrayList<com.baidu.adp.widget.ListView.f> arrayList2, boolean z2) {
        BannerListData bannerListData;
        if (!this.bkL) {
            if (this.eOi != null) {
                bannerListData = this.eOi.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gxQ;
        }
        this.bkL = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar2.P(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.ci(z);
            bVar3.O(arrayList);
            bVar3.Q(arrayList2);
            bVar3.cj(z2);
            bVar3.bY(qA().qu());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void bvh() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i);
            if (fVar instanceof bd) {
                bd bdVar = (bd) fVar;
                if (bdVar.isPhotoLiveThread() && !(bdVar instanceof ar)) {
                    ar arVar = new ar();
                    arVar.s(bux());
                    arVar.a(bdVar, 0);
                    if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, arVar);
                    }
                }
            }
        }
    }

    public void bvi() {
        int i;
        if (aRf() != null) {
            List<PhotoLiveCardData> bux = bux();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (bux != null && bux.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof ar)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int ug = ug(i);
                ar arVar = new ar();
                a(arVar, bux);
                getThreadList().add(ug, arVar);
            }
        }
    }

    private void a(ar arVar, List<PhotoLiveCardData> list) {
        if (arVar != null && !com.baidu.tbadk.core.util.v.w(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            arVar.setThreadType(33);
            arVar.a(metaData);
            arVar.cH(photoLiveCardData.getForumName());
            arVar.setTitle(photoLiveCardData.getTitle());
            arVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            arVar.cD(photoLiveCardData.getThreadId() + "");
            arVar.m(photoLiveCardData.getLastModifiedTime());
            arVar.bQ(photoLiveCardData.getDiscussNum());
        }
    }

    private int ug(int i) {
        int apO = apO();
        int buC = buC();
        if (buA()) {
            buC++;
        }
        return Math.min((buC + apO) - 1, i);
    }

    public void bvj() {
        e buY;
        if (this.threadList != null && aRf() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null && (buY = buY()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(bS(buY.gwc, threadList.size()), buY);
        }
    }

    public void bvk() {
        a(e.class, getThreadList());
    }

    private int bS(int i, int i2) {
        int apO = apO();
        if (buA()) {
            i++;
        }
        return Math.min((apO + i) - 1, i2);
    }

    private void a(Class cls, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = arrayList.get(i);
                if (fVar.getClass() != cls) {
                    i++;
                } else {
                    arrayList2.add(fVar);
                    break;
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.removeAll(arrayList2);
            }
        }
    }

    public void bvl() {
        bd buG;
        int i;
        if (aRf() != null && (buG = buG()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + buG.getTid());
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof ar)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                threadList.add(ug(i), buG);
            }
        }
    }

    public void bvm() {
        if (aRf() != null) {
            List<com.baidu.adp.widget.ListView.f> buR = buR();
            List<Integer> buQ = buQ();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (buQ != null && buQ.size() > 0 && buR != null && buR.size() > 0 && threadList != null) {
                int size = buQ.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < buR.size()) {
                        com.baidu.adp.widget.ListView.f fVar = buR.get(i);
                        int bT = bT(buQ.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bT + "  Title:" + fVar.getType());
                        threadList.add(bT, fVar);
                    }
                }
            }
        }
    }

    private int bT(int i, int i2) {
        int apO = apO();
        if (buA()) {
            i++;
        }
        return Math.min((apO + i) - 1, i2);
    }

    public void bvn() {
        if (buA()) {
            int apO = apO();
            if (re() == 0) {
                apO++;
            }
            as asVar = new as();
            asVar.a(buB());
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(apO, asVar);
            }
        }
    }

    public bd sQ(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
            if (next != null && (next instanceof bd) && TextUtils.equals(str, ((bd) next).getId())) {
                return (bd) next;
            }
        }
        return null;
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        if (this.threadList != null && kVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next != null && (next instanceof bd) && ((bd) next).rx() != null && currentAccount.equals(((bd) next).rx().getUserId()) && ((bd) next).rx().getPendantData() != null) {
                        ((bd) next).rx().getPendantData().T(kVar.CE());
                        ((bd) next).rx().getPendantData().cF(kVar.pT());
                    }
                }
            }
        }
    }

    public void aj(bd bdVar) {
        this.threadList.remove(bdVar);
    }

    public boolean e(h hVar) {
        if (hVar == null) {
            return false;
        }
        c(hVar.qi());
        a(hVar.buu());
        mW(hVar.buq());
        sM(hVar.bur());
        c(hVar.aRf());
        setGameName(hVar.getGameName());
        sN(hVar.buy());
        a(hVar.bus());
        mX(hVar.buv());
        pC(hVar.aRt());
        dx(hVar.bux());
        uc(hVar.buC());
        c(hVar.buB());
        a(hVar.qA());
        a(hVar.buo());
        dv(hVar.buw());
        az(hVar.getThreadList());
        du(hVar.but());
        d(hVar.getUserData());
        setUserMap(hVar.getUserMap());
        a(hVar.bup());
        dw(hVar.buz());
        ud(hVar.buH());
        dz(hVar.buE());
        sP(hVar.buF());
        ai(hVar.buG());
        a(hVar.buI());
        ue(hVar.buL());
        a(hVar.buM());
        a(hVar.buN());
        tZ(hVar.bul());
        a(hVar.buO());
        ua(hVar.bum());
        ub(hVar.bun());
        this.gwD = hVar.gwD;
        this.gxa = hVar.gxa;
        this.gxd = hVar.gxd;
        a(hVar.buJ());
        k(hVar.buP());
        a(hVar.buK());
        dA(hVar.buQ());
        dB(hVar.buR());
        this.gxp = hVar.gxp;
        a(hVar.buS());
        a(hVar.buj());
        dt(hVar.bui());
        a(hVar.buT());
        dC(hVar.buU());
        uf(hVar.buV());
        a(hVar.buk());
        a(hVar.buW());
        a(hVar.buX());
        this.gxz = hVar.gxz;
        b(hVar.buY());
        return true;
    }

    public void bvo() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.eOi != null && this.eOi.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if (fVar instanceof bd) {
                    bd bdVar = (bd) fVar;
                    if (bdVar == null || (!bdVar.rY() && bdVar.ru() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.eOi.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                g gVar = new g();
                gVar.setForumId(this.eOi.getId());
                gVar.ds(feedForumList);
                this.threadList.add(i + 6, gVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mY(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.w(this.threadList)) {
            bvp();
            if (buS() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                    if (fVar instanceof bd) {
                        bd bdVar = (bd) fVar;
                        if (bdVar == null || (!bdVar.rY() && bdVar.ru() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((buS().aso() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((buS().aso() + i) - 1, buS());
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

    public void bvp() {
        if (!com.baidu.tbadk.core.util.v.w(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.dhf) {
                    it.remove();
                }
            }
        }
    }

    public boolean bvq() {
        com.baidu.tieba.card.data.p recomTopicData;
        if (this.threadList == null || this.eOi == null || this.eOi.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
            if (fVar instanceof bd) {
                bd bdVar = (bd) fVar;
                if (bdVar == null || (!bdVar.rY() && bdVar.ru() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.eOi.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.v(recomTopicData.cdY) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ak("c10835").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bvr() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int buL = (buL() + apO()) - 1;
            if (buM() != null && buL >= 0 && buL <= this.threadList.size()) {
                this.threadList.add(buL, buM());
            }
        }
    }

    public void bvs() {
        int sz;
        if (buW() != null) {
            com.baidu.tieba.frs.q buW = buW();
            if (com.baidu.tbadk.core.util.v.v(buW.getUserInfo()) >= 3 && (sz = buW.sz()) > 0) {
                int apO = sz + apO();
                if (apO > this.threadList.size()) {
                    this.threadList.add(buW);
                } else {
                    this.threadList.add(apO, buW);
                }
            }
        }
    }

    public void bvt() {
        if (buX() != null && !com.baidu.tbadk.core.util.v.w(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next != null && next.getType() == j.gxO) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, buX());
        }
    }

    public List<com.baidu.adp.widget.ListView.f> bvu() {
        return this.gxj;
    }

    public void dD(List<com.baidu.adp.widget.ListView.f> list) {
        this.gxj = list;
    }

    public boolean bvv() {
        if (buo() == null) {
            return false;
        }
        return buo().buZ() == 1;
    }

    public boolean bvw() {
        return buN() == null ? !com.baidu.tbadk.core.util.v.w(buz()) : !com.baidu.tbadk.core.util.v.w(buN().tab);
    }

    public void a(BannerListData bannerListData) {
        this.bkL = true;
        this.gxQ = bannerListData;
    }
}
