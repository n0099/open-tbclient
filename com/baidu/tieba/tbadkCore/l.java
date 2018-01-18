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
    private boolean bYi;
    private int gWQ = 0;
    private BannerListData gWR;
    private List<RecmForumInfo> recm_forum_list;

    public void c(r rVar) {
        if (rVar != null) {
            this.fDm.setCurScore(rVar.getCurScore());
            this.fDm.setLevelupScore(rVar.getLevelupScore());
            this.fDm.setLike(rVar.isLike());
            this.fDm.setUser_level(rVar.bsa());
            this.fDm.setLevelName(rVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fDm.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fDm == null) {
            return null;
        }
        return this.fDm.getSignData();
    }

    public void but() {
        bg top_notice_data;
        com.baidu.adp.widget.ListView.i iVar;
        if (aYE() != null && this.threadList != null && (top_notice_data = aYE().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (iVar = this.threadList.get(0)) != null && (iVar instanceof bd) && ((bd) iVar).yN() == 2) {
                this.threadList.remove(0);
            }
            bd bdVar = new bd();
            bdVar.setTitle(top_notice_data.getTitle());
            bdVar.cK(top_notice_data.An());
            bdVar.eR(2);
            bdVar.zB();
            this.threadList.add(0, bdVar);
        }
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.threadList != null) {
            int aym = aym();
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
                    this.gWQ++;
                    this.threadList.add(aym, arVar);
                    return;
                }
                return;
            }
            this.gWQ++;
            this.threadList.add(aym, aiVar);
        }
    }

    public void buu() {
        this.gWQ = 0;
    }

    public int aym() {
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
                } else if (((bd) next).yN() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    private int yB() {
        Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.i next = it.next();
            if ((next instanceof bd) && ((bd) next).yP() == 1) {
                return ((bd) next).yB();
            }
        }
        return -1;
    }

    public void buv() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bd.aNc || this.threadList.get(i2).getType() == bd.aNd || this.threadList.get(i2).getType() == bd.aNe) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void buw() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.eOn != null && this.eOn.xS() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
                if ((iVar instanceof bd) && iVar.getType() == bd.aOm) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int aym = aym();
            if (i > aym) {
                this.threadList.add(aym, this.threadList.remove(i));
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
        if (!this.bYi) {
            if (this.fDm != null) {
                bannerListData = this.fDm.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gWR;
        }
        this.bYi = false;
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
            bVar3.cK(z);
            bVar3.V(arrayList);
            bVar3.X(arrayList2);
            bVar3.cL(z2);
            bVar3.eW(xY().xS());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar3));
        }
    }

    public void bux() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i);
            if (iVar instanceof bd) {
                bd bdVar = (bd) iVar;
                if (bdVar.isPhotoLiveThread() && !(bdVar instanceof ar)) {
                    ar arVar = new ar();
                    arVar.B(btM());
                    arVar.a(bdVar, 0);
                    if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, arVar);
                    }
                }
            }
        }
    }

    public void buy() {
        int i;
        if (aYE() != null) {
            List<PhotoLiveCardData> btM = btM();
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (btM != null && btM.size() > 0 && threadList != null && threadList.size() > 0) {
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
                a(arVar, btM);
                getThreadList().add(vG, arVar);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.i
    public List<RecmForumInfo> btz() {
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
        int aym = aym();
        int btR = btR();
        if (btP()) {
            btR++;
        }
        return Math.min((btR + aym) - 1, i);
    }

    public void buz() {
        f buo;
        if (this.threadList != null && aYE() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null && (buo = buo()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            a(f.class, threadList);
            if (!com.baidu.tbadk.core.util.v.E(buo.gVb)) {
                threadList.add(cJ(1, threadList.size()), buo);
            }
        }
    }

    public void buA() {
        a(f.class, getThreadList());
    }

    public void buB() {
        e bun;
        if (this.threadList != null && aYE() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null && (bun = bun()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            a(e.class, threadList);
            threadList.add(cJ(bun.gUZ, threadList.size()), bun);
        }
    }

    public void buC() {
        a(e.class, getThreadList());
    }

    private int cJ(int i, int i2) {
        int aym = aym();
        if (btP()) {
            i++;
        }
        return Math.min((aym + i) - 1, i2);
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

    public void buD() {
        bd btV;
        int i;
        if (aYE() != null && (btV = btV()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + btV.getTid());
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
                threadList.add(vG(i), btV);
            }
        }
    }

    public void buE() {
        if (aYE() != null) {
            List<com.baidu.adp.widget.ListView.i> bug = bug();
            List<Integer> buf = buf();
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (buf != null && buf.size() > 0 && bug != null && bug.size() > 0 && threadList != null) {
                int size = buf.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bug.size()) {
                        com.baidu.adp.widget.ListView.i iVar = bug.get(i);
                        int cK = cK(buf.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + cK + "  Title:" + iVar.getType());
                        threadList.add(cK, iVar);
                    }
                }
            }
        }
    }

    private int cK(int i, int i2) {
        int aym = aym();
        if (btP()) {
            i++;
        }
        return Math.min((aym + i) - 1, i2);
    }

    public void buF() {
        if (btP()) {
            int aym = aym();
            if (yB() == 0) {
                aym++;
            }
            as asVar = new as();
            asVar.a(btQ());
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(aym, asVar);
            }
        }
    }

    public bd so(String str) {
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
                    if (next != null && (next instanceof bd) && ((bd) next).yS() != null && currentAccount.equals(((bd) next).yS().getUserId()) && ((bd) next).yS().getPendantData() != null) {
                        ((bd) next).yS().getPendantData().ab(hVar.JW());
                        ((bd) next).yS().getPendantData().cM(hVar.xt());
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
        c(iVar.xG());
        a(iVar.btJ());
        mt(iVar.btF());
        sk(iVar.btG());
        c(iVar.aYE());
        setGameName(iVar.getGameName());
        sl(iVar.btN());
        a(iVar.btH());
        mu(iVar.btK());
        sw(iVar.aYT());
        dl(iVar.btM());
        vC(iVar.btR());
        b(iVar.btQ());
        a(iVar.xY());
        a(iVar.btD());
        dj(iVar.btL());
        at(iVar.getThreadList());
        di(iVar.btI());
        e(iVar.getUserData());
        setUserMap(iVar.getUserMap());
        a(iVar.btE());
        dk(iVar.btO());
        vD(iVar.btW());
        dn(iVar.btT());
        sn(iVar.btU());
        af(iVar.btV());
        a(iVar.btX());
        vE(iVar.bua());
        a(iVar.bub());
        a(iVar.buc());
        vz(iVar.btA());
        a(iVar.bud());
        vA(iVar.btB());
        vB(iVar.btC());
        this.gVC = iVar.gVC;
        this.gVZ = iVar.gVZ;
        this.gWc = iVar.gWc;
        a(iVar.btY());
        j(iVar.bue());
        a(iVar.btZ());
        m14do(iVar.buf());
        dp(iVar.bug());
        this.gWp = iVar.gWp;
        a(iVar.buh());
        a(iVar.btx());
        a(iVar.bui());
        dq(iVar.buj());
        vF(iVar.buk());
        a(iVar.bty());
        a(iVar.bul());
        a(iVar.bum());
        this.gWy = iVar.gWy;
        b(iVar.bun());
        this.recm_forum_list = iVar.btz();
        b(iVar.buo());
        this.gWA = iVar.gWA;
        return true;
    }

    public void buG() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fDm != null && this.fDm.getBannerListData() != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
                if (iVar instanceof bd) {
                    bd bdVar = (bd) iVar;
                    if (bdVar == null || (!bdVar.zt() && bdVar.yP() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.fDm.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                h hVar = new h();
                hVar.setForumId(this.fDm.getId());
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
    public void mv(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.E(this.threadList)) {
            buH();
            if (buh() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
                    if (iVar instanceof bd) {
                        bd bdVar = (bd) iVar;
                        if (bdVar == null || (!bdVar.zt() && bdVar.yP() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((buh().azG() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((buh().azG() + i) - 1, buh());
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

    public void buH() {
        if (!com.baidu.tbadk.core.util.v.E(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.dVF) {
                    it.remove();
                }
            }
        }
    }

    public boolean buI() {
        com.baidu.tieba.card.data.p recomTopicData;
        if (this.threadList == null || this.fDm == null || this.fDm.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
            if (iVar instanceof bd) {
                bd bdVar = (bd) iVar;
                if (bdVar == null || (!bdVar.zt() && bdVar.yP() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fDm.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.D(recomTopicData.cXw) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ak("c10835").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void buJ() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            int bua = (bua() + aym()) - 1;
            if (bub() != null && bua >= 0 && bua <= this.threadList.size()) {
                this.threadList.add(bua, bub());
            }
        }
    }

    public void buK() {
        int zR;
        if (bul() != null) {
            com.baidu.tieba.frs.s bul = bul();
            if (com.baidu.tbadk.core.util.v.D(bul.getUserInfo()) >= 3 && (zR = bul.zR()) > 0) {
                int aym = zR + aym();
                if (aym > this.threadList.size()) {
                    this.threadList.add(bul);
                } else {
                    this.threadList.add(aym, bul);
                }
            }
        }
    }

    public void buL() {
        if (bum() != null && !com.baidu.tbadk.core.util.v.E(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next != null && next.getType() == k.gWP) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, bum());
        }
    }

    public List<com.baidu.adp.widget.ListView.i> buM() {
        return this.gWi;
    }

    public void dr(List<com.baidu.adp.widget.ListView.i> list) {
        this.gWi = list;
    }

    public boolean buN() {
        if (btD() == null) {
            return false;
        }
        return btD().bup() == 1;
    }

    public boolean buO() {
        return buc() == null ? !com.baidu.tbadk.core.util.v.E(btO()) : !com.baidu.tbadk.core.util.v.E(buc().tab);
    }

    public void a(BannerListData bannerListData) {
        this.bYi = true;
        this.gWR = bannerListData;
    }
}
