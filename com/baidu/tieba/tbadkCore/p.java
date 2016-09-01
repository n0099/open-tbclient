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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bg;
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
    private int fqU = 0;

    public void c(y yVar) {
        if (yVar != null) {
            this.ejZ.setCurScore(yVar.getCurScore());
            this.ejZ.setLevelupScore(yVar.getLevelupScore());
            this.ejZ.setLike(yVar.isLike());
            this.ejZ.setUser_level(yVar.getUserLevel());
            this.ejZ.setLevelName(yVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.ejZ.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.ejZ == null) {
            return null;
        }
        return this.ejZ.getSignData();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(bg bgVar) {
        if (this.threadList != null) {
            while (!this.threadList.isEmpty() && this.threadList.get(0) != null && (this.threadList.get(0) instanceof bg) && ((bg) this.threadList.get(0)).rx() == 2) {
                this.threadList.remove(0);
            }
        }
        this.threadList.add(0, bgVar);
    }

    public void a(com.baidu.tbadk.core.data.ah ahVar) {
        if (ahVar != null && !StringUtils.isNull(ahVar.getId()) && this.threadList != null) {
            int aeO = aeO();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = threadList.get(i);
                    if ((vVar instanceof bg) && ahVar.getId().equals(((bg) vVar).getId())) {
                        return;
                    }
                }
            }
            if (ahVar.isPhotoLiveThread()) {
                aq aqVar = new aq();
                aqVar.a(ahVar, -1);
                aqVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.fqU++;
                    this.threadList.add(aeO, aqVar);
                    return;
                }
                return;
            }
            this.fqU++;
            this.threadList.add(aeO, ahVar);
        }
    }

    public void bhO() {
        this.fqU = 0;
    }

    public int bhP() {
        return this.fqU;
    }

    public int aeO() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof bg) {
                if (((bg) next).rx() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int rn() {
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if ((next instanceof bg) && ((bg) next).rz() == 1) {
                return ((bg) next).rn();
            }
        }
        return -1;
    }

    public void bhQ() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dsK != null && this.dsK.qo() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if ((vVar instanceof bg) && vVar.getType() == bg.Uo) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int aeO = aeO();
            if (i > aeO) {
                this.threadList.add(aeO, this.threadList.remove(i));
            }
        }
    }

    public void bf(Context context) {
        BannerListData bannerListData;
        int g;
        if (this.ejZ != null && (bannerListData = this.ejZ.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && this.threadList != null && this.threadList.size() > 0) {
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
                if ((next instanceof bg) && ((bg) next).rx() != 0) {
                    i2++;
                }
            }
            int size3 = bannerListData.getAllAdvertList().size();
            if (size3 >= 1) {
                int i3 = size2 - i2;
                HashSet hashSet = new HashSet();
                for (int i4 = 0; i4 < size3; i4++) {
                    com.baidu.tbadk.core.data.b bVar = bannerListData.getAllAdvertList().get(i4);
                    if (bVar != null && bVar.pg() && (com.baidu.adp.lib.h.b.g(bVar.Pf, 0) + i2) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && (g < size2 || i3 <= 3)) {
                        if (bVar.ph()) {
                            if (!com.baidu.tieba.recapp.f.isInstalledPackage(context, bVar.Pe) && !TextUtils.isEmpty(bVar.Pe) && !TextUtils.isEmpty(bVar.OZ)) {
                                boolean fh = com.baidu.tbadk.download.b.Cv().fh(bVar.Pe);
                                boolean fj = com.baidu.tbadk.download.b.Cv().fj(bVar.Pe);
                                if (fh) {
                                    bVar.OX = 1;
                                } else if (fj) {
                                    bVar.OX = 2;
                                } else {
                                    bVar.OX = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                if (g < size2) {
                                    this.threadList.add(g, bVar);
                                } else if (g == size2) {
                                    this.threadList.add(bVar);
                                }
                            }
                        } else if (bVar.pi()) {
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

    public void bhR() {
        boolean z = true;
        int i = 0;
        if (this.ejZ != null && bg.To.get() && this.dsK != null && this.dsK.qo() == 1) {
            if (this.fqc == null || !this.fqc.bif()) {
                z = false;
            }
            if (this.fqa || z || (getUserData() != null && getUserData().isBawu())) {
                aa aaVar = new aa();
                aaVar.kI(this.fqa);
                aaVar.qS(this.fqb);
                aaVar.b(this.fqc);
                aaVar.bV(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof bg) && ((bg) next).rx() != 0) {
                            i++;
                        }
                    }
                    this.threadList.add(i, aaVar);
                }
            }
        }
    }

    public void bhS() {
        if (this.ejZ != null) {
            if (((this.ejZ.getTopCode() != null && !StringUtils.isNull(this.ejZ.getTopCode().getSummary())) || (this.ejZ.getNewsInfo() != null && !StringUtils.isNull(this.ejZ.getNewsInfo().getSummary()))) && this.dsK != null && this.dsK.qo() == 1) {
                al alVar = new al();
                alVar.a(this.ejZ.getTopCode());
                alVar.a(this.ejZ.getNewsInfo());
                alVar.bV(3);
                alVar.kJ(true);
                if (!com.baidu.tbadk.core.util.y.t(this.threadList)) {
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof bg) && ((bg) next).rx() != 0) {
                            if (((bg) next).rx() == 1003) {
                                alVar.kJ(false);
                            }
                            i++;
                        }
                    }
                    this.threadList.add(i, alVar);
                }
            }
        }
    }

    public void bhT() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i);
            if (vVar instanceof bg) {
                bg bgVar = (bg) vVar;
                if (bgVar.isPhotoLiveThread() && !(bgVar instanceof aq)) {
                    aq aqVar = new aq();
                    aqVar.p(bho());
                    aqVar.a(bgVar, 0);
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, aqVar);
                    }
                }
            }
        }
    }

    public void bhU() {
        int i;
        if (aLP() != null) {
            List<PhotoLiveCardData> bho = bho();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bho != null && bho.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof aq)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int rt = rt(i);
                aq aqVar = new aq();
                a(aqVar, bho);
                getThreadList().add(rt, aqVar);
            }
        }
    }

    private void a(aq aqVar, List<PhotoLiveCardData> list) {
        if (aqVar != null && !com.baidu.tbadk.core.util.y.t(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            aqVar.setThreadType(33);
            aqVar.setAuthor(metaData);
            aqVar.setForum_name(photoLiveCardData.getForumName());
            aqVar.setTitle(photoLiveCardData.getTitle());
            aqVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            aqVar.cs(new StringBuilder(String.valueOf(photoLiveCardData.getThreadId())).toString());
            aqVar.p(photoLiveCardData.getLastModifiedTime());
            aqVar.bU(photoLiveCardData.getDiscussNum());
        }
    }

    private int rt(int i) {
        int aeO = aeO();
        int bhu = bhu();
        if (bhr()) {
            bhu++;
        }
        return Math.min((bhu + aeO) - 1, i);
    }

    public void bhV() {
        bg bhy;
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        int i;
        if (aLP() != null && (bhy = bhy()) != null && (threadList = getThreadList()) != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = size;
                    break;
                } else if (!(threadList.get(i2) instanceof aq)) {
                    i2++;
                } else {
                    threadList.remove(i2);
                    i = size - 1;
                    break;
                }
            }
            threadList.add(rt(i), bhy);
        }
    }

    public void bhW() {
        if (bhr()) {
            int aeO = aeO();
            if (rn() == 0) {
                aeO++;
            }
            ar arVar = new ar();
            arVar.a(bhs());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(aeO, arVar);
            }
        }
    }

    public void bhX() {
        com.baidu.tbadk.core.data.w bht;
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.tS().getLong("frs_storecard_closetime", 0L) >= 86400000 && (bht = bht()) != null) {
            int aeO = aeO();
            int rn = rn();
            if (rn == 0 || rn == 1) {
                aeO++;
            }
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(aeO, bht);
            }
        }
    }

    public void bhY() {
        av recommendLikeUser;
        int g;
        int i;
        if (this.ejZ != null && (recommendLikeUser = this.ejZ.getRecommendLikeUser()) != null && recommendLikeUser.qE() != null && !TextUtils.isEmpty(recommendLikeUser.qE().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if ((next instanceof bg) && ((bg) next).rx() != 0) {
                    i2++;
                }
            }
            String qD = recommendLikeUser.qD();
            if (!TextUtils.isEmpty(qD) && !TextUtils.isEmpty(qD.trim()) && (g = com.baidu.adp.lib.h.b.g(qD, -1)) != -1 && (g + i2) - 1 < size && i >= 0 && !(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.b)) {
                if (i - 1 < 0 || !(this.threadList.get(i - 1) instanceof com.baidu.tbadk.core.data.b)) {
                    this.threadList.add(i, recommendLikeUser);
                }
            }
        }
    }

    public bg qL(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next != null && (next instanceof bg) && TextUtils.equals(str, ((bg) next).getId())) {
                return (bg) next;
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
                    if (next != null && (next instanceof bg) && ((bg) next).getAuthor() != null && currentAccount.equals(((bg) next).getAuthor().getUserId()) && ((bg) next).getAuthor().getPendantData() != null) {
                        ((bg) next).getAuthor().getPendantData().P(jVar.Cd());
                        ((bg) next).getAuthor().getPendantData().cq(jVar.rc());
                    }
                }
            }
        }
    }

    public void w(bg bgVar) {
        this.threadList.remove(bgVar);
    }

    public boolean d(n nVar) {
        if (nVar == null) {
            return false;
        }
        d(nVar.qf());
        a(nVar.bhl());
        kG(nVar.bhh());
        qH(nVar.bhi());
        c(nVar.aLP());
        setGameName(nVar.getGameName());
        qI(nVar.bhp());
        a(nVar.bhj());
        kH(nVar.bhm());
        mr(nVar.aLY());
        da(nVar.bho());
        rq(nVar.bhu());
        c(nVar.bhs());
        a(nVar.getPage());
        a(nVar.bhf());
        cY(nVar.bhn());
        aA(nVar.getThreadList());
        cX(nVar.bhk());
        j(nVar.getUserData());
        setUserMap(nVar.getUserMap());
        b(nVar.bhg());
        cZ(nVar.bhq());
        rr(nVar.bhz());
        dc(nVar.bhw());
        qK(nVar.bhx());
        a(nVar.bht());
        u(nVar.bhy());
        b(nVar.bhA());
        rs(nVar.bhC());
        a(nVar.bhD());
        a(nVar.bhE());
        a(nVar.bhF());
        dd(nVar.bhG());
        ro(nVar.bhd());
        rp(nVar.bhe());
        this.fpX = nVar.fpX;
        this.fqv = nVar.fqv;
        a(nVar.bhB());
        h(nVar.bhH());
        return true;
    }

    public void bhZ() {
        if (this.threadList != null || this.threadList.size() <= 0) {
            int size = this.threadList.size();
            for (int i = 0; i < size; i++) {
                if (this.threadList.get(i) instanceof com.baidu.tbadk.core.data.w) {
                    this.threadList.remove(i);
                    return;
                }
            }
        }
    }

    public void bia() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.ejZ != null && this.ejZ.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if (vVar instanceof bg) {
                    bg bgVar = (bg) vVar;
                    if (bgVar == null || (!bgVar.sb() && bgVar.rz() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.ejZ.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                i iVar = new i();
                iVar.setForumId(this.ejZ.getId());
                iVar.cW(feedForumList);
                this.threadList.add(i + 6, iVar);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public void a(DataRes dataRes) {
        super.a(dataRes);
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public ForumData aLP() {
        return super.aLP();
    }

    public boolean bib() {
        com.baidu.tieba.card.data.q recomTopicData;
        if (this.threadList == null || this.ejZ == null || this.ejZ.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
            if (vVar instanceof bg) {
                bg bgVar = (bg) vVar;
                if (bgVar == null || (!bgVar.sb() && bgVar.rz() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.ejZ.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.y.s(recomTopicData.bck) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ay("c10835").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bic() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bhC = (bhC() + aeO()) - 1;
            if (bhD() != null && bhC >= 0 && bhC <= this.threadList.size()) {
                this.threadList.add(bhC, bhD());
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.v> bid() {
        return this.fqC;
    }

    public void de(List<com.baidu.adp.widget.ListView.v> list) {
        this.fqC = list;
    }

    public boolean bie() {
        return bhE() == null ? !com.baidu.tbadk.core.util.y.t(bhq()) : !com.baidu.tbadk.core.util.y.t(bhE().tab);
    }
}
