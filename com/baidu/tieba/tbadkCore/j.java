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
    private boolean bfT;
    private int gnS = 0;
    private BannerListData gnT;

    public void c(p pVar) {
        if (pVar != null) {
            this.eGf.setCurScore(pVar.getCurScore());
            this.eGf.setLevelupScore(pVar.getLevelupScore());
            this.eGf.setLike(pVar.isLike());
            this.eGf.setUser_level(pVar.getUserLevel());
            this.eGf.setLevelName(pVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.eGf.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.eGf == null) {
            return null;
        }
        return this.eGf.getSignData();
    }

    public void btk() {
        bj top_notice_data;
        com.baidu.adp.widget.ListView.f fVar;
        if (aPM() != null && this.threadList != null && (top_notice_data = aPM().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
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
            int anF = anF();
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
                    this.gnS++;
                    this.threadList.add(anF, avVar);
                    return;
                }
                return;
            }
            this.gnS++;
            this.threadList.add(anF, amVar);
        }
    }

    public void btl() {
        this.gnS = 0;
    }

    public int anF() {
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

    public void btm() {
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

    public void btn() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dRK != null && this.dRK.qp() == 1 && this.threadList != null && this.threadList.size() > 0) {
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
            int anF = anF();
            if (i > anF) {
                this.threadList.add(anF, this.threadList.remove(i));
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
        if (!this.bfT) {
            if (this.eGf != null) {
                bannerListData = this.eGf.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gnT;
        }
        this.bfT = false;
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
            bVar3.ce(z);
            bVar3.N(arrayList);
            bVar3.P(arrayList2);
            bVar3.cf(z2);
            bVar3.bX(qv().qp());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void bto() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i);
            if (fVar instanceof bh) {
                bh bhVar = (bh) fVar;
                if (bhVar.isPhotoLiveThread() && !(bhVar instanceof av)) {
                    av avVar = new av();
                    avVar.r(bsF());
                    avVar.a(bhVar, 0);
                    if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, avVar);
                    }
                }
            }
        }
    }

    public void btp() {
        int i;
        if (aPM() != null) {
            List<PhotoLiveCardData> bsF = bsF();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (bsF != null && bsF.size() > 0 && threadList != null && threadList.size() > 0) {
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
                int tM = tM(i);
                av avVar = new av();
                a(avVar, bsF);
                getThreadList().add(tM, avVar);
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

    private int tM(int i) {
        int anF = anF();
        int bsL = bsL();
        if (bsI()) {
            bsL++;
        }
        return Math.min((bsL + anF) - 1, i);
    }

    public void btq() {
        bh bsP;
        int i;
        if (aPM() != null && (bsP = bsP()) != null) {
            Log.e(PbActivityConfig.VALUE_FROM_FRS, "addCardVideoInfoToThreadList cardVideoInfo:" + bsP.getTid());
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
                threadList.add(tM(i), bsP);
            }
        }
    }

    public void btr() {
        if (aPM() != null) {
            List<com.baidu.adp.widget.ListView.f> bta = bta();
            List<Integer> bsZ = bsZ();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (bsZ != null && bsZ.size() > 0 && bta != null && bta.size() > 0 && threadList != null) {
                int size = bsZ.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bta.size()) {
                        com.baidu.adp.widget.ListView.f fVar = bta.get(i);
                        int bT = bT(bsZ.get(i).intValue(), size2);
                        Log.e(PbActivityConfig.VALUE_FROM_FRS, "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bT + "  Title:" + fVar.getType());
                        threadList.add(bT, fVar);
                    }
                }
            }
        }
    }

    private int bT(int i, int i2) {
        int anF = anF();
        if (bsI()) {
            i++;
        }
        return Math.min((anF + i) - 1, i2);
    }

    public void bts() {
        if (bsI()) {
            int anF = anF();
            if (ra() == 0) {
                anF++;
            }
            aw awVar = new aw();
            awVar.a(bsJ());
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(anF, awVar);
            }
        }
    }

    public bh so(String str) {
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
                        ((bh) next).rt().getPendantData().Q(kVar.Cj());
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
        a(gVar.bsC());
        mr(gVar.bsy());
        sk(gVar.bsz());
        c(gVar.aPM());
        setGameName(gVar.getGameName());
        sl(gVar.bsG());
        a(gVar.bsA());
        ms(gVar.bsD());
        pp(gVar.aQa());
        dl(gVar.bsF());
        tJ(gVar.bsL());
        c(gVar.bsJ());
        a(gVar.qv());
        a(gVar.bsw());
        dj(gVar.bsE());
        az(gVar.getThreadList());
        di(gVar.bsB());
        f(gVar.getUserData());
        setUserMap(gVar.getUserMap());
        a(gVar.bsx());
        dk(gVar.bsH());
        tK(gVar.bsQ());
        dn(gVar.bsN());
        sn(gVar.bsO());
        ah(gVar.bsP());
        a(gVar.bsR());
        tL(gVar.bsU());
        a(gVar.bsV());
        a(gVar.bsW());
        tG(gVar.bst());
        a(gVar.bsX());
        tH(gVar.bsu());
        tI(gVar.bsv());
        this.gmI = gVar.gmI;
        this.gng = gVar.gng;
        this.gnj = gVar.gnj;
        a(gVar.bsS());
        j(gVar.bsY());
        a(gVar.bsT());
        a(gVar.bsK());
        m12do(gVar.bsZ());
        dp(gVar.bta());
        this.gnu = gVar.gnu;
        a(gVar.btb());
        a(gVar.bsr());
        dh(gVar.bsq());
        a(gVar.btc());
        dq(gVar.btd());
        a(gVar.bss());
        a(gVar.bte());
        a(gVar.btf());
        return true;
    }

    public void btt() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.eGf != null && this.eGf.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
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
            if (this.threadList.size() - i > 7 && (feedForumList = this.eGf.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                f fVar2 = new f();
                fVar2.setForumId(this.eGf.getId());
                fVar2.dg(feedForumList);
                this.threadList.add(i + 6, fVar2);
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
        if (!com.baidu.tbadk.core.util.v.v(this.threadList)) {
            btu();
            if (btb() != null) {
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
                if ((btb().aqe() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((btb().aqe() + i) - 1, btb());
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

    public void btu() {
        if (!com.baidu.tbadk.core.util.v.v(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.cYc) {
                    it.remove();
                }
            }
        }
    }

    public boolean btv() {
        com.baidu.tieba.card.data.p recomTopicData;
        if (this.threadList == null || this.eGf == null || this.eGf.getBannerListData() == null) {
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
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.eGf.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.u(recomTopicData.bVr) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ak("c10835").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void btw() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bsU = (bsU() + anF()) - 1;
            if (bsV() != null && bsU >= 0 && bsU <= this.threadList.size()) {
                this.threadList.add(bsU, bsV());
            }
        }
    }

    public void btx() {
        int intValue;
        if (bsK() != null && (bsK().position.intValue() + anF()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bsK());
        }
    }

    public void bty() {
        int sw;
        if (bte() != null) {
            com.baidu.tieba.frs.q bte = bte();
            if (com.baidu.tbadk.core.util.v.u(bte.getUserInfo()) >= 3 && (sw = bte.sw()) > 0) {
                int anF = sw + anF();
                if (anF > this.threadList.size()) {
                    this.threadList.add(bte);
                } else {
                    this.threadList.add(anF, bte);
                }
            }
        }
    }

    public void btz() {
        if (btf() != null && !com.baidu.tbadk.core.util.v.v(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next != null && next.getType() == i.gnR) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, btf());
        }
    }

    public List<com.baidu.adp.widget.ListView.f> btA() {
        return this.gnp;
    }

    public void dr(List<com.baidu.adp.widget.ListView.f> list) {
        this.gnp = list;
    }

    public boolean btB() {
        if (bsw() == null) {
            return false;
        }
        return bsw().btg() == 1;
    }

    public boolean btC() {
        return bsW() == null ? !com.baidu.tbadk.core.util.v.v(bsH()) : !com.baidu.tbadk.core.util.v.v(bsW().tab);
    }

    public void a(BannerListData bannerListData) {
        this.bfT = true;
        this.gnT = bannerListData;
    }
}
