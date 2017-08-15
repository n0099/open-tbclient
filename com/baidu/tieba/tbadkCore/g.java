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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.al;
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
    private AntiData XO;
    private AlaLiveNotify cwr;
    protected ar dGu;
    protected ForumData eFF;
    private UserData eFL;
    private String gameName;
    private NavTabInfo ghA;
    private List<FeedForumData> ghC;
    private List<CategoryInfo> ghD;
    private bl ghL;
    private ba ghM;
    private com.baidu.tbadk.core.data.m ghO;
    private List<Integer> ghS;
    private List<com.baidu.adp.widget.ListView.f> ghT;
    public PopInfo ghV;
    private com.baidu.tieba.g.b ghW;
    private AgreeBanner ghX;
    protected List<com.baidu.adp.widget.ListView.f> ghY;
    private List<FrsTabInfo> ghZ;
    protected List<Long> ghj;
    private h ghk;
    protected boolean ghl;
    protected String ghm;
    protected j ghn;
    private b gho;
    private boolean ghp;
    private List<PhotoLiveCardData> ghs;
    private int ght;
    private PhotoLiveCardData ghu;
    private String ghv;
    private z ghx;
    private List<FrsTabInfo> ghz;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.f> threadList;
    private HashMap<String, MetaData> userMap;
    public int ghi = 0;
    private List<e> ghq = new ArrayList();
    private int ghr = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> ghw = new ArrayList<>();
    protected com.baidu.tbadk.core.data.r ghy = null;
    private int ghB = 1;
    private String ghE = null;
    private y ghF = null;
    public aa ghG = null;
    private com.baidu.tbadk.core.data.s ghH = null;
    private Integer ghI = -1;
    public w ghJ = null;
    private com.baidu.tbadk.core.data.u ghK = null;
    private int ghN = -1;
    protected List<com.baidu.adp.widget.ListView.f> ghP = null;
    private int ghQ = 0;
    private int ghR = 0;
    private boolean isShowDriftingBottle = false;
    private long ghU = 0;
    private int alaLiveCount = 0;

    public g() {
        initData();
    }

    private void initData() {
        this.eFF = new ForumData();
        this.threadList = new ArrayList<>();
        this.ghP = new ArrayList();
        this.userMap = new HashMap<>();
        this.dGu = new ar();
        this.ghk = new h();
        this.eFL = new UserData();
        this.ghn = new j();
        d(new AntiData());
        a(new b());
        this.ghT = new ArrayList();
        this.ghS = new ArrayList();
    }

    public FrsPageResIdl F(byte[] bArr) {
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
                if (!com.baidu.tbadk.core.util.u.v(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.u.v(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            if (oVar.a(colorEgg)) {
                                this.ghw.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.u.v(dataRes.activityhead.head_imgs)) {
                    this.ghy = new com.baidu.tbadk.core.data.r();
                    this.ghy.a(dataRes.activityhead);
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
                mY(dataRes.is_new_url.intValue());
                this.ghl = dataRes.fortune_bag.intValue() == 1;
                this.ghm = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.ghp = dataRes.forum.has_game.intValue() == 1;
                    this.ghv = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.ghq.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        e eVar = new e();
                        eVar.a(list2.get(i2));
                        this.ghq.add(eVar);
                    }
                }
                this.ghn.a(dataRes.gcon_account);
                this.eFF.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.ghj = dataRes.thread_id_list;
                this.XO.parserProtobuf(dataRes.anti);
                this.gho.a(dataRes.group);
                this.dGu.a(dataRes.page);
                this.ghk.a(dataRes.frs_star);
                this.eFL.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eFL.getIsSelectTail());
                }
                this.ghz = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.ghA = builder.build(true);
                } else {
                    this.ghA = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                tg(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.ghs = new ArrayList();
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
                        this.ghs.add(photoLiveCardData);
                    }
                }
                this.ght = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.ghu = new PhotoLiveCardData();
                    if (this.ghu.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.ghu;
                        this.ghu.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.ghu.getShowStyle();
                    this.ghu.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.ghu.setShowExpressionViewIndexList(this.ghu.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.ghD = dataRes.category_list;
                if (!al.isEmpty(dataRes.bawu_enter_url)) {
                    this.ghE = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.ghF = new y();
                    this.ghF.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.ghG = new aa();
                    this.ghG.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.ghH = new com.baidu.tbadk.core.data.s();
                    this.ghH.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.ghJ = new w();
                    this.ghJ.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.ghK = new com.baidu.tbadk.core.data.u();
                    this.ghK.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.ntspread != null) {
                    this.ghx = new z();
                    this.ghx.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.ghL = new bl();
                    this.ghL.ap(true);
                    this.ghL.bW(this.ght);
                    this.ghL.setUserMap(this.userMap);
                    this.ghL.a(dataRes.card_shipin_info.get(0));
                    this.ghL.sn();
                    if (this.ghL.getFid() == 0 && longValue != 0) {
                        this.ghL.setFid(longValue);
                    }
                    this.ghL.i(this.ghw);
                    this.ghL.ao(!this.ghL.rm());
                    if (this.ghL.getAuthor() != null && this.ghL.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.ghL.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.Q(metaData.getPendantData().CB());
                        jVar.cH(metaData.getPendantData().pV());
                        this.ghL.getAuthor().setPendantData(jVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.ghN = dataRes.school_recom_pos.intValue();
                    this.ghM = new ba();
                    this.ghM.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.ghO = new com.baidu.tbadk.core.data.m();
                    this.ghO.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.ghQ = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.ghR = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.ghi = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.biO().rj(dataRes.asp_shown_info);
                this.ghS = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bl blVar = new bl();
                        if (this.ghS != null && this.ghS.size() >= dataRes.card_shipin_new.size()) {
                            blVar.bW(this.ghS.get(i5).intValue());
                        }
                        blVar.ap(true);
                        blVar.a(dataRes.card_shipin_new.get(i5));
                        this.ghT.add(blVar);
                    }
                }
                if (dataRes.bottle != null) {
                    this.isShowDriftingBottle = dataRes.bottle.has_enter_display.intValue() == 1;
                    this.ghU = dataRes.bottle.tid.longValue();
                } else {
                    this.isShowDriftingBottle = false;
                    this.ghU = 0L;
                }
                this.ghV = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.ghW = new com.baidu.tieba.g.b();
                    this.ghW.a(dataRes.esport);
                }
                if (TbadkCoreApplication.isLogin() && dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1) {
                    com.baidu.tbadk.data.e eVar2 = new com.baidu.tbadk.data.e();
                    eVar2.a(dataRes.banner_user_story, longValue);
                    this.ghY = eVar2.Ct();
                    MessageManager.getInstance().sendMessageFromBackground(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, Long.valueOf(longValue)));
                }
                this.ghX = dataRes.agree_banner;
                this.cwr = dataRes.live_frs_notify;
                this.ghZ = dataRes.frs_game_tab_info;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.f> brf() {
        return this.ghY;
    }

    public void dk(List<com.baidu.adp.widget.ListView.f> list) {
        this.ghY = list;
    }

    public AgreeBanner brg() {
        return this.ghX;
    }

    public void a(AgreeBanner agreeBanner) {
        this.ghX = agreeBanner;
    }

    private void tg(int i) {
        this.ghB = 1;
        if (this.ghz != null && this.ghz.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.ghz) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.ghB = i;
                    return;
                }
            }
        }
    }

    public void a(List<ThreadInfo> list, long j) {
        if (list != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
            for (int i = 0; i < list.size(); i++) {
                bl blVar = new bl();
                blVar.setUserMap(this.userMap);
                blVar.a(list.get(i));
                blVar.bX(3);
                blVar.sn();
                if (blVar.getFid() == 0 && j != 0) {
                    blVar.setFid(j);
                }
                if (StringUtils.isNull(blVar.rK())) {
                    blVar.cJ(this.eFF.getName());
                }
                blVar.i(this.ghw);
                if (blVar.getThreadType() == 33 && !blVar.sg()) {
                    ax axVar = new ax();
                    axVar.a(blVar, 0);
                    axVar.r(brt());
                    if (appResponseToIntentClass) {
                        this.threadList.add(axVar);
                    }
                } else if (!TextUtils.isEmpty(blVar.sA())) {
                    ah ahVar = new ah();
                    ahVar.cE(blVar.sA());
                    this.threadList.add(ahVar);
                } else {
                    this.threadList.add(blVar);
                }
            }
        }
    }

    public int brh() {
        return this.alaLiveCount;
    }

    public void th(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] EZ() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean C(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void n(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aPO() {
        return this.eFF;
    }

    public int bri() {
        return this.ghQ;
    }

    public void ti(int i) {
        this.ghQ = i;
    }

    public int brj() {
        return this.ghR;
    }

    public void tj(int i) {
        this.ghR = i;
    }

    public void c(ForumData forumData) {
        this.eFF = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getThreadList() {
        return this.threadList;
    }

    public void aB(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qr() {
        return this.XO;
    }

    public void d(AntiData antiData) {
        this.XO = antiData;
    }

    public ar qH() {
        return this.dGu;
    }

    public void a(ar arVar) {
        this.dGu = arVar;
    }

    public h brk() {
        return this.ghk;
    }

    public void a(h hVar) {
        this.ghk = hVar;
    }

    public com.baidu.tbadk.core.data.r brl() {
        return this.ghy;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.ghy = rVar;
    }

    public boolean brm() {
        return this.ghl;
    }

    public void mv(boolean z) {
        this.ghl = z;
    }

    public String brn() {
        return this.ghm;
    }

    public void rR(String str) {
        this.ghm = str;
    }

    public j bro() {
        return this.ghn;
    }

    public void a(j jVar) {
        this.ghn = jVar;
    }

    public UserData getUserData() {
        return this.eFL;
    }

    public void setUserData(UserData userData) {
        this.eFL = userData;
    }

    public List<Long> brp() {
        return this.ghj;
    }

    public void dl(List<Long> list) {
        this.ghj = list;
    }

    public b brq() {
        return this.gho;
    }

    public void a(b bVar) {
        this.gho = bVar;
    }

    public boolean brr() {
        return this.ghp;
    }

    public void mw(boolean z) {
        this.ghp = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<e> brs() {
        return this.ghq;
    }

    public void dm(List<e> list) {
        this.ghq = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aQc() {
        return this.ghr;
    }

    public void mY(int i) {
        this.ghr = i;
    }

    public List<PhotoLiveCardData> brt() {
        return this.ghs;
    }

    public String bru() {
        return this.ghv;
    }

    public void rS(String str) {
        this.ghv = str;
    }

    public List<FrsTabInfo> brv() {
        return this.ghz;
    }

    public void dn(List<FrsTabInfo> list) {
        this.ghz = list;
    }

    /* renamed from: do  reason: not valid java name */
    public void m12do(List<PhotoLiveCardData> list) {
        this.ghs = list;
    }

    public boolean brw() {
        return this.ghu != null;
    }

    public PhotoLiveCardData brx() {
        return this.ghu;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.ghu = photoLiveCardData;
    }

    public z bry() {
        return this.ghx;
    }

    public void a(z zVar) {
        this.ghx = zVar;
    }

    public int brz() {
        return this.ght;
    }

    public void tk(int i) {
        this.ght = i;
    }

    public List<FeedForumData> brA() {
        return this.ghC;
    }

    public void dp(List<FeedForumData> list) {
        this.ghC = list;
    }

    public void rT(String str) {
        if (this.ghC != null && str != null) {
            for (FeedForumData feedForumData : this.ghC) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.ghC.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> brB() {
        return this.ghD;
    }

    public void dq(List<CategoryInfo> list) {
        this.ghD = list;
    }

    public void rU(String str) {
        this.ghE = str;
    }

    public String brC() {
        return this.ghE;
    }

    public bl brD() {
        return this.ghL;
    }

    public void ah(bl blVar) {
        this.ghL = blVar;
    }

    public int brE() {
        return this.ghB;
    }

    public void tl(int i) {
        this.ghB = i;
    }

    public y brF() {
        return this.ghF;
    }

    public void a(y yVar) {
        this.ghF = yVar;
    }

    public com.baidu.tbadk.core.data.s brG() {
        return this.ghH;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.ghH = sVar;
    }

    public com.baidu.tbadk.core.data.u brH() {
        return this.ghK;
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        this.ghK = uVar;
    }

    public int brI() {
        return this.ghN;
    }

    public void tm(int i) {
        this.ghN = i;
    }

    public ba brJ() {
        return this.ghM;
    }

    public void a(ba baVar) {
        this.ghM = baVar;
    }

    public NavTabInfo brK() {
        return this.ghA;
    }

    public void a(NavTabInfo navTabInfo) {
        this.ghA = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m brL() {
        return this.ghO;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.ghO = mVar;
    }

    public Integer brM() {
        return this.ghI;
    }

    public void i(Integer num) {
        this.ghI = num;
    }

    public List<Integer> brN() {
        return this.ghS;
    }

    public void dr(List<Integer> list) {
        this.ghS = list;
    }

    public List<com.baidu.adp.widget.ListView.f> brO() {
        return this.ghT;
    }

    public void ds(List<com.baidu.adp.widget.ListView.f> list) {
        this.ghT = list;
    }

    public boolean isShowDriftingBottle() {
        return this.isShowDriftingBottle;
    }

    public long brP() {
        return this.ghU;
    }

    public void mx(boolean z) {
        this.isShowDriftingBottle = z;
    }

    public void cS(long j) {
        this.ghU = j;
    }

    public com.baidu.tieba.g.b brQ() {
        return this.ghW;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.ghW = bVar;
    }

    public AlaLiveNotify brR() {
        return this.cwr;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.cwr = alaLiveNotify;
    }

    public List<FrsTabInfo> brS() {
        return this.ghZ;
    }

    public void dt(List<FrsTabInfo> list) {
        this.ghZ = list;
    }
}
