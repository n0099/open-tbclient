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
    private int cZo = 0;

    public void c(x xVar) {
        if (xVar != null) {
            this.cgK.setCurScore(xVar.getCurScore());
            this.cgK.setLevelupScore(xVar.getLevelupScore());
            this.cgK.setLike(xVar.isLike());
            this.cgK.setUser_level(xVar.auf());
            this.cgK.setLevelName(xVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.cgK.setSignData(signData);
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
            int Ny = Ny();
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
                    this.cZo++;
                    this.threadList.add(Ny, tVar);
                    return;
                }
                return;
            }
            this.cZo++;
            this.threadList.add(Ny, mVar);
        }
    }

    public void awu() {
        this.cZo = 0;
    }

    public int awv() {
        return this.cZo;
    }

    public int aww() {
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

    public int Ny() {
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

    public void aO(Context context) {
        BannerListData bannerListData;
        int g;
        if (this.cgK != null && (bannerListData = this.cgK.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && this.threadList != null && this.threadList.size() > 0) {
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
                    if (bVar != null && bVar.rn() && (com.baidu.adp.lib.g.b.g(bVar.Uc, 0) + i2) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && (g < size2 || i3 <= 3)) {
                        if (bVar.ro()) {
                            if (!ag.isInstalledPackage(context, bVar.Ub) && !TextUtils.isEmpty(bVar.Ub) && !TextUtils.isEmpty(bVar.TX)) {
                                boolean eH = com.baidu.tbadk.download.b.Ap().eH(bVar.Ub);
                                boolean eI = com.baidu.tbadk.download.b.Ap().eI(bVar.Ub);
                                if (eH) {
                                    bVar.TV = 1;
                                } else if (eI) {
                                    bVar.TV = 2;
                                } else {
                                    bVar.TV = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                if (g < size2) {
                                    this.threadList.add(g, bVar);
                                } else if (g == size2) {
                                    this.threadList.add(bVar);
                                }
                            }
                        } else if (bVar.rp()) {
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

    public void awx() {
        boolean z = true;
        int i = 0;
        if (this.cgK != null && this.cbi != null && this.cbi.rI() == 1) {
            if (this.cYL == null || !this.cYL.awC()) {
                z = false;
            }
            if (this.cYJ || z) {
                z zVar = new z();
                zVar.gv(this.cYJ);
                zVar.lC(this.cYK);
                zVar.b(this.cYL);
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

    public void awy() {
        int size = this.threadList.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.adp.widget.ListView.u uVar = this.threadList.get(i2);
            if (uVar instanceof com.baidu.tbadk.core.data.w) {
                com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) uVar;
                if (wVar.isPhotoLiveThread() && !(wVar instanceof com.baidu.tbadk.core.data.t)) {
                    com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t();
                    tVar.a(wVar, i);
                    int showStyle = tVar.sb() != null ? tVar.sb().getShowStyle() : i;
                    if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i2, tVar);
                    }
                    i = showStyle;
                }
            }
        }
    }

    public void awz() {
        if (afg() != null) {
            List<PhotoLiveCardData> awh = awh();
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (awh != null && awh.size() > 0 && threadList != null && threadList.size() > 0) {
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
                int Ny = Ny();
                int awm = awm();
                if (awk()) {
                    awm++;
                }
                int min = Math.min((awm + Ny) - 1, size);
                com.baidu.tbadk.core.data.p pVar = new com.baidu.tbadk.core.data.p();
                pVar.j(awh);
                getThreadList().add(min, pVar);
            }
        }
    }

    public void awA() {
        if (awk()) {
            int Ny = Ny();
            com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q();
            qVar.a(awl());
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(Ny, qVar);
            }
        }
    }

    public void awB() {
        com.baidu.tbadk.core.data.r recommendLikeUser;
        int g;
        int i;
        if (this.cgK != null && (recommendLikeUser = this.cgK.getRecommendLikeUser()) != null && recommendLikeUser.rR() != null && !TextUtils.isEmpty(recommendLikeUser.rR().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.u next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) next).getIs_top() != 0) {
                    i2++;
                }
            }
            String rQ = recommendLikeUser.rQ();
            if (!TextUtils.isEmpty(rQ) && !TextUtils.isEmpty(rQ.trim()) && (g = com.baidu.adp.lib.g.b.g(rQ, -1)) != -1 && (g + i2) - 1 < size && i >= 0 && !(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.b)) {
                if (i - 1 < 0 || !(this.threadList.get(i - 1) instanceof com.baidu.tbadk.core.data.b)) {
                    this.threadList.add(i, recommendLikeUser);
                }
            }
        }
    }

    public com.baidu.tbadk.core.data.w ly(String str) {
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
        d(mVar.rE());
        a(mVar.awd());
        gt(mVar.avZ());
        lw(mVar.awa());
        c(mVar.afg());
        setGameName(mVar.getGameName());
        lx(mVar.awi());
        a(mVar.awb());
        gu(mVar.awe());
        ih(mVar.afm());
        by(mVar.awh());
        ag(mVar.awg());
        lf(mVar.awm());
        c(mVar.awl());
        b(mVar.getPage());
        a(mVar.avX());
        bw(mVar.awf());
        af(mVar.getThreadList());
        bv(mVar.awc());
        i(mVar.getUserData());
        setUserMap(mVar.getUserMap());
        b(mVar.avY());
        bx(mVar.awj());
        bz(mVar.awn());
        return true;
    }
}
