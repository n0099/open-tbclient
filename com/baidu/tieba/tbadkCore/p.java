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
    private int dxU = 0;

    public void c(y yVar) {
        if (yVar != null) {
            this.czh.setCurScore(yVar.getCurScore());
            this.czh.setLevelupScore(yVar.getLevelupScore());
            this.czh.setLike(yVar.isLike());
            this.czh.setUser_level(yVar.RI());
            this.czh.setLevelName(yVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.czh.setSignData(signData);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(com.baidu.tbadk.core.data.z zVar) {
        if (this.threadList != null) {
            while (!this.threadList.isEmpty() && this.threadList.get(0) != null && (this.threadList.get(0) instanceof com.baidu.tbadk.core.data.z) && ((com.baidu.tbadk.core.data.z) this.threadList.get(0)).getIs_top() == 2) {
                this.threadList.remove(0);
            }
        }
        this.threadList.add(0, zVar);
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null && !StringUtils.isNull(oVar.getId()) && this.threadList != null) {
            int Pe = Pe();
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
                    this.dxU++;
                    this.threadList.add(Pe, wVar);
                    return;
                }
                return;
            }
            this.dxU++;
            this.threadList.add(Pe, oVar);
        }
    }

    public void aCc() {
        this.dxU = 0;
    }

    public int aCd() {
        return this.dxU;
    }

    public int aCe() {
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

    public int Pe() {
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

    private int sD() {
        Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.u next = it.next();
            if ((next instanceof com.baidu.tbadk.core.data.z) && ((com.baidu.tbadk.core.data.z) next).sJ() == 1) {
                return ((com.baidu.tbadk.core.data.z) next).sD();
            }
        }
        return -1;
    }

    public void aN(Context context) {
        BannerListData bannerListData;
        int g;
        if (this.czh != null && (bannerListData = this.czh.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && this.threadList != null && this.threadList.size() > 0) {
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
                    if (bVar != null && bVar.rB() && (com.baidu.adp.lib.h.b.g(bVar.Us, 0) + i2) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && (g < size2 || i3 <= 3)) {
                        if (bVar.rC()) {
                            if (!ah.isInstalledPackage(context, bVar.Ur) && !TextUtils.isEmpty(bVar.Ur) && !TextUtils.isEmpty(bVar.Un)) {
                                boolean eT = com.baidu.tbadk.download.b.Bm().eT(bVar.Ur);
                                boolean eW = com.baidu.tbadk.download.b.Bm().eW(bVar.Ur);
                                if (eT) {
                                    bVar.Ul = 1;
                                } else if (eW) {
                                    bVar.Ul = 2;
                                } else {
                                    bVar.Ul = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                if (g < size2) {
                                    this.threadList.add(g, bVar);
                                } else if (g == size2) {
                                    this.threadList.add(bVar);
                                }
                            }
                        } else if (bVar.rD()) {
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

    public void aCf() {
        boolean z = true;
        int i = 0;
        if (this.czh != null && this.ceI != null && this.ceI.sd() == 1) {
            if (this.dxo == null || !this.dxo.aCn()) {
                z = false;
            }
            if (this.dxm || z) {
                aa aaVar = new aa();
                aaVar.hj(this.dxm);
                aaVar.ms(this.dxn);
                aaVar.b(this.dxo);
                aaVar.bJ(1003);
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

    public void aCg() {
        int size = this.threadList.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.adp.widget.ListView.u uVar = this.threadList.get(i2);
            if (uVar instanceof com.baidu.tbadk.core.data.z) {
                com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) uVar;
                if (zVar.isPhotoLiveThread() && !(zVar instanceof com.baidu.tbadk.core.data.w)) {
                    com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                    wVar.a(zVar, i);
                    int showStyle = wVar.sy() != null ? wVar.sy().getShowStyle() : i;
                    if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i2, wVar);
                    }
                    i = showStyle;
                }
            }
        }
    }

    public void aCh() {
        if (ajy() != null) {
            List<PhotoLiveCardData> aBM = aBM();
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (aBM != null && aBM.size() > 0 && threadList != null && threadList.size() > 0) {
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
                int Pe = Pe();
                int aBS = aBS();
                if (aBP()) {
                    aBS++;
                }
                int min = Math.min((aBS + Pe) - 1, size);
                com.baidu.tbadk.core.data.s sVar = new com.baidu.tbadk.core.data.s();
                sVar.i(aBM);
                getThreadList().add(min, sVar);
            }
        }
    }

    public void aCi() {
        if (aBP()) {
            int Pe = Pe();
            if (sD() == 0) {
                Pe++;
            }
            com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t();
            tVar.a(aBQ());
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(Pe, tVar);
            }
        }
    }

    public void aCj() {
        com.baidu.tbadk.core.data.k aBR;
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.tZ().getLong("frs_storecard_closetime", 0L) >= 86400000 && (aBR = aBR()) != null) {
            int Pe = Pe();
            int sD = sD();
            if (sD == 0 || sD == 1) {
                Pe++;
            }
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(Pe, aBR);
            }
        }
    }

    public void aCk() {
        com.baidu.tbadk.core.data.u recommendLikeUser;
        int g;
        int i;
        if (this.czh != null && (recommendLikeUser = this.czh.getRecommendLikeUser()) != null && recommendLikeUser.so() != null && !TextUtils.isEmpty(recommendLikeUser.so().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.u next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.z) && ((com.baidu.tbadk.core.data.z) next).getIs_top() != 0) {
                    i2++;
                }
            }
            String sn = recommendLikeUser.sn();
            if (!TextUtils.isEmpty(sn) && !TextUtils.isEmpty(sn.trim()) && (g = com.baidu.adp.lib.h.b.g(sn, -1)) != -1 && (g + i2) - 1 < size && i >= 0 && !(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.b)) {
                if (i - 1 < 0 || !(this.threadList.get(i - 1) instanceof com.baidu.tbadk.core.data.b)) {
                    this.threadList.add(i, recommendLikeUser);
                }
            }
        }
    }

    public com.baidu.tbadk.core.data.z mo(String str) {
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

    public void g(com.baidu.tbadk.core.data.z zVar) {
        this.threadList.remove(zVar);
    }

    public boolean d(n nVar) {
        if (nVar == null) {
            return false;
        }
        c(nVar.rZ());
        a(nVar.aBI());
        hh(nVar.aBE());
        mk(nVar.aBF());
        c(nVar.ajy());
        setGameName(nVar.getGameName());
        ml(nVar.aBN());
        a(nVar.aBG());
        hi(nVar.aBJ());
        jb(nVar.ajE());
        bM(nVar.aBM());
        an(nVar.aBL());
        mp(nVar.aBS());
        c(nVar.aBQ());
        b(nVar.getPage());
        a(nVar.aBC());
        bK(nVar.aBK());
        am(nVar.getThreadList());
        bJ(nVar.aBH());
        f(nVar.getUserData());
        setUserMap(nVar.getUserMap());
        b(nVar.aBD());
        bL(nVar.aBO());
        bO(nVar.aBU());
        mn(nVar.aBV());
        a(nVar.aBR());
        return true;
    }

    public void aCl() {
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

    public void aCm() {
        List<FeedForumData> feedForumList;
        com.baidu.tbadk.core.data.z zVar;
        if (this.threadList != null && this.czh != null && this.czh.getBannerListData() != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size() && (zVar = (com.baidu.tbadk.core.data.z) this.threadList.get(i2)) != null && (zVar.sW() || zVar.sJ() == 1); i2++) {
                i++;
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.czh.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                i iVar = new i();
                iVar.setForumId(this.czh.getId());
                iVar.bH(feedForumList);
                this.threadList.add(i + 6, iVar);
            }
        }
    }
}
