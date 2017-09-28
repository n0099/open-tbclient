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
    private z geA;
    private List<FrsTabInfo> geC;
    private NavTabInfo geD;
    private List<FeedForumData> geF;
    private List<CategoryInfo> geG;
    private bh geO;
    private ay geP;
    private com.baidu.tbadk.core.data.m geR;
    private List<Integer> geV;
    private List<com.baidu.adp.widget.ListView.f> geW;
    public PopInfo geX;
    private com.baidu.tieba.g.b geY;
    private AgreeBanner geZ;
    protected List<Long> gem;
    private h gen;
    protected boolean geo;
    protected String gep;
    protected j geq;
    private b ger;
    private boolean ges;
    private List<PhotoLiveCardData> gev;
    private int gew;
    private PhotoLiveCardData gex;
    private String gey;
    protected List<com.baidu.adp.widget.ListView.f> gfa;
    private List<FrsTabInfo> gfb;
    private ForumHeadIcon gfc;
    private com.baidu.tieba.frs.q gfd;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.f> threadList;
    private HashMap<String, MetaData> userMap;
    public int gel = 0;
    private List<e> get = new ArrayList();
    private int geu = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> gez = new ArrayList<>();
    protected com.baidu.tbadk.core.data.r geB = null;
    private int geE = 1;
    private String geH = null;
    private y geI = null;
    public aa geJ = null;
    private com.baidu.tbadk.core.data.s geK = null;
    private Integer geL = -1;
    public w geM = null;
    private com.baidu.tbadk.core.data.u geN = null;
    private int geQ = -1;
    protected List<com.baidu.adp.widget.ListView.f> geS = null;
    private int geT = 0;
    private int geU = 0;
    private int alaLiveCount = 0;

    public g() {
        initData();
    }

    private void initData() {
        this.eyq = new ForumData();
        this.threadList = new ArrayList<>();
        this.geS = new ArrayList();
        this.userMap = new HashMap<>();
        this.dKm = new ap();
        this.gen = new h();
        this.eyy = new UserData();
        this.geq = new j();
        d(new AntiData());
        a(new b());
        this.geW = new ArrayList();
        this.geV = new ArrayList();
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
                                this.gez.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !v.u(dataRes.activityhead.head_imgs)) {
                    this.geB = new com.baidu.tbadk.core.data.r();
                    this.geB.a(dataRes.activityhead);
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
                this.geo = dataRes.fortune_bag.intValue() == 1;
                this.gep = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.ges = dataRes.forum.has_game.intValue() == 1;
                    this.gey = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.get.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        e eVar = new e();
                        eVar.a(list2.get(i2));
                        this.get.add(eVar);
                    }
                }
                this.geq.a(dataRes.gcon_account);
                this.eyq.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gem = dataRes.thread_id_list;
                this.WZ.parserProtobuf(dataRes.anti);
                this.ger.a(dataRes.group);
                this.dKm.a(dataRes.page);
                this.gen.a(dataRes.frs_star);
                this.eyy.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eyy.getIsSelectTail());
                }
                this.geC = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.geD = builder.build(true);
                } else {
                    this.geD = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                tp(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.gev = new ArrayList();
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
                        this.gev.add(photoLiveCardData);
                    }
                }
                this.gew = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.gex = new PhotoLiveCardData();
                    if (this.gex.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.gex;
                        this.gex.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.gex.getShowStyle();
                    this.gex.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.gex.setShowExpressionViewIndexList(this.gex.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.geG = dataRes.category_list;
                if (!am.isEmpty(dataRes.bawu_enter_url)) {
                    this.geH = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.geI = new y();
                    this.geI.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.geJ = new aa();
                    this.geJ.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.geK = new com.baidu.tbadk.core.data.s();
                    this.geK.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.geM = new w();
                    this.geM.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.geN = new com.baidu.tbadk.core.data.u();
                    this.geN.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.ntspread != null) {
                    this.geA = new z();
                    this.geA.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.geO = new bh();
                    this.geO.ap(true);
                    this.geO.bX(this.gew);
                    this.geO.setUserMap(this.userMap);
                    this.geO.a(dataRes.card_shipin_info.get(0));
                    this.geO.sd();
                    if (this.geO.getFid() == 0 && longValue != 0) {
                        this.geO.setFid(longValue);
                    }
                    this.geO.i(this.gez);
                    this.geO.ao(!this.geO.rb());
                    if (this.geO.getAuthor() != null && this.geO.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.geO.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                        iVar.P(metaData.getPendantData().Ca());
                        iVar.cA(metaData.getPendantData().pS());
                        this.geO.getAuthor().setPendantData(iVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.geQ = dataRes.school_recom_pos.intValue();
                    this.geP = new ay();
                    this.geP.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.geR = new com.baidu.tbadk.core.data.m();
                    this.geR.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.geT = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.geU = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gel = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bgz().qO(dataRes.asp_shown_info);
                this.geV = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bh bhVar = new bh();
                        if (this.geV != null && this.geV.size() >= dataRes.card_shipin_new.size()) {
                            bhVar.bX(this.geV.get(i5).intValue());
                        }
                        bhVar.ap(true);
                        bhVar.a(dataRes.card_shipin_new.get(i5));
                        this.geW.add(bhVar);
                    }
                }
                this.geX = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.geY = new com.baidu.tieba.g.b();
                    this.geY.a(dataRes.esport);
                }
                if (TbadkCoreApplication.isLogin() && dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1) {
                    com.baidu.tbadk.data.d dVar = new com.baidu.tbadk.data.d();
                    dVar.a(dataRes.banner_user_story, longValue);
                    this.gfa = dVar.BR();
                    MessageManager.getInstance().sendMessageFromBackground(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, Long.valueOf(longValue)));
                }
                this.geZ = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gfd = new com.baidu.tieba.frs.q();
                    this.gfd.a(dataRes.user_extend);
                }
                this.cEx = dataRes.live_frs_notify;
                this.gfb = dataRes.frs_game_tab_info;
                this.gfc = dataRes.forum_head_icon;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.f> bpu() {
        return this.gfa;
    }

    public void df(List<com.baidu.adp.widget.ListView.f> list) {
        this.gfa = list;
    }

    public AgreeBanner bpv() {
        return this.geZ;
    }

    public void a(AgreeBanner agreeBanner) {
        this.geZ = agreeBanner;
    }

    public ForumHeadIcon bpw() {
        return this.gfc;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gfc = forumHeadIcon;
    }

    private void tp(int i) {
        this.geE = 1;
        if (this.geC != null && this.geC.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.geC) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.geE = i;
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
                bhVar.i(this.gez);
                if (bhVar.getThreadType() == 33 && !bhVar.rW()) {
                    av avVar = new av();
                    avVar.a(bhVar, 0);
                    avVar.q(bpJ());
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

    public int bpx() {
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

    public int bpy() {
        return this.geT;
    }

    public void tr(int i) {
        this.geT = i;
    }

    public int bpz() {
        return this.geU;
    }

    public void ts(int i) {
        this.geU = i;
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

    public h bpA() {
        return this.gen;
    }

    public void a(h hVar) {
        this.gen = hVar;
    }

    public com.baidu.tbadk.core.data.r bpB() {
        return this.geB;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.geB = rVar;
    }

    public boolean bpC() {
        return this.geo;
    }

    public void mx(boolean z) {
        this.geo = z;
    }

    public String bpD() {
        return this.gep;
    }

    public void rD(String str) {
        this.gep = str;
    }

    public j bpE() {
        return this.geq;
    }

    public void a(j jVar) {
        this.geq = jVar;
    }

    public UserData getUserData() {
        return this.eyy;
    }

    public void e(UserData userData) {
        this.eyy = userData;
    }

    public List<Long> bpF() {
        return this.gem;
    }

    public void dg(List<Long> list) {
        this.gem = list;
    }

    public b bpG() {
        return this.ger;
    }

    public void a(b bVar) {
        this.ger = bVar;
    }

    public boolean bpH() {
        return this.ges;
    }

    public void my(boolean z) {
        this.ges = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<e> bpI() {
        return this.get;
    }

    public void dh(List<e> list) {
        this.get = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aNn() {
        return this.geu;
    }

    public void oW(int i) {
        this.geu = i;
    }

    public List<PhotoLiveCardData> bpJ() {
        return this.gev;
    }

    public String bpK() {
        return this.gey;
    }

    public void rE(String str) {
        this.gey = str;
    }

    public List<FrsTabInfo> bpL() {
        return this.geC;
    }

    public void di(List<FrsTabInfo> list) {
        this.geC = list;
    }

    public void dj(List<PhotoLiveCardData> list) {
        this.gev = list;
    }

    public boolean bpM() {
        return this.gex != null;
    }

    public PhotoLiveCardData bpN() {
        return this.gex;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.gex = photoLiveCardData;
    }

    public z bpO() {
        return this.geA;
    }

    public void a(z zVar) {
        this.geA = zVar;
    }

    public int bpP() {
        return this.gew;
    }

    public void tt(int i) {
        this.gew = i;
    }

    public List<FeedForumData> bpQ() {
        return this.geF;
    }

    public void dk(List<FeedForumData> list) {
        this.geF = list;
    }

    public void rF(String str) {
        if (this.geF != null && str != null) {
            for (FeedForumData feedForumData : this.geF) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.geF.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bpR() {
        return this.geG;
    }

    public void dl(List<CategoryInfo> list) {
        this.geG = list;
    }

    public void rG(String str) {
        this.geH = str;
    }

    public String bpS() {
        return this.geH;
    }

    public bh bpT() {
        return this.geO;
    }

    public void ah(bh bhVar) {
        this.geO = bhVar;
    }

    public int bpU() {
        return this.geE;
    }

    public void tu(int i) {
        this.geE = i;
    }

    public y bpV() {
        return this.geI;
    }

    public void a(y yVar) {
        this.geI = yVar;
    }

    public com.baidu.tbadk.core.data.s bpW() {
        return this.geK;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.geK = sVar;
    }

    public com.baidu.tbadk.core.data.u bpX() {
        return this.geN;
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        this.geN = uVar;
    }

    public int bpY() {
        return this.geQ;
    }

    public void tv(int i) {
        this.geQ = i;
    }

    public ay bpZ() {
        return this.geP;
    }

    public void a(ay ayVar) {
        this.geP = ayVar;
    }

    public NavTabInfo bqa() {
        return this.geD;
    }

    public void a(NavTabInfo navTabInfo) {
        this.geD = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m bqb() {
        return this.geR;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.geR = mVar;
    }

    public Integer bqc() {
        return this.geL;
    }

    public void j(Integer num) {
        this.geL = num;
    }

    public List<Integer> bqd() {
        return this.geV;
    }

    public void dm(List<Integer> list) {
        this.geV = list;
    }

    public List<com.baidu.adp.widget.ListView.f> bqe() {
        return this.geW;
    }

    public void dn(List<com.baidu.adp.widget.ListView.f> list) {
        this.geW = list;
    }

    public com.baidu.tieba.g.b bqf() {
        return this.geY;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.geY = bVar;
    }

    public AlaLiveNotify bqg() {
        return this.cEx;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.cEx = alaLiveNotify;
    }

    public List<FrsTabInfo> bqh() {
        return this.gfb;
    }

    /* renamed from: do  reason: not valid java name */
    public void m12do(List<FrsTabInfo> list) {
        this.gfb = list;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.gfd = qVar;
    }

    public com.baidu.tieba.frs.q bqi() {
        return this.gfd;
    }
}
