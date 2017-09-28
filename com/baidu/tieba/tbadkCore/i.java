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
import com.baidu.tbadk.core.util.v;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class i extends g implements com.baidu.tbadk.mvc.b.l {
    private boolean bfr;
    private int gfs = 0;
    private BannerListData gft;

    public void c(o oVar) {
        if (oVar != null) {
            this.eyq.setCurScore(oVar.getCurScore());
            this.eyq.setLevelupScore(oVar.getLevelupScore());
            this.eyq.setLike(oVar.isLike());
            this.eyq.setUser_level(oVar.getUserLevel());
            this.eyq.setLevelName(oVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.eyq.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.eyq == null) {
            return null;
        }
        return this.eyq.getSignData();
    }

    public void bqn() {
        bj top_notice_data;
        com.baidu.adp.widget.ListView.f fVar;
        if (aMZ() != null && this.threadList != null && (top_notice_data = aMZ().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (fVar = this.threadList.get(0)) != null && (fVar instanceof bh) && ((bh) fVar).rq() == 2) {
                this.threadList.remove(0);
            }
            bh bhVar = new bh();
            bhVar.setTitle(top_notice_data.getTitle());
            bhVar.cy(top_notice_data.sU());
            bhVar.bU(2);
            bhVar.sd();
            this.threadList.add(0, bhVar);
        }
    }

    public void a(am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && this.threadList != null) {
            int akZ = akZ();
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
                    this.gfs++;
                    this.threadList.add(akZ, avVar);
                    return;
                }
                return;
            }
            this.gfs++;
            this.threadList.add(akZ, amVar);
        }
    }

    public void bqo() {
        this.gfs = 0;
    }

    public int akZ() {
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
                } else if (((bh) next).rq() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    private int rd() {
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
            if ((next instanceof bh) && ((bh) next).rs() == 1) {
                return ((bh) next).rd();
            }
        }
        return -1;
    }

    public void bqp() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bh.Ym || this.threadList.get(i2).getType() == bh.Yn || this.threadList.get(i2).getType() == bh.Yo) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bqq() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dKm != null && this.dKm.qr() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if ((fVar instanceof bh) && fVar.getType() == bh.Zs) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int akZ = akZ();
            if (i > akZ) {
                this.threadList.add(akZ, this.threadList.remove(i));
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
        if (!this.bfr) {
            if (this.eyq != null) {
                bannerListData = this.eyq.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gft;
        }
        this.bfr = false;
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
            bVar3.M(arrayList);
            bVar3.O(arrayList2);
            bVar3.ck(z2);
            bVar3.bY(qx().qr());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void bqr() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i);
            if (fVar instanceof bh) {
                bh bhVar = (bh) fVar;
                if (bhVar.isPhotoLiveThread() && !(bhVar instanceof av)) {
                    av avVar = new av();
                    avVar.q(bpJ());
                    avVar.a(bhVar, 0);
                    if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, avVar);
                    }
                }
            }
        }
    }

    public void bqs() {
        int i;
        if (aMZ() != null) {
            List<PhotoLiveCardData> bpJ = bpJ();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (bpJ != null && bpJ.size() > 0 && threadList != null && threadList.size() > 0) {
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
                int tw = tw(i);
                av avVar = new av();
                a(avVar, bpJ);
                getThreadList().add(tw, avVar);
            }
        }
    }

    private void a(av avVar, List<PhotoLiveCardData> list) {
        if (avVar != null && !v.u(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            avVar.setThreadType(33);
            avVar.setAuthor(metaData);
            avVar.cC(photoLiveCardData.getForumName());
            avVar.setTitle(photoLiveCardData.getTitle());
            avVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            avVar.cy(photoLiveCardData.getThreadId() + "");
            avVar.l(photoLiveCardData.getLastModifiedTime());
            avVar.bS(photoLiveCardData.getDiscussNum());
        }
    }

    private int tw(int i) {
        int akZ = akZ();
        int bpP = bpP();
        if (bpM()) {
            bpP++;
        }
        return Math.min((bpP + akZ) - 1, i);
    }

    public void bqt() {
        bh bpT;
        int i;
        if (aMZ() != null && (bpT = bpT()) != null) {
            Log.e(PbActivityConfig.VALUE_FROM_FRS, "addCardVideoInfoToThreadList cardVideoInfo:" + bpT.getTid());
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
                threadList.add(tw(i), bpT);
            }
        }
    }

    public void bqu() {
        if (aMZ() != null) {
            List<com.baidu.adp.widget.ListView.f> bqe = bqe();
            List<Integer> bqd = bqd();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (bqd != null && bqd.size() > 0 && bqe != null && bqe.size() > 0 && threadList != null) {
                int size = bqd.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bqe.size()) {
                        com.baidu.adp.widget.ListView.f fVar = bqe.get(i);
                        int bR = bR(bqd.get(i).intValue(), size2);
                        Log.e(PbActivityConfig.VALUE_FROM_FRS, "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bR + "  Title:" + fVar.getType());
                        threadList.add(bR, fVar);
                    }
                }
            }
        }
    }

    private int bR(int i, int i2) {
        int akZ = akZ();
        if (bpM()) {
            i++;
        }
        return Math.min((akZ + i) - 1, i2);
    }

    public void bqv() {
        if (bpM()) {
            int akZ = akZ();
            if (rd() == 0) {
                akZ++;
            }
            aw awVar = new aw();
            awVar.a(bpN());
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(akZ, awVar);
            }
        }
    }

    public bh rH(String str) {
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

    public void a(com.baidu.tbadk.data.i iVar) {
        if (this.threadList != null && iVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next != null && (next instanceof bh) && ((bh) next).getAuthor() != null && currentAccount.equals(((bh) next).getAuthor().getUserId()) && ((bh) next).getAuthor().getPendantData() != null) {
                        ((bh) next).getAuthor().getPendantData().P(iVar.Ca());
                        ((bh) next).getAuthor().getPendantData().cA(iVar.pS());
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
        d(gVar.qh());
        a(gVar.bpG());
        mx(gVar.bpC());
        rD(gVar.bpD());
        c(gVar.aMZ());
        setGameName(gVar.getGameName());
        rE(gVar.bpK());
        a(gVar.bpE());
        my(gVar.bpH());
        oW(gVar.aNn());
        dj(gVar.bpJ());
        tt(gVar.bpP());
        c(gVar.bpN());
        a(gVar.qx());
        a(gVar.bpA());
        dh(gVar.bpI());
        az(gVar.getThreadList());
        dg(gVar.bpF());
        e(gVar.getUserData());
        setUserMap(gVar.getUserMap());
        a(gVar.bpB());
        di(gVar.bpL());
        tu(gVar.bpU());
        dl(gVar.bpR());
        rG(gVar.bpS());
        ah(gVar.bpT());
        a(gVar.bpV());
        tv(gVar.bpY());
        a(gVar.bpZ());
        a(gVar.bqa());
        tq(gVar.bpx());
        a(gVar.bqb());
        tr(gVar.bpy());
        ts(gVar.bpz());
        this.gel = gVar.gel;
        this.geJ = gVar.geJ;
        this.geM = gVar.geM;
        a(gVar.bpW());
        j(gVar.bqc());
        a(gVar.bpX());
        a(gVar.bpO());
        dm(gVar.bqd());
        dn(gVar.bqe());
        this.geX = gVar.geX;
        a(gVar.bqf());
        a(gVar.bpv());
        df(gVar.bpu());
        a(gVar.bqg());
        m12do(gVar.bqh());
        a(gVar.bpw());
        a(gVar.bqi());
        return true;
    }

    public void bqw() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.eyq != null && this.eyq.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if (fVar instanceof bh) {
                    bh bhVar = (bh) fVar;
                    if (bhVar == null || (!bhVar.rW() && bhVar.rs() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.eyq.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                f fVar2 = new f();
                fVar2.setForumId(this.eyq.getId());
                fVar2.de(feedForumList);
                this.threadList.add(i + 6, fVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mz(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!v.u(this.threadList)) {
            bqx();
            if (bqf() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                    if (fVar instanceof bh) {
                        bh bhVar = (bh) fVar;
                        if (bhVar == null || (!bhVar.rW() && bhVar.rs() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bqf().any() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((bqf().any() + i) - 1, bqf());
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

    public void bqx() {
        if (!v.u(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.cPd) {
                    it.remove();
                }
            }
        }
    }

    public boolean bqy() {
        com.baidu.tieba.card.data.p recomTopicData;
        if (this.threadList == null || this.eyq == null || this.eyq.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
            if (fVar instanceof bh) {
                bh bhVar = (bh) fVar;
                if (bhVar == null || (!bhVar.rW() && bhVar.rs() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.eyq.getBannerListData().getRecomTopicData()) == null || v.t(recomTopicData.bNZ) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ak("c10835").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bqz() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bpY = (bpY() + akZ()) - 1;
            if (bpZ() != null && bpY >= 0 && bpY <= this.threadList.size()) {
                this.threadList.add(bpY, bpZ());
            }
        }
    }

    public void bqA() {
        int intValue;
        if (bpO() != null && (bpO().position.intValue() + akZ()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bpO());
        }
    }

    public void bqB() {
        int sw;
        if (bqi() != null) {
            com.baidu.tieba.frs.q bqi = bqi();
            if (v.t(bqi.getUserInfo()) >= 3 && (sw = bqi.sw()) > 0) {
                int akZ = sw + akZ();
                if (akZ > this.threadList.size()) {
                    this.threadList.add(bqi);
                } else {
                    this.threadList.add(akZ, bqi);
                }
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.f> bqC() {
        return this.geS;
    }

    public void dp(List<com.baidu.adp.widget.ListView.f> list) {
        this.geS = list;
    }

    public boolean bqD() {
        if (bpA() == null) {
            return false;
        }
        return bpA().bqj() == 1;
    }

    public boolean bqE() {
        return bqa() == null ? !v.u(bpL()) : !v.u(bqa().tab);
    }

    public void a(BannerListData bannerListData) {
        this.bfr = true;
        this.gft = bannerListData;
    }
}
