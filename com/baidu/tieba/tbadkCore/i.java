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
    private boolean bdG;
    private int ggw = 0;
    private BannerListData ggx;

    public void c(o oVar) {
        if (oVar != null) {
            this.eDL.setCurScore(oVar.getCurScore());
            this.eDL.setLevelupScore(oVar.getLevelupScore());
            this.eDL.setLike(oVar.isLike());
            this.eDL.setUser_level(oVar.getUserLevel());
            this.eDL.setLevelName(oVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.eDL.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.eDL == null) {
            return null;
        }
        return this.eDL.getSignData();
    }

    public void brp() {
        bn top_notice_data;
        com.baidu.adp.widget.ListView.f fVar;
        if (aPh() != null && this.threadList != null && (top_notice_data = aPh().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (fVar = this.threadList.get(0)) != null && (fVar instanceof bl) && ((bl) fVar).rA() == 2) {
                this.threadList.remove(0);
            }
            bl blVar = new bl();
            blVar.setTitle(top_notice_data.getTitle());
            blVar.cF(top_notice_data.td());
            blVar.bT(2);
            blVar.sn();
            this.threadList.add(0, blVar);
        }
    }

    public void a(ao aoVar) {
        if (aoVar != null && !StringUtils.isNull(aoVar.getId()) && this.threadList != null) {
            int aiA = aiA();
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
                    this.ggw++;
                    this.threadList.add(aiA, axVar);
                    return;
                }
                return;
            }
            this.ggw++;
            this.threadList.add(aiA, aoVar);
        }
    }

    public void brq() {
        this.ggw = 0;
    }

    public int aiA() {
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
                } else if (((bl) next).rA() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    private int ro() {
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
            if ((next instanceof bl) && ((bl) next).rC() == 1) {
                return ((bl) next).ro();
            }
        }
        return -1;
    }

    public void brr() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bl.Ze || this.threadList.get(i2).getType() == bl.Zf || this.threadList.get(i2).getType() == bl.Zg) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void brs() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dEx != null && this.dEx.qB() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if ((fVar instanceof bl) && fVar.getType() == bl.aam) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int aiA = aiA();
            if (i > aiA) {
                this.threadList.add(aiA, this.threadList.remove(i));
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
        if (!this.bdG) {
            if (this.eDL != null) {
                bannerListData = this.eDL.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.ggx;
        }
        this.bdG = false;
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
            bVar3.bX(qH().qB());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void brt() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i);
            if (fVar instanceof bl) {
                bl blVar = (bl) fVar;
                if (blVar.isPhotoLiveThread() && !(blVar instanceof ax)) {
                    ax axVar = new ax();
                    axVar.r(bqL());
                    axVar.a(blVar, 0);
                    if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, axVar);
                    }
                }
            }
        }
    }

    public void bru() {
        int i;
        if (aPh() != null) {
            List<PhotoLiveCardData> bqL = bqL();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (bqL != null && bqL.size() > 0 && threadList != null && threadList.size() > 0) {
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
                a(axVar, bqL);
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
            axVar.cJ(photoLiveCardData.getForumName());
            axVar.setTitle(photoLiveCardData.getTitle());
            axVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            axVar.cF(photoLiveCardData.getThreadId() + "");
            axVar.m(photoLiveCardData.getLastModifiedTime());
            axVar.bR(photoLiveCardData.getDiscussNum());
        }
    }

    private int td(int i) {
        int aiA = aiA();
        int bqR = bqR();
        if (bqO()) {
            bqR++;
        }
        return Math.min((bqR + aiA) - 1, i);
    }

    public void brv() {
        bl bqV;
        int i;
        if (aPh() != null && (bqV = bqV()) != null) {
            Log.e(PbActivityConfig.VALUE_FROM_FRS, "addCardVideoInfoToThreadList cardVideoInfo:" + bqV.getTid());
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
                threadList.add(td(i), bqV);
            }
        }
    }

    public void brw() {
        if (aPh() != null) {
            List<com.baidu.adp.widget.ListView.f> brg = brg();
            List<Integer> brf = brf();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (brf != null && brf.size() > 0 && brg != null && brg.size() > 0 && threadList != null) {
                int size = brf.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < brg.size()) {
                        com.baidu.adp.widget.ListView.f fVar = brg.get(i);
                        int bv = bv(brf.get(i).intValue(), size2);
                        Log.e(PbActivityConfig.VALUE_FROM_FRS, "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bv + "  Title:" + fVar.getType());
                        threadList.add(bv, fVar);
                    }
                }
            }
        }
    }

    private int bv(int i, int i2) {
        int aiA = aiA();
        if (bqO()) {
            i++;
        }
        return Math.min((aiA + i) - 1, i2);
    }

    public void brx() {
        if (bqO()) {
            int aiA = aiA();
            if (ro() == 0) {
                aiA++;
            }
            ay ayVar = new ay();
            ayVar.a(bqP());
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(aiA, ayVar);
            }
        }
    }

    public bl rT(String str) {
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
                        ((bl) next).getAuthor().getPendantData().Q(jVar.CB());
                        ((bl) next).getAuthor().getPendantData().cH(jVar.pV());
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
        d(gVar.qr());
        a(gVar.bqI());
        ms(gVar.bqE());
        rP(gVar.bqF());
        c(gVar.aPh());
        setGameName(gVar.getGameName());
        rQ(gVar.bqM());
        a(gVar.bqG());
        mt(gVar.bqJ());
        mO(gVar.aPv());
        dl(gVar.bqL());
        ta(gVar.bqR());
        c(gVar.bqP());
        a(gVar.qH());
        a(gVar.bqC());
        dj(gVar.bqK());
        aB(gVar.getThreadList());
        di(gVar.bqH());
        setUserData(gVar.getUserData());
        setUserMap(gVar.getUserMap());
        a(gVar.bqD());
        dk(gVar.bqN());
        tb(gVar.bqW());
        dn(gVar.bqT());
        rS(gVar.bqU());
        ah(gVar.bqV());
        a(gVar.bqX());
        tc(gVar.bra());
        a(gVar.brb());
        a(gVar.brc());
        sX(gVar.bqz());
        a(gVar.brd());
        sY(gVar.bqA());
        sZ(gVar.bqB());
        this.gfq = gVar.gfq;
        this.gfO = gVar.gfO;
        this.gfR = gVar.gfR;
        a(gVar.bqY());
        i(gVar.bre());
        a(gVar.bqZ());
        a(gVar.bqQ());
        m13do(gVar.brf());
        dp(gVar.brg());
        mu(gVar.isShowDriftingBottle());
        cS(gVar.brh());
        this.ggd = gVar.ggd;
        a(gVar.bri());
        a(gVar.bqy());
        dh(gVar.bqx());
        a(gVar.brj());
        dq(gVar.brk());
        return true;
    }

    public void bry() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.eDL != null && this.eDL.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if (fVar instanceof bl) {
                    bl blVar = (bl) fVar;
                    if (blVar == null || (!blVar.sg() && blVar.rC() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.eDL.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                f fVar2 = new f();
                fVar2.setForumId(this.eDL.getId());
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
            brz();
            if (bri() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                    if (fVar instanceof bl) {
                        bl blVar = (bl) fVar;
                        if (blVar == null || (!blVar.sg() && blVar.rC() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bri().alb() + i) - 1 < this.threadList.size()) {
                    String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("game_rank_list_info", "");
                    if (StringUtils.isNull(string) || string.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length != 2) {
                        z2 = true;
                    } else {
                        z2 = UtilHelper.getDayBetweenTime(com.baidu.adp.lib.g.b.d(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0], 0L), System.currentTimeMillis()) >= ((long) com.baidu.adp.lib.g.b.g(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1], 0));
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
                                this.threadList.add((bri().alb() + i) - 1, bri());
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

    public void brz() {
        if (!com.baidu.tbadk.core.util.u.v(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.cEX) {
                    it.remove();
                }
            }
        }
    }

    public boolean brA() {
        com.baidu.tieba.card.data.p recomTopicData;
        if (this.threadList == null || this.eDL == null || this.eDL.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
            if (fVar instanceof bl) {
                bl blVar = (bl) fVar;
                if (blVar == null || (!blVar.sg() && blVar.rC() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.eDL.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.u.u(recomTopicData.bKb) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new aj("c10835").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void brB() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bra = (bra() + aiA()) - 1;
            if (brb() != null && bra >= 0 && bra <= this.threadList.size()) {
                this.threadList.add(bra, brb());
            }
        }
    }

    public void brC() {
        int intValue;
        if (bqQ() != null && (bqQ().position.intValue() + aiA()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bqQ());
        }
    }

    public List<com.baidu.adp.widget.ListView.f> brD() {
        return this.gfX;
    }

    public void dr(List<com.baidu.adp.widget.ListView.f> list) {
        this.gfX = list;
    }

    public boolean brE() {
        if (bqC() == null) {
            return false;
        }
        return bqC().brl() == 1;
    }

    public boolean brF() {
        return brc() == null ? !com.baidu.tbadk.core.util.u.v(bqN()) : !com.baidu.tbadk.core.util.u.v(brc().tab);
    }

    public void a(BannerListData bannerListData) {
        this.bdG = true;
        this.ggx = bannerListData;
    }
}
