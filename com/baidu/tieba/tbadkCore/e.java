package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.UserData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tbclient.AnchorInfo;
import tbclient.FrsPage.AnchorPower;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.StarEnter;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class e {
    private AntiData DX;
    private ForumData bRO;
    private ArrayList<com.baidu.adp.widget.ListView.am> bRP;
    private t bRQ;
    private boolean bRR;
    private u bRS;
    private UserData bRT;
    private b bRU;
    private boolean bRV;
    private ArrayList<LiveCardData> bSc;
    private com.baidu.tbadk.core.data.p bsg;
    private String fortune_desc;
    private String gameName;
    private String game_url;
    private HashMap<String, MetaData> userMap;
    private List<o> star_enter = new ArrayList();
    private int arY = 0;
    private x bRW = null;
    private w bRX = null;
    private boolean bRY = false;
    private i bRZ = null;
    private f bSa = null;
    private boolean bSb = false;
    private long bsO = 0;
    private long bsP = 0;
    private long bsQ = 0;
    private long bsR = 0;

    public boolean aee() {
        return this.bRV;
    }

    public String getGameName() {
        return this.gameName;
    }

    public List<o> aef() {
        return this.star_enter;
    }

    public String aeg() {
        return this.game_url;
    }

    public ArrayList<LiveCardData> aeh() {
        return this.bSc;
    }

    public long TZ() {
        return this.bsR;
    }

    public long Ua() {
        return this.bsP;
    }

    public long Ub() {
        return this.bsQ;
    }

    public long Uc() {
        return this.bsO;
    }

    public boolean aei() {
        return this.bRR;
    }

    public e() {
        initData();
    }

    private void initData() {
        this.bRO = new ForumData();
        this.bRP = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.bsg = new com.baidu.tbadk.core.data.p();
        this.bRQ = new t();
        this.bRT = new UserData();
        this.bRS = new u();
        b(new AntiData());
        a(new b());
    }

    public void a(ae aeVar) {
        if (aeVar != null) {
            this.bRO.setCurScore(aeVar.getCurScore());
            this.bRO.setLevelupScore(aeVar.getLevelupScore());
            this.bRO.setLike(aeVar.isLike());
            this.bRO.setUser_level(aeVar.adi());
            this.bRO.setLevelName(aeVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        this.bRO.setSignData(signData);
    }

    public ForumData aej() {
        return this.bRO;
    }

    public void a(AnchorPower anchorPower) {
        this.bRO.setAnchorPower(anchorPower);
    }

    public void d(com.baidu.tbadk.core.data.w wVar) {
        while (!this.bRP.isEmpty() && this.bRP.get(0) != null && (this.bRP.get(0) instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) this.bRP.get(0)).getIs_top() == 2) {
            this.bRP.remove(0);
        }
        this.bRP.add(0, wVar);
    }

    public ArrayList<com.baidu.adp.widget.ListView.am> aek() {
        return this.bRP;
    }

    public UserData getUserData() {
        return this.bRT;
    }

    public void b(AntiData antiData) {
        this.DX = antiData;
    }

    public AntiData mP() {
        return this.DX;
    }

    public com.baidu.tbadk.core.data.p mY() {
        return this.bsg;
    }

    public t ael() {
        return this.bRQ;
    }

    public void ep(boolean z) {
        this.bRY = z;
    }

    public FrsPageResIdl B(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) new Wire(new Class[0]).parseFrom(bArr, FrsPageResIdl.class);
            if (frsPageResIdl != null && frsPageResIdl.data != null) {
                a(frsPageResIdl.data);
                return frsPageResIdl;
            }
            return frsPageResIdl;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            try {
                initData();
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i));
                        String userId = metaData.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.userMap.put(metaData.getUserId(), metaData);
                        }
                    }
                }
                gC(dataRes.is_new_url.intValue());
                this.bRR = dataRes.fortune_bag.intValue() == 1;
                this.fortune_desc = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.bRV = dataRes.forum.has_game.intValue() == 1;
                    this.game_url = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.star_enter.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        o oVar = new o();
                        oVar.a(list2.get(i2));
                        this.star_enter.add(oVar);
                    }
                }
                this.bRS.a(dataRes.gcon_account);
                this.bRO.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list3 = dataRes.thread_list;
                if (list3 != null) {
                    for (int i3 = 0; i3 < list3.size(); i3++) {
                        com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                        wVar.setUserMap(this.userMap);
                        wVar.a(list3.get(i3));
                        wVar.parser_title();
                        this.bRP.add(wVar);
                    }
                }
                this.DX.parserProtobuf(dataRes.anti);
                this.bRU.a(dataRes.group);
                this.bsg.a(dataRes.page);
                this.bRQ.a(dataRes.frs_star);
                this.bRT.parserProtobuf(dataRes.user);
                List<AnchorInfo> list4 = dataRes.forum_livegroup_list;
                this.bSc = new ArrayList<>();
                if (list4 != null) {
                    for (int i4 = 0; i4 < list4.size(); i4++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list4.get(i4));
                        this.bSc.add(liveCardData);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(BaseActivity baseActivity, FRSPageRequestMessage fRSPageRequestMessage, int i, boolean z, String str) {
        if (this.bRZ != null) {
            this.bRZ.cancel();
            this.bRZ = null;
        }
        this.bSb = z;
        this.bRZ = new i(this, baseActivity, fRSPageRequestMessage, i, str);
        this.bRZ.setPriority(3);
        this.bRZ.execute(fRSPageRequestMessage);
    }

    public void clear() {
        if (this.bRZ != null) {
            this.bRZ.cancel();
            this.bRZ = null;
        }
        if (this.bSa != null) {
            this.bSa.cancel();
            this.bSa = null;
        }
    }

    public void a(g gVar) {
        ae aeVar = new ae();
        aeVar.setLike(1);
        aeVar.hv(gVar.level);
        aeVar.setLevelName(gVar.bSj);
        aeVar.setCurScore(gVar.cur_score);
        aeVar.setLevelupScore(gVar.levelup_score);
        a(aeVar);
    }

    public void a(x xVar) {
        this.bRW = xVar;
    }

    public int Ci() {
        return this.arY;
    }

    public void gC(int i) {
        this.arY = i;
    }

    public b aem() {
        return this.bRU;
    }

    public void a(b bVar) {
        this.bRU = bVar;
    }

    public int aen() {
        if (this.bRP == null || this.bRP.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.am> it = this.bRP.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.am next = it.next();
            if (next instanceof com.baidu.tbadk.core.data.w) {
                if (((com.baidu.tbadk.core.data.w) next).getIs_top() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    public void au(Context context) {
        com.baidu.tbadk.core.data.f bannerListData;
        if (this.bRO != null && (bannerListData = this.bRO.getBannerListData()) != null && bannerListData.mA() != null && this.bRP != null && this.bRP.size() > 0) {
            int size = this.bRP.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    if (!(this.bRP.get(i) instanceof com.baidu.tbadk.core.data.c)) {
                        i++;
                    } else {
                        this.bRP.remove(i);
                        break;
                    }
                } else {
                    break;
                }
            }
            int size2 = this.bRP.size();
            Iterator<com.baidu.adp.widget.ListView.am> it = this.bRP.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.am next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) next).getIs_top() != 0) {
                    i2++;
                }
            }
            int size3 = bannerListData.mA().size();
            if (size3 >= 1) {
                HashSet hashSet = new HashSet();
                for (int i3 = 0; i3 < size3; i3++) {
                    com.baidu.tbadk.core.data.c cVar = bannerListData.mA().get(i3);
                    int i4 = (cVar.Dr + i2) - 1;
                    if (!hashSet.contains(Integer.valueOf(i4)) && cVar != null && cVar.mu() && i4 < size2) {
                        if (cVar.mv()) {
                            if (!ar.isInstalledPackage(context, cVar.Dq) && !TextUtils.isEmpty(cVar.Dq) && !TextUtils.isEmpty(cVar.Dm)) {
                                boolean dS = com.baidu.tbadk.download.b.uK().dS(cVar.Dq);
                                boolean dT = com.baidu.tbadk.download.b.uK().dT(cVar.Dq);
                                if (dS) {
                                    cVar.Dk = 1;
                                } else if (dT) {
                                    cVar.Dk = 2;
                                } else {
                                    cVar.Dk = 0;
                                }
                                hashSet.add(Integer.valueOf(i4));
                                this.bRP.add(i4, cVar);
                            }
                        } else if (cVar.mw()) {
                            hashSet.add(Integer.valueOf(i4));
                            this.bRP.add(i4, cVar);
                        }
                    }
                }
            }
        }
    }

    public void aeo() {
        boolean z = true;
        int i = 0;
        if (this.bRO != null && this.bsg != null && this.bsg.mU() == 1) {
            if (this.bRS == null || !this.bRS.aey()) {
                z = false;
            }
            if (this.bRR || z) {
                ag agVar = new ag();
                agVar.eq(this.bRR);
                agVar.hZ(this.fortune_desc);
                agVar.a(this.bRS);
                agVar.bp(1003);
                if (this.bRP != null && this.bRP.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.am> it = this.bRP.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.am next = it.next();
                        if ((next instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) next).getIs_top() != 0) {
                            i++;
                        }
                    }
                    this.bRP.add(i, agVar);
                }
            }
        }
    }

    public void aep() {
        com.baidu.tbadk.core.data.s recommendLikeUser;
        int i;
        int i2;
        if (this.bRO != null && (recommendLikeUser = this.bRO.getRecommendLikeUser()) != null && recommendLikeUser.nf() != null && !TextUtils.isEmpty(recommendLikeUser.nf().getName()) && this.bRP != null && this.bRP.size() > 0) {
            int size = this.bRP.size();
            Iterator<com.baidu.adp.widget.ListView.am> it = this.bRP.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.am next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) next).getIs_top() != 0) {
                    i3++;
                }
            }
            String ne = recommendLikeUser.ne();
            if (!TextUtils.isEmpty(ne) && !TextUtils.isEmpty(ne.trim()) && (i = com.baidu.adp.lib.g.c.toInt(ne, -1)) != -1 && (i + i3) - 1 < size) {
                this.bRP.add(i2, recommendLikeUser);
            }
        }
    }

    public com.baidu.tbadk.core.data.w hU(String str) {
        if (this.bRP == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.am> it = this.bRP.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.am next = it.next();
            if (next != null && (next instanceof com.baidu.tbadk.core.data.w) && TextUtils.equals(str, ((com.baidu.tbadk.core.data.w) next).getId())) {
                return (com.baidu.tbadk.core.data.w) next;
            }
        }
        return null;
    }

    public void e(com.baidu.tbadk.core.data.w wVar) {
        this.bRP.remove(wVar);
    }
}
