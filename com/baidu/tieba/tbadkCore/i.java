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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class i extends g implements com.baidu.tbadk.mvc.b.l {
    private boolean bdI;
    private int gip = 0;
    private BannerListData giq;

    public void c(o oVar) {
        if (oVar != null) {
            this.eFF.setCurScore(oVar.getCurScore());
            this.eFF.setLevelupScore(oVar.getLevelupScore());
            this.eFF.setLike(oVar.isLike());
            this.eFF.setUser_level(oVar.getUserLevel());
            this.eFF.setLevelName(oVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.eFF.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.eFF == null) {
            return null;
        }
        return this.eFF.getSignData();
    }

    public void brX() {
        bn top_notice_data;
        com.baidu.adp.widget.ListView.f fVar;
        if (aPO() != null && this.threadList != null && (top_notice_data = aPO().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (fVar = this.threadList.get(0)) != null && (fVar instanceof bl) && ((bl) fVar).rA() == 2) {
                this.threadList.remove(0);
            }
            bl blVar = new bl();
            blVar.setTitle(top_notice_data.getTitle());
            blVar.cF(top_notice_data.td());
            blVar.bT(2);
            blVar.sn();
            this.threadList.add(0, blVar);
        }
    }

    public void a(ao aoVar) {
        if (aoVar != null && !StringUtils.isNull(aoVar.getId()) && this.threadList != null) {
            int ajh = ajh();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = threadList.get(i);
                    if ((fVar instanceof bl) && aoVar.getId().equals(((bl) fVar).getId())) {
                        return;
                    }
                }
            }
            if (aoVar.isPhotoLiveThread()) {
                ax axVar = new ax();
                axVar.a(aoVar, -1);
                axVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.gip++;
                    this.threadList.add(ajh, axVar);
                    return;
                }
                return;
            }
            this.gip++;
            this.threadList.add(ajh, aoVar);
        }
    }

    public void brY() {
        this.gip = 0;
    }

    public int ajh() {
        int i = 0;
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof bl)) {
                    i = i2;
                } else if (((bl) next).rA() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    private int ro() {
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
            if ((next instanceof bl) && ((bl) next).rC() == 1) {
                return ((bl) next).ro();
            }
        }
        return -1;
    }

    public void brZ() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bl.Zg || this.threadList.get(i2).getType() == bl.Zh || this.threadList.get(i2).getType() == bl.Zi) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bsa() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.dGu != null && this.dGu.qB() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if ((fVar instanceof bl) && fVar.getType() == bl.aao) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int ajh = ajh();
            if (i > ajh) {
                this.threadList.add(ajh, this.threadList.remove(i));
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
        if (!this.bdI) {
            if (this.eFF != null) {
                bannerListData = this.eFF.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.giq;
        }
        this.bdI = false;
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
            bVar3.cj(z);
            bVar3.setThreadList(arrayList);
            bVar3.O(arrayList2);
            bVar3.ck(z2);
            bVar3.bX(qH().qB());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void bsb() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i);
            if (fVar instanceof bl) {
                bl blVar = (bl) fVar;
                if (blVar.isPhotoLiveThread() && !(blVar instanceof ax)) {
                    ax axVar = new ax();
                    axVar.r(brt());
                    axVar.a(blVar, 0);
                    if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, axVar);
                    }
                }
            }
        }
    }

    public void bsc() {
        int i;
        if (aPO() != null) {
            List<PhotoLiveCardData> brt = brt();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (brt != null && brt.size() > 0 && threadList != null && threadList.size() > 0) {
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
                int tn = tn(i);
                ax axVar = new ax();
                a(axVar, brt);
                getThreadList().add(tn, axVar);
            }
        }
    }

    private void a(ax axVar, List<PhotoLiveCardData> list) {
        if (axVar != null && !com.baidu.tbadk.core.util.u.v(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            axVar.setThreadType(33);
            axVar.setAuthor(metaData);
            axVar.cJ(photoLiveCardData.getForumName());
            axVar.setTitle(photoLiveCardData.getTitle());
            axVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            axVar.cF(photoLiveCardData.getThreadId() + "");
            axVar.m(photoLiveCardData.getLastModifiedTime());
            axVar.bR(photoLiveCardData.getDiscussNum());
        }
    }

    private int tn(int i) {
        int ajh = ajh();
        int brz = brz();
        if (brw()) {
            brz++;
        }
        return Math.min((brz + ajh) - 1, i);
    }

    public void bsd() {
        bl brD;
        int i;
        if (aPO() != null && (brD = brD()) != null) {
            Log.e(PbActivityConfig.VALUE_FROM_FRS, "addCardVideoInfoToThreadList cardVideoInfo:" + brD.getTid());
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
                threadList.add(tn(i), brD);
            }
        }
    }

    public void bse() {
        if (aPO() != null) {
            List<com.baidu.adp.widget.ListView.f> brO = brO();
            List<Integer> brN = brN();
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (brN != null && brN.size() > 0 && brO != null && brO.size() > 0 && threadList != null) {
                int size = brN.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < brO.size()) {
                        com.baidu.adp.widget.ListView.f fVar = brO.get(i);
                        int bD = bD(brN.get(i).intValue(), size2);
                        Log.e(PbActivityConfig.VALUE_FROM_FRS, "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + bD + "  Title:" + fVar.getType());
                        threadList.add(bD, fVar);
                    }
                }
            }
        }
    }

    private int bD(int i, int i2) {
        int ajh = ajh();
        if (brw()) {
            i++;
        }
        return Math.min((ajh + i) - 1, i2);
    }

    public void bsf() {
        if (brw()) {
            int ajh = ajh();
            if (ro() == 0) {
                ajh++;
            }
            ay ayVar = new ay();
            ayVar.a(brx());
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(ajh, ayVar);
            }
        }
    }

    public bl rV(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
            if (next != null && (next instanceof bl) && TextUtils.equals(str, ((bl) next).getId())) {
                return (bl) next;
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
                    if (next != null && (next instanceof bl) && ((bl) next).getAuthor() != null && currentAccount.equals(((bl) next).getAuthor().getUserId()) && ((bl) next).getAuthor().getPendantData() != null) {
                        ((bl) next).getAuthor().getPendantData().Q(jVar.CB());
                        ((bl) next).getAuthor().getPendantData().cH(jVar.pV());
                    }
                }
            }
        }
    }

    public void ai(bl blVar) {
        this.threadList.remove(blVar);
    }

    public boolean e(g gVar) {
        if (gVar == null) {
            return false;
        }
        d(gVar.qr());
        a(gVar.brq());
        mv(gVar.brm());
        rR(gVar.brn());
        c(gVar.aPO());
        setGameName(gVar.getGameName());
        rS(gVar.bru());
        a(gVar.bro());
        mw(gVar.brr());
        mY(gVar.aQc());
        m12do(gVar.brt());
        tk(gVar.brz());
        c(gVar.brx());
        a(gVar.qH());
        a(gVar.brk());
        dm(gVar.brs());
        aB(gVar.getThreadList());
        dl(gVar.brp());
        setUserData(gVar.getUserData());
        setUserMap(gVar.getUserMap());
        a(gVar.brl());
        dn(gVar.brv());
        tl(gVar.brE());
        dq(gVar.brB());
        rU(gVar.brC());
        ah(gVar.brD());
        a(gVar.brF());
        tm(gVar.brI());
        a(gVar.brJ());
        a(gVar.brK());
        th(gVar.brh());
        a(gVar.brL());
        ti(gVar.bri());
        tj(gVar.brj());
        this.ghi = gVar.ghi;
        this.ghG = gVar.ghG;
        this.ghJ = gVar.ghJ;
        a(gVar.brG());
        i(gVar.brM());
        a(gVar.brH());
        a(gVar.bry());
        dr(gVar.brN());
        ds(gVar.brO());
        mx(gVar.isShowDriftingBottle());
        cS(gVar.brP());
        this.ghV = gVar.ghV;
        a(gVar.brQ());
        a(gVar.brg());
        dk(gVar.brf());
        a(gVar.brR());
        dt(gVar.brS());
        return true;
    }

    public void bsg() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.eFF != null && this.eFF.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                if (fVar instanceof bl) {
                    bl blVar = (bl) fVar;
                    if (blVar == null || (!blVar.sg() && blVar.rC() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.eFF.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                f fVar2 = new f();
                fVar2.setForumId(this.eFF.getId());
                fVar2.dj(feedForumList);
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
        if (!com.baidu.tbadk.core.util.u.v(this.threadList)) {
            bsh();
            if (brQ() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
                    if (fVar instanceof bl) {
                        bl blVar = (bl) fVar;
                        if (blVar == null || (!blVar.sg() && blVar.rC() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((brQ().alH() + i) - 1 < this.threadList.size()) {
                    String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("game_rank_list_info", "");
                    if (StringUtils.isNull(string) || string.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length != 2) {
                        z2 = true;
                    } else {
                        z2 = UtilHelper.getDayBetweenTime(com.baidu.adp.lib.g.b.d(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0], 0L), System.currentTimeMillis()) >= ((long) com.baidu.adp.lib.g.b.g(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1], 0));
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
                                this.threadList.add((brQ().alH() + i) - 1, brQ());
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

    public void bsh() {
        if (!com.baidu.tbadk.core.util.u.v(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.cGU) {
                    it.remove();
                }
            }
        }
    }

    public boolean bsi() {
        com.baidu.tieba.card.data.p recomTopicData;
        if (this.threadList == null || this.eFF == null || this.eFF.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.f fVar = this.threadList.get(i2);
            if (fVar instanceof bl) {
                bl blVar = (bl) fVar;
                if (blVar == null || (!blVar.sg() && blVar.rC() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.eFF.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.u.u(recomTopicData.bKK) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new aj("c10835").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bsj() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int brI = (brI() + ajh()) - 1;
            if (brJ() != null && brI >= 0 && brI <= this.threadList.size()) {
                this.threadList.add(brI, brJ());
            }
        }
    }

    public void bsk() {
        int intValue;
        if (bry() != null && (bry().position.intValue() + ajh()) - 1 >= 0 && intValue <= this.threadList.size()) {
            this.threadList.add(intValue, bry());
        }
    }

    public List<com.baidu.adp.widget.ListView.f> bsl() {
        return this.ghP;
    }

    public void du(List<com.baidu.adp.widget.ListView.f> list) {
        this.ghP = list;
    }

    public boolean bsm() {
        if (brk() == null) {
            return false;
        }
        return brk().brT() == 1;
    }

    public boolean bsn() {
        return brK() == null ? !com.baidu.tbadk.core.util.u.v(brv()) : !com.baidu.tbadk.core.util.u.v(brK().tab);
    }

    public void a(BannerListData bannerListData) {
        this.bdI = true;
        this.giq = bannerListData;
    }
}
