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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes.dex */
public class l extends i implements com.baidu.tbadk.mvc.b.l {
    private boolean cay;
    private int gZD = 0;
    private BannerListData gZE;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fHe.setCurScore(rVar.getCurScore());
            this.fHe.setLevelupScore(rVar.getLevelupScore());
            this.fHe.setLike(rVar.isLike());
            this.fHe.setUser_level(rVar.btq());
            this.fHe.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fHe.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fHe == null) {
            return null;
        }
        return this.fHe.getSignData();
    }

    public void bvK() {
        bg top_notice_data;
        com.baidu.adp.widget.ListView.i iVar;
        if (bas() != null && this.threadList != null && (top_notice_data = bas().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (iVar = this.threadList.get(0)) != null && (iVar instanceof bd) && ((bd) iVar).zi() == 2) {
                this.threadList.remove(0);
            }
            bd bdVar = new bd();
            bdVar.setTitle(top_notice_data.getTitle());
            bdVar.cV(top_notice_data.AH());
            bdVar.eR(2);
            bdVar.zW();
            this.threadList.add(0, bdVar);
        }
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.threadList != null) {
            int azt = azt();
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.i iVar = threadList.get(i);
                    if ((iVar instanceof bd) && aiVar.getId().equals(((bd) iVar).getId())) {
                        return;
                    }
                }
            }
            if (aiVar.isPhotoLiveThread()) {
                ar arVar = new ar();
                arVar.a(aiVar, -1);
                arVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.gZD++;
                    this.threadList.add(azt, arVar);
                    return;
                }
                return;
            }
            this.gZD++;
            this.threadList.add(azt, aiVar);
        }
    }

    public void bvL() {
        this.gZD = 0;
    }

    public int azt() {
        int i = 0;
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (!(next instanceof bd)) {
                    i = i2;
                } else if (((bd) next).zi() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    private int yW() {
        Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.i next = it.next();
            if ((next instanceof bd) && ((bd) next).zk() == 1) {
                return ((bd) next).yW();
            }
        }
        return -1;
    }

    public void bvM() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bd.aOy || this.threadList.get(i2).getType() == bd.aOz || this.threadList.get(i2).getType() == bd.aOA) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bvN() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.eSW != null && this.eSW.yu() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
                if ((iVar instanceof bd) && iVar.getType() == bd.aPI) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int azt = azt();
            if (i > azt) {
                this.threadList.add(azt, this.threadList.remove(i));
            }
        }
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar) {
        a(bVar, false, this.threadList, null, false);
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        a(bVar, false, arrayList, null, false);
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar, boolean z, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, ArrayList<com.baidu.adp.widget.ListView.i> arrayList2, boolean z2) {
        BannerListData bannerListData;
        if (!this.cay) {
            if (this.fHe != null) {
                bannerListData = this.fHe.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gZE;
        }
        this.cay = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar2.Y(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.cP(z);
            bVar3.X(arrayList);
            bVar3.Z(arrayList2);
            bVar3.cQ(z2);
            bVar3.eW(yA().yu());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    public void bvO() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i);
            if (iVar instanceof bd) {
                bd bdVar = (bd) iVar;
                if (bdVar.isPhotoLiveThread() && !(bdVar instanceof ar)) {
                    ar arVar = new ar();
                    arVar.B(bvd());
                    arVar.a(bdVar, 0);
                    if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, arVar);
                    }
                }
            }
        }
    }

    public void bvP() {
        int i;
        if (bas() != null) {
            List<PhotoLiveCardData> bvd = bvd();
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
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
                int vG = vG(i);
                ar arVar = new ar();
                a(arVar, bvd);
                getThreadList().add(vG, arVar);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.i
    public List<RecmForumInfo> buQ() {
        return this.recm_forum_list;
    }

    private void a(ar arVar, List<PhotoLiveCardData> list) {
        if (arVar != null && !com.baidu.tbadk.core.util.v.E(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            arVar.setThreadType(33);
            arVar.a(metaData);
            arVar.cZ(photoLiveCardData.getForumName());
            arVar.setTitle(photoLiveCardData.getTitle());
            arVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            arVar.cV(photoLiveCardData.getThreadId() + "");
            arVar.v(photoLiveCardData.getLastModifiedTime());
            arVar.eP(photoLiveCardData.getDiscussNum());
        }
    }

    private int vG(int i) {
        int azt = azt();
        int bvi = bvi();
        if (bvg()) {
            bvi++;
        }
        return Math.min((bvi + azt) - 1, i);
    }

    public void bvQ() {
        f bvF;
        if (this.threadList != null && bas() != null && MessageManager.getInstance().findTask(2911003) != null && (bvF = bvF()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.v.E(bvF.gXO)) {
                threadList.add(cE(1, threadList.size()), bvF);
            }
        }
    }

    public void bvR() {
        a(f.class, getThreadList());
    }

    public void bvS() {
        e bvE;
        if (this.threadList != null && bas() != null && MessageManager.getInstance().findTask(2911003) != null && (bvE = bvE()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(cE(bvE.gXM, threadList.size()), bvE);
        }
    }

    public void bvT() {
        a(e.class, getThreadList());
    }

    private int cE(int i, int i2) {
        int azt = azt();
        if (bvg()) {
            i++;
        }
        return Math.min((azt + i) - 1, i2);
    }

    private void a(Class cls, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                com.baidu.adp.widget.ListView.i iVar = arrayList.get(i);
                if (iVar.getClass() != cls) {
                    i++;
                } else {
                    arrayList2.add(iVar);
                    break;
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.removeAll(arrayList2);
            }
        }
    }

    public void bvU() {
        bd bvm;
        int i;
        if (bas() != null && (bvm = bvm()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + bvm.getTid());
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
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
                threadList.add(vG(i), bvm);
            }
        }
    }

    public void bvV() {
        if (bas() != null) {
            List<com.baidu.adp.widget.ListView.i> bvx = bvx();
            List<Integer> bvw = bvw();
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (bvw != null && bvw.size() > 0 && bvx != null && bvx.size() > 0 && threadList != null) {
                int size = bvw.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bvx.size()) {
                        com.baidu.adp.widget.ListView.i iVar = bvx.get(i);
                        int cF = cF(bvw.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + cF + "  Title:" + iVar.getType());
                        threadList.add(cF, iVar);
                    }
                }
            }
        }
    }

    private int cF(int i, int i2) {
        int azt = azt();
        if (bvg()) {
            i++;
        }
        return Math.min((azt + i) - 1, i2);
    }

    public void bvW() {
        if (bvg()) {
            int azt = azt();
            if (yW() == 0) {
                azt++;
            }
            as asVar = new as();
            asVar.a(bvh());
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(azt, asVar);
            }
        }
    }

    public bd sE(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.i next = it.next();
            if (next != null && (next instanceof bd) && TextUtils.equals(str, ((bd) next).getId())) {
                return (bd) next;
            }
        }
        return null;
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (this.threadList != null && hVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.i next = it.next();
                    if (next != null && (next instanceof bd) && ((bd) next).zn() != null && currentAccount.equals(((bd) next).zn().getUserId()) && ((bd) next).zn().getPendantData() != null) {
                        ((bd) next).zn().getPendantData().ab(hVar.KE());
                        ((bd) next).zn().getPendantData().cX(hVar.ya());
                    }
                }
            }
        }
    }

    public void aj(bd bdVar) {
        this.threadList.remove(bdVar);
    }

    public boolean e(i iVar) {
        if (iVar == null) {
            return false;
        }
        c(iVar.yn());
        a(iVar.bva());
        mD(iVar.buW());
        sA(iVar.buX());
        c(iVar.bas());
        setGameName(iVar.getGameName());
        sB(iVar.bve());
        a(iVar.buY());
        mE(iVar.bvb());
        sz(iVar.baH());
        dr(iVar.bvd());
        vC(iVar.bvi());
        b(iVar.bvh());
        a(iVar.yA());
        a(iVar.buU());
        dp(iVar.bvc());
        au(iVar.getThreadList());
        m18do(iVar.buZ());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.buV());
        dq(iVar.bvf());
        vD(iVar.bvn());
        dt(iVar.bvk());
        sD(iVar.bvl());
        ai(iVar.bvm());
        a(iVar.bvo());
        vE(iVar.bvr());
        a(iVar.bvs());
        a(iVar.bvt());
        vz(iVar.buR());
        a(iVar.bvu());
        vA(iVar.buS());
        vB(iVar.buT());
        this.gYp = iVar.gYp;
        this.gYM = iVar.gYM;
        this.gYP = iVar.gYP;
        a(iVar.bvp());
        j(iVar.bvv());
        a(iVar.bvq());
        du(iVar.bvw());
        dv(iVar.bvx());
        this.gZc = iVar.gZc;
        a(iVar.bvy());
        a(iVar.buO());
        a(iVar.bvz());
        dw(iVar.bvA());
        vF(iVar.bvB());
        a(iVar.buP());
        a(iVar.bvC());
        a(iVar.bvD());
        this.gZl = iVar.gZl;
        b(iVar.bvE());
        this.recm_forum_list = iVar.buQ();
        b(iVar.bvF());
        this.dJz = iVar.dJz;
        this.gZn = iVar.gZn;
        return true;
    }

    public void bvX() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fHe != null && this.fHe.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
                if (iVar instanceof bd) {
                    bd bdVar = (bd) iVar;
                    if (bdVar == null || (!bdVar.zO() && bdVar.zk() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.fHe.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar = new h();
                hVar.setForumId(this.fHe.getId());
                hVar.dn(feedForumList);
                this.threadList.add(i + 6, hVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mF(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.E(this.threadList)) {
            bvY();
            if (bvy() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
                    if (iVar instanceof bd) {
                        bd bdVar = (bd) iVar;
                        if (bdVar == null || (!bdVar.zO() && bdVar.zk() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bvy().aBf() + i) - 1 < this.threadList.size()) {
                    String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("game_rank_list_info", "");
                    if (StringUtils.isNull(string) || string.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length != 2) {
                        z2 = true;
                    } else {
                        z2 = UtilHelper.getDayBetweenTime(com.baidu.adp.lib.g.b.c(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0], 0L), System.currentTimeMillis()) >= ((long) com.baidu.adp.lib.g.b.h(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1], 0));
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
                                this.threadList.add((bvy().aBf() + i) - 1, bvy());
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

    public void bvY() {
        if (!com.baidu.tbadk.core.util.v.E(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.eam) {
                    it.remove();
                }
            }
        }
    }

    public boolean bvZ() {
        com.baidu.tieba.card.data.o recomTopicData;
        if (this.threadList == null || this.fHe == null || this.fHe.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
            if (iVar instanceof bd) {
                bd bdVar = (bd) iVar;
                if (bdVar == null || (!bdVar.zO() && bdVar.zk() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fHe.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.D(recomTopicData.daG) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ak("c10835").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bwa() {
        if (MessageManager.getInstance().findTask(2003016) != null) {
            int bvr = (bvr() + azt()) - 1;
            if (bvs() != null && bvr >= 0 && bvr <= this.threadList.size()) {
                this.threadList.add(bvr, bvs());
            }
        }
    }

    public void bwb() {
        int Al;
        if (bvC() != null) {
            com.baidu.tieba.frs.s bvC = bvC();
            if (com.baidu.tbadk.core.util.v.D(bvC.getUserInfo()) >= 3 && (Al = bvC.Al()) > 0) {
                int azt = Al + azt();
                if (azt > this.threadList.size()) {
                    this.threadList.add(bvC);
                } else {
                    this.threadList.add(azt, bvC);
                }
            }
        }
    }

    public void bwc() {
        if (!com.baidu.tbadk.core.util.v.E(this.threadList)) {
            boolean z = false;
            Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
            while (true) {
                boolean z2 = z;
                if (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.s) {
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

    public void bwd() {
        if (bvD() != null && !com.baidu.tbadk.core.util.v.E(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next != null && next.getType() == k.gZC) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, bvD());
        }
    }

    public List<com.baidu.adp.widget.ListView.i> bwe() {
        return this.gYV;
    }

    public void dx(List<com.baidu.adp.widget.ListView.i> list) {
        this.gYV = list;
    }

    public boolean bwf() {
        if (buU() == null) {
            return false;
        }
        return buU().bvG() == 1;
    }

    public boolean bwg() {
        return bvt() == null ? !com.baidu.tbadk.core.util.v.E(bvf()) : !com.baidu.tbadk.core.util.v.E(bvt().tab);
    }

    public void a(BannerListData bannerListData) {
        this.cay = true;
        this.gZE = bannerListData;
    }
}
