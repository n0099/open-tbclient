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
import com.baidu.tbadk.core.util.v;
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
    private AntiData WN;
    private AlaLiveNotify cEl;
    protected ap dJY;
    protected ForumData eyb;
    private UserData eyj;
    private String gameName;
    protected List<Long> gdX;
    private h gdY;
    protected boolean gdZ;
    private ay geA;
    private com.baidu.tbadk.core.data.m geC;
    private List<Integer> geG;
    private List<com.baidu.adp.widget.ListView.f> geH;
    public PopInfo geI;
    private com.baidu.tieba.g.b geJ;
    private AgreeBanner geK;
    protected List<com.baidu.adp.widget.ListView.f> geL;
    private List<FrsTabInfo> geM;
    private ForumHeadIcon geN;
    private com.baidu.tieba.frs.q geO;
    protected String gea;
    protected j geb;
    private b gec;
    private boolean ged;
    private List<PhotoLiveCardData> geg;
    private int geh;
    private PhotoLiveCardData gei;
    private String gej;
    private z gel;
    private List<FrsTabInfo> gen;
    private NavTabInfo geo;
    private List<FeedForumData> geq;
    private List<CategoryInfo> ger;
    private bh gez;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.f> threadList;
    private HashMap<String, MetaData> userMap;
    public int gdW = 0;
    private List<e> gee = new ArrayList();
    private int gef = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> gek = new ArrayList<>();
    protected com.baidu.tbadk.core.data.r gem = null;
    private int gep = 1;
    private String ges = null;
    private y get = null;
    public aa geu = null;
    private com.baidu.tbadk.core.data.s gev = null;
    private Integer gew = -1;
    public w gex = null;
    private com.baidu.tbadk.core.data.u gey = null;
    private int geB = -1;
    protected List<com.baidu.adp.widget.ListView.f> geD = null;
    private int geE = 0;
    private int geF = 0;
    private int alaLiveCount = 0;

    public g() {
        initData();
    }

    private void initData() {
        this.eyb = new ForumData();
        this.threadList = new ArrayList<>();
        this.geD = new ArrayList();
        this.userMap = new HashMap<>();
        this.dJY = new ap();
        this.gdY = new h();
        this.eyj = new UserData();
        this.geb = new j();
        d(new AntiData());
        a(new b());
        this.geH = new ArrayList();
        this.geG = new ArrayList();
    }

    public FrsPageResIdl B(byte[] bArr) {
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
                if (!v.u(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !v.u(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            if (oVar.a(colorEgg)) {
                                this.gek.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !v.u(dataRes.activityhead.head_imgs)) {
                    this.gem = new com.baidu.tbadk.core.data.r();
                    this.gem.a(dataRes.activityhead);
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
                oV(dataRes.is_new_url.intValue());
                this.gdZ = dataRes.fortune_bag.intValue() == 1;
                this.gea = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.ged = dataRes.forum.has_game.intValue() == 1;
                    this.gej = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gee.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        e eVar = new e();
                        eVar.a(list2.get(i2));
                        this.gee.add(eVar);
                    }
                }
                this.geb.a(dataRes.gcon_account);
                this.eyb.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gdX = dataRes.thread_id_list;
                this.WN.parserProtobuf(dataRes.anti);
                this.gec.a(dataRes.group);
                this.dJY.a(dataRes.page);
                this.gdY.a(dataRes.frs_star);
                this.eyj.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eyj.getIsSelectTail());
                }
                this.gen = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.geo = builder.build(true);
                } else {
                    this.geo = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                to(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.geg = new ArrayList();
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
                        this.geg.add(photoLiveCardData);
                    }
                }
                this.geh = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.gei = new PhotoLiveCardData();
                    if (this.gei.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.gei;
                        this.gei.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.gei.getShowStyle();
                    this.gei.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.gei.setShowExpressionViewIndexList(this.gei.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.ger = dataRes.category_list;
                if (!am.isEmpty(dataRes.bawu_enter_url)) {
                    this.ges = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.get = new y();
                    this.get.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.geu = new aa();
                    this.geu.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gev = new com.baidu.tbadk.core.data.s();
                    this.gev.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gex = new w();
                    this.gex.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gey = new com.baidu.tbadk.core.data.u();
                    this.gey.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.ntspread != null) {
                    this.gel = new z();
                    this.gel.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gez = new bh();
                    this.gez.ao(true);
                    this.gez.bW(this.geh);
                    this.gez.setUserMap(this.userMap);
                    this.gez.a(dataRes.card_shipin_info.get(0));
                    this.gez.rW();
                    if (this.gez.getFid() == 0 && longValue != 0) {
                        this.gez.setFid(longValue);
                    }
                    this.gez.i(this.gek);
                    this.gez.an(!this.gez.qU());
                    if (this.gez.getAuthor() != null && this.gez.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.gez.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                        iVar.Q(metaData.getPendantData().BU());
                        iVar.cz(metaData.getPendantData().pL());
                        this.gez.getAuthor().setPendantData(iVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.geB = dataRes.school_recom_pos.intValue();
                    this.geA = new ay();
                    this.geA.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.geC = new com.baidu.tbadk.core.data.m();
                    this.geC.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.geE = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.geF = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gdW = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bgt().qN(dataRes.asp_shown_info);
                this.geG = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bh bhVar = new bh();
                        if (this.geG != null && this.geG.size() >= dataRes.card_shipin_new.size()) {
                            bhVar.bW(this.geG.get(i5).intValue());
                        }
                        bhVar.ao(true);
                        bhVar.a(dataRes.card_shipin_new.get(i5));
                        this.geH.add(bhVar);
                    }
                }
                this.geI = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.geJ = new com.baidu.tieba.g.b();
                    this.geJ.a(dataRes.esport);
                }
                if (TbadkCoreApplication.isLogin() && dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1) {
                    com.baidu.tbadk.data.d dVar = new com.baidu.tbadk.data.d();
                    dVar.a(dataRes.banner_user_story, longValue);
                    this.geL = dVar.BL();
                    MessageManager.getInstance().sendMessageFromBackground(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, Long.valueOf(longValue)));
                }
                this.geK = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.geO = new com.baidu.tieba.frs.q();
                    this.geO.a(dataRes.user_extend);
                }
                this.cEl = dataRes.live_frs_notify;
                this.geM = dataRes.frs_game_tab_info;
                this.geN = dataRes.forum_head_icon;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.f> bpm() {
        return this.geL;
    }

    public void df(List<com.baidu.adp.widget.ListView.f> list) {
        this.geL = list;
    }

    public AgreeBanner bpn() {
        return this.geK;
    }

    public void a(AgreeBanner agreeBanner) {
        this.geK = agreeBanner;
    }

    public ForumHeadIcon bpo() {
        return this.geN;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.geN = forumHeadIcon;
    }

    private void to(int i) {
        this.gep = 1;
        if (this.gen != null && this.gen.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gen) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gep = i;
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
                bhVar.rW();
                if (bhVar.getFid() == 0 && j != 0) {
                    bhVar.setFid(j);
                }
                if (StringUtils.isNull(bhVar.rt())) {
                    bhVar.cB(this.eyb.getName());
                }
                bhVar.i(this.gek);
                if (bhVar.getThreadType() == 33 && !bhVar.rP()) {
                    av avVar = new av();
                    avVar.a(bhVar, 0);
                    avVar.q(bpB());
                    if (appResponseToIntentClass) {
                        this.threadList.add(avVar);
                    }
                } else if (!TextUtils.isEmpty(bhVar.sj())) {
                    af afVar = new af();
                    afVar.cw(bhVar.sj());
                    this.threadList.add(afVar);
                } else {
                    this.threadList.add(bhVar);
                }
            }
        }
    }

    public int bpp() {
        return this.alaLiveCount;
    }

    public void tp(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Ew() {
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
    public void k(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aMU() {
        return this.eyb;
    }

    public int bpq() {
        return this.geE;
    }

    public void tq(int i) {
        this.geE = i;
    }

    public int bpr() {
        return this.geF;
    }

    public void tr(int i) {
        this.geF = i;
    }

    public void c(ForumData forumData) {
        this.eyb = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getThreadList() {
        return this.threadList;
    }

    public void az(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qa() {
        return this.WN;
    }

    public void d(AntiData antiData) {
        this.WN = antiData;
    }

    public ap qq() {
        return this.dJY;
    }

    public void a(ap apVar) {
        this.dJY = apVar;
    }

    public h bps() {
        return this.gdY;
    }

    public void a(h hVar) {
        this.gdY = hVar;
    }

    public com.baidu.tbadk.core.data.r bpt() {
        return this.gem;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.gem = rVar;
    }

    public boolean bpu() {
        return this.gdZ;
    }

    public void mw(boolean z) {
        this.gdZ = z;
    }

    public String bpv() {
        return this.gea;
    }

    public void rC(String str) {
        this.gea = str;
    }

    public j bpw() {
        return this.geb;
    }

    public void a(j jVar) {
        this.geb = jVar;
    }

    public UserData getUserData() {
        return this.eyj;
    }

    public void e(UserData userData) {
        this.eyj = userData;
    }

    public List<Long> bpx() {
        return this.gdX;
    }

    public void dg(List<Long> list) {
        this.gdX = list;
    }

    public b bpy() {
        return this.gec;
    }

    public void a(b bVar) {
        this.gec = bVar;
    }

    public boolean bpz() {
        return this.ged;
    }

    public void mx(boolean z) {
        this.ged = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<e> bpA() {
        return this.gee;
    }

    public void dh(List<e> list) {
        this.gee = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aNi() {
        return this.gef;
    }

    public void oV(int i) {
        this.gef = i;
    }

    public List<PhotoLiveCardData> bpB() {
        return this.geg;
    }

    public String bpC() {
        return this.gej;
    }

    public void rD(String str) {
        this.gej = str;
    }

    public List<FrsTabInfo> bpD() {
        return this.gen;
    }

    public void di(List<FrsTabInfo> list) {
        this.gen = list;
    }

    public void dj(List<PhotoLiveCardData> list) {
        this.geg = list;
    }

    public boolean bpE() {
        return this.gei != null;
    }

    public PhotoLiveCardData bpF() {
        return this.gei;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.gei = photoLiveCardData;
    }

    public z bpG() {
        return this.gel;
    }

    public void a(z zVar) {
        this.gel = zVar;
    }

    public int bpH() {
        return this.geh;
    }

    public void ts(int i) {
        this.geh = i;
    }

    public List<FeedForumData> bpI() {
        return this.geq;
    }

    public void dk(List<FeedForumData> list) {
        this.geq = list;
    }

    public void rE(String str) {
        if (this.geq != null && str != null) {
            for (FeedForumData feedForumData : this.geq) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.geq.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bpJ() {
        return this.ger;
    }

    public void dl(List<CategoryInfo> list) {
        this.ger = list;
    }

    public void rF(String str) {
        this.ges = str;
    }

    public String bpK() {
        return this.ges;
    }

    public bh bpL() {
        return this.gez;
    }

    public void ah(bh bhVar) {
        this.gez = bhVar;
    }

    public int bpM() {
        return this.gep;
    }

    public void tt(int i) {
        this.gep = i;
    }

    public y bpN() {
        return this.get;
    }

    public void a(y yVar) {
        this.get = yVar;
    }

    public com.baidu.tbadk.core.data.s bpO() {
        return this.gev;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.gev = sVar;
    }

    public com.baidu.tbadk.core.data.u bpP() {
        return this.gey;
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        this.gey = uVar;
    }

    public int bpQ() {
        return this.geB;
    }

    public void tu(int i) {
        this.geB = i;
    }

    public ay bpR() {
        return this.geA;
    }

    public void a(ay ayVar) {
        this.geA = ayVar;
    }

    public NavTabInfo bpS() {
        return this.geo;
    }

    public void a(NavTabInfo navTabInfo) {
        this.geo = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m bpT() {
        return this.geC;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.geC = mVar;
    }

    public Integer bpU() {
        return this.gew;
    }

    public void j(Integer num) {
        this.gew = num;
    }

    public List<Integer> bpV() {
        return this.geG;
    }

    public void dm(List<Integer> list) {
        this.geG = list;
    }

    public List<com.baidu.adp.widget.ListView.f> bpW() {
        return this.geH;
    }

    public void dn(List<com.baidu.adp.widget.ListView.f> list) {
        this.geH = list;
    }

    public com.baidu.tieba.g.b bpX() {
        return this.geJ;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.geJ = bVar;
    }

    public AlaLiveNotify bpY() {
        return this.cEl;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.cEl = alaLiveNotify;
    }

    public List<FrsTabInfo> bpZ() {
        return this.geM;
    }

    /* renamed from: do  reason: not valid java name */
    public void m13do(List<FrsTabInfo> list) {
        this.geM = list;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.geO = qVar;
    }

    public com.baidu.tieba.frs.q bqa() {
        return this.geO;
    }
}
