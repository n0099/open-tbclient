package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.DataRes;
/* loaded from: classes.dex */
public class p extends n implements com.baidu.tbadk.mvc.b.l {
    private int fjc = 0;

    public void c(z zVar) {
        if (zVar != null) {
            this.dXV.setCurScore(zVar.getCurScore());
            this.dXV.setLevelupScore(zVar.getLevelupScore());
            this.dXV.setLike(zVar.isLike());
            this.dXV.setUser_level(zVar.getUserLevel());
            this.dXV.setLevelName(zVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.dXV.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.dXV == null) {
            return null;
        }
        return this.dXV.getSignData();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(be beVar) {
        if (this.threadList != null) {
            while (!this.threadList.isEmpty() && this.threadList.get(0) != null && (this.threadList.get(0) instanceof be) && ((be) this.threadList.get(0)).qt() == 2) {
                this.threadList.remove(0);
            }
        }
        this.threadList.add(0, beVar);
    }

    public void a(com.baidu.tbadk.core.data.ag agVar) {
        if (agVar != null && !StringUtils.isNull(agVar.getId()) && this.threadList != null) {
            int aad = aad();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = threadList.get(i);
                    if ((vVar instanceof be) && agVar.getId().equals(((be) vVar).getId())) {
                        return;
                    }
                }
            }
            if (agVar.isPhotoLiveThread()) {
                ao aoVar = new ao();
                aoVar.a(agVar, -1);
                aoVar.setPost_num(1);
                if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.fjc++;
                    this.threadList.add(aad, aoVar);
                    return;
                }
                return;
            }
            this.fjc++;
            this.threadList.add(aad, agVar);
        }
    }

    public void bei() {
        this.fjc = 0;
    }

    public int bej() {
        return this.fjc;
    }

    public int aad() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof be) {
                if (((be) next).qt() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int qj() {
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if ((next instanceof be) && ((be) next).qv() == 1) {
                return ((be) next).qj();
            }
        }
        return -1;
    }

    public void bek() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dhe != null && this.dhe.pl() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if ((vVar instanceof be) && vVar.getType() == be.RF) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int aad = aad();
            if (i > aad) {
                this.threadList.add(aad, this.threadList.remove(i));
            }
        }
    }

    public void aS(Context context) {
        BannerListData bannerListData;
        int g;
        if (this.dXV != null && (bannerListData = this.dXV.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    if (!(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.b)) {
                        i++;
                    } else {
                        this.threadList.remove(i);
                        break;
                    }
                } else {
                    break;
                }
            }
            int size2 = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if ((next instanceof be) && ((be) next).qt() != 0) {
                    i2++;
                }
            }
            int size3 = bannerListData.getAllAdvertList().size();
            if (size3 >= 1) {
                int i3 = size2 - i2;
                HashSet hashSet = new HashSet();
                for (int i4 = 0; i4 < size3; i4++) {
                    com.baidu.tbadk.core.data.b bVar = bannerListData.getAllAdvertList().get(i4);
                    if (bVar != null && bVar.ok() && (com.baidu.adp.lib.h.b.g(bVar.MM, 0) + i2) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && (g < size2 || i3 <= 3)) {
                        if (bVar.ol()) {
                            if (!al.isInstalledPackage(context, bVar.MK) && !TextUtils.isEmpty(bVar.MK) && !TextUtils.isEmpty(bVar.MF)) {
                                boolean fe = com.baidu.tbadk.download.b.Ba().fe(bVar.MK);
                                boolean fh = com.baidu.tbadk.download.b.Ba().fh(bVar.MK);
                                if (fe) {
                                    bVar.MD = 1;
                                } else if (fh) {
                                    bVar.MD = 2;
                                } else {
                                    bVar.MD = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                if (g < size2) {
                                    this.threadList.add(g, bVar);
                                } else if (g == size2) {
                                    this.threadList.add(bVar);
                                }
                            }
                        } else if (bVar.om()) {
                            hashSet.add(Integer.valueOf(g));
                            if (g < size2) {
                                this.threadList.add(g, bVar);
                            } else if (g == size2) {
                                this.threadList.add(bVar);
                            }
                        }
                    }
                }
            }
        }
    }

    public void bel() {
        boolean z = true;
        int i = 0;
        if (this.dXV != null && be.QF.get() && this.dhe != null && this.dhe.pl() == 1) {
            if (this.fil == null || !this.fil.bez()) {
                z = false;
            }
            if (this.fij || z || (getUserData() != null && getUserData().isBawu())) {
                ab abVar = new ab();
                abVar.kw(this.fij);
                abVar.qi(this.fik);
                abVar.b(this.fil);
                abVar.bI(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof be) && ((be) next).qt() != 0) {
                            i++;
                        }
                    }
                    this.threadList.add(i, abVar);
                }
            }
        }
    }

    public void bem() {
        if (this.dXV != null) {
            if (((this.dXV.getTopCode() != null && !StringUtils.isNull(this.dXV.getTopCode().getSummary())) || (this.dXV.getNewsInfo() != null && !StringUtils.isNull(this.dXV.getNewsInfo().getSummary()))) && this.dhe != null && this.dhe.pl() == 1) {
                am amVar = new am();
                amVar.a(this.dXV.getTopCode());
                amVar.a(this.dXV.getNewsInfo());
                amVar.bI(3);
                amVar.kx(true);
                if (!com.baidu.tbadk.core.util.y.t(this.threadList)) {
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof be) && ((be) next).qt() != 0) {
                            if (((be) next).qt() == 1003) {
                                amVar.kx(false);
                            }
                            i++;
                        }
                    }
                    this.threadList.add(i, amVar);
                }
            }
        }
    }

    public void ben() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i);
            if (vVar instanceof be) {
                be beVar = (be) vVar;
                if (beVar.isPhotoLiveThread() && !(beVar instanceof ao)) {
                    ao aoVar = new ao();
                    aoVar.p(bdK());
                    aoVar.a(beVar, 0);
                    if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, aoVar);
                    }
                }
            }
        }
    }

    public void beo() {
        int i;
        if (aGX() != null) {
            List<PhotoLiveCardData> bdK = bdK();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bdK != null && bdK.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof ao)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int qS = qS(i);
                ao aoVar = new ao();
                a(aoVar, bdK);
                getThreadList().add(qS, aoVar);
            }
        }
    }

    private void a(ao aoVar, List<PhotoLiveCardData> list) {
        if (aoVar != null && !com.baidu.tbadk.core.util.y.t(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            aoVar.setThreadType(33);
            aoVar.setAuthor(metaData);
            aoVar.setForum_name(photoLiveCardData.getForumName());
            aoVar.setTitle(photoLiveCardData.getTitle());
            aoVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            aoVar.cr(new StringBuilder(String.valueOf(photoLiveCardData.getThreadId())).toString());
            aoVar.p(photoLiveCardData.getLastModifiedTime());
            aoVar.bH(photoLiveCardData.getDiscussNum());
        }
    }

    private int qS(int i) {
        int aad = aad();
        int bdQ = bdQ();
        if (bdN()) {
            bdQ++;
        }
        return Math.min((bdQ + aad) - 1, i);
    }

    public void bep() {
        be bdU;
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        int i;
        if (aGX() != null && (bdU = bdU()) != null && (threadList = getThreadList()) != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = size;
                    break;
                } else if (!(threadList.get(i2) instanceof ao)) {
                    i2++;
                } else {
                    threadList.remove(i2);
                    i = size - 1;
                    break;
                }
            }
            threadList.add(qS(i), bdU);
        }
    }

    public void beq() {
        if (bdN()) {
            int aad = aad();
            if (qj() == 0) {
                aad++;
            }
            ap apVar = new ap();
            apVar.a(bdO());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(aad, apVar);
            }
        }
    }

    public void ber() {
        com.baidu.tbadk.core.data.v bdP;
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.sN().getLong("frs_storecard_closetime", 0L) >= 86400000 && (bdP = bdP()) != null) {
            int aad = aad();
            int qj = qj();
            if (qj == 0 || qj == 1) {
                aad++;
            }
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(aad, bdP);
            }
        }
    }

    public void bes() {
        at recommendLikeUser;
        int g;
        int i;
        if (this.dXV != null && (recommendLikeUser = this.dXV.getRecommendLikeUser()) != null && recommendLikeUser.pA() != null && !TextUtils.isEmpty(recommendLikeUser.pA().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if ((next instanceof be) && ((be) next).qt() != 0) {
                    i2++;
                }
            }
            String pz = recommendLikeUser.pz();
            if (!TextUtils.isEmpty(pz) && !TextUtils.isEmpty(pz.trim()) && (g = com.baidu.adp.lib.h.b.g(pz, -1)) != -1 && (g + i2) - 1 < size && i >= 0 && !(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.b)) {
                if (i - 1 < 0 || !(this.threadList.get(i - 1) instanceof com.baidu.tbadk.core.data.b)) {
                    this.threadList.add(i, recommendLikeUser);
                }
            }
        }
    }

    public be qb(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next != null && (next instanceof be) && TextUtils.equals(str, ((be) next).getId())) {
                return (be) next;
            }
        }
        return null;
    }

    public void w(be beVar) {
        this.threadList.remove(beVar);
    }

    public boolean d(n nVar) {
        if (nVar == null) {
            return false;
        }
        d(nVar.pc());
        a(nVar.bdH());
        ku(nVar.bdD());
        pX(nVar.bdE());
        c(nVar.aGX());
        setGameName(nVar.getGameName());
        pY(nVar.bdL());
        a(nVar.bdF());
        kv(nVar.bdI());
        lO(nVar.aHg());
        cW(nVar.bdK());
        qP(nVar.bdQ());
        c(nVar.bdO());
        a(nVar.getPage());
        a(nVar.bdB());
        cU(nVar.bdJ());
        aB(nVar.getThreadList());
        cT(nVar.bdG());
        f(nVar.getUserData());
        setUserMap(nVar.getUserMap());
        b(nVar.bdC());
        cV(nVar.bdM());
        qQ(nVar.bdV());
        cY(nVar.bdS());
        qa(nVar.bdT());
        a(nVar.bdP());
        u(nVar.bdU());
        b(nVar.bdW());
        qR(nVar.bdX());
        a(nVar.bdY());
        a(nVar.bdZ());
        a(nVar.bea());
        cZ(nVar.beb());
        qN(nVar.bdz());
        qO(nVar.bdA());
        this.fig = nVar.fig;
        this.fiF = nVar.fiF;
        return true;
    }

    public void bet() {
        if (this.threadList != null || this.threadList.size() <= 0) {
            int size = this.threadList.size();
            for (int i = 0; i < size; i++) {
                if (this.threadList.get(i) instanceof com.baidu.tbadk.core.data.v) {
                    this.threadList.remove(i);
                    return;
                }
            }
        }
    }

    public void beu() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.dXV != null && this.dXV.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if (vVar instanceof be) {
                    be beVar = (be) vVar;
                    if (beVar == null || (!beVar.qW() && beVar.qv() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.dXV.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                i iVar = new i();
                iVar.setForumId(this.dXV.getId());
                iVar.cS(feedForumList);
                this.threadList.add(i + 6, iVar);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public void a(DataRes dataRes) {
        super.a(dataRes);
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public ForumData aGX() {
        return super.aGX();
    }

    public boolean bev() {
        com.baidu.tieba.card.a.q recomTopicData;
        if (this.threadList == null || this.dXV == null || this.dXV.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
            if (vVar instanceof be) {
                be beVar = (be) vVar;
                if (beVar == null || (!beVar.qW() && beVar.qv() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.dXV.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.y.s(recomTopicData.aWI) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ay("c10835").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bew() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bdX = (bdX() + aad()) - 1;
            if (bdY() != null && bdX >= 0 && bdX <= this.threadList.size()) {
                this.threadList.add(bdX, bdY());
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.v> bex() {
        return this.fiK;
    }

    public void da(List<com.baidu.adp.widget.ListView.v> list) {
        this.fiK = list;
    }

    public boolean bey() {
        return bdZ() == null ? !com.baidu.tbadk.core.util.y.t(bdM()) : !com.baidu.tbadk.core.util.y.t(bdZ().tab);
    }
}
