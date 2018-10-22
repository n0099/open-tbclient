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
    private AntiData anH;
    public ForumArIno dGk;
    protected al eWB;
    private UserData fHG;
    protected ForumData fHz;
    private String gameName;
    private List<CategoryInfo> haA;
    private bb haJ;
    private at haK;
    private com.baidu.tbadk.core.data.l haM;
    private List<Integer> haQ;
    private List<com.baidu.adp.widget.ListView.h> haR;
    private e haS;
    private f haT;
    public PopInfo haU;
    private com.baidu.tieba.h.b haV;
    private AgreeBanner haW;
    private AlaLiveNotify haX;
    private List<FrsTabInfo> haY;
    protected List<Long> hak;
    private j hal;
    protected boolean ham;
    protected String han;
    protected m hao;
    private b hap;
    private boolean haq;
    private int hat;
    private String hau;
    private NavTabInfo hax;
    private List<FeedForumData> haz;
    private ForumHeadIcon hba;
    private com.baidu.tieba.frs.q hbb;
    private k hbc;
    public FrsTabInfo hbd;
    public StarRank hbe;
    public List<WindowToast> hbf;
    public ActivityConfig hbg;
    private WorldcupSkin hbh;
    public com.baidu.tieba.frs.b hbi;
    public List<OriForumInfo> hbj;
    public List<BottomMenu> hbk;
    private com.baidu.tieba.tbadkCore.data.m hbl;
    public boolean hbm;
    public List<String> hbo;
    public SmartApp hbp;
    public boolean isBrandForum;
    private int mSortType;
    public List<RecmForumInfo> recm_forum_list;
    protected ArrayList<com.baidu.adp.widget.ListView.h> threadList;
    private HashMap<String, MetaData> userMap;
    public int haj = 0;
    private List<g> har = new ArrayList();
    private int has = 0;
    private ArrayList<com.baidu.tbadk.core.data.n> hav = new ArrayList<>();
    protected com.baidu.tbadk.core.data.o haw = null;
    private int hay = 1;
    private boolean gjH = false;
    private String haB = null;
    private com.baidu.tbadk.core.data.w haC = null;
    public x haD = null;
    public RecomPostTopic haE = null;
    private com.baidu.tbadk.core.data.p haF = null;
    private Integer haG = -1;
    public com.baidu.tbadk.core.data.u haH = null;
    private com.baidu.tbadk.core.data.r haI = null;
    private int haL = -1;
    protected List<com.baidu.adp.widget.ListView.h> haN = null;
    private int haO = 0;
    private int haP = 0;
    private int alaLiveCount = 0;
    private int haZ = 0;
    public int dHx = 0;
    public int hbn = 1;

    public i() {
        initData();
    }

    private void initData() {
        this.fHz = new ForumData();
        this.threadList = new ArrayList<>();
        this.haN = new ArrayList();
        this.userMap = new HashMap<>();
        this.eWB = new al();
        this.hal = new j();
        this.fHG = new UserData();
        this.hao = new m();
        c(new AntiData());
        a(new b());
        this.haR = new ArrayList();
        this.haQ = new ArrayList();
    }

    public FrsPageResIdl N(byte[] bArr) {
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
                if (!com.baidu.tbadk.core.util.v.J(dataRes.color_egg)) {
                    for (ColorEgg colorEgg : dataRes.color_egg) {
                        if (colorEgg != null && !com.baidu.tbadk.core.util.v.J(colorEgg.holiday_words)) {
                            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                            if (nVar.a(colorEgg)) {
                                this.hav.add(nVar);
                            }
                        }
                    }
                }
                if (dataRes.forum != null) {
                    this.haq = dataRes.forum.has_game.intValue() == 1;
                    this.hau = dataRes.forum.game_url;
                    this.gameName = dataRes.forum.game_name;
                    this.isBrandForum = dataRes.forum.is_brand_forum.intValue() == 1;
                }
                if (this.isBrandForum && dataRes.brand_forum_info != null) {
                    this.haw = new com.baidu.tbadk.core.data.o();
                    this.haw.a(dataRes.brand_forum_info.head_imgs);
                    this.hbi = new com.baidu.tieba.frs.b();
                    this.hbi.a(dataRes.brand_forum_info);
                    if (!com.baidu.tbadk.core.util.v.J(dataRes.brand_forum_info.relation_forum)) {
                        this.hbj = new ArrayList();
                        for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                            if (oriForumInfo != null) {
                                this.hbj.add(oriForumInfo);
                            }
                        }
                    }
                } else if (dataRes.activityhead != null && !com.baidu.tbadk.core.util.v.J(dataRes.activityhead.head_imgs)) {
                    this.haw = new com.baidu.tbadk.core.data.o();
                    this.haw.a(dataRes.activityhead);
                }
                this.hbk = dataRes.bottom_menu;
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
                rl(dataRes.is_new_url.intValue());
                this.ham = dataRes.fortune_bag.intValue() == 1;
                this.han = dataRes.fortune_desc;
                List<StarEnter> list2 = dataRes.star_enter;
                this.har.clear();
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        g gVar = new g();
                        gVar.a(list2.get(i2));
                        this.har.add(gVar);
                    }
                }
                this.hao.a(dataRes.gcon_account);
                this.fHz.parserProtobuf(dataRes.forum);
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                this.hak = dataRes.thread_id_list;
                this.anH.parserProtobuf(dataRes.anti);
                if (dataRes.anti != null) {
                    com.baidu.tieba.ueg.c.e(dataRes.anti.block_pop_info);
                }
                this.hap.a(dataRes.group);
                this.eWB.a(dataRes.page);
                this.hal.a(dataRes.frs_star);
                this.fHG.parserProtobuf(dataRes.user);
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    currentAccountObj.setIsSelectTail(this.fHG.getIsSelectTail());
                }
                if (dataRes.nav_tab_info == null) {
                    NavTabInfo.Builder builder = new NavTabInfo.Builder();
                    builder.tab = dataRes.frs_tab_info;
                    this.hax = builder.build(true);
                } else {
                    this.hax = dataRes.nav_tab_info;
                }
                if (this.hax != null && com.baidu.tbadk.core.util.v.d(this.hax.tab, 0) != null) {
                    this.hbn = ((FrsTabInfo) com.baidu.tbadk.core.util.v.d(this.hax.tab, 0)).tab_id.intValue();
                }
                if (this.hax != null && !com.baidu.tbadk.core.util.v.J(this.hax.head)) {
                    this.hbd = this.hax.head.get(0);
                }
                this.alaLiveCount = dataRes.ala_live_count.intValue();
                ut(dataRes.frs_tab_default.intValue());
                this.hat = dataRes.twzhibo_pos.intValue();
                this.gjH = dataRes.trends_redpoint.intValue() == 1;
                c(dataRes.thread_list, longValue);
                this.haA = dataRes.category_list;
                if (!ao.isEmpty(dataRes.bawu_enter_url)) {
                    this.haB = dataRes.bawu_enter_url;
                }
                if (dataRes.head_sdk != null) {
                    this.haC = new com.baidu.tbadk.core.data.w();
                    this.haC.a(dataRes.head_sdk);
                }
                if (dataRes.recommend_book != null) {
                    this.haD = new x();
                    this.haD.a(dataRes.recommend_book);
                }
                if (dataRes.book_info != null) {
                    this.haF = new com.baidu.tbadk.core.data.p();
                    this.haF.a(dataRes.book_info);
                }
                if (dataRes.forum_present_info != null) {
                    this.haH = new com.baidu.tbadk.core.data.u();
                    this.haH.a(dataRes.forum_present_info);
                }
                if (dataRes.forum_headline_img_info != null) {
                    this.haI = new com.baidu.tbadk.core.data.r();
                    this.haI.a(dataRes.forum_headline_img_info);
                }
                if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                    this.haJ = new bb();
                    this.haJ.aK(true);
                    this.haJ.ct(this.hat);
                    this.haJ.setUserMap(this.userMap);
                    this.haJ.a(dataRes.card_shipin_info.get(0));
                    this.haJ.zf();
                    this.haJ.arq = this.isBrandForum;
                    if (this.haJ.getFid() == 0 && longValue != 0) {
                        this.haJ.setFid(longValue);
                    }
                    this.haJ.m(this.hav);
                    this.haJ.aJ(!this.haJ.yb());
                    if (this.haJ.yv() != null && this.haJ.yv().getPendantData() == null && (metaData = this.userMap.get(this.haJ.yv().getUserId())) != null && metaData.getPendantData() != null) {
                        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                        jVar.af(metaData.getPendantData().Ko());
                        jVar.dR(metaData.getPendantData().xf());
                        this.haJ.yv().setPendantData(jVar);
                    }
                }
                if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                    this.haS = new e();
                    this.haS.gZE = dataRes.ala_insert_floor.intValue();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < dataRes.ala_live_insert.ala_live_list.size(); i3++) {
                        if (dataRes.ala_live_insert.ala_live_list.get(i3) != null) {
                            bb bbVar = new bb();
                            bbVar.a(dataRes.ala_live_insert.ala_live_list.get(i3));
                            bbVar.arq = this.isBrandForum;
                            arrayList.add(bbVar);
                        }
                    }
                    this.haS.gZD = arrayList;
                }
                if (dataRes.ala_stage_list != null) {
                    this.haT = new f();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < dataRes.ala_stage_list.size(); i4++) {
                        if (dataRes.ala_stage_list.get(i4) != null) {
                            bb bbVar2 = new bb();
                            bbVar2.a(dataRes.ala_stage_list.get(i4));
                            bbVar2.arq = this.isBrandForum;
                            arrayList2.add(bbVar2);
                        }
                    }
                    this.haT.gZG = arrayList2;
                }
                if (dataRes.school_recom_info != null) {
                    this.haL = dataRes.school_recom_pos.intValue();
                    this.haK = new at();
                    this.haK.a(dataRes.school_recom_info);
                }
                if (dataRes.carrier_enter != null) {
                    this.haM = new com.baidu.tbadk.core.data.l();
                    this.haM.a(dataRes.carrier_enter);
                }
                if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                    this.haO = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                    this.haP = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
                }
                this.mSortType = dataRes.sort_type.intValue();
                this.haj = dataRes.need_log.intValue();
                com.baidu.tieba.recapp.d.a.bua().uf(dataRes.asp_shown_info);
                this.haQ = dataRes.card_shipin_pos;
                if (dataRes.card_shipin_new != null) {
                    for (int i5 = 0; i5 < dataRes.card_shipin_new.size(); i5++) {
                        bb bbVar3 = new bb();
                        if (this.haQ != null && this.haQ.size() >= dataRes.card_shipin_new.size()) {
                            bbVar3.ct(this.haQ.get(i5).intValue());
                        }
                        bbVar3.aK(true);
                        bbVar3.a(dataRes.card_shipin_new.get(i5));
                        bbVar3.arq = this.isBrandForum;
                        this.haR.add(bbVar3);
                    }
                }
                this.haU = dataRes.enter_pop_info;
                if (dataRes.esport != null) {
                    this.haV = new com.baidu.tieba.h.b();
                    this.haV.a(dataRes.esport);
                }
                this.haW = dataRes.agree_banner;
                if (dataRes.user_extend != null) {
                    this.hbb = new com.baidu.tieba.frs.q();
                    this.hbb.a(dataRes.user_extend);
                }
                this.haX = dataRes.live_frs_notify;
                this.haY = dataRes.frs_game_tab_info;
                this.haZ = dataRes.game_default_tab_id.intValue();
                this.hba = dataRes.forum_head_icon;
                if (dataRes.video != null && dataRes.video.video_act != null) {
                    this.hbc = new k();
                    this.hbc.a(dataRes.video.video_act);
                }
                if (dataRes.info != null) {
                    this.recm_forum_list = dataRes.info.recm_forum_list;
                }
                this.dGk = dataRes.forum_ar_info;
                if (dataRes.star_rank_info != null) {
                    this.hbe = dataRes.star_rank_info;
                }
                if (dataRes.recom_post_topic != null) {
                    this.haE = dataRes.recom_post_topic;
                }
                this.hbf = dataRes.window_toast;
                this.hbg = dataRes.activity_config;
                this.hbh = dataRes.worldcup_skin;
                this.hbl = new com.baidu.tieba.tbadkCore.data.m();
                this.hbl.a(dataRes.redpacketrain);
                this.hbm = dataRes.video_auto_play.intValue() == 1;
                this.hbo = dataRes.smart_app_avatar;
                this.hbp = dataRes.smart_app;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public AgreeBanner bzV() {
        return this.haW;
    }

    public void a(AgreeBanner agreeBanner) {
        this.haW = agreeBanner;
    }

    public ForumHeadIcon bzW() {
        return this.hba;
    }

    public void a(ForumHeadIcon forumHeadIcon) {
        this.hba = forumHeadIcon;
    }

    public List<RecmForumInfo> bzX() {
        return this.recm_forum_list;
    }

    private void ut(int i) {
        this.hay = 1;
        if (this.hax != null && this.hax.tab != null && this.hax.tab.size() > 0) {
            for (FrsTabInfo frsTabInfo : this.hax.tab) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.hay = i;
                    return;
                }
            }
        }
    }

    public void c(List<ThreadInfo> list, long j) {
        if (!com.baidu.tbadk.core.util.v.J(list)) {
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    bb bbVar = new bb();
                    bbVar.setUserMap(this.userMap);
                    bbVar.a(threadInfo);
                    bbVar.setCurrentPage(3);
                    bbVar.zf();
                    if (bbVar.getFid() == 0 && j != 0) {
                        bbVar.setFid(j);
                    }
                    if (StringUtils.isNull(bbVar.yB())) {
                        bbVar.dU(this.fHz.getName());
                    }
                    bbVar.m(this.hav);
                    bbVar.arq = this.fHz.isBrandForum;
                    if (!TextUtils.isEmpty(bbVar.zp())) {
                        ab abVar = new ab();
                        abVar.dP(bbVar.zp());
                        this.threadList.add(abVar);
                    } else {
                        this.threadList.add(bbVar);
                    }
                }
            }
        }
    }

    public int bzY() {
        return this.alaLiveCount;
    }

    public void uu(int i) {
        this.alaLiveCount = i;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] MK() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean G(byte[] bArr) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void H(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public ForumData beT() {
        return this.fHz;
    }

    public int bzZ() {
        return this.haO;
    }

    public void uv(int i) {
        this.haO = i;
    }

    public int bAa() {
        return this.haP;
    }

    public void uw(int i) {
        this.haP = i;
    }

    public void c(ForumData forumData) {
        this.fHz = forumData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getThreadList() {
        return this.threadList;
    }

    public void ay(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        this.threadList = arrayList;
    }

    public AntiData xs() {
        return this.anH;
    }

    public void c(AntiData antiData) {
        this.anH = antiData;
    }

    public al xH() {
        return this.eWB;
    }

    public void a(al alVar) {
        this.eWB = alVar;
    }

    public j bAb() {
        return this.hal;
    }

    public void a(j jVar) {
        this.hal = jVar;
    }

    public com.baidu.tbadk.core.data.o bAc() {
        return this.haw;
    }

    public void a(com.baidu.tbadk.core.data.o oVar) {
        this.haw = oVar;
    }

    public boolean bAd() {
        return this.ham;
    }

    public void na(boolean z) {
        this.ham = z;
    }

    public String bAe() {
        return this.han;
    }

    public void uM(String str) {
        this.han = str;
    }

    public m bAf() {
        return this.hao;
    }

    public void a(m mVar) {
        this.hao = mVar;
    }

    public UserData getUserData() {
        return this.fHG;
    }

    public void e(UserData userData) {
        this.fHG = userData;
    }

    public List<Long> bAg() {
        return this.hak;
    }

    public void dD(List<Long> list) {
        this.hak = list;
    }

    public b bAh() {
        return this.hap;
    }

    public void a(b bVar) {
        this.hap = bVar;
    }

    public boolean bAi() {
        return this.haq;
    }

    public void nb(boolean z) {
        this.haq = z;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public List<g> bAj() {
        return this.har;
    }

    public void dE(List<g> list) {
        this.har = list;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public int bfi() {
        return this.has;
    }

    public void rl(int i) {
        this.has = i;
    }

    public String bAk() {
        return this.hau;
    }

    public void uN(String str) {
        this.hau = str;
    }

    public int bAl() {
        return this.hat;
    }

    public void ux(int i) {
        this.hat = i;
    }

    public List<FeedForumData> bAm() {
        return this.haz;
    }

    public void dF(List<FeedForumData> list) {
        this.haz = list;
    }

    public void uO(String str) {
        if (this.haz != null && str != null) {
            for (FeedForumData feedForumData : this.haz) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.haz.remove(feedForumData);
                    return;
                }
            }
        }
    }

    public List<CategoryInfo> bAn() {
        return this.haA;
    }

    public void dG(List<CategoryInfo> list) {
        this.haA = list;
    }

    public void uP(String str) {
        this.haB = str;
    }

    public String bAo() {
        return this.haB;
    }

    public bb bAp() {
        return this.haJ;
    }

    public void at(bb bbVar) {
        this.haJ = bbVar;
    }

    public int bAq() {
        return this.hay;
    }

    public void uy(int i) {
        this.hay = i;
    }

    public com.baidu.tbadk.core.data.w bAr() {
        return this.haC;
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        this.haC = wVar;
    }

    public com.baidu.tbadk.core.data.p bAs() {
        return this.haF;
    }

    public void a(com.baidu.tbadk.core.data.p pVar) {
        this.haF = pVar;
    }

    public com.baidu.tbadk.core.data.r bAt() {
        return this.haI;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.haI = rVar;
    }

    public int bAu() {
        return this.haL;
    }

    public void uz(int i) {
        this.haL = i;
    }

    public at bAv() {
        return this.haK;
    }

    public void a(at atVar) {
        this.haK = atVar;
    }

    public NavTabInfo bAw() {
        return this.hax;
    }

    public void a(NavTabInfo navTabInfo) {
        this.hax = navTabInfo;
    }

    public boolean bAx() {
        return this.gjH;
    }

    public void nc(boolean z) {
        this.gjH = z;
    }

    public com.baidu.tbadk.core.data.l bAy() {
        return this.haM;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.haM = lVar;
    }

    public int aaJ() {
        return this.mSortType;
    }

    public Integer bAz() {
        return this.haG;
    }

    public void q(Integer num) {
        this.haG = num;
    }

    public List<Integer> bAA() {
        return this.haQ;
    }

    public void dH(List<Integer> list) {
        this.haQ = list;
    }

    public List<com.baidu.adp.widget.ListView.h> bAB() {
        return this.haR;
    }

    public void dI(List<com.baidu.adp.widget.ListView.h> list) {
        this.haR = list;
    }

    public com.baidu.tieba.h.b bAC() {
        return this.haV;
    }

    public void a(com.baidu.tieba.h.b bVar) {
        this.haV = bVar;
    }

    public AlaLiveNotify bAD() {
        return this.haX;
    }

    public void a(AlaLiveNotify alaLiveNotify) {
        this.haX = alaLiveNotify;
    }

    public List<FrsTabInfo> bAE() {
        return this.haY;
    }

    public void dJ(List<FrsTabInfo> list) {
        this.haY = list;
    }

    public void uA(int i) {
        this.haZ = i;
    }

    public int bAF() {
        return this.haZ;
    }

    public void a(com.baidu.tieba.frs.q qVar) {
        this.hbb = qVar;
    }

    public com.baidu.tieba.frs.q bAG() {
        return this.hbb;
    }

    public k bAH() {
        return this.hbc;
    }

    public void a(k kVar) {
        this.hbc = kVar;
    }

    public e bAI() {
        return this.haS;
    }

    public void b(e eVar) {
        this.haS = eVar;
    }

    public f bAJ() {
        return this.haT;
    }

    public void b(f fVar) {
        this.haT = fVar;
    }

    public WorldcupSkin bAK() {
        return this.hbh;
    }

    public com.baidu.tieba.tbadkCore.data.m bAL() {
        return this.hbl;
    }

    public void d(com.baidu.tieba.tbadkCore.data.m mVar) {
        this.hbl = mVar;
    }
}
