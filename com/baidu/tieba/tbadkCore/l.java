package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.au;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.CategoryInfo;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsTabInfo;
import tbclient.PopInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData WN;
    protected ap dni;
    protected ForumData eih;
    private UserData ein;
    protected List<Long> fvL;
    private m fvM;
    protected boolean fvN;
    protected String fvO;
    protected o fvP;
    private b fvQ;
    private boolean fvR;
    private List<PhotoLiveCardData> fvU;
    private int fvV;
    private PhotoLiveCardData fvW;
    private String fvX;
    private com.baidu.tbadk.core.data.z fvZ;
    private List<FrsTabInfo> fwb;
    private NavTabInfo fwc;
    private List<FeedForumData> fwe;
    private List<CategoryInfo> fwf;
    private bi fwn;
    private ay fwo;
    private com.baidu.tbadk.core.data.m fwq;
    private List<Integer> fwu;
    private List<com.baidu.adp.widget.ListView.v> fwv;
    public PopInfo fwx;
    private String gameName;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.v> threadList;
    private HashMap<String, MetaData> userMap;
    public int fvK = 0;
    private List<g> fvS = new ArrayList();
    private int fvT = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> fvY = new ArrayList<>();
    protected com.baidu.tbadk.core.data.r fwa = null;
    private int fwd = 1;
    private String fwg = null;
    private com.baidu.tbadk.core.data.y fwh = null;
    public com.baidu.tbadk.core.data.aa fwi = null;
    private com.baidu.tbadk.core.data.s fwj = null;
    private Integer fwk = -1;
    public com.baidu.tbadk.core.data.w fwl = null;
    private com.baidu.tbadk.core.data.u fwm = null;
    private int fwp = -1;
    protected List<com.baidu.adp.widget.ListView.v> fwr = null;
    private int fws = 0;
    private int fwt = 0;
    private boolean isShowDriftingBottle = false;
    private long fww = 0;
    private int alaLiveCount = 0;

    public l() {
        initData();
    }

    private void initData() {
        this.eih = new ForumData();
        this.threadList = new ArrayList<>();
        this.fwr = new ArrayList();
        this.userMap = new HashMap<>();
        this.dni = new ap();
        this.fvM = new m();
        this.ein = new UserData();
        this.fvP = new o();
        d(new AntiData());
        a(new b());
        this.fwv = new ArrayList();
        this.fwu = new ArrayList();
    }

    public FrsPageResIdl C(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            FrsPageResIdl frsPageResIdl = (FrsPageResIdl) WIRE.parseFrom(bArr, FrsPageResIdl.class);
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
        MetaData metaData;
        MetaData metaData2;
        if (dataRes != null) {
            try {
                initData();
                if (!com.baidu.tbadk.core.util.x.q(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.x.q(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            if (oVar.a(colorEgg)) {
                                this.fvY.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.x.q(dataRes.activityhead.head_imgs)) {
                    this.fwa = new com.baidu.tbadk.core.data.r();
                    this.fwa.a(dataRes.activityhead);
                }
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData3 = new MetaData();
                        metaData3.parserProtobuf(list.get(i));
                        String userId = metaData3.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.userMap.put(metaData3.getUserId(), metaData3);
                        }
                    }
                }
                mo(dataRes.is_new_url.intValue());
                this.fvN = dataRes.fortune_bag.intValue() == 1;
                this.fvO = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.fvR = dataRes.forum.has_game.intValue() == 1;
                    this.fvX = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.fvS.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.fvS.add(gVar);
                    }
                }
                this.fvP.a(dataRes.gcon_account);
                this.eih.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.fvL = dataRes.thread_id_list;
                this.WN.parserProtobuf(dataRes.anti);
                this.fvQ.a(dataRes.group);
                this.dni.a(dataRes.page);
                this.fvM.a(dataRes.frs_star);
                this.ein.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.ein.getIsSelectTail());
                }
                this.fwb = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.fwc = builder.build(true);
                } else {
                    this.fwc = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                rM(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.fvU = new ArrayList();
                    int size = list3.size();
                    int i3 = -1;
                    for (int i4 = 0; i4 < size; i4++) {
                        PhotoLiveCardData photoLiveCardData = new PhotoLiveCardData();
                        photoLiveCardData.parserProtobuf(list3.get(i4));
                        if (photoLiveCardData.getShowStyle() < 0) {
                            photoLiveCardData.setShowStyle(PhotoLiveCardData.getRandom(3, i3));
                        }
                        i3 = photoLiveCardData.getShowStyle();
                        photoLiveCardData.setShowExpressionViewIndexList(photoLiveCardData.getExpressionDatas());
                        if (photoLiveCardData.getPendantData() == null && (metaData2 = this.userMap.get(photoLiveCardData.getAuthorId())) != null && metaData2.getPendantData() != null) {
                            photoLiveCardData.setUserPendantData(metaData2.getPendantData());
                        }
                        this.fvU.add(photoLiveCardData);
                    }
                }
                this.fvV = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.fvW = new PhotoLiveCardData();
                    if (this.fvW.getShowStyle() < 0) {
                        this.fvW.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.fvW.getShowStyle();
                    this.fvW.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.fvW.setShowExpressionViewIndexList(this.fvW.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.fwf = dataRes.category_list;
                if (!au.isEmpty(dataRes.bawu_enter_url)) {
                    this.fwg = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.fwh = new com.baidu.tbadk.core.data.y();
                    this.fwh.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.fwi = new com.baidu.tbadk.core.data.aa();
                    this.fwi.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.fwj = new com.baidu.tbadk.core.data.s();
                    this.fwj.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.fwl = new com.baidu.tbadk.core.data.w();
                    this.fwl.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.fwm = new com.baidu.tbadk.core.data.u();
                    this.fwm.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.ntspread != null) {
                    this.fvZ = new com.baidu.tbadk.core.data.z();
                    this.fvZ.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    Log.e(PbActivityConfig.VALUE_FROM_FRS, "5FloorVideo:" + dataRes.card_shipin_info);
                    this.fwn = new bi();
                    this.fwn.at(true);
                    this.fwn.bW(this.fvV);
                    this.fwn.setUserMap(this.userMap);
                    this.fwn.a(dataRes.card_shipin_info.get(0));
                    this.fwn.sW();
                    if (this.fwn.getFid() == 0 && longValue != 0) {
                        this.fwn.setFid(longValue);
                    }
                    this.fwn.i(this.fvY);
                    this.fwn.as(!this.fwn.rW());
                    if (this.fwn.getAuthor() != null && this.fwn.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.fwn.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.N(metaData.getPendantData().CO());
                        jVar.cr(metaData.getPendantData().qB());
                        this.fwn.getAuthor().setPendantData(jVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.fwp = dataRes.school_recom_pos.intValue();
                    this.fwo = new ay();
                    this.fwo.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.fwq = new com.baidu.tbadk.core.data.m();
                    this.fwq.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.fws = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.fwt = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.fvK = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bbv().pt(dataRes.asp_shown_info);
                this.fwu = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bi biVar = new bi();
                        if (this.fwu != null && this.fwu.size() >= dataRes.card_shipin_new.size()) {
                            biVar.bW(this.fwu.get(i5).intValue());
                        }
                        biVar.at(true);
                        biVar.a(dataRes.card_shipin_new.get(i5));
                        this.fwv.add(biVar);
                    }
                }
                if (dataRes.bottle != null) {
                    this.isShowDriftingBottle = dataRes.bottle.has_enter_display.intValue() == 1;
                    this.fww = dataRes.bottle.tid.longValue();
                } else {
                    this.isShowDriftingBottle = false;
                    this.fww = 0L;
                }
                this.fwx = dataRes.enter_pop_info;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void rM(int i) {
        this.fwd = 1;
        if (this.fwb != null && this.fwb.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.fwb) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.fwd = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bi biVar = new bi();
                biVar.setUserMap(this.userMap);
                biVar.a(list.get(i));
                biVar.bX(3);
                biVar.sW();
                if (biVar.getFid() == 0 && j != 0) {
                    biVar.setFid(j);
                }
                biVar.i(this.fvY);
                if (biVar.getThreadType() == 33 && !biVar.sP()) {
                    av avVar = new av();
                    avVar.a(biVar, 0);
                    avVar.m(bhy());
                    if (appResponseToIntentClass) {
                        this.threadList.add(avVar);
                    }
                } else if (!TextUtils.isEmpty(biVar.tj())) {
                    ah ahVar = new ah();
                    ahVar.co(biVar.tj());
                    this.threadList.add(ahVar);
                } else {
                    this.threadList.add(biVar);
                }
            }
        }
    }

    public int bhm() {
        return this.alaLiveCount;
    }

    public void rN(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Ff() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean z(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void m(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aKx() {
        return this.eih;
    }

    public int bhn() {
        return this.fws;
    }

    public void rO(int i) {
        this.fws = i;
    }

    public int bho() {
        return this.fwt;
    }

    public void rP(int i) {
        this.fwt = i;
    }

    public void c(ForumData forumData) {
        this.eih = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getThreadList() {
        return this.threadList;
    }

    public void ax(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData rb() {
        return this.WN;
    }

    public void d(AntiData antiData) {
        this.WN = antiData;
    }

    public ap rr() {
        return this.dni;
    }

    public void a(ap apVar) {
        this.dni = apVar;
    }

    public m bhp() {
        return this.fvM;
    }

    public void a(m mVar) {
        this.fvM = mVar;
    }

    public com.baidu.tbadk.core.data.r bhq() {
        return this.fwa;
    }

    public void b(com.baidu.tbadk.core.data.r rVar) {
        this.fwa = rVar;
    }

    public boolean bhr() {
        return this.fvN;
    }

    public void ln(boolean z) {
        this.fvN = z;
    }

    public String bhs() {
        return this.fvO;
    }

    public void pO(String str) {
        this.fvO = str;
    }

    public o bht() {
        return this.fvP;
    }

    public void a(o oVar) {
        this.fvP = oVar;
    }

    public UserData getUserData() {
        return this.ein;
    }

    public void h(UserData userData) {
        this.ein = userData;
    }

    public List<Long> bhu() {
        return this.fvL;
    }

    public void cE(List<Long> list) {
        this.fvL = list;
    }

    public b bhv() {
        return this.fvQ;
    }

    public void a(b bVar) {
        this.fvQ = bVar;
    }

    public boolean bhw() {
        return this.fvR;
    }

    public void lo(boolean z) {
        this.fvR = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bhx() {
        return this.fvS;
    }

    public void cF(List<g> list) {
        this.fvS = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aKJ() {
        return this.fvT;
    }

    public void mo(int i) {
        this.fvT = i;
    }

    public List<PhotoLiveCardData> bhy() {
        return this.fvU;
    }

    public String bhz() {
        return this.fvX;
    }

    public void pP(String str) {
        this.fvX = str;
    }

    public List<FrsTabInfo> bhA() {
        return this.fwb;
    }

    public void cG(List<FrsTabInfo> list) {
        this.fwb = list;
    }

    public void cH(List<PhotoLiveCardData> list) {
        this.fvU = list;
    }

    public boolean bhB() {
        return this.fvW != null;
    }

    public PhotoLiveCardData bhC() {
        return this.fvW;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.fvW = photoLiveCardData;
    }

    public com.baidu.tbadk.core.data.z bhD() {
        return this.fvZ;
    }

    public void a(com.baidu.tbadk.core.data.z zVar) {
        this.fvZ = zVar;
    }

    public int bhE() {
        return this.fvV;
    }

    public void rQ(int i) {
        this.fvV = i;
    }

    public List<FeedForumData> bhF() {
        return this.fwe;
    }

    public void cI(List<FeedForumData> list) {
        this.fwe = list;
    }

    public void pQ(String str) {
        if (this.fwe != null && str != null) {
            for (FeedForumData feedForumData : this.fwe) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.fwe.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bhG() {
        return this.fwf;
    }

    public void cJ(List<CategoryInfo> list) {
        this.fwf = list;
    }

    public void pR(String str) {
        this.fwg = str;
    }

    public String bhH() {
        return this.fwg;
    }

    public bi bhI() {
        return this.fwn;
    }

    public void H(bi biVar) {
        this.fwn = biVar;
    }

    public int bhJ() {
        return this.fwd;
    }

    public void rR(int i) {
        this.fwd = i;
    }

    public com.baidu.tbadk.core.data.y bhK() {
        return this.fwh;
    }

    public void b(com.baidu.tbadk.core.data.y yVar) {
        this.fwh = yVar;
    }

    public com.baidu.tbadk.core.data.s bhL() {
        return this.fwj;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.fwj = sVar;
    }

    public com.baidu.tbadk.core.data.u bhM() {
        return this.fwm;
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        this.fwm = uVar;
    }

    public int bhN() {
        return this.fwp;
    }

    public void rS(int i) {
        this.fwp = i;
    }

    public ay bhO() {
        return this.fwo;
    }

    public void a(ay ayVar) {
        this.fwo = ayVar;
    }

    public NavTabInfo bhP() {
        return this.fwc;
    }

    public void a(NavTabInfo navTabInfo) {
        this.fwc = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m bhQ() {
        return this.fwq;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.fwq = mVar;
    }

    public int adT() {
        return this.mSortType;
    }

    public Integer bhR() {
        return this.fwk;
    }

    public void d(Integer num) {
        this.fwk = num;
    }

    public List<Integer> bhS() {
        return this.fwu;
    }

    public void cK(List<Integer> list) {
        this.fwu = list;
    }

    public List<com.baidu.adp.widget.ListView.v> bhT() {
        return this.fwv;
    }

    public void cL(List<com.baidu.adp.widget.ListView.v> list) {
        this.fwv = list;
    }

    public boolean isShowDriftingBottle() {
        return this.isShowDriftingBottle;
    }

    public long bhU() {
        return this.fww;
    }

    public void lp(boolean z) {
        this.isShowDriftingBottle = z;
    }

    public void cA(long j) {
        this.fww = j;
    }
}
