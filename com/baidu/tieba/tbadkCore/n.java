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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class n extends l implements com.baidu.tbadk.mvc.b.l {
    private int fKN = 0;
    private boolean fKO;
    private BannerListData fKP;

    public void c(t tVar) {
        if (tVar != null) {
            this.erp.setCurScore(tVar.getCurScore());
            this.erp.setLevelupScore(tVar.getLevelupScore());
            this.erp.setLike(tVar.isLike());
            this.erp.setUser_level(tVar.getUserLevel());
            this.erp.setLevelName(tVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.erp.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.erp == null) {
            return null;
        }
        return this.erp.getSignData();
    }

    public void bll() {
        bq top_notice_data;
        com.baidu.adp.widget.ListView.v vVar;
        if (aMt() != null && this.threadList != null && (top_notice_data = aMt().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (vVar = this.threadList.get(0)) != null && (vVar instanceof bm) && ((bm) vVar).rm() == 2) {
                this.threadList.remove(0);
            }
            bm bmVar = new bm();
            bmVar.setTitle(top_notice_data.getTitle());
            bmVar.cu(top_notice_data.sM());
            bmVar.bS(2);
            bmVar.rZ();
            this.threadList.add(0, bmVar);
        }
    }

    public void a(ap apVar) {
        if (apVar != null && !StringUtils.isNull(apVar.getId()) && this.threadList != null) {
            int agP = agP();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = threadList.get(i);
                    if ((vVar instanceof bm) && apVar.getId().equals(((bm) vVar).getId())) {
                        return;
                    }
                }
            }
            if (apVar.isPhotoLiveThread()) {
                ay ayVar = new ay();
                ayVar.a(apVar, -1);
                ayVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.fKN++;
                    this.threadList.add(agP, ayVar);
                    return;
                }
                return;
            }
            this.fKN++;
            this.threadList.add(agP, apVar);
        }
    }

    public void blm() {
        this.fKN = 0;
    }

    public int agP() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof bm) {
                if (((bm) next).rm() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int rb() {
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if ((next instanceof bm) && ((bm) next).ro() == 1) {
                return ((bm) next).rb();
            }
        }
        return -1;
    }

    public void bln() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bm.Xs || this.threadList.get(i2).getType() == bm.Xt) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void blo() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.duF != null && this.duF.qo() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if ((vVar instanceof bm) && vVar.getType() == bm.Yz) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int agP = agP();
            if (i > agP) {
                this.threadList.add(agP, this.threadList.remove(i));
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
        if (!this.fKO) {
            if (this.erp != null) {
                bannerListData = this.erp.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.fKP;
        }
        this.fKO = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar2.K(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.cg(z);
            bVar3.setThreadList(arrayList);
            bVar3.L(arrayList2);
            bVar3.ch(z2);
            bVar3.bW(qu().qo());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void blp() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i);
            if (vVar instanceof bm) {
                bm bmVar = (bm) vVar;
                if (bmVar.isPhotoLiveThread() && !(bmVar instanceof ay)) {
                    ay ayVar = new ay();
                    ayVar.p(bkJ());
                    ayVar.a(bmVar, 0);
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, ayVar);
                    }
                }
            }
        }
    }

    public void blq() {
        int i;
        if (aMt() != null) {
            List<PhotoLiveCardData> bkJ = bkJ();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bkJ != null && bkJ.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof ay)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int sA = sA(i);
                ay ayVar = new ay();
                a(ayVar, bkJ);
                getThreadList().add(sA, ayVar);
            }
        }
    }

    private void a(ay ayVar, List<PhotoLiveCardData> list) {
        if (ayVar != null && !com.baidu.tbadk.core.util.z.t(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            ayVar.setThreadType(33);
            ayVar.setAuthor(metaData);
            ayVar.cy(photoLiveCardData.getForumName());
            ayVar.setTitle(photoLiveCardData.getTitle());
            ayVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            ayVar.cu(new StringBuilder(String.valueOf(photoLiveCardData.getThreadId())).toString());
            ayVar.m(photoLiveCardData.getLastModifiedTime());
            ayVar.bQ(photoLiveCardData.getDiscussNum());
        }
    }

    private int sA(int i) {
        int agP = agP();
        int bkP = bkP();
        if (bkM()) {
            bkP++;
        }
        return Math.min((bkP + agP) - 1, i);
    }

    public void blr() {
        bm bkT;
        int i;
        if (aMt() != null && (bkT = bkT()) != null) {
            Log.e(PbActivityConfig.VALUE_FROM_FRS, "addCardVideoInfoToThreadList cardVideoInfo:" + bkT.getTid());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof ay)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                threadList.add(sA(i), bkT);
            }
        }
    }

    public void bls() {
        if (aMt() != null) {
            List<com.baidu.adp.widget.ListView.v> ble = ble();
            List<Integer> bld = bld();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bld != null && bld.size() > 0 && ble != null && ble.size() > 0 && threadList != null) {
                int size = bld.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < ble.size()) {
                        com.baidu.adp.widget.ListView.v vVar = ble.get(i);
                        int bs = bs(bld.get(i).intValue(), size2);
                        Log.e(PbActivityConfig.VALUE_FROM_FRS, "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bs + "  Title:" + vVar.getType());
                        threadList.add(bs, vVar);
                    }
                }
            }
        }
    }

    private int bs(int i, int i2) {
        int agP = agP();
        if (bkM()) {
            i++;
        }
        return Math.min((agP + i) - 1, i2);
    }

    public void blt() {
        if (bkM()) {
            int agP = agP();
            if (rb() == 0) {
                agP++;
            }
            az azVar = new az();
            azVar.a(bkN());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(agP, azVar);
            }
        }
    }

    public bm rd(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next != null && (next instanceof bm) && TextUtils.equals(str, ((bm) next).getId())) {
                return (bm) next;
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
                    if (next != null && (next instanceof bm) && ((bm) next).getAuthor() != null && currentAccount.equals(((bm) next).getAuthor().getUserId()) && ((bm) next).getAuthor().getPendantData() != null) {
                        ((bm) next).getAuthor().getPendantData().P(jVar.Ch());
                        ((bm) next).getAuthor().getPendantData().cw(jVar.pI());
                    }
                }
            }
        }
    }

    public void X(bm bmVar) {
        this.threadList.remove(bmVar);
    }

    public boolean d(l lVar) {
        if (lVar == null) {
            return false;
        }
        d(lVar.qe());
        a(lVar.bkG());
        lM(lVar.bkC());
        qZ(lVar.bkD());
        c(lVar.aMt());
        setGameName(lVar.getGameName());
        ra(lVar.bkK());
        a(lVar.bkE());
        lN(lVar.bkH());
        mG(lVar.aMH());
        cP(lVar.bkJ());
        sx(lVar.bkP());
        c(lVar.bkN());
        a(lVar.qu());
        a(lVar.bkA());
        cN(lVar.bkI());
        az(lVar.getThreadList());
        cM(lVar.bkF());
        d(lVar.getUserData());
        setUserMap(lVar.getUserMap());
        a(lVar.bkB());
        cO(lVar.bkL());
        sy(lVar.bkU());
        cR(lVar.bkR());
        rc(lVar.bkS());
        W(lVar.bkT());
        a(lVar.bkV());
        sz(lVar.bkY());
        a(lVar.bkZ());
        a(lVar.bla());
        su(lVar.bkx());
        a(lVar.blb());
        sv(lVar.bky());
        sw(lVar.bkz());
        this.fJJ = lVar.fJJ;
        this.fKh = lVar.fKh;
        this.fKk = lVar.fKk;
        a(lVar.bkW());
        h(lVar.blc());
        a(lVar.bkX());
        a(lVar.bkO());
        cS(lVar.bld());
        cT(lVar.ble());
        lO(lVar.isShowDriftingBottle());
        cF(lVar.blf());
        this.fKw = lVar.fKw;
        a(lVar.blg());
        a(lVar.bkw());
        return true;
    }

    public void blu() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.erp != null && this.erp.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if (vVar instanceof bm) {
                    bm bmVar = (bm) vVar;
                    if (bmVar == null || (!bmVar.rS() && bmVar.ro() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.erp.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar = new h();
                hVar.setForumId(this.erp.getId());
                hVar.cL(feedForumList);
                this.threadList.add(i + 6, hVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void lP(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.z.t(this.threadList)) {
            blv();
            if (blg() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                    if (vVar instanceof bm) {
                        bm bmVar = (bm) vVar;
                        if (bmVar == null || (!bmVar.rS() && bmVar.ro() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((blg().ajo() + i) - 1 < this.threadList.size()) {
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
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("game_rank_list_info", String.valueOf(System.currentTimeMillis()) + ",1");
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("game_rank_list_show_times", 0);
                            if (!z3) {
                                this.threadList.add((blg().ajo() + i) - 1, blg());
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

    public void blv() {
        if (!com.baidu.tbadk.core.util.z.t(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.cws) {
                    it.remove();
                }
            }
        }
    }

    public boolean blw() {
        com.baidu.tieba.card.data.p recomTopicData;
        if (this.threadList == null || this.erp == null || this.erp.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
            if (vVar instanceof bm) {
                bm bmVar = (bm) vVar;
                if (bmVar == null || (!bmVar.rS() && bmVar.ro() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.erp.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.z.s(recomTopicData.bEF) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new au("c10835").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void blx() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bkY = (bkY() + agP()) - 1;
            if (bkZ() != null && bkY >= 0 && bkY <= this.threadList.size()) {
                this.threadList.add(bkY, bkZ());
            }
        }
    }

    public void bly() {
        int intValue;
        if (bkO() != null && (bkO().position.intValue() + agP()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bkO());
        }
    }

    public List<com.baidu.adp.widget.ListView.v> blz() {
        return this.fKq;
    }

    public void cU(List<com.baidu.adp.widget.ListView.v> list) {
        this.fKq = list;
    }

    public boolean blA() {
        return bkA() != null && bkA().blh() == 1;
    }

    public boolean blB() {
        return bla() == null ? !com.baidu.tbadk.core.util.z.t(bkL()) : !com.baidu.tbadk.core.util.z.t(bla().tab);
    }

    public void a(BannerListData bannerListData) {
        this.fKO = true;
        this.fKP = bannerListData;
    }
}
