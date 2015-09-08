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
    public void b(x xVar) {
        if (xVar != null) {
            this.caQ.setCurScore(xVar.getCurScore());
            this.caQ.setLevelupScore(xVar.getLevelupScore());
            this.caQ.setLike(xVar.isLike());
            this.caQ.setUser_level(xVar.arj());
            this.caQ.setLevelName(xVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.caQ.setSignData(signData);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(com.baidu.tbadk.core.data.x xVar) {
        if (this.threadList != null) {
            while (!this.threadList.isEmpty() && this.threadList.get(0) != null && (this.threadList.get(0) instanceof com.baidu.tbadk.core.data.x) && ((com.baidu.tbadk.core.data.x) this.threadList.get(0)).getIs_top() == 2) {
                this.threadList.remove(0);
            }
        }
        this.threadList.add(0, xVar);
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null && !StringUtils.isNull(mVar.getId()) && this.threadList != null) {
            int Nk = Nk();
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.u uVar = threadList.get(i);
                    if ((uVar instanceof com.baidu.tbadk.core.data.x) && mVar.getId().equals(((com.baidu.tbadk.core.data.x) uVar).getId())) {
                        return;
                    }
                }
            }
            if (mVar.isPhotoLiveThread()) {
                com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t();
                tVar.a(mVar).setPostNum(1);
                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.threadList.add(Nk, tVar);
                    return;
                }
                return;
            }
            this.threadList.add(Nk, mVar);
        }
    }

    public int atu() {
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

    public int Nk() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.u next = it.next();
            if (next instanceof com.baidu.tbadk.core.data.x) {
                if (((com.baidu.tbadk.core.data.x) next).getIs_top() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    public void aQ(Context context) {
        BannerListData bannerListData;
        int i;
        if (this.caQ != null && (bannerListData = this.caQ.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (!(this.threadList.get(i2) instanceof com.baidu.tbadk.core.data.c)) {
                    i2++;
                } else {
                    this.threadList.remove(i2);
                    break;
                }
            }
            int size2 = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.x) {
                    com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) next;
                    if (xVar.getIs_top() != 0 || xVar.sm() == 1) {
                        i3++;
                    }
                }
            }
            int size3 = bannerListData.getAllAdvertList().size();
            if (size3 >= 1) {
                HashSet hashSet = new HashSet();
                int i4 = 0;
                int i5 = 0;
                while (i4 < size3) {
                    com.baidu.tbadk.core.data.c cVar = bannerListData.getAllAdvertList().get(i4);
                    int i6 = ((cVar.Uo + i3) - 1) + i5;
                    if (!hashSet.contains(Integer.valueOf(i6)) && cVar != null) {
                        if (!cVar.ru()) {
                            i = i5;
                        } else if (i6 >= size2) {
                            i = i5;
                        } else if (cVar.rv()) {
                            if (ag.isInstalledPackage(context, cVar.Un)) {
                                i = i5;
                            } else if (!TextUtils.isEmpty(cVar.Un) && !TextUtils.isEmpty(cVar.Uj)) {
                                boolean eC = com.baidu.tbadk.download.b.AC().eC(cVar.Un);
                                boolean eD = com.baidu.tbadk.download.b.AC().eD(cVar.Un);
                                if (eC) {
                                    cVar.Uh = 1;
                                } else if (eD) {
                                    cVar.Uh = 2;
                                } else {
                                    cVar.Uh = 0;
                                }
                                hashSet.add(Integer.valueOf(i6));
                                this.threadList.add(i6, cVar);
                                i = i5 + 1;
                            }
                        } else if (cVar.rw()) {
                            hashSet.add(Integer.valueOf(i6));
                            this.threadList.add(i6, cVar);
                            i = i5 + 1;
                        }
                        i4++;
                        i5 = i;
                    }
                    i = i5;
                    i4++;
                    i5 = i;
                }
            }
        }
    }

    public void atv() {
        boolean z = true;
        int i = 0;
        if (this.caQ != null && this.bWI != null && this.bWI.rO() == 1) {
            if (this.cPA == null || !this.cPA.atA()) {
                z = false;
            }
            if (this.cPy || z) {
                z zVar = new z();
                zVar.gh(this.cPy);
                zVar.kX(this.cPz);
                zVar.b(this.cPA);
                zVar.bA(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.u next = it.next();
                        if ((next instanceof com.baidu.tbadk.core.data.x) && ((com.baidu.tbadk.core.data.x) next).getIs_top() != 0) {
                            i++;
                        }
                    }
                    this.threadList.add(i, zVar);
                }
            }
        }
    }

    public void atw() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.u uVar = this.threadList.get(i);
            if (uVar instanceof com.baidu.tbadk.core.data.x) {
                com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) uVar;
                if (xVar.isPhotoLiveThread()) {
                    com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t();
                    tVar.a(xVar);
                    if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, tVar);
                    }
                }
            }
        }
    }

    public void atx() {
        if (acP() != null) {
            List<PhotoLiveCardData> ati = ati();
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (ati != null && ati.size() > 0 && threadList != null && threadList.size() > 0) {
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
                int Nk = Nk();
                int atn = atn();
                if (atl()) {
                    atn++;
                }
                int min = Math.min((atn + Nk) - 1, size);
                com.baidu.tbadk.core.data.p pVar = new com.baidu.tbadk.core.data.p();
                pVar.j(ati);
                getThreadList().add(min, pVar);
            }
        }
    }

    public void aty() {
        if (atl()) {
            int Nk = Nk();
            com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q();
            qVar.a(atm());
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(Nk, qVar);
            }
        }
    }

    public void atz() {
        com.baidu.tbadk.core.data.r recommendLikeUser;
        int g;
        int i;
        if (this.caQ != null && (recommendLikeUser = this.caQ.getRecommendLikeUser()) != null && recommendLikeUser.rX() != null && !TextUtils.isEmpty(recommendLikeUser.rX().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.u next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.x) && ((com.baidu.tbadk.core.data.x) next).getIs_top() != 0) {
                    i2++;
                }
            }
            String rW = recommendLikeUser.rW();
            if (!TextUtils.isEmpty(rW) && !TextUtils.isEmpty(rW.trim()) && (g = com.baidu.adp.lib.g.b.g(rW, -1)) != -1 && (g + i2) - 1 < size && i >= 0 && !(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.c)) {
                if (i - 1 < 0 || !(this.threadList.get(i - 1) instanceof com.baidu.tbadk.core.data.c)) {
                    this.threadList.add(i, recommendLikeUser);
                }
            }
        }
    }

    public com.baidu.tbadk.core.data.x kT(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.u next = it.next();
            if (next != null && (next instanceof com.baidu.tbadk.core.data.x) && TextUtils.equals(str, ((com.baidu.tbadk.core.data.x) next).getId())) {
                return (com.baidu.tbadk.core.data.x) next;
            }
        }
        return null;
    }

    public void g(com.baidu.tbadk.core.data.x xVar) {
        this.threadList.remove(xVar);
    }

    public boolean d(m mVar) {
        if (mVar == null) {
            return false;
        }
        c(mVar.rK());
        a(mVar.ate());
        gf(mVar.ata());
        kR(mVar.atb());
        c(mVar.acP());
        setGameName(mVar.getGameName());
        kS(mVar.atj());
        a(mVar.atc());
        gg(mVar.atf());
        hL(mVar.acV());
        br(mVar.ati());
        ae(mVar.ath());
        ko(mVar.atn());
        d(mVar.atm());
        a(mVar.getPage());
        a(mVar.asY());
        bp(mVar.atg());
        ad(mVar.getThreadList());
        bo(mVar.atd());
        h(mVar.getUserData());
        setUserMap(mVar.getUserMap());
        b(mVar.asZ());
        bq(mVar.atk());
        return true;
    }
}
