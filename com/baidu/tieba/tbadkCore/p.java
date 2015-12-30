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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class p extends n implements com.baidu.tbadk.mvc.b.l {
    private int dFv = 0;

    public void c(y yVar) {
        if (yVar != null) {
            this.cCN.setCurScore(yVar.getCurScore());
            this.cCN.setLevelupScore(yVar.getLevelupScore());
            this.cCN.setLike(yVar.isLike());
            this.cCN.setUser_level(yVar.Sa());
            this.cCN.setLevelName(yVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.cCN.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.cCN == null) {
            return null;
        }
        return this.cCN.getSignData();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(com.baidu.tbadk.core.data.z zVar) {
        if (this.threadList != null) {
            while (!this.threadList.isEmpty() && this.threadList.get(0) != null && (this.threadList.get(0) instanceof com.baidu.tbadk.core.data.z) && ((com.baidu.tbadk.core.data.z) this.threadList.get(0)).getIs_top() == 2) {
                this.threadList.remove(0);
            }
        }
        this.threadList.add(0, zVar);
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null && !StringUtils.isNull(oVar.getId()) && this.threadList != null) {
            int Pw = Pw();
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.u uVar = threadList.get(i);
                    if ((uVar instanceof com.baidu.tbadk.core.data.z) && oVar.getId().equals(((com.baidu.tbadk.core.data.z) uVar).getId())) {
                        return;
                    }
                }
            }
            if (oVar.isPhotoLiveThread()) {
                com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                wVar.a(oVar, -1).setPostNum(1);
                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.dFv++;
                    this.threadList.add(Pw, wVar);
                    return;
                }
                return;
            }
            this.dFv++;
            this.threadList.add(Pw, oVar);
        }
    }

    public void aEk() {
        this.dFv = 0;
    }

    public int aEl() {
        return this.dFv;
    }

    public int aEm() {
        int i = 0;
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = threadList.get(i2) instanceof com.baidu.tbadk.core.data.o ? i + 1 : i;
                i2++;
                i = i3;
            }
        }
        return i;
    }

    public int Pw() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.u next = it.next();
            if (next instanceof com.baidu.tbadk.core.data.z) {
                if (((com.baidu.tbadk.core.data.z) next).getIs_top() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int sm() {
        Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.u next = it.next();
            if ((next instanceof com.baidu.tbadk.core.data.z) && ((com.baidu.tbadk.core.data.z) next).st() == 1) {
                return ((com.baidu.tbadk.core.data.z) next).sm();
            }
        }
        return -1;
    }

    public void aO(Context context) {
        BannerListData bannerListData;
        int g;
        if (this.cCN != null && (bannerListData = this.cCN.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && this.threadList != null && this.threadList.size() > 0) {
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
            Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.u next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.z) && ((com.baidu.tbadk.core.data.z) next).getIs_top() != 0) {
                    i2++;
                }
            }
            int size3 = bannerListData.getAllAdvertList().size();
            if (size3 >= 1) {
                int i3 = size2 - i2;
                HashSet hashSet = new HashSet();
                for (int i4 = 0; i4 < size3; i4++) {
                    com.baidu.tbadk.core.data.b bVar = bannerListData.getAllAdvertList().get(i4);
                    if (bVar != null && bVar.rk() && (com.baidu.adp.lib.h.b.g(bVar.UT, 0) + i2) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && (g < size2 || i3 <= 3)) {
                        if (bVar.rl()) {
                            if (!ah.isInstalledPackage(context, bVar.US) && !TextUtils.isEmpty(bVar.US) && !TextUtils.isEmpty(bVar.UN)) {
                                boolean eX = com.baidu.tbadk.download.b.Bb().eX(bVar.US);
                                boolean fa = com.baidu.tbadk.download.b.Bb().fa(bVar.US);
                                if (eX) {
                                    bVar.UL = 1;
                                } else if (fa) {
                                    bVar.UL = 2;
                                } else {
                                    bVar.UL = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                if (g < size2) {
                                    this.threadList.add(g, bVar);
                                } else if (g == size2) {
                                    this.threadList.add(bVar);
                                }
                            }
                        } else if (bVar.rm()) {
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

    public void aEn() {
        boolean z = true;
        int i = 0;
        if (this.cCN != null && this.ciK != null && this.ciK.rM() == 1) {
            if (this.dEP == null || !this.dEP.aEv()) {
                z = false;
            }
            if (this.dEN || z) {
                aa aaVar = new aa();
                aaVar.hs(this.dEN);
                aaVar.mp(this.dEO);
                aaVar.b(this.dEP);
                aaVar.bC(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.u next = it.next();
                        if ((next instanceof com.baidu.tbadk.core.data.z) && ((com.baidu.tbadk.core.data.z) next).getIs_top() != 0) {
                            i++;
                        }
                    }
                    this.threadList.add(i, aaVar);
                }
            }
        }
    }

    public void aEo() {
        int size = this.threadList.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.adp.widget.ListView.u uVar = this.threadList.get(i2);
            if (uVar instanceof com.baidu.tbadk.core.data.z) {
                com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) uVar;
                if (zVar.isPhotoLiveThread() && !(zVar instanceof com.baidu.tbadk.core.data.w)) {
                    com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                    wVar.a(zVar, i);
                    int showStyle = wVar.sh() != null ? wVar.sh().getShowStyle() : i;
                    if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i2, wVar);
                    }
                    i = showStyle;
                }
            }
        }
    }

    public void aEp() {
        if (akG() != null) {
            List<PhotoLiveCardData> aDU = aDU();
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (aDU != null && aDU.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!(threadList.get(i) instanceof com.baidu.tbadk.core.data.s)) {
                        i++;
                    } else {
                        threadList.remove(i);
                        break;
                    }
                }
                int Pw = Pw();
                int aEa = aEa();
                if (aDX()) {
                    aEa++;
                }
                int min = Math.min((aEa + Pw) - 1, size);
                com.baidu.tbadk.core.data.s sVar = new com.baidu.tbadk.core.data.s();
                sVar.i(aDU);
                getThreadList().add(min, sVar);
            }
        }
    }

    public void aEq() {
        if (aDX()) {
            int Pw = Pw();
            if (sm() == 0) {
                Pw++;
            }
            com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t();
            tVar.a(aDY());
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(Pw, tVar);
            }
        }
    }

    public void aEr() {
        com.baidu.tbadk.core.data.k aDZ;
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.tJ().getLong("frs_storecard_closetime", 0L) >= 86400000 && (aDZ = aDZ()) != null) {
            int Pw = Pw();
            int sm = sm();
            if (sm == 0 || sm == 1) {
                Pw++;
            }
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(Pw, aDZ);
            }
        }
    }

    public void aEs() {
        com.baidu.tbadk.core.data.u recommendLikeUser;
        int g;
        int i;
        if (this.cCN != null && (recommendLikeUser = this.cCN.getRecommendLikeUser()) != null && recommendLikeUser.rX() != null && !TextUtils.isEmpty(recommendLikeUser.rX().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.u next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.z) && ((com.baidu.tbadk.core.data.z) next).getIs_top() != 0) {
                    i2++;
                }
            }
            String rW = recommendLikeUser.rW();
            if (!TextUtils.isEmpty(rW) && !TextUtils.isEmpty(rW.trim()) && (g = com.baidu.adp.lib.h.b.g(rW, -1)) != -1 && (g + i2) - 1 < size && i >= 0 && !(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.b)) {
                if (i - 1 < 0 || !(this.threadList.get(i - 1) instanceof com.baidu.tbadk.core.data.b)) {
                    this.threadList.add(i, recommendLikeUser);
                }
            }
        }
    }

    public com.baidu.tbadk.core.data.z ml(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.u next = it.next();
            if (next != null && (next instanceof com.baidu.tbadk.core.data.z) && TextUtils.equals(str, ((com.baidu.tbadk.core.data.z) next).getId())) {
                return (com.baidu.tbadk.core.data.z) next;
            }
        }
        return null;
    }

    public void j(com.baidu.tbadk.core.data.z zVar) {
        this.threadList.remove(zVar);
    }

    public boolean d(n nVar) {
        if (nVar == null) {
            return false;
        }
        c(nVar.rI());
        a(nVar.aDQ());
        hq(nVar.aDM());
        mh(nVar.aDN());
        c(nVar.akG());
        setGameName(nVar.getGameName());
        mi(nVar.aDV());
        a(nVar.aDO());
        hr(nVar.aDR());
        jz(nVar.akM());
        bP(nVar.aDU());
        an(nVar.aDT());
        mR(nVar.aEa());
        c(nVar.aDY());
        b(nVar.getPage());
        a(nVar.aDK());
        bN(nVar.aDS());
        am(nVar.getThreadList());
        bM(nVar.aDP());
        f(nVar.getUserData());
        setUserMap(nVar.getUserMap());
        b(nVar.aDL());
        bO(nVar.aDW());
        bR(nVar.aEc());
        mk(nVar.aEd());
        a(nVar.aDZ());
        return true;
    }

    public void aEt() {
        if (this.threadList != null || this.threadList.size() <= 0) {
            int size = this.threadList.size();
            for (int i = 0; i < size; i++) {
                if (this.threadList.get(i) instanceof com.baidu.tbadk.core.data.k) {
                    this.threadList.remove(i);
                    return;
                }
            }
        }
    }

    public void aEu() {
        List<FeedForumData> feedForumList;
        com.baidu.tbadk.core.data.z zVar;
        if (this.threadList != null && this.cCN != null && this.cCN.getBannerListData() != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size() && (zVar = (com.baidu.tbadk.core.data.z) this.threadList.get(i2)) != null && (zVar.sG() || zVar.st() == 1); i2++) {
                i++;
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.cCN.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                i iVar = new i();
                iVar.setForumId(this.cCN.getId());
                iVar.bK(feedForumList);
                this.threadList.add(i + 6, iVar);
            }
        }
    }
}
