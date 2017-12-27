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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bh;
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
public class l extends i implements com.baidu.tbadk.mvc.b.l {
    private boolean bYb;
    private int hhp = 0;
    private BannerListData hhq;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fBM.setCurScore(rVar.getCurScore());
            this.fBM.setLevelupScore(rVar.getLevelupScore());
            this.fBM.setLike(rVar.isLike());
            this.fBM.setUser_level(rVar.getUserLevel());
            this.fBM.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fBM.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fBM == null) {
            return null;
        }
        return this.fBM.getSignData();
    }

    public void bAX() {
        bh top_notice_data;
        com.baidu.adp.widget.ListView.i iVar;
        if (aYy() != null && this.threadList != null && (top_notice_data = aYy().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (iVar = this.threadList.get(0)) != null && (iVar instanceof be) && ((be) iVar).yS() == 2) {
                this.threadList.remove(0);
            }
            be beVar = new be();
            beVar.setTitle(top_notice_data.getTitle());
            beVar.cK(top_notice_data.Av());
            beVar.eS(2);
            beVar.zF();
            this.threadList.add(0, beVar);
        }
    }

    public void a(aj ajVar) {
        if (ajVar != null && !StringUtils.isNull(ajVar.getId()) && this.threadList != null) {
            int axj = axj();
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.i iVar = threadList.get(i);
                    if ((iVar instanceof be) && ajVar.getId().equals(((be) iVar).getId())) {
                        return;
                    }
                }
            }
            if (ajVar.isPhotoLiveThread()) {
                as asVar = new as();
                asVar.a(ajVar, -1);
                asVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.hhp++;
                    this.threadList.add(axj, asVar);
                    return;
                }
                return;
            }
            this.hhp++;
            this.threadList.add(axj, ajVar);
        }
    }

    public void bAY() {
        this.hhp = 0;
    }

    public int axj() {
        int i = 0;
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (!(next instanceof be)) {
                    i = i2;
                } else if (((be) next).yS() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    private int yE() {
        Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.i next = it.next();
            if ((next instanceof be) && ((be) next).yU() == 1) {
                return ((be) next).yE();
            }
        }
        return -1;
    }

    public void bAZ() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == be.aNg || this.threadList.get(i2).getType() == be.aNh || this.threadList.get(i2).getType() == be.aNi) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bBa() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.eMO != null && this.eMO.xV() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
                if ((iVar instanceof be) && iVar.getType() == be.aOq) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int axj = axj();
            if (i > axj) {
                this.threadList.add(axj, this.threadList.remove(i));
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
        if (!this.bYb) {
            if (this.fBM != null) {
                bannerListData = this.fBM.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.hhq;
        }
        this.bYb = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar2.Y(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.cM(z);
            bVar3.X(arrayList);
            bVar3.Z(arrayList2);
            bVar3.cN(z2);
            bVar3.eY(yb().xV());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void bBb() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i);
            if (iVar instanceof be) {
                be beVar = (be) iVar;
                if (beVar.isPhotoLiveThread() && !(beVar instanceof as)) {
                    as asVar = new as();
                    asVar.C(bAq());
                    asVar.a(beVar, 0);
                    if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, asVar);
                    }
                }
            }
        }
    }

    public void bBc() {
        int i;
        if (aYy() != null) {
            List<PhotoLiveCardData> bAq = bAq();
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (bAq != null && bAq.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof as)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int xe = xe(i);
                as asVar = new as();
                a(asVar, bAq);
                getThreadList().add(xe, asVar);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.i
    public List<RecmForumInfo> bAd() {
        return this.recm_forum_list;
    }

    private void a(as asVar, List<PhotoLiveCardData> list) {
        if (asVar != null && !com.baidu.tbadk.core.util.v.G(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            asVar.setThreadType(33);
            asVar.a(metaData);
            asVar.cO(photoLiveCardData.getForumName());
            asVar.setTitle(photoLiveCardData.getTitle());
            asVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            asVar.cK(photoLiveCardData.getThreadId() + "");
            asVar.v(photoLiveCardData.getLastModifiedTime());
            asVar.eQ(photoLiveCardData.getDiscussNum());
        }
    }

    private int xe(int i) {
        int axj = axj();
        int bAv = bAv();
        if (bAt()) {
            bAv++;
        }
        return Math.min((bAv + axj) - 1, i);
    }

    public void bBd() {
        f bAS;
        if (this.threadList != null && aYy() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null && (bAS = bAS()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.v.G(bAS.hfB)) {
                threadList.add(cQ(1, threadList.size()), bAS);
            }
        }
    }

    public void bBe() {
        a(f.class, getThreadList());
    }

    public void bBf() {
        e bAR;
        if (this.threadList != null && aYy() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null && (bAR = bAR()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(cQ(bAR.hfz, threadList.size()), bAR);
        }
    }

    public void bBg() {
        a(e.class, getThreadList());
    }

    private int cQ(int i, int i2) {
        int axj = axj();
        if (bAt()) {
            i++;
        }
        return Math.min((axj + i) - 1, i2);
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

    public void bBh() {
        be bAz;
        int i;
        if (aYy() != null && (bAz = bAz()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + bAz.getTid());
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof as)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                threadList.add(xe(i), bAz);
            }
        }
    }

    public void bBi() {
        if (aYy() != null) {
            List<com.baidu.adp.widget.ListView.i> bAK = bAK();
            List<Integer> bAJ = bAJ();
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (bAJ != null && bAJ.size() > 0 && bAK != null && bAK.size() > 0 && threadList != null) {
                int size = bAJ.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bAK.size()) {
                        com.baidu.adp.widget.ListView.i iVar = bAK.get(i);
                        int cR = cR(bAJ.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + cR + "  Title:" + iVar.getType());
                        threadList.add(cR, iVar);
                    }
                }
            }
        }
    }

    private int cR(int i, int i2) {
        int axj = axj();
        if (bAt()) {
            i++;
        }
        return Math.min((axj + i) - 1, i2);
    }

    public void bBj() {
        if (bAt()) {
            int axj = axj();
            if (yE() == 0) {
                axj++;
            }
            at atVar = new at();
            atVar.a(bAu());
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(axj, atVar);
            }
        }
    }

    public be sV(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.i next = it.next();
            if (next != null && (next instanceof be) && TextUtils.equals(str, ((be) next).getId())) {
                return (be) next;
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
                    if (next != null && (next instanceof be) && ((be) next).yX() != null && currentAccount.equals(((be) next).yX().getUserId()) && ((be) next).yX().getPendantData() != null) {
                        ((be) next).yX().getPendantData().ab(hVar.Kh());
                        ((be) next).yX().getPendantData().cM(hVar.xu());
                    }
                }
            }
        }
    }

    public void ag(be beVar) {
        this.threadList.remove(beVar);
    }

    public boolean e(i iVar) {
        if (iVar == null) {
            return false;
        }
        c(iVar.xJ());
        a(iVar.bAn());
        nr(iVar.bAj());
        sR(iVar.bAk());
        c(iVar.aYy());
        setGameName(iVar.getGameName());
        sS(iVar.bAr());
        a(iVar.bAl());
        ns(iVar.bAo());
        sD(iVar.aYO());
        dC(iVar.bAq());
        xa(iVar.bAv());
        c(iVar.bAu());
        a(iVar.yb());
        a(iVar.bAh());
        dA(iVar.bAp());
        az(iVar.getThreadList());
        dz(iVar.bAm());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.bAi());
        dB(iVar.bAs());
        xb(iVar.bAA());
        dE(iVar.bAx());
        sU(iVar.bAy());
        af(iVar.bAz());
        a(iVar.bAB());
        xc(iVar.bAE());
        a(iVar.bAF());
        a(iVar.bAG());
        wX(iVar.bAe());
        a(iVar.bAH());
        wY(iVar.bAf());
        wZ(iVar.bAg());
        this.hgc = iVar.hgc;
        this.hgz = iVar.hgz;
        this.hgC = iVar.hgC;
        a(iVar.bAC());
        j(iVar.bAI());
        a(iVar.bAD());
        dF(iVar.bAJ());
        dG(iVar.bAK());
        this.hgP = iVar.hgP;
        a(iVar.bAL());
        a(iVar.bAb());
        a(iVar.bAM());
        dH(iVar.bAN());
        xd(iVar.bAO());
        a(iVar.bAc());
        a(iVar.bAP());
        a(iVar.bAQ());
        this.hgY = iVar.hgY;
        b(iVar.bAR());
        this.recm_forum_list = iVar.bAd();
        b(iVar.bAS());
        return true;
    }

    public void bBk() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fBM != null && this.fBM.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
                if (iVar instanceof be) {
                    be beVar = (be) iVar;
                    if (beVar == null || (!beVar.zy() && beVar.yU() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.fBM.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar = new h();
                hVar.setForumId(this.fBM.getId());
                hVar.dy(feedForumList);
                this.threadList.add(i + 6, hVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void nt(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.G(this.threadList)) {
            bBl();
            if (bAL() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
                    if (iVar instanceof be) {
                        be beVar = (be) iVar;
                        if (beVar == null || (!beVar.zy() && beVar.yU() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bAL().azE() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((bAL().azE() + i) - 1, bAL());
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

    public void bBl() {
        if (!com.baidu.tbadk.core.util.v.G(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.dUw) {
                    it.remove();
                }
            }
        }
    }

    public boolean bBm() {
        com.baidu.tieba.card.data.p recomTopicData;
        if (this.threadList == null || this.fBM == null || this.fBM.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
            if (iVar instanceof be) {
                be beVar = (be) iVar;
                if (beVar == null || (!beVar.zy() && beVar.yU() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fBM.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.F(recomTopicData.cSU) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ak("c10835").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bBn() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bAE = (bAE() + axj()) - 1;
            if (bAF() != null && bAE >= 0 && bAE <= this.threadList.size()) {
                this.threadList.add(bAE, bAF());
            }
        }
    }

    public void bBo() {
        int zZ;
        if (bAP() != null) {
            com.baidu.tieba.frs.s bAP = bAP();
            if (com.baidu.tbadk.core.util.v.F(bAP.getUserInfo()) >= 3 && (zZ = bAP.zZ()) > 0) {
                int axj = zZ + axj();
                if (axj > this.threadList.size()) {
                    this.threadList.add(bAP);
                } else {
                    this.threadList.add(axj, bAP);
                }
            }
        }
    }

    public void bBp() {
        if (bAQ() != null && !com.baidu.tbadk.core.util.v.G(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next != null && next.getType() == k.hho) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, bAQ());
        }
    }

    public List<com.baidu.adp.widget.ListView.i> bBq() {
        return this.hgI;
    }

    public void dI(List<com.baidu.adp.widget.ListView.i> list) {
        this.hgI = list;
    }

    public boolean bBr() {
        if (bAh() == null) {
            return false;
        }
        return bAh().bAT() == 1;
    }

    public boolean bBs() {
        return bAG() == null ? !com.baidu.tbadk.core.util.v.G(bAs()) : !com.baidu.tbadk.core.util.v.G(bAG().tab);
    }

    public void a(BannerListData bannerListData) {
        this.bYb = true;
        this.hhq = bannerListData;
    }
}
