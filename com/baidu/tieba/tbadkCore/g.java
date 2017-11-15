package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.am;
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
import tbclient.FrsPage.StarEnter;
import tbclient.FrsTabInfo;
import tbclient.PopInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData Xe;
    protected ap dRO;
    private UserData eGG;
    protected ForumData eGz;
    private String gameName;
    protected List<Long> gnL;
    private h gnM;
    protected boolean gnN;
    protected String gnO;
    protected k gnP;
    private b gnQ;
    private boolean gnR;
    private List<PhotoLiveCardData> gnU;
    private int gnV;
    private PhotoLiveCardData gnW;
    private String gnX;
    private z gnZ;
    protected List<com.baidu.adp.widget.ListView.f> goA;
    private AlaLiveNotify goB;
    private List<FrsTabInfo> goC;
    private ForumHeadIcon goE;
    private com.baidu.tieba.frs.q goF;
    private i goG;
    private List<FrsTabInfo> gob;
    private NavTabInfo goc;
    private List<FeedForumData> gof;
    private List<CategoryInfo> gog;
    private bh goo;
    private ay gop;
    private com.baidu.tbadk.core.data.m gor;
    private List<Integer> gov;
    private List<com.baidu.adp.widget.ListView.f> gow;
    public PopInfo gox;
    private com.baidu.tieba.g.b goy;
    private AgreeBanner goz;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.f> threadList;
    private HashMap<String, MetaData> userMap;
    public int gnK = 0;
    private List<e> gnS = new ArrayList();
    private int gnT = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> gnY = new ArrayList<>();
    protected com.baidu.tbadk.core.data.r goa = null;
    private int goe = 1;
    private String goh = null;
    private y goi = null;
    public aa goj = null;
    private com.baidu.tbadk.core.data.s gok = null;
    private Integer gol = -1;
    public w gom = null;
    private com.baidu.tbadk.core.data.u gon = null;
    private int goq = -1;
    protected List<com.baidu.adp.widget.ListView.f> gos = null;
    private int got = 0;
    private int gou = 0;
    private int alaLiveCount = 0;
    private int goD = 0;

    public g() {
        initData();
    }

    private void initData() {
        this.eGz = new ForumData();
        this.threadList = new ArrayList<>();
        this.gos = new ArrayList();
        this.userMap = new HashMap<>();
        this.dRO = new ap();
        this.gnM = new h();
        this.eGG = new UserData();
        this.gnP = new k();
        d(new AntiData());
        a(new b());
        this.gow = new ArrayList();
        this.gov = new ArrayList();
    }

    public FrsPageResIdl D(byte[] bArr) {
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
                if (!com.baidu.tbadk.core.util.v.v(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.v.v(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            if (oVar.a(colorEgg)) {
                                this.gnY.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.v(dataRes.activityhead.head_imgs)) {
                    this.goa = new com.baidu.tbadk.core.data.r();
                    this.goa.a(dataRes.activityhead);
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
                pq(dataRes.is_new_url.intValue());
                this.gnN = dataRes.fortune_bag.intValue() == 1;
                this.gnO = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gnR = dataRes.forum.has_game.intValue() == 1;
                    this.gnX = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gnS.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        e eVar = new e();
                        eVar.a(list2.get(i2));
                        this.gnS.add(eVar);
                    }
                }
                this.gnP.a(dataRes.gcon_account);
                this.eGz.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gnL = dataRes.thread_id_list;
                this.Xe.parserProtobuf(dataRes.anti);
                this.gnQ.a(dataRes.group);
                this.dRO.a(dataRes.page);
                this.gnM.a(dataRes.frs_star);
                this.eGG.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eGG.getIsSelectTail());
                }
                this.gob = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.goc = builder.build(true);
                } else {
                    this.goc = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                tI(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.gnU = new ArrayList();
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
                        this.gnU.add(photoLiveCardData);
                    }
                }
                this.gnV = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.gnW = new PhotoLiveCardData();
                    if (this.gnW.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.gnW;
                        this.gnW.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.gnW.getShowStyle();
                    this.gnW.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.gnW.setShowExpressionViewIndexList(this.gnW.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.gog = dataRes.category_list;
                if (!am.isEmpty(dataRes.bawu_enter_url)) {
                    this.goh = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.goi = new y();
                    this.goi.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.goj = new aa();
                    this.goj.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gok = new com.baidu.tbadk.core.data.s();
                    this.gok.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gom = new w();
                    this.gom.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gon = new com.baidu.tbadk.core.data.u();
                    this.gon.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.ntspread != null) {
                    this.gnZ = new z();
                    this.gnZ.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.goo = new bh();
                    this.goo.am(true);
                    this.goo.bW(this.gnV);
                    this.goo.setUserMap(this.userMap);
                    this.goo.a(dataRes.card_shipin_info.get(0));
                    this.goo.sc();
                    if (this.goo.getFid() == 0 && longValue != 0) {
                        this.goo.setFid(longValue);
                    }
                    this.goo.i(this.gnY);
                    this.goo.al(!this.goo.qY());
                    if (this.goo.rt() != null && this.goo.rt().getPendantData() == null && (metaData = this.userMap.get(this.goo.rt().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                        kVar.Q(metaData.getPendantData().Cv());
                        kVar.cF(metaData.getPendantData().pQ());
                        this.goo.rt().setPendantData(kVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.goq = dataRes.school_recom_pos.intValue();
                    this.gop = new ay();
                    this.gop.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gor = new com.baidu.tbadk.core.data.m();
                    this.gor.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.got = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gou = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gnK = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.e.a.bjQ().rB(dataRes.asp_shown_info);
                this.gov = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bh bhVar = new bh();
                        if (this.gov != null && this.gov.size() >= dataRes.card_shipin_new.size()) {
                            bhVar.bW(this.gov.get(i5).intValue());
                        }
                        bhVar.am(true);
                        bhVar.a(dataRes.card_shipin_new.get(i5));
                        this.gow.add(bhVar);
                    }
                }
                this.gox = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.goy = new com.baidu.tieba.g.b();
                    this.goy.a(dataRes.esport);
                }
                if (TbadkCoreApplication.isLogin() && dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1 && dataRes.forum != null) {
                    com.baidu.tbadk.data.f fVar = new com.baidu.tbadk.data.f();
                    fVar.a(dataRes.banner_user_story, 0L, dataRes.forum.id.longValue(), dataRes.forum.name, true);
                    this.goA = fVar.getList();
                    MessageManager.getInstance().sendMessageFromBackground(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, Long.valueOf(longValue)));
                }
                this.goz = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.goF = new com.baidu.tieba.frs.q();
                    this.goF.a(dataRes.user_extend);
                }
                this.goB = dataRes.live_frs_notify;
                this.goC = dataRes.frs_game_tab_info;
                this.goD = dataRes.game_default_tab_id.intValue();
                this.goE = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.goG = new i();
                    this.goG.a(dataRes.video.video_act);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.f> bsB() {
        return this.goA;
    }

    public void di(List<com.baidu.adp.widget.ListView.f> list) {
        this.goA = list;
    }

    public AgreeBanner bsC() {
        return this.goz;
    }

    public void a(AgreeBanner agreeBanner) {
        this.goz = agreeBanner;
    }

    public ForumHeadIcon bsD() {
        return this.goE;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.goE = forumHeadIcon;
    }

    private void tI(int i) {
        this.goe = 1;
        if (this.gob != null && this.gob.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gob) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.goe = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bh bhVar = new bh();
                bhVar.setUserMap(this.userMap);
                bhVar.a(list.get(i));
                bhVar.bX(3);
                bhVar.sc();
                if (bhVar.getFid() == 0 && j != 0) {
                    bhVar.setFid(j);
                }
                if (StringUtils.isNull(bhVar.rz())) {
                    bhVar.cH(this.eGz.getName());
                }
                bhVar.i(this.gnY);
                if (bhVar.getThreadType() == 33 && !bhVar.rV()) {
                    av avVar = new av();
                    avVar.a(bhVar, 0);
                    avVar.r(bsQ());
                    if (appResponseToIntentClass) {
                        this.threadList.add(avVar);
                    }
                } else if (!TextUtils.isEmpty(bhVar.sq())) {
                    af afVar = new af();
                    afVar.cC(bhVar.sq());
                    this.threadList.add(afVar);
                } else {
                    this.threadList.add(bhVar);
                }
            }
        }
    }

    public int bsE() {
        return this.alaLiveCount;
    }

    public void tJ(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] EU() {
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
    public void l(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aPU() {
        return this.eGz;
    }

    public int bsF() {
        return this.got;
    }

    public void tK(int i) {
        this.got = i;
    }

    public int bsG() {
        return this.gou;
    }

    public void tL(int i) {
        this.gou = i;
    }

    public void c(ForumData forumData) {
        this.eGz = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getThreadList() {
        return this.threadList;
    }

    public void az(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qf() {
        return this.Xe;
    }

    public void d(AntiData antiData) {
        this.Xe = antiData;
    }

    public ap qv() {
        return this.dRO;
    }

    public void a(ap apVar) {
        this.dRO = apVar;
    }

    public h bsH() {
        return this.gnM;
    }

    public void a(h hVar) {
        this.gnM = hVar;
    }

    public com.baidu.tbadk.core.data.r bsI() {
        return this.goa;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.goa = rVar;
    }

    public boolean bsJ() {
        return this.gnN;
    }

    public void mz(boolean z) {
        this.gnN = z;
    }

    public String bsK() {
        return this.gnO;
    }

    public void sq(String str) {
        this.gnO = str;
    }

    public k bsL() {
        return this.gnP;
    }

    public void a(k kVar) {
        this.gnP = kVar;
    }

    public UserData getUserData() {
        return this.eGG;
    }

    public void f(UserData userData) {
        this.eGG = userData;
    }

    public List<Long> bsM() {
        return this.gnL;
    }

    public void dj(List<Long> list) {
        this.gnL = list;
    }

    public b bsN() {
        return this.gnQ;
    }

    public void a(b bVar) {
        this.gnQ = bVar;
    }

    public boolean bsO() {
        return this.gnR;
    }

    public void mA(boolean z) {
        this.gnR = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<e> bsP() {
        return this.gnS;
    }

    public void dk(List<e> list) {
        this.gnS = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aQi() {
        return this.gnT;
    }

    public void pq(int i) {
        this.gnT = i;
    }

    public List<PhotoLiveCardData> bsQ() {
        return this.gnU;
    }

    public String bsR() {
        return this.gnX;
    }

    public void sr(String str) {
        this.gnX = str;
    }

    public List<FrsTabInfo> bsS() {
        return this.gob;
    }

    public void dl(List<FrsTabInfo> list) {
        this.gob = list;
    }

    public void dm(List<PhotoLiveCardData> list) {
        this.gnU = list;
    }

    public boolean bsT() {
        return this.gnW != null;
    }

    public PhotoLiveCardData bsU() {
        return this.gnW;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.gnW = photoLiveCardData;
    }

    public z bsV() {
        return this.gnZ;
    }

    public void a(z zVar) {
        this.gnZ = zVar;
    }

    public int bsW() {
        return this.gnV;
    }

    public void tM(int i) {
        this.gnV = i;
    }

    public List<FeedForumData> bsX() {
        return this.gof;
    }

    public void dn(List<FeedForumData> list) {
        this.gof = list;
    }

    public void ss(String str) {
        if (this.gof != null && str != null) {
            for (FeedForumData feedForumData : this.gof) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gof.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bsY() {
        return this.gog;
    }

    /* renamed from: do  reason: not valid java name */
    public void m12do(List<CategoryInfo> list) {
        this.gog = list;
    }

    public void st(String str) {
        this.goh = str;
    }

    public String bsZ() {
        return this.goh;
    }

    public bh bta() {
        return this.goo;
    }

    public void ah(bh bhVar) {
        this.goo = bhVar;
    }

    public int btb() {
        return this.goe;
    }

    public void tN(int i) {
        this.goe = i;
    }

    public y btc() {
        return this.goi;
    }

    public void a(y yVar) {
        this.goi = yVar;
    }

    public com.baidu.tbadk.core.data.s btd() {
        return this.gok;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.gok = sVar;
    }

    public com.baidu.tbadk.core.data.u bte() {
        return this.gon;
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        this.gon = uVar;
    }

    public int btf() {
        return this.goq;
    }

    public void tO(int i) {
        this.goq = i;
    }

    public ay btg() {
        return this.gop;
    }

    public void a(ay ayVar) {
        this.gop = ayVar;
    }

    public NavTabInfo bth() {
        return this.goc;
    }

    public void a(NavTabInfo navTabInfo) {
        this.goc = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m bti() {
        return this.gor;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.gor = mVar;
    }

    public Integer btj() {
        return this.gol;
    }

    public void j(Integer num) {
        this.gol = num;
    }

    public List<Integer> btk() {
        return this.gov;
    }

    public void dp(List<Integer> list) {
        this.gov = list;
    }

    public List<com.baidu.adp.widget.ListView.f> btl() {
        return this.gow;
    }

    public void dq(List<com.baidu.adp.widget.ListView.f> list) {
        this.gow = list;
    }

    public com.baidu.tieba.g.b btm() {
        return this.goy;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.goy = bVar;
    }

    public AlaLiveNotify btn() {
        return this.goB;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.goB = alaLiveNotify;
    }

    public List<FrsTabInfo> bto() {
        return this.goC;
    }

    public void dr(List<FrsTabInfo> list) {
        this.goC = list;
    }

    public void tP(int i) {
        this.goD = i;
    }

    public int btp() {
        return this.goD;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.goF = qVar;
    }

    public com.baidu.tieba.frs.q btq() {
        return this.goF;
    }

    public i btr() {
        return this.goG;
    }

    public void a(i iVar) {
        this.goG = iVar;
    }
}
