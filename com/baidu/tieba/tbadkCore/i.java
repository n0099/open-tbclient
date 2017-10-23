package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class i extends g implements com.baidu.tbadk.mvc.b.l {
    private boolean bfd;
    private int gfd = 0;
    private BannerListData gfe;

    public void c(o oVar) {
        if (oVar != null) {
            this.eyb.setCurScore(oVar.getCurScore());
            this.eyb.setLevelupScore(oVar.getLevelupScore());
            this.eyb.setLike(oVar.isLike());
            this.eyb.setUser_level(oVar.getUserLevel());
            this.eyb.setLevelName(oVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.eyb.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.eyb == null) {
            return null;
        }
        return this.eyb.getSignData();
    }

    public void bqf() {
        bj top_notice_data;
        com.baidu.adp.widget.ListView.f fVar;
        if (aMU() != null && this.threadList != null && (top_notice_data = aMU().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (fVar = this.threadList.get(0)) != null && (fVar instanceof bh) && ((bh) fVar).rj() == 2) {
                this.threadList.remove(0);
            }
            bh bhVar = new bh();
            bhVar.setTitle(top_notice_data.getTitle());
            bhVar.cx(top_notice_data.sN());
            bhVar.bT(2);
            bhVar.rW();
            this.threadList.add(0, bhVar);
        }
    }

    public void a(am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && this.threadList != null) {
            int akU = akU();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = threadList.get(i);
                    if ((fVar instanceof bh) && amVar.getId().equals(((bh) fVar).getId())) {
                        return;
                    }
                }
            }
            if (amVar.isPhotoLiveThread()) {
                av avVar = new av();
                avVar.a(amVar, -1);
                avVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.gfd++;
                    this.threadList.add(akU, avVar);
                    return;
                }
                return;
            }
            this.gfd++;
            this.threadList.add(akU, amVar);
        }
    }

    public void bqg() {
        this.gfd = 0;
    }

    public int akU() {
        int i = 0;
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof bh)) {
                    i = i2;
                } else if (((bh) next).rj() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    private int qW() {
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
            if ((next instanceof bh) && ((bh) next).rl() == 1) {
                return ((bh) next).qW();
            }
        }
        return -1;
    }

    public void bqh() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bh.Ya || this.threadList.get(i2).getType() == bh.Yb || this.threadList.get(i2).getType() == bh.Yc) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bqi() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dJY != null && this.dJY.qk() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if ((fVar instanceof bh) && fVar.getType() == bh.Zg) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int akU = akU();
            if (i > akU) {
                this.threadList.add(akU, this.threadList.remove(i));
            }
        }
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar) {
        a(bVar, false, this.threadList, null, false);
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        a(bVar, false, arrayList, null, false);
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar, boolean z, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, ArrayList<com.baidu.adp.widget.ListView.f> arrayList2, boolean z2) {
        BannerListData bannerListData;
        if (!this.bfd) {
            if (this.eyb != null) {
                bannerListData = this.eyb.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gfe;
        }
        this.bfd = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar2.N(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.ci(z);
            bVar3.M(arrayList);
            bVar3.O(arrayList2);
            bVar3.cj(z2);
            bVar3.bX(qq().qk());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void bqj() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i);
            if (fVar instanceof bh) {
                bh bhVar = (bh) fVar;
                if (bhVar.isPhotoLiveThread() && !(bhVar instanceof av)) {
                    av avVar = new av();
                    avVar.q(bpB());
                    avVar.a(bhVar, 0);
                    if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, avVar);
                    }
                }
            }
        }
    }

    public void bqk() {
        int i;
        if (aMU() != null) {
            List<PhotoLiveCardData> bpB = bpB();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (bpB != null && bpB.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof av)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int tv2 = tv(i);
                av avVar = new av();
                a(avVar, bpB);
                getThreadList().add(tv2, avVar);
            }
        }
    }

    private void a(av avVar, List<PhotoLiveCardData> list) {
        if (avVar != null && !v.u(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            avVar.setThreadType(33);
            avVar.setAuthor(metaData);
            avVar.cB(photoLiveCardData.getForumName());
            avVar.setTitle(photoLiveCardData.getTitle());
            avVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            avVar.cx(photoLiveCardData.getThreadId() + "");
            avVar.m(photoLiveCardData.getLastModifiedTime());
            avVar.bR(photoLiveCardData.getDiscussNum());
        }
    }

    private int tv(int i) {
        int akU = akU();
        int bpH = bpH();
        if (bpE()) {
            bpH++;
        }
        return Math.min((bpH + akU) - 1, i);
    }

    public void bql() {
        bh bpL;
        int i;
        if (aMU() != null && (bpL = bpL()) != null) {
            Log.e(PbActivityConfig.VALUE_FROM_FRS, "addCardVideoInfoToThreadList cardVideoInfo:" + bpL.getTid());
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof av)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                threadList.add(tv(i), bpL);
            }
        }
    }

    public void bqm() {
        if (aMU() != null) {
            List<com.baidu.adp.widget.ListView.f> bpW = bpW();
            List<Integer> bpV = bpV();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (bpV != null && bpV.size() > 0 && bpW != null && bpW.size() > 0 && threadList != null) {
                int size = bpV.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bpW.size()) {
                        com.baidu.adp.widget.ListView.f fVar = bpW.get(i);
                        int bR = bR(bpV.get(i).intValue(), size2);
                        Log.e(PbActivityConfig.VALUE_FROM_FRS, "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bR + "  Title:" + fVar.getType());
                        threadList.add(bR, fVar);
                    }
                }
            }
        }
    }

    private int bR(int i, int i2) {
        int akU = akU();
        if (bpE()) {
            i++;
        }
        return Math.min((akU + i) - 1, i2);
    }

    public void bqn() {
        if (bpE()) {
            int akU = akU();
            if (qW() == 0) {
                akU++;
            }
            aw awVar = new aw();
            awVar.a(bpF());
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(akU, awVar);
            }
        }
    }

    public bh rG(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
            if (next != null && (next instanceof bh) && TextUtils.equals(str, ((bh) next).getId())) {
                return (bh) next;
            }
        }
        return null;
    }

    public void a(com.baidu.tbadk.data.i iVar) {
        if (this.threadList != null && iVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next != null && (next instanceof bh) && ((bh) next).getAuthor() != null && currentAccount.equals(((bh) next).getAuthor().getUserId()) && ((bh) next).getAuthor().getPendantData() != null) {
                        ((bh) next).getAuthor().getPendantData().Q(iVar.BU());
                        ((bh) next).getAuthor().getPendantData().cz(iVar.pL());
                    }
                }
            }
        }
    }

    public void ai(bh bhVar) {
        this.threadList.remove(bhVar);
    }

    public boolean e(g gVar) {
        if (gVar == null) {
            return false;
        }
        d(gVar.qa());
        a(gVar.bpy());
        mw(gVar.bpu());
        rC(gVar.bpv());
        c(gVar.aMU());
        setGameName(gVar.getGameName());
        rD(gVar.bpC());
        a(gVar.bpw());
        mx(gVar.bpz());
        oV(gVar.aNi());
        dj(gVar.bpB());
        ts(gVar.bpH());
        c(gVar.bpF());
        a(gVar.qq());
        a(gVar.bps());
        dh(gVar.bpA());
        az(gVar.getThreadList());
        dg(gVar.bpx());
        e(gVar.getUserData());
        setUserMap(gVar.getUserMap());
        a(gVar.bpt());
        di(gVar.bpD());
        tt(gVar.bpM());
        dl(gVar.bpJ());
        rF(gVar.bpK());
        ah(gVar.bpL());
        a(gVar.bpN());
        tu(gVar.bpQ());
        a(gVar.bpR());
        a(gVar.bpS());
        tp(gVar.bpp());
        a(gVar.bpT());
        tq(gVar.bpq());
        tr(gVar.bpr());
        this.gdW = gVar.gdW;
        this.geu = gVar.geu;
        this.gex = gVar.gex;
        a(gVar.bpO());
        j(gVar.bpU());
        a(gVar.bpP());
        a(gVar.bpG());
        dm(gVar.bpV());
        dn(gVar.bpW());
        this.geI = gVar.geI;
        a(gVar.bpX());
        a(gVar.bpn());
        df(gVar.bpm());
        a(gVar.bpY());
        m13do(gVar.bpZ());
        a(gVar.bpo());
        a(gVar.bqa());
        return true;
    }

    public void bqo() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.eyb != null && this.eyb.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if (fVar instanceof bh) {
                    bh bhVar = (bh) fVar;
                    if (bhVar == null || (!bhVar.rP() && bhVar.rl() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.eyb.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                f fVar2 = new f();
                fVar2.setForumId(this.eyb.getId());
                fVar2.de(feedForumList);
                this.threadList.add(i + 6, fVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void my(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!v.u(this.threadList)) {
            bqp();
            if (bpX() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                    if (fVar instanceof bh) {
                        bh bhVar = (bh) fVar;
                        if (bhVar == null || (!bhVar.rP() && bhVar.rl() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bpX().ant() + i) - 1 < this.threadList.size()) {
                    String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("game_rank_list_info", "");
                    if (StringUtils.isNull(string) || string.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length != 2) {
                        z2 = true;
                    } else {
                        z2 = UtilHelper.getDayBetweenTime(com.baidu.adp.lib.g.b.c(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0], 0L), System.currentTimeMillis()) >= ((long) com.baidu.adp.lib.g.b.g(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1], 0));
                    }
                    if (z2) {
                        int i3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("game_rank_list_show_times", 0);
                        if (!z) {
                            i3++;
                        }
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("game_rank_list_show_times", i3);
                        if (i3 > 3) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("game_rank_list_info", System.currentTimeMillis() + ",1");
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("game_rank_list_show_times", 0);
                            if (!z3) {
                                this.threadList.add((bpX().ant() + i) - 1, bpX());
                                return;
                            }
                            return;
                        }
                    }
                    z3 = z2;
                    if (!z3) {
                    }
                }
            }
        }
    }

    public void bqp() {
        if (!v.u(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.cOR) {
                    it.remove();
                }
            }
        }
    }

    public boolean bqq() {
        com.baidu.tieba.card.data.p recomTopicData;
        if (this.threadList == null || this.eyb == null || this.eyb.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
            if (fVar instanceof bh) {
                bh bhVar = (bh) fVar;
                if (bhVar == null || (!bhVar.rP() && bhVar.rl() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.eyb.getBannerListData().getRecomTopicData()) == null || v.t(recomTopicData.bNN) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ak("c10835").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bqr() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bpQ = (bpQ() + akU()) - 1;
            if (bpR() != null && bpQ >= 0 && bpQ <= this.threadList.size()) {
                this.threadList.add(bpQ, bpR());
            }
        }
    }

    public void bqs() {
        int intValue;
        if (bpG() != null && (bpG().position.intValue() + akU()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bpG());
        }
    }

    public void bqt() {
        int sp;
        if (bqa() != null) {
            com.baidu.tieba.frs.q bqa = bqa();
            if (v.t(bqa.getUserInfo()) >= 3 && (sp = bqa.sp()) > 0) {
                int akU = sp + akU();
                if (akU > this.threadList.size()) {
                    this.threadList.add(bqa);
                } else {
                    this.threadList.add(akU, bqa);
                }
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.f> bqu() {
        return this.geD;
    }

    public void dp(List<com.baidu.adp.widget.ListView.f> list) {
        this.geD = list;
    }

    public boolean bqv() {
        if (bps() == null) {
            return false;
        }
        return bps().bqb() == 1;
    }

    public boolean bqw() {
        return bpS() == null ? !v.u(bpD()) : !v.u(bpS().tab);
    }

    public void a(BannerListData bannerListData) {
        this.bfd = true;
        this.gfe = bannerListData;
    }
}
