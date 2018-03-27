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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes.dex */
public class m extends j implements com.baidu.tbadk.mvc.b.l {
    private boolean cap;
    private int gZL = 0;
    private BannerListData gZM;
    private List<RecmForumInfo> recm_forum_list;

    public void c(s sVar) {
        if (sVar != null) {
            this.fHj.setCurScore(sVar.getCurScore());
            this.fHj.setLevelupScore(sVar.getLevelupScore());
            this.fHj.setLike(sVar.isLike());
            this.fHj.setUser_level(sVar.btq());
            this.fHj.setLevelName(sVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        if (signData != null) {
            this.fHj.setSignData(signData);
        }
    }

    public SignData getSignData() {
        if (this.fHj == null) {
            return null;
        }
        return this.fHj.getSignData();
    }

    public void bvO() {
        bg top_notice_data;
        com.baidu.adp.widget.ListView.i iVar;
        if (bas() != null && this.threadList != null && (top_notice_data = bas().getTop_notice_data()) != null && top_notice_data.getTitle() != null) {
            while (!this.threadList.isEmpty() && (iVar = this.threadList.get(0)) != null && (iVar instanceof bd) && ((bd) iVar).zi() == 2) {
                this.threadList.remove(0);
            }
            bd bdVar = new bd();
            bdVar.setTitle(top_notice_data.getTitle());
            bdVar.cV(top_notice_data.AI());
            bdVar.eR(2);
            bdVar.zW();
            this.threadList.add(0, bdVar);
        }
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.threadList != null) {
            int azu = azu();
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
                    this.gZL++;
                    this.threadList.add(azu, arVar);
                    return;
                }
                return;
            }
            this.gZL++;
            this.threadList.add(azu, aiVar);
        }
    }

    public void bvP() {
        this.gZL = 0;
    }

    public int azu() {
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
                } else if (((bd) next).zi() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    private int yW() {
        Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.i next = it.next();
            if ((next instanceof bd) && ((bd) next).zk() == 1) {
                return ((bd) next).yW();
            }
        }
        return -1;
    }

    public void bvQ() {
        if (this.threadList != null && this.threadList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.threadList.size()) {
                    if (this.threadList.get(i2).getType() == bd.aOo || this.threadList.get(i2).getType() == bd.aOp || this.threadList.get(i2).getType() == bd.aOq) {
                        this.threadList.remove(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bvR() {
        int i;
        if (this.threadList != null && this.threadList.size() > 0 && this.eSZ != null && this.eSZ.yu() == 1 && this.threadList != null && this.threadList.size() > 0) {
            int size = this.threadList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
                if ((iVar instanceof bd) && iVar.getType() == bd.aPy) {
                    i = i2;
                    break;
                }
                i2++;
            }
            int azu = azu();
            if (i > azu) {
                this.threadList.add(azu, this.threadList.remove(i));
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
        if (!this.cap) {
            if (this.fHj != null) {
                bannerListData = this.fHj.getBannerListData();
            } else {
                return;
            }
        } else {
            bannerListData = this.gZM;
        }
        this.cap = false;
        if (bannerListData != null && bannerListData.getAllAdvertList() != null && arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<AdvertAppInfo> it = bannerListData.getAllAdvertList().iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next());
            }
            bVar2.Y(arrayList3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            com.baidu.tieba.InjectPlugin.b.b bVar3 = new com.baidu.tieba.InjectPlugin.b.b(bVar, 3);
            bVar3.cP(z);
            bVar3.X(arrayList);
            bVar3.Z(arrayList2);
            bVar3.cQ(z2);
            bVar3.eW(yA().yu());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar3));
        }
    }

    public void bvS() {
        int size = this.threadList.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i);
            if (iVar instanceof bd) {
                bd bdVar = (bd) iVar;
                if (bdVar.isPhotoLiveThread() && !(bdVar instanceof ar)) {
                    ar arVar = new ar();
                    arVar.B(bvf());
                    arVar.a(bdVar, 0);
                    if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.threadList.set(i, arVar);
                    }
                }
            }
        }
    }

    public void bvT() {
        int i;
        if (bas() != null) {
            List<PhotoLiveCardData> bvf = bvf();
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (bvf != null && bvf.size() > 0 && threadList != null && threadList.size() > 0) {
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
                int vH = vH(i);
                ar arVar = new ar();
                a(arVar, bvf);
                getThreadList().add(vH, arVar);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.j
    public List<RecmForumInfo> buR() {
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
            arVar.cZ(photoLiveCardData.getForumName());
            arVar.setTitle(photoLiveCardData.getTitle());
            arVar.setPhotoLiveCover(photoLiveCardData.getPhotoLiveCover());
            arVar.cV(photoLiveCardData.getThreadId() + "");
            arVar.v(photoLiveCardData.getLastModifiedTime());
            arVar.eP(photoLiveCardData.getDiscussNum());
        }
    }

    private int vH(int i) {
        int azu = azu();
        int bvk = bvk();
        if (bvi()) {
            bvk++;
        }
        return Math.min((bvk + azu) - 1, i);
    }

    public void bvU() {
        g bvH;
        if (this.threadList != null && bas() != null && MessageManager.getInstance().findTask(2911003) != null && (bvH = bvH()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            a(g.class, threadList);
            if (!com.baidu.tbadk.core.util.v.E(bvH.gXU)) {
                threadList.add(cE(1, threadList.size()), bvH);
            }
        }
    }

    public void bvV() {
        a(g.class, getThreadList());
    }

    public void bvW() {
        f bvG;
        if (this.threadList != null && bas() != null && MessageManager.getInstance().findTask(2911003) != null && (bvG = bvG()) != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            a(f.class, threadList);
            threadList.add(cE(bvG.gXS, threadList.size()), bvG);
        }
    }

    public void bvX() {
        a(f.class, getThreadList());
    }

    private int cE(int i, int i2) {
        int azu = azu();
        if (bvi()) {
            i++;
        }
        return Math.min((azu + i) - 1, i2);
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

    public void bvY() {
        bd bvo;
        int i;
        if (bas() != null && (bvo = bvo()) != null) {
            Log.e("FrsActivity", "addCardVideoInfoToThreadList cardVideoInfo:" + bvo.getTid());
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
                threadList.add(vH(i), bvo);
            }
        }
    }

    public void bvZ() {
        if (bas() != null) {
            List<com.baidu.adp.widget.ListView.i> bvz = bvz();
            List<Integer> bvy = bvy();
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (bvy != null && bvy.size() > 0 && bvz != null && bvz.size() > 0 && threadList != null) {
                int size = bvy.size();
                int size2 = threadList.size();
                for (int i = 0; i < size; i++) {
                    if (i < bvz.size()) {
                        com.baidu.adp.widget.ListView.i iVar = bvz.get(i);
                        int cF = cF(bvy.get(i).intValue(), size2);
                        Log.e("FrsActivity", "addVideoInfoToThreadListInTenAndFifteenFloor  insertPos:" + cF + "  Title:" + iVar.getType());
                        threadList.add(cF, iVar);
                    }
                }
            }
        }
    }

    private int cF(int i, int i2) {
        int azu = azu();
        if (bvi()) {
            i++;
        }
        return Math.min((azu + i) - 1, i2);
    }

    public void bwa() {
        if (bvi()) {
            int azu = azu();
            if (yW() == 0) {
                azu++;
            }
            as asVar = new as();
            asVar.a(bvj());
            ArrayList<com.baidu.adp.widget.ListView.i> threadList = getThreadList();
            if (threadList != null && threadList.size() > 0) {
                threadList.add(azu, asVar);
            }
        }
    }

    public bd sE(String str) {
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
                    if (next != null && (next instanceof bd) && ((bd) next).zn() != null && currentAccount.equals(((bd) next).zn().getUserId()) && ((bd) next).zn().getPendantData() != null) {
                        ((bd) next).zn().getPendantData().ab(hVar.KE());
                        ((bd) next).zn().getPendantData().cX(hVar.ya());
                    }
                }
            }
        }
    }

    public void aj(bd bdVar) {
        this.threadList.remove(bdVar);
    }

    public boolean e(j jVar) {
        if (jVar == null) {
            return false;
        }
        c(jVar.yn());
        a(jVar.bvc());
        mI(jVar.buY());
        sA(jVar.buZ());
        c(jVar.bas());
        setGameName(jVar.getGameName());
        sB(jVar.bvg());
        a(jVar.bva());
        mJ(jVar.bvd());
        sA(jVar.baH());
        dr(jVar.bvf());
        vD(jVar.bvk());
        b(jVar.bvj());
        a(jVar.yA());
        a(jVar.buV());
        dp(jVar.bve());
        au(jVar.getThreadList());
        m17do(jVar.bvb());
        e(jVar.getUserData());
        setUserMap(jVar.getUserMap());
        a(jVar.buX());
        dq(jVar.bvh());
        vE(jVar.bvp());
        dt(jVar.bvm());
        sD(jVar.bvn());
        ai(jVar.bvo());
        a(jVar.bvq());
        vF(jVar.bvt());
        a(jVar.bvu());
        a(jVar.bvv());
        vA(jVar.buS());
        a(jVar.bvw());
        vB(jVar.buT());
        vC(jVar.buU());
        this.gYv = jVar.gYv;
        this.gYS = jVar.gYS;
        this.gYV = jVar.gYV;
        a(jVar.bvr());
        j(jVar.bvx());
        a(jVar.bvs());
        du(jVar.bvy());
        dv(jVar.bvz());
        this.gZi = jVar.gZi;
        a(jVar.bvA());
        a(jVar.buP());
        a(jVar.bvB());
        dw(jVar.bvC());
        vG(jVar.bvD());
        a(jVar.buQ());
        a(jVar.bvE());
        a(jVar.bvF());
        this.gZr = jVar.gZr;
        b(jVar.bvG());
        this.recm_forum_list = jVar.buR();
        b(jVar.bvH());
        this.dJs = jVar.dJs;
        this.gZt = jVar.gZt;
        b(jVar.buW());
        this.gZu = jVar.gZu;
        return true;
    }

    public void bwb() {
        List<FeedForumData> feedForumList;
        if (this.threadList != null && this.fHj != null && this.fHj.getBannerListData() != null && MessageManager.getInstance().findTask(2003016) != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
                if (iVar instanceof bd) {
                    bd bdVar = (bd) iVar;
                    if (bdVar == null || (!bdVar.zO() && bdVar.zk() != 1)) {
                        break;
                    }
                    i++;
                }
            }
            if (this.threadList.size() - i > 7 && (feedForumList = this.fHj.getBannerListData().getFeedForumList()) != null && feedForumList.size() > 0) {
                i iVar2 = new i();
                iVar2.setForumId(this.fHj.getId());
                iVar2.dn(feedForumList);
                this.threadList.add(i + 6, iVar2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mK(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!com.baidu.tbadk.core.util.v.E(this.threadList)) {
            bwc();
            if (bvA() != null) {
                int i = 0;
                for (int i2 = 0; i2 < this.threadList.size(); i2++) {
                    com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
                    if (iVar instanceof bd) {
                        bd bdVar = (bd) iVar;
                        if (bdVar == null || (!bdVar.zO() && bdVar.zk() != 1)) {
                            break;
                        }
                        i++;
                    }
                }
                if ((bvA().aBf() + i) - 1 < this.threadList.size()) {
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
                                this.threadList.add((bvA().aBf() + i) - 1, bvA());
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

    public void bwc() {
        if (!com.baidu.tbadk.core.util.v.E(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next != null && next.getType() == com.baidu.tieba.g.b.eaq) {
                    it.remove();
                }
            }
        }
    }

    public boolean bwd() {
        com.baidu.tieba.card.data.o recomTopicData;
        if (this.threadList == null || this.fHj == null || this.fHj.getBannerListData() == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.threadList.size(); i2++) {
            com.baidu.adp.widget.ListView.i iVar = this.threadList.get(i2);
            if (iVar instanceof bd) {
                bd bdVar = (bd) iVar;
                if (bdVar == null || (!bdVar.zO() && bdVar.zk() != 1)) {
                    break;
                }
                i++;
            }
        }
        if (this.threadList.size() - i <= 7 || (recomTopicData = this.fHj.getBannerListData().getRecomTopicData()) == null || com.baidu.tbadk.core.util.v.D(recomTopicData.daw) < 4) {
            return false;
        }
        this.threadList.add(i + 6, recomTopicData);
        TiebaStatic.log(new ak("c10835").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        return true;
    }

    public void bwe() {
        if (MessageManager.getInstance().findTask(2003016) != null) {
            int bvt = (bvt() + azu()) - 1;
            if (bvu() != null && bvt >= 0 && bvt <= this.threadList.size()) {
                this.threadList.add(bvt, bvu());
            }
        }
    }

    public void bwf() {
        int Al;
        if (bvE() != null) {
            com.baidu.tieba.frs.s bvE = bvE();
            if (com.baidu.tbadk.core.util.v.D(bvE.getUserInfo()) >= 3 && (Al = bvE.Al()) > 0) {
                int azu = Al + azu();
                if (azu > this.threadList.size()) {
                    this.threadList.add(bvE);
                } else {
                    this.threadList.add(azu, bvE);
                }
            }
        }
    }

    public void bwg() {
        if (!com.baidu.tbadk.core.util.v.E(this.threadList)) {
            boolean z = false;
            Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
            while (true) {
                boolean z2 = z;
                if (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.s) {
                        if (z2) {
                            it.remove();
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    return;
                }
            }
        }
    }

    public void bwh() {
        if (bvF() != null && !com.baidu.tbadk.core.util.v.E(this.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next != null && next.getType() == l.gZK) {
                    this.threadList.remove(next);
                    break;
                }
            }
            this.threadList.add(0, bvF());
        }
    }

    public List<com.baidu.adp.widget.ListView.i> bwi() {
        return this.gZb;
    }

    public void dx(List<com.baidu.adp.widget.ListView.i> list) {
        this.gZb = list;
    }

    public boolean bwj() {
        if (buV() == null) {
            return false;
        }
        return buV().bvJ() == 1;
    }

    public boolean bwk() {
        return bvv() == null ? !com.baidu.tbadk.core.util.v.E(bvh()) : !com.baidu.tbadk.core.util.v.E(bvv().tab);
    }

    public void a(BannerListData bannerListData) {
        this.cap = true;
        this.gZM = bannerListData;
    }
}
