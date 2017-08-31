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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bl;
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
    private boolean bdG;
    private int ggQ = 0;
    private BannerListData ggR;

    public void c(o oVar) {
        if (oVar != null) {
            this.eEb.setCurScore(oVar.getCurScore());
            this.eEb.setLevelupScore(oVar.getLevelupScore());
            this.eEb.setLike(oVar.isLike());
            this.eEb.setUser_level(oVar.getUserLevel());
            this.eEb.setLevelName(oVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.eEb.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.eEb == null) {
            return null;
        }
        return this.eEb.getSignData();
    }

    public void brf() {
        bl top_notice_data;
        com.baidu.adp.widget.ListView.f fVar;
        if (aOV() != null && this.threadList != null && (top_notice_data = aOV().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (fVar = this.threadList.get(0)) != null && (fVar instanceof bj) && ((bj) fVar).rw() == 2) {
                this.threadList.remove(0);
            }
            bj bjVar = new bj();
            bjVar.setTitle(top_notice_data.getTitle());
            bjVar.cy(top_notice_data.ta());
            bjVar.bT(2);
            bjVar.sj();
            this.threadList.add(0, bjVar);
        }
    }

    public void a(ao aoVar) {
        if (aoVar != null && !StringUtils.isNull(aoVar.getId()) && this.threadList != null) {
            int akK = akK();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = threadList.get(i);
                    if ((fVar instanceof bj) && aoVar.getId().equals(((bj) fVar).getId())) {
                        return;
                    }
                }
            }
            if (aoVar.isPhotoLiveThread()) {
                ax axVar = new ax();
                axVar.a(aoVar, -1);
                axVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.ggQ++;
                    this.threadList.add(akK, axVar);
                    return;
                }
                return;
            }
            this.ggQ++;
            this.threadList.add(akK, aoVar);
        }
    }

    public void brg() {
        this.ggQ = 0;
    }

    public int akK() {
        int i = 0;
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof bj)) {
                    i = i2;
                } else if (((bj) next).rw() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    private int rj() {
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
            if ((next instanceof bj) && ((bj) next).ry() == 1) {
                return ((bj) next).rj();
            }
        }
        return -1;
    }

    public void brh() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bj.Yl || this.threadList.get(i2).getType() == bj.Ym || this.threadList.get(i2).getType() == bj.Yn) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bri() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dNa != null && this.dNa.qx() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if ((fVar instanceof bj) && fVar.getType() == bj.Zs) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int akK = akK();
            if (i > akK) {
                this.threadList.add(akK, this.threadList.remove(i));
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
        if (!this.bdG) {
            if (this.eEb != null) {
                bannerListData = this.eEb.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.ggR;
        }
        this.bdG = false;
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
            bVar3.ck(z);
            bVar3.setThreadList(arrayList);
            bVar3.O(arrayList2);
            bVar3.cl(z2);
            bVar3.bX(qD().qx());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void brj() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i);
            if (fVar instanceof bj) {
                bj bjVar = (bj) fVar;
                if (bjVar.isPhotoLiveThread() && !(bjVar instanceof ax)) {
                    ax axVar = new ax();
                    axVar.r(bqB());
                    axVar.a(bjVar, 0);
                    if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, axVar);
                    }
                }
            }
        }
    }

    public void brk() {
        int i;
        if (aOV() != null) {
            List<PhotoLiveCardData> bqB = bqB();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (bqB != null && bqB.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof ax)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int tp = tp(i);
                ax axVar = new ax();
                a(axVar, bqB);
                getThreadList().add(tp, axVar);
            }
        }
    }

    private void a(ax axVar, List<PhotoLiveCardData> list) {
        if (axVar != null && !v.v(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            axVar.setThreadType(33);
            axVar.setAuthor(metaData);
            axVar.cC(photoLiveCardData.getForumName());
            axVar.setTitle(photoLiveCardData.getTitle());
            axVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            axVar.cy(photoLiveCardData.getThreadId() + "");
            axVar.m(photoLiveCardData.getLastModifiedTime());
            axVar.bR(photoLiveCardData.getDiscussNum());
        }
    }

    private int tp(int i) {
        int akK = akK();
        int bqH = bqH();
        if (bqE()) {
            bqH++;
        }
        return Math.min((bqH + akK) - 1, i);
    }

    public void brl() {
        bj bqL;
        int i;
        if (aOV() != null && (bqL = bqL()) != null) {
            Log.e(PbActivityConfig.VALUE_FROM_FRS, "addCardVideoInfoToThreadList cardVideoInfo:" + bqL.getTid());
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof ax)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                threadList.add(tp(i), bqL);
            }
        }
    }

    public void brm() {
        if (aOV() != null) {
            List<com.baidu.adp.widget.ListView.f> bqW = bqW();
            List<Integer> bqV = bqV();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (bqV != null && bqV.size() > 0 && bqW != null && bqW.size() > 0 && threadList != null) {
                int size = bqV.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bqW.size()) {
                        com.baidu.adp.widget.ListView.f fVar = bqW.get(i);
                        int bF = bF(bqV.get(i).intValue(), size2);
                        Log.e(PbActivityConfig.VALUE_FROM_FRS, "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bF + "  Title:" + fVar.getType());
                        threadList.add(bF, fVar);
                    }
                }
            }
        }
    }

    private int bF(int i, int i2) {
        int akK = akK();
        if (bqE()) {
            i++;
        }
        return Math.min((akK + i) - 1, i2);
    }

    public void brn() {
        if (bqE()) {
            int akK = akK();
            if (rj() == 0) {
                akK++;
            }
            ay ayVar = new ay();
            ayVar.a(bqF());
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(akK, ayVar);
            }
        }
    }

    public bj rV(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
            if (next != null && (next instanceof bj) && TextUtils.equals(str, ((bj) next).getId())) {
                return (bj) next;
            }
        }
        return null;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (this.threadList != null && jVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next != null && (next instanceof bj) && ((bj) next).getAuthor() != null && currentAccount.equals(((bj) next).getAuthor().getUserId()) && ((bj) next).getAuthor().getPendantData() != null) {
                        ((bj) next).getAuthor().getPendantData().P(jVar.Cw());
                        ((bj) next).getAuthor().getPendantData().cA(jVar.pR());
                    }
                }
            }
        }
    }

    public void ao(bj bjVar) {
        this.threadList.remove(bjVar);
    }

    public boolean e(g gVar) {
        if (gVar == null) {
            return false;
        }
        d(gVar.qn());
        a(gVar.bqy());
        mB(gVar.bqu());
        rR(gVar.bqv());
        c(gVar.aOV());
        setGameName(gVar.getGameName());
        rS(gVar.bqC());
        a(gVar.bqw());
        mC(gVar.bqz());
        nr(gVar.aPj());
        dl(gVar.bqB());
        tm(gVar.bqH());
        c(gVar.bqF());
        a(gVar.qD());
        a(gVar.bqs());
        dj(gVar.bqA());
        aA(gVar.getThreadList());
        di(gVar.bqx());
        setUserData(gVar.getUserData());
        setUserMap(gVar.getUserMap());
        a(gVar.bqt());
        dk(gVar.bqD());
        tn(gVar.bqM());
        dn(gVar.bqJ());
        rU(gVar.bqK());
        an(gVar.bqL());
        a(gVar.bqN());
        to(gVar.bqQ());
        a(gVar.bqR());
        a(gVar.bqS());
        tj(gVar.bqp());
        a(gVar.bqT());
        tk(gVar.bqq());
        tl(gVar.bqr());
        this.gfK = gVar.gfK;
        this.ggi = gVar.ggi;
        this.ggl = gVar.ggl;
        a(gVar.bqO());
        j(gVar.bqU());
        a(gVar.bqP());
        a(gVar.bqG());
        m12do(gVar.bqV());
        dp(gVar.bqW());
        mD(gVar.isShowDriftingBottle());
        cN(gVar.bqX());
        this.ggx = gVar.ggx;
        a(gVar.bqY());
        a(gVar.bqo());
        dh(gVar.bqn());
        a(gVar.bqZ());
        dq(gVar.bra());
        return true;
    }

    public void bro() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.eEb != null && this.eEb.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if (fVar instanceof bj) {
                    bj bjVar = (bj) fVar;
                    if (bjVar == null || (!bjVar.sc() && bjVar.ry() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.eEb.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                f fVar2 = new f();
                fVar2.setForumId(this.eEb.getId());
                fVar2.dg(feedForumList);
                this.threadList.add(i + 6, fVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mE(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!v.v(this.threadList)) {
            brp();
            if (bqY() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                    if (fVar instanceof bj) {
                        bj bjVar = (bj) fVar;
                        if (bjVar == null || (!bjVar.sc() && bjVar.ry() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bqY().anj() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((bqY().anj() + i) - 1, bqY());
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

    public void brp() {
        if (!v.v(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.cNj) {
                    it.remove();
                }
            }
        }
    }

    public boolean brq() {
        com.baidu.tieba.card.data.p recomTopicData;
        if (this.threadList == null || this.eEb == null || this.eEb.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
            if (fVar instanceof bj) {
                bj bjVar = (bj) fVar;
                if (bjVar == null || (!bjVar.sc() && bjVar.ry() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.eEb.getBannerListData().getRecomTopicData()) == null || v.u(recomTopicData.bND) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ak("c10835").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void brr() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bqQ = (bqQ() + akK()) - 1;
            if (bqR() != null && bqQ >= 0 && bqQ <= this.threadList.size()) {
                this.threadList.add(bqQ, bqR());
            }
        }
    }

    public void brs() {
        int intValue;
        if (bqG() != null && (bqG().position.intValue() + akK()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bqG());
        }
    }

    public List<com.baidu.adp.widget.ListView.f> brt() {
        return this.ggr;
    }

    public void dr(List<com.baidu.adp.widget.ListView.f> list) {
        this.ggr = list;
    }

    public boolean bru() {
        if (bqs() == null) {
            return false;
        }
        return bqs().brb() == 1;
    }

    public boolean brv() {
        return bqS() == null ? !v.v(bqD()) : !v.v(bqS().tab);
    }

    public void a(BannerListData bannerListData) {
        this.bdG = true;
        this.ggR = bannerListData;
    }
}
