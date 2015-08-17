package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.SignData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import tbclient.FrsPage.AnchorPower;
/* loaded from: classes.dex */
public class n extends l implements com.baidu.tbadk.mvc.b.l {
    public void b(w wVar) {
        if (wVar != null) {
            this.bZW.setCurScore(wVar.getCurScore());
            this.bZW.setLevelupScore(wVar.getLevelupScore());
            this.bZW.setLike(wVar.isLike());
            this.bZW.setUser_level(wVar.ana());
            this.bZW.setLevelName(wVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.bZW.setSignData(signData);
        }
    }

    public void a(AnchorPower anchorPower) {
        this.bZW.setAnchorPower(anchorPower);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(com.baidu.tbadk.core.data.v vVar) {
        if (this.threadList != null) {
            while (!this.threadList.isEmpty() && this.threadList.get(0) != null && (this.threadList.get(0) instanceof com.baidu.tbadk.core.data.v) && ((com.baidu.tbadk.core.data.v) this.threadList.get(0)).getIs_top() == 2) {
                this.threadList.remove(0);
            }
        }
        this.threadList.add(0, vVar);
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null && !StringUtils.isNull(nVar.getId()) && this.threadList != null) {
            int Nj = Nj();
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.u uVar = threadList.get(i);
                    if (uVar instanceof com.baidu.tbadk.core.data.l) {
                        Nj++;
                    }
                    if ((uVar instanceof com.baidu.tbadk.core.data.v) && nVar.getId().equals(((com.baidu.tbadk.core.data.v) uVar).getId())) {
                        return;
                    }
                }
            }
            this.threadList.add(Nj, nVar);
        }
    }

    public int apj() {
        int i = 0;
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = threadList.get(i2) instanceof com.baidu.tbadk.core.data.n ? i + 1 : i;
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

    public void aN(Context context) {
        BannerListData bannerListData;
        int i;
        if (this.bZW != null && (bannerListData = this.bZW.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && this.threadList != null && this.threadList.size() > 0) {
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
                if (next instanceof com.baidu.tbadk.core.data.v) {
                    com.baidu.tbadk.core.data.v vVar = (com.baidu.tbadk.core.data.v) next;
                    if (vVar.getIs_top() != 0 || vVar.sl() == 1) {
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
                    int i6 = ((cVar.Un + i3) - 1) + i5;
                    if (!hashSet.contains(Integer.valueOf(i6)) && cVar != null) {
                        if (!cVar.rv()) {
                            i = i5;
                        } else if (i6 >= size2) {
                            i = i5;
                        } else if (cVar.rw()) {
                            if (af.isInstalledPackage(context, cVar.Um)) {
                                i = i5;
                            } else if (!TextUtils.isEmpty(cVar.Um) && !TextUtils.isEmpty(cVar.Ui)) {
                                boolean eu = com.baidu.tbadk.download.b.Ap().eu(cVar.Um);
                                boolean ev = com.baidu.tbadk.download.b.Ap().ev(cVar.Um);
                                if (eu) {
                                    cVar.Ug = 1;
                                } else if (ev) {
                                    cVar.Ug = 2;
                                } else {
                                    cVar.Ug = 0;
                                }
                                hashSet.add(Integer.valueOf(i6));
                                this.threadList.add(i6, cVar);
                                i = i5 + 1;
                            }
                        } else if (cVar.rx()) {
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

    public void apk() {
        boolean z = true;
        int i = 0;
        if (this.bZW != null && this.bWc != null && this.bWc.rR() == 1) {
            if (this.cHc == null || !this.cHc.apn()) {
                z = false;
            }
            if (this.cHa || z) {
                y yVar = new y();
                yVar.fw(this.cHa);
                yVar.ks(this.cHb);
                yVar.b(this.cHc);
                yVar.bz(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.u next = it.next();
                        if ((next instanceof com.baidu.tbadk.core.data.v) && ((com.baidu.tbadk.core.data.v) next).getIs_top() != 0) {
                            i++;
                        }
                    }
                    this.threadList.add(i, yVar);
                }
            }
        }
    }

    public void apl() {
        if (acG() != null && TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            a(acG().getAnchorPower());
            ArrayList<LiveCardData> apa = apa();
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (apa != null && apa.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!(threadList.get(i) instanceof com.baidu.tbadk.core.data.l)) {
                        i++;
                    } else {
                        threadList.remove(i);
                        break;
                    }
                }
                int Nj = Nj();
                com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
                lVar.i(apa);
                getThreadList().add(Nj, lVar);
            }
        }
    }

    public void apm() {
        com.baidu.tbadk.core.data.q recommendLikeUser;
        int g;
        int i;
        if (this.bZW != null && (recommendLikeUser = this.bZW.getRecommendLikeUser()) != null && recommendLikeUser.rZ() != null && !TextUtils.isEmpty(recommendLikeUser.rZ().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.u next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.v) && ((com.baidu.tbadk.core.data.v) next).getIs_top() != 0) {
                    i2++;
                }
            }
            String rY = recommendLikeUser.rY();
            if (!TextUtils.isEmpty(rY) && !TextUtils.isEmpty(rY.trim()) && (g = com.baidu.adp.lib.g.b.g(rY, -1)) != -1 && (g + i2) - 1 < size && i >= 0 && !(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.c)) {
                if (i - 1 < 0 || !(this.threadList.get(i - 1) instanceof com.baidu.tbadk.core.data.c)) {
                    this.threadList.add(i, recommendLikeUser);
                }
            }
        }
    }

    public com.baidu.tbadk.core.data.v ko(String str) {
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

    public void f(com.baidu.tbadk.core.data.v vVar) {
        this.threadList.remove(vVar);
    }

    public boolean d(l lVar) {
        if (lVar == null) {
            return false;
        }
        c(lVar.rM());
        a(lVar.aoX());
        fu(lVar.aoT());
        km(lVar.aoU());
        c(lVar.acG());
        setGameName(lVar.getGameName());
        kn(lVar.apb());
        a(lVar.aoV());
        fv(lVar.aoY());
        hB(lVar.acL());
        Y(lVar.apa());
        a(lVar.getPage());
        a(lVar.aoR());
        bh(lVar.aoZ());
        X(lVar.getThreadList());
        bg(lVar.aoW());
        h(lVar.getUserData());
        setUserMap(lVar.getUserMap());
        b(lVar.aoS());
        bi(lVar.apc());
        return true;
    }
}
