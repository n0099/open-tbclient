package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class n extends l implements com.baidu.tbadk.mvc.b.l {
    private int foo = 0;

    public void c(v vVar) {
        if (vVar != null) {
            this.efp.setCurScore(vVar.getCurScore());
            this.efp.setLevelupScore(vVar.getLevelupScore());
            this.efp.setLike(vVar.isLike());
            this.efp.setUser_level(vVar.getUserLevel());
            this.efp.setLevelName(vVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.efp.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.efp == null) {
            return null;
        }
        return this.efp.getSignData();
    }

    public void bgA() {
        bl top_notice_data;
        com.baidu.adp.widget.ListView.v vVar;
        if (aJY() != null && this.threadList != null && (top_notice_data = aJY().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (vVar = this.threadList.get(0)) != null && (vVar instanceof bh) && ((bh) vVar).rs() == 2) {
                this.threadList.remove(0);
            }
            bh bhVar = new bh();
            bhVar.setTitle(top_notice_data.getTitle());
            bhVar.cu(top_notice_data.sH());
            bhVar.bV(2);
            bhVar.sd();
            this.threadList.add(0, bhVar);
        }
    }

    public void a(al alVar) {
        if (alVar != null && !StringUtils.isNull(alVar.getId()) && this.threadList != null) {
            int abW = abW();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = threadList.get(i);
                    if ((vVar instanceof bh) && alVar.getId().equals(((bh) vVar).getId())) {
                        return;
                    }
                }
            }
            if (alVar.isPhotoLiveThread()) {
                au auVar = new au();
                auVar.a(alVar, -1);
                auVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.foo++;
                    this.threadList.add(abW, auVar);
                    return;
                }
                return;
            }
            this.foo++;
            this.threadList.add(abW, alVar);
        }
    }

    public void bgB() {
        this.foo = 0;
    }

    public int abW() {
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof bh) {
                if (((bh) next).rs() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    private int rh() {
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if ((next instanceof bh) && ((bh) next).ru() == 1) {
                return ((bh) next).rh();
            }
        }
        return -1;
    }

    public void bgC() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bh.SA || this.threadList.get(i2).getType() == bh.SB) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bgD() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.djY != null && this.djY.qv() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if ((vVar instanceof bh) && vVar.getType() == bh.TH) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int abW = abW();
            if (i > abW) {
                this.threadList.add(abW, this.threadList.remove(i));
            }
        }
    }

    public void g(BaseActivity baseActivity) {
        a(baseActivity, false, this.threadList, null, false);
    }

    public void a(BaseActivity baseActivity, boolean z, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, ArrayList<com.baidu.adp.widget.ListView.v> arrayList2, boolean z2) {
        BannerListData bannerListData;
        if (this.efp != null && (bannerListData = this.efp.getBannerListData()) != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(baseActivity.getPageContext(), 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<com.baidu.tbadk.core.data.c> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar.K((List<Object>) arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(baseActivity.getPageContext(), 3);
            bVar2.ce(z);
            bVar2.J(arrayList);
            bVar2.L(arrayList2);
            bVar2.cf(z2);
            bVar2.aW(getPage().qv());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        }
    }

    public void bgE() {
        boolean z = true;
        if (this.efp != null && this.threadList != null && bh.SD.get() && this.djY != null && this.djY.qv() == 1) {
            if (this.fnp == null || !this.fnp.bgU()) {
                z = false;
            }
            if (this.fnn || z || (getUserData() != null && getUserData().isBawu())) {
                while (!this.threadList.isEmpty() && (this.threadList.get(0) instanceof x)) {
                    this.threadList.remove(0);
                }
                x xVar = new x();
                xVar.lf(this.fnn);
                xVar.qz(this.fno);
                xVar.b(this.fnp);
                xVar.bV(1003);
                if (this.threadList != null && this.threadList.size() > 0) {
                    com.baidu.tbadk.core.util.w.a(this.threadList, abW(), xVar);
                }
            }
        }
    }

    public void bgF() {
        if (this.efp != null) {
            if (((this.efp.getTopCode() != null && !StringUtils.isNull(this.efp.getTopCode().sB())) || (this.efp.getNewsInfo() != null && !StringUtils.isNull(this.efp.getNewsInfo().sB()))) && this.djY != null && this.djY.qv() == 1) {
                ag agVar = new ag();
                agVar.a(this.efp.getTopCode());
                agVar.a(this.efp.getNewsInfo());
                agVar.bV(3);
                agVar.lg(true);
                if (!com.baidu.tbadk.core.util.w.s(this.threadList)) {
                    Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.v next = it.next();
                        if ((next instanceof bh) && ((bh) next).rs() != 0) {
                            if (((bh) next).rs() == 1003) {
                                agVar.lg(false);
                            }
                            i++;
                        }
                    }
                    this.threadList.add(i, agVar);
                }
            }
        }
    }

    public void bgG() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i);
            if (vVar instanceof bh) {
                bh bhVar = (bh) vVar;
                if (bhVar.isPhotoLiveThread() && !(bhVar instanceof au)) {
                    au auVar = new au();
                    auVar.o(bfV());
                    auVar.a(bhVar, 0);
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, auVar);
                    }
                }
            }
        }
    }

    public void bgH() {
        int i;
        if (aJY() != null) {
            List<PhotoLiveCardData> bfV = bfV();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bfV != null && bfV.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof au)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int rQ = rQ(i);
                au auVar = new au();
                a(auVar, bfV);
                getThreadList().add(rQ, auVar);
            }
        }
    }

    private void a(au auVar, List<PhotoLiveCardData> list) {
        if (auVar != null && !com.baidu.tbadk.core.util.w.s(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            auVar.setThreadType(33);
            auVar.setAuthor(metaData);
            auVar.cv(photoLiveCardData.getForumName());
            auVar.setTitle(photoLiveCardData.getTitle());
            auVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            auVar.cu(new StringBuilder(String.valueOf(photoLiveCardData.getThreadId())).toString());
            auVar.n(photoLiveCardData.getLastModifiedTime());
            auVar.bU(photoLiveCardData.getDiscussNum());
        }
    }

    private int rQ(int i) {
        int abW = abW();
        int bgc = bgc();
        if (bfY()) {
            bgc++;
        }
        return Math.min((bgc + abW) - 1, i);
    }

    public void bgI() {
        bh bgg;
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        int i;
        if (aJY() != null && (bgg = bgg()) != null && (threadList = getThreadList()) != null && threadList.size() > 0) {
            int size = threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = size;
                    break;
                } else if (!(threadList.get(i2) instanceof au)) {
                    i2++;
                } else {
                    threadList.remove(i2);
                    i = size - 1;
                    break;
                }
            }
            threadList.add(rQ(i), bgg);
        }
    }

    public void bgJ() {
        if (aJY() != null) {
            List<com.baidu.adp.widget.ListView.v> bgs = bgs();
            List<Integer> bgr = bgr();
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (bgr != null && bgr.size() > 0 && bgs != null && bgs.size() > 0 && threadList != null) {
                int size = bgr.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bgs.size()) {
                        threadList.add(bk(bgr.get(i).intValue(), size2), bgs.get(i));
                    }
                }
            }
        }
    }

    private int bk(int i, int i2) {
        int abW = abW();
        if (bfY()) {
            i++;
        }
        return Math.min((abW + i) - 1, i2);
    }

    public void bgK() {
        if (bfY()) {
            int abW = abW();
            if (rh() == 0) {
                abW++;
            }
            av avVar = new av();
            avVar.a(bfZ());
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(abW, avVar);
            }
        }
    }

    public void bgL() {
        com.baidu.tbadk.core.data.aa bga;
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.tQ().getLong("frs_storecard_closetime", 0L) >= 86400000 && (bga = bga()) != null) {
            int abW = abW();
            int rh = rh();
            if (rh == 0 || rh == 1) {
                abW++;
            }
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(abW, bga);
            }
        }
    }

    public bh qr(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next != null && (next instanceof bh) && TextUtils.equals(str, ((bh) next).getId())) {
                return (bh) next;
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
                    if (next != null && (next instanceof bh) && ((bh) next).getAuthor() != null && currentAccount.equals(((bh) next).getAuthor().getUserId()) && ((bh) next).getAuthor().getPendantData() != null) {
                        ((bh) next).getAuthor().getPendantData().N(jVar.BX());
                        ((bh) next).getAuthor().getPendantData().cq(jVar.pL());
                    }
                }
            }
        }
    }

    public void K(bh bhVar) {
        this.threadList.remove(bhVar);
    }

    public boolean d(l lVar) {
        if (lVar == null) {
            return false;
        }
        d(lVar.qm());
        a(lVar.bfS());
        lc(lVar.bfO());
        qn(lVar.bfP());
        c(lVar.aJY());
        setGameName(lVar.getGameName());
        qo(lVar.bfW());
        a(lVar.bfQ());
        ld(lVar.bfT());
        mr(lVar.aKk());
        da(lVar.bfV());
        rN(lVar.bgc());
        c(lVar.bfZ());
        a(lVar.getPage());
        a(lVar.bfM());
        cY(lVar.bfU());
        ax(lVar.getThreadList());
        cX(lVar.bfR());
        h(lVar.getUserData());
        setUserMap(lVar.getUserMap());
        b(lVar.bfN());
        cZ(lVar.bfX());
        rO(lVar.bgh());
        dc(lVar.bge());
        qq(lVar.bgf());
        a(lVar.bga());
        J(lVar.bgg());
        b(lVar.bgi());
        rP(lVar.bgl());
        a(lVar.bgm());
        a(lVar.bgn());
        rK(lVar.bfJ());
        a(lVar.bgo());
        dd(lVar.bgp());
        rL(lVar.bfK());
        rM(lVar.bfL());
        this.fnk = lVar.fnk;
        this.fnJ = lVar.fnJ;
        this.fnM = lVar.fnM;
        a(lVar.bgj());
        d(lVar.bgq());
        a(lVar.bgk());
        a(lVar.bgb());
        de(lVar.bgr());
        df(lVar.bgs());
        le(lVar.isShowDriftingBottle());
        cy(lVar.bgt());
        this.fnZ = lVar.fnZ;
        return true;
    }

    public void bgM() {
        if (this.threadList != null || this.threadList.size() <= 0) {
            int size = this.threadList.size();
            for (int i = 0; i < size; i++) {
                if (this.threadList.get(i) instanceof com.baidu.tbadk.core.data.aa) {
                    this.threadList.remove(i);
                    return;
                }
            }
        }
    }

    public void bgN() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.efp != null && this.efp.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
                if (vVar instanceof bh) {
                    bh bhVar = (bh) vVar;
                    if (bhVar == null || (!bhVar.rW() && bhVar.ru() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.efp.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar = new h();
                hVar.setForumId(this.efp.getId());
                hVar.cW(feedForumList);
                this.threadList.add(i + 6, hVar);
            }
        }
    }

    public boolean bgO() {
        com.baidu.tieba.card.data.r recomTopicData;
        if (this.threadList == null || this.efp == null || this.efp.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.v vVar = this.threadList.get(i2);
            if (vVar instanceof bh) {
                bh bhVar = (bh) vVar;
                if (bhVar == null || (!bhVar.rW() && bhVar.ru() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.efp.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.w.r(recomTopicData.boN) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ar("c10835").ab(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bgP() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bgl = (bgl() + abW()) - 1;
            if (bgm() != null && bgl >= 0 && bgl <= this.threadList.size()) {
                this.threadList.add(bgl, bgm());
            }
        }
    }

    public void bgQ() {
        int intValue;
        if (bgb() != null && (bgb().position.intValue() + abW()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bgb());
        }
    }

    public List<com.baidu.adp.widget.ListView.v> bgR() {
        return this.fnS;
    }

    public void dg(List<com.baidu.adp.widget.ListView.v> list) {
        this.fnS = list;
    }

    public boolean bgS() {
        return bfM() != null && bfM().bgu() == 1;
    }

    public boolean bgT() {
        return bgn() == null ? !com.baidu.tbadk.core.util.w.s(bfX()) : !com.baidu.tbadk.core.util.w.s(bgn().tab);
    }
}
