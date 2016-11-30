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
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.DataRes;
/* loaded from: classes.dex */
public class p extends n implements com.baidu.tbadk.mvc.b.l {
    private int fAP = 0;

    public void c(y yVar) {
        if (yVar != null) {
            this.erU.setCurScore(yVar.getCurScore());
            this.erU.setLevelupScore(yVar.getLevelupScore());
            this.erU.setLike(yVar.isLike());
            this.erU.setUser_level(yVar.getUserLevel());
            this.erU.setLevelName(yVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.erU.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.erU == null) {
            return null;
        }
        return this.erU.getSignData();
    }

    public void bkV() {
        bp top_notice_data;
        com.baidu.adp.widget.ListView.v vVar;
        if (aOk() != null && this.threadList != null && (top_notice_data = aOk().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (vVar = this.threadList.get(0)) != null && (vVar instanceof bk) && ((bk) vVar).rL() == 2) {
                this.threadList.remove(0);
            }
            bk bkVar = new bk();
            bkVar.setTitle(top_notice_data.getTitle());
            bkVar.cw(top_notice_data.tc());
            bkVar.bV(2);
            bkVar.sw();
            this.threadList.add(0, bkVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.al alVar) {
        if (alVar != null && !StringUtils.isNull(alVar.getId()) && this.threadList != null) {
            int agu = agu();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = threadList.get(i);
                    if ((vVar instanceof bk) && alVar.getId().equals(((bk) vVar).getId())) {
                        return;
                    }
                }
            }
            if (alVar.isPhotoLiveThread()) {
                au auVar = new au();
                auVar.a(alVar, -1);
                auVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.fAP++;
                    this.threadList.add(agu, auVar);
                    return;
                }
                return;
            }
            this.fAP++;
            this.threadList.add(agu, alVar);
        }
    }

    public void bkW() {
        this.fAP = 0;
    }

    public int bkX() {
        return this.fAP;
    }

