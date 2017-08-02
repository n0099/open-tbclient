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
    private AntiData Wq;
    private AlaLiveNotify csT;
    protected ar dDg;
    private UserData eCE;
    protected ForumData eCy;
    private String gameName;
    private List<CategoryInfo> geA;
    private bl geI;
    private ba geJ;
    private com.baidu.tbadk.core.data.m geL;
    private List<Integer> geP;
    private List<com.baidu.adp.widget.ListView.f> geQ;
    public PopInfo geS;
    private com.baidu.tieba.g.b geT;
    private AgreeBanner geU;
    protected List<com.baidu.adp.widget.ListView.f> geV;
    private List<FrsTabInfo> geW;
    protected List<Long> geg;
    private h geh;
    protected boolean gei;
    protected String gej;
    protected j gek;
    private b gel;
    private boolean gem;
    private List<PhotoLiveCardData> gep;
    private int geq;
    private PhotoLiveCardData ger;
    private String ges;
    private z geu;
    private List<FrsTabInfo> gew;
    private NavTabInfo gex;
    private List<FeedForumData> gez;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.f> threadList;
    private HashMap<String, MetaData> userMap;
    public int gef = 0;
    private List<e> gen = new ArrayList();
    private int geo = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> get = new ArrayList<>();
    protected com.baidu.tbadk.core.data.r gev = null;
    private int gey = 1;
    private String geB = null;
    private y geC = null;
    public aa geD = null;
    private com.baidu.tbadk.core.data.s geE = null;
    private Integer geF = -1;
    public w geG = null;
    private com.baidu.tbadk.core.data.u geH = null;
    private int geK = -1;
    protected List<com.baidu.adp.widget.ListView.f> geM = null;
    private int geN = 0;
    private int geO = 0;
    private boolean isShowDriftingBottle = false;
    private long geR = 0;
    private int alaLiveCount = 0;

    public g() {
        initData();
    }

    private void initData() {
        this.eCy = new ForumData();
        this.threadList = new ArrayList<>();
        this.geM = new ArrayList();
        this.userMap = new HashMap<>();
        this.dDg = new ar();
        this.geh = new h();
        this.eCE = new UserData();
        this.gek = new j();
        d(new AntiData());
        a(new b());
        this.geQ = new ArrayList();
        this.geP = new ArrayList();
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
                if (!com.baidu.tbadk.core.util.u.v(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.u.v(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            if (oVar.a(colorEgg)) {
                                this.get.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.u.v(dataRes.activityhead.head_imgs)) {
                    this.gev = new com.baidu.tbadk.core.data.r();
                    this.gev.a(dataRes.activityhead);
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
                mP(dataRes.is_new_url.intValue());
                this.gei = dataRes.fortune_bag.intValue() == 1;
                this.gej = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gem = dataRes.forum.has_game.intValue() == 1;
                    this.ges = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gen.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        e eVar = new e();
                        eVar.a(list2.get(i2));
                        this.gen.add(eVar);
                    }
                }
                this.gek.a(dataRes.gcon_account);
                this.eCy.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.geg = dataRes.thread_id_list;
                this.Wq.parserProtobuf(dataRes.anti);
                this.gel.a(dataRes.group);
                this.dDg.a(dataRes.page);
                this.geh.a(dataRes.frs_star);
                this.eCE.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eCE.getIsSelectTail());
                }
                this.gew = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gex = builder.build(true);
                } else {
                    this.gex = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                sX(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.gep = new ArrayList();
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
                        this.gep.add(photoLiveCardData);
                    }
                }
                this.geq = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.ger = new PhotoLiveCardData();
                    if (this.ger.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.ger;
                        this.ger.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.ger.getShowStyle();
                    this.ger.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.ger.setShowExpressionViewIndexList(this.ger.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.geA = dataRes.category_list;
                if (!al.isEmpty(dataRes.bawu_enter_url)) {
                    this.geB = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.geC = new y();
                    this.geC.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.geD = new aa();
                    this.geD.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.geE = new com.baidu.tbadk.core.data.s();
                    this.geE.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.geG = new w();
                    this.geG.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.geH = new com.baidu.tbadk.core.data.u();
                    this.geH.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.ntspread != null) {
                    this.geu = new z();
                    this.geu.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.geI = new bl();
                    this.geI.ap(true);
                    this.geI.bU(this.geq);
                    this.geI.setUserMap(this.userMap);
                    this.geI.a(dataRes.card_shipin_info.get(0));
                    this.geI.sd();
                    if (this.geI.getFid() == 0 && longValue != 0) {
                        this.geI.setFid(longValue);
                    }
                    this.geI.i(this.get);
                    this.geI.ao(!this.geI.rc());
                    if (this.geI.getAuthor() != null && this.geI.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.geI.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.Q(metaData.getPendantData().Ct());
                        jVar.cB(metaData.getPendantData().pL());
                        this.geI.getAuthor().setPendantData(jVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.geK = dataRes.school_recom_pos.intValue();
                    this.geJ = new ba();
                    this.geJ.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.geL = new com.baidu.tbadk.core.data.m();
                    this.geL.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.geN = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.geO = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gef = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bhY().rc(dataRes.asp_shown_info);
                this.geP = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bl blVar = new bl();
                        if (this.geP != null && this.geP.size() >= dataRes.card_shipin_new.size()) {
                            blVar.bU(this.geP.get(i5).intValue());
                        }
                        blVar.ap(true);
                        blVar.a(dataRes.card_shipin_new.get(i5));
                        this.geQ.add(blVar);
                    }
                }
                if (dataRes.bottle != null) {
                    this.isShowDriftingBottle = dataRes.bottle.has_enter_display.intValue() == 1;
                    this.geR = dataRes.bottle.tid.longValue();
                } else {
                    this.isShowDriftingBottle = false;
                    this.geR = 0L;
                }
                this.geS = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.geT = new com.baidu.tieba.g.b();
                    this.geT.a(dataRes.esport);
                }
                if (TbadkCoreApplication.isLogin() && dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1) {
                    com.baidu.tbadk.data.e eVar2 = new com.baidu.tbadk.data.e();
                    eVar2.a(dataRes.banner_user_story, longValue);
                    this.geV = eVar2.Cl();
                    MessageManager.getInstance().sendMessageFromBackground(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, Long.valueOf(longValue)));
                }
                this.geU = dataRes.agree_banner;
                this.csT = dataRes.live_frs_notify;
                this.geW = dataRes.frs_game_tab_info;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.f> bqq() {
        return this.geV;
    }

    public void dh(List<com.baidu.adp.widget.ListView.f> list) {
        this.geV = list;
    }

    public AgreeBanner bqr() {
        return this.geU;
    }

    public void a(AgreeBanner agreeBanner) {
        this.geU = agreeBanner;
    }

    private void sX(int i) {
        this.gey = 1;
        if (this.gew != null && this.gew.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gew) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gey = i;
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
                blVar.bV(3);
                blVar.sd();
                if (blVar.getFid() == 0 && j != 0) {
                    blVar.setFid(j);
                }
                if (StringUtils.isNull(blVar.rA())) {
                    blVar.cD(this.eCy.getName());
                }
                blVar.i(this.get);
                if (blVar.getThreadType() == 33 && !blVar.rW()) {
                    ax axVar = new ax();
                    axVar.a(blVar, 0);
                    axVar.r(bqE());
                    if (appResponseToIntentClass) {
                        this.threadList.add(axVar);
                    }
                } else if (!TextUtils.isEmpty(blVar.sq())) {
                    ah ahVar = new ah();
                    ahVar.cy(blVar.sq());
                    this.threadList.add(ahVar);
                } else {
                    this.threadList.add(blVar);
                }
            }
        }
    }

    public int bqs() {
        return this.alaLiveCount;
    }

    public void sY(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] ER() {
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
    public void n(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aOW() {
        return this.eCy;
    }

    public int bqt() {
        return this.geN;
    }

    public void sZ(int i) {
        this.geN = i;
    }

    public int bqu() {
        return this.geO;
    }

    public void ta(int i) {
        this.geO = i;
    }

    public void c(ForumData forumData) {
        this.eCy = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getThreadList() {
        return this.threadList;
    }

    public void aB(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData qh() {
        return this.Wq;
    }

    public void d(AntiData antiData) {
        this.Wq = antiData;
    }

    public ar qx() {
        return this.dDg;
    }

    public void a(ar arVar) {
        this.dDg = arVar;
    }

    public h bqv() {
        return this.geh;
    }

    public void a(h hVar) {
        this.geh = hVar;
    }

    public com.baidu.tbadk.core.data.r bqw() {
        return this.gev;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.gev = rVar;
    }

    public boolean bqx() {
        return this.gei;
    }

    public void ms(boolean z) {
        this.gei = z;
    }

    public String bqy() {
        return this.gej;
    }

    public void rK(String str) {
        this.gej = str;
    }

    public j bqz() {
        return this.gek;
    }

    public void a(j jVar) {
        this.gek = jVar;
    }

    public UserData getUserData() {
        return this.eCE;
    }

    public void setUserData(UserData userData) {
        this.eCE = userData;
    }

    public List<Long> bqA() {
        return this.geg;
    }

    public void di(List<Long> list) {
        this.geg = list;
    }

    public b bqB() {
        return this.gel;
    }

    public void a(b bVar) {
        this.gel = bVar;
    }

    public boolean bqC() {
        return this.gem;
    }

    public void mt(boolean z) {
        this.gem = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<e> bqD() {
        return this.gen;
    }

    public void dj(List<e> list) {
        this.gen = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aPk() {
        return this.geo;
    }

    public void mP(int i) {
        this.geo = i;
    }

    public List<PhotoLiveCardData> bqE() {
        return this.gep;
    }

    public String bqF() {
        return this.ges;
    }

    public void rL(String str) {
        this.ges = str;
    }

    public List<FrsTabInfo> bqG() {
        return this.gew;
    }

    public void dk(List<FrsTabInfo> list) {
        this.gew = list;
    }

    public void dl(List<PhotoLiveCardData> list) {
        this.gep = list;
    }

    public boolean bqH() {
        return this.ger != null;
    }

    public PhotoLiveCardData bqI() {
        return this.ger;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.ger = photoLiveCardData;
    }

    public z bqJ() {
        return this.geu;
    }

    public void a(z zVar) {
        this.geu = zVar;
    }

    public int bqK() {
        return this.geq;
    }

    public void tb(int i) {
        this.geq = i;
    }

    public List<FeedForumData> bqL() {
        return this.gez;
    }

    public void dm(List<FeedForumData> list) {
        this.gez = list;
    }

    public void rM(String str) {
        if (this.gez != null && str != null) {
            for (FeedForumData feedForumData : this.gez) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gez.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bqM() {
        return this.geA;
    }

    public void dn(List<CategoryInfo> list) {
        this.geA = list;
    }

    public void rN(String str) {
        this.geB = str;
    }

    public String bqN() {
        return this.geB;
    }

    public bl bqO() {
        return this.geI;
    }

    public void ah(bl blVar) {
        this.geI = blVar;
    }

    public int bqP() {
        return this.gey;
    }

    public void tc(int i) {
        this.gey = i;
    }

    public y bqQ() {
        return this.geC;
    }

    public void a(y yVar) {
        this.geC = yVar;
    }

    public com.baidu.tbadk.core.data.s bqR() {
        return this.geE;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.geE = sVar;
    }

    public com.baidu.tbadk.core.data.u bqS() {
        return this.geH;
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        this.geH = uVar;
    }

    public int bqT() {
        return this.geK;
    }

    public void td(int i) {
        this.geK = i;
    }

    public ba bqU() {
        return this.geJ;
    }

    public void a(ba baVar) {
        this.geJ = baVar;
    }

    public NavTabInfo bqV() {
        return this.gex;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gex = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m bqW() {
        return this.geL;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.geL = mVar;
    }

    public Integer bqX() {
        return this.geF;
    }

    public void i(Integer num) {
        this.geF = num;
    }

    public List<Integer> bqY() {
        return this.geP;
    }

    /* renamed from: do  reason: not valid java name */
    public void m13do(List<Integer> list) {
        this.geP = list;
    }

    public List<com.baidu.adp.widget.ListView.f> bqZ() {
        return this.geQ;
    }

    public void dp(List<com.baidu.adp.widget.ListView.f> list) {
        this.geQ = list;
    }

    public boolean isShowDriftingBottle() {
        return this.isShowDriftingBottle;
    }

    public long bra() {
        return this.geR;
    }

    public void mu(boolean z) {
        this.isShowDriftingBottle = z;
    }

    public void cS(long j) {
        this.geR = j;
    }

    public com.baidu.tieba.g.b brb() {
        return this.geT;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.geT = bVar;
    }

    public AlaLiveNotify brc() {
        return this.csT;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.csT = alaLiveNotify;
    }

    public List<FrsTabInfo> brd() {
        return this.geW;
    }

    public void dq(List<FrsTabInfo> list) {
        this.geW = list;
    }
}
