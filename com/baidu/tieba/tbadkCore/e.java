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
    private AntiData DY;
    private ForumData bTA;
    private ArrayList<com.baidu.adp.widget.ListView.am> bTB;
    private t bTC;
    private boolean bTD;
    private u bTE;
    private UserData bTF;
    private b bTG;
    private boolean bTH;
    private ArrayList<LiveCardData> bTP;
    private com.baidu.tbadk.core.data.q btC;
    private String fortune_desc;
    private String gameName;
    private String game_url;
    private HashMap<String, MetaData> userMap;
    private List<o> star_enter = new ArrayList();
    private ArrayList<com.baidu.tbadk.core.data.i> bTI = new ArrayList<>();
    private int ata = 0;
    private x bTJ = null;
    private w bTK = null;
    private boolean bTL = false;
    private i bTM = null;
    private f bTN = null;
    private boolean bTO = false;
    private long bul = 0;
    private long bum = 0;
    private long bun = 0;
    private long buo = 0;

    public boolean aeD() {
        return this.bTH;
    }

    public String getGameName() {
        return this.gameName;
    }

    public List<o> aeE() {
        return this.star_enter;
    }

    public String aeF() {
        return this.game_url;
    }

    public ArrayList<LiveCardData> aeG() {
        return this.bTP;
    }

    public long Us() {
        return this.buo;
    }

    public long Ut() {
        return this.bum;
    }

    public long Uu() {
        return this.bun;
    }

    public long Uv() {
        return this.bul;
    }

    public boolean aeH() {
        return this.bTD;
    }

    public e() {
        initData();
    }

    private void initData() {
        this.bTA = new ForumData();
        this.bTB = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.btC = new com.baidu.tbadk.core.data.q();
        this.bTC = new t();
        this.bTF = new UserData();
        this.bTE = new u();
        a(new AntiData());
        a(new b());
    }

    public void a(ae aeVar) {
        if (aeVar != null) {
            this.bTA.setCurScore(aeVar.getCurScore());
            this.bTA.setLevelupScore(aeVar.getLevelupScore());
            this.bTA.setLike(aeVar.isLike());
            this.bTA.setUser_level(aeVar.adH());
            this.bTA.setLevelName(aeVar.getLevelName());
        }
    }

    public void d(SignData signData) {
        this.bTA.setSignData(signData);
    }

    public ForumData aeI() {
        return this.bTA;
    }

    public void a(AnchorPower anchorPower) {
        this.bTA.setAnchorPower(anchorPower);
    }

    public void d(com.baidu.tbadk.core.data.x xVar) {
        while (!this.bTB.isEmpty() && this.bTB.get(0) != null && (this.bTB.get(0) instanceof com.baidu.tbadk.core.data.x) && ((com.baidu.tbadk.core.data.x) this.bTB.get(0)).getIs_top() == 2) {
            this.bTB.remove(0);
        }
        this.bTB.add(0, xVar);
    }

    public ArrayList<com.baidu.adp.widget.ListView.am> aeJ() {
        return this.bTB;
    }

    public UserData getUserData() {
        return this.bTF;
    }

    public void a(AntiData antiData) {
        this.DY = antiData;
    }

    public AntiData mK() {
        return this.DY;
    }

    public com.baidu.tbadk.core.data.q mT() {
        return this.btC;
    }

    public t aeK() {
        return this.bTC;
    }

    public void ew(boolean z) {
        this.bTL = z;
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
                                this.bTI.add(iVar);
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
                this.bTD = dataRes.fortune_bag.intValue() == 1;
                this.fortune_desc = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.bTH = dataRes.forum.has_game.intValue() == 1;
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
                this.bTE.a(dataRes.gcon_account);
                this.bTA.parserProtobuf(dataRes.forum);
                List<ThreadInfo> list3 = dataRes.thread_list;
                if (list3 != null) {
                    for (int i3 = 0; i3 < list3.size(); i3++) {
                        com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                        xVar.setUserMap(this.userMap);
                        xVar.a(list3.get(i3));
                        xVar.parser_title();
                        xVar.q(this.bTI);
                        this.bTB.add(xVar);
                    }
                }
                this.DY.parserProtobuf(dataRes.anti);
                this.bTG.a(dataRes.group);
                this.btC.a(dataRes.page);
                this.bTC.a(dataRes.frs_star);
                this.bTF.parserProtobuf(dataRes.user);
                List<AnchorInfo> list4 = dataRes.forum_livegroup_list;
                this.bTP = new ArrayList<>();
                if (list4 != null) {
                    for (int i4 = 0; i4 < list4.size(); i4++) {
                        LiveCardData liveCardData = new LiveCardData();
                        liveCardData.parserProtobuf(list4.get(i4));
                        this.bTP.add(liveCardData);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(BaseActivity baseActivity, FRSPageRequestMessage fRSPageRequestMessage, int i, boolean z, String str) {
        if (this.bTM != null) {
            this.bTM.cancel();
            this.bTM = null;
        }
        this.bTO = z;
        this.bTM = new i(this, baseActivity, fRSPageRequestMessage, i, str);
        this.bTM.setPriority(3);
        this.bTM.execute(fRSPageRequestMessage);
    }

    public void clear() {
        if (this.bTM != null) {
            this.bTM.cancel();
            this.bTM = null;
        }
        if (this.bTN != null) {
            this.bTN.cancel();
            this.bTN = null;
        }
    }

    public void a(g gVar) {
        ae aeVar = new ae();
        aeVar.setLike(1);
        aeVar.hE(gVar.level);
        aeVar.setLevelName(gVar.bTW);
        aeVar.setCurScore(gVar.cur_score);
        aeVar.setLevelupScore(gVar.levelup_score);
        a(aeVar);
    }

    public void a(x xVar) {
        this.bTJ = xVar;
    }

    public int CB() {
        return this.ata;
    }

    public void gL(int i) {
        this.ata = i;
    }

    public b aeL() {
        return this.bTG;
    }

    public void a(b bVar) {
        this.bTG = bVar;
    }

    public int aeM() {
        if (this.bTB == null || this.bTB.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.am> it = this.bTB.iterator();
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
        if (this.bTA != null && (bannerListData = this.bTA.getBannerListData()) != null && bannerListData.mt() != null && this.bTB != null && this.bTB.size() > 0) {
            int size = this.bTB.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    if (!(this.bTB.get(i) instanceof com.baidu.tbadk.core.data.c)) {
                        i++;
                    } else {
                        this.bTB.remove(i);
                        break;
                    }
                } else {
                    break;
                }
            }
            int size2 = this.bTB.size();
            Iterator<com.baidu.adp.widget.ListView.am> it = this.bTB.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.am next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.x) && ((com.baidu.tbadk.core.data.x) next).getIs_top() != 0) {
                    i2++;
                }
            }
            int size3 = bannerListData.mt().size();
            if (size3 >= 1) {
                HashSet hashSet = new HashSet();
                for (int i3 = 0; i3 < size3; i3++) {
                    com.baidu.tbadk.core.data.c cVar = bannerListData.mt().get(i3);
                    int i4 = (cVar.Dq + i2) - 1;
                    if (!hashSet.contains(Integer.valueOf(i4)) && cVar != null && cVar.mn() && i4 < size2) {
                        if (cVar.mo()) {
                            if (!ar.isInstalledPackage(context, cVar.Dp) && !TextUtils.isEmpty(cVar.Dp) && !TextUtils.isEmpty(cVar.Dl)) {
                                boolean dO = com.baidu.tbadk.download.b.uV().dO(cVar.Dp);
                                boolean dP = com.baidu.tbadk.download.b.uV().dP(cVar.Dp);
                                if (dO) {
                                    cVar.Dj = 1;
                                } else if (dP) {
                                    cVar.Dj = 2;
                                } else {
                                    cVar.Dj = 0;
                                }
                                hashSet.add(Integer.valueOf(i4));
                                this.bTB.add(i4, cVar);
                            }
                        } else if (cVar.mp()) {
                            hashSet.add(Integer.valueOf(i4));
                            this.bTB.add(i4, cVar);
                        }
                    }
                }
            }
        }
    }

    public void aeN() {
        boolean z = true;
        int i = 0;
        if (this.bTA != null && this.btC != null && this.btC.mP() == 1) {
            if (this.bTE == null || !this.bTE.aeX()) {
                z = false;
            }
            if (this.bTD || z) {
                ag agVar = new ag();
                agVar.ex(this.bTD);
                agVar.ie(this.fortune_desc);
                agVar.a(this.bTE);
                agVar.bu(1003);
                if (this.bTB != null && this.bTB.size() > 0) {
                    Iterator<com.baidu.adp.widget.ListView.am> it = this.bTB.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.widget.ListView.am next = it.next();
                        if ((next instanceof com.baidu.tbadk.core.data.x) && ((com.baidu.tbadk.core.data.x) next).getIs_top() != 0) {
                            i++;
                        }
                    }
                    this.bTB.add(i, agVar);
                }
            }
        }
    }

    public void aeO() {
        com.baidu.tbadk.core.data.t recommendLikeUser;
        int i;
        int i2;
        if (this.bTA != null && (recommendLikeUser = this.bTA.getRecommendLikeUser()) != null && recommendLikeUser.na() != null && !TextUtils.isEmpty(recommendLikeUser.na().getName()) && this.bTB != null && this.bTB.size() > 0) {
            int size = this.bTB.size();
            Iterator<com.baidu.adp.widget.ListView.am> it = this.bTB.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.am next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.x) && ((com.baidu.tbadk.core.data.x) next).getIs_top() != 0) {
                    i3++;
                }
            }
            String mZ = recommendLikeUser.mZ();
            if (!TextUtils.isEmpty(mZ) && !TextUtils.isEmpty(mZ.trim()) && (i = com.baidu.adp.lib.g.c.toInt(mZ, -1)) != -1 && (i + i3) - 1 < size) {
                this.bTB.add(i2, recommendLikeUser);
            }
        }
    }

    public com.baidu.tbadk.core.data.x hZ(String str) {
        if (this.bTB == null) {
            return null;
        }
        Iterator<com.baidu.adp.widget.ListView.am> it = this.bTB.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.am next = it.next();
            if (next != null && (next instanceof com.baidu.tbadk.core.data.x) && TextUtils.equals(str, ((com.baidu.tbadk.core.data.x) next).getId())) {
                return (com.baidu.tbadk.core.data.x) next;
            }
        }
        return null;
    }

    public void e(com.baidu.tbadk.core.data.x xVar) {
        this.bTB.remove(xVar);
    }
}
