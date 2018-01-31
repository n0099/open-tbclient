package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes.dex */
public class l extends i implements com.baidu.tbadk.mvc.b.l {
    private boolean bYq;
    private int gXk = 0;
    private BannerListData gXl;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fDH.setCurScore(rVar.getCurScore());
            this.fDH.setLevelupScore(rVar.getLevelupScore());
            this.fDH.setLike(rVar.isLike());
            this.fDH.setUser_level(rVar.bsc());
            this.fDH.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fDH.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fDH == null) {
            return null;
        }
        return this.fDH.getSignData();
    }

    public void buv() {
        bg top_notice_data;
        com.baidu.adp.widget.ListView.i iVar;
        if (aYJ() != null && this.threadList != null && (top_notice_data = aYJ().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (iVar = this.threadList.get(0)) != null && (iVar instanceof bd) && ((bd) iVar).yO() == 2) {
                this.threadList.remove(0);
            }
            bd bdVar = new bd();
            bdVar.setTitle(top_notice_data.getTitle());
            bdVar.cK(top_notice_data.Ao());
            bdVar.eR(2);
            bdVar.zC();
            this.threadList.add(0, bdVar);
        }
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.threadList != null) {
            int ayr = ayr();
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.i iVar = threadList.get(i);
                    if ((iVar instanceof bd) && aiVar.getId().equals(((bd) iVar).getId())) {
                        return;
                    }
                }
            }
            if (aiVar.isPhotoLiveThread()) {
                ar arVar = new ar();
                arVar.a(aiVar, -1);
                arVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.gXk++;
                    this.threadList.add(ayr, arVar);
                    return;
                }
                return;
            }
            this.gXk++;
            this.threadList.add(ayr, aiVar);
        }
    }

    public void buw() {
        this.gXk = 0;
    }

    public int ayr() {
        int i = 0;
        if (this.threadList == null || this.threadList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (!(next instanceof bd)) {
                    i = i2;
                } else if (((bd) next).yO() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    private int yC() {
        Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.i next = it.next();
            if ((next instanceof bd) && ((bd) next).yQ() == 1) {
                return ((bd) next).yC();
            }
        }
        return -1;
    }

    public void bux() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bd.aNf || this.threadList.get(i2).getType() == bd.aNg || this.threadList.get(i2).getType() == bd.aNh) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void buy() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.eOI != null && this.eOI.xT() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
                if ((iVar instanceof bd) && iVar.getType() == bd.aOp) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int ayr = ayr();
            if (i > ayr) {
                this.threadList.add(ayr, this.threadList.remove(i));
            }
        }
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar) {
        a(bVar, false, this.threadList, null, false);
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        a(bVar, false, arrayList, null, false);
    }

    public void a(com.baidu.tieba.InjectPlugin.a.b bVar, boolean z, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, ArrayList<com.baidu.adp.widget.ListView.i> arrayList2, boolean z2) {
        BannerListData bannerListData;
        if (!this.bYq) {
            if (this.fDH != null) {
                bannerListData = this.fDH.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gXl;
        }
        this.bYq = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar2.W(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.cL(z);
            bVar3.V(arrayList);
            bVar3.X(arrayList2);
            bVar3.cM(z2);
            bVar3.eW(xZ().xT());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void buz() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i);
            if (iVar instanceof bd) {
                bd bdVar = (bd) iVar;
                if (bdVar.isPhotoLiveThread() && !(bdVar instanceof ar)) {
                    ar arVar = new ar();
                    arVar.B(btO());
                    arVar.a(bdVar, 0);
                    if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, arVar);
                    }
                }
            }
        }
    }

    public void buA() {
        int i;
        if (aYJ() != null) {
            List<PhotoLiveCardData> btO = btO();
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (btO != null && btO.size() > 0 && threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof ar)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                int vG = vG(i);
                ar arVar = new ar();
                a(arVar, btO);
                getThreadList().add(vG, arVar);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.i
    public List<RecmForumInfo> btB() {
        return this.recm_forum_list;
    }

    private void a(ar arVar, List<PhotoLiveCardData> list) {
        if (arVar != null && !com.baidu.tbadk.core.util.v.E(list) && list.get(0) != null) {
            PhotoLiveCardData photoLiveCardData = list.get(0);
            MetaData metaData = new MetaData();
            metaData.setName_show(photoLiveCardData.getAuthorName());
            metaData.setUserId(photoLiveCardData.getAuthorId());
            metaData.setPortrait(photoLiveCardData.getAuthorPortrait());
            metaData.setFansNickName(photoLiveCardData.getNickName());
            metaData.setFansNum(photoLiveCardData.getFansNum());
            arVar.setThreadType(33);
            arVar.a(metaData);
            arVar.cO(photoLiveCardData.getForumName());
            arVar.setTitle(photoLiveCardData.getTitle());
            arVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            arVar.cK(photoLiveCardData.getThreadId() + "");
            arVar.v(photoLiveCardData.getLastModifiedTime());
            arVar.eP(photoLiveCardData.getDiscussNum());
        }
    }

    private int vG(int i) {
        int ayr = ayr();
        int btT = btT();
        if (btR()) {
            btT++;
        }
        return Math.min((btT + ayr) - 1, i);
    }

    public void buB() {
        f buq;
        if (this.threadList != null && aYJ() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null && (buq = buq()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.v.E(buq.gVv)) {
                threadList.add(cJ(1, threadList.size()), buq);
            }
        }
    }

    public void buC() {
        a(f.class, getThreadList());
    }

    public void buD() {
        e bup;
        if (this.threadList != null && aYJ() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null && (bup = bup()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(cJ(bup.gVt, threadList.size()), bup);
        }
    }

    public void buE() {
        a(e.class, getThreadList());
    }

    private int cJ(int i, int i2) {
        int ayr = ayr();
        if (btR()) {
            i++;
        }
        return Math.min((ayr + i) - 1, i2);
    }

    private void a(Class cls, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                com.baidu.adp.widget.ListView.i iVar = arrayList.get(i);
                if (iVar.getClass() != cls) {
                    i++;
                } else {
                    arrayList2.add(iVar);
                    break;
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.removeAll(arrayList2);
            }
        }
    }

    public void buF() {
        bd btX;
        int i;
        if (aYJ() != null && (btX = btX()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + btX.getTid());
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                int size = threadList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i = size;
                        break;
                    } else if (!(threadList.get(i2) instanceof ar)) {
                        i2++;
                    } else {
                        threadList.remove(i2);
                        i = size - 1;
                        break;
                    }
                }
                threadList.add(vG(i), btX);
            }
        }
    }

    public void buG() {
        if (aYJ() != null) {
            List<com.baidu.adp.widget.ListView.i> bui = bui();
            List<Integer> buh = buh();
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (buh != null && buh.size() > 0 && bui != null && bui.size() > 0 && threadList != null) {
                int size = buh.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bui.size()) {
                        com.baidu.adp.widget.ListView.i iVar = bui.get(i);
                        int cK = cK(buh.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + cK + "  Title:" + iVar.getType());
                        threadList.add(cK, iVar);
                    }
                }
            }
        }
    }

    private int cK(int i, int i2) {
        int ayr = ayr();
        if (btR()) {
            i++;
        }
        return Math.min((ayr + i) - 1, i2);
    }

    public void buH() {
        if (btR()) {
            int ayr = ayr();
            if (yC() == 0) {
                ayr++;
            }
            as asVar = new as();
            asVar.a(btS());
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(ayr, asVar);
            }
        }
    }

    public bd sw(String str) {
        if (this.threadList == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.i next = it.next();
            if (next != null && (next instanceof bd) && TextUtils.equals(str, ((bd) next).getId())) {
                return (bd) next;
            }
        }
        return null;
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (this.threadList != null && hVar != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.i next = it.next();
                    if (next != null && (next instanceof bd) && ((bd) next).yT() != null && currentAccount.equals(((bd) next).yT().getUserId()) && ((bd) next).yT().getPendantData() != null) {
                        ((bd) next).yT().getPendantData().ab(hVar.JY());
                        ((bd) next).yT().getPendantData().cM(hVar.xu());
                    }
                }
            }
        }
    }

    public void ag(bd bdVar) {
        this.threadList.remove(bdVar);
    }

    public boolean e(i iVar) {
        if (iVar == null) {
            return false;
        }
        c(iVar.xH());
        a(iVar.btL());
        mv(iVar.btH());
        ss(iVar.btI());
        c(iVar.aYJ());
        setGameName(iVar.getGameName());
        st(iVar.btP());
        a(iVar.btJ());
        mw(iVar.btM());
        sw(iVar.aYY());
        dl(iVar.btO());
        vC(iVar.btT());
        b(iVar.btS());
        a(iVar.xZ());
        a(iVar.btF());
        dj(iVar.btN());
        at(iVar.getThreadList());
        di(iVar.btK());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.btG());
        dk(iVar.btQ());
        vD(iVar.btY());
        dn(iVar.btV());
        sv(iVar.btW());
        af(iVar.btX());
        a(iVar.btZ());
        vE(iVar.buc());
        a(iVar.bud());
        a(iVar.bue());
        vz(iVar.btC());
        a(iVar.buf());
        vA(iVar.btD());
        vB(iVar.btE());
        this.gVW = iVar.gVW;
        this.gWt = iVar.gWt;
        this.gWw = iVar.gWw;
        a(iVar.bua());
        j(iVar.bug());
        a(iVar.bub());
        m14do(iVar.buh());
        dp(iVar.bui());
        this.gWJ = iVar.gWJ;
        a(iVar.buj());
        a(iVar.btz());
        a(iVar.buk());
        dq(iVar.bul());
        vF(iVar.bum());
        a(iVar.btA());
        a(iVar.bun());
        a(iVar.buo());
        this.gWS = iVar.gWS;
        b(iVar.bup());
        this.recm_forum_list = iVar.btB();
        b(iVar.buq());
        this.gWU = iVar.gWU;
        return true;
    }

    public void buI() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fDH != null && this.fDH.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
                if (iVar instanceof bd) {
                    bd bdVar = (bd) iVar;
                    if (bdVar == null || (!bdVar.zu() && bdVar.yQ() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.fDH.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar = new h();
                hVar.setForumId(this.fDH.getId());
                hVar.dh(feedForumList);
                this.threadList.add(i + 6, hVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mx(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.E(this.threadList)) {
            buJ();
            if (buj() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
                    if (iVar instanceof bd) {
                        bd bdVar = (bd) iVar;
                        if (bdVar == null || (!bdVar.zu() && bdVar.yQ() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((buj().azL() + i) - 1 < this.threadList.size()) {
                    String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("game_rank_list_info", "");
                    if (StringUtils.isNull(string) || string.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length != 2) {
                        z2 = true;
                    } else {
                        z2 = UtilHelper.getDayBetweenTime(com.baidu.adp.lib.g.b.c(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0], 0L), System.currentTimeMillis()) >= ((long) com.baidu.adp.lib.g.b.h(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1], 0));
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
                                this.threadList.add((buj().azL() + i) - 1, buj());
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

    public void buJ() {
        if (!com.baidu.tbadk.core.util.v.E(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.dWa) {
                    it.remove();
                }
            }
        }
    }

    public boolean buK() {
        com.baidu.tieba.card.data.p recomTopicData;
        if (this.threadList == null || this.fDH == null || this.fDH.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
            if (iVar instanceof bd) {
                bd bdVar = (bd) iVar;
                if (bdVar == null || (!bdVar.zu() && bdVar.yQ() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fDH.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.D(recomTopicData.cXR) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ak("c10835").aa("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void buL() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int buc = (buc() + ayr()) - 1;
            if (bud() != null && buc >= 0 && buc <= this.threadList.size()) {
                this.threadList.add(buc, bud());
            }
        }
    }

    public void buM() {
        int zS;
        if (bun() != null) {
            com.baidu.tieba.frs.s bun = bun();
            if (com.baidu.tbadk.core.util.v.D(bun.getUserInfo()) >= 3 && (zS = bun.zS()) > 0) {
                int ayr = zS + ayr();
                if (ayr > this.threadList.size()) {
                    this.threadList.add(bun);
                } else {
                    this.threadList.add(ayr, bun);
                }
            }
        }
    }

    public void buN() {
        if (buo() != null && !com.baidu.tbadk.core.util.v.E(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next != null && next.getType() == k.gXj) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, buo());
        }
    }

    public List<com.baidu.adp.widget.ListView.i> buO() {
        return this.gWC;
    }

    public void dr(List<com.baidu.adp.widget.ListView.i> list) {
        this.gWC = list;
    }

    public boolean buP() {
        if (btF() == null) {
            return false;
        }
        return btF().bur() == 1;
    }

    public boolean buQ() {
        return bue() == null ? !com.baidu.tbadk.core.util.v.E(btQ()) : !com.baidu.tbadk.core.util.v.E(bue().tab);
    }

    public void a(BannerListData bannerListData) {
        this.bYq = true;
        this.gXl = bannerListData;
    }
}
