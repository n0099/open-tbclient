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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.data.bj;
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
    private AntiData WY;
    private AlaLiveNotify cDE;
    protected ar dNU;
    protected ForumData eEV;
    private UserData eFb;
    private String gameName;
    protected List<Long> ggF;
    private h ggG;
    protected boolean ggH;
    protected String ggI;
    protected j ggJ;
    private b ggK;
    private boolean ggL;
    private List<PhotoLiveCardData> ggO;
    private int ggP;
    private PhotoLiveCardData ggQ;
    private String ggR;
    private z ggT;
    private List<FrsTabInfo> ggV;
    private NavTabInfo ggW;
    private List<FeedForumData> ggY;
    private List<CategoryInfo> ggZ;
    private bj ghh;
    private ba ghi;
    private com.baidu.tbadk.core.data.m ghk;
    private List<Integer> gho;
    private List<com.baidu.adp.widget.ListView.f> ghp;
    public PopInfo ghr;
    private com.baidu.tieba.g.b ghs;
    private AgreeBanner ght;
    protected List<com.baidu.adp.widget.ListView.f> ghu;
    private List<FrsTabInfo> ghv;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.f> threadList;
    private HashMap<String, MetaData> userMap;
    public int ggE = 0;
    private List<e> ggM = new ArrayList();
    private int ggN = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> ggS = new ArrayList<>();
    protected com.baidu.tbadk.core.data.r ggU = null;
    private int ggX = 1;
    private String gha = null;
    private y ghb = null;
    public aa ghc = null;
    private com.baidu.tbadk.core.data.s ghd = null;
    private Integer ghe = -1;
    public w ghf = null;
    private com.baidu.tbadk.core.data.u ghg = null;
    private int ghj = -1;
    protected List<com.baidu.adp.widget.ListView.f> ghl = null;
    private int ghm = 0;
    private int ghn = 0;
    private boolean isShowDriftingBottle = false;
    private long ghq = 0;
    private int alaLiveCount = 0;

    public g() {
        initData();
    }

    private void initData() {
        this.eEV = new ForumData();
        this.threadList = new ArrayList<>();
        this.ghl = new ArrayList();
        this.userMap = new HashMap<>();
        this.dNU = new ar();
        this.ggG = new h();
        this.eFb = new UserData();
        this.ggJ = new j();
        d(new AntiData());
        a(new b());
        this.ghp = new ArrayList();
        this.gho = new ArrayList();
    }

    public FrsPageResIdl A(byte[] bArr) {
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
                if (!v.v(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !v.v(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            if (oVar.a(colorEgg)) {
                                this.ggS.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !v.v(dataRes.activityhead.head_imgs)) {
                    this.ggU = new com.baidu.tbadk.core.data.r();
                    this.ggU.a(dataRes.activityhead);
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
                nt(dataRes.is_new_url.intValue());
                this.ggH = dataRes.fortune_bag.intValue() == 1;
                this.ggI = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.ggL = dataRes.forum.has_game.intValue() == 1;
                    this.ggR = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.ggM.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        e eVar = new e();
                        eVar.a(list2.get(i2));
                        this.ggM.add(eVar);
                    }
                }
                this.ggJ.a(dataRes.gcon_account);
                this.eEV.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.ggF = dataRes.thread_id_list;
                this.WY.parserProtobuf(dataRes.anti);
                this.ggK.a(dataRes.group);
                this.dNU.a(dataRes.page);
                this.ggG.a(dataRes.frs_star);
                this.eFb.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eFb.getIsSelectTail());
                }
                this.ggV = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.ggW = builder.build(true);
                } else {
                    this.ggW = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                tk(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.ggO = new ArrayList();
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
                        this.ggO.add(photoLiveCardData);
                    }
                }
                this.ggP = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.ggQ = new PhotoLiveCardData();
                    if (this.ggQ.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.ggQ;
                        this.ggQ.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.ggQ.getShowStyle();
                    this.ggQ.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.ggQ.setShowExpressionViewIndexList(this.ggQ.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.ggZ = dataRes.category_list;
                if (!am.isEmpty(dataRes.bawu_enter_url)) {
                    this.gha = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.ghb = new y();
                    this.ghb.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.ghc = new aa();
                    this.ghc.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.ghd = new com.baidu.tbadk.core.data.s();
                    this.ghd.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.ghf = new w();
                    this.ghf.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.ghg = new com.baidu.tbadk.core.data.u();
                    this.ghg.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.ntspread != null) {
                    this.ggT = new z();
                    this.ggT.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.ghh = new bj();
                    this.ghh.ap(true);
                    this.ghh.bW(this.ggP);
                    this.ghh.setUserMap(this.userMap);
                    this.ghh.a(dataRes.card_shipin_info.get(0));
                    this.ghh.sj();
                    if (this.ghh.getFid() == 0 && longValue != 0) {
                        this.ghh.setFid(longValue);
                    }
                    this.ghh.i(this.ggS);
                    this.ghh.ao(!this.ghh.rh());
                    if (this.ghh.getAuthor() != null && this.ghh.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.ghh.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.P(metaData.getPendantData().Cw());
                        jVar.cA(metaData.getPendantData().pR());
                        this.ghh.getAuthor().setPendantData(jVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.ghj = dataRes.school_recom_pos.intValue();
                    this.ghi = new ba();
                    this.ghi.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.ghk = new com.baidu.tbadk.core.data.m();
                    this.ghk.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.ghm = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.ghn = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.ggE = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bhT().re(dataRes.asp_shown_info);
                this.gho = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bj bjVar = new bj();
                        if (this.gho != null && this.gho.size() >= dataRes.card_shipin_new.size()) {
                            bjVar.bW(this.gho.get(i5).intValue());
                        }
                        bjVar.ap(true);
                        bjVar.a(dataRes.card_shipin_new.get(i5));
                        this.ghp.add(bjVar);
                    }
                }
                if (dataRes.bottle != null) {
                    this.isShowDriftingBottle = dataRes.bottle.has_enter_display.intValue() == 1;
                    this.ghq = dataRes.bottle.tid.longValue();
                } else {
                    this.isShowDriftingBottle = false;
                    this.ghq = 0L;
                }
                this.ghr = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.ghs = new com.baidu.tieba.g.b();
                    this.ghs.a(dataRes.esport);
                }
                if (TbadkCoreApplication.isLogin() && dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1) {
                    com.baidu.tbadk.data.e eVar2 = new com.baidu.tbadk.data.e();
                    eVar2.a(dataRes.banner_user_story, longValue);
                    this.ghu = eVar2.Co();
                    MessageManager.getInstance().sendMessageFromBackground(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, Long.valueOf(longValue)));
                }
                this.ght = dataRes.agree_banner;
                this.cDE = dataRes.live_frs_notify;
                this.ghv = dataRes.frs_game_tab_info;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.f> bqy() {
        return this.ghu;
    }

    public void di(List<com.baidu.adp.widget.ListView.f> list) {
        this.ghu = list;
    }

    public AgreeBanner bqz() {
        return this.ght;
    }

    public void a(AgreeBanner agreeBanner) {
        this.ght = agreeBanner;
    }

    private void tk(int i) {
        this.ggX = 1;
        if (this.ggV != null && this.ggV.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.ggV) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.ggX = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bj bjVar = new bj();
                bjVar.setUserMap(this.userMap);
                bjVar.a(list.get(i));
                bjVar.bX(3);
                bjVar.sj();
                if (bjVar.getFid() == 0 && j != 0) {
                    bjVar.setFid(j);
                }
                if (StringUtils.isNull(bjVar.rG())) {
                    bjVar.cC(this.eEV.getName());
                }
                bjVar.i(this.ggS);
                if (bjVar.getThreadType() == 33 && !bjVar.sc()) {
                    ax axVar = new ax();
                    axVar.a(bjVar, 0);
                    axVar.r(bqM());
                    if (appResponseToIntentClass) {
                        this.threadList.add(axVar);
                    }
                } else if (!TextUtils.isEmpty(bjVar.sw())) {
                    ah ahVar = new ah();
                    ahVar.cx(bjVar.sw());
                    this.threadList.add(ahVar);
                } else {
                    this.threadList.add(bjVar);
                }
            }
        }
    }

    public int bqA() {
        return this.alaLiveCount;
    }

    public void tl(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] EX() {
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

    public ForumData aPg() {
        return this.eEV;
    }

    public int bqB() {
        return this.ghm;
    }

    public void tm(int i) {
        this.ghm = i;
    }

    public int bqC() {
        return this.ghn;
    }

    public void tn(int i) {
        this.ghn = i;
    }

    public void c(ForumData forumData) {
        this.eEV = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getThreadList() {
        return this.threadList;
    }

    public void aA(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qn() {
        return this.WY;
    }

    public void d(AntiData antiData) {
        this.WY = antiData;
    }

    public ar qD() {
        return this.dNU;
    }

    public void a(ar arVar) {
        this.dNU = arVar;
    }

    public h bqD() {
        return this.ggG;
    }

    public void a(h hVar) {
        this.ggG = hVar;
    }

    public com.baidu.tbadk.core.data.r bqE() {
        return this.ggU;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.ggU = rVar;
    }

    public boolean bqF() {
        return this.ggH;
    }

    public void mC(boolean z) {
        this.ggH = z;
    }

    public String bqG() {
        return this.ggI;
    }

    public void rT(String str) {
        this.ggI = str;
    }

    public j bqH() {
        return this.ggJ;
    }

    public void a(j jVar) {
        this.ggJ = jVar;
    }

    public UserData getUserData() {
        return this.eFb;
    }

    public void setUserData(UserData userData) {
        this.eFb = userData;
    }

    public List<Long> bqI() {
        return this.ggF;
    }

    public void dj(List<Long> list) {
        this.ggF = list;
    }

    public b bqJ() {
        return this.ggK;
    }

    public void a(b bVar) {
        this.ggK = bVar;
    }

    public boolean bqK() {
        return this.ggL;
    }

    public void mD(boolean z) {
        this.ggL = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<e> bqL() {
        return this.ggM;
    }

    public void dk(List<e> list) {
        this.ggM = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aPu() {
        return this.ggN;
    }

    public void nt(int i) {
        this.ggN = i;
    }

    public List<PhotoLiveCardData> bqM() {
        return this.ggO;
    }

    public String bqN() {
        return this.ggR;
    }

    public void rU(String str) {
        this.ggR = str;
    }

    public List<FrsTabInfo> bqO() {
        return this.ggV;
    }

    public void dl(List<FrsTabInfo> list) {
        this.ggV = list;
    }

    public void dm(List<PhotoLiveCardData> list) {
        this.ggO = list;
    }

    public boolean bqP() {
        return this.ggQ != null;
    }

    public PhotoLiveCardData bqQ() {
        return this.ggQ;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.ggQ = photoLiveCardData;
    }

    public z bqR() {
        return this.ggT;
    }

    public void a(z zVar) {
        this.ggT = zVar;
    }

    public int bqS() {
        return this.ggP;
    }

    public void to(int i) {
        this.ggP = i;
    }

    public List<FeedForumData> bqT() {
        return this.ggY;
    }

    public void dn(List<FeedForumData> list) {
        this.ggY = list;
    }

    public void rV(String str) {
        if (this.ggY != null && str != null) {
            for (FeedForumData feedForumData : this.ggY) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.ggY.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bqU() {
        return this.ggZ;
    }

    /* renamed from: do  reason: not valid java name */
    public void m11do(List<CategoryInfo> list) {
        this.ggZ = list;
    }

    public void rW(String str) {
        this.gha = str;
    }

    public String bqV() {
        return this.gha;
    }

    public bj bqW() {
        return this.ghh;
    }

    public void an(bj bjVar) {
        this.ghh = bjVar;
    }

    public int bqX() {
        return this.ggX;
    }

    public void tp(int i) {
        this.ggX = i;
    }

    public y bqY() {
        return this.ghb;
    }

    public void a(y yVar) {
        this.ghb = yVar;
    }

    public com.baidu.tbadk.core.data.s bqZ() {
        return this.ghd;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.ghd = sVar;
    }

    public com.baidu.tbadk.core.data.u bra() {
        return this.ghg;
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        this.ghg = uVar;
    }

    public int brb() {
        return this.ghj;
    }

    public void tq(int i) {
        this.ghj = i;
    }

    public ba brc() {
        return this.ghi;
    }

    public void a(ba baVar) {
        this.ghi = baVar;
    }

    public NavTabInfo brd() {
        return this.ggW;
    }

    public void a(NavTabInfo navTabInfo) {
        this.ggW = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m bre() {
        return this.ghk;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.ghk = mVar;
    }

    public Integer brf() {
        return this.ghe;
    }

    public void j(Integer num) {
        this.ghe = num;
    }

    public List<Integer> brg() {
        return this.gho;
    }

    public void dp(List<Integer> list) {
        this.gho = list;
    }

    public List<com.baidu.adp.widget.ListView.f> brh() {
        return this.ghp;
    }

    public void dq(List<com.baidu.adp.widget.ListView.f> list) {
        this.ghp = list;
    }

    public boolean isShowDriftingBottle() {
        return this.isShowDriftingBottle;
    }

    public long bri() {
        return this.ghq;
    }

    public void mE(boolean z) {
        this.isShowDriftingBottle = z;
    }

    public void cN(long j) {
        this.ghq = j;
    }

    public com.baidu.tieba.g.b brj() {
        return this.ghs;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.ghs = bVar;
    }

    public AlaLiveNotify brk() {
        return this.cDE;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.cDE = alaLiveNotify;
    }

    public List<FrsTabInfo> brl() {
        return this.ghv;
    }

    public void dr(List<FrsTabInfo> list) {
        this.ghv = list;
    }
}