    public int agu() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof bk) {
                if (((bk) next).rL() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int rB() {
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if ((next instanceof bk) && ((bk) next).rN() == 1) {
                return ((bk) next).rB();
            }
        }
        return -1;
    }

    public void bkY() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dzM != null && this.dzM.qB() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if ((vVar instanceof bk) && vVar.getType() == bk.UW) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int agu = agu();
            if (i > agu) {
                this.threadList.add(agu, this.threadList.remove(i));
            }
        }
    }

    public void bq(Context context) {
        BannerListData bannerListData;
        int g;
        if (this.erU != null && (bannerListData = this.erU.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    if (!(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.c)) {
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
                if ((next instanceof bk) && ((bk) next).rL() != 0) {
                    i2++;
                }
            }
            int size3 = bannerListData.getAllAdvertList().size();
            if (size3 >= 1) {
                int i3 = size2 - i2;
                HashSet hashSet = new HashSet();
                for (int i4 = 0; i4 < size3; i4++) {
                    com.baidu.tbadk.core.data.c cVar = bannerListData.getAllAdvertList().get(i4);
                    if (cVar != null && cVar.pj() && (com.baidu.adp.lib.h.b.g(cVar.adPosition, 0) + i2) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && (g < size2 || i3 <= 3)) {
                        if (cVar.pk()) {
                            if (!com.baidu.tieba.recapp.g.isInstalledPackage(context, cVar.Ps) && !TextUtils.isEmpty(cVar.Ps) && !TextUtils.isEmpty(cVar.Pn)) {
                                boolean fm = com.baidu.tbadk.download.b.CD().fm(cVar.Ps);
                                boolean fo = com.baidu.tbadk.download.b.CD().fo(cVar.Ps);
                                if (fm) {
                                    cVar.Pl = 1;
                                } else if (fo) {
                                    cVar.Pl = 2;
                                } else {
                                    cVar.Pl = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                if (g < size2) {
                                    this.threadList.add(g, cVar);
                                } else if (g == size2) {
                                    this.threadList.add(cVar);
                                }
                            }
                        } else if (cVar.pl()) {
                            hashSet.add(Integer.valueOf(g));
                            if (g < size2) {
                                this.threadList.add(g, cVar);
                            } else if (g == size2) {
                                this.threadList.add(cVar);
                            }
                        }
                    }
                }
            }
        }
    }

    public void bkZ() {
        boolean z = true;
        if (this.erU != null && this.threadList != null && bk.TS.get() && this.dzM != null && this.dzM.qB() == 1) {
            if (this.fzS == null || !this.fzS.blq()) {
                z = false;
            }
            if (this.fzQ || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof aa)) {
                    this.threadList.remove(0);
                }
                aa aaVar = new aa();
                aaVar.lj(this.fzQ);
                aaVar.rB(this.fzR);
                aaVar.b(this.fzS);
                aaVar.bV(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    com.baidu.tbadk.core.util.x.a(this.threadList, agu(), aaVar);
                }
            }
        }
    }

    public void bla() {
        if (this.erU != null) {
            if (((this.erU.getTopCode() != null && !StringUtils.isNull(this.erU.getTopCode().getSummary())) || (this.erU.getNewsInfo() != null && !StringUtils.isNull(this.erU.getNewsInfo().getSummary()))) && this.dzM != null && this.dzM.qB() == 1) {
                ak akVar = new ak();
                akVar.a(this.erU.getTopCode());
                akVar.a(this.erU.getNewsInfo());
                akVar.bV(3);
                akVar.lk(true);
                if (!com.baidu.tbadk.core.util.x.t(this.threadList)) {
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof bk) && ((bk) next).rL() != 0) {
                            if (((bk) next).rL() == 1003) {
                                akVar.lk(false);
                            }
                            i++;
                        }
                    }
                    this.threadList.add(i, akVar);
                }
            }
        }
    }

    public void blb() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i);
            if (vVar instanceof bk) {
                bk bkVar = (bk) vVar;
                if (bkVar.isPhotoLiveThread() && !(bkVar instanceof au)) {
                    au auVar = new au();
                    auVar.p(bkr());
                    auVar.a(bkVar, 0);
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, auVar);
                    }
                }
            }
        }
    }

    public void blc() {
        int i;
        if (aOk() != null) {
            List<PhotoLiveCardData> bkr = bkr();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bkr != null && bkr.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof au)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int sa = sa(i);
                au auVar = new au();
                a(auVar, bkr);
                getThreadList().add(sa, auVar);
            }
        }
    }

    private void a(au auVar, List<PhotoLiveCardData> list) {
        if (auVar != null && !com.baidu.tbadk.core.util.x.t(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            auVar.setThreadType(33);
            auVar.setAuthor(metaData);
            auVar.setForum_name(photoLiveCardData.getForumName());
            auVar.setTitle(photoLiveCardData.getTitle());
            auVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            auVar.cw(new StringBuilder(String.valueOf(photoLiveCardData.getThreadId())).toString());
            auVar.o(photoLiveCardData.getLastModifiedTime());
            auVar.bU(photoLiveCardData.getDiscussNum());
        }
    }

    private int sa(int i) {
        int agu = agu();
        int bky = bky();
        if (bku()) {
            bky++;
        }
        return Math.min((bky + agu) - 1, i);
    }

    public void bld() {
        bk bkC;
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        int i;
        if (aOk() != null && (bkC = bkC()) != null && (threadList = getThreadList()) != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = size;
                    break;
                } else if (!(threadList.get(i2) instanceof au)) {
                    i2++;
                } else {
                    threadList.remove(i2);
                    i = size - 1;
                    break;
                }
            }
            threadList.add(sa(i), bkC);
        }
    }

    public void ble() {
        if (aOk() != null) {
            List<com.baidu.adp.widget.ListView.v> bkO = bkO();
            List<Integer> bkN = bkN();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bkN != null && bkN.size() > 0 && bkO != null && bkO.size() > 0 && threadList != null) {
                int size = bkN.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i <= bkO.size()) {
                        threadList.add(bu(bkN.get(i).intValue(), size2), bkO.get(i));
                    }
                }
            }
        }
    }

    private int bu(int i, int i2) {
        int agu = agu();
        if (bku()) {
            i++;
        }
        return Math.min((agu + i) - 1, i2);
    }

    public void blf() {
        if (bku()) {
            int agu = agu();
            if (rB() == 0) {
                agu++;
            }
            av avVar = new av();
            avVar.a(bkv());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(agu, avVar);
            }
        }
    }

    public void blg() {
        com.baidu.tbadk.core.data.aa bkw;
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.um().getLong("frs_storecard_closetime", 0L) >= 86400000 && (bkw = bkw()) != null) {
            int agu = agu();
            int rB = rB();
            if (rB == 0 || rB == 1) {
                agu++;
            }
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(agu, bkw);
            }
        }
    }

    public void blh() {
        az recommendLikeUser;
        int g;
        int i;
        if (this.erU != null && (recommendLikeUser = this.erU.getRecommendLikeUser()) != null && recommendLikeUser.qR() != null && !TextUtils.isEmpty(recommendLikeUser.qR().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if ((next instanceof bk) && ((bk) next).rL() != 0) {
                    i2++;
                }
            }
            String qQ = recommendLikeUser.qQ();
            if (!TextUtils.isEmpty(qQ) && !TextUtils.isEmpty(qQ.trim()) && (g = com.baidu.adp.lib.h.b.g(qQ, -1)) != -1 && (g + i2) - 1 < size && i >= 0 && !(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.c)) {
                if (i - 1 < 0 || !(this.threadList.get(i - 1) instanceof com.baidu.tbadk.core.data.c)) {
                    this.threadList.add(i, recommendLikeUser);
                }
            }
        }
    }

    public bk rt(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next != null && (next instanceof bk) && TextUtils.equals(str, ((bk) next).getId())) {
                return (bk) next;
            }
        }
        return null;
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        if (this.threadList != null && kVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.v next = it.next();
                    if (next != null && (next instanceof bk) && ((bk) next).getAuthor() != null && currentAccount.equals(((bk) next).getAuthor().getUserId()) && ((bk) next).getAuthor().getPendantData() != null) {
                        ((bk) next).getAuthor().getPendantData().P(kVar.Co());
                        ((bk) next).getAuthor().getPendantData().cs(kVar.pR());
                    }
                }
            }
        }
    }

    public void x(bk bkVar) {
        this.threadList.remove(bkVar);
    }

    public boolean d(n nVar) {
        if (nVar == null) {
            return false;
        }
        d(nVar.qs());
        a(nVar.bko());
        lh(nVar.bkk());
        rp(nVar.bkl());
        c(nVar.aOk());
        setGameName(nVar.getGameName());
        rq(nVar.bks());
        a(nVar.bkm());
        li(nVar.bkp());
        mH(nVar.aOu());
        df(nVar.bkr());
        rX(nVar.bky());
        c(nVar.bkv());
        a(nVar.getPage());
        a(nVar.bki());
        dd(nVar.bkq());
        aD(nVar.getThreadList());
        dc(nVar.bkn());
        j(nVar.getUserData());
        setUserMap(nVar.getUserMap());
        b(nVar.bkj());
        de(nVar.bkt());
        rY(nVar.bkD());
        dh(nVar.bkA());
        rs(nVar.bkB());
        a(nVar.bkw());
        w(nVar.bkC());
        b(nVar.bkE());
        rZ(nVar.bkH());
        a(nVar.bkI());
        a(nVar.bkJ());
        a(nVar.bkK());
        di(nVar.bkL());
        rV(nVar.bkg());
        rW(nVar.bkh());
        this.fzN = nVar.fzN;
        this.fAm = nVar.fAm;
        this.fAp = nVar.fAp;
        a(nVar.bkF());
        h(nVar.bkM());
        a(nVar.bkG());
        a(nVar.bkx());
        dj(nVar.bkN());
        dk(nVar.bkO());
        return true;
    }

    public void bli() {
        if (this.threadList != null || this.threadList.size() <= 0) {
            int size = this.threadList.size();
            for (int i = 0; i < size; i++) {
                if (this.threadList.get(i) instanceof com.baidu.tbadk.core.data.aa) {
                    this.threadList.remove(i);
                    return;
                }
            }
        }
    }

    public void blj() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.erU != null && this.erU.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if (vVar instanceof bk) {
                    bk bkVar = (bk) vVar;
                    if (bkVar == null || (!bkVar.sp() && bkVar.rN() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.erU.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                i iVar = new i();
                iVar.setForumId(this.erU.getId());
                iVar.db(feedForumList);
                this.threadList.add(i + 6, iVar);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public void a(DataRes dataRes) {
        super.a(dataRes);
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public ForumData aOk() {
        return super.aOk();
    }

    public boolean blk() {
        com.baidu.tieba.card.data.q recomTopicData;
        if (this.threadList == null || this.erU == null || this.erU.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
            if (vVar instanceof bk) {
                bk bkVar = (bk) vVar;
                if (bkVar == null || (!bkVar.sp() && bkVar.rN() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.erU.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.x.s(recomTopicData.bfD) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10835").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bll() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bkH = (bkH() + agu()) - 1;
            if (bkI() != null && bkH >= 0 && bkH <= this.threadList.size()) {
                this.threadList.add(bkH, bkI());
            }
        }
    }

    public void blm() {
        int intValue;
        if (bkx() != null && (bkx().position.intValue() + agu()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bkx());
        }
    }

    public List<com.baidu.adp.widget.ListView.v> bln() {
        return this.fAv;
    }

    public void dl(List<com.baidu.adp.widget.ListView.v> list) {
        this.fAv = list;
    }

    public boolean blo() {
        return bki() != null && bki().bkP() == 1;
    }

    public boolean blp() {
        return bkJ() == null ? !com.baidu.tbadk.core.util.x.t(bkt()) : !com.baidu.tbadk.core.util.x.t(bkJ().tab);
    }
}
