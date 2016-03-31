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
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class o extends m implements com.baidu.tbadk.mvc.b.l {
    private int enU = 0;

    public void c(x xVar) {
        if (xVar != null) {
            this.dcG.setCurScore(xVar.getCurScore());
            this.dcG.setLevelupScore(xVar.getLevelupScore());
            this.dcG.setLike(xVar.isLike());
            this.dcG.setUser_level(xVar.getUserLevel());
            this.dcG.setLevelName(xVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.dcG.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.dcG == null) {
            return null;
        }
        return this.dcG.getSignData();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k(as asVar) {
        if (this.threadList != null) {
            while (!this.threadList.isEmpty() && this.threadList.get(0) != null && (this.threadList.get(0) instanceof as) && ((as) this.threadList.get(0)).getIs_top() == 2) {
                this.threadList.remove(0);
            }
        }
        this.threadList.add(0, asVar);
    }

    public void a(com.baidu.tbadk.core.data.aa aaVar) {
        if (aaVar != null && !StringUtils.isNull(aaVar.getId()) && this.threadList != null) {
            int To = To();
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.u uVar = threadList.get(i);
                    if ((uVar instanceof as) && aaVar.getId().equals(((as) uVar).getId())) {
                        return;
                    }
                }
            }
            if (aaVar.isPhotoLiveThread()) {
                am amVar = new am();
                amVar.a(aaVar, -1).setPostNum(1);
                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.enU++;
                    this.threadList.add(To, amVar);
                    return;
                }
                return;
            }
            this.enU++;
            this.threadList.add(To, aaVar);
        }
    }

    public void aSg() {
        this.enU = 0;
    }

    public int aSh() {
        return this.enU;
    }

    public int aSi() {
        int i = 0;
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
        if (threadList != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = threadList.get(i2) instanceof com.baidu.tbadk.core.data.aa ? i + 1 : i;
                i2++;
                i = i3;
            }
        }
        return i;
    }

    public int To() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.u next = it.next();
            if (next instanceof as) {
                if (((as) next).getIs_top() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int th() {
        Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.u next = it.next();
            if ((next instanceof as) && ((as) next).tn() == 1) {
                return ((as) next).th();
            }
        }
        return -1;
    }

    public void aSj() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.cxM != null && this.cxM.so() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.u uVar = this.threadList.get(i2);
                if ((uVar instanceof as) && uVar.getType() == as.VN) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int To = To();
            if (i > To) {
                this.threadList.add(To, this.threadList.remove(i));
            }
        }
    }

    public void aK(Context context) {
        BannerListData bannerListData;
        int g;
        if (this.dcG != null && (bannerListData = this.dcG.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    if (!(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.c)) {
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
                if ((next instanceof as) && ((as) next).getIs_top() != 0) {
                    i2++;
                }
            }
            int size3 = bannerListData.getAllAdvertList().size();
            if (size3 >= 1) {
                int i3 = size2 - i2;
                HashSet hashSet = new HashSet();
                for (int i4 = 0; i4 < size3; i4++) {
                    com.baidu.tbadk.core.data.c cVar = bannerListData.getAllAdvertList().get(i4);
                    if (cVar != null && cVar.rk() && (com.baidu.adp.lib.h.b.g(cVar.Sf, 0) + i2) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && (g < size2 || i3 <= 3)) {
                        if (cVar.rl()) {
                            if (!ag.isInstalledPackage(context, cVar.Se) && !TextUtils.isEmpty(cVar.Se) && !TextUtils.isEmpty(cVar.Sa)) {
                                boolean fd = com.baidu.tbadk.download.b.CX().fd(cVar.Se);
                                boolean fg = com.baidu.tbadk.download.b.CX().fg(cVar.Se);
                                if (fd) {
                                    cVar.RY = 1;
                                } else if (fg) {
                                    cVar.RY = 2;
                                } else {
                                    cVar.RY = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                if (g < size2) {
                                    this.threadList.add(g, cVar);
                                } else if (g == size2) {
                                    this.threadList.add(cVar);
                                }
                            }
                        } else if (cVar.rm()) {
                            hashSet.add(Integer.valueOf(g));
                            if (g < size2) {
                                this.threadList.add(g, cVar);
                            } else if (g == size2) {
                                this.threadList.add(cVar);
                            }
                        }
                    }
                }
            }
        }
    }

    public void N(Context context, String str) {
        com.baidu.tbadk.core.data.b adKillerData;
        com.baidu.tbadk.core.data.c rj;
        ArrayList<com.baidu.tbadk.core.data.c> allAdvertList;
        if (this.dcG != null) {
            BannerListData bannerListData = this.dcG.getBannerListData();
            if ((bannerListData == null || (allAdvertList = bannerListData.getAllAdvertList()) == null || allAdvertList.size() <= 0) && (adKillerData = this.dcG.getAdKillerData()) != null && adKillerData.rh() != null) {
                List<b.a> rh = adKillerData.rh();
                if (rh.size() != 0 && this.threadList != null && this.threadList.size() > 0) {
                    int size = this.threadList.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (!(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.c)) {
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
                        if ((next instanceof as) && ((as) next).getIs_top() != 0) {
                            i2++;
                        }
                    }
                    int size3 = rh.size();
                    if (size3 >= 1) {
                        int i3 = size2 - i2;
                        HashSet hashSet = new HashSet();
                        for (int i4 = 0; i4 < size3; i4++) {
                            b.a aVar = rh.get(i4);
                            if (aVar != null && (rj = aVar.rj()) != null && rj.rk()) {
                                rj.Sp = true;
                                rj.Ss = aVar.ri() == 1;
                                rj.Sq = aVar.getUrl();
                                rj.Sr = aVar.getTag();
                                rj.setFid(com.baidu.adp.lib.h.b.c(str, 0L));
                                int g = (com.baidu.adp.lib.h.b.g(rj.Sf, 0) + i2) - 1;
                                if (g >= 0 && !hashSet.contains(Integer.valueOf(g)) && (g < size2 || i3 <= 3)) {
                                    if (rj.rl()) {
                                        if (!ag.isInstalledPackage(context, rj.Se) && !TextUtils.isEmpty(rj.Se) && !TextUtils.isEmpty(rj.Sa)) {
                                            boolean fd = com.baidu.tbadk.download.b.CX().fd(rj.Se);
                                            boolean fg = com.baidu.tbadk.download.b.CX().fg(rj.Se);
                                            if (fd) {
                                                rj.RY = 1;
                                            } else if (fg) {
                                                rj.RY = 2;
                                            } else {
                                                rj.RY = 0;
                                            }
                                            hashSet.add(Integer.valueOf(g));
                                            if (g < size2) {
                                                this.threadList.add(g, rj);
                                            } else if (g == size2) {
                                                this.threadList.add(rj);
                                            }
                                        }
                                    } else if (rj.rm()) {
                                        hashSet.add(Integer.valueOf(g));
                                        if (g < size2) {
                                            this.threadList.add(g, rj);
                                        } else if (g == size2) {
                                            this.threadList.add(rj);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void aSk() {
        boolean z = true;
        int i = 0;
        if (this.dcG != null && this.cxM != null && this.cxM.so() == 1) {
            if (this.enn == null || !this.enn.aSu()) {
                z = false;
            }
            if (this.enl || z) {
                z zVar = new z();
                zVar.iI(this.enl);
                zVar.nR(this.enm);
                zVar.b(this.enn);
                zVar.bW(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.u next = it.next();
                        if ((next instanceof as) && ((as) next).getIs_top() != 0) {
                            i++;
                        }
                    }
                    this.threadList.add(i, zVar);
                }
            }
        }
    }

    public void aSl() {
        int size = this.threadList.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.adp.widget.ListView.u uVar = this.threadList.get(i2);
            if (uVar instanceof as) {
                as asVar = (as) uVar;
                if (asVar.isPhotoLiveThread() && !(asVar instanceof am)) {
                    am amVar = new am();
                    amVar.a(asVar, i);
                    int showStyle = amVar.sT() != null ? amVar.sT().getShowStyle() : i;
                    if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i2, amVar);
                    }
                    i = showStyle;
                }
            }
        }
    }

    public void aSm() {
        int i;
        if (avu() != null) {
            List<PhotoLiveCardData> aRN = aRN();
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (aRN != null && aRN.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof com.baidu.tbadk.core.data.ae)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int pl = pl(i);
                com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
                aeVar.m(aRN);
                getThreadList().add(pl, aeVar);
            }
        }
    }

    private int pl(int i) {
        int To = To();
        int aRT = aRT();
        if (aRQ()) {
            aRT++;
        }
        return Math.min((aRT + To) - 1, i);
    }

    public void aSn() {
        as aRX;
        ArrayList<com.baidu.adp.widget.ListView.u> threadList;
        int i;
        if (avu() != null && (aRX = aRX()) != null && (threadList = getThreadList()) != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = size;
                    break;
                } else if (!(threadList.get(i2) instanceof com.baidu.tbadk.core.data.ae)) {
                    i2++;
                } else {
                    threadList.remove(i2);
                    i = size - 1;
                    break;
                }
            }
            threadList.add(pl(i), aRX);
        }
    }

    public void aSo() {
        if (aRQ()) {
            int To = To();
            if (th() == 0) {
                To++;
            }
            com.baidu.tbadk.core.data.af afVar = new com.baidu.tbadk.core.data.af();
            afVar.a(aRR());
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(To, afVar);
            }
        }
    }

    public void aSp() {
        com.baidu.tbadk.core.data.r aRS;
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.vk().getLong("frs_storecard_closetime", 0L) >= 86400000 && (aRS = aRS()) != null) {
            int To = To();
            int th = th();
            if (th == 0 || th == 1) {
                To++;
            }
            ArrayList<com.baidu.adp.widget.ListView.u> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(To, aRS);
            }
        }
    }

    public void aSq() {
        com.baidu.tbadk.core.data.ai recommendLikeUser;
        int g;
        int i;
        if (this.dcG != null && (recommendLikeUser = this.dcG.getRecommendLikeUser()) != null && recommendLikeUser.sz() != null && !TextUtils.isEmpty(recommendLikeUser.sz().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.u next = it.next();
                if ((next instanceof as) && ((as) next).getIs_top() != 0) {
                    i2++;
                }
            }
            String sy = recommendLikeUser.sy();
            if (!TextUtils.isEmpty(sy) && !TextUtils.isEmpty(sy.trim()) && (g = com.baidu.adp.lib.h.b.g(sy, -1)) != -1 && (g + i2) - 1 < size && i >= 0 && !(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.c)) {
                if (i - 1 < 0 || !(this.threadList.get(i - 1) instanceof com.baidu.tbadk.core.data.c)) {
                    this.threadList.add(i, recommendLikeUser);
                }
            }
        }
    }

    public as nN(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.u> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.u next = it.next();
            if (next != null && (next instanceof as) && TextUtils.equals(str, ((as) next).getId())) {
                return (as) next;
            }
        }
        return null;
    }

    public void l(as asVar) {
        this.threadList.remove(asVar);
    }

    public boolean d(m mVar) {
        if (mVar == null) {
            return false;
        }
        d(mVar.sf());
        a(mVar.aRK());
        iG(mVar.aRG());
        nJ(mVar.aRH());
        c(mVar.avu());
        setGameName(mVar.getGameName());
        nK(mVar.aRO());
        a(mVar.aRI());
        iH(mVar.aRL());
        kB(mVar.avC());
        cr(mVar.aRN());
        pj(mVar.aRT());
        c(mVar.aRR());
        b(mVar.getPage());
        a(mVar.aRE());
        cp(mVar.aRM());
        ao(mVar.getThreadList());
        co(mVar.aRJ());
        f(mVar.getUserData());
        setUserMap(mVar.getUserMap());
        b(mVar.aRF());
        cq(mVar.aRP());
        pk(mVar.aRY());
        ct(mVar.aRV());
        nM(mVar.aRW());
        a(mVar.aRS());
        j(mVar.aRX());
        b(mVar.aRZ());
        return true;
    }

    public void aSr() {
        if (this.threadList != null || this.threadList.size() <= 0) {
            int size = this.threadList.size();
            for (int i = 0; i < size; i++) {
                if (this.threadList.get(i) instanceof com.baidu.tbadk.core.data.r) {
                    this.threadList.remove(i);
                    return;
                }
            }
        }
    }

    public void aSs() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.dcG != null && this.dcG.getBannerListData() != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.u uVar = this.threadList.get(i2);
                if (uVar instanceof as) {
                    as asVar = (as) uVar;
                    if (asVar == null || (!asVar.tF() && asVar.tn() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.dcG.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar = new h();
                hVar.setForumId(this.dcG.getId());
                hVar.cn(feedForumList);
                this.threadList.add(i + 6, hVar);
            }
        }
    }

    public boolean aSt() {
        com.baidu.tieba.card.a.x recomTopicData;
        if (this.threadList == null || this.dcG == null || this.dcG.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.u uVar = this.threadList.get(i2);
            if (uVar instanceof as) {
                as asVar = (as) uVar;
                if (asVar == null || (!asVar.tF() && asVar.tn() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.dcG.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.y.p(recomTopicData.aWv) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new aw("c10835").ac("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }
}
