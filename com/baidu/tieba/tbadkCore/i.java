package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.be;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.AlaLiveNotify;
import tbclient.CategoryInfo;
import tbclient.FrsPage.AgreeBanner;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumHeadIcon;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsTabInfo;
import tbclient.PopInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData aLS;
    protected am eMO;
    protected ForumData fBM;
    private UserData fBT;
    private String gameName;
    private be hgE;
    private av hgF;
    private com.baidu.tbadk.core.data.l hgH;
    private List<Integer> hgL;
    private List<com.baidu.adp.widget.ListView.i> hgM;
    private e hgN;
    private f hgO;
    public PopInfo hgP;
    private com.baidu.tieba.g.b hgQ;
    private AgreeBanner hgR;
    private AlaLiveNotify hgS;
    private List<FrsTabInfo> hgT;
    private ForumHeadIcon hgV;
    private com.baidu.tieba.frs.s hgW;
    private k hgX;
    public FrsTabInfo hgY;
    protected List<Long> hgd;
    private j hge;
    protected boolean hgf;
    protected String hgg;
    protected m hgh;
    private b hgi;
    private boolean hgj;
    private List<PhotoLiveCardData> hgm;
    private int hgn;
    private PhotoLiveCardData hgo;
    private String hgp;
    private List<FrsTabInfo> hgs;
    private NavTabInfo hgt;
    private List<FeedForumData> hgv;
    private List<CategoryInfo> hgw;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.i> threadList;
    private HashMap<String, MetaData> userMap;
    public int hgc = 0;
    private List<g> hgk = new ArrayList();
    private int hgl = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> hgq = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o hgr = null;
    private int hgu = 1;
    private String hgx = null;
    private com.baidu.tbadk.core.data.w hgy = null;
    public com.baidu.tbadk.core.data.x hgz = null;
    private com.baidu.tbadk.core.data.p hgA = null;
    private Integer hgB = -1;
    public com.baidu.tbadk.core.data.u hgC = null;
    private com.baidu.tbadk.core.data.r hgD = null;
    private int hgG = -1;
    protected List<com.baidu.adp.widget.ListView.i> hgI = null;
    private int hgJ = 0;
    private int hgK = 0;
    private int alaLiveCount = 0;
    private int hgU = 0;
    public int hgZ = 0;

    public i() {
        initData();
    }

    private void initData() {
        this.fBM = new ForumData();
        this.threadList = new ArrayList<>();
        this.hgI = new ArrayList();
        this.userMap = new HashMap<>();
        this.eMO = new am();
        this.hge = new j();
        this.fBT = new UserData();
        this.hgh = new m();
        c(new AntiData());
        a(new b());
        this.hgM = new ArrayList();
        this.hgL = new ArrayList();
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
                if (!com.baidu.tbadk.core.util.v.G(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.v.G(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                            if (nVar.a(colorEgg)) {
                                this.hgq.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.G(dataRes.activityhead.head_imgs)) {
                    this.hgr = new com.baidu.tbadk.core.data.o();
                    this.hgr.a(dataRes.activityhead);
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
                sD(dataRes.is_new_url.intValue());
                this.hgf = dataRes.fortune_bag.intValue() == 1;
                this.hgg = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.hgj = dataRes.forum.has_game.intValue() == 1;
                    this.hgp = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.hgk.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.hgk.add(gVar);
                    }
                }
                this.hgh.a(dataRes.gcon_account);
                this.fBM.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.hgd = dataRes.thread_id_list;
                this.aLS.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.p.a.e(dataRes.anti.block_pop_info);
                }
                this.hgi.a(dataRes.group);
                this.eMO.a(dataRes.page);
                this.hge.a(dataRes.frs_star);
                this.fBT.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fBT.getIsSelectTail());
                }
                this.hgs = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.hgt = builder.build(true);
                } else {
                    this.hgt = dataRes.nav_tab_info;
                }
                if (this.hgt.head != null && !com.baidu.tbadk.core.util.v.G(this.hgt.head)) {
                    this.hgY = this.hgt.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                wW(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.hgm = new ArrayList();
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
                        this.hgm.add(photoLiveCardData);
                    }
                }
                this.hgn = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.hgo = new PhotoLiveCardData();
                    if (this.hgo.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.hgo;
                        this.hgo.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.hgo.getShowStyle();
                    this.hgo.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.hgo.setShowExpressionViewIndexList(this.hgo.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.hgw = dataRes.category_list;
                if (!com.baidu.tbadk.core.util.am.isEmpty(dataRes.bawu_enter_url)) {
                    this.hgx = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.hgy = new com.baidu.tbadk.core.data.w();
                    this.hgy.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.hgz = new com.baidu.tbadk.core.data.x();
                    this.hgz.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.hgA = new com.baidu.tbadk.core.data.p();
                    this.hgA.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.hgC = new com.baidu.tbadk.core.data.u();
                    this.hgC.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hgD = new com.baidu.tbadk.core.data.r();
                    this.hgD.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.hgE = new be();
                    this.hgE.aT(true);
                    this.hgE.eX(this.hgn);
                    this.hgE.setUserMap(this.userMap);
                    this.hgE.a(dataRes.card_shipin_info.get(0));
                    this.hgE.zF();
                    if (this.hgE.getFid() == 0 && longValue != 0) {
                        this.hgE.setFid(longValue);
                    }
                    this.hgE.j(this.hgq);
                    this.hgE.aS(!this.hgE.yC());
                    if (this.hgE.yX() != null && this.hgE.yX().getPendantData() == null && (metaData = this.userMap.get(this.hgE.yX().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                        hVar.ab(metaData.getPendantData().Kh());
                        hVar.cM(metaData.getPendantData().xu());
                        this.hgE.yX().setPendantData(hVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.hgN = new e();
                    this.hgN.hfz = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < dataRes.ala_live_insert.ala_live_list.size(); i5++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i5) != null) {
                            be beVar = new be();
                            beVar.a(dataRes.ala_live_insert.ala_live_list.get(i5));
                            arrayList.add(beVar);
                        }
                    }
                    this.hgN.hfy = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.hgO = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i6 = 0; i6 < dataRes.ala_stage_list.size(); i6++) {
                        if (dataRes.ala_stage_list.get(i6) != null) {
                            be beVar2 = new be();
                            beVar2.a(dataRes.ala_stage_list.get(i6));
                            arrayList2.add(beVar2);
                        }
                    }
                    this.hgO.hfB = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.hgG = dataRes.school_recom_pos.intValue();
                    this.hgF = new av();
                    this.hgF.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.hgH = new com.baidu.tbadk.core.data.l();
                    this.hgH.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.hgJ = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.hgK = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.hgc = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.e.a.bud().sm(dataRes.asp_shown_info);
                this.hgL = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i7 = 0; i7 < dataRes.card_shipin_new.size(); i7++) {
                        be beVar3 = new be();
                        if (this.hgL != null && this.hgL.size() >= dataRes.card_shipin_new.size()) {
                            beVar3.eX(this.hgL.get(i7).intValue());
                        }
                        beVar3.aT(true);
                        beVar3.a(dataRes.card_shipin_new.get(i7));
                        this.hgM.add(beVar3);
                    }
                }
                this.hgP = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.hgQ = new com.baidu.tieba.g.b();
                    this.hgQ.a(dataRes.esport);
                }
                this.hgR = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.hgW = new com.baidu.tieba.frs.s();
                    this.hgW.a(dataRes.user_extend);
                }
                this.hgS = dataRes.live_frs_notify;
                this.hgT = dataRes.frs_game_tab_info;
                this.hgU = dataRes.game_default_tab_id.intValue();
                this.hgV = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.hgX = new k();
                    this.hgX.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner bAb() {
        return this.hgR;
    }

    public void a(AgreeBanner agreeBanner) {
        this.hgR = agreeBanner;
    }

    public ForumHeadIcon bAc() {
        return this.hgV;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.hgV = forumHeadIcon;
    }

    public List<RecmForumInfo> bAd() {
        return this.recm_forum_list;
    }

    private void wW(int i) {
        this.hgu = 1;
        if (this.hgs != null && this.hgs.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.hgs) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.hgu = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                be beVar = new be();
                beVar.setUserMap(this.userMap);
                beVar.a(list.get(i));
                beVar.eY(3);
                beVar.zF();
                if (beVar.getFid() == 0 && j != 0) {
                    beVar.setFid(j);
                }
                if (StringUtils.isNull(beVar.zd())) {
                    beVar.cO(this.fBM.getName());
                }
                beVar.j(this.hgq);
                if (beVar.getThreadType() == 33 && !beVar.zy()) {
                    as asVar = new as();
                    asVar.a(beVar, 0);
                    asVar.C(bAq());
                    if (appResponseToIntentClass) {
                        this.threadList.add(asVar);
                    }
                } else if (!TextUtils.isEmpty(beVar.zT())) {
                    ac acVar = new ac();
                    acVar.cJ(beVar.zT());
                    this.threadList.add(acVar);
                } else {
                    this.threadList.add(beVar);
                }
            }
        }
    }

    public int bAe() {
        return this.alaLiveCount;
    }

    public void wX(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] MB() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean x(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void j(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aYy() {
        return this.fBM;
    }

    public int bAf() {
        return this.hgJ;
    }

    public void wY(int i) {
        this.hgJ = i;
    }

    public int bAg() {
        return this.hgK;
    }

    public void wZ(int i) {
        this.hgK = i;
    }

    public void c(ForumData forumData) {
        this.fBM = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> getThreadList() {
        return this.threadList;
    }

    public void az(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData xJ() {
        return this.aLS;
    }

    public void c(AntiData antiData) {
        this.aLS = antiData;
    }

    public am yb() {
        return this.eMO;
    }

    public void a(am amVar) {
        this.eMO = amVar;
    }

    public j bAh() {
        return this.hge;
    }

    public void a(j jVar) {
        this.hge = jVar;
    }

    public com.baidu.tbadk.core.data.o bAi() {
        return this.hgr;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.hgr = oVar;
    }

    public boolean bAj() {
        return this.hgf;
    }

    public void nr(boolean z) {
        this.hgf = z;
    }

    public String bAk() {
        return this.hgg;
    }

    public void sR(String str) {
        this.hgg = str;
    }

    public m bAl() {
        return this.hgh;
    }

    public void a(m mVar) {
        this.hgh = mVar;
    }

    public UserData getUserData() {
        return this.fBT;
    }

    public void e(UserData userData) {
        this.fBT = userData;
    }

    public List<Long> bAm() {
        return this.hgd;
    }

    public void dz(List<Long> list) {
        this.hgd = list;
    }

    public b bAn() {
        return this.hgi;
    }

    public void a(b bVar) {
        this.hgi = bVar;
    }

    public boolean bAo() {
        return this.hgj;
    }

    public void ns(boolean z) {
        this.hgj = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bAp() {
        return this.hgk;
    }

    public void dA(List<g> list) {
        this.hgk = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aYO() {
        return this.hgl;
    }

    public void sD(int i) {
        this.hgl = i;
    }

    public List<PhotoLiveCardData> bAq() {
        return this.hgm;
    }

    public String bAr() {
        return this.hgp;
    }

    public void sS(String str) {
        this.hgp = str;
    }

    public List<FrsTabInfo> bAs() {
        return this.hgs;
    }

    public void dB(List<FrsTabInfo> list) {
        this.hgs = list;
    }

    public void dC(List<PhotoLiveCardData> list) {
        this.hgm = list;
    }

    public boolean bAt() {
        return this.hgo != null;
    }

    public PhotoLiveCardData bAu() {
        return this.hgo;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.hgo = photoLiveCardData;
    }

    public int bAv() {
        return this.hgn;
    }

    public void xa(int i) {
        this.hgn = i;
    }

    public List<FeedForumData> bAw() {
        return this.hgv;
    }

    public void dD(List<FeedForumData> list) {
        this.hgv = list;
    }

    public void sT(String str) {
        if (this.hgv != null && str != null) {
            for (FeedForumData feedForumData : this.hgv) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.hgv.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bAx() {
        return this.hgw;
    }

    public void dE(List<CategoryInfo> list) {
        this.hgw = list;
    }

    public void sU(String str) {
        this.hgx = str;
    }

    public String bAy() {
        return this.hgx;
    }

    public be bAz() {
        return this.hgE;
    }

    public void af(be beVar) {
        this.hgE = beVar;
    }

    public int bAA() {
        return this.hgu;
    }

    public void xb(int i) {
        this.hgu = i;
    }

    public com.baidu.tbadk.core.data.w bAB() {
        return this.hgy;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.hgy = wVar;
    }

    public com.baidu.tbadk.core.data.p bAC() {
        return this.hgA;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.hgA = pVar;
    }

    public com.baidu.tbadk.core.data.r bAD() {
        return this.hgD;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.hgD = rVar;
    }

    public int bAE() {
        return this.hgG;
    }

    public void xc(int i) {
        this.hgG = i;
    }

    public av bAF() {
        return this.hgF;
    }

    public void a(av avVar) {
        this.hgF = avVar;
    }

    public NavTabInfo bAG() {
        return this.hgt;
    }

    public void a(NavTabInfo navTabInfo) {
        this.hgt = navTabInfo;
    }

    public com.baidu.tbadk.core.data.l bAH() {
        return this.hgH;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.hgH = lVar;
    }

    public Integer bAI() {
        return this.hgB;
    }

    public void j(Integer num) {
        this.hgB = num;
    }

    public List<Integer> bAJ() {
        return this.hgL;
    }

    public void dF(List<Integer> list) {
        this.hgL = list;
    }

    public List<com.baidu.adp.widget.ListView.i> bAK() {
        return this.hgM;
    }

    public void dG(List<com.baidu.adp.widget.ListView.i> list) {
        this.hgM = list;
    }

    public com.baidu.tieba.g.b bAL() {
        return this.hgQ;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.hgQ = bVar;
    }

    public AlaLiveNotify bAM() {
        return this.hgS;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.hgS = alaLiveNotify;
    }

    public List<FrsTabInfo> bAN() {
        return this.hgT;
    }

    public void dH(List<FrsTabInfo> list) {
        this.hgT = list;
    }

    public void xd(int i) {
        this.hgU = i;
    }

    public int bAO() {
        return this.hgU;
    }

    public void a(com.baidu.tieba.frs.s sVar) {
        this.hgW = sVar;
    }

    public com.baidu.tieba.frs.s bAP() {
        return this.hgW;
    }

    public k bAQ() {
        return this.hgX;
    }

    public void a(k kVar) {
        this.hgX = kVar;
    }

    public e bAR() {
        return this.hgN;
    }

    public void b(e eVar) {
        this.hgN = eVar;
    }

    public f bAS() {
        return this.hgO;
    }

    public void b(f fVar) {
        this.hgO = fVar;
    }
}
