package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class j extends g implements com.baidu.tbadk.mvc.b.l {
    private boolean bgc;
    private int goW = 0;
    private BannerListData goX;

    public void c(p pVar) {
        if (pVar != null) {
            this.eGz.setCurScore(pVar.getCurScore());
            this.eGz.setLevelupScore(pVar.getLevelupScore());
            this.eGz.setLike(pVar.isLike());
            this.eGz.setUser_level(pVar.getUserLevel());
            this.eGz.setLevelName(pVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.eGz.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.eGz == null) {
            return null;
        }
        return this.eGz.getSignData();
    }

    public void btw() {
        bj top_notice_data;
        com.baidu.adp.widget.ListView.f fVar;
        if (aPU() != null && this.threadList != null && (top_notice_data = aPU().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (fVar = this.threadList.get(0)) != null && (fVar instanceof bh) && ((bh) fVar).ro() == 2) {
                this.threadList.remove(0);
            }
            bh bhVar = new bh();
            bhVar.setTitle(top_notice_data.getTitle());
            bhVar.cD(top_notice_data.sU());
            bhVar.bS(2);
            bhVar.sc();
            this.threadList.add(0, bhVar);
        }
    }

    public void a(am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && this.threadList != null) {
            int anU = anU();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = threadList.get(i);
                    if ((fVar instanceof bh) && amVar.getId().equals(((bh) fVar).getId())) {
                        return;
                    }
                }
            }
            if (amVar.isPhotoLiveThread()) {
                av avVar = new av();
                avVar.a(amVar, -1);
                avVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.goW++;
                    this.threadList.add(anU, avVar);
                    return;
                }
                return;
            }
            this.goW++;
            this.threadList.add(anU, amVar);
        }
    }

    public void btx() {
        this.goW = 0;
    }

    public int anU() {
        int i = 0;
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof bh)) {
                    i = i2;
                } else if (((bh) next).ro() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    private int ra() {
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
            if ((next instanceof bh) && ((bh) next).rq() == 1) {
                return ((bh) next).ra();
            }
        }
        return -1;
    }

    public void bty() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bh.Ys || this.threadList.get(i2).getType() == bh.Yt || this.threadList.get(i2).getType() == bh.Yu) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void btz() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dRO != null && this.dRO.qp() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if ((fVar instanceof bh) && fVar.getType() == bh.ZB) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int anU = anU();
            if (i > anU) {
                this.threadList.add(anU, this.threadList.remove(i));
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
        if (!this.bgc) {
            if (this.eGz != null) {
                bannerListData = this.eGz.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.goX;
        }
        this.bgc = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar2.O(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.cf(z);
            bVar3.N(arrayList);
            bVar3.P(arrayList2);
            bVar3.cg(z2);
            bVar3.bX(qv().qp());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void btA() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i);
            if (fVar instanceof bh) {
                bh bhVar = (bh) fVar;
                if (bhVar.isPhotoLiveThread() && !(bhVar instanceof av)) {
                    av avVar = new av();
                    avVar.r(bsQ());
                    avVar.a(bhVar, 0);
                    if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, avVar);
                    }
                }
            }
        }
    }

    public void btB() {
        int i;
        if (aPU() != null) {
            List<PhotoLiveCardData> bsQ = bsQ();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (bsQ != null && bsQ.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof av)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int tQ = tQ(i);
                av avVar = new av();
                a(avVar, bsQ);
                getThreadList().add(tQ, avVar);
            }
        }
    }

    private void a(av avVar, List<PhotoLiveCardData> list) {
        if (avVar != null && !com.baidu.tbadk.core.util.v.v(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            avVar.setThreadType(33);
            avVar.a(metaData);
            avVar.cH(photoLiveCardData.getForumName());
            avVar.setTitle(photoLiveCardData.getTitle());
            avVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            avVar.cD(photoLiveCardData.getThreadId() + "");
            avVar.m(photoLiveCardData.getLastModifiedTime());
            avVar.bQ(photoLiveCardData.getDiscussNum());
        }
    }

    private int tQ(int i) {
        int anU = anU();
        int bsW = bsW();
        if (bsT()) {
            bsW++;
        }
        return Math.min((bsW + anU) - 1, i);
    }

    public void btC() {
        bh bta;
        int i;
        if (aPU() != null && (bta = bta()) != null) {
            Log.e(PbActivityConfig.VALUE_FROM_FRS, "addCardVideoInfoToThreadList cardVideoInfo:" + bta.getTid());
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof av)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                threadList.add(tQ(i), bta);
            }
        }
    }

    public void btD() {
        if (aPU() != null) {
            List<com.baidu.adp.widget.ListView.f> btl = btl();
            List<Integer> btk = btk();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (btk != null && btk.size() > 0 && btl != null && btl.size() > 0 && threadList != null) {
                int size = btk.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < btl.size()) {
                        com.baidu.adp.widget.ListView.f fVar = btl.get(i);
                        int bS = bS(btk.get(i).intValue(), size2);
                        Log.e(PbActivityConfig.VALUE_FROM_FRS, "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bS + "  Title:" + fVar.getType());
                        threadList.add(bS, fVar);
                    }
                }
            }
        }
    }

    private int bS(int i, int i2) {
        int anU = anU();
        if (bsT()) {
            i++;
        }
        return Math.min((anU + i) - 1, i2);
    }

    public void btE() {
        if (bsT()) {
            int anU = anU();
            if (ra() == 0) {
                anU++;
            }
            aw awVar = new aw();
            awVar.a(bsU());
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(anU, awVar);
            }
        }
    }

    public bh su(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
            if (next != null && (next instanceof bh) && TextUtils.equals(str, ((bh) next).getId())) {
                return (bh) next;
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
                    if (next != null && (next instanceof bh) && ((bh) next).rt() != null && currentAccount.equals(((bh) next).rt().getUserId()) && ((bh) next).rt().getPendantData() != null) {
                        ((bh) next).rt().getPendantData().Q(kVar.Cv());
                        ((bh) next).rt().getPendantData().cF(kVar.pQ());
                    }
                }
            }
        }
    }

    public void ai(bh bhVar) {
        this.threadList.remove(bhVar);
    }

    public boolean e(g gVar) {
        if (gVar == null) {
            return false;
        }
        d(gVar.qf());
        a(gVar.bsN());
        mz(gVar.bsJ());
        sq(gVar.bsK());
        c(gVar.aPU());
        setGameName(gVar.getGameName());
        sr(gVar.bsR());
        a(gVar.bsL());
        mA(gVar.bsO());
        pq(gVar.aQi());
        dm(gVar.bsQ());
        tM(gVar.bsW());
        c(gVar.bsU());
        a(gVar.qv());
        a(gVar.bsH());
        dk(gVar.bsP());
        az(gVar.getThreadList());
        dj(gVar.bsM());
        f(gVar.getUserData());
        setUserMap(gVar.getUserMap());
        a(gVar.bsI());
        dl(gVar.bsS());
        tN(gVar.btb());
        m12do(gVar.bsY());
        st(gVar.bsZ());
        ah(gVar.bta());
        a(gVar.btc());
        tO(gVar.btf());
        a(gVar.btg());
        a(gVar.bth());
        tJ(gVar.bsE());
        a(gVar.bti());
        tK(gVar.bsF());
        tL(gVar.bsG());
        this.gnK = gVar.gnK;
        this.goj = gVar.goj;
        this.gom = gVar.gom;
        a(gVar.btd());
        j(gVar.btj());
        a(gVar.bte());
        a(gVar.bsV());
        dp(gVar.btk());
        dq(gVar.btl());
        this.gox = gVar.gox;
        a(gVar.btm());
        a(gVar.bsC());
        di(gVar.bsB());
        a(gVar.btn());
        dr(gVar.bto());
        tP(gVar.btp());
        a(gVar.bsD());
        a(gVar.btq());
        a(gVar.btr());
        return true;
    }

    public void btF() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.eGz != null && this.eGz.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if (fVar instanceof bh) {
                    bh bhVar = (bh) fVar;
                    if (bhVar == null || (!bhVar.rV() && bhVar.rq() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.eGz.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                f fVar2 = new f();
                fVar2.setForumId(this.eGz.getId());
                fVar2.dh(feedForumList);
                this.threadList.add(i + 6, fVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mB(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.v(this.threadList)) {
            btG();
            if (btm() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                    if (fVar instanceof bh) {
                        bh bhVar = (bh) fVar;
                        if (bhVar == null || (!bhVar.rV() && bhVar.rq() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((btm().aqu() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((btm().aqu() + i) - 1, btm());
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

    public void btG() {
        if (!com.baidu.tbadk.core.util.v.v(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.cYw) {
                    it.remove();
                }
            }
        }
    }

    public boolean btH() {
        com.baidu.tieba.card.data.p recomTopicData;
        if (this.threadList == null || this.eGz == null || this.eGz.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
            if (fVar instanceof bh) {
                bh bhVar = (bh) fVar;
                if (bhVar == null || (!bhVar.rV() && bhVar.rq() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.eGz.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.u(recomTopicData.bVE) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ak("c10835").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void btI() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int btf = (btf() + anU()) - 1;
            if (btg() != null && btf >= 0 && btf <= this.threadList.size()) {
                this.threadList.add(btf, btg());
            }
        }
    }

    public void btJ() {
        int intValue;
        if (bsV() != null && (bsV().position.intValue() + anU()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bsV());
        }
    }

    public void btK() {
        int sw;
        if (btq() != null) {
            com.baidu.tieba.frs.q btq = btq();
            if (com.baidu.tbadk.core.util.v.u(btq.getUserInfo()) >= 3 && (sw = btq.sw()) > 0) {
                int anU = sw + anU();
                if (anU > this.threadList.size()) {
                    this.threadList.add(btq);
                } else {
                    this.threadList.add(anU, btq);
                }
            }
        }
    }

    public void btL() {
        if (btr() != null && !com.baidu.tbadk.core.util.v.v(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next != null && next.getType() == i.goV) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, btr());
        }
    }

    public List<com.baidu.adp.widget.ListView.f> btM() {
        return this.gos;
    }

    public void ds(List<com.baidu.adp.widget.ListView.f> list) {
        this.gos = list;
    }

    public boolean btN() {
        if (bsH() == null) {
            return false;
        }
        return bsH().bts() == 1;
    }

    public boolean btO() {
        return bth() == null ? !com.baidu.tbadk.core.util.v.v(bsS()) : !com.baidu.tbadk.core.util.v.v(bth().tab);
    }

    public void a(BannerListData bannerListData) {
        this.bgc = true;
        this.goX = bannerListData;
    }
}
