package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.DataRes;
/* loaded from: classes.dex */
public class p extends n implements com.baidu.tbadk.mvc.b.l {
    private int eWa = 0;

    public void c(z zVar) {
        if (zVar != null) {
            this.dLM.setCurScore(zVar.getCurScore());
            this.dLM.setLevelupScore(zVar.getLevelupScore());
            this.dLM.setLike(zVar.isLike());
            this.dLM.setUser_level(zVar.getUserLevel());
            this.dLM.setLevelName(zVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.dLM.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.dLM == null) {
            return null;
        }
        return this.dLM.getSignData();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(az azVar) {
        if (this.threadList != null) {
            while (!this.threadList.isEmpty() && this.threadList.get(0) != null && (this.threadList.get(0) instanceof az) && ((az) this.threadList.get(0)).getIs_top() == 2) {
                this.threadList.remove(0);
            }
        }
        this.threadList.add(0, azVar);
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        if (adVar != null && !StringUtils.isNull(adVar.getId()) && this.threadList != null) {
            int ZG = ZG();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = threadList.get(i);
                    if ((vVar instanceof az) && adVar.getId().equals(((az) vVar).getId())) {
                        return;
                    }
                }
            }
            if (adVar.isPhotoLiveThread()) {
                com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
                ajVar.a(adVar, -1);
                ajVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.eWa++;
                    this.threadList.add(ZG, ajVar);
                    return;
                }
                return;
            }
            this.eWa++;
            this.threadList.add(ZG, adVar);
        }
    }

    public void baU() {
        this.eWa = 0;
    }

    public int baV() {
        return this.eWa;
    }

    public int ZG() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof az) {
                if (((az) next).getIs_top() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int qA() {
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if ((next instanceof az) && ((az) next).qH() == 1) {
                return ((az) next).qA();
            }
        }
        return -1;
    }

    public void baW() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.deh != null && this.deh.pC() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if ((vVar instanceof az) && vVar.getType() == az.Rd) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int ZG = ZG();
            if (i > ZG) {
                this.threadList.add(ZG, this.threadList.remove(i));
            }
        }
    }

    public void aS(Context context) {
        BannerListData bannerListData;
        int g;
        if (this.dLM != null && (bannerListData = this.dLM.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && this.threadList != null && this.threadList.size() > 0) {
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
            Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if ((next instanceof az) && ((az) next).getIs_top() != 0) {
                    i2++;
                }
            }
            int size3 = bannerListData.getAllAdvertList().size();
            if (size3 >= 1) {
                int i3 = size2 - i2;
                HashSet hashSet = new HashSet();
                for (int i4 = 0; i4 < size3; i4++) {
                    com.baidu.tbadk.core.data.b bVar = bannerListData.getAllAdvertList().get(i4);
                    if (bVar != null && bVar.ov() && (com.baidu.adp.lib.h.b.g(bVar.MO, 0) + i2) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && (g < size2 || i3 <= 3)) {
                        if (bVar.ow()) {
                            if (!al.isInstalledPackage(context, bVar.MN) && !TextUtils.isEmpty(bVar.MN) && !TextUtils.isEmpty(bVar.MH)) {
                                boolean fg = com.baidu.tbadk.download.b.Ba().fg(bVar.MN);
                                boolean fj = com.baidu.tbadk.download.b.Ba().fj(bVar.MN);
                                if (fg) {
                                    bVar.MF = 1;
                                } else if (fj) {
                                    bVar.MF = 2;
                                } else {
                                    bVar.MF = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                if (g < size2) {
                                    this.threadList.add(g, bVar);
                                } else if (g == size2) {
                                    this.threadList.add(bVar);
                                }
                            }
                        } else if (bVar.ox()) {
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

    public void baX() {
        boolean z = true;
        int i = 0;
        if (this.dLM != null && az.Qk.get() && this.deh != null && this.deh.pC() == 1) {
            if (this.eVl == null || !this.eVl.bbl()) {
                z = false;
            }
            if (this.eVj || z || (getUserData() != null && getUserData().isBawu())) {
                ab abVar = new ab();
                abVar.ki(this.eVj);
                abVar.py(this.eVk);
                abVar.b(this.eVl);
                abVar.bI(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof az) && ((az) next).getIs_top() != 0) {
                            i++;
                        }
                    }
                    this.threadList.add(i, abVar);
                }
            }
        }
    }

    public void baY() {
        if (this.dLM != null) {
            if (((this.dLM.getTopCode() != null && !StringUtils.isNull(this.dLM.getTopCode().getSummary())) || (this.dLM.getNewsInfo() != null && !StringUtils.isNull(this.dLM.getNewsInfo().getSummary()))) && this.deh != null && this.deh.pC() == 1) {
                am amVar = new am();
                amVar.a(this.dLM.getTopCode());
                amVar.a(this.dLM.getNewsInfo());
                amVar.bI(3);
                amVar.kj(true);
                if (!com.baidu.tbadk.core.util.y.t(this.threadList)) {
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof az) && ((az) next).getIs_top() != 0) {
                            if (((az) next).getIs_top() == 1003) {
                                amVar.kj(false);
                            }
                            i++;
                        }
                    }
                    this.threadList.add(i, amVar);
                }
            }
        }
    }

    public void baZ() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i);
            if (vVar instanceof az) {
                az azVar = (az) vVar;
                if (azVar.isPhotoLiveThread() && !(azVar instanceof com.baidu.tbadk.core.data.aj)) {
                    com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
                    ajVar.p(baw());
                    ajVar.a(azVar, 0);
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, ajVar);
                    }
                }
            }
        }
    }

    public void bba() {
        int i;
        if (aDN() != null) {
            List<PhotoLiveCardData> baw = baw();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (baw != null && baw.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof com.baidu.tbadk.core.data.aj)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int qx = qx(i);
                com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
                a(ajVar, baw);
                getThreadList().add(qx, ajVar);
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.aj ajVar, List<PhotoLiveCardData> list) {
        if (ajVar != null && !com.baidu.tbadk.core.util.y.t(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            ajVar.setThreadType(33);
            ajVar.setAuthor(metaData);
            ajVar.setForum_name(photoLiveCardData.getForumName());
            ajVar.setTitle(photoLiveCardData.getTitle());
            ajVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            ajVar.cr(new StringBuilder(String.valueOf(photoLiveCardData.getThreadId())).toString());
            ajVar.u(photoLiveCardData.getLastModifiedTime());
            ajVar.setReply_num(photoLiveCardData.getDiscussNum());
        }
    }

    private int qx(int i) {
        int ZG = ZG();
        int baC = baC();
        if (baz()) {
            baC++;
        }
        return Math.min((baC + ZG) - 1, i);
    }

    public void bbb() {
        az baG;
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        int i;
        if (aDN() != null && (baG = baG()) != null && (threadList = getThreadList()) != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = size;
                    break;
                } else if (!(threadList.get(i2) instanceof com.baidu.tbadk.core.data.aj)) {
                    i2++;
                } else {
                    threadList.remove(i2);
                    i = size - 1;
                    break;
                }
            }
            threadList.add(qx(i), baG);
        }
    }

    public void bbc() {
        if (baz()) {
            int ZG = ZG();
            if (qA() == 0) {
                ZG++;
            }
            com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
            akVar.a(baA());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(ZG, akVar);
            }
        }
    }

    public void bbd() {
        com.baidu.tbadk.core.data.t baB;
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.sO().getLong("frs_storecard_closetime", 0L) >= 86400000 && (baB = baB()) != null) {
            int ZG = ZG();
            int qA = qA();
            if (qA == 0 || qA == 1) {
                ZG++;
            }
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(ZG, baB);
            }
        }
    }

    public void bbe() {
        ao recommendLikeUser;
        int g;
        int i;
        if (this.dLM != null && (recommendLikeUser = this.dLM.getRecommendLikeUser()) != null && recommendLikeUser.pR() != null && !TextUtils.isEmpty(recommendLikeUser.pR().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if ((next instanceof az) && ((az) next).getIs_top() != 0) {
                    i2++;
                }
            }
            String pQ = recommendLikeUser.pQ();
            if (!TextUtils.isEmpty(pQ) && !TextUtils.isEmpty(pQ.trim()) && (g = com.baidu.adp.lib.h.b.g(pQ, -1)) != -1 && (g + i2) - 1 < size && i >= 0 && !(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.b)) {
                if (i - 1 < 0 || !(this.threadList.get(i - 1) instanceof com.baidu.tbadk.core.data.b)) {
                    this.threadList.add(i, recommendLikeUser);
                }
            }
        }
    }

    public az pr(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next != null && (next instanceof az) && TextUtils.equals(str, ((az) next).getId())) {
                return (az) next;
            }
        }
        return null;
    }

    public void u(az azVar) {
        this.threadList.remove(azVar);
    }

    public boolean d(n nVar) {
        if (nVar == null) {
            return false;
        }
        d(nVar.pt());
        a(nVar.bat());
        kg(nVar.bap());
        pn(nVar.baq());
        c(nVar.aDN());
        setGameName(nVar.getGameName());
        po(nVar.bax());
        a(nVar.bar());
        kh(nVar.bau());
        lI(nVar.aDV());
        cJ(nVar.baw());
        qu(nVar.baC());
        c(nVar.baA());
        a(nVar.getPage());
        a(nVar.ban());
        cH(nVar.bav());
        ay(nVar.getThreadList());
        cG(nVar.bas());
        f(nVar.getUserData());
        setUserMap(nVar.getUserMap());
        b(nVar.bao());
        cI(nVar.bay());
        qv(nVar.baH());
        cL(nVar.baE());
        pq(nVar.baF());
        a(nVar.baB());
        s(nVar.baG());
        b(nVar.baI());
        qw(nVar.baJ());
        a(nVar.baK());
        a(nVar.baL());
        a(nVar.baM());
        cM(nVar.baN());
        qs(nVar.bal());
        qt(nVar.bam());
        return true;
    }

    public void bbf() {
        if (this.threadList != null || this.threadList.size() <= 0) {
            int size = this.threadList.size();
            for (int i = 0; i < size; i++) {
                if (this.threadList.get(i) instanceof com.baidu.tbadk.core.data.t) {
                    this.threadList.remove(i);
                    return;
                }
            }
        }
    }

    public void bbg() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.dLM != null && this.dLM.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if (vVar instanceof az) {
                    az azVar = (az) vVar;
                    if (azVar == null || (!azVar.ra() && azVar.qH() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.dLM.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                i iVar = new i();
                iVar.setForumId(this.dLM.getId());
                iVar.cF(feedForumList);
                this.threadList.add(i + 6, iVar);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public void a(DataRes dataRes) {
        super.a(dataRes);
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public ForumData aDN() {
        return super.aDN();
    }

    public boolean bbh() {
        com.baidu.tieba.card.a.q recomTopicData;
        if (this.threadList == null || this.dLM == null || this.dLM.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
            if (vVar instanceof az) {
                az azVar = (az) vVar;
                if (azVar == null || (!azVar.ra() && azVar.qH() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.dLM.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.y.s(recomTopicData.aVK) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ay("c10835").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bbi() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int baJ = (baJ() + ZG()) - 1;
            if (baK() != null && baJ >= 0 && baJ <= this.threadList.size()) {
                this.threadList.add(baJ, baK());
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.v> bbj() {
        return this.eVI;
    }

    public void cN(List<com.baidu.adp.widget.ListView.v> list) {
        this.eVI = list;
    }

    public boolean bbk() {
        return baL() == null ? !com.baidu.tbadk.core.util.y.t(bay()) : !com.baidu.tbadk.core.util.y.t(baL().tab);
    }
}
