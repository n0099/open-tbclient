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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.DataRes;
/* loaded from: classes.dex */
public class p extends n implements com.baidu.tbadk.mvc.b.l {
    private int ftC = 0;

    public void c(y yVar) {
        if (yVar != null) {
            this.elX.setCurScore(yVar.getCurScore());
            this.elX.setLevelupScore(yVar.getLevelupScore());
            this.elX.setLike(yVar.isLike());
            this.elX.setUser_level(yVar.getUserLevel());
            this.elX.setLevelName(yVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.elX.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.elX == null) {
            return null;
        }
        return this.elX.getSignData();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(bi biVar) {
        if (this.threadList != null) {
            while (!this.threadList.isEmpty() && this.threadList.get(0) != null && (this.threadList.get(0) instanceof bi) && ((bi) this.threadList.get(0)).rJ() == 2) {
                this.threadList.remove(0);
            }
        }
        this.threadList.add(0, biVar);
    }

    public void a(com.baidu.tbadk.core.data.aj ajVar) {
        if (ajVar != null && !StringUtils.isNull(ajVar.getId()) && this.threadList != null) {
            int afc = afc();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = threadList.get(i);
                    if ((vVar instanceof bi) && ajVar.getId().equals(((bi) vVar).getId())) {
                        return;
                    }
                }
            }
            if (ajVar.isPhotoLiveThread()) {
                as asVar = new as();
                asVar.a(ajVar, -1);
                asVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.ftC++;
                    this.threadList.add(afc, asVar);
                    return;
                }
                return;
            }
            this.ftC++;
            this.threadList.add(afc, ajVar);
        }
    }

    public void biy() {
        this.ftC = 0;
    }

    public int biz() {
        return this.ftC;
    }

    public int afc() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof bi) {
                if (((bi) next).rJ() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int rz() {
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if ((next instanceof bi) && ((bi) next).rL() == 1) {
                return ((bi) next).rz();
            }
        }
        return -1;
    }

    public void biA() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.duh != null && this.duh.qz() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if ((vVar instanceof bi) && vVar.getType() == bi.Uy) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int afc = afc();
            if (i > afc) {
                this.threadList.add(afc, this.threadList.remove(i));
            }
        }
    }

    public void bc(Context context) {
        BannerListData bannerListData;
        int g;
        if (this.elX != null && (bannerListData = this.elX.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && this.threadList != null && this.threadList.size() > 0) {
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
                if ((next instanceof bi) && ((bi) next).rJ() != 0) {
                    i2++;
                }
            }
            int size3 = bannerListData.getAllAdvertList().size();
            if (size3 >= 1) {
                int i3 = size2 - i2;
                HashSet hashSet = new HashSet();
                for (int i4 = 0; i4 < size3; i4++) {
                    com.baidu.tbadk.core.data.b bVar = bannerListData.getAllAdvertList().get(i4);
                    if (bVar != null && bVar.ph() && (com.baidu.adp.lib.h.b.g(bVar.adPosition, 0) + i2) - 1 >= 0 && !hashSet.contains(Integer.valueOf(g)) && (g < size2 || i3 <= 3)) {
                        if (bVar.pi()) {
                            if (!com.baidu.tieba.recapp.g.isInstalledPackage(context, bVar.Pg) && !TextUtils.isEmpty(bVar.Pg) && !TextUtils.isEmpty(bVar.Pa)) {
                                boolean fj = com.baidu.tbadk.download.b.Cv().fj(bVar.Pg);
                                boolean fl = com.baidu.tbadk.download.b.Cv().fl(bVar.Pg);
                                if (fj) {
                                    bVar.OY = 1;
                                } else if (fl) {
                                    bVar.OY = 2;
                                } else {
                                    bVar.OY = 0;
                                }
                                hashSet.add(Integer.valueOf(g));
                                if (g < size2) {
                                    this.threadList.add(g, bVar);
                                } else if (g == size2) {
                                    this.threadList.add(bVar);
                                }
                            }
                        } else if (bVar.pj()) {
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

    public void biB() {
        boolean z = true;
        int i = 0;
        if (this.elX != null && bi.Tw.get() && this.duh != null && this.duh.qz() == 1) {
            if (this.fsI == null || !this.fsI.biQ()) {
                z = false;
            }
            if (this.fsG || z || (getUserData() != null && getUserData().isBawu())) {
                aa aaVar = new aa();
                aaVar.kL(this.fsG);
                aaVar.rh(this.fsH);
                aaVar.b(this.fsI);
                aaVar.bV(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof bi) && ((bi) next).rJ() != 0) {
                            i++;
                        }
                    }
                    this.threadList.add(i, aaVar);
                }
            }
        }
    }

    public void biC() {
        if (this.elX != null) {
            if (((this.elX.getTopCode() != null && !StringUtils.isNull(this.elX.getTopCode().getSummary())) || (this.elX.getNewsInfo() != null && !StringUtils.isNull(this.elX.getNewsInfo().getSummary()))) && this.duh != null && this.duh.qz() == 1) {
                al alVar = new al();
                alVar.a(this.elX.getTopCode());
                alVar.a(this.elX.getNewsInfo());
                alVar.bV(3);
                alVar.kM(true);
                if (!com.baidu.tbadk.core.util.y.t(this.threadList)) {
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof bi) && ((bi) next).rJ() != 0) {
                            if (((bi) next).rJ() == 1003) {
                                alVar.kM(false);
                            }
                            i++;
                        }
                    }
                    this.threadList.add(i, alVar);
                }
            }
        }
    }

    public void biD() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i);
            if (vVar instanceof bi) {
                bi biVar = (bi) vVar;
                if (biVar.isPhotoLiveThread() && !(biVar instanceof as)) {
                    as asVar = new as();
                    asVar.p(bhW());
                    asVar.a(biVar, 0);
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, asVar);
                    }
                }
            }
        }
    }

    public void biE() {
        int i;
        if (aMr() != null) {
            List<PhotoLiveCardData> bhW = bhW();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bhW != null && bhW.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof as)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int rH = rH(i);
                as asVar = new as();
                a(asVar, bhW);
                getThreadList().add(rH, asVar);
            }
        }
    }

    private void a(as asVar, List<PhotoLiveCardData> list) {
        if (asVar != null && !com.baidu.tbadk.core.util.y.t(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            asVar.setThreadType(33);
            asVar.setAuthor(metaData);
            asVar.setForum_name(photoLiveCardData.getForumName());
            asVar.setTitle(photoLiveCardData.getTitle());
            asVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            asVar.cu(new StringBuilder(String.valueOf(photoLiveCardData.getThreadId())).toString());
            asVar.p(photoLiveCardData.getLastModifiedTime());
            asVar.bU(photoLiveCardData.getDiscussNum());
        }
    }

    private int rH(int i) {
        int afc = afc();
        int bid = bid();
        if (bhZ()) {
            bid++;
        }
        return Math.min((bid + afc) - 1, i);
    }

    public void biF() {
        bi bih;
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        int i;
        if (aMr() != null && (bih = bih()) != null && (threadList = getThreadList()) != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = size;
                    break;
                } else if (!(threadList.get(i2) instanceof as)) {
                    i2++;
                } else {
                    threadList.remove(i2);
                    i = size - 1;
                    break;
                }
            }
            threadList.add(rH(i), bih);
        }
    }

    public void biG() {
        if (bhZ()) {
            int afc = afc();
            if (rz() == 0) {
                afc++;
            }
            at atVar = new at();
            atVar.a(bia());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(afc, atVar);
            }
        }
    }

    public void biH() {
        com.baidu.tbadk.core.data.y bib;
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.uh().getLong("frs_storecard_closetime", 0L) >= 86400000 && (bib = bib()) != null) {
            int afc = afc();
            int rz = rz();
            if (rz == 0 || rz == 1) {
                afc++;
            }
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(afc, bib);
            }
        }
    }

    public void biI() {
        ax recommendLikeUser;
        int g;
        int i;
        if (this.elX != null && (recommendLikeUser = this.elX.getRecommendLikeUser()) != null && recommendLikeUser.qP() != null && !TextUtils.isEmpty(recommendLikeUser.qP().getName()) && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if ((next instanceof bi) && ((bi) next).rJ() != 0) {
                    i2++;
                }
            }
            String qO = recommendLikeUser.qO();
            if (!TextUtils.isEmpty(qO) && !TextUtils.isEmpty(qO.trim()) && (g = com.baidu.adp.lib.h.b.g(qO, -1)) != -1 && (g + i2) - 1 < size && i >= 0 && !(this.threadList.get(i) instanceof com.baidu.tbadk.core.data.b)) {
                if (i - 1 < 0 || !(this.threadList.get(i - 1) instanceof com.baidu.tbadk.core.data.b)) {
                    this.threadList.add(i, recommendLikeUser);
                }
            }
        }
    }

    public bi qZ(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next != null && (next instanceof bi) && TextUtils.equals(str, ((bi) next).getId())) {
                return (bi) next;
            }
        }
        return null;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (this.threadList != null && jVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.v next = it.next();
                    if (next != null && (next instanceof bi) && ((bi) next).getAuthor() != null && currentAccount.equals(((bi) next).getAuthor().getUserId()) && ((bi) next).getAuthor().getPendantData() != null) {
                        ((bi) next).getAuthor().getPendantData().Q(jVar.Cg());
                        ((bi) next).getAuthor().getPendantData().cq(jVar.pO());
                    }
                }
            }
        }
    }

    public void w(bi biVar) {
        this.threadList.remove(biVar);
    }

    public boolean d(n nVar) {
        if (nVar == null) {
            return false;
        }
        d(nVar.qq());
        a(nVar.bhT());
        kJ(nVar.bhP());
        qV(nVar.bhQ());
        c(nVar.aMr());
        setGameName(nVar.getGameName());
        qW(nVar.bhX());
        a(nVar.bhR());
        kK(nVar.bhU());
        mz(nVar.aMA());
        db(nVar.bhW());
        rE(nVar.bid());
        c(nVar.bia());
        a(nVar.getPage());
        a(nVar.bhN());
        cZ(nVar.bhV());
        aA(nVar.getThreadList());
        cY(nVar.bhS());
        j(nVar.getUserData());
        setUserMap(nVar.getUserMap());
        b(nVar.bhO());
        da(nVar.bhY());
        rF(nVar.bii());
        dd(nVar.bif());
        qY(nVar.big());
        a(nVar.bib());
        u(nVar.bih());
        b(nVar.bij());
        rG(nVar.bim());
        a(nVar.bin());
        a(nVar.bio());
        a(nVar.bip());
        de(nVar.biq());
        rC(nVar.bhL());
        rD(nVar.bhM());
        this.fsD = nVar.fsD;
        this.ftc = nVar.ftc;
        a(nVar.bik());
        h(nVar.bir());
        a(nVar.bil());
        a(nVar.bic());
        return true;
    }

    public void biJ() {
        if (this.threadList != null || this.threadList.size() <= 0) {
            int size = this.threadList.size();
            for (int i = 0; i < size; i++) {
                if (this.threadList.get(i) instanceof com.baidu.tbadk.core.data.y) {
                    this.threadList.remove(i);
                    return;
                }
            }
        }
    }

    public void biK() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.elX != null && this.elX.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if (vVar instanceof bi) {
                    bi biVar = (bi) vVar;
                    if (biVar == null || (!biVar.sn() && biVar.rL() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.elX.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                i iVar = new i();
                iVar.setForumId(this.elX.getId());
                iVar.cX(feedForumList);
                this.threadList.add(i + 6, iVar);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public void a(DataRes dataRes) {
        super.a(dataRes);
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public ForumData aMr() {
        return super.aMr();
    }

    public boolean biL() {
        com.baidu.tieba.card.data.q recomTopicData;
        if (this.threadList == null || this.elX == null || this.elX.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
            if (vVar instanceof bi) {
                bi biVar = (bi) vVar;
                if (biVar == null || (!biVar.sn() && biVar.rL() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.elX.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.y.s(recomTopicData.bcE) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c10835").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void biM() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bim = (bim() + afc()) - 1;
            if (bin() != null && bim >= 0 && bim <= this.threadList.size()) {
                this.threadList.add(bim, bin());
            }
        }
    }

    public void biN() {
        int intValue;
        if (bic() != null && (bic().position.intValue() + afc()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bic());
        }
    }

    public List<com.baidu.adp.widget.ListView.v> biO() {
        return this.ftk;
    }

    public void df(List<com.baidu.adp.widget.ListView.v> list) {
        this.ftk = list;
    }

    public boolean biP() {
        return bio() == null ? !com.baidu.tbadk.core.util.y.t(bhY()) : !com.baidu.tbadk.core.util.y.t(bio().tab);
    }
}
