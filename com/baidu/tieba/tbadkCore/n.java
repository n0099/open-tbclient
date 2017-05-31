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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class n extends l implements com.baidu.tbadk.mvc.b.l {
    private int fAJ = 0;
    private boolean fAK;
    private BannerListData fAL;

    public void c(t tVar) {
        if (tVar != null) {
            this.eis.setCurScore(tVar.getCurScore());
            this.eis.setLevelupScore(tVar.getLevelupScore());
            this.eis.setLike(tVar.isLike());
            this.eis.setUser_level(tVar.getUserLevel());
            this.eis.setLevelName(tVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.eis.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.eis == null) {
            return null;
        }
        return this.eis.getSignData();
    }

    public void bgX() {
        bp top_notice_data;
        com.baidu.adp.widget.ListView.v vVar;
        if (aIz() != null && this.threadList != null && (top_notice_data = aIz().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (vVar = this.threadList.get(0)) != null && (vVar instanceof bl) && ((bl) vVar).rq() == 2) {
                this.threadList.remove(0);
            }
            bl blVar = new bl();
            blVar.setTitle(top_notice_data.getTitle());
            blVar.co(top_notice_data.sO());
            blVar.bS(2);
            blVar.sc();
            this.threadList.add(0, blVar);
        }
    }

    public void a(ao aoVar) {
        if (aoVar != null && !StringUtils.isNull(aoVar.getId()) && this.threadList != null) {
            int acW = acW();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = threadList.get(i);
                    if ((vVar instanceof bl) && aoVar.getId().equals(((bl) vVar).getId())) {
                        return;
                    }
                }
            }
            if (aoVar.isPhotoLiveThread()) {
                ax axVar = new ax();
                axVar.a(aoVar, -1);
                axVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.fAJ++;
                    this.threadList.add(acW, axVar);
                    return;
                }
                return;
            }
            this.fAJ++;
            this.threadList.add(acW, aoVar);
        }
    }

    public void bgY() {
        this.fAJ = 0;
    }

    public int acW() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof bl) {
                if (((bl) next).rq() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int re() {
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if ((next instanceof bl) && ((bl) next).rs() == 1) {
                return ((bl) next).re();
            }
        }
        return -1;
    }

    public void bgZ() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bl.Xs || this.threadList.get(i2).getType() == bl.Xt) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bha() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dmJ != null && this.dmJ.qr() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if ((vVar instanceof bl) && vVar.getType() == bl.Yy) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int acW = acW();
            if (i > acW) {
                this.threadList.add(acW, this.threadList.remove(i));
            }
        }
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar) {
        a(bVar, false, this.threadList, null, false);
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        a(bVar, false, arrayList, null, false);
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar, boolean z, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, ArrayList<com.baidu.adp.widget.ListView.v> arrayList2, boolean z2) {
        BannerListData bannerListData;
        if (!this.fAK) {
            if (this.eis != null) {
                bannerListData = this.eis.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.fAL;
        }
        this.fAK = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar2.I(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.ce(z);
            bVar3.setThreadList(arrayList);
            bVar3.J(arrayList2);
            bVar3.cf(z2);
            bVar3.bW(qx().qr());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void bhb() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i);
            if (vVar instanceof bl) {
                bl blVar = (bl) vVar;
                if (blVar.isPhotoLiveThread() && !(blVar instanceof ax)) {
                    ax axVar = new ax();
                    axVar.n(bgv());
                    axVar.a(blVar, 0);
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, axVar);
                    }
                }
            }
        }
    }

    public void bhc() {
        int i;
        if (aIz() != null) {
            List<PhotoLiveCardData> bgv = bgv();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bgv != null && bgv.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof ax)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int sh = sh(i);
                ax axVar = new ax();
                a(axVar, bgv);
                getThreadList().add(sh, axVar);
            }
        }
    }

    private void a(ax axVar, List<PhotoLiveCardData> list) {
        if (axVar != null && !com.baidu.tbadk.core.util.x.r(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            axVar.setThreadType(33);
            axVar.setAuthor(metaData);
            axVar.cs(photoLiveCardData.getForumName());
            axVar.setTitle(photoLiveCardData.getTitle());
            axVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            axVar.co(new StringBuilder(String.valueOf(photoLiveCardData.getThreadId())).toString());
            axVar.m(photoLiveCardData.getLastModifiedTime());
            axVar.bQ(photoLiveCardData.getDiscussNum());
        }
    }

    private int sh(int i) {
        int acW = acW();
        int bgB = bgB();
        if (bgy()) {
            bgB++;
        }
        return Math.min((bgB + acW) - 1, i);
    }

    public void bhd() {
        bl bgF;
        int i;
        if (aIz() != null && (bgF = bgF()) != null) {
            Log.e(PbActivityConfig.VALUE_FROM_FRS, "addCardVideoInfoToThreadList cardVideoInfo:" + bgF.getTid());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof ax)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                threadList.add(sh(i), bgF);
            }
        }
    }

    public void bhe() {
        if (aIz() != null) {
            List<com.baidu.adp.widget.ListView.v> bgQ = bgQ();
            List<Integer> bgP = bgP();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bgP != null && bgP.size() > 0 && bgQ != null && bgQ.size() > 0 && threadList != null) {
                int size = bgP.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bgQ.size()) {
                        com.baidu.adp.widget.ListView.v vVar = bgQ.get(i);
                        int bj = bj(bgP.get(i).intValue(), size2);
                        Log.e(PbActivityConfig.VALUE_FROM_FRS, "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bj + "  Title:" + vVar.getType());
                        threadList.add(bj, vVar);
                    }
                }
            }
        }
    }

    private int bj(int i, int i2) {
        int acW = acW();
        if (bgy()) {
            i++;
        }
        return Math.min((acW + i) - 1, i2);
    }

    public void bhf() {
        if (bgy()) {
            int acW = acW();
            if (re() == 0) {
                acW++;
            }
            ay ayVar = new ay();
            ayVar.a(bgz());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(acW, ayVar);
            }
        }
    }

    public bl qf(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next != null && (next instanceof bl) && TextUtils.equals(str, ((bl) next).getId())) {
                return (bl) next;
            }
        }
        return null;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (this.threadList != null && jVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.v next = it.next();
                    if (next != null && (next instanceof bl) && ((bl) next).getAuthor() != null && currentAccount.equals(((bl) next).getAuthor().getUserId()) && ((bl) next).getAuthor().getPendantData() != null) {
                        ((bl) next).getAuthor().getPendantData().O(jVar.BN());
                        ((bl) next).getAuthor().getPendantData().cq(jVar.pL());
                    }
                }
            }
        }
    }

    public void W(bl blVar) {
        this.threadList.remove(blVar);
    }

    public boolean d(l lVar) {
        if (lVar == null) {
            return false;
        }
        d(lVar.qh());
        a(lVar.bgs());
        ln(lVar.bgo());
        qb(lVar.bgp());
        c(lVar.aIz());
        setGameName(lVar.getGameName());
        qc(lVar.bgw());
        a(lVar.bgq());
        lo(lVar.bgt());
        mv(lVar.aIN());
        cA(lVar.bgv());
        se(lVar.bgB());
        c(lVar.bgz());
        a(lVar.qx());
        a(lVar.bgm());
        cy(lVar.bgu());
        ay(lVar.getThreadList());
        cx(lVar.bgr());
        a(lVar.getUserData());
        setUserMap(lVar.getUserMap());
        a(lVar.bgn());
        cz(lVar.bgx());
        sf(lVar.bgG());
        cC(lVar.bgD());
        qe(lVar.bgE());
        V(lVar.bgF());
        a(lVar.bgH());
        sg(lVar.bgK());
        a(lVar.bgL());
        a(lVar.bgM());
        sb(lVar.bgj());
        a(lVar.bgN());
        sc(lVar.bgk());
        sd(lVar.bgl());
        this.fzF = lVar.fzF;
        this.fAd = lVar.fAd;
        this.fAg = lVar.fAg;
        a(lVar.bgI());
        d(lVar.bgO());
        a(lVar.bgJ());
        a(lVar.bgA());
        cD(lVar.bgP());
        cE(lVar.bgQ());
        lp(lVar.isShowDriftingBottle());
        cq(lVar.bgR());
        this.fAs = lVar.fAs;
        a(lVar.bgS());
        a(lVar.bgi());
        return true;
    }

    public void bhg() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.eis != null && this.eis.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if (vVar instanceof bl) {
                    bl blVar = (bl) vVar;
                    if (blVar == null || (!blVar.rV() && blVar.rs() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.eis.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar = new h();
                hVar.setForumId(this.eis.getId());
                hVar.cw(feedForumList);
                this.threadList.add(i + 6, hVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void lq(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.x.r(this.threadList)) {
            bhh();
            if (bgS() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                    if (vVar instanceof bl) {
                        bl blVar = (bl) vVar;
                        if (blVar == null || (!blVar.rV() && blVar.rs() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bgS().afE() + i) - 1 < this.threadList.size()) {
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
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("game_rank_list_info", String.valueOf(System.currentTimeMillis()) + ",1");
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("game_rank_list_show_times", 0);
                            if (!z3) {
                                this.threadList.add((bgS().afE() + i) - 1, bgS());
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

    public void bhh() {
        if (!com.baidu.tbadk.core.util.x.r(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.coD) {
                    it.remove();
                }
            }
        }
    }

    public boolean bhi() {
        com.baidu.tieba.card.data.p recomTopicData;
        if (this.threadList == null || this.eis == null || this.eis.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
            if (vVar instanceof bl) {
                bl blVar = (bl) vVar;
                if (blVar == null || (!blVar.rV() && blVar.rs() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.eis.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.x.q(recomTopicData.bDM) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new as("c10835").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bhj() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bgK = (bgK() + acW()) - 1;
            if (bgL() != null && bgK >= 0 && bgK <= this.threadList.size()) {
                this.threadList.add(bgK, bgL());
            }
        }
    }

    public void bhk() {
        int intValue;
        if (bgA() != null && (bgA().position.intValue() + acW()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bgA());
        }
    }

    public List<com.baidu.adp.widget.ListView.v> bhl() {
        return this.fAm;
    }

    public void cF(List<com.baidu.adp.widget.ListView.v> list) {
        this.fAm = list;
    }

    public boolean bhm() {
        return bgm() != null && bgm().bgT() == 1;
    }

    public boolean bhn() {
        return bgM() == null ? !com.baidu.tbadk.core.util.x.r(bgx()) : !com.baidu.tbadk.core.util.x.r(bgM().tab);
    }

    public void a(BannerListData bannerListData) {
        this.fAK = true;
        this.fAL = bannerListData;
    }
}
