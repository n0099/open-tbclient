package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes.dex */
public class k extends h implements com.baidu.tbadk.mvc.b.l {
    private boolean bkM;
    private int gAy = 0;
    private BannerListData gAz;
    private List<RecmForumInfo> recm_forum_list;

    public void c(q qVar) {
        if (qVar != null) {
            this.ePl.setCurScore(qVar.getCurScore());
            this.ePl.setLevelupScore(qVar.getLevelupScore());
            this.ePl.setLike(qVar.isLike());
            this.ePl.setUser_level(qVar.getUserLevel());
            this.ePl.setLevelName(qVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.ePl.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.ePl == null) {
            return null;
        }
        return this.ePl.getSignData();
    }

    public void bvJ() {
        bg top_notice_data;
        com.baidu.adp.widget.ListView.f fVar;
        if (aRn() != null && this.threadList != null && (top_notice_data = aRn().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (fVar = this.threadList.get(0)) != null && (fVar instanceof bd) && ((bd) fVar).rq() == 2) {
                this.threadList.remove(0);
            }
            bd bdVar = new bd();
            bdVar.setTitle(top_notice_data.getTitle());
            bdVar.cD(top_notice_data.sU());
            bdVar.bS(2);
            bdVar.sd();
            this.threadList.add(0, bdVar);
        }
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.threadList != null) {
            int apW = apW();
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
                    this.gAy++;
                    this.threadList.add(apW, arVar);
                    return;
                }
                return;
            }
            this.gAy++;
            this.threadList.add(apW, aiVar);
        }
    }

    public void bvK() {
        this.gAy = 0;
    }

    public int apW() {
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
                } else if (((bd) next).rq() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    private int rc() {
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
            if ((next instanceof bd) && ((bd) next).rs() == 1) {
                return ((bd) next).rc();
            }
        }
        return -1;
    }

    public void bvL() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bd.YE || this.threadList.get(i2).getType() == bd.YF || this.threadList.get(i2).getType() == bd.YG) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bvM() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.eaH != null && this.eaH.qs() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if ((fVar instanceof bd) && fVar.getType() == bd.ZO) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int apW = apW();
            if (i > apW) {
                this.threadList.add(apW, this.threadList.remove(i));
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
        if (!this.bkM) {
            if (this.ePl != null) {
                bannerListData = this.ePl.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gAz;
        }
        this.bkM = false;
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
            bVar3.cj(z);
            bVar3.O(arrayList);
            bVar3.Q(arrayList2);
            bVar3.ck(z2);
            bVar3.bY(qy().qs());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void bvN() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i);
            if (fVar instanceof bd) {
                bd bdVar = (bd) fVar;
                if (bdVar.isPhotoLiveThread() && !(bdVar instanceof ar)) {
                    ar arVar = new ar();
                    arVar.s(bvd());
                    arVar.a(bdVar, 0);
                    if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, arVar);
                    }
                }
            }
        }
    }

    public void bvO() {
        int i;
        if (aRn() != null) {
            List<PhotoLiveCardData> bvd = bvd();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (bvd != null && bvd.size() > 0 && threadList != null && threadList.size() > 0) {
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
                int ur = ur(i);
                ar arVar = new ar();
                a(arVar, bvd);
                getThreadList().add(ur, arVar);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.h
    public List<RecmForumInfo> buQ() {
        return this.recm_forum_list;
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

    private int ur(int i) {
        int apW = apW();
        int bvi = bvi();
        if (bvg()) {
            bvi++;
        }
        return Math.min((bvi + apW) - 1, i);
    }

    public void bvP() {
        e bvE;
        if (this.threadList != null && aRn() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null && (bvE = bvE()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(bT(bvE.gyK, threadList.size()), bvE);
        }
    }

    public void bvQ() {
        a(e.class, getThreadList());
    }

    private int bT(int i, int i2) {
        int apW = apW();
        if (bvg()) {
            i++;
        }
        return Math.min((apW + i) - 1, i2);
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

    public void bvR() {
        bd bvm;
        int i;
        if (aRn() != null && (bvm = bvm()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + bvm.getTid());
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
                threadList.add(ur(i), bvm);
            }
        }
    }

    public void bvS() {
        if (aRn() != null) {
            List<com.baidu.adp.widget.ListView.f> bvx = bvx();
            List<Integer> bvw = bvw();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (bvw != null && bvw.size() > 0 && bvx != null && bvx.size() > 0 && threadList != null) {
                int size = bvw.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bvx.size()) {
                        com.baidu.adp.widget.ListView.f fVar = bvx.get(i);
                        int bU = bU(bvw.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bU + "  Title:" + fVar.getType());
                        threadList.add(bU, fVar);
                    }
                }
            }
        }
    }

    private int bU(int i, int i2) {
        int apW = apW();
        if (bvg()) {
            i++;
        }
        return Math.min((apW + i) - 1, i2);
    }

    public void bvT() {
        if (bvg()) {
            int apW = apW();
            if (rc() == 0) {
                apW++;
            }
            as asVar = new as();
            asVar.a(bvh());
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(apW, asVar);
            }
        }
    }

    public bd sV(String str) {
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
                    if (next != null && (next instanceof bd) && ((bd) next).rv() != null && currentAccount.equals(((bd) next).rv().getUserId()) && ((bd) next).rv().getPendantData() != null) {
                        ((bd) next).rv().getPendantData().T(kVar.CF());
                        ((bd) next).rv().getPendantData().cF(kVar.pR());
                    }
                }
            }
        }
    }

    public void al(bd bdVar) {
        this.threadList.remove(bdVar);
    }

    public boolean e(h hVar) {
        if (hVar == null) {
            return false;
        }
        c(hVar.qg());
        a(hVar.bva());
        mY(hVar.buW());
        sR(hVar.buX());
        c(hVar.aRn());
        setGameName(hVar.getGameName());
        sS(hVar.bve());
        a(hVar.buY());
        mZ(hVar.bvb());
        pJ(hVar.aRB());
        dw(hVar.bvd());
        un(hVar.bvi());
        c(hVar.bvh());
        a(hVar.qy());
        a(hVar.buU());
        du(hVar.bvc());
        aA(hVar.getThreadList());
        dt(hVar.buZ());
        e(hVar.getUserData());
        setUserMap(hVar.getUserMap());
        a(hVar.buV());
        dv(hVar.bvf());
        uo(hVar.bvn());
        dy(hVar.bvk());
        sU(hVar.bvl());
        ak(hVar.bvm());
        a(hVar.bvo());
        up(hVar.bvr());
        a(hVar.bvs());
        a(hVar.bvt());
        uk(hVar.buR());
        a(hVar.bvu());
        ul(hVar.buS());
        um(hVar.buT());
        this.gzl = hVar.gzl;
        this.gzI = hVar.gzI;
        this.gzL = hVar.gzL;
        a(hVar.bvp());
        k(hVar.bvv());
        a(hVar.bvq());
        dz(hVar.bvw());
        dA(hVar.bvx());
        this.gzX = hVar.gzX;
        a(hVar.bvy());
        a(hVar.buO());
        ds(hVar.buN());
        a(hVar.bvz());
        dB(hVar.bvA());
        uq(hVar.bvB());
        a(hVar.buP());
        a(hVar.bvC());
        a(hVar.bvD());
        this.gAh = hVar.gAh;
        b(hVar.bvE());
        this.recm_forum_list = hVar.buQ();
        return true;
    }

    public void bvU() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.ePl != null && this.ePl.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if (fVar instanceof bd) {
                    bd bdVar = (bd) fVar;
                    if (bdVar == null || (!bdVar.rW() && bdVar.rs() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.ePl.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                g gVar = new g();
                gVar.setForumId(this.ePl.getId());
                gVar.dr(feedForumList);
                this.threadList.add(i + 6, gVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void na(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.w(this.threadList)) {
            bvV();
            if (bvy() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                    if (fVar instanceof bd) {
                        bd bdVar = (bd) fVar;
                        if (bdVar == null || (!bdVar.rW() && bdVar.rs() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bvy().asx() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((bvy().asx() + i) - 1, bvy());
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

    public void bvV() {
        if (!com.baidu.tbadk.core.util.v.w(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.dik) {
                    it.remove();
                }
            }
        }
    }

    public boolean bvW() {
        com.baidu.tieba.card.data.p recomTopicData;
        if (this.threadList == null || this.ePl == null || this.ePl.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
            if (fVar instanceof bd) {
                bd bdVar = (bd) fVar;
                if (bdVar == null || (!bdVar.rW() && bdVar.rs() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.ePl.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.v(recomTopicData.cem) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ak("c10835").ac("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bvX() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bvr = (bvr() + apW()) - 1;
            if (bvs() != null && bvr >= 0 && bvr <= this.threadList.size()) {
                this.threadList.add(bvr, bvs());
            }
        }
    }

    public void bvY() {
        int sx;
        if (bvC() != null) {
            com.baidu.tieba.frs.r bvC = bvC();
            if (com.baidu.tbadk.core.util.v.v(bvC.getUserInfo()) >= 3 && (sx = bvC.sx()) > 0) {
                int apW = sx + apW();
                if (apW > this.threadList.size()) {
                    this.threadList.add(bvC);
                } else {
                    this.threadList.add(apW, bvC);
                }
            }
        }
    }

    public void bvZ() {
        if (bvD() != null && !com.baidu.tbadk.core.util.v.w(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next != null && next.getType() == j.gAx) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, bvD());
        }
    }

    public List<com.baidu.adp.widget.ListView.f> bwa() {
        return this.gzR;
    }

    public void dC(List<com.baidu.adp.widget.ListView.f> list) {
        this.gzR = list;
    }

    public boolean bwb() {
        if (buU() == null) {
            return false;
        }
        return buU().bvF() == 1;
    }

    public boolean bwc() {
        return bvt() == null ? !com.baidu.tbadk.core.util.v.w(bvf()) : !com.baidu.tbadk.core.util.v.w(bvt().tab);
    }

    public void a(BannerListData bannerListData) {
        this.bkM = true;
        this.gAz = bannerListData;
    }
}
