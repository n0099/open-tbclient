package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class o extends m implements com.baidu.tbadk.mvc.b.l {
    private int erm = 0;

    public void c(y yVar) {
        if (yVar != null) {
            this.dfa.setCurScore(yVar.getCurScore());
            this.dfa.setLevelupScore(yVar.getLevelupScore());
            this.dfa.setLike(yVar.isLike());
            this.dfa.setUser_level(yVar.getUserLevel());
            this.dfa.setLevelName(yVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.dfa.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.dfa == null) {
            return null;
        }
        return this.dfa.getSignData();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p(ax axVar) {
        if (this.threadList != null) {
            while (!this.threadList.isEmpty() && this.threadList.get(0) != null && (this.threadList.get(0) instanceof ax) && ((ax) this.threadList.get(0)).getIs_top() == 2) {
                this.threadList.remove(0);
            }
        }
        this.threadList.add(0, axVar);
    }

    public void a(com.baidu.tbadk.core.data.ab abVar) {
        if (abVar != null && !StringUtils.isNull(abVar.getId()) && this.threadList != null) {
            int Tu = Tu();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = threadList.get(i);
                    if ((vVar instanceof ax) && abVar.getId().equals(((ax) vVar).getId())) {
                        return;
                    }
                }
            }
            if (abVar.isPhotoLiveThread()) {
                com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
                agVar.a(abVar, -1);
                agVar.setPost_num(1);
                if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.erm++;
                    this.threadList.add(Tu, agVar);
                    return;
                }
                return;
            }
            this.erm++;
            this.threadList.add(Tu, abVar);
        }
    }

    public void aSI() {
        this.erm = 0;
    }

    public int aSJ() {
        return this.erm;
    }

    public int Tu() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof ax) {
                if (((ax) next).getIs_top() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int qH() {
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if ((next instanceof ax) && ((ax) next).qN() == 1) {
                return ((ax) next).qH();
            }
        }
        return -1;
    }

    public void aSK() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.cyL != null && this.cyL.pI() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if ((vVar instanceof ax) && vVar.getType() == ax.QO) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int Tu = Tu();
            if (i > Tu) {
                this.threadList.add(Tu, this.threadList.remove(i));
            }
        }
    }

    public void aQ(Context context) {
        BannerListData bannerListData;
        int g;
        if (this.dfa != null && (bannerListData = this.dfa.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && this.threadList != null && this.threadList.size() > 0) {
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
            Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if ((next instanceof ax) && ((ax) next).getIs_top() != 0) {
                    i2++;
                }
            }
            int size3 = bannerListData.getAllAdvertList().size();
            if (size3 >= 1) {
                int i3 = size2 - i2;
                HashSet hashSet = new HashSet();
                for (int i4 = 0; i4 < size3; i4++) {
                    com.baidu.tbadk.core.data.c cVar = bannerListData.getAllAdvertList().get(i4);
                    if (cVar != null && cVar.oF() && (com.baidu.adp.lib.h.b.g(cVar.MT, 0) + i2) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && (g < size2 || i3 <= 3)) {
                        if (cVar.oG()) {
                            if (!ah.isInstalledPackage(context, cVar.MS) && !TextUtils.isEmpty(cVar.MS) && !TextUtils.isEmpty(cVar.MO)) {
                                boolean fa = com.baidu.tbadk.download.b.AR().fa(cVar.MS);
                                boolean fd = com.baidu.tbadk.download.b.AR().fd(cVar.MS);
                                if (fa) {
                                    cVar.MM = 1;
                                } else if (fd) {
                                    cVar.MM = 2;
                                } else {
                                    cVar.MM = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                if (g < size2) {
                                    this.threadList.add(g, cVar);
                                } else if (g == size2) {
                                    this.threadList.add(cVar);
                                }
                            }
                        } else if (cVar.oH()) {
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
        com.baidu.tbadk.core.data.c oE;
        ArrayList<com.baidu.tbadk.core.data.c> allAdvertList;
        if (this.dfa != null) {
            BannerListData bannerListData = this.dfa.getBannerListData();
            if ((bannerListData == null || (allAdvertList = bannerListData.getAllAdvertList()) == null || allAdvertList.size() <= 0) && (adKillerData = this.dfa.getAdKillerData()) != null && adKillerData.oC() != null) {
                List<b.a> oC = adKillerData.oC();
                if (oC.size() != 0 && this.threadList != null && this.threadList.size() > 0) {
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
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof ax) && ((ax) next).getIs_top() != 0) {
                            i2++;
                        }
                    }
                    int size3 = oC.size();
                    if (size3 >= 1) {
                        int i3 = size2 - i2;
                        HashSet hashSet = new HashSet();
                        for (int i4 = 0; i4 < size3; i4++) {
                            b.a aVar = oC.get(i4);
                            if (aVar != null && (oE = aVar.oE()) != null && oE.oF()) {
                                oE.Nd = true;
                                oE.Ng = aVar.oD() == 1;
                                oE.Ne = aVar.getUrl();
                                oE.Nf = aVar.getTag();
                                oE.setFid(com.baidu.adp.lib.h.b.c(str, 0L));
                                int g = (com.baidu.adp.lib.h.b.g(oE.MT, 0) + i2) - 1;
                                if (g >= 0 && !hashSet.contains(Integer.valueOf(g)) && (g < size2 || i3 <= 3)) {
                                    if (oE.oG()) {
                                        if (!ah.isInstalledPackage(context, oE.MS) && !TextUtils.isEmpty(oE.MS) && !TextUtils.isEmpty(oE.MO)) {
                                            boolean fa = com.baidu.tbadk.download.b.AR().fa(oE.MS);
                                            boolean fd = com.baidu.tbadk.download.b.AR().fd(oE.MS);
                                            if (fa) {
                                                oE.MM = 1;
                                            } else if (fd) {
                                                oE.MM = 2;
                                            } else {
                                                oE.MM = 0;
                                            }
                                            hashSet.add(Integer.valueOf(g));
                                            if (g < size2) {
                                                this.threadList.add(g, oE);
                                            } else if (g == size2) {
                                                this.threadList.add(oE);
                                            }
                                        }
                                    } else if (oE.oH()) {
                                        hashSet.add(Integer.valueOf(g));
                                        if (g < size2) {
                                            this.threadList.add(g, oE);
                                        } else if (g == size2) {
                                            this.threadList.add(oE);
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

    public void aSL() {
        boolean z = true;
        int i = 0;
        if (this.dfa != null && this.cyL != null && this.cyL.pI() == 1) {
            if (this.eqB == null || !this.eqB.aSZ()) {
                z = false;
            }
            if (this.eqz || z) {
                aa aaVar = new aa();
                aaVar.jx(this.eqz);
                aaVar.nQ(this.eqA);
                aaVar.b(this.eqB);
                aaVar.bH(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof ax) && ((ax) next).getIs_top() != 0) {
                            i++;
                        }
                    }
                    this.threadList.add(i, aaVar);
                }
            }
        }
    }

    public void aSM() {
        if (this.dfa != null) {
            if (((this.dfa.getTopCode() != null && !StringUtils.isNull(this.dfa.getTopCode().rC())) || (this.dfa.getNewsInfo() != null && !StringUtils.isNull(this.dfa.getNewsInfo().rC()))) && this.cyL != null && this.cyL.pI() == 1) {
                aj ajVar = new aj();
                ajVar.a(this.dfa.getTopCode());
                ajVar.a(this.dfa.getNewsInfo());
                ajVar.bH(3);
                ajVar.jy(true);
                if (!com.baidu.tbadk.core.util.y.s(this.threadList)) {
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof ax) && ((ax) next).getIs_top() != 0) {
                            if (((ax) next).getIs_top() == 1003) {
                                ajVar.jy(false);
                            }
                            i++;
                        }
                    }
                    this.threadList.add(i, ajVar);
                }
            }
        }
    }

    public void aSN() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i);
            if (vVar instanceof ax) {
                ax axVar = (ax) vVar;
                if (axVar.isPhotoLiveThread() && !(axVar instanceof com.baidu.tbadk.core.data.ag)) {
                    com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
                    agVar.o(aSm());
                    agVar.a(axVar, 0);
                    if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, agVar);
                    }
                }
            }
        }
    }

    public void aSO() {
        int i;
        if (avD() != null) {
            List<PhotoLiveCardData> aSm = aSm();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (aSm != null && aSm.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof com.baidu.tbadk.core.data.ag)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int pg = pg(i);
                com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
                a(agVar, aSm);
                getThreadList().add(pg, agVar);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.ag agVar, List<PhotoLiveCardData> list) {
        if (agVar != null && !com.baidu.tbadk.core.util.y.s(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            agVar.setThreadType(33);
            agVar.setAuthor(metaData);
            agVar.cs(photoLiveCardData.getForumName());
            agVar.setTitle(photoLiveCardData.getTitle());
            agVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            agVar.cr(new StringBuilder(String.valueOf(photoLiveCardData.getThreadId())).toString());
            agVar.u(photoLiveCardData.getLastModifiedTime());
            agVar.setReply_num(photoLiveCardData.getDiscussNum());
        }
    }

    private int pg(int i) {
        int Tu = Tu();
        int aSs = aSs();
        if (aSp()) {
            aSs++;
        }
        return Math.min((aSs + Tu) - 1, i);
    }

    public void aSP() {
        ax aSw;
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        int i;
        if (avD() != null && (aSw = aSw()) != null && (threadList = getThreadList()) != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = size;
                    break;
                } else if (!(threadList.get(i2) instanceof com.baidu.tbadk.core.data.ag)) {
                    i2++;
                } else {
                    threadList.remove(i2);
                    i = size - 1;
                    break;
                }
            }
            threadList.add(pg(i), aSw);
        }
    }

    public void aSQ() {
        if (aSp()) {
            int Tu = Tu();
            if (qH() == 0) {
                Tu++;
            }
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            ahVar.a(aSq());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(Tu, ahVar);
            }
        }
    }

    public void aSR() {
        com.baidu.tbadk.core.data.r aSr;
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.sR().getLong("frs_storecard_closetime", 0L) >= 86400000 && (aSr = aSr()) != null) {
            int Tu = Tu();
            int qH = qH();
            if (qH == 0 || qH == 1) {
                Tu++;
            }
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(Tu, aSr);
            }
        }
    }

    public void aSS() {
        am recommendLikeUser;
        int g;
        int i;
        if (this.dfa != null && (recommendLikeUser = this.dfa.getRecommendLikeUser()) != null && recommendLikeUser.pX() != null && !TextUtils.isEmpty(recommendLikeUser.pX().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if ((next instanceof ax) && ((ax) next).getIs_top() != 0) {
                    i2++;
                }
            }
            String pW = recommendLikeUser.pW();
            if (!TextUtils.isEmpty(pW) && !TextUtils.isEmpty(pW.trim()) && (g = com.baidu.adp.lib.h.b.g(pW, -1)) != -1 && (g + i2) - 1 < size && i >= 0 && !(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.c)) {
                if (i - 1 < 0 || !(this.threadList.get(i - 1) instanceof com.baidu.tbadk.core.data.c)) {
                    this.threadList.add(i, recommendLikeUser);
                }
            }
        }
    }

    public ax nM(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next != null && (next instanceof ax) && TextUtils.equals(str, ((ax) next).getId())) {
                return (ax) next;
            }
        }
        return null;
    }

    public void q(ax axVar) {
        this.threadList.remove(axVar);
    }

    public boolean d(m mVar) {
        if (mVar == null) {
            return false;
        }
        d(mVar.pz());
        a(mVar.aSj());
        jv(mVar.aSf());
        nI(mVar.aSg());
        c(mVar.avD());
        setGameName(mVar.getGameName());
        nJ(mVar.aSn());
        a(mVar.aSh());
        jw(mVar.aSk());
        kg(mVar.avL());
        ct(mVar.aSm());
        pd(mVar.aSs());
        c(mVar.aSq());
        a(mVar.getPage());
        a(mVar.aSd());
        cr(mVar.aSl());
        an(mVar.getThreadList());
        cq(mVar.aSi());
        f(mVar.getUserData());
        setUserMap(mVar.getUserMap());
        b(mVar.aSe());
        cs(mVar.aSo());
        pe(mVar.aSx());
        cv(mVar.aSu());
        nL(mVar.aSv());
        a(mVar.aSr());
        o(mVar.aSw());
        b(mVar.aSy());
        pf(mVar.aSz());
        a(mVar.aSA());
        a(mVar.aSB());
        return true;
    }

    public void aST() {
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

    public void aSU() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.dfa != null && this.dfa.getBannerListData() != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if (vVar instanceof ax) {
                    ax axVar = (ax) vVar;
                    if (axVar == null || (!axVar.re() && axVar.qN() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.dfa.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar = new h();
                hVar.setForumId(this.dfa.getId());
                hVar.cp(feedForumList);
                this.threadList.add(i + 6, hVar);
            }
        }
    }

    public boolean aSV() {
        com.baidu.tieba.card.a.p recomTopicData;
        if (this.threadList == null || this.dfa == null || this.dfa.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
            if (vVar instanceof ax) {
                ax axVar = (ax) vVar;
                if (axVar == null || (!axVar.re() && axVar.qN() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.dfa.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.y.r(recomTopicData.aSp) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new aw("c10835").ac("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void aSW() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int aSz = (aSz() + Tu()) - 1;
            if (aSA() != null && aSz >= 0 && aSz <= this.threadList.size()) {
                this.threadList.add(aSz, aSA());
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.v> aSX() {
        return this.eqX;
    }

    public void cw(List<com.baidu.adp.widget.ListView.v> list) {
        this.eqX = list;
    }

    public boolean aSY() {
        return aSB() == null ? !com.baidu.tbadk.core.util.y.s(aSo()) : !com.baidu.tbadk.core.util.y.s(aSB().tab);
    }
}
