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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.ao;
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
import tbclient.FrsPage.NebulaHotThreads;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsPage.RecomPostTopic;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsPage.StarRank;
import tbclient.FrsPage.WorldcupSkin;
import tbclient.FrsTabInfo;
import tbclient.OriForumInfo;
import tbclient.PopInfo;
import tbclient.SmartApp;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.WindowToast;
/* loaded from: classes6.dex */
public class i implements com.baidu.tbadk.mvc.b.c {
    public static final Wire WIRE = new Wire(new Class[0]);
    private AntiData arV;
    public ForumArIno dQM;
    protected ForumData fSF;
    private UserData fSM;
    protected al fhz;
    private String gameName;
    protected List<Long> hlL;
    private j hlM;
    protected boolean hlN;
    protected String hlO;
    protected m hlP;
    private b hlQ;
    private boolean hlR;
    private int hlU;
    private String hlV;
    private NavTabInfo hlY;
    private ForumHeadIcon hmB;
    private com.baidu.tieba.frs.q hmC;
    private k hmD;
    public FrsTabInfo hmE;
    public StarRank hmF;
    public List<WindowToast> hmG;
    public ActivityConfig hmH;
    private WorldcupSkin hmI;
    public com.baidu.tieba.frs.b hmJ;
    public List<OriForumInfo> hmK;
    public List<BottomMenu> hmL;
    private com.baidu.tieba.tbadkCore.data.m hmM;
    public boolean hmN;
    public List<String> hmP;
    public SmartApp hmQ;
    public NebulaHotThreads hmR;
    private List<FeedForumData> hma;
    private List<CategoryInfo> hmb;
    private bb hmk;
    private at hml;
    private com.baidu.tbadk.core.data.l hmn;
    private List<Integer> hmr;
    private List<com.baidu.adp.widget.ListView.h> hms;
    private e hmt;
    private f hmu;
    public PopInfo hmv;
    private com.baidu.tieba.h.b hmw;
    private AgreeBanner hmx;
    private AlaLiveNotify hmy;
    private List<FrsTabInfo> hmz;
    public boolean isBrandForum;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.h> threadList;
    private HashMap<String, MetaData> userMap;
    public int hlK = 0;
    private List<g> hlS = new ArrayList();
    private int hlT = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> hlW = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o hlX = null;
    private int hlZ = 1;
    private boolean guN = false;
    private String hmc = null;
    private com.baidu.tbadk.core.data.w hmd = null;
    public x hme = null;
    public RecomPostTopic hmf = null;
    private com.baidu.tbadk.core.data.p hmg = null;
    private Integer hmh = -1;
    public com.baidu.tbadk.core.data.u hmi = null;
    private com.baidu.tbadk.core.data.r hmj = null;
    private int hmm = -1;
    protected List<com.baidu.adp.widget.ListView.h> hmo = null;
    private int hmp = 0;
    private int hmq = 0;
    private int alaLiveCount = 0;
    private int hmA = 0;
    public int dRQ = 0;
    public int hmO = 1;

    public i() {
        initData();
    }

    private void initData() {
        this.fSF = new ForumData();
        this.threadList = new ArrayList<>();
        this.hmo = new ArrayList();
        this.userMap = new HashMap<>();
        this.fhz = new al();
        this.hlM = new j();
        this.fSM = new UserData();
        this.hlP = new m();
        c(new AntiData());
        a(new b());
        this.hms = new ArrayList();
        this.hmr = new ArrayList();
    }

