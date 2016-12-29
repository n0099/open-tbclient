package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class o extends m implements com.baidu.tbadk.mvc.b.l {
    private int feU = 0;

    public void c(x xVar) {
        if (xVar != null) {
            this.dWw.setCurScore(xVar.getCurScore());
            this.dWw.setLevelupScore(xVar.getLevelupScore());
            this.dWw.setLike(xVar.isLike());
            this.dWw.setUser_level(xVar.getUserLevel());
            this.dWw.setLevelName(xVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.dWw.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.dWw == null) {
            return null;
        }
        return this.dWw.getSignData();
    }

    public void beM() {
        bk top_notice_data;
        com.baidu.adp.widget.ListView.v vVar;
        if (aIk() != null && this.threadList != null && (top_notice_data = aIk().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (vVar = this.threadList.get(0)) != null && (vVar instanceof bg) && ((bg) vVar).rA() == 2) {
                this.threadList.remove(0);
            }
            bg bgVar = new bg();
            bgVar.setTitle(top_notice_data.getTitle());
            bgVar.cw(top_notice_data.sN());
            bgVar.bW(2);
            bgVar.sl();
            this.threadList.add(0, bgVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ak akVar) {
        if (akVar != null && !StringUtils.isNull(akVar.getId()) && this.threadList != null) {
            int aaQ = aaQ();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = threadList.get(i);
                    if ((vVar instanceof bg) && akVar.getId().equals(((bg) vVar).getId())) {
                        return;
                    }
                }
            }
            if (akVar.isPhotoLiveThread()) {
                at atVar = new at();
                atVar.a(akVar, -1);
                atVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.feU++;
                    this.threadList.add(aaQ, atVar);
                    return;
                }
                return;
            }
            this.feU++;
            this.threadList.add(aaQ, akVar);
        }
    }

    public void beN() {
        this.feU = 0;
    }

    public int aaQ() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof bg) {
                if (((bg) next).rA() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int rp() {
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if ((next instanceof bg) && ((bg) next).rC() == 1) {
                return ((bg) next).rp();
            }
        }
        return -1;
    }

    public void beO() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dcN != null && this.dcN.qC() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if ((vVar instanceof bg) && vVar.getType() == bg.Uu) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int aaQ = aaQ();
            if (i > aaQ) {
                this.threadList.add(aaQ, this.threadList.remove(i));
            }
        }
    }

    public void bp(Context context) {
        BannerListData bannerListData;
        int g;
        if (this.dWw != null && (bannerListData = this.dWw.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && this.threadList != null && this.threadList.size() > 0) {
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
                if ((next instanceof bg) && ((bg) next).rA() != 0) {
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
                            if (!com.baidu.tieba.recapp.l.isInstalledPackage(context, cVar.Pp) && !TextUtils.isEmpty(cVar.Pp) && !TextUtils.isEmpty(cVar.Pk)) {
                                boolean fi = com.baidu.tbadk.download.b.Cq().fi(cVar.Pp);
                                boolean fk = com.baidu.tbadk.download.b.Cq().fk(cVar.Pp);
                                if (fi) {
                                    cVar.Pi = 1;
                                } else if (fk) {
                                    cVar.Pi = 2;
                                } else {
                                    cVar.Pi = 0;
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

    public void a(Context context, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, ArrayList<com.baidu.adp.widget.ListView.v> arrayList2, boolean z) {
        BannerListData bannerListData;
        int g;
        if (this.dWw != null && (bannerListData = this.dWw.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    if (!(arrayList.get(i) instanceof com.baidu.tbadk.core.data.c)) {
                        i++;
                    } else {
                        arrayList.remove(i);
                        break;
                    }
                } else {
                    break;
                }
            }
            int size2 = arrayList.size();
            Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if ((next instanceof bg) && ((bg) next).rA() != 0) {
                    i2++;
                }
            }
            int size3 = bannerListData.getAllAdvertList().size();
            if (size3 >= 1) {
                int i3 = 9;
                if (bannerListData.getAllAdvertList().size() > 1 && (com.baidu.adp.lib.h.b.g(bannerListData.getAllAdvertList().get(1).adPosition, 0) - com.baidu.adp.lib.h.b.g(bannerListData.getAllAdvertList().get(0).adPosition, 0)) - 1 > 0) {
                    i3 = g;
                }
                int g2 = com.baidu.adp.lib.h.b.g(bannerListData.getAllAdvertList().get(0).adPosition, 0) - 1;
                int i4 = size2 - i2;
                HashSet hashSet = new HashSet();
                for (int i5 = 0; i5 < size3; i5++) {
                    com.baidu.tbadk.core.data.c cVar = bannerListData.getAllAdvertList().get(i5);
                    if (cVar != null && cVar.pj()) {
                        int g3 = com.baidu.adp.lib.h.b.g(cVar.adPosition, 0);
                        int i6 = (g3 + i2) - 1;
                        boolean z2 = false;
                        if (i6 >= 0 && !hashSet.contains(Integer.valueOf(i6)) && i6 <= size2) {
                            if (g3 > (i4 - i3) + g2) {
                                if (z && !com.baidu.tbadk.core.util.x.t(arrayList2)) {
                                    int size4 = arrayList2.size();
                                    int i7 = (i3 - ((i4 - g3) + 1)) - 1;
                                    int i8 = 0;
                                    z2 = true;
                                    while (true) {
                                        if (i8 >= size4 || i8 >= i7) {
                                            break;
                                        } else if (arrayList2.get(i8) instanceof com.baidu.tbadk.core.data.c) {
                                            z2 = false;
                                            break;
                                        } else {
                                            i8++;
                                        }
                                    }
                                }
                            } else {
                                z2 = true;
                            }
                        }
                        if (!z2) {
                            com.baidu.tieba.recapp.report.b.aYs().a(com.baidu.tieba.recapp.report.e.a(cVar, 41, getPage().qC()));
                        } else if (cVar.pk()) {
                            if (!com.baidu.tieba.recapp.l.isInstalledPackage(context, cVar.Pp) && !TextUtils.isEmpty(cVar.Pp) && !TextUtils.isEmpty(cVar.Pk)) {
                                boolean fi = com.baidu.tbadk.download.b.Cq().fi(cVar.Pp);
                                boolean fk = com.baidu.tbadk.download.b.Cq().fk(cVar.Pp);
                                if (fi) {
                                    cVar.Pi = 1;
                                } else if (fk) {
                                    cVar.Pi = 2;
                                } else {
                                    cVar.Pi = 0;
                                }
                                hashSet.add(Integer.valueOf(i6));
                                if (i6 < size2) {
                                    arrayList.add(i6, cVar);
                                } else if (i6 == size2) {
                                    arrayList.add(cVar);
                                }
                            }
                        } else if (cVar.pl()) {
                            hashSet.add(Integer.valueOf(i6));
                            if (i6 < size2) {
                                arrayList.add(i6, cVar);
                            } else if (i6 == size2) {
                                arrayList.add(cVar);
                            }
                        }
                    }
                }
            }
        }
    }

    public void beP() {
        boolean z = true;
        if (this.dWw != null && this.threadList != null && bg.Tr.get() && this.dcN != null && this.dcN.qC() == 1) {
            if (this.fdU == null || !this.fdU.bff()) {
                z = false;
            }
            if (this.fdS || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof z)) {
                    this.threadList.remove(0);
                }
                z zVar = new z();
                zVar.kT(this.fdS);
                zVar.qf(this.fdT);
                zVar.b(this.fdU);
                zVar.bW(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    com.baidu.tbadk.core.util.x.a(this.threadList, aaQ(), zVar);
                }
            }
        }
    }

    public void beQ() {
        if (this.dWw != null) {
            if (((this.dWw.getTopCode() != null && !StringUtils.isNull(this.dWw.getTopCode().sH())) || (this.dWw.getNewsInfo() != null && !StringUtils.isNull(this.dWw.getNewsInfo().sH()))) && this.dcN != null && this.dcN.qC() == 1) {
                aj ajVar = new aj();
                ajVar.a(this.dWw.getTopCode());
                ajVar.a(this.dWw.getNewsInfo());
                ajVar.bW(3);
                ajVar.kU(true);
                if (!com.baidu.tbadk.core.util.x.t(this.threadList)) {
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof bg) && ((bg) next).rA() != 0) {
                            if (((bg) next).rA() == 1003) {
                                ajVar.kU(false);
                            }
                            i++;
                        }
                    }
                    this.threadList.add(i, ajVar);
                }
            }
        }
    }

    public void beR() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i);
            if (vVar instanceof bg) {
                bg bgVar = (bg) vVar;
                if (bgVar.isPhotoLiveThread() && !(bgVar instanceof at)) {
                    at atVar = new at();
                    atVar.p(beh());
                    atVar.a(bgVar, 0);
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, atVar);
                    }
                }
            }
        }
    }

    public void beS() {
        int i;
        if (aIk() != null) {
            List<PhotoLiveCardData> beh = beh();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (beh != null && beh.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof at)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int rd = rd(i);
                at atVar = new at();
                a(atVar, beh);
                getThreadList().add(rd, atVar);
            }
        }
    }

    private void a(at atVar, List<PhotoLiveCardData> list) {
        if (atVar != null && !com.baidu.tbadk.core.util.x.t(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            atVar.setThreadType(33);
            atVar.setAuthor(metaData);
            atVar.cx(photoLiveCardData.getForumName());
            atVar.setTitle(photoLiveCardData.getTitle());
            atVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            atVar.cw(new StringBuilder(String.valueOf(photoLiveCardData.getThreadId())).toString());
            atVar.o(photoLiveCardData.getLastModifiedTime());
            atVar.bV(photoLiveCardData.getDiscussNum());
        }
    }

    private int rd(int i) {
        int aaQ = aaQ();
        int beo = beo();
        if (bek()) {
            beo++;
        }
        return Math.min((beo + aaQ) - 1, i);
    }

    public void beT() {
        bg bes;
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        int i;
        if (aIk() != null && (bes = bes()) != null && (threadList = getThreadList()) != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = size;
                    break;
                } else if (!(threadList.get(i2) instanceof at)) {
                    i2++;
                } else {
                    threadList.remove(i2);
                    i = size - 1;
                    break;
                }
            }
            threadList.add(rd(i), bes);
        }
    }

    public void beU() {
        if (aIk() != null) {
            List<com.baidu.adp.widget.ListView.v> beE = beE();
            List<Integer> beD = beD();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (beD != null && beD.size() > 0 && beE != null && beE.size() > 0 && threadList != null) {
                int size = beD.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < beE.size()) {
                        threadList.add(bj(beD.get(i).intValue(), size2), beE.get(i));
                    }
                }
            }
        }
    }

    private int bj(int i, int i2) {
        int aaQ = aaQ();
        if (bek()) {
            i++;
        }
        return Math.min((aaQ + i) - 1, i2);
    }

    public void beV() {
        if (bek()) {
            int aaQ = aaQ();
            if (rp() == 0) {
                aaQ++;
            }
            au auVar = new au();
            auVar.a(bel());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(aaQ, auVar);
            }
        }
    }

    public void beW() {
        com.baidu.tbadk.core.data.z bem;
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.tW().getLong("frs_storecard_closetime", 0L) >= 86400000 && (bem = bem()) != null) {
            int aaQ = aaQ();
            int rp = rp();
            if (rp == 0 || rp == 1) {
                aaQ++;
            }
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(aaQ, bem);
            }
        }
    }

    public bg pX(String str) {
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

    public void a(com.baidu.tbadk.data.k kVar) {
        if (this.threadList != null && kVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.v next = it.next();
                    if (next != null && (next instanceof bg) && ((bg) next).getAuthor() != null && currentAccount.equals(((bg) next).getAuthor().getUserId()) && ((bg) next).getAuthor().getPendantData() != null) {
                        ((bg) next).getAuthor().getPendantData().O(kVar.Cb());
                        ((bg) next).getAuthor().getPendantData().cs(kVar.pS());
                    }
                }
            }
        }
    }

    public void C(bg bgVar) {
        this.threadList.remove(bgVar);
    }

    public boolean d(m mVar) {
        if (mVar == null) {
            return false;
        }
        d(mVar.qt());
        a(mVar.bee());
        kQ(mVar.bea());
        pT(mVar.beb());
        c(mVar.aIk());
        setGameName(mVar.getGameName());
        pU(mVar.bei());
        a(mVar.bec());
        kR(mVar.bef());
        lE(mVar.aIv());
        cV(mVar.beh());
        ra(mVar.beo());
        c(mVar.bel());
        a(mVar.getPage());
        a(mVar.bdY());
        cT(mVar.beg());
        at(mVar.getThreadList());
        cS(mVar.bed());
        h(mVar.getUserData());
        setUserMap(mVar.getUserMap());
        b(mVar.bdZ());
        cU(mVar.bej());
        rb(mVar.bet());
        cX(mVar.beq());
        pW(mVar.ber());
        a(mVar.bem());
        B(mVar.bes());
        b(mVar.beu());
        rc(mVar.bex());
        a(mVar.bey());
        a(mVar.bez());
        a(mVar.beA());
        cY(mVar.beB());
        qY(mVar.bdW());
        qZ(mVar.bdX());
        this.fdP = mVar.fdP;
        this.fep = mVar.fep;
        this.fes = mVar.fes;
        a(mVar.bev());
        g(mVar.beC());
        a(mVar.bew());
        a(mVar.ben());
        cZ(mVar.beD());
        da(mVar.beE());
        kS(mVar.isShowDriftingBottle());
        cF(mVar.beF());
        this.feF = mVar.feF;
        return true;
    }

    public void beX() {
        if (this.threadList != null || this.threadList.size() <= 0) {
            int size = this.threadList.size();
            for (int i = 0; i < size; i++) {
                if (this.threadList.get(i) instanceof com.baidu.tbadk.core.data.z) {
                    this.threadList.remove(i);
                    return;
                }
            }
        }
    }

    public void beY() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.dWw != null && this.dWw.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if (vVar instanceof bg) {
                    bg bgVar = (bg) vVar;
                    if (bgVar == null || (!bgVar.se() && bgVar.rC() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.dWw.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar = new h();
                hVar.setForumId(this.dWw.getId());
                hVar.cR(feedForumList);
                this.threadList.add(i + 6, hVar);
            }
        }
    }

    public boolean beZ() {
        com.baidu.tieba.card.data.q recomTopicData;
        if (this.threadList == null || this.dWw == null || this.dWw.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
            if (vVar instanceof bg) {
                bg bgVar = (bg) vVar;
                if (bgVar == null || (!bgVar.se() && bgVar.rC() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.dWw.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.x.s(recomTopicData.beS) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10835").ab(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bfa() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bex = (bex() + aaQ()) - 1;
            if (bey() != null && bex >= 0 && bex <= this.threadList.size()) {
                this.threadList.add(bex, bey());
            }
        }
    }

    public void bfb() {
        int intValue;
        if (ben() != null && (ben().position.intValue() + aaQ()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, ben());
        }
    }

    public List<com.baidu.adp.widget.ListView.v> bfc() {
        return this.fey;
    }

    public void db(List<com.baidu.adp.widget.ListView.v> list) {
        this.fey = list;
    }

    public boolean bfd() {
        return bdY() != null && bdY().beG() == 1;
    }

    public boolean bfe() {
        return bez() == null ? !com.baidu.tbadk.core.util.x.t(bej()) : !com.baidu.tbadk.core.util.x.t(bez().tab);
    }
}
