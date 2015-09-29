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
            this.cfU.setCurScore(xVar.getCurScore());
            this.cfU.setLevelupScore(xVar.getLevelupScore());
            this.cfU.setLike(xVar.isLike());
            this.cfU.setUser_level(xVar.atx());
            this.cfU.setLevelName(xVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.cfU.setSignData(signData);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(com.baidu.tbadk.core.data.v vVar) {
        if (this.threadList != null) {
            while (!this.threadList.isEmpty() && this.threadList.get(0) != null && (this.threadList.get(0) instanceof com.baidu.tbadk.core.data.v) && ((com.baidu.tbadk.core.data.v) this.threadList.get(0)).getIs_top() == 2) {
                this.threadList.remove(0);
            }
        }
        this.threadList.add(0, vVar);
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        if (lVar != null && !StringUtils.isNull(lVar.getId()) && this.threadList != null) {
            int Nj = Nj();
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.u uVar = threadList.get(i);
                    if ((uVar instanceof com.baidu.tbadk.core.data.v) && lVar.getId().equals(((com.baidu.tbadk.core.data.v) uVar).getId())) {
                        return;
                    }
                }
            }
            if (lVar.isPhotoLiveThread()) {
                com.baidu.tbadk.core.data.s sVar = new com.baidu.tbadk.core.data.s();
                sVar.a(lVar, -1).setPostNum(1);
                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.threadList.add(Nj, sVar);
                    return;
                }
                return;
            }
            this.threadList.add(Nj, lVar);
        }
    }

    public int avK() {
        int i = 0;
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = threadList.get(i2) instanceof com.baidu.tbadk.core.data.l ? i + 1 : i;
                i2++;
                i = i3;
            }
        }
        return i;
    }

    public int Nj() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.u next = it.next();
            if (next instanceof com.baidu.tbadk.core.data.v) {
                if (((com.baidu.tbadk.core.data.v) next).getIs_top() != 0) {
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
        if (this.cfU != null && (bannerListData = this.cfU.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                } else if (!(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.b)) {
                    i++;
                } else {
                    this.threadList.remove(i);
                    break;
                }
            }
            int size2 = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.v) {
                    com.baidu.tbadk.core.data.v vVar = (com.baidu.tbadk.core.data.v) next;
                    if (vVar.getIs_top() != 0 || vVar.sh() == 1) {
                        i2++;
                    }
                }
            }
            int size3 = bannerListData.getAllAdvertList().size();
            if (size3 >= 1) {
                int i3 = 0;
                int i4 = size2 - i2;
                HashSet hashSet = new HashSet();
                int i5 = 0;
                while (i5 < size3) {
                    com.baidu.tbadk.core.data.b bVar = bannerListData.getAllAdvertList().get(i5);
                    if (bVar != null && bVar.rp() && (g = ((com.baidu.adp.lib.g.b.g(bVar.Ua, 0) + i2) - 1) + i3) >= 0 && !hashSet.contains(Integer.valueOf(g)) && (g < size2 || i4 <= 3)) {
                        if (bVar.rq()) {
                            if (!ag.isInstalledPackage(context, bVar.TZ) && !TextUtils.isEmpty(bVar.TZ) && !TextUtils.isEmpty(bVar.TV)) {
                                boolean eH = com.baidu.tbadk.download.b.An().eH(bVar.TZ);
                                boolean eI = com.baidu.tbadk.download.b.An().eI(bVar.TZ);
                                if (eH) {
                                    bVar.TT = 1;
                                } else if (eI) {
                                    bVar.TT = 2;
                                } else {
                                    bVar.TT = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                i3++;
                                if (g < size2) {
                                    this.threadList.add(g, bVar);
                                } else if (g == size2) {
                                    this.threadList.add(bVar);
                                }
                            }
                        } else if (bVar.rr()) {
                            hashSet.add(Integer.valueOf(g));
                            i3++;
                            if (g < size2) {
                                this.threadList.add(g, bVar);
                            } else if (g == size2) {
                                this.threadList.add(bVar);
                            }
                        }
                    }
                    i5++;
                    i3 = i3;
                }
            }
        }
    }

    public void avL() {
        boolean z = true;
        int i = 0;
        if (this.cfU != null && this.caw != null && this.caw.rJ() == 1) {
            if (this.cWQ == null || !this.cWQ.avQ()) {
                z = false;
            }
            if (this.cWO || z) {
                z zVar = new z();
                zVar.gs(this.cWO);
                zVar.lv(this.cWP);
                zVar.b(this.cWQ);
                zVar.bA(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.u next = it.next();
                        if ((next instanceof com.baidu.tbadk.core.data.v) && ((com.baidu.tbadk.core.data.v) next).getIs_top() != 0) {
                            i++;
                        }
                    }
                    this.threadList.add(i, zVar);
                }
            }
        }
    }

    public void avM() {
        int size = this.threadList.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.adp.widget.ListView.u uVar = this.threadList.get(i2);
            if (uVar instanceof com.baidu.tbadk.core.data.v) {
                com.baidu.tbadk.core.data.v vVar = (com.baidu.tbadk.core.data.v) uVar;
                if (vVar.isPhotoLiveThread() && !(vVar instanceof com.baidu.tbadk.core.data.s)) {
                    com.baidu.tbadk.core.data.s sVar = new com.baidu.tbadk.core.data.s();
                    sVar.a(vVar, i);
                    int showStyle = sVar.sc() != null ? sVar.sc().getShowStyle() : i;
                    if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i2, sVar);
                    }
                    i = showStyle;
                }
            }
        }
    }

    public void avN() {
        if (aeN() != null) {
            List<PhotoLiveCardData> avy = avy();
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (avy != null && avy.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!(threadList.get(i) instanceof com.baidu.tbadk.core.data.o)) {
                        i++;
                    } else {
                        threadList.remove(i);
                        break;
                    }
                }
                int Nj = Nj();
                int avD = avD();
                if (avB()) {
                    avD++;
                }
                int min = Math.min((avD + Nj) - 1, size);
                com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                oVar.j(avy);
                getThreadList().add(min, oVar);
            }
        }
    }

    public void avO() {
        if (avB()) {
            int Nj = Nj();
            com.baidu.tbadk.core.data.p pVar = new com.baidu.tbadk.core.data.p();
            pVar.a(avC());
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(Nj, pVar);
            }
        }
    }

    public void avP() {
        com.baidu.tbadk.core.data.q recommendLikeUser;
        int g;
        int i;
        if (this.cfU != null && (recommendLikeUser = this.cfU.getRecommendLikeUser()) != null && recommendLikeUser.rS() != null && !TextUtils.isEmpty(recommendLikeUser.rS().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.u next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.v) && ((com.baidu.tbadk.core.data.v) next).getIs_top() != 0) {
                    i2++;
                }
            }
            String rR = recommendLikeUser.rR();
            if (!TextUtils.isEmpty(rR) && !TextUtils.isEmpty(rR.trim()) && (g = com.baidu.adp.lib.g.b.g(rR, -1)) != -1 && (g + i2) - 1 < size && i >= 0 && !(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.b)) {
                if (i - 1 < 0 || !(this.threadList.get(i - 1) instanceof com.baidu.tbadk.core.data.b)) {
                    this.threadList.add(i, recommendLikeUser);
                }
            }
        }
    }

    public com.baidu.tbadk.core.data.v lr(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.u next = it.next();
            if (next != null && (next instanceof com.baidu.tbadk.core.data.v) && TextUtils.equals(str, ((com.baidu.tbadk.core.data.v) next).getId())) {
                return (com.baidu.tbadk.core.data.v) next;
            }
        }
        return null;
    }

    public void g(com.baidu.tbadk.core.data.v vVar) {
        this.threadList.remove(vVar);
    }

    public boolean d(m mVar) {
        if (mVar == null) {
            return false;
        }
        d(mVar.rF());
        a(mVar.avu());
        gq(mVar.avq());
        lp(mVar.avr());
        c(mVar.aeN());
        setGameName(mVar.getGameName());
        lq(mVar.avz());
        a(mVar.avs());
        gr(mVar.avv());
        hT(mVar.aeT());
        bt(mVar.avy());
        ag(mVar.avx());
        kP(mVar.avD());
        c(mVar.avC());
        b(mVar.getPage());
        a(mVar.avo());
        br(mVar.avw());
        af(mVar.getThreadList());
        bq(mVar.avt());
        i(mVar.getUserData());
        setUserMap(mVar.getUserMap());
        b(mVar.avp());
        bs(mVar.avA());
        return true;
    }
}