    public FrsPageResIdl M(byte[] bArr) {
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
                if (!com.baidu.tbadk.core.util.v.I(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.v.I(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                            if (nVar.a(colorEgg)) {
                                this.hlW.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.forum != null) {
                    this.hlR = dataRes.forum.has_game.intValue() == 1;
                    this.hlV = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                    this.isBrandForum = dataRes.forum.is_brand_forum.intValue() == 1;
                }
                if (this.isBrandForum && dataRes.brand_forum_info != null) {
                    this.hlX = new com.baidu.tbadk.core.data.o();
                    this.hlX.a(dataRes.brand_forum_info.head_imgs);
                    this.hmJ = new com.baidu.tieba.frs.b();
                    this.hmJ.a(dataRes.brand_forum_info);
                    if (!com.baidu.tbadk.core.util.v.I(dataRes.brand_forum_info.relation_forum)) {
                        this.hmK = new ArrayList();
                        for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                            if (oriForumInfo != null) {
                                this.hmK.add(oriForumInfo);
                            }
                        }
                    }
                } else if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.I(dataRes.activityhead.head_imgs)) {
                    this.hlX = new com.baidu.tbadk.core.data.o();
                    this.hlX.a(dataRes.activityhead);
                }
                this.hmL = dataRes.bottom_menu;
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
                sl(dataRes.is_new_url.intValue());
                this.hlN = dataRes.fortune_bag.intValue() == 1;
                this.hlO = dataRes.fortune_desc;
                List<StarEnter> list2 = dataRes.star_enter;
                this.hlS.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.hlS.add(gVar);
                    }
                }
                this.hlP.a(dataRes.gcon_account);
                this.fSF.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.hlL = dataRes.thread_id_list;
                this.arV.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.ueg.c.e(dataRes.anti.block_pop_info);
                }
                this.hlQ.a(dataRes.group);
                this.fhz.a(dataRes.page);
                this.hlM.a(dataRes.frs_star);
                this.fSM.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fSM.getIsSelectTail());
                }
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.hlY = builder.build(true);
                } else {
                    this.hlY = dataRes.nav_tab_info;
                }
                if (this.hlY != null && com.baidu.tbadk.core.util.v.d(this.hlY.tab, 0) != null) {
                    this.hmO = ((FrsTabInfo) com.baidu.tbadk.core.util.v.d(this.hlY.tab, 0)).tab_id.intValue();
                }
                if (this.hlY != null && !com.baidu.tbadk.core.util.v.I(this.hlY.head)) {
                    this.hmE = this.hlY.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                vv(dataRes.frs_tab_default.intValue());
                this.hlU = dataRes.twzhibo_pos.intValue();
                this.guN = dataRes.trends_redpoint.intValue() == 1;
                c(dataRes.thread_list, longValue);
                this.hmb = dataRes.category_list;
                if (!ao.isEmpty(dataRes.bawu_enter_url)) {
                    this.hmc = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.hmd = new com.baidu.tbadk.core.data.w();
                    this.hmd.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.hme = new x();
                    this.hme.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.hmg = new com.baidu.tbadk.core.data.p();
                    this.hmg.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.hmi = new com.baidu.tbadk.core.data.u();
                    this.hmi.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.hmj = new com.baidu.tbadk.core.data.r();
                    this.hmj.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.hmk = new bb();
                    this.hmk.bb(true);
                    this.hmk.cV(this.hlU);
                    this.hmk.setUserMap(this.userMap);
                    this.hmk.a(dataRes.card_shipin_info.get(0));
                    this.hmk.Aq();
                    this.hmk.avD = this.isBrandForum;
                    if (this.hmk.getFid() == 0 && longValue != 0) {
                        this.hmk.setFid(longValue);
                    }
                    this.hmk.m(this.hlW);
                    this.hmk.ba(!this.hmk.zm());
                    if (this.hmk.zG() != null && this.hmk.zG().getPendantData() == null && (metaData = this.userMap.get(this.hmk.zG().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.ap(metaData.getPendantData().LF());
                        jVar.ej(metaData.getPendantData().ys());
                        this.hmk.zG().setPendantData(jVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.hmt = new e();
                    this.hmt.hlg = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < dataRes.ala_live_insert.ala_live_list.size(); i3++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i3) != null) {
                            bb bbVar = new bb();
                            bbVar.a(dataRes.ala_live_insert.ala_live_list.get(i3));
                            bbVar.avD = this.isBrandForum;
                            arrayList.add(bbVar);
                        }
                    }
                    this.hmt.hlf = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.hmu = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_stage_list.size(); i4++) {
                        if (dataRes.ala_stage_list.get(i4) != null) {
                            bb bbVar2 = new bb();
                            bbVar2.a(dataRes.ala_stage_list.get(i4));
                            bbVar2.avD = this.isBrandForum;
                            arrayList2.add(bbVar2);
                        }
                    }
                    this.hmu.hli = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.hmm = dataRes.school_recom_pos.intValue();
                    this.hml = new at();
                    this.hml.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.hmn = new com.baidu.tbadk.core.data.l();
                    this.hmn.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.hmp = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.hmq = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.hlK = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bwa().uN(dataRes.asp_shown_info);
                this.hmr = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bb bbVar3 = new bb();
                        if (this.hmr != null && this.hmr.size() >= dataRes.card_shipin_new.size()) {
                            bbVar3.cV(this.hmr.get(i5).intValue());
                        }
                        bbVar3.bb(true);
                        bbVar3.a(dataRes.card_shipin_new.get(i5));
                        bbVar3.avD = this.isBrandForum;
                        this.hms.add(bbVar3);
                    }
                }
                this.hmv = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.hmw = new com.baidu.tieba.h.b();
                    this.hmw.a(dataRes.esport);
                }
                this.hmx = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.hmC = new com.baidu.tieba.frs.q();
                    this.hmC.a(dataRes.user_extend);
                }
                this.hmy = dataRes.live_frs_notify;
                this.hmz = dataRes.frs_game_tab_info;
                this.hmA = dataRes.game_default_tab_id.intValue();
                this.hmB = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.hmD = new k();
                    this.hmD.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.dQM = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.hmF = dataRes.star_rank_info;
                }
                if (dataRes.recom_post_topic != null) {
                    this.hmf = dataRes.recom_post_topic;
                }
                this.hmG = dataRes.window_toast;
                this.hmH = dataRes.activity_config;
                this.hmI = dataRes.worldcup_skin;
                this.hmM = new com.baidu.tieba.tbadkCore.data.m();
                this.hmM.a(dataRes.redpacketrain);
                this.hmN = dataRes.video_auto_play.intValue() == 1;
                this.hmP = dataRes.smart_app_avatar;
                this.hmQ = dataRes.smart_app;
                this.hmR = dataRes.nebula_hot_threads;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner bCc() {
        return this.hmx;
    }

    public void a(AgreeBanner agreeBanner) {
        this.hmx = agreeBanner;
    }

    public ForumHeadIcon bCd() {
        return this.hmB;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.hmB = forumHeadIcon;
    }

    public List<RecmForumInfo> bCe() {
        return this.recm_forum_list;
    }

    private void vv(int i) {
        this.hlZ = 1;
        if (this.hlY != null && this.hlY.tab != null && this.hlY.tab.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.hlY.tab) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.hlZ = i;
                    return;
                }
            }
        }
    }

    public void c(List<ThreadInfo> list, long j) {
        if (!com.baidu.tbadk.core.util.v.I(list)) {
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bb bbVar = new bb();
                    bbVar.setUserMap(this.userMap);
                    bbVar.a(threadInfo);
                    bbVar.setCurrentPage(3);
                    bbVar.Aq();
                    if (bbVar.getFid() == 0 && j != 0) {
                        bbVar.setFid(j);
                    }
                    if (StringUtils.isNull(bbVar.zM())) {
                        bbVar.em(this.fSF.getName());
                    }
                    bbVar.m(this.hlW);
                    bbVar.avD = this.fSF.isBrandForum;
                    if (!TextUtils.isEmpty(bbVar.AA())) {
                        ab abVar = new ab();
                        abVar.eh(bbVar.AA());
                        this.threadList.add(abVar);
                    } else {
                        this.threadList.add(bbVar);
                    }
                }
            }
        }
    }

    public int bCf() {
        return this.alaLiveCount;
    }

    public void vw(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] NY() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean F(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void I(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData bgT() {
        return this.fSF;
    }

    public int bCg() {
        return this.hmp;
    }

    public void vx(int i) {
        this.hmp = i;
    }

    public int bCh() {
        return this.hmq;
    }

    public void vy(int i) {
        this.hmq = i;
    }

    public void c(ForumData forumData) {
        this.fSF = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getThreadList() {
        return this.threadList;
    }

    public void ay(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData yE() {
        return this.arV;
    }

    public void c(AntiData antiData) {
        this.arV = antiData;
    }

    public al yS() {
        return this.fhz;
    }

    public void a(al alVar) {
        this.fhz = alVar;
    }

    public j bCi() {
        return this.hlM;
    }

    public void a(j jVar) {
        this.hlM = jVar;
    }

    public com.baidu.tbadk.core.data.o bCj() {
        return this.hlX;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.hlX = oVar;
    }

    public boolean bCk() {
        return this.hlN;
    }

    public void nq(boolean z) {
        this.hlN = z;
    }

    public String bCl() {
        return this.hlO;
    }

    public void vu(String str) {
        this.hlO = str;
    }

    public m bCm() {
        return this.hlP;
    }

    public void a(m mVar) {
        this.hlP = mVar;
    }

    public UserData getUserData() {
        return this.fSM;
    }

    public void e(UserData userData) {
        this.fSM = userData;
    }

    public List<Long> bCn() {
        return this.hlL;
    }

    public void dG(List<Long> list) {
        this.hlL = list;
    }

    public b bCo() {
        return this.hlQ;
    }

    public void a(b bVar) {
        this.hlQ = bVar;
    }

    public boolean bCp() {
        return this.hlR;
    }

    public void nr(boolean z) {
        this.hlR = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bCq() {
        return this.hlS;
    }

    public void dH(List<g> list) {
        this.hlS = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int bhi() {
        return this.hlT;
    }

    public void sl(int i) {
        this.hlT = i;
    }

    public String bCr() {
        return this.hlV;
    }

    public void vv(String str) {
        this.hlV = str;
    }

    public int bCs() {
        return this.hlU;
    }

    public void vz(int i) {
        this.hlU = i;
    }

    public List<FeedForumData> bCt() {
        return this.hma;
    }

    public void dI(List<FeedForumData> list) {
        this.hma = list;
    }

    public void vw(String str) {
        if (this.hma != null && str != null) {
            for (FeedForumData feedForumData : this.hma) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.hma.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bCu() {
        return this.hmb;
    }

    public void dJ(List<CategoryInfo> list) {
        this.hmb = list;
    }

    public void vx(String str) {
        this.hmc = str;
    }

    public String bCv() {
        return this.hmc;
    }

    public bb bCw() {
        return this.hmk;
    }

    public void at(bb bbVar) {
        this.hmk = bbVar;
    }

    public int bCx() {
        return this.hlZ;
    }

    public void vA(int i) {
        this.hlZ = i;
    }

    public com.baidu.tbadk.core.data.w bCy() {
        return this.hmd;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.hmd = wVar;
    }

    public com.baidu.tbadk.core.data.p bCz() {
        return this.hmg;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.hmg = pVar;
    }

    public com.baidu.tbadk.core.data.r bCA() {
        return this.hmj;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.hmj = rVar;
    }

    public int bCB() {
        return this.hmm;
    }

    public void vB(int i) {
        this.hmm = i;
    }

    public at bCC() {
        return this.hml;
    }

    public void a(at atVar) {
        this.hml = atVar;
    }

    public NavTabInfo bCD() {
        return this.hlY;
    }

    public void a(NavTabInfo navTabInfo) {
        this.hlY = navTabInfo;
    }

    public boolean bCE() {
        return this.guN;
    }

    public void ns(boolean z) {
        this.guN = z;
    }

    public com.baidu.tbadk.core.data.l bCF() {
        return this.hmn;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.hmn = lVar;
    }

    public int acb() {
        return this.mSortType;
    }

    public Integer bCG() {
        return this.hmh;
    }

    public void q(Integer num) {
        this.hmh = num;
    }

    public List<Integer> bCH() {
        return this.hmr;
    }

    public void dK(List<Integer> list) {
        this.hmr = list;
    }

    public List<com.baidu.adp.widget.ListView.h> bCI() {
        return this.hms;
    }

    public void dL(List<com.baidu.adp.widget.ListView.h> list) {
        this.hms = list;
    }

    public com.baidu.tieba.h.b bCJ() {
        return this.hmw;
    }

    public void a(com.baidu.tieba.h.b bVar) {
        this.hmw = bVar;
    }

    public AlaLiveNotify bCK() {
        return this.hmy;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.hmy = alaLiveNotify;
    }

    public List<FrsTabInfo> bCL() {
        return this.hmz;
    }

    public void dM(List<FrsTabInfo> list) {
        this.hmz = list;
    }

    public void vC(int i) {
        this.hmA = i;
    }

    public int bCM() {
        return this.hmA;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.hmC = qVar;
    }

    public com.baidu.tieba.frs.q bCN() {
        return this.hmC;
    }

    public k bCO() {
        return this.hmD;
    }

    public void a(k kVar) {
        this.hmD = kVar;
    }

    public e bCP() {
        return this.hmt;
    }

    public void b(e eVar) {
        this.hmt = eVar;
    }

    public f bCQ() {
        return this.hmu;
    }

    public void b(f fVar) {
        this.hmu = fVar;
    }

    public WorldcupSkin bCR() {
        return this.hmI;
    }

    public com.baidu.tieba.tbadkCore.data.m bCS() {
        return this.hmM;
    }

    public void d(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.hmM = mVar;
    }
}
