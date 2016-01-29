package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class o extends m implements com.baidu.tbadk.mvc.b.l {
    private int dVq = 0;

    public void c(x xVar) {
        if (xVar != null) {
            this.cJt.setCurScore(xVar.getCurScore());
            this.cJt.setLevelupScore(xVar.getLevelupScore());
            this.cJt.setLike(xVar.isLike());
            this.cJt.setUser_level(xVar.getUserLevel());
            this.cJt.setLevelName(xVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.cJt.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.cJt == null) {
            return null;
        }
        return this.cJt.getSignData();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(com.baidu.tbadk.core.data.ah ahVar) {
        if (this.threadList != null) {
            while (!this.threadList.isEmpty() && this.threadList.get(0) != null && (this.threadList.get(0) instanceof com.baidu.tbadk.core.data.ah) && ((com.baidu.tbadk.core.data.ah) this.threadList.get(0)).getIs_top() == 2) {
                this.threadList.remove(0);
            }
        }
        this.threadList.add(0, ahVar);
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        if (sVar != null && !StringUtils.isNull(sVar.getId()) && this.threadList != null) {
            int RA = RA();
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.u uVar = threadList.get(i);
                    if ((uVar instanceof com.baidu.tbadk.core.data.ah) && sVar.getId().equals(((com.baidu.tbadk.core.data.ah) uVar).getId())) {
                        return;
                    }
                }
            }
            if (sVar.isPhotoLiveThread()) {
                com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
                abVar.a(sVar, -1).setPostNum(1);
                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.dVq++;
                    this.threadList.add(RA, abVar);
                    return;
                }
                return;
            }
            this.dVq++;
            this.threadList.add(RA, sVar);
        }
    }

    public void aLo() {
        this.dVq = 0;
    }

    public int aLp() {
        return this.dVq;
    }

    public int aLq() {
        int i = 0;
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = threadList.get(i2) instanceof com.baidu.tbadk.core.data.s ? i + 1 : i;
                i2++;
                i = i3;
            }
        }
        return i;
    }

    public int RA() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.u next = it.next();
            if (next instanceof com.baidu.tbadk.core.data.ah) {
                if (((com.baidu.tbadk.core.data.ah) next).getIs_top() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int tf() {
        Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.u next = it.next();
            if ((next instanceof com.baidu.tbadk.core.data.ah) && ((com.baidu.tbadk.core.data.ah) next).tl() == 1) {
                return ((com.baidu.tbadk.core.data.ah) next).tf();
            }
        }
        return -1;
    }

    public void aLr() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.cnk != null && this.cnk.st() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.u uVar = this.threadList.get(i2);
                if ((uVar instanceof com.baidu.tbadk.core.data.ah) && uVar.getType() == com.baidu.tbadk.core.data.ah.Xw) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int RA = RA();
            if (i > RA) {
                this.threadList.add(RA, this.threadList.remove(i));
            }
        }
    }

    public void aQ(Context context) {
        BannerListData bannerListData;
        int g;
        if (this.cJt != null && (bannerListData = this.cJt.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && this.threadList != null && this.threadList.size() > 0) {
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
            Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.u next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.ah) && ((com.baidu.tbadk.core.data.ah) next).getIs_top() != 0) {
                    i2++;
                }
            }
            int size3 = bannerListData.getAllAdvertList().size();
            if (size3 >= 1) {
                int i3 = size2 - i2;
                HashSet hashSet = new HashSet();
                for (int i4 = 0; i4 < size3; i4++) {
                    com.baidu.tbadk.core.data.c cVar = bannerListData.getAllAdvertList().get(i4);
                    if (cVar != null && cVar.rM() && (com.baidu.adp.lib.h.b.g(cVar.Uz, 0) + i2) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && (g < size2 || i3 <= 3)) {
                        if (cVar.rN()) {
                            if (!ag.isInstalledPackage(context, cVar.Uy) && !TextUtils.isEmpty(cVar.Uy) && !TextUtils.isEmpty(cVar.Uu)) {
                                boolean eW = com.baidu.tbadk.download.b.Cr().eW(cVar.Uy);
                                boolean eZ = com.baidu.tbadk.download.b.Cr().eZ(cVar.Uy);
                                if (eW) {
                                    cVar.Us = 1;
                                } else if (eZ) {
                                    cVar.Us = 2;
                                } else {
                                    cVar.Us = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                if (g < size2) {
                                    this.threadList.add(g, cVar);
                                } else if (g == size2) {
                                    this.threadList.add(cVar);
                                }
                            }
                        } else if (cVar.rO()) {
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

    public void W(Context context, String str) {
        com.baidu.tbadk.core.data.b adKillerData;
        com.baidu.tbadk.core.data.c rL;
        ArrayList<com.baidu.tbadk.core.data.c> allAdvertList;
        if (this.cJt != null) {
            BannerListData bannerListData = this.cJt.getBannerListData();
            if ((bannerListData == null || (allAdvertList = bannerListData.getAllAdvertList()) == null || allAdvertList.size() <= 0) && (adKillerData = this.cJt.getAdKillerData()) != null && adKillerData.rJ() != null) {
                List<b.a> rJ = adKillerData.rJ();
                if (rJ.size() != 0 && this.threadList != null && this.threadList.size() > 0) {
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
                    Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.u next = it.next();
                        if ((next instanceof com.baidu.tbadk.core.data.ah) && ((com.baidu.tbadk.core.data.ah) next).getIs_top() != 0) {
                            i2++;
                        }
                    }
                    int size3 = rJ.size();
                    if (size3 >= 1) {
                        int i3 = size2 - i2;
                        HashSet hashSet = new HashSet();
                        for (int i4 = 0; i4 < size3; i4++) {
                            b.a aVar = rJ.get(i4);
                            if (aVar != null && (rL = aVar.rL()) != null && rL.rM()) {
                                rL.UK = true;
                                rL.UN = aVar.rK() == 1;
                                rL.UL = aVar.getUrl();
                                rL.UM = aVar.getTag();
                                rL.setFid(com.baidu.adp.lib.h.b.c(str, 0L));
                                int g = (com.baidu.adp.lib.h.b.g(rL.Uz, 0) + i2) - 1;
                                if (g >= 0 && !hashSet.contains(Integer.valueOf(g)) && (g < size2 || i3 <= 3)) {
                                    if (rL.rN()) {
                                        if (!ag.isInstalledPackage(context, rL.Uy) && !TextUtils.isEmpty(rL.Uy) && !TextUtils.isEmpty(rL.Uu)) {
                                            boolean eW = com.baidu.tbadk.download.b.Cr().eW(rL.Uy);
                                            boolean eZ = com.baidu.tbadk.download.b.Cr().eZ(rL.Uy);
                                            if (eW) {
                                                rL.Us = 1;
                                            } else if (eZ) {
                                                rL.Us = 2;
                                            } else {
                                                rL.Us = 0;
                                            }
                                            hashSet.add(Integer.valueOf(g));
                                            if (g < size2) {
                                                this.threadList.add(g, rL);
                                            } else if (g == size2) {
                                                this.threadList.add(rL);
                                            }
                                        }
                                    } else if (rL.rO()) {
                                        hashSet.add(Integer.valueOf(g));
                                        if (g < size2) {
                                            this.threadList.add(g, rL);
                                        } else if (g == size2) {
                                            this.threadList.add(rL);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void aLs() {
        boolean z = true;
        int i = 0;
        if (this.cJt != null && this.cnk != null && this.cnk.st() == 1) {
            if (this.dUL == null || !this.dUL.aLB()) {
                z = false;
            }
            if (this.dUJ || z) {
                z zVar = new z();
                zVar.hT(this.dUJ);
                zVar.mG(this.dUK);
                zVar.b(this.dUL);
                zVar.bU(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.u next = it.next();
                        if ((next instanceof com.baidu.tbadk.core.data.ah) && ((com.baidu.tbadk.core.data.ah) next).getIs_top() != 0) {
                            i++;
                        }
                    }
                    this.threadList.add(i, zVar);
                }
            }
        }
    }

    public void aLt() {
        int size = this.threadList.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.adp.widget.ListView.u uVar = this.threadList.get(i2);
            if (uVar instanceof com.baidu.tbadk.core.data.ah) {
                com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) uVar;
                if (ahVar.isPhotoLiveThread() && !(ahVar instanceof com.baidu.tbadk.core.data.ab)) {
                    com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
                    abVar.a(ahVar, i);
                    int showStyle = abVar.sS() != null ? abVar.sS().getShowStyle() : i;
                    if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i2, abVar);
                    }
                    i = showStyle;
                }
            }
        }
    }

    public void aLu() {
        if (aoE() != null) {
            List<PhotoLiveCardData> aKY = aKY();
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (aKY != null && aKY.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!(threadList.get(i) instanceof com.baidu.tbadk.core.data.w)) {
                        i++;
                    } else {
                        threadList.remove(i);
                        break;
                    }
                }
                int RA = RA();
                int aLe = aLe();
                if (aLb()) {
                    aLe++;
                }
                int min = Math.min((aLe + RA) - 1, size);
                com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                wVar.l(aKY);
                getThreadList().add(min, wVar);
            }
        }
    }

    public void aLv() {
        if (aLb()) {
            int RA = RA();
            if (tf() == 0) {
                RA++;
            }
            com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
            xVar.a(aLc());
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(RA, xVar);
            }
        }
    }

    public void aLw() {
        com.baidu.tbadk.core.data.n aLd;
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.uO().getLong("frs_storecard_closetime", 0L) >= 86400000 && (aLd = aLd()) != null) {
            int RA = RA();
            int tf = tf();
            if (tf == 0 || tf == 1) {
                RA++;
            }
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(RA, aLd);
            }
        }
    }

    public void aLx() {
        com.baidu.tbadk.core.data.y recommendLikeUser;
        int g;
        int i;
        if (this.cJt != null && (recommendLikeUser = this.cJt.getRecommendLikeUser()) != null && recommendLikeUser.sE() != null && !TextUtils.isEmpty(recommendLikeUser.sE().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.u next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.ah) && ((com.baidu.tbadk.core.data.ah) next).getIs_top() != 0) {
                    i2++;
                }
            }
            String sD = recommendLikeUser.sD();
            if (!TextUtils.isEmpty(sD) && !TextUtils.isEmpty(sD.trim()) && (g = com.baidu.adp.lib.h.b.g(sD, -1)) != -1 && (g + i2) - 1 < size && i >= 0 && !(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.c)) {
                if (i - 1 < 0 || !(this.threadList.get(i - 1) instanceof com.baidu.tbadk.core.data.c)) {
                    this.threadList.add(i, recommendLikeUser);
                }
            }
        }
    }

    public com.baidu.tbadk.core.data.ah mC(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.u next = it.next();
            if (next != null && (next instanceof com.baidu.tbadk.core.data.ah) && TextUtils.equals(str, ((com.baidu.tbadk.core.data.ah) next).getId())) {
                return (com.baidu.tbadk.core.data.ah) next;
            }
        }
        return null;
    }

    public void k(com.baidu.tbadk.core.data.ah ahVar) {
        this.threadList.remove(ahVar);
    }

    public boolean d(m mVar) {
        if (mVar == null) {
            return false;
        }
        d(mVar.so());
        a(mVar.aKV());
        hR(mVar.aKR());
        my(mVar.aKS());
        c(mVar.aoE());
        setGameName(mVar.getGameName());
        mz(mVar.aKZ());
        a(mVar.aKT());
        hS(mVar.aKW());
        jW(mVar.aoK());
        cb(mVar.aKY());
        oc(mVar.aLe());
        c(mVar.aLc());
        b(mVar.getPage());
        a(mVar.aKP());
        bZ(mVar.aKX());
        an(mVar.getThreadList());
        bY(mVar.aKU());
        f(mVar.getUserData());
        setUserMap(mVar.getUserMap());
        b(mVar.aKQ());
        ca(mVar.aLa());
        cd(mVar.aLg());
        mB(mVar.aLh());
        a(mVar.aLd());
        return true;
    }

    public void aLy() {
        if (this.threadList != null || this.threadList.size() <= 0) {
            int size = this.threadList.size();
            for (int i = 0; i < size; i++) {
                if (this.threadList.get(i) instanceof com.baidu.tbadk.core.data.n) {
                    this.threadList.remove(i);
                    return;
                }
            }
        }
    }

    public void aLz() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.cJt != null && this.cJt.getBannerListData() != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.u uVar = this.threadList.get(i2);
                if (uVar instanceof com.baidu.tbadk.core.data.ah) {
                    com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) uVar;
                    if (ahVar == null || (!ahVar.tB() && ahVar.tl() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.cJt.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar = new h();
                hVar.setForumId(this.cJt.getId());
                hVar.bW(feedForumList);
                this.threadList.add(i + 6, hVar);
            }
        }
    }

    public boolean aLA() {
        com.baidu.tieba.card.a.u recomTopicData;
        if (this.threadList == null || this.cJt == null || this.cJt.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.u uVar = this.threadList.get(i2);
            if (uVar instanceof com.baidu.tbadk.core.data.ah) {
                com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) uVar;
                if (ahVar == null || (!ahVar.tB() && ahVar.tl() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.cJt.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.x.o(recomTopicData.aSJ) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new au("c10835").aa("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }
}
