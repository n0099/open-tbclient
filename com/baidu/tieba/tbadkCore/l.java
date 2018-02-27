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
    private boolean cam;
    private int gZo = 0;
    private BannerListData gZp;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fGT.setCurScore(rVar.getCurScore());
            this.fGT.setLevelupScore(rVar.getLevelupScore());
            this.fGT.setLike(rVar.isLike());
            this.fGT.setUser_level(rVar.btp());
            this.fGT.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fGT.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fGT == null) {
            return null;
        }
        return this.fGT.getSignData();
    }

    public void bvJ() {
        bg top_notice_data;
        com.baidu.adp.widget.ListView.i iVar;
        if (bar() != null && this.threadList != null && (top_notice_data = bar().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
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
            int azs = azs();
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
                    this.gZo++;
                    this.threadList.add(azs, arVar);
                    return;
                }
                return;
            }
            this.gZo++;
            this.threadList.add(azs, aiVar);
        }
    }

    public void bvK() {
        this.gZo = 0;
    }

    public int azs() {
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

    public void bvL() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bd.aOn || this.threadList.get(i2).getType() == bd.aOo || this.threadList.get(i2).getType() == bd.aOp) {
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
        if (this.threadList != null && this.threadList.size() > 0 && this.eSK != null && this.eSK.yu() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
                if ((iVar instanceof bd) && iVar.getType() == bd.aPx) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int azs = azs();
            if (i > azs) {
                this.threadList.add(azs, this.threadList.remove(i));
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
        if (!this.cam) {
            if (this.fGT != null) {
                bannerListData = this.fGT.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gZp;
        }
        this.cam = false;
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

    public void bvN() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i);
            if (iVar instanceof bd) {
                bd bdVar = (bd) iVar;
                if (bdVar.isPhotoLiveThread() && !(bdVar instanceof ar)) {
                    ar arVar = new ar();
                    arVar.B(bvc());
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
        if (bar() != null) {
            List<PhotoLiveCardData> bvc = bvc();
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (bvc != null && bvc.size() > 0 && threadList != null && threadList.size() > 0) {
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
                int vH = vH(i);
                ar arVar = new ar();
                a(arVar, bvc);
                getThreadList().add(vH, arVar);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.i
    public List<RecmForumInfo> buP() {
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

    private int vH(int i) {
        int azs = azs();
        int bvh = bvh();
        if (bvf()) {
            bvh++;
        }
        return Math.min((bvh + azs) - 1, i);
    }

    public void bvP() {
        f bvE;
        if (this.threadList != null && bar() != null && MessageManager.getInstance().findTask(2911003) != null && (bvE = bvE()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.v.E(bvE.gXz)) {
                threadList.add(cE(1, threadList.size()), bvE);
            }
        }
    }

    public void bvQ() {
        a(f.class, getThreadList());
    }

    public void bvR() {
        e bvD;
        if (this.threadList != null && bar() != null && MessageManager.getInstance().findTask(2911003) != null && (bvD = bvD()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(cE(bvD.gXx, threadList.size()), bvD);
        }
    }

    public void bvS() {
        a(e.class, getThreadList());
    }

    private int cE(int i, int i2) {
        int azs = azs();
        if (bvf()) {
            i++;
        }
        return Math.min((azs + i) - 1, i2);
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

    public void bvT() {
        bd bvl;
        int i;
        if (bar() != null && (bvl = bvl()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + bvl.getTid());
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
                threadList.add(vH(i), bvl);
            }
        }
    }

    public void bvU() {
        if (bar() != null) {
            List<com.baidu.adp.widget.ListView.i> bvw = bvw();
            List<Integer> bvv = bvv();
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (bvv != null && bvv.size() > 0 && bvw != null && bvw.size() > 0 && threadList != null) {
                int size = bvv.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bvw.size()) {
                        com.baidu.adp.widget.ListView.i iVar = bvw.get(i);
                        int cF = cF(bvv.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + cF + "  Title:" + iVar.getType());
                        threadList.add(cF, iVar);
                    }
                }
            }
        }
    }

    private int cF(int i, int i2) {
        int azs = azs();
        if (bvf()) {
            i++;
        }
        return Math.min((azs + i) - 1, i2);
    }

    public void bvV() {
        if (bvf()) {
            int azs = azs();
            if (yW() == 0) {
                azs++;
            }
            as asVar = new as();
            asVar.a(bvg());
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(azs, asVar);
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
                        ((bd) next).zn().getPendantData().ab(hVar.KD());
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
        a(iVar.buZ());
        mD(iVar.buV());
        sA(iVar.buW());
        c(iVar.bar());
        setGameName(iVar.getGameName());
        sB(iVar.bvd());
        a(iVar.buX());
        mE(iVar.bva());
        sA(iVar.baG());
        dr(iVar.bvc());
        vD(iVar.bvh());
        b(iVar.bvg());
        a(iVar.yA());
        a(iVar.buT());
        dp(iVar.bvb());
        au(iVar.getThreadList());
        m18do(iVar.buY());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.buU());
        dq(iVar.bve());
        vE(iVar.bvm());
        dt(iVar.bvj());
        sD(iVar.bvk());
        ai(iVar.bvl());
        a(iVar.bvn());
        vF(iVar.bvq());
        a(iVar.bvr());
        a(iVar.bvs());
        vA(iVar.buQ());
        a(iVar.bvt());
        vB(iVar.buR());
        vC(iVar.buS());
        this.gYa = iVar.gYa;
        this.gYx = iVar.gYx;
        this.gYA = iVar.gYA;
        a(iVar.bvo());
        j(iVar.bvu());
        a(iVar.bvp());
        du(iVar.bvv());
        dv(iVar.bvw());
        this.gYN = iVar.gYN;
        a(iVar.bvx());
        a(iVar.buN());
        a(iVar.bvy());
        dw(iVar.bvz());
        vG(iVar.bvA());
        a(iVar.buO());
        a(iVar.bvB());
        a(iVar.bvC());
        this.gYW = iVar.gYW;
        b(iVar.bvD());
        this.recm_forum_list = iVar.buP();
        b(iVar.bvE());
        this.dJn = iVar.dJn;
        this.gYY = iVar.gYY;
        return true;
    }

    public void bvW() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fGT != null && this.fGT.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
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
            if (this.threadList.size() - i > 7 && (feedForumList = this.fGT.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar = new h();
                hVar.setForumId(this.fGT.getId());
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
            bvX();
            if (bvx() != null) {
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
                if ((bvx().aBe() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((bvx().aBe() + i) - 1, bvx());
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

    public void bvX() {
        if (!com.baidu.tbadk.core.util.v.E(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.eaa) {
                    it.remove();
                }
            }
        }
    }

    public boolean bvY() {
        com.baidu.tieba.card.data.o recomTopicData;
        if (this.threadList == null || this.fGT == null || this.fGT.getBannerListData() == null) {
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
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fGT.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.D(recomTopicData.das) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ak("c10835").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bvZ() {
        if (MessageManager.getInstance().findTask(2003016) != null) {
            int bvq = (bvq() + azs()) - 1;
            if (bvr() != null && bvq >= 0 && bvq <= this.threadList.size()) {
                this.threadList.add(bvq, bvr());
            }
        }
    }

    public void bwa() {
        int Al;
        if (bvB() != null) {
            com.baidu.tieba.frs.s bvB = bvB();
            if (com.baidu.tbadk.core.util.v.D(bvB.getUserInfo()) >= 3 && (Al = bvB.Al()) > 0) {
                int azs = Al + azs();
                if (azs > this.threadList.size()) {
                    this.threadList.add(bvB);
                } else {
                    this.threadList.add(azs, bvB);
                }
            }
        }
    }

    public void bwb() {
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

    public void bwc() {
        if (bvC() != null && !com.baidu.tbadk.core.util.v.E(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next != null && next.getType() == k.gZn) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, bvC());
        }
    }

    public List<com.baidu.adp.widget.ListView.i> bwd() {
        return this.gYG;
    }

    public void dx(List<com.baidu.adp.widget.ListView.i> list) {
        this.gYG = list;
    }

    public boolean bwe() {
        if (buT() == null) {
            return false;
        }
        return buT().bvF() == 1;
    }

    public boolean bwf() {
        return bvs() == null ? !com.baidu.tbadk.core.util.v.E(bve()) : !com.baidu.tbadk.core.util.v.E(bvs().tab);
    }

    public void a(BannerListData bannerListData) {
        this.cam = true;
        this.gZp = bannerListData;
    }
}
