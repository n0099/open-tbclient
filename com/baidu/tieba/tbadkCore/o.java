package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.SignData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class o extends m implements com.baidu.tbadk.mvc.b.l {
    private int cXR = 0;

    public void b(x xVar) {
        if (xVar != null) {
            this.cgf.setCurScore(xVar.getCurScore());
            this.cgf.setLevelupScore(xVar.getLevelupScore());
            this.cgf.setLike(xVar.isLike());
            this.cgf.setUser_level(xVar.atz());
            this.cgf.setLevelName(xVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.cgf.setSignData(signData);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(com.baidu.tbadk.core.data.w wVar) {
        if (this.threadList != null) {
            while (!this.threadList.isEmpty() && this.threadList.get(0) != null && (this.threadList.get(0) instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) this.threadList.get(0)).getIs_top() == 2) {
                this.threadList.remove(0);
            }
        }
        this.threadList.add(0, wVar);
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null && !StringUtils.isNull(mVar.getId()) && this.threadList != null) {
            int Nf = Nf();
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.u uVar = threadList.get(i);
                    if ((uVar instanceof com.baidu.tbadk.core.data.w) && mVar.getId().equals(((com.baidu.tbadk.core.data.w) uVar).getId())) {
                        return;
                    }
                }
            }
            if (mVar.isPhotoLiveThread()) {
                com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t();
                tVar.a(mVar, -1).setPostNum(1);
                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.cXR++;
                    this.threadList.add(Nf, tVar);
                    return;
                }
                return;
            }
            this.cXR++;
            this.threadList.add(Nf, mVar);
        }
    }

    public void avM() {
        this.cXR = 0;
    }

    public int avN() {
        return this.cXR;
    }

    public int avO() {
        int i = 0;
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = threadList.get(i2) instanceof com.baidu.tbadk.core.data.m ? i + 1 : i;
                i2++;
                i = i3;
            }
        }
        return i;
    }

    public int Nf() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.u next = it.next();
            if (next instanceof com.baidu.tbadk.core.data.w) {
                if (((com.baidu.tbadk.core.data.w) next).getIs_top() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    public void aP(Context context) {
        BannerListData bannerListData;
        int g;
        if (this.cgf != null && (bannerListData = this.cgf.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && this.threadList != null && this.threadList.size() > 0) {
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
                if ((next instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) next).getIs_top() != 0) {
                    i2++;
                }
            }
            int size3 = bannerListData.getAllAdvertList().size();
            if (size3 >= 1) {
                int i3 = size2 - i2;
                HashSet hashSet = new HashSet();
                for (int i4 = 0; i4 < size3; i4++) {
                    com.baidu.tbadk.core.data.b bVar = bannerListData.getAllAdvertList().get(i4);
                    if (bVar != null && bVar.rm() && (com.baidu.adp.lib.g.b.g(bVar.Ub, 0) + i2) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && (g < size2 || i3 <= 3)) {
                        if (bVar.rn()) {
                            if (!ag.isInstalledPackage(context, bVar.Ua) && !TextUtils.isEmpty(bVar.Ua) && !TextUtils.isEmpty(bVar.TW)) {
                                boolean eH = com.baidu.tbadk.download.b.Ak().eH(bVar.Ua);
                                boolean eI = com.baidu.tbadk.download.b.Ak().eI(bVar.Ua);
                                if (eH) {
                                    bVar.TU = 1;
                                } else if (eI) {
                                    bVar.TU = 2;
                                } else {
                                    bVar.TU = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                if (g < size2) {
                                    this.threadList.add(g, bVar);
                                } else if (g == size2) {
                                    this.threadList.add(bVar);
                                }
                            }
                        } else if (bVar.ro()) {
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

    public void avP() {
        boolean z = true;
        int i = 0;
        if (this.cgf != null && this.caH != null && this.caH.rG() == 1) {
            if (this.cXp == null || !this.cXp.avU()) {
                z = false;
            }
            if (this.cXn || z) {
                z zVar = new z();
                zVar.gs(this.cXn);
                zVar.ly(this.cXo);
                zVar.b(this.cXp);
                zVar.bA(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.u next = it.next();
                        if ((next instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) next).getIs_top() != 0) {
                            i++;
                        }
                    }
                    this.threadList.add(i, zVar);
                }
            }
        }
    }

    public void avQ() {
        int size = this.threadList.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.adp.widget.ListView.u uVar = this.threadList.get(i2);
            if (uVar instanceof com.baidu.tbadk.core.data.w) {
                com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) uVar;
                if (wVar.isPhotoLiveThread() && !(wVar instanceof com.baidu.tbadk.core.data.t)) {
                    com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t();
                    tVar.a(wVar, i);
                    int showStyle = tVar.rZ() != null ? tVar.rZ().getShowStyle() : i;
                    if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i2, tVar);
                    }
                    i = showStyle;
                }
            }
        }
    }

    public void avR() {
        if (aeJ() != null) {
            List<PhotoLiveCardData> avA = avA();
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (avA != null && avA.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!(threadList.get(i) instanceof com.baidu.tbadk.core.data.p)) {
                        i++;
                    } else {
                        threadList.remove(i);
                        break;
                    }
                }
                int Nf = Nf();
                int avF = avF();
                if (avD()) {
                    avF++;
                }
                int min = Math.min((avF + Nf) - 1, size);
                com.baidu.tbadk.core.data.p pVar = new com.baidu.tbadk.core.data.p();
                pVar.j(avA);
                getThreadList().add(min, pVar);
            }
        }
    }

    public void avS() {
        if (avD()) {
            int Nf = Nf();
            com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q();
            qVar.a(avE());
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(Nf, qVar);
            }
        }
    }

    public void avT() {
        com.baidu.tbadk.core.data.r recommendLikeUser;
        int g;
        int i;
        if (this.cgf != null && (recommendLikeUser = this.cgf.getRecommendLikeUser()) != null && recommendLikeUser.rP() != null && !TextUtils.isEmpty(recommendLikeUser.rP().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.u next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) next).getIs_top() != 0) {
                    i2++;
                }
            }
            String rO = recommendLikeUser.rO();
            if (!TextUtils.isEmpty(rO) && !TextUtils.isEmpty(rO.trim()) && (g = com.baidu.adp.lib.g.b.g(rO, -1)) != -1 && (g + i2) - 1 < size && i >= 0 && !(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.b)) {
                if (i - 1 < 0 || !(this.threadList.get(i - 1) instanceof com.baidu.tbadk.core.data.b)) {
                    this.threadList.add(i, recommendLikeUser);
                }
            }
        }
    }

    public com.baidu.tbadk.core.data.w lu(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.u next = it.next();
            if (next != null && (next instanceof com.baidu.tbadk.core.data.w) && TextUtils.equals(str, ((com.baidu.tbadk.core.data.w) next).getId())) {
                return (com.baidu.tbadk.core.data.w) next;
            }
        }
        return null;
    }

    public void g(com.baidu.tbadk.core.data.w wVar) {
        this.threadList.remove(wVar);
    }

    public boolean d(m mVar) {
        if (mVar == null) {
            return false;
        }
        d(mVar.rC());
        a(mVar.avw());
        gq(mVar.avs());
        ls(mVar.avt());
        c(mVar.aeJ());
        setGameName(mVar.getGameName());
        lt(mVar.avB());
        a(mVar.avu());
        gr(mVar.avx());
        hT(mVar.aeP());
        bu(mVar.avA());
        ag(mVar.avz());
        kR(mVar.avF());
        c(mVar.avE());
        b(mVar.getPage());
        a(mVar.avq());
        bs(mVar.avy());
        af(mVar.getThreadList());
        br(mVar.avv());
        i(mVar.getUserData());
        setUserMap(mVar.getUserMap());
        b(mVar.avr());
        bt(mVar.avC());
        return true;
    }
}
