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
            ahVar.id(gVar.level);
            ahVar.setLevelName(gVar.ckG);
            ahVar.setCurScore(gVar.cur_score);
            ahVar.setLevelupScore(gVar.levelup_score);
            a(ahVar);
        }
    }

    public void a(ah ahVar) {
        if (ahVar != null) {
            this.bHo.setCurScore(ahVar.getCurScore());
            this.bHo.setLevelupScore(ahVar.getLevelupScore());
            this.bHo.setLike(ahVar.isLike());
            this.bHo.setUser_level(ahVar.aiO());
            this.bHo.setLevelName(ahVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.bHo.setSignData(signData);
        }
    }

    public void a(AnchorPower anchorPower) {
        this.bHo.setAnchorPower(anchorPower);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(com.baidu.tbadk.core.data.w wVar) {
        if (this.threadList != null) {
            while (!this.threadList.isEmpty() && this.threadList.get(0) != null && (this.threadList.get(0) instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) this.threadList.get(0)).getIs_top() == 2) {
                this.threadList.remove(0);
            }
        }
        this.threadList.add(0, wVar);
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null && !StringUtils.isNull(oVar.getId()) && this.threadList != null) {
            int akX = akX();
            ArrayList<com.baidu.adp.widget.ListView.ai> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.ai aiVar = threadList.get(i);
                    if (aiVar instanceof com.baidu.tbadk.core.data.m) {
                        akX++;
                    }
                    if ((aiVar instanceof com.baidu.tbadk.core.data.w) && oVar.getId().equals(((com.baidu.tbadk.core.data.w) aiVar).getId())) {
                        return;
                    }
                }
            }
            this.threadList.add(akX, oVar);
        }
    }

    public int akW() {
        int i = 0;
        ArrayList<com.baidu.adp.widget.ListView.ai> threadList = getThreadList();
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

    public int akX() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.ai> it = this.threadList.iterator();
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
        if (this.bHo != null && (bannerListData = this.bHo.getBannerListData()) != null && bannerListData.pU() != null && this.threadList != null && this.threadList.size() > 0) {
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
            Iterator<com.baidu.adp.widget.ListView.ai> it = this.threadList.iterator();
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
                    int i6 = ((cVar.Pe + i3) - 1) + i5;
                    if (!hashSet.contains(Integer.valueOf(i6)) && cVar != null) {
                        if (!cVar.pO()) {
                            i = i5;
                        } else if (i6 >= size2) {
                            i = i5;
                        } else if (cVar.pP()) {
                            if (au.isInstalledPackage(context, cVar.Pd)) {
                                i = i5;
                            } else if (!TextUtils.isEmpty(cVar.Pd) && !TextUtils.isEmpty(cVar.OZ)) {
                                boolean ea = com.baidu.tbadk.download.b.yr().ea(cVar.Pd);
                                boolean eb = com.baidu.tbadk.download.b.yr().eb(cVar.Pd);
                                if (ea) {
                                    cVar.OX = 1;
                                } else if (eb) {
                                    cVar.OX = 2;
                                } else {
                                    cVar.OX = 0;
                                }
                                hashSet.add(Integer.valueOf(i6));
                                this.threadList.add(i6, cVar);
                                i = i5 + 1;
                            }
                        } else if (cVar.pQ()) {
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

    public void akY() {
        boolean z = true;
        int i = 0;
        if (this.bHo != null && this.bDp != null && this.bDp.qj() == 1) {
            if (this.cll == null || !this.cll.alb()) {
                z = false;
            }
            if (this.clj || z) {
                aj ajVar = new aj();
                ajVar.eK(this.clj);
                ajVar.iD(this.clk);
                ajVar.b(this.cll);
                ajVar.bt(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.ai> it = this.threadList.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.ai next = it.next();
                        if ((next instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) next).getIs_top() != 0) {
                            i++;
                        }
                    }
                    this.threadList.add(i, ajVar);
                }
            }
        }
    }

    public void akZ() {
        if (Za() != null && TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            a(Za().getAnchorPower());
            ArrayList<LiveCardData> akM = akM();
            ArrayList<com.baidu.adp.widget.ListView.ai> threadList = getThreadList();
            if (akM != null && akM.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!(threadList.get(i) instanceof com.baidu.tbadk.core.data.m)) {
                        i++;
                    } else {
                        threadList.remove(i);
                        break;
                    }
                }
                int akX = akX();
                com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
                mVar.k(akM);
                getThreadList().add(akX, mVar);
            }
        }
    }

    public void ala() {
        com.baidu.tbadk.core.data.s recommendLikeUser;
        int i;
        int i2;
        if (this.bHo != null && (recommendLikeUser = this.bHo.getRecommendLikeUser()) != null && recommendLikeUser.qq() != null && !TextUtils.isEmpty(recommendLikeUser.qq().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.ai> it = this.threadList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.ai next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) next).getIs_top() != 0) {
                    i3++;
                }
            }
            String qp = recommendLikeUser.qp();
            if (!TextUtils.isEmpty(qp) && !TextUtils.isEmpty(qp.trim()) && (i = com.baidu.adp.lib.g.c.toInt(qp, -1)) != -1 && (i + i3) - 1 < size && i2 >= 0 && !(this.threadList.get(i2) instanceof com.baidu.tbadk.core.data.c)) {
                if (i2 - 1 < 0 || !(this.threadList.get(i2 - 1) instanceof com.baidu.tbadk.core.data.c)) {
                    this.threadList.add(i2, recommendLikeUser);
                }
            }
        }
    }

    public com.baidu.tbadk.core.data.w iz(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.ai> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.ai next = it.next();
            if (next != null && (next instanceof com.baidu.tbadk.core.data.w) && TextUtils.equals(str, ((com.baidu.tbadk.core.data.w) next).getId())) {
                return (com.baidu.tbadk.core.data.w) next;
            }
        }
        return null;
    }

    public void f(com.baidu.tbadk.core.data.w wVar) {
        this.threadList.remove(wVar);
    }

    public boolean d(u uVar) {
        if (uVar == null) {
            return false;
        }
        b(uVar.qe());
        a(uVar.akJ());
        eI(uVar.akG());
        ix(uVar.akH());
        c(uVar.Za());
        setGameName(uVar.getGameName());
        iy(uVar.akN());
        a(uVar.akI());
        eJ(uVar.akK());
        gG(uVar.Zf());
        W(uVar.akM());
        b(uVar.XQ());
        a(uVar.akF());
        aZ(uVar.akL());
        V(uVar.getThreadList());
        aY(uVar.akE());
        k(uVar.getUserData());
        setUserMap(uVar.getUserMap());
        return true;
    }
}
