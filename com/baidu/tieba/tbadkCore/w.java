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
            ahVar.iz(gVar.level);
            ahVar.setLevelName(gVar.coG);
            ahVar.setCurScore(gVar.cur_score);
            ahVar.setLevelupScore(gVar.levelup_score);
            a(ahVar);
        }
    }

    public void a(ah ahVar) {
        if (ahVar != null) {
            this.bJD.setCurScore(ahVar.getCurScore());
            this.bJD.setLevelupScore(ahVar.getLevelupScore());
            this.bJD.setLike(ahVar.isLike());
            this.bJD.setUser_level(ahVar.aky());
            this.bJD.setLevelName(ahVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.bJD.setSignData(signData);
        }
    }

    public void a(AnchorPower anchorPower) {
        this.bJD.setAnchorPower(anchorPower);
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
            int amI = amI();
            ArrayList<com.baidu.adp.widget.ListView.ai> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.ai aiVar = threadList.get(i);
                    if (aiVar instanceof com.baidu.tbadk.core.data.m) {
                        amI++;
                    }
                    if ((aiVar instanceof com.baidu.tbadk.core.data.w) && oVar.getId().equals(((com.baidu.tbadk.core.data.w) aiVar).getId())) {
                        return;
                    }
                }
            }
            this.threadList.add(amI, oVar);
        }
    }

    public int amH() {
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

    public int amI() {
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

    public void aG(Context context) {
        com.baidu.tbadk.core.data.f bannerListData;
        int i;
        if (this.bJD != null && (bannerListData = this.bJD.getBannerListData()) != null && bannerListData.qA() != null && this.threadList != null && this.threadList.size() > 0) {
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
                    if (wVar.getIs_top() != 0 || wVar.ri() == 1) {
                        i3++;
                    }
                }
            }
            int size3 = bannerListData.qA().size();
            if (size3 >= 1) {
                HashSet hashSet = new HashSet();
                int i4 = 0;
                int i5 = 0;
                while (i4 < size3) {
                    com.baidu.tbadk.core.data.c cVar = bannerListData.qA().get(i4);
                    int i6 = ((cVar.Py + i3) - 1) + i5;
                    if (!hashSet.contains(Integer.valueOf(i6)) && cVar != null) {
                        if (!cVar.qu()) {
                            i = i5;
                        } else if (i6 >= size2) {
                            i = i5;
                        } else if (cVar.qv()) {
                            if (au.isInstalledPackage(context, cVar.Px)) {
                                i = i5;
                            } else if (!TextUtils.isEmpty(cVar.Px) && !TextUtils.isEmpty(cVar.Pt)) {
                                boolean er = com.baidu.tbadk.download.b.ze().er(cVar.Px);
                                boolean es = com.baidu.tbadk.download.b.ze().es(cVar.Px);
                                if (er) {
                                    cVar.Pr = 1;
                                } else if (es) {
                                    cVar.Pr = 2;
                                } else {
                                    cVar.Pr = 0;
                                }
                                hashSet.add(Integer.valueOf(i6));
                                this.threadList.add(i6, cVar);
                                i = i5 + 1;
                            }
                        } else if (cVar.qw()) {
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

    public void amJ() {
        boolean z = true;
        int i = 0;
        if (this.bJD != null && this.bGk != null && this.bGk.qP() == 1) {
            if (this.cpk == null || !this.cpk.amM()) {
                z = false;
            }
            if (this.cpi || z) {
                aj ajVar = new aj();
                ajVar.fe(this.cpi);
                ajVar.jw(this.cpj);
                ajVar.b(this.cpk);
                ajVar.bq(1003);
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

    public void amK() {
        if (aar() != null && TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            a(aar().getAnchorPower());
            ArrayList<LiveCardData> amx = amx();
            ArrayList<com.baidu.adp.widget.ListView.ai> threadList = getThreadList();
            if (amx != null && amx.size() > 0 && threadList != null && threadList.size() > 0) {
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
                int amI = amI();
                com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
                mVar.j(amx);
                getThreadList().add(amI, mVar);
            }
        }
    }

    public void amL() {
        com.baidu.tbadk.core.data.s recommendLikeUser;
        int i;
        int i2;
        if (this.bJD != null && (recommendLikeUser = this.bJD.getRecommendLikeUser()) != null && recommendLikeUser.qW() != null && !TextUtils.isEmpty(recommendLikeUser.qW().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.ai> it = this.threadList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.ai next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) next).getIs_top() != 0) {
                    i3++;
                }
            }
            String qV = recommendLikeUser.qV();
            if (!TextUtils.isEmpty(qV) && !TextUtils.isEmpty(qV.trim()) && (i = com.baidu.adp.lib.g.c.toInt(qV, -1)) != -1 && (i + i3) - 1 < size && i2 >= 0 && !(this.threadList.get(i2) instanceof com.baidu.tbadk.core.data.c)) {
                if (i2 - 1 < 0 || !(this.threadList.get(i2 - 1) instanceof com.baidu.tbadk.core.data.c)) {
                    this.threadList.add(i2, recommendLikeUser);
                }
            }
        }
    }

    public com.baidu.tbadk.core.data.w js(String str) {
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
        b(uVar.qK());
        a(uVar.amu());
        fc(uVar.amq());
        jq(uVar.amr());
        c(uVar.aar());
        setGameName(uVar.getGameName());
        jr(uVar.amy());
        a(uVar.ams());
        fd(uVar.amv());
        gX(uVar.aaw());
        S(uVar.amx());
        a(uVar.Zp());
        a(uVar.amp());
        ba(uVar.amw());
        R(uVar.getThreadList());
        aZ(uVar.amt());
        k(uVar.getUserData());
        setUserMap(uVar.getUserMap());
        return true;
    }
}
