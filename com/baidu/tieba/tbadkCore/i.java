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
    public ForumArIno drW;
    protected al eHH;
    private UserData fsA;
    protected ForumData fst;
    private List<CategoryInfo> gLA;
    private bb gLJ;
    private at gLK;
    private com.baidu.tbadk.core.data.l gLM;
    private List<Integer> gLQ;
    private List<com.baidu.adp.widget.ListView.h> gLR;
    private e gLS;
    private f gLT;
    public PopInfo gLU;
    private com.baidu.tieba.h.b gLV;
    private AgreeBanner gLW;
    private AlaLiveNotify gLX;
    private List<FrsTabInfo> gLY;
    protected List<Long> gLk;
    private j gLl;
    protected boolean gLm;
    protected String gLn;
    protected m gLo;
    private b gLp;
    private boolean gLq;
    private int gLt;
    private String gLu;
    private NavTabInfo gLx;
    private List<FeedForumData> gLz;
    private ForumHeadIcon gMa;
    private com.baidu.tieba.frs.q gMb;
    private k gMc;
    public FrsTabInfo gMd;
    public StarRank gMe;
    public List<WindowToast> gMf;
    public ActivityConfig gMg;
    private WorldcupSkin gMh;
    public com.baidu.tieba.frs.b gMi;
    public List<OriForumInfo> gMj;
    public List<BottomMenu> gMk;
    private com.baidu.tieba.tbadkCore.data.m gMl;
    public boolean gMm;
    private String gameName;
    public boolean isBrandForum;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.h> threadList;
    private HashMap<String, MetaData> userMap;
    public int gLj = 0;
    private List<g> gLr = new ArrayList();
    private int gLs = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> gLv = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o gLw = null;
    private int gLy = 1;
    private boolean fUU = false;
    private String gLB = null;
    private com.baidu.tbadk.core.data.w gLC = null;
    public x gLD = null;
    public RecomPostTopic gLE = null;
    private com.baidu.tbadk.core.data.p gLF = null;
    private Integer gLG = -1;
    public com.baidu.tbadk.core.data.u gLH = null;
    private com.baidu.tbadk.core.data.r gLI = null;
    private int gLL = -1;
    protected List<com.baidu.adp.widget.ListView.h> gLN = null;
    private int gLO = 0;
    private int gLP = 0;
    private int alaLiveCount = 0;
    private int gLZ = 0;
    public int dsU = 0;
    public int gMn = 1;

    public i() {
        initData();
    }

    private void initData() {
        this.fst = new ForumData();
        this.threadList = new ArrayList<>();
        this.gLN = new ArrayList();
        this.userMap = new HashMap<>();
        this.eHH = new al();
        this.gLl = new j();
        this.fsA = new UserData();
        this.gLo = new m();
        c(new AntiData());
        a(new b());
        this.gLR = new ArrayList();
        this.gLQ = new ArrayList();
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
                                this.gLv.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.forum != null) {
                    this.gLq = dataRes.forum.has_game.intValue() == 1;
                    this.gLu = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                    this.isBrandForum = dataRes.forum.is_brand_forum.intValue() == 1;
                }
                if (this.isBrandForum && dataRes.brand_forum_info != null) {
                    this.gLw = new com.baidu.tbadk.core.data.o();
                    this.gLw.a(dataRes.brand_forum_info.head_imgs);
                    this.gMi = new com.baidu.tieba.frs.b();
                    this.gMi.a(dataRes.brand_forum_info);
                    if (!com.baidu.tbadk.core.util.w.z(dataRes.brand_forum_info.relation_forum)) {
                        this.gMj = new ArrayList();
                        for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                            if (oriForumInfo != null) {
                                this.gMj.add(oriForumInfo);
                            }
                        }
                    }
                } else if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.w.z(dataRes.activityhead.head_imgs)) {
                    this.gLw = new com.baidu.tbadk.core.data.o();
                    this.gLw.a(dataRes.activityhead);
                }
                this.gMk = dataRes.bottom_menu;
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
                this.gLm = dataRes.fortune_bag.intValue() == 1;
                this.gLn = dataRes.fortune_desc;
                List<StarEnter> list2 = dataRes.star_enter;
                this.gLr.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.gLr.add(gVar);
                    }
                }
                this.gLo.a(dataRes.gcon_account);
                this.fst.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.gLk = dataRes.thread_id_list;
                this.agm.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.ueg.c.e(dataRes.anti.block_pop_info);
                }
                this.gLp.a(dataRes.group);
                this.eHH.a(dataRes.page);
                this.gLl.a(dataRes.frs_star);
                this.fsA.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fsA.getIsSelectTail());
                }
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.gLx = builder.build(true);
                } else {
                    this.gLx = dataRes.nav_tab_info;
                }
                if (this.gLx != null && com.baidu.tbadk.core.util.w.d(this.gLx.tab, 0) != null) {
                    this.gMn = ((FrsTabInfo) com.baidu.tbadk.core.util.w.d(this.gLx.tab, 0)).tab_id.intValue();
                }
                if (this.gLx != null && !com.baidu.tbadk.core.util.w.z(this.gLx.head)) {
                    this.gMd = this.gLx.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                tw(dataRes.frs_tab_default.intValue());
                this.gLt = dataRes.twzhibo_pos.intValue();
                this.fUU = dataRes.trends_redpoint.intValue() == 1;
                b(dataRes.thread_list, longValue);
                this.gLA = dataRes.category_list;
                if (!ap.isEmpty(dataRes.bawu_enter_url)) {
                    this.gLB = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.gLC = new com.baidu.tbadk.core.data.w();
                    this.gLC.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.gLD = new x();
                    this.gLD.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.gLF = new com.baidu.tbadk.core.data.p();
                    this.gLF.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.gLH = new com.baidu.tbadk.core.data.u();
                    this.gLH.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.gLI = new com.baidu.tbadk.core.data.r();
                    this.gLI.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.gLJ = new bb();
                    this.gLJ.aq(true);
                    this.gLJ.bZ(this.gLt);
                    this.gLJ.setUserMap(this.userMap);
                    this.gLJ.a(dataRes.card_shipin_info.get(0));
                    this.gLJ.vS();
                    this.gLJ.ajR = this.isBrandForum;
                    if (this.gLJ.getFid() == 0 && longValue != 0) {
                        this.gLJ.setFid(longValue);
                    }
                    this.gLJ.m(this.gLv);
                    this.gLJ.ap(!this.gLJ.uQ());
                    if (this.gLJ.vk() != null && this.gLJ.vk().getPendantData() == null && (metaData = this.userMap.get(this.gLJ.vk().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                        iVar.Z(metaData.getPendantData().GZ());
                        iVar.dj(metaData.getPendantData().tU());
                        this.gLJ.vk().setPendantData(iVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.gLS = new e();
                    this.gLS.gKF = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < dataRes.ala_live_insert.ala_live_list.size(); i3++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i3) != null) {
                            bb bbVar = new bb();
                            bbVar.a(dataRes.ala_live_insert.ala_live_list.get(i3));
                            bbVar.ajR = this.isBrandForum;
                            arrayList.add(bbVar);
                        }
                    }
                    this.gLS.gKE = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.gLT = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_stage_list.size(); i4++) {
                        if (dataRes.ala_stage_list.get(i4) != null) {
                            bb bbVar2 = new bb();
                            bbVar2.a(dataRes.ala_stage_list.get(i4));
                            bbVar2.ajR = this.isBrandForum;
                            arrayList2.add(bbVar2);
                        }
                    }
                    this.gLT.gKH = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.gLL = dataRes.school_recom_pos.intValue();
                    this.gLK = new at();
                    this.gLK.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.gLM = new com.baidu.tbadk.core.data.l();
                    this.gLM.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.gLO = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.gLP = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.gLj = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bod().sS(dataRes.asp_shown_info);
                this.gLQ = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bb bbVar3 = new bb();
                        if (this.gLQ != null && this.gLQ.size() >= dataRes.card_shipin_new.size()) {
                            bbVar3.bZ(this.gLQ.get(i5).intValue());
                        }
                        bbVar3.aq(true);
                        bbVar3.a(dataRes.card_shipin_new.get(i5));
                        bbVar3.ajR = this.isBrandForum;
                        this.gLR.add(bbVar3);
                    }
                }
                this.gLU = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.gLV = new com.baidu.tieba.h.b();
                    this.gLV.a(dataRes.esport);
                }
                this.gLW = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.gMb = new com.baidu.tieba.frs.q();
                    this.gMb.a(dataRes.user_extend);
                }
                this.gLX = dataRes.live_frs_notify;
                this.gLY = dataRes.frs_game_tab_info;
                this.gLZ = dataRes.game_default_tab_id.intValue();
                this.gMa = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.gMc = new k();
                    this.gMc.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.drW = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.gMe = dataRes.star_rank_info;
                }
                if (dataRes.recom_post_topic != null) {
                    this.gLE = dataRes.recom_post_topic;
                }
                this.gMf = dataRes.window_toast;
                this.gMg = dataRes.activity_config;
                this.gMh = dataRes.worldcup_skin;
                this.gMl = new com.baidu.tieba.tbadkCore.data.m();
                this.gMl.a(dataRes.redpacketrain);
                this.gMm = dataRes.video_auto_play.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner btZ() {
        return this.gLW;
    }

    public void a(AgreeBanner agreeBanner) {
        this.gLW = agreeBanner;
    }

    public ForumHeadIcon bua() {
        return this.gMa;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.gMa = forumHeadIcon;
    }

    public List<RecmForumInfo> bub() {
        return this.recm_forum_list;
    }

    private void tw(int i) {
        this.gLy = 1;
        if (this.gLx != null && this.gLx.tab != null && this.gLx.tab.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.gLx.tab) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.gLy = i;
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
                    bbVar.vS();
                    if (bbVar.getFid() == 0 && j != 0) {
                        bbVar.setFid(j);
                    }
                    if (StringUtils.isNull(bbVar.vq())) {
                        bbVar.dm(this.fst.getName());
                    }
                    bbVar.m(this.gLv);
                    bbVar.ajR = this.fst.isBrandForum;
                    if (!TextUtils.isEmpty(bbVar.wc())) {
                        ab abVar = new ab();
                        abVar.dg(bbVar.wc());
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

    public int buc() {
        return this.alaLiveCount;
    }

    public void tx(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Js() {
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

    public ForumData aZl() {
        return this.fst;
    }

    public int bud() {
        return this.gLO;
    }

    public void ty(int i) {
        this.gLO = i;
    }

    public int bue() {
        return this.gLP;
    }

    public void tz(int i) {
        this.gLP = i;
    }

    public void c(ForumData forumData) {
        this.fst = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getThreadList() {
        return this.threadList;
    }

    public void ax(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData uh() {
        return this.agm;
    }

    public void c(AntiData antiData) {
        this.agm = antiData;
    }

    public al uw() {
        return this.eHH;
    }

    public void a(al alVar) {
        this.eHH = alVar;
    }

    public j buf() {
        return this.gLl;
    }

    public void a(j jVar) {
        this.gLl = jVar;
    }

    public com.baidu.tbadk.core.data.o bug() {
        return this.gLw;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.gLw = oVar;
    }

    public boolean buh() {
        return this.gLm;
    }

    public void mm(boolean z) {
        this.gLm = z;
    }

    public String bui() {
        return this.gLn;
    }

    public void tz(String str) {
        this.gLn = str;
    }

    public m buj() {
        return this.gLo;
    }

    public void a(m mVar) {
        this.gLo = mVar;
    }

    public UserData getUserData() {
        return this.fsA;
    }

    public void e(UserData userData) {
        this.fsA = userData;
    }

    public List<Long> buk() {
        return this.gLk;
    }

    /* renamed from: do  reason: not valid java name */
    public void m17do(List<Long> list) {
        this.gLk = list;
    }

    public b bul() {
        return this.gLp;
    }

    public void a(b bVar) {
        this.gLp = bVar;
    }

    public boolean bum() {
        return this.gLq;
    }

    public void mn(boolean z) {
        this.gLq = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bun() {
        return this.gLr;
    }

    public void dp(List<g> list) {
        this.gLr = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int aZA() {
        return this.gLs;
    }

    public void qj(int i) {
        this.gLs = i;
    }

    public String buo() {
        return this.gLu;
    }

    public void tA(String str) {
        this.gLu = str;
    }

    public int bup() {
        return this.gLt;
    }

    public void tA(int i) {
        this.gLt = i;
    }

    public List<FeedForumData> buq() {
        return this.gLz;
    }

    public void dq(List<FeedForumData> list) {
        this.gLz = list;
    }

    public void tB(String str) {
        if (this.gLz != null && str != null) {
            for (FeedForumData feedForumData : this.gLz) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.gLz.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bur() {
        return this.gLA;
    }

    public void dr(List<CategoryInfo> list) {
        this.gLA = list;
    }

    public void tC(String str) {
        this.gLB = str;
    }

    public String bus() {
        return this.gLB;
    }

    public bb but() {
        return this.gLJ;
    }

    public void as(bb bbVar) {
        this.gLJ = bbVar;
    }

    public int buu() {
        return this.gLy;
    }

    public void tB(int i) {
        this.gLy = i;
    }

    public com.baidu.tbadk.core.data.w buv() {
        return this.gLC;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.gLC = wVar;
    }

    public com.baidu.tbadk.core.data.p buw() {
        return this.gLF;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.gLF = pVar;
    }

    public com.baidu.tbadk.core.data.r bux() {
        return this.gLI;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.gLI = rVar;
    }

    public int buy() {
        return this.gLL;
    }

    public void tC(int i) {
        this.gLL = i;
    }

    public at buz() {
        return this.gLK;
    }

    public void a(at atVar) {
        this.gLK = atVar;
    }

    public NavTabInfo buA() {
        return this.gLx;
    }

    public void a(NavTabInfo navTabInfo) {
        this.gLx = navTabInfo;
    }

    public boolean buB() {
        return this.fUU;
    }

    public void mo(boolean z) {
        this.fUU = z;
    }

    public com.baidu.tbadk.core.data.l buC() {
        return this.gLM;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.gLM = lVar;
    }

    public int Vk() {
        return this.mSortType;
    }

    public Integer buD() {
        return this.gLG;
    }

    public void q(Integer num) {
        this.gLG = num;
    }

    public List<Integer> buE() {
        return this.gLQ;
    }

    public void ds(List<Integer> list) {
        this.gLQ = list;
    }

    public List<com.baidu.adp.widget.ListView.h> buF() {
        return this.gLR;
    }

    public void dt(List<com.baidu.adp.widget.ListView.h> list) {
        this.gLR = list;
    }

    public com.baidu.tieba.h.b buG() {
        return this.gLV;
    }

    public void a(com.baidu.tieba.h.b bVar) {
        this.gLV = bVar;
    }

    public AlaLiveNotify buH() {
        return this.gLX;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.gLX = alaLiveNotify;
    }

    public List<FrsTabInfo> buI() {
        return this.gLY;
    }

    public void du(List<FrsTabInfo> list) {
        this.gLY = list;
    }

    public void tD(int i) {
        this.gLZ = i;
    }

    public int buJ() {
        return this.gLZ;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.gMb = qVar;
    }

    public com.baidu.tieba.frs.q buK() {
        return this.gMb;
    }

    public k buL() {
        return this.gMc;
    }

    public void a(k kVar) {
        this.gMc = kVar;
    }

    public e buM() {
        return this.gLS;
    }

    public void b(e eVar) {
        this.gLS = eVar;
    }

    public f buN() {
        return this.gLT;
    }

    public void b(f fVar) {
        this.gLT = fVar;
    }

    public WorldcupSkin buO() {
        return this.gMh;
    }

    public com.baidu.tieba.tbadkCore.data.m buP() {
        return this.gMl;
    }

    public void d(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.gMl = mVar;
    }
}
