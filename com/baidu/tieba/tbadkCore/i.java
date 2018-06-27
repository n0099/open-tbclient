package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.util.ap;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.AlaLiveNotify;
import tbclient.BottomMenu;
import tbclient.CategoryInfo;
import tbclient.ForumArIno;
import tbclient.FrsPage.ActivityConfig;
import tbclient.FrsPage.AgreeBanner;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumHeadIcon;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsPage.RecomPostTopic;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsPage.StarRank;
import tbclient.FrsPage.WorldcupSkin;
import tbclient.FrsTabInfo;
import tbclient.OriForumInfo;
import tbclient.PopInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.WindowToast;
/* loaded from: classes2.dex */
public class i implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData agS;
    public ForumArIno dpj;
    protected am eDN;
    protected ForumData fsh;
    private UserData fso;
    private NavTabInfo gKA;
    private List<FeedForumData> gKC;
    private List<CategoryInfo> gKD;
    private bc gKM;
    private au gKN;
    private com.baidu.tbadk.core.data.m gKP;
    private List<Integer> gKT;
    private List<com.baidu.adp.widget.ListView.h> gKU;
    private e gKV;
    private f gKW;
    public PopInfo gKX;
    private com.baidu.tieba.h.b gKY;
    private AgreeBanner gKZ;
    protected List<Long> gKn;
    private j gKo;
    protected boolean gKp;
    protected String gKq;
    protected m gKr;
    private b gKs;
    private boolean gKt;
    private int gKw;
    private String gKx;
    private AlaLiveNotify gLa;
    private List<FrsTabInfo> gLb;
    private ForumHeadIcon gLd;
    private com.baidu.tieba.frs.q gLe;
    private k gLf;
    public FrsTabInfo gLg;
    public StarRank gLh;
    public List<WindowToast> gLi;
    public ActivityConfig gLj;
    private WorldcupSkin gLk;
    public com.baidu.tieba.frs.b gLl;
    public List<OriForumInfo> gLm;
    public List<BottomMenu> gLn;
    private com.baidu.tieba.tbadkCore.data.m gLo;
    private String gameName;
    public boolean isBrandForum;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.h> threadList;
    private HashMap<String, MetaData> userMap;
    public int gKm = 0;
    private List<g> gKu = new ArrayList();
    private int gKv = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> gKy = new ArrayList<>();
    protected com.baidu.tbadk.core.data.p gKz = null;
    private int gKB = 1;
    private boolean fUH = false;
    private String gKE = null;
    private x gKF = null;
    public y gKG = null;
    public RecomPostTopic gKH = null;
    private com.baidu.tbadk.core.data.q gKI = null;
    private Integer gKJ = -1;
    public com.baidu.tbadk.core.data.v gKK = null;
    private com.baidu.tbadk.core.data.s gKL = null;
    private int gKO = -1;
    protected List<com.baidu.adp.widget.ListView.h> gKQ = null;
    private int gKR = 0;
    private int gKS = 0;
    private int alaLiveCount = 0;
    private int gLc = 0;
    public int dqh = 0;
    public int gLp = 1;

    public i() {
        initData();
    }

    private void initData() {
        this.fsh = new ForumData();
        this.threadList = new ArrayList<>();
        this.gKQ = new ArrayList();
        this.userMap = new HashMap<>();
        this.eDN = new am();
        this.gKo = new j();
        this.fso = new UserData();
        this.gKr = new m();
        c(new AntiData());
        a(new b());
        this.gKU = new ArrayList();
        this.gKT = new ArrayList();
    }

    public FrsPageResIdl G(byte[] bArr) {
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
        if (dataRes != null) {
            try {
                initData();
                if (!com.baidu.tbadk.core.util.w.A(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.w.A(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            if (oVar.a(colorEgg)) {
                                this.gKy.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.forum != null) {
                    this.gKt = dataRes.forum.has_game.intValue() == 1;
                    this.gKx = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                    this.isBrandForum = dataRes.forum.is_brand_forum.intValue() == 1;
                }
                if (this.isBrandForum && dataRes.brand_forum_info != null) {
                    this.gKz = new com.baidu.tbadk.core.data.p();
                    this.gKz.a(dataRes.brand_forum_info.head_imgs);
                    this.gLl = new com.baidu.tieba.frs.b();
                    this.gLl.a(dataRes.brand_forum_info);
                    if (!com.baidu.tbadk.core.util.w.A(dataRes.brand_forum_info.relation_forum)) {
                        this.gLm = new ArrayList();
                        for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                            if (oriForumInfo != null) {
                                this.gLm.add(oriForumInfo);
                            }
                        }
                    }
                } else if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.w.A(dataRes.activityhead.head_imgs)) {
                    this.gKz = new com.baidu.tbadk.core.data.p();
                    this.gKz.a(dataRes.activityhead);
                }
                this.gLn = dataRes.bottom_menu;
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData2 = new MetaData();
                        metaData2.parserProtobuf(list.get(i));
                        String userId = metaData2.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.userMap.put(metaData2.getUserId(), metaData2);
                        }
                    }
                }
                qm(dataRes.is_new_url.intValue());
                this.gKp = dataRes.fortune_bag.intValue() == 1;
                this.gKq = dataRes.fortune_desc;
                List<StarEnter> list2 = dataRes.star_enter;
                this.gKu.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.gKu.add(gVar);
                    }
                }
                this.gKr.a(dataRes.gcon_account);
                this.fsh.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gKn = dataRes.thread_id_list;
                this.agS.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.s.b.e(dataRes.anti.block_pop_info);
                }
                this.gKs.a(dataRes.group);
                this.eDN.a(dataRes.page);
                this.gKo.a(dataRes.frs_star);
                this.fso.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fso.getIsSelectTail());
                }
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gKA = builder.build(true);
                } else {
                    this.gKA = dataRes.nav_tab_info;
                }
                if (this.gKA != null && com.baidu.tbadk.core.util.w.d(this.gKA.tab, 0) != null) {
                    this.gLp = ((FrsTabInfo) com.baidu.tbadk.core.util.w.d(this.gKA.tab, 0)).tab_id.intValue();
                }
                if (this.gKA.head != null && !com.baidu.tbadk.core.util.w.A(this.gKA.head)) {
                    this.gLg = this.gKA.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                ty(dataRes.frs_tab_default.intValue());
                this.gKw = dataRes.twzhibo_pos.intValue();
                this.fUH = dataRes.trends_redpoint.intValue() == 1;
                b(dataRes.thread_list, longValue);
                this.gKD = dataRes.category_list;
                if (!ap.isEmpty(dataRes.bawu_enter_url)) {
                    this.gKE = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gKF = new x();
                    this.gKF.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gKG = new y();
                    this.gKG.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gKI = new com.baidu.tbadk.core.data.q();
                    this.gKI.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gKK = new com.baidu.tbadk.core.data.v();
                    this.gKK.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gKL = new com.baidu.tbadk.core.data.s();
                    this.gKL.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gKM = new bc();
                    this.gKM.at(true);
                    this.gKM.bX(this.gKw);
                    this.gKM.setUserMap(this.userMap);
                    this.gKM.a(dataRes.card_shipin_info.get(0));
                    this.gKM.wd();
                    this.gKM.aku = this.isBrandForum;
                    if (this.gKM.getFid() == 0 && longValue != 0) {
                        this.gKM.setFid(longValue);
                    }
                    this.gKM.m(this.gKy);
                    this.gKM.as(!this.gKM.vc());
                    if (this.gKM.vw() != null && this.gKM.vw().getPendantData() == null && (metaData = this.userMap.get(this.gKM.vw().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                        iVar.X(metaData.getPendantData().Hd());
                        iVar.dm(metaData.getPendantData().uh());
                        this.gKM.vw().setPendantData(iVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.gKV = new e();
                    this.gKV.gJJ = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < dataRes.ala_live_insert.ala_live_list.size(); i3++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i3) != null) {
                            bc bcVar = new bc();
                            bcVar.a(dataRes.ala_live_insert.ala_live_list.get(i3));
                            bcVar.aku = this.isBrandForum;
                            arrayList.add(bcVar);
                        }
                    }
                    this.gKV.gJI = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.gKW = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_stage_list.size(); i4++) {
                        if (dataRes.ala_stage_list.get(i4) != null) {
                            bc bcVar2 = new bc();
                            bcVar2.a(dataRes.ala_stage_list.get(i4));
                            bcVar2.aku = this.isBrandForum;
                            arrayList2.add(bcVar2);
                        }
                    }
                    this.gKW.gJL = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.gKO = dataRes.school_recom_pos.intValue();
                    this.gKN = new au();
                    this.gKN.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gKP = new com.baidu.tbadk.core.data.m();
                    this.gKP.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.gKR = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gKS = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gKm = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bpy().sW(dataRes.asp_shown_info);
                this.gKT = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bc bcVar3 = new bc();
                        if (this.gKT != null && this.gKT.size() >= dataRes.card_shipin_new.size()) {
                            bcVar3.bX(this.gKT.get(i5).intValue());
                        }
                        bcVar3.at(true);
                        bcVar3.a(dataRes.card_shipin_new.get(i5));
                        bcVar3.aku = this.isBrandForum;
                        this.gKU.add(bcVar3);
                    }
                }
                this.gKX = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.gKY = new com.baidu.tieba.h.b();
                    this.gKY.a(dataRes.esport);
                }
                this.gKZ = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gLe = new com.baidu.tieba.frs.q();
                    this.gLe.a(dataRes.user_extend);
                }
                this.gLa = dataRes.live_frs_notify;
                this.gLb = dataRes.frs_game_tab_info;
                this.gLc = dataRes.game_default_tab_id.intValue();
                this.gLd = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.gLf = new k();
                    this.gLf.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.dpj = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.gLh = dataRes.star_rank_info;
                }
                if (dataRes.recom_post_topic != null) {
                    this.gKH = dataRes.recom_post_topic;
                }
                this.gLi = dataRes.window_toast;
                this.gLj = dataRes.activity_config;
                this.gLk = dataRes.worldcup_skin;
                this.gLo = new com.baidu.tieba.tbadkCore.data.m();
                this.gLo.a(dataRes.redpacketrain);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner bvv() {
        return this.gKZ;
    }

    public void a(AgreeBanner agreeBanner) {
        this.gKZ = agreeBanner;
    }

    public ForumHeadIcon bvw() {
        return this.gLd;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gLd = forumHeadIcon;
    }

    public List<RecmForumInfo> bvx() {
        return this.recm_forum_list;
    }

    private void ty(int i) {
        this.gKB = 1;
        if (this.gKA != null && this.gKA.tab != null && this.gKA.tab.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gKA.tab) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gKB = i;
                    return;
                }
            }
        }
    }

    public void b(List<ThreadInfo> list, long j) {
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    bc bcVar = new bc();
                    bcVar.setUserMap(this.userMap);
                    bcVar.a(list.get(i2));
                    bcVar.bY(3);
                    bcVar.wd();
                    if (bcVar.getFid() == 0 && j != 0) {
                        bcVar.setFid(j);
                    }
                    if (StringUtils.isNull(bcVar.vB())) {
                        bcVar.dp(this.fsh.getName());
                    }
                    bcVar.m(this.gKy);
                    bcVar.aku = this.fsh.isBrandForum;
                    if (!TextUtils.isEmpty(bcVar.wn())) {
                        ac acVar = new ac();
                        acVar.dj(bcVar.wn());
                        this.threadList.add(acVar);
                    } else {
                        this.threadList.add(bcVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int bvy() {
        return this.alaLiveCount;
    }

    public void tz(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Jx() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean A(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void v(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData baT() {
        return this.fsh;
    }

    public int bvz() {
        return this.gKR;
    }

    public void tA(int i) {
        this.gKR = i;
    }

    public int bvA() {
        return this.gKS;
    }

    public void tB(int i) {
        this.gKS = i;
    }

    public void c(ForumData forumData) {
        this.fsh = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getThreadList() {
        return this.threadList;
    }

    public void az(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData uu() {
        return this.agS;
    }

    public void c(AntiData antiData) {
        this.agS = antiData;
    }

    public am uJ() {
        return this.eDN;
    }

    public void a(am amVar) {
        this.eDN = amVar;
    }

    public j bvB() {
        return this.gKo;
    }

    public void a(j jVar) {
        this.gKo = jVar;
    }

    public com.baidu.tbadk.core.data.p bvC() {
        return this.gKz;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.gKz = pVar;
    }

    public boolean bvD() {
        return this.gKp;
    }

    public void mB(boolean z) {
        this.gKp = z;
    }

    public String bvE() {
        return this.gKq;
    }

    public void tB(String str) {
        this.gKq = str;
    }

    public m bvF() {
        return this.gKr;
    }

    public void a(m mVar) {
        this.gKr = mVar;
    }

    public UserData getUserData() {
        return this.fso;
    }

    public void e(UserData userData) {
        this.fso = userData;
    }

    public List<Long> bvG() {
        return this.gKn;
    }

    public void ds(List<Long> list) {
        this.gKn = list;
    }

    public b bvH() {
        return this.gKs;
    }

    public void a(b bVar) {
        this.gKs = bVar;
    }

    public boolean bvI() {
        return this.gKt;
    }

    public void mC(boolean z) {
        this.gKt = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bvJ() {
        return this.gKu;
    }

    public void dt(List<g> list) {
        this.gKu = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int bbi() {
        return this.gKv;
    }

    public void qm(int i) {
        this.gKv = i;
    }

    public String bvK() {
        return this.gKx;
    }

    public void tC(String str) {
        this.gKx = str;
    }

    public int bvL() {
        return this.gKw;
    }

    public void tC(int i) {
        this.gKw = i;
    }

    public List<FeedForumData> bvM() {
        return this.gKC;
    }

    public void du(List<FeedForumData> list) {
        this.gKC = list;
    }

    public void tD(String str) {
        if (this.gKC != null && str != null) {
            for (FeedForumData feedForumData : this.gKC) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gKC.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bvN() {
        return this.gKD;
    }

    public void dv(List<CategoryInfo> list) {
        this.gKD = list;
    }

    public void tE(String str) {
        this.gKE = str;
    }

    public String bvO() {
        return this.gKE;
    }

    public bc bvP() {
        return this.gKM;
    }

    public void ar(bc bcVar) {
        this.gKM = bcVar;
    }

    public int bvQ() {
        return this.gKB;
    }

    public void tD(int i) {
        this.gKB = i;
    }

    public x bvR() {
        return this.gKF;
    }

    public void a(x xVar) {
        this.gKF = xVar;
    }

    public com.baidu.tbadk.core.data.q bvS() {
        return this.gKI;
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        this.gKI = qVar;
    }

    public com.baidu.tbadk.core.data.s bvT() {
        return this.gKL;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.gKL = sVar;
    }

    public int bvU() {
        return this.gKO;
    }

    public void tE(int i) {
        this.gKO = i;
    }

    public au bvV() {
        return this.gKN;
    }

    public void a(au auVar) {
        this.gKN = auVar;
    }

    public NavTabInfo bvW() {
        return this.gKA;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gKA = navTabInfo;
    }

    public boolean bvX() {
        return this.fUH;
    }

    public void mD(boolean z) {
        this.fUH = z;
    }

    public com.baidu.tbadk.core.data.m bvY() {
        return this.gKP;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.gKP = mVar;
    }

    public int Vb() {
        return this.mSortType;
    }

    public Integer bvZ() {
        return this.gKJ;
    }

    public void q(Integer num) {
        this.gKJ = num;
    }

    public List<Integer> bwa() {
        return this.gKT;
    }

    public void dw(List<Integer> list) {
        this.gKT = list;
    }

    public List<com.baidu.adp.widget.ListView.h> bwb() {
        return this.gKU;
    }

    public void dx(List<com.baidu.adp.widget.ListView.h> list) {
        this.gKU = list;
    }

    public com.baidu.tieba.h.b bwc() {
        return this.gKY;
    }

    public void a(com.baidu.tieba.h.b bVar) {
        this.gKY = bVar;
    }

    public AlaLiveNotify bwd() {
        return this.gLa;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.gLa = alaLiveNotify;
    }

    public List<FrsTabInfo> bwe() {
        return this.gLb;
    }

    public void dy(List<FrsTabInfo> list) {
        this.gLb = list;
    }

    public void tF(int i) {
        this.gLc = i;
    }

    public int bwf() {
        return this.gLc;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.gLe = qVar;
    }

    public com.baidu.tieba.frs.q bwg() {
        return this.gLe;
    }

    public k bwh() {
        return this.gLf;
    }

    public void a(k kVar) {
        this.gLf = kVar;
    }

    public e bwi() {
        return this.gKV;
    }

    public void b(e eVar) {
        this.gKV = eVar;
    }

    public f bwj() {
        return this.gKW;
    }

    public void b(f fVar) {
        this.gKW = fVar;
    }

    public WorldcupSkin bwk() {
        return this.gLk;
    }

    public com.baidu.tieba.tbadkCore.data.m bwl() {
        return this.gLo;
    }

    public void d(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.gLo = mVar;
    }
}
