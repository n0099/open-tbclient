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
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class i extends g implements com.baidu.tbadk.mvc.b.l {
    private boolean bcw;
    private int gfl = 0;
    private BannerListData gfm;

    public void c(o oVar) {
        if (oVar != null) {
            this.eCy.setCurScore(oVar.getCurScore());
            this.eCy.setLevelupScore(oVar.getLevelupScore());
            this.eCy.setLike(oVar.isLike());
            this.eCy.setUser_level(oVar.getUserLevel());
            this.eCy.setLevelName(oVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.eCy.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.eCy == null) {
            return null;
        }
        return this.eCy.getSignData();
    }

    public void bri() {
        bn top_notice_data;
        com.baidu.adp.widget.ListView.f fVar;
        if (aOW() != null && this.threadList != null && (top_notice_data = aOW().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (fVar = this.threadList.get(0)) != null && (fVar instanceof bl) && ((bl) fVar).rq() == 2) {
                this.threadList.remove(0);
            }
            bl blVar = new bl();
            blVar.setTitle(top_notice_data.getTitle());
            blVar.cz(top_notice_data.sT());
            blVar.bR(2);
            blVar.sd();
            this.threadList.add(0, blVar);
        }
    }

    public void a(ao aoVar) {
        if (aoVar != null && !StringUtils.isNull(aoVar.getId()) && this.threadList != null) {
            int aio = aio();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = threadList.get(i);
                    if ((fVar instanceof bl) && aoVar.getId().equals(((bl) fVar).getId())) {
                        return;
                    }
                }
            }
            if (aoVar.isPhotoLiveThread()) {
                ax axVar = new ax();
                axVar.a(aoVar, -1);
                axVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.gfl++;
                    this.threadList.add(aio, axVar);
                    return;
                }
                return;
            }
            this.gfl++;
            this.threadList.add(aio, aoVar);
        }
    }

    public void brj() {
        this.gfl = 0;
    }

    public int aio() {
        int i = 0;
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof bl)) {
                    i = i2;
                } else if (((bl) next).rq() != 0) {
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
            if ((next instanceof bl) && ((bl) next).rs() == 1) {
                return ((bl) next).re();
            }
        }
        return -1;
    }

    public void brk() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bl.XI || this.threadList.get(i2).getType() == bl.XJ || this.threadList.get(i2).getType() == bl.XK) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void brl() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dDg != null && this.dDg.qr() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if ((fVar instanceof bl) && fVar.getType() == bl.YQ) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int aio = aio();
            if (i > aio) {
                this.threadList.add(aio, this.threadList.remove(i));
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
        if (!this.bcw) {
            if (this.eCy != null) {
                bannerListData = this.eCy.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gfm;
        }
        this.bcw = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar2.N(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.cj(z);
            bVar3.setThreadList(arrayList);
            bVar3.O(arrayList2);
            bVar3.ck(z2);
            bVar3.bV(qx().qr());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void brm() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i);
            if (fVar instanceof bl) {
                bl blVar = (bl) fVar;
                if (blVar.isPhotoLiveThread() && !(blVar instanceof ax)) {
                    ax axVar = new ax();
                    axVar.r(bqE());
                    axVar.a(blVar, 0);
                    if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, axVar);
                    }
                }
            }
        }
    }

    public void brn() {
        int i;
        if (aOW() != null) {
            List<PhotoLiveCardData> bqE = bqE();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (bqE != null && bqE.size() > 0 && threadList != null && threadList.size() > 0) {
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
                int td = td(i);
                ax axVar = new ax();
                a(axVar, bqE);
                getThreadList().add(td, axVar);
            }
        }
    }

    private void a(ax axVar, List<PhotoLiveCardData> list) {
        if (axVar != null && !com.baidu.tbadk.core.util.u.v(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            axVar.setThreadType(33);
            axVar.setAuthor(metaData);
            axVar.cD(photoLiveCardData.getForumName());
            axVar.setTitle(photoLiveCardData.getTitle());
            axVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            axVar.cz(photoLiveCardData.getThreadId() + "");
            axVar.m(photoLiveCardData.getLastModifiedTime());
            axVar.bP(photoLiveCardData.getDiscussNum());
        }
    }

    private int td(int i) {
        int aio = aio();
        int bqK = bqK();
        if (bqH()) {
            bqK++;
        }
        return Math.min((bqK + aio) - 1, i);
    }

    public void bro() {
        bl bqO;
        int i;
        if (aOW() != null && (bqO = bqO()) != null) {
            Log.e(PbActivityConfig.VALUE_FROM_FRS, "addCardVideoInfoToThreadList cardVideoInfo:" + bqO.getTid());
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
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
                threadList.add(td(i), bqO);
            }
        }
    }

    public void brp() {
        if (aOW() != null) {
            List<com.baidu.adp.widget.ListView.f> bqZ = bqZ();
            List<Integer> bqY = bqY();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (bqY != null && bqY.size() > 0 && bqZ != null && bqZ.size() > 0 && threadList != null) {
                int size = bqY.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bqZ.size()) {
                        com.baidu.adp.widget.ListView.f fVar = bqZ.get(i);
                        int bu = bu(bqY.get(i).intValue(), size2);
                        Log.e(PbActivityConfig.VALUE_FROM_FRS, "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bu + "  Title:" + fVar.getType());
                        threadList.add(bu, fVar);
                    }
                }
            }
        }
    }

    private int bu(int i, int i2) {
        int aio = aio();
        if (bqH()) {
            i++;
        }
        return Math.min((aio + i) - 1, i2);
    }

    public void brq() {
        if (bqH()) {
            int aio = aio();
            if (re() == 0) {
                aio++;
            }
            ay ayVar = new ay();
            ayVar.a(bqI());
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(aio, ayVar);
            }
        }
    }

    public bl rO(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
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
                Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next != null && (next instanceof bl) && ((bl) next).getAuthor() != null && currentAccount.equals(((bl) next).getAuthor().getUserId()) && ((bl) next).getAuthor().getPendantData() != null) {
                        ((bl) next).getAuthor().getPendantData().Q(jVar.Ct());
                        ((bl) next).getAuthor().getPendantData().cB(jVar.pL());
                    }
                }
            }
        }
    }

    public void ai(bl blVar) {
        this.threadList.remove(blVar);
    }

    public boolean e(g gVar) {
        if (gVar == null) {
            return false;
        }
        d(gVar.qh());
        a(gVar.bqB());
        ms(gVar.bqx());
        rK(gVar.bqy());
        c(gVar.aOW());
        setGameName(gVar.getGameName());
        rL(gVar.bqF());
        a(gVar.bqz());
        mt(gVar.bqC());
        mO(gVar.aPk());
        dl(gVar.bqE());
        ta(gVar.bqK());
        c(gVar.bqI());
        a(gVar.qx());
        a(gVar.bqv());
        dj(gVar.bqD());
        aB(gVar.getThreadList());
        di(gVar.bqA());
        setUserData(gVar.getUserData());
        setUserMap(gVar.getUserMap());
        a(gVar.bqw());
        dk(gVar.bqG());
        tb(gVar.bqP());
        dn(gVar.bqM());
        rN(gVar.bqN());
        ah(gVar.bqO());
        a(gVar.bqQ());
        tc(gVar.bqT());
        a(gVar.bqU());
        a(gVar.bqV());
        sX(gVar.bqs());
        a(gVar.bqW());
        sY(gVar.bqt());
        sZ(gVar.bqu());
        this.gef = gVar.gef;
        this.geD = gVar.geD;
        this.geG = gVar.geG;
        a(gVar.bqR());
        i(gVar.bqX());
        a(gVar.bqS());
        a(gVar.bqJ());
        m13do(gVar.bqY());
        dp(gVar.bqZ());
        mu(gVar.isShowDriftingBottle());
        cS(gVar.bra());
        this.geS = gVar.geS;
        a(gVar.brb());
        a(gVar.bqr());
        dh(gVar.bqq());
        a(gVar.brc());
        dq(gVar.brd());
        return true;
    }

    public void brr() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.eCy != null && this.eCy.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if (fVar instanceof bl) {
                    bl blVar = (bl) fVar;
                    if (blVar == null || (!blVar.rW() && blVar.rs() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.eCy.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                f fVar2 = new f();
                fVar2.setForumId(this.eCy.getId());
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
    public void mv(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.u.v(this.threadList)) {
            brs();
            if (brb() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                    if (fVar instanceof bl) {
                        bl blVar = (bl) fVar;
                        if (blVar == null || (!blVar.rW() && blVar.rs() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((brb().akO() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((brb().akO() + i) - 1, brb());
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

    public void brs() {
        if (!com.baidu.tbadk.core.util.u.v(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.cDC) {
                    it.remove();
                }
            }
        }
    }

    public boolean brt() {
        com.baidu.tieba.card.data.p recomTopicData;
        if (this.threadList == null || this.eCy == null || this.eCy.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
            if (fVar instanceof bl) {
                bl blVar = (bl) fVar;
                if (blVar == null || (!blVar.rW() && blVar.rs() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.eCy.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.u.u(recomTopicData.bIR) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new aj("c10835").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bru() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bqT = (bqT() + aio()) - 1;
            if (bqU() != null && bqT >= 0 && bqT <= this.threadList.size()) {
                this.threadList.add(bqT, bqU());
            }
        }
    }

    public void brv() {
        int intValue;
        if (bqJ() != null && (bqJ().position.intValue() + aio()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bqJ());
        }
    }

    public List<com.baidu.adp.widget.ListView.f> brw() {
        return this.geM;
    }

    public void dr(List<com.baidu.adp.widget.ListView.f> list) {
        this.geM = list;
    }

    public boolean brx() {
        if (bqv() == null) {
            return false;
        }
        return bqv().bre() == 1;
    }

    public boolean bry() {
        return bqV() == null ? !com.baidu.tbadk.core.util.u.v(bqG()) : !com.baidu.tbadk.core.util.u.v(bqV().tab);
    }

    public void a(BannerListData bannerListData) {
        this.bcw = true;
        this.gfm = bannerListData;
    }
}
