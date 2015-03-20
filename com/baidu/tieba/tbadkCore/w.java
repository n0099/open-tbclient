package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.SignData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import tbclient.FrsPage.AnchorPower;
/* loaded from: classes.dex */
public class w extends u implements com.baidu.tbadk.mvc.b.m {
    public void a(g gVar) {
        if (gVar != null) {
            ah ahVar = new ah();
            ahVar.setLike(1);
            ahVar.ia(gVar.level);
            ahVar.setLevelName(gVar.ckq);
            ahVar.setCurScore(gVar.cur_score);
            ahVar.setLevelupScore(gVar.levelup_score);
            a(ahVar);
        }
    }

    public void a(ah ahVar) {
        if (ahVar != null) {
            this.bHb.setCurScore(ahVar.getCurScore());
            this.bHb.setLevelupScore(ahVar.getLevelupScore());
            this.bHb.setLike(ahVar.isLike());
            this.bHb.setUser_level(ahVar.aiz());
            this.bHb.setLevelName(ahVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.bHb.setSignData(signData);
        }
    }

    public void a(AnchorPower anchorPower) {
        this.bHb.setAnchorPower(anchorPower);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(com.baidu.tbadk.core.data.w wVar) {
        if (this.ckR != null) {
            while (!this.ckR.isEmpty() && this.ckR.get(0) != null && (this.ckR.get(0) instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) this.ckR.get(0)).getIs_top() == 2) {
                this.ckR.remove(0);
            }
        }
        this.ckR.add(0, wVar);
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null && !StringUtils.isNull(oVar.getId()) && this.ckR != null) {
            int akI = akI();
            ArrayList<com.baidu.adp.widget.ListView.ai> akp = akp();
            if (akp != null && akp.size() > 0) {
                int size = akp.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.ai aiVar = akp.get(i);
                    if (aiVar instanceof com.baidu.tbadk.core.data.m) {
                        akI++;
                    }
                    if ((aiVar instanceof com.baidu.tbadk.core.data.w) && oVar.getId().equals(((com.baidu.tbadk.core.data.w) aiVar).getId())) {
                        return;
                    }
                }
            }
            this.ckR.add(akI, oVar);
        }
    }

    public int akH() {
        int i = 0;
        ArrayList<com.baidu.adp.widget.ListView.ai> akp = akp();
        if (akp != null && akp.size() > 0) {
            int size = akp.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = akp.get(i2) instanceof com.baidu.tbadk.core.data.o ? i + 1 : i;
                i2++;
                i = i3;
            }
        }
        return i;
    }

    public int akI() {
        if (this.ckR == null || this.ckR.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.ai> it = this.ckR.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.ai next = it.next();
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

    public void aB(Context context) {
        com.baidu.tbadk.core.data.f bannerListData;
        int i;
        if (this.bHb != null && (bannerListData = this.bHb.getBannerListData()) != null && bannerListData.pU() != null && this.ckR != null && this.ckR.size() > 0) {
            int size = this.ckR.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (!(this.ckR.get(i2) instanceof com.baidu.tbadk.core.data.c)) {
                    i2++;
                } else {
                    this.ckR.remove(i2);
                    break;
                }
            }
            int size2 = this.ckR.size();
            Iterator<com.baidu.adp.widget.ListView.ai> it = this.ckR.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.ai next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.w) {
                    com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) next;
                    if (wVar.getIs_top() != 0 || wVar.qC() == 1) {
                        i3++;
                    }
                }
            }
            int size3 = bannerListData.pU().size();
            if (size3 >= 1) {
                HashSet hashSet = new HashSet();
                int i4 = 0;
                int i5 = 0;
                while (i4 < size3) {
                    com.baidu.tbadk.core.data.c cVar = bannerListData.pU().get(i4);
                    int i6 = ((cVar.Pc + i3) - 1) + i5;
                    if (!hashSet.contains(Integer.valueOf(i6)) && cVar != null) {
                        if (!cVar.pO()) {
                            i = i5;
                        } else if (i6 >= size2) {
                            i = i5;
                        } else if (cVar.pP()) {
                            if (au.isInstalledPackage(context, cVar.Pb)) {
                                i = i5;
                            } else if (!TextUtils.isEmpty(cVar.Pb) && !TextUtils.isEmpty(cVar.OX)) {
                                boolean dX = com.baidu.tbadk.download.b.yl().dX(cVar.Pb);
                                boolean dY = com.baidu.tbadk.download.b.yl().dY(cVar.Pb);
                                if (dX) {
                                    cVar.OV = 1;
                                } else if (dY) {
                                    cVar.OV = 2;
                                } else {
                                    cVar.OV = 0;
                                }
                                hashSet.add(Integer.valueOf(i6));
                                this.ckR.add(i6, cVar);
                                i = i5 + 1;
                            }
                        } else if (cVar.pQ()) {
                            hashSet.add(Integer.valueOf(i6));
                            this.ckR.add(i6, cVar);
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

    public void akJ() {
        boolean z = true;
        int i = 0;
        if (this.bHb != null && this.bDc != null && this.bDc.qj() == 1) {
            if (this.ckV == null || !this.ckV.akM()) {
                z = false;
            }
            if (this.ckT || z) {
                aj ajVar = new aj();
                ajVar.eM(this.ckT);
                ajVar.iA(this.ckU);
                ajVar.b(this.ckV);
                ajVar.bt(1003);
                if (this.ckR != null && this.ckR.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.ai> it = this.ckR.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.ai next = it.next();
                        if ((next instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) next).getIs_top() != 0) {
                            i++;
                        }
                    }
                    this.ckR.add(i, ajVar);
                }
            }
        }
    }

    public void akK() {
        if (YO() != null && TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            a(YO().getAnchorPower());
            ArrayList<LiveCardData> akx = akx();
            ArrayList<com.baidu.adp.widget.ListView.ai> akp = akp();
            if (akx != null && akx.size() > 0 && akp != null && akp.size() > 0) {
                int size = akp.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!(akp.get(i) instanceof com.baidu.tbadk.core.data.m)) {
                        i++;
                    } else {
                        akp.remove(i);
                        break;
                    }
                }
                int akI = akI();
                com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
                mVar.k(akx);
                akp().add(akI, mVar);
            }
        }
    }

    public void akL() {
        com.baidu.tbadk.core.data.s recommendLikeUser;
        int i;
        int i2;
        if (this.bHb != null && (recommendLikeUser = this.bHb.getRecommendLikeUser()) != null && recommendLikeUser.qq() != null && !TextUtils.isEmpty(recommendLikeUser.qq().getName()) && this.ckR != null && this.ckR.size() > 0) {
            int size = this.ckR.size();
            Iterator<com.baidu.adp.widget.ListView.ai> it = this.ckR.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.ai next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) next).getIs_top() != 0) {
                    i3++;
                }
            }
            String qp = recommendLikeUser.qp();
            if (!TextUtils.isEmpty(qp) && !TextUtils.isEmpty(qp.trim()) && (i = com.baidu.adp.lib.g.c.toInt(qp, -1)) != -1 && (i + i3) - 1 < size && i2 >= 0 && !(this.ckR.get(i2) instanceof com.baidu.tbadk.core.data.c)) {
                if (i2 - 1 < 0 || !(this.ckR.get(i2 - 1) instanceof com.baidu.tbadk.core.data.c)) {
                    this.ckR.add(i2, recommendLikeUser);
                }
            }
        }
    }

    public com.baidu.tbadk.core.data.w iw(String str) {
        if (this.ckR == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.ai> it = this.ckR.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.ai next = it.next();
            if (next != null && (next instanceof com.baidu.tbadk.core.data.w) && TextUtils.equals(str, ((com.baidu.tbadk.core.data.w) next).getId())) {
                return (com.baidu.tbadk.core.data.w) next;
            }
        }
        return null;
    }

    public void f(com.baidu.tbadk.core.data.w wVar) {
        this.ckR.remove(wVar);
    }

    public boolean d(u uVar) {
        if (uVar == null) {
            return false;
        }
        b(uVar.qe());
        a(uVar.aku());
        eK(uVar.akr());
        iu(uVar.aks());
        c(uVar.YO());
        setGameName(uVar.getGameName());
        iv(uVar.aky());
        a(uVar.akt());
        eL(uVar.akv());
        gE(uVar.YT());
        U(uVar.akx());
        b(uVar.XE());
        a(uVar.akq());
        aV(uVar.akw());
        T(uVar.akp());
        k(uVar.getUserData());
        setUserMap(uVar.getUserMap());
        return true;
    }
}
