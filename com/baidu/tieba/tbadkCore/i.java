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
    private AntiData agm;
    public ForumArIno drT;
    protected al eHC;
    protected ForumData fsm;
    private UserData fst;
    private List<FeedForumData> gLB;
    private List<CategoryInfo> gLC;
    private bb gLL;
    private at gLM;
    private com.baidu.tbadk.core.data.l gLO;
    private List<Integer> gLS;
    private List<com.baidu.adp.widget.ListView.h> gLT;
    private e gLU;
    private f gLV;
    public PopInfo gLW;
    private com.baidu.tieba.h.b gLX;
    private AgreeBanner gLY;
    private AlaLiveNotify gLZ;
    protected List<Long> gLm;
    private j gLn;
    protected boolean gLo;
    protected String gLp;
    protected m gLq;
    private b gLr;
    private boolean gLs;
    private int gLv;
    private String gLw;
    private NavTabInfo gLz;
    private List<FrsTabInfo> gMa;
    private ForumHeadIcon gMc;
    private com.baidu.tieba.frs.q gMd;
    private k gMe;
    public FrsTabInfo gMf;
    public StarRank gMg;
    public List<WindowToast> gMh;
    public ActivityConfig gMi;
    private WorldcupSkin gMj;
    public com.baidu.tieba.frs.b gMk;
    public List<OriForumInfo> gMl;
    public List<BottomMenu> gMm;
    private com.baidu.tieba.tbadkCore.data.m gMn;
    public boolean gMo;
    private String gameName;
    public boolean isBrandForum;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.h> threadList;
    private HashMap<String, MetaData> userMap;
    public int gLl = 0;
    private List<g> gLt = new ArrayList();
    private int gLu = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> gLx = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o gLy = null;
    private int gLA = 1;
    private boolean fUP = false;
    private String gLD = null;
    private com.baidu.tbadk.core.data.w gLE = null;
    public x gLF = null;
    public RecomPostTopic gLG = null;
    private com.baidu.tbadk.core.data.p gLH = null;
    private Integer gLI = -1;
    public com.baidu.tbadk.core.data.u gLJ = null;
    private com.baidu.tbadk.core.data.r gLK = null;
    private int gLN = -1;
    protected List<com.baidu.adp.widget.ListView.h> gLP = null;
    private int gLQ = 0;
    private int gLR = 0;
    private int alaLiveCount = 0;
    private int gMb = 0;
    public int dsR = 0;
    public int gMp = 1;

    public i() {
        initData();
    }

    private void initData() {
        this.fsm = new ForumData();
        this.threadList = new ArrayList<>();
        this.gLP = new ArrayList();
        this.userMap = new HashMap<>();
        this.eHC = new al();
        this.gLn = new j();
        this.fst = new UserData();
        this.gLq = new m();
        c(new AntiData());
        a(new b());
        this.gLT = new ArrayList();
        this.gLS = new ArrayList();
    }

    public FrsPageResIdl E(byte[] bArr) {
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
                            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                            if (nVar.a(colorEgg)) {
                                this.gLx.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.forum != null) {
                    this.gLs = dataRes.forum.has_game.intValue() == 1;
                    this.gLw = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                    this.isBrandForum = dataRes.forum.is_brand_forum.intValue() == 1;
                }
                if (this.isBrandForum && dataRes.brand_forum_info != null) {
                    this.gLy = new com.baidu.tbadk.core.data.o();
                    this.gLy.a(dataRes.brand_forum_info.head_imgs);
                    this.gMk = new com.baidu.tieba.frs.b();
                    this.gMk.a(dataRes.brand_forum_info);
                    if (!com.baidu.tbadk.core.util.w.z(dataRes.brand_forum_info.relation_forum)) {
                        this.gMl = new ArrayList();
                        for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                            if (oriForumInfo != null) {
                                this.gMl.add(oriForumInfo);
                            }
                        }
                    }
                } else if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.w.z(dataRes.activityhead.head_imgs)) {
                    this.gLy = new com.baidu.tbadk.core.data.o();
                    this.gLy.a(dataRes.activityhead);
                }
                this.gMm = dataRes.bottom_menu;
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
                qj(dataRes.is_new_url.intValue());
                this.gLo = dataRes.fortune_bag.intValue() == 1;
                this.gLp = dataRes.fortune_desc;
                List<StarEnter> list2 = dataRes.star_enter;
                this.gLt.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.gLt.add(gVar);
                    }
                }
                this.gLq.a(dataRes.gcon_account);
                this.fsm.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gLm = dataRes.thread_id_list;
                this.agm.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.ueg.c.e(dataRes.anti.block_pop_info);
                }
                this.gLr.a(dataRes.group);
                this.eHC.a(dataRes.page);
                this.gLn.a(dataRes.frs_star);
                this.fst.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fst.getIsSelectTail());
                }
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gLz = builder.build(true);
                } else {
                    this.gLz = dataRes.nav_tab_info;
                }
                if (this.gLz != null && com.baidu.tbadk.core.util.w.d(this.gLz.tab, 0) != null) {
                    this.gMp = ((FrsTabInfo) com.baidu.tbadk.core.util.w.d(this.gLz.tab, 0)).tab_id.intValue();
                }
                if (this.gLz != null && !com.baidu.tbadk.core.util.w.z(this.gLz.head)) {
                    this.gMf = this.gLz.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                tw(dataRes.frs_tab_default.intValue());
                this.gLv = dataRes.twzhibo_pos.intValue();
                this.fUP = dataRes.trends_redpoint.intValue() == 1;
                b(dataRes.thread_list, longValue);
                this.gLC = dataRes.category_list;
                if (!ap.isEmpty(dataRes.bawu_enter_url)) {
                    this.gLD = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gLE = new com.baidu.tbadk.core.data.w();
                    this.gLE.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gLF = new x();
                    this.gLF.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gLH = new com.baidu.tbadk.core.data.p();
                    this.gLH.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gLJ = new com.baidu.tbadk.core.data.u();
                    this.gLJ.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gLK = new com.baidu.tbadk.core.data.r();
                    this.gLK.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gLL = new bb();
                    this.gLL.ar(true);
                    this.gLL.bZ(this.gLv);
                    this.gLL.setUserMap(this.userMap);
                    this.gLL.a(dataRes.card_shipin_info.get(0));
                    this.gLL.vR();
                    this.gLL.ajR = this.isBrandForum;
                    if (this.gLL.getFid() == 0 && longValue != 0) {
                        this.gLL.setFid(longValue);
                    }
                    this.gLL.m(this.gLx);
                    this.gLL.aq(!this.gLL.uP());
                    if (this.gLL.vj() != null && this.gLL.vj().getPendantData() == null && (metaData = this.userMap.get(this.gLL.vj().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                        iVar.Z(metaData.getPendantData().GZ());
                        iVar.dj(metaData.getPendantData().tT());
                        this.gLL.vj().setPendantData(iVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.gLU = new e();
                    this.gLU.gKH = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < dataRes.ala_live_insert.ala_live_list.size(); i3++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i3) != null) {
                            bb bbVar = new bb();
                            bbVar.a(dataRes.ala_live_insert.ala_live_list.get(i3));
                            bbVar.ajR = this.isBrandForum;
                            arrayList.add(bbVar);
                        }
                    }
                    this.gLU.gKG = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.gLV = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_stage_list.size(); i4++) {
                        if (dataRes.ala_stage_list.get(i4) != null) {
                            bb bbVar2 = new bb();
                            bbVar2.a(dataRes.ala_stage_list.get(i4));
                            bbVar2.ajR = this.isBrandForum;
                            arrayList2.add(bbVar2);
                        }
                    }
                    this.gLV.gKJ = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.gLN = dataRes.school_recom_pos.intValue();
                    this.gLM = new at();
                    this.gLM.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gLO = new com.baidu.tbadk.core.data.l();
                    this.gLO.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.gLQ = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gLR = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gLl = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.boe().sW(dataRes.asp_shown_info);
                this.gLS = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bb bbVar3 = new bb();
                        if (this.gLS != null && this.gLS.size() >= dataRes.card_shipin_new.size()) {
                            bbVar3.bZ(this.gLS.get(i5).intValue());
                        }
                        bbVar3.ar(true);
                        bbVar3.a(dataRes.card_shipin_new.get(i5));
                        bbVar3.ajR = this.isBrandForum;
                        this.gLT.add(bbVar3);
                    }
                }
                this.gLW = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.gLX = new com.baidu.tieba.h.b();
                    this.gLX.a(dataRes.esport);
                }
                this.gLY = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gMd = new com.baidu.tieba.frs.q();
                    this.gMd.a(dataRes.user_extend);
                }
                this.gLZ = dataRes.live_frs_notify;
                this.gMa = dataRes.frs_game_tab_info;
                this.gMb = dataRes.game_default_tab_id.intValue();
                this.gMc = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.gMe = new k();
                    this.gMe.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.drT = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.gMg = dataRes.star_rank_info;
                }
                if (dataRes.recom_post_topic != null) {
                    this.gLG = dataRes.recom_post_topic;
                }
                this.gMh = dataRes.window_toast;
                this.gMi = dataRes.activity_config;
                this.gMj = dataRes.worldcup_skin;
                this.gMn = new com.baidu.tieba.tbadkCore.data.m();
                this.gMn.a(dataRes.redpacketrain);
                this.gMo = dataRes.video_auto_play.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner bua() {
        return this.gLY;
    }

    public void a(AgreeBanner agreeBanner) {
        this.gLY = agreeBanner;
    }

    public ForumHeadIcon bub() {
        return this.gMc;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gMc = forumHeadIcon;
    }

    public List<RecmForumInfo> buc() {
        return this.recm_forum_list;
    }

    private void tw(int i) {
        this.gLA = 1;
        if (this.gLz != null && this.gLz.tab != null && this.gLz.tab.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gLz.tab) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gLA = i;
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
                    bb bbVar = new bb();
                    bbVar.setUserMap(this.userMap);
                    bbVar.a(list.get(i2));
                    bbVar.ca(3);
                    bbVar.vR();
                    if (bbVar.getFid() == 0 && j != 0) {
                        bbVar.setFid(j);
                    }
                    if (StringUtils.isNull(bbVar.vp())) {
                        bbVar.dm(this.fsm.getName());
                    }
                    bbVar.m(this.gLx);
                    bbVar.ajR = this.fsm.isBrandForum;
                    if (!TextUtils.isEmpty(bbVar.wb())) {
                        ab abVar = new ab();
                        abVar.dh(bbVar.wb());
                        this.threadList.add(abVar);
                    } else {
                        this.threadList.add(bbVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public int bud() {
        return this.alaLiveCount;
    }

    public void tx(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Jw() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean y(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void u(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData aZg() {
        return this.fsm;
    }

    public int bue() {
        return this.gLQ;
    }

    public void ty(int i) {
        this.gLQ = i;
    }

    public int buf() {
        return this.gLR;
    }

    public void tz(int i) {
        this.gLR = i;
    }

    public void c(ForumData forumData) {
        this.fsm = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getThreadList() {
        return this.threadList;
    }

    public void ax(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData ug() {
        return this.agm;
    }

    public void c(AntiData antiData) {
        this.agm = antiData;
    }

    public al uv() {
        return this.eHC;
    }

    public void a(al alVar) {
        this.eHC = alVar;
    }

    public j bug() {
        return this.gLn;
    }

    public void a(j jVar) {
        this.gLn = jVar;
    }

    public com.baidu.tbadk.core.data.o buh() {
        return this.gLy;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.gLy = oVar;
    }

    public boolean bui() {
        return this.gLo;
    }

    public void mm(boolean z) {
        this.gLo = z;
    }

    public String buj() {
        return this.gLp;
    }

    public void tD(String str) {
        this.gLp = str;
    }

    public m buk() {
        return this.gLq;
    }

    public void a(m mVar) {
        this.gLq = mVar;
    }

    public UserData getUserData() {
        return this.fst;
    }

    public void e(UserData userData) {
        this.fst = userData;
    }

    public List<Long> bul() {
        return this.gLm;
    }

    /* renamed from: do  reason: not valid java name */
    public void m17do(List<Long> list) {
        this.gLm = list;
    }

    public b bum() {
        return this.gLr;
    }

    public void a(b bVar) {
        this.gLr = bVar;
    }

    public boolean bun() {
        return this.gLs;
    }

    public void mn(boolean z) {
        this.gLs = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> buo() {
        return this.gLt;
    }

    public void dp(List<g> list) {
        this.gLt = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aZv() {
        return this.gLu;
    }

    public void qj(int i) {
        this.gLu = i;
    }

    public String bup() {
        return this.gLw;
    }

    public void tE(String str) {
        this.gLw = str;
    }

    public int buq() {
        return this.gLv;
    }

    public void tA(int i) {
        this.gLv = i;
    }

    public List<FeedForumData> bur() {
        return this.gLB;
    }

    public void dq(List<FeedForumData> list) {
        this.gLB = list;
    }

    public void tF(String str) {
        if (this.gLB != null && str != null) {
            for (FeedForumData feedForumData : this.gLB) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gLB.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bus() {
        return this.gLC;
    }

    public void dr(List<CategoryInfo> list) {
        this.gLC = list;
    }

    public void tG(String str) {
        this.gLD = str;
    }

    public String but() {
        return this.gLD;
    }

    public bb buu() {
        return this.gLL;
    }

    public void as(bb bbVar) {
        this.gLL = bbVar;
    }

    public int buv() {
        return this.gLA;
    }

    public void tB(int i) {
        this.gLA = i;
    }

    public com.baidu.tbadk.core.data.w buw() {
        return this.gLE;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.gLE = wVar;
    }

    public com.baidu.tbadk.core.data.p bux() {
        return this.gLH;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.gLH = pVar;
    }

    public com.baidu.tbadk.core.data.r buy() {
        return this.gLK;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.gLK = rVar;
    }

    public int buz() {
        return this.gLN;
    }

    public void tC(int i) {
        this.gLN = i;
    }

    public at buA() {
        return this.gLM;
    }

    public void a(at atVar) {
        this.gLM = atVar;
    }

    public NavTabInfo buB() {
        return this.gLz;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gLz = navTabInfo;
    }

    public boolean buC() {
        return this.fUP;
    }

    public void mo(boolean z) {
        this.fUP = z;
    }

    public com.baidu.tbadk.core.data.l buD() {
        return this.gLO;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.gLO = lVar;
    }

    public int Vo() {
        return this.mSortType;
    }

    public Integer buE() {
        return this.gLI;
    }

    public void q(Integer num) {
        this.gLI = num;
    }

    public List<Integer> buF() {
        return this.gLS;
    }

    public void ds(List<Integer> list) {
        this.gLS = list;
    }

    public List<com.baidu.adp.widget.ListView.h> buG() {
        return this.gLT;
    }

    public void dt(List<com.baidu.adp.widget.ListView.h> list) {
        this.gLT = list;
    }

    public com.baidu.tieba.h.b buH() {
        return this.gLX;
    }

    public void a(com.baidu.tieba.h.b bVar) {
        this.gLX = bVar;
    }

    public AlaLiveNotify buI() {
        return this.gLZ;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.gLZ = alaLiveNotify;
    }

    public List<FrsTabInfo> buJ() {
        return this.gMa;
    }

    public void du(List<FrsTabInfo> list) {
        this.gMa = list;
    }

    public void tD(int i) {
        this.gMb = i;
    }

    public int buK() {
        return this.gMb;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.gMd = qVar;
    }

    public com.baidu.tieba.frs.q buL() {
        return this.gMd;
    }

    public k buM() {
        return this.gMe;
    }

    public void a(k kVar) {
        this.gMe = kVar;
    }

    public e buN() {
        return this.gLU;
    }

    public void b(e eVar) {
        this.gLU = eVar;
    }

    public f buO() {
        return this.gLV;
    }

    public void b(f fVar) {
        this.gLV = fVar;
    }

    public WorldcupSkin buP() {
        return this.gMj;
    }

    public com.baidu.tieba.tbadkCore.data.m buQ() {
        return this.gMn;
    }

    public void d(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.gMn = mVar;
    }
}
