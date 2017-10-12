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
    private AntiData WZ;
    private AlaLiveNotify cEx;
    protected ap dKm;
    protected ForumData eyq;
    private UserData eyy;
    private String gameName;
    private List<FrsTabInfo> geB;
    private NavTabInfo geC;
    private List<FeedForumData> geE;
    private List<CategoryInfo> geF;
    private bh geN;
    private ay geO;
    private com.baidu.tbadk.core.data.m geQ;
    private List<Integer> geU;
    private List<com.baidu.adp.widget.ListView.f> geV;
    public PopInfo geW;
    private com.baidu.tieba.g.b geX;
    private AgreeBanner geY;
    protected List<com.baidu.adp.widget.ListView.f> geZ;
    protected List<Long> gel;
    private h gem;
    protected boolean gen;
    protected String geo;
    protected j gep;
    private b geq;
    private boolean ger;
    private List<PhotoLiveCardData> geu;
    private int gev;
    private PhotoLiveCardData gew;
    private String gex;
    private z gez;
    private List<FrsTabInfo> gfa;
    private ForumHeadIcon gfb;
    private com.baidu.tieba.frs.q gfc;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.f> threadList;
    private HashMap<String, MetaData> userMap;
    public int gek = 0;
    private List<e> ges = new ArrayList();
    private int get = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> gey = new ArrayList<>();
    protected com.baidu.tbadk.core.data.r geA = null;
    private int geD = 1;
    private String geG = null;
    private y geH = null;
    public aa geI = null;
    private com.baidu.tbadk.core.data.s geJ = null;
    private Integer geK = -1;
    public w geL = null;
    private com.baidu.tbadk.core.data.u geM = null;
    private int geP = -1;
    protected List<com.baidu.adp.widget.ListView.f> geR = null;
    private int geS = 0;
    private int geT = 0;
    private int alaLiveCount = 0;

    public g() {
        initData();
    }

    private void initData() {
        this.eyq = new ForumData();
        this.threadList = new ArrayList<>();
        this.geR = new ArrayList();
        this.userMap = new HashMap<>();
        this.dKm = new ap();
        this.gem = new h();
        this.eyy = new UserData();
        this.gep = new j();
        d(new AntiData());
        a(new b());
        this.geV = new ArrayList();
        this.geU = new ArrayList();
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
                                this.gey.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !v.u(dataRes.activityhead.head_imgs)) {
                    this.geA = new com.baidu.tbadk.core.data.r();
                    this.geA.a(dataRes.activityhead);
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
                oW(dataRes.is_new_url.intValue());
                this.gen = dataRes.fortune_bag.intValue() == 1;
                this.geo = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.ger = dataRes.forum.has_game.intValue() == 1;
                    this.gex = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.ges.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        e eVar = new e();
                        eVar.a(list2.get(i2));
                        this.ges.add(eVar);
                    }
                }
                this.gep.a(dataRes.gcon_account);
                this.eyq.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gel = dataRes.thread_id_list;
                this.WZ.parserProtobuf(dataRes.anti);
                this.geq.a(dataRes.group);
                this.dKm.a(dataRes.page);
                this.gem.a(dataRes.frs_star);
                this.eyy.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eyy.getIsSelectTail());
                }
                this.geB = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.geC = builder.build(true);
                } else {
                    this.geC = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                tp(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.geu = new ArrayList();
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
                        this.geu.add(photoLiveCardData);
                    }
                }
                this.gev = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.gew = new PhotoLiveCardData();
                    if (this.gew.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.gew;
                        this.gew.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.gew.getShowStyle();
                    this.gew.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.gew.setShowExpressionViewIndexList(this.gew.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.geF = dataRes.category_list;
                if (!am.isEmpty(dataRes.bawu_enter_url)) {
                    this.geG = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.geH = new y();
                    this.geH.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.geI = new aa();
                    this.geI.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.geJ = new com.baidu.tbadk.core.data.s();
                    this.geJ.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.geL = new w();
                    this.geL.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.geM = new com.baidu.tbadk.core.data.u();
                    this.geM.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.ntspread != null) {
                    this.gez = new z();
                    this.gez.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.geN = new bh();
                    this.geN.ap(true);
                    this.geN.bX(this.gev);
                    this.geN.setUserMap(this.userMap);
                    this.geN.a(dataRes.card_shipin_info.get(0));
                    this.geN.sd();
                    if (this.geN.getFid() == 0 && longValue != 0) {
                        this.geN.setFid(longValue);
                    }
                    this.geN.i(this.gey);
                    this.geN.ao(!this.geN.rb());
                    if (this.geN.getAuthor() != null && this.geN.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.geN.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                        iVar.P(metaData.getPendantData().Ca());
                        iVar.cA(metaData.getPendantData().pS());
                        this.geN.getAuthor().setPendantData(iVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.geP = dataRes.school_recom_pos.intValue();
                    this.geO = new ay();
                    this.geO.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.geQ = new com.baidu.tbadk.core.data.m();
                    this.geQ.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.geS = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.geT = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gek = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bgy().qO(dataRes.asp_shown_info);
                this.geU = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bh bhVar = new bh();
                        if (this.geU != null && this.geU.size() >= dataRes.card_shipin_new.size()) {
                            bhVar.bX(this.geU.get(i5).intValue());
                        }
                        bhVar.ap(true);
                        bhVar.a(dataRes.card_shipin_new.get(i5));
                        this.geV.add(bhVar);
                    }
                }
                this.geW = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.geX = new com.baidu.tieba.g.b();
                    this.geX.a(dataRes.esport);
                }
                if (TbadkCoreApplication.isLogin() && dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1) {
                    com.baidu.tbadk.data.d dVar = new com.baidu.tbadk.data.d();
                    dVar.a(dataRes.banner_user_story, longValue);
                    this.geZ = dVar.BR();
                    MessageManager.getInstance().sendMessageFromBackground(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, Long.valueOf(longValue)));
                }
                this.geY = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gfc = new com.baidu.tieba.frs.q();
                    this.gfc.a(dataRes.user_extend);
                }
                this.cEx = dataRes.live_frs_notify;
                this.gfa = dataRes.frs_game_tab_info;
                this.gfb = dataRes.forum_head_icon;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.f> bpt() {
        return this.geZ;
    }

    public void df(List<com.baidu.adp.widget.ListView.f> list) {
        this.geZ = list;
    }

    public AgreeBanner bpu() {
        return this.geY;
    }

    public void a(AgreeBanner agreeBanner) {
        this.geY = agreeBanner;
    }

    public ForumHeadIcon bpv() {
        return this.gfb;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gfb = forumHeadIcon;
    }

    private void tp(int i) {
        this.geD = 1;
        if (this.geB != null && this.geB.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.geB) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.geD = i;
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
                bhVar.bY(3);
                bhVar.sd();
                if (bhVar.getFid() == 0 && j != 0) {
                    bhVar.setFid(j);
                }
                if (StringUtils.isNull(bhVar.rA())) {
                    bhVar.cC(this.eyq.getName());
                }
                bhVar.i(this.gey);
                if (bhVar.getThreadType() == 33 && !bhVar.rW()) {
                    av avVar = new av();
                    avVar.a(bhVar, 0);
                    avVar.q(bpI());
                    if (appResponseToIntentClass) {
                        this.threadList.add(avVar);
                    }
                } else if (!TextUtils.isEmpty(bhVar.sq())) {
                    af afVar = new af();
                    afVar.cx(bhVar.sq());
                    this.threadList.add(afVar);
                } else {
                    this.threadList.add(bhVar);
                }
            }
        }
    }

    public int bpw() {
        return this.alaLiveCount;
    }

    public void tq(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] EC() {
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
    public void i(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aMZ() {
        return this.eyq;
    }

    public int bpx() {
        return this.geS;
    }

    public void tr(int i) {
        this.geS = i;
    }

    public int bpy() {
        return this.geT;
    }

    public void ts(int i) {
        this.geT = i;
    }

    public void c(ForumData forumData) {
        this.eyq = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getThreadList() {
        return this.threadList;
    }

    public void az(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qh() {
        return this.WZ;
    }

    public void d(AntiData antiData) {
        this.WZ = antiData;
    }

    public ap qx() {
        return this.dKm;
    }

    public void a(ap apVar) {
        this.dKm = apVar;
    }

    public h bpz() {
        return this.gem;
    }

    public void a(h hVar) {
        this.gem = hVar;
    }

    public com.baidu.tbadk.core.data.r bpA() {
        return this.geA;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.geA = rVar;
    }

    public boolean bpB() {
        return this.gen;
    }

    public void mx(boolean z) {
        this.gen = z;
    }

    public String bpC() {
        return this.geo;
    }

    public void rD(String str) {
        this.geo = str;
    }

    public j bpD() {
        return this.gep;
    }

    public void a(j jVar) {
        this.gep = jVar;
    }

    public UserData getUserData() {
        return this.eyy;
    }

    public void e(UserData userData) {
        this.eyy = userData;
    }

    public List<Long> bpE() {
        return this.gel;
    }

    public void dg(List<Long> list) {
        this.gel = list;
    }

    public b bpF() {
        return this.geq;
    }

    public void a(b bVar) {
        this.geq = bVar;
    }

    public boolean bpG() {
        return this.ger;
    }

    public void my(boolean z) {
        this.ger = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<e> bpH() {
        return this.ges;
    }

    public void dh(List<e> list) {
        this.ges = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aNn() {
        return this.get;
    }

    public void oW(int i) {
        this.get = i;
    }

    public List<PhotoLiveCardData> bpI() {
        return this.geu;
    }

    public String bpJ() {
        return this.gex;
    }

    public void rE(String str) {
        this.gex = str;
    }

    public List<FrsTabInfo> bpK() {
        return this.geB;
    }

    public void di(List<FrsTabInfo> list) {
        this.geB = list;
    }

    public void dj(List<PhotoLiveCardData> list) {
        this.geu = list;
    }

    public boolean bpL() {
        return this.gew != null;
    }

    public PhotoLiveCardData bpM() {
        return this.gew;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.gew = photoLiveCardData;
    }

    public z bpN() {
        return this.gez;
    }

    public void a(z zVar) {
        this.gez = zVar;
    }

    public int bpO() {
        return this.gev;
    }

    public void tt(int i) {
        this.gev = i;
    }

    public List<FeedForumData> bpP() {
        return this.geE;
    }

    public void dk(List<FeedForumData> list) {
        this.geE = list;
    }

    public void rF(String str) {
        if (this.geE != null && str != null) {
            for (FeedForumData feedForumData : this.geE) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.geE.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bpQ() {
        return this.geF;
    }

    public void dl(List<CategoryInfo> list) {
        this.geF = list;
    }

    public void rG(String str) {
        this.geG = str;
    }

    public String bpR() {
        return this.geG;
    }

    public bh bpS() {
        return this.geN;
    }

    public void ah(bh bhVar) {
        this.geN = bhVar;
    }

    public int bpT() {
        return this.geD;
    }

    public void tu(int i) {
        this.geD = i;
    }

    public y bpU() {
        return this.geH;
    }

    public void a(y yVar) {
        this.geH = yVar;
    }

    public com.baidu.tbadk.core.data.s bpV() {
        return this.geJ;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.geJ = sVar;
    }

    public com.baidu.tbadk.core.data.u bpW() {
        return this.geM;
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        this.geM = uVar;
    }

    public int bpX() {
        return this.geP;
    }

    public void tv(int i) {
        this.geP = i;
    }

    public ay bpY() {
        return this.geO;
    }

    public void a(ay ayVar) {
        this.geO = ayVar;
    }

    public NavTabInfo bpZ() {
        return this.geC;
    }

    public void a(NavTabInfo navTabInfo) {
        this.geC = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m bqa() {
        return this.geQ;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.geQ = mVar;
    }

    public Integer bqb() {
        return this.geK;
    }

    public void j(Integer num) {
        this.geK = num;
    }

    public List<Integer> bqc() {
        return this.geU;
    }

    public void dm(List<Integer> list) {
        this.geU = list;
    }

    public List<com.baidu.adp.widget.ListView.f> bqd() {
        return this.geV;
    }

    public void dn(List<com.baidu.adp.widget.ListView.f> list) {
        this.geV = list;
    }

    public com.baidu.tieba.g.b bqe() {
        return this.geX;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.geX = bVar;
    }

    public AlaLiveNotify bqf() {
        return this.cEx;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.cEx = alaLiveNotify;
    }

    public List<FrsTabInfo> bqg() {
        return this.gfa;
    }

    /* renamed from: do  reason: not valid java name */
    public void m12do(List<FrsTabInfo> list) {
        this.gfa = list;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.gfc = qVar;
    }

    public com.baidu.tieba.frs.q bqh() {
        return this.gfc;
    }
}
