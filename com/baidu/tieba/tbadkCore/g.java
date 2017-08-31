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
    private AlaLiveNotify cCM;
    protected ar dNa;
    protected ForumData eEb;
    private UserData eEh;
    private String gameName;
    protected List<Long> gfL;
    private h gfM;
    protected boolean gfN;
    protected String gfO;
    protected j gfP;
    private b gfQ;
    private boolean gfR;
    private List<PhotoLiveCardData> gfU;
    private int gfV;
    private PhotoLiveCardData gfW;
    private String gfX;
    private z gfZ;
    protected List<com.baidu.adp.widget.ListView.f> ggA;
    private List<FrsTabInfo> ggB;
    private List<FrsTabInfo> ggb;
    private NavTabInfo ggc;
    private List<FeedForumData> gge;
    private List<CategoryInfo> ggf;
    private bj ggn;
    private ba ggo;
    private com.baidu.tbadk.core.data.m ggq;
    private List<Integer> ggu;
    private List<com.baidu.adp.widget.ListView.f> ggv;
    public PopInfo ggx;
    private com.baidu.tieba.g.b ggy;
    private AgreeBanner ggz;
    private int mSortType;
    protected ArrayList<com.baidu.adp.widget.ListView.f> threadList;
    private HashMap<String, MetaData> userMap;
    public int gfK = 0;
    private List<e> gfS = new ArrayList();
    private int gfT = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> gfY = new ArrayList<>();
    protected com.baidu.tbadk.core.data.r gga = null;
    private int ggd = 1;
    private String ggg = null;
    private y ggh = null;
    public aa ggi = null;
    private com.baidu.tbadk.core.data.s ggj = null;
    private Integer ggk = -1;
    public w ggl = null;
    private com.baidu.tbadk.core.data.u ggm = null;
    private int ggp = -1;
    protected List<com.baidu.adp.widget.ListView.f> ggr = null;
    private int ggs = 0;
    private int ggt = 0;
    private boolean isShowDriftingBottle = false;
    private long ggw = 0;
    private int alaLiveCount = 0;

    public g() {
        initData();
    }

    private void initData() {
        this.eEb = new ForumData();
        this.threadList = new ArrayList<>();
        this.ggr = new ArrayList();
        this.userMap = new HashMap<>();
        this.dNa = new ar();
        this.gfM = new h();
        this.eEh = new UserData();
        this.gfP = new j();
        d(new AntiData());
        a(new b());
        this.ggv = new ArrayList();
        this.ggu = new ArrayList();
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
                                this.gfY.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !v.v(dataRes.activityhead.head_imgs)) {
                    this.gga = new com.baidu.tbadk.core.data.r();
                    this.gga.a(dataRes.activityhead);
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
                nr(dataRes.is_new_url.intValue());
                this.gfN = dataRes.fortune_bag.intValue() == 1;
                this.gfO = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gfR = dataRes.forum.has_game.intValue() == 1;
                    this.gfX = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gfS.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        e eVar = new e();
                        eVar.a(list2.get(i2));
                        this.gfS.add(eVar);
                    }
                }
                this.gfP.a(dataRes.gcon_account);
                this.eEb.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gfL = dataRes.thread_id_list;
                this.WY.parserProtobuf(dataRes.anti);
                this.gfQ.a(dataRes.group);
                this.dNa.a(dataRes.page);
                this.gfM.a(dataRes.frs_star);
                this.eEh.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.eEh.getIsSelectTail());
                }
                this.ggb = dataRes.frs_tab_info;
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.ggc = builder.build(true);
                } else {
                    this.ggc = dataRes.nav_tab_info;
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                ti(dataRes.frs_tab_default.intValue());
                List<ZhiBoInfoTW> list3 = dataRes.twzhibo_info;
                if (list3 != null && list3.size() > 0) {
                    this.gfU = new ArrayList();
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
                        this.gfU.add(photoLiveCardData);
                    }
                }
                this.gfV = dataRes.twzhibo_pos.intValue();
                if (dataRes.hot_twzhibo_info != null) {
                    this.gfW = new PhotoLiveCardData();
                    if (this.gfW.getShowStyle() < 0) {
                        PhotoLiveCardData photoLiveCardData2 = this.gfW;
                        this.gfW.setShowStyle(PhotoLiveCardData.getRandom(3, -1));
                    }
                    this.gfW.getShowStyle();
                    this.gfW.parserProtobuf(dataRes.hot_twzhibo_info);
                    this.gfW.setShowExpressionViewIndexList(this.gfW.getExpressionDatas());
                }
                a(dataRes.thread_list, longValue);
                this.ggf = dataRes.category_list;
                if (!am.isEmpty(dataRes.bawu_enter_url)) {
                    this.ggg = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.ggh = new y();
                    this.ggh.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.ggi = new aa();
                    this.ggi.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.ggj = new com.baidu.tbadk.core.data.s();
                    this.ggj.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.ggl = new w();
                    this.ggl.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.ggm = new com.baidu.tbadk.core.data.u();
                    this.ggm.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.ntspread != null) {
                    this.gfZ = new z();
                    this.gfZ.a(dataRes.ntspread);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.ggn = new bj();
                    this.ggn.ap(true);
                    this.ggn.bW(this.gfV);
                    this.ggn.setUserMap(this.userMap);
                    this.ggn.a(dataRes.card_shipin_info.get(0));
                    this.ggn.sj();
                    if (this.ggn.getFid() == 0 && longValue != 0) {
                        this.ggn.setFid(longValue);
                    }
                    this.ggn.i(this.gfY);
                    this.ggn.ao(!this.ggn.rh());
                    if (this.ggn.getAuthor() != null && this.ggn.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.ggn.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.P(metaData.getPendantData().Cw());
                        jVar.cA(metaData.getPendantData().pR());
                        this.ggn.getAuthor().setPendantData(jVar);
                    }
                }
                if (dataRes.school_recom_info != null) {
                    this.ggp = dataRes.school_recom_pos.intValue();
                    this.ggo = new ba();
                    this.ggo.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.ggq = new com.baidu.tbadk.core.data.m();
                    this.ggq.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.ggs = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.ggt = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gfK = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bhI().rc(dataRes.asp_shown_info);
                this.ggu = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bj bjVar = new bj();
                        if (this.ggu != null && this.ggu.size() >= dataRes.card_shipin_new.size()) {
                            bjVar.bW(this.ggu.get(i5).intValue());
                        }
                        bjVar.ap(true);
                        bjVar.a(dataRes.card_shipin_new.get(i5));
                        this.ggv.add(bjVar);
                    }
                }
                if (dataRes.bottle != null) {
                    this.isShowDriftingBottle = dataRes.bottle.has_enter_display.intValue() == 1;
                    this.ggw = dataRes.bottle.tid.longValue();
                } else {
                    this.isShowDriftingBottle = false;
                    this.ggw = 0L;
                }
                this.ggx = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.ggy = new com.baidu.tieba.g.b();
                    this.ggy.a(dataRes.esport);
                }
                if (TbadkCoreApplication.isLogin() && dataRes.banner_user_story != null && dataRes.banner_user_story._switch.intValue() == 1) {
                    com.baidu.tbadk.data.e eVar2 = new com.baidu.tbadk.data.e();
                    eVar2.a(dataRes.banner_user_story, longValue);
                    this.ggA = eVar2.Co();
                    MessageManager.getInstance().sendMessageFromBackground(new CustomMessage((int) CmdConfigCustom.CMD_STORY_READ_CACHE, Long.valueOf(longValue)));
                }
                this.ggz = dataRes.agree_banner;
                this.cCM = dataRes.live_frs_notify;
                this.ggB = dataRes.frs_game_tab_info;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.f> bqn() {
        return this.ggA;
    }

    public void dh(List<com.baidu.adp.widget.ListView.f> list) {
        this.ggA = list;
    }

    public AgreeBanner bqo() {
        return this.ggz;
    }

    public void a(AgreeBanner agreeBanner) {
        this.ggz = agreeBanner;
    }

    private void ti(int i) {
        this.ggd = 1;
        if (this.ggb != null && this.ggb.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.ggb) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.ggd = i;
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
                    bjVar.cC(this.eEb.getName());
                }
                bjVar.i(this.gfY);
                if (bjVar.getThreadType() == 33 && !bjVar.sc()) {
                    ax axVar = new ax();
                    axVar.a(bjVar, 0);
                    axVar.r(bqB());
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

    public int bqp() {
        return this.alaLiveCount;
    }

    public void tj(int i) {
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

    public ForumData aOV() {
        return this.eEb;
    }

    public int bqq() {
        return this.ggs;
    }

    public void tk(int i) {
        this.ggs = i;
    }

    public int bqr() {
        return this.ggt;
    }

    public void tl(int i) {
        this.ggt = i;
    }

    public void c(ForumData forumData) {
        this.eEb = forumData;
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
        return this.dNa;
    }

    public void a(ar arVar) {
        this.dNa = arVar;
    }

    public h bqs() {
        return this.gfM;
    }

    public void a(h hVar) {
        this.gfM = hVar;
    }

    public com.baidu.tbadk.core.data.r bqt() {
        return this.gga;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.gga = rVar;
    }

    public boolean bqu() {
        return this.gfN;
    }

    public void mB(boolean z) {
        this.gfN = z;
    }

    public String bqv() {
        return this.gfO;
    }

    public void rR(String str) {
        this.gfO = str;
    }

    public j bqw() {
        return this.gfP;
    }

    public void a(j jVar) {
        this.gfP = jVar;
    }

    public UserData getUserData() {
        return this.eEh;
    }

    public void setUserData(UserData userData) {
        this.eEh = userData;
    }

    public List<Long> bqx() {
        return this.gfL;
    }

    public void di(List<Long> list) {
        this.gfL = list;
    }

    public b bqy() {
        return this.gfQ;
    }

    public void a(b bVar) {
        this.gfQ = bVar;
    }

    public boolean bqz() {
        return this.gfR;
    }

    public void mC(boolean z) {
        this.gfR = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<e> bqA() {
        return this.gfS;
    }

    public void dj(List<e> list) {
        this.gfS = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aPj() {
        return this.gfT;
    }

    public void nr(int i) {
        this.gfT = i;
    }

    public List<PhotoLiveCardData> bqB() {
        return this.gfU;
    }

    public String bqC() {
        return this.gfX;
    }

    public void rS(String str) {
        this.gfX = str;
    }

    public List<FrsTabInfo> bqD() {
        return this.ggb;
    }

    public void dk(List<FrsTabInfo> list) {
        this.ggb = list;
    }

    public void dl(List<PhotoLiveCardData> list) {
        this.gfU = list;
    }

    public boolean bqE() {
        return this.gfW != null;
    }

    public PhotoLiveCardData bqF() {
        return this.gfW;
    }

    public void c(PhotoLiveCardData photoLiveCardData) {
        this.gfW = photoLiveCardData;
    }

    public z bqG() {
        return this.gfZ;
    }

    public void a(z zVar) {
        this.gfZ = zVar;
    }

    public int bqH() {
        return this.gfV;
    }

    public void tm(int i) {
        this.gfV = i;
    }

    public List<FeedForumData> bqI() {
        return this.gge;
    }

    public void dm(List<FeedForumData> list) {
        this.gge = list;
    }

    public void rT(String str) {
        if (this.gge != null && str != null) {
            for (FeedForumData feedForumData : this.gge) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gge.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bqJ() {
        return this.ggf;
    }

    public void dn(List<CategoryInfo> list) {
        this.ggf = list;
    }

    public void rU(String str) {
        this.ggg = str;
    }

    public String bqK() {
        return this.ggg;
    }

    public bj bqL() {
        return this.ggn;
    }

    public void an(bj bjVar) {
        this.ggn = bjVar;
    }

    public int bqM() {
        return this.ggd;
    }

    public void tn(int i) {
        this.ggd = i;
    }

    public y bqN() {
        return this.ggh;
    }

    public void a(y yVar) {
        this.ggh = yVar;
    }

    public com.baidu.tbadk.core.data.s bqO() {
        return this.ggj;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.ggj = sVar;
    }

    public com.baidu.tbadk.core.data.u bqP() {
        return this.ggm;
    }

    public void a(com.baidu.tbadk.core.data.u uVar) {
        this.ggm = uVar;
    }

    public int bqQ() {
        return this.ggp;
    }

    public void to(int i) {
        this.ggp = i;
    }

    public ba bqR() {
        return this.ggo;
    }

    public void a(ba baVar) {
        this.ggo = baVar;
    }

    public NavTabInfo bqS() {
        return this.ggc;
    }

    public void a(NavTabInfo navTabInfo) {
        this.ggc = navTabInfo;
    }

    public com.baidu.tbadk.core.data.m bqT() {
        return this.ggq;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.ggq = mVar;
    }

    public Integer bqU() {
        return this.ggk;
    }

    public void j(Integer num) {
        this.ggk = num;
    }

    public List<Integer> bqV() {
        return this.ggu;
    }

    /* renamed from: do  reason: not valid java name */
    public void m12do(List<Integer> list) {
        this.ggu = list;
    }

    public List<com.baidu.adp.widget.ListView.f> bqW() {
        return this.ggv;
    }

    public void dp(List<com.baidu.adp.widget.ListView.f> list) {
        this.ggv = list;
    }

    public boolean isShowDriftingBottle() {
        return this.isShowDriftingBottle;
    }

    public long bqX() {
        return this.ggw;
    }

    public void mD(boolean z) {
        this.isShowDriftingBottle = z;
    }

    public void cN(long j) {
        this.ggw = j;
    }

    public com.baidu.tieba.g.b bqY() {
        return this.ggy;
    }

    public void a(com.baidu.tieba.g.b bVar) {
        this.ggy = bVar;
    }

    public AlaLiveNotify bqZ() {
        return this.cCM;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.cCM = alaLiveNotify;
    }

    public List<FrsTabInfo> bra() {
        return this.ggB;
    }

    public void dq(List<FrsTabInfo> list) {
        this.ggB = list;
    }
}
