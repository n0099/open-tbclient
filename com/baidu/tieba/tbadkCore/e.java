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
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.StarEnter;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class e {
    private AntiData Eb;
    private ForumData bTB;
    private ArrayList<com.baidu.adp.widget.ListView.am> bTC;
    private t bTD;
    private boolean bTE;
    private u bTF;
    private UserData bTG;
    private b bTH;
    private boolean bTI;
    private ArrayList<LiveCardData> bTQ;
    private com.baidu.tbadk.core.data.q btD;
    private String fortune_desc;
    private String gameName;
    private String game_url;
    private HashMap<String, MetaData> userMap;
    private List<o> star_enter = new ArrayList();
    private ArrayList<com.baidu.tbadk.core.data.i> bTJ = new ArrayList<>();
    private int atd = 0;
    private x bTK = null;
    private w bTL = null;
    private boolean bTM = false;
    private i bTN = null;
    private f bTO = null;
    private boolean bTP = false;
    private long bum = 0;
    private long bun = 0;
    private long buo = 0;
    private long bup = 0;

    public boolean aeI() {
        return this.bTI;
    }

    public String getGameName() {
        return this.gameName;
    }

    public List<o> aeJ() {
        return this.star_enter;
    }

    public String aeK() {
        return this.game_url;
    }

    public ArrayList<LiveCardData> aeL() {
        return this.bTQ;
    }

    public long Ux() {
        return this.bup;
    }

    public long Uy() {
        return this.bun;
    }

    public long Uz() {
        return this.buo;
    }

    public long UA() {
        return this.bum;
    }

    public boolean aeM() {
        return this.bTE;
    }

    public e() {
        initData();
    }

    private void initData() {
        this.bTB = new ForumData();
        this.bTC = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.btD = new com.baidu.tbadk.core.data.q();
        this.bTD = new t();
        this.bTG = new UserData();
        this.bTF = new u();
        a(new AntiData());
        a(new b());
    }

    public void a(ae aeVar) {
        if (aeVar != null) {
            this.bTB.setCurScore(aeVar.getCurScore());
            this.bTB.setLevelupScore(aeVar.getLevelupScore());
            this.bTB.setLike(aeVar.isLike());
            this.bTB.setUser_level(aeVar.adM());
            this.bTB.setLevelName(aeVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        this.bTB.setSignData(signData);
    }

    public ForumData aeN() {
        return this.bTB;
    }

    public void a(AnchorPower anchorPower) {
        this.bTB.setAnchorPower(anchorPower);
    }

    public void d(com.baidu.tbadk.core.data.x xVar) {
        while (!this.bTC.isEmpty() && this.bTC.get(0) != null && (this.bTC.get(0) instanceof com.baidu.tbadk.core.data.x) && ((com.baidu.tbadk.core.data.x) this.bTC.get(0)).getIs_top() == 2) {
            this.bTC.remove(0);
        }
        this.bTC.add(0, xVar);
    }

    public ArrayList<com.baidu.adp.widget.ListView.am> aeO() {
        return this.bTC;
    }

    public UserData getUserData() {
        return this.bTG;
    }

    public void a(AntiData antiData) {
        this.Eb = antiData;
    }

    public AntiData mR() {
        return this.Eb;
    }

    public com.baidu.tbadk.core.data.q na() {
        return this.btD;
    }

    public t aeP() {
        return this.bTD;
    }

    public void ew(boolean z) {
        this.bTM = z;
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
                if (dataRes.color_egg != null && dataRes.color_egg.size() > 0) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && colorEgg.holiday_words != null && colorEgg.holiday_words.size() > 0) {
                            com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i();
                            if (iVar.a(colorEgg)) {
                                this.bTJ.add(iVar);
                            }
                        }
                    }
                }
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
                gL(dataRes.is_new_url.intValue());
                this.bTE = dataRes.fortune_bag.intValue() == 1;
                this.fortune_desc = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.bTI = dataRes.forum.has_game.intValue() == 1;
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
                this.bTF.a(dataRes.gcon_account);
                this.bTB.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list3 = dataRes.thread_list;
                if (list3 != null) {
                    for (int i3 = 0; i3 < list3.size(); i3++) {
                        com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                        xVar.setUserMap(this.userMap);
                        xVar.a(list3.get(i3));
                        xVar.parser_title();
                        xVar.q(this.bTJ);
                        this.bTC.add(xVar);
                    }
                }
                this.Eb.parserProtobuf(dataRes.anti);
                this.bTH.a(dataRes.group);
                this.btD.a(dataRes.page);
                this.bTD.a(dataRes.frs_star);
                this.bTG.parserProtobuf(dataRes.user);
                List<AnchorInfo> list4 = dataRes.forum_livegroup_list;
                this.bTQ = new ArrayList<>();
                if (list4 != null) {
                    for (int i4 = 0; i4 < list4.size(); i4++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list4.get(i4));
                        this.bTQ.add(liveCardData);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(BaseActivity baseActivity, FRSPageRequestMessage fRSPageRequestMessage, int i, boolean z, String str) {
        if (this.bTN != null) {
            this.bTN.cancel();
            this.bTN = null;
        }
        this.bTP = z;
        this.bTN = new i(this, baseActivity, fRSPageRequestMessage, i, str);
        this.bTN.setPriority(3);
        this.bTN.execute(fRSPageRequestMessage);
    }

    public void clear() {
        if (this.bTN != null) {
            this.bTN.cancel();
            this.bTN = null;
        }
        if (this.bTO != null) {
            this.bTO.cancel();
            this.bTO = null;
        }
    }

    public void a(g gVar) {
        ae aeVar = new ae();
        aeVar.setLike(1);
        aeVar.hE(gVar.level);
        aeVar.setLevelName(gVar.bTX);
        aeVar.setCurScore(gVar.cur_score);
        aeVar.setLevelupScore(gVar.levelup_score);
        a(aeVar);
    }

    public void a(x xVar) {
        this.bTK = xVar;
    }

    public int CH() {
        return this.atd;
    }

    public void gL(int i) {
        this.atd = i;
    }

    public b aeQ() {
        return this.bTH;
    }

    public void a(b bVar) {
        this.bTH = bVar;
    }

    public int aeR() {
        if (this.bTC == null || this.bTC.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.am> it = this.bTC.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.am next = it.next();
            if (next instanceof com.baidu.tbadk.core.data.x) {
                if (((com.baidu.tbadk.core.data.x) next).getIs_top() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    public void av(Context context) {
        com.baidu.tbadk.core.data.f bannerListData;
        if (this.bTB != null && (bannerListData = this.bTB.getBannerListData()) != null && bannerListData.mA() != null && this.bTC != null && this.bTC.size() > 0) {
            int size = this.bTC.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    if (!(this.bTC.get(i) instanceof com.baidu.tbadk.core.data.c)) {
                        i++;
                    } else {
                        this.bTC.remove(i);
                        break;
                    }
                } else {
                    break;
                }
            }
            int size2 = this.bTC.size();
            Iterator<com.baidu.adp.widget.ListView.am> it = this.bTC.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.am next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.x) && ((com.baidu.tbadk.core.data.x) next).getIs_top() != 0) {
                    i2++;
                }
            }
            int size3 = bannerListData.mA().size();
            if (size3 >= 1) {
                HashSet hashSet = new HashSet();
                for (int i3 = 0; i3 < size3; i3++) {
                    com.baidu.tbadk.core.data.c cVar = bannerListData.mA().get(i3);
                    int i4 = (cVar.Dt + i2) - 1;
                    if (!hashSet.contains(Integer.valueOf(i4)) && cVar != null && cVar.mu() && i4 < size2) {
                        if (cVar.mv()) {
                            if (!ar.isInstalledPackage(context, cVar.Ds) && !TextUtils.isEmpty(cVar.Ds) && !TextUtils.isEmpty(cVar.Do)) {
                                boolean dR = com.baidu.tbadk.download.b.vb().dR(cVar.Ds);
                                boolean dS = com.baidu.tbadk.download.b.vb().dS(cVar.Ds);
                                if (dR) {
                                    cVar.Dm = 1;
                                } else if (dS) {
                                    cVar.Dm = 2;
                                } else {
                                    cVar.Dm = 0;
                                }
                                hashSet.add(Integer.valueOf(i4));
                                this.bTC.add(i4, cVar);
                            }
                        } else if (cVar.mw()) {
                            hashSet.add(Integer.valueOf(i4));
                            this.bTC.add(i4, cVar);
                        }
                    }
                }
            }
        }
    }

    public void aeS() {
        boolean z = true;
        int i = 0;
        if (this.bTB != null && this.btD != null && this.btD.mW() == 1) {
            if (this.bTF == null || !this.bTF.afc()) {
                z = false;
            }
            if (this.bTE || z) {
                ag agVar = new ag();
                agVar.ex(this.bTE);
                agVar.ih(this.fortune_desc);
                agVar.a(this.bTF);
                agVar.bu(1003);
                if (this.bTC != null && this.bTC.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.am> it = this.bTC.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.am next = it.next();
                        if ((next instanceof com.baidu.tbadk.core.data.x) && ((com.baidu.tbadk.core.data.x) next).getIs_top() != 0) {
                            i++;
                        }
                    }
                    this.bTC.add(i, agVar);
                }
            }
        }
    }

    public void aeT() {
        com.baidu.tbadk.core.data.t recommendLikeUser;
        int i;
        int i2;
        if (this.bTB != null && (recommendLikeUser = this.bTB.getRecommendLikeUser()) != null && recommendLikeUser.nh() != null && !TextUtils.isEmpty(recommendLikeUser.nh().getName()) && this.bTC != null && this.bTC.size() > 0) {
            int size = this.bTC.size();
            Iterator<com.baidu.adp.widget.ListView.am> it = this.bTC.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.am next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.x) && ((com.baidu.tbadk.core.data.x) next).getIs_top() != 0) {
                    i3++;
                }
            }
            String ng = recommendLikeUser.ng();
            if (!TextUtils.isEmpty(ng) && !TextUtils.isEmpty(ng.trim()) && (i = com.baidu.adp.lib.g.c.toInt(ng, -1)) != -1 && (i + i3) - 1 < size) {
                this.bTC.add(i2, recommendLikeUser);
            }
        }
    }

    public com.baidu.tbadk.core.data.x ib(String str) {
        if (this.bTC == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.am> it = this.bTC.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.am next = it.next();
            if (next != null && (next instanceof com.baidu.tbadk.core.data.x) && TextUtils.equals(str, ((com.baidu.tbadk.core.data.x) next).getId())) {
                return (com.baidu.tbadk.core.data.x) next;
            }
        }
        return null;
    }

    public void e(com.baidu.tbadk.core.data.x xVar) {
        this.bTC.remove(xVar);
    }
}
