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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.util.ao;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.AlaLiveNotify;
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
import tbclient.PopInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.WindowToast;
/* loaded from: classes2.dex */
public class i implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData agD;
    public ForumArIno dmy;
    protected am ezX;
    protected ForumData fon;
    private UserData fov;
    private int gGB;
    private String gGC;
    private NavTabInfo gGF;
    private List<FeedForumData> gGH;
    private List<CategoryInfo> gGI;
    private bd gGR;
    private au gGS;
    private com.baidu.tbadk.core.data.m gGU;
    private List<Integer> gGY;
    private List<com.baidu.adp.widget.ListView.h> gGZ;
    protected List<Long> gGs;
    private j gGt;
    protected boolean gGu;
    protected String gGv;
    protected m gGw;
    private b gGx;
    private boolean gGy;
    private e gHa;
    private f gHb;
    public PopInfo gHc;
    private com.baidu.tieba.h.b gHd;
    private AgreeBanner gHe;
    private AlaLiveNotify gHf;
    private List<FrsTabInfo> gHg;
    private ForumHeadIcon gHi;
    private com.baidu.tieba.frs.o gHj;
    private k gHk;
    public FrsTabInfo gHl;
    public StarRank gHm;
    public List<WindowToast> gHn;
    public ActivityConfig gHo;
    private WorldcupSkin gHp;
    private com.baidu.tieba.tbadkCore.data.m gHq;
    private String gameName;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.h> threadList;
    private HashMap<String, MetaData> userMap;
    public int gGr = 0;
    private List<g> gGz = new ArrayList();
    private int gGA = 0;
    private ArrayList<com.baidu.tbadk.core.data.o> gGD = new ArrayList<>();
    protected com.baidu.tbadk.core.data.p gGE = null;
    private int gGG = 1;
    private boolean fQF = false;
    private String gGJ = null;
    private x gGK = null;
    public y gGL = null;
    public RecomPostTopic gGM = null;
    private com.baidu.tbadk.core.data.q gGN = null;
    private Integer gGO = -1;
    public com.baidu.tbadk.core.data.v gGP = null;
    private com.baidu.tbadk.core.data.s gGQ = null;
    private int gGT = -1;
    protected List<com.baidu.adp.widget.ListView.h> gGV = null;
    private int gGW = 0;
    private int gGX = 0;
    private int alaLiveCount = 0;
    private int gHh = 0;
    public int dmW = 0;

    public i() {
        initData();
    }

    private void initData() {
        this.fon = new ForumData();
        this.threadList = new ArrayList<>();
        this.gGV = new ArrayList();
        this.userMap = new HashMap<>();
        this.ezX = new am();
        this.gGt = new j();
        this.fov = new UserData();
        this.gGw = new m();
        c(new AntiData());
        a(new b());
        this.gGZ = new ArrayList();
        this.gGY = new ArrayList();
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
        if (dataRes != null) {
            try {
                initData();
                if (!com.baidu.tbadk.core.util.w.z(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.w.z(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
                            if (oVar.a(colorEgg)) {
                                this.gGD.add(oVar);
                            }
                        }
                    }
                }
                if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.w.z(dataRes.activityhead.head_imgs)) {
                    this.gGE = new com.baidu.tbadk.core.data.p();
                    this.gGE.a(dataRes.activityhead);
                }
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
                qf(dataRes.is_new_url.intValue());
                this.gGu = dataRes.fortune_bag.intValue() == 1;
                this.gGv = dataRes.fortune_desc;
                if (dataRes.forum != null) {
                    this.gGy = dataRes.forum.has_game.intValue() == 1;
                    this.gGC = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                }
                List<StarEnter> list2 = dataRes.star_enter;
                this.gGz.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.gGz.add(gVar);
                    }
                }
                this.gGw.a(dataRes.gcon_account);
                this.fon.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gGs = dataRes.thread_id_list;
                this.agD.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.s.b.e(dataRes.anti.block_pop_info);
                }
                this.gGx.a(dataRes.group);
                this.ezX.a(dataRes.page);
                this.gGt.a(dataRes.frs_star);
                this.fov.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fov.getIsSelectTail());
                }
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gGF = builder.build(true);
                } else {
                    this.gGF = dataRes.nav_tab_info;
                }
                if (this.gGF.head != null && !com.baidu.tbadk.core.util.w.z(this.gGF.head)) {
                    this.gHl = this.gGF.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                tm(dataRes.frs_tab_default.intValue());
                this.gGB = dataRes.twzhibo_pos.intValue();
                this.fQF = dataRes.trends_redpoint.intValue() == 1;
                b(dataRes.thread_list, longValue);
                this.gGI = dataRes.category_list;
                if (!ao.isEmpty(dataRes.bawu_enter_url)) {
                    this.gGJ = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gGK = new x();
                    this.gGK.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gGL = new y();
                    this.gGL.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gGN = new com.baidu.tbadk.core.data.q();
                    this.gGN.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gGP = new com.baidu.tbadk.core.data.v();
                    this.gGP.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gGQ = new com.baidu.tbadk.core.data.s();
                    this.gGQ.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gGR = new bd();
                    this.gGR.as(true);
                    this.gGR.bW(this.gGB);
                    this.gGR.setUserMap(this.userMap);
                    this.gGR.a(dataRes.card_shipin_info.get(0));
                    this.gGR.vT();
                    if (this.gGR.getFid() == 0 && longValue != 0) {
                        this.gGR.setFid(longValue);
                    }
                    this.gGR.i(this.gGD);
                    this.gGR.ar(!this.gGR.uU());
                    if (this.gGR.vm() != null && this.gGR.vm().getPendantData() == null && (metaData = this.userMap.get(this.gGR.vm().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                        iVar.W(metaData.getPendantData().GL());
                        iVar.dj(metaData.getPendantData().ub());
                        this.gGR.vm().setPendantData(iVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.gHa = new e();
                    this.gHa.gFQ = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < dataRes.ala_live_insert.ala_live_list.size(); i3++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i3) != null) {
                            bd bdVar = new bd();
                            bdVar.a(dataRes.ala_live_insert.ala_live_list.get(i3));
                            arrayList.add(bdVar);
                        }
                    }
                    this.gHa.gFP = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.gHb = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_stage_list.size(); i4++) {
                        if (dataRes.ala_stage_list.get(i4) != null) {
                            bd bdVar2 = new bd();
                            bdVar2.a(dataRes.ala_stage_list.get(i4));
                            arrayList2.add(bdVar2);
                        }
                    }
                    this.gHb.gFS = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.gGT = dataRes.school_recom_pos.intValue();
                    this.gGS = new au();
                    this.gGS.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gGU = new com.baidu.tbadk.core.data.m();
                    this.gGU.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.gGW = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gGX = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gGr = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.boX().sX(dataRes.asp_shown_info);
                this.gGY = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bd bdVar3 = new bd();
                        if (this.gGY != null && this.gGY.size() >= dataRes.card_shipin_new.size()) {
                            bdVar3.bW(this.gGY.get(i5).intValue());
                        }
                        bdVar3.as(true);
                        bdVar3.a(dataRes.card_shipin_new.get(i5));
                        this.gGZ.add(bdVar3);
                    }
                }
                this.gHc = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.gHd = new com.baidu.tieba.h.b();
                    this.gHd.a(dataRes.esport);
                }
                this.gHe = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gHj = new com.baidu.tieba.frs.o();
                    this.gHj.a(dataRes.user_extend);
                }
                this.gHf = dataRes.live_frs_notify;
                this.gHg = dataRes.frs_game_tab_info;
                this.gHh = dataRes.game_default_tab_id.intValue();
                this.gHi = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.gHk = new k();
                    this.gHk.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.dmy = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.gHm = dataRes.star_rank_info;
                }
                if (dataRes.recom_post_topic != null) {
                    this.gGM = dataRes.recom_post_topic;
                }
                this.gHn = dataRes.window_toast;
                this.gHo = dataRes.activity_config;
                this.gHp = dataRes.worldcup_skin;
                this.gHq = new com.baidu.tieba.tbadkCore.data.m();
                this.gHq.a(dataRes.redpacketrain);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner buV() {
        return this.gHe;
    }

    public void a(AgreeBanner agreeBanner) {
        this.gHe = agreeBanner;
    }

    public ForumHeadIcon buW() {
        return this.gHi;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gHi = forumHeadIcon;
    }

    public List<RecmForumInfo> buX() {
        return this.recm_forum_list;
    }

    private void tm(int i) {
        this.gGG = 1;
        if (this.gGF != null && this.gGF.tab != null && this.gGF.tab.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gGF.tab) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gGG = i;
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
                    bd bdVar = new bd();
                    bdVar.setUserMap(this.userMap);
                    bdVar.a(list.get(i2));
                    bdVar.bX(3);
                    bdVar.vT();
                    if (bdVar.getFid() == 0 && j != 0) {
                        bdVar.setFid(j);
                    }
                    if (StringUtils.isNull(bdVar.vr())) {
                        bdVar.dm(this.fon.getName());
                    }
                    bdVar.i(this.gGD);
                    if (!TextUtils.isEmpty(bdVar.wd())) {
                        ac acVar = new ac();
                        acVar.dg(bdVar.wd());
                        this.threadList.add(acVar);
                    } else {
                        this.threadList.add(bdVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int buY() {
        return this.alaLiveCount;
    }

    public void tn(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Jf() {
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
    public void v(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData bam() {
        return this.fon;
    }

    public int buZ() {
        return this.gGW;
    }

    public void to(int i) {
        this.gGW = i;
    }

    public int bva() {
        return this.gGX;
    }

    public void tp(int i) {
        this.gGX = i;
    }

    public void c(ForumData forumData) {
        this.fon = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getThreadList() {
        return this.threadList;
    }

    public void av(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData uo() {
        return this.agD;
    }

    public void c(AntiData antiData) {
        this.agD = antiData;
    }

    public am uB() {
        return this.ezX;
    }

    public void a(am amVar) {
        this.ezX = amVar;
    }

    public j bvb() {
        return this.gGt;
    }

    public void a(j jVar) {
        this.gGt = jVar;
    }

    public com.baidu.tbadk.core.data.p bvc() {
        return this.gGE;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.gGE = pVar;
    }

    public boolean bvd() {
        return this.gGu;
    }

    public void mq(boolean z) {
        this.gGu = z;
    }

    public String bve() {
        return this.gGv;
    }

    public void tC(String str) {
        this.gGv = str;
    }

    public m bvf() {
        return this.gGw;
    }

    public void a(m mVar) {
        this.gGw = mVar;
    }

    public UserData getUserData() {
        return this.fov;
    }

    public void e(UserData userData) {
        this.fov = userData;
    }

    public List<Long> bvg() {
        return this.gGs;
    }

    /* renamed from: do  reason: not valid java name */
    public void m17do(List<Long> list) {
        this.gGs = list;
    }

    public b bvh() {
        return this.gGx;
    }

    public void a(b bVar) {
        this.gGx = bVar;
    }

    public boolean bvi() {
        return this.gGy;
    }

    public void mr(boolean z) {
        this.gGy = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bvj() {
        return this.gGz;
    }

    public void dp(List<g> list) {
        this.gGz = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int baB() {
        return this.gGA;
    }

    public void qf(int i) {
        this.gGA = i;
    }

    public String bvk() {
        return this.gGC;
    }

    public void tD(String str) {
        this.gGC = str;
    }

    public int bvl() {
        return this.gGB;
    }

    public void tq(int i) {
        this.gGB = i;
    }

    public List<FeedForumData> bvm() {
        return this.gGH;
    }

    public void dq(List<FeedForumData> list) {
        this.gGH = list;
    }

    public void tE(String str) {
        if (this.gGH != null && str != null) {
            for (FeedForumData feedForumData : this.gGH) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gGH.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bvn() {
        return this.gGI;
    }

    public void dr(List<CategoryInfo> list) {
        this.gGI = list;
    }

    public void tF(String str) {
        this.gGJ = str;
    }

    public String bvo() {
        return this.gGJ;
    }

    public bd bvp() {
        return this.gGR;
    }

    public void am(bd bdVar) {
        this.gGR = bdVar;
    }

    public int bvq() {
        return this.gGG;
    }

    public void tr(int i) {
        this.gGG = i;
    }

    public x bvr() {
        return this.gGK;
    }

    public void a(x xVar) {
        this.gGK = xVar;
    }

    public com.baidu.tbadk.core.data.q bvs() {
        return this.gGN;
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        this.gGN = qVar;
    }

    public com.baidu.tbadk.core.data.s bvt() {
        return this.gGQ;
    }

    public void a(com.baidu.tbadk.core.data.s sVar) {
        this.gGQ = sVar;
    }

    public int bvu() {
        return this.gGT;
    }

    public void ts(int i) {
        this.gGT = i;
    }

    public au bvv() {
        return this.gGS;
    }

    public void a(au auVar) {
        this.gGS = auVar;
    }

    public NavTabInfo bvw() {
        return this.gGF;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gGF = navTabInfo;
    }

    public boolean bvx() {
        return this.fQF;
    }

    public void ms(boolean z) {
        this.fQF = z;
    }

    public com.baidu.tbadk.core.data.m bvy() {
        return this.gGU;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.gGU = mVar;
    }

    public int UG() {
        return this.mSortType;
    }

    public Integer bvz() {
        return this.gGO;
    }

    public void q(Integer num) {
        this.gGO = num;
    }

    public List<Integer> bvA() {
        return this.gGY;
    }

    public void ds(List<Integer> list) {
        this.gGY = list;
    }

    public List<com.baidu.adp.widget.ListView.h> bvB() {
        return this.gGZ;
    }

    public void dt(List<com.baidu.adp.widget.ListView.h> list) {
        this.gGZ = list;
    }

    public com.baidu.tieba.h.b bvC() {
        return this.gHd;
    }

    public void a(com.baidu.tieba.h.b bVar) {
        this.gHd = bVar;
    }

    public AlaLiveNotify bvD() {
        return this.gHf;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.gHf = alaLiveNotify;
    }

    public List<FrsTabInfo> bvE() {
        return this.gHg;
    }

    public void du(List<FrsTabInfo> list) {
        this.gHg = list;
    }

    public void tt(int i) {
        this.gHh = i;
    }

    public int bvF() {
        return this.gHh;
    }

    public void a(com.baidu.tieba.frs.o oVar) {
        this.gHj = oVar;
    }

    public com.baidu.tieba.frs.o bvG() {
        return this.gHj;
    }

    public k bvH() {
        return this.gHk;
    }

    public void a(k kVar) {
        this.gHk = kVar;
    }

    public e bvI() {
        return this.gHa;
    }

    public void b(e eVar) {
        this.gHa = eVar;
    }

    public f bvJ() {
        return this.gHb;
    }

    public void b(f fVar) {
        this.gHb = fVar;
    }

    public WorldcupSkin bvK() {
        return this.gHp;
    }

    public com.baidu.tieba.tbadkCore.data.m bvL() {
        return this.gHq;
    }

    public void d(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.gHq = mVar;
    }
}
